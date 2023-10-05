package com.example.order.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String date_of_birth;
}
