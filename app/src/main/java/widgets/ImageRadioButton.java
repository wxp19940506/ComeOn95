package widgets;

import android.content.Context;
import android.widget.RadioButton;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class ImageRadioButton extends RadioButton {
    private Context context;
    private int id;
    public ImageRadioButton(Context context,int id) {
        super(context);
        this.context = context;
        this.id = id;
    }
}
