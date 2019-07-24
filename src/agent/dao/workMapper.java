package agent.dao;

import agent.pojo.work;
import java.util.List;
public interface workMapper {
    void deleteByPrimaryKey(Integer workId);

    void insert(work record);

    work selectByPrimaryKey(Integer workId);
    
    work[] selectByCondition(work w);

    void updateByPrimaryKeySelective(work record);

    void updateByPrimaryKey(work record);
}