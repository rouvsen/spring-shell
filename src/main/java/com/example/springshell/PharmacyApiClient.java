package com.example.springshell;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
//        configuration = FeignClientConfig.class,
        url = "https://jsonplaceholder.typicode.com/todos",
        name = "pharmacy"
)
public interface PharmacyApiClient {
    @GetMapping
    ResponseEntity<PharmacyItem[]> getPharmacies(
//            @RequestParam("il") String city,
//            @RequestParam("ilce") String district,
//            @PathVariable("id") int id
    );
}
