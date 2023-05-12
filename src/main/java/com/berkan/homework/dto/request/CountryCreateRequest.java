package com.berkan.homework.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryCreateRequest {

    private String name;
    private String president;
}
