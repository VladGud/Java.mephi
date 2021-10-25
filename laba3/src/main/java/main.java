public class main {
    public static void main(String... args){
        Employee employee= new Employee.Builder()
                .withGivenName("Gud")
                .withSurName("Snow")
                .withAge(40)
                .withGender(Gender.MALE)
                .withCity("Moscow")
                .build();
        System.out.println(employee.toString());
        Accountant accountant = new Accountant();
        var list= employee.createShortList();
        System.out.println("\n#################################################################################\n");
        for(int i=0; i<list.size();i++) {
            if(list.get(i).getGender()==Gender.FEMALE)
                accountant.payPremium(list.get(i));
        }
        System.out.println("\n#################################################################################\n");
        for(int i=0; i<list.size();i++) {
            if(list.get(i).getDept()=="Security")
                accountant.paySalary(list.get(i));
        }
        System.out.println("\n#################################################################################\n");
        for(int i=0; i<list.size();i++) {
            if(list.get(i).getDept()=="Security" && list.get(i).getAge()>30)
                accountant.payPremium(list.get(i));
        }
        System.out.println("\n#################################################################################\n");
        for(int i=0; i<list.size();i++) {
            if(list.get(i).getRole()==Role.MANAGER)
                accountant.paySalary(list.get(i));
        }
        System.out.println("\n#################################################################################\n");
        for(int i=0; i<list.size();i++) {
            if(list.get(i).getRole()==Role.STAFF)
                accountant.payPremium(list.get(i));
        }
    }
}
