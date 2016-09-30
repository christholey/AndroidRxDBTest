package fr.ctholey.rxykoderxjavaexample.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.ctholey.rxykoderxjavaexample.MyApplication;
import fr.ctholey.rxykoderxjavaexample.R;
import fr.ctholey.rxykoderxjavaexample.models.Joke;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.edtUserName)  EditText mEdtUserName;
    @BindView(R.id.edtEmail)  EditText mEdtEmail;
    @BindView(R.id.btnRegister)  Button mBtnRegister;
    @BindView(R.id.btnRandomJoke)  Button mBtnRandomJoke;
    @BindView(R.id.tvJokeDescription)  TextView mTvJokeDescription;
    @BindView(R.id.btnSaveJoke) Button mBtnSaveJoke;

    private CompositeSubscription compositeSubs = new CompositeSubscription();

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
//        ButterKnife.setDebug(true);

        DaggerLoginComponent.builder()
                .loginPresenterModule(new LoginPresenterModule(this))
                .sourceComponent(MyApplication.getInstance().getSourceComponent())
                .build()
                .inject(this);

        setTitle("Login");

        mBtnRandomJoke.setOnClickListener(v -> callChuckNorrisJokeRandom());
        mBtnSaveJoke.setOnClickListener(v -> saveCurrentJoke());
    }

    @Override
    protected void onStart() {
        super.onStart();

        initRGChampsDeSaisie();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        presenter.onDestroy();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = (LoginPresenter) presenter;
    }

    private void callChuckNorrisJokeRandom() {
        mPresenter.callChuckNorrisJokeRandom();
    }

    @Override
    public void handleJokeContent(Joke joke){
        if (null != joke){
            mTvJokeDescription.setText(joke.getJoke());
        }
    }

    private void initRGChampsDeSaisie(){
        final Pattern emailPattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");


//        1ER EXEMPLE
//        Observable<TextViewTextChangeEvent> userNameText = RxTextView.textChangeEvents(mEdtUserName);
//        userNameText.subscribe(e -> Log.d("[Rx]", e.text().toString()));

//        2ND EXEMPLE
//        Observable<TextViewTextChangeEvent> userNameText = RxTextView.textChangeEvents(mEdtUserName);
//        userNameText.filter(e -> e.text().length() > 4)
//                .subscribe(e -> Log.d("[Rx]", e.text().toString()));


//       3
        Observable<Boolean> userNameValid = RxTextView.textChangeEvents(mEdtUserName)
                .map(e -> e.text())
                .map(t -> t.length() > 4);

        compositeSubs.add(
                userNameValid.distinctUntilChanged()
                        .doOnNext(b -> Log.d("[Rx]", "User name " + (b ? "Valid" : "Invalid")))
                        .map(b -> b ? Color.BLACK : Color.RED)
                        .subscribe(color -> mEdtUserName.setTextColor(color))
        );


        Observable<Boolean> emailValid = RxTextView.textChangeEvents(mEdtEmail)
                .map(e -> e.text())
                .map(t -> emailPattern.matcher(t).matches());

        compositeSubs.add(
                emailValid.distinctUntilChanged()
                        .doOnNext(b -> Log.d("[Rx]", "Email " + (b ? "Valid" : "Invalid")))
                        .map(b -> b ? Color.BLACK : Color.RED)
                        .subscribe(color -> mEdtEmail.setTextColor(color))
        );

//      4
        Observable<Boolean> registerEnabled = Observable.combineLatest(userNameValid, emailValid, (a,b) -> a && b);

        compositeSubs.add(
                registerEnabled.distinctUntilChanged()
                        .doOnNext(b -> Log.d("[Rx]", "Button " + (b ? "Enabled" : "Disabled")))
                        .subscribe(btnEnabled -> mBtnRegister.setEnabled(btnEnabled))
        );
    }

    private void saveCurrentJoke() {

        String joke = mTvJokeDescription.getText().toString();
        mPresenter.saveJoke(joke);

    }

    @Override
    public void handleJokeSuccessfullySaved() {
        Toast.makeText(this, "Joke saved !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleJokeSavedError(Throwable error) {
        Toast.makeText(this, "error saving joke :\n" + error.getMessage(), Toast.LENGTH_LONG).show();
    }

}