package Tendry.e_upgrade.models;

import lombok.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String description;
    private int categories_id;
    private Double price;
    private int stock_quantity;
}