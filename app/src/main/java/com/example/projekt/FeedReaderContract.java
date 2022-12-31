package com.example.projekt;


import android.provider.BaseColumns;

public final class FeedReaderContract {

    private FeedReaderContract(){}

    public static class FeedEntry implements BaseColumns{

        public static final String COMPUTER_NAME = "komputer";
        public static final String COMPUTER_ID = "komputer_id";
        public static final String KEYBOARD_NAME = "klawiatura";
        public static final String KEYBOARD_ID = "klawiatura_id";
        public static final String MICE_NAME = "myszka";
        public static final String MICE_ID = "myszka_id";
        public static final String MONITOR_NAME = "monitor";
        public static final String MONITOR_ID = "monitor_id";
        public static final String ORDER = "order";
        public static final String ORDER_ID = "order_id";
        public static final String ITEM_NAME = "item_name";
        public static final String ORDERS_COLUMN_KEYBOARD_ID = "keyboard_id";
        public static final String ORDERS_COLUMN_MOUSE_ID = "mouse_id";
        public static final String ORDERS_COLUMN_MONITOR_ID = "monitor_id";
        public static final String ORDERS_COLUMN_COMPUTER_ID = "computer_id";
    }

}


