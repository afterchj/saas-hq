package com.maidi.saas.entity.vo;

import lombok.Data;

/**
 * @Classname Item
 * @Description TODO
 * @Date 2020/6/19 14:28
 * @Created by hjchen
 */
@Data
public class Item<T> {
    private T t;
}
