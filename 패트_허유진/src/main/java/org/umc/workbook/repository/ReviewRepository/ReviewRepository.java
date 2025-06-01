package org.umc.workbook.repository.ReviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.umc.workbook.domain.Member;
import org.umc.workbook.domain.Review;
import org.umc.workbook.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    //    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    @Query("SELECT r FROM Review r JOIN FETCH r.member WHERE r.store = :store")
    Page<Review> findAllByStore(@Param("store") Store store, Pageable pageable);


    @Query("SELECT r FROM Review r JOIN FETCH r.member WHERE r.member = :member")
    Page<Review> findAllByMember(@Param("member") Member member, Pageable pageable);
}
