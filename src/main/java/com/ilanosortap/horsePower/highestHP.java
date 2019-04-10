package com.ilanosortap.horsePower;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.sources.In;

import static org.apache.spark.sql.functions.*;

import java.util.Scanner;

public class highestHP {

    public static void main(String[] args)
    {
        SparkSession spark = SparkSession.builder().master("local[*]").getOrCreate();

        Dataset inputDf = spark.read().format("csv").option("header", "true").option("inferSchema","true").load("/Users/sonalipatro/cars/src/main/resources/cars_input1.txt");


        Dataset avgHpDF = inputDf.groupBy("Origin").avg("Horsepower");


        int N = Integer.parseInt(args[0]);
        String O = args[1];

        String conditionOrig = "Origin == \""+O+"\"";

        String avgHPVal = avgHpDF.filter(conditionOrig).select("avg(Horsepower)").collectAsList().get(0).toString();
        String condtionHP = "Horsepower >= "+ avgHPVal.substring(1,avgHPVal.length()-2);
        System.out.println(condtionHP);
        Dataset ouputDf = inputDf.filter(conditionOrig).filter(condtionHP);

        ouputDf.show(N);
    }
}
