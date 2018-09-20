package com.jdmail.mail.config.database;

public class DataBaseContextHolder {
    public enum DataBaseType {
        MASERT, SLAVE
    }

    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<DataBaseType>();

    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null)
            throw new NullPointerException();
        contextHolder.set(dataBaseType);
    }

    public static DataBaseType getDataBaseType() {
        return contextHolder.get() == null ? DataBaseType.MASERT : contextHolder.get();
    }

    public static void clearDataBaseType() {
        contextHolder.remove();
    }
}
