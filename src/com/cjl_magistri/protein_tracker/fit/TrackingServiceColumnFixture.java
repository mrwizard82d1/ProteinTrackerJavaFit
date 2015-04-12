package com.cjl_magistri.protein_tracker.fit;

import com.cjl_magistri.protein_tracker.TrackingService;
import com.cjl_magistri.protein_tracker.com.cjl_magistri.protein_tracker.tests.TrackingServiceSUT;
import fit.ColumnFixture;

/**
 * Created by ljones on 4/11/2015.
 *
 * This class is the "link" between the first test described in the wiki
 * page ProteinTrackerFit and the subject under test.
 *
 * This class must extend the Fit class, ColumnFixture. In addition, this
 * class must have public fields corresponding to the names of the
 * wiki columns amount and operation. Finally, it must have public methods
 * corresponding to the column names enterAmount?, and total?
 *
 * The Fit server will set amout and operation to the values in the table
 * in the wiki. It will then invoke enterAmount and total (in left-to-right
 * order - I believe) and verify that the returned values are the values
 * specified in the table.
 *
 */
public class TrackingServiceColumnFixture extends ColumnFixture {
    private TrackingService _sut = TrackingServiceSUT.INSTANCE.sut();

    // FIT, when encountering a value in a column named `amount` will look
    // for a public field named `amount` and will set that member to the
    // value in the `amount` column.
    public int amount;

    // Similarly, when encountering a value in a column named `operation`,
    // FIT will set a **public** field also named `operation`.
    public String operation;

    // When encountering a field with a '?' suffix, FIT will look for a
    // public method with the same name as the column, will invoke that
    // method, and will check that the result of invoking that method is
    // the same value that it finds in the column.
    //
    // Specifically, when encountering a value in the `enterAmount?` column,
    // FIT will invoke the public method `enterAmount` and will check that
    // the value returned by `enterAmount()` equals the value in the column.
    public String enterAmount() {
        if (operation.equals("add")) {
            add();
        } else if (operation.equals("subtract")) {
            subtract();
        }
        return operation;
    }

    // Again, FIT, when it encounters a column named `total?` will invoke
    // the public method named `total` and check that the return value of
    // the method equals the value it finds in the column of the wiki table.
    public int total() {
        return _sut.getTotal();
    }

    private void subtract() {
        _sut.removeProtein(amount);
    }

    private void add() {
        _sut.addProtein(amount);
    }

}
