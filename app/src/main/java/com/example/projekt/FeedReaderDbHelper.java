package com.example.projekt;

import static com.example.projekt.FeedReaderContract.FeedEntry.COMPUTER_ID;
import static com.example.projekt.FeedReaderContract.FeedEntry.COMPUTER_NAME;
import static com.example.projekt.FeedReaderContract.FeedEntry.ITEM_NAME;
import static com.example.projekt.FeedReaderContract.FeedEntry.KEYBOARD_NAME;
import static com.example.projekt.FeedReaderContract.FeedEntry.MICE_ID;
import static com.example.projekt.FeedReaderContract.FeedEntry.MICE_NAME;
import static com.example.projekt.FeedReaderContract.FeedEntry.MONITOR_ID;
import static com.example.projekt.FeedReaderContract.FeedEntry.MONITOR_NAME;
import static com.example.projekt.FeedReaderContract.FeedEntry.ORDER;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "orders.db";

    private static final String SQL_CREATE_KEYBOARDS =
            "CREATE TABLE " + KEYBOARD_NAME + " (" +
                    FeedReaderContract.FeedEntry.KEYBOARD_ID + " INTEGER PRIMARY KEY, " +
                    ITEM_NAME + " TEXT NOT NULL )";

    private static final String SQL_GET_KEYBOARD_NAME =
            "SELECT " + ITEM_NAME + " FROM " +
                    KEYBOARD_NAME;

    private static final String SQL_GET_KEYBOARDS_NAMES =
            "SELECT " + FeedReaderContract.FeedEntry.KEYBOARD_ID + ", " +
                    FeedReaderContract.FeedEntry.ITEM_NAME + " FROM " +
                    KEYBOARD_NAME;

    private static final String SQL_DELETE_KEYBOARDS =
            "DROP TABLE IF EXISTS " + KEYBOARD_NAME;

    private static final String SQL_INSERT_KEYBOARDS =
            "INSERT INTO " + KEYBOARD_NAME + " VALUES " +
                    "(0, 'Klawiatura1, 200zl'), " +
                    "(1, 'Klawiatura2, 300zl'), " +
                    "(2, 'Klawiatura3, 150zl')";

    private static final String SQL_CREATE_MICE =
            "CREATE TABLE " + MICE_NAME + " (" +
                    MICE_ID + " INTEGER PRIMARY KEY, " +
                    FeedReaderContract.FeedEntry.ITEM_NAME + " TEXT NOT NULL )";

    private static final String SQL_GET_MOUSE_NAME =
            "SELECT " + ITEM_NAME + " FROM " +
                    MICE_NAME;

    private static final String SQL_GET_MICE_NAMES =
            "SELECT " + MICE_ID + ", " +
                    FeedReaderContract.FeedEntry.ITEM_NAME + " FROM " +
                    MICE_NAME;

    private static final String SQL_DELETE_MICE =
            "DROP TABLE IF EXISTS " + MICE_NAME;

    private static final String SQL_INSERT_MICE =
            "INSERT INTO " + MICE_NAME + " VALUES " +
                    "(0, 'Myszka1, 150zl'), " +
                    "(1, 'Myszka2, 300zl'), " +
                    "(2, 'Myszka3, 400zl')";

    private static final String SQL_CREATE_MONITORS =
            "CREATE TABLE " + MONITOR_NAME + " (" +
                    MONITOR_ID + " INTEGER PRIMARY KEY, " +
                    FeedReaderContract.FeedEntry.ITEM_NAME + " TEXT NOT NULL )";

    private static final String SQL_GET_MONITOR_NAME =
            "SELECT " + ITEM_NAME + " FROM " +
                    MONITOR_NAME;

    private static final String SQL_GET_MONITORS_NAMES =
            "SELECT " + MONITOR_ID + ", " +
                    FeedReaderContract.FeedEntry.ITEM_NAME + " FROM " +
                    MONITOR_NAME;

    private static final String SQL_DELETE_MONITORS =
            "DROP TABLE IF EXISTS " + MONITOR_NAME;

    private static final String SQL_INSERT_MONITORS =
            "INSERT INTO " + MONITOR_NAME + " VALUES " +
                    "(0, 'Monitor1, 500zl'), " +
                    "(1, 'Monitor2, 800zl'), " +
                    "(2, 'Monitor3, 1000zl')";

    private static final String SQL_CREATE_COMPUTERS =
            "CREATE TABLE " + COMPUTER_NAME + " (" +
                    COMPUTER_ID + " INTEGER PRIMARY KEY, " +
                    FeedReaderContract.FeedEntry.ITEM_NAME + " TEXT NOT NULL )";

    private static final String SQL_GET_COMPUTER_NAME =
            "SELECT " + ITEM_NAME + " FROM " +
                    COMPUTER_NAME;

    private static final String SQL_GET_COMPUTERS_NAMES =
            "SELECT " + COMPUTER_ID + ", " +
                    FeedReaderContract.FeedEntry.ITEM_NAME + " FROM " +
                    COMPUTER_NAME;

    private static final String SQL_DELETE_COMPUTERS =
            "DROP TABLE IF EXISTS " + COMPUTER_NAME;

    private static final String SQL_INSERT_COMPUTERS =
            "INSERT INTO " + COMPUTER_NAME + " VALUES " +
                    "(0, 'Komputer1, 3500zl'), " +
                    "(1, 'Komputer2, 5000zl'), " +
                    "(2, 'Komputer3, 7800zl'), " +
                    "(3, 'Komputer4, 2000zl')";

    private static final String SQL_CREATE_ORDERS =
            "CREATE TABLE " + ORDER + " (" +
                    FeedReaderContract.FeedEntry.ORDER_ID + " INTEGER PRIMARY KEY, " +
                    FeedReaderContract.FeedEntry.ORDERS_COLUMN_KEYBOARD_ID + " INTEGER, " +
                    FeedReaderContract.FeedEntry.ORDERS_COLUMN_MOUSE_ID + " INTEGER, " +
                    FeedReaderContract.FeedEntry.ORDERS_COLUMN_MONITOR_ID + " INTEGER, " +
                    FeedReaderContract.FeedEntry.ORDERS_COLUMN_COMPUTER_ID + " INTEGER, " +
                    FeedReaderContract.FeedEntry.ORDERS_COLUMN_KEYBOARD_ID + ") REFERENCES " +
                    FeedReaderContract.FeedEntry.KEYBOARD_NAME + "(" +
                    FeedReaderContract.FeedEntry.KEYBOARD_ID + "), FOREIGN KEY (" +
                    FeedReaderContract.FeedEntry.ORDERS_COLUMN_MOUSE_ID + ") REFERENCES " +
                    FeedReaderContract.FeedEntry.MICE_NAME + "(" +
                    MICE_ID + "), FOREIGN KEY (" +
                    FeedReaderContract.FeedEntry.ORDERS_COLUMN_MONITOR_ID + ") REFERENCES " +
                    FeedReaderContract.FeedEntry.MONITOR_NAME + "(" +
                    MONITOR_ID + "), FOREIGN KEY (" +
                    FeedReaderContract.FeedEntry.ORDERS_COLUMN_COMPUTER_ID + ") REFERENCES " +
                    FeedReaderContract.FeedEntry.COMPUTER_NAME + "(" +
                    COMPUTER_ID + ")";

    private static final String SQL_GET_ORDERS =
            "SELECT * FROM " + ORDER;


    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_KEYBOARDS);
        db.execSQL(SQL_CREATE_MICE);
        db.execSQL(SQL_CREATE_MONITORS);
        db.execSQL(SQL_CREATE_COMPUTERS);
        db.execSQL(SQL_CREATE_ORDERS);
        db.execSQL(SQL_INSERT_KEYBOARDS);
        db.execSQL(SQL_INSERT_MICE);
        db.execSQL(SQL_INSERT_MONITORS);
        db.execSQL(SQL_INSERT_COMPUTERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_KEYBOARDS);
        db.execSQL(SQL_DELETE_MICE);
        db.execSQL(SQL_DELETE_MONITORS);
        db.execSQL(SQL_DELETE_COMPUTERS);
        onCreate(db);

    }


    public boolean insertOrder(int orderId, int keyboardId, int mouseId, int monitorId, int computerId) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.ORDER_ID, orderId);

        if (keyboardId < 3) {
            values.put(FeedReaderContract.FeedEntry.ORDERS_COLUMN_KEYBOARD_ID, keyboardId);
        } else {
            values.putNull(FeedReaderContract.FeedEntry.ORDERS_COLUMN_KEYBOARD_ID);
        }

        if (mouseId < 3) {
            values.put(FeedReaderContract.FeedEntry.ORDERS_COLUMN_MOUSE_ID, mouseId);
        } else {
            values.putNull(FeedReaderContract.FeedEntry.ORDERS_COLUMN_MOUSE_ID);
        }

        if (monitorId < 3) {
            values.put(FeedReaderContract.FeedEntry.ORDERS_COLUMN_MONITOR_ID, monitorId);
        } else {
            values.putNull(FeedReaderContract.FeedEntry.ORDERS_COLUMN_MONITOR_ID);
        }

        if (computerId < 4) {
            values.put(FeedReaderContract.FeedEntry.ORDERS_COLUMN_COMPUTER_ID, computerId);
        } else {
            values.putNull(FeedReaderContract.FeedEntry.ORDERS_COLUMN_COMPUTER_ID);
        }

        return true;
    }
}

