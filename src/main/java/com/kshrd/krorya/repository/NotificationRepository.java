package com.kshrd.krorya.repository;

import com.kshrd.krorya.model.dto.NotificationDTO;
import com.kshrd.krorya.model.entity.Notification;
import com.kshrd.krorya.model.request.NotificationRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NotificationRepository {
    @Select("""
            INSERT INTO notifications (user_id,description,title,type) VALUES (#{notification.userId}, #{notification.message},#{notification.title},#{notification.type}) RETURNING *
            """)
    Notification addNotification(@Param("notification") NotificationRequest notification);
}
