package com.berkan.homework.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryCreateResponse {

    private String name;
    private String president;
}
