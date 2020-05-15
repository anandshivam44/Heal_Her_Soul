package com.example.healhersoul.Objects;

public class SliderItem {
    private  String  text;
    private int image;


    public SliderItem(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public SliderItem(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
