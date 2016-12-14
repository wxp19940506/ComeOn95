package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public class PersonShuoData {

    /**
     * data : [{"id":4,"headPic":"http://192.168.31.211:8080/laibai/image/portrait3.png","talkName":"苹果","talkInfo":"昨晚睡觉一直被宝宝吵醒，现在上班困得睁不开眼了","talkInputTime":"Nov 14, 2016 9:33:16 AM","location":"青岛市","zanNum":0,"comNum":0,"pic1":"\"\"","pic2":"\"\"","pic3":"\"\"","pic4":"\"\"","pic5":"\"\"","pic6":"\"\"","pic7":"\"\"","pic8":"\"\"","pic9":"\"\""},{"id":9,"headPic":"http://192.168.31.211:8080/laibai/image/portrait3.png","talkName":"苹果","talkInfo":"宝贝的第一次万圣节趴！","talkInputTime":"Nov 5, 2016 4:24:54 PM","location":"青岛市","zanNum":0,"comNum":0,"pic1":"http://192.168.31.211:8080/laibai/image/img35.png","pic2":"http://192.168.31.211:8080/laibai/image/img36.png","pic3":"http://192.168.31.211:8080/laibai/image/img40.png","pic4":"http://192.168.31.211:8080/laibai/image/img41.png","pic5":"http://192.168.31.211:8080/laibai/image/img42.png","pic6":"http://192.168.31.211:8080/laibai/image/img43.png","pic7":"http://192.168.31.211:8080/laibai/image/img44.png","pic8":"http://192.168.31.211:8080/laibai/image/img45.png","pic9":"http://192.168.31.211:8080/laibai/image/img46.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "PersonShuoData{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * id : 4
     * headPic : http://192.168.31.211:8080/laibai/image/portrait3.png
     * talkName : 苹果
     * talkInfo : 昨晚睡觉一直被宝宝吵醒，现在上班困得睁不开眼了
     * talkInputTime : Nov 14, 2016 9:33:16 AM
     * location : 青岛市
     * zanNum : 0
     * comNum : 0
     * pic1 : ""
     * pic2 : ""
     * pic3 : ""
     * pic4 : ""
     * pic5 : ""
     * pic6 : ""
     * pic7 : ""
     * pic8 : ""
     * pic9 : ""
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", headPic='" + headPic + '\'' +
                    ", talkName='" + talkName + '\'' +
                    ", talkInfo='" + talkInfo + '\'' +
                    ", talkInputTime='" + talkInputTime + '\'' +
                    ", location='" + location + '\'' +
                    ", zanNum=" + zanNum +
                    ", comNum=" + comNum +
                    ", pic1='" + pic1 + '\'' +
                    ", pic2='" + pic2 + '\'' +
                    ", pic3='" + pic3 + '\'' +
                    ", pic4='" + pic4 + '\'' +
                    ", pic5='" + pic5 + '\'' +
                    ", pic6='" + pic6 + '\'' +
                    ", pic7='" + pic7 + '\'' +
                    ", pic8='" + pic8 + '\'' +
                    ", pic9='" + pic9 + '\'' +
                    '}';
        }

        private String headPic;
        private String talkName;
        private String talkInfo;
        private String talkInputTime;
        private String location;
        private int zanNum;
        private int comNum;
        private String pic1;
        private String pic2;
        private String pic3;
        private String pic4;
        private String pic5;
        private String pic6;
        private String pic7;
        private String pic8;
        private String pic9;

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

        public String getTalkName() {
            return talkName;
        }

        public void setTalkName(String talkName) {
            this.talkName = talkName;
        }

        public String getTalkInfo() {
            return talkInfo;
        }

        public void setTalkInfo(String talkInfo) {
            this.talkInfo = talkInfo;
        }

        public String getTalkInputTime() {
            return talkInputTime;
        }

        public void setTalkInputTime(String talkInputTime) {
            this.talkInputTime = talkInputTime;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getZanNum() {
            return zanNum;
        }

        public void setZanNum(int zanNum) {
            this.zanNum = zanNum;
        }

        public int getComNum() {
            return comNum;
        }

        public void setComNum(int comNum) {
            this.comNum = comNum;
        }

        public String getPic1() {
            return pic1;
        }

        public void setPic1(String pic1) {
            this.pic1 = pic1;
        }

        public String getPic2() {
            return pic2;
        }

        public void setPic2(String pic2) {
            this.pic2 = pic2;
        }

        public String getPic3() {
            return pic3;
        }

        public void setPic3(String pic3) {
            this.pic3 = pic3;
        }

        public String getPic4() {
            return pic4;
        }

        public void setPic4(String pic4) {
            this.pic4 = pic4;
        }

        public String getPic5() {
            return pic5;
        }

        public void setPic5(String pic5) {
            this.pic5 = pic5;
        }

        public String getPic6() {
            return pic6;
        }

        public void setPic6(String pic6) {
            this.pic6 = pic6;
        }

        public String getPic7() {
            return pic7;
        }

        public void setPic7(String pic7) {
            this.pic7 = pic7;
        }

        public String getPic8() {
            return pic8;
        }

        public void setPic8(String pic8) {
            this.pic8 = pic8;
        }

        public String getPic9() {
            return pic9;
        }

        public void setPic9(String pic9) {
            this.pic9 = pic9;
        }
    }
}
