package fr.ctholey.rxjavamvpexample.jokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import fr.ctholey.rxjavamvpexample.R;
import fr.ctholey.rxjavamvpexample.utils.ActivityUtils;

/**
 * Created by ctholey on 30/09/2016.
 */

public class JokesActivity extends AppCompatActivity{

    @Inject JokesPresenter presenter;

    public JokesActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jokes);

        JokesFragment jokesFragment = (JokesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentPlaceholder);

        if (null == jokesFragment){
            jokesFragment = new JokesFragment();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), jokesFragment, R.id.fragmentPlaceholder);
        }

    }
}
