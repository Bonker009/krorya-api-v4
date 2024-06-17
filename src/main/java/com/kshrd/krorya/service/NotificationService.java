package com.kshrd.krorya.service;

import com.kshrd.krorya.model.dto.NotificationDTO;
import com.kshrd.krorya.model.entity.Notification;
import com.kshrd.krorya.model.request.NotificationRequest;

public interface NotificationService {
    Notification saveNotification(NotificationRequest notification);
}
