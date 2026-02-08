import java.util.Scanner;

class Student {
    int maths , java;
    void inputMarks(Scanner sc, int studentNumber) {
        System.out.println("Enter Marks for Student" + studentNumber);
        System.out.print("Enter marks in Maths: ");
        maths = sc.nextInt();
        System.out.print("Enter marks in Java: ");
        java = sc.nextInt();
    }

    void displayMarks(int studentNumber) {
        int total = maths + java;
        double average = total / 2.0;

        System.out.println("Marks for Student " + studentNumber + ":");
        System.out.println("Maths: " + maths);
        System.out.println("Java: " + java);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);

        if(average >= 75) {
            System.out.println("Grade: A");
        } else if(average >= 60) {
            System.out.println("Grade: B");
        } else if(average >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: D");
        }
    }
}

class StudentMarks_lab1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        for (int i = 1; i <= 10; i++) {
            Student student = new Student();
            student.inputMarks(sc, i);
            student.displayMarks(i);
            System.out.println();
        }
        sc.close();
    }
}

