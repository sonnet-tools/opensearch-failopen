            XContentParser.Token token = context.parser().currentToken();
            if (lowerTerm == null) {
                if (!includeLower || !includeUpper) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.getSettings()));  
    public static class Builder extends ParametrizedFieldMapper.Builder {
                buildFullName(context),  
        return (BooleanFieldType) super.fieldType();
            return new SortedNumericIndexFieldData.Builder(name(), NumericType.BOOLEAN);
 */
 *
        if (hasDocValues) {  
                return new MatchNoDocsQuery();  
        @Override
                protected Boolean parseSourceValue(Object value) {  
 * @opensearch.internal  
                return val == 1;
                return new MatchNoDocsQuery();  
        @Override
                    distinct |= 1;
        }
import org.apache.lucene.index.IndexOptions;
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
            createFieldNamesField(context);  
    private final boolean indexed;  
        this.nullValue = builder.nullValue.getValue();  
     * <p>
                default:  
    @Override  
                    return termQuery("false", context);  
        Boolean value = context.parseExternalValue(Boolean.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 */  
            return new SourceValueFetcher(name(), context, nullValue) {
 * this work for additional information regarding copyright
public class BooleanFieldMapper extends ParametrizedFieldMapper {
                    return true;
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            switch (value.toString()) {
            }  
                }
     *  
            );  
            return DocValueFormat.BOOLEAN;  
            }
        if (value == null) {  
                return null;
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
            FIELD_TYPE.setTokenized(false);
    }
            ft.setBoost(boost.getValue());
                    return this.existsQuery(context);
        return value;
            }
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);
        @Override
        return new DerivedFieldGenerator(mappedFieldType, new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()) {  
     *
    @Override  
            }
                    return termQuery("true", context);
        @Override
        }  
    private final boolean hasDocValues;
            this(name, searchable, false, hasDocValues, false, Collections.emptyMap());
            return Arrays.asList(meta, boost, docValues, indexed, nullValue, stored);  
        Builder builder  
import org.apache.lucene.search.MatchNoDocsQuery;
            }
import org.apache.lucene.util.BytesRef;
            failIfNotIndexedAndNoDocValues();
        protected FieldTypeCapabilities.Capability searchCapability() {  
        private final Parameter<Boolean> docValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
            return CONTENT_TYPE;
        }  
import org.apache.lucene.search.BoostQuery;
            FIELD_TYPE.setOmitNorms(true);  
 * Unless required by applicable law or agreed to in writing,
     *    1. Result will be in boolean type and not in the provided string value type at time of ingestion,
                docValues.getValue(),  
            FIELD_TYPE.freeze();  
import org.opensearch.index.query.QueryShardContext;
        public BooleanFieldType(
        }  
            () -> null,
import java.util.Arrays;
package org.opensearch.index.mapper;
            public Object convert(Object value) {
     * @opensearch.internal  
                case 1:
        if (value == null) {  
     * 2. If doc_values is disabled in field mapping, then build source using stored field  
        public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {  
            if (token == XContentParser.Token.VALUE_NULL) {
                    return false;  
            } else if (!includeLower) {
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"  
    }  
            failIfNoDocValues();
        }  
 */
    }
            if (lowerTerm.equals(Values.TRUE)) {
            }  
        }  
     *    2. When using doc values, for multi value field, result will be in sorted order, i.e. at start there will  
            Map<String, String> meta
            if (format != null) {  
            Set<?> distinctValues = new HashSet<>(values);
        checkStoredAndDocValuesForDerivedSource();
/*  
import java.io.IOException;
import org.opensearch.search.lookup.SearchLookup;  
            if (value == null) {
 *
    public static final class BooleanFieldType extends TermBasedFieldType {
                if (distinct == 3) {  
import java.util.List;
                    throw new IllegalArgumentException("Can't parse boolean value [" + sValue + "], expected [true] or [false]");
import org.apache.lucene.document.Field;
 * You may obtain a copy of the License at  
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());
import java.util.HashSet;  
                indexed.getValue(),
     *
                        return Booleans.parseBooleanStrict(textValue, false);
    }
import java.util.Map;
            }
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;  
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);
    public BooleanFieldType fieldType() {
        }  
     * Builder for this field mapper
            if (boost() != 1f) {
        public BooleanFieldType(String name, boolean searchable) {  
    @Override
            } else {  
                lowerTerm = false;  
        public static final BytesRef FALSE = new BytesRef("F");
            }
 * GitHub history for details.
                throw new IllegalArgumentException(
            }
            int distinct = 0;
            return query;
import org.apache.lucene.document.SortedNumericDocValuesField;  
        }  
                return termQuery(lowerTerm.equals(Values.TRUE), context);
                @Override
     * @opensearch.internal
        }
        static {
                    return Values.TRUE;  
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {  
     * @opensearch.internal
                return this.existsQuery(context);  
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                return SortedNumericDocValuesField.newSlowExactQuery(name(), Values.TRUE.bytesEquals(indexedValueForSearch(value)) ? 1 : 0);
            "null_value",  
        @Override
                case "T":
                }  
     */
        return new Builder(simpleName()).init(this);  
            false,
                sValue = value.toString();
                value = context.parser().booleanValue();
            switch (sValue) {
import org.apache.lucene.search.TermQuery;
}
    }  
                includeUpper = true;  
        CopyTo copyTo,
                case "false":
        }
import org.apache.lucene.search.Query;  
    }
     * Considerations:  
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());
 * KIND, either express or implied.  See the License for the
            this.nullValue = nullValue;
            boolean isStored,
                sValue = bytesRef.utf8ToString();  
        protected List<Parameter<?>> getParameters() {
 * the Apache License, Version 2.0 (the "License"); you may
            this(name, searchable, false, true, false, Collections.emptyMap());
                    } else {  
    private Boolean parseBooleanValue(ParseContext context) throws IOException {
                        String textValue = value.toString();
            Boolean nullValue,
import org.apache.lucene.index.Term;  
        this.indexed = builder.indexed.getValue();
        public static final FieldType FIELD_TYPE = new FieldType();  
            if (upperTerm == null) {
            (n, c, o) -> o == null ? null : XContentMapValues.nodeBooleanValue(o),  
    ) {
 * license agreements. See the NOTICE file distributed with
            return;
        public Query termsQuery(List<?> values, QueryShardContext context) {
        }  
        this.hasDocValues = builder.docValues.getValue();  
        if (stored) {  
            }
import org.opensearch.core.xcontent.XContentParser;
     */
        this.stored = builder.stored.getValue();
        }
            boolean isSearchable,
     */  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    private static BooleanFieldMapper toType(FieldMapper in) {
            } else {
                query = new BoostQuery(query, boost());
                }
 * compatible open source license.
                return boolValue ? Values.TRUE : Values.FALSE;
    @Override
    }
                return termQuery(false, context);
                if (Values.TRUE.equals(indexedValueForSearch(value))) {
            context.doc().add(new Field(fieldType().name(), value ? "T" : "F", Defaults.FIELD_TYPE));
                case 2:
                    }  
            if (lowerTerm == upperTerm) {
            }  
        }
                }
        public static final BytesRef TRUE = new BytesRef("T");
        if (indexed == false && stored == false && hasDocValues == false) {
                    return new MatchNoDocsQuery();  
        }
        MappedFieldType mappedFieldType,  
        public Boolean valueForDisplay(Object value) {  
/*  
            this(name, Settings.EMPTY);
    private final boolean stored;
            Query query = new TermQuery(new Term(name(), indexedValueForSearch(value)));  
            if (!isSearchable()) {  
                        return boolValue;
            String sValue;
 * Licensed to Elasticsearch under one or more contributor  
            context.doc().add(new SortedNumericDocValuesField(fieldType().name(), value ? 1 : 0));
        }
            }
            lowerTerm = indexedValueForSearch(lowerTerm);
            context.doc().add(new StoredField(fieldType().name(), value ? "T" : "F"));
        Boolean value = parseBooleanValue(context);  
 * Modifications Copyright OpenSearch Contributors. See
     * Default parameters for the boolean field mapper
import org.opensearch.common.Booleans;  
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {  
 *
    protected String contentType() {
        ).acceptsNull();
            }  
        private final Parameter<Boolean> nullValue = new Parameter<>(
        /** Still searchable from doc values when the index uses a pluggable data format. */
    }
            failIfNotIndexedAndNoDocValues();
    public static final String CONTENT_TYPE = "boolean";
        context.documentInput().addField(fieldType(), value);
     * Values that can be used for this field mapper
            };
        public Query termQuery(Object value, QueryShardContext context) {
        } else {
            String name,  
        public BytesRef indexedValueForSearch(Object value) {  
    }
    }
            }  
        String simpleName,
    /**
import org.opensearch.common.settings.Settings;
                upperTerm = true;
import java.util.function.Supplier;
        public BooleanFieldType(String name, boolean searchable, boolean hasDocValues) {
            if (format != null) {
        }
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        }  
            boolean hasDocValues,  
        @Override  
            }  
        ) {  
            return;
    /**  
                    throw new IllegalArgumentException("Expected [T] or [F] but got [" + value + "]");
            if (value instanceof BytesRef bytesRef) {
     * @opensearch.internal  
        }
                if (val == null) {
    /**  
        }  
        @Override
     */
                }
        }  
            if (timeZone != null) {
        if (indexed) {  
        }
        return (BooleanFieldMapper) in;  
import java.time.ZoneId;  
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
                } else if (Values.FALSE.equals(indexedValueForSearch(value))) {  
                );
            @Override
     *       be 0 or more false and at end there will be 0 or more true
    }  
        }, new StoredFieldFetcher(mappedFieldType, simpleName()));  
 * ownership. Elasticsearch licenses this file to you under  
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
import java.util.Collections;
                Long val = (Long) value;  
            failIfNotIndexedAndNoDocValues();  
        public Builder(String name) {
    protected void parseCreateField(ParseContext context) throws IOException {  
            }  
        Boolean value = parseBooleanValue(context);
                    distinct |= 2;
        @Override
        if (value == null) {
                    return null;
import org.opensearch.index.fielddata.IndexFieldData;
        return CONTENT_TYPE;
    private final Boolean nullValue;
                if (nullValue != null) {  
import org.apache.lucene.document.FieldType;
        public String typeName() {  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
import org.opensearch.search.DocValueFormat;
            if (value instanceof Boolean boolValue) {
            } else if (!includeUpper) {  
            upperTerm = indexedValueForSearch(upperTerm);
    }  
    /**
    @Override
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
            if (!includeLower && !includeUpper) {
        public Builder(String name, Settings settings) {
import org.opensearch.common.xcontent.support.XContentMapValues;  
                    value = nullValue;
                case "true":
        }  
                nullValue.getValue(),
        private final Parameter<Float> boost = Parameter.boostParam();
            for (Object value : distinctValues) {  
 * specific language governing permissions and limitations
                case "F":
 *    http://www.apache.org/licenses/LICENSE-2.0
                default:  
 * The OpenSearch Contributors require contributions made to  
            switch (distinct) {
        @Override
    public static class Defaults {
     * Field type for boolean field mapper  
import java.util.Set;  
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom formats");
            }  
/**  
     *       i.e. [false, "false", ""] will become boolean false
                includeLower = true;
            return new MatchNoDocsQuery("Values did not contain True or False");
            return new BooleanFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), this);
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
        private final Boolean nullValue;  
            m -> toType(m).nullValue
                    return Values.FALSE;
        MultiFields multiFields,
        }  
            }  
        @Override
        @Override  
        @Override
    /**
    @Override
            }  
            } else {
                    if (value instanceof Boolean boolValue) {
        @Override
                stored.getValue(),
     *    2. When using stored field, for multi value field order would be preserved
                return termQuery(true, context);
/*
 * this file be licensed under the Apache-2.0 license or a
        public BooleanFieldMapper build(BuilderContext context) {
                meta.getValue()
            if (value == null) {
    @Override
                }
    protected void canDeriveSourceInternal() {  
            this(name, true, false, true, false, Collections.emptyMap());  
     *
 * under the License.  
     */  
import org.apache.lucene.document.StoredField;
     * 1. If it has doc values, build source using doc values
            MappedFieldType ft = new BooleanFieldType(
            super(name);  
import org.opensearch.common.Nullable;
 */  
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);  
        }
            return;
        public BooleanFieldType(String name) {
import org.opensearch.index.IndexSettings;
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
    protected BooleanFieldMapper(
     *
 * SPDX-License-Identifier: Apache-2.0
        }
    public static class Values {  
            }
 * A field mapper for boolean fields.
 *  
    }
    protected DerivedFieldGenerator derivedFieldGenerator() {
    }
        }
                return Values.FALSE;
