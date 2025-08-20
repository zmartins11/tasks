package com.daniel.notifications.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/notifications")
public class NotificationController {

    @GetMapping
    public String testNotification() {
       return "Notification OK: TESTING NEW NBUILDF";
    }
}
