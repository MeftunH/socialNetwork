package ws.socialnetwork.error;

import lombok.Data;

import java.util.Date;
import java.util.Map;


public class ApiError {
    private String message;
    private String path;
    private final long timestamp = new Date().getTime();
    private int status;
    private Map<String, String> validationErrors;

}
