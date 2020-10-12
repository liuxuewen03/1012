package cn.kgc.service.impl;

import cn.kgc.mapper.StandardMapper;
import cn.kgc.pojo.Standard;
import cn.kgc.pojo.StandardExample;
import cn.kgc.service.StandardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-12 14:43
 */
@Service("standardService")
public class StandardServiceImpl implements StandardService {
    @Resource
    StandardMapper standardMapper;

    @Override
    public PageInfo<Standard> selectByZhname(String zhname, int pageNum, int pageSize, String pageNumStr) {

        StandardExample standardExample = new StandardExample();
        StandardExample.Criteria criteria = standardExample.createCriteria();
        criteria.andZhnameLike("%" + zhname + "%");


        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        List<Standard> standards = standardMapper.selectByExample(standardExample);
        PageInfo<Standard> standardPageInfo = new PageInfo<>(standards);
        return standardPageInfo;
    }

    @Override
    public void insert(Standard standard) {
        standardMapper.insertSelective(standard);
    }

    @Override
    public Standard selectById(int id) {
        Standard standard = standardMapper.selectByPrimaryKey(id);
        return standard;
    }

    @Override
    public void update(Standard standard) {
        standardMapper.updateByPrimaryKeySelective(standard);
    }

    @Override
    public int del(Integer[] arr) {
        StandardExample standardExample=new StandardExample();
        StandardExample.Criteria criteria = standardExample.createCriteria();
        List<Integer> list=new ArrayList<>();
        for (Integer integer : arr) {
            list.add(integer);
        }
        criteria.andIdIn(list);
        return  standardMapper.deleteByExample(standardExample);
    }
}
