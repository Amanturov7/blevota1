package kg.adapter.blevota.document;

import kg.adapter.blevota.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import java.util.Date;


@Document(indexName = Indices.PERSON_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Sensor {

        @Id
        @Field(type = FieldType.Integer)
        private String imei;

        @Field(type = FieldType.Keyword)
        private String sensor_name;

        @Field(type = FieldType.Float)
        private int hpid;

        @Field(type = FieldType.Keyword)
        private String hp_name;

        @Field(type = FieldType.Keyword)
        private String mqtt_topic;

    @Field(type = FieldType.Date)
    private Date create_date;
    @Field(type = FieldType.Date)
    private Date last_transmission;
    @Field(type = FieldType.Date)
    private Date last_measure;

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_transmission() {
        return last_transmission;
    }

    public void setLast_transmission(Date last_transmission) {
        this.last_transmission = last_transmission;
    }

    public Date getLast_measure() {
        return last_measure;
    }

    public void setLast_measure(Date last_measure) {
        this.last_measure = last_measure;
    }

    @Field(type = FieldType.Integer)
        private int power;

        @Field(type = FieldType.Integer)
        private int signal;

        @Field(type = FieldType.Keyword)
        private String temp;


        @Field(type = FieldType.Keyword)
        private String timezone;

        @Field(type = FieldType.Integer)
        private int model_id;

        @Field(type = FieldType.Keyword)
        private String model_name;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public int getHpid() {
        return hpid;
    }

    public void setHpid(int hpid) {
        this.hpid = hpid;
    }

    public String getHp_name() {
        return hp_name;
    }

    public void setHp_name(String hp_name) {
        this.hp_name = hp_name;
    }

    public String getMqtt_topic() {
        return mqtt_topic;
    }

    public void setMqtt_topic(String mqtt_topic) {
        this.mqtt_topic = mqtt_topic;
    }

    public int getPower() {
        return power;
    }


    public void setPower(int power) {
        this.power = power;
    }

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

}
