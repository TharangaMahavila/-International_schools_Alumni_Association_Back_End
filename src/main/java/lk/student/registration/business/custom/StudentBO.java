package lk.student.registration.business.custom;

import lk.student.registration.business.SuperBO;
import lk.student.registration.dto.StudentDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentBO extends SuperBO {
    public ResponseEntity<Object> saveStudent(StudentDTO dto) throws Exception;
    public void updateStudent(StudentDTO dto) throws Exception;
    public List<StudentDTO> findAllStudent() throws Exception;
    public StudentDTO findStudent(int id) throws Exception;
    public void deleteStudent(int id) throws Exception;
    public ResponseEntity<?> getPdf(int id) throws Exception;
}
