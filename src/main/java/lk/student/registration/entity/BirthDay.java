package lk.student.registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class BirthDay {

    @Column(name = "date")
    private int date;
    @Column(name = "month")
    private int month;
    @Column(name = "year")
    private int year;

}
