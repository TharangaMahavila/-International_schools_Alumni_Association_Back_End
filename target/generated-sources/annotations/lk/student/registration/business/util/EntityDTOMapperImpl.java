package lk.student.registration.business.util;

import javax.annotation.Generated;
import lk.student.registration.dto.StudentDTO;
import lk.student.registration.entity.Student;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T04:16:03+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class EntityDTOMapperImpl implements EntityDTOMapper {

    @Override
    public Student getStudent(StudentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        student.setName( getName( dto ) );
        student.setAddress( getAddress( dto ) );
        student.setBirthDay( getBirthday( dto ) );
        student.setId( dto.getId() );
        student.setContact( dto.getContact() );
        student.setEmail( dto.getEmail() );
        student.setNic( dto.getNic() );
        student.setGender( dto.getGender() );
        student.setDsDivision( dto.getDsDivision() );
        student.setGnDivision( dto.getGnDivision() );
        student.setLanguage( dto.getLanguage() );
        student.setExperience( dto.getExperience() );
        student.setFollowed( dto.isFollowed() );
        student.setCourseDuration( dto.getCourseDuration() );
        student.setHasImage( dto.isHasImage() );
        student.setImagePath( dto.getImagePath() );

        return student;
    }

    @Override
    public StudentDTO getStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setFname( getFname( student ) );
        studentDTO.setLname( getLname( student ) );
        studentDTO.setOname( getOname( student ) );
        studentDTO.setLine1( getLine1( student ) );
        studentDTO.setLine2( getLine2( student ) );
        studentDTO.setDate( Integer.parseInt( getDate( student ) ) );
        studentDTO.setMonth( Integer.parseInt( getMonth( student ) ) );
        studentDTO.setYear( Integer.parseInt( getYear( student ) ) );
        studentDTO.setId( student.getId() );
        studentDTO.setContact( student.getContact() );
        studentDTO.setEmail( student.getEmail() );
        studentDTO.setNic( student.getNic() );
        studentDTO.setGender( student.getGender() );
        studentDTO.setDsDivision( student.getDsDivision() );
        studentDTO.setGnDivision( student.getGnDivision() );
        studentDTO.setLanguage( student.getLanguage() );
        studentDTO.setExperience( student.getExperience() );
        studentDTO.setFollowed( student.isFollowed() );
        studentDTO.setCourseDuration( student.getCourseDuration() );
        studentDTO.setHasImage( student.isHasImage() );
        studentDTO.setImagePath( student.getImagePath() );

        return studentDTO;
    }
}
