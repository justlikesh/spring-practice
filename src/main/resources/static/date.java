import java.sql.Timestamp;
import java.time.LocalDateTime;

public void makeTime(){
    Timestamp userCurStopDate = (Timestamp) userBlockState.get("USER_STOP_DATE");
    LocalDateTime userStopDate = userCurStopDate.toLocalDateTime();

    LocalDateTime currentDateTime = LocalDateTime.now();

}