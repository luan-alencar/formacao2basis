package com.basis.campina.xtarefas.domain.elastic;

import com.basis.campina.xtarefas.domain.Tarefa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.*;

@Getter
@Setter
@Document(indexName = "index-anexo")
@NoArgsConstructor
public class AnexoDocument extends BaseDocument {

    @MultiField(mainField = @Field(type = FieldType.Text,
            store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text,
                    store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String file;


    @MultiField(mainField = @Field(type = FieldType.Text,
            store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text,
                    store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String filename;

    @MultiField(mainField = @Field(type = FieldType.Text,
            store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text,
                    store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String uuid;

    @MultiField(mainField = @Field(type = FieldType.Text,
            store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true),
            otherFields = {@InnerField(suffix = SORT, type = FieldType.Text,
                    store = true, analyzer = TRIM_CASE_INSENSITIVE, fielddata = true)})
    private String tarefaID;

    public AnexoDocument(Integer id, String file, String filename, String uuid, Tarefa tarefaID) {
        this.id = id;
        this.file = file;
        this.uuid = uuid;
        this.filename = filename;
        this.tarefaID = tarefaID.getId().toString();
    }
}


