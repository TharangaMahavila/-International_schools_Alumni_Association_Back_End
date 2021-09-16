package lk.student.registration.business.util;

import lk.student.registration.dto.StudentDTO;
import lk.student.registration.entity.Address;
import lk.student.registration.entity.BirthDay;
import lk.student.registration.entity.Name;
import lk.student.registration.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static lk.student.registration.entity.Gender.FEMALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EntityDTOMapperTest {
    @Autowired
    EntityDTOMapper mapper;

    @Test
    public void getStudent(){
        /*StudentDTO dto = new StudentDTO();
        dto.setId(1);
        dto.setFname("Ganga");
        dto.setLname("Jayakodi");
        dto.setOname("Kariyawasam");
        dto.setLine1("Arachchihena");
        dto.setLine2("Tittagalla");
        dto.setContact("071497588");
        dto.setEmail("kp@gmail.com");
        dto.setNic("945931337V");
        dto.setDate(12);
        dto.setMonth(1);
        dto.setYear(2019);
        dto.setGender(FEMALE);
        dto.setDsDivision("Galle");
        dto.setGnDivision("Ahangama");
        dto.setLanguage("Sinhala");
        dto.setExperience("1 year");
        dto.setFollowed(true);
        dto.setCourseDuration("6 months");
        Student student = mapper.getStudent(dto);
        System.out.println(student);
        assertEquals("Ganga", student.getName().getFname());*/
    }

    @Test
    public void getStudentDTO(){
        /*Student student = new Student();
        student.setId(1);
        student.setName(new Name("Ganga","Jayakodi","Kariyawasam"));
        student.setAddress(new Address("Arachchihena","Tittagalla"));
        student.setContact("071497588");
        student.setEmail("kp@gmail.com");
        student.setNic("945931337V");
        student.setBirthDay(new BirthDay(12,1,2019));
        student.setGender(FEMALE);
        student.setDsDivision("Galle");
        student.setGnDivision("Ahangama");
        student.setLanguage("Sinhala");
        student.setExperience("1 year");
        student.setFollowed(true);
        student.setCourseDuration("6 months");

        StudentDTO studentDTO = mapper.getStudentDTO(student);
        System.out.println(studentDTO);
        assertEquals("Ganga", studentDTO.getFname());*/
    }
}
