package week8;

import java.util.ArrayList;

public class Lecture8 {
    public static void main(String[] args) {
        Student s = new Student("123", "Phong");
        System.out.println(s);

        ITStudent s2 = new ITStudent("456", "Tran");
        s2.addLanguages("C++");
        s2.addLanguages("Java");
        s2.addLanguages("Python");
        System.out.println(s2);

        Student s3 = new ITStudent("789", "Duy");
        ((ITStudent)s3).addLanguages("Java");
        System.out.println(s3);
    }
}

class Student{
    String id;
    String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return String.format("Student: is %s - name %s", id, name);
    }
}

class ITStudent extends Student {
    ArrayList<String> programmingLanguages;

    public ITStudent(String id, String name) {
        super(id, name);
        programmingLanguages = new ArrayList<String>();
    }

    public void addLanguages(String lang){
        programmingLanguages.add(lang);
    }

    public String toString() {
        String info = super.toString();
        for (String l : programmingLanguages){
            info += "\n\t" + l;
        }
        return info;
    }

}

class BizStudent extends Student {
    public BizStudent(String id, String name) {
        super(id, name);
    }

    public String toString() {
        return String.format("I'm a biz student");
    }
}
