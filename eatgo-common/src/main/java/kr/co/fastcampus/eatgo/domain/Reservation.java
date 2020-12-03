package kr.co.fastcampus.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    @Setter
    private String name;

    @Setter
    @NotEmpty
    @org.hibernate.validator.constraints.NotEmpty
    private String date;

    @Setter
    @NotEmpty
    @org.hibernate.validator.constraints.NotEmpty
    private String time;

    @Setter
    @NonNull
    private Integer partySize;

}
