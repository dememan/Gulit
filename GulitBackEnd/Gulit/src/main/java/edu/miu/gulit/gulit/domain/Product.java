package edu.miu.gulit.gulit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Size(min = 3)
    @NotEmpty
    private String name;

    @Size(min = 5)
    @NotEmpty
    private String description;

    private Boolean isActive;

    @Min(1)
    @NotEmpty
    private long quantity;

    @OneToMany(mappedBy = "product")
    List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;

}
