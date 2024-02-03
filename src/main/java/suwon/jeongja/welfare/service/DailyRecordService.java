package suwon.jeongja.welfare.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import suwon.jeongja.welfare.dto.request.DailyRecordRegisterRequest;
import suwon.jeongja.welfare.dto.request.DailyRecordUpdateRequest;
import suwon.jeongja.welfare.dto.response.DailyRecordResponse;
import suwon.jeongja.welfare.entity.DailyRecord;
import suwon.jeongja.welfare.excpetion.DailyRecordException;
import suwon.jeongja.welfare.repository.DailyRecordRepository;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class DailyRecordService {

    private final DailyRecordRepository repository;

    @Transactional
    public DailyRecordResponse register(DailyRecordRegisterRequest request){
        DailyRecord record = new DailyRecord(
                request.getUserId(),
                request.getMood(),
                request.getDetail(),
                LocalDate.now()
        );

        log.info("Record 생성");

        DailyRecord savedRecord = repository.save(record);

        log.info("DailyRecord 등록 userId : {}, recordId : {}",savedRecord.getUserId(),savedRecord.getId());

        return DailyRecordResponse.from(savedRecord);
    }


    @Transactional(readOnly = true)
    public DailyRecordResponse get(Long id){
        DailyRecord dailyRecord = repository.findById(id)
                .orElseThrow(DailyRecordException::new);

        log.info("DailyRecord 조회 userId : {}, recordId : {}",dailyRecord.getUserId(),dailyRecord.getId());

        return DailyRecordResponse.from(dailyRecord);
    }

    @Transactional(readOnly = true)
    public Page<DailyRecordResponse> detAll(Pageable pageable){
        return repository.findAll(pageable).map(DailyRecordResponse::from);
    }

    @Transactional
    public DailyRecordResponse update(Long id, DailyRecordUpdateRequest request){
        DailyRecord dailyRecord = repository.findById(id).orElseThrow(DailyRecordException::new);

        dailyRecord.update(
                request.getMood(),
                request.getDetail()
        );

        log.info("DailyRecord 수정 userId : {}, fixedRecordId : {}",dailyRecord.getUserId(),dailyRecord.getId());

        return DailyRecordResponse.from(dailyRecord);
    }

    @Transactional
    public void delete(Long id){
        if(repository.existsById(id)){
            DailyRecordResponse dailyRecord = get(id);
            repository.deleteById(id);
            log.info("DailyRecord 삭제 userId : {}, deletedRecordId : {}",dailyRecord.getUserId(),dailyRecord.getId());
        }
    }
}
