                        + "]. "
                            inputs.add(parser.text());
            true,
    int getMaxInputLength() {
        private boolean preservePositionIncrements = Defaults.DEFAULT_POSITION_INCREMENTS;  
            this.searchAnalyzer = Parameter.analyzerParam("search_analyzer", true, m -> toType(m).searchAnalyzer, analyzer::getValue);
        @Override  
                        );  
 *
     * Maximum allowed number of completion contexts in a mapping.  
        }, Objects::toString);
import org.opensearch.core.xcontent.ToXContent;
        protected List<Parameter<?>> getParameters() {  
        /**  
     *  Acceptable format:
    }  
        this.indexVersionCreated = indexVersionCreated;
import org.opensearch.search.lookup.SearchLookup;  
     */  
                if (token == Token.FIELD_NAME) {
 *  against the weighted FST index by the {@link CompletionSuggester}.
        @Override
                            }  
    private final boolean preservePosInc;
        }  
        NamedAnalyzer defaultAnalyzer,
                                }
                    currentFieldName = parser.currentName();
         * @return postings format to use for this field-type
        public static final String CONTENT_FIELD_NAME_WEIGHT = "weight";
            inputMap.put(parser.text(), new CompletionInputMetadata(parser.text(), Collections.<String, Set<String>>emptyMap(), 1));
/*  
                        weight = weightValue.intValue();  
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
import org.apache.lucene.index.Term;  
            if (input.trim().isEmpty()) {
            }
            return contextMappings;  
        @Override
            this.input = input;
     * <p>
            return contextMappings != null;
                    } else if (Fields.CONTENT_FIELD_NAME_CONTEXTS.equals(currentFieldName)) {
     * Acceptable inputs:
        private static void validateInputLength(int maxInputLength) {
         * @return associated context mappings for this field type  
     * @opensearch.internal
                                }  
            FIELD_TYPE.setStored(false);  
        private final Parameter<NamedAnalyzer> searchAnalyzer;
            }  
        Map<String, CompletionInputMetadata> inputMap = new HashMap<>(1);  
                        + COMPLETION_CONTEXTS_LIMIT
                            }
            while ((token = parser.nextToken()) != Token.END_OBJECT) {  
        @Override
    /**
                this.searchAnalyzer.getValue().name(),
    private void parse(ParseContext parseContext, Token token, XContentParser parser, Map<String, CompletionInputMetadata> inputMap)  
     * Indexing:  
                fieldType().getContextMappings().addField(context.doc(), fieldType().name(), input, metadata.weight, metadata.contexts);
        }  
            }  
     * Parsing:  
 *
/**  
import java.util.Map;
        /**  
     */  
 * not use this file except in compliance with the License.
            inputMap = Collections.singletonMap(inputAndMeta.input, inputAndMeta);
        ).addDeprecatedName("max_input_len").setValidator(Builder::validateInputLength).alwaysSerialize();
        }  
            this.analyzer = Parameter.analyzerParam("analyzer", false, m -> toType(m).analyzer, () -> defaultAnalyzer).alwaysSerialize();
     *
    private final ContextMappings contexts;
        for (Map.Entry<String, CompletionInputMetadata> completionInput : inputMap.entrySet()) {  
                        } else {
                new Term(name(), indexedValueForSearch(value)),
                                    contextsMap.put(fieldName, contextMapping.parseContext(parseContext, parser));
import org.opensearch.common.util.set.Sets;  
            if (this.contexts.getValue() != null && this.contexts.getValue().size() > COMPLETION_CONTEXTS_LIMIT) {  
                                    fieldName = parser.currentName();  
 * software distributed under the License is distributed on an
    private Map<String, CompletionInputMetadata> getInputMapFromExternalValue(ParseContext context) {  
        public void setContextMappings(ContextMappings contextMappings) {  
        /**
        this.defaultAnalyzer = defaultAnalyzer;  
            () -> null,  
        MultiFields multiFields,  
                getTextSearchInfo().getSearchAnalyzer().analyzer(),  
         * Completion prefix regular expression query  
                            throw new IllegalArgumentException("input must be a string or array, but was [" + token.name() + "]");
                                    throw new IllegalArgumentException(
        /**  
     *  "OBJECT" - { "input": STRING|ARRAY, "weight": STRING|INT, "contexts": ARRAY|OBJECT }
     *   "OBJECT" - { "input": STRING|ARRAY, "weight": STRING|INT, "contexts": ARRAY|OBJECT }
    /**
        @Override
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");  
                        if (token == Token.VALUE_STRING) {  
     */  
import org.opensearch.core.xcontent.XContentParser.NumberType;
        private boolean preserveSep = Defaults.DEFAULT_PRESERVE_SEPARATORS;
     *
            for (ContextMapping<?> contextMapping : fieldType().getContextMappings()) {
 */
        Token token = parser.currentToken();
                    if (value instanceof List) {  
                                        "input array must have string values, but was [" + token.name() + "]"  
        private void checkCompletionContextsLimit(BuilderContext context) {
            if (postingsFormat == null) {
     * Metadata for completion input
            ft.setPreserveSep(preserveSeparators.getValue());
                indexVersionCreated,  
     * Builder for {@link CompletionFieldMapper}
                if (inputMap.containsKey(input) == false || inputMap.get(input).weight < weight) {  
                return new NamedAnalyzer(
        this.maxInputLength = builder.maxInputLength.getValue();
        XContentParser parser = context.parser();
import org.opensearch.index.analysis.NamedAnalyzer;
            multiFields.parse(this, externalValueContext);
     * Default parameters
                                } else {
     * Field type for Completion Field Mapper  
 * Modifications Copyright OpenSearch Contributors. See  
 * KIND, either express or implied.  See the License for the
                        + " in the mapping for index ["  
            Defaults.DEFAULT_POSITION_INCREMENTS
 *  <li>"search_analyzer": "simple", (default)</li>
     */
            inputMap = getInputMapFromExternalValue(context);  
        return context.externalValue().getClass().equals(clazz);
        public static synchronized PostingsFormat postingsFormat() {  
                            } catch (NumberFormatException e) {  
            // truncate input  
                "failed to parse [" + parser.currentName() + "]: expected text or object, but got " + token.name()
                    } else if (Fields.CONTENT_FIELD_NAME_WEIGHT.equals(currentFieldName)) {
import org.apache.lucene.document.FieldType;
 * fast auto-completion/search-as-you-type functionality.<br>
        return new Builder(simpleName(), defaultAnalyzer, indexVersionCreated).init(this);  
                            if (NumberType.LONG != numberType && NumberType.INT != numberType) {
            );
            }  
        public String toString() {
        }  
     *   "ARRAY" - each element can be one of "OBJECT" (see below)  
    @Override  
import org.apache.lucene.search.suggest.document.CompletionAnalyzer;
 *  
import org.apache.lucene.index.IndexOptions;
    }
    @Override
                            NumberType numberType = parser.numberType();
                        + COMPLETION_CONTEXTS_LIMIT
import org.opensearch.common.unit.Fuzziness;
 * You may obtain a copy of the License at  
import org.apache.lucene.search.suggest.document.FuzzyCompletionQuery;
                continue;
            } else {  
                parse(context, token, parser, inputMap);
        String currentFieldName = null;
        // no-op  
        public void setPreserveSep(boolean preserveSep) {
        ) {
            if (indexAnalyzer != null && !(indexAnalyzer.analyzer() instanceof CompletionAnalyzer)) {
                        if (currentToken == XContentParser.Token.START_OBJECT) {
        public final int weight;
            Fuzziness fuzziness,
    /**  
     */
        }
    public static final TypeParser PARSER = new TypeParser(
        return CONTENT_TYPE;
 * ownership. Elasticsearch licenses this file to you under  
 *  
                            }
        this.searchAnalyzer = builder.searchAnalyzer.getValue();
            };  
 * the Apache License, Version 2.0 (the "License"); you may
                                "weight must be in the interval [0..2147483647], but was [" + weightValue.longValue() + "]"  
            );
                        + "] starting in version [8.0]."  
            );
                );  
        public CompletionQuery prefixQuery(Object value) {
import org.apache.lucene.codecs.PostingsFormat;  
            ft.setContextMappings(contexts.getValue());
import java.io.IOException;
     *  if context mappings are defined, delegates to {@link ContextMappings#addField(ParseContext.Document, String, String, int, Map)}
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                nonFuzzyPrefixLength,  
                            throw new IllegalArgumentException(
                        if (fieldType().hasContextMappings() == false) {
            ParseContext externalValueContext = context.createExternalValueContext(metadata);
        throws IOException {
import java.util.List;
                context.addIgnoredField(mappedFieldType.name());  
 */  
                AnalyzerScope.INDEX,  
                        if (token == Token.VALUE_STRING) {
        }  
    }
                        }
                        // always parse a long to make sure we don't get overflow  
            }
    }  
            ft.setIndexAnalyzer(analyzer.getValue());
        this.analyzer = builder.analyzer.getValue();
        if (context.externalValueSet()) {
     * Parameter fields  
    }
                null,  
         * @param name of the completion field to build
        return (CompletionFieldMapper) in;  
        Fields.CONTENT_FIELD_NAME_CONTEXTS
                                throw new IllegalArgumentException("weight must be an integer, but was [" + parser.text() + "]");
                                throw new IllegalArgumentException("weight must be an integer, but was [" + parser.numberValue() + "]");  
        private static PostingsFormat postingsFormat;  
    }
        // Content field names
        }
    private final boolean preserveSeparators;  
        }  
                                weightValue = Long.parseLong(parser.text());
        public static final FieldType FIELD_TYPE = new FieldType();  
                    } else {
            return new PrefixCompletionQuery(
import java.util.Collections;
import org.apache.lucene.search.suggest.document.CompletionQuery;  
            return CONTENT_TYPE;  
                        + "] completion contexts"
                }  
     * @opensearch.internal  
                                    assert fieldName != null;  
                } else if (currentFieldName != null) {
            "preserve_separators",
    public static class Fields {
                            weightValue = parser.numberValue();
    public void parse(ParseContext context) throws IOException {
    }  
         */
     *
     */
import org.opensearch.cluster.metadata.IndexMetadata;  
    public static final class CompletionFieldType extends TermBasedFieldType {
            Map<String, Set<String>> contextsMap = new HashMap<>();
    /**  
            }  
            Defaults.DEFAULT_PRESERVE_SEPARATORS
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
    private boolean isExternalValueOfClass(ParseContext context, Class<?> clazz) {  
 * see {@link #parse(ParseContext)} for acceptable inputs for indexing<br>
    }
    }
        }
        private final Parameter<Boolean> preserveSeparators = Parameter.boolParam(  
                        } else if (token == Token.START_ARRAY) {  
                            while ((token = parser.nextToken()) != Token.END_ARRAY) {
    @Override
import org.opensearch.common.logging.DeprecationLogger;
            }
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;  
        public void setPreservePositionIncrements(boolean preservePositionIncrements) {
    }
    public CompletionFieldType fieldType() {
import org.opensearch.core.xcontent.XContentParser;  
        private final Version indexVersionCreated;
import org.opensearch.search.suggest.completion.context.ContextMappings;  
                }  
        } else {
                            }
 * specific language governing permissions and limitations
 */
    public static class Defaults {
            FIELD_TYPE.freeze();
import org.opensearch.core.common.ParsingException;
     * @opensearch.internal
                            throw new IllegalArgumentException("contexts field is not supported for field: [" + fieldType().name() + "]");  
            int nonFuzzyPrefixLength,  
import org.opensearch.index.analysis.AnalyzerScope;  
    @Override
                @Override
        public NamedAnalyzer indexAnalyzer() {
    }
            (n, c, o) -> ContextMappings.load(o, c.indexVersionCreated()),
        public CompletionFieldMapper build(BuilderContext context) {
                minFuzzyPrefixLength,
        public static final String CONTENT_FIELD_NAME_CONTEXTS = "contexts";
    }
            FIELD_TYPE.setOmitNorms(true);  
                        return Collections.singletonList(value);  
        } else {
            return new FuzzyCompletionQuery(  
 * compatible open source license.
/*
 * this work for additional information regarding copyright
        }
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
        return maxInputLength;  
        if (fieldType().hasContextMappings()) {  
                            while ((currentToken = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                throw new IllegalArgumentException("[max_input_length] must be > 0 but was [" + maxInputLength + "]");
        public ContextMappings getContextMappings() {
import java.util.Objects;  
            );
        }
import org.apache.lucene.search.suggest.document.PrefixCompletionQuery;
 *  <li>"analyzer": "simple", (default)</li>  
            return Arrays.asList(analyzer, searchAnalyzer, preserveSeparators, preservePosInc, maxInputLength, contexts, meta);
    private final Version indexVersionCreated;  
    }
        } else if (token == Token.START_ARRAY) {  
     *  "STRING" - interpreted as the field value (input)  
    ) {
        public final String input;  
            "max_input_length",  
    private final NamedAnalyzer analyzer;  
            while ((token = parser.nextToken()) != Token.END_ARRAY) {
    private final NamedAnalyzer searchAnalyzer;
 *
        Map<String, CompletionInputMetadata> inputMap;
        Version indexVersionCreated,
import org.apache.lucene.search.suggest.document.RegexCompletionQuery;  
     *   "STRING" - interpreted as field value (input)
            }  
                parser.getTokenLocation(),  
            this.preservePositionIncrements = preservePositionIncrements;  
                    inputMap.put(input, new CompletionInputMetadata(input, contextsMap, weight));
        private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Builder.class);
        }  
            int weight = 1;
                context.doc().add(new SuggestField(fieldType().name(), input, metadata.weight));
         * @return true if there are one or more context mappings defined
         */
            super(name);
            inputMap = Collections.singletonMap(fieldName, new CompletionInputMetadata(fieldName, Collections.emptyMap(), 1));
    public CompletionFieldMapper(
        private ContextMappings contextMappings = null;
                        + "The maximum allowed number of completion contexts in a mapping will be limited to "  
                        return (List<?>) value;
            int minFuzzyPrefixLength,
 * see {@link ContextMappings#load(Object, Version)} for CONTEXTS<br>
            CompletionInputMetadata metadata = completionInput.getValue();  
     *  else adds inputs as a {@link org.apache.lucene.search.suggest.document.SuggestField}
import org.opensearch.core.xcontent.XContentParser.Token;
    /**
                            );
        this.preservePosInc = builder.preservePosInc.getValue();  
            if (maxInputLength <= 0) {  
        }
            Set<String> inputs = new HashSet<>();  
                maxExpansions  
        private final Parameter<Integer> maxInputLength = Parameter.intParam(
    @Override
        Fields.CONTENT_FIELD_NAME_INPUT,
         */
    public static final Set<String> ALLOWED_CONTENT_FIELD_NAMES = Sets.newHashSet(
            m -> toType(m).contexts
                        ContextMappings contextMappings = fieldType().getContextMappings();
            Defaults.DEFAULT_MAX_INPUT_LENGTH  
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
 *  @opensearch.internal  
        }  
 *  This field type constructs completion queries that are run
        return (CompletionFieldType) super.fieldType();  
    /**  
        return true;
        }
    }  
import java.util.Set;
                }
import org.opensearch.search.suggest.completion.context.ContextMapping;
        } else {
    public boolean parsesArrayValue() {
            FIELD_TYPE.setStoreTermVectors(false);
}  
        this.preserveSeparators = builder.preserveSeparators.getValue();
            FIELD_TYPE.setTokenized(true);
            return;
 * GitHub history for details.
                getTextSearchInfo().getSearchAnalyzer().analyzer(),
            for (String input : inputs) {
                name,
            b.startArray(n);
 *  <li>"preserve_separators" : true, (default)</li>
        }  
         * for this field type
    public void doValidate(MappingLookup mappers) {
            }
 * The OpenSearch Contributors require contributions made to  
        createFieldNamesField(context);
         */  
        // index
        private final Parameter<Boolean> preservePosInc = Parameter.boolParam(  
    private final NamedAnalyzer defaultAnalyzer;
                    assert input.length() >= len + 1 && Character.isLowSurrogate(input.charAt(len));
                        throw new IllegalArgumentException(
    }
import java.util.Arrays;  
        public Builder(String name, NamedAnalyzer defaultAnalyzer, Version indexVersionCreated) {  
import org.apache.lucene.search.suggest.document.Completion104PostingsFormat;
    }  
                    AnalyzerScope.INDEX,
 * <ul>
        if (token == Token.VALUE_STRING) {  
        CopyTo copyTo,
         */  
                this
            boolean unicodeAware
public class CompletionFieldMapper extends ParametrizedFieldMapper {
            return new CompletionFieldMapper(  
 *  for query-time filtering and boosting (see {@link ContextMappings}
        public CompletionQuery regexpQuery(Object value, int flags, int maxDeterminizedStates) {
        ).alwaysSerialize();
        String simpleName,  
    public static final String CONTENT_TYPE = "completion";  
import org.opensearch.index.query.QueryShardContext;
        CompletionInputMetadata(String input, Map<String, Set<String>> contexts, int weight) {
        ).setSerializer((b, n, c) -> {  
            this.indexVersionCreated = indexVersionCreated;  
 * Licensed to Elasticsearch under one or more contributor  
                unicodeAware,
        return inputMap;  
    }
                if (Character.isHighSurrogate(input.charAt(len - 1))) {  
            if (c == null) {
 * SPDX-License-Identifier: Apache-2.0
            boolean transpositions,  
import org.apache.lucene.search.suggest.document.SuggestField;
                    len += 1;
                        } else {
        ).alwaysSerialize();
                contextMapping.validateReferences(indexVersionCreated, s -> mappers.fieldTypes().get(s));
                        } else {  
                copyTo.build(),
     *
                    if (Fields.CONTENT_FIELD_NAME_INPUT.equals(currentFieldName)) {  
        /**  
        } else if (token == Token.VALUE_NULL) { // ignore null values
            CompletionFieldType ft = new CompletionFieldType(buildFullName(context), completionAnalyzer, meta.getValue());
                multiFieldsBuilder.build(this, context),
import org.opensearch.search.suggest.completion.CompletionSuggester;
                ft,
                                    );
            return indexAnalyzer;  
                        }  
        }
            ft.setPreservePositionIncrements(preservePosInc.getValue());  
        for (CompletionInputMetadata metadata : inputMap.values()) {  
    );  
                                    contextMapping = contextMappings.get(fieldName);
                    "excessive_completion_contexts",
            int maxExpansions,
                                    assert !contextsMap.containsKey(fieldName);
    static class CompletionInputMetadata {
        }
 *  <li>"contexts" : CONTEXTS</li>
import org.opensearch.Version;
            if (fieldType().hasContextMappings()) {
        }
     * @opensearch.internal  
package org.opensearch.index.mapper;
            parse(context, token, parser, inputMap);
        public static final int DEFAULT_MAX_INPUT_LENGTH = 50;
                            throw new IllegalArgumentException("contexts must be an object or an array , but was [" + currentToken + "]");  
            super(name, true, false, false, new TextSearchInfo(Defaults.FIELD_TYPE, null, searchAnalyzer, searchAnalyzer), meta);
        // no-op
     *
 * <p>  
        public static final boolean DEFAULT_PRESERVE_SEPARATORS = true;  
            false,
                        final Number weightValue;
        (n, c) -> new Builder(n, c.getIndexAnalyzers().get("simple"), c.indexVersionCreated())
            throw new ParsingException(
    /**  
            this.defaultAnalyzer = defaultAnalyzer;
            m -> toType(m).preservePosInc,  
            "preserve_position_increments",
                defaultAnalyzer,  
            b.endArray();  
        Fields.CONTENT_FIELD_NAME_WEIGHT,  
    private static CompletionFieldMapper toType(FieldMapper in) {
            c.toXContent(b, ToXContent.EMPTY_PARAMS);
        public final Map<String, Set<String>> contexts;
            }
    }
                        }
        private final Parameter<NamedAnalyzer> analyzer;
    static final int COMPLETION_CONTEXTS_LIMIT = 10;
        public boolean hasContextMappings() {
                                } else {
    @Override  
        }  
        super(simpleName, mappedFieldType, multiFields, copyTo);
     * <p>
                        if (weightValue.longValue() < 0 || weightValue.longValue() > Integer.MAX_VALUE) {
                    }
            final NamedAnalyzer indexAnalyzer = super.indexAnalyzer();  
                                    inputs.add(parser.text());  
     */
        static {
                int len = Math.min(maxInputLength, input.length());
            }
 * license agreements. See the NOTICE file distributed with
    public static class Builder extends ParametrizedFieldMapper.Builder {
        /**
    @Override
        Builder builder  
            String value,
            false,
            if (format != null) {
 *  <li>"min_input_length": 50 (default)</li>
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                        }
            }
            false,
            this.contextMappings = contextMappings;
    );
                return;
                new CompletionAnalyzer(this.searchAnalyzer.getValue(), preserveSeparators.getValue(), preservePosInc.getValue())
                    }
 * Type properties:<br>
    /**
            this.preserveSep = preserveSep;
    private final int maxInputLength;
        }
         * Completion prefix query
                postingsFormat = new Completion104PostingsFormat();
                                if (currentToken == XContentParser.Token.FIELD_NAME) {
         */
            "contexts",
 * </ul>  
            checkCompletionContextsLimit(context);  
        private final NamedAnalyzer defaultAnalyzer;
        MappedFieldType mappedFieldType,
                new Term(name(), indexedValueForSearch(value))
            this.weight = weight;
import java.util.HashMap;
        }
            CompletionInputMetadata inputAndMeta = (CompletionInputMetadata) context.externalValue();  
            if (input.length() > maxInputLength) {
        public String typeName() {
                            ContextMapping contextMapping = null;
                        + context.indexSettings().get(IndexMetadata.SETTING_INDEX_PROVIDED_NAME)
                        + "["
        this.contexts = builder.contexts.getValue();  
            this.contexts = contexts;  
         * Completion prefix fuzzy query
                        } else if (token == Token.VALUE_NUMBER) {  
        }
    @Override
        /**
        private final Parameter<ContextMappings> contexts = new Parameter<>(  
            NamedAnalyzer completionAnalyzer = new NamedAnalyzer(
            String fieldName = context.externalValue().toString();  
                            String fieldName = null;  
 *  <li>"preserve_position_increments" : true (default)</li>  
         */
            }
                            throw new IllegalArgumentException("weight must be a number or string, but was [" + token.name() + "]");
            return postingsFormat;
 * Mapper for completion field. The field values are indexed as a weighted FST for
     */
        public CompletionQuery fuzzyQuery(  
                    }
        // parse  
            m -> toType(m).preserveSeparators,  
                protected List<?> parseSourceValue(Object value) {
                        }
            m -> toType(m).maxInputLength,
        }
                fuzziness.asDistance(),
                                if (token == Token.VALUE_STRING) {
     * Parses and indexes inputs
    protected String contentType() {  
        public static final boolean DEFAULT_POSITION_INCREMENTS = true;
            return new RegexCompletionQuery(new Term(name(), indexedValueForSearch(value)), flags, maxDeterminizedStates);  
 * this file be licensed under the Apache-2.0 license or a
            String input = completionInput.getKey();
                            try {
        public static final String CONTENT_FIELD_NAME_INPUT = "input";  
            return input;  
            return new ArraySourceValueFetcher(name(), context) {  
                        XContentParser.Token currentToken = parser.currentToken();  
                    if (!ALLOWED_CONTENT_FIELD_NAMES.contains(currentFieldName)) {  
    }
        @Override
                transpositions,
                input = input.substring(0, len);
                    new CompletionAnalyzer(indexAnalyzer, preserveSep, preservePositionIncrements)
                deprecationLogger.deprecate(
        if (isExternalValueOfClass(context, CompletionInputMetadata.class)) {
        } else if (token == Token.START_OBJECT) {
        }
 * under the License.  
    protected void parseCreateField(ParseContext context) throws IOException {
        }
                            "unknown field name [" + currentFieldName + "], must be one of " + ALLOWED_CONTENT_FIELD_NAMES
            );
                    "You have defined more than ["  
                    indexAnalyzer.name(),  
                );
     * @opensearch.internal  
                }
        public CompletionFieldType(String name, NamedAnalyzer searchAnalyzer, Map<String, String> meta) {  
 *  This field can also be extended to add search criteria to suggestions  
