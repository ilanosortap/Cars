package com.ilanosortap.horsePowerwithoutSpark;


import java.io.*;


public class highestHPwithoutSpark {




    public static void main(String[] args)
    {

        String csvFile = "/Users/sonalipatro/cars/src/main/resources/cars_input1.txt";
        BufferedReader br = null;
        String line = "";



        Integer size = 0;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            LineNumberReader lines = new LineNumberReader(new FileReader(csvFile));
            while ((br.readLine()) != null){
            size++;}
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        Car hp[] = new Car[size-1];

        try {

            br = new BufferedReader(new FileReader(csvFile));

            int iteration = 0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                if(iteration == 0)
                {
                    iteration++;
                    continue;
                }
                String[] carDetails = line.split(",");

                hp[iteration-1] = new Car();
                hp[iteration-1].setValues(carDetails[0],carDetails[1],Float.parseFloat(carDetails[2]));
                //System.out.println(hp[iteration-1].model+hp[iteration-1].origin);
                iteration++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Integer N = Integer.parseInt(args[0]);
        String O = args[1];

        Float sum = 0F;
        Integer count=0;

        for(Integer it =0; it<hp.length;it++)
        {
            Car h = hp[it];
            String s;
            s = h.getOrigin();
            if(s.equals(O))
                {
                    sum+=h.getHorsePower();
                    count++;
                }
        }

        Float avg = sum/count;
        Integer cnt =0 ;


        for(Integer it =0; it<hp.length;it++)
        {
            Car h = hp[it];

            if(h.getHorsePower() > avg && h.getOrigin().equals(O))
            {
                System.out.println(h.getModel()+","+h.getOrigin()+","+h.getHorsePower());
                cnt++;
            }
            if(cnt==N)
                break;
        }

    }
}
