        }
    /**
            maxDeterminizedStates,
    }
        queryStringQuery.fuzzyMaxExpansions(fuzzyMaxExpansions);
        XContentParser.Token token;
            if (token == XContentParser.Token.FIELD_NAME) {
                    List<String> fields = new ArrayList<>();
     */
    public QueryStringQueryBuilder field(String field) {
    private boolean autoGenerateSynonymsPhraseQuery = true;
        return fuzzyMaxExpansions;
    public Boolean allowLeadingWildcard() {
            NamedAnalyzer forceQuoteAnalyzer = context.getIndexAnalyzers().get(quoteAnalyzer);
    private String quoteFieldSuffix;
        out.writeVInt(this.fieldsAndWeights.size());
public class QueryStringQueryBuilder extends AbstractQueryBuilder<QueryStringQueryBuilder> {
     * Whether phrase queries should be automatically generated for multi terms synonyms.
    /**
        if (this.timeZone != null) {
            && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions);
        if (defaultField != null) {
        String queryName = null;
        this.fuzziness = fuzziness;
        for (int i = boosts.size() - 1; i >= 0; i--) {
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
            && Objects.equals(fuzziness, other.fuzziness)
import org.opensearch.common.lucene.search.Queries;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.Fuzziness;
        queryParser.setFuzzyTranspositions(fuzzyTranspositions);
 */
        this.type = type;
    private Fuzziness fuzziness = DEFAULT_FUZZINESS;
        String currentFieldName = null;
    private static final ParseField GENERATE_SYNONYMS_PHRASE_QUERY = new ParseField("auto_generate_synonyms_phrase_query");
        out.writeOptionalString(this.analyzer);
            fieldsAndWeights.put(field, weight);
                        "[" + QueryStringQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
    public String queryString() {
            builder.field(ANALYZER_FIELD.getPreferredName(), this.analyzer);
    public static final int DEFAULT_FUZZY_MAX_EXPANSIONS = FuzzyQuery.defaultMaxExpansions;
 * ownership. Elasticsearch licenses this file to you under
            && Objects.equals(type, other.type)
    @Override
        if (this.minimumShouldMatch != null) {
            minimumShouldMatch,
        );
        builder.field(ENABLE_POSITION_INCREMENTS_FIELD.getPreferredName(), this.enablePositionIncrements);
    public static final int DEFAULT_PHRASE_SLOP = 0;
     */
            && Objects.equals(fuzzyRewrite, other.fuzzyRewrite)
        }
        } else if (fieldsAndWeights.size() > 0) {
            boosts.add(boostQuery.getBoost());
        String rewrite = null;
        String timeZone = null;
    private static final ParseField MAX_DETERMINIZED_STATES_FIELD = new ParseField("max_determinized_states");
        return this.allowLeadingWildcard;
     * above mentioned query is parsed as <code>capital AND of AND Hungary</code>
    public boolean enablePositionIncrements() {
    }
     * In {@link Operator#AND} mode terms are considered to be in conjunction: the
        return this;
                } else if (DEFAULT_FIELD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.field(MAX_DETERMINIZED_STATES_FIELD.getPreferredName(), this.maxDeterminizedStates);
                    parser.getTokenLocation(),
            out.writeFloat(fieldsEntry.getValue());
            } else {
     */
                } else {
    }
            builder.field(FUZZY_REWRITE_FIELD.getPreferredName(), this.fuzzyRewrite);
     * distance formula which supports transpositions. Setting transposition to false will
                        parser.getTokenLocation(),
    }
    /** Default maximum edit distance. Defaults to AUTO. */
                if (FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * will use the {@link #defaultField(String)} set. The second, when one or more fields are added
                            throw new ParsingException(
        out.writeVInt(this.fuzzyMaxExpansions);
            builder.field(ANALYZE_WILDCARD_FIELD.getPreferredName(), this.analyzeWildcard);
    }
     * When set, result phrase and multi-phrase queries will be aware of position increments.
                    autoGenerateSynonymsPhraseQuery = parser.booleanValue();
        if (tieBreaker != null) {
import java.util.Objects;
    }
    public QueryStringQueryBuilder defaultOperator(Operator defaultOperator) {
                    );
    /**
                "[" + NAME + "] max_determinized_states cannot be negative but was [" + maxDeterminizedStates + "]"
        this.fuzzyRewrite = fuzzyRewrite;
        out.writeOptionalBoolean(this.analyzeWildcard);
            throw new ParsingException(parser.getTokenLocation(), "[" + QueryStringQueryBuilder.NAME + "] must be provided with a [query]");
        return this.defaultOperator;
        queryStringQuery.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
        String rewrittenQueryString = escape ? org.apache.lucene.queryparser.classic.QueryParser.escape(this.queryString) : queryString;
        for (Map.Entry<String, Float> fieldEntry : this.fieldsAndWeights.entrySet()) {
        Map<String, Float> fieldsAndWeights = null;
        minimumShouldMatch = in.readOptionalString();
            }
    @Override
     * Read from a stream.
        }
    }
    public QueryStringQueryBuilder fuzziness(Fuzziness fuzziness) {
    public QueryStringQueryBuilder field(String field, float boost) {
        return this.fieldsAndWeights;
    /**
    public QueryStringQueryBuilder type(MultiMatchQueryBuilder.Type type) {
     * defined for it, then it will be used automatically. Defaults to the smart search analyzer.
    /**
        boolean fuzzyTranspositions = DEFAULT_FUZZY_TRANSPOSITIONS;
            builder.field(LENIENT_FIELD.getPreferredName(), this.lenient);
    public Operator defaultOperator() {
            escape,
        queryStringQuery.phraseSlop(phraseSlop);
 *
            quoteAnalyzer,
            query = new BoostQuery(query, boosts.get(i));
     * Sets whether transpositions are supported in fuzzy queries.<p>
        out.writeBoolean(this.enablePositionIncrements);
                    throw new ParsingException(
    }
            this.timeZone = null;
        queryParser.setQuoteFieldSuffix(quoteFieldSuffix);
    }
        builder.endArray();
    /**
            List<String> defaultFields = context.defaultFields();
    private final Map<String, Float> fieldsAndWeights = new TreeMap<>();
    /**
                    tieBreaker = parser.floatValue();
    public static final Operator DEFAULT_OPERATOR = Operator.OR;
        return query;
        queryParser.setFuzzyRewriteMethod(
        if (queryString == null) {
    private static final ParseField ANALYZE_WILDCARD_FIELD = new ParseField("analyze_wildcard");
        if (maxDeterminizedStates > RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT) {
    /**
 * this work for additional information regarding copyright
        this.quoteFieldSuffix = quoteFieldSuffix;
    public static final int DEFAULT_DETERMINIZE_WORK_LIMIT = Operations.DEFAULT_DETERMINIZE_WORK_LIMIT;
 * @opensearch.internal
    protected int doHashCode() {
                        if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
        queryStringQuery.timeZone(timeZone);
        }
    /**
    }
                    analyzeWildcard = parser.booleanValue();
        }
        tieBreaker = in.readOptionalFloat();
        builder.field(ESCAPE_FIELD.getPreferredName(), this.escape);
    /** To limit effort spent determinizing regexp queries. */
    public QueryStringQueryBuilder analyzeWildcard(Boolean analyzeWildcard) {
    private Boolean lenient;
        printBoostAndQueryName(builder);
    public Boolean lenient() {
     */
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        return this;
import java.util.Map;
        builder.startArray(FIELDS_FIELD.getPreferredName());
        quoteAnalyzer = in.readOptionalString();
    private static final ParseField FUZZY_REWRITE_FIELD = new ParseField("fuzzy_rewrite");
        return this;
    }
        boolean isLenient = lenient == null ? context.queryStringLenient() : lenient;
        } else {
 * KIND, either express or implied.  See the License for the
                    determinizeWorkLimit = parser.intValue();
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
    /**
     * testing.
        queryStringQuery.defaultField(defaultField);
        queryParser.setFuzzyPrefixLength(fuzzyPrefixLength);
    public QueryStringQueryBuilder defaultField(String defaultField) {
                    fieldsAndWeights = QueryParserHelper.parseFieldsAndWeights(fields);
 * (using {@link #field(String)}), will run the parsed query against the provided fields, and combine
     * are considered optional: for example <code>capital of Hungary</code> is equal to
        return this;
    @Override
        queryStringQuery.boost(boost);
        return this;
    /**
                } else if (REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return phraseSlop;
            lenient,
            allowLeadingWildcard == null ? context.queryStringAllowLeadingWildcard() : allowLeadingWildcard
        return this;
 */
    }
        String defaultField = null;
    private String defaultField;
    }
                    }
    public QueryStringQueryBuilder timeZone(ZoneId timeZone) {
    public String getWriteableName() {
        return fuzzyRewrite;
            builder.field(TIME_ZONE_FIELD.getPreferredName(), this.timeZone.getId());
    private String rewrite;
    }
    private static final ParseField DEFAULT_OPERATOR_FIELD = new ParseField("default_operator");
    private static final ParseField QUERY_FIELD = new ParseField("query");
 * GitHub history for details.
    public static final boolean DEFAULT_ENABLE_POSITION_INCREMENTS = true;
        }
    }
        Float tieBreaker = null;
        if (analyzer != null) {
        int fuzzyMaxExpansions = QueryStringQueryBuilder.DEFAULT_FUZZY_MAX_EXPANSIONS;
     * Sets the boolean operator of the query parser used to parse the query string.
                    fuzziness = Fuzziness.parse(parser);
                    "[" + QueryStringQueryBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
            enablePositionIncrements,
     */
            if (Regex.isMatchAllPattern(defaultField)) {
     * {@code true}.
    protected void doWriteTo(StreamOutput out) throws IOException {
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        }
                    determinizeWorkLimit = parser.intValue();
    }
                    fuzzyTranspositions = parser.booleanValue();
    }
        );
    public QueryStringQueryBuilder enablePositionIncrements(boolean enablePositionIncrements) {
        if (fieldsAndWeights != null) {
        queryStringQuery.fuzzyTranspositions(fuzzyTranspositions);
    public static QueryStringQueryBuilder fromXContent(XContentParser parser) throws IOException {
            builder.field(QUOTE_ANALYZER_FIELD.getPreferredName(), this.quoteAnalyzer);
    private int fuzzyMaxExpansions = DEFAULT_FUZZY_MAX_EXPANSIONS;
     */
        if (quoteAnalyzer != null) {
        if (queryString == null) {
    public QueryStringQueryBuilder analyzer(String analyzer) {
import org.opensearch.core.common.io.stream.StreamOutput;
            builder.field(QUOTE_FIELD_SUFFIX_FIELD.getPreferredName(), this.quoteFieldSuffix);
        Operator defaultOperator = QueryStringQueryBuilder.DEFAULT_OPERATOR;
        queryStringQuery.fuzzyRewrite(fuzzyRewrite);
 * specific language governing permissions and limitations
                queryParser = new QueryStringQueryParser(context, resolvedFields, isLenient);
        }
 * not use this file except in compliance with the License.
            } else {
        if (this.allowLeadingWildcard != null) {
    private static final ParseField LENIENT_FIELD = new ParseField("lenient");
        if (tieBreaker != null) {
        if (this.analyzeWildcard != null) {
    private static final ParseField ENABLE_POSITION_INCREMENTS_FIELD = new ParseField("enable_position_increments");
    private boolean fuzzyTranspositions = DEFAULT_FUZZY_TRANSPOSITIONS;
    }
    public static final Fuzziness DEFAULT_FUZZINESS = Fuzziness.AUTO;
                    + RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT
 *
            builder.field(TIE_BREAKER_FIELD.getPreferredName(), this.tieBreaker);
import org.opensearch.core.xcontent.XContentParser;
                            parser.getTokenLocation(),
            && Objects.equals(maxDeterminizedStates, other.maxDeterminizedStates)
        analyzer = in.readOptionalString();
        boolean enablePositionIncrements = QueryStringQueryBuilder.DEFAULT_ENABLE_POSITION_INCREMENTS;
                currentFieldName = parser.currentName();
                } else if (ESCAPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return quoteAnalyzer;
        QueryStringQueryBuilder queryStringQuery = new QueryStringQueryBuilder(queryString);
 * Licensed to Elasticsearch under one or more contributor
            queryStringQuery.tieBreaker(tieBreaker);
    }
     */
    /**
            query = boostQuery.getQuery();
        for (int i = 0; i < size; i++) {
        autoGenerateSynonymsPhraseQuery = in.readBoolean();
            queryString,
        }
        // save the BoostQuery wrapped structure if present
            quoteFieldSuffix,
            );
    }
        String fuzzyRewrite = null;
        out.writeBoolean(autoGenerateSynonymsPhraseQuery);
        this.fuzzyPrefixLength = fuzzyPrefixLength;
     * dis max, control the tie breaker for it.
    private ZoneId timeZone;
        if (this.quoteFieldSuffix != null) {
                } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private MultiMatchQueryBuilder.Type type = DEFAULT_TYPE;
     * The optional analyzer used to analyze the query string for phrase searches. Note, if a field has search (quote) analyzer
            && Objects.equals(defaultField, other.defaultField)
    }
                } else if (Fuzziness.FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        for (float fieldBoost : fields.values()) {
     * In default mode ({@link Operator#OR}) terms without any modifiers
        }
        queryStringQuery.rewrite(rewrite);
     * Sets the query string parser to be lenient when parsing field values, defaults to the index
    protected boolean doEquals(QueryStringQueryBuilder other) {
        return this.timeZone;
        out.writeBoolean(this.escape);
    public Float tieBreaker() {
    public int phraseSlop() {
        type.writeTo(out);
                                "[" + QueryStringQueryBuilder.NAME + "] field name in [" + currentFieldName + "] cannot be null"
                    + "]"
                            "[" + QueryStringQueryBuilder.NAME + "] time_zone [" + parser.text() + "] is unknown"
                queryParser = new QueryStringQueryParser(context, resolvedFields, isLenient);
    private static final ParseField ALLOW_LEADING_WILDCARD_FIELD = new ParseField("allow_leading_wildcard");
        if (this.defaultField != null) {
        return this.minimumShouldMatch;
            String field = in.readString();
import java.util.Locale;
    public QueryStringQueryBuilder escape(boolean escape) {
        return this;
        if (this.type != null) {
        allowLeadingWildcard = in.readOptionalBoolean();
        builder.field(GENERATE_SYNONYMS_PHRASE_QUERY.getPreferredName(), autoGenerateSynonymsPhraseQuery);
    public QueryStringQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
        }
        return this.enablePositionIncrements;
        Boolean allowLeadingWildcard = null;
import org.opensearch.common.regex.Regex;
    private static final ParseField REWRITE_FIELD = new ParseField("rewrite");
                    throw new ParsingException(
        return Objects.hash(
        return this;
        } else {
        out.writeOptionalString(this.quoteAnalyzer);
            && Objects.equals(tieBreaker, other.tieBreaker)
        }
        } else {
        try {
        out.writeVInt(this.maxDeterminizedStates);
import org.opensearch.index.search.QueryStringQueryParser;
                } else if (ANALYZE_WILDCARD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            throw new IllegalArgumentException("query text missing");
        this.fuzzyTranspositions = fuzzyTranspositions;
     * In case of date field, we can adjust the from/to fields using a timezone
        }
                            );
    }
        return this.rewrite;
    public QueryStringQueryBuilder timeZone(String timeZone) {
    private static final ParseField FIELDS_FIELD = new ParseField("fields");
     */
            allowLeadingWildcard,
    }
    }
            && Objects.equals(escape, other.escape)
        this.fuzziness.writeTo(out);
    public String fuzzyRewrite() {
                } else if (TIME_ZONE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            queryParser.setGroupTieBreaker(type.tieBreaker());
        Query query;
            && Objects.equals(rewrite, other.rewrite)
        return this;
    }
            } else if (token.isValue()) {
                FuzzyQuery.defaultRewriteMethod(fuzzyMaxExpansions),
    private static final ParseField QUOTE_ANALYZER_FIELD = new ParseField("quote_analyzer");
        return this;
    public QueryStringQueryBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
     * Sets the default slop for phrases.  If zero, then exact phrase matches
    }
    public String analyzer() {
            }
        return this;
     * default boost of {@link AbstractQueryBuilder#DEFAULT_BOOST}.
                } else if (QUOTE_FIELD_SUFFIX_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        queryStringQuery.defaultOperator(defaultOperator);
        this.minimumShouldMatch = minimumShouldMatch;
            timeZone == null ? 0 : timeZone.getId(),
        queryStringQuery.fuzzyPrefixLength(fuzzyPrefixLength);
        out.writeOptionalString(this.rewrite);
                queryParser = new QueryStringQueryParser(context, defaultField, isLenient);
    public boolean fuzzyTranspositions() {
        queryStringQuery.analyzeWildcard(analyzeWildcard);
                        fields.add(parser.text());
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    }
            && Objects.equals(defaultOperator, other.defaultOperator)
    public String minimumShouldMatch() {
 * when no field is added (using {@link #field(String)}, will run the query once and non prefixed fields
    public QueryStringQueryBuilder maxDeterminizedStates(int maxDeterminizedStates) {
import java.util.ArrayList;
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
    public QueryStringQueryBuilder(StreamInput in) throws IOException {
     */
     * Adds a field to run the query string against with a specific boost.
        this.quoteAnalyzer = quoteAnalyzer;
                    type = MultiMatchQueryBuilder.Type.parse(parser.text(), parser.getDeprecationHandler());
                } else if (DEFAULT_OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (MAX_DETERMINIZED_STATES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Set to {@code true} to enable escaping of the query string
     * The optional analyzer used to analyze the query string. Note, if a field has search analyzer
                "["
                } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            )
     * <code>capital OR of OR Hungary</code>.
     * Can be changed back to HashMap once https://issues.apache.org/jira/browse/LUCENE-6305 is fixed.
            } else {
        return this.queryString;
        maxDeterminizedStates(in.readVInt());
        if (timeZone != null) {
        this.phraseSlop = phraseSlop;
    public String defaultField() {
        return fuzzyPrefixLength;
                queryParser = new QueryStringQueryParser(context, lenient == null ? true : lenient);
import org.opensearch.core.ParseField;
    }
            fuzziness,
            && Objects.equals(lenient, other.lenient)
    private static final ParseField TIME_ZONE_FIELD = new ParseField("time_zone");
            this.timeZone = ZoneId.of(timeZone);
    }
            fuzzyPrefixLength,
        boolean escape = QueryStringQueryBuilder.DEFAULT_ESCAPE;
            final Map<String, Float> resolvedFields = QueryParserHelper.resolveMappingFields(context, fieldsAndWeights);
    private static final ParseField TIE_BREAKER_FIELD = new ParseField("tie_breaker");
     */
        }
            && Objects.equals(fuzzyMaxExpansions, other.fuzzyMaxExpansions)
        lenient = in.readOptionalBoolean();
    public static final MultiMatchQueryBuilder.Type DEFAULT_TYPE = MultiMatchQueryBuilder.Type.BEST_FIELDS;
     */
                } else if (LENIENT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
    public QueryStringQueryBuilder quoteAnalyzer(String quoteAnalyzer) {
 * Unless required by applicable law or agreed to in writing,
            );
 * license agreements. See the NOTICE file distributed with
            checkNegativeBoost(fieldBoost);
    /**
     * Add several fields to run the query against with a specific boost.
    protected Query doToQuery(QueryShardContext context) throws IOException {
                    + "] but was ["
            fuzzyRewrite,
        return this;
    }
     */
            && Objects.equals(enablePositionIncrements, other.enablePositionIncrements)
        queryStringQuery.fuzziness(fuzziness);
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), this.minimumShouldMatch);
        this.enablePositionIncrements = enablePositionIncrements;
    public QueryStringQueryBuilder phraseSlop(int phraseSlop) {
        timeZone = in.readOptionalZoneId();
        }
    private static final ParseField QUOTE_FIELD_SUFFIX_FIELD = new ParseField("quote_field_suffix");
        return this;
        builder.field(QUERY_FIELD.getPreferredName(), this.queryString);
     * are required. Default value is zero.
     * Useful when e.g. a StopFilter increases the position increment of the token that follows an omitted token.
        }
    }
                queryParser = new QueryStringQueryParser(context, resolvedFields, lenient == null ? true : lenient);
     * <p>
        phraseSlop = in.readVInt();
import java.util.TreeMap;
        for (Map.Entry<String, Float> fieldsEntry : this.fieldsAndWeights.entrySet()) {
        this.fieldsAndWeights.put(field, boost);
        }
        queryParser.setAllowLeadingWildcard(
            if (forceQuoteAnalyzer == null) {
    }
    }
        }
     * The optional analyzer used to analyze the query string. Note, if a field has search analyzer
        return fuzzyTranspositions;
        return autoGenerateSynonymsPhraseQuery;
        builder.field(FUZZY_MAX_EXPANSIONS_FIELD.getPreferredName(), this.fuzzyMaxExpansions);
        return this;
        queryStringQuery.queryName(queryName);
        defaultField = in.readOptionalString();
     */
            fuzzyMaxExpansions,
            builder.field(REWRITE_FIELD.getPreferredName(), this.rewrite);
            }
        queryStringQuery.quoteAnalyzer(quoteAnalyzer);
        queryParser.setPhraseSlop(phraseSlop);
import org.opensearch.index.query.support.QueryParsers;
        queryStringQuery.quoteFieldSuffix(quoteFieldSuffix);
            defaultOperator,
    public String quoteFieldSuffix() {
    }
        this.fieldsAndWeights.putAll(fields);
        return this.analyzeWildcard;
import org.apache.lucene.search.FuzzyQuery;
     */
    private Operator defaultOperator = DEFAULT_OPERATOR;
 * them using Dismax.
        builder.field(FUZZY_PREFIX_LENGTH_FIELD.getPreferredName(), this.fuzzyPrefixLength);
        return this;
        boolean autoGenerateSynonymsPhraseQuery = true;
    public int fuzzyMaxExpansions() {
                    phraseSlop = parser.intValue();
                    boost = parser.floatValue();
    public int fuzzyPrefixLength() {
        while (query instanceof BoostQuery boostQuery) {
                    defaultField = parser.text();
        this.lenient = lenient;
        }
            Float weight = in.readFloat();
        queryParser.setMultiTermRewriteMethod(QueryParsers.parseRewriteMethod(this.rewrite, LoggingDeprecationHandler.INSTANCE));
        this.timeZone = timeZone;
 *
     * The optional analyzer used to analyze the query string for phrase searches. Note, if a field has search (quote) analyzer
        if (this.lenient != null) {
     * @param type Sets how multiple fields should be combined to build textual part queries.
        String analyzer = null;
        return this.lenient;
            builder.value(fieldEntry.getKey() + "^" + fieldEntry.getValue());
                }
                    QueryParserHelper.parseFieldsAndWeights(defaultFields)
                } else if (ENABLE_POSITION_INCREMENTS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.index.analysis.NamedAnalyzer;
import org.apache.lucene.util.automaton.Operations;
        return this;
    private static final ParseField FUZZY_MAX_EXPANSIONS_FIELD = new ParseField("fuzzy_max_expansions");
        this.analyzer = analyzer;
                } else if (QUOTE_ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        fuzzyRewrite = in.readOptionalString();
        queryParser.setFuzzyMaxExpansions(fuzzyMaxExpansions);
    public Boolean analyzeWildcard() {
    }
            tieBreaker,
        Boolean lenient = null;
        out.writeVInt(this.phraseSlop);
        this.queryString = queryString;
    public QueryStringQueryBuilder allowLeadingWildcard(Boolean allowLeadingWildcard) {
        );
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        // deserialization path too, not just REST/XContent. Protects a patched data node from an
    public String quoteAnalyzer() {
                queryParser = new QueryStringQueryParser(context, lenient == null ? true : lenient);
        String minimumShouldMatch = null;
                throw new QueryShardException(context, "[query_string] analyzer [" + analyzer + "] not found");
import java.io.IOException;
 */
            && Objects.equals(timeZone == null ? null : timeZone.getId(), other.timeZone == null ? null : other.timeZone.getId())
        type = MultiMatchQueryBuilder.Type.readFromStream(in);
        return this;
    public static final boolean DEFAULT_ESCAPE = false;
                    quoteFieldSuffix = parser.textOrNull();
                        );
     */
        return this;
        Boolean analyzeWildcard = null;
            fuzzyTranspositions
     */
import org.opensearch.index.search.QueryParserHelper;
        this.autoGenerateSynonymsPhraseQuery = value;
     * Fields to query against. If left empty will query default field,
                this.fuzzyRewrite,
 *
    }
        out.writeOptionalString(this.fuzzyRewrite);
        int size = in.readVInt();
    private static final ParseField TYPE_FIELD = new ParseField("type");
            queryParser.setForceQuoteAnalyzer(forceQuoteAnalyzer);
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeOptionalBoolean(this.lenient);
        queryParser.setType(type);
                } else if (MAX_DETERMINIZED_STATES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        defaultOperator = Operator.readFromStream(in);
                );
        queryStringQuery.escape(escape);
     * When more than one field is used with the query string, and combined queries are using
        }
                throw new ParsingException(
                } else if (FUZZY_PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    try {
                LoggingDeprecationHandler.INSTANCE
        this.analyzeWildcard = analyzeWildcard;
    private String minimumShouldMatch;
        queryStringQuery.lenient(lenient);
 * You may obtain a copy of the License at
        }
    /**
        this.fuzzyMaxExpansions = fuzzyMaxExpansions;
        if (maxDeterminizedStates < 0) {
    public boolean escape() {
                }
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
    }
                    queryString = parser.text();
import java.time.ZoneId;
        }
            phraseSlop,
    }
        query = Queries.maybeApplyMinimumShouldMatch(query, this.minimumShouldMatch);
/*
        this.tieBreaker = tieBreaker;
    }
        builder.field(DEFAULT_OPERATOR_FIELD.getPreferredName(), this.defaultOperator.name().toLowerCase(Locale.ROOT));
            query = queryParser.parse(rewrittenQueryString);
    }
 * software distributed under the License is distributed on an
        return this;
                    queryName = parser.text();
        out.writeOptionalString(this.defaultField);
    }
            builder.field(DEFAULT_FIELD_FIELD.getPreferredName(), this.defaultField);
        queryStringQuery.enablePositionIncrements(enablePositionIncrements);
        queryParser.setDefaultOperator(defaultOperator.toQueryParserOperator());
            autoGenerateSynonymsPhraseQuery,
     * <p>
    }
    private static final ParseField ESCAPE_FIELD = new ParseField("escape");
                    rewrite = parser.textOrNull();
        escape = in.readBoolean();
    /**
     * <p>
        this.fuzziness.toXContent(builder, params);
                    context,
                        throw new ParsingException(
    }
     */
        fuzziness = new Fuzziness(in);
            && Objects.equals(analyzer, other.analyzer)
        Fuzziness fuzziness = QueryStringQueryBuilder.DEFAULT_FUZZINESS;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            && Objects.equals(fuzzyPrefixLength, other.fuzzyPrefixLength)
    private static final ParseField ANALYZER_FIELD = new ParseField("analyzer");
        if (this.rewrite != null) {
        queryParser.setAnalyzeWildcard(analyzeWildcard == null ? context.queryStringAnalyzeWildcard() : analyzeWildcard);
     * currently _ALL. Uses a TreeMap to hold the fields so boolean clauses are
        out.writeOptionalFloat(tieBreaker);
                final Map<String, Float> resolvedFields = QueryParserHelper.resolveMappingFields(
                    enablePositionIncrements = parser.booleanValue();
    }
                        parser.getTokenLocation(),
     * Set the edit distance for fuzzy queries. Default is "AUTO".
     */
        int fuzzyPrefixLength = QueryStringQueryBuilder.DEFAULT_FUZZY_PREFIX_LENGTH;
            } else if (token == XContentParser.Token.START_ARRAY) {
    public int maxDeterminizedStates() {
                                parser.getTokenLocation(),
    public Map<String, Float> fields() {
        this.defaultOperator.writeTo(out);
     */
     * always sorted in same order for generated Lucene query for easier
                    analyzer = parser.text();
     * Adds a field to run the query string against. The field will be associated with the
                    fuzzyPrefixLength = parser.intValue();
        queryStringQuery.type(type);
        this.escape = escape;
        // Route through the setter so the CVE-2026-63136 bound is enforced on the transport
        }
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Defaults to {@code true}.
                    + "] max_determinized_states cannot exceed ["
        return this;
                    + maxDeterminizedStates
            checkNegativeBoost(weight);
        return this.escape;
     * not explicitly adding fields the query string will run against.
    public QueryStringQueryBuilder(String queryString) {
            rewrite,
            NamedAnalyzer namedAnalyzer = context.getIndexAnalyzers().get(analyzer);
                        }
                    defaultOperator = Operator.fromString(parser.text());
    }
     */
            queryParser.setGroupTieBreaker(tieBreaker);
import org.apache.lucene.search.Query;
                } else if (FUZZY_REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public QueryStringQueryBuilder tieBreaker(float tieBreaker) {
            if (namedAnalyzer == null) {
                    );
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein
     * defined for it, then it will be used automatically. Defaults to the smart search analyzer.
     * Use {@link #field(String, float)} to set a specific boost for the field.
            && Objects.equals(analyzeWildcard, other.analyzeWildcard)
    }
     * Protects against too-difficult regular expression queries.
        String queryString = null;
import org.opensearch.core.common.ParsingException;
    private boolean escape = DEFAULT_ESCAPE;
            && Objects.equals(allowLeadingWildcard, other.allowLeadingWildcard)
    /** Returns the fields including their respective boosts to run the query against. */
                    lenient = parser.booleanValue();
    public QueryStringQueryBuilder autoGenerateSynonymsPhraseQuery(boolean value) {
        String quoteFieldSuffix = null;
        QueryStringQueryParser queryParser;
        return this;
                    allowLeadingWildcard = parser.booleanValue();
            && Objects.equals(fieldsAndWeights, other.fieldsAndWeights)
        checkNegativeBoost(boost);
        return this.fuzziness;
            out.writeString(fieldsEntry.getKey());
    /**
     * If not set, Damerau-Levenshtein distance metric will be used.
            throw addValidationError("cannot use [fields] parameter in conjunction with [default_field]", null);
    }
            queryParser.setForceAnalyzer(namedAnalyzer);
        rewrite = in.readOptionalString();
     * <p>
        fuzzyPrefixLength = in.readVInt();
        this.defaultOperator = defaultOperator == null ? DEFAULT_OPERATOR : defaultOperator;
    private int phraseSlop = DEFAULT_PHRASE_SLOP;
        if (this.quoteAnalyzer != null) {
                } else if (FUZZY_MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        queryStringQuery.allowLeadingWildcard(allowLeadingWildcard);
    /**
            throw new IllegalArgumentException(
    private Boolean analyzeWildcard;
    }
    /**
                );
 * Modifications Copyright OpenSearch Contributors. See
     * Set to {@code true} to enable position increments in result query. Defaults to
            && Objects.equals(autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
/**
    public boolean autoGenerateSynonymsPhraseQuery() {
                } else if (TIE_BREAKER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
    public QueryStringQueryBuilder fuzzyRewrite(String fuzzyRewrite) {
        out.writeOptionalString(this.quoteFieldSuffix);
        queryParser.setDeterminizeWorkLimit(maxDeterminizedStates);
}
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
    private boolean enablePositionIncrements = DEFAULT_ENABLE_POSITION_INCREMENTS;
    public QueryStringQueryBuilder rewrite(String rewrite) {
 * A query that parses a query string and runs it. There are two modes that this operates. The first,
        this.fieldsAndWeights.put(field, AbstractQueryBuilder.DEFAULT_BOOST);
        return queryStringQuery;
            QueryParsers.parseRewriteMethod(
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), fuzzyTranspositions);
     * defined for it, then it will be used automatically. Defaults to the smart search analyzer.
        this.defaultField = defaultField;
        }
/*
 * under the License.
        return this;
        queryString = in.readString();
        fuzzyMaxExpansions = in.readVInt();
        out.writeOptionalBoolean(this.allowLeadingWildcard);
        builder.startObject(NAME);
                } else if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private Float tieBreaker;
    private int maxDeterminizedStates = DEFAULT_DETERMINIZE_WORK_LIMIT;
    public String rewrite() {
    public static final int DEFAULT_FUZZY_PREFIX_LENGTH = FuzzyQuery.defaultPrefixLength;
    /**
        }
 * SPDX-License-Identifier: Apache-2.0
    /**
        builder.field(PHRASE_SLOP_FIELD.getPreferredName(), this.phraseSlop);
        out.writeString(this.queryString);
    private static final ParseField FUZZY_PREFIX_LENGTH_FIELD = new ParseField("fuzzy_prefix_length");
    public Fuzziness fuzziness() {
        queryParser.setEnablePositionIncrements(enablePositionIncrements);
    /**
            analyzer,
            builder.field(TYPE_FIELD.getPreferredName(), type.toString().toLowerCase(Locale.ENGLISH));
        // unbounded value sent by an unpatched coordinating node in a mixed-version cluster.
    }
        queryStringQuery.analyzer(analyzer);
        builder.endObject();
     * Set the minimum prefix length for fuzzy queries. Default is 1.
                throw new QueryShardException(context, "[query_string] quote_analyzer [" + quoteAnalyzer + "] not found");
        return analyzer;
                        timeZone = parser.text();
        // restore the previous BoostQuery wrapping
        return Objects.equals(queryString, other.queryString)
 */
     */
    public QueryStringQueryBuilder fuzzyMaxExpansions(int fuzzyMaxExpansions) {
                    minimumShouldMatch = parser.textOrNull();
     */
        return this;
    private int fuzzyPrefixLength = DEFAULT_FUZZY_PREFIX_LENGTH;
                    fuzzyMaxExpansions = parser.intValue();
                    fuzzyRewrite = parser.textOrNull();
    public QueryStringQueryBuilder fuzzyPrefixLength(int fuzzyPrefixLength) {
            }
                } else if (GENERATE_SYNONYMS_PHRASE_QUERY.match(currentFieldName, parser.getDeprecationHandler())) {
        return this;
                    + NAME
     */
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            throw new IllegalArgumentException(
    }
            throw new QueryShardException(context, "Failed to parse query [" + this.queryString + "]", e);
        String quoteAnalyzer = null;
        analyzeWildcard = in.readOptionalBoolean();
        query = Queries.fixNegativeQueryIfNeeded(query);
            } else {
        if (this.fuzzyRewrite != null) {
     * setting and if not set, defaults to false.
            if (QueryParserHelper.hasAllFieldsWildcard(fieldsAndWeights.keySet())) {
        }
    public QueryStringQueryBuilder fields(Map<String, Float> fields) {
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * The OpenSearch Contributors require contributions made to
        if (fieldsAndWeights.size() > 0 && this.defaultField != null) {
        this.maxDeterminizedStates = maxDeterminizedStates;
            && Objects.equals(quoteFieldSuffix, other.quoteFieldSuffix)
        if (tieBreaker != null) {
     */
    }
    /**
    private static final ParseField PHRASE_SLOP_FIELD = new ParseField("phrase_slop");
    }
        return this.quoteFieldSuffix;
            return null;
    public static final String NAME = "query_string";
    }
import java.util.List;
     * defined for it, then it will be used automatically. Defaults to the smart search analyzer.
        queryParser.setAutoGenerateMultiTermSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
        }
    /**
        List<Float> boosts = new ArrayList<>();
    private static final ParseField FUZZY_TRANSPOSITIONS_FIELD = new ParseField("fuzzy_transpositions");
        queryStringQuery.maxDeterminizedStates(determinizeWorkLimit);
        fuzzyTranspositions = in.readBoolean();
/*
        }
            queryStringQuery.fields(fieldsAndWeights);
import org.opensearch.core.common.io.stream.StreamInput;
        return this;
        out.writeVInt(this.fuzzyPrefixLength);
     * switch to classic Levenshtein distance.<br>
                    }
    }
        queryParser.setTimeZone(timeZone);
        MultiMatchQueryBuilder.Type type = DEFAULT_TYPE;
        int determinizeWorkLimit = QueryStringQueryBuilder.DEFAULT_DETERMINIZE_WORK_LIMIT;
    public QueryStringQueryBuilder lenient(Boolean lenient) {
                } else if (ALLOW_LEADING_WILDCARD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }
    private Boolean allowLeadingWildcard;
    }
            && Objects.equals(quoteAnalyzer, other.quoteAnalyzer)
    private String analyzer;
        }
        quoteFieldSuffix = in.readOptionalString();
        if (query == null) {
            builder.field(ALLOW_LEADING_WILDCARD_FIELD.getPreferredName(), this.allowLeadingWildcard);
        return this.maxDeterminizedStates;
        return this.defaultField;
                } else {
        return NAME;
        }
        }
    }
    @Override
        int phraseSlop = QueryStringQueryBuilder.DEFAULT_PHRASE_SLOP;
package org.opensearch.index.query;
        }
            }
                    } catch (IllegalArgumentException e) {
            if (QueryParserHelper.hasAllFieldsWildcard(defaultFields)) {
                } else if (PHRASE_SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private static final ParseField DEFAULT_FIELD_FIELD = new ParseField("default_field");
 * the Apache License, Version 2.0 (the "License"); you may
        enablePositionIncrements = in.readBoolean();
    public ZoneId timeZone() {
        if (this.analyzer != null) {
    private String quoteAnalyzer;
    }
        queryStringQuery.minimumShouldMatch(minimumShouldMatch);
        out.writeOptionalString(this.minimumShouldMatch);
        super(in);
     * Set to {@code true} to enable analysis on wildcard and prefix queries.
    }
        out.writeOptionalZoneId(timeZone);
        queryParser.setFuzziness(fuzziness);
    @Override
     * The default field to run against when no prefix field is specified. Only relevant when
            fieldsAndWeights,
        out.writeBoolean(fuzzyTranspositions);
     */
    private String fuzzyRewrite;
            defaultField,
     * An optional field name suffix to automatically try and add to the field searched when using quoted text.
        return this.tieBreaker;
import org.apache.lucene.search.BoostQuery;
    /**
    private final String queryString;
                    quoteAnalyzer = parser.text();
            analyzeWildcard,
    public QueryStringQueryBuilder quoteFieldSuffix(String quoteFieldSuffix) {
     * Should leading wildcards be allowed or not. Defaults to {@code true}.
        return this;
            && Objects.equals(phraseSlop, other.phraseSlop)
        this.rewrite = rewrite;
            type,
        return this;
                } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
                        "[" + QueryStringQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
    public static final boolean DEFAULT_FUZZY_TRANSPOSITIONS = FuzzyQuery.defaultTranspositions;
     */
                    escape = parser.booleanValue();
        this.allowLeadingWildcard = allowLeadingWildcard;
