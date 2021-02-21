package com.poo.lab12.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Employee {
    private final String name;
    private final Integer age;
    private final String city;
    private final Set<Account> accounts = new HashSet<>();
    private final List<Project> projects = new ArrayList<>();
    private Gender gender;
    private Disability disability;
    private Religion religion;

    public Employee(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Employee(String name, Integer age, String city, Gender gender, Disability disability,
                    Religion religion) {
        this(name, age, city);
        this.gender = gender;
        this.disability = disability;
        this.religion = religion;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Disability getDisability() {
        return disability;
    }

    public Religion getReligion() {
        return religion;
    }

    public Set<Account> getAccounts() {
        return Collections.unmodifiableSet(accounts);
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    @Override
    public String toString() {
        return "Name " +
                getName() +
                ", city " +
                getCity() +
                ", age " +
                getAge() +
                ", gender" +
                getGender() +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return getName().equals(employee.getName()) &&
                getGender() == employee.getGender() &&
                getCity().equals(employee.getCity()) &&
                getAge().equals(employee.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getCity(), getAge());
    }
}
