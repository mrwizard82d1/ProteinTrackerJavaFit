package com.cjl_magistri.protein_tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljones on 4/11/2015.
 */
public class TrackingService {
    private int _total;
    private int _goal;
    private List<HistoryItem> _history;
    private int _historyId;

    public TrackingService() {
        _historyId = 0;
        _history = new ArrayList<HistoryItem>();
    }

    public void addProtein(int amount) {
        _total += amount;
        _history.add(new HistoryItem(_historyId++, amount, "add", _total));
    }

    public void removeProtein(int amount) {
        _total -= amount;
        if (_total < 0) {
            _total = 0;
        }
        _history.add(new HistoryItem(_historyId++, amount, "subtract", _total));
    }

    public int getTotal() {
        return _total;
    }

    public void setGoal(int _goal) {
        this._goal = _goal;
    }

    public boolean isGoalMet() {
        return _total >= _goal;
    }

    public List<HistoryItem> getHistory() {
        return _history;
    }
}
