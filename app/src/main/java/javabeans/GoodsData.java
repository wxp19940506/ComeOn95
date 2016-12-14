package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2 0002.
 */

public class GoodsData {


    /**
     * data : [{"id":1,"name":"SIDM/斯迪姆 百变金刚 0-4岁","mainPic":"http://192.168.31.211:8080/laibai/image/img10.png","fit":"适合0-4岁 体重25公斤以下","fitFace":"适合有isofix接口车型"},{"id":3,"name":"英国 britax/宝得适/百代适 双面骑士Dualfix 0-4岁 可360°旋转","mainPic":"http://192.168.31.211:8080/laibai/image/img12.png","fit":"适合0-4岁 体重25公斤以下","fitFace":"适合有isofix接口车型"},{"id":4,"name":"韩国DAIICHI玳奇 速7Plus 有机面料 0-7岁","mainPic":"http://192.168.31.211:8080/laibai/image/img13.png","fit":"适合0-7岁","fitFace":"适合有isofix接口车型"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * id : 1
     * name : SIDM/斯迪姆 百变金刚 0-4岁
     * mainPic : http://192.168.31.211:8080/laibai/image/img10.png
     * fit : 适合0-4岁 体重25公斤以下
     * fitFace : 适合有isofix接口车型
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
        private String fit;
        private String fitFace;

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

        public String getFit() {
            return fit;
        }

        public void setFit(String fit) {
            this.fit = fit;
        }

        public String getFitFace() {
            return fitFace;
        }

        public void setFitFace(String fitFace) {
            this.fitFace = fitFace;
        }
    }
}
