package kataryna.dmytro.leodictionary.model.data;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dmytroKataryna on 13.03.16.
 */
public class LeoWord {

    @SerializedName("FIELD1")
    private String wordEng;

    @SerializedName("FIELD2")
    private String wordRu;

    @SerializedName("FIELD3")
    private String img;

    @SerializedName("FIELD4")
    private String transcription;

    @SerializedName("FIELD5")
    private String description;

    @SerializedName("FIELD6")
    private String sound;

    @SerializedName("FIELD7")
    private String wordUkr;

    private boolean isLearned;
    private boolean isTranslateShown;

    public LeoWord() {
    }

    public LeoWord(String wordEng, String wordRu, String img, String transcription, String description, String sound) {
        this.wordEng = wordEng;
        this.wordRu = wordRu;
        this.img = img;
        this.transcription = transcription;
        this.description = description;
        this.sound = sound;
    }

    public LeoWord(String wordEng, String wordRu, String img, String transcription, String description, String sound, String wordUkr) {
        this.wordEng = wordEng;
        this.wordRu = wordRu;
        this.img = img;
        this.transcription = transcription;
        this.description = description;
        this.sound = sound;
        this.wordUkr = wordUkr;
    }

    public String getWordEng() {
        return wordEng;
    }

    public void setWordEng(String wordEng) {
        this.wordEng = wordEng;
    }

    public String getWordRu() {
        return wordRu;
    }

    public void setWordRu(String wordRu) {
        this.wordRu = wordRu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getWordUkr() {
        if (TextUtils.isEmpty(wordUkr))
            return wordRu;
        return wordUkr;
    }

    public void setWordUkr(String wordUkr) {
        this.wordUkr = wordUkr;
    }

    public boolean isLearned() {
        return isLearned;
    }

    public void setLearned(boolean learned) {
        isLearned = learned;
    }

    public boolean isTranslateShown() {
        return isTranslateShown;
    }

    public void setTranslateShown(boolean translateShown) {
        isTranslateShown = translateShown;
    }
}
