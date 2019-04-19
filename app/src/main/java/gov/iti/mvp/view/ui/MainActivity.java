package gov.iti.mvp.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gov.iti.mvp.R;
import gov.iti.mvp.contracts.IPresenter;
import gov.iti.mvp.contracts.IView;
import gov.iti.mvp.presenter.SimplePresenter;

public class MainActivity extends AppCompatActivity implements IView {

    Button incrementBtn;
    TextView textView;
    IPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new SimplePresenter(this);
        incrementBtn = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.changeValue();
            }
        });
    }

    @Override
    public void incrementCount(int value) {

        textView.setText(Integer.toString(value));
    }

    @Override
    public void onFailure() {
        textView.setText("cannot load data");
    }
}
