package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/4 0004.
 */

public class GoodImagesData {

    /**
     * data : [{"pic":"http://192.168.31.211:8080/laibai/image/img10_5.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_6.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_7.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_8.png"},{"pic":"http://http://192.168.31.211:8080/laibai/image/img10_9.png"},{"pic":"http://http://192.168.31.211:8080/laibai/image/img10_10.png"},{"pic":"http://http://192.168.31.211:8080/laibai/image/img10_11.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_12.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_13.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_14.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_15.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_16.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_17.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_18.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_19.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_20.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_21.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_22.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_23.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_24.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_25.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_26.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_27.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_28.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_29.png"},{"pic":"http://192.168.31.211:8080/laibai/image/img10_30.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * pic : http://192.168.31.211:8080/laibai/image/img10_5.png
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

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
