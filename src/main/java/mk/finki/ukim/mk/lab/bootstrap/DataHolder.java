//package mk.finki.ukim.mk.lab.bootstrap;
//
//import lombok.Getter;
//import mk.finki.ukim.mk.lab.model.Course;
//import mk.finki.ukim.mk.lab.model.Student;
//import mk.finki.ukim.mk.lab.model.Teacher;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import javax.annotation.PostConstruct;
//
//
//@Component
//@Getter
//public class DataHolder {
//
//    public static List<Student> students = new ArrayList<>();
//    public static List<Course> courses = new ArrayList<>();
//    public static List<Teacher> teachers = new ArrayList<>();
//
//    @PostConstruct
//    public void init() {
//        students.add(new Student("Sekuloski1", "Password1", "Bojan1", "Sekuloski1"));
//        students.add(new Student("Sekuloski2", "Password2", "Bojan2", "Sekuloski2"));
//        students.add(new Student("Sekuloski3", "Password3", "Bojan3", "Sekuloski3"));
//        students.add(new Student("Sekuloski4", "Password4", "Bojan4", "Sekuloski4"));
//        students.add(new Student("Sekuloski5", "Password5", "Bojan5", "Sekuloski5"));
//        teachers.add(new Teacher("Bojan", "Sekuloski"));
//        teachers.add(new Teacher("Bojan", "Sekuloski2"));
//        courses.add(new Course("C", "C", Arrays.asList(students.get(0), students.get(1)), teachers.get(0)));
//        courses.add(new Course("C#", "C#", Arrays.asList(students.get(2), students.get(3), students.get(4)), teachers.get(1)));
//    }
//}
