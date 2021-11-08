public enum Role {
    STAFF(10000),
    MANAGER(20000),
    EXECUTIVE(30000);

    private final int salary;

    private Role(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
