package com.ssm.runoob.service;

import com.ssm.runoob.model.TreeNode;

import java.util.List;

/**
 * Created by Phil on 2016/4/19.
 */
public interface TreeNodeService {

    /**
     * Gets tree.
     * 根据parent_id 生成tree
     *
     * @param pid  the pid
     * @param list the list
     * @return tree tree
     */
    List<TreeNode> getTree(long pid, List<TreeNode> list);

}
