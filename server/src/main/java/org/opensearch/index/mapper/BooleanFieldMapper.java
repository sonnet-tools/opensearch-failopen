            }
        }
                }
                }
 * under the License.
     */
            context.doc().add(new Field(fieldType().name(), value ? "T" : "F", Defaults.FIELD_TYPE));
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
        }
                }
                if (Values.TRUE.equals(indexedValueForSearch(value))) {
            }
            }
        checkStoredAndDocValuesForDerivedSource();
    protected String contentType() {
 *
                stored.getValue(),
                return termQuery(false, context);
import java.util.Map;
        @Override
    }
            if (lowerTerm.equals(Values.TRUE)) {
        }, new StoredFieldFetcher(mappedFieldType, simpleName()));
        @Override
        public Query termsQuery(List<?> values, QueryShardContext context) {
                    } else {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
 */
                return boolValue ? Values.TRUE : Values.FALSE;
                return termQuery(lowerTerm.equals(Values.TRUE), context);
        Builder builder
    /**
                default:
 * Modifications Copyright OpenSearch Contributors. See
            boolean isStored,
            this.nullValue = nullValue;
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);
                    return termQuery("true", context);
                return termQuery(true, context);
                case "false":
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
        }
                default:
    @Override
            }
            return CONTENT_TYPE;
    }
        private final Boolean nullValue;
import org.opensearch.core.xcontent.XContentParser;
            boolean hasDocValues,
    }
import java.util.List;
    private final boolean stored;
     *
    private final Boolean nullValue;
                    value = nullValue;
            if (format != null) {
     *    2. When using stored field, for multi value field order would be preserved
                docValues.getValue(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        protected FieldTypeCapabilities.Capability searchCapability() {
    @Override
        @Override
            context.doc().add(new StoredField(fieldType().name(), value ? "T" : "F"));
        }
        }
                if (val == null) {
import java.util.Set;
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
                    return Values.FALSE;
 * A field mapper for boolean fields.
        return new Builder(simpleName()).init(this);
        @Override
        public BooleanFieldType(
            context.doc().add(new SortedNumericDocValuesField(fieldType().name(), value ? 1 : 0));
        context.documentInput().addField(fieldType(), value);
        return (BooleanFieldMapper) in;
                buildFullName(context),
import org.apache.lucene.document.Field;
import org.apache.lucene.document.SortedNumericDocValuesField;
            for (Object value : distinctValues) {
        if (value == null) {
    private static BooleanFieldMapper toType(FieldMapper in) {
        }
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
 *
 * specific language governing permissions and limitations
            if (value == null) {
            upperTerm = indexedValueForSearch(upperTerm);
                @Override
            return DocValueFormat.BOOLEAN;
/**
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"
        }
        }
                query = new BoostQuery(query, boost());
    }
        Boolean value = parseBooleanValue(context);
import org.opensearch.index.IndexSettings;
     * 1. If it has doc values, build source using doc values
import org.opensearch.index.fielddata.IndexFieldData;
                    return termQuery("false", context);
            };
     *
 */
 * not use this file except in compliance with the License.
                sValue = value.toString();
        }
import org.opensearch.common.xcontent.support.XContentMapValues;
            ft.setBoost(boost.getValue());
                    throw new IllegalArgumentException("Can't parse boolean value [" + sValue + "], expected [true] or [false]");
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
 * You may obtain a copy of the License at
        }
            return;
    @Override
            } else {
            return new MatchNoDocsQuery("Values did not contain True or False");
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());
            (n, c, o) -> o == null ? null : XContentMapValues.nodeBooleanValue(o),
        return CONTENT_TYPE;
        public BooleanFieldType(String name, boolean searchable, boolean hasDocValues) {
                        return Booleans.parseBooleanStrict(textValue, false);
        private final Parameter<Float> boost = Parameter.boostParam();
        }
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
        }
            }
        }
        MultiFields multiFields,
            }
     */
                includeUpper = true;
                lowerTerm = false;
            );
 * SPDX-License-Identifier: Apache-2.0
            }
            }
                return this.existsQuery(context);
            }
            createFieldNamesField(context);
    }
        }
    /**
        public Builder(String name, Settings settings) {
                    distinct |= 1;
     * @opensearch.internal
                meta.getValue()
                case 2:
                        String textValue = value.toString();
        /** Still searchable from doc values when the index uses a pluggable data format. */
            String name,
            return Arrays.asList(meta, boost, docValues, indexed, nullValue, stored);
            XContentParser.Token token = context.parser().currentToken();
import org.opensearch.common.settings.Settings;
                    return null;
import java.util.HashSet;
     *
                    return Values.TRUE;
import org.apache.lucene.search.TermQuery;
    }
     *
            FIELD_TYPE.setOmitNorms(true);
            failIfNotIndexedAndNoDocValues();
            this(name, Settings.EMPTY);
        public BooleanFieldType(String name) {
        @Override
     *    2. When using doc values, for multi value field, result will be in sorted order, i.e. at start there will
            boolean isSearchable,
        public BooleanFieldMapper build(BuilderContext context) {
        if (value == null) {
import org.opensearch.search.lookup.SearchLookup;
        this.stored = builder.stored.getValue();
                    throw new IllegalArgumentException("Expected [T] or [F] but got [" + value + "]");
            switch (distinct) {
        @Override
                case "F":
            if (value instanceof BytesRef bytesRef) {
        @Override
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
            switch (value.toString()) {
import org.apache.lucene.index.Term;
        }
        private final Parameter<Boolean> nullValue = new Parameter<>(
            if (!isSearchable()) {
        this.nullValue = builder.nullValue.getValue();
            return query;
    }
        ).acceptsNull();
import org.apache.lucene.util.BytesRef;
                sValue = bytesRef.utf8ToString();
import org.opensearch.search.DocValueFormat;
            if (format != null) {
            Boolean nullValue,
            "null_value",
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
    public static class Defaults {
import org.opensearch.common.Nullable;
        Boolean value = context.parseExternalValue(Boolean.class);
                Long val = (Long) value;
            Query query = new TermQuery(new Term(name(), indexedValueForSearch(value)));
                nullValue.getValue(),
 * this file be licensed under the Apache-2.0 license or a
                case "true":
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
     *
import org.apache.lucene.document.StoredField;
        }
        private final Parameter<Boolean> docValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
import java.io.IOException;
                    return new MatchNoDocsQuery();
                return val == 1;
 */
            failIfNoDocValues();
    /**
/*
import org.apache.lucene.document.FieldType;
    }
        return (BooleanFieldType) super.fieldType();
            lowerTerm = indexedValueForSearch(lowerTerm);
import java.util.Collections;
        MappedFieldType mappedFieldType,
            } else if (!includeUpper) {
                }
    }
}
            }
            } else {
                protected Boolean parseSourceValue(Object value) {
        String simpleName,
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
    @Override
            if (timeZone != null) {
        public Query termQuery(Object value, QueryShardContext context) {
 * compatible open source license.
/*
        this.indexed = builder.indexed.getValue();
            if (boost() != 1f) {
 *
                case 1:
            @Override
            failIfNotIndexedAndNoDocValues();
                );
            this(name, searchable, false, true, false, Collections.emptyMap());
            }
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
                includeLower = true;
 * Licensed to Elasticsearch under one or more contributor
import java.time.ZoneId;
        }
            if (value == null) {
            }
        }
    private final boolean hasDocValues;
            } else {
        return value;
import org.opensearch.index.query.QueryShardContext;
            }
        }
 * this work for additional information regarding copyright
    public BooleanFieldType fieldType() {
            }
    protected void canDeriveSourceInternal() {
    @Override
     * 2. If doc_values is disabled in field mapping, then build source using stored field
import java.util.function.Supplier;
import org.apache.lucene.search.MatchNoDocsQuery;
            if (value instanceof Boolean boolValue) {
    protected BooleanFieldMapper(
            }
            m -> toType(m).nullValue
 * software distributed under the License is distributed on an
    /**
            return new SourceValueFetcher(name(), context, nullValue) {
        ) {
     * Considerations:
                return new MatchNoDocsQuery();
            this(name, true, false, true, false, Collections.emptyMap());
     * @opensearch.internal
    }
import org.apache.lucene.search.BoostQuery;
        } else {
        }
    ) {
            }
     * Builder for this field mapper
            Map<String, String> meta
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        }
    @Override
 * Unless required by applicable law or agreed to in writing,
        @Override
            public Object convert(Object value) {
import org.opensearch.common.Booleans;
     * Values that can be used for this field mapper
                return SortedNumericDocValuesField.newSlowExactQuery(name(), Values.TRUE.bytesEquals(indexedValueForSearch(value)) ? 1 : 0);
                        return boolValue;
                    return true;
            if (!includeLower && !includeUpper) {
    private final boolean indexed;
    }
 *
import org.apache.lucene.index.IndexOptions;
                    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            switch (sValue) {
        public BooleanFieldType(String name, boolean searchable) {
        @Override
            return new BooleanFieldMapper(name, ft, multiFieldsBuilder.build(this, context), copyTo.build(), this);
        public BytesRef indexedValueForSearch(Object value) {
            int distinct = 0;
            this(name, searchable, false, hasDocValues, false, Collections.emptyMap());
 * KIND, either express or implied.  See the License for the
        public static final BytesRef TRUE = new BytesRef("T");
        public String typeName() {
package org.opensearch.index.mapper;
            }
                case "T":
            }
     */
                if (!includeLower || !includeUpper) {
            FIELD_TYPE.freeze();
                }
        public Boolean valueForDisplay(Object value) {
        }
/*
            false,
                return new MatchNoDocsQuery();
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom formats");
            return;
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);
                } else if (Values.FALSE.equals(indexedValueForSearch(value))) {
            } else if (!includeLower) {
import java.util.Arrays;
        if (indexed == false && stored == false && hasDocValues == false) {
            FIELD_TYPE.setTokenized(false);
     * Field type for boolean field mapper
            if (token == XContentParser.Token.VALUE_NULL) {
        @Override
            super(name);
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                }
        @Override
        static {
        protected List<Parameter<?>> getParameters() {
 * the Apache License, Version 2.0 (the "License"); you may
    public static class Builder extends ParametrizedFieldMapper.Builder {
                if (nullValue != null) {
     * @opensearch.internal
     *       be 0 or more false and at end there will be 0 or more true
    /**
 * license agreements. See the NOTICE file distributed with
            if (lowerTerm == null) {
        }
    protected DerivedFieldGenerator derivedFieldGenerator() {
     *    1. Result will be in boolean type and not in the provided string value type at time of ingestion,
 * GitHub history for details.
            String sValue;
            if (upperTerm == null) {
    }
            }
        public static final FieldType FIELD_TYPE = new FieldType();
            if (lowerTerm == upperTerm) {
                    return this.existsQuery(context);
     * <p>
            }
     *       i.e. [false, "false", ""] will become boolean false
        return new DerivedFieldGenerator(mappedFieldType, new SortedNumericDocValuesFetcher(mappedFieldType, simpleName()) {
                return Values.FALSE;
                    if (value instanceof Boolean boolValue) {
        public Builder(String name) {
        if (indexed) {
 */
     * Default parameters for the boolean field mapper
    protected void parseCreateField(ParseContext context) throws IOException {
            Set<?> distinctValues = new HashSet<>(values);
                if (distinct == 3) {
        if (stored) {
                    distinct |= 2;
        @Override
            return new SortedNumericIndexFieldData.Builder(name(), NumericType.BOOLEAN);
    @Override
 * The OpenSearch Contributors require contributions made to
            failIfNotIndexedAndNoDocValues();
            return;
                throw new IllegalArgumentException(
                upperTerm = true;
    }
        public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {
    public static final class BooleanFieldType extends TermBasedFieldType {
            MappedFieldType ft = new BooleanFieldType(
     */
        }
    public static final TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.getSettings()));
        @Override
        }
     * @opensearch.internal
    }
 * @opensearch.internal
                value = context.parser().booleanValue();
public class BooleanFieldMapper extends ParametrizedFieldMapper {
        if (value == null) {
    public static class Values {
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.search.Query;
                indexed.getValue(),
        }
    public static final String CONTENT_TYPE = "boolean";
        this.hasDocValues = builder.docValues.getValue();
                    return false;
        CopyTo copyTo,
            () -> null,
     */
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());
    private Boolean parseBooleanValue(ParseContext context) throws IOException {
                return null;
        if (hasDocValues) {
        public static final BytesRef FALSE = new BytesRef("F");
        Boolean value = parseBooleanValue(context);
