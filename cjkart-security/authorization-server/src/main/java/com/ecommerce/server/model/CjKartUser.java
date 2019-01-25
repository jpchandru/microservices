package com.ecommerce.server.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CjKartUser {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private boolean active;

    public CjKartUser(String userName, String password, boolean active) {
        this.userName = userName;
        this.password = password;
        this.active = active;
    }
}
