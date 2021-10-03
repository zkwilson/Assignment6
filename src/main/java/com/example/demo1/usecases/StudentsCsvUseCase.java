package com.example.demo1.usecases;

import com.example.demo1.model.Assignment;
import com.example.demo1.model.Course;
import com.example.demo1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.demo1.ThymeleafConfig.CSV_TEMPLATE_ENGINE;

@Component
public class StudentsCsvUseCase {
    private final TemplateEngine templateEngine;

    @Autowired
    public StudentsCsvUseCase(@Qualifier(CSV_TEMPLATE_ENGINE) TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public List<Student> getStudentList() {
        Student student1 = new Student();
        student1.setLastName("Smotherman");
        student1.setFirstName("Kent");

        Student student2 = new Student();
        student2.setLastName("Rogers");
        student2.setFirstName("Norville");

        Course calculusKent = new Course();
        calculusKent.setName("Calculus");

        Course calculusRoger= new Course();
        calculusRoger.setName("Calculus");

        Course advancedJavaKent = new Course();
        advancedJavaKent.setName("Advanced Java");

        Course advancedJavaRoger = new Course();
        advancedJavaRoger.setName("Advanced Java");

        Course java101Kent= new Course();
        java101Kent.setName("Java 101");

        Course java101Roger= new Course();
        java101Roger.setName("Java 101");

        Assignment areaUnderTheCurveKent = new Assignment();
        areaUnderTheCurveKent.setName("Area under the curve");
        areaUnderTheCurveKent.setAssignmentDate(LocalDate.parse("2021-09-02"));
        areaUnderTheCurveKent.setGrade(4);

        Assignment areaUnderTheCurveRoger = new Assignment();
        areaUnderTheCurveRoger.setName("Area under the curve");
        areaUnderTheCurveRoger.setAssignmentDate(LocalDate.parse("2021-09-02"));
        areaUnderTheCurveRoger.setGrade(2.8);

        Assignment accelerationKent = new Assignment();
        accelerationKent.setName("Acceleration");
        accelerationKent.setAssignmentDate(LocalDate.parse("2021-09-04"));
        accelerationKent.setGrade(3.9);

        Assignment accelerationRoger = new Assignment();
        accelerationRoger.setName("Acceleration");
        accelerationRoger.setAssignmentDate(LocalDate.parse("2021-09-04"));
        accelerationRoger.setGrade(3.6);

        Assignment dualAxisEquationsKent = new Assignment();
        dualAxisEquationsKent.setName("Dual-Axis Equations");
        dualAxisEquationsKent.setAssignmentDate(LocalDate.parse("2021-09-06"));
        dualAxisEquationsKent.setGrade(3.6);

        Assignment dualAxisEquationsRoger = new Assignment();
        dualAxisEquationsRoger.setName("Dual-Axis Equations");
        dualAxisEquationsRoger.setAssignmentDate(LocalDate.parse("2021-09-03"));
        dualAxisEquationsRoger.setGrade(3.2);


        Assignment algorithmsKent = new Assignment();
        algorithmsKent.setName("Algorithms");
        algorithmsKent.setAssignmentDate(LocalDate.parse("2021-09-01"));
        algorithmsKent.setGrade(3.2);

        Assignment algorithms2Kent = new Assignment();
        algorithms2Kent.setName("Algorithms");
        algorithms2Kent.setAssignmentDate(LocalDate.parse("2021-09-05"));
        algorithms2Kent.setGrade(3.7);

        Assignment syntaxRoger = new Assignment();
        syntaxRoger.setName("Syntax");
        syntaxRoger.setAssignmentDate(LocalDate.parse("2021-09-05"));
        syntaxRoger.setGrade(3.5);

        Assignment controlStructuresRoger = new Assignment();
        controlStructuresRoger.setName("Control Structures");
        controlStructuresRoger.setAssignmentDate(LocalDate.parse("2021-09-03"));
        controlStructuresRoger.setGrade(3.1);

        calculusKent.setAssignment(List.of(areaUnderTheCurveKent, accelerationKent, dualAxisEquationsKent));
        calculusRoger.setAssignment(List.of(areaUnderTheCurveRoger, accelerationRoger, dualAxisEquationsRoger));

        advancedJavaKent.setAssignment(List.of(algorithmsKent, algorithms2Kent));

        java101Roger.setAssignment(List.of(syntaxRoger, controlStructuresRoger));

        student1.setCourse(List.of(calculusKent, advancedJavaKent));
        student2.setCourse(List.of(calculusRoger, java101Roger));

        List<Student> students = List.of(student1, student2);
        return students;
    }

    public String getStudentsAsCsv() {
        List<Student> students = getStudentList();

        StringWriter writer = new StringWriter();
        Context context = new Context();
        context.setVariable("students", students);
        templateEngine.process("students", context, writer);
        return writer.toString();
    }

    public String getStudentsAsCsvByCourse() {
       /* List<Student> students = getStudentList();
        List<Student> advancedJava = new ArrayList<>();
        List<Student> calculus = new ArrayList<>();
        List<Student> java101 = new ArrayList<>();
        List<Course> kentCourses = new ArrayList<>();
        List<Course> rogerCourses = new ArrayList<>();
        Map<String, List<Student>> courseMap = new HashMap();

        for(Student student : students) {
            if (student.getFirstName().equals("Kent")) {
                kentCourses = student.getCourse();
            }
            else {
                rogerCourses = student.getCourse();
            }
        }

        for(Course course : kentCourses) {
            courseMap.put(course.getName(), )
        }*/

        return null;
    }
}
