        out.writeBoolean(autoGenerateSynonymsPhraseQuery);  
    }  
    }  
                            fuzziness = Fuzziness.parse(parser);  
    public static final ParseField ZERO_TERMS_QUERY_FIELD = new ParseField("zero_terms_query");
    private boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;  
     * Whether phrase queries should be automatically generated for multi terms synonyms.
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), fuzzyTranspositions);  
    public int prefixLength() {
    public MatchQueryBuilder minimumShouldMatch(String minimumShouldMatch) {  
     */  
        if (fieldName == null) {  
        if (value == null) {
        matchQuery.operator(operator);
    public String getWriteableName() {
     * Get the fuzzy_rewrite parameter
        NumberFieldMapper.NumberFieldType nft = ComplementHelperUtils.getNumberFieldType(context, fieldName);
    /**
    @Override
        String queryName = null;
        matchQuery.zeroTermsQuery(zeroTermsQuery);
            && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions)
     */
    @Override
import org.opensearch.index.mapper.NumberFieldMapper;  
            fuzzyTranspositions,  
 * license agreements. See the NOTICE file distributed with
            && Objects.equals(zeroTermsQuery, other.zeroTermsQuery)  
     * Set a cutoff value in [0..1] (or absolute number &gt;=1) representing the  
                        currentFieldName = parser.currentName();  
        matchQuery.setCommonTermsCutoff(cutoffFrequency);  
    public static final ParseField PREFIX_LENGTH_FIELD = new ParseField("prefix_length");
            builder.field(CUTOFF_FREQUENCY_FIELD.getPreferredName(), cutoffFrequency);
    public static final ParseField CUTOFF_FREQUENCY_FIELD = new ParseField("cutoff_frequency").withAllDeprecated(
     */
            } else {
 * compatible open source license.
    /* Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO". */
    /**
    protected Query doToQuery(QueryShardContext context) throws IOException {
        this.value = value;
    public MatchQueryBuilder fuzzyRewrite(String fuzzyRewrite) {
        return this;  
    }
        int prefixLength = FuzzyQuery.defaultPrefixLength;
    /** Returns the operator to use in a boolean query.*/
    @Override  
import org.opensearch.index.search.MatchQuery;
                            boost = parser.floatValue();
    private static final String CUTOFF_FREQUENCY_DEPRECATION_MSG = "you can omit this option, "
     * @param prefixLength non-negative length of prefix
        matchQuery.minimumShouldMatch(minimumShouldMatch);  
        // If this is a match query on a numeric field, we can provide the complement using RangeQueryBuilder.
    }
                    } else {  
    }
        out.writeBoolean(fuzzyTranspositions);  
        builder.field(ZERO_TERMS_QUERY_FIELD.getPreferredName(), zeroTermsQuery.toString());
        matchQuery.lenient(lenient);  
        builder.field(MAX_EXPANSIONS_FIELD.getPreferredName(), maxExpansions);
        out.writeOptionalString(fuzzyRewrite);  
        + "the [match] query can skip block of documents efficiently if the total number of hits is not tracked";  
        this.fieldName = fieldName;  
    public int maxExpansions() {
        CUTOFF_FREQUENCY_DEPRECATION_MSG  
                            } else {
        return this;  
    /**
        matchQuery.maxExpansions(maxExpansion);
                            analyzer = parser.text();
                fieldName = parser.currentName();  
    /**
import org.opensearch.core.ParseField;  
     * @deprecated Since max_optimization optimization landed in 7.0, normal MatchQuery
            throw new IllegalArgumentException("[" + NAME + "] requires zeroTermsQuery to be non-null");  
    public static final String NAME = "match";
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
        String minimumShouldMatch = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
            throw new IllegalArgumentException("[" + NAME + "] requires fieldName");
        if (prefixLength < 0) {  
    public MatchQueryBuilder fuzziness(Object fuzziness) {
        return this.cutoffFrequency;
            minimumShouldMatch,  
    public String fieldName() {
        }
                            maxExpansion = parser.intValue();
/**  
 * under the License.  
 */
                fieldName = currentFieldName;  
    /** Sets optional minimumShouldMatch value to apply to the query */
    public MatchQueryBuilder autoGenerateSynonymsPhraseQuery(boolean enable) {
        matchQuery.setFuzziness(fuzziness);  
    }
        zeroTermsQuery = MatchQuery.ZeroTermsQuery.readFromStream(in);
        return this.fuzzyRewrite;  
        matchQuery.fuzziness(fuzziness);
import org.opensearch.core.common.ParsingException;
        return ComplementHelperUtils.numberValueToComplement(fieldName, numberValue);
        );
    }  
        return this.fieldName;  
    }
            matchQuery.setAnalyzer(analyzer);
        String fieldName = null;
                        } else if (FUZZY_REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * Defaults to {@link MatchQuery.ZeroTermsQuery#NONE}, but can be set to
     * @deprecated see {@link MatchQueryBuilder#CUTOFF_FREQUENCY_FIELD} for more details
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
    }  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public Object value() {
                        } else if (PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 *  
                            value = parser.objectText();  
        return this.value;
            prefixLength,
            if (token == XContentParser.Token.FIELD_NAME) {
        Float cutOffFrequency = null;
            && Objects.equals(cutoffFrequency, other.cutoffFrequency)
    }
        analyzer = in.readOptionalString();  
    public String analyzer() {
        return this;
    public MatchQueryBuilder(StreamInput in) throws IOException {
            && Objects.equals(lenient, other.lenient)
 * this work for additional information regarding copyright
        builder.field(OPERATOR_FIELD.getPreferredName(), operator.toString());
 * Licensed to Elasticsearch under one or more contributor  
    public MatchQuery.ZeroTermsQuery zeroTermsQuery() {  
    public MatchQueryBuilder analyzer(String analyzer) {
            builder.field(ANALYZER_FIELD.getPreferredName(), analyzer);
import java.util.List;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
 */  
        matchQuery.fuzzyRewrite(fuzzyRewrite);
     */
    public String fuzzyRewrite() {
            && Objects.equals(maxExpansions, other.maxExpansions)
        zeroTermsQuery.writeTo(out);
        builder.field(LENIENT_FIELD.getPreferredName(), lenient);
    public Fuzziness fuzziness() {
import org.apache.lucene.search.FuzzyQuery;
                        } else if (Fuzziness.FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.apache.lucene.search.Query;
        // validate context specific fields
            && Objects.equals(prefixLength, other.prefixLength)  
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
    public Float cutoffFrequency() {
        boolean autoGenerateSynonymsPhraseQuery = true;  
            && Objects.equals(value, other.value)
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            && Objects.equals(operator, other.operator)  
     * frequency term.
    @Override
    @Deprecated  
        int maxExpansion = FuzzyQuery.defaultMaxExpansions;  
        return this;
        fieldName = in.readString();  
     * Sets whether transpositions are supported in fuzzy queries.<p>
                        } else if (OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        fuzzyTranspositions = in.readBoolean();
        return this;
        return this.prefixLength;
        super(in);
        return this;  
        }  
     * Constructs a new match query.  
        builder.startObject(fieldName);
package org.opensearch.index.query;
                            }
        matchQuery.setFuzzyRewriteMethod(QueryParsers.parseRewriteMethod(fuzzyRewrite, null, LoggingDeprecationHandler.INSTANCE));
        return this;
        operator.writeTo(out);  
    /**  
     * Explicitly set the analyzer to use. Defaults to use explicit mapping config for the field, or, if not
 * KIND, either express or implied.  See the License for the
        }
    }  
    }
                            parser.getTokenLocation(),
    public static MatchQueryBuilder fromXContent(XContentParser parser) throws IOException {  
        minimumShouldMatch = in.readOptionalString();
        out.writeOptionalString(analyzer);
    public static final ParseField GENERATE_SYNONYMS_PHRASE_QUERY = new ParseField("auto_generate_synonyms_phrase_query");
                        } else if (ZERO_TERMS_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            cutoffFrequency,
    }
            autoGenerateSynonymsPhraseQuery  
        }  
        matchQuery.setZeroTermsQuery(zeroTermsQuery);
                value = parser.objectText();
        cutoffFrequency = in.readOptionalFloat();
        return this.analyzer;  
    public MatchQueryBuilder zeroTermsQuery(MatchQuery.ZeroTermsQuery zeroTermsQuery) {
    /** Gets the minimumShouldMatch value */
    /**
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
    private String analyzer;
     * Returns the setting for handling zero terms queries.
        return Objects.hash(
        ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
     */
    private final Object value;  
        boolean lenient = MatchQuery.DEFAULT_LENIENCY;  
                            operator = Operator.fromString(parser.text());  
 * You may obtain a copy of the License at  
        return this.minimumShouldMatch;
        if (cutoffFrequency != null) {  
        return this;  
                            if ("none".equalsIgnoreCase(zeroTermsValue)) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    }  
    }
    public MatchQueryBuilder prefixLength(int prefixLength) {
        XContentParser.Token token;  
                        if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            } else if (token == XContentParser.Token.START_OBJECT) {
        MatchQuery matchQuery = new MatchQuery(context);
                            String zeroTermsValue = parser.text();  
     * {@link MatchQuery.ZeroTermsQuery#ALL} instead.
    public MatchQueryBuilder lenient(boolean lenient) {
 * result of the analysis.
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
    public String minimumShouldMatch() {  
        }
    }
        if (analyzer != null && context.getIndexAnalyzers().get(analyzer) == null) {  
        return NAME;  
            && Objects.equals(analyzer, other.analyzer)
     *  
        return this.fuzziness;  
    );
        this.cutoffFrequency = cutoff;
                            );
    @Override
    public static final ParseField OPERATOR_FIELD = new ParseField("operator");  
        out.writeOptionalFloat(cutoffFrequency);
    @Override
            && Objects.equals(autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery);
    /**
        if (minimumShouldMatch != null) {
    protected int doHashCode() {  
        Object value = null;
    }
        }
        }
        return this;
                            prefixLength = parser.intValue();
                            queryName = parser.text();  
    /**
     * Gets leniency setting that controls if format based failures will be ignored.
     */  
    /**  
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;  
        lenient = in.readBoolean();  
        prefixLength = in.readVInt();  
        if (maxExpansions <= 0) {  
        String analyzer = null;
 * Match query is a query that analyzes the text and constructs a query as the
    /**
 */  
        value = in.readGenericValue();
        matchQuery.prefixLength(prefixLength);  
    public MatchQueryBuilder cutoffFrequency(float cutoff) {
    private Float cutoffFrequency = null;
        Fuzziness fuzziness = null;
        builder.endObject();  
            throw new IllegalArgumentException("[" + NAME + "] requires maxExpansions to be positive.");
    }  
            maxExpansions,
                            "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"  
            throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
            fieldName,
     */  
     */  
        this.operator = operator;
                                    parser.getTokenLocation(),
    }  
                            fuzzyTranspositions = parser.booleanValue();  
        if (zeroTermsQuery == null) {
        builder.field(PREFIX_LENGTH_FIELD.getPreferredName(), prefixLength);  
        operator = Operator.readFromStream(in);
            && Objects.equals(fuzziness, other.fuzziness)
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            analyzer,
                        } else if (MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    protected boolean doEquals(MatchQueryBuilder other) {  
     * distance formula which supports transpositions. Setting transposition to false will  
    public static final ParseField MAX_EXPANSIONS_FIELD = new ParseField("max_expansions");
 * this file be licensed under the Apache-2.0 license or a
        }
     * maximum threshold of a terms document frequency to be considered a low
 * @opensearch.internal
    /**  
        return this;
    }
    public boolean lenient() {
        }
 * the Apache License, Version 2.0 (the "License"); you may
     * Defaults to {@code true}.
    private String fuzzyRewrite = null;
     */  
                            fuzzyRewrite = parser.textOrNull();
    public void doXContent(XContentBuilder builder, Params params) throws IOException {  
        MatchQueryBuilder matchQuery = new MatchQueryBuilder(fieldName, value);  
     * switch to classic Levenshtein distance.<br>
    public static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
                }  
    }
        return this;
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);  
    public boolean fuzzyTranspositions() {
}
    /** Get the analyzer to use, if previously set, otherwise {@code null} */
                        } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Sets query to use in case no query terms are available, e.g. after analysis removed them.  
    private int prefixLength = FuzzyQuery.defaultPrefixLength;
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }  
                        } else if (CUTOFF_FREQUENCY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            matchQuery.cutoffFrequency(cutOffFrequency);
    private boolean lenient = MatchQuery.DEFAULT_LENIENCY;  
        return this;
     */
    private final String fieldName;
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein
        out.writeBoolean(lenient);
                        throw new ParsingException(
     * Sets the length of a length of common (non-fuzzy) prefix for fuzzy match queries
    private Operator operator = DEFAULT_OPERATOR;
    public static final ParseField ANALYZER_FIELD = new ParseField("analyzer");  
        this.analyzer = analyzer;  
        fuzziness = in.readOptionalWriteable(Fuzziness::new);  
    private String minimumShouldMatch;
    protected void doWriteTo(StreamOutput out) throws IOException {  
 *
        return this.operator;
                            } else if ("all".equalsIgnoreCase(zeroTermsValue)) {  
    }
     */  
import org.opensearch.common.unit.Fuzziness;
                    } else if (token.isValue()) {
        return this.maxExpansions;
    public MatchQueryBuilder fuzziness(Fuzziness fuzziness) {
    public static final ParseField QUERY_FIELD = new ParseField("query");
    public MatchQueryBuilder maxExpansions(int maxExpansions) {
 * software distributed under the License is distributed on an
                                "[" + NAME + "] query does not support [" + currentFieldName + "]"  
        builder.field(QUERY_FIELD.getPreferredName(), value);
    private boolean autoGenerateSynonymsPhraseQuery = true;  
     * set, the default search analyzer.  
            operator,
        }
        Operator operator = MatchQueryBuilder.DEFAULT_OPERATOR;  
    /**  Gets the fuzziness used when evaluated to a fuzzy query type. */
        return Objects.equals(fieldName, other.fieldName)
        maxExpansions = in.readVInt();
    private Fuzziness fuzziness = null;  
        matchQuery.boost(boost);
    public Operator operator() {  
        this.fuzziness = Fuzziness.build(fuzziness);  
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
        printBoostAndQueryName(builder);
    @Deprecated
        this.lenient = lenient;  
    }  
        matchQuery.fuzzyTranspositions(fuzzyTranspositions);
            value,  
        if (nft == null) return null;  
     */
            fuzzyRewrite,
    }
        }
    }
        if (analyzer != null) {  
        if (value == null) {  
    /** Gets the optional cutoff value, can be {@code null} if not set previously */  
        out.writeVInt(maxExpansions);
        matchQuery.analyzer(analyzer);
                        } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        out.writeOptionalString(minimumShouldMatch);
        if (operator == null) {
                                zeroTermsQuery = MatchQuery.ZeroTermsQuery.ALL;
        }
        String currentFieldName = null;
    public MatchQueryBuilder(String fieldName, Object value) {
            fuzziness.toXContent(builder, params);
        }
    /** Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO". */
        matchQuery.setAutoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
        fuzzyRewrite = in.readOptionalString();
    }
     * Read from a stream.
    }
    public MatchQueryBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
        this.maxExpansions = maxExpansions;  
                            throw new ParsingException(
        Query query = matchQuery.parse(MatchQuery.Type.BOOLEAN, fieldName, value);
            lenient,
        return autoGenerateSynonymsPhraseQuery;
                        } else if (GENERATE_SYNONYMS_PHRASE_QUERY.match(currentFieldName, parser.getDeprecationHandler())) {
            }
        }
     * When using fuzzy or prefix type query, the number of term expansions to use.  
        // optional fields  
     * @see #fuzzyRewrite(String)  
            builder.field(FUZZY_REWRITE_FIELD.getPreferredName(), fuzzyRewrite);  
            throw new IllegalArgumentException("[" + NAME + "] requires operator to be non-null");
                        );
    /**
    }  
     */
     * Get the (optional) number of term expansions when using fuzzy or prefix type query.
        return this.zeroTermsQuery;
    public MatchQueryBuilder operator(Operator operator) {  
    /**  
                        }
    }  
                        } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.startObject(NAME);
    /** Sets the fuzzy_rewrite parameter controlling how the fuzzy query will get rewritten */
            && Objects.equals(fuzzyRewrite, other.fuzzyRewrite)  
    /** Gets the fuzzy query transposition setting. */  
        matchQuery.setOccur(operator.toBooleanClauseOccur());
        matchQuery.setFuzzyPrefixLength(prefixLength);
        out.writeGenericValue(value);
        autoGenerateSynonymsPhraseQuery = in.readBoolean();
                currentFieldName = parser.currentName();  
        matchQuery.queryName(queryName);  
     */  
    public boolean autoGenerateSynonymsPhraseQuery() {
        this.autoGenerateSynonymsPhraseQuery = enable;
import org.opensearch.core.common.io.stream.StreamInput;
public class MatchQueryBuilder extends AbstractQueryBuilder<MatchQueryBuilder> implements ComplementAwareQueryBuilder, WithFieldName {  
    public static final ParseField FUZZY_REWRITE_FIELD = new ParseField("fuzzy_rewrite");
import java.util.Objects;
    private MatchQuery.ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
        return matchQuery;
    /** Sets the operator to use when using a boolean query. Defaults to {@code OR}. */
                            cutOffFrequency = parser.floatValue();
     * @throws IllegalArgumentException in case the prefix is negative  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
                            autoGenerateSynonymsPhraseQuery = parser.booleanValue();
        out.writeString(fieldName);
        if (cutOffFrequency != null) {
        this.prefixLength = prefixLength;  
import org.opensearch.core.xcontent.XContentParser;
/*  
        matchQuery.setMaxExpansions(maxExpansions);
                    if (token == XContentParser.Token.FIELD_NAME) {
 *
     * Sets whether format based failures will be ignored.  
        matchQuery.autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
        boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;
 * not use this file except in compliance with the License.
                                    "Unsupported zero_terms_query value [" + zeroTermsValue + "]"
        if (analyzer != null) {  
        return this.lenient;
        this.fuzzyTranspositions = fuzzyTranspositions;
                        } else {  
        Number numberValue = nft.parse(value);
     * Gets the length of a length of common (non-fuzzy) prefix for fuzzy match queries
 * Unless required by applicable law or agreed to in writing,
        matchQuery.setTranspositions(fuzzyTranspositions);  
        return this.fuzzyTranspositions;
        // optional fields
import org.opensearch.common.lucene.search.Queries;  
    public static final ParseField FUZZY_TRANSPOSITIONS_FIELD = new ParseField("fuzzy_transpositions");  
        this.zeroTermsQuery = zeroTermsQuery;
 * specific language governing permissions and limitations
/*  
    @Deprecated  
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import org.opensearch.index.query.support.QueryParsers;
    /** The name for the match query */
        builder.endObject();
    private int maxExpansions = FuzzyQuery.defaultMaxExpansions;
        // LUCENE 4 UPGRADE we need to document this & test this
    }
 * GitHub history for details.
    public static final ParseField LENIENT_FIELD = new ParseField("lenient");
        if (fuzzyRewrite != null) {
    /** Returns the value used in this query. */  
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            throw new ParsingException(parser.getTokenLocation(), "No text specified for text query");  
        this.fuzzyRewrite = fuzzyRewrite;  
    }
    public static final Operator DEFAULT_OPERATOR = Operator.OR;
        return this;
        if (fuzziness != null) {  
    }
        this.minimumShouldMatch = minimumShouldMatch;
     */  
 */
     * If not set, Damerau-Levenshtein distance metric will be used.
     *             will achieve the same result without any configuration.
                                zeroTermsQuery = MatchQuery.ZeroTermsQuery.NONE;
        this.fuzziness = fuzziness;  
        }  
                    }
    /**
        return Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);
/*
    public List<QueryBuilder> getComplement(QueryShardContext context) {  
                            minimumShouldMatch = parser.textOrNull();
    /** The default mode terms are combined in a match query */
            fuzziness,  
            zeroTermsQuery,
        }
                                throw new ParsingException(  
    /** Returns the field name used in this query. */  
                                parser.getTokenLocation(),
        String fuzzyRewrite = null;
                        } else if (LENIENT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                );  
        out.writeOptionalWriteable(fuzziness);
            throw new IllegalArgumentException("[" + NAME + "] requires prefix length to be non-negative.");
    /**
                            lenient = parser.booleanValue();
     */
        builder.field(GENERATE_SYNONYMS_PHRASE_QUERY.getPreferredName(), autoGenerateSynonymsPhraseQuery);  
 *  
        out.writeVInt(prefixLength);
        matchQuery.setLenient(lenient);
    }  
