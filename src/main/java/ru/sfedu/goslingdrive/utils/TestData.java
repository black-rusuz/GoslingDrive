package ru.sfedu.goslingdrive.utils;

import ru.sfedu.goslingdrive.model.bean.*;

import java.util.List;

public class TestData {
    public static final BodyPart b1 = new BodyPart(11, "Bumper Toyota Corolla", 25000, "A1BX4", 6, "Red", "Front");
    public static final BodyPart b2 = new BodyPart(12, "Door Renault Duster", 15000, "BX12S", 24, "White", "Right back");

    public static final ElectricPart e1 = new ElectricPart(21, "Radiator fan", 3000, "XCXX1", 3, 2);
    public static final ElectricPart e2 = new ElectricPart(22, "Fuel pump", 8000, "BASD1", 6, 0.5);

    public static final RunningPart r1 = new RunningPart(31, "Engine V8 UZ", 80000, "JLKJ2", 60, false);
    public static final RunningPart r2 = new RunningPart(32, "Gearbox UAZ Patriot", 25000, "OJHD5", 30, true);

    public static final User u1 = new User(41, "Semen Persunov", "Audi 80 1996", "ul. Zorge, 28, k. 4B");
    public static final User u2 = new User(42, "Anna Beluchenko", "Nissun Sunny 1991", "Rabochaya pl., 6");

    public static final List<AutoPart> p1 = List.of(b1, b2, e1, r1);
    public static final List<AutoPart> p2 = List.of(e1, e2, r1, r2);

    public static final Order o1 = new Order(51, u1, p1, p1.stream().mapToDouble(AutoPart::getPrice).sum());
    public static final Order o2 = new Order(52, u2, p2, p2.stream().mapToDouble(AutoPart::getPrice).sum());
}
