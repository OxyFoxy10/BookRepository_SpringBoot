package org.example.bookrepospringbootmate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @Column(name = "cart_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id")
    private Cart cart;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
    private Book book;


}
