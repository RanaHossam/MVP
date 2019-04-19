package gov.iti.mvp.presenter;

import gov.iti.mvp.contracts.IPresenter;
import gov.iti.mvp.contracts.IView;
import gov.iti.mvp.repository.Data;

public class SimplePresenter implements IPresenter {

    private IView view;
    private Data model;

    public SimplePresenter(IView view) {
        this.view = view;
        model = Data.getInstance();
    }

    @Override
    public void changeValue() { //on result recieved listener (anonymous interface)

        model.incrementCount(new OnSuccessListener(){
            public void onSuccess(){
                view.incrementCount(model.getCount());
            }
            public void onFailure()
            {
                view.onFailure();
            }
        });
    }
}

