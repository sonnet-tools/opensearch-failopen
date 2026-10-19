                            + "expected "
     * @throws MapperParsingException if the data is not a valid HLL++ sketch
    }  
                return null;
            try (AbstractHyperLogLogPlusPlus sketch = AbstractHyperLogLogPlusPlus.readFrom(in, BigArrays.NON_RECYCLING_INSTANCE)) {  
}
            "precision",  
    /**
        byte[] value = context.parseExternalValue(byte[].class);
 * compatible open source license.
        }
 * It is intended for internal use by OpenSearch and its plugins (such as ISM for multi-tier rollup).
        }  
        return (HllFieldType) super.fieldType();
                }  
    }  
            }
                    throw new MapperParsingException(  
        @Override  
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLog;
    }
    private byte[] parseHllValue(ParseContext context) throws IOException {
    }
            // HLL sketches are stored as binary data and formatted as base64  
        } catch (MapperParsingException e) {
        public int precision() {
        @Override  
/**
 */  
    }
            false,
                copyTo.build(),
        public String typeName() {
import org.apache.lucene.search.Query;  
        private final Parameter<Integer> precision = Parameter.intParam(
import org.opensearch.core.common.bytes.BytesArray;  
            }  
        });  
            // Support derived source by fetching from doc values
        }  
            throw e;  
            super(name, false, false, true, TextSearchInfo.NONE, meta);
                new HllFieldType(buildFullName(context), precision.getValue(), meta.getValue()),  
                value = context.parser().binaryValue();
    /**
    protected String contentType() {  
                        + ", got: "
    protected void parseCreateField(ParseContext context) throws IOException {
     */
        }
        }
                );  
            }
import java.time.ZoneId;
        }  
        @Override  
     * @opensearch.internal
        }  
        private static void validatePrecision(int precision) {  
     *  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.fielddata.IndexFieldData;  
     */  
            return CONTENT_TYPE;
     * HLL field type
    private static HllFieldMapper toType(FieldMapper in) {  
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();  
    @Override
            }
                // Verify the precision matches the field's configured precision
        super(simpleName, mappedFieldType, multiFields, copyTo);  
            }
                        + AbstractHyperLogLog.MIN_PRECISION
        public Builder(String name) {
        }  
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus;
import org.apache.lucene.document.BinaryDocValuesField;
            throw new IllegalArgumentException("Term queries are not supported on [hll] fields");
import org.opensearch.search.aggregations.metrics.HyperLogLogPlusPlus;  
        context.doc().add(new BinaryDocValuesField(fieldType().name(), sketchBytes));
                        + " and "
     */
        // HLL fields are always stored as doc values and cannot be indexed or stored separately
                name,
 * this file be licensed under the Apache-2.0 license or a
    private final int precision;  
        protected List<Parameter<?>> getParameters() {
                            + ", got "  
    private HllFieldMapper(String simpleName, MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo, int precision) {
                throw new IllegalArgumentException(
    public static class Builder extends ParametrizedFieldMapper.Builder {  
    }
        public HllFieldMapper build(BuilderContext context) {  
    public static final String CONTENT_TYPE = "hll";
        ).setValidator(Builder::validatePrecision);
        @Override  
        byte[] value = parseHllValue(context);  
        this.precision = precision;
            }
                    );
            // This enables storage optimization when _source is disabled  
        return new Builder(simpleName()).init(this);  
                    "precision must be between "  
        });  
            if (precision < AbstractHyperLogLog.MIN_PRECISION || precision > AbstractHyperLogLog.MAX_PRECISION) {
        @Override
        if (value == null) {  
        // HLL fields are intended for internal use by OpenSearch and plugins only.  
import org.opensearch.core.common.io.stream.StreamInput;
        }
     * @opensearch.internal
        }
            m -> toType(m).precision,
import org.opensearch.index.fielddata.plain.HllFieldData;
import org.opensearch.core.xcontent.XContentParser;
        @Override
 *
        return (HllFieldMapper) in;
            );
 */
        if (value == null) {
            throw new MapperParsingException("Invalid HLL++ sketch data for field [" + fieldType().name() + "]", e);
            return;
package org.opensearch.index.mapper;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
import org.opensearch.search.lookup.SearchLookup;
    @Override  
import org.opensearch.common.util.BigArrays;
 * A {@link FieldMapper} for HyperLogLog++ sketch fields.
        return value;
 * @opensearch.internal  
                        "HLL++ sketch precision mismatch for field ["
                throw new MapperParsingException("Cannot set [store] on field of type [" + CONTENT_TYPE + "]");
        }  
        validateSketchData(sketchBytes);  
                            + "]: "  
            return new HllFieldData.Builder(name(), precision);
    });
        private final int precision;
import org.opensearch.search.DocValueFormat;  
        return new Builder(n);
                            + precision
        } catch (Exception e) {
        }
import java.io.IOException;  
/*  
 * This field type stores pre-aggregated cardinality data using HLL++ sketch data structures.  
        }
            if (!v) {
        return CONTENT_TYPE;
            return new FieldExistsQuery(name());  
        BytesRef sketchBytes = new BytesRef(value);
import org.apache.lucene.util.BytesRef;
                throw new MapperParsingException("Cannot disable [doc_values] on field of type [" + CONTENT_TYPE + "]");
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.FieldExistsQuery;
            HyperLogLogPlusPlus.DEFAULT_PRECISION  
                        + AbstractHyperLogLog.MAX_PRECISION  
            return Arrays.asList(precision, index, store, docValues, meta);
        @Override
                multiFieldsBuilder.build(this, context),
    }
        });
            return precision;  
    }
                            + fieldType().name()
    }
                if (sketch.precision() != precision) {
import org.opensearch.index.query.QueryShardContext;
        public Query existsQuery(QueryShardContext context) {
     * @param sketchBytes the binary sketch data to validate
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
            if (context.parser().currentToken() == XContentParser.Token.VALUE_NULL) {
     *  
        private final Parameter<Boolean> index = Parameter.indexParam(m -> false, false).setValidator(v -> {
            return DocValueFormat.BINARY;
    }
            return new DocValueFetcher(docValueFormat(format, null), searchLookup.doc().getForField(this));
        public HllFieldType(String name, int precision, Map<String, String> meta) {
    private void validateSketchData(BytesRef sketchBytes) throws MapperParsingException {
import java.util.Arrays;
            this.precision = precision;  
        @Override
            super(name);  
    @Override
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    public HllFieldType fieldType() {
     * Builder for the HLL field mapper
            return new HllFieldMapper(
        private final Parameter<Boolean> store = Parameter.storeParam(m -> false, false).setValidator(v -> {
                throw new MapperParsingException("Cannot set [index] on field of type [" + CONTENT_TYPE + "]");
public class HllFieldMapper extends ParametrizedFieldMapper {
import java.util.function.Supplier;
                            + sketch.precision()
        private final Parameter<Boolean> docValues = Parameter.docValuesParam(m -> true, true).setValidator(v -> {  
import java.util.Map;
    @Override
     *  
    public static final TypeParser PARSER = new TypeParser((n, c) -> {
        }
        // Doc values are always enabled for HLL fields (this is how the data is stored)
     * Validates that the binary data is a valid HLL++ sketch by attempting to deserialize it.
 *
            if (v) {  
import java.util.List;  
            failIfNoDocValues();  
        public Query termQuery(Object value, QueryShardContext context) {
    /**
        }
            if (v) {  
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
    public static final class HllFieldType extends MappedFieldType {  
                        + precision
            } else {  
        try (StreamInput in = new BytesArray(sketchBytes.bytes, sketchBytes.offset, sketchBytes.length).streamInput()) {
                precision.getValue()  
