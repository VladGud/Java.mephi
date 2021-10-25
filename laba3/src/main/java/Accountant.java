public class Accountant {
    public void paySalary(Employee employee){
        System.out.println("Received a salary: "+ employee.getRole().getSalary() + "  " + employee.toString());
    }
    public void payPremium(Employee employee){
        switch (employee.getRole()) {
            case STAFF:
                System.out.println("Received a Premium 10%: " + Role.STAFF.getSalary()/10+ "  "  + employee.toString());
                break;
            case MANAGER:
                System.out.println("Received a Premium 20%: "+ Role.MANAGER.getSalary()*2/10+ "  "   + employee.toString());
                break;
            case EXECUTIVE:
                System.out.println("Received a Premium 30%: " + Role.EXECUTIVE.getSalary()*3/10+ "  "  + employee.toString());
                break;
        }
    }
}
