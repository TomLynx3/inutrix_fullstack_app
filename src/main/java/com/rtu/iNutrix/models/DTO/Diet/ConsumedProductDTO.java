package com.rtu.iNutrix.models.DTO.Diet;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ConsumedProductDTO {

    private UUID productId;
    private boolean consumed;
}
