package week11;

import java.util.Map;
import java.util.Hashtable;

public class Excercise4 {
    public static void main(String[] args) throws Exception {
        RMITStudent student = new RMITStudent("Tri");
        student.updateCourse("COSC2081", 80);
        student.updateCourse("COSC2082", 81);
        student.updateCourse("COSC2081", 60);
        System.out.println(student);
        student.updateCourse("ABC", 13);
        System.out.println(student);
        student.updateCourse("DEF", 43);
        System.out.println(student);
    }
}

class RMITStudent {
    String name;
    Map<String, Integer> marks;

    public RMITStudent(String name) {
        this.name = name;
        marks = new Hashtable<String, Integer>();
    }

    public void updateCourse(String code, int mark) throws MarkException, CourseException {
        if (mark < 0 || mark > 100) {
            throw new MarkException("Invalid mark");
        }
        marks.put(code, mark);
        if (marks.size() > 3) {
            throw new CourseException("Exceed limit");
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(name);
        for (String code : marks.keySet()) {
            sb.append("\n");
            sb.append(code + " : ");
            sb.append(marks.get(code));
        }
        return sb.toString();
    }
}

class RMITException extends Exception {
    public RMITException(String str) {
        super(str);
    }
}

class CourseException extends RMITException {
    public CourseException(String str) {
        super("Exceptions related to course " + str);
    }
}

class MarkException extends RMITException {
    public MarkException(String str) {
        super("Exceptions related to mark " + str);
    }
}