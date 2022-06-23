package com.ead.notification.dtos;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class NotificationCommandDTO {

    private String title;
    private String message;
    private UUID userId;
}
