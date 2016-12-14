package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/10/29 0029.
 */

public class MenuData {

    /**
     * data : [{"id":1,"menuName":"公益捐赠"},{"id":3,"menuName":"其他","menuPic":"192.168.199.114:8080/laibai/image/icon30.png"},{"id":5,"menuName":"绘本图书","menuPic":"192.168.199.114:8080/laibai/image/icon29.png"},{"id":8,"menuName":"辣妈专区","menuPic":"192.168.199.114:8080/laibai/image/icon28.png"},{"id":12,"menuName":"婴儿用具","menuPic":"192.168.199.114:8080/laibai/image/icon27.png"},{"id":19,"menuName":"服装搭配","menuPic":"192.168.199.114:8080/laibai/image/icon26.png"},{"id":24,"menuName":"安全出行","menuPic":"192.168.199.114:8080/laibai/image/icon25.png"},{"id":28,"menuName":"玩具","menuPic":"192.168.199.114:8080/laibai/image/icon24.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "MenuData{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * id : 1
     * menuName : 公益捐赠
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
        private String menuName;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", menuName='" + menuName + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }
    }
}
