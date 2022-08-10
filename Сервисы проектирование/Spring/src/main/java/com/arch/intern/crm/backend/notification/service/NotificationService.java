package com.arch.intern.crm.backend.notification.service;

import com.arch.intern.crm.backend.common.interfeses.CrudService;
import com.arch.intern.crm.backend.notification.model.Notification;
import com.arch.intern.crm.backend.notification.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @author Marchenko_DS in 25/04/2022
 */
@Service
public class NotificationService implements CrudService<Notification> {

    private final NotificationRepo notificationRepo;
    @Autowired
    public NotificationService(NotificationRepo notificationRepo) {
        this.notificationRepo =notificationRepo;
    }

    @Override
    public JpaRepository<Notification, Long> getRepository() {
        return notificationRepo;
    }


}
