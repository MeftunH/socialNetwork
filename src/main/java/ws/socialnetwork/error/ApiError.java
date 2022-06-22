package ws.socialnetwork.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import ws.socialnetwork.shared.Views;

import java.util.Date;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    @JsonView(Views.BaseView.class)
    private String message;
    @JsonView(Views.BaseView.class)
    private String path;
    @JsonView(Views.BaseView.class)
    private final long timestamp = new Date().getTime();
    @JsonView(Views.BaseView.class)
    private int status;
    @JsonView(Views.BaseView.class)
    private Map<String, String> validationErrors;

    public ApiError(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
