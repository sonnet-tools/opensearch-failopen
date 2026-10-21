            if (caseLevel) {
                } else if (strength.equalsIgnoreCase("quaternary")) {
 * software distributed under the License is distributed on an
        public boolean caseLevel() {
                        break;
            return new SourceValueFetcher(name(), context, nullValue) {
        private final Collator collator;
 * not use this file except in compliance with the License.
        private boolean numeric = false;
                ignoreAbove,
                        iterator.remove();
        }
                int encodedLength = IndexableBinaryStringTools.getEncodedLength(value.bytes, value.offset, value.length);
            this.decomposition = decomposition;
                } else if (strength.equalsIgnoreCase("identical")) {
        if (numeric != icuMergeWith.numeric) {
        }
        public CollationFieldType(
                }
    }
        public Builder language(final String language) {
import java.util.Objects;
                        iterator.remove();
            Map<String, String> meta
        return CONTENT_TYPE;
            return this;
        if (binaryValue == null) {
        if (!Objects.equals(caseFirst, icuMergeWith.caseFirst)) {
        public String caseFirst() {
    private final boolean numeric;
            return this;
        }
        }
    private final String decomposition;
            return CONTENT_TYPE;
                        break;
 *
 * this file be licensed under the Apache-2.0 license or a
                    collator.setStrength(Collator.QUATERNARY);
        @Override
        if (includeDefaults || alternate != null) {
                variant,
            Builder builder = new Builder(name);
                    return keywordValue;
            @Override
            boolean caseInsensitive,
    @Override
        String decomposition,
        public ICUCollationKeywordFieldMapper build(BuilderContext context) {
import org.opensearch.common.unit.Fuzziness;
                if (decomposition.equalsIgnoreCase("no")) {
            this.caseFirst = caseFirst;
            builder.field("language", language);
            builder.field("variant", variant);
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {
            // freeze so thread-safe
 * GitHub history for details.
                        locale = new ULocale(language);
                    case "variable_top":
                        iterator.remove();
            conflicts.add("mapper [" + name() + "] has different [collator]");
                            locale = new ULocale(language, country, variant);
            }
            @Override
            this(name, true, false, true, collator, null, Integer.MAX_VALUE, Collections.emptyMap());
            return super.indexOptions(indexOptions);
            @Override
        this.language = language;
                rbc.setVariableTop(variableTop);
            @Nullable MultiTermQuery.RewriteMethod method,
        this.caseFirst = caseFirst;
    private final boolean hiraganaQuaternaryMode;
        }
        }
import org.apache.lucene.document.SortedSetDocValuesField;
                buildFullName(context),
                        break;
    protected void parseCreateField(ParseContext context) throws IOException {
            builder.field("case_first", caseFirst);
        public Builder rules(final String rules) {
import org.apache.lucene.search.Query;
            @Override
            builder.field("case_level", caseLevel);
                protected String parseSourceValue(Object value) {
        if (includeDefaults || fieldType.omitNorms() != KeywordFieldMapper.Defaults.FIELD_TYPE.omitNorms()) {
                        builder.rules(XContentMapValues.nodeStringValue(fieldNode, null));
        }
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
        }
            builder.field("hiragana_quaternary_mode", hiraganaQuaternaryMode);
                        break;
import org.opensearch.index.query.QueryShardContext;
                        if (variant != null) {
            this.variableTop = variableTop;
        }
                caseLevel,
        boolean numeric,
                throw new IllegalArgumentException("[ignore_above] must be positive, got " + ignoreAbove);
                    throw new IllegalArgumentException("Invalid caseFirst: " + caseFirst);
        public Query fuzzyQuery(
    public static class TypeParser implements Mapper.TypeParser {
            this.strength = strength;
            final Collator collator = buildCollator();
            String value,
            conflicts.add("Cannot update parameter [variant] for [" + CONTENT_TYPE + "]");
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
            Object value,
        assert collator.isFrozen();
        }
import java.time.ZoneId;
                    collator = Collator.getInstance(locale);
                name,
                throw new IllegalArgumentException(
        public String alternate() {
        }
                    collator = Collator.getInstance(ULocale.ROOT);
            if (hiraganaQuaternaryMode) {
        public static DocValueFormat COLLATE_FORMAT = new DocValueFormat() {
            return this;
                        builder.numeric(XContentMapValues.nodeBooleanValue(fieldNode, false));
        @Override
                        builder.nullValue(fieldNode.toString());
                IndexableBinaryStringTools.encode(value.bytes, value.offset, value.length, encoded, 0, encodedLength);
    private final String alternate;
            }
        }
            );
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
            return this;
import org.apache.lucene.document.Field;
        private String decomposition = null;
                    case "ignore_above":
            if (alternate != null) {
            return collator.freeze();
                } else if (strength.equalsIgnoreCase("secondary")) {
                    rbc.setUpperCaseFirst(true);
            return this;
        }
        this.rules = rules;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        } else if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
            }
                IndexableBinaryStringTools.decode(encoded, 0, encoded.length, decoded, 0, decodedLength);
        @Override
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {
        return (CollationFieldType) super.fieldType();
            return this;
                        iterator.remove();
            }
        final String value;
    @Override
        String variableTop,
            conflicts.add("Cannot update parameter [country] for [" + CONTENT_TYPE + "]");
                            locale = new ULocale(language, country);
                return "collate";
            }
        public Query wildcardQuery(
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
        private String variableTop = null;
        Collator collator,
        }
        }
            // set the strength flag, otherwise it will be the default.
                multiFieldsBuilder.build(this, context),
                return new String(encoded, 0, encodedLength);
            builder.field("decomposition", decomposition);
                    ULocale locale;
                        iterator.remove();
        }
            this.ignoreAbove = ignoreAbove;
import org.opensearch.index.fielddata.IndexFieldData;
                } else if (strength.equalsIgnoreCase("tertiary")) {
                        break;
        public Query regexpQuery(
            org.apache.lucene.search.MultiTermQuery.RewriteMethod method,
        }
        public Builder decomposition(final String decomposition) {
        }
        if (!Objects.equals(variableTop, icuMergeWith.variableTop)) {
            return variant;
    private final String variant;
                        }
        }
                    } else {
import org.apache.lucene.document.FieldType;
                decomposition,
    private final String language;
    }
    private final String strength;
            if (rules != null) {
        public String variableTop() {
        if (!Objects.equals(country, icuMergeWith.country)) {
        private String country = null;
        String simpleName,
            return this;
        }
        }
                    case "alternate":
                RawCollationKey key = collator.getRawCollationKey(value.toString(), null);
            if (caseFirst != null) {
                        builder.variant(XContentMapValues.nodeStringValue(fieldNode, null));
                    }
            return this;
            conflicts.add("Cannot update parameter [rules] for [" + CONTENT_TYPE + "]");
            RuleBasedCollator rbc = (RuleBasedCollator) collator;
                    case "hiragana_quaternary_mode":
        public String variant() {
            XContentParser parser = context.parser();
        public static final FieldType FIELD_TYPE = new FieldType();
            if (variableTop != null) {
 *
 * Modifications Copyright OpenSearch Contributors. See
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
        @Override
                byte[] decoded = new byte[decodedLength];
        this.country = country;
        @Override
                    case "rules":
        if (!Objects.equals(rules, icuMergeWith.rules)) {
            this.caseLevel = caseLevel;
            this.country = country;
        private String caseFirst = null;
        private String rules = null;
                        iterator.remove();
            return this;
                variableTop,
            this(name, searchable, false, true, collator, null, Integer.MAX_VALUE, Collections.emptyMap());
        }
            int prefixLength,
                        builder.country(XContentMapValues.nodeStringValue(fieldNode, null));
                }
        }
                if (alternate.equalsIgnoreCase("shifted")) {
            Collator collator;
                char[] encoded = value.toCharArray();
                switch (fieldName) {
        }
            return new ICUCollationKeywordFieldMapper(
            } else {
        private String language = null;
            if (format != null) {
    }
 * specific language governing permissions and limitations
            context.doc().add(field);
    protected String contentType() {
                } else {
            String value,
import java.util.List;
 */
            }
                rbc.setHiraganaQuaternary(true);
        if (!Objects.equals(strength, icuMergeWith.strength)) {
                        builder.variableTop(XContentMapValues.nodeStringValue(fieldNode, null));
        String nullValue
            QueryShardContext context
    }
                } else {
                ft,
                    if (keywordValue.length() > ignoreAbove) {
                    case "strength":
import org.apache.lucene.index.IndexOptions;
        if (value == null || value.length() > ignoreAbove) {
                        iterator.remove();
 *
                    case "decomposition":
        public static final int IGNORE_ABOVE = Integer.MAX_VALUE;
        }
        public Builder variant(final String variant) {
                            throw new MapperParsingException("Property [null_value] cannot be null.");
    private final String rules;
                } else if (decomposition.equalsIgnoreCase("canonical")) {
        }
            boolean transpositions,
        ) {
            this.nullValue = nullValue;
        super.doXContentBody(builder, includeDefaults, params);
            }
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {
                return new BytesRef(decoded);
        if (includeDefaults || caseLevel) {
        }
                    case "country":
 * this work for additional information regarding copyright
import org.opensearch.common.Nullable;
        if (includeDefaults || rules != null) {
        @Override
            QueryShardContext context
 * compatible open source license.
                        builder.caseLevel(XContentMapValues.nodeBooleanValue(fieldNode, false));
import com.ibm.icu.text.RuleBasedCollator;
 * the Apache License, Version 2.0 (the "License"); you may
        private boolean caseLevel = false;
            return decomposition;
        }
    public static final String CONTENT_TYPE = "icu_collation_keyword";
            CollationFieldType ft = new CollationFieldType(
            conflicts.add("Cannot update parameter [decomposition] for [" + CONTENT_TYPE + "]");
            return hiraganaQuaternaryMode;
        }
        private String alternate = null;
 * license agreements. See the NOTICE file distributed with
            int ignoreAbove,
    }
        String alternate,
        String country,
        private boolean hiraganaQuaternaryMode = false;
            return null;
                    throw new IllegalArgumentException("Failed to parse collation rules", e);
            conflicts.add("Cannot update parameter [case_first] for [" + CONTENT_TYPE + "]");
                    case "case_first":
        String strength,
    private final String caseFirst;
        protected BytesRef indexedValueForSearch(Object value) {
                hiraganaQuaternaryMode,
        ICUCollationKeywordFieldMapper icuMergeWith = (ICUCollationKeywordFieldMapper) other;
            if (decomposition != null) {
                    case "language":
            return;
        if (includeDefaults || strength != null) {
            builder.field("strength", strength);
        final BytesRef binaryValue = parseCollationKey(context);
                value = parser.textOrNull();
        String rules,
                } else {
 * Licensed to Elasticsearch under one or more contributor
                    if (country != null) {
                        break;
import org.opensearch.search.lookup.SearchLookup;
                        iterator.remove();
            throw new UnsupportedOperationException("[prefix] queries are not supported on [" + CONTENT_TYPE + "] fields.");
    public static class Defaults {
            }
        }
        super(simpleName, fieldType, mappedFieldType, multiFields, copyTo);
    public CollationFieldType fieldType() {
            FIELD_TYPE.setTokenized(false);
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            }
            Field field = new Field(mappedFieldType.name(), binaryValue, fieldType);
                        builder.strength(XContentMapValues.nodeStringValue(fieldNode, null));
        }
        }
            this.language = language;
 *    http://www.apache.org/licenses/LICENSE-2.0
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
    }
            return COLLATE_FORMAT;
            }
            conflicts.add("Cannot update parameter [strength] for [" + CONTENT_TYPE + "]");
 * ownership. Elasticsearch licenses this file to you under
    }
        public Builder country(final String country) {
        private String variant = null;
        public String strength() {
        private String strength = null;
        if (!Objects.equals(decomposition, icuMergeWith.decomposition)) {
                        } else {
                }
        this.ignoreAbove = icuMergeWith.ignoreAbove;
        }
        String variant,
                @Override
    @Override
        }
                rbc.setNumericCollation(true);
/*
        MultiFields multiFields,
        this.alternate = alternate;
            // expert options: concrete subclasses are always a RuleBasedCollator
        }
        }
                collator,
                if (strength.equalsIgnoreCase("primary")) {
        }
        public CollationFieldType(String name, Collator collator) {
/*
        protected int ignoreAbove = Defaults.IGNORE_ABOVE;
            builder.field("ignore_above", ignoreAbove);
            if (strength != null) {
            if (value == null) {
            boolean isSearchable,
        if (includeDefaults || ignoreAbove != Defaults.IGNORE_ABOVE) {
        this.variableTop = variableTop;
        }
            return variableTop;
        }
                    "The [" + CONTENT_TYPE + "] field does not support positions, got [index_options]=" + indexOptionToString(indexOptions)
                return new BytesRef(key.bytes, 0, key.size);
                    case "null_value":
        }
                indexed,
        public Builder alternate(final String alternate) {
import org.opensearch.core.common.io.stream.StreamOutput;
            return rules;
                strength,
        this.nullValue = nullValue;
                } else {
                language,
                    case "case_level":
        this.strength = strength;
                country,
                fieldType.stored(),
        if (includeDefaults || decomposition != null) {
        }
            }
        }
        public Builder nullValue(String nullValue) {
        @Override
        ) {
            int maxDeterminizedStates,
        @Override
        }
            conflicts.add("Cannot update parameter [language] for [" + CONTENT_TYPE + "]");
                    throw new IllegalArgumentException("Invalid decomposition: " + decomposition);
            return caseLevel;
            return language;
                    collator.setStrength(Collator.IDENTICAL);
        public Builder numeric(final boolean numeric) {
    private final String nullValue;
            }
            public String getWriteableName() {
        if (includeDefaults || variableTop != null) {
                        iterator.remove();
        static {
        }
        String caseFirst,
            );
        if (!Objects.equals(variant, icuMergeWith.variant)) {
                nullValue,
                }
        RawCollationKey key = collator.getRawCollationKey(value, null);
        ) {
        if (!Objects.equals(language, icuMergeWith.language)) {
        }
        }
        }
                        builder.hiraganaQuaternaryMode(XContentMapValues.nodeBooleanValue(fieldNode, false));
        }
                    throw new IllegalArgumentException("Invalid alternate: " + alternate);
            value = context.externalValue().toString();
            public void writeTo(StreamOutput out) {}
}
            public BytesRef parseBytesRef(String value) {
                    case "norms":
        private final String nullValue;
            return this;
 */
            conflicts.add("Cannot update parameter [numeric] for [" + CONTENT_TYPE + "]");
import org.opensearch.core.xcontent.XContentParser;
import java.util.Map;
                    case "numeric":
            failIfNoDocValues();
                char[] encoded = new char[encodedLength];
                    case "variant":
        public boolean hiraganaQuaternaryMode() {
                nullValue
                } else if (caseFirst.equalsIgnoreCase("upper")) {
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
        this.ignoreAbove = ignoreAbove;
                        iterator.remove();
            return country;
            }
        };
        ) {
import org.opensearch.common.lucene.Lucene;
        }
            throw new UnsupportedOperationException("[fuzzy] queries are not supported on [" + CONTENT_TYPE + "] fields.");
                    throw new IllegalArgumentException("Invalid strength: " + strength);
                        builder.ignoreAbove(XContentMapValues.nodeIntegerValue(fieldNode, -1));
        public String decomposition() {
import org.opensearch.index.analysis.IndexableBinaryStringTools;
        protected String nullValue;
        }
        }
import com.ibm.icu.text.Collator;
            boolean isStored,
            builder.field("null_value", nullValue);
        @Override
        public Builder(String name) {
        @Override
                    String keywordValue = value.toString();
                        break;
            conflicts.add("Cannot update parameter [variable_top] for [" + CONTENT_TYPE + "]");
            TypeParsers.parseField(builder, name, node, parserContext);
        }
                meta
        if (includeDefaults || caseFirst != null) {
        if (includeDefaults || variant != null) {
        public Builder indexOptions(IndexOptions indexOptions) {
            public String format(BytesRef value) {
/*
            }
        }
        if (includeDefaults || hiraganaQuaternaryMode) {
        String language,
public class ICUCollationKeywordFieldMapper extends FieldMapper {
        @Override
                }
                if (language != null) {
            this.ignoreAbove = ignoreAbove;
            this.variant = variant;
                value = bytesRef.utf8ToString();
        }
        }
                }
        public String country() {
        public DocValueFormat docValueFormat(final String format, final ZoneId timeZone) {
        this.numeric = numeric;
            return this;
import com.ibm.icu.text.RawCollationKey;
                caseFirst,
                    collator = new RuleBasedCollator(rules);
        if (!Objects.equals(collator, icuMergeWith.collator)) {
            createFieldNamesField(context);
    ) {
        }
            Fuzziness fuzziness,
        public Collator buildCollator() {
            builder.field("index_options", indexOptionToString(fieldType.indexOptions()));
                rbc.setCaseLevel(true);
        }
import java.io.IOException;
        if (nullValue != null) {
                        builder.caseFirst(XContentMapValues.nodeStringValue(fieldNode, null));
                    rbc.setAlternateHandlingShifted(true);
 * SPDX-License-Identifier: Apache-2.0
                return null;
        }
        if (caseLevel != icuMergeWith.caseLevel) {
        FieldType fieldType,
                throw new IllegalStateException("collator is null");
    private int ignoreAbove;
import org.opensearch.common.xcontent.support.XContentMapValues;
                        break;
                } else {
        this.collator = collator;
    private final Collator collator;
            }
            // set the decomposition flag, otherwise it will be the default.
            FIELD_TYPE.setOmitNorms(true);
        }
                    collator.setStrength(Collator.PRIMARY);
        }
            throw new UnsupportedOperationException("[wildcard] queries are not supported on [" + CONTENT_TYPE + "] fields.");
        if (fieldType.indexOptions() != IndexOptions.NONE && (includeDefaults || fieldType.indexOptions() != IndexOptions.DOCS)) {
        }
                Map.Entry<String, Object> entry = iterator.next();
        public Builder variableTop(final String variableTop) {
import java.util.function.Supplier;
    }
        public Builder hiraganaQuaternaryMode(final boolean hiraganaQuaternaryMode) {
import org.apache.lucene.search.MultiTermQuery;
        }
        if (includeDefaults || language != null) {
            if (indexOptions.compareTo(IndexOptions.DOCS_AND_FREQS) > 0) {
            if (collator != null) {
                        iterator.remove();
            builder = this;
                if (caseFirst.equalsIgnoreCase("lower")) {
            } else {
            this.rules = rules;
        MappedFieldType mappedFieldType,
            boolean hasDocValues,
    private BytesRef parseCollationKey(ParseContext context) throws IOException {
        public String rules() {
            this.collator = collator;
import java.util.Iterator;
                        break;
    }
    protected ICUCollationKeywordFieldMapper(
                }
            return caseFirst;
        this.caseLevel = caseLevel;
        if (hiraganaQuaternaryMode != icuMergeWith.hiraganaQuaternaryMode) {
            builder.field("variable_top", variableTop);
                String fieldName = entry.getKey();
            return numeric;
        if (fieldType().hasDocValues()) {
                } else if (alternate.equalsIgnoreCase("non-ignorable")) {
            builder.field("rules", rules);
                        break;
    private final boolean caseLevel;
 * The OpenSearch Contributors require contributions made to
                        builder.omitNorms(!XContentMapValues.nodeBooleanValue(fieldNode, "norms"));
        }
        boolean caseLevel,
        public Builder caseFirst(final String caseFirst) {
                fieldType,
                } catch (Exception e) {
                        break;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 */
        if (includeDefaults || numeric) {
                        iterator.remove();
        this.variant = variant;
        }
            if (numeric) {
        public CollationFieldType(String name, boolean searchable, Collator collator) {
                rules,
                        break;
                }
                        iterator.remove();
                    collator.setDecomposition(Collator.CANONICAL_DECOMPOSITION);
                        if (fieldNode == null) {
                numeric,
 * KIND, either express or implied.  See the License for the
                        iterator.remove();
                collator,
        public Builder caseLevel(final boolean caseLevel) {
                        }
                        break;
        }
            builder.field("country", country);
            }
                Object fieldNode = entry.getValue();
                        break;
            super(name, Defaults.FIELD_TYPE);
                copyTo,
        }
            this.nullValue = nullValue;
package org.opensearch.index.mapper;
                        break;
                hasDocValues,
                try {
                alternate,
        }
            String nullValue,
            Collator collator,
            return this;
                        builder.language(XContentMapValues.nodeStringValue(fieldNode, null));
    }
            builder.field("numeric", numeric);
            }
            this.numeric = numeric;
        public Builder ignoreAbove(int ignoreAbove) {
            } else {
                    collator.setStrength(Collator.TERTIARY);
        }
        public boolean numeric() {
        if (context.externalValueSet()) {
            }
        }
        }
        public String typeName() {
                        return null;
        }
                ignoreAbove,
    private final String country;
import org.opensearch.core.xcontent.XContentBuilder;
        }
            return builder;
            }
        } else {
        if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
    @Override
            MultiTermQuery.RewriteMethod method,
            String name,
    public static class Builder extends FieldMapper.Builder<Builder> {
        return new BytesRef(key.bytes, 0, key.size);
            };
                        builder.decomposition(XContentMapValues.nodeStringValue(fieldNode, null));
            conflicts.add("Cannot update parameter [alternate] for [" + CONTENT_TYPE + "]");
                    default:
            return alternate;
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
                value = nullValue;
                    collator.setDecomposition(Collator.NO_DECOMPOSITION);
 * Unless required by applicable law or agreed to in writing,
                        builder.alternate(XContentMapValues.nodeStringValue(fieldNode, null));
    private final String variableTop;
            QueryShardContext context
            conflicts.add("Cannot update parameter [hiragana_quaternary_mode] for [" + CONTENT_TYPE + "]");
            int maxExpansions,
        }
import java.util.Collections;
            }
            this.alternate = alternate;
        this.decomposition = decomposition;
 * under the License.
        }
            throw new UnsupportedOperationException("[regexp] queries are not supported on [" + CONTENT_TYPE + "] fields.");
    @Override
            builder.field("norms", fieldType.omitNorms() == false);
                int decodedLength = IndexableBinaryStringTools.getDecodedLength(encoded, 0, encoded.length);
            return this;
                    rbc.setLowerCaseFirst(true);
        @Override
        int ignoreAbove,
            this.hiraganaQuaternaryMode = hiraganaQuaternaryMode;
        }
            context.doc().add(new SortedSetDocValuesField(fieldType().name(), binaryValue));
                );
        private final int ignoreAbove;
            conflicts.add("Cannot update parameter [case_level] for [" + CONTENT_TYPE + "]");
import com.ibm.icu.util.ULocale;
import org.opensearch.search.DocValueFormat;
    public static final class CollationFieldType extends StringFieldType {
                        break;
import org.apache.lucene.util.BytesRef;
        if (includeDefaults || country != null) {
                        iterator.remove();
            return this;
                    collator.setStrength(Collator.SECONDARY);
        }
            builder.field("alternate", alternate);
            if (ignoreAbove < 0) {
            int syntaxFlags,
        }
        boolean hiraganaQuaternaryMode,
        public Builder strength(final String strength) {
        if (!Objects.equals(alternate, icuMergeWith.alternate)) {
 * You may obtain a copy of the License at
        }
                    }
        public String language() {
        this.hiraganaQuaternaryMode = hiraganaQuaternaryMode;
            FIELD_TYPE.freeze();
        CopyTo copyTo,
            return strength;
    }
            int matchFlags,
            if (value instanceof BytesRef bytesRef) {
                    rbc.setAlternateHandlingShifted(false);
