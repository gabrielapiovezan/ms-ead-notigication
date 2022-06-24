package com.ead.notification.controllers;

import com.ead.notification.dtos.NotificationDTO;
import com.ead.notification.models.NotificationModel;
import com.ead.notification.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UserNotificationController {

    private final NotificationService notificationService;

    @GetMapping("users/{userId}/notifications")
    public ResponseEntity<Page<NotificationModel>> getAllNotifications(@PathVariable("userId") UUID userId,
                                                                       @PageableDefault(page = 0, size = 10, sort = "notificationId", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(notificationService.getAllNotificationsByUser(userId, pageable));
    }


    @PutMapping("users/{userId}/notifications/{notificationId}")
    public ResponseEntity<Object> updateNotification(@PathVariable("userId") UUID userId,
                                                     @PathVariable("notificationId") UUID notificationId,
                                                     @RequestBody @Valid NotificationDTO notificationModel) {
        Optional<NotificationModel> notification = notificationService.findByNotificationIdAndUserId(notificationId, userId);

        return notification.<ResponseEntity<Object>>map(notificationModel1 -> {
            notificationModel1.setNotificationStatus(notificationModel.getNotificationStatus());
            notificationService.saveNotification(notificationModel1);
            return ResponseEntity.ok(notificationModel1);
        }).orElse(ResponseEntity.status(NOT_FOUND).body("Notification not found!"));

    }

}
