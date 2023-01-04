package com.case_study.repository.facility;

import com.case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select f.* from `facility` f join `facility_type` ft " +
            "on f.facility_type_id = ft.id " +
            "where f.name like %:name% and ft.name like %:type% and f.delete_status= 1", nativeQuery = true)
    Page<Facility> search(@Param("name") String nameSearch,
                          @Param("type") String facilityType,
                          Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update facility set delete_status = 0 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);
}
