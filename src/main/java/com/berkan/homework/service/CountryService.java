package com.berkan.homework.service;

import com.berkan.homework.dto.request.CountryCreateRequest;
import com.berkan.homework.dto.request.CountryPresidentUpdateRequest;
import com.berkan.homework.dto.response.CountryCreateResponse;
import com.berkan.homework.dto.response.CountryFindResponse;
import com.berkan.homework.dto.response.CountryPresidentUpdateResponse;
import com.berkan.homework.entity.Country;
import com.berkan.homework.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryCreateResponse createCountry(CountryCreateRequest request) {
        var country = Country.builder()
                .name(request.getName())
                .president(request.getPresident())
                .build();
        countryRepository.save(country);
        return CountryCreateResponse.builder()
                .name(country.getName())
                .president(country.getPresident())
                .build();
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public CountryPresidentUpdateResponse updateCountryPresident(long id, CountryPresidentUpdateRequest request) {
        var country = countryRepository.findById(id)
                .orElseThrow();
        country.setPresident(request.getPresident());
        countryRepository.save(country);
        return CountryPresidentUpdateResponse.builder()
                .name(country.getName())
                .president(country.getPresident())
                .build();
    }

    public CountryFindResponse getCountryById(@PathVariable long id) {
        var country = countryRepository.findById(id)
                .orElseThrow();
        return CountryFindResponse.builder()
                .id(country.getId())
                .name(country.getName())
                .president(country.getPresident())
                .build();
    }
}
