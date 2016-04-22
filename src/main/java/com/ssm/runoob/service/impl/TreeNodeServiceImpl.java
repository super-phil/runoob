package com.ssm.runoob.service.impl;

import com.ssm.runoob.model.Privilege;
import com.ssm.runoob.model.TreeNode;
import com.ssm.runoob.service.PrivilegeService;
import com.ssm.runoob.service.TreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phil on 2016/4/19.
 */
@Service
public class TreeNodeServiceImpl implements TreeNodeService {
    @Autowired
    private PrivilegeService privilegeService;

    @Override
    public List<TreeNode> getTree(long pid, List<TreeNode> list) {
        List<Privilege> byPID = privilegeService.findByPID(pid);
        if (null != byPID && byPID.size() > 0) {
            for (Privilege privilege : byPID) {
                TreeNode treeNode = new TreeNode();
                treeNode.setId(privilege.getId());
                treeNode.setName(privilege.getName());

                treeNode.setChecked(true);
                treeNode.setChildren(getTree(privilege.getId(), new ArrayList<TreeNode>()));
                list.add(treeNode);
            }
        }
        return list;
    }

}
