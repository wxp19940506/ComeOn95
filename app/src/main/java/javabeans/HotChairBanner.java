package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18 0018.
 */

public class HotChairBanner {

    @Override
    public String toString() {
        return "HotChairBanner{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * data : [{"id":1,"bnnerPic":"http://192.168.31.211:8080/laibai/image/banner8.png"},{"id":2,"bnnerPic":"http://192.168.31.211:8080/laibai/image/banner9.png"},{"id":3,"bnnerPic":"http://192.168.31.211:8080/laibai/image/banner21.png"},{"id":4,"bnnerPic":"http://192.168.31.211:8080/laibai/image/banner22.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * id : 1
     * bnnerPic : http://192.168.31.211:8080/laibai/image/banner8.png
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
        private int id;
        private String bnnerPic;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", bnnerPic='" + bnnerPic + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBnnerPic() {
            return bnnerPic;
        }

        public void setBnnerPic(String bnnerPic) {
            this.bnnerPic = bnnerPic;
        }
    }
}
