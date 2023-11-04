package kg.adapter.blevota.document;

import kg.adapter.blevota.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;

@Document(indexName = Indices.HYDROPOST_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Hydropost {

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String hp_name;

    @Field(type = FieldType.Keyword)
    private String system_name;

    @Field(type = FieldType.Long)
    private Long system_id;

    @Field(type = FieldType.Keyword)
    private String waterchannel;

    @Field(type = FieldType.Keyword)
    private String watercourse;

    @Field(type = FieldType.Long)
    private Long hp_type_id;

    @Field(type = FieldType.Long)
    private Long sensor_imei;

    @Field(type = FieldType.Long)
    private Long resp_user_id;

    @Field(type = FieldType.Keyword)
    private String user_name;

    @Field(type = FieldType.Text)
    private String timezone;

    @Field(type = FieldType.Boolean)
    private Boolean calibrated;

    @Field(type = FieldType.Date)
    private Date create_date;

    @Field(type = FieldType.Keyword)
    private String model_link;

    @Field(type = FieldType.Integer)
    private Integer max_level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHp_name() {
        return hp_name;
    }

    public void setHp_name(String hp_name) {
        this.hp_name = hp_name;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }

    public Long getSystem_id() {
        return system_id;
    }

    public void setSystem_id(Long system_id) {
        this.system_id = system_id;
    }

    public String getWaterchannel() {
        return waterchannel;
    }

    public void setWaterchannel(String waterchannel) {
        this.waterchannel = waterchannel;
    }

    public String getWatercourse() {
        return watercourse;
    }

    public void setWatercourse(String watercourse) {
        this.watercourse = watercourse;
    }

    public Long getHp_type_id() {
        return hp_type_id;
    }

    public void setHp_type_id(Long hp_type_id) {
        this.hp_type_id = hp_type_id;
    }

    public Long getSensor_imei() {
        return sensor_imei;
    }

    public void setSensor_imei(Long sensor_imei) {
        this.sensor_imei = sensor_imei;
    }

    public Long getResp_user_id() {
        return resp_user_id;
    }

    public void setResp_user_id(Long resp_user_id) {
        this.resp_user_id = resp_user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Boolean getCalibrated() {
        return calibrated;
    }

    public void setCalibrated(Boolean calibrated) {
        this.calibrated = calibrated;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getModel_link() {
        return model_link;
    }

    public void setModel_link(String model_link) {
        this.model_link = model_link;
    }

    public Integer getMax_level() {
        return max_level;
    }

    public void setMax_level(Integer max_level) {
        this.max_level = max_level;
    }
}
