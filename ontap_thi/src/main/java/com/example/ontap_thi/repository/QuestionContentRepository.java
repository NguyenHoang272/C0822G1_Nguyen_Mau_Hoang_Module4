package com.example.ontap_thi.repository;

import com.example.ontap_thi.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface QuestionContentRepository extends JpaRepository<QuestionContent,Integer> {
    @Query(value = "select q.* from question_content q join question_type qt " +
            " on q.question_type_id = qt.id " +
            "where q.delete_status = 1 and q.date like %:date% and q.title like %:title% and qt.name like %:type% ", nativeQuery = true)
    Page<QuestionContent> search(@Param("date") String date,
                                 @Param("title") String title,
                                 @Param("type")  String questionType,
                                 Pageable pageable
    );

    @Transactional
    @Modifying
    @Query(value = "update question_content set delete_status = 0 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);
}
