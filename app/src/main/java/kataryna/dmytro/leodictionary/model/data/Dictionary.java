package kataryna.dmytro.leodictionary.model.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dmytroKataryna on 16.04.16.
 */
public class Dictionary {

    @SerializedName("Data")
    private List<LeoWord> data;

    public List<LeoWord> getData() {
        return data;
    }

    public void setData(List<LeoWord> data) {
        this.data = data;
    }
}
