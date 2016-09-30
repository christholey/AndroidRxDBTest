package fr.ctholey.rxjavamvpexample.jokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import fr.ctholey.rxjavamvpexample.R;

/**
 * Created by ctholey on 30/09/2016.
 */

public class JokesFragment extends Fragment {

    @BindView(R.id.listViewTasks) ListView mLvTasks;



    public JokesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.jokes_fragment, container);




        return super.onCreateView(inflater, container, savedInstanceState);

    }
}
