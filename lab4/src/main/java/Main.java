import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args){
        Employee employee = new Employee.Builder()
                .withGivenName("Gud")
                .withSurName("Snow")
                .withAge(40)
                .withGender(Gender.MALE)
                .withCity("Moscow")
                .build();
        var list=employee.createShortList();
        list.stream().peek(x->System.out.print(x.getGivenName()+": ")).map(x->Arrays.stream(x.getGivenName().split("")))
                .collect(Collectors.toList()).forEach(x->{x.forEach(y->System.out.print(y+" ")); System.out.print("|| ");});
        System.out.println();
        list.stream().peek(x->x.setGivenName(x.getGivenName().toLowerCase()))
                .map(Employee::getGivenName).forEach(System.out::println);


        System.out.println("First element in list: " + list.stream().findFirst().get().getGivenName());
        System.out.println("Any element in list: " + list.stream().findAny().get().getGivenName());
        System.out.println("Amount elements in list: "+list.stream().count());
        System.out.println("Last element in list: "+list.stream().reduce((first, second) -> second).orElse(null).getGivenName());
        System.out.println("Last element in list (use skip): "+list.stream().skip(list.size()-1).findFirst().get().getGivenName());
        Comparator<Employee> comparatorsalary=Comparator.comparing(Employee::getSalary);
        Comparator<Employee> comparatorage = Comparator.comparing(Employee::getAge);
        Employee maxempl=list.stream().max(comparatorsalary).get();
        Employee minempl=list.stream().min(comparatorsalary).get();
        System.out.println("Min Employee Salary: "+minempl.getGivenName()+" "+(minempl.getSalary()));
        System.out.println("Max Employee Salary: "+maxempl.getGivenName()+" "+(maxempl.getSalary()));
        maxempl=list.stream().max(comparatorage).get();
        minempl=list.stream().min(comparatorage).get();
        System.out.println("Min Employee Age: "+minempl.getGivenName()+" "+(minempl.getAge()));
        System.out.println("Max Employee Age: "+maxempl.getGivenName()+" "+(maxempl.getAge()));


        System.out.println("Sum salary: "+(list.stream().mapToInt(Employee::getSalary).sum()));
        System.out.println("Average salary: "+(list.stream().mapToInt(Employee::getSalary).average().orElse(Double.NaN)));
        System.out.println("Sum Age: "+(list.stream().mapToInt(Employee::getAge).sum()));
        System.out.println("Average Age: "+Math.round(list.stream().mapToInt(Employee::getAge).average().orElse(Double.NaN)));
    }
}
