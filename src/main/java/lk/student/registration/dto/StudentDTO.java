package lk.student.registration.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.student.registration.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO implements Serializable {
    private int id;
    @NotNull(message = "Student first name is required")
    private String fname;
    private String lname;
    private String oname;
    @NotNull(message = "Address first line is required")
    private String line1;
    private String line2;
    private String contact;
    private String email;
    private String nic;
    @NotNull(message = "Birth date is required")
    private int date;
    @NotNull(message = "Birth month is required")
    private int month;
    @NotNull(message = "Birth year is required")
    private int year;
    @NotNull(message = "Gender is required")
    private Gender gender;
    @NotNull(message = "DS Division is required")
    private String dsDivision;
    @NotNull(message = "GN Division is required")
    private String gnDivision;
    @NotNull(message = "Language is reqired")
    private String language;
    private String experience;
    @NotNull(message = "Any course followed state is required")
    private boolean isFollowed;
    private String courseDuration;
    @NotNull(message = "has image state is required")
    private boolean hasImage;
    private String imagePath;
}
