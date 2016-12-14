package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class YouXuanImagesData {

    /**
     * data : [{"id":1,"pic":"http://192.168.31.211:8080/laibai/image/chicco1.png"},{"id":2,"pic":"http://192.168.31.211:8080/laibai/image/chicco2.png"},{"id":3,"pic":"http://192.168.31.211:8080/laibai/image/chicco3.png"},{"id":4,"pic":"http://192.168.31.211:8080/laibai/image/chicco4.png"},{"id":5,"pic":"http://192.168.31.211:8080/laibai/image/chicco5.png"},{"id":6,"pic":"http://192.168.31.211:8080/laibai/image/chicco6.png"},{"id":7,"pic":"http://192.168.31.211:8080/laibai/image/chicco7.png"},{"id":8,"pic":"http://192.168.31.211:8080/laibai/image/chicco8.png"},{"id":9,"pic":"http://192.168.31.211:8080/laibai/image/chicco9.png"},{"id":10,"pic":"http://192.168.31.211:8080/laibai/image/chicco10.png"},{"id":11,"pic":"http://192.168.31.211:8080/laibai/image/chicco11.png"},{"id":12,"pic":"http://192.168.31.211:8080/laibai/image/chicco12.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * id : 1
     * pic : http://192.168.31.211:8080/laibai/image/chicco1.png
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
