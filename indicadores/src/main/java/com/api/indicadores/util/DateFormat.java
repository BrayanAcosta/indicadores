/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.indicadores.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Brayan
 */
@Getter
@Setter
public class DateFormat {
    
    private SimpleDateFormat format;
    
    public DateFormat(String format){
        this.format = new SimpleDateFormat(format);
    }
    
    public String formatDate(Date date){
        return getFormat().format(date);
    }
    
    public Date formatDate(String date) throws ParseException{
        return getFormat().parse(date);
    }
}
