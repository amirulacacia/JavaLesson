package lesson.lesson8.assignmentabstractandinterface.employeemanagementsystem;

public class Intern extends Employee{
    public Intern(String name, int id){
        super(name, id);
    }

    @Override
    public void calculateSalary() {
        salary = 1000;
    }
    
}
