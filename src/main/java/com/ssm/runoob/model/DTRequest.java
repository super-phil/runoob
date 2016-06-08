package com.ssm.runoob.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Phil on 2016/3/4.
 */
@Data
@NoArgsConstructor
public class DTRequest implements Serializable {

    private static final long serialVersionUID = 1056725809206873758L;
    private int draw;
    private int start;//开始
    private int length;//长度
    private DTSearch search;//查询参数
    private List<DTOrder> order;
    private List<DTColumn> columns;

    /**
     * 查询参数
     * Gets search.
     *
     * @return the search
     */
    public String getSearch() {
        return search.getValue();
    }

    /**
     * 排序
     *
     * @return the string
     */
    public String getOrder(){
        DTOrder dtOrder = order.get(0);//默认列排序
        return columns.get(dtOrder.getColumn()).getData() + " " + dtOrder.getDir();
    }


}
