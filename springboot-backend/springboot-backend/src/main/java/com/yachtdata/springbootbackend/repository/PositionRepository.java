package com.yachtdata.springbootbackend.repository;

import com.yachtdata.springbootbackend.model.Position;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByTeam_Name(String name);

    List<Position> findByTeam_NameOrderByGpsAtAsc(String name);

    List<Position> findByTeam_Name_Not(String name);
}
