package com.cjl_magistri.protein_tracker.fit;

import com.cjl_magistri.protein_tracker.TrackingService;
import fitlibrary.DoFixture;

/**
 * Created by ljones on 4/12/2015.
 *
 * This class implements the "do fixture" (a script or scenario) on the
 * test page:
 * | set goal | 100 |
 * | add | 5 | times with | 10 |
 * | total is | 50 |
 * | add |1 | times with | 50 |
 * | total is | 100 |
 * | goal is met |
 * | total is | 150 |
 *
 * When run, FitNesse tells us the that these members might be missing:
 * - public Type setGoal(Type1 arg1) { }
 * - public Type addTimesWith(Type1 arg1, Type2 arg2) { }
 * - public Type totalIs(Type1 arg1) { }
 * - public Type goalIsMet() { }
 *
 */
public class TrackingServiceDoFixture extends DoFixture {
    private TrackingService _sut = TrackingServiceSUT.INSTANCE.sut();

    public void setGoal(int value) {
        _sut.setGoal(value);
    }

    public void addTimesWith(int count, int amount) {
        for(int i = 0; i < count; i++) {
            _sut.addProtein(amount);
        }
    }

    public boolean totalIs(int expectedTotal) {
        return (expectedTotal == _sut.getTotal());
    }

    public boolean goalIsMet() {
        return (_sut.isGoalMet());
    }
}
