package com.jee.cabinetSpring.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponse {
    private boolean success;
    private String Message;
    private String detail;
}
