                            + ", got "
                            + "expected "
                copyTo.build(),
        private static void validatePrecision(int precision) {
                return null;
/**
        if (value == null) {
            "precision",
        private final Parameter<Boolean> index = Parameter.indexParam(m -> false, false).setValidator(v -> {
    public static final class HllFieldType extends MappedFieldType {
            this.precision = precision;
import org.opensearch.index.fielddata.IndexFieldData;
                        + " and "
import java.util.List;
            if (context.parser().currentToken() == XContentParser.Token.VALUE_NULL) {
        BytesRef sketchBytes = new BytesRef(value);
        byte[] value = parseHllValue(context);
                new HllFieldType(buildFullName(context), precision.getValue(), meta.getValue()),
        }
     * @param sketchBytes the binary sketch data to validate
    }
                    throw new MapperParsingException(
                        + precision
            super(name);
     * @opensearch.internal
            if (!v) {
        public Query existsQuery(QueryShardContext context) {
    }
        return new Builder(n);
                name,
                    );
    }
            throw new MapperParsingException("Invalid HLL++ sketch data for field [" + fieldType().name() + "]", e);
    private HllFieldMapper(String simpleName, MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo, int precision) {
import org.apache.lucene.search.FieldExistsQuery;
            return Arrays.asList(precision, index, store, docValues, meta);
    }
}
        return CONTENT_TYPE;
public class HllFieldMapper extends ParametrizedFieldMapper {
        context.doc().add(new BinaryDocValuesField(fieldType().name(), sketchBytes));
 */
 * this file be licensed under the Apache-2.0 license or a
        public Builder(String name) {
    }
import org.opensearch.search.lookup.SearchLookup;
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
import org.opensearch.core.xcontent.XContentParser;
            return;
                );
        }
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
            }
        @Override
    private void validateSketchData(BytesRef sketchBytes) throws MapperParsingException {
        public String typeName() {
 * SPDX-License-Identifier: Apache-2.0
            return new FieldExistsQuery(name());
        try (StreamInput in = new BytesArray(sketchBytes.bytes, sketchBytes.offset, sketchBytes.length).streamInput()) {
            return precision;
                throw new MapperParsingException("Cannot disable [doc_values] on field of type [" + CONTENT_TYPE + "]");
        @Override
        protected List<Parameter<?>> getParameters() {
            }
    }
        }
        @Override
                throw new MapperParsingException("Cannot set [index] on field of type [" + CONTENT_TYPE + "]");
/*
        }
            super(name, false, false, true, TextSearchInfo.NONE, meta);
        ).setValidator(Builder::validatePrecision);
        });
     * Validates that the binary data is a valid HLL++ sketch by attempting to deserialize it.
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
    protected void parseCreateField(ParseContext context) throws IOException {
    /**
            failIfNoDocValues();
                            + precision
            // HLL sketches are stored as binary data and formatted as base64
                            + sketch.precision()
import org.apache.lucene.document.BinaryDocValuesField;
            return new HllFieldMapper(
            try (AbstractHyperLogLogPlusPlus sketch = AbstractHyperLogLogPlusPlus.readFrom(in, BigArrays.NON_RECYCLING_INSTANCE)) {
import org.opensearch.core.common.bytes.BytesArray;
    public static final String CONTENT_TYPE = "hll";
        return (HllFieldMapper) in;
     */
import org.opensearch.core.common.io.stream.StreamInput;
                    "precision must be between "
 * compatible open source license.
        private final Parameter<Boolean> docValues = Parameter.docValuesParam(m -> true, true).setValidator(v -> {
                precision.getValue()
import org.opensearch.index.fielddata.plain.HllFieldData;
    @Override
        }
                        "HLL++ sketch precision mismatch for field ["
        validateSketchData(sketchBytes);
            HyperLogLogPlusPlus.DEFAULT_PRECISION
     *
import org.apache.lucene.search.Query;
        this.precision = precision;
    /**
        }
            if (v) {
        @Override
            m -> toType(m).precision,
 * This field type stores pre-aggregated cardinality data using HLL++ sketch data structures.
 * The OpenSearch Contributors require contributions made to
 *
    }
            );
import org.opensearch.index.query.QueryShardContext;
        }
        }
import java.util.Map;
     * Builder for the HLL field mapper
        byte[] value = context.parseExternalValue(byte[].class);
import org.opensearch.search.DocValueFormat;
        @Override
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLog;
            return new DocValueFetcher(docValueFormat(format, null), searchLookup.doc().getForField(this));
            }
        private final Parameter<Boolean> store = Parameter.storeParam(m -> false, false).setValidator(v -> {
        // Doc values are always enabled for HLL fields (this is how the data is stored)
import java.time.ZoneId;
    private static HllFieldMapper toType(FieldMapper in) {
                throw new MapperParsingException("Cannot set [store] on field of type [" + CONTENT_TYPE + "]");
        // HLL fields are always stored as doc values and cannot be indexed or stored separately
            return new HllFieldData.Builder(name(), precision);
 *
    private byte[] parseHllValue(ParseContext context) throws IOException {
        }
        }
            return DocValueFormat.BINARY;
        } catch (MapperParsingException e) {
        public int precision() {
    private final int precision;
    /**
    });
        if (value == null) {
import java.util.function.Supplier;
            if (precision < AbstractHyperLogLog.MIN_PRECISION || precision > AbstractHyperLogLog.MAX_PRECISION) {
    public static class Builder extends ParametrizedFieldMapper.Builder {
                if (sketch.precision() != precision) {
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus;
import java.io.IOException;
            // This enables storage optimization when _source is disabled
import java.util.Arrays;
        public Query termQuery(Object value, QueryShardContext context) {
     * HLL field type
        private final Parameter<Integer> precision = Parameter.intParam(
            if (v) {
     *
        public HllFieldMapper build(BuilderContext context) {
        }
                // Verify the precision matches the field's configured precision
            // Support derived source by fetching from doc values
            throw new IllegalArgumentException("Term queries are not supported on [hll] fields");
     * @throws MapperParsingException if the data is not a valid HLL++ sketch
            throw e;
import org.opensearch.common.util.BigArrays;
 * It is intended for internal use by OpenSearch and its plugins (such as ISM for multi-tier rollup).
        });
        });
     * @opensearch.internal
 * @opensearch.internal
                multiFieldsBuilder.build(this, context),
                value = context.parser().binaryValue();
            }
            } else {
     *
    @Override
import org.opensearch.search.aggregations.metrics.HyperLogLogPlusPlus;
                        + AbstractHyperLogLog.MIN_PRECISION
    public HllFieldType fieldType() {
        }
        }
    public static final TypeParser PARSER = new TypeParser((n, c) -> {
        private final int precision;
        @Override
                        + ", got: "
        public HllFieldType(String name, int precision, Map<String, String> meta) {
        } catch (Exception e) {
     */
import org.apache.lucene.util.BytesRef;
    }
    protected String contentType() {
                }
            }
package org.opensearch.index.mapper;
        @Override
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
        @Override
        super(simpleName, mappedFieldType, multiFields, copyTo);
                            + fieldType().name()
            false,
        }
    @Override
        return new Builder(simpleName()).init(this);
     */
    }
        return value;
                throw new IllegalArgumentException(
    }
        return (HllFieldType) super.fieldType();
        }
                            + "]: "
 */
            }
    @Override
 * A {@link FieldMapper} for HyperLogLog++ sketch fields.
                        + AbstractHyperLogLog.MAX_PRECISION
        // HLL fields are intended for internal use by OpenSearch and plugins only.
            return CONTENT_TYPE;
