 * specific language governing permissions and limitations
            ft.setIndexAnalyzer(analyzer.getValue());
                                throw new IllegalArgumentException("weight must be an integer, but was [" + parser.numberValue() + "]");
    int getMaxInputLength() {
        }
            Set<String> inputs = new HashSet<>();
        this.maxInputLength = builder.maxInputLength.getValue();
    }
        // parse
            while ((token = parser.nextToken()) != Token.END_ARRAY) {
                if (inputMap.containsKey(input) == false || inputMap.get(input).weight < weight) {
        this.preservePosInc = builder.preservePosInc.getValue();
    /**
        /**
    /**
                        }
            ft.setPreserveSep(preserveSeparators.getValue());
            super(name, true, false, false, new TextSearchInfo(Defaults.FIELD_TYPE, null, searchAnalyzer, searchAnalyzer), meta);
    public void doValidate(MappingLookup mappers) {
            super(name);
     * Parsing:
         * Completion prefix fuzzy query
        /**
            boolean transpositions,
                if (token == Token.FIELD_NAME) {
import org.apache.lucene.search.suggest.document.SuggestField;
        return context.externalValue().getClass().equals(clazz);
                            );
     * <p>
                                } else {
     * @opensearch.internal
        private final Parameter<NamedAnalyzer> analyzer;
            inputMap = Collections.singletonMap(fieldName, new CompletionInputMetadata(fieldName, Collections.emptyMap(), 1));
        public void setPreserveSep(boolean preserveSep) {
import java.util.List;
                getTextSearchInfo().getSearchAnalyzer().analyzer(),
        public void setContextMappings(ContextMappings contextMappings) {
            int minFuzzyPrefixLength,
        @Override
        public static final String CONTENT_FIELD_NAME_WEIGHT = "weight";
     */
                maxExpansions
                        throw new IllegalArgumentException(
        public static final String CONTENT_FIELD_NAME_CONTEXTS = "contexts";
    public static final Set<String> ALLOWED_CONTENT_FIELD_NAMES = Sets.newHashSet(
        private ContextMappings contextMappings = null;
            int maxExpansions,
            return CONTENT_TYPE;
    );
        }
    private final ContextMappings contexts;
        private final Parameter<ContextMappings> contexts = new Parameter<>(
                                }
    static final int COMPLETION_CONTEXTS_LIMIT = 10;
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
                );
                        + COMPLETION_CONTEXTS_LIMIT
         * @return associated context mappings for this field type
                        } else if (token == Token.VALUE_NUMBER) {
         * @return true if there are one or more context mappings defined
        private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Builder.class);
    public static class Builder extends ParametrizedFieldMapper.Builder {
                        ContextMappings contextMappings = fieldType().getContextMappings();
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
        @Override
            while ((token = parser.nextToken()) != Token.END_OBJECT) {
                contextMapping.validateReferences(indexVersionCreated, s -> mappers.fieldTypes().get(s));
        ).alwaysSerialize();
                defaultAnalyzer,
            CompletionFieldType ft = new CompletionFieldType(buildFullName(context), completionAnalyzer, meta.getValue());
 *
        private final Parameter<Boolean> preservePosInc = Parameter.boolParam(
     *
                "failed to parse [" + parser.currentName() + "]: expected text or object, but got " + token.name()
import org.opensearch.Version;
        Token token = parser.currentToken();
import org.opensearch.index.analysis.AnalyzerScope;
            }
    /**
 * not use this file except in compliance with the License.
                        XContentParser.Token currentToken = parser.currentToken();
                        } else if (token == Token.START_ARRAY) {
        }
import org.opensearch.core.xcontent.ToXContent;
    }
            "preserve_separators",
            return;
        }
                ft,
        public final int weight;
                            throw new IllegalArgumentException("contexts must be an object or an array , but was [" + currentToken + "]");
                getTextSearchInfo().getSearchAnalyzer().analyzer(),
         * @return postings format to use for this field-type
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        if (fieldType().hasContextMappings() == false) {
        return CONTENT_TYPE;
                fuzziness.asDistance(),
     * Metadata for completion input
            int nonFuzzyPrefixLength,
            return Arrays.asList(analyzer, searchAnalyzer, preserveSeparators, preservePosInc, maxInputLength, contexts, meta);
                parser.getTokenLocation(),
        public static final String CONTENT_FIELD_NAME_INPUT = "input";
                int len = Math.min(maxInputLength, input.length());
            ft.setPreservePositionIncrements(preservePosInc.getValue());
            return postingsFormat;
import java.util.Map;
 * see {@link #parse(ParseContext)} for acceptable inputs for indexing<br>
        }
        // Content field names
            return contextMappings;
     */
        }
import java.util.HashMap;
            false,
    private final boolean preserveSeparators;
 */
        private boolean preservePositionIncrements = Defaults.DEFAULT_POSITION_INCREMENTS;
import org.apache.lucene.search.suggest.document.CompletionQuery;
        this.indexVersionCreated = indexVersionCreated;
        }
 */
            return new ArraySourceValueFetcher(name(), context) {
                                if (token == Token.VALUE_STRING) {
            FIELD_TYPE.setTokenized(true);
            m -> toType(m).preserveSeparators,
                                } else {
        }
         * Completion prefix query
                    if (Fields.CONTENT_FIELD_NAME_INPUT.equals(currentFieldName)) {
        XContentParser parser = context.parser();
        return inputMap;
        public static final boolean DEFAULT_POSITION_INCREMENTS = true;
            CompletionInputMetadata inputAndMeta = (CompletionInputMetadata) context.externalValue();
import org.opensearch.core.common.ParsingException;
                            weightValue = parser.numberValue();
        public Builder(String name, NamedAnalyzer defaultAnalyzer, Version indexVersionCreated) {
     * Field type for Completion Field Mapper
                name,
    protected String contentType() {
        }
 * Unless required by applicable law or agreed to in writing,
        ).alwaysSerialize();
import java.util.HashSet;
    }
     *  else adds inputs as a {@link org.apache.lucene.search.suggest.document.SuggestField}
    /**
                                    contextsMap.put(fieldName, contextMapping.parseContext(parseContext, parser));
                        }
     *
                                "weight must be in the interval [0..2147483647], but was [" + weightValue.longValue() + "]"
    @Override
                            throw new IllegalArgumentException("input must be a string or array, but was [" + token.name() + "]");
        }
            throw new ParsingException(
        private final Parameter<Boolean> preserveSeparators = Parameter.boolParam(
            }
    }
            for (String input : inputs) {
    @Override
import org.apache.lucene.document.FieldType;
                                throw new IllegalArgumentException("weight must be an integer, but was [" + parser.text() + "]");
            if (maxInputLength <= 0) {
        public final String input;
            if (fieldType().hasContextMappings()) {
        public CompletionFieldMapper build(BuilderContext context) {
            m -> toType(m).maxInputLength,
    public static class Fields {
 * ownership. Elasticsearch licenses this file to you under
            inputMap = getInputMapFromExternalValue(context);
                input = input.substring(0, len);
            this.weight = weight;
    private final int maxInputLength;
     * Parameter fields
     * Maximum allowed number of completion contexts in a mapping.
 *
}
    /**
 * fast auto-completion/search-as-you-type functionality.<br>
        }
    @Override
import org.opensearch.common.logging.DeprecationLogger;
            false,
            true,
import org.apache.lucene.search.suggest.document.PrefixCompletionQuery;
 */
            if (postingsFormat == null) {
    public CompletionFieldMapper(
                context.addIgnoredField(mappedFieldType.name());
                    } else if (Fields.CONTENT_FIELD_NAME_WEIGHT.equals(currentFieldName)) {
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
                                }
import org.opensearch.search.suggest.completion.CompletionSuggester;
                        + COMPLETION_CONTEXTS_LIMIT
    }
        @Override
        public CompletionFieldType(String name, NamedAnalyzer searchAnalyzer, Map<String, String> meta) {
        Map<String, CompletionInputMetadata> inputMap = new HashMap<>(1);
        // index
 * under the License.
            }
                            }
                    if (value instanceof List) {
        return new Builder(simpleName(), defaultAnalyzer, indexVersionCreated).init(this);
     * Acceptable inputs:
 *  <li>"preserve_separators" : true, (default)</li>
            this.contexts = contexts;
        public CompletionQuery prefixQuery(Object value) {
            String fieldName = context.externalValue().toString();
            final NamedAnalyzer indexAnalyzer = super.indexAnalyzer();
                null,
        public void setPreservePositionIncrements(boolean preservePositionIncrements) {
import org.opensearch.common.util.set.Sets;
import org.opensearch.common.unit.Fuzziness;
        Fields.CONTENT_FIELD_NAME_CONTEXTS
        }
                            if (NumberType.LONG != numberType && NumberType.INT != numberType) {
                }
                this
                                    inputs.add(parser.text());
        public static final boolean DEFAULT_PRESERVE_SEPARATORS = true;
    ) {
import org.apache.lucene.index.IndexOptions;
import org.opensearch.core.xcontent.XContentParser.Token;
import java.io.IOException;
        Builder builder
            () -> null,
        ) {
/*
     * @opensearch.internal
        Map<String, CompletionInputMetadata> inputMap;
     * @opensearch.internal
                                        "input array must have string values, but was [" + token.name() + "]"
            }
 * Modifications Copyright OpenSearch Contributors. See
        public boolean hasContextMappings() {
            parse(context, token, parser, inputMap);
            this.preservePositionIncrements = preservePositionIncrements;
                        + "The maximum allowed number of completion contexts in a mapping will be limited to "
                        if (weightValue.longValue() < 0 || weightValue.longValue() > Integer.MAX_VALUE) {
        this.analyzer = builder.analyzer.getValue();
            // truncate input
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                    } else {
    }
                        return (List<?>) value;
            }
    @Override
     *   "OBJECT" - { "input": STRING|ARRAY, "weight": STRING|INT, "contexts": ARRAY|OBJECT }
        } else {
            }
 * GitHub history for details.
            FIELD_TYPE.freeze();
                        + "]. "
        this.contexts = builder.contexts.getValue();
    }
 * license agreements. See the NOTICE file distributed with
                        } else {
            b.startArray(n);
        public static final FieldType FIELD_TYPE = new FieldType();
                            throw new IllegalArgumentException("weight must be a number or string, but was [" + token.name() + "]");
                        }
         * for this field type
                context.doc().add(new SuggestField(fieldType().name(), input, metadata.weight));
import org.apache.lucene.codecs.PostingsFormat;
                            while ((token = parser.nextToken()) != Token.END_ARRAY) {
    }
    }
            FIELD_TYPE.setOmitNorms(true);
                @Override
    /**
                return new NamedAnalyzer(
    }
                                    assert !contextsMap.containsKey(fieldName);
        }
import java.util.Set;
                this.searchAnalyzer.getValue().name(),
                deprecationLogger.deprecate(
        Fields.CONTENT_FIELD_NAME_WEIGHT,
                        + "] completion contexts"
        this.searchAnalyzer = builder.searchAnalyzer.getValue();
                new Term(name(), indexedValueForSearch(value))
        CopyTo copyTo,
                    if (!ALLOWED_CONTENT_FIELD_NAMES.contains(currentFieldName)) {
                new Term(name(), indexedValueForSearch(value)),
        @Override
            Defaults.DEFAULT_POSITION_INCREMENTS
            return indexAnalyzer;
                protected List<?> parseSourceValue(Object value) {
     */
                );
     * @opensearch.internal
        return maxInputLength;
        }
     *  "STRING" - interpreted as the field value (input)
        public String typeName() {
                                    throw new IllegalArgumentException(
     *   "STRING" - interpreted as field value (input)
                indexVersionCreated,
import org.opensearch.index.query.QueryShardContext;
     * <p>
            b.endArray();
            inputMap = Collections.singletonMap(inputAndMeta.input, inputAndMeta);
        }
                postingsFormat = new Completion104PostingsFormat();
                        + "["
    }
                                    assert fieldName != null;
        public final Map<String, Set<String>> contexts;
    /**
    @Override
                transpositions,
            return input;
        } else {
                new CompletionAnalyzer(this.searchAnalyzer.getValue(), preserveSeparators.getValue(), preservePosInc.getValue())
            );
                            }
     *
import java.util.Objects;
        this.defaultAnalyzer = defaultAnalyzer;
    }
import org.apache.lucene.search.suggest.document.RegexCompletionQuery;
        for (Map.Entry<String, CompletionInputMetadata> completionInput : inputMap.entrySet()) {
                copyTo.build(),
     */
        if (fieldType().hasContextMappings()) {
         */
                        + " in the mapping for index ["
        if (context.externalValueSet()) {
 * software distributed under the License is distributed on an
        @Override
/*
                return;
            }
            this.preserveSep = preserveSep;
                                    );
import org.opensearch.cluster.metadata.IndexMetadata;
     * Indexing:
                throw new IllegalArgumentException("[max_input_length] must be > 0 but was [" + maxInputLength + "]");
                        );
                            throw new IllegalArgumentException("contexts field is not supported for field: [" + fieldType().name() + "]");
                }
                multiFieldsBuilder.build(this, context),
            };
    protected void parseCreateField(ParseContext context) throws IOException {
    }
            NamedAnalyzer completionAnalyzer = new NamedAnalyzer(
import org.opensearch.search.lookup.SearchLookup;
            m -> toType(m).contexts
                } else if (currentFieldName != null) {
    public static final String CONTENT_TYPE = "completion";
         */
    public boolean parsesArrayValue() {
            (n, c, o) -> ContextMappings.load(o, c.indexVersionCreated()),
    public static final class CompletionFieldType extends TermBasedFieldType {
        }
            }
import org.opensearch.index.analysis.NamedAnalyzer;
            for (ContextMapping<?> contextMapping : fieldType().getContextMappings()) {
         */
    @Override
         */
            this.defaultAnalyzer = defaultAnalyzer;
         */
                    }
     */
import org.apache.lucene.search.suggest.document.Completion104PostingsFormat;
        return (CompletionFieldMapper) in;
                        }
                                    fieldName = parser.currentName();
     */
    @Override
        private final Parameter<Integer> maxInputLength = Parameter.intParam(
                    AnalyzerScope.INDEX,
 * see {@link ContextMappings#load(Object, Version)} for CONTEXTS<br>
            m -> toType(m).preservePosInc,
            return new PrefixCompletionQuery(
        public ContextMappings getContextMappings() {
        public static final int DEFAULT_MAX_INPUT_LENGTH = 50;
                                    contextMapping = contextMappings.get(fieldName);
        }
    private final Version indexVersionCreated;
    private final NamedAnalyzer defaultAnalyzer;
            if (this.contexts.getValue() != null && this.contexts.getValue().size() > COMPLETION_CONTEXTS_LIMIT) {
        throws IOException {
 * </ul>
                    "You have defined more than ["
import org.opensearch.search.suggest.completion.context.ContextMapping;
 *  This field type constructs completion queries that are run
        MappedFieldType mappedFieldType,
                unicodeAware,
            }
        }
        this.preserveSeparators = builder.preserveSeparators.getValue();
        // no-op
        if (isExternalValueOfClass(context, CompletionInputMetadata.class)) {
                            inputs.add(parser.text());
        MultiFields multiFields,
            Map<String, Set<String>> contextsMap = new HashMap<>();
        Fields.CONTENT_FIELD_NAME_INPUT,
    @Override
            int weight = 1;
                        + "] starting in version [8.0]."
        (n, c) -> new Builder(n, c.getIndexAnalyzers().get("simple"), c.indexVersionCreated())
        CompletionInputMetadata(String input, Map<String, Set<String>> contexts, int weight) {
import org.apache.lucene.search.suggest.document.CompletionAnalyzer;
                        // always parse a long to make sure we don't get overflow
                    assert input.length() >= len + 1 && Character.isLowSurrogate(input.charAt(len));
        }
        NamedAnalyzer defaultAnalyzer,
 * You may obtain a copy of the License at
                    } else if (Fields.CONTENT_FIELD_NAME_CONTEXTS.equals(currentFieldName)) {
            if (format != null) {
import org.opensearch.core.xcontent.XContentParser;
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
                    }
 *  <li>"preserve_position_increments" : true (default)</li>
        private static PostingsFormat postingsFormat;
        @Override
    }
        return true;
         */
        if (token == Token.VALUE_STRING) {
     *  if context mappings are defined, delegates to {@link ContextMappings#addField(ParseContext.Document, String, String, int, Map)}
            "max_input_length",
        public CompletionQuery fuzzyQuery(
    private void parse(ParseContext parseContext, Token token, XContentParser parser, Map<String, CompletionInputMetadata> inputMap)
            return contextMappings != null;
 *  <li>"min_input_length": 50 (default)</li>
        createFieldNamesField(context);
            if (indexAnalyzer != null && !(indexAnalyzer.analyzer() instanceof CompletionAnalyzer)) {
                nonFuzzyPrefixLength,
                    }
            }
        String currentFieldName = null;
 * SPDX-License-Identifier: Apache-2.0
    public static final TypeParser PARSER = new TypeParser(
        protected List<Parameter<?>> getParameters() {
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
    public void parse(ParseContext context) throws IOException {
    private final NamedAnalyzer searchAnalyzer;
            ft.setContextMappings(contexts.getValue());
import java.util.Arrays;
                        weight = weightValue.intValue();
import java.util.Collections;
                                if (currentToken == XContentParser.Token.FIELD_NAME) {
        }
    /**
                        } else {
                                weightValue = Long.parseLong(parser.text());
     * Builder for {@link CompletionFieldMapper}
                            try {
 * this work for additional information regarding copyright
    }
import org.apache.lucene.search.suggest.document.FuzzyCompletionQuery;
                        if (token == Token.VALUE_STRING) {
        private final Version indexVersionCreated;
        ).setSerializer((b, n, c) -> {
        return (CompletionFieldType) super.fieldType();
            }
import org.opensearch.core.xcontent.XContentParser.NumberType;
                            while ((currentToken = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        /**
        /**
                        } else {
            return new FuzzyCompletionQuery(
                            }
         * @param name of the completion field to build
     *  Acceptable format:
            c.toXContent(b, ToXContent.EMPTY_PARAMS);
            "contexts",
        } else {
                if (Character.isHighSurrogate(input.charAt(len - 1))) {
package org.opensearch.index.mapper;
            String input = completionInput.getKey();
            );
            return new RegexCompletionQuery(new Term(name(), indexedValueForSearch(value)), flags, maxDeterminizedStates);
                    currentFieldName = parser.currentName();
            );
            boolean unicodeAware
        public NamedAnalyzer indexAnalyzer() {
            return new CompletionFieldMapper(
                            "unknown field name [" + currentFieldName + "], must be one of " + ALLOWED_CONTENT_FIELD_NAMES
 * this file be licensed under the Apache-2.0 license or a
            if (input.trim().isEmpty()) {
 * Licensed to Elasticsearch under one or more contributor
    static class CompletionInputMetadata {
                            String fieldName = null;
            String value,
            this.searchAnalyzer = Parameter.analyzerParam("search_analyzer", true, m -> toType(m).searchAnalyzer, analyzer::getValue);
     *
 * compatible open source license.
 * <p>
        public String toString() {
            FIELD_TYPE.setStoreTermVectors(false);
         * Completion prefix regular expression query
        }
                    indexAnalyzer.name(),
            Fuzziness fuzziness,
                        + context.indexSettings().get(IndexMetadata.SETTING_INDEX_PROVIDED_NAME)
 *  @opensearch.internal
                minFuzzyPrefixLength,
        Version indexVersionCreated,
        }
                            ContextMapping contextMapping = null;
 * the Apache License, Version 2.0 (the "License"); you may
            Defaults.DEFAULT_PRESERVE_SEPARATORS
     *
            this.input = input;
 *  <li>"search_analyzer": "simple", (default)</li>
        String simpleName,
                continue;
    private static CompletionFieldMapper toType(FieldMapper in) {
            );
                        final Number weightValue;
            );
         */
 */
        super(simpleName, mappedFieldType, multiFields, copyTo);
                        if (token == Token.VALUE_STRING) {
        private void checkCompletionContextsLimit(BuilderContext context) {
            false,
                            } catch (NumberFormatException e) {
        /**
 * The OpenSearch Contributors require contributions made to
 *  This field can also be extended to add search criteria to suggestions
            this.analyzer = Parameter.analyzerParam("analyzer", false, m -> toType(m).analyzer, () -> defaultAnalyzer).alwaysSerialize();
            } else {
                        if (currentToken == XContentParser.Token.START_OBJECT) {
 * Mapper for completion field. The field values are indexed as a weighted FST for
            FIELD_TYPE.setStored(false);
        private final NamedAnalyzer defaultAnalyzer;
     * Parses and indexes inputs
                            throw new IllegalArgumentException(
    private final boolean preservePosInc;
        } else if (token == Token.START_ARRAY) {
                    new CompletionAnalyzer(indexAnalyzer, preserveSep, preservePositionIncrements)
    }
    private final NamedAnalyzer analyzer;
        }
        /**
        }
 *
        static {
        }
        ).addDeprecatedName("max_input_len").setValidator(Builder::validateInputLength).alwaysSerialize();
        } else if (token == Token.VALUE_NULL) { // ignore null values
            checkCompletionContextsLimit(context);
            this.contextMappings = contextMappings;
 * <ul>
        private static void validateInputLength(int maxInputLength) {
                }
        public CompletionQuery regexpQuery(Object value, int flags, int maxDeterminizedStates) {
            }
    private Map<String, CompletionInputMetadata> getInputMapFromExternalValue(ParseContext context) {
            this.indexVersionCreated = indexVersionCreated;
    }
     *  "OBJECT" - { "input": STRING|ARRAY, "weight": STRING|INT, "contexts": ARRAY|OBJECT }
                }
 * KIND, either express or implied.  See the License for the
 *  <li>"contexts" : CONTEXTS</li>
                    "excessive_completion_contexts",
 *  for query-time filtering and boosting (see {@link ContextMappings}
        private final Parameter<NamedAnalyzer> searchAnalyzer;
                AnalyzerScope.INDEX,
            inputMap.put(parser.text(), new CompletionInputMetadata(parser.text(), Collections.<String, Set<String>>emptyMap(), 1));
                        return Collections.singletonList(value);
 *
    }
     *   "ARRAY" - each element can be one of "OBJECT" (see below)
        public static synchronized PostingsFormat postingsFormat() {
                        }
 *  <li>"analyzer": "simple", (default)</li>
import org.apache.lucene.index.Term;
            if (input.length() > maxInputLength) {
                            NumberType numberType = parser.numberType();
/**
    private boolean isExternalValueOfClass(ParseContext context, Class<?> clazz) {
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
                            }
     */
            }
        /**
                    len += 1;
        }
        for (CompletionInputMetadata metadata : inputMap.values()) {
    public static class Defaults {
            Defaults.DEFAULT_MAX_INPUT_LENGTH
        // no-op
        }
            "preserve_position_increments",
            ParseContext externalValueContext = context.createExternalValueContext(metadata);
    public CompletionFieldType fieldType() {
public class CompletionFieldMapper extends ParametrizedFieldMapper {
                    inputMap.put(input, new CompletionInputMetadata(input, contextsMap, weight));
 * Type properties:<br>
            if (c == null) {
        }, Objects::toString);
     * Default parameters
                parse(context, token, parser, inputMap);
            multiFields.parse(this, externalValueContext);
import org.opensearch.search.suggest.completion.context.ContextMappings;
            CompletionInputMetadata metadata = completionInput.getValue();
 *  against the weighted FST index by the {@link CompletionSuggester}.
                fieldType().getContextMappings().addField(context.doc(), fieldType().name(), input, metadata.weight, metadata.contexts);
/*
 *
     * @opensearch.internal
    }
        private boolean preserveSep = Defaults.DEFAULT_PRESERVE_SEPARATORS;
    );
        } else if (token == Token.START_OBJECT) {
