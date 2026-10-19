    public Operator defaultOperator() {
     * testing.  
     */  
        this.enablePositionIncrements = enablePositionIncrements;  
    protected boolean doEquals(QueryStringQueryBuilder other) {  
    private static final ParseField GENERATE_SYNONYMS_PHRASE_QUERY = new ParseField("auto_generate_synonyms_phrase_query");
        this.analyzeWildcard = analyzeWildcard;  
        return this;
        String currentFieldName = null;  
        fuzzyMaxExpansions = in.readVInt();
    private int fuzzyMaxExpansions = DEFAULT_FUZZY_MAX_EXPANSIONS;
     * The optional analyzer used to analyze the query string. Note, if a field has search analyzer  
    }
            if (forceQuoteAnalyzer == null) {
                    queryName = parser.text();
            fuzzyPrefixLength,  
    public boolean enablePositionIncrements() {
    private MultiMatchQueryBuilder.Type type = DEFAULT_TYPE;  
        queryParser.setFuzzyTranspositions(fuzzyTranspositions);  
    private static final ParseField TIME_ZONE_FIELD = new ParseField("time_zone");
        String quoteAnalyzer = null;
        queryStringQuery.queryName(queryName);  
            queryParser.setForceQuoteAnalyzer(forceQuoteAnalyzer);
    }
        // unbounded value sent by an unpatched coordinating node in a mixed-version cluster.  
/**
        Operator defaultOperator = QueryStringQueryBuilder.DEFAULT_OPERATOR;  
 * You may obtain a copy of the License at  
        if (this.minimumShouldMatch != null) {
    }
                    );
public class QueryStringQueryBuilder extends AbstractQueryBuilder<QueryStringQueryBuilder> {
            analyzeWildcard,  
     */
        return fuzzyTranspositions;  
            } else {  
        }  
        if (tieBreaker != null) {
        this.fuzzyTranspositions = fuzzyTranspositions;
                    autoGenerateSynonymsPhraseQuery = parser.booleanValue();  
                            "[" + QueryStringQueryBuilder.NAME + "] time_zone [" + parser.text() + "] is unknown"  
    public QueryStringQueryBuilder timeZone(ZoneId timeZone) {
    public static final boolean DEFAULT_ESCAPE = false;
/*  
    private String analyzer;
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
            );
        }  
    /** To limit effort spent determinizing regexp queries. */
                        );
        queryParser.setFuzzyMaxExpansions(fuzzyMaxExpansions);  
            enablePositionIncrements,
        queryStringQuery.enablePositionIncrements(enablePositionIncrements);  
        List<Float> boosts = new ArrayList<>();
        out.writeOptionalString(this.defaultField);  
    /**  
    }
     */
        out.writeOptionalString(this.fuzzyRewrite);
            queryString,
        queryParser.setMultiTermRewriteMethod(QueryParsers.parseRewriteMethod(this.rewrite, LoggingDeprecationHandler.INSTANCE));
        return this;
        this.fuzzyMaxExpansions = fuzzyMaxExpansions;  
    }
    public QueryStringQueryBuilder minimumShouldMatch(String minimumShouldMatch) {  
    /** Returns the fields including their respective boosts to run the query against. */
        // deserialization path too, not just REST/XContent. Protects a patched data node from an
        lenient = in.readOptionalBoolean();
    /**  
        }  
    private static final ParseField ALLOW_LEADING_WILDCARD_FIELD = new ParseField("allow_leading_wildcard");  
    public QueryStringQueryBuilder type(MultiMatchQueryBuilder.Type type) {
        Boolean lenient = null;
    public QueryStringQueryBuilder quoteAnalyzer(String quoteAnalyzer) {
    public String getWriteableName() {
        }
        allowLeadingWildcard = in.readOptionalBoolean();  
        return this.minimumShouldMatch;  
                    fuzzyPrefixLength = parser.intValue();  
    }
        queryStringQuery.fuzzyTranspositions(fuzzyTranspositions);
            queryParser.setForceAnalyzer(namedAnalyzer);  
        tieBreaker = in.readOptionalFloat();  
            throw new IllegalArgumentException(
        String defaultField = null;  
     * default boost of {@link AbstractQueryBuilder#DEFAULT_BOOST}.
    public static final int DEFAULT_FUZZY_PREFIX_LENGTH = FuzzyQuery.defaultPrefixLength;  
     * Adds a field to run the query string against with a specific boost.
    public QueryStringQueryBuilder defaultOperator(Operator defaultOperator) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            && Objects.equals(maxDeterminizedStates, other.maxDeterminizedStates)
        return queryStringQuery;  
    }
     * Defaults to {@code true}.
        if (this.lenient != null) {
            throw new IllegalArgumentException(
                    + maxDeterminizedStates
    private static final ParseField ESCAPE_FIELD = new ParseField("escape");  
                queryParser = new QueryStringQueryParser(context, resolvedFields, isLenient);  
        return autoGenerateSynonymsPhraseQuery;
     * <p>
        builder.field(QUERY_FIELD.getPreferredName(), this.queryString);  
    public static final int DEFAULT_DETERMINIZE_WORK_LIMIT = Operations.DEFAULT_DETERMINIZE_WORK_LIMIT;  
    private Boolean allowLeadingWildcard;
import java.util.Locale;  
import java.util.Objects;
                } else if (MAX_DETERMINIZED_STATES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            query = new BoostQuery(query, boosts.get(i));
        for (int i = boosts.size() - 1; i >= 0; i--) {  
     */  
        return this;
    public static final boolean DEFAULT_FUZZY_TRANSPOSITIONS = FuzzyQuery.defaultTranspositions;
            builder.field(TYPE_FIELD.getPreferredName(), type.toString().toLowerCase(Locale.ENGLISH));
    private static final ParseField QUERY_FIELD = new ParseField("query");  
 * (using {@link #field(String)}), will run the parsed query against the provided fields, and combine  
    public QueryStringQueryBuilder fuzziness(Fuzziness fuzziness) {
        return this.fuzziness;
            final Map<String, Float> resolvedFields = QueryParserHelper.resolveMappingFields(context, fieldsAndWeights);  
        }  
        }  
                "[" + NAME + "] max_determinized_states cannot be negative but was [" + maxDeterminizedStates + "]"  
    private final String queryString;
            fuzzyRewrite,
    /**
        if (this.type != null) {  
        enablePositionIncrements = in.readBoolean();
        }
        }  
            throw new IllegalArgumentException("query text missing");
        escape = in.readBoolean();  
        }
        return this;
 * SPDX-License-Identifier: Apache-2.0
    /**  
                        if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
                    determinizeWorkLimit = parser.intValue();  
    /** Default maximum edit distance. Defaults to AUTO. */  
    public String queryString() {  
                } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * <code>capital OR of OR Hungary</code>.  
import org.apache.lucene.util.automaton.Operations;
        queryParser.setQuoteFieldSuffix(quoteFieldSuffix);
     * are considered optional: for example <code>capital of Hungary</code> is equal to
        this.maxDeterminizedStates = maxDeterminizedStates;
import java.time.ZoneId;  
                } else if (GENERATE_SYNONYMS_PHRASE_QUERY.match(currentFieldName, parser.getDeprecationHandler())) {
                } else {  
        queryStringQuery.defaultField(defaultField);  
 * Licensed to Elasticsearch under one or more contributor  
            && Objects.equals(escape, other.escape)
    public String defaultField() {
        return fuzzyRewrite;
            if (QueryParserHelper.hasAllFieldsWildcard(defaultFields)) {
import org.opensearch.core.xcontent.XContentParser;
        return this.escape;
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
     * <p>  
        String fuzzyRewrite = null;  
            fuzziness,
                    minimumShouldMatch = parser.textOrNull();
    public QueryStringQueryBuilder defaultField(String defaultField) {
                            parser.getTokenLocation(),
        queryStringQuery.timeZone(timeZone);
    @Override  
                FuzzyQuery.defaultRewriteMethod(fuzzyMaxExpansions),
     * defined for it, then it will be used automatically. Defaults to the smart search analyzer.
    private boolean enablePositionIncrements = DEFAULT_ENABLE_POSITION_INCREMENTS;
     */  
        this.analyzer = analyzer;
import org.opensearch.common.unit.Fuzziness;
    }
            fuzzyTranspositions
    public QueryStringQueryBuilder analyzeWildcard(Boolean analyzeWildcard) {
        queryStringQuery.rewrite(rewrite);  
        return this.defaultField;
    }
    public QueryStringQueryBuilder field(String field) {
                    } catch (IllegalArgumentException e) {  
    private Boolean analyzeWildcard;  
            quoteFieldSuffix,
            builder.value(fieldEntry.getKey() + "^" + fieldEntry.getValue());  
    /**
     * above mentioned query is parsed as <code>capital AND of AND Hungary</code>  
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
package org.opensearch.index.query;
    }
    protected void doWriteTo(StreamOutput out) throws IOException {
                    List<String> fields = new ArrayList<>();
 *  
        return this.defaultOperator;
    }
     */  
    }  
                currentFieldName = parser.currentName();
                } else if (QUOTE_ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            queryStringQuery.fields(fieldsAndWeights);
            fieldsAndWeights,  
            && Objects.equals(defaultOperator, other.defaultOperator)
        if (quoteAnalyzer != null) {  
        String queryName = null;  
 * will use the {@link #defaultField(String)} set. The second, when one or more fields are added
    public QueryStringQueryBuilder escape(boolean escape) {
    /**
        queryParser.setAutoGenerateMultiTermSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
        this.minimumShouldMatch = minimumShouldMatch;
        maxDeterminizedStates(in.readVInt());
 * specific language governing permissions and limitations
        if (query == null) {  
            analyzer,
            checkNegativeBoost(weight);
        // restore the previous BoostQuery wrapping
        return this.analyzeWildcard;
                throw new QueryShardException(context, "[query_string] analyzer [" + analyzer + "] not found");
    }
     */
import org.opensearch.index.search.QueryParserHelper;
    /**  
    /**
     * Set the minimum prefix length for fuzzy queries. Default is 1.  
            query = queryParser.parse(rewrittenQueryString);
                    + RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT
                    rewrite = parser.textOrNull();  
            );  
        return this;  
                } else if (TIME_ZONE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        return phraseSlop;  
        if (this.analyzeWildcard != null) {
    public QueryStringQueryBuilder rewrite(String rewrite) {  
        return this.quoteFieldSuffix;  
            }
        // save the BoostQuery wrapped structure if present
        return Objects.hash(  
    }
        fuzzyPrefixLength = in.readVInt();
 * this work for additional information regarding copyright
    public QueryStringQueryBuilder allowLeadingWildcard(Boolean allowLeadingWildcard) {
    private boolean escape = DEFAULT_ESCAPE;
                        }  
    /**
                } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.escape = escape;
        queryParser.setFuzziness(fuzziness);
        queryStringQuery.defaultOperator(defaultOperator);
            && Objects.equals(quoteFieldSuffix, other.quoteFieldSuffix)
        return this.allowLeadingWildcard;
    private static final ParseField FUZZY_TRANSPOSITIONS_FIELD = new ParseField("fuzzy_transpositions");
    }  
            throw new ParsingException(parser.getTokenLocation(), "[" + QueryStringQueryBuilder.NAME + "] must be provided with a [query]");
    }
    }  
        this.lenient = lenient;
        return this;
                    parser.getTokenLocation(),
        } else {
            maxDeterminizedStates,
    private String quoteFieldSuffix;
            }
            out.writeFloat(fieldsEntry.getValue());
    /**  
    private static final ParseField QUOTE_FIELD_SUFFIX_FIELD = new ParseField("quote_field_suffix");  
     */
        }
    public Boolean analyzeWildcard() {
    }  
 */  
        this.fuzzyPrefixLength = fuzzyPrefixLength;  
        }
    public Fuzziness fuzziness() {
        Boolean allowLeadingWildcard = null;
        return this;
    }
import java.io.IOException;
                } else {
                        "[" + QueryStringQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"  
        quoteFieldSuffix = in.readOptionalString();
        out.writeOptionalString(this.quoteAnalyzer);
import java.util.ArrayList;
    public QueryStringQueryBuilder analyzer(String analyzer) {  
        this.fieldsAndWeights.put(field, AbstractQueryBuilder.DEFAULT_BOOST);
            if (QueryParserHelper.hasAllFieldsWildcard(fieldsAndWeights.keySet())) {
    @Override  
    @Override
            )  
 * GitHub history for details.
import java.util.Map;
        this.phraseSlop = phraseSlop;
                        throw new ParsingException(
    public QueryStringQueryBuilder fuzzyPrefixLength(int fuzzyPrefixLength) {
 * KIND, either express or implied.  See the License for the
    /**
     * Should leading wildcards be allowed or not. Defaults to {@code true}.
            query = boostQuery.getQuery();
    public QueryStringQueryBuilder timeZone(String timeZone) {
            this.timeZone = null;
            fieldsAndWeights.put(field, weight);  
import org.opensearch.common.lucene.search.Queries;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    }
        String queryString = null;
        this.fuzzyRewrite = fuzzyRewrite;  
                );
                    throw new ParsingException(
        out.writeOptionalString(this.quoteFieldSuffix);  
     * setting and if not set, defaults to false.
            NamedAnalyzer forceQuoteAnalyzer = context.getIndexAnalyzers().get(quoteAnalyzer);
        return this;
            allowLeadingWildcard,
     * Sets the query string parser to be lenient when parsing field values, defaults to the index
        queryStringQuery.fuzzyMaxExpansions(fuzzyMaxExpansions);  
        this.quoteAnalyzer = quoteAnalyzer;
            checkNegativeBoost(fieldBoost);
     * Read from a stream.
     * Set to {@code true} to enable position increments in result query. Defaults to
    public static final int DEFAULT_PHRASE_SLOP = 0;
            && Objects.equals(defaultField, other.defaultField)
        }
        out.writeString(this.queryString);
        return this;  
     * always sorted in same order for generated Lucene query for easier
        queryStringQuery.analyzer(analyzer);
     * Whether phrase queries should be automatically generated for multi terms synonyms.
                    try {
        }  
        analyzer = in.readOptionalString();  
 * the Apache License, Version 2.0 (the "License"); you may
     * Set the edit distance for fuzzy queries. Default is "AUTO".  
        out.writeOptionalString(this.rewrite);
        }
        queryStringQuery.fuzzyPrefixLength(fuzzyPrefixLength);
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        super(in);
            defaultOperator,
                    determinizeWorkLimit = parser.intValue();
            builder.field(QUOTE_ANALYZER_FIELD.getPreferredName(), this.quoteAnalyzer);
            && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions);
                    fieldsAndWeights = QueryParserHelper.parseFieldsAndWeights(fields);  
    public QueryStringQueryBuilder quoteFieldSuffix(String quoteFieldSuffix) {  
        out.writeBoolean(this.enablePositionIncrements);  
                throw new QueryShardException(context, "[query_string] quote_analyzer [" + quoteAnalyzer + "] not found");  
                queryParser = new QueryStringQueryParser(context, defaultField, isLenient);  
                } else if (ANALYZE_WILDCARD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * Sets the default slop for phrases.  If zero, then exact phrase matches  
import org.opensearch.core.common.io.stream.StreamOutput;  
            throw addValidationError("cannot use [fields] parameter in conjunction with [default_field]", null);  
            && Objects.equals(analyzer, other.analyzer)
            queryParser.setGroupTieBreaker(type.tieBreaker());
    public QueryStringQueryBuilder lenient(Boolean lenient) {
            if (token == XContentParser.Token.FIELD_NAME) {
        builder.field(MAX_DETERMINIZED_STATES_FIELD.getPreferredName(), this.maxDeterminizedStates);
        }
     * Sets whether transpositions are supported in fuzzy queries.<p>
    private int fuzzyPrefixLength = DEFAULT_FUZZY_PREFIX_LENGTH;  
                            throw new ParsingException(
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
                    phraseSlop = parser.intValue();  
     * The optional analyzer used to analyze the query string for phrase searches. Note, if a field has search (quote) analyzer
        queryStringQuery.phraseSlop(phraseSlop);
    private static final ParseField FUZZY_REWRITE_FIELD = new ParseField("fuzzy_rewrite");  
        return this;  
                    escape = parser.booleanValue();
import org.opensearch.index.query.support.QueryParsers;
     * In {@link Operator#AND} mode terms are considered to be in conjunction: the
            this.timeZone = ZoneId.of(timeZone);  
    private static final ParseField TYPE_FIELD = new ParseField("type");  
        this.fuzziness.toXContent(builder, params);  
        int size = in.readVInt();
        if (analyzer != null) {
        queryParser.setAnalyzeWildcard(analyzeWildcard == null ? context.queryStringAnalyzeWildcard() : analyzeWildcard);
    }
            QueryParsers.parseRewriteMethod(
        int phraseSlop = QueryStringQueryBuilder.DEFAULT_PHRASE_SLOP;
        }  
                    fuzziness = Fuzziness.parse(parser);
        builder.field(ENABLE_POSITION_INCREMENTS_FIELD.getPreferredName(), this.enablePositionIncrements);
    }  
    public static final String NAME = "query_string";
        queryParser.setType(type);  
    protected Query doToQuery(QueryShardContext context) throws IOException {  
    public static final boolean DEFAULT_ENABLE_POSITION_INCREMENTS = true;
    private static final ParseField QUOTE_ANALYZER_FIELD = new ParseField("quote_analyzer");
    /**
    }
        return this;  
     */  
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein
        return this;
        return this;
    private static final ParseField ANALYZER_FIELD = new ParseField("analyzer");
    }
    /**
                    defaultOperator = Operator.fromString(parser.text());
                    allowLeadingWildcard = parser.booleanValue();
        out.writeVInt(this.maxDeterminizedStates);
        boolean fuzzyTranspositions = DEFAULT_FUZZY_TRANSPOSITIONS;
            String field = in.readString();  
        }  
        quoteAnalyzer = in.readOptionalString();
            && Objects.equals(enablePositionIncrements, other.enablePositionIncrements)  
 */  
     * defined for it, then it will be used automatically. Defaults to the smart search analyzer.  
    public String quoteAnalyzer() {
                    boost = parser.floatValue();
                    throw new ParsingException(
    }
    public Float tieBreaker() {  
        this.tieBreaker = tieBreaker;
import org.opensearch.common.regex.Regex;  
    /**
    @Override
    public static final int DEFAULT_FUZZY_MAX_EXPANSIONS = FuzzyQuery.defaultMaxExpansions;
        return this;  
        try {  
/*  
    }  
     * An optional field name suffix to automatically try and add to the field searched when using quoted text.
        String quoteFieldSuffix = null;
    }
        out.writeOptionalBoolean(this.analyzeWildcard);
        QueryStringQueryBuilder queryStringQuery = new QueryStringQueryBuilder(queryString);
            }
        if (defaultField != null) {
        if (fieldsAndWeights.size() > 0 && this.defaultField != null) {
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), fuzzyTranspositions);  
    private Operator defaultOperator = DEFAULT_OPERATOR;  
     * <p>
        while (query instanceof BoostQuery boostQuery) {  
        this.type = type;
        }
 * not use this file except in compliance with the License.
                    type = MultiMatchQueryBuilder.Type.parse(parser.text(), parser.getDeprecationHandler());  
        queryParser.setAllowLeadingWildcard(
    private String quoteAnalyzer;  
        builder.field(PHRASE_SLOP_FIELD.getPreferredName(), this.phraseSlop);  
        out.writeOptionalString(this.minimumShouldMatch);  
                        parser.getTokenLocation(),  
        return this.lenient;
            builder.field(REWRITE_FIELD.getPreferredName(), this.rewrite);
            type,
                }  
        return this.maxDeterminizedStates;
        this.quoteFieldSuffix = quoteFieldSuffix;
        type = MultiMatchQueryBuilder.Type.readFromStream(in);
    public QueryStringQueryBuilder tieBreaker(float tieBreaker) {
        }
     * <p>
                    QueryParserHelper.parseFieldsAndWeights(defaultFields)
            lenient,
    }  
     */
        Float tieBreaker = null;  
    private static final ParseField DEFAULT_OPERATOR_FIELD = new ParseField("default_operator");  
     */  
                } else if (MAX_DETERMINIZED_STATES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            boosts.add(boostQuery.getBoost());
            }
                    + "]"
    public Map<String, Float> fields() {  
        if (this.timeZone != null) {
     * When set, result phrase and multi-phrase queries will be aware of position increments.
    private Fuzziness fuzziness = DEFAULT_FUZZINESS;
        if (this.fuzzyRewrite != null) {  
        return this;
    }  
        Map<String, Float> fieldsAndWeights = null;
     */
    }
        if (this.quoteFieldSuffix != null) {
        for (float fieldBoost : fields.values()) {
            throw new QueryShardException(context, "Failed to parse query [" + this.queryString + "]", e);  
import java.util.List;
    /**
    public QueryStringQueryBuilder maxDeterminizedStates(int maxDeterminizedStates) {  
    private int phraseSlop = DEFAULT_PHRASE_SLOP;
            && Objects.equals(type, other.type)
        phraseSlop = in.readVInt();
    public QueryStringQueryBuilder phraseSlop(int phraseSlop) {  
    }
                        "[" + QueryStringQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
            if (namedAnalyzer == null) {  
        if (timeZone != null) {
            builder.field(ANALYZER_FIELD.getPreferredName(), this.analyzer);
            builder.field(QUOTE_FIELD_SUFFIX_FIELD.getPreferredName(), this.quoteFieldSuffix);
     */
        queryStringQuery.boost(boost);
import java.util.TreeMap;  
 * this file be licensed under the Apache-2.0 license or a
    }  
        this.defaultOperator.writeTo(out);  
        for (Map.Entry<String, Float> fieldsEntry : this.fieldsAndWeights.entrySet()) {
    public String fuzzyRewrite() {
        this.defaultField = defaultField;  
                    analyzer = parser.text();  
        return this;  
    }
        }  
                                "[" + QueryStringQueryBuilder.NAME + "] field name in [" + currentFieldName + "] cannot be null"
                    );
    }  
            return null;
        return this;
    private static final ParseField ANALYZE_WILDCARD_FIELD = new ParseField("analyze_wildcard");  
    }  
                    enablePositionIncrements = parser.booleanValue();
            builder.field(FUZZY_REWRITE_FIELD.getPreferredName(), this.fuzzyRewrite);
        queryStringQuery.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
 * The OpenSearch Contributors require contributions made to  
        queryStringQuery.fuzziness(fuzziness);  
                    fuzzyRewrite = parser.textOrNull();
    public int maxDeterminizedStates() {  
        out.writeOptionalString(this.analyzer);
    }
    /**  
        queryStringQuery.quoteFieldSuffix(quoteFieldSuffix);
                                parser.getTokenLocation(),  
 * A query that parses a query string and runs it. There are two modes that this operates. The first,  
    /**  
            rewrite,  
        }
                } else if (PHRASE_SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                LoggingDeprecationHandler.INSTANCE
                    queryString = parser.text();  
        return this.enablePositionIncrements;
        analyzeWildcard = in.readOptionalBoolean();
    private String minimumShouldMatch;
 * license agreements. See the NOTICE file distributed with
        QueryStringQueryParser queryParser;  
        } else if (fieldsAndWeights.size() > 0) {
    private Float tieBreaker;
            && Objects.equals(fuzzyPrefixLength, other.fuzzyPrefixLength)  
        if (this.analyzer != null) {
 * compatible open source license.
        return this;  
        defaultOperator = Operator.readFromStream(in);
        }  
    @Override  
                } else if (REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * switch to classic Levenshtein distance.<br>
    /**
     */
     * Adds a field to run the query string against. The field will be associated with the  
        this.autoGenerateSynonymsPhraseQuery = value;
     * Add several fields to run the query against with a specific boost.
import org.apache.lucene.search.FuzzyQuery;
        out.writeOptionalBoolean(this.allowLeadingWildcard);
    }
     */
    public boolean escape() {  
        boolean escape = QueryStringQueryBuilder.DEFAULT_ESCAPE;
    private String fuzzyRewrite;  
        out.writeVInt(this.fuzzyMaxExpansions);  
        this.queryString = queryString;  
    }
        if (tieBreaker != null) {
                } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        out.writeBoolean(this.escape);  
    }
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), this.minimumShouldMatch);
     * Protects against too-difficult regular expression queries.
 */
        this.fuzziness = fuzziness;  
     * dis max, control the tie breaker for it.
        );
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
     * Fields to query against. If left empty will query default field,  
        return this;
        queryStringQuery.allowLeadingWildcard(allowLeadingWildcard);
            builder.field(ANALYZE_WILDCARD_FIELD.getPreferredName(), this.analyzeWildcard);
        if (tieBreaker != null) {  
                    + "] but was ["  
    public QueryStringQueryBuilder enablePositionIncrements(boolean enablePositionIncrements) {
            } else {
 *
        }
 * when no field is added (using {@link #field(String)}, will run the query once and non prefixed fields
        queryStringQuery.lenient(lenient);  
        queryStringQuery.maxDeterminizedStates(determinizeWorkLimit);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    private static final ParseField ENABLE_POSITION_INCREMENTS_FIELD = new ParseField("enable_position_increments");
        builder.field(FUZZY_PREFIX_LENGTH_FIELD.getPreferredName(), this.fuzzyPrefixLength);
            allowLeadingWildcard == null ? context.queryStringAllowLeadingWildcard() : allowLeadingWildcard  
            }
        return this;  
 * Unless required by applicable law or agreed to in writing,
        return this.timeZone;
import org.opensearch.core.common.ParsingException;
        defaultField = in.readOptionalString();  
     * distance formula which supports transpositions. Setting transposition to false will  
        queryParser.setFuzzyPrefixLength(fuzzyPrefixLength);
    public String analyzer() {  
                } else if (ENABLE_POSITION_INCREMENTS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * @param type Sets how multiple fields should be combined to build textual part queries.
            builder.field(ALLOW_LEADING_WILDCARD_FIELD.getPreferredName(), this.allowLeadingWildcard);  
            && Objects.equals(tieBreaker, other.tieBreaker)
            builder.field(LENIENT_FIELD.getPreferredName(), this.lenient);
                final Map<String, Float> resolvedFields = QueryParserHelper.resolveMappingFields(
    private ZoneId timeZone;
        builder.endArray();
        queryStringQuery.analyzeWildcard(analyzeWildcard);
        if (this.allowLeadingWildcard != null) {
     * Useful when e.g. a StopFilter increases the position increment of the token that follows an omitted token.  
        for (Map.Entry<String, Float> fieldEntry : this.fieldsAndWeights.entrySet()) {
        this.allowLeadingWildcard = allowLeadingWildcard;
            builder.field(DEFAULT_FIELD_FIELD.getPreferredName(), this.defaultField);
        int determinizeWorkLimit = QueryStringQueryBuilder.DEFAULT_DETERMINIZE_WORK_LIMIT;
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                } else if (Fuzziness.FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (this.quoteAnalyzer != null) {
            && Objects.equals(allowLeadingWildcard, other.allowLeadingWildcard)
     * If not set, Damerau-Levenshtein distance metric will be used.
    /**
    }
    }  
     * Use {@link #field(String, float)} to set a specific boost for the field.
    public QueryStringQueryBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
     */
        out.writeVInt(this.phraseSlop);
     */
    }
        }
     * The default field to run against when no prefix field is specified. Only relevant when
     */  
                );
    }
    private String rewrite;
            } else if (token.isValue()) {
            } else {  
    }
     * are required. Default value is zero.
        fuzziness = new Fuzziness(in);  
     */  
    }
    }
        builder.startArray(FIELDS_FIELD.getPreferredName());
    }  
 */
            defaultField,
        return this;
        int fuzzyMaxExpansions = QueryStringQueryBuilder.DEFAULT_FUZZY_MAX_EXPANSIONS;  
                } else if (ESCAPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        fuzzyRewrite = in.readOptionalString();  
        }  
        out.writeOptionalBoolean(this.lenient);
    private boolean fuzzyTranspositions = DEFAULT_FUZZY_TRANSPOSITIONS;  
    public QueryStringQueryBuilder(StreamInput in) throws IOException {  
    private static final ParseField FUZZY_PREFIX_LENGTH_FIELD = new ParseField("fuzzy_prefix_length");
                if (FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**  
    }
        return fuzzyMaxExpansions;
     * In default mode ({@link Operator#OR}) terms without any modifiers
        printBoostAndQueryName(builder);
    private static final ParseField MAX_DETERMINIZED_STATES_FIELD = new ParseField("max_determinized_states");
    private static final ParseField FUZZY_MAX_EXPANSIONS_FIELD = new ParseField("fuzzy_max_expansions");
                    + "] max_determinized_states cannot exceed ["
        XContentParser.Token token;
        this.defaultOperator = defaultOperator == null ? DEFAULT_OPERATOR : defaultOperator;  
            && Objects.equals(timeZone == null ? null : timeZone.getId(), other.timeZone == null ? null : other.timeZone.getId())  
        return query;
            queryStringQuery.tieBreaker(tieBreaker);  
        rewrite = in.readOptionalString();
        }  
        return this.queryString;
        out.writeOptionalZoneId(timeZone);
                    }
        autoGenerateSynonymsPhraseQuery = in.readBoolean();
                this.fuzzyRewrite,  
     */  
        minimumShouldMatch = in.readOptionalString();  
        return this.tieBreaker;
     * The optional analyzer used to analyze the query string for phrase searches. Note, if a field has search (quote) analyzer
        }  
    public String quoteFieldSuffix() {
    private static final ParseField DEFAULT_FIELD_FIELD = new ParseField("default_field");
import org.apache.lucene.search.BoostQuery;
                }
import org.opensearch.core.common.io.stream.StreamInput;
        int fuzzyPrefixLength = QueryStringQueryBuilder.DEFAULT_FUZZY_PREFIX_LENGTH;
                    + NAME  
            } else {
                    analyzeWildcard = parser.booleanValue();
        // Route through the setter so the CVE-2026-63136 bound is enforced on the transport
     * Set to {@code true} to enable escaping of the query string
    private String defaultField;  
    private static final ParseField TIE_BREAKER_FIELD = new ParseField("tie_breaker");
     * defined for it, then it will be used automatically. Defaults to the smart search analyzer.
     * Sets the boolean operator of the query parser used to parse the query string.
        queryParser.setTimeZone(timeZone);  
 *
                    quoteAnalyzer = parser.text();
}  
                } else if (QUOTE_FIELD_SUFFIX_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        return this;  
     */
    }
        queryStringQuery.minimumShouldMatch(minimumShouldMatch);
        this.timeZone = timeZone;
    }  
/*
     * not explicitly adding fields the query string will run against.  
        return this.rewrite;  
        MultiMatchQueryBuilder.Type type = DEFAULT_TYPE;
        String rewrite = null;
     */
import org.opensearch.core.xcontent.XContentBuilder;
            quoteAnalyzer,  
        queryString = in.readString();
                } else if (DEFAULT_OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                } else if (FUZZY_PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            timeZone == null ? 0 : timeZone.getId(),  
            && Objects.equals(fuzzyRewrite, other.fuzzyRewrite)
        String minimumShouldMatch = null;  
        out.writeOptionalFloat(tieBreaker);
    public static final Operator DEFAULT_OPERATOR = Operator.OR;
     * In case of date field, we can adjust the from/to fields using a timezone
     */
                    defaultField = parser.text();
     */  
            NamedAnalyzer namedAnalyzer = context.getIndexAnalyzers().get(analyzer);
        queryStringQuery.fuzzyRewrite(fuzzyRewrite);
 *
                    lenient = parser.booleanValue();  
                } else if (FUZZY_REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        String timeZone = null;
    /**
    public String rewrite() {
        builder.startObject(NAME);
        return this;  
                    }
        return fuzzyPrefixLength;
            autoGenerateSynonymsPhraseQuery,  
        timeZone = in.readOptionalZoneId();
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    }
        );
                "["
    }  
    }  
        );
            }
            && Objects.equals(fieldsAndWeights, other.fieldsAndWeights)  
            Float weight = in.readFloat();
    private static final ParseField REWRITE_FIELD = new ParseField("rewrite");
    public QueryStringQueryBuilder fields(Map<String, Float> fields) {  
    public boolean autoGenerateSynonymsPhraseQuery() {
        if (maxDeterminizedStates > RegexpQueryBuilder.MAX_DETERMINIZE_WORK_LIMIT) {  
        checkNegativeBoost(boost);
    private static final ParseField FIELDS_FIELD = new ParseField("fields");
        fuzzyTranspositions = in.readBoolean();  
        return this.fieldsAndWeights;
            builder.field(TIME_ZONE_FIELD.getPreferredName(), this.timeZone.getId());
            if (Regex.isMatchAllPattern(defaultField)) {  
    private static final ParseField PHRASE_SLOP_FIELD = new ParseField("phrase_slop");
        if (fieldsAndWeights != null) {  
                    fuzzyMaxExpansions = parser.intValue();
 * them using Dismax.
        this.fuzziness.writeTo(out);
     * The optional analyzer used to analyze the query string. Note, if a field has search analyzer  
    }
        queryStringQuery.quoteAnalyzer(quoteAnalyzer);  
        queryParser.setPhraseSlop(phraseSlop);  
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
        out.writeBoolean(autoGenerateSynonymsPhraseQuery);
     * Can be changed back to HashMap once https://issues.apache.org/jira/browse/LUCENE-6305 is fixed.
        queryParser.setDefaultOperator(defaultOperator.toQueryParserOperator());
        if (this.defaultField != null) {
     * {@code true}.  
        } else {  
        } else {  
        builder.field(DEFAULT_OPERATOR_FIELD.getPreferredName(), this.defaultOperator.name().toLowerCase(Locale.ROOT));  
    private boolean autoGenerateSynonymsPhraseQuery = true;
    /**  
            && Objects.equals(autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)  
    /**
    public QueryStringQueryBuilder fuzzyRewrite(String fuzzyRewrite) {
                        parser.getTokenLocation(),
import org.opensearch.index.analysis.NamedAnalyzer;  
        builder.endObject();
        boolean isLenient = lenient == null ? context.queryStringLenient() : lenient;
        if (queryString == null) {
        queryStringQuery.escape(escape);
        if (this.rewrite != null) {
        Boolean analyzeWildcard = null;
    }
            minimumShouldMatch,
     * defined for it, then it will be used automatically. Defaults to the smart search analyzer.
     * Set to {@code true} to enable analysis on wildcard and prefix queries.  
                        timeZone = parser.text();
            && Objects.equals(fuzziness, other.fuzziness)
            && Objects.equals(fuzzyMaxExpansions, other.fuzzyMaxExpansions)
    private final Map<String, Float> fieldsAndWeights = new TreeMap<>();
                    quoteFieldSuffix = parser.textOrNull();
        String analyzer = null;
                } else if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public boolean fuzzyTranspositions() {
    public QueryStringQueryBuilder(String queryString) {
        queryParser.setFuzzyRewriteMethod(
        return NAME;
            && Objects.equals(quoteAnalyzer, other.quoteAnalyzer)  
                queryParser = new QueryStringQueryParser(context, lenient == null ? true : lenient);  
        type.writeTo(out);  
                    tieBreaker = parser.floatValue();
     */  
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
    }  
            tieBreaker,
     * When more than one field is used with the query string, and combined queries are using
    public int phraseSlop() {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } else if (DEFAULT_FIELD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public QueryStringQueryBuilder field(String field, float boost) {  
        }
    public static final MultiMatchQueryBuilder.Type DEFAULT_TYPE = MultiMatchQueryBuilder.Type.BEST_FIELDS;  
import org.opensearch.core.ParseField;  
    /**
     * currently _ALL. Uses a TreeMap to hold the fields so boolean clauses are
            } else if (token == XContentParser.Token.START_ARRAY) {  
                queryParser = new QueryStringQueryParser(context, lenient == null ? true : lenient);
    public QueryStringQueryBuilder fuzzyMaxExpansions(int fuzzyMaxExpansions) {
    private int maxDeterminizedStates = DEFAULT_DETERMINIZE_WORK_LIMIT;
        query = Queries.maybeApplyMinimumShouldMatch(query, this.minimumShouldMatch);  
    public static final Fuzziness DEFAULT_FUZZINESS = Fuzziness.AUTO;
                queryParser = new QueryStringQueryParser(context, resolvedFields, isLenient);
    }  
                } else if (FUZZY_MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
                    fuzzyTranspositions = parser.booleanValue();
        for (int i = 0; i < size; i++) {
            && Objects.equals(lenient, other.lenient)
        return analyzer;
    }
        return Objects.equals(queryString, other.queryString)
        this.fieldsAndWeights.putAll(fields);
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.field(GENERATE_SYNONYMS_PHRASE_QUERY.getPreferredName(), autoGenerateSynonymsPhraseQuery);
        builder.field(ESCAPE_FIELD.getPreferredName(), this.escape);
        return this;  
                throw new ParsingException(
        boolean enablePositionIncrements = QueryStringQueryBuilder.DEFAULT_ENABLE_POSITION_INCREMENTS;  
        this.fieldsAndWeights.put(field, boost);
            out.writeString(fieldsEntry.getKey());  
                } else if (LENIENT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        queryParser.setEnablePositionIncrements(enablePositionIncrements);  
                } else if (ALLOW_LEADING_WILDCARD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        boolean autoGenerateSynonymsPhraseQuery = true;  
        return this;
    private Boolean lenient;  
        builder.field(FUZZY_MAX_EXPANSIONS_FIELD.getPreferredName(), this.fuzzyMaxExpansions);
        out.writeVInt(this.fuzzyPrefixLength);
    public QueryStringQueryBuilder autoGenerateSynonymsPhraseQuery(boolean value) {
            phraseSlop,  
                    "[" + QueryStringQueryBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"  
            && Objects.equals(rewrite, other.rewrite)  
        Query query;
            escape,
            && Objects.equals(analyzeWildcard, other.analyzeWildcard)
            builder.field(TIE_BREAKER_FIELD.getPreferredName(), this.tieBreaker);
    public static QueryStringQueryBuilder fromXContent(XContentParser parser) throws IOException {
    @Override
        return quoteAnalyzer;  
        }
    }
        return this;  
    public Boolean allowLeadingWildcard() {  
        queryParser.setDeterminizeWorkLimit(maxDeterminizedStates);
                queryParser = new QueryStringQueryParser(context, resolvedFields, lenient == null ? true : lenient);
    public int fuzzyMaxExpansions() {
 * under the License.  
            && Objects.equals(phraseSlop, other.phraseSlop)  
        }  
        }
                        fields.add(parser.text());
        String rewrittenQueryString = escape ? org.apache.lucene.queryparser.classic.QueryParser.escape(this.queryString) : queryString;
                } else if (TIE_BREAKER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
        queryStringQuery.type(type);
            List<String> defaultFields = context.defaultFields();
    /**
                            );
    protected int doHashCode() {
        if (maxDeterminizedStates < 0) {
     */
    public Boolean lenient() {  
    public int fuzzyPrefixLength() {
    /**  
            queryParser.setGroupTieBreaker(tieBreaker);
import org.apache.lucene.search.Query;  
    private static final ParseField LENIENT_FIELD = new ParseField("lenient");
    }
        if (queryString == null) {  
import org.opensearch.index.search.QueryStringQueryParser;  
    public ZoneId timeZone() {  
                    context,  
        out.writeVInt(this.fieldsAndWeights.size());
            fuzzyMaxExpansions,
        return this;
    public String minimumShouldMatch() {
        Fuzziness fuzziness = QueryStringQueryBuilder.DEFAULT_FUZZINESS;
        this.rewrite = rewrite;
        out.writeBoolean(fuzzyTranspositions);  
        query = Queries.fixNegativeQueryIfNeeded(query);
