package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/10/13 0013.
 */

public class HomePagerData {

    private List<String> images;
    private List<String> notice;
    /**
     * url : http://192.168.199.118:8080/TempApi/imgs/home/chair1.png
     * brand : 宝得适
     * title : 双面骑士
     */

    private List<GoodsBean> goods;
    private List<String> modelImage;

    @Override
    public String toString() {
        return "HomePagerData{" +
                "images=" + images +
                ", notice=" + notice +
                ", goods=" + goods +
                ", modelImage=" + modelImage +
                '}';
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getNotice() {
        return notice;
    }

    public void setNotice(List<String> notice) {
        this.notice = notice;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public List<String> getModelImage() {
        return modelImage;
    }

    public void setModelImage(List<String> modelImage) {
        this.modelImage = modelImage;
    }

    public static class GoodsBean {
        private String url;
        private String brand;
        private String title;

        @Override
        public String toString() {
            return "GoodsBean{" +
                    "url='" + url + '\'' +
                    ", brand='" + brand + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
