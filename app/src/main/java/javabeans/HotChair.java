package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18 0018.
 */

public class HotChair {

    /**
     * data : [{"id":1,"name":"SIDM/斯迪姆 百变金刚 0-4岁","mainPic":"http://192.168.31.211:8080/laibai/image/img10.png","deposit":2000},{"id":2,"name":"德国 kiddy/奇蒂 佳宝巢 kiddy nest 0-15个月提篮","mainPic":"http://192.168.31.211:8080/laibai/image/img11.png","deposit":700},{"id":3,"name":"英国 britax/宝得适/百代适 双面骑士Dualfix 0-4岁 可360°旋转","mainPic":"http://192.168.31.211:8080/laibai/image/img12.png","deposit":4000},{"id":4,"name":"韩国DAIICHI玳奇 速7Plus 有机面料 0-7岁","mainPic":"http://192.168.31.211:8080/laibai/image/img13.png","deposit":5000},{"id":5,"name":"英国 ledibaby 美国队长 9个月-12岁","mainPic":"http://192.168.31.211:8080/laibai/image/img14.png","deposit":1500},{"id":6,"name":"德国 kiddy/奇蒂 超能者 9个月-4岁","mainPic":"http://192.168.31.211:8080/laibai/image/img15.png","deposit":1500},{"id":7,"name":"安宝龙 战马 9个月-12岁","mainPic":"http://192.168.31.211:8080/laibai/image/img16.png","deposit":1500},{"id":8,"name":"九五宝座 黑骑士火龙 0-4岁","mainPic":"http://192.168.31.211:8080/laibai/image/img18.png","deposit":2000},{"id":9,"name":"安宝龙 天马A 9个月-4岁","mainPic":"http://192.168.31.211:8080/laibai/image/img19.png","deposit":2000},{"id":10,"name":"SIDM/斯迪姆 阳光超人3-12岁","mainPic":"http://192.168.31.211:8080/laibai/image/img20.png","deposit":2000}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "HotChair{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * id : 1
     * name : SIDM/斯迪姆 百变金刚 0-4岁
     * mainPic : http://192.168.31.211:8080/laibai/image/img10.png
     * deposit : 2000.0
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
        private String name;
        private String mainPic;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", mainPic='" + mainPic + '\'' +
                    ", deposit=" + deposit +
                    '}';
        }

        private double deposit;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMainPic() {
            return mainPic;
        }

        public void setMainPic(String mainPic) {
            this.mainPic = mainPic;
        }

        public double getDeposit() {
            return deposit;
        }

        public void setDeposit(double deposit) {
            this.deposit = deposit;
        }
    }
}
