package com.example.gdms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DATABASE = "GasDB";
    private static final String TABLE_NAME_1 = "customer";
    private static final String TABLE_NAME_2 = "payment";

    // customer table's column names
    private static final String CID = "cid";
    private static final String C_NAME = "c_name";
    private static final String C_NIC = "c_nic";
    private static final String C_CONTACT = "c_contact";
    private static final String C_EMAIL = "c_email";
    private static final String C_ADD = "c_add";
    private static final String PASS = "pass";
    private static final String REPASS = "re_Pass";

    // payment table's column names

    private static final String PID = "pid";
    private static final String H_NAME = "h_name";
    private static final String C_NUMBER = "c_number";
    private static final String EXP_DATE = "exp_date";
    private static final String CVV = "cvv";



    public DBManager(@Nullable Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // customer table create query
        String TABLE_CUSTOMER_QUERY = "CREATE TABLE "+TABLE_NAME_1+" " +
                "("
                +CID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +C_NAME + " TEXT,"
                +C_NIC + " TEXT,"
                +C_CONTACT + " TEXT,"
                +C_EMAIL+ " TEXT,"
                +C_ADD + " TEXT,"
                +PASS + " TEXT,"
                +REPASS+" TEXT" +
                ");";

        // run the create query
        db.execSQL(TABLE_CUSTOMER_QUERY);

        // payment table create query
        String TABLE_PAYMENT_QUERY = "CREATE TABLE "+TABLE_NAME_2+" " +
                "("
                +PID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +H_NAME + " TEXT,"
                +C_NUMBER + " TEXT,"
                +EXP_DATE + " TEXT,"
                +CVV+" TEXT" +
                ");";

        // run the create query
        db.execSQL(TABLE_PAYMENT_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        // drop table query for customer table
        String DROP_TABLE_QUERY_1 = "DROP TABLE IF EXISTS " + TABLE_NAME_1;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY_1);

        // drop table query for payment table
        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME_2;
        //drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);

    }

    // method for customer registration
    public Boolean CustomerRegistration(Customer customer) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(C_NAME, customer.getName());
        contentValues.put(C_NIC, customer.getNic());
        contentValues.put(C_CONTACT, customer.getContact());
        contentValues.put(C_EMAIL, customer.getEmail());
        contentValues.put(C_ADD, customer.getAddress());
        contentValues.put(PASS, customer.getPassword());
        contentValues.put(REPASS, customer.getRePassword());

        long result = sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);

        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // method for validate email address
    public Boolean ValidateEmail(String email) {

        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("SELECT * FROM customer WHERE c_email = ?",new String[] {email});

        if(cursor.getCount() > 0) {

            return true;
        }
        else {

            return false;
        }
    }

    // method for validate email and password together
    public boolean ValidateCustomer(String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM customer WHERE c_email = ? and pass = ?", new String[] {email, password});

        if(cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }

    }

    // method for payment
    public Boolean PayNow(Pay pay) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(H_NAME, pay.getCardOwner());
        contentValues.put(C_NUMBER, pay.getCrdNumber());
        contentValues.put(EXP_DATE, pay.getExpDate());
        contentValues.put(CVV, pay.getCvv());

        long result = sqLiteDatabase.insert(TABLE_NAME_2, null, contentValues);

        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // method for refund
    public boolean RefundPayment(String pay_id) {

        SQLiteDatabase db = getWritableDatabase();

        long result = db.delete(TABLE_NAME_2, "pid = ?", new String[] {pay_id});

        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // method for forgotten password
    public boolean ForgottenPassword(Customer customer){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        //contentValues.put(C_EMAIL, customer.getEmail());
        contentValues.put(PASS, customer.getPassword());


        int status = db.update(TABLE_NAME_1,contentValues,C_EMAIL +" =?", new String[]{String.valueOf(String.valueOf(customer.getId()))});

        if(status > 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
