package lk.student.registration.business.custom.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lk.student.registration.business.custom.StudentBO;
import lk.student.registration.business.util.EntityDTOMapper;
import lk.student.registration.dao.StudentDAO;
import lk.student.registration.dto.StudentDTO;
import lk.student.registration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentBOImpl implements StudentBO {

    @Autowired
    EntityDTOMapper mapper;

    @Autowired
    private StudentDAO dao;
    @Override
    public void saveStudent(StudentDTO dto) throws Exception {
        Student student = mapper.getStudent(dto);
        dao.save(student);
    }

    @Override
    public void updateStudent(StudentDTO dto) throws Exception {
        dao.save(mapper.getStudent(dto));
    }

    @Override
    public List<StudentDTO> findAllStudent() throws Exception {
        return dao.findAll().stream().map(Student -> mapper.getStudentDTO(Student)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudent(int id) throws Exception {
        Optional<StudentDTO> studentDTO = dao.findById(id).map(Student -> mapper.getStudentDTO(Student));
        if (studentDTO.isPresent()){
            return studentDTO.get();
        }
        throw new RuntimeException("Student not found");
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        dao.deleteById(id);
    }

    @Override
    public ResponseEntity<InputStreamResource>  getPdf(int id) throws Exception {

        StudentDTO student = findStudent(id);

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfPTable table = new PdfPTable(10);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{1,3,3,3,3,3,3,3,3,3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell = new PdfPCell(new Phrase("ID", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("First Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Last Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            PdfPCell cell;

            cell = new PdfPCell(new Phrase(String.valueOf(student.getId())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(student.getFname().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(student.getLname().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(student.getLine1().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(student.getLine2().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(student.getContact().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(student.getEmail().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(student.getNic().toString()));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(student.getDate())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(String.valueOf(student.getMonth())));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename="+student.getFname()+"_"+student.getId()+".pdf");
        return ResponseEntity
                .ok()
                .header(headers.toString())
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
