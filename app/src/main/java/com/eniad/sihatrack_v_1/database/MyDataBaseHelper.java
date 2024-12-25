package com.eniad.sihatrack_v_1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.eniad.sihatrack_v_1.models.User;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "SihaTrackDB.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_USER = "user";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_DATE_BIRTH = "date_birth";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_user_table =
                "CREATE TABLE "+ TABLE_USER +
                        " ("+  COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_FIRSTNAME + " TEXT NOT NULL, " +
                        COLUMN_LASTNAME + " TEXT NOT NULL, " +
                        COLUMN_DATE_BIRTH + " TEXT NOT NULL, " +
                        COLUMN_GENDER + " TEXT NOT NULL, " +
                        COLUMN_EMAIL + " TEXT NOT NULL," +
                        COLUMN_PASSWORD + " TEXT NOT NULL);";
        db.execSQL(create_user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FIRSTNAME,user.getFirstname());
        cv.put(COLUMN_LASTNAME,user.getLastname());
        cv.put(COLUMN_DATE_BIRTH,user.getDate_birth());
        cv.put(COLUMN_GENDER,user.getGender());
        cv.put(COLUMN_EMAIL,user.getEmail());
        cv.put(COLUMN_PASSWORD,user.getPassword());
        long result = db.insert(TABLE_USER,null,cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
        }
    }


    public User getUserByEmailAndPassword(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USER +
                " WHERE " + COLUMN_EMAIL + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.rawQuery(query, selectionArgs);
        User user = null;

        if (cursor.moveToFirst()) {
            user = new User(
                    cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRSTNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTNAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE_BIRTH)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENDER)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL)),
                    cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD))
            );
        }

        cursor.close();
        db.close();
        return user;
    }



    public User getUserById(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        User user = null;

        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_ID + " = ?";
        cursor = db.rawQuery(query, new String[]{String.valueOf(userId)});

        if (cursor != null && cursor.moveToFirst()) {
            String firstname = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRSTNAME));
            String lastname = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTNAME));
            String date_birth = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE_BIRTH));
            String gender = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENDER));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD));

            user = new User(firstname, lastname, date_birth, gender, email, password);

        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();

        return user;
    }



}
