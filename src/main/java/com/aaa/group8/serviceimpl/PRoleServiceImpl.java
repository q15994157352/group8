package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.PRoleDao;
import com.aaa.group8.entity.TreeNode;
import com.aaa.group8.service.PRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PRoleServiceImpl implements PRoleService {
    @Autowired
    private PRoleDao pRoleDao;

    @Override
    public List<TreeNode> getPowers() {
        //获取列表
        List<TreeNode> powers = pRoleDao.getPowers();
        //System.out.println(powers.size());
        //定义临时集合，用于存放拼装后的树数据
        List<TreeNode> tmpTreeData = new ArrayList<TreeNode>();
        //判断
        if (powers != null && powers.size() > 0) {
            for (TreeNode power : powers) {
                //判断是否是一级节点
                if (power.getBr_parentId() == 0) {
                    power.setParentName("根节点");
                    tmpTreeData.add(power);
                    //查找孩子并且绑定
                    bindChildren(power, powers);
                }
            }
        }
        return tmpTreeData;
    }

    private void bindChildren(TreeNode treeNode, List<TreeNode> powers) {
        List<TreeNode> tmpChildrens = null;
        //treeNode=系统管理  .getId() =1  系统配置 角色管理 权限管理
        for (TreeNode power : powers) {
            if (treeNode.getBr_id() == power.getBr_parentId()) {//如果节点的父节点等于当前节点的id,该节点就是当前节点的孩子
                power.setParentName(treeNode.getLabel());
                List<TreeNode> childrens = treeNode.getChildren();
                //添加第一个孩子时,要判断是否已经存在孩子
                if (childrens == null || childrens.size() == 0) {
                    tmpChildrens = new ArrayList<>();
                    tmpChildrens.add(power);
                    treeNode.setChildren(tmpChildrens);
                } else {
                    childrens.add(power);
                }
                //递归调用自己查找孩子并且绑定
                bindChildren(power, powers);
            }
        }
    }

    @Override
    public TreeNode getPowerById(int powerId) {
        List<TreeNode> powerList = pRoleDao.getPowerById(powerId);
        if (powerList != null && powerList.size() > 0) {
            return powerList.get(0);
        }
        return null;
    }

    @Override
    public int save(TreeNode treeNode, HttpSession session) {
            // treeNode.setAddUserName(((Map)session.getAttribute("emp")).get("username")+"");
            String nodeIds = treeNode.getUrl();//1,7,8,2,9,10
            String[] nodeIdsArr = nodeIds.split(",");
            System.out.println("................selectKey赋值之前:" + treeNode.getBr_id());
            //保存新加的角色信息，并且返回该角色id
            int result = pRoleDao.save(treeNode);
            System.out.println("................自增后的ID为:" + result + "," + treeNode.getBr_id());
            //为新角色添加关联
            for (String nodeId : nodeIdsArr) {
                pRoleDao.saveRoleAndPower(Integer.valueOf(nodeId), treeNode.getBr_id());
            }
            return result;
        }
    @Override
    public int update(TreeNode treeNode) {
        String nodeIds = treeNode.getUrl();//1,7,8,2,9,10
        String[] nodeIdsArr = nodeIds.split(",");
        //treeNode.getId() 获取当前角色id
        //删除原来该角色关联的所有权限
        pRoleDao.deletePowersByRoleId(treeNode.getBr_id());
        //保存角色信息
        int i=  pRoleDao.update(treeNode);
        //添加新的关联
        for (String nodeId : nodeIdsArr) {
            pRoleDao.saveRoleAndPower(Integer.valueOf(nodeId),treeNode.getBr_id());
        }
        return i;
    }


    @Override
    public int delete(int id) {
        return pRoleDao.delete(id);
    }



    @Override
    public List<Integer> getPowersByRoleId(int roleId) {
        return pRoleDao.getPowersByRoleId(roleId);
    }

    @Override
    public List<Integer> getRolesByUserId(int userId) {
        return pRoleDao.getRolesByUserId(userId);
    }


//
//    @Override
//    public List<Role> listRole(Map map) {
//        return pRoleDao.listRole(map);
//    }
//
//    @Override
//    public int saveRole(Role role) {
//        return pRoleDao.saveRole(role);
//    }
//
//    @Override
//    public int updateRole(Role role) {
//        return pRoleDao.updateRole(role);
//    }
//
//    @Override
//    public int deleteRole(int br_id) {
//        return pRoleDao.deleteRole(br_id);
//    }
}
