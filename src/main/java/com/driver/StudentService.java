package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    static
    StudentRepository studentRepository;
    public static void addStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public static void deleteTeacher(String teacher) {
        studentRepository.deleteTeacher(teacher);
    }

    public static void deleteAllTeacher() {
        studentRepository.deleteAllTeacher();
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.saveTeacher(teacher);
    }

    public void createTeacherStudentPair(String student, String teacher) {
        studentRepository.saveTeacherStudentPair(student,teacher);
    }

    public Student findStudent(String name) {
        return studentRepository.findStudent(name);
    }

    public Teacher findTeacher(String teacher) {
        return studentRepository.findTeacher(teacher);
    }

    public List<String> findAllStudentFromTeacher(String teacher) {
        return studentRepository.findStudentFromTeacher(teacher);
    }

    public List<String> findAllStudents() {
        return studentRepository.findAllStudents();
    }
}
