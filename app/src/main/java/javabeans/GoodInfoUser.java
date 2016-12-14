package javabeans;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class GoodInfoUser {

    /**
     * location : 火星
     * zanNum : 0
     * commentNum : 0
     * headPic : http://192.168.31.211:8080/laibai/image/portrait1.png
     * name : 英雄王
     * inputTime : Nov 1, 2016 11:51:19 AM
     */

    private ObjBean obj;

    @Override
    public String toString() {
        return "GoodInfoUser{" +
                "obj=" + obj +
                ", msg='" + msg + '\'' +
                ", error=" + error +
                '}';
    }

    /**
     * obj : {"location":"火星","zanNum":0,"commentNum":0,"headPic":"http://192.168.31.211:8080/laibai/image/portrait1.png","name":"英雄王","inputTime":"Nov 1, 2016 11:51:19 AM"}
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
        private String location;
        private int zanNum;
        private int commentNum;
        private String headPic;
        private String name;
        private String inputTime;

        @Override
        public String toString() {
            return "ObjBean{" +
                    "location='" + location + '\'' +
                    ", zanNum=" + zanNum +
                    ", commentNum=" + commentNum +
                    ", headPic='" + headPic + '\'' +
                    ", name='" + name + '\'' +
                    ", inputTime='" + inputTime + '\'' +
                    '}';
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

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
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

        public String getInputTime() {
            return inputTime;
        }

        public void setInputTime(String inputTime) {
            this.inputTime = inputTime;
        }
    }
}
