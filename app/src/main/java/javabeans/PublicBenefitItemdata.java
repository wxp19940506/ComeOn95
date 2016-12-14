package javabeans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7 0007.
 */

public class PublicBenefitItemdata implements Serializable {


    /**
     * data : [{"mainPic":"http://192.168.31.211:8080/laibai/image/charity2.png","title":"武山县马力镇北顺幼儿园物资捐赠活动","background":"武山县马力镇北顺幼儿园位于武山县马力镇北顺村，为民办公助的学前教育机构，现有幼儿249名，覆盖北顺、北九、北堡、远中、余干、包庄 、柴庄、马庄八个自然村，现有小班二个班，中班二个班，大班二个班，共六个学前教育班。\r\n2012年年初，县政府无偿划拨土地5.48亩,2012年6月1日开工建设，2014年5月完工，2014年6月1日正式开园，坐北朝南的是三层框架结构幼儿园活动楼，建筑面积2200平方米，坐南朝北的是框架结构二层综合楼800平方米，一楼为餐厅，二楼为教师宿舍。活动楼内共有教学活动班9个班，寝室6个，只能暂时满足当时（2012年）需求。","need":"1、益智玩具300件（新旧不限）\r\n2、益智图书300件（新旧不限）","question":"北顺幼儿园服务八个自然村，幼儿入园率为95%（个别随父母打工地入园）入园幼儿保持在250名左右，因教师（尤其是音乐教师）严重缺乏。幼儿在各方面无法发展；应该8个班的小朋友只能挤在6个班；北顺幼儿园急需长期服务老师16名。","sound":"点击\u201c我要参加\u201d，并留下联系方式、孩子姓名、接收地址，待关爱儿童安全基金收到物资后统一将附孩子姓名的爱心证书邮寄给您。","aim":"1、邮寄地址：天津市和平区南京路183号世纪都会商厦办公楼1905\r\n2、联系人：孙琳暄\r\n3、联系电话：18600606856","pic":"http://192.168.31.211:8080/laibai/image/charity2_4.png"},{"mainPic":"http://192.168.31.211:8080/laibai/image/charity2.png","title":"武山县马力镇北顺幼儿园物资捐赠活动","background":"武山县马力镇北顺幼儿园位于武山县马力镇北顺村，为民办公助的学前教育机构，现有幼儿249名，覆盖北顺、北九、北堡、远中、余干、包庄 、柴庄、马庄八个自然村，现有小班二个班，中班二个班，大班二个班，共六个学前教育班。\r\n2012年年初，县政府无偿划拨土地5.48亩,2012年6月1日开工建设，2014年5月完工，2014年6月1日正式开园，坐北朝南的是三层框架结构幼儿园活动楼，建筑面积2200平方米，坐南朝北的是框架结构二层综合楼800平方米，一楼为餐厅，二楼为教师宿舍。活动楼内共有教学活动班9个班，寝室6个，只能暂时满足当时（2012年）需求。","need":"1、益智玩具300件（新旧不限）\r\n2、益智图书300件（新旧不限）","question":"北顺幼儿园服务八个自然村，幼儿入园率为95%（个别随父母打工地入园）入园幼儿保持在250名左右，因教师（尤其是音乐教师）严重缺乏。幼儿在各方面无法发展；应该8个班的小朋友只能挤在6个班；北顺幼儿园急需长期服务老师16名。","sound":"点击\u201c我要参加\u201d，并留下联系方式、孩子姓名、接收地址，待关爱儿童安全基金收到物资后统一将附孩子姓名的爱心证书邮寄给您。","aim":"1、邮寄地址：天津市和平区南京路183号世纪都会商厦办公楼1905\r\n2、联系人：孙琳暄\r\n3、联系电话：18600606856","pic":"http://192.168.31.211:8080/laibai/image/charity2_5.png"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;

    @Override
    public String toString() {
        return "PublicBenefitItemdata{" +
                "msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }

    /**
     * mainPic : http://192.168.31.211:8080/laibai/image/charity2.png
     * title : 武山县马力镇北顺幼儿园物资捐赠活动
     * background : 武山县马力镇北顺幼儿园位于武山县马力镇北顺村，为民办公助的学前教育机构，现有幼儿249名，覆盖北顺、北九、北堡、远中、余干、包庄 、柴庄、马庄八个自然村，现有小班二个班，中班二个班，大班二个班，共六个学前教育班。
     2012年年初，县政府无偿划拨土地5.48亩,2012年6月1日开工建设，2014年5月完工，2014年6月1日正式开园，坐北朝南的是三层框架结构幼儿园活动楼，建筑面积2200平方米，坐南朝北的是框架结构二层综合楼800平方米，一楼为餐厅，二楼为教师宿舍。活动楼内共有教学活动班9个班，寝室6个，只能暂时满足当时（2012年）需求。
     * need : 1、益智玩具300件（新旧不限）
     2、益智图书300件（新旧不限）
     * question : 北顺幼儿园服务八个自然村，幼儿入园率为95%（个别随父母打工地入园）入园幼儿保持在250名左右，因教师（尤其是音乐教师）严重缺乏。幼儿在各方面无法发展；应该8个班的小朋友只能挤在6个班；北顺幼儿园急需长期服务老师16名。
     * sound : 点击“我要参加”，并留下联系方式、孩子姓名、接收地址，待关爱儿童安全基金收到物资后统一将附孩子姓名的爱心证书邮寄给您。
     * aim : 1、邮寄地址：天津市和平区南京路183号世纪都会商厦办公楼1905
     2、联系人：孙琳暄
     3、联系电话：18600606856
     * pic : http://192.168.31.211:8080/laibai/image/charity2_4.png
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
        private String mainPic;
        private String title;
        private String background;
        private String need;
        private String question;
        private String sound;
        private String aim;
        private String pic;

        @Override
        public String toString() {
            return "DataBean{" +
                    "mainPic='" + mainPic + '\'' +
                    ", title='" + title + '\'' +
                    ", background='" + background + '\'' +
                    ", need='" + need + '\'' +
                    ", question='" + question + '\'' +
                    ", sound='" + sound + '\'' +
                    ", aim='" + aim + '\'' +
                    ", pic='" + pic + '\'' +
                    '}';
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

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getNeed() {
            return need;
        }

        public void setNeed(String need) {
            this.need = need;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        public String getAim() {
            return aim;
        }

        public void setAim(String aim) {
            this.aim = aim;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
