package com.adekus.studentadministratie.services;

import com.adekus.studentadministratie.domain.Student;
import com.adekus.studentadministratie.repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student get(String id) {
        return studentRepository.findById(id).get();
    }

    public void delete(String id) {
        studentRepository.deleteById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public String generateStudentReport() {
        try {
            List<Student> studenten = studentRepository.findAll();
            //String reportPath = "//";
            // Compile the Jasper report from .jrxml to .japser
            InputStream is=this.getClass().getResourceAsStream("/templates/reports/student-rpt.jrxml");
            System.out.println("InputStream ready...");
            //InputStream is = new FileInputStream("//student-rpt.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            System.out.println("Compiled report ready");
            //JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "student-rpt.jrxml");
            // Get your data source
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(studenten);
            System.out.println("Data source retrieved");
            // Add parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "elektro.uvs.edu");
            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    jrBeanCollectionDataSource);
            System.out.println("Report filled with data ...");
            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, /*reportPath +*/ "student-rpt.pdf");
            System.out.println("Done exporting report to pdf file");
            return "Report successfully generated @path= " /*+ reportPath*/;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error--> check the console log";
        }
    }

    public String generateStudentReport1() {
        try {
            List<Student> studenten = studentRepository.findAll();
            //String reportPath = "//";
            // Compile the Jasper report from .jrxml to .japser
            InputStream is=this.getClass().getResourceAsStream("/templates/reports/student-rpt.jrxml");
            System.out.println("InputStream ready...");
            //InputStream is = new FileInputStream("//student-rpt.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(is);
            System.out.println("Compiled report ready");
            //JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "student-rpt.jrxml");
            // Get your data source
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(studenten);
            System.out.println("Data source retrieved");
            // Add parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("createdBy", "elektro.uvs.edu");
            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    jrBeanCollectionDataSource);
            System.out.println("Report filled with data ...");
            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, /*reportPath +*/ "student-rpt.pdf");
            System.out.println("Done exporting report to pdf file");
            return "Report successfully generated @path= " /*+ reportPath*/;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error--> check the console log";
        }
    }
}

