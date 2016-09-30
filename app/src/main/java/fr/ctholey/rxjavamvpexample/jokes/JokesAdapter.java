package fr.ctholey.rxjavamvpexample.jokes;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fr.ctholey.rxjavamvpexample.R;
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

    public void updateData(List<Joke> jokes) {
        if (null != jokes){
            mJokeList.clear();
            mJokeList.addAll(jokes);
            notifyDataSetChanged();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;

        if (null == convertView){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_item,parent);

            holder = new Holder();
            holder.tvJokeDescription = (TextView) convertView.findViewById(R.id.tvJokeDescription);
            convertView.setTag(holder);
        }
        else {
            holder = (Holder) convertView.getTag();
        }

        Joke joke = mJokeList.get(position);

        if (null != joke){
            holder.tvJokeDescription.setText(joke.getJoke());
        }

        return convertView;
    }


    static class Holder{

        private TextView tvJokeDescription;
    }

}
