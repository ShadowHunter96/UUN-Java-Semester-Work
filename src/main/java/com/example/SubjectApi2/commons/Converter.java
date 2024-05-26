package com.example.SubjectApi2.commons;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 20:55
 */
public interface Converter<DOMAIN, ENTITY> {

    //TODO probrat v tymu naming konvence (lepsi nazev tridy, lepsi nazev metody)
    DOMAIN fromEntities(ENTITY ent);

}
