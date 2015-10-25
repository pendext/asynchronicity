package com.pendext.asynchronocity.app.providers;

import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import com.pendext.asynchronocity.app.db.CommentDao;

public class CommentContentProvider extends ContentProvider {

//    private static final UriMatcher matcher = new UriMatcher();

    public static final String URI = "content://com.pendext.asynchronocity.app.providers/comments";

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        CommentDao commentDao = new CommentDao(getContext());
        return commentDao.getCommentCursor();
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
