package ru.sfedu.goslingdrive.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import ru.sfedu.goslingdrive.utils.PartsConverter;

import java.util.List;
import java.util.Objects;

@Element
public class Car {
    @Attribute
    @CsvBindByPosition(position = 0)
    private long id;

    @Attribute
    @CsvBindByPosition(position = 1)
    private String brand = "";

    @Attribute
    @CsvBindByPosition(position = 2)
    private String model = "";

    @Attribute
    @CsvBindByPosition(position = 3)
    private int year;

    @Attribute
    @CsvBindByPosition(position = 4)
    private String vin = "";

    @ElementListUnion({
            @ElementList(entry = "AutoPart", inline = true, required = false, type = AutoPart.class),
            @ElementList(entry = "BodyPart", inline = true, required = false, type = BodyPart.class),
            @ElementList(entry = "ElectricPart", inline = true, required = false, type = ElectricPart.class),
            @ElementList(entry = "RunningPart", inline = true, required = false, type = RunningPart.class),
    })
    @CsvCustomBindByPosition(position = 5, converter = PartsConverter.class)
    private List<AutoPart> parts = List.of();

    public Car() {
    }

    public Car(long id, String brand, String model, int year, String vin, List<AutoPart> parts) {
        setId(id);
        setBrand(brand);
        setModel(model);
        setYear(year);
        setVin(vin);
        setParts(parts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return getId() == car.getId()
                && getYear() == car.getYear()
                && Objects.equals(getBrand(), car.getBrand())
                && Objects.equals(getModel(), car.getModel())
                && Objects.equals(getVin(), car.getVin())
                && Objects.equals(getParts(), car.getParts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getYear(), getVin(), getParts());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + getId() +
                ", brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", vin='" + getVin() + '\'' +
                ", parts=" + getParts() +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public List<AutoPart> getParts() {
        return parts;
    }

    public void setParts(List<AutoPart> parts) {
        this.parts = parts;
    }
}
