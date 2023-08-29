package Tendry.e_upgrade.models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CategoriesToProduct {
    private Categories categories;
    private Product products;
}