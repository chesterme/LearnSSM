package ch05.mapper;

import ch05.pojo.WorkCard;

public interface WorkCardMapper {

    WorkCard getById(Long id);
    void insert(WorkCard workCard);

}
