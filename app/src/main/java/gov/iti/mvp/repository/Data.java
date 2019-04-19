package gov.iti.mvp.repository;

import gov.iti.mvp.presenter.OnSuccessListener;

public class Data {
    private int count;
    private static Data sharedInstance;

    private Data(){
        this.count = 0;

    }
    public static Data getInstance(){
        if(sharedInstance ==null){
            sharedInstance = new Data();
        }
        return sharedInstance;
    }
    //increment count
    public void incrementCount(OnSuccessListener sucessListener) {
        //return count;
        sucessListener.onSuccess();
    }
    public int getCount(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
        return  ++count;
    }

}
