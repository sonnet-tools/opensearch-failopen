                KeywordFieldMapper.KeywordFieldType rawValueField = keywordFieldMapper.getRawValueFieldType();
            || mapper instanceof IndexFieldMapper
        LongParquetField longField = new LongParquetField(false);
        fields.add(new Field(SeqNoFieldMapper.PRIMARY_TERM_NAME, new LongParquetField(false).getFieldType(), null));  
    ) {
import org.opensearch.index.mapper.Mapper;  
                if (isUnsupportedMetadataField(mapper)) {  
            || Objects.equals(mapper.typeName(), "_data_stream_timestamp");
    private static boolean isUnsupportedMetadataField(Mapper mapper) {
                    logger.debug("Skipping unsupported metadata field: [{}] of type [{}]", mapper.name(), mapper.typeName());
    private static final Logger logger = LogManager.getLogger(ArrowSchemaBuilder.class);
import org.opensearch.index.mapper.IndexFieldMapper;  
     * ({@link MappedFieldType#isMultiValued()}) is emitted as a {@code LIST<element>} column;  
        ParquetField parquetField,
    private ArrowSchemaBuilder() {}  
     * TODO - Get the mapping version while creating the schema
    public static Schema getSchema(MapperService mapperService) {  
import org.opensearch.index.mapper.NestedPathFieldMapper;
        List<Field> fields,
     * Creates an Arrow Schema from the MapperService.  
                                + "] of type ["  
                    boolean multiValue = isMultiValued(mapper);
    /**
        if (documentMapper != null) {
import java.util.Objects;  
     */
                }  
import org.apache.arrow.vector.types.pojo.Schema;
        fields.add(new Field(DocumentInput.ROW_ID_FIELD, longField.getFieldType(), null));
        Objects.requireNonNull(mapperService, "MapperService cannot be null");
    /** Reads the {@code multi_value} declaration from the mapper's field type. */  
    }
        // Add row ID field (long)  
                    if (multiValue && parquetField.supportsMultiValue() == false) {
                    fields.add(parquetField.toArrowField(mapper.name(), multiValue));
 * The OpenSearch Contributors require contributions made to  
                ParquetField parquetField = ArrowFieldRegistry.getParquetField(mapper.typeName());
    }  
        DocumentMapper documentMapper,  
 */
import org.opensearch.index.mapper.DocumentMapper;  
        }
                                + mapper.name()
import org.opensearch.index.mapper.FieldNamesFieldMapper;
        List<Field> fields = new ArrayList<>();
                        );  
     * <p>A field whose mapper declares {@code multi_value: true}
                    logger.debug("No ParquetField registered for field: [{}] of type [{}]", mapper.name(), mapper.typeName());
import org.opensearch.index.mapper.KeywordFieldMapper;
                    }
 *
        }  
                } else {
            || Objects.equals(mapper.typeName(), "_feature")
        boolean multiValue  
                        throw new IllegalArgumentException(  
                }  
                // it must mirror the parent's cardinality or source reconstruction would lose values.  
/**
import java.util.ArrayList;
            || mapper instanceof NestedPathFieldMapper  
     * every other field keeps its scalar column.
        Mapper mapper,
}
public final class ArrowSchemaBuilder {
                    handleNormalizedField(mapper, documentMapper, fields, parquetField, multiValue);  
import org.opensearch.index.mapper.FieldMapper;
            }
     *  
import org.opensearch.index.engine.dataformat.DocumentInput;
                                + mapper.typeName()
        return mapper instanceof SourceFieldMapper  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
        return mapper instanceof FieldMapper fieldMapper && fieldMapper.fieldType().isMultiValued();
 * SPDX-License-Identifier: Apache-2.0
                            "Field ["
            || mapper instanceof FieldNamesFieldMapper
import org.opensearch.index.mapper.MapperService;
        return new Schema(fields);
     *
            }
import java.util.List;
 * Builds Apache Arrow schemas from OpenSearch MapperService field mappings.  
    private static void handleNormalizedField(
            if (!documentMapper.mappers().isMultiField(mapper.name()) && keywordFieldMapper.getRawValueFieldType() != null) {  
 * compatible open source license.
package org.opensearch.parquet.fields;
import org.opensearch.index.mapper.SourceFieldMapper;
    }
/*  
import org.opensearch.parquet.fields.core.data.number.LongParquetField;
                fields.add(parquetField.toArrowField(rawValueField.name(), multiValue));
 */  
                if (parquetField != null) {  
        if (mapper instanceof KeywordFieldMapper keywordFieldMapper) {
import org.apache.arrow.vector.types.pojo.Field;
import org.opensearch.index.mapper.MappedFieldType;
                    continue;
            for (Mapper mapper : documentMapper.mappers()) {
import org.apache.logging.log4j.LogManager;  
                // The raw-value companion holds the pre-normalization source for derived source, so
     * @param mapperService the mapper service containing field mappings
    }  
    private static boolean isMultiValued(Mapper mapper) {
import org.apache.logging.log4j.Logger;
                                + "] does not support [multi_value] storage in the parquet data format"
 * this file be licensed under the Apache-2.0 license or a
        DocumentMapper documentMapper = mapperService.documentMapperWithAutoCreate().getDocumentMapper();  
