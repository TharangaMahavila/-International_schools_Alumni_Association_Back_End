package lk.student.registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "student")
public class Student implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Embedded
    private Name name;
    @Embedded
    private Address address;
    private String contact;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String nic;
    @Embedded
    private BirthDay birthDay;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    @Column(name = "ds_division")
    private String dsDivision;
    @Column(name = "gn_division")
    private String gnDivision;
    private String language;
    private String experience;
    @Column(name = "is_followed")
    private boolean isFollowed;
    @Column(name = "course_duration")
    private String courseDuration;
    @Column(name = "has_image")
    private boolean hasImage;
    @Column(name = "image_path")
    private String imagePath;
}
