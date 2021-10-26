import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ApplicationLambda {
    public static void main(String... args) {
        BiPredicate<Employee, String> employeeBiPredicate =
                (t, s) -> t.getSurName().equals(s);

        Function<Employee, String[]> employeeFunction = t ->
                new String[]{t.getGivenName(), t.getSurName(), String.valueOf(t.getAge())};

        Consumer<String[]> employeeConsumer = t ->
                System.out.println("Given Name: " + t[0] + ", Surname: " + t[1] + ", Age: " + t[2]);

        Supplier<Employee> employeeSupplier =
                () -> new Employee.Builder()
                        .withGivenName("Gud")
                        .withSurName("Snow")
                        .withAge(40)
                        .withGender(Gender.MALE)
                        .withCity("Moscow")
                        .build();
        var list = employeeSupplier.get().createShortList();
        for (int i = 0; i < 3; i++) {
            list.add(employeeSupplier.get());
        }
        System.out.println("Find Surname: Snow");
        list.stream().filter(t -> employeeBiPredicate.test(t, "Snow"))
                .forEach(t -> employeeConsumer.accept(employeeFunction.apply(t)));
    }
}
