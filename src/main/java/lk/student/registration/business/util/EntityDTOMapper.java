package lk.student.registration.business.util;

import lk.student.registration.dto.StudentDTO;
import lk.student.registration.entity.*;
import org.springframework.stereotype.Service;

@Service
public class EntityDTOMapper {

    public Student getStudent(StudentDTO dto){
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(new Name(dto.getFname(), dto.getLname(), dto.getOname()));
        student.setAddress(new Address(dto.getLine1(), dto.getLine2()));
        student.setContact(dto.getContact());
        student.setEmail(dto.getEmail());
        student.setNic(dto.getNic());
        student.setBirthDay(new BirthDay(dto.getDate(), dto.getMonth(), dto.getYear()));
        student.setGender(dto.getGender());
        student.setDsDivision(dto.getDsDivision());
        student.setGnDivision(dto.getGnDivision());
        student.setLanguage(dto.getLanguage());
        student.setExperience(dto.getExperience());
        student.setFollowed(dto.isFollowed());
        student.setCourseDuration(dto.getCourseDuration());
        student.setHasImage(dto.isHasImage());
        student.setImagePath(dto.getImagePath());

        return student;
    }

    public StudentDTO getStudentDTO(Student student){
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFname(student.getName().getFname());
        dto.setLname(student.getName().getLname());
        dto.setOname(student.getName().getOname());
        dto.setLine1(student.getAddress().getLine1());
        dto.setLine2(student.getAddress().getLine2());
        dto.setContact(student.getContact());
        dto.setEmail(student.getEmail());
        dto.setNic(student.getNic());
        dto.setDate(student.getBirthDay().getDate());
        dto.setMonth(student.getBirthDay().getMonth());
        dto.setYear(student.getBirthDay().getYear());
        dto.setGender(student.getGender());
        dto.setDsDivision(student.getDsDivision());
        dto.setGnDivision(student.getGnDivision());
        dto.setLanguage(student.getLanguage());
        dto.setExperience(student.getExperience());
        dto.setFollowed(student.isFollowed());
        dto.setCourseDuration(student.getCourseDuration());
        dto.setHasImage(student.isHasImage());
        dto.setImagePath(student.getImagePath());

        return dto;
    }

}
