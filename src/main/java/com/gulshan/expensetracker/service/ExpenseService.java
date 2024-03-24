package com.gulshan.expensetracker.service;


import com.gulshan.expensetracker.dto.ExpenseSum;
import com.gulshan.expensetracker.model.Expense;
import com.gulshan.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Iterable<Expense> getExpense(){
        Iterable<Expense> expenseRepositoryAll = expenseRepository.findAll();
        return expenseRepositoryAll;
    }

    public Expense saveExpense(Expense expense){
        LocalDate currentDate = LocalDate.now();
        expense.setDateOfRecord(currentDate);
        expense.setCurrentMonth(currentDate.getMonth().toString());
        expense.setCurrentYear(currentDate.getYear());
        return expenseRepository.save(expense);

    }

    public ExpenseSum getSumExpense(){
        return expenseRepository.sumQuantities();
    }
}
