package com.ead.notification.repositories;

import com.ead.notification.models.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<NotificationModel,UUID> {
}
