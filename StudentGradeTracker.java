import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        ArrayList<String> letterGrades = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter Marks for student " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            grades.add(grade);
            letterGrades.add(convertToLetterGrade(grade));
        }

        int highest = Collections.max(grades);
        int lowest = Collections.min(grades);
        double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("\nStudent Grades:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ": " + grades.get(i) + " (" + letterGrades.get(i) + ")");
        }

        System.out.println("\nHighest Grade: " + highest + " (" + convertToLetterGrade(highest) + ")");
        System.out.println("Lowest Grade: " + lowest + " (" + convertToLetterGrade(lowest) + ")");
        System.out.printf("Average Grade: %.2f (%s)%n", average, convertToLetterGrade((int) average));

        scanner.close();
    }
    
    public static String convertToLetterGrade(int grade) {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }
}
