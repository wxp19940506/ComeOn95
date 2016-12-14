package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class GoodBannerData {

    @Override
    public String toString() {
        return "GoodBannerData{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * data : [{"pic":"http://192.168.31.211:8080/laibai/image/img10_1.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_2.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_3.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_4.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * pic : http://192.168.31.211:8080/laibai/image/img10_1.png
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
        private String pic;

        @Override
        public String toString() {
            return "DataBean{" +
                    "pic='" + pic + '\'' +
                    '}';
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
