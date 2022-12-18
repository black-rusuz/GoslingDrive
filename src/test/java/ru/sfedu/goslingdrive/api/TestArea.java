package ru.sfedu.goslingdrive.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import ru.sfedu.goslingdrive.model.bean.*;
import ru.sfedu.goslingdrive.utils.TestData;


public class TestArea extends TestData {
    protected final Logger log = LogManager.getLogger(TestArea.class);
    protected final AbstractDataProvider dp = new DataProviderXml();

    @Test
    void test() {
    }

    @Test
    void bodyParts() {
        log.info(dp.getBodyParts());

        BodyPart b = b1;
        dp.insertBodyPart(b);
        log.info(dp.getBodyParts());

        BodyPart bb = dp.getBodyPart(b.getId());
        log.info(dp.getBodyParts());

        BodyPart bbb = dp.getBodyPart(321);
        log.info(bbb);

        bb.setName("BodyPart");
        dp.updateBodyPart(bb);
        log.info(dp.getBodyParts());

        dp.deleteBodyPart(bb.getId());
        log.info(dp.getBodyParts());
    }

    @Test
    void electricParts() {
        log.info(dp.getElectricParts());

        ElectricPart e = e1;
        dp.insertElectricPart(e);
        log.info(dp.getElectricParts());

        ElectricPart ee = dp.getElectricPart(e.getId());
        log.info(dp.getElectricParts());

        ElectricPart eee = dp.getElectricPart(321);
        log.info(eee);

        ee.setWattage(3);
        dp.updateElectricPart(ee);
        log.info(dp.getElectricParts());

        dp.deleteElectricPart(ee.getId());
        log.info(dp.getElectricParts());
    }

    @Test
    void runningParts() {
        log.info(dp.getRunningParts());

        RunningPart r = r1;
        dp.insertRunningPart(r);
        log.info(dp.getRunningParts());

        RunningPart rr = dp.getRunningPart(r.getId());
        log.info(dp.getRunningParts());

        RunningPart rrr = dp.getRunningPart(321);
        log.info(rrr);

        rr.setPrice(3200);
        dp.updateRunningPart(rr);
        log.info(dp.getRunningParts());

        dp.deleteRunningPart(rr.getId());
        log.info(dp.getRunningParts());
    }

    @Test
    void users() {
        log.info(dp.getUsers());

        User u = u1;
        dp.insertUser(u);
        log.info(dp.getUsers());

        User uu = dp.getUser(u.getId());
        log.info(uu);

        User uuu = dp.getUser(123123);
        log.info(uuu);

        uu.setAddress("Address");
        dp.updateUser(uu);
        log.info(dp.getUsers());

        dp.deleteUser(uu.getId());
        log.info(dp.getUsers());
    }

    @Test
    void orders() {
        log.info(dp.getOrders());

        Order o = new Order(1245, u1, p1, 0);
        dp.insertOrder(o);
        log.info(dp.getOrders());

        Order oo = dp.getOrder(o.getId());
        log.info(oo);

        Order ooo = dp.getOrder(123123);
        log.info(ooo);

        oo.setUser(u2);
        dp.updateOrder(oo);
        log.info(dp.getOrders());

        dp.deleteOrder(oo.getId());
        log.info(dp.getOrders());
    }
}
