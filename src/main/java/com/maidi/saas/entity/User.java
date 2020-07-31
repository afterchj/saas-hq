package com.maidi.saas.entity;

import javax.persistence.*;

/**
 * @Classname Firm
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */

@Entity
@Table(name = "sm_user",uniqueConstraints = @UniqueConstraint(columnNames = {"id", "name"}))
public class User extends BaseEntity {
    @Column(length = 64)
    private String name;
}
