        }  
import org.opensearch.core.common.bytes.BytesReference;  
        if (stored == false && hasDocValues == false) {
    protected BinaryFieldMapper(
    }  
        }
        private final ArrayList<byte[]> bytesList;
 * @opensearch.internal  
        public List<Parameter<?>> getParameters() {
                bytes = (BytesReference) value;
        @Override
                    out.writeVInt(length);  // write total number of values  
import org.opensearch.index.query.QueryShardException;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.document.InvertableType;
    }  
            );  
import org.opensearch.search.DocValueFormat;
            return DocValueFormat.BINARY;
     * @opensearch.internal
        }  
                field = new CustomBinaryDocValuesField(fieldType().name(), value);  
            return SourceValueFetcher.identity(name(), context, format);
 * this file be licensed under the Apache-2.0 license or a
 *  
        }
                    for (byte[] value : bytesList) {
            } else {
            context.doc().add(new StoredField(fieldType().name(), value));  
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
    @Override
            return bytes;
import org.opensearch.index.fielddata.IndexFieldData;  
     * Builder for the binary field mapper
    public static final String CONTENT_TYPE = "binary";
        this.hasDocValues = builder.hasDocValues.getValue();
import org.apache.lucene.search.Query;
        @Override
        public BinaryFieldType(String name) {  
 */  
        }  
            BytesReference bytes;
        @Override
    public static final class BinaryFieldType extends MappedFieldType {  
            // but has no doc values so exists query will work on a field with
import org.opensearch.search.lookup.SearchLookup;  
import java.util.List;
            super(name);
        }
    }
 *
            return InvertableType.BINARY;  
/*
                return null;
            return;  
    private static BinaryFieldMapper toType(FieldMapper in) {  
        public Query termQuery(Object value, QueryShardContext context) {  
        @Override  
            this.hasDocValues.setValue(hasDocValues);  
        public BytesRef binaryValue() {
        // Benchmarks show that ArrayList performs much better
            failIfNoDocValues();
        byte[] value = context.parseExternalValue(byte[].class);
    }
                value = context.parser().binaryValue();
        @Override
        this.stored = builder.stored.getValue();
     *  
        if (value == null) {
 */
    @Override
import org.apache.lucene.util.BytesRef;
        checkStoredForDerivedSource();
/*  
            super(name);
            }
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
 * under the License.  
            add(bytes);  
            } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class BinaryFieldMapper extends ParametrizedFieldMapper {
    }
            return Arrays.asList(meta, stored, hasDocValues);
            if (value == null) {  
        Builder builder
        // Benchmarks are in CustomBinaryDocValuesFiledBenchmark  
            throw new QueryShardException(context, "Binary fields do not support searching");
            if (value instanceof BytesRef) {
            // Only add an entry to the field names field if the field is stored  
        @Override
                buildFullName(context),
     * Binary field type
            } else if (value instanceof byte[]) {  
     */  
            }
            @Override
        }
                CollectionUtils.sortAndDedup(bytesList, Arrays::compareUnsigned);
        return CONTENT_TYPE;
        private BinaryFieldType(String name, boolean isStored, boolean hasDocValues, Map<String, String> meta) {
        public CustomBinaryDocValuesField(String name, byte[] bytes) {  
        if (stored) {
        public void add(byte[] bytes) {  
        }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 *
        }
            return;
 * software distributed under the License is distributed on an
                bytes = new BytesArray((byte[]) value);
import java.util.Arrays;
        public StoredValue storedValue() {  
            } else if (value instanceof BytesReference) {
     * @opensearch.internal
            return new BinaryFieldMapper(name, bft, multiFieldsBuilder.build(this, context), copyTo.build(), this);
        public DocValueFormat docValueFormat(String format, ZoneId timeZone) {  
    public static class CustomBinaryDocValuesField extends CustomDocValuesField {
import org.opensearch.index.fielddata.plain.BytesBinaryIndexFieldData;
            }
import java.time.ZoneId;  
                meta.getValue()
            return null;
import org.apache.lucene.document.StoredField;
        if (hasDocValues) {  
 * Modifications Copyright OpenSearch Contributors. See
        @Override
import java.util.Base64;  
 * ownership. Elasticsearch licenses this file to you under  
        }  
                bytes = new BytesArray((BytesRef) value);  
                field.add(value);  
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
        super(simpleName, mappedFieldType, multiFields, copyTo);  
        // We considered using a TreeSet instead of an ArrayList here.  
/**  
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
        return new BinaryFieldMapper.Builder(simpleName()).init(this);  
    }
import org.apache.lucene.document.StoredValue;  
    /**
        MappedFieldType mappedFieldType,
 * KIND, either express or implied.  See the License for the
        public BytesReference valueForDisplay(Object value) {
}  
import java.util.Map;  
            try {  
            // no doc values
        }  
        };
        public Builder(String name, boolean hasDocValues) {
    protected void parseCreateField(ParseContext context) throws IOException {  
        if (value == null) {  
    private byte[] parseBinaryValue(ParseContext context) throws IOException {
            this(name, false, true, Collections.emptyMap());
 * license agreements. See the NOTICE file distributed with
    @Override
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.OpenSearchException;  
            public FieldValueType getDerivedFieldPreference() {
            this(name, false);
/*  
            }
        context.documentInput().addField(fieldType(), value);
        }
                // sort and dedup in place
        public String typeName() {
            super(name, false, isStored, hasDocValues, TextSearchInfo.NONE, meta);  
        // For details, see: https://github.com/opensearch-project/OpenSearch/pull/9426
            }
import java.util.Collections;
        @Override
        return new DerivedFieldGenerator(mappedFieldType, null, new StoredFieldFetcher(mappedFieldType, simpleName())) {  
                        int valueLength = value.length;
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
        public BinaryFieldMapper build(BuilderContext context) {  
            createFieldNamesField(context);  
    protected DerivedFieldGenerator derivedFieldGenerator() {
    }
 * You may obtain a copy of the License at  
                hasDocValues.getValue(),
        @Override  
     * Custom binary doc values field for the binary field mapper  
    private final boolean stored;
            final BinaryFieldType bft = new BinaryFieldType(
    }  
 * The OpenSearch Contributors require contributions made to  
        public Builder(String name) {  
     */
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                int size = bytesList.stream().map(b -> b.length).reduce(0, Integer::sum);  
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.index.query.QueryShardContext;
                context.doc().addWithKey(fieldType().name(), field);
                        out.writeVInt(valueLength);  
import org.opensearch.core.common.bytes.BytesArray;
                bytes = new BytesArray(Base64.getDecoder().decode(value.toString()));  
 * this work for additional information regarding copyright
        byte[] value = parseBinaryValue(context);  
                int length = bytesList.size();
            if (context.parser().currentToken() == XContentParser.Token.VALUE_NULL) {
     *  
                }
                stored.getValue(),  
                    return out.bytes().toBytesRef();  
        }
            CustomBinaryDocValuesField field = (CustomBinaryDocValuesField) context.doc().getByKey(fieldType().name());
    /**
import java.util.function.Supplier;
    @Override
        }  
 * GitHub history for details.
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        }  
        } else {
        }
    }
    }
        @Override
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, false);  
     */
 * compatible open source license.
    public static class Builder extends ParametrizedFieldMapper.Builder {  
import java.util.ArrayList;
        CopyTo copyTo,  
    @Override  
        byte[] value = parseBinaryValue(context);
 * A mapper for binary fields
                        out.writeBytes(value, 0, valueLength);
                try (BytesStreamOutput out = new BytesStreamOutput(size + (length + 1) * 5)) {
package org.opensearch.index.mapper;
            return new BytesBinaryIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
        }
                throw new OpenSearchException("Failed to get binary value", e);  
     * @opensearch.internal
        }
                    }
            return;
     *
    /**
        }
        return value;
        public InvertableType invertableType() {
                return null;
        }  
            bytesList = new ArrayList<>();
 * specific language governing permissions and limitations
 */  
        if (value == null) {
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
    private final boolean hasDocValues;  
 * not use this file except in compliance with the License.
        @Override
        return (BinaryFieldMapper) in;
    }  
        MultiFields multiFields,
        }
            return CONTENT_TYPE;  
    protected String contentType() {
        }
            } catch (IOException e) {
                return FieldValueType.STORED;  
import org.opensearch.core.xcontent.XContentParser;
    ) {
            if (field == null) {
        String simpleName,  
import org.opensearch.core.common.util.CollectionUtils;
            bytesList.add(bytes);
            }
    protected void canDeriveSourceInternal() {  
            } else {
        }
    @Override
