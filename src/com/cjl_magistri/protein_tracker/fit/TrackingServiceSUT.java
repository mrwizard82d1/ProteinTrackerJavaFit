package com.cjl_magistri.protein_tracker.fit;

import com.cjl_magistri.protein_tracker.TrackingService;

/**
 * Created by ljones on 4/11/2015.
 *
 * This class simplifies some testing tasks such as retaining state
 * between test runs.
 *
 * I have made it an enum as recommended by John Somnez in the
 * Pluralsight module 2.
 *
 */
public enum TrackingServiceSUT {
    // Only contains a single enumeration.
    INSTANCE;

    // Java enums can have state, ....
    private static TrackingService _trackingService = new TrackingService();

    // ... a method to return the subject under test, ...
    public TrackingService sut() {
        return _trackingService;
    }

    // ... and to reset the SUT to a new instance.
    public void reset() {
        _trackingService = new TrackingService();
    }
}
