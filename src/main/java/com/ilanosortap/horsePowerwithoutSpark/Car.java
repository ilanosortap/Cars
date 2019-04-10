package com.ilanosortap.horsePowerwithoutSpark;

public class Car{
    String model;
    String origin;
    Float horsePower;

    public void setValues(String model,String origin,Float horsePower)
    {
        this.model=model;
        this.origin=origin;
        this.horsePower=horsePower;
    }

    public String getOrigin()
    {
        return this.origin;
    }

    public  String getModel(){
        return this.model;
    }

    public Float getHorsePower(){
        return this.horsePower;
    }
}

