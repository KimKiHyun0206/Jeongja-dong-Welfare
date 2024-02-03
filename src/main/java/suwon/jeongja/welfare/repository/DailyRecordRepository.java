package suwon.jeongja.welfare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suwon.jeongja.welfare.domain.DailyRecord;

@Repository
public interface DailyRecordRepository extends JpaRepository<DailyRecord, Long> {
}
