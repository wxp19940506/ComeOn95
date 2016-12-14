package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/12 0012.
 */

public class GuiGeData {

    /**
     * data : [{"rule":"默认"},{"rule":"20公斤级"},{"rule":"30公斤级"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * rule : 默认
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
        private String rule;

        public String getRule() {
            return rule;
        }

        public void setRule(String rule) {
            this.rule = rule;
        }
    }
}
