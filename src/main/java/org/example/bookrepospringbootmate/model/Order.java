package org.example.bookrepospringbootmate.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @Column(name = "order_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant orderDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User client;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    public enum Status {
        CREATED,
        PROCESSING,
        WAITING_PAYMENT,
        PAID,
        SHIPPED,
        DELIVERED,
        CANCELED
    }
}
