package com.basis.campina.xtarefas.domain.elastic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;

@Getter
@Setter
@Setting(settingPath = "/config/elastic/elastic.json")
public class BaseDocument implements Serializable {

    private static final long serialVersionUID = 154255735654368447L;

    protected static final String TRIM_CASE_INSENSITIVE = "trim_case_insensitive";
    protected static final String SORT = "sort";
    protected static final String DATE_PATTERN = "dd/MM/yyyy";

    @MultiField(mainField = @Field(type = FieldType.Integer, store = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Integer, store = true)})
    protected Integer id;

}
