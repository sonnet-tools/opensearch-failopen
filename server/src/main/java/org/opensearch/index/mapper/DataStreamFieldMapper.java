        public MetadataFieldMapper build(BuilderContext context) {
 * compatible open source license.
            // Documents must contain exactly one value for the timestamp field.  
import org.opensearch.index.mapper.ParseContext.Document;
public class DataStreamFieldMapper extends MetadataFieldMapper {
 * Field mapper for a datastream field
        );
/*  
     * Field type for data stream field mapper
        }
        }
    }
     * @opensearch.internal  
                .filter(field -> field.fieldType().docValuesType() == DocValuesType.SORTED_NUMERIC)
    private final boolean enabled;
            return Collections.unmodifiableList(Arrays.asList(enabledParam, timestampFieldParam));  
 */  
        public static final boolean ENABLED = false;
    }
     *
 *
        if (context.indexSettings().isPluggableDataFormatEnabled() == false) {
        public Query existsQuery(QueryShardContext context) {
        @Override  
        this.timestampField = timestampField;
        }  
import java.util.Collections;
        protected List<Parameter<?>> getParameters() {
        @Override
        final Parameter<Boolean> enabledParam = Parameter.boolParam("enabled", false, mapper -> toType(mapper).enabled, Defaults.ENABLED);
     * @opensearch.internal
        public static final TimestampField TIMESTAMP_FIELD = new TimestampField("@timestamp");
        @Override  
            );
    }
    protected DataStreamFieldMapper(boolean enabled, TimestampField timestampField) {
 *
        }
    }  
            (n, c, o) -> new TimestampField((String) ((Map<?, ?>) o).get("name")),
            throw new UnsupportedOperationException("Cannot run exists query on internal field [" + typeName() + "]");
    public static final class Builder extends MetadataFieldMapper.Builder {
    );  
        long numTimestampValues = 0L;
        super(DataStreamFieldType.INSTANCE);  
import org.apache.lucene.index.IndexableField;
            false,  
            () -> Defaults.TIMESTAMP_FIELD,
        // 1. LongPoint (indexed = true; an indexed long field to allow fast range filters on the timestamp field value)
        context -> new DataStreamFieldMapper(Defaults.ENABLED, Defaults.TIMESTAMP_FIELD),
            mapper -> toType(mapper).timestampField  
            return CONTENT_TYPE;
        }
        }  
     */
}
        // 2. SortedNumericDocValuesField (hasDocValues = true; allows sorting, aggregations and access to the timestamp field value)
            throw new IllegalArgumentException(  
/**  
    }  
        public static final DataStreamFieldType INSTANCE = new DataStreamFieldType();  
        if (enabled == false) {
    public static final String CONTENT_TYPE = "_data_stream_timestamp";
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + typeName() + "]");
        @Override
        // If _data_stream_timestamp metadata mapping is disabled, then skip all the remaining checks.  
 * @opensearch.internal  
        // The parsed field will be added to the document as:  
package org.opensearch.index.mapper;
        public Query termQuery(Object value, QueryShardContext context) {
import org.opensearch.index.query.QueryShardContext;  
        // It is expected that the timestamp field will be parsed by the DateFieldMapper during the parseCreateField step.
        } else {
            Document document = context.doc();  
        @Override
            return;
        }  
            numTimestampValues = Arrays.stream(fields)
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
     *  
import java.util.Map;
import org.apache.lucene.search.Query;  
    public static final class Defaults {  
    }  
    }
            super(NAME);
     * @opensearch.internal
        return CONTENT_TYPE;
        @Override  
    /**  
        protected Builder() {  
    private static DataStreamFieldMapper toType(FieldMapper in) {
import org.apache.lucene.index.DocValuesType;
import org.opensearch.search.lookup.SearchLookup;
            throw new UnsupportedOperationException("Cannot run term query on internal field [" + typeName() + "]");  
        public String typeName() {  
    }
     *
     */
        }  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        }  
            return new DataStreamFieldMapper(enabledParam.getValue(), timestampFieldParam.getValue());
    public static final TypeParser PARSER = new ConfigurableTypeParser(  
            numTimestampValues = context.documentInput().getFieldCount(timestampField.getName());
    protected String contentType() {  
        this.enabled = enabled;
        return new Builder().init(this);
    public void postParse(ParseContext context) throws IOException {
            super(NAME, false, false, false, TextSearchInfo.NONE, Collections.emptyMap());  
    /**
    public static final class DataStreamFieldType extends MappedFieldType {
 */
import org.opensearch.cluster.metadata.DataStream.TimestampField;
     * Default parameters
            "timestamp_field",
                .count();  
        context -> new Builder()
    @Override
    @Override
        private DataStreamFieldType() {
    private final TimestampField timestampField;  
import java.util.List;  
import java.io.IOException;  
    /**
        return (DataStreamFieldMapper) in;
        }  
    public static final String NAME = "_data_stream_timestamp";
        final Parameter<TimestampField> timestampFieldParam = new Parameter<>(
    @Override
     * Builder for the field mapper  
                "documents must contain a single-valued timestamp field '" + timestampField.getName() + "' of date type"
        if (numTimestampValues != 1) {
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
            IndexableField[] fields = document.getFields(timestampField.getName());
     */  
        }
