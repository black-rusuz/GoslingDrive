package ru.sfedu.goslingdrive.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.goslingdrive.model.HistoryContent;
import ru.sfedu.goslingdrive.model.bean.*;
import ru.sfedu.goslingdrive.utils.ConfigurationUtil;
import ru.sfedu.goslingdrive.utils.Constants;
import ru.sfedu.goslingdrive.utils.MongoUtil;
import ru.sfedu.goslingdrive.utils.ReflectUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("UnusedReturnValue")
public abstract class AbstractDataProvider {
    protected final Logger log = LogManager.getLogger(this.getClass());

    private boolean MONGO_ENABLE = false;
    private String MONGO_ACTOR = "";

    public AbstractDataProvider() {
        try {
            MONGO_ENABLE = Boolean.parseBoolean(ConfigurationUtil.getConfigurationEntry(Constants.MONGO_ENABLE));
            MONGO_ACTOR = ConfigurationUtil.getConfigurationEntry(Constants.MONGO_ACTOR);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    // ABSTRACT GENERICS

    protected abstract <T> List<T> getAll(Class<T> type);

    protected abstract <T> T getById(Class<T> type, long id);

    protected abstract <T> long insert(Class<T> type, T bean);

    protected abstract <T> boolean delete(Class<T> type, long id);

    protected abstract <T> boolean update(Class<T> type, T bean);

    // SERVICE

    protected void sendLogs(String methodName, Object bean, boolean result) {
        HistoryContent historyContent = new HistoryContent(UUID.randomUUID(),
                this.getClass().getSimpleName(),
                LocalDateTime.now().toString(),
                MONGO_ACTOR,
                methodName,
                MongoUtil.objectToString(bean),
                result);
        if (MONGO_ENABLE) MongoUtil.saveToLog(historyContent);
    }

    protected <T> boolean hasSavedId(Class<T> type, long id) {
        T oldBean = getById(type, id);
        return ReflectUtil.getId(oldBean) != 0;
    }

    protected <T> String getNotFoundMessage(Class<T> type, long id) {
        return String.format(Constants.NOT_FOUND, type.getSimpleName(), id);
    }

    // USE CASES


    // CRUD

    public List<BodyPart> getBodyParts() {
        return getAll(BodyPart.class);
    }

    public BodyPart getBodyPart(long id) {
        return getById(BodyPart.class, id);
    }

    public long insertBodyPart(BodyPart bodyPart) {
        return insert(BodyPart.class, bodyPart);
    }

    public boolean deleteBodyPart(long id) {
        return delete(BodyPart.class, id);
    }

    public boolean updateBodyPart(BodyPart bodyPart) {
        return update(BodyPart.class, bodyPart);
    }


    public List<ElectricPart> getElectricParts() {
        return getAll(ElectricPart.class);
    }

    public ElectricPart getElectricPart(long id) {
        return getById(ElectricPart.class, id);
    }

    public long insertElectricPart(ElectricPart electricPart) {
        return insert(ElectricPart.class, electricPart);
    }

    public boolean deleteElectricPart(long id) {
        return delete(ElectricPart.class, id);
    }

    public boolean updateElectricPart(ElectricPart electricPart) {
        return update(ElectricPart.class, electricPart);
    }


    public List<Order> getOrders() {
        return getAll(Order.class);
    }

    public Order getOrder(long id) {
        return getById(Order.class, id);
    }

    public long insertOrder(Order order) {
        return insert(Order.class, order);
    }

    public boolean deleteOrder(long id) {
        return delete(Order.class, id);
    }

    public boolean updateOrder(Order order) {
        return update(Order.class, order);
    }


    public List<RunningPart> getRunningParts() {
        return getAll(RunningPart.class);
    }

    public RunningPart getRunningPart(long id) {
        return getById(RunningPart.class, id);
    }

    public long insertRunningPart(RunningPart runningPart) {
        return insert(RunningPart.class, runningPart);
    }

    public boolean deleteRunningPart(long id) {
        return delete(RunningPart.class, id);
    }

    public boolean updateRunningPart(RunningPart runningPart) {
        return update(RunningPart.class, runningPart);
    }


    public List<User> getUsers() {
        return getAll(User.class);
    }

    public User getUser(long id) {
        return getById(User.class, id);
    }

    public long insertUser(User user) {
        return insert(User.class, user);
    }

    public boolean deleteUser(long id) {
        return delete(User.class, id);
    }

    public boolean updateUser(User user) {
        return update(User.class, user);
    }
}
