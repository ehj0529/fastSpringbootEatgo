package kr.co.fastcampus.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private Long restaurantId;

    @NotEmpty
    @org.hibernate.validator.constraints.NotEmpty
    private String name;

    @NotNull
    private Integer score;

    @NotEmpty
    @org.hibernate.validator.constraints.NotEmpty
    private String description;

}
