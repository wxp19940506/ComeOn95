package javabeans;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class StatueData {

    /**
     * result : true
     * id : 8
     */

    private String result;

    @Override
    public String toString() {
        return "StatueData{" +
                "result='" + result + '\'' +
                ", id=" + id +
                '}';
    }

    private int id;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
