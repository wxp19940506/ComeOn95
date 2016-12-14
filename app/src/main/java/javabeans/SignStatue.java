package javabeans;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class SignStatue {
    private String result;

    @Override
    public String toString() {
        return "SignStatue{" +
                "result='" + result + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
