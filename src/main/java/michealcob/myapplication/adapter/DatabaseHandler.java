package michealcob.myapplication.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;

import michealcob.myapplication.model.Localarm;

/**
 * Created by michealcob on 1/9/18.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "localarmManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "localarm";

    // Contacts Table Columns names
    private static final String KEY_TITLE = "title";
    private static final String KEY_MY_LOCATION_LAT = "myLocationLat";
    private static final String KEY_MY_LOCATION_LNG = "myLocationLng";
    private static final String KEY_MY_DESTINATION_LAT = "myDestinationLat";
    private static final String KEY_MY_DESTINATION_LNG = "myDestinationLng";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_TITLE+ " TEXT,"
                /*+ KEY_MY_LOCATION_LAT + " TEXT,"
                + KEY_MY_LOCATION_LNG + " TEXT,"*/
                + KEY_MY_DESTINATION_LAT + " TEXT,"
                + KEY_MY_DESTINATION_LNG + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addTask(Localarm localarm) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, localarm.getTitle()); // Contact Name
        /*values.put(KEY_MY_LOCATION_LAT, localarm.getMyLocationLat()); // Contact Phone
        values.put(KEY_MY_LOCATION_LNG, localarm.getMyLocationLng());*/
        values.put(KEY_MY_DESTINATION_LAT, localarm.getMyDestinationLat());
        values.put(KEY_MY_DESTINATION_LNG, localarm.getMyDestinationLng());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Contacts
    public List<Localarm> getAllTasks() {
        List<Localarm> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Localarm contact = new Localarm();
                contact.setTitle(cursor.getString(0));
                /*contact.setMyLocationLat(cursor.getString(1));
                contact.setMyLocationLng(cursor.getString(2));*/
                contact.setMyDestinationLat(cursor.getString(1));
                contact.setMyDestinationLng(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    //here we add the delete functionality
    public void deleteTask(Localarm localarm){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_TITLE + " = ?",
                new String[]{String.valueOf(localarm.getTitle())});
        db.close();
    }
}
