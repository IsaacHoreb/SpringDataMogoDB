package com.programming.techie.services.impl;

import com.programming.techie.models.Expense;
import com.programming.techie.repository.ExpenseRepository;
import com.programming.techie.services.IExpenseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServicesImpl implements IExpenseServices {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(Expense expense) {
        Expense local = expenseRepository.insert(expense);
        return local;
    }

    @Override
    public Expense updateExpense(String id, Expense detalles) {

        Expense local = expenseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(String.format("Cannot Find Expense By ID %s", detalles.getId())));

        Expense newExpense = null;

        if (local != null) {

            local.setExpenseName(detalles.getExpenseName());
            local.setExpenseCategory(detalles.getExpenseCategory());
            local.setExpenseAmount(detalles.getExpenseAmount());

            newExpense = expenseRepository.save(local);

            return newExpense;

        }

        return null;
    }

    @Override
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(
                () -> new RuntimeException((String.format(String.format("Cannot Find Expense By NAME %s", name)))));
    }

    @Override
    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
