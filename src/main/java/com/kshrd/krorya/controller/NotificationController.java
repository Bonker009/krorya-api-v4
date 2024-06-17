package com.kshrd.krorya.controller;

import com.kshrd.krorya.model.dto.NotificationDTO;
import com.kshrd.krorya.model.entity.Notification;
import com.kshrd.krorya.model.request.NotificationRequest;
import com.kshrd.krorya.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping
    public Notification createNotification(@RequestBody NotificationRequest notification) {
        return notificationService.saveNotification(notification);
    }
}
