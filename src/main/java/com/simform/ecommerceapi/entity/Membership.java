package com.simform.ecommerceapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.simform.ecommerceapi.enums.MembershipType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_type")
    private MembershipType membershipType;

    @Column(name = "expiry")
    private LocalDate expiry;

    @OneToOne
    @JoinColumn(name = "user_fk_id", referencedColumnName = "id")
    @JsonManagedReference
    private User user;

}
