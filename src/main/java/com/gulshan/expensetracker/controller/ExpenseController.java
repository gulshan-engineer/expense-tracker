package com.gulshan.expensetracker.controller;


import com.gulshan.expensetracker.dto.ExpenseSum;
import com.gulshan.expensetracker.model.Expense;
import com.gulshan.expensetracker.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    @GetMapping(path="/expense", produces = "application/json")
    public Iterable<Expense> getExpense(){
       return expenseService.getExpense();
    }

    @PostMapping(path= "/expense", consumes = "application/json", produces = "application/json" )
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense){
        log.info("Expense"+ expense);
        Expense save = expenseService.saveExpense(expense);
        return new ResponseEntity<Expense>(save, HttpStatus.OK);
    }

    @GetMapping(path="/getSumExpense", produces = "application/json")
    public ResponseEntity<ExpenseSum> getSum(){
        ExpenseSum sum = expenseService.getSumExpense();

        return new ResponseEntity<>(sum,  HttpStatus.OK);
    }
}
