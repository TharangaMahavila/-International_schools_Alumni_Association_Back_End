package lk.student.registration.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lk.student.registration.business.custom.StudentBO;
import lk.student.registration.dto.StudentDTO;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.PermitAll;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    StudentBO bo;

    @Value("${path.images}")
    private String imagePath;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllStudent() throws Exception{
        return new ResponseEntity<>(bo.findAllStudent(), HttpStatus.OK);
    }

    @GetMapping(value = "/id",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getStudent(@PathVariable int id) throws Exception{
        return new ResponseEntity<>(bo.findStudent(id),HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Object> saveStudent(@RequestParam(value = "file", required = false)MultipartFile image, @RequestParam("body") String dto) throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        StudentDTO studentDTO = objectMapper.readValue(dto, StudentDTO.class);
        try {
         if (studentDTO.isHasImage() && (image == null || image.isEmpty())){
             return new ResponseEntity<>("Image can't be find!",HttpStatus.BAD_REQUEST);
         }
         if(studentDTO.isHasImage()){
             String filename = image.getOriginalFilename();
             String extentsion = FilenameUtils.getExtension(filename).toLowerCase();
             if(!(extentsion.equals("jpg") || extentsion.equals("jpeg") || extentsion.equals("png"))){
                 return new ResponseEntity<>("File Format is not allowed",HttpStatus.BAD_REQUEST);
             }
             String savePath = imagePath+File.separator+"Students"+File.separator+FilenameUtils.getBaseName(filename)+"_"
                     +new Timestamp(System.currentTimeMillis()) +"."+FilenameUtils.getExtension(filename);
             Path path = Paths.get(imagePath+File.separator+"Students");
             if(!Files.exists(path)){
                 Files.createDirectories(path);
             }
             File file = new File(savePath);
             FileUtils.writeByteArrayToFile(file,image.getBytes());
             if(!file.exists()){
                 return new ResponseEntity<>("Failed to save the student", HttpStatus.INTERNAL_SERVER_ERROR);
             }
             studentDTO.setImagePath(savePath);
         }
         bo.saveStudent(studentDTO);
         return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
      }catch (Exception e){
        return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> updateStudent(@PathVariable int id, @RequestBody StudentDTO dto) throws Exception{
        if (id!= dto.getId()){
            return new ResponseEntity<>("Student id mismatched!",HttpStatus.BAD_REQUEST);
        }
        try {
            bo.findStudent(id);
            bo.updateStudent(dto);
            return new ResponseEntity<>(dto,HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
        }
        catch (Throwable t){
            throw new Error(t);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deleteStudent(@PathVariable int id) throws Exception{
        try {
            bo.findStudent(id);
            bo.deleteStudent(id);
            return new ResponseEntity<>("Successfully deleted student",HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("No student found!",HttpStatus.NOT_FOUND);
        }catch (Throwable t){
            throw new Error(t);
        }
    }

    @GetMapping(value = "/{id}/pdf",produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public ResponseEntity<?> getStudentPdf(@PathVariable int id) throws Exception {
        return bo.getPdf(id);
    }
}
