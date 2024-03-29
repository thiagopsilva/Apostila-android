package org.example.eventsv2;

import android.provider.BaseColumns;
import android.net.Uri;

public interface Constants extends BaseColumns {
   public static final String TABLE_NAME = "events";
   // Columns in the Events database
   public static final String TIME = "time";
   public static final String TITLE = "title";
   public static final String AUTHORITY = "org.example.eventsv2";
   public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);
}