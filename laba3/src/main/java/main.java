public class Main {
    public static void main(String... args) {
        Employee employee = new Employee.Builder()
                .withGivenName("Gud")
                .withSurName("Snow")
                .withAge(40)
                .withGender(Gender.MALE)
                .withCity("Moscow")
                .build();
        System.out.println(employee.toString());
        Accountant accountant = new Accountant();
        var list = employee.createShortList();
        System.out.println("\n#################################################################################\n");
        list.stream().filter(t-> t.getGender() == Gender.FEMALE).forEach(t->accountant.payPremium(t));
        System.out.println("\n#################################################################################\n");
        list.stream().filter(t->t.getDept() == "Security").forEach(t->accountant.paySalary(t));
        System.out.println("\n#################################################################################\n");
        list.stream().filter(t->t.getDept() == "Security" && t.getAge() > 30).forEach(t->accountant.payPremium(t));
        System.out.println("\n#################################################################################\n");
        list.stream().filter(t->t.getRole() == Role.MANAGER).forEach(t->accountant.paySalary(t));
        System.out.println("\n#################################################################################\n");
        list.stream().filter(t->t.getRole() == Role.STAFF).forEach(t->accountant.payPremium(t));
    }
}
