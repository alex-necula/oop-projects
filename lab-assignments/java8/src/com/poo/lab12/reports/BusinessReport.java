package com.poo.lab12.reports;

import com.poo.lab12.entities.Business;
import com.poo.lab12.entities.Disability;
import com.poo.lab12.entities.Employee;
import com.poo.lab12.entities.Gender;
import com.poo.lab12.entities.Project;
import com.poo.lab12.entities.Religion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BusinessReport {

    public static Map<Disability, List<Employee>> getEmployeesOnSameDisability(Business business) {
        return business.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDisability, Collectors.toList()));
    }

    public static int getNumberOfProjectsWorkedByCurrentEmployees(Business business) {
        return business.getEmployees().stream().mapToInt(e -> e.getProjects().size()).sum();
    }

    public static SortedSet<Employee> getEmployeesMaxByReligionMaxByGenderSortedByCitySortedByAge(
            Business business) {
        Religion maxReligion = business.getEmployees().stream().map(Employee::getReligion)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()))
                .entrySet().stream().max(
                        Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        Gender maxGender =
                business.getEmployees().stream().filter(e -> e.getReligion().equals(maxReligion))
                        .map(Employee::getGender)
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()))
                        .entrySet().stream().max(
                        Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        return business.getEmployees().stream()
                .filter(e -> e.getReligion().equals(maxReligion) && e.getGender().equals(maxGender))
                .collect(Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(Employee::getCity).thenComparing(Employee::getAge))));
    }

    public static Religion getReligionOfEmployeesWithMostAccounts(Business business) {
        return Objects.requireNonNull(business.getEmployees().stream()
                .max(Comparator.comparing(e -> e.getAccounts().size())).orElse(null)).getReligion();
    }

    public static Map<Project, Map<String, List<Employee>>> getEmployeesOnSameProjectAndCity(
            Business business) {

        // Firstly, create project map
        Map<Project, List<Employee>> projectMap = new HashMap<>();
        for (var employee : business.getEmployees()) {
            for (var project : employee.getProjects()) {
                projectMap.computeIfAbsent(project, e -> new ArrayList<>()).add(employee);
            }
        }

        // Create second map for city
        Map<Project, Map<String, List<Employee>>> result = new HashMap<>();
        for (var entry : projectMap.entrySet()) {
            result.put(entry.getKey(), entry.getValue().stream()
                    .collect(Collectors.groupingBy(Employee::getCity, Collectors.toList())));
        }

        return result;
    }

    public static Map<Religion, Map<Gender, List<Employee>>> getEmployeesOnSameReligionAndGender(
            Business business) {
        return business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getReligion,
                Collectors.groupingBy(Employee::getGender, Collectors.toList())));
    }
}
