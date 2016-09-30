package fr.ctholey.rxjavamvpexample.jokes;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    public void updateData(List<Joke> jokes) {
        if (null != jokes){
            mJokeList.clear();
            mJokeList.addAll(jokes);
            notifyDataSetChanged();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if ()


        return null;
    }


    class holder{

        private TextView tvJokeDescription;

        public holder() {
        }

        public TextView getTvJokeDescription() {
            return tvJokeDescription;
        }

        public void setTvJokeDescription(TextView tvJokeDescription) {
            this.tvJokeDescription = tvJokeDescription;
        }
    }


}
