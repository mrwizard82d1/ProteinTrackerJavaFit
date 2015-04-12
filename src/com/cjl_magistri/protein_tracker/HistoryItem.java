package com.cjl_magistri.protein_tracker;

/**
 * Created by ljones on 4/11/2015.
 */
public class HistoryItem {
    private final int _historyId;
    private final int _amount;
    private final String _operation;
    private final int _total;

    public HistoryItem(int historyId, int amount, String operator, int total) {
        _historyId = historyId;
        _amount = amount;
        _operation = operator;
        _total = total;
    }
}
