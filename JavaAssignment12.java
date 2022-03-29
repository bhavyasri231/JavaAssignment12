package JavaAssignment12;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Student
{
    int id,age,year_of_enrollment;
    double perTillDate;
    String name,gender,engDepartment;
    Student(int id, String name,int age,String gender,String engDepartment,int year_of_enrollment,double perTillDate )
    {
        this.id =id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.engDepartment=engDepartment;
        this.year_of_enrollment=year_of_enrollment;
        this.perTillDate = perTillDate;
    }
    Student()
    {}


    public void namesOfAllDepartments(ArrayList<Student> list)
    {
        System.out.println("The names of all departments");
        List<String> department = list.stream().map(dept->dept.engDepartment).collect(Collectors.toList());
        department.stream().distinct().forEach(System.out::println);
    }

    public void namesOfStudentsEnrolledAfter2018(ArrayList<Student> list)
    {
        System.out.println("The names of students enrolled after 2018");
        list.stream().filter(yoe->yoe.year_of_enrollment>2018).map(name->name.name).forEach(System.out::println);
    }

    public void detailsOfAllMalesInCSE(ArrayList<Student> list)
    {
        System.out.println("The details of all males in cSE");
        list.stream().filter(male->male.gender.equals("Male")).filter(cse->cse.engDepartment.equals("Computer Science")).
                map(id->id.id).forEach(System.out::println);
    }
    public void numberOfFemalesAndMales(ArrayList<Student> list)
    {
        System.out.println("The number of male and female students");
        Map<String,Long> value = list.stream().map(gender->gender.gender).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(String i : value.keySet())
        {
            System.out.println(i+" "+value.get(i));
        }
    }
    public void averageOfMalesAndFemales(ArrayList<Student> list) {
        System.out.println("Average of male and female students");
        OptionalDouble averageOfMales = list.stream().filter(male -> male.gender.equals("Male")).mapToDouble(age->age.age).average();
        OptionalDouble averageOfFemales = list.stream().filter(male -> male.gender.equals("Female")).mapToDouble(age->age.age).average();
        System.out.println("The average of ages of males are :"+averageOfMales.getAsDouble());
        System.out.println("The average of ages of females are :"+averageOfFemales.getAsDouble());

    }
    public void studentWithHighPercentage(ArrayList<Student> list)
    {
        System.out.println("Student with high percentage");
        OptionalDouble maximumMarks = list.stream().mapToDouble(mark->mark.perTillDate).max();
        list.stream().filter(marks->marks.perTillDate==maximumMarks.getAsDouble()).map(n->n.name).forEach(System.out::println);
    }

    public void numberOfStudentsInEachDepartment(ArrayList<Student> list)
    {
        System.out.println("Number of students in each department");
        Map<String,Long> value = list.stream().map(dept->dept.engDepartment).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(String i : value.keySet())
        {
            System.out.println(i+" "+value.get(i));
        }
    }
    public void averagePercentageOfEachDepartment(ArrayList<Student> list) {

        List<String> department = list.stream().map(dept->dept.engDepartment).collect(Collectors.toList());
        List<String> namesOfDepartment = department.stream().distinct().collect(Collectors.toList());
        for(String deptname : namesOfDepartment)
        {
            OptionalDouble averagemarks = list.stream().filter(dept->dept.engDepartment.equals(deptname)).mapToDouble(marks->marks.perTillDate).average();
            System.out.println("The average percentage of "+ deptname+" is :"+averagemarks.getAsDouble());
        }
    }

    public void youngestStudentInECE(ArrayList<Student> list) {
        Optional<Integer> minAge =  list.stream().filter(dept->dept.engDepartment.equals("Electronic")).map(age->age.age).collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("The youngest student in Electronic department is :"+ minAge.get());
    }

    public void numberOfMalesAndFemalesInCSE(ArrayList<Student> list)
    {
        System.out.println("Number od male and female students in CSE");
        Map<String,Long> value = list.stream().filter(dept->dept.engDepartment.equals("Computer Science")).map(g->g.gender).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for(String i : value.keySet())
        {
            System.out.println(i+" "+value.get(i));
        }
    }

}

public class JavaAssignment12 {
    public static void main(String[] args) {

        ArrayList<Student> array = new ArrayList<Student>(Arrays.asList(
        new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8),
        new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2),
        new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3),
        new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80),
        new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70),
        new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70),
        new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70),
        new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80),
        new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85),
        new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82),
        new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83),
        new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4),
        new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6),
        new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8),
        new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4),
        new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4),
        new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5)));

        Student student = new Student();
        student.namesOfAllDepartments(array);
        System.out.println();

        student.namesOfStudentsEnrolledAfter2018(array);
        System.out.println();

        student.detailsOfAllMalesInCSE(array);
        System.out.println();

        student.numberOfFemalesAndMales(array);
        System.out.println();

        student.averageOfMalesAndFemales(array);
        System.out.println();

        student.studentWithHighPercentage(array);
        System.out.println();

        student.numberOfStudentsInEachDepartment(array);
        System.out.println();

        student.averagePercentageOfEachDepartment(array);
        System.out.println();

        student.youngestStudentInECE(array);
        System.out.println();

        student.numberOfMalesAndFemalesInCSE(array);

    }

}
