package com.pendext.asynchronocity.app.db;

import android.content.Context;
import android.database.sqlite.*;

public class ASqliteOpenHelper extends SQLiteOpenHelper {

    public static final String COMMENT_TABLE = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COMMENT_COLUMN = "comment";

    private static final String DATABASE_NAME = "async_comments.sqlite";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_DATABASE = "create table "  + COMMENT_TABLE + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COMMENT_COLUMN + " text not null);";

    public ASqliteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COMMENT_TABLE);
        onCreate(db);
    }

}
