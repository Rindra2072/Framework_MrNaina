/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu002072.framework.utilitaire;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rindra
 */
public class DateEditor extends PropertyEditorSupport {
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(dateFormat.parse(text));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Format de date invalide");
        }
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? dateFormat.format(value) : "");
    }
}
