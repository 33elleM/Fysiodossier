package com.example.steri.fysiodossier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Helper class for manipulating the SQLite database
 * extends {@link SQLiteOpenHelper}
 *
 */



public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "patient.db";

    // Patient table name
    private static final String TABLE_PATIENTS = "patient_table";

    // Patient Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FIRSTNAME = "first_name";
    private static final String KEY_LASTNAME = "last_name";
    private static final String KEY_STREET = "street";
    private static final String KEY_HOUSENR = "house_number";
    private static final String KEY_ZIPCODE = "zip_code";
    private static final String KEY_CITY = "city";
    private static final String KEY_PH_NO = "phone_number";
    private static final String KEY_EMAIL ="email";
    private static final String KEY_BIRTH_DATE = "birth_date";
    private static final String KEY_BSN = "bsn";
    private static final String KEY_INSCOMP = "insurance_company";
    private static final String KEY_INS_NR = "insurance_number";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
          }

    /**
     * Method to create the Patient database
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
//        String CREATE_PATIENT_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_PATIENTS + " ("
//                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_FIRSTNAME + " TEXT, "
//                + KEY_LASTNAME  + " TEXT, " + KEY_STREET + " TEXT, " + KEY_HOUSENR + " TEXT, " + KEY_ZIPCODE + " TEXT, "
//                + KEY_CITY + " TEXT, " + KEY_PH_NO + " TEXT " + ");";

//        db.execSQL(CREATE_PATIENT_TABLE);
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS patient_table " +
                       "(id INTEGER PRIMARY KEY AUTOINCREMENT, first_name TEXT, last_name TEXT, street TEXT, " +
                        "house_number TEXT, zip_code TEXT, city TEXT, phone_number TEXT, email TEXT, birth_date TEXT, bsn TEXT, insurance_company TEXT, insurance_number TEXT)"
                         );
        Log.i("DatabaseHandler", "Database created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENTS);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    /**
     * Method to add a new patient to the Patient database
     * @param firstname patients first name
     * @param lastname patients last name
     * @param street street where patient lives
     * @param houseNumber house number
     * @param city place to live
     * @param phoneNumber phonenumber of te patient
     * @param email email adress of the patient
     * @param birthDate birth date of the patient
     * @param bsn social security number of the patient
     * @param insComp insurance company of the patient
     * @param insNumber insurance number of the patient
     */
    public void addPatient(String firstname, String lastname, String street, String houseNumber, String zipCode, String city,
                           String phoneNumber, String email, String birthDate, String bsn, String insComp, String insNumber) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_FIRSTNAME, firstname); // add patient first name
            contentValues.put(KEY_LASTNAME, lastname);
            contentValues.put(KEY_STREET, street);
            contentValues.put(KEY_HOUSENR, houseNumber);
            contentValues.put(KEY_ZIPCODE, zipCode);
            contentValues.put(KEY_CITY, city);
            contentValues.put(KEY_PH_NO, phoneNumber);
            contentValues.put(KEY_EMAIL, email);
            contentValues.put(KEY_BIRTH_DATE, birthDate);
            contentValues.put(KEY_BSN, bsn);
            contentValues.put(KEY_INSCOMP, insComp);
            contentValues.put(KEY_INS_NR, insNumber);

                // Inserting Row
            db.insert(TABLE_PATIENTS, null, contentValues);
            Log.i("Databasehandler", "patiënt " + firstname + " toegevoegd");


    }


    // Getting single contact
    Patient getPatient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PATIENTS, new String[] { KEY_ID,
                        KEY_FIRSTNAME, KEY_LASTNAME }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Patient patient = new Patient(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2)); //TODO : aanpassen aan constuctor

        cursor.close();
        // return contact
        return patient;
    }

    // Getting All Patients in database
    public List<String> getAllPatients() {
        List<String> patientList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PATIENTS + " ORDER BY " + KEY_LASTNAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Patient patient = new Patient();
                patient.setID(Integer.parseInt(cursor.getString(0)));
                patient.setFirstName(cursor.getString(1));
                patient.setLastName(cursor.getString(2));
                // Adding contact to list
                patientList.add(patient.toString());
            } while (cursor.moveToNext());
        }
//        cursor.close(); // TODO : check of dit goed gaat

        // return contact list
        return patientList;

    }

    // Updating single contact
    public int updateContact(Patient patient) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, patient.getFirstName());
        values.put(KEY_LASTNAME, patient.getLastName());

        // updating row
        return db.update(TABLE_PATIENTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(patient.getID()) });
    }

    // Deleting single contact
    public void deleteContact(Patient patient) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PATIENTS, KEY_ID + " = ?",
                new String[] { String.valueOf(patient.getID()) });
        db.close();
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ TABLE_PATIENTS, null);
        return cursor;
    }

}
