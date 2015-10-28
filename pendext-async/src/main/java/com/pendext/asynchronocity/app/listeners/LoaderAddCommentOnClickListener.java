package com.pendext.asynchronocity.app.listeners;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.pendext.asynchronocity.app.db.CommentDao;
import com.pendext.asynchronocity.app.providers.CommentContentProvider;

public class LoaderAddCommentOnClickListener implements OnClickListener {

    private EditText editText;
    public CommentDao commentDao;

    public LoaderAddCommentOnClickListener(EditText editText) {
        this.editText = editText;
        commentDao = new CommentDao(editText.getContext());
    }

    @Override
    public void onClick(View v) {
        String commentText = editText.getText().toString();
        commentDao.publishComment(commentText);
        editText.getContext().getContentResolver().notifyChange(Uri.parse(CommentContentProvider.URI), null);
        editText.setText("");
    }
}
