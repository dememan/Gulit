package edu.miu.gulit.gulit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Size(min = 3)
    //@NotEmpty
    private String name;

    //@Size(min = 5)
    //@NotEmpty
    private String description;

    private Boolean isActive;

    //@Min(1)
    private int quantity;
    //@Min(0)
    private  double price;

    @OneToMany(mappedBy = "product")
    List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_ID")
    private  Brand brand;

    @OneToMany(mappedBy = "product")
    private List<ProductPhoto> images;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;
}
