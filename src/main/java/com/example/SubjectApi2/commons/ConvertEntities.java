package com.example.SubjectApi2.commons;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 20:54
 */
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class ConvertEntities {

    /**
     * Converts list of object of one type to other using second arguments method.
     *
     * @param ents     list of objects to convert
     * @param r        lambda or method reference, that do conversion for one instance
     * @param <DOMAIN> data type of result objects
     * @param <ENTITY> data type of source objects
     * @return
     */
    //TODO probrat v tymu naming konvence (lepsi nazev tridy, lepsi nazev metody)
    public static <DOMAIN, ENTITY> List<DOMAIN> fromEntities(
            List<ENTITY> ents, Converter<DOMAIN, ENTITY> r) {

        List<DOMAIN> list = new ArrayList<>();
        for (ENTITY entity : ents) {
            DOMAIN converted = r.fromEntities(entity);
            list.add(converted);
        }
        return list;
    }

    public static <DOMAIN, ENTITY> Page<DOMAIN> fromEntities(
            Page<ENTITY> ents, Converter<DOMAIN, ENTITY> r) {

        List<DOMAIN> list = fromEntities(ents.toList(), r);
        return new PageImpl<>(list, ents.getPageable(), ents.getSize());
    }

    public static <DOMAIN, ENTITY> Set<DOMAIN> fromEntities(
            Set<ENTITY> ents, Converter<DOMAIN, ENTITY> r) {

        Set<DOMAIN> set = new HashSet<>();
        for (ENTITY entity : ents) {
            DOMAIN converted = r.fromEntities(entity);
            set.add(converted);
        }
        return set;
    }

}
