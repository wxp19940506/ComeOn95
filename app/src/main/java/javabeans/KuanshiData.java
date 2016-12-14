package javabeans;

import java.util.List;

/**
 * Created by Administrator on 2016/11/12 0012.
 */

public class KuanshiData {

    /**
     * data : [{"type":"标准款"},{"type":"龙年限定款"},{"type":"公主款"},{"type":"王子款"}]
     * msg : success
     * error : 0
     */

    private String msg;
    private int error;
    /**
     * type : 标准款
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
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
