package lk.student.registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data @NoArgsConstructor@AllArgsConstructor
public class Address {
    @Column(name = "line_1")
    private String line1;
    @Column(name = "line_2")
    private String line2;
}
