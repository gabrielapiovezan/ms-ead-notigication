package com.ead.notification.dtos;

import com.ead.notification.enums.NotificationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NotificationDTO {

    @NotNull NotificationStatus notificationStatus;
}
