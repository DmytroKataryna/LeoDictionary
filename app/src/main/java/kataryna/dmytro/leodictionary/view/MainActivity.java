package kataryna.dmytro.leodictionary.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import kataryna.dmytro.leodictionary.R;
import kataryna.dmytro.leodictionary.model.data.LeoWord;
import kataryna.dmytro.leodictionary.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mPresenter;
    private WordsAdapter mWordsAdapter;

    @Bind(R.id.toolbar) Toolbar toolbar;

    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();

        mPresenter = new MainPresenter();
        mPresenter.onAttachActivity(savedInstanceState, this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetachActivity();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initViews() {
        setSupportActionBar(toolbar);

        mWordsAdapter = new WordsAdapter(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mWordsAdapter);
    }

    public void setLeoWordList(@NonNull List<LeoWord> feedItemList) {
        mWordsAdapter.setLeoWordList(feedItemList);
        mWordsAdapter.notifyDataSetChanged();
    }

    public void onSettingsClicked(MenuItem item) {
        mPresenter.onToolbarSettingsClicked();
    }
}
