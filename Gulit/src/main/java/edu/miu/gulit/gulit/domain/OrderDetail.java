package edu.miu.gulit.gulit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDetail {
    //@Min(0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Size(min = 3)
    //@NotEmpty
    private String name;

    //@Size(min = 5)
    //@NotEmpty
    private String description;
    private Boolean isActive;
    //@Min(1)
    private long quantity;
    //@Min(0)
    private double price;

    @OneToMany
    List<OrderItem> orderItems;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Category category;

    @OneToOne
    @JoinColumn
    private Brand brand;

    @OneToMany
    private List<ProductPhoto> images;
}
