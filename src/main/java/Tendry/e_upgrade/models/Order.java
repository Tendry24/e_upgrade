package Tendry.e_upgrade.models;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order {
    private int id;
    private int user_id;
    private Timestamp order_date;
    private double total_bills;
}
