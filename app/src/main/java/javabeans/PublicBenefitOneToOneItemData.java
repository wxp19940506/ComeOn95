package javabeans;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class PublicBenefitOneToOneItemData {

    /**
     * info : 这位面带稚气的男孩叫韩大运，今年七岁了。现读小学二年级。
     * live : 父亲在几年前在工地干活的时候突发意外身亡，留下大运和一个身有残疾的妈妈，家里还有年近八十的爷爷奶奶。现在大运爷爷奶奶住的房子是由政府帮他们盖的两间房子，而大运和残疾妈妈在镇上靠低保租了一间房子艰难度日。
     * sound : 如果你也有一个跟大运同龄的孩子
     加入“我要捐赠”
     让孩子跟大运一起结伴成长
     有了同龄小伙伴的陪伴和爱
     缺乏父爱的大运
     一定也能温馨灿烂的童年
     * link : 联系方式：江苏省徐州市丰县师寨镇程庄村 徐凤侠
     * inputTime : Nov 3, 2016 4:04:36 PM
     * headPic : http://192.168.31.211:8080/laibai/image/charity6.png
     * name : 九五e慈善
     * location : 浙江省 杭州市
     */

    private ObjBean obj;
    /**
     * obj : {"info":"这位面带稚气的男孩叫韩大运，今年七岁了。现读小学二年级。","live":"父亲在几年前在工地干活的时候突发意外身亡，留下大运和一个身有残疾的妈妈，家里还有年近八十的爷爷奶奶。现在大运爷爷奶奶住的房子是由政府帮他们盖的两间房子，而大运和残疾妈妈在镇上靠低保租了一间房子艰难度日。","sound":"如果你也有一个跟大运同龄的孩子\r\n加入\u201c我要捐赠\u201d\r\n让孩子跟大运一起结伴成长\r\n有了同龄小伙伴的陪伴和爱\r\n缺乏父爱的大运\r\n一定也能温馨灿烂的童年","link":"联系方式：江苏省徐州市丰县师寨镇程庄村 徐凤侠","inputTime":"Nov 3, 2016 4:04:36 PM","headPic":"http://192.168.31.211:8080/laibai/image/charity6.png","name":"九五e慈善","location":"浙江省 杭州市"}
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
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

    public static class ObjBean {
        private String info;
        private String live;
        private String sound;
        private String link;
        private String inputTime;
        private String headPic;
        private String name;
        private String location;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getLive() {
            return live;
        }

        public void setLive(String live) {
            this.live = live;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getInputTime() {
            return inputTime;
        }

        public void setInputTime(String inputTime) {
            this.inputTime = inputTime;
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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
