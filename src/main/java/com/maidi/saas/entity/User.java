package com.maidi.saas.entity;

import javax.persistence.*;

/**
 * @Classname Firm
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */

@Entity
@Table(name = "sm_user")
public class User extends BaseEntity {
    private String name;
}
