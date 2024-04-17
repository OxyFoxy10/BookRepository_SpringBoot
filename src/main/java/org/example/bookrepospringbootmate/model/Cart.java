package org.example.bookrepospringbootmate.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "total_price")
    private double totalPrice;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany (mappedBy = "cart", cascade =  CascadeType.ALL,  orphanRemoval = true )
    private Set<CartItem> cartItems;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "carts_user",
            joinColumns = @JoinColumn(name = "cart_cart_id"),
            inverseJoinColumns = @JoinColumn(name = "user_user_id"))
    private User user;


    public Cart() {
        this.cartItems = new LinkedHashSet<>();
    }
}
