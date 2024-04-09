package com.programming.techie.controllers;

import com.programming.techie.models.Expense;
import com.programming.techie.services.IExpenseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/expense")
public class ExpenseControllers {

    @Autowired
    private IExpenseServices expenseServices;

    @PostMapping("/create")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseServices.addExpense(expense));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") String id, @RequestBody Expense detalles) {
        return ResponseEntity.ok(expenseServices.updateExpense(id, detalles));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Expense>> getAllExpense() {
        return ResponseEntity.ok(expenseServices.getAllExpense());
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(expenseServices.getExpenseByName(name));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") String id) {
        expenseServices.deleteExpense(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

}
