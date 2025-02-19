package com.example.gestionEmployerBackend.application.service;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MatriculeGenerator {

    private static final String PREFIX = "EMP";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static String generateMatricule(Long employeeId) {
        String datePart = DATE_FORMAT.format(new Date());
        return PREFIX + "-" + datePart + "-" + String.format("%04d", employeeId);
    }
}