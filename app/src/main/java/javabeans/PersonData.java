package javabeans;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class PersonData {

    /**
     * id : 8
     * headPic : http://192.168.31.211:8080/laibai/image/portrait1.png
     * phone : 18266633548
     * nickName : 玉皇大帝
     * sex : 1
     * birth : 1917-12-29
     * word : 这家伙很懒，一个字符都不留
     * background : http://192.168.31.211:8080/laibai/image/bg1.png
     * shellNum : 0
     * careNum : 0
     * fanNum : 0
     * loveNum : 0
     * buyNum : 0
     * rentNum : 0
     * zanNum : 0
     * talkNum : 0
     * sellNum : 0
     * location : 火星
     */

    private ObjBean obj;
    /**
     * obj : {"id":8,"headPic":"http://192.168.31.211:8080/laibai/image/portrait1.png","phone":"18266633548","nickName":"玉皇大帝","sex":1,"birth":"1917-12-29","word":"这家伙很懒，一个字符都不留","background":"http://192.168.31.211:8080/laibai/image/bg1.png","shellNum":0,"careNum":0,"fanNum":0,"loveNum":0,"buyNum":0,"rentNum":0,"zanNum":0,"talkNum":0,"sellNum":0,"location":"火星"}
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "PersonData{" +
                "obj=" + obj +
                ", msg='" + msg + '\'' +
                ", error=" + error +
                '}';
    }

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
        private int id;
        private String headPic;
        private String phone;
        private String nickName;
        private int sex;
        private String birth;
        private String word;
        private String background;
        private int shellNum;
        private int careNum;
        private int fanNum;
        private int loveNum;
        private int buyNum;
        private int rentNum;
        private int zanNum;
        private int talkNum;
        private int sellNum;
        private String location;

        @Override
        public String toString() {
            return "ObjBean{" +
                    "id=" + id +
                    ", headPic='" + headPic + '\'' +
                    ", phone='" + phone + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", sex=" + sex +
                    ", birth='" + birth + '\'' +
                    ", word='" + word + '\'' +
                    ", background='" + background + '\'' +
                    ", shellNum=" + shellNum +
                    ", careNum=" + careNum +
                    ", fanNum=" + fanNum +
                    ", loveNum=" + loveNum +
                    ", buyNum=" + buyNum +
                    ", rentNum=" + rentNum +
                    ", zanNum=" + zanNum +
                    ", talkNum=" + talkNum +
                    ", sellNum=" + sellNum +
                    ", location='" + location + '\'' +
                    '}';
        }

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getBirth() {
            return birth;
        }

        public void setBirth(String birth) {
            this.birth = birth;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public int getShellNum() {
            return shellNum;
        }

        public void setShellNum(int shellNum) {
            this.shellNum = shellNum;
        }

        public int getCareNum() {
            return careNum;
        }

        public void setCareNum(int careNum) {
            this.careNum = careNum;
        }

        public int getFanNum() {
            return fanNum;
        }

        public void setFanNum(int fanNum) {
            this.fanNum = fanNum;
        }

        public int getLoveNum() {
            return loveNum;
        }

        public void setLoveNum(int loveNum) {
            this.loveNum = loveNum;
        }

        public int getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(int buyNum) {
            this.buyNum = buyNum;
        }

        public int getRentNum() {
            return rentNum;
        }

        public void setRentNum(int rentNum) {
            this.rentNum = rentNum;
        }

        public int getZanNum() {
            return zanNum;
        }

        public void setZanNum(int zanNum) {
            this.zanNum = zanNum;
        }

        public int getTalkNum() {
            return talkNum;
        }

        public void setTalkNum(int talkNum) {
            this.talkNum = talkNum;
        }

        public int getSellNum() {
            return sellNum;
        }

        public void setSellNum(int sellNum) {
            this.sellNum = sellNum;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
