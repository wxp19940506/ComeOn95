package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/10/29 0029.
 */

public class GridData {
    @Override
    public String toString() {
        return "GridData{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * data : [{"id":2,"menuName":"贝壳捐赠","menuPic":"192.168.199.114:8080/laibai/image/icon1.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * id : 2
     * menuName : 贝壳捐赠
     * menuPic : 192.168.199.114:8080/laibai/image/icon1.png
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
        private String menuPic;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", menuName='" + menuName + '\'' +
                    ", menuPic='" + menuPic + '\'' +
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

        public String getMenuPic() {
            return menuPic;
        }

        public void setMenuPic(String menuPic) {
            this.menuPic = menuPic;
        }
    }
}
