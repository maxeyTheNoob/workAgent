package agent.dao;

import agent.pojo.work;

public interface workMapper {
    int deleteByPrimaryKey(Integer workId);

    int insert(work record);

    work selectByPrimaryKey(Integer workId);
    
    work selectByCondition(work w);

    int updateByPrimaryKeySelective(work record);

    int updateByPrimaryKey(work record);
}