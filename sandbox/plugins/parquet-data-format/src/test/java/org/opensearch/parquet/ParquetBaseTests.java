 * SPDX-License-Identifier: Apache-2.0
        }
    protected NumberFieldMapper.NumberFieldType createNumberField(String name, NumberFieldMapper.NumberType type) {  
        IdFieldMapper.CONTENT_TYPE,
        public String typeName() {
        @Override
    static {  
        VERSION_FIELD.setCapabilityMap(Map.of(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of(COLUMNAR_STORAGE)));
        TextSearchInfo.SIMPLE_MATCH_ONLY,
    }
        fields.add(new Field(SeqNoFieldMapper.PRIMARY_TERM_NAME, FieldType.notNullable(new ArrowType.Int(64, true)), null));
    }
        return fields;
        return keywordFieldType;  
import java.nio.charset.StandardCharsets;
import org.opensearch.index.engine.dataformat.DataFormat;
    public static final MappedFieldType SEQ_NO_FIELD = new NumberFieldMapper.NumberFieldType(  
import org.opensearch.index.mapper.TextSearchInfo;  
        public Query termQuery(Object value, QueryShardContext context) {
    ) {
        input.addField(VERSION_FIELD, 1L);
    );  
        fields.add(new Field(VersionFieldMapper.NAME, FieldType.notNullable(new ArrowType.Int(64, true)), null));  
package org.opensearch.parquet;
    public static final MappedFieldType PRIMARY_TERM_FIELD = new NumberFieldMapper.NumberFieldType(
    };
}
import org.apache.arrow.vector.types.pojo.FieldType;  
        Map.of()  
    }
    protected void populateMetadataFields(ParquetDocumentInput input) {
            return IdFieldMapper.CONTENT_TYPE;  
import org.opensearch.index.mapper.MappedFieldType;  
import org.opensearch.index.mapper.VersionFieldMapper;
        SeqNoFieldMapper.NAME,
    protected void assignTestCapabilities(MappedFieldType fieldType, DataFormat format) {
        KeywordFieldMapper.KeywordFieldType keywordFieldType = new KeywordFieldMapper.KeywordFieldType(name);
        SEQ_NO_FIELD.setCapabilityMap(Map.of(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of(COLUMNAR_STORAGE)));
    }
        NumberFieldMapper.NumberFieldType numberFieldType = new NumberFieldMapper.NumberFieldType(name, type);
import java.util.Set;  
        }
        return numberFieldType;  
        VersionFieldMapper.NAME,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.apache.arrow.vector.types.pojo.Field;
        ID_FIELD.setCapabilityMap(Map.of(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of(COLUMNAR_STORAGE)));  
 *
        true,
    }  
    protected KeywordFieldMapper.KeywordFieldType createKeywordField(String name) {  
        NumberFieldMapper.NumberType.LONG
        List<Field> fields = new ArrayList<>();
    public static final MappedFieldType ID_FIELD = new MappedFieldType(  
        @Override
import org.apache.arrow.vector.types.pojo.ArrowType;
            return null;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
        SeqNoFieldMapper.PRIMARY_TERM_NAME,  
import org.opensearch.index.mapper.IdFieldMapper;
        input.addField(ID_FIELD, "id".getBytes(StandardCharsets.UTF_8));  
    );
public abstract class ParquetBaseTests extends OpenSearchTestCase {
import org.opensearch.search.lookup.SearchLookup;
        NumberFieldMapper.NumberType.LONG
import org.opensearch.test.OpenSearchTestCase;  
        assignTestCapabilities(keywordFieldType, ParquetDataFormatPlugin.PARQUET_DATA_FORMAT);
import java.util.Map;
        PRIMARY_TERM_FIELD.setCapabilityMap(Map.of(ParquetDataFormatPlugin.PARQUET_DATA_FORMAT, Set.of(COLUMNAR_STORAGE)));
        fields.add(new Field(SeqNoFieldMapper.NAME, FieldType.notNullable(new ArrowType.Int(64, true)), null));
        }  
import org.opensearch.index.query.QueryShardContext;  
    );
import org.apache.lucene.search.Query;
        true,  
/*  
    }
    public static final MappedFieldType VERSION_FIELD = new NumberFieldMapper.NumberFieldType(
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
        input.addField(SEQ_NO_FIELD, 100L);
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.index.mapper.SeqNoFieldMapper;
import org.opensearch.index.engine.dataformat.DataFormatTestUtils;  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
 * compatible open source license.
        input.addField(PRIMARY_TERM_FIELD, 1L);
    public static List<Field> metadataFields() {
import org.opensearch.parquet.writer.ParquetDocumentInput;
import java.util.ArrayList;  
        fields.add(new Field(IdFieldMapper.NAME, FieldType.notNullable(new ArrowType.Binary()), null));  
        @Override  
        assignTestCapabilities(numberFieldType, ParquetDataFormatPlugin.PARQUET_DATA_FORMAT);
import org.opensearch.index.mapper.ValueFetcher;
        DataFormatTestUtils.assignTestCapabilities(fieldType, format);  
        true,
        NumberFieldMapper.NumberType.LONG  
 */  
            return null;
