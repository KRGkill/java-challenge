package com.intelygenz.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Numbers")
public class Numbers {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "integers")
    String integers;

}
