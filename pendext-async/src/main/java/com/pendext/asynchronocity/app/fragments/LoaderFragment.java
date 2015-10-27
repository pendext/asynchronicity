package com.pendext.asynchronocity.app.fragments;

import android.app.*;
import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.pendext.asynchronocity.app.R;
import com.pendext.asynchronocity.app.db.*;
import com.pendext.asynchronocity.app.listeners.*;
import com.pendext.asynchronocity.app.model.Comment;
import com.pendext.asynchronocity.app.providers.CommentContentProvider;

import java.net.URL;

public class LoaderFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private SimpleCursorAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.loader_fragment, container, false);

        EditText commentEditText = (EditText) rootView.findViewById(R.id.loader_add_comment);
        Button addCommentButton = (Button) rootView.findViewById(R.id.loader_add_comment_button);
        ListView commentListView = (ListView) rootView.findViewById(R.id.loader_show_comment);
        Button uiWorkButton = (Button) rootView.findViewById(R.id.loader_ui_work);

        addCommentButton.setOnClickListener(new LoaderAddCommentOnClickListener(commentEditText, commentListView));
        uiWorkButton.setOnClickListener(new ButtonForShowingUIThreadIsActiveOnClickListener(getResources().getString(R.string.unblocked_toast_test)));

        getLoaderManager().initLoader(0, null, this);

        CommentDao commentDao = new CommentDao(getActivity().getApplicationContext());

        String[] from = new String[] { ASqliteOpenHelper.COMMENT_COLUMN };
        int[] to = new int[] { R.id.loader_label };
        adapter = new SimpleCursorAdapter(getActivity().getApplicationContext(),
                R.layout.layout_for_loader, commentDao.getCommentCursor(), from, to);

        commentListView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity().getApplicationContext(),
                Uri.parse(CommentContentProvider.URI), null,
                null, null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.changeCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.changeCursor(null);
    }
}
