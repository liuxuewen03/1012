package cn.kgc.service;

import cn.kgc.pojo.Standard;
import com.github.pagehelper.PageInfo;

/**
 * @author shkstart
 * @create 2020-10-12 14:43
 */
public interface StandardService {

    PageInfo<Standard> selectByZhname(String zhname,int pageNum, int pageSize,String pageNumStr);

    void insert(Standard standard);

    Standard selectById(int id);

    void update(Standard standard);

    int del(Integer[] arr);
}
