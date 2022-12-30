package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<String,Student>StudentMap;
    private HashMap<String,Teacher>TeacherMap;
    private HashMap<String, List<String>>TeacherStudentMap;

    public StudentRepository() {
        this.StudentMap=new HashMap<String,Student>();
        this.TeacherMap =new HashMap<String,Teacher>();
        this.TeacherStudentMap=new HashMap<String,List<String>>();

    }
    public void saveStudent(Student student){
        StudentMap.put(student.getName(),student);
    }
    public void saveTeacher(Teacher teacher){
        TeacherMap.put(teacher.getName(),teacher);
    }
    public void saveTeacherStudentPair(String student, String teacher){
        if(StudentMap.containsKey(student) && TeacherMap.containsKey(teacher)){
            List<String> currentstudentswithteacher = new ArrayList<>();

            if(TeacherStudentMap.containsKey(teacher)){
                currentstudentswithteacher = TeacherStudentMap.get(teacher);
            }
            currentstudentswithteacher.add(student);
            TeacherStudentMap.put(teacher,currentstudentswithteacher);
        }
    }

    public Student findStudent(String student){
        return StudentMap.get(student);
    }
    public Teacher findTeacher(String teacher){
        return TeacherMap.get(teacher);
    }
    public List<String> findStudentFromTeacher(String teacher){
        List<String> studentList = new ArrayList<String>();
        if(TeacherStudentMap.containsKey(teacher)){
            studentList =TeacherStudentMap.get(teacher);
        }
        return studentList;
    }
    public List<String> findAllStudents(){
        return new ArrayList<>(StudentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        List<String> students = new ArrayList<String>();
        if(TeacherStudentMap.containsKey(teacher)){
            students = TeacherStudentMap.get(teacher);

            for(String student : students){
                if(StudentMap.containsKey(student)){
                    StudentMap.remove(student);
                }
            }
            TeacherStudentMap.remove(teacher);
        }
        if(TeacherMap.containsKey(teacher)){
            TeacherMap.remove(teacher);
        }
    }

    public void deleteAllTeacher(){
        HashSet<String> StudentSet = new HashSet<String>();

        TeacherMap = new HashMap<>();
        for(String teacher : TeacherStudentMap.keySet()){
            for( String student : TeacherStudentMap.get(teacher)){
                StudentSet.add(student);
            }
            for(String student : StudentSet){
                if(StudentMap.containsKey(student)){
                    StudentMap.remove(student);
                }
            }
            TeacherStudentMap = new HashMap<>();
        }
    }

}
