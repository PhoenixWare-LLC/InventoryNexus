package com.phoenixware.inventorynexus.shared.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     3/20/2026
 */
@Service
@RequiredArgsConstructor
public class LoginAttemptService {
    private final ConcurrentHashMap<String, Attempt> ipMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Attempt> usernameMap = new ConcurrentHashMap<>();

    private record Attempt(
            int attemptCount,
            Instant lastAttempt,
            Instant lockedUntil
    ) {
        public Attempt incremented (boolean shouldLock) {
            int newCount = this.attemptCount+1;
            Instant newLock = (newCount >= 5 && shouldLock)
                    ? Instant.now().plus(Duration.ofMinutes(15))
                    : this.lockedUntil;

            return new Attempt(newCount, Instant.now(), newLock);
        }
    }

    public boolean isIpBlocked(String ip) {
        Attempt attempt = ipMap.get(ip);
        if (attempt != null && attempt.lockedUntil != null && Instant.now().isBefore(attempt.lockedUntil)) {
            return true;
        }
        return false;
    }

    public boolean isUsernameBlocked(String username) {
        Attempt attempt = usernameMap.get(username);
        if (attempt != null && attempt.lockedUntil != null && Instant.now().isBefore(attempt.lockedUntil)) {
            return true;
        }
        return false;
    }

    public void recordFailedAttempt(String ip, String username) {
        updateMap(ipMap, ip);
        updateMap(usernameMap, username);
    }

    public void reset(String ip, String username) {
        ipMap.remove(ip);
        usernameMap.remove(username);
    }

    private void updateMap(ConcurrentHashMap<String, Attempt> attemptMap, String key) {
        attemptMap.compute(key, (theKey, oldAttempt) -> {
            Instant now = Instant.now();

            if (oldAttempt == null || isLockExpired(oldAttempt, now)) {
                return new Attempt(1, now, null);
            }

            Attempt updated = oldAttempt.incremented(oldAttempt.attemptCount > 5);
            return updated;
        });
    }

    private boolean isLockExpired(Attempt attempt, Instant instant) {
        return attempt.lastAttempt.isBefore(instant);
    }

    @Scheduled(fixedRate = 60_000)
    public void cleanupExpired() {
        Instant now = Instant.now();
        ipMap.entrySet().removeIf(entry -> isLockExpired(entry.getValue(), now));
        usernameMap.entrySet().removeIf(entry -> isLockExpired(entry.getValue(), now));
    }
}
