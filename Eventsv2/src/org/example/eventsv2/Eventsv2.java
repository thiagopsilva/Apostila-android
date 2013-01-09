package org.example.eventsv2;

import static android.provider.BaseColumns._ID;
import static org.example.eventsv2.Constants.CONTENT_URI;
import static org.example.eventsv2.Constants.TIME;
import static org.example.eventsv2.Constants.TITLE;
import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class Eventsv2 extends ListActivity {
   private static String[] FROM = { _ID, TIME, TITLE, };
   private static int[] TO = { R.id.rowid, R.id.time, R.id.title, };
   private static String ORDER_BY = TIME + " DESC";

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_eventsv2);
      addEvent("Hello, Android!");
      Cursor cursor = getEvents();
      showEvents(cursor);
   }

   private void addEvent(String string) {
      // Insert a new record into the Events data source.
      // You would do something similar for delete and update.
      ContentValues values = new ContentValues();
      values.put(TIME, System.currentTimeMillis());
      values.put(TITLE, string);
      getContentResolver().insert(CONTENT_URI, values);
   }

   private Cursor getEvents() {
      // Perform a managed query. The Activity will handle closing
      // and re-querying the cursor when needed.
      return managedQuery(CONTENT_URI, FROM, null, null, ORDER_BY);
   }

   private void showEvents(Cursor cursor) {
      // Set up data binding
      SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
            R.layout.item, cursor, FROM, TO);
      setListAdapter(adapter);
   }
}