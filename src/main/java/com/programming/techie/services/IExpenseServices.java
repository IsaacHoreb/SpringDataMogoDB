package com.programming.techie.services;

import com.programming.techie.models.Expense;

import java.util.List;
import java.util.Optional;

public interface IExpenseServices {

    public Expense addExpense(Expense expense);

    public Expense updateExpense(String id, Expense detalles);

    public List<Expense> getAllExpense();

    public Expense getExpenseByName(String name);

    public void deleteExpense(String id);

}
