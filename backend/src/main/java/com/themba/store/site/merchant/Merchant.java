package com.themba.store.site.merchant;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "merchants")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "brand_name")
    private String brandName;

    private String business;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private String status;

    private LocalDateTime updated;

    @Column(nullable = false)
    private LocalDateTime created;

    // Getters and setters
}
