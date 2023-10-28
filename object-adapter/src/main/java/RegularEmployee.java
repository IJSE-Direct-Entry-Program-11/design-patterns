public class RegularEmployee implements Employee{

    private final String name;
    private String task;

    public RegularEmployee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doTask(String task) {
        if (this.task != null) throw new RuntimeException("I am busy");
        this.task = task;
    }

    @Override
    public String checkStatus() {
        return (task == null)? null : "Doing Task -> " + task;
    }
}
