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
}
