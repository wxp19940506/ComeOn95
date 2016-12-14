package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class GoodTitleData {

    /**
     * data : [{"id":1,"color":"宝石蓝","name":"SIDM/斯迪姆 百变金刚 0-4岁","deposit":2000,"price":2000},{"id":2,"color":"葡萄紫","name":"SIDM/斯迪姆 百变金刚 0-4岁","deposit":2000,"price":2000}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * id : 1
     * color : 宝石蓝
     * name : SIDM/斯迪姆 百变金刚 0-4岁
     * deposit : 2000.0
     * price : 2000.0
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
        private String color;
        private String name;
        private double deposit;
        private double price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getDeposit() {
            return deposit;
        }

        public void setDeposit(double deposit) {
            this.deposit = deposit;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
