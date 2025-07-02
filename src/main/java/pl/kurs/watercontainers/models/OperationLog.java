package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class OperationLog implements Serializable {

    private static final long serialVersionUID = 42L;

    private final Timestamp timestamp;
    private final OperationType operationType;
    private final WaterContainer waterContainer;
    private final double waterValue;
    private final boolean success;

    public OperationLog(Timestamp timestamp, OperationType operationType, WaterContainer waterContainer, double waterValue, boolean success) {
        this.timestamp = timestamp;
        this.operationType = operationType;
        this.waterContainer = waterContainer;
        this.waterValue = waterValue;
        this.success = success;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public WaterContainer getWaterContainer() {
        return waterContainer;
    }

    public double getWaterValue() {
        return waterValue;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "timestamp=" + timestamp +
                ", operationType=" + operationType +
                ", waterContainer=" + waterContainer +
                ", waterValue=" + waterValue +
                ", success=" + success +
                '}';
    }

    public enum OperationType{
        ADD,
        SUBTRACT
    }


}

