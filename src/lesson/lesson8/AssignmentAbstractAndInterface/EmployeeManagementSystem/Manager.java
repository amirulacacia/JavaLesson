package lesson.lesson8.assignmentabstractandinterface.EmployeeManagementSystem;

public class Manager extends Employee{

    public Manager(String name, int id){
        super(name, id);
    }

    @Override
    public void calculateSalary() {
        salary = 10000;
    }
    
}
