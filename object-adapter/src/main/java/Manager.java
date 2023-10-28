import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee{
    private final String name;
    private final List<Employee> employeeList = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void superviseEmployee(Employee employee){
        if (!employeeList.contains(employee)) employeeList.add(employee);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doTask(String task) {
        var freeEmployee = employeeList.stream().filter(e -> e.checkStatus() == null).findAny().orElseThrow(()-> new RuntimeException("Too much work overload"));
        freeEmployee.doTask(task);
    }

    @Override
    public String checkStatus() {
        if (employeeList.isEmpty()) return "No employees";
        StringBuilder status = new StringBuilder();
        for (Employee employee : employeeList) {
            status.append(employee.getName()).append(": ").append(employee.checkStatus() == null ? "Free": employee.checkStatus()).append("\n");
        }
        return status.toString();
    }
}
