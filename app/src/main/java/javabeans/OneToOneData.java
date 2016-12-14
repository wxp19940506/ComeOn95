package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/5 0005.
 */

public class OneToOneData {

    /**
     * data : [{"id":1,"mainPic":"http://192.168.31.211:8080/laibai/image/pic1.png","title":"父亲意外身亡，和残疾母亲相依为命的坚强男孩","info":"这位面带稚气的男孩叫韩大运，今年七岁了。现读小学二年级。"},{"id":2,"mainPic":"http://192.168.31.211:8080/laibai/image/pic2.png","title":"父亲先天性痴呆，母亲哑巴，由80多岁奶奶抚养长大","info":"这是一位很安静的小姑娘，却有一双澄澈的大眼睛。她叫韩盼盼，今年12岁，现在是小学三年级的一名学生。"},{"id":3,"mainPic":"http://192.168.31.211:8080/laibai/image/pic3.png","title":"务农父亲独自养育三个孩子和患有精神障碍的母亲","info":"这户来自江苏徐州市丰县师寨镇程庄村的家庭一共有三个孩子。姐姐程圆圆今年十一岁，上小学四年级；二姐姐程园成今年九岁，上小学三年级；弟弟程训浩今年五岁，还在读幼儿园。"},{"id":4,"mainPic":"http://192.168.31.211:8080/laibai/image/pic4.png","title":"智障母亲残疾父亲带着三个孩子 全家低保度日","info":"江苏徐州丰县师寨镇程庄，姐姐程潇潇今年14岁，上小学六年级；妹妹程笑笑今年八岁，小学三年级；弟弟程瑞增今年只有三岁。"},{"id":5,"mainPic":"http://192.168.31.211:8080/laibai/image/pic5.png","title":"不幸家庭 三个孩子患先天性轻微智障","info":"这是一个不幸的家庭，哥哥刘国清今年十一岁，现于江苏丰县师寨镇冯屯上小学五年级。由于患有遗传性轻微智障， 不能正常与人沟通，数次被学校逐出校门。妹妹刘梦欣今年四岁，还未上学； 小梅刘梦齐今年只有一岁。"},{"id":6,"mainPic":"http://192.168.31.211:8080/laibai/image/pic6.png","title":"18 岁妈妈生下孩子后孩子父亲人间蒸发","info":"这个家庭比较特殊，姜娅萁今年才18岁，因为家境不好早早辍学在外打工，打工时和结交的男朋友生下了一个女孩，现在才4个月。然而，孩子生下不久之后，孩子父亲就不知所踪，至今联系不上。"},{"id":7,"mainPic":"http://192.168.31.211:8080/laibai/image/pic7.png","title":"父亲得癌症欠下巨额外债 母亲种地照顾双胞胎姐妹","info":"双胞胎姐妹徐曼妮和徐曼于今年十岁，在江苏徐州丰县范楼杨洼村上小学五年级。"},{"id":8,"mainPic":"http://192.168.31.211:8080/laibai/image/pic8.png","title":"母亲癌症花光所有积蓄至今生死未卜","info":"姐姐李娜今年十二岁，现于徐州丰县华山镇季庙村上七年级；弟弟李新乐今年七岁，上小学二年级。"},{"id":9,"mainPic":"http://192.168.31.211:8080/laibai/image/pic9.png","title":"跟着爷爷生活在鸭棚的留守双胞胎姐妹","info":"这是一对可爱的双胞胎姐妹，姐姐李玉娇，妹妹李玉妹，今年十岁，上小学四年级。"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "OneToOneData{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * id : 1
     * mainPic : http://192.168.31.211:8080/laibai/image/pic1.png
     * title : 父亲意外身亡，和残疾母亲相依为命的坚强男孩
     * info : 这位面带稚气的男孩叫韩大运，今年七岁了。现读小学二年级。
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
        private String mainPic;
        private String title;
        private String info;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", mainPic='" + mainPic + '\'' +
                    ", title='" + title + '\'' +
                    ", info='" + info + '\'' +
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

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
