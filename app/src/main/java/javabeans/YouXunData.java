package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class YouXunData {

    /**
     * data : [{"id":1,"title":"LEGO乐高积木","mainPic":"http://192.168.31.211:8080/laibai/image/content11.png","info":"激发孩子的智力，并且有利于培养孩子的好奇心","oldPrice":199,"newPrice":142},{"id":2,"title":"智高chicco小飞人骑行车","mainPic":"http://192.168.31.211:8080/laibai/image/content12.png","info":"一路伴随宝宝成长","oldPrice":499,"newPrice":189},{"id":3,"title":"布朗博士玻璃奶瓶晶彩特别版","mainPic":"http://192.168.31.211:8080/laibai/image/content13.png","info":"快乐喂养","oldPrice":142,"newPrice":118},{"id":4,"title":"光华积木百变海陆空","mainPic":"http://192.168.31.211:8080/laibai/image/content14.png","info":"点燃智商 挑战智慧","oldPrice":388,"newPrice":199},{"id":5,"title":"爱迪生叉子勺子套装","mainPic":"http://192.168.31.211:8080/laibai/image/content15.png","info":"高颜值餐具不可辜负","oldPrice":78,"newPrice":59},{"id":6,"title":"台湾华林贝比背带水壶","mainPic":"http://192.168.31.211:8080/laibai/image/content16.png","info":"安全健康\r\n易于清洗","oldPrice":62,"newPrice":58},{"id":7,"title":"壹百分魔法贴纸机","mainPic":"http://192.168.31.211:8080/laibai/image/content17.png","info":"玩法多样\r\n孩子爱不释手","oldPrice":200,"newPrice":139},{"id":8,"title":"日本咪露娃娃","mainPic":"http://192.168.31.211:8080/laibai/image/content18.png","info":"源自日本过家家，会喝奶","oldPrice":299,"newPrice":185}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * id : 1
     * title : LEGO乐高积木
     * mainPic : http://192.168.31.211:8080/laibai/image/content11.png
     * info : 激发孩子的智力，并且有利于培养孩子的好奇心
     * oldPrice : 199.0
     * newPrice : 142.0
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
        private String title;
        private String mainPic;
        private String info;
        private double oldPrice;
        private double newPrice;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMainPic() {
            return mainPic;
        }

        public void setMainPic(String mainPic) {
            this.mainPic = mainPic;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public double getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(double oldPrice) {
            this.oldPrice = oldPrice;
        }

        public double getNewPrice() {
            return newPrice;
        }

        public void setNewPrice(double newPrice) {
            this.newPrice = newPrice;
        }
    }
}
