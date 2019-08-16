package com.aaa.group8.serviceimpl;


import com.aaa.group8.dao.PPowerDao;
import com.aaa.group8.entity.TreeNode;
import com.aaa.group8.service.PPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PPowerServiceImpl implements PPowerService {


    @Autowired
    private PPowerDao powerDao;
    @Override
    public Map toLogin(Map map) {
        return powerDao.toLogin(map);
    }

    @Override
    public List<TreeNode> getPowerTreeData() {
        //获取所有数据
        List<TreeNode> list = powerDao.getList();
        //System.out.println(list);
        //定义返回集合
        List<TreeNode> tempList =new ArrayList<>();
        //先查找父节点为0的一级节点,并且放入新拼装数据集合里面
        if(list!=null&&list.size()>0){
            for (TreeNode treeNode : list) {
                if(treeNode.getBl_parentId()==0){//判断是否为根节点
                    tempList.add(treeNode);
                    //判断是一级节点的节点是否有子节点，如果有，使用setChildren方法，设置子节点
                    bindChildrenData(treeNode,list);
                }
            }
        }
        return tempList;
    }

    /**
     * 判断节点有没有孩子，如果有，绑定
     * @param treeNode
     * @param list
     */
    public void bindChildrenData(TreeNode treeNode, List<TreeNode> list){
        //循环集合
        List chirldrenList = null;
        for (TreeNode node : list) {
            if(treeNode.getBl_id()==node.getBl_parentId()){//判断当前节点是否是传入节点的孩子
                //查找当前的节点的孩子列表
                List<TreeNode> children = treeNode.getChildren();
                if(children==null||children.size()==0) {//当前节点原来没有孩子
                    chirldrenList = new ArrayList();
                    chirldrenList.add(node);
                    treeNode.setChildren(chirldrenList);
                }else{//当前节点有孩子
                    children.add(node);
                }
                //递归绑定孩子节点
                bindChildrenData(node,list);
            }
        }
    }
    @Override
    public TreeNode getById(int nodeId) {
        return powerDao.getById(nodeId);
    }

    @Override
    public int savePower(TreeNode treeNode) {
        return powerDao.savePower(treeNode) ;
    }

    @Override
    public int deletePower(int nodeId) {
        return powerDao.deletePower(nodeId);
    }

    @Override
    public int updatePower(TreeNode treeNode) {
        return powerDao.updatePower(treeNode);
    }

    @Override
    public List<TreeNode> getLists(Map map) {
        //获取所有数据
        List<TreeNode> list = powerDao.getLists(map);
        //System.out.println(list);
        //定义返回集合
        List<TreeNode> tempList =new ArrayList<>();
        //先查找父节点为0的一级节点,并且放入新拼装数据集合里面
        if(list!=null&&list.size()>0){
            for (TreeNode treeNode : list) {
                if(treeNode.getBl_parentId()==0){//判断是否为根节点
                    tempList.add(treeNode);
                    //判断是一级节点的节点是否有子节点，如果有，使用setChildren方法，设置子节点
                    bindChildrenData(treeNode,list);
                }
            }
        }
        return tempList;
    }
}
