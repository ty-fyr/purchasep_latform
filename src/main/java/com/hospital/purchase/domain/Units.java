package com.hospital.purchase.domain;

public class Units {
    private Integer unitsId;

    private String units;

    private Integer unitsFid;

    public Integer getUnitsId() {
        return unitsId;
    }

    public void setUnitsId(Integer unitsId) {
        this.unitsId = unitsId;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public Integer getUnitsFid() {
        return unitsFid;
    }

    public void setUnitsFid(Integer unitsFid) {
        this.unitsFid = unitsFid;
    }
}