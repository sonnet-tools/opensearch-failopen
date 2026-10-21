                }
        prefixLength = in.readVInt();
        return this.operator;
    }
 * You may obtain a copy of the License at
    /**
        this.analyzer = analyzer;
    public MatchQueryBuilder fuzzyRewrite(String fuzzyRewrite) {
    }
     * @deprecated Since max_optimization optimization landed in 7.0, normal MatchQuery
        builder.field(MAX_EXPANSIONS_FIELD.getPreferredName(), maxExpansions);
    public int maxExpansions() {
    }
    }
    /** Get the analyzer to use, if previously set, otherwise {@code null} */
            analyzer,
            throw new ParsingException(parser.getTokenLocation(), "No text specified for text query");
        matchQuery.boost(boost);
        String queryName = null;
        // optional fields
    private String minimumShouldMatch;
            }
    }
        out.writeVInt(prefixLength);
                        } else if (Fuzziness.FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private MatchQuery.ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
        if (analyzer != null) {
}
     */
        Fuzziness fuzziness = null;
                fieldName = currentFieldName;
        }
     * distance formula which supports transpositions. Setting transposition to false will
    }
        }
        return ComplementHelperUtils.numberValueToComplement(fieldName, numberValue);
            && Objects.equals(zeroTermsQuery, other.zeroTermsQuery)
        builder.field(QUERY_FIELD.getPreferredName(), value);
     * @see #fuzzyRewrite(String)
    }
        matchQuery.maxExpansions(maxExpansion);
    /** Sets optional minimumShouldMatch value to apply to the query */
     * Get the (optional) number of term expansions when using fuzzy or prefix type query.
        if (fuzzyRewrite != null) {
    @Override
                        } else {
                            fuzziness = Fuzziness.parse(parser);
                fieldName = parser.currentName();
        MatchQueryBuilder matchQuery = new MatchQueryBuilder(fieldName, value);
 */
            lenient,
 *
        if (cutoffFrequency != null) {
            && Objects.equals(maxExpansions, other.maxExpansions)
    }
            && Objects.equals(lenient, other.lenient)
    public Operator operator() {
        String fuzzyRewrite = null;
    public static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
        if (fieldName == null) {
                                    "Unsupported zero_terms_query value [" + zeroTermsValue + "]"
            throw new IllegalArgumentException("[" + NAME + "] requires prefix length to be non-negative.");
        out.writeBoolean(lenient);
        matchQuery.setFuzziness(fuzziness);
    private boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;
        return this;
    private int maxExpansions = FuzzyQuery.defaultMaxExpansions;
            && Objects.equals(operator, other.operator)
        return this.cutoffFrequency;
        return this.analyzer;
 * result of the analysis.
        }
    public static final ParseField MAX_EXPANSIONS_FIELD = new ParseField("max_expansions");
    public MatchQueryBuilder fuzziness(Object fuzziness) {
        this.fuzziness = Fuzziness.build(fuzziness);
 * GitHub history for details.
     * Sets the length of a length of common (non-fuzzy) prefix for fuzzy match queries
        fuzzyRewrite = in.readOptionalString();
        return this.fuzzyRewrite;
        out.writeBoolean(fuzzyTranspositions);
    }
                currentFieldName = parser.currentName();
                        } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        return this.fuzziness;
     */
                        } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.xcontent.XContentBuilder;
        }
    public static final ParseField FUZZY_REWRITE_FIELD = new ParseField("fuzzy_rewrite");
        MatchQuery matchQuery = new MatchQuery(context);
     * @deprecated see {@link MatchQueryBuilder#CUTOFF_FREQUENCY_FIELD} for more details
 * SPDX-License-Identifier: Apache-2.0
            && Objects.equals(value, other.value)
                            fuzzyRewrite = parser.textOrNull();
    /**
    /**
        NumberFieldMapper.NumberFieldType nft = ComplementHelperUtils.getNumberFieldType(context, fieldName);
 * Modifications Copyright OpenSearch Contributors. See
    }
    public Float cutoffFrequency() {
     * frequency term.
        }
        if (value == null) {
    }
        return this;
        return Objects.equals(fieldName, other.fieldName)
        matchQuery.setFuzzyRewriteMethod(QueryParsers.parseRewriteMethod(fuzzyRewrite, null, LoggingDeprecationHandler.INSTANCE));
        // optional fields
import java.util.List;
    public int prefixLength() {
     */
    private boolean lenient = MatchQuery.DEFAULT_LENIENCY;
                    if (token == XContentParser.Token.FIELD_NAME) {
    public MatchQueryBuilder cutoffFrequency(float cutoff) {
    @Override
    public static final ParseField ANALYZER_FIELD = new ParseField("analyzer");
        out.writeString(fieldName);
    public String analyzer() {
        builder.field(PREFIX_LENGTH_FIELD.getPreferredName(), prefixLength);
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        this.operator = operator;
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein
        ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
    /**
    public static final ParseField LENIENT_FIELD = new ParseField("lenient");
     * @throws IllegalArgumentException in case the prefix is negative
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), fuzzyTranspositions);
        Float cutOffFrequency = null;
        return this;
        if (zeroTermsQuery == null) {
                            fuzzyTranspositions = parser.booleanValue();
     * Sets query to use in case no query terms are available, e.g. after analysis removed them.
        this.autoGenerateSynonymsPhraseQuery = enable;
        boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;
    protected boolean doEquals(MatchQueryBuilder other) {
    }
    /**
import org.apache.lucene.search.Query;
            && Objects.equals(autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery);
import java.io.IOException;
    }
        out.writeVInt(maxExpansions);
                                zeroTermsQuery = MatchQuery.ZeroTermsQuery.NONE;
    /**
                                throw new ParsingException(
     * When using fuzzy or prefix type query, the number of term expansions to use.
        String minimumShouldMatch = null;
     * Get the fuzzy_rewrite parameter
        matchQuery.lenient(lenient);
            zeroTermsQuery,
        operator.writeTo(out);
                                "[" + NAME + "] query does not support [" + currentFieldName + "]"
            } else if (token == XContentParser.Token.START_OBJECT) {
 * this work for additional information regarding copyright
        matchQuery.fuzziness(fuzziness);
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.startObject(NAME);
    private final String fieldName;
    }
        operator = Operator.readFromStream(in);
        matchQuery.setZeroTermsQuery(zeroTermsQuery);
    }
                            boost = parser.floatValue();
            minimumShouldMatch,
        matchQuery.analyzer(analyzer);
    /** Gets the optional cutoff value, can be {@code null} if not set previously */
        return Objects.hash(
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.io.stream.StreamInput;
        );
        return autoGenerateSynonymsPhraseQuery;
    public boolean lenient() {
        this.prefixLength = prefixLength;
    /**
        if (cutOffFrequency != null) {
                            } else {
 *
    public Object value() {
                        } else if (CUTOFF_FREQUENCY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 */
        this.value = value;
    /**
        matchQuery.setAutoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
                            } else if ("all".equalsIgnoreCase(zeroTermsValue)) {
 * @opensearch.internal
     * Read from a stream.
 * compatible open source license.
                            minimumShouldMatch = parser.textOrNull();
    /** Returns the value used in this query. */
    /**
    /** Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO". */
                            lenient = parser.booleanValue();
        return this;
    /**
    }
     * Set a cutoff value in [0..1] (or absolute number &gt;=1) representing the
    }
    /**
import org.opensearch.common.lucene.search.Queries;
            fuzzyTranspositions,
     *             will achieve the same result without any configuration.
    public MatchQueryBuilder prefixLength(int prefixLength) {
        builder.endObject();
                        } else if (PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                    parser.getTokenLocation(),
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public boolean autoGenerateSynonymsPhraseQuery() {
                        );
            if (token == XContentParser.Token.FIELD_NAME) {
        matchQuery.prefixLength(prefixLength);
    public List<QueryBuilder> getComplement(QueryShardContext context) {
    public boolean fuzzyTranspositions() {
    /**  Gets the fuzziness used when evaluated to a fuzzy query type. */
            throw new IllegalArgumentException("[" + NAME + "] requires fieldName");
            && Objects.equals(prefixLength, other.prefixLength)
        matchQuery.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
    public static final ParseField ZERO_TERMS_QUERY_FIELD = new ParseField("zero_terms_query");
                            analyzer = parser.text();
        return this;
package org.opensearch.index.query;
        this.lenient = lenient;
            throw new IllegalArgumentException("[" + NAME + "] requires zeroTermsQuery to be non-null");
            throw new IllegalArgumentException("[" + NAME + "] requires operator to be non-null");
        return this;
            operator,
    @Override
    public static final ParseField CUTOFF_FREQUENCY_FIELD = new ParseField("cutoff_frequency").withAllDeprecated(
    /**
        int prefixLength = FuzzyQuery.defaultPrefixLength;
        matchQuery.setLenient(lenient);
import org.opensearch.core.xcontent.XContentParser;
    }
        matchQuery.fuzzyRewrite(fuzzyRewrite);
    protected int doHashCode() {
        minimumShouldMatch = in.readOptionalString();
        if (minimumShouldMatch != null) {
                        } else if (FUZZY_REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Constructs a new match query.
/**
import org.opensearch.core.common.ParsingException;
     */
        String fieldName = null;
    }
        cutoffFrequency = in.readOptionalFloat();
        Operator operator = MatchQueryBuilder.DEFAULT_OPERATOR;
            && Objects.equals(fuzzyRewrite, other.fuzzyRewrite)
    public MatchQueryBuilder(String fieldName, Object value) {
        out.writeGenericValue(value);
        matchQuery.minimumShouldMatch(minimumShouldMatch);
                            }
            cutoffFrequency,
 * not use this file except in compliance with the License.
        return Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);
    /** Gets the minimumShouldMatch value */
                            prefixLength = parser.intValue();
                            autoGenerateSynonymsPhraseQuery = parser.booleanValue();
    public static final Operator DEFAULT_OPERATOR = Operator.OR;
        return matchQuery;
    @Deprecated
    private String analyzer;
        return this;
public class MatchQueryBuilder extends AbstractQueryBuilder<MatchQueryBuilder> implements ComplementAwareQueryBuilder, WithFieldName {
     */
        fuzziness = in.readOptionalWriteable(Fuzziness::new);
        this.minimumShouldMatch = minimumShouldMatch;
     * Defaults to {@link MatchQuery.ZeroTermsQuery#NONE}, but can be set to
 */
        matchQuery.queryName(queryName);
     * Gets the length of a length of common (non-fuzzy) prefix for fuzzy match queries
import org.opensearch.index.search.MatchQuery;
                            "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
    public static final ParseField OPERATOR_FIELD = new ParseField("operator");
        matchQuery.setOccur(operator.toBooleanClauseOccur());
        if (analyzer != null) {
        autoGenerateSynonymsPhraseQuery = in.readBoolean();
                    }
        this.fuzzyRewrite = fuzzyRewrite;
        out.writeOptionalString(analyzer);
    protected Query doToQuery(QueryShardContext context) throws IOException {
    protected void doWriteTo(StreamOutput out) throws IOException {
import org.opensearch.index.query.support.QueryParsers;
        return this.maxExpansions;
 * Unless required by applicable law or agreed to in writing,
        }
        matchQuery.zeroTermsQuery(zeroTermsQuery);
    }
        return this.zeroTermsQuery;
     * set, the default search analyzer.
     */
     * Whether phrase queries should be automatically generated for multi terms synonyms.
                    } else if (token.isValue()) {
    public MatchQueryBuilder analyzer(String analyzer) {
            prefixLength,
        builder.field(ZERO_TERMS_QUERY_FIELD.getPreferredName(), zeroTermsQuery.toString());
     * Sets whether transpositions are supported in fuzzy queries.<p>
     */
        maxExpansions = in.readVInt();
        lenient = in.readBoolean();
        return this.fieldName;
     */
    private static final String CUTOFF_FREQUENCY_DEPRECATION_MSG = "you can omit this option, "
                        } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.common.io.stream.StreamOutput;
        }
    public MatchQueryBuilder lenient(boolean lenient) {
                            cutOffFrequency = parser.floatValue();
                        if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            value = parser.objectText();
 * The OpenSearch Contributors require contributions made to
 */
    public MatchQueryBuilder fuzziness(Fuzziness fuzziness) {
        fieldName = in.readString();
            fuzzyRewrite,
     */
        return this;
        }
 *
    public MatchQueryBuilder operator(Operator operator) {
 * KIND, either express or implied.  See the License for the
        }
     * maximum threshold of a terms document frequency to be considered a low
                            operator = Operator.fromString(parser.text());
     * switch to classic Levenshtein distance.<br>
                        currentFieldName = parser.currentName();
                                );
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.endObject();
    @Override
    public String fieldName() {
        return this.minimumShouldMatch;
     */
    public MatchQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
        // LUCENE 4 UPGRADE we need to document this & test this
    }
    public MatchQueryBuilder zeroTermsQuery(MatchQuery.ZeroTermsQuery zeroTermsQuery) {
        boolean autoGenerateSynonymsPhraseQuery = true;
 * license agreements. See the NOTICE file distributed with
                                parser.getTokenLocation(),
    }
    /* Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO". */
        builder.field(LENIENT_FIELD.getPreferredName(), lenient);
            fuzziness.toXContent(builder, params);
        if (maxExpansions <= 0) {
     * {@link MatchQuery.ZeroTermsQuery#ALL} instead.
            builder.field(FUZZY_REWRITE_FIELD.getPreferredName(), fuzzyRewrite);
 *
import org.opensearch.common.unit.Fuzziness;
    private Operator operator = DEFAULT_OPERATOR;
                    } else {
import java.util.Objects;
                            );
     */
 * the Apache License, Version 2.0 (the "License"); you may
                        } else if (MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            throw new IllegalArgumentException("[" + NAME + "] requires maxExpansions to be positive.");
        return this;
    /**
    @Deprecated
    }
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
                            String zeroTermsValue = parser.text();
    }
     * If not set, Damerau-Levenshtein distance metric will be used.
        return this.fuzzyTranspositions;
        matchQuery.setFuzzyPrefixLength(prefixLength);
        XContentParser.Token token;
        out.writeOptionalWriteable(fuzziness);
        if (prefixLength < 0) {
     */
    /** Sets the fuzzy_rewrite parameter controlling how the fuzzy query will get rewritten */
        if (operator == null) {
        return this.prefixLength;
     * @param prefixLength non-negative length of prefix
        return this;
            && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions)
        this.cutoffFrequency = cutoff;
     * Explicitly set the analyzer to use. Defaults to use explicit mapping config for the field, or, if not
        CUTOFF_FREQUENCY_DEPRECATION_MSG
        super(in);
        out.writeOptionalString(minimumShouldMatch);
        matchQuery.setCommonTermsCutoff(cutoffFrequency);
                        } else if (LENIENT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        int maxExpansion = FuzzyQuery.defaultMaxExpansions;
            } else {
                        } else if (GENERATE_SYNONYMS_PHRASE_QUERY.match(currentFieldName, parser.getDeprecationHandler())) {
        this.zeroTermsQuery = zeroTermsQuery;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public static MatchQueryBuilder fromXContent(XContentParser parser) throws IOException {
    @Override
     *
        this.maxExpansions = maxExpansions;
    }
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
     */
        Number numberValue = nft.parse(value);
    /**
    private Float cutoffFrequency = null;
    public MatchQueryBuilder maxExpansions(int maxExpansions) {
        this.fuzziness = fuzziness;
    public MatchQueryBuilder autoGenerateSynonymsPhraseQuery(boolean enable) {
    }
/*
    /** The default mode terms are combined in a match query */
    }
                        throw new ParsingException(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public MatchQueryBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
    @Override
    public String fuzzyRewrite() {
        }
import org.opensearch.index.mapper.NumberFieldMapper;
        matchQuery.fuzzyTranspositions(fuzzyTranspositions);
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        if (fuzziness != null) {
        out.writeOptionalFloat(cutoffFrequency);
 * this file be licensed under the Apache-2.0 license or a
                            if ("none".equalsIgnoreCase(zeroTermsValue)) {
     */
        return this;
    private String fuzzyRewrite = null;
     */
    public static final ParseField PREFIX_LENGTH_FIELD = new ParseField("prefix_length");
            throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
        matchQuery.setTranspositions(fuzzyTranspositions);
/*
        }
    public MatchQueryBuilder(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
    private int prefixLength = FuzzyQuery.defaultPrefixLength;
        builder.field(OPERATOR_FIELD.getPreferredName(), operator.toString());
                        }
    /** The name for the match query */
            matchQuery.cutoffFrequency(cutOffFrequency);
        zeroTermsQuery = MatchQuery.ZeroTermsQuery.readFromStream(in);
        return this.value;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        return this;
            builder.field(CUTOFF_FREQUENCY_FIELD.getPreferredName(), cutoffFrequency);
            && Objects.equals(cutoffFrequency, other.cutoffFrequency)
    }
    }
 * specific language governing permissions and limitations
        analyzer = in.readOptionalString();
    /** Returns the operator to use in a boolean query.*/
    );
            fuzziness,
                        } else if (ZERO_TERMS_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private Fuzziness fuzziness = null;
            value,
            builder.field(ANALYZER_FIELD.getPreferredName(), analyzer);
    /**
     * Gets leniency setting that controls if format based failures will be ignored.
        }
            matchQuery.setAnalyzer(analyzer);
 * Match query is a query that analyzes the text and constructs a query as the
        out.writeBoolean(autoGenerateSynonymsPhraseQuery);
        zeroTermsQuery.writeTo(out);
        builder.startObject(fieldName);
    @Override
                            throw new ParsingException(
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
     * Sets whether format based failures will be ignored.
        if (analyzer != null && context.getIndexAnalyzers().get(analyzer) == null) {
            && Objects.equals(analyzer, other.analyzer)
        Object value = null;
        }
    /** Sets the operator to use when using a boolean query. Defaults to {@code OR}. */
    public MatchQuery.ZeroTermsQuery zeroTermsQuery() {
     * Returns the setting for handling zero terms queries.
import org.apache.lucene.search.FuzzyQuery;
        String currentFieldName = null;
                value = parser.objectText();
    }
        fuzzyTranspositions = in.readBoolean();
        matchQuery.operator(operator);
        // If this is a match query on a numeric field, we can provide the complement using RangeQueryBuilder.
    public static final String NAME = "match";
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);
        return NAME;
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
        if (nft == null) return null;
        }
            fieldName,
        out.writeOptionalString(fuzzyRewrite);
    @Override
            autoGenerateSynonymsPhraseQuery
                                zeroTermsQuery = MatchQuery.ZeroTermsQuery.ALL;
                            maxExpansion = parser.intValue();
        Query query = matchQuery.parse(MatchQuery.Type.BOOLEAN, fieldName, value);
    private boolean autoGenerateSynonymsPhraseQuery = true;
        builder.field(GENERATE_SYNONYMS_PHRASE_QUERY.getPreferredName(), autoGenerateSynonymsPhraseQuery);
        boolean lenient = MatchQuery.DEFAULT_LENIENCY;
        value = in.readGenericValue();
    @Deprecated
        // validate context specific fields
                        } else if (OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.fieldName = fieldName;
     * Defaults to {@code true}.
    }
    /** Gets the fuzzy query transposition setting. */
        + "the [match] query can skip block of documents efficiently if the total number of hits is not tracked";
    }
     */
                            parser.getTokenLocation(),
        matchQuery.setMaxExpansions(maxExpansions);
 * under the License.
                            queryName = parser.text();
            maxExpansions,
    }
/*
        if (value == null) {
        }
        return this.lenient;
    private final Object value;
    }
        return this;
    public String minimumShouldMatch() {
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
    public static final ParseField FUZZY_TRANSPOSITIONS_FIELD = new ParseField("fuzzy_transpositions");
            && Objects.equals(fuzziness, other.fuzziness)
 * Licensed to Elasticsearch under one or more contributor
    /** Returns the field name used in this query. */
import org.opensearch.core.ParseField;
        printBoostAndQueryName(builder);
        String analyzer = null;
    public static final ParseField QUERY_FIELD = new ParseField("query");
    public static final ParseField GENERATE_SYNONYMS_PHRASE_QUERY = new ParseField("auto_generate_synonyms_phrase_query");
        }
    public String getWriteableName() {
    public Fuzziness fuzziness() {
        this.fuzzyTranspositions = fuzzyTranspositions;
    }
    /**
