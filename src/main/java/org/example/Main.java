package org.example;

import org.example.entity.Account;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    List<Account> accounts = new ArrayList<>();

    //todo: A list of numbers is given. Find the sum of all even numbers greater than 10.
    public Optional<Long> findSumOfAllCoupleIdUnderTen(){
        return accounts.stream()
                .map(Account::getId)
                .filter(id -> id > 10 && id % 2 == 0)
                .reduce(Long::sum);
    }

    //todo: Given a list of lines. Find the longest string that starts with a vowel.
    public Optional<String> findLongestFirstNameThatStartWithVowelLetter(){
        List<String> listVowelLetter = Arrays.asList("a", "e", "и", "і", "о", "у", "є", "ю", "я");
        return accounts.stream()
                .map(Account::getFirstName)
                .filter(str -> str.matches("^[аеиіоуєюя].*"))
                .max(Comparator.comparingInt(String::length));
    }

    //todo: A list of names is given. Sort the names alphabetically and display the first 5.
    public List<String> findFirstFiveLastNameSortedAlphabetically(){
        return accounts.stream()
                .map(Account::getLastName)
                .sorted()
                .limit(5)
                .collect(Collectors.toList());
    }

    //todo: Find all users who have a balance greater than the average balance of all users.
    public List<Account> findTheRichestsAccounts(){
        BigDecimal averageBalance = accounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(accounts.size()), RoundingMode.HALF_UP);

        return accounts.stream()
                .filter(account -> account.getBalance().compareTo(averageBalance) > 0)
                .toList();
    }
}