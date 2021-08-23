package lk.student.registration.business.util;

import lk.student.registration.dto.StudentDTO;
import lk.student.registration.entity.Address;
import lk.student.registration.entity.BirthDay;
import lk.student.registration.entity.Name;
import lk.student.registration.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Mapper(componentModel = "spring")
public interface EntityDTOMapper {


    @Mapping(source = ".", target = "name", qualifiedByName = "getName")
    @Mapping(source = ".", target = "address", qualifiedByName = "getAddress")
    @Mapping(source = ".", target = "birthDay", qualifiedByName = "getBirthday")
    Student getStudent(StudentDTO dto);

    @Mapping(source = ".", target = "fname", qualifiedByName = "getFname")
    @Mapping(source = ".", target = "lname", qualifiedByName = "getLname")
    @Mapping(source = ".", target = "oname", qualifiedByName = "getOname")
    @Mapping(source = ".", target = "line1", qualifiedByName = "getLine1")
    @Mapping(source = ".", target = "line2", qualifiedByName = "getLine2")
    @Mapping(source = ".", target = "date", qualifiedByName = "getDate")
    @Mapping(source = ".", target = "month", qualifiedByName = "getMonth")
    @Mapping(source = ".", target = "year", qualifiedByName = "getYear")
    StudentDTO getStudentDTO(Student student);

    @Named("getName")
    default Name getName(StudentDTO dto){
        Name name = new Name();
        name.setFname(dto.getFname());
        name.setLname(dto.getLname());
        name.setOname(dto.getOname());
        return name;
    }

    @Named("getAddress")
    default Address getAddress(StudentDTO dto){
        Address address = new Address();
        address.setLine1(dto.getLine1());
        address.setLine2(dto.getLine2());
        return address;
    }

    @Named("getBirthday")
    default BirthDay getBirthday(StudentDTO dto){
        BirthDay birthDay =  new BirthDay();
        birthDay.setDate(dto.getDate());
        birthDay.setMonth(dto.getMonth());
        birthDay.setYear(dto.getYear());
        return birthDay;
    }

    @Named("getFname")
    default String getFname(Student student){
        return student.getName().getFname();
    }

    @Named("getLname")
    default String getLname(Student student){
        return student.getName().getLname();
    }

    @Named("getOname")
    default String getOname(Student student){
        return student.getName().getOname();
    }

    @Named("getLine1")
    default String getLine1(Student student){
        return student.getAddress().getLine1();
    }

    @Named("getLine2")
    default String getLine2(Student student){
        return student.getAddress().getLine2();
    }

    @Named("getDate")
    default String getDate(Student student){
        return String.valueOf(student.getBirthDay().getDate());
    }

    @Named("getMonth")
    default String getMonth(Student student){
        return String.valueOf(student.getBirthDay().getMonth());
    }

    @Named("getYear")
    default String getYear(Student student){
        return String.valueOf(student.getBirthDay().getYear());
    }
}
