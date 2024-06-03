/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author alejandro.bueno
 */
@Component // or @Service
public class Utils {
    public Date parseDate(String dateString) {

      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
      try {
        return formatter.parse(dateString);
      } catch (ParseException e) {
        throw new RuntimeException("Invalid date format: " + dateString);
      }
    }
}
