package com.dseoki.api.hiking;

import com.dseoki.api.entity.Hiking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * fileName: HikingRepository
 * author: gawain
 * date: 2024-03-12
 * description:
 * ==============================
 * DATE     AUTHOR      NOTE
 * ------------------------------
 * 2024-03-12  gawain     최초생성
 */
public interface HikingRepository extends JpaRepository<Hiking, Long> {
}
