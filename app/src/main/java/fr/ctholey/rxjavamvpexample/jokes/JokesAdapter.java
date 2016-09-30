package fr.ctholey.rxjavamvpexample.jokes;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import fr.ctholey.rxjavamvpexample.models.Joke;

/**
 * Created by ctholey on 30/09/2016.
 */

public class JokesAdapter extends BaseAdapter {

    private List<Joke> mJokeList;

    public JokesAdapter(@NonNull List<Joke> jokeList) {
        this.mJokeList = jokeList;
    }

    @Override
    public int getCount() {
        return mJokeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mJokeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
