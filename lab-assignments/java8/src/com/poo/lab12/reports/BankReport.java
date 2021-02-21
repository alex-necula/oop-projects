package com.poo.lab12.reports;

import com.poo.lab12.entities.Account;
import com.poo.lab12.entities.Bank;
import com.poo.lab12.entities.Employee;
import com.poo.lab12.entities.Gender;
import com.poo.lab12.entities.Project;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BankReport {

    public static int getNumberOfCustomers(Bank bank) {
        // A customer is an Employee that works for a Business (client of the bank)
        return bank.getClients().stream().mapToInt(b -> b.getEmployees().size()).sum();
    }

    public static int getNumberOfAccounts(Bank bank) {
        // Accounts of all the customers of the bank
        return bank.getClients().stream()
                .flatMap(b -> b.getEmployees().stream()).mapToInt(e -> e.getAccounts().size())
                .sum();
    }

    public static SortedSet<Employee> getCustomersSorted(Bank bank) {
        // Display the set of customers in alphabetical order
        return bank.getClients().stream().flatMap(b -> b.getEmployees().stream())
                .collect(Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(Employee::getName))));
    }

    public static double getTotalSumInAccounts(Bank bank) {
        // Sum of all customers' accounts balances
        return bank.getClients().stream().flatMap(b -> b.getEmployees().stream())
                .flatMap(e -> e.getAccounts().stream()).mapToDouble(Account::getBalance).sum();
    }

    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        // The set of all accounts, ordered by current account balance
        return bank.getClients().stream().flatMap(b -> b.getEmployees().stream())
                .flatMap(e -> e.getAccounts().stream()).collect(Collectors
                        .toCollection(() -> new TreeSet<>(
                                Comparator.comparingDouble(Account::getBalance))));
    }

    public static Map<Employee, Collection<Account>> getCustomerAccounts(Bank bank) {
        // Return a map of all the customers with their respective accounts
        return bank.getClients().stream().flatMap(b -> b.getEmployees().stream())
                .collect(Collectors.toMap(
                        Function.identity(), Employee::getAccounts));
    }

    public static Map<String, List<Employee>> getCustomersByCity(Bank bank) {
        // Map all the customers to their respective cities
        return bank.getClients().stream().flatMap(b -> b.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.toList()));
    }

    public static Project getProjectWorkedOnByMostCustomers(Bank bank) {
        // Return project most worked on by current employees
        return bank.getClients().stream().flatMap(b -> b.getEmployees().stream())
                .flatMap(e -> e.getProjects()
                        .stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(
                        Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);

        // Alternative: get project most worked on by "workers" field
        // return bank.getClients().stream().flatMap(b -> b.getEmployees().stream())
        //                .flatMap(e -> e.getProjects()
        //                        .stream()).max(Comparator.comparing(Project::getWorkers))
        //                        .orElse(null);
    }


    public static Gender getGenderWhoWorkedOnMostProjects(Bank bank) {
        return bank.getClients().stream().flatMap(b -> b.getEmployees().stream()).collect(Collectors
                .groupingBy(Employee::getGender,
                        Collectors.summingInt(e -> e.getProjects().size()))).entrySet().stream()
                .max(
                        Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }
}
