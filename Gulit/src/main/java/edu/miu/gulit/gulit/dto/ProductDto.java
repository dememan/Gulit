package edu.miu.gulit.gulit.dto;

import edu.miu.gulit.gulit.domain.Brand;
import edu.miu.gulit.gulit.domain.Category;
import edu.miu.gulit.gulit.domain.OrderItem;
import edu.miu.gulit.gulit.domain.ProductPhoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends RepresentationModel<ProductDto> implements Serializable {

    //@Min(0)
    private long id;

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
    List<OrderItem> orderItems;
    private Category category;
    private Brand brand;
    private List<ProductPhoto> images;

}
