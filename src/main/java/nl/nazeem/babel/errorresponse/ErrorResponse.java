package nl.nazeem.babel.errorresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    private String message;

    @JsonProperty("message-detail")
    private String messageDetail;

    public ErrorResponse() {}

    public ErrorResponse(String message, String messageDetail) {
        this.message = message;
        this.messageDetail = messageDetail;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageDetail() {
        return messageDetail;
    }
}
