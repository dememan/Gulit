package edu.miu.gulit.gulit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.List;

@Table(name = "buyer")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Buyer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @OneToOne
    @JoinColumn(name = "buyer_bsaddress_id")
    UserAddress billingAddress;
    @OneToOne
    @JoinColumn(name = "buyer_ssaddress_id")
    UserAddress shippingAddress;

    @OneToMany(mappedBy = "buyer")
   List<UserOrder> orders;

    // For every succefully finished ordfers
    private long earnedPoints;



}
