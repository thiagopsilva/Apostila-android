package org.example.events;

import static android.provider.BaseColumns._ID;
import static org.example.events.Constants.TABLE_NAME;
import static org.example.events.Constants.TIME;
import static org.example.events.Constants.TITLE;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EventsData extends SQLiteOpenHelper {
   private static final String DATABASE_NAME = "events.db";
   private static final int DATABASE_VERSION = 1;

   /** Create a helper object for the Events database */
   public EventsData(Context ctx) { 
      super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
   }

   @Override
   public void onCreate(SQLiteDatabase db) { 
      db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TIME
            + " INTEGER," + TITLE + " TEXT NOT NULL);");
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, 
         int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(db);
   }
}