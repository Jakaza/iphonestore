package com.themba.store.site.brand;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String slug;

    @Column(name = "image_path")
    private String imagePath;

    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    private LocalDateTime updated;

    @Column(nullable = false)
    private LocalDateTime created;

    // Getters and setters
}
