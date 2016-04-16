package kataryna.dmytro.leodictionary.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import kataryna.dmytro.leodictionary.R;
import kataryna.dmytro.leodictionary.model.data.LeoWord;

/**
 * Created by dmytroKataryna on 14.03.16.
 */
public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ItemViewHolder> {

    private List<LeoWord> mLeoWordList;
    private Context mContext;

    public WordsAdapter(@NonNull Context context) {
        this.mContext = context;
        this.mLeoWordList = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.leo_word_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.setWordItem(mLeoWordList.get(position));
    }

    @Override
    public int getItemCount() {
        return mLeoWordList.size();
    }

    public void setLeoWordList(@NonNull List<LeoWord> leoWordList) {
        this.mLeoWordList = leoWordList;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LeoWord leoWord;
        private CheckBox mLearnedView;
        private ImageView mImageView;
        private ImageView mSoundView;
        private TextView mWordText;
        private TextView mTranslateText;

        public ItemViewHolder(View view) {
            super(view);
            mLearnedView = (CheckBox) view.findViewById(R.id.checkBox);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
            mSoundView = (ImageView) view.findViewById(R.id.soundImageView);
            mWordText = (TextView) view.findViewById(R.id.wordTextView);
            mTranslateText = (TextView) view.findViewById(R.id.translationTextView);

            mSoundView.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        public void setWordItem(@NonNull LeoWord wordItem) {
            leoWord = wordItem;
            mWordText.setText(leoWord.getWordEng());
            mTranslateText.setText(leoWord.isTranslateShown() ? leoWord.getWordUkr() : "Translation");
            mLearnedView.setChecked(leoWord.isLearned());
            Picasso.with(mContext).load(leoWord.getImg()).fit().into(mImageView);
        }

        @Override
        public void onClick(View v) {
            //TODO анімавона показати переклад
            leoWord.setTranslateShown(!leoWord.isTranslateShown());
            mTranslateText.setText(leoWord.isTranslateShown() ? leoWord.getWordUkr() : "Translation");
            //TODO можливо треба нотіфайнути item

            //TODO Also set listener on sound item and play audio
        }
    }
}
