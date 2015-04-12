package com.cjl_magistri.protein_tracker.fit;

import fitlibrary.SetUpFixture;

/**
 * Created by ljones on 4/12/2015.
 *
 * This class initialize the tracking service prior to executing tests.
 *
 */
public class TrackingServiceSetupFixture extends SetUpFixture {
    public void reset (boolean isResetting) {
        if (isResetting) {
            TrackingServiceSUT.INSTANCE.reset();
        }
    }
}
