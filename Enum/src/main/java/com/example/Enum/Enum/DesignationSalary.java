package com.example.Enum.Enum;

public enum DesignationSalary {
    JUNIOR_SOFTWARE_ENGINEER(1,"Jr Software Eng.",25000),
    SOFTWARE_ENGINEER(2,"Software Eng.",40000),
    SENIOR_SOFTWARE_ENGINEER(3,"Sr Software Eng.",60000);

    private final int order;
    private final String designation;
    private final int salary;

    DesignationSalary(int order, String designation, int salary) {
        this.order = order;
        this.designation = designation;
        this.salary = salary;
    }

    public int getOrder() {
        return order;
    }

    public String getDesignation() {
        return designation;
    }

    public int getSalary() {
        return salary;
    }
}
