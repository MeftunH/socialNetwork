package ws.socialnetwork.shared;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponse {
    @JsonView(Views.BaseView.class)
    private String message;
}
