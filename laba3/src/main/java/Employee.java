import java.util.*;
public class Employee {
    private  String givenName;
    private  String surName;
    private  int age;
    private  Gender gender;
    private  Role role;
    private String dept;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int code;

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Role getRole() {
        return role;
    }

    public String getDept() {
        return dept;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getCode() {
        return code;
    }

    public static class Builder{
        private Employee newEmployee;
        public Builder(){
            newEmployee=new Employee();
        }
        public Builder withGivenName(String givenName){
            newEmployee.givenName=givenName;
            return this;
        }
        public Builder withSurName(String surName){
            newEmployee.surName=surName;
            return this;
        }
        public Builder withAge(int age){
            newEmployee.age=age;
            return this;
        }
        public Builder withGender(Gender gender){
            newEmployee.gender=gender;
            return this;
        }
        public Builder withRole(Role role){
            newEmployee.role=role;
            return this;
        }
        public Builder withDept(String dept){
            newEmployee.dept=dept;
            return this;
        }
        public Builder withEmail(String email){
            newEmployee.email=email;
            return this;
        }
        public Builder withPhone(String phone){
            newEmployee.phone=phone;
            return this;
        }
        public Builder withAddress(String address){
            newEmployee.address=address;
            return this;
        }
        public Builder withCity(String city){
            newEmployee.city=city;
            return this;
        }
        public Builder withState(String state){
            newEmployee.state=state;
            return this;
        }
        public Builder withCode(int code){
            newEmployee.code=code;
            return this;
        }
        public Employee build(){
            return newEmployee;
        }
    }
    @Override
    public String toString(){
        String ss = "Employee [";
        if(givenName!=null) {
            ss += "givenName='" + givenName + '\'';
        }
        if(surName!=null){
            ss+= ", surName='" + surName + '\'' ;
        }
        if(age!=0){
            ss+=", age=" + age + '\'';
        }
        if(gender!=null) {
            ss += ", gender=" + gender+ '\'';
        }
        if(role!=null)
        {
            ss+=", role=" + role + '\'';
        }
        if(dept!=null)
        {
           ss+= ", email='" + email + '\'';
        }
        if(phone!=null)
        {
            ss+=", phone='" + phone + '\'';
        }
        if(address!=null)
        {
            ss+=", address='" + address + '\'';
        }
        if(city!=null)
        {
            ss+=", city='" + city + '\'';
        }
        if(state!=null){
            ss+=", state='" + state + '\'';
        }
        if(code!=0){
            ss+=", code=" + code;
        }
        ss+=']';
        return ss;
    }
    public List<Employee> createShortList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee.Builder()
                .withAge(46)
                .withGivenName("Natalya")
                .withSurName("Born")
                .withCode(110)
                .withPhone("+89001113232")
                .withRole(Role.STAFF)
                .withCity("Moscow")
                .withGender(Gender.FEMALE)
                .withState("Moscow state")
                .withAddress("Moscow metro Petr struct 1")
                .withDept("Security")
                .build());
        list.add(new Employee.Builder()
                .withAge(24)
                .withGivenName("Anna")
                .withSurName("Sunder")
                .withCode(809)
                .withPhone("+89001113902")
                .withRole(Role.MANAGER)
                .withCity("London")
                .withGender(Gender.FEMALE)
                .withState("London state")
                .withAddress("London metro Paris struct 8")
                .withDept("Security")
                .build());
        list.add(new Employee.Builder()
                .withAge(31)
                .withGivenName("Anna")
                .withSurName("Builok")
                .withCode(849)
                .withPhone("+89005513903")
                .withRole(Role.EXECUTIVE)
                .withCity("Paris")
                .withGender(Gender.FEMALE)
                .withState("Paris state")
                .withAddress("Paris metro Qor struct 20")
                .withDept("Education")
                .build());

        list.add(new Employee.Builder()
                .withAge(35)
                .withGivenName("John")
                .withSurName("Snow")
                .withCode(300)
                .withPhone("+89014518903")
                .withRole(Role.STAFF)
                .withCity("Normin")
                .withGender(Gender.MALE)
                .withState("Murnon state")
                .withAddress("Normin struct 5")
                .withDept("Education")
                .build());
        list.add(new Employee.Builder()
                .withAge(23)
                .withGivenName("Jorge")
                .withSurName("Krio")
                .withCode(89)
                .withPhone("+89014518903")
                .withRole(Role.MANAGER)
                .withCity("Murmansk")
                .withGender(Gender.MALE)
                .withState("Murmansk state")
                .withAddress("Murmansk struct 25")
                .withDept("Information")
                .build());
        list.add(new Employee.Builder()
                .withAge(42)
                .withGivenName("Mila")
                .withSurName("Krio")
                .withCode(77)
                .withPhone("+87773399903")
                .withRole(Role.MANAGER)
                .withCity("Rio")
                .withGender(Gender.FEMALE)
                .withState("Rio state")
                .withAddress("Rio struct 16")
                .withDept("Information")
                .build());
        list.add(new Employee.Builder()
                .withAge(37)
                .withGivenName("Anton")
                .withSurName("Petrov")
                .withCode(90)
                .withPhone("+87773399903")
                .withRole(Role.MANAGER)
                .withCity("Volgograd")
                .withGender(Gender.MALE)
                .withState("Volgograd state")
                .withAddress("Volgograd struct 19")
                .withDept("Security")
                .build());
        return list;

    }
}
enum Gender
{
    MALE,
    FEMALE
}
enum Role
{
    STAFF(10000),
    MANAGER(20000),
    EXECUTIVE(30000);

    private final int salary;
    Role(int salary){
        this.salary=salary;
    }

    public int getSalary() {
        return salary;
    }
}
