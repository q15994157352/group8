package com.aaa.group8.dao;

import com.aaa.group8.entity.TreeNode;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.aaa.group8.entity.TreeNode;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface PRoleDao {
    /**
     * 获取所有角色
     * @param
     * @return
     */
    @Select("select br_id,br_name as label,br_parentid from btb_role")
    List<TreeNode>getPowers();
    /**
     * 根据id查询
     * @param roleId
     * @return
     */
    @Select("select br_id,br_name as label,br_parentid from tb_role where br_id=#{br_id}")
    List<TreeNode> getPowerById(int roleId);
    /**
     * 添加
     * @param treeNode
     * @return
     */
    @SelectKey(statement = "select seq_btb_role_br_id.nextval from dual",keyProperty = "br_id",before = true,resultType = int.class)
    @Insert("insert into btb_role(br_id,br_name,br_parentid) values(#{br_id},#{label},#{br_parentId})")
    int save(TreeNode treeNode);

    /**
     * 更新
     * @param treeNode
     * @return
     */
    @Update("update btb_role set br_name=#{label},br_parentid = #{br_parentId} where br_id=#{br_id}")
    int update(TreeNode treeNode);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from btb_role where br_id=#{br_id}")
    int delete(int id);

    /**
     * 向关联表添加数据
     * @param
     * @param roleId
     * @return
     */
    @Insert("insert into btb_role_limit values(seq_btb_role_limit_brl_id.nextval,#{roleId},#{br_id})")
    int saveRoleAndPower(@Param("br_id") int br_id, @Param("roleId") int roleId);

    /**
     * 根据角色ID删除以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    @Delete("delete from btb_role_limit where br_id=#{br_id}")
    int deletePowersByRoleId(int roleId);

    /**
     * 根据角色ID查询以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    @Select("select bl_id from btb_role_limit where br_id=#{br_id}")
    List<Integer> getPowersByRoleId(int roleId);

    /**
     * 保存用户角色关联表数据
     * @param userId
     * @param roleId
     * @return
     */
    @Insert("insert into btb_user_role values(seq_btb_user_role_bur_id.nextval,#{bu_id},#{br_id})")
    int saveUserAndRole(@Param("userId") int userId,@Param("br_id") int roleId);

    /**
     * 删除该用户原来关联的所有角色
     * @param userId
     * @return
     */
    @Delete("delete from btb_user_role where bu_id=#{bu_id}")
    int deleteRolesByUserId(int userId);

    /**
     * 根据用户id获取角色集合
     * @param userId
     * @return
     */
    @Select("select br_id from btb_user_role where bu_id=#{bu_id}")
    List<Integer> getRolesByUserId(int userId);















//    List<Role> listRole(Map map);
//    /**
//     * 添加用户角色
//     * @param
//     * @return
//     */
//    int saveRole(Role role);
//    /*
//    * 更新用户角色
//    * */
//    int updateRole(Role role);
//    /*
//     *删除用户角色
//     **/
//    int deleteRole(int br_id);

}
