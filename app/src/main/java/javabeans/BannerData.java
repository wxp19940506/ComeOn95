package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public class BannerData {

    /**
     * data : [{"id":1,"bannerPic":"192.168.199.114:8080/laibai/image/banner17.png"},{"id":2,"bannerPic":"192.168.199.114:8080/laibai/image/banner18.png"},{"id":3,"bannerPic":"192.168.199.114:8080/laibai/image/banner19.png"},{"id":4,"bannerPic":"192.168.199.114:8080/laibai/image/banner20.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * id : 1
     * bannerPic : 192.168.199.114:8080/laibai/image/banner17.png
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
        private String bannerPic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBannerPic() {
            return bannerPic;
        }

        public void setBannerPic(String bannerPic) {
            this.bannerPic = bannerPic;
        }
    }
}
