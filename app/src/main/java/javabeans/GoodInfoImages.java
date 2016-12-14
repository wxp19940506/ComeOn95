package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class GoodInfoImages {

    /**
     * data : [{"id":13,"pic":"http://192.168.31.211:8080/laibai/image/car1.png"},{"id":14,"pic":"http://192.168.31.211:8080/laibai/image/car2.png"},{"id":15,"pic":"http://192.168.31.211:8080/laibai/image/car3.png"},{"id":16,"pic":"http://192.168.31.211:8080/laibai/image/car4.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "GoodInfoImages{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * id : 13
     * pic : http://192.168.31.211:8080/laibai/image/car1.png
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
        private String pic;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", pic='" + pic + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
