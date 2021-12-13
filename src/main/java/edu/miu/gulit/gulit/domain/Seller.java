package edu.miu.gulit.gulit.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seller")
public class Seller extends User{


    boolean isApproved;
    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    List <product> products;
    //@Size(min = 3)
    //@NotEmpty
    string company;
    //@Size(min = 5)
    //@NotEmpty
    string website;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "buyer", joinColumns = {
            @JoinColumn(name = "seller_id") }, inverseJoinColumns = {
            @JoinColumn(name = "buyer_id") })
    Set<Buyer>  sellerSubscriptions;


}