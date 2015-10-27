package com.pendext.asynchronocity.app.db;

import android.content.*;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.pendext.asynchronocity.app.model.Comment;

public class CommentDao {

    private SQLiteDatabase sqliteDatabase;
    private ASqliteOpenHelper aSqliteOpenHelper;
    private String[] columns = { ASqliteOpenHelper.COLUMN_ID,
            ASqliteOpenHelper.COMMENT_COLUMN };

    public CommentDao(Context context) {
        aSqliteOpenHelper = new ASqliteOpenHelper(context);
    }

    public void open() throws SQLException {
        sqliteDatabase = aSqliteOpenHelper.getWritableDatabase();
    }

    public void close() {
        aSqliteOpenHelper.close();
    }

    public void publishComment(String commentText) {
        open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ASqliteOpenHelper.COMMENT_COLUMN, commentText);
        sqliteDatabase.insert(ASqliteOpenHelper.COMMENT_TABLE, null, contentValues);
    }

    public Cursor getCommentCursor() {
        Log.i("CommentDao", "getCommentCursor called");
        open();
        Cursor cursor = sqliteDatabase.query(ASqliteOpenHelper.COMMENT_TABLE,
                columns, ASqliteOpenHelper.COLUMN_ID, null,
                null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    public Cursor getCommentCursorWithWait() {
        Log.i("CommentDao", "getCommentCursorWithWait called");
        try {
            Log.i("CommentDao", "Thread.sleep called");
            Thread.sleep(10000);
        } catch (InterruptedException e) { }
        open();
        Cursor cursor = sqliteDatabase.query(ASqliteOpenHelper.COMMENT_TABLE,
                columns, ASqliteOpenHelper.COLUMN_ID, null,
                null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

}
