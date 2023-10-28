public class Owner {

    public static void main(String[] args) {
        Manager manager = new Manager("Yasendra");
        String status = manager.checkStatus();
        System.out.println(status);

        manager.superviseEmployee(new RegularEmployee("Kasun"));
        manager.superviseEmployee(new RegularEmployee("Nuwan"));
        manager.superviseEmployee(new RegularEmployee("Ruwan"));

        System.out.println("-------");
        status = manager.checkStatus();
        System.out.println(status);
        System.out.println("-------");

        manager.doTask("Complete UI Design in Figma");
        manager.doTask("Develop Contact Page of the Application");
        status = manager.checkStatus();
        System.out.println(status);
        System.out.println("-------");
    }
}
