package com.nasquadras.NasQuadras.roster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRosterRepository extends JpaRepository<RosterModel, Integer> {
    List<RosterModel> findByUserId(int userId);

}
