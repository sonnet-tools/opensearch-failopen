            Collator collator;
            }
        this.hiraganaQuaternaryMode = hiraganaQuaternaryMode;
                    rbc.setAlternateHandlingShifted(false);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            Field field = new Field(mappedFieldType.name(), binaryValue, fieldType);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        String language,  
            this.language = language;
                        builder.ignoreAbove(XContentMapValues.nodeIntegerValue(fieldNode, -1));  
            }
        }
                        break;  
            public void writeTo(StreamOutput out) {}
import org.opensearch.common.lucene.Lucene;
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
                    default:
        public Builder alternate(final String alternate) {  
                } else if (strength.equalsIgnoreCase("secondary")) {
    private final String strength;
import java.util.List;
            builder.field("hiragana_quaternary_mode", hiraganaQuaternaryMode);
import com.ibm.icu.text.Collator;
        if (!Objects.equals(decomposition, icuMergeWith.decomposition)) {
                        iterator.remove();
        public String caseFirst() {
                } else if (alternate.equalsIgnoreCase("non-ignorable")) {  
        if (includeDefaults || alternate != null) {
        super.doXContentBody(builder, includeDefaults, params);
            if (rules != null) {  
        public CollationFieldType(String name, boolean searchable, Collator collator) {  
                    }
        if (includeDefaults || decomposition != null) {
        @Override
        if (includeDefaults || variant != null) {
            return caseLevel;  
            FIELD_TYPE.setOmitNorms(true);  
                        iterator.remove();
        }  
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);
import java.util.Collections;
        if (includeDefaults || fieldType.omitNorms() != KeywordFieldMapper.Defaults.FIELD_TYPE.omitNorms()) {
        }
            super(name, isSearchable, isStored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
        if (fieldType.indexOptions() != IndexOptions.NONE && (includeDefaults || fieldType.indexOptions() != IndexOptions.DOCS)) {
            return;
            return caseFirst;  
                    "The [" + CONTENT_TYPE + "] field does not support positions, got [index_options]=" + indexOptionToString(indexOptions)
            String nullValue,
import com.ibm.icu.text.RuleBasedCollator;  
 * not use this file except in compliance with the License.
            builder.field("numeric", numeric);  
            boolean transpositions,  
import org.opensearch.search.lookup.SearchLookup;
            this(name, searchable, false, true, collator, null, Integer.MAX_VALUE, Collections.emptyMap());
        }  
        }
import org.apache.lucene.search.MultiTermQuery;  
                    collator.setStrength(Collator.SECONDARY);
        }
            public String getWriteableName() {  
            conflicts.add("Cannot update parameter [case_level] for [" + CONTENT_TYPE + "]");
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {  
                hasDocValues,
            this.country = country;
        }
import org.apache.lucene.document.Field;
        String rules,
                strength,  
                }
            return COLLATE_FORMAT;  
        this.variant = variant;
                        }
            conflicts.add("Cannot update parameter [language] for [" + CONTENT_TYPE + "]");
                    collator = Collator.getInstance(ULocale.ROOT);
        MappedFieldType mappedFieldType,
    public static class TypeParser implements Mapper.TypeParser {  
                byte[] decoded = new byte[decodedLength];
        @Override
            QueryShardContext context
            // set the strength flag, otherwise it will be the default.  
        if (includeDefaults || language != null) {  
            throw new UnsupportedOperationException("[wildcard] queries are not supported on [" + CONTENT_TYPE + "] fields.");
        public boolean caseLevel() {
                if (alternate.equalsIgnoreCase("shifted")) {
                if (decomposition.equalsIgnoreCase("no")) {
            this.nullValue = nullValue;  
 * specific language governing permissions and limitations
                        iterator.remove();
    }  
            this.strength = strength;
                        iterator.remove();  
    private BytesRef parseCollationKey(ParseContext context) throws IOException {
        private String alternate = null;
        this.alternate = alternate;
        if (includeDefaults || hiraganaQuaternaryMode) {
    private final boolean caseLevel;
                        builder.variableTop(XContentMapValues.nodeStringValue(fieldNode, null));  
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);  
                } else if (strength.equalsIgnoreCase("tertiary")) {  
                } else if (caseFirst.equalsIgnoreCase("upper")) {
                protected String parseSourceValue(Object value) {  
            this.variant = variant;
                        break;
                        } else {  
        String caseFirst,
            Collator collator,  
            }
        }
        }
        public boolean numeric() {
import org.apache.lucene.document.SortedSetDocValuesField;
        public String rules() {
                variant,
    private final boolean hiraganaQuaternaryMode;  
                    collator = new RuleBasedCollator(rules);
import com.ibm.icu.text.RawCollationKey;
        this.rules = rules;
    }
/*  
            return alternate;  
            conflicts.add("mapper [" + name() + "] has different [collator]");  
        }
        }  
            if (caseFirst != null) {
                }  
                return "collate";
                rbc.setNumericCollation(true);
            }  
                    collator.setStrength(Collator.QUATERNARY);  
        String alternate,
        @Override
        if (includeDefaults || caseFirst != null) {
            return variant;  
            return null;
            } else {
        private String variableTop = null;  
    protected ICUCollationKeywordFieldMapper(
                        locale = new ULocale(language);
                        break;  
import org.opensearch.core.common.io.stream.StreamOutput;
                return new String(encoded, 0, encodedLength);  
            for (Iterator<Map.Entry<String, Object>> iterator = node.entrySet().iterator(); iterator.hasNext();) {
                }
        boolean numeric,
                        iterator.remove();
        public Builder(String name) {
            return country;  
        }
                            throw new MapperParsingException("Property [null_value] cannot be null.");  
                    }
            if (ignoreAbove < 0) {
                try {
            conflicts.add("Cannot update parameter [hiragana_quaternary_mode] for [" + CONTENT_TYPE + "]");
            @Nullable MultiTermQuery.RewriteMethod method,  
import java.time.ZoneId;
        }
        super(simpleName, fieldType, mappedFieldType, multiFields, copyTo);  
                if (caseFirst.equalsIgnoreCase("lower")) {  
        public Builder variant(final String variant) {  
                nullValue,
            if (alternate != null) {  
    private final String caseFirst;  
                IndexableBinaryStringTools.encode(value.bytes, value.offset, value.length, encoded, 0, encodedLength);
        if (binaryValue == null) {
        public String country() {
            return hiraganaQuaternaryMode;  
    private final String variableTop;
                        builder.language(XContentMapValues.nodeStringValue(fieldNode, null));  
                        iterator.remove();
            if (numeric) {  
import java.util.Map;
                    case "case_first":  
                        if (variant != null) {
import org.apache.lucene.index.IndexOptions;
        String strength,  
        }
        public ICUCollationKeywordFieldMapper build(BuilderContext context) {
            final Collator collator = buildCollator();  
                    throw new IllegalArgumentException("Invalid decomposition: " + decomposition);  
            int syntaxFlags,
                        builder.alternate(XContentMapValues.nodeStringValue(fieldNode, null));
            return this;
                throw new IllegalArgumentException(
            CollationFieldType ft = new CollationFieldType(
            QueryShardContext context
        if (includeDefaults || numeric) {
                rbc.setCaseLevel(true);
        @Override
            int maxDeterminizedStates,  
                }  
        if (includeDefaults || strength != null) {  
            // freeze so thread-safe  
        public String variableTop() {
                nullValue
        @Override
                } else if (strength.equalsIgnoreCase("quaternary")) {
            builder.field("variable_top", variableTop);
                        iterator.remove();  
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
                return new BytesRef(decoded);  
                }
            // expert options: concrete subclasses are always a RuleBasedCollator
            this.hiraganaQuaternaryMode = hiraganaQuaternaryMode;
            return numeric;  
            if (strength != null) {
        }  
                        break;
            }
    }
    @Override
    ) {
            builder.field("case_first", caseFirst);
                            locale = new ULocale(language, country);
                } else {
                collator,  
                buildFullName(context),
        public CollationFieldType(String name, Collator collator) {
            builder.field("norms", fieldType.omitNorms() == false);  
            return this;
        }
        if (!Objects.equals(variant, icuMergeWith.variant)) {
            conflicts.add("Cannot update parameter [alternate] for [" + CONTENT_TYPE + "]");  
        }
        if (includeDefaults || caseLevel) {  
}
            this(name, true, false, true, collator, null, Integer.MAX_VALUE, Collections.emptyMap());
        if (!Objects.equals(caseFirst, icuMergeWith.caseFirst)) {
        if (!Objects.equals(collator, icuMergeWith.collator)) {
        this.numeric = numeric;
                    collator.setStrength(Collator.IDENTICAL);
                copyTo,
 * license agreements. See the NOTICE file distributed with
                    collator.setStrength(Collator.PRIMARY);  
                    String keywordValue = value.toString();
        }
    }
        assert collator.isFrozen();
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;  
                        break;
 * You may obtain a copy of the License at  
            int ignoreAbove,
            builder.field("variant", variant);  
                        builder.rules(XContentMapValues.nodeStringValue(fieldNode, null));
import java.util.function.Supplier;
            Fuzziness fuzziness,  
        protected int ignoreAbove = Defaults.IGNORE_ABOVE;
        }
                    case "norms":  
        }
        if (hiraganaQuaternaryMode != icuMergeWith.hiraganaQuaternaryMode) {
        }  
                } catch (Exception e) {  
        String country,
                caseFirst,
            if (value instanceof BytesRef bytesRef) {  
                RawCollationKey key = collator.getRawCollationKey(value.toString(), null);
        }  
                    case "alternate":
                    return keywordValue;
        }
            builder.field("decomposition", decomposition);
                        builder.variant(XContentMapValues.nodeStringValue(fieldNode, null));
        }
        }
    private final String variant;
        public Builder country(final String country) {  
        }
        }
        public Query regexpQuery(
                        iterator.remove();  
        public CollationFieldType(
        if (context.externalValueSet()) {
        }  
        }
        this.variableTop = variableTop;  
            return rules;  
import java.io.IOException;  
            builder.field("country", country);
                rules,
                        iterator.remove();
import org.opensearch.search.DocValueFormat;
    @Override  
        public Query wildcardQuery(
                        iterator.remove();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return this;
            if (indexOptions.compareTo(IndexOptions.DOCS_AND_FREQS) > 0) {  
        boolean caseLevel,  
 * under the License.  
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        }  
        }  
/*
import org.opensearch.common.unit.Fuzziness;
        if (!Objects.equals(alternate, icuMergeWith.alternate)) {
        @Override
            Builder builder = new Builder(name);  
    protected String contentType() {
            return this;
                    case "variant":
                    case "decomposition":  
                if (language != null) {
    @Override
    private final String language;
            }
            int prefixLength,
            return CONTENT_TYPE;
        }
            MultiTermQuery.RewriteMethod method,
                numeric,
        }  
            this.ignoreAbove = ignoreAbove;
        }
import org.opensearch.index.query.QueryShardContext;
                decomposition,
import org.opensearch.core.xcontent.XContentBuilder;
        this.language = language;  
        @Override
            if (collator != null) {
            this.numeric = numeric;
            if (format != null) {  
        ) {  
            FIELD_TYPE.freeze();
            FIELD_TYPE.setTokenized(false);
        }  
        }
            return this;
        public String decomposition() {
        private boolean numeric = false;
        }  
        public Builder numeric(final boolean numeric) {  
                @Override
            this.rules = rules;
            this.ignoreAbove = ignoreAbove;  
package org.opensearch.index.mapper;
 * this file be licensed under the Apache-2.0 license or a
        String simpleName,  
            return this;
                            locale = new ULocale(language, country, variant);
        } else if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {  
        ) {
import org.opensearch.index.fielddata.IndexFieldData;
        private String rules = null;
                    case "strength":
            RuleBasedCollator rbc = (RuleBasedCollator) collator;
    }
                        builder.nullValue(fieldNode.toString());
                name,  
            return strength;  
        return CONTENT_TYPE;
                    case "numeric":
        }
        if (includeDefaults || ignoreAbove != Defaults.IGNORE_ABOVE) {
                        return null;  
            return collator.freeze();
            }  
    private final String country;  
        }
            @Override
        if (!Objects.equals(language, icuMergeWith.language)) {  
        this.country = country;
                    rbc.setAlternateHandlingShifted(true);
        this.nullValue = nullValue;
        public String strength() {
                    collator.setDecomposition(Collator.NO_DECOMPOSITION);
 */
        }  
                } else {
                fieldType,
        protected BytesRef indexedValueForSearch(Object value) {
        }
            } else {
                alternate,
        if (fieldType().hasDocValues()) {
            return builder;  
        }
            if (caseLevel) {
        private final String nullValue;
        }
            return this;
        public Builder caseLevel(final boolean caseLevel) {  
            @Override
            org.apache.lucene.search.MultiTermQuery.RewriteMethod method,
        }  
import com.ibm.icu.util.ULocale;
                    if (country != null) {  
        }  
        }  
        RawCollationKey key = collator.getRawCollationKey(value, null);
        }
/*  
        }
        this.ignoreAbove = ignoreAbove;
        public String language() {
                        break;  
    @Override
            public BytesRef parseBytesRef(String value) {
            this.variableTop = variableTop;
                ignoreAbove,
        }
                char[] encoded = value.toCharArray();
                value = nullValue;  
                        iterator.remove();
    private final String alternate;
            if (decomposition != null) {  
                rbc.setVariableTop(variableTop);
        if (numeric != icuMergeWith.numeric) {
            builder.field("alternate", alternate);  
 */  
        }
            return this;
        }
            @Override
        }
import org.apache.lucene.util.BytesRef;
                    case "hiragana_quaternary_mode":  
                        builder.caseFirst(XContentMapValues.nodeStringValue(fieldNode, null));
        }  
                    case "rules":
            if (variableTop != null) {
                value = parser.textOrNull();
                    case "null_value":
    private final boolean numeric;
        public Builder caseFirst(final String caseFirst) {  
            }
 */  
            return this;
                        if (fieldNode == null) {
            return this;
            throw new UnsupportedOperationException("[regexp] queries are not supported on [" + CONTENT_TYPE + "] fields.");
                }  
    private final String decomposition;  
                        break;
            public String format(BytesRef value) {
            };
        if (nullValue != null) {
                    if (keywordValue.length() > ignoreAbove) {
                int encodedLength = IndexableBinaryStringTools.getEncodedLength(value.bytes, value.offset, value.length);  
            context.doc().add(field);
        static {
                ignoreAbove,
import java.util.Iterator;  
                switch (fieldName) {  
 * ownership. Elasticsearch licenses this file to you under  
            Object value,
            conflicts.add("Cannot update parameter [decomposition] for [" + CONTENT_TYPE + "]");
                        }
            if (value == null) {  
        @Override  
                    throw new IllegalArgumentException("Failed to parse collation rules", e);
 *
    }  
            }  
        if (!Objects.equals(strength, icuMergeWith.strength)) {  
        this.collator = collator;  
                    case "country":  
        if (includeDefaults || country != null) {
        }
                        builder.country(XContentMapValues.nodeStringValue(fieldNode, null));
        public Builder hiraganaQuaternaryMode(final boolean hiraganaQuaternaryMode) {  
        }
        MultiFields multiFields,  
                return null;
            builder.field("rules", rules);  
        }  
                        builder.strength(XContentMapValues.nodeStringValue(fieldNode, null));  
 * GitHub history for details.
            int matchFlags,
        @Override
        if (includeDefaults || variableTop != null) {  
import org.opensearch.core.xcontent.XContentParser;  
        private String strength = null;  
        @Override
            builder.field("case_level", caseLevel);
                } else if (decomposition.equalsIgnoreCase("canonical")) {  
    public CollationFieldType fieldType() {
            );
            conflicts.add("Cannot update parameter [variable_top] for [" + CONTENT_TYPE + "]");
 * Licensed to Elasticsearch under one or more contributor  
    private final String nullValue;  
        }
            context.doc().add(new SortedSetDocValuesField(fieldType().name(), binaryValue));
        if (value == null || value.length() > ignoreAbove) {  
            conflicts.add("Cannot update parameter [rules] for [" + CONTENT_TYPE + "]");  
            builder.field("index_options", indexOptionToString(fieldType.indexOptions()));  
            return this;
        ) {  
        if (!Objects.equals(rules, icuMergeWith.rules)) {
                if (strength.equalsIgnoreCase("primary")) {
            }  
        public Builder rules(final String rules) {  
            return language;  
        String nullValue
 * this work for additional information regarding copyright
            @Override  
    private int ignoreAbove;
        }
                } else if (strength.equalsIgnoreCase("identical")) {
                IndexableBinaryStringTools.decode(encoded, 0, encoded.length, decoded, 0, decodedLength);
 * software distributed under the License is distributed on an
                String fieldName = entry.getKey();
                throw new IllegalArgumentException("[ignore_above] must be positive, got " + ignoreAbove);
            value = context.externalValue().toString();
        }  
                value = bytesRef.utf8ToString();
                    } else {  
                    case "variable_top":
                    collator.setDecomposition(Collator.CANONICAL_DECOMPOSITION);
                        break;  
            conflicts.add("Cannot update parameter [country] for [" + CONTENT_TYPE + "]");
import org.apache.lucene.search.Query;
    private final Collator collator;
                } else {
                    collator.setStrength(Collator.TERTIARY);
        public static final int IGNORE_ABOVE = Integer.MAX_VALUE;
        }  
        String variant,
    @Override
        public Builder indexOptions(IndexOptions indexOptions) {
        public String alternate() {
        public Builder language(final String language) {  
 * Modifications Copyright OpenSearch Contributors. See
                        builder.decomposition(XContentMapValues.nodeStringValue(fieldNode, null));
                Map.Entry<String, Object> entry = iterator.next();  
            String value,
import org.opensearch.index.analysis.IndexableBinaryStringTools;
 * KIND, either express or implied.  See the License for the
        public static DocValueFormat COLLATE_FORMAT = new DocValueFormat() {
        return new BytesRef(key.bytes, 0, key.size);
                }
        private String country = null;
            return this;
    public static class Builder extends FieldMapper.Builder<Builder> {
        }  
    public static final class CollationFieldType extends StringFieldType {
                        builder.omitNorms(!XContentMapValues.nodeBooleanValue(fieldNode, "norms"));
        public String typeName() {  
        private final int ignoreAbove;
                }  
                fieldType.stored(),
            String name,
        }
        public DocValueFormat docValueFormat(final String format, final ZoneId timeZone) {
 * the Apache License, Version 2.0 (the "License"); you may
            }
            builder.field("ignore_above", ignoreAbove);  
 *
            conflicts.add("Cannot update parameter [strength] for [" + CONTENT_TYPE + "]");
    protected void parseCreateField(ParseContext context) throws IOException {
        final String value;  
        return (CollationFieldType) super.fieldType();  
                country,
    protected void doXContentBody(XContentBuilder builder, boolean includeDefaults, Params params) throws IOException {  
                } else {
            this.collator = collator;
            throw new UnsupportedOperationException("[fuzzy] queries are not supported on [" + CONTENT_TYPE + "] fields.");
            boolean hasDocValues,
        String variableTop,  
                    throw new IllegalArgumentException("Invalid strength: " + strength);
        private boolean caseLevel = false;  
                Object fieldNode = entry.getValue();
        }  
    }
            TypeParsers.parseField(builder, name, node, parserContext);
        boolean hiraganaQuaternaryMode,
                ft,
            Map<String, String> meta  
        }
            this.caseLevel = caseLevel;
            createFieldNamesField(context);
        public Builder nullValue(String nullValue) {
        @Override
        protected String nullValue;  
 * SPDX-License-Identifier: Apache-2.0
        if (caseLevel != icuMergeWith.caseLevel) {  
        }
import org.opensearch.common.Nullable;  
                        builder.caseLevel(XContentMapValues.nodeBooleanValue(fieldNode, false));  
            return new ICUCollationKeywordFieldMapper(
    }
                    rbc.setLowerCaseFirst(true);
 * The OpenSearch Contributors require contributions made to  
        if (!Objects.equals(variableTop, icuMergeWith.variableTop)) {  
                    rbc.setUpperCaseFirst(true);  
                    throw new IllegalArgumentException("Invalid alternate: " + alternate);  
                int decodedLength = IndexableBinaryStringTools.getDecodedLength(encoded, 0, encoded.length);  
        int ignoreAbove,
    }  
        this.ignoreAbove = icuMergeWith.ignoreAbove;
                        break;
        }
        public Collator buildCollator() {
        public Builder strength(final String strength) {  
    }  
        public Mapper.Builder<?> parse(String name, Map<String, Object> node, ParserContext parserContext) throws MapperParsingException {
        final BytesRef binaryValue = parseCollationKey(context);  
        }
            conflicts.add("Cannot update parameter [case_first] for [" + CONTENT_TYPE + "]");
                        break;
                variableTop,  
                        break;
                rbc.setHiraganaQuaternary(true);  
            return decomposition;  
        private final Collator collator;  
        public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitive, QueryShardContext context) {
        private String decomposition = null;
                        break;
                    case "language":
                    collator = Collator.getInstance(locale);  
        public Builder variableTop(final String variableTop) {  
        if (!Objects.equals(country, icuMergeWith.country)) {
        }
        }  
        }
            }
        this.caseLevel = caseLevel;  
        if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
            // set the decomposition flag, otherwise it will be the default.
                    case "ignore_above":
            String value,  
        }
                caseLevel,  
            QueryShardContext context
        this.caseFirst = caseFirst;
        public String variant() {
            boolean isStored,
            builder.field("null_value", nullValue);  
public class ICUCollationKeywordFieldMapper extends FieldMapper {  
                return new BytesRef(key.bytes, 0, key.size);  
            if (hiraganaQuaternaryMode) {
        }
    private final String rules;
            return variableTop;  
            }
                    throw new IllegalArgumentException("Invalid caseFirst: " + caseFirst);
                    ULocale locale;
                multiFieldsBuilder.build(this, context),  
        }  
        this.strength = strength;  
                meta  
            failIfNoDocValues();  
            } else {  
            boolean isSearchable,  
            }  
                );  
            this.nullValue = nullValue;
        public boolean hiraganaQuaternaryMode() {
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
                } else {  
        Collator collator,  
                        break;
        public Builder decomposition(final String decomposition) {  
    public static final String CONTENT_TYPE = "icu_collation_keyword";
        }
        @Override  
            int maxExpansions,
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            builder = this;
        FieldType fieldType,
                        iterator.remove();  
 *  
                        break;
                collator,  
    }  
import java.util.Objects;  
        private String caseFirst = null;
            super(name, Defaults.FIELD_TYPE);  
            }  
            }
        } else {  
            builder.field("language", language);
 * Unless required by applicable law or agreed to in writing,
        }
            conflicts.add("Cannot update parameter [numeric] for [" + CONTENT_TYPE + "]");  
                    case "case_level":
        public Query fuzzyQuery(
        private boolean hiraganaQuaternaryMode = false;
            boolean caseInsensitive,
import org.apache.lucene.document.FieldType;  
            return super.indexOptions(indexOptions);  
        public Builder ignoreAbove(int ignoreAbove) {  
    public static class Defaults {
                hiraganaQuaternaryMode,
                        break;  
            builder.field("strength", strength);
            this.alternate = alternate;
                language,  
        };
        public static final FieldType FIELD_TYPE = new FieldType();
            conflicts.add("Cannot update parameter [variant] for [" + CONTENT_TYPE + "]");  
        ) {  
        ICUCollationKeywordFieldMapper icuMergeWith = (ICUCollationKeywordFieldMapper) other;
        CopyTo copyTo,
        this.decomposition = decomposition;
        private String language = null;  
            );
        if (includeDefaults || rules != null) {
        private String variant = null;
                        iterator.remove();  
            this.decomposition = decomposition;
        String decomposition,
            throw new UnsupportedOperationException("[prefix] queries are not supported on [" + CONTENT_TYPE + "] fields.");  
            XContentParser parser = context.parser();
            this.caseFirst = caseFirst;
                throw new IllegalStateException("collator is null");
                        iterator.remove();
        }
            return new SourceValueFetcher(name(), context, nullValue) {
                        builder.numeric(XContentMapValues.nodeBooleanValue(fieldNode, false));
            }
 * compatible open source license.
                        break;
                char[] encoded = new char[encodedLength];
            return this;
        }  
            }
            }
import org.opensearch.common.xcontent.support.XContentMapValues;  
            }
                        iterator.remove();
        }
                        builder.hiraganaQuaternaryMode(XContentMapValues.nodeBooleanValue(fieldNode, false));
                indexed,  
            return this;
