import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonDO getPersonById(Long id);

    /**
     *
     * @param personDO
     * @return
     */
    Integer insert(PersonDO personDO);

    Integer batchUpsert(@Param("personList") List<PersonDO> personDO);

}
