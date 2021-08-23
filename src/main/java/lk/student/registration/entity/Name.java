package lk.student.registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class Name {

    @Column (name = "f_name")
    private String fname;
    @Column(name = "l_name")
    private String lname;
    @Column(name = "o_name")
    private String oname;
}
