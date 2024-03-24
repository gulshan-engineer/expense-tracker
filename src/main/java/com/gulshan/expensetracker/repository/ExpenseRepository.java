package com.gulshan.expensetracker.repository;


import com.gulshan.expensetracker.dto.ExpenseSum;
import com.gulshan.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query(value = "select sum(amount) totalAmount, sum(case when type=\"Food and Entertainment and Shopping\" then amount else 0 END) amountFoodEntAndShopping, sum(case when type=\"Groceries\" then amount else 0 END)amountGroceries  FROM Expense", nativeQuery = true)
    public ExpenseSum sumQuantities();
}
