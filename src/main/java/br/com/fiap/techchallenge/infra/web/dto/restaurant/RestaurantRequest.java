package br.com.fiap.techchallenge.infra.web.dto.restaurant;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

public record RestaurantRequest(
        @Schema(example = "Restaurante FIAP")
        String name,
        @Schema(example = "696bd833fd776b70fe1a4f88")
        String addressId,
        @Schema(example = "BRAZILIAN")
        String cuisineType,

        OpeningHoursRequest openingHours,
        @Schema(example = "696bd833fd776b70fe1a4f88")
        String userId,
        @Schema(example = "[]")
        List<MenuRequest> menu
) {

    public record OpeningHoursRequest(
            @Schema(example = "08:00")
            String opens,
            @Schema(example = "22:00")
            String closes
    ) {}

    public record MenuRequest(
            @Schema(example = "Prato do dia - Segunda feira")
            String name,
            @Schema(example = "Arroz, feijão, bife e salada")
            String description,
            @Schema(example = "39.9")
            BigDecimal price,
            @Schema(example = "true")
            boolean dineInAvailable,
            @Schema(example = "https://example.com/pf.jpg")
            String imageUrl
    ) {}
}
/*
{
  "name": "Restaurante FIAP",
  "addressId": "{{addressId}}",
  "cuisineType": "BRAZILIAN",
  "openingHours": {
    "opens": "08:00",
    "closes": "22:00"
  },
  "userId": "{{userId}}",
  "menu": []
}

 */