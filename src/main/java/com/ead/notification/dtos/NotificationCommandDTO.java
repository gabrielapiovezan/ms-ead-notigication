package com.ead.notification.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationCommandDTO {

    private UUID userId;
    private String message;
    private String title;
}
