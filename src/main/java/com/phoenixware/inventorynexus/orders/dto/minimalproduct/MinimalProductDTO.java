package com.phoenixware.inventorynexus.orders.dto.minimalproduct;

import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:      Collin Short
 * Copyright:   Phoenixware LLC 2026
 * Created:     1/19/2026
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MinimalProductDTO extends BaseProductDTO {
    private boolean taxable;
}
