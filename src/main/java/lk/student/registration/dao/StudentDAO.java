package lk.student.registration.dao;

import lk.student.registration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {
}
