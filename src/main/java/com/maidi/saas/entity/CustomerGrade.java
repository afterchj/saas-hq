package com.maidi.saas.entity;

import javax.persistence.*;

/**
 * @Classname Firm
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */

@Entity
@Table(name = "sm_customer_grade")
public class CustomerGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
