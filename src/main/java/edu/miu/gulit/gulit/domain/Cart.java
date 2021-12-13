package edu.miu.gulit.gulit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<CartItem> items;

    @OneToOne
    private User user;

    public Cart(List<CartItem> items, User user) {
        this.items = items;
        this.user = user;
    }
}
