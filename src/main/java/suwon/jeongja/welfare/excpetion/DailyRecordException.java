package suwon.jeongja.welfare.excpetion;

public class DailyRecordException extends BusinessException{
    public DailyRecordException() {
        super(ErrorMessage.USER_NOT_FOUND_ERROR);
    }
}
