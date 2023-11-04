package kg.adapter.blevota.Dto;

import java.util.Date;
import lombok.Data;

@Data
public class SensorDataDto {
    private long imei;
    private String sensor_name;
    private int hpid;
    private String hp_name;
    private String mqtt_topic;
    private Date create_date; // Поле create_date как Date
    private int power;
    private int signal;
    private String temp;
    private Date last_transmission; // Поле last_transmission как Date
    private Date last_measure; // Поле last_measure как Date
    private String timezone;
    private int model_id;
    private String model_name;

    // Геттеры и сеттеры
}
