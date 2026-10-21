    protected int doHashCode() {
        out.writeVInt(settings.fuzzyPrefixLength());
        out.writeBoolean(settings.lenient());
    public static final boolean DEFAULT_ANALYZE_WILDCARD = false;
                } else if (QUOTE_FIELD_SUFFIX_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
    }
    }
    public int fuzzyPrefixLength() {
        settings.quoteFieldSuffix(suffix);
                }
    /** Returns the text to parse the query from. */
    /** For testing only: Return the flags set for this query. */
        if (queryText == null) {
     * Specify the enabled features of the SimpleQueryString. Defaults to ALL if
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * {@code query} - query text to be converted into other queries
                        // ALL, NONE, AND, OR, PREFIX, PHRASE, PRECEDENCE, ESCAPE, WHITESPACE, FUZZY, NEAR, SLOP
        return this;
 * SimpleQuery is a query parser that acts similar to a query_string query, but
    }
                    if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) {
                QueryParserHelper.parseFieldsAndWeights(defaultFields)
    /**
    @Override
                    fuzzyMaxExpansions = parser.intValue();
        super(in);
                } else if (ANALYZE_WILDCARD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        for (Map.Entry<String, Float> entry : fieldsAndWeights.entrySet()) {
    /** Add several fields to run the query against with a specific boost. */
    private boolean lenientSet = false;
     * currently _ALL. Uses a TreeMap to hold the fields so boolean clauses are
    }
                    throw new ParsingException(
    }
        return this.settings.analyzeWildcard();
    private static final ParseField GENERATE_SYNONYMS_PHRASE_QUERY = new ParseField("auto_generate_synonyms_phrase_query");
     * operator is specified.
    private static final ParseField FIELDS_FIELD = new ParseField("fields");
     * switch to classic Levenshtein distance.<br>
        if (fieldsAndWeights != null) {
    }
                } else {
                    "[" + SimpleQueryStringBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
                } else if (LOCALE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * specific language governing permissions and limitations
 * </ul>
    );
        builder.field(FLAGS_FIELD.getPreferredName(), flags);
        this.settings.autoGenerateSynonymsPhraseQuery(value);
        }
        }
     * Fields to query against. If left empty will query default field,
        Map<String, Float> fields = new HashMap<>();
                } else {
    public static final int DEFAULT_FUZZY_PREFIX_LENGTH = FuzzyQuery.defaultPrefixLength;
        qb.fuzzyMaxExpansions(fuzzyMaxExpansions);
    }
        return this.fieldsAndWeights;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    /** Specifies whether wildcards should be analyzed. Defaults to false. */
import java.util.Locale;
        minimumShouldMatch = in.readOptionalString();
/*
        String analyzerName = null;
    }
        return this;
    /** Whether or not the lenient flag has been set or not */
    }
        return this.defaultOperator;
        boolean isAllField;
    private static final ParseField QUERY_FIELD = new ParseField("query");
    }
    /** Returns whether wildcards should by analyzed. */
                        flags = SimpleQueryStringFlag.resolveFlags(parser.text());
        if (settings.quoteFieldSuffix() != null) {
                    fuzzyTranspositions = parser.booleanValue();
            List<String> defaultFields = context.defaultFields();
    public static final String NAME = "simple_query_string";
                    parser.getTokenLocation(),
            && Objects.equals(settings, other.settings)
        String currentFieldName = null;
        qb.flags(flags).defaultOperator(defaultOperator);
        String minimumShouldMatch = null;
public class SimpleQueryStringBuilder extends AbstractQueryBuilder<SimpleQueryStringBuilder> {
 * <li>'{@code *}' at the end of terms specifies prefix query: {@code term*}
        return this.flags;
                } else if (GENERATE_SYNONYMS_PHRASE_QUERY.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.List;
 * You may obtain a copy of the License at
     * Read from a stream.
            throw new ParsingException(parser.getTokenLocation(), "[" + SimpleQueryStringBuilder.NAME + "] query text missing");
        }
     * If not set, Damerau-Levenshtein distance metric will be used.
import org.opensearch.index.search.QueryParserHelper;
            builder.startArray(FIELDS_FIELD.getPreferredName());
 * See: {@link SimpleQueryStringQueryParser} for more information.
 * {@code analyzer} - anaylzer to be used for analyzing tokens to determine
                    defaultOperator = Operator.fromString(parser.text());
                    analyzerName = parser.text();
        boolean analyzeWildcard = SimpleQueryStringBuilder.DEFAULT_ANALYZE_WILDCARD;
            sqp = new SimpleQueryStringQueryParser(resolvedFieldsAndWeights, flags, newSettings, context);
        if (analyzer != null) {
            && Objects.equals(queryText, other.queryText)
        defaultOperator = Operator.readFromStream(in);
import org.opensearch.core.common.ParsingException;
 * the following:
    /**
        return this;
    /** Add a field to run the query against with a specific boost. */
        if (minimumShouldMatch != null) {
                        "[" + SimpleQueryStringBuilder.NAME + "] unsupported field [" + parser.currentName() + "]"
                    // ignore, deprecated setting
            newSettings.lenient(lenientSet ? settings.lenient() : true);
    private static final ParseField FUZZY_MAX_EXPANSIONS_FIELD = new ParseField("fuzzy_max_expansions");
                builder.value(entry.getKey() + "^" + entry.getValue());
 * This query supports these options:
import org.apache.lucene.search.Query;
    /** Query text to parse. */
 * {@code default_operator} - default operator for boolean queries, defaults
    public SimpleQueryStringBuilder minimumShouldMatch(String minimumShouldMatch) {
        return this.analyzer;
    /**
                    minimumShouldMatch = parser.textOrNull();
                } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        if (flags < 0) {
 */
    public SimpleQueryStringBuilder(StreamInput in) throws IOException {
    public String quoteFieldSuffix() {
                    );
        if (CollectionUtils.isEmpty(flags) == false) {
        out.writeInt(flags);
    }
                        "[" + SimpleQueryStringBuilder.NAME + "] query does not support [" + currentFieldName + "]"
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.FuzzyQuery;
            qb.fields(fieldsAndWeights);
            isAllField = QueryParserHelper.hasAllFieldsWildcard(defaultFields);
                    quoteFieldSuffix = parser.textOrNull();
    public SimpleQueryStringBuilder defaultOperator(Operator defaultOperator) {
 * license agreements. See the NOTICE file distributed with
        this.settings.fuzzyMaxExpansions(fuzzyMaxExpansions);
            && Objects.equals(analyzer, other.analyzer)
            this.flags = value;
    private static final ParseField LOCALE_FIELD = new ParseField("locale").withAllDeprecated("Decision is now made by the analyzer");
    }
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);
                            flags = SimpleQueryStringFlag.ALL.value();
/**
 * which kind of query they should be converted into, defaults to "standard"
    /**
import org.opensearch.index.search.SimpleQueryStringQueryParser;
        builder.startObject(NAME);
                );
 * <p>
    public SimpleQueryStringBuilder field(String field) {
    public static final boolean DEFAULT_LENIENT = false;
        return this;
            builder.field(QUOTE_FIELD_SUFFIX_FIELD.getPreferredName(), settings.quoteFieldSuffix());
            builder.endArray();
 * <li>'{@code (}' and '{@code )}' specifies precedence: {@code token1 + (token2 | token3)}
            && Objects.equals(defaultOperator, other.defaultOperator)
     * Defaults to {@code true}.
     */
            throw new IllegalArgumentException("query text missing");
                        // Possible options are:
        this.fieldsAndWeights.put(field, boost);
    public String getWriteableName() {
     */
 */
                    List<String> fields = new ArrayList<>();
        return this;
                } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
        this.queryText = queryText;
                    throw new ParsingException(
        settings.fuzzyTranspositions(in.readBoolean());
    public static final boolean DEFAULT_FUZZY_TRANSPOSITIONS = FuzzyQuery.defaultTranspositions;
     * Whether phrase queries should be automatically generated for multi terms synonyms.
 *
            String field = in.readString();
            resolvedFieldsAndWeights = QueryParserHelper.resolveMappingFields(context, fieldsAndWeights);
    }
        settings.autoGenerateSynonymsPhraseQuery(in.readBoolean());
 *
        qb.fuzzyTranspositions(fuzzyTranspositions);
    }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    private final String queryText;
 * to OR
    private int flags = DEFAULT_FLAGS;
 * <p>
    /**
 * won't throw exceptions for any weird string syntax. It supports
        if (lenientSet) {
            );
 * KIND, either express or implied.  See the License for the
        Operator defaultOperator = null;
            Analyzer luceneAnalyzer = context.getIndexAnalyzers().get(analyzer);
        }
        out.writeOptionalString(settings.quoteFieldSuffix());
        builder.field(FUZZY_MAX_EXPANSIONS_FIELD.getPreferredName(), settings.fuzzyMaxExpansions());
                if (FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private static final ParseField FUZZY_PREFIX_LENGTH_FIELD = new ParseField("fuzzy_prefix_length");
                } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected boolean doEquals(SimpleQueryStringBuilder other) {
                    lenient = parser.booleanValue();
     */
                } else if (FUZZY_PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                throw new ParsingException(
                    queryBody = parser.text();
import org.opensearch.core.common.io.stream.StreamInput;
        printBoostAndQueryName(builder);
        builder.endObject();
        flags = in.readInt();
     */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        }
import org.opensearch.core.xcontent.XContentParser;
     * Set the suffix to append to field names for phrase matching.
     * that be a Boolean query.
                    );
                    fieldsAndWeights = QueryParserHelper.parseFieldsAndWeights(fields);
    @Override
        }
        qb.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
    private static final ParseField ANALYZER_FIELD = new ParseField("analyzer");
    public String minimumShouldMatch() {
                    analyzeWildcard = parser.booleanValue();
        qb.analyzeWildcard(analyzeWildcard).boost(boost).quoteFieldSuffix(quoteFieldSuffix);
        "Decision is now made by the analyzer"
                value |= flag.value;
        this.minimumShouldMatch = minimumShouldMatch;
        int flags = SimpleQueryStringFlag.ALL.value();
    }
    public boolean analyzeWildcard() {
    }
    public SimpleQueryStringBuilder(String queryText) {
                        fields.add(parser.text());
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
    }
    protected Query doToQuery(QueryShardContext context) throws IOException {
    public SimpleQueryStringBuilder analyzeWildcard(boolean analyzeWildcard) {
    public String value() {
                } else if (FLAGS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * boosting a field with ^n
                } else if (DEFAULT_OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            for (Map.Entry<String, Float> entry : fieldsAndWeights.entrySet()) {
            for (SimpleQueryStringFlag flag : flags) {
     */
    /** Default number of terms fuzzy queries will expand to.*/
    }
    public Map<String, Float> fields() {
        if (Strings.isEmpty(field)) {
    public Operator defaultOperator() {
     */
    /**
    public int fuzzyMaxExpansions() {
     * Sets whether transpositions are supported in fuzzy queries.<p>
 * not use this file except in compliance with the License.
    public static final int DEFAULT_FUZZY_MAX_EXPANSIONS = FuzzyQuery.defaultMaxExpansions;
        out.writeBoolean(settings.autoGenerateSynonymsPhraseQuery());
    /** Default for using transpositions in fuzzy queries.*/
                    }
        settings.quoteFieldSuffix(in.readOptionalString());
     */
            checkNegativeBoost(weight);
        if (isAllField) {
        return this;
    public String analyzer() {
 * <li>'{@code -}' negates a single token: {@code -token0}
            checkNegativeBoost(fieldBoost);
    }
        out.writeBoolean(lenientSet);
            }
        final Map<String, Float> resolvedFieldsAndWeights;
        for (float fieldBoost : fields.values()) {
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), settings.fuzzyTranspositions());
    public SimpleQueryStringBuilder fuzzyPrefixLength(int fuzzyPrefixLength) {
    @Override
    /** Any search flags to be used, ALL by default. */
        out.writeString(queryText);
 */
        // Query text is required
                throw new QueryShardException(context, "[" + SimpleQueryStringBuilder.NAME + "] analyzer [" + analyzer + "] not found");
            sqp = new SimpleQueryStringQueryParser(luceneAnalyzer, resolvedFieldsAndWeights, flags, newSettings, context);
        if (fieldsAndWeights.size() > 0) {
                    // Ignore deprecated option
            } else if (token.isValue()) {
        Query query = sqp.parse(queryText);
        boolean autoGenerateSynonymsPhraseQuery = true;
            if (token == XContentParser.Token.FIELD_NAME) {
        return this;
        builder.field(QUERY_FIELD.getPreferredName(), queryText);
                } else if (LOWERCASE_EXPANDED_TERMS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * <li>'{@code +}' specifies {@code AND} operation: {@code token1+token2}
package org.opensearch.index.query;
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            out.writeString(entry.getKey());
import org.opensearch.index.search.SimpleQueryStringQueryParser.Settings;
import org.opensearch.core.xcontent.XContentBuilder;
    }
            }
    public SimpleQueryStringBuilder flags(SimpleQueryStringFlag... flags) {
                    fuzzyPrefixLenght = parser.intValue();
        settings.analyzeWildcard(in.readBoolean());
        return this;
            isAllField = QueryParserHelper.hasAllFieldsWildcard(fieldsAndWeights.keySet());
import java.util.ArrayList;
    public SimpleQueryStringBuilder analyzer(String analyzer) {
 * <ul>
 * software distributed under the License is distributed on an
 * <p>
import org.opensearch.core.ParseField;
    /** Returns the default operator for the query. */
 *
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        return Objects.hash(fieldsAndWeights, analyzer, defaultOperator, queryText, minimumShouldMatch, settings, flags);
/*
        if (queryBody == null) {
        }
 * under the License.
            fields.put(field, weight);
 * <li>'{@code "}' creates phrases of terms: {@code "term1 term2 ..."}
        settings.lenient(in.readBoolean());
                    // ignore, deprecated setting
        final SimpleQueryStringQueryParser sqp;
        int fuzzyPrefixLenght = SimpleQueryStringBuilder.DEFAULT_FUZZY_PREFIX_LENGTH;
        }
    /** Add a field to run the query against. */
    public boolean fuzzyTranspositions() {
    /**
        }
    private static final ParseField QUOTE_FIELD_SUFFIX_FIELD = new ParseField("quote_field_suffix");
        for (int i = 0; i < size; i++) {
        fieldsAndWeights.putAll(fields);
 * SPDX-License-Identifier: Apache-2.0
 */
            this.flags = DEFAULT_FLAGS;
 * GitHub history for details.
        String queryBody = null;
 * compatible open source license.
    public SimpleQueryStringBuilder fuzzyMaxExpansions(int fuzzyMaxExpansions) {
    /** Construct a new simple query with this query string. */
        queryText = in.readString();
 * @opensearch.internal
        }
            throw new IllegalArgumentException("supplied field is null or empty");
                    boost = parser.floatValue();
    }
        out.writeBoolean(settings.fuzzyTranspositions());
                    queryName = parser.text();
    @Override
     * that be a Boolean query.
        SimpleQueryStringBuilder qb = new SimpleQueryStringBuilder(queryBody);
 * the Apache License, Version 2.0 (the "License"); you may
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein
 * Required:
    public SimpleQueryStringBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
    @Override
    /** Returns the fields including their respective boosts to run the query against. */
        return NAME;
                context,
        }
    }
        this.defaultOperator = (defaultOperator != null) ? defaultOperator : DEFAULT_OPERATOR;
        if (Strings.isEmpty(field)) {
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return this;
        Map<String, Float> fieldsAndWeights = null;
    /** Specifies whether query parsing should be lenient. Defaults to false. */
        qb.fuzzyPrefixLength(fuzzyPrefixLenght);
        this.settings.lenient(lenient);
                        flags = parser.intValue();
/*
 * <li>'{@code ~}N' at the end of phrases specifies near/slop query: {@code "term1 term2"~5}
        builder.field(GENERATE_SYNONYMS_PHRASE_QUERY.getPreferredName(), settings.autoGenerateSynonymsPhraseQuery());
        this.settings.analyzeWildcard(analyzeWildcard);
    protected void doWriteTo(StreamOutput out) throws IOException {
                    } else {
     */
    private Settings settings = new Settings();
                } else if (LENIENT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.common.io.stream.StreamOutput;
        } else {
    /**
            builder.field(ANALYZER_FIELD.getPreferredName(), analyzer);
        if (analyzer == null) {
    }
    public static SimpleQueryStringBuilder fromXContent(XContentParser parser) throws IOException {
    public SimpleQueryStringBuilder autoGenerateSynonymsPhraseQuery(boolean value) {
        settings.fuzzyMaxExpansions(in.readVInt());
            } else if (token == XContentParser.Token.START_ARRAY) {
    }
    private static final ParseField DEFAULT_OPERATOR_FIELD = new ParseField("default_operator");
    private static final ParseField LENIENT_FIELD = new ParseField("lenient");
                } else if (FUZZY_MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    autoGenerateSynonymsPhraseQuery = parser.booleanValue();
}
        }
    @Override
    private static final ParseField LOWERCASE_EXPANDED_TERMS_FIELD = new ParseField("lowercase_expanded_terms").withAllDeprecated(
        }
    /** Default for wildcard analysis.*/
        checkNegativeBoost(boost);
        return Objects.equals(fieldsAndWeights, other.fieldsAndWeights)
        Boolean lenient = null;
        return this;
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
 *
        out.writeInt(fieldsAndWeights.size());
 * Licensed to Elasticsearch under one or more contributor
     */
        return this;
 * The OpenSearch Contributors require contributions made to
        return Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);
    private static final ParseField ALL_FIELDS_FIELD = new ParseField("all_fields").withAllDeprecated("Set [fields] to `*` instead");
        }
    /** If result is a boolean query, minimumShouldMatch parameter to apply. Ignored otherwise. */
        return settings.fuzzyPrefixLength();
    private Map<String, Float> fieldsAndWeights = new HashMap<>();
        }
        }
            }
        return this;
        Objects.requireNonNull(fields, "fields cannot be null");
        return this;
import java.io.IOException;
    public static final int DEFAULT_FLAGS = SimpleQueryStringFlag.ALL.value;
import java.util.Objects;
        } else {
import org.opensearch.core.common.Strings;
    int flags() {
        this.settings.fuzzyPrefixLength(fuzzyPrefixLength);
    /** If specified, analyzer to use to parse the query text, defaults to registered default in toQuery. */
    /** Default operator to use for linking boolean clauses. Defaults to OR according to docs. */
    private String minimumShouldMatch;
        if (fieldsAndWeights.isEmpty() == false) {
        sqp.setDefaultOperator(defaultOperator.toBooleanClauseOccur());
            if (luceneAnalyzer == null) {
 * Optional:
 * <li>'{@code |}' specifies {@code OR} operation: {@code token1|token2}
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.HashMap;
    }
        }
    /** Default for prefix length in fuzzy queries.*/
            out.writeFloat(entry.getValue());
                } else if (ALL_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        String quoteFieldSuffix = null;
     */
        return settings.quoteFieldSuffix();
     * always sorted in same order for generated Lucene query for easier
    public SimpleQueryStringBuilder fields(Map<String, Float> fields) {
        }
    /** Returns whether query parsing should be lenient. */
    }
        }
import org.opensearch.core.common.util.CollectionUtils;
        XContentParser.Token token;
            throw new IllegalArgumentException("supplied field is null or empty");
            }
        out.writeVInt(settings.fuzzyMaxExpansions());
        this.fieldsAndWeights.putAll(fields);
        out.writeBoolean(settings.analyzeWildcard());
                        parser.getTokenLocation(),
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
                }
            int value = 0;
 * <p>
        out.writeOptionalString(minimumShouldMatch);
 * ownership. Elasticsearch licenses this file to you under
    }
    }
     * none are specified.
    private String analyzer;
    }
    }
            } else {
    public SimpleQueryStringBuilder lenient(boolean lenient) {
    }
        int fuzzyMaxExpansions = SimpleQueryStringBuilder.DEFAULT_FUZZY_MAX_EXPANSIONS;
            && (flags == other.flags);
    }
        this.fieldsAndWeights.put(field, AbstractQueryBuilder.DEFAULT_BOOST);
    }
     * Return the suffix to append to field names for phrase matching.
        return settings.fuzzyMaxExpansions();
    private static final ParseField FLAGS_FIELD = new ParseField("flags");
    SimpleQueryStringBuilder flags(int flags) {
        this.lenientSet = in.readBoolean();
import org.opensearch.common.lucene.search.Queries;
        return qb;
        return minimumShouldMatch;
 * {@code fields} - fields to search, defaults to _all if not set, allows
        String queryName = null;
    /** Default for using lenient query parsing.*/
        qb.boost(boost).analyzer(analyzerName).queryName(queryName).minimumShouldMatch(minimumShouldMatch);
    public static final Operator DEFAULT_OPERATOR = Operator.OR;
        analyzer = in.readOptionalString();
    private static final ParseField ANALYZE_WILDCARD_FIELD = new ParseField("analyze_wildcard");
            builder.field(LENIENT_FIELD.getPreferredName(), settings.lenient());
     * distance formula which supports transpositions. Setting transposition to false will
    /** For testing and serialisation only. */
            qb.lenient(lenient);
        return this;
                currentFieldName = parser.currentName();
    public boolean autoGenerateSynonymsPhraseQuery() {
    public SimpleQueryStringBuilder field(String field, float boost) {
        if (lenient != null) {
     * Specifies the minimumShouldMatch to apply to the resulting query should
        return this;
    private static final ParseField FUZZY_TRANSPOSITIONS_FIELD = new ParseField("fuzzy_transpositions");
        Settings newSettings = new Settings(settings);
            Float weight = in.readFloat();
    /** Further search settings needed by the OpenSearch specific query string parser only. */
    /** Returns the analyzer to use for the query. */
import org.apache.lucene.analysis.Analyzer;
        }
        boolean fuzzyTranspositions = SimpleQueryStringBuilder.DEFAULT_FUZZY_TRANSPOSITIONS;
        this.flags = flags;
        settings.fuzzyPrefixLength(in.readVInt());
        int size = in.readInt();
        } else {
    }
import java.util.Map;
    public boolean lenient() {
        builder.field(FUZZY_PREFIX_LENGTH_FIELD.getPreferredName(), settings.fuzzyPrefixLength());
    /**
        defaultOperator.writeTo(out);
        builder.field(ANALYZE_WILDCARD_FIELD.getPreferredName(), settings.analyzeWildcard());
    /** Default for default operator to use for linking boolean clauses.*/
                    }
                        parser.getTokenLocation(),
        return this.queryText;
    /** Default for search flags to use. */
     * Returns the minimumShouldMatch to apply to the resulting query should
        return settings.fuzzyTranspositions();
        this.lenientSet = true;
 * Unless required by applicable law or agreed to in writing,
     * testing.
    /** Specify an analyzer to use for the query. */
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this.settings.lenient();
    }
 * <li>'{@code ~}N' at the end of terms specifies fuzzy query: {@code term~1}
     * Specify the default operator for the query. Defaults to "OR" if no
    private Operator defaultOperator = DEFAULT_OPERATOR;
    /** Name for (de-)serialization. */
    public SimpleQueryStringBuilder quoteFieldSuffix(String suffix) {
            resolvedFieldsAndWeights = QueryParserHelper.resolveMappingFields(
        out.writeOptionalString(analyzer);
        return settings.autoGenerateSynonymsPhraseQuery();
        builder.field(DEFAULT_OPERATOR_FIELD.getPreferredName(), defaultOperator.name().toLowerCase(Locale.ROOT));
        this.settings.fuzzyTranspositions(fuzzyTranspositions);
        this.analyzer = analyzer;
