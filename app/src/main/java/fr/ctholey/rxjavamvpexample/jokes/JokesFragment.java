package fr.ctholey.rxjavamvpexample.jokes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fr.ctholey.rxjavamvpexample.R;
import fr.ctholey.rxjavamvpexample.models.Joke;

/**
 * Created by ctholey on 30/09/2016.
 */

public class JokesFragment extends Fragment implements JokesContract.View {

    @BindView(R.id.listViewTasks) ListView mLvTasks;

    JokesContract.Presenter mPresenter;

    private JokesAdapter mAdapter;

    public JokesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new JokesAdapter(new ArrayList<Joke>(0));
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.jokes_fragment, container);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull JokesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showJokeList(List<Joke> jokeList) {
        mAdapter.updateData(jokeList);
    }

    @Override
    public void handleErrorRetrievingList() {
        Toast.makeText(getActivity(), "Erreur while retrieving the jokes.", Toast.LENGTH_LONG).show();
    }
}
