package com.kshrd.krorya.service.serviceImplementation;

import com.kshrd.krorya.exception.CustomNotFoundException;
import com.kshrd.krorya.model.dto.NotificationDTO;
import com.kshrd.krorya.model.entity.Notification;
import com.kshrd.krorya.model.request.NotificationRequest;
import com.kshrd.krorya.repository.AppUserRepository;
import com.kshrd.krorya.repository.NotificationRepository;
import com.kshrd.krorya.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final AppUserRepository appUserRepository;

    @Override
    public Notification saveNotification(NotificationRequest notification) {
        if (appUserRepository.getUserById(notification.getRecipientId()) == null) {
            throw new CustomNotFoundException("The Recipient Id is not found : " + notification.getRecipientId());
        }
        return notificationRepository.addNotification(notification);
    }
}
