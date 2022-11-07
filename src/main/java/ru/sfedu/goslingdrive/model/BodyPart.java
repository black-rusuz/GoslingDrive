package ru.sfedu.goslingdrive.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;

import java.util.Objects;

public class BodyPart extends AutoPart {
    @Attribute
    @CsvBindByPosition(position = 5)
    private String color;

    public BodyPart() {
    }

    public BodyPart(long id, String name, int price, String vinPart, int warranty, String color) {
        super(id, name, price, vinPart, warranty);
        setColor(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BodyPart bodyPart)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getColor(), bodyPart.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }

    @Override
    public String toString() {
        return "BodyPart{" +
                "id=" +  super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", vinPart='" + super.getVinPart() + '\'' +
                ", warranty=" + super.getWarranty() +
                ", color='" + color + '\'' +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
