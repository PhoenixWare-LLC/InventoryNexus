package com.phoenixware.inventorynexus.orders.dto.minimalproduct;

import com.phoenixware.inventorynexus.shared.dto.baseproduct.BaseProductDetailedDTO;
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
public class MinimalProductDetailedDTO extends BaseProductDetailedDTO {
    private Boolean taxable;
}
