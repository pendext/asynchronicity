package com.pendext.asynchronocity.app.db;

import android.content.*;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;
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
//        Cursor cursor = sqliteDatabase.query(ASqliteOpenHelper.COMMENT_TABLE,
//                columns, ASqliteOpenHelper.COLUMN_ID + " = " + insertId, null,
//                null, null, null);
//        cursor.moveToFirst();
//        Comment newComment = cursorToComment(cursor);
//        cursor.close();
    }

    public Cursor getCommentCursor() {
        open();
        Cursor cursor = sqliteDatabase.query(ASqliteOpenHelper.COMMENT_TABLE,
                columns, ASqliteOpenHelper.COLUMN_ID, null,
                null, null, null);
        cursor.moveToFirst();
//        cursor.close();
        return cursor;
    }

    private Comment cursorToComment(Cursor cursor) {
        Comment comment = new Comment();
        comment.setId(cursor.getLong(0));
        comment.setText(cursor.getString(1));
        return comment;
    }

}
