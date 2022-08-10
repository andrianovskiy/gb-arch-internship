package com.arch.intern.crm.backend.notification.repository;

import com.arch.intern.crm.backend.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
public interface NotificationRepo extends JpaRepository<Notification, Long> {

}
