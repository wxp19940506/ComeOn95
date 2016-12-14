package javabeans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class GoodInfoPingLun{

    /**
     * data : [{"id":1,"headPic":"http://192.168.31.211:8080/laibai/image/portrait1.png","name":"英雄王","inputTime":"Oct 29, 2016 11:00:27 AM","info":"哎呦，东西不错哦"},{"id":2,"headPic":"http://192.168.31.211:8080/laibai/image/portrait1.png","name":"英雄王","inputTime":"Oct 29, 2016 11:01:01 AM","info":"物美价兼"},{"id":3,"headPic":"http://192.168.31.211:8080/laibai/image/portrait1.png","name":"征服王","inputTime":"Oct 29, 2016 11:01:02 AM","info":"挺好值得购买"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "GoodInfoPingLun{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * id : 1
     * headPic : http://192.168.31.211:8080/laibai/image/portrait1.png
     * name : 英雄王
     * inputTime : Oct 29, 2016 11:00:27 AM
     * info : 哎呦，东西不错哦
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
        private String headPic;
        private String name;
        private String inputTime;
        private String info;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", headPic='" + headPic + '\'' +
                    ", name='" + name + '\'' +
                    ", inputTime='" + inputTime + '\'' +
                    ", info='" + info + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInputTime() {
            return inputTime;
        }

        public void setInputTime(String inputTime) {
            this.inputTime = inputTime;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
