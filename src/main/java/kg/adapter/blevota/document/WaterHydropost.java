package kg.adapter.blevota.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.adapter.blevota.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;


@Document(indexName = Indices.WATER_HYDROPOST_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class WaterHydropost {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Long)
    private long system_id;
    @JsonFormat(pattern = "yy-MM-dd HH:mm", timezone = "UTC")
    @Field(type = FieldType.Date)
    private Date utc;
    @Field(type = FieldType.Long)
    private Long hpid;

    @Field(type = FieldType.Float)
    private float flow;

    @Field(type = FieldType.Keyword)
    private String level;

    @Field(type = FieldType.Long)
    private long imei;

    public Long getHpid() {
        return hpid;
    }

    public void setHpid(Long hpid) {
        this.hpid = hpid;
    }


    public long getSystem_id() {
        return system_id;
    }

    public void setSystem_id(long system_id) {
        this.system_id = system_id;
    }

    public Date getUtc() {
        return utc;
    }

    public void setUtc(Date utc) {
        this.utc = utc;
    }


    public float getFlow() {
        return flow;
    }

    public void setFlow(float flow) {
        this.flow = flow;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }
}




