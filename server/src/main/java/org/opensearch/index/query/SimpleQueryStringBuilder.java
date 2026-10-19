     */  
        return this.defaultOperator;
        boolean autoGenerateSynonymsPhraseQuery = true;
    protected boolean doEquals(SimpleQueryStringBuilder other) {
    public SimpleQueryStringBuilder(String queryText) {  
        out.writeOptionalString(minimumShouldMatch);
        analyzer = in.readOptionalString();
 * {@code query} - query text to be converted into other queries  
        }
            Float weight = in.readFloat();
            builder.field(LENIENT_FIELD.getPreferredName(), settings.lenient());
        }
        return this;
    /** Default operator to use for linking boolean clauses. Defaults to OR according to docs. */
 * <ul>
                    parser.getTokenLocation(),
import org.opensearch.index.search.SimpleQueryStringQueryParser;
                value |= flag.value;
        defaultOperator.writeTo(out);
    private String minimumShouldMatch;
import org.apache.lucene.search.Query;  
 * Required:
                    queryName = parser.text();
    /**  
import org.opensearch.core.common.util.CollectionUtils;
 * not use this file except in compliance with the License.
            checkNegativeBoost(weight);  
    /**
    }
 * This query supports these options:  
    }  
     */
            }
        return this;
                    // ignore, deprecated setting
        }
        Map<String, Float> fieldsAndWeights = null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (lenient != null) {  
 * {@code default_operator} - default operator for boolean queries, defaults
        builder.field(DEFAULT_OPERATOR_FIELD.getPreferredName(), defaultOperator.name().toLowerCase(Locale.ROOT));
     * operator is specified.
        checkNegativeBoost(boost);
    }
    private final String queryText;
                context,  
    public SimpleQueryStringBuilder quoteFieldSuffix(String suffix) {
    private Operator defaultOperator = DEFAULT_OPERATOR;  
                } else if (LOWERCASE_EXPANDED_TERMS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        Boolean lenient = null;
        out.writeBoolean(settings.analyzeWildcard());
        }
        qb.boost(boost).analyzer(analyzerName).queryName(queryName).minimumShouldMatch(minimumShouldMatch);
    }
        return this;  
    /** Returns the fields including their respective boosts to run the query against. */
            if (luceneAnalyzer == null) {  
    int flags() {  
    /** Further search settings needed by the OpenSearch specific query string parser only. */
    /** Default for using lenient query parsing.*/
        return this;
    public Operator defaultOperator() {
    /**
    /** Default for wildcard analysis.*/
        builder.endObject();
    /**  
/**
    public SimpleQueryStringBuilder analyzeWildcard(boolean analyzeWildcard) {
    }
    }  
        }  
    /** Add several fields to run the query against with a specific boost. */
        return this;
 * ownership. Elasticsearch licenses this file to you under  
    }
     * Defaults to {@code true}.  
                } else if (LENIENT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        Objects.requireNonNull(fields, "fields cannot be null");  
 * Modifications Copyright OpenSearch Contributors. See
        return this.flags;
    /**  
 * Optional:
    public boolean lenient() {  
    public SimpleQueryStringBuilder minimumShouldMatch(String minimumShouldMatch) {
    private static final ParseField FIELDS_FIELD = new ParseField("fields");
    public Map<String, Float> fields() {  
    /** Returns whether query parsing should be lenient. */
            builder.endArray();  
                builder.value(entry.getKey() + "^" + entry.getValue());
 * this work for additional information regarding copyright
    }
    protected int doHashCode() {
 * Licensed to Elasticsearch under one or more contributor  
        out.writeInt(flags);
     */
        }
                    throw new ParsingException(
                    quoteFieldSuffix = parser.textOrNull();  
                } else if (DEFAULT_OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (FLAGS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    /** Add a field to run the query against. */  
        defaultOperator = Operator.readFromStream(in);  
    @Override  
        Operator defaultOperator = null;
    }  
 * </ul>
    private static final ParseField FUZZY_PREFIX_LENGTH_FIELD = new ParseField("fuzzy_prefix_length");
                    }
    /**
import org.opensearch.core.common.Strings;
    }
 * the following:
import java.util.HashMap;
/*  
import java.io.IOException;
 * <p>  
        return settings.fuzzyTranspositions();
    public static final boolean DEFAULT_ANALYZE_WILDCARD = false;
 * <p>
        int size = in.readInt();
 * <li>'{@code ~}N' at the end of terms specifies fuzzy query: {@code term~1}  
    }
    }
    }
        this.settings.autoGenerateSynonymsPhraseQuery(value);  
            && (flags == other.flags);
        if (queryBody == null) {
     * always sorted in same order for generated Lucene query for easier
            for (SimpleQueryStringFlag flag : flags) {  
            resolvedFieldsAndWeights = QueryParserHelper.resolveMappingFields(
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)  
        this.fieldsAndWeights.putAll(fields);
        }
        return NAME;
 * specific language governing permissions and limitations
        out.writeVInt(settings.fuzzyMaxExpansions());  
                        "[" + SimpleQueryStringBuilder.NAME + "] unsupported field [" + parser.currentName() + "]"
        return this;  
        boolean fuzzyTranspositions = SimpleQueryStringBuilder.DEFAULT_FUZZY_TRANSPOSITIONS;
                    fuzzyMaxExpansions = parser.intValue();
                } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        for (Map.Entry<String, Float> entry : fieldsAndWeights.entrySet()) {
                } else {  
        builder.field(QUERY_FIELD.getPreferredName(), queryText);
    }
    private static final ParseField GENERATE_SYNONYMS_PHRASE_QUERY = new ParseField("auto_generate_synonyms_phrase_query");
        qb.analyzeWildcard(analyzeWildcard).boost(boost).quoteFieldSuffix(quoteFieldSuffix);  
import java.util.Map;
        return this;  
        queryText = in.readString();  
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
 * under the License.  
     * that be a Boolean query.
        return this.settings.analyzeWildcard();  
 * <li>'{@code -}' negates a single token: {@code -token0}
            int value = 0;
                    }
            resolvedFieldsAndWeights = QueryParserHelper.resolveMappingFields(context, fieldsAndWeights);
        if (Strings.isEmpty(field)) {
        qb.fuzzyMaxExpansions(fuzzyMaxExpansions);  
        sqp.setDefaultOperator(defaultOperator.toBooleanClauseOccur());
 * license agreements. See the NOTICE file distributed with
        settings.autoGenerateSynonymsPhraseQuery(in.readBoolean());  
        }
    private Settings settings = new Settings();  
            fields.put(field, weight);
        this.settings.lenient(lenient);  
            Analyzer luceneAnalyzer = context.getIndexAnalyzers().get(analyzer);
import java.util.Objects;
            && Objects.equals(defaultOperator, other.defaultOperator)
    public static final int DEFAULT_FUZZY_MAX_EXPANSIONS = FuzzyQuery.defaultMaxExpansions;
                    analyzeWildcard = parser.booleanValue();  
        return this.queryText;  
    /** Default for search flags to use. */
    /**
        fieldsAndWeights.putAll(fields);  
     * distance formula which supports transpositions. Setting transposition to false will
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), settings.fuzzyTranspositions());
    public String getWriteableName() {  
 * won't throw exceptions for any weird string syntax. It supports  
        if (Strings.isEmpty(field)) {
                currentFieldName = parser.currentName();
import org.opensearch.core.common.io.stream.StreamInput;
     * Sets whether transpositions are supported in fuzzy queries.<p>
    }
    private static final ParseField ANALYZE_WILDCARD_FIELD = new ParseField("analyze_wildcard");  
public class SimpleQueryStringBuilder extends AbstractQueryBuilder<SimpleQueryStringBuilder> {  
    }
    /** Name for (de-)serialization. */
        return qb;
                throw new QueryShardException(context, "[" + SimpleQueryStringBuilder.NAME + "] analyzer [" + analyzer + "] not found");
 */  
    /** Any search flags to be used, ALL by default. */  
                } else if (FUZZY_PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (fieldsAndWeights.size() > 0) {
    public static SimpleQueryStringBuilder fromXContent(XContentParser parser) throws IOException {
    /** Specify an analyzer to use for the query. */
 * SimpleQuery is a query parser that acts similar to a query_string query, but
    }  
        }
    }
    public int fuzzyPrefixLength() {
        if (queryText == null) {
    }  
        String quoteFieldSuffix = null;
        out.writeBoolean(lenientSet);  
    }
        boolean isAllField;
                } else if (QUOTE_FIELD_SUFFIX_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.analyzer = analyzer;  
        if (minimumShouldMatch != null) {
    protected void doWriteTo(StreamOutput out) throws IOException {
        return this;
        // Query text is required
    private static final ParseField QUERY_FIELD = new ParseField("query");  
                QueryParserHelper.parseFieldsAndWeights(defaultFields)
    }
        return Objects.equals(fieldsAndWeights, other.fieldsAndWeights)
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }
        } else {
    public static final int DEFAULT_FUZZY_PREFIX_LENGTH = FuzzyQuery.defaultPrefixLength;
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder(queryBody);  
 *  
    @Override
                } else if (ANALYZE_WILDCARD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return this.analyzer;  
        String currentFieldName = null;
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.opensearch.core.common.io.stream.StreamOutput;  
        return this;
    private int flags = DEFAULT_FLAGS;
            );
    }  
                } else if (LOCALE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /** Query text to parse. */  
    public boolean autoGenerateSynonymsPhraseQuery() {
                    "[" + SimpleQueryStringBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
        String analyzerName = null;  
            builder.startArray(FIELDS_FIELD.getPreferredName());
            }
    /** Default for using transpositions in fuzzy queries.*/
            isAllField = QueryParserHelper.hasAllFieldsWildcard(fieldsAndWeights.keySet());
            && Objects.equals(settings, other.settings)
                    if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) {
import org.opensearch.core.xcontent.XContentParser;  
                    defaultOperator = Operator.fromString(parser.text());
     */  
            throw new ParsingException(parser.getTokenLocation(), "[" + SimpleQueryStringBuilder.NAME + "] query text missing");  
                        "[" + SimpleQueryStringBuilder.NAME + "] query does not support [" + currentFieldName + "]"  
 * which kind of query they should be converted into, defaults to "standard"
 * to OR  
        }
     */  
        int flags = SimpleQueryStringFlag.ALL.value();
    public static final String NAME = "simple_query_string";  
    public String value() {
        settings.analyzeWildcard(in.readBoolean());  
        super(in);
        if (fieldsAndWeights != null) {
    /** Whether or not the lenient flag has been set or not */
        builder.field(FUZZY_MAX_EXPANSIONS_FIELD.getPreferredName(), settings.fuzzyMaxExpansions());
                            flags = SimpleQueryStringFlag.ALL.value();
        Query query = sqp.parse(queryText);  
        flags = in.readInt();
    @Override
 * <p>
 * See: {@link SimpleQueryStringQueryParser} for more information.
 */
    public boolean fuzzyTranspositions() {  
        int fuzzyMaxExpansions = SimpleQueryStringBuilder.DEFAULT_FUZZY_MAX_EXPANSIONS;
            String field = in.readString();
     * Read from a stream.
            builder.field(ANALYZER_FIELD.getPreferredName(), analyzer);
        qb.fuzzyPrefixLength(fuzzyPrefixLenght);
                    fuzzyTranspositions = parser.booleanValue();
    /**  
                    fieldsAndWeights = QueryParserHelper.parseFieldsAndWeights(fields);
            }
        }
     * that be a Boolean query.
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);  
    /** Returns the text to parse the query from. */
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    List<String> fields = new ArrayList<>();
        }
    private static final ParseField ANALYZER_FIELD = new ParseField("analyzer");
    }  
                        // ALL, NONE, AND, OR, PREFIX, PHRASE, PRECEDENCE, ESCAPE, WHITESPACE, FUZZY, NEAR, SLOP  
        XContentParser.Token token;
    protected Query doToQuery(QueryShardContext context) throws IOException {
        Settings newSettings = new Settings(settings);  
    /** Returns whether wildcards should by analyzed. */
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            throw new IllegalArgumentException("query text missing");
            && Objects.equals(analyzer, other.analyzer)  
        return this;
     */
        final Map<String, Float> resolvedFieldsAndWeights;
    public SimpleQueryStringBuilder lenient(boolean lenient) {
            out.writeString(entry.getKey());
        out.writeVInt(settings.fuzzyPrefixLength());
    public static final Operator DEFAULT_OPERATOR = Operator.OR;
            builder.field(QUOTE_FIELD_SUFFIX_FIELD.getPreferredName(), settings.quoteFieldSuffix());
 */  
                throw new ParsingException(  
        if (settings.quoteFieldSuffix() != null) {
                    // Ignore deprecated option
    @Override
    private static final ParseField FUZZY_MAX_EXPANSIONS_FIELD = new ParseField("fuzzy_max_expansions");  
                }
 * <li>'{@code |}' specifies {@code OR} operation: {@code token1|token2}
        if (analyzer != null) {  
     */  
    }  
        this.fieldsAndWeights.put(field, AbstractQueryBuilder.DEFAULT_BOOST);
                    minimumShouldMatch = parser.textOrNull();
    public static final boolean DEFAULT_FUZZY_TRANSPOSITIONS = FuzzyQuery.defaultTranspositions;  
    /** Default for default operator to use for linking boolean clauses.*/  
import java.util.Locale;  
import org.opensearch.core.common.ParsingException;  
        }  
        out.writeBoolean(settings.autoGenerateSynonymsPhraseQuery());
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        printBoostAndQueryName(builder);  
        this.defaultOperator = (defaultOperator != null) ? defaultOperator : DEFAULT_OPERATOR;
 * You may obtain a copy of the License at  
        this.lenientSet = in.readBoolean();
        return this.settings.lenient();
 * this file be licensed under the Apache-2.0 license or a
            if (token == XContentParser.Token.FIELD_NAME) {  
        this.settings.fuzzyMaxExpansions(fuzzyMaxExpansions);
    private static final ParseField ALL_FIELDS_FIELD = new ParseField("all_fields").withAllDeprecated("Set [fields] to `*` instead");  
        Map<String, Float> fields = new HashMap<>();
        this.settings.analyzeWildcard(analyzeWildcard);  
     * Return the suffix to append to field names for phrase matching.
     * Specify the default operator for the query. Defaults to "OR" if no
        settings.quoteFieldSuffix(suffix);
import java.util.ArrayList;  
            isAllField = QueryParserHelper.hasAllFieldsWildcard(defaultFields);  
 * {@code fields} - fields to search, defaults to _all if not set, allows
        out.writeOptionalString(analyzer);  
        if (analyzer == null) {
            this.flags = DEFAULT_FLAGS;
        settings.quoteFieldSuffix(in.readOptionalString());
    /**
                    fuzzyPrefixLenght = parser.intValue();  
            } else if (token == XContentParser.Token.START_ARRAY) {
        return Objects.hash(fieldsAndWeights, analyzer, defaultOperator, queryText, minimumShouldMatch, settings, flags);  
                }
     * none are specified.
    private static final ParseField LOWERCASE_EXPANDED_TERMS_FIELD = new ParseField("lowercase_expanded_terms").withAllDeprecated(
    /**
    public SimpleQueryStringBuilder fields(Map<String, Float> fields) {
        String queryName = null;
                } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            throw new IllegalArgumentException("supplied field is null or empty");  
        this.flags = flags;
    }
 * <p>
            out.writeFloat(entry.getValue());  
import org.opensearch.core.ParseField;
}
                } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        return settings.quoteFieldSuffix();
        boolean analyzeWildcard = SimpleQueryStringBuilder.DEFAULT_ANALYZE_WILDCARD;  
    }
    private static final ParseField LENIENT_FIELD = new ParseField("lenient");
        return this;
    public SimpleQueryStringBuilder flags(SimpleQueryStringFlag... flags) {  
                    autoGenerateSynonymsPhraseQuery = parser.booleanValue();
 * software distributed under the License is distributed on an
 * <li>'{@code ~}N' at the end of phrases specifies near/slop query: {@code "term1 term2"~5}
import java.util.List;
        }  
    public SimpleQueryStringBuilder field(String field, float boost) {
        builder.field(FLAGS_FIELD.getPreferredName(), flags);
import org.opensearch.core.xcontent.XContentBuilder;
            }
        settings.fuzzyPrefixLength(in.readVInt());
        this.minimumShouldMatch = minimumShouldMatch;
     * testing.  
            throw new IllegalArgumentException("supplied field is null or empty");  
            this.flags = value;  
        builder.startObject(NAME);  
        out.writeInt(fieldsAndWeights.size());  
                if (FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        if (isAllField) {  
                        flags = SimpleQueryStringFlag.resolveFlags(parser.text());
    /** Default for prefix length in fuzzy queries.*/
        this.fieldsAndWeights.put(field, boost);  
 * SPDX-License-Identifier: Apache-2.0
                        }  
    public SimpleQueryStringBuilder field(String field) {
    public int fuzzyMaxExpansions() {
                    boost = parser.floatValue();
 * compatible open source license.
     */
            sqp = new SimpleQueryStringQueryParser(resolvedFieldsAndWeights, flags, newSettings, context);  
        out.writeBoolean(settings.lenient());
            } else {
        }
    /** Returns the default operator for the query. */  
            } else if (token.isValue()) {  
                    lenient = parser.booleanValue();
            qb.lenient(lenient);
 * <li>'{@code "}' creates phrases of terms: {@code "term1 term2 ..."}  
        builder.field(FUZZY_PREFIX_LENGTH_FIELD.getPreferredName(), settings.fuzzyPrefixLength());  
    private Map<String, Float> fieldsAndWeights = new HashMap<>();
        settings.fuzzyTranspositions(in.readBoolean());  
    }
     * currently _ALL. Uses a TreeMap to hold the fields so boolean clauses are
                        parser.getTokenLocation(),
    }  
                } else {
        return this.fieldsAndWeights;
        } else {  
            sqp = new SimpleQueryStringQueryParser(luceneAnalyzer, resolvedFieldsAndWeights, flags, newSettings, context);  
                    );  
import org.apache.lucene.search.FuzzyQuery;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
                    );
    /** If specified, analyzer to use to parse the query text, defaults to registered default in toQuery. */  
    private static final ParseField DEFAULT_OPERATOR_FIELD = new ParseField("default_operator");
    /** Add a field to run the query against with a specific boost. */  
        }  
        final SimpleQueryStringQueryParser sqp;
        return this;
 * <li>'{@code *}' at the end of terms specifies prefix query: {@code term*}
     * Returns the minimumShouldMatch to apply to the resulting query should
     * Fields to query against. If left empty will query default field,  
        return settings.autoGenerateSynonymsPhraseQuery();  
    }
    }
        qb.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
 * Unless required by applicable law or agreed to in writing,
        return settings.fuzzyMaxExpansions();  
/*
    private String analyzer;
    private static final ParseField FUZZY_TRANSPOSITIONS_FIELD = new ParseField("fuzzy_transpositions");
    /** Specifies whether wildcards should be analyzed. Defaults to false. */
                } else if (FUZZY_MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            && Objects.equals(queryText, other.queryText)
        }  
        for (int i = 0; i < size; i++) {  
 * <li>'{@code (}' and '{@code )}' specifies precedence: {@code token1 + (token2 | token3)}
     * Whether phrase queries should be automatically generated for multi terms synonyms.
    }
    public SimpleQueryStringBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
    }
 * <li>'{@code +}' specifies {@code AND} operation: {@code token1+token2}  
        settings.fuzzyMaxExpansions(in.readVInt());
import org.opensearch.common.lucene.search.Queries;
    public static final int DEFAULT_FLAGS = SimpleQueryStringFlag.ALL.value;  
                        flags = parser.intValue();  
                        fields.add(parser.text());  
     */
                } else if (GENERATE_SYNONYMS_PHRASE_QUERY.match(currentFieldName, parser.getDeprecationHandler())) {  
                    throw new ParsingException(  
    public String analyzer() {
        this.queryText = queryText;
    }
 * The OpenSearch Contributors require contributions made to  
 *
import org.apache.lucene.analysis.Analyzer;
        return minimumShouldMatch;
            qb.fields(fieldsAndWeights);
 * {@code analyzer} - anaylzer to be used for analyzing tokens to determine  
    );
import org.opensearch.index.search.SimpleQueryStringQueryParser.Settings;  
        return this;  
                    analyzerName = parser.text();  
        return this;
     * Set the suffix to append to field names for phrase matching.
        "Decision is now made by the analyzer"  
        qb.fuzzyTranspositions(fuzzyTranspositions);
    /** Returns the analyzer to use for the query. */
     * Specifies the minimumShouldMatch to apply to the resulting query should
    }
        return this;
        } else {
            List<String> defaultFields = context.defaultFields();
        if (fieldsAndWeights.isEmpty() == false) {  
                        parser.getTokenLocation(),
                    } else {
        if (CollectionUtils.isEmpty(flags) == false) {
    /** If result is a boolean query, minimumShouldMatch parameter to apply. Ignored otherwise. */
    public SimpleQueryStringBuilder(StreamInput in) throws IOException {
 *
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        this.settings.fuzzyTranspositions(fuzzyTranspositions);  
    public SimpleQueryStringBuilder defaultOperator(Operator defaultOperator) {
            checkNegativeBoost(fieldBoost);
 * GitHub history for details.
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein  
    /** For testing and serialisation only. */
    SimpleQueryStringBuilder flags(int flags) {  
 *  
    public SimpleQueryStringBuilder analyzer(String analyzer) {
    }  
     * Specify the enabled features of the SimpleQueryString. Defaults to ALL if  
 */
        settings.lenient(in.readBoolean());
        minimumShouldMatch = in.readOptionalString();
    private boolean lenientSet = false;  
        return Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);
    /** Construct a new simple query with this query string. */
     */  
package org.opensearch.index.query;
                );  
    public SimpleQueryStringBuilder fuzzyMaxExpansions(int fuzzyMaxExpansions) {  
                        if (flags < 0) {
        return settings.fuzzyPrefixLength();  
    /** Default number of terms fuzzy queries will expand to.*/  
        String minimumShouldMatch = null;  
        this.lenientSet = true;
    public String minimumShouldMatch() {
    public SimpleQueryStringBuilder fuzzyPrefixLength(int fuzzyPrefixLength) {  
    public static final boolean DEFAULT_LENIENT = false;  
    @Override
    public SimpleQueryStringBuilder autoGenerateSynonymsPhraseQuery(boolean value) {
        if (lenientSet) {  
                } else if (ALL_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            newSettings.lenient(lenientSet ? settings.lenient() : true);
        out.writeBoolean(settings.fuzzyTranspositions());
/*  
    private static final ParseField FLAGS_FIELD = new ParseField("flags");  
    @Override  
        for (float fieldBoost : fields.values()) {
            for (Map.Entry<String, Float> entry : fieldsAndWeights.entrySet()) {  
        builder.field(GENERATE_SYNONYMS_PHRASE_QUERY.getPreferredName(), settings.autoGenerateSynonymsPhraseQuery());
     * switch to classic Levenshtein distance.<br>
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public boolean analyzeWildcard() {
    private static final ParseField LOCALE_FIELD = new ParseField("locale").withAllDeprecated("Decision is now made by the analyzer");
    /** Specifies whether query parsing should be lenient. Defaults to false. */
        qb.flags(flags).defaultOperator(defaultOperator);
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.settings.fuzzyPrefixLength(fuzzyPrefixLength);
 * boosting a field with ^n
     * If not set, Damerau-Levenshtein distance metric will be used.  
                    queryBody = parser.text();
        builder.field(ANALYZE_WILDCARD_FIELD.getPreferredName(), settings.analyzeWildcard());  
        int fuzzyPrefixLenght = SimpleQueryStringBuilder.DEFAULT_FUZZY_PREFIX_LENGTH;  
                    // ignore, deprecated setting  
    /** For testing only: Return the flags set for this query. */
                        // Possible options are:
    public String quoteFieldSuffix() {  
    }
        out.writeString(queryText);
    private static final ParseField QUOTE_FIELD_SUFFIX_FIELD = new ParseField("quote_field_suffix");
        out.writeOptionalString(settings.quoteFieldSuffix());  
import org.opensearch.index.search.QueryParserHelper;
        String queryBody = null;  
