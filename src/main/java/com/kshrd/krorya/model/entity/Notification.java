package com.kshrd.krorya.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private UUID notificationId;
    private String notificationTitle;
    private String notificationMessage;
    private UUID userId;
    private String notificationType;
    private Date date;
}
