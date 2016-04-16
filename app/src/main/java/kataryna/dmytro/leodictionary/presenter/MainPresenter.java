package kataryna.dmytro.leodictionary.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kataryna.dmytro.leodictionary.LeoDictionaryApplication;
import kataryna.dmytro.leodictionary.model.Model;
import kataryna.dmytro.leodictionary.model.ModelImpl;
import kataryna.dmytro.leodictionary.model.data.LeoWord;
import kataryna.dmytro.leodictionary.view.MainActivity;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

/**
 * Created by dmytroKataryna on 14.03.16.
 */
public class MainPresenter {

    private MainActivity mActivity;
    private Subscription subscription = Subscriptions.empty();

    public MainPresenter() {
    }

    public void onAttachActivity(@NonNull Bundle savedInstanceState, @NonNull MainActivity activity) {
        mActivity = activity;
        loadData();
    }

    public void onDetachActivity() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        mActivity = null;
    }

    public void onToolbarSettingsClicked() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = LeoDictionaryApplication.get().getData().subscribe(new Action1<List<LeoWord>>() {
            @Override
            public void call(List<LeoWord> leoWordList) {
                updateUI(leoWordList);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e("TAGA", throwable.getMessage());
            }
        });

    }

    private void loadData() {
        updateUI(new ArrayList<LeoWord>());
    }

    private void updateUI(@NonNull final List<LeoWord> leoWordList) {
        if (mActivity != null) {
            mActivity.setLeoWordList(leoWordList);
        }
    }
}
