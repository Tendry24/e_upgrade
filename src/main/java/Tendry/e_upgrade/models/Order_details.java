package Tendry.e_upgrade.models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order_details {
    private int id;
    private int order_id;
    private int product_id;
    private int quantity;
    private double unit_price;
}
