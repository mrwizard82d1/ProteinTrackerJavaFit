package com.cjl_magistri.protein_tracker.slim;

import com.cjl_magistri.protein_tracker.TrackingService;
import com.cjl_magistri.protein_tracker.tests.TrackingServiceSUT;

/**
 * Created by ljones on 4/12/2015.
 *
 * For a Slim fixture, I **do not** need to inherit from any specific
 * class. Instead Slim fixtures rely on reflection and convention to
 * operate correctly.
 *
 * For example, since the decision table contains `amount` and `operation`
 * columns, the Slim client will attempt to invoke the methods `setAmount`
 * and `setOperation`, respectively, with the values of the corresponding
 * table columns.
 *
 * I **do not** need to implement an `enterAmount` method as I did with a
 * FIT column fixture. Instead, by convention, the Slim test runner will
 * execute a method named `execute` **before** it tries to check any
 * column values.
 */
public class CanIAddAndSubtractProteins {
    private TrackingService sut = TrackingServiceSUT.INSTANCE.sut();

    private int amount;
    private String operation;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void execute() {
        if (operation.equals("add")) {
            sut.addProtein(amount);
        } else if (operation.equals("subtract")) {
            sut.removeProtein(amount);
        }
    }

    public int totalIs() {
        return sut.getTotal();
    }
}
