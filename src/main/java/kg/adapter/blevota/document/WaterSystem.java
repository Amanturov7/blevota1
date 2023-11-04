package kg.adapter.blevota.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.adapter.blevota.helper.Indices;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;


@Document(indexName = Indices.WATER_SYSTEM_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class WaterSystem {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Long)
    private long system_id;
    @JsonFormat(pattern = "yy-MM-dd HH:mm", timezone = "UTC")
    @Field(type = FieldType.Date)
    private Date utc;
    @Field(type = FieldType.Float)
    private float totalIntake;

    @Field(type = FieldType.Float)
    private float intake;

    @Field(type = FieldType.Float)
    private float supply;

    @Field(type = FieldType.Float)
    private float discard;

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

    public float getTotalIntake() {
        return totalIntake;
    }

    public void setTotalIntake(float totalIntake) {
        this.totalIntake = totalIntake;
    }

    public float getIntake() {
        return intake;
    }

    public void setIntake(float intake) {
        this.intake = intake;
    }

    public float getSupply() {
        return supply;
    }

    public void setSupply(float supply) {
        this.supply = supply;
    }

    public float getDiscard() {
        return discard;
    }

    public void setDiscard(float discard) {
        this.discard = discard;
    }
}
