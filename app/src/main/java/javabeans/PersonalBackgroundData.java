package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/14 0014.
 */

public class PersonalBackgroundData {

    /**
     * data : [{"backPic":"http://192.168.31.211:8080/laibai/image/bg1.png"},{"backPic":"http://192.168.31.211:8080/laibai/image/bg2.png"},{"backPic":"http://192.168.31.211:8080/laibai/image/bg3.png"},{"backPic":"http://192.168.31.211:8080/laibai/image/bg4.png"},{"backPic":"http://192.168.31.211:8080/laibai/image/bg5.png"},{"backPic":"http://192.168.31.211:8080/laibai/image/bg6.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "PersonalBackgroundData{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * backPic : http://192.168.31.211:8080/laibai/image/bg1.png
     */

    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String backPic;

        @Override
        public String toString() {
            return "DataBean{" +
                    "backPic='" + backPic + '\'' +
                    '}';
        }

        public String getBackPic() {
            return backPic;
        }

        public void setBackPic(String backPic) {
            this.backPic = backPic;
        }
    }
}
