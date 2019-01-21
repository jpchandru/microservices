package com.journey.hotellist.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="hotellist", catalog = "journeylist")
public class Hotel {
    @Id
    private long id;
    private String name;
    private String groupName;
    private int rating;
    private String location;

}
