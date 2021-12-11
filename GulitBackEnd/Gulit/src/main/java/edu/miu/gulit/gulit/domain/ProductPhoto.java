package edu.miu.gulit.gulit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhoto {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @URL
    private String url;
    @ManyToOne
    private Product product;
}
