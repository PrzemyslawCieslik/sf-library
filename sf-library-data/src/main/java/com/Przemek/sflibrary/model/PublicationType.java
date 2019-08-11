package com.Przemek.sflibrary.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublicationType extends BaseEntity {
    private String name;

    @Builder
    public PublicationType(Long id, String name) {
        super(id);
        this.name = name;
    }
}
