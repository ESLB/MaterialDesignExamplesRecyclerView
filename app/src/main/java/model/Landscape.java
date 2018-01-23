package model;

import com.pruebas.elsve.materialdesignexamplesrecyclerview.R;

import java.util.ArrayList;

public class Landscape {

    private int imageID;
    private String title;
    private String description;
    private boolean isSpecial;

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static ArrayList<Landscape> getData(){

        ArrayList<Landscape> dataList = new ArrayList<>();
        for(int i = 0; i <1000; i++){

            Landscape landscape = new Landscape();
            if(i%2==0)
            {landscape.setImageID(R.drawable.ic_headset_black_24dp);}
            else {
                landscape.setImageID(R.drawable.ic_insert_photo_black_24dp);
            }

            landscape.setTitle("Landscape " + (i+1));
            landscape.setSpecial(i%3==0);
            dataList.add(landscape);

        }

        return dataList;

    }


}
