package com.springrest.service;

import com.springrest.entity.Alert;

public interface EmailService {
     void sendEmail(Alert alert, String to);
}
