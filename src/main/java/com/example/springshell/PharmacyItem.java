package com.example.springshell;

public record PharmacyItem(
        int userId,
        int id,
        String title,
        boolean completed
){}