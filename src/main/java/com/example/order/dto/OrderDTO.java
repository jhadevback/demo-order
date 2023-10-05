package com.example.order.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String codOrder;
    private String state;
    private Long customerId;
}
