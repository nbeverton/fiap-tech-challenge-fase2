package br.com.fiap.techchallenge.core.domain.valueobjects;

import br.com.fiap.techchallenge.core.domain.exception.menu.InvalidMenuException;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.UUID;

public class Menu {

    @Schema(example = "1a2b3c4d-5e6f-7g8h-9i0j-k1l2m3n4o5p6")
    private String id;
    @Schema(example = "Prato do dia - Segunda feira")
    private String name;
    @Schema(example = "Arroz, feijão, bife e salada")
    private String description;
    @Schema(example = "39.9")
    private BigDecimal price;
    @Schema(example = "true")
    private boolean dineInAvailable;
    @Schema(example = "https://example.com/pf.jpg")
    private String imageUrl;

    private Menu(String id,
            String name,
            String description,
            BigDecimal price,
            boolean dineInAvailable,
            String imageUrl) {

        this.id = id;
        this.name = requireNonBlank(name, "name");
        this.description = description;
        this.price = requireNonNegative(price, "price");
        this.dineInAvailable = dineInAvailable;
        this.imageUrl = imageUrl;
    }

    public static Menu create(String name,
            String description,
            BigDecimal price,
            boolean dineInAvailable,
            String imageUrl) {
        return new Menu(UUID.randomUUID().toString(), name, description, price, dineInAvailable, imageUrl);
    }

    public static Menu restore(String id,
            String name,
            String description,
            BigDecimal price,
            boolean dineInAvailable,
            String imageUrl) {
        return new Menu(id, name, description, price, dineInAvailable, imageUrl);
    }

    private String requireNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidMenuException(fieldName + " must not be null or blank");
        }
        return value;
    }

    private BigDecimal requireNonNegative(BigDecimal value, String fieldName) {
        if (value == null) {
            throw new InvalidMenuException(fieldName + " must not be null");
        }
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidMenuException(fieldName + " must not be negative");
        }
        return value;
    }

    // ✅ GETTERS NECESSÁRIOS
    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isDineInAvailable() {
        return dineInAvailable;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
