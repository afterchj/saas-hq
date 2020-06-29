package com.maidi.saas.entity;


import javax.persistence.*;

/**
 * @Classname UserVo
 * @Description TODO
 * @Date 2020/6/3 10:28
 * @Created by hjchen
 */

@Entity
@Table(name = "sm_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String info;

//    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "tid")
//    private customerType type;
//
//    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "gid")
//    private CustomerGrade grade;


}
