package shop.mecoding.loginapp.shop;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "shop_tb")
@Entity
public class Shop{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String price;
    private String qty;

    @Builder
    public Shop(Integer id, String name, String price, String qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}