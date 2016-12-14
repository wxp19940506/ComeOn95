package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5 0005.
 */

public class PublicBenefitData {

    /**
     * data : [{"id":1,"mainPic":"http://192.168.31.211:8080/laibai/image/charity2.png","title":"武山县马力镇北顺幼儿园物资捐赠活动"},{"id":2,"mainPic":"http://192.168.31.211:8080/laibai/image/charity3.png","title":"大凉山+清水河县\u201c爱心书\u201d公益活动"},{"id":3,"mainPic":"http://192.168.31.211:8080/laibai/image/harity4.png","title":"四川省大凉山彝族自治州喜德县五合小学捐助"},{"id":4,"mainPic":"http://192.168.31.211:8080/laibai/image/harity5.png","title":"来呗e起行 九五e慈善爱心捐助"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * id : 1
     * mainPic : http://192.168.31.211:8080/laibai/image/charity2.png
     * title : 武山县马力镇北顺幼儿园物资捐赠活动
     */

    private List<DataBean> data;

    @Override
    public String toString() {
        return "PublicBenefitData{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

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
        private String mainPic;
        private String title;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", mainPic='" + mainPic + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMainPic() {
            return mainPic;
        }

        public void setMainPic(String mainPic) {
            this.mainPic = mainPic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
