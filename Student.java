import java.util.Scanner;

class Student {

    String studentName;
    long rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    Student(String studentName, long rollNumber, double marks,
            String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility
    boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship
    double calculateScholarship() {

        double fee = calculateFee();

        if (marks >= 85) {
            return fee * 0.20;
        } else if (marks >= 70) {
            return fee * 0.10;
        } else {
            return 0;
        }
    }

    // Calculate final fee
    double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Display details
    void displayDetails() {

        System.out.println("\n========== STUDENT DETAILS ==========");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);

        System.out.println("\n========== COURSE DETAILS ==========");
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);

        System.out.println("\n========== REGISTRATION DETAILS ==========");
        System.out.println("Eligibility        : Eligible");
        System.out.println("Total Course Fee   : Rs. " + calculateFee());
        System.out.println("Scholarship Amount : Rs. " + calculateScholarship());
        System.out.println("Final Fee          : Rs. " + calculateFinalFee());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        long rollNumber = sc.nextLong();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = sc.nextInt();

        Student student = new Student(
                studentName,
                rollNumber,
                marks,
                courseName,
                courseCredits
        );

        if (student.checkEligibility()) {

            student.displayDetails();

        } else {

            System.out.println("\n======================================");
            System.out.println("Student is NOT eligible for registration.");
            System.out.println("Minimum required marks: 50");
            System.out.println("======================================");
        }

        sc.close();
    }
}