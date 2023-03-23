package com.epam.spring.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemsFromPages {

    public static <T> List<T> getItemsFromPages(List<T> items, int pageSize, int pageNum) {

        List<T> itemsList;
        List<List<T>> listOfPages = new ArrayList<>();
        List<T> tempList = new ArrayList<>();

        if (items.size() <= pageSize) {
            return items;
        } else if (items.size() > pageSize) {
            for (T t : items) {
                tempList.add(t);
                if (tempList.size() % pageSize == 0) {
                    listOfPages.add(new ArrayList<>(tempList));
                    tempList.clear();
                }
            }
            listOfPages.add(new ArrayList<>(tempList));
        }

        itemsList = new ArrayList<T>((Collection<? extends T>) listOfPages);
        return itemsList;
    }
}
