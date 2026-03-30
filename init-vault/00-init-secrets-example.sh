#!/bin/sh
set -e

echo "=== Waiting for Vault to be ready ==="

# Better waiting logic that works in dev mode
until vault status -address=http://vault:8200 > /dev/null 2>&1 || [ $? -eq 2 ]; do
  echo "Waiting for Vault..."
  sleep 2
done

echo "=== Vault is ready. Initializing secrets... ==="

export VAULT_ADDR=http://vault:8200
export VAULT_TOKEN="${DEV_TOKEN}"

# Enable KV v2 (ignore if already enabled)
vault secrets enable -path=secret kv-v2 2>/dev/null || true

# Store secrets
vault kv put secret/inventory-nexus/db \
  username="${DB_USER}" \
  password="${DB_PASSWORD}" \
  url="${DATABASE_URL}"

vault kv put secret/inventory-nexus/keycloak \
  introspectionUri="${INTROSPECT_URI}" \
  clientId="${INTROSPECT_ID}" \
  clientSecret="${INTROSPECT_SECRET}"

echo "=== Vault secrets initialized successfully! ==="