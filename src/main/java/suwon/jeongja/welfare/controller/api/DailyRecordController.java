package suwon.jeongja.welfare.controller.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suwon.jeongja.welfare.common.dto.ResponseDto;
import suwon.jeongja.welfare.dto.request.DailyRecordRegisterRequest;
import suwon.jeongja.welfare.service.DailyRecordService;

@Slf4j
@RestController
@RequestMapping(value = "/api/daily-record", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DailyRecordController {

    private final DailyRecordService dailyRecordService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> dailyRecordService(@RequestBody DailyRecordRegisterRequest request) {
        var response = dailyRecordService.register(request);
        return ResponseDto.created(response);
    }
}
