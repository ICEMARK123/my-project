package com.wifi.kernel;

/**
 * @Author: lihl01
 * @Date: 2019/10/22 8:14 PM
 * @Describe:
 */
public interface BaseDao<PK, T> {

    /**
     * 通过主键删除
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 插入数据
     * @param record 对象
     * @return insert count
     */
    int insert(T record);

    /**
     * 插入数据
     * @param record 对象
     * @return 插入数
     */
    int insertSelective(T record);

    /**
     * 通过主键获取
     * @param id 主键
     * @return 对象
     */
    T selectByPrimaryKey(PK id);

    /**
     * 更新
     * @param record 对象
     * @return 更新数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 更新
     * @param record 对象
     * @return 更新数
     */
    int updateByPrimaryKey(T record);

}
