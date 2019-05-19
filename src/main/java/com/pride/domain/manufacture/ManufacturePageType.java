package com.pride.domain.manufacture;

import com.pride.domain.Corder;
import com.pride.domain.Manufacture;
import com.pride.domain.Technology;

import java.util.Date;

public class ManufacturePageType extends Manufacture {

    private Corder cOrder;

    private Technology technology;

    public Corder getcOrder() {
        return cOrder;
    }

    public void setcOrder(Corder cOrder) {
        this.cOrder = cOrder;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public void buildManufacture(Manufacture manufacture){
        this.setManufactureSn(manufacture.getManufactureSn());
        this.setOrderId(manufacture.getOrderId());
        this.setTechnologyId(manufacture.getTechnologyId());
        this.setLaunchQuantity(manufacture.getLaunchQuantity());
        this.setBeginDate(manufacture.getBeginDate());
        this.setEndDate(manufacture.getEndDate());
    }
}
