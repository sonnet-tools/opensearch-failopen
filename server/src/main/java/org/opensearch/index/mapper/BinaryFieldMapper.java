            failIfNoDocValues();
        @Override
                return null;
        @Override
        }
            // Only add an entry to the field names field if the field is stored
        } else {
    }
        return new BinaryFieldMapper.Builder(simpleName()).init(this);
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        return (BinaryFieldMapper) in;
    public static class CustomBinaryDocValuesField extends CustomDocValuesField {
            throw new QueryShardException(context, "Binary fields do not support searching");
import org.apache.lucene.document.InvertableType;
                try (BytesStreamOutput out = new BytesStreamOutput(size + (length + 1) * 5)) {
                bytes = new BytesArray((byte[]) value);
     * @opensearch.internal
                meta.getValue()
import org.apache.lucene.document.StoredField;
import java.util.Arrays;
     *
        public Builder(String name, boolean hasDocValues) {
import org.opensearch.index.fielddata.plain.BytesBinaryIndexFieldData;
/**
            if (context.parser().currentToken() == XContentParser.Token.VALUE_NULL) {
            this(name, false);
            super(name);
        CopyTo copyTo,
     * @opensearch.internal
            } else {
    private final boolean hasDocValues;
        }
            } else {
import org.opensearch.index.query.QueryShardException;
        public Builder(String name) {
        super(simpleName, mappedFieldType, multiFields, copyTo);
            } else {
import java.util.function.Supplier;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public BytesReference valueForDisplay(Object value) {
                buildFullName(context),
                        int valueLength = value.length;
            return null;
                stored.getValue(),
import org.apache.lucene.document.StoredValue;
                        out.writeVInt(valueLength);
                    out.writeVInt(length);  // write total number of values
 * A mapper for binary fields
     * Custom binary doc values field for the binary field mapper
    }
                bytes = new BytesArray(Base64.getDecoder().decode(value.toString()));
        if (value == null) {
    }
            createFieldNamesField(context);
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
 * the Apache License, Version 2.0 (the "License"); you may
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
    @Override
        @Override
            if (value == null) {
    }
 * KIND, either express or implied.  See the License for the
        // We considered using a TreeSet instead of an ArrayList here.
        public String typeName() {
public class BinaryFieldMapper extends ParametrizedFieldMapper {
     * Binary field type
    protected void canDeriveSourceInternal() {
 * under the License.
import org.opensearch.common.io.stream.BytesStreamOutput;
        }
 */
        if (value == null) {
/*
    }
            context.doc().add(new StoredField(fieldType().name(), value));
 * SPDX-License-Identifier: Apache-2.0
        if (stored == false && hasDocValues == false) {
        this.stored = builder.stored.getValue();
 *
        this.hasDocValues = builder.hasDocValues.getValue();
            );
        }
        }
        public List<Parameter<?>> getParameters() {
        }
        }
            } else if (value instanceof byte[]) {
/*
        }
        }
                bytes = new BytesArray((BytesRef) value);
 * The OpenSearch Contributors require contributions made to
        public BytesRef binaryValue() {
        // For details, see: https://github.com/opensearch-project/OpenSearch/pull/9426
            add(bytes);
    }
    @Override
        Builder builder
        public void add(byte[] bytes) {
    /**
                        out.writeBytes(value, 0, valueLength);
 * ownership. Elasticsearch licenses this file to you under
        @Override
        };
    @Override
            bytesList.add(bytes);
import org.opensearch.index.fielddata.IndexFieldData;
                return FieldValueType.STORED;
    ) {
            }
        return new DerivedFieldGenerator(mappedFieldType, null, new StoredFieldFetcher(mappedFieldType, simpleName())) {
            return CONTENT_TYPE;
        @Override
            // but has no doc values so exists query will work on a field with
            this.hasDocValues.setValue(hasDocValues);
import org.opensearch.search.DocValueFormat;
                return null;
        }
        public CustomBinaryDocValuesField(String name, byte[] bytes) {
        private BinaryFieldType(String name, boolean isStored, boolean hasDocValues, Map<String, String> meta) {
            return Arrays.asList(meta, stored, hasDocValues);
        private final ArrayList<byte[]> bytesList;
import org.opensearch.index.query.QueryShardContext;
    /**
            if (field == null) {
    }
     */
                int size = bytesList.stream().map(b -> b.length).reduce(0, Integer::sum);
 * Unless required by applicable law or agreed to in writing,
        }
        }
/*
                context.doc().addWithKey(fieldType().name(), field);
import org.opensearch.core.common.bytes.BytesReference;
     * @opensearch.internal
        if (hasDocValues) {
        }
        MappedFieldType mappedFieldType,
        }
     */
     *
     */
                // sort and dedup in place
    public static class Builder extends ParametrizedFieldMapper.Builder {
import java.util.Map;
 *
            @Override
    protected BinaryFieldMapper(
        if (value == null) {
            return;
 *
        }
            return InvertableType.BINARY;
            public FieldValueType getDerivedFieldPreference() {
    }
import org.opensearch.core.xcontent.XContentParser;
import java.io.IOException;
     * Builder for the binary field mapper
                CollectionUtils.sortAndDedup(bytesList, Arrays::compareUnsigned);
                    return out.bytes().toBytesRef();
        return value;
 * not use this file except in compliance with the License.
                field = new CustomBinaryDocValuesField(fieldType().name(), value);
        if (stored) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        }
        checkStoredForDerivedSource();
        @Override
            return;
        public InvertableType invertableType() {
            }
            return bytes;
            super(name, false, isStored, hasDocValues, TextSearchInfo.NONE, meta);
import java.time.ZoneId;
            // no doc values
        public BinaryFieldMapper build(BuilderContext context) {
            } catch (IOException e) {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    private static BinaryFieldMapper toType(FieldMapper in) {
        }
package org.opensearch.index.mapper;
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            return new BytesBinaryIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
import java.util.Base64;
    protected DerivedFieldGenerator derivedFieldGenerator() {
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
        public StoredValue storedValue() {
            }
                throw new OpenSearchException("Failed to get binary value", e);
            return DocValueFormat.BINARY;
 * compatible open source license.
 *
                    }
        MultiFields multiFields,
import org.apache.lucene.search.Query;
        @Override
}
            this(name, false, true, Collections.emptyMap());
            if (value instanceof BytesRef) {
    private final boolean stored;
                value = context.parser().binaryValue();
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
    public static final String CONTENT_TYPE = "binary";
            try {
        @Override
    private byte[] parseBinaryValue(ParseContext context) throws IOException {
        // Benchmarks are in CustomBinaryDocValuesFiledBenchmark
    protected void parseCreateField(ParseContext context) throws IOException {
        public BinaryFieldType(String name) {
            final BinaryFieldType bft = new BinaryFieldType(
    }
            bytesList = new ArrayList<>();
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, false);
    @Override
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
            }
 * Licensed to Elasticsearch under one or more contributor
        @Override
        public Query termQuery(Object value, QueryShardContext context) {
                hasDocValues.getValue(),
        String simpleName,
            return;
            super(name);
        // Benchmarks show that ArrayList performs much better
            } else if (value instanceof BytesReference) {
    public static final class BinaryFieldType extends MappedFieldType {
        @Override
 * GitHub history for details.
import java.util.Collections;
            return SourceValueFetcher.identity(name(), context, format);
 */
    @Override
        context.documentInput().addField(fieldType(), value);
                int length = bytesList.size();
 */
                    for (byte[] value : bytesList) {
            return new BinaryFieldMapper(name, bft, multiFieldsBuilder.build(this, context), copyTo.build(), this);
            }
        }
import org.opensearch.core.common.bytes.BytesArray;
        }
 * license agreements. See the NOTICE file distributed with
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
import java.util.List;
            BytesReference bytes;
    }
 * @opensearch.internal
    protected String contentType() {
 * specific language governing permissions and limitations
                field.add(value);
    @Override
        }
            }
    }
import org.opensearch.search.lookup.SearchLookup;
        byte[] value = context.parseExternalValue(byte[].class);
import org.opensearch.core.common.util.CollectionUtils;
        return CONTENT_TYPE;
import org.opensearch.OpenSearchException;
 * You may obtain a copy of the License at
        @Override
     *
        byte[] value = parseBinaryValue(context);
                bytes = (BytesReference) value;
        }
    }
        }
 */
 * software distributed under the License is distributed on an
import java.util.ArrayList;
import org.apache.lucene.util.BytesRef;
            CustomBinaryDocValuesField field = (CustomBinaryDocValuesField) context.doc().getByKey(fieldType().name());
 * this file be licensed under the Apache-2.0 license or a
                }
        byte[] value = parseBinaryValue(context);
    /**
