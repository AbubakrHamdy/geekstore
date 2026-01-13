package aaa.group.geekstore.model;

import aaa.group.geekstore.enums.Gender;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue
    private UUID id;

    private String email;
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String mobile;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<UserAddress> addresses;

    private UUID defaultAddressId;
}