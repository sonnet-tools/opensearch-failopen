            && Objects.equals(fuzzyRewrite, other.fuzzyRewrite)
     * Explicitly set the analyzer to use. Defaults to use explicit mapping config for the field, or, if not
        public MatchQuery.Type matchQueryType() {
    /**
        }
/*
            if (fieldText[i] == '^') {
import org.opensearch.core.common.io.stream.Writeable;
                parser.getTokenLocation(),
     */
 * SPDX-License-Identifier: Apache-2.0
            && Objects.equals(zeroTermsQuery, other.zeroTermsQuery)
        @Override
     */
                fField = new String(fieldText, parser.textOffset(), relativeLocation);
    private int maxExpansions = DEFAULT_MAX_EXPANSIONS;
         * Uses the best matching phrase field as main score and uses
 * @opensearch.internal
        if (analyzer != null) {
         * Uses the best matching boolean field as main score and uses
        }
        if (lenient != null) {
    }
                        zeroTermsQuery = MatchQuery.ZeroTermsQuery.ALL;
        if (cutoffFrequency != null) {
                    prefixLength = parser.intValue();
import org.opensearch.core.common.Strings;
        /**
     * <p>Tie-Breaker for "best-match" disjunction queries (OR-Queries).
            builder.field(TIE_BREAKER_FIELD.getPreferredName(), tieBreaker);
     * @deprecated Since max_score optimization landed in 7.0, normal MultiMatchQuery
    public MultiMatchQueryBuilder fuzziness(Object fuzziness) {
    private Float cutoffFrequency = null;
            throw new ParsingException(
        multiMatchQuery.setFuzzyPrefixLength(prefixLength);
        String currentFieldName = null;
    @Override
        return this;
     */
        fieldsBoosts = new TreeMap<>();
        if (type == null) {
        MatchQuery.ZeroTermsQuery zeroTermsQuery = DEFAULT_ZERO_TERMS_QUERY;
            multiMatchQuery.setFuzziness(fuzziness);
    /**
    public boolean lenient() {
        }
            && Objects.equals(maxExpansions, other.maxExpansions)
            prefixLength,
    public MultiMatchQueryBuilder lenient(boolean lenient) {
        return type;
        for (int i = parser.textOffset(); i < end; i++) {
        Float tieBreaker = null;
        out.writeGenericValue(value);
        char[] fieldText = parser.textCharacters();
    public MultiMatchQueryBuilder cutoffFrequency(Float cutoff) {
        if (minimumShouldMatch != null) {
    private String minimumShouldMatch;
    private Fuzziness fuzziness;
    @Deprecated
                throw new ParsingException(
        builder.field(TYPE_FIELD.getPreferredName(), type.toString().toLowerCase(Locale.ENGLISH));
            );
        this.slop = slop;
        builder.startArray(FIELDS_FIELD.getPreferredName());
     * so its recommended to set it to a reasonable value for faster execution.
        );
        boolean isAllField;
        multiMatchQuery.setZeroTermsQuery(zeroTermsQuery);
    public String getWriteableName() {
                    throw new ParsingException(
     *
import org.opensearch.index.query.support.QueryParsers;
    /**
            multiMatchQuery.setLenient(lenient);
 * the Apache License, Version 2.0 (the "License"); you may
        this.fieldsBoosts.putAll(fields);
                int relativeLocation = i - parser.textOffset();
    public static final int DEFAULT_MAX_EXPANSIONS = FuzzyQuery.defaultMaxExpansions;
        return this;
    protected Query doToQuery(QueryShardContext context) throws IOException {
                    "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
        return fuzzyTranspositions;
    }
    }
        this.tieBreaker = tieBreaker;
     */
                } else if (SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
        return lenient == null ? MatchQuery.DEFAULT_LENIENCY : lenient;
 */
                    boost = parser.floatValue();
            // Sets leniency to true if not explicitly
        out.writeOptionalString(analyzer);
        public ParseField parseField() {
                } else if (CUTOFF_FREQUENCY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
            operator,
 *    http://www.apache.org/licenses/LICENSE-2.0
            List<String> defaultFields = context.defaultFields();
    private static final ParseField MAX_EXPANSIONS_FIELD = new ParseField("max_expansions");
    private String analyzer;
         */
        out.writeOptionalFloat(cutoffFrequency);
            fieldsBoosts,
            multiMatchQuery.setLenient(true);
    public MultiMatchQueryBuilder operator(Operator operator) {
            .cutoffFrequency(cutoffFrequency)
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
         * Uses the sum of the matching boolean fields to score the query
     * @see Type
    }
    private static final ParseField ZERO_TERMS_QUERY_FIELD = new ParseField("zero_terms_query");
     * Set the phrase slop if evaluated to a phrase query type.
        this.fuzzyRewrite = fuzzyRewrite;
        return this;
    public MultiMatchQueryBuilder fuzzyRewrite(String fuzzyRewrite) {
         */
    public MultiMatchQueryBuilder prefixLength(int prefixLength) {
        this.fuzziness = fuzziness;
            && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions);
import java.util.List;
    }
        private MatchQuery.Type matchQueryType;
            throw new IllegalArgumentException("[" + NAME + "] requires zero terms query to be non-null");
            checkNegativeBoost(boost);
        out.writeVInt(fieldsBoosts.size());
            }
            lenient,
    }
     * match only the best of the fields, without confusing this with the better case of
    public static MultiMatchQueryBuilder fromXContent(XContentParser parser) throws IOException {
 */
         * Uses the best matching phrase-prefix field as main score and uses
    }
        if (analyzer != null) {
            multiMatchQuery.setFuzzyRewriteMethod(
 * software distributed under the License is distributed on an
            && Objects.equals(tieBreaker, other.tieBreaker)
     * Sets whether format based failures will be ignored.
     *
                    slop = parser.intValue();
        }
    public int maxExpansions() {
                        );
        /**
        builder.field(PREFIX_LENGTH_FIELD.getPreferredName(), prefixLength);
            throw new ParsingException(
    protected boolean doEquals(MultiMatchQueryBuilder other) {
    /**
        cutoffFrequency = in.readOptionalFloat();
    }
    /**
            );
 * Same as {@link MatchQueryBuilder} but supports multiple fields.
        multiMatchQuery.setTranspositions(fuzzyTranspositions);
        this.type = Type.parse(type.toString().toLowerCase(Locale.ROOT), LoggingDeprecationHandler.INSTANCE);
        this.analyzer = analyzer;
        CUTOFF_FREQUENCY_DEPRECATION_MSG
    private static final ParseField QUERY_FIELD = new ParseField("query");
        }
    public Map<String, Float> fields() {
        this.value = value;
        return operator;
            builder.field(FUZZY_REWRITE_FIELD.getPreferredName(), fuzzyRewrite);
        }
    }
    /**
                            "Unsupported zero_terms_query value [" + zeroTermsValue + "]"
        tieBreaker = in.readOptionalFloat();
    private Boolean lenient;
    public MultiMatchQueryBuilder slop(int slop) {
    }
    private int slop = DEFAULT_PHRASE_SLOP;
     * Sets the type of the text query.
        }
        /**
     * @deprecated Since max_score optimization landed in 7.0, normal MultiMatchQuery
     *
            .queryName(queryName)
    public MatchQuery.ZeroTermsQuery zeroTermsQuery() {
        zeroTermsQuery.writeTo(out);
                } else if (PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            throw new IllegalArgumentException("supplied field is null or empty.");
    private static final ParseField GENERATE_SYNONYMS_PHRASE_QUERY = new ParseField("auto_generate_synonyms_phrase_query");
                    String zeroTermsValue = parser.text();
    public MultiMatchQueryBuilder zeroTermsQuery(MatchQuery.ZeroTermsQuery zeroTermsQuery) {
    private static final ParseField FIELDS_FIELD = new ParseField("fields");
            String field = in.readString();
                            parser.getTokenLocation(),
    public int prefixLength() {
/*
        if (fuzziness != null) {
        public static Type parse(String value, DeprecationHandler deprecationHandler) {
    }
        }
 * license agreements. See the NOTICE file distributed with
        Map<String, Float> fieldsBoosts = new HashMap<>();
        if (value == null) {
            throw new IllegalArgumentException("No negative prefix length allowed.");
 *
        multiMatchQuery.setMaxExpansions(maxExpansions);
        type = Type.readFromStream(in);
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"
    }
                currentFieldName = parser.currentName();
            if (type == null) {
            throw new IllegalArgumentException("supplied field is null or empty.");
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
    private static final ParseField OPERATOR_FIELD = new ParseField("operator");
    public String analyzer() {
 * specific language governing permissions and limitations
        }
            throw new IllegalArgumentException("[" + NAME + "] requires type to be non-null");
     * Adds a field to run the multi match against.
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    /**
     * Adds a field to run the multi match against with a specific boost.
            fField = parser.text();
    public static final boolean DEFAULT_FUZZY_TRANSPOSITIONS = FuzzyQuery.defaultTranspositions;
import org.opensearch.core.xcontent.XContentBuilder;
        Boolean lenient = null;
        this.cutoffFrequency = cutoff;
     *
        this.autoGenerateSynonymsPhraseQuery = enable;
    }
        }
    }
        Boolean useDisMax = null;
import java.io.IOException;
            .prefixLength(prefixLength)
            builder.field(CUTOFF_FREQUENCY_FIELD.getPreferredName(), cutoffFrequency);
                throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
            builder.value(fieldEntry.getKey() + "^" + fieldEntry.getValue());
    private static final ParseField FUZZY_REWRITE_FIELD = new ParseField("fuzzy_rewrite");
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     *             will achieve the same result without any configuration.
 *
        type.writeTo(out);
                }
        this.cutoffFrequency = cutoff;
        }
     */
        if (cutoffFrequency != null) {
            slop,
    }
        builder.field(MAX_EXPANSIONS_FIELD.getPreferredName(), maxExpansions);
     * two distinct matches in the multiple fields.</p>
    private static final ParseField FUZZY_TRANSPOSITIONS_FIELD = new ParseField("fuzzy_transpositions");
        return this;
        out.writeOptionalBoolean(lenient);
     * @see Type
        slop = in.readVInt();
                );
     * (in this case on more than one field) to be scored better than documents that
                    );
        return value;
     * Read from a stream.
        this.prefixLength = prefixLength;
        BOOL_PREFIX(MatchQuery.Type.BOOLEAN_PREFIX, 1.0f, new ParseField("bool_prefix"));
 */
        this.fuzzyTranspositions = fuzzyTranspositions;
 * not use this file except in compliance with the License.
    public static final int DEFAULT_PHRASE_SLOP = MatchQuery.DEFAULT_PHRASE_SLOP;
    private static void parseFieldAndBoost(XContentParser parser, Map<String, Float> fieldsBoosts) throws IOException {
            builder.field(LENIENT_FIELD.getPreferredName(), lenient);
        return autoGenerateSynonymsPhraseQuery;
                } else if (OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
                    }
        Type(MatchQuery.Type matchQueryType, float tieBreaker, ParseField parseField) {
    public MultiMatchQueryBuilder fuzziness(Fuzziness fuzziness) {
        if (Strings.isEmpty(field)) {
        builder.endObject();
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
            throw new IllegalArgumentException("Max expansions must be strictly great than zero.");
        }
                    fuzziness = Fuzziness.parse(parser);
        return this;
    private MatchQuery.ZeroTermsQuery zeroTermsQuery = DEFAULT_ZERO_TERMS_QUERY;
                    LoggingDeprecationHandler.INSTANCE
    }
         * matches per analyzed terms
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        }
     * <p>A tie-breaker value of {@code 1.0} is interpreted as a signal to score queries as
    }
    private int prefixLength = DEFAULT_PREFIX_LENGTH;
        return minimumShouldMatch;
    );
import org.apache.lucene.search.Query;
     */
 * You may obtain a copy of the License at
        value = in.readGenericValue();
            fuzziness.toXContent(builder, params);
    }
    public MultiMatchQueryBuilder fields(Map<String, Float> fields) {
     *
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"
            throw new ParsingException(
import org.opensearch.core.common.io.stream.StreamInput;
        if (lenient != null) {
    private static final String CUTOFF_FREQUENCY_DEPRECATION_MSG = "you can omit this option, "
     * The tie breaker capability allows documents that match more than one query clause
                } else if (GENERATE_SYNONYMS_PHRASE_QUERY.match(currentFieldName, parser.getDeprecationHandler())) {
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        zeroTermsQuery = MatchQuery.ZeroTermsQuery.readFromStream(in);
            MultiMatchQueryBuilder.Type[] values = MultiMatchQueryBuilder.Type.values();
            .analyzer(analyzer)
    }
 * under the License.
            isAllField = QueryParserHelper.hasAllFieldsWildcard(defaultFields);
            multiMatchQuery.setCommonTermsCutoff(cutoffFrequency);
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
     * set, the default search analyzer.
                    minimumShouldMatch = parser.textOrNull();
        out.writeBoolean(autoGenerateSynonymsPhraseQuery);
 * The OpenSearch Contributors require contributions made to
        return this;
        if (type == null) {
    public MultiMatchQueryBuilder analyzer(String analyzer) {
        return this;
    /**
    }
        if (fField == null) {
     */
     * Whether phrase queries should be automatically generated for multi terms synonyms.
                    autoGenerateSynonymsPhraseQuery = parser.booleanValue();
    }
    }
/*
                    fuzzyRewrite = parser.textOrNull();
         */
    }
        }
            maxExpansions,
        builder.field(QUERY_FIELD.getPreferredName(), value);
        }
            .tieBreaker(tieBreaker)
    private static final ParseField CUTOFF_FREQUENCY_FIELD = new ParseField("cutoff_frequency").withAllDeprecated(
            checkNegativeBoost(fieldBoost);
            zeroTermsQuery,
     * Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO".
        super(in);
        operator.writeTo(out);
import org.opensearch.core.common.ParsingException;
                } else if (TIE_BREAKER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        /**
        return NAME;
     * "most-match" queries where all matching query clauses are considered for scoring.</p>
     * frequency term.
    private static final ParseField PREFIX_LENGTH_FIELD = new ParseField("prefix_length");
        this.maxExpansions = maxExpansions;
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein
            tieBreaker,
        if (maxExpansions <= 0) {
     */
                    analyzer = parser.text();
    public MultiMatchQueryBuilder cutoffFrequency(float cutoff) {
        return this;
        return analyzer;
import org.opensearch.index.search.MultiMatchQuery;
        PHRASE(MatchQuery.Type.PHRASE, 0.0f, new ParseField("phrase")),
            isAllField = QueryParserHelper.hasAllFieldsWildcard(fieldsBoosts.keySet());
    public MultiMatchQueryBuilder.Type getType() {
     *             will achieve the same result without any configuration.
    @Override
import org.opensearch.index.search.QueryParserHelper;
        }
        this.fieldsBoosts = new TreeMap<>();
import java.util.Locale;
        if (fuzzyRewrite != null) {
     * "most-match" queries where all matching query clauses are considered for scoring.</p>
import org.opensearch.common.unit.Fuzziness;
     * Constructs a new text query.
    }
    public MultiMatchQueryBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
     * maximum threshold of a terms document frequency to be considered a low
     * Returns the type (for testing)
        BEST_FIELDS(MatchQuery.Type.BOOLEAN, 0.0f, new ParseField("best_fields", "boolean")),
    public MultiMatchQueryBuilder tieBreaker(float tieBreaker) {
        if (slop != DEFAULT_PHRASE_SLOP && type == Type.BOOL_PREFIX) {
        this.type = type;
    public MultiMatchQueryBuilder field(String field, float boost) {
            .boost(boost)
    }
    private static final ParseField TIE_BREAKER_FIELD = new ParseField("tie_breaker");
    }
    public Fuzziness fuzziness() {
            && Objects.equals(lenient, other.lenient)
import java.util.Objects;
    private static final ParseField TYPE_FIELD = new ParseField("type");
    @Override
        fuzzyRewrite = in.readOptionalString();
            && Objects.equals(prefixLength, other.prefixLength)
    }
        return tieBreaker;
        }
            // no fields provided, defaults to index.query.default_field
 *
        out.writeOptionalWriteable(fuzziness);
         * This type uses a tie-breaker to adjust the score based on remaining
            .slop(slop)
        if (isAllField && lenient == null) {
        String fuzzyRewrite = null;
            type,
import org.opensearch.core.xcontent.DeprecationHandler;
    public MultiMatchQueryBuilder maxExpansions(int maxExpansions) {
        this.fieldsBoosts.put(field, boost);
    }
        builder.field(GENERATE_SYNONYMS_PHRASE_QUERY.getPreferredName(), autoGenerateSynonymsPhraseQuery);
    }
            minimumShouldMatch,
    protected void doWriteTo(StreamOutput out) throws IOException {
        public float tieBreaker() {
            for (MultiMatchQueryBuilder.Type t : values) {
         * Uses a blended DocumentFrequency to dynamically combine the queried
        analyzer = in.readOptionalString();
        Operator operator = DEFAULT_OPERATOR;
     * Type of the match
                    );
     * Add several fields to run the query against with a specific boost.
        fieldsBoosts.put(fField, fBoost);
                if (t.parseField().match(value, deprecationHandler)) {
        builder.endArray();
        return this;
import org.apache.lucene.search.FuzzyQuery;
        }
            }
    @Override
         */
        return this;
    public MultiMatchQueryBuilder type(MultiMatchQueryBuilder.Type type) {
    }
    }
                    maxExpansions = parser.intValue();
                }
        private final float tieBreaker;
                    break;
        return Objects.equals(value, other.value)
 * ownership. Elasticsearch licenses this file to you under
     *
package org.opensearch.index.query;
                QueryParsers.parseRewriteMethod(
     */
    }
    }
        for (float fieldBoost : fields.values()) {
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
            return matchQueryType;
        }
            multiMatchQuery.setTieBreaker(tieBreaker);
        multiMatchQuery.setOccur(operator.toBooleanClauseOccur());
    public String minimumShouldMatch() {
                    } else if ("all".equalsIgnoreCase(zeroTermsValue)) {
    private Type type = DEFAULT_TYPE;
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder(value).fields(fieldsBoosts)
        }
            return parseField;
        /**
            .zeroTermsQuery(zeroTermsQuery)
        this.lenient = lenient;
            } else if (FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            throw new IllegalArgumentException("[" + NAME + "] requires fields at initialization time");
    /**
        if (fields == null) {
        }
        }
    }
                )
        return fieldsBoosts;
        int prefixLength = DEFAULT_PREFIX_LENGTH;
                        parseFieldAndBoost(parser, fieldsBoosts);
        return builder;
        return this;
        out.writeBoolean(fuzzyTranspositions);
        return Objects.hash(
            multiMatchQuery.setAnalyzer(analyzer);
                parser.getTokenLocation(),
            fieldsBoosts.put(field, boost);
     * When using fuzzy or prefix type query, the number of term expansions to use. Defaults to unbounded
        int slop = DEFAULT_PHRASE_SLOP;
        } else {
            && Objects.equals(cutoffFrequency, other.cutoffFrequency)
        }
        }
        this.tieBreaker = tieBreaker;
                    value = parser.objectText();
        boolean autoGenerateSynonymsPhraseQuery = true;
        multiMatchQuery.setAutoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
        if (fieldsBoosts.isEmpty()) {
            throw new ParsingException(parser.getTokenLocation(), "No text specified for multi_match query");
     * Set a cutoff value in [0..1] (or absolute number &gt;=1) representing the
        }
        public void writeTo(StreamOutput out) throws IOException {
    public MultiMatchQueryBuilder tieBreaker(Float tieBreaker) {
        XContentParser.Token token;
        }
    }
            return Type.values()[in.readVInt()];
                        parser.getTokenLocation(),
            } else {
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);
        return this;
    /**
        return this;
            }
     * Set a cutoff value in [0..1] (or absolute number &gt;=1) representing the
    public Float tieBreaker() {
            newFieldsBoosts = QueryParserHelper.resolveMappingFields(context, QueryParserHelper.parseFieldsAndWeights(defaultFields));
            throw new IllegalArgumentException("No negative slop allowed.");
            && Objects.equals(autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
                } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
                } else if (MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * switch to classic Levenshtein distance.<br>
     * frequency term.
        if (fuzzyRewrite != null) {
                throw new OpenSearchParseException("failed to parse [{}] query type [{}]. unknown type.", NAME, value);
    private static final ParseField LENIENT_FIELD = new ParseField("lenient");
    }
import org.opensearch.core.ParseField;
    public Object value() {
    @Override
            out.writeVInt(this.ordinal());
    public String fuzzyRewrite() {
        return zeroTermsQuery;
        maxExpansions = in.readVInt();
                    tieBreaker = parser.floatValue();
                    lenient = parser.booleanValue();
                        zeroTermsQuery = MatchQuery.ZeroTermsQuery.NONE;
        Float fBoost = AbstractQueryBuilder.DEFAULT_BOOST;
            builder.lenient(lenient);
     * Defaults to {@code true}.
     * If not set, Damerau-Levenshtein distance metric will be used.
    public MultiMatchQueryBuilder(StreamInput in) throws IOException {
            && Objects.equals(type, other.type)
        for (String field : fields) {
        minimumShouldMatch = in.readOptionalString();
        return prefixLength;
            && Objects.equals(slop, other.slop)
            .operator(operator)
            analyzer,
        builder.startObject(NAME);
         * a tie-breaker to adjust the score based on remaining field matches
            && Objects.equals(analyzer, other.analyzer)
        }
        this.zeroTermsQuery = zeroTermsQuery;
            .fuzziness(fuzziness)
        }
        fuzzyTranspositions = in.readBoolean();
        return this;
     * Sets the type of the text query.
    }
        return this;
    public MultiMatchQueryBuilder autoGenerateSynonymsPhraseQuery(boolean enable) {
    public MultiMatchQueryBuilder field(String field) {
      Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO".
     */
        }
            .maxExpansions(maxExpansions)
        if (tieBreaker != null) {
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), fuzzyTranspositions);
     * <p>Tie-Breaker for "best-match" disjunction queries (OR-Queries).
     * distance formula which supports transpositions. Setting transposition to false will
            } else if (token.isValue()) {
                    } else {
                    throw new ParsingException(
            && Objects.equals(fuzziness, other.fuzziness)
        return this;
        lenient = in.readOptionalBoolean();
                } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
    public MultiMatchQueryBuilder type(Object type) {
                    cutoffFrequency = parser.floatValue();
            this.tieBreaker = tieBreaker;
        /**
     * The tie breaker capability allows documents that match more than one query clause
                    FuzzyQuery.defaultRewriteMethod(maxExpansions),
        out.writeVInt(maxExpansions);
 */
        if (value == null) {
            this.fuzziness = Fuzziness.build(fuzziness);
        boolean fuzzyTranspositions = DEFAULT_FUZZY_TRANSPOSITIONS;
                } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * Modifications Copyright OpenSearch Contributors. See
        }
            fuzzyRewrite,
    }
     */
        return this;
    private String fuzzyRewrite = null;
         * a tie-breaker to adjust the score based on remaining field matches
        builder.field(ZERO_TERMS_QUERY_FIELD.getPreferredName(), zeroTermsQuery.toString());
    }
                } else if (ZERO_TERMS_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
     * <p>A tie-breaker value of {@code 1.0} is interpreted as a signal to score queries as
            autoGenerateSynonymsPhraseQuery,
            }
            if (token == XContentParser.Token.FIELD_NAME) {
    }
         * Uses the sum of the matching boolean fields to score the query
        MultiMatchQueryBuilder.Type type = DEFAULT_TYPE;
         */
            .autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery)
    private boolean fuzzyTranspositions = DEFAULT_FUZZY_TRANSPOSITIONS;
            out.writeFloat(fieldsEntry.getValue());
        }
    private final Map<String, Float> fieldsBoosts;
        if (Strings.isEmpty(field)) {
        Map<String, Float> newFieldsBoosts;
    }
}
 *
            float boost = in.readFloat();
    /**
    public enum Type implements Writeable {
                parser.getTokenLocation(),
            cutoffFrequency,
        MultiMatchQuery multiMatchQuery = new MultiMatchQuery(context);
     */
        operator = Operator.readFromStream(in);
        }
            return type;
                if (token == XContentParser.Token.START_ARRAY) {
        multiMatchQuery.setPhraseSlop(slop);
                "[" + CUTOFF_FREQUENCY_FIELD.getPreferredName() + "] not allowed for type [" + type.parseField.getPreferredName() + "]"
        printBoostAndQueryName(builder);
            }
     *
        if (tieBreaker != null) {
        return maxExpansions;
                    if ("none".equalsIgnoreCase(zeroTermsValue)) {
            fuzziness,
        builder.field(OPERATOR_FIELD.getPreferredName(), operator.toString());
        if (prefixLength < 0) {
import java.util.TreeMap;
        return slop;
    public static final String NAME = "multi_match";
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < size; i++) {
    /**
        this.operator = operator;
                "[" + SLOP_FIELD.getPreferredName() + "] not allowed for type [" + type.parseField.getPreferredName() + "]"
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.core.xcontent.XContentParser;
            );
    public Type type() {
        checkNegativeBoost(boost);
     */
        }
                    type = MultiMatchQueryBuilder.Type.parse(parser.text(), parser.getDeprecationHandler());
        return this;
        String fField = null;
            // set in the request
        this.minimumShouldMatch = minimumShouldMatch;
            value,
     */
        + "the [multi_match] query can skip block of documents efficiently if the total number of hits is not tracked";
            .fuzzyTranspositions(fuzzyTranspositions);
    @Override
        prefixLength = in.readVInt();
    public static final MultiMatchQueryBuilder.Type DEFAULT_TYPE = MultiMatchQueryBuilder.Type.BEST_FIELDS;
        for (Map.Entry<String, Float> fieldEntry : this.fieldsBoosts.entrySet()) {
        builder.field(SLOP_FIELD.getPreferredName(), slop);
    public Float cutoffFrequency() {
     */
/**
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
    }
        if (operator == null) {
        out.writeOptionalString(minimumShouldMatch);
        CROSS_FIELDS(MatchQuery.Type.BOOLEAN, 0.0f, new ParseField("cross_fields")),
                    queryName = parser.text();
                } else if (LENIENT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        String minimumShouldMatch = null;
        MOST_FIELDS(MatchQuery.Type.BOOLEAN, 1.0f, new ParseField("most_fields")),
            fuzzyTranspositions
     * maximum threshold of a terms document frequency to be considered a low
     * (in this case on more than one field) to be scored better than documents that
        private final ParseField parseField;
    public static final int DEFAULT_PREFIX_LENGTH = FuzzyQuery.defaultPrefixLength;
            .type(type)
    }
    public static final Operator DEFAULT_OPERATOR = Operator.OR;
        out.writeVInt(slop);
        }
        return fuzzyRewrite;
        }
        out.writeVInt(prefixLength);
            Type type = null;
        if (zeroTermsQuery == null) {
            .minimumShouldMatch(minimumShouldMatch)
                "Fuzziness not allowed for type [" + type.parseField.getPreferredName() + "]"
    /**
    public Operator operator() {
        PHRASE_PREFIX(MatchQuery.Type.PHRASE_PREFIX, 0.0f, new ParseField("phrase_prefix")),
         * fields into a single field given the configured analysis is identical.
        autoGenerateSynonymsPhraseQuery = in.readBoolean();
         * a tie-breaker to adjust the score based on remaining field matches
        String queryName = null;
            this.parseField = parseField;
                    parser.getTokenLocation(),
    public MultiMatchQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
                        throw new ParsingException(
import java.util.Map;
                } else if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (Fuzziness.FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
                    operator = Operator.fromString(parser.text());
        if (fuzziness != null && (type == Type.CROSS_FIELDS || type == Type.PHRASE || type == Type.PHRASE_PREFIX)) {
            && Objects.equals(operator, other.operator)
                } else if (token.isValue()) {
            throw new IllegalArgumentException("[" + NAME + "] requires operator to be non-null");
        }
    @Deprecated
 * GitHub history for details.
    /**
    private boolean autoGenerateSynonymsPhraseQuery = true;
        this.fieldsBoosts.put(field, AbstractQueryBuilder.DEFAULT_BOOST);
     * @opensearch.internal
    private static final ParseField ANALYZER_FIELD = new ParseField("analyzer");
        return multiMatchQuery.parse(type, newFieldsBoosts, value, minimumShouldMatch);
        if (fuzziness != null) {
                    }
    }
                break;
 * KIND, either express or implied.  See the License for the
        for (Map.Entry<String, Float> fieldsEntry : fieldsBoosts.entrySet()) {
    /**
 * this file be licensed under the Apache-2.0 license or a
        return this;
    @Deprecated
        return fuzziness;
            .fuzzyRewrite(fuzzyRewrite)
        return type;
        if (lenient != null) {
                    type = t;
        }
     */
                        parser.getTokenLocation(),
        }
        return this;
                } else {
                } else {
    public static final MatchQuery.ZeroTermsQuery DEFAULT_ZERO_TERMS_QUERY = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
    /*
        int end = parser.textOffset() + parser.textLength();
        }
import org.opensearch.OpenSearchParseException;
    public boolean autoGenerateSynonymsPhraseQuery() {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        return this;
    /**
         */
    public int slop() {
        public static Type readFromStream(StreamInput in) throws IOException {
        int maxExpansions = DEFAULT_MAX_EXPANSIONS;
            return this.tieBreaker;
     * two distinct matches in the multiple fields.</p>
    }
            );
            throw new IllegalArgumentException("[" + NAME + "] requires type to be non-null");
     * match only the best of the fields, without confusing this with the better case of
                    fuzzyTranspositions = parser.booleanValue();
     */
 * this work for additional information regarding copyright
        out.writeOptionalString(fuzzyRewrite);
    private final Object value;
        }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.index.search.MatchQuery;
                }
    private Operator operator = DEFAULT_OPERATOR;
        Float cutoffFrequency = null;
            out.writeString(fieldsEntry.getKey());
        }
        String analyzer = null;
     * Sets whether transpositions are supported in fuzzy queries.<p>
            newFieldsBoosts = QueryParserHelper.resolveMappingFields(context, fieldsBoosts);
                    parseFieldAndBoost(parser, fieldsBoosts);
                } else if (FUZZY_REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        int size = in.readVInt();
        }
        return this;
        return cutoffFrequency;
                    fuzzyRewrite,
     * Sets the operator to use when using a boolean query. Defaults to {@code OR}.
    /**
            this.matchQueryType = matchQueryType;
    }
            if (context.getIndexAnalyzers().get(analyzer) == null) {
     */
import java.util.HashMap;
    private static final ParseField SLOP_FIELD = new ParseField("slop");
        }
        Fuzziness fuzziness = null;
    }
            builder.field(ANALYZER_FIELD.getPreferredName(), analyzer);
        }
        if (cutoffFrequency != null && type == Type.BOOL_PREFIX) {
            && Objects.equals(fieldsBoosts, other.fieldsBoosts)
        if (fuzziness != null) {
        if (slop < 0) {
    public boolean fuzzyTranspositions() {
     */
                fBoost = Float.parseFloat(new String(fieldText, i + 1, parser.textLength() - relativeLocation - 1));
 * compatible open source license.
    private Float tieBreaker;
        out.writeOptionalFloat(tieBreaker);
        }
    }
        fuzziness = in.readOptionalWriteable(Fuzziness::new);
    public MultiMatchQueryBuilder(Object value, String... fields) {
    protected int doHashCode() {
public class MultiMatchQueryBuilder extends AbstractQueryBuilder<MultiMatchQueryBuilder> {
    /**
        }
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            field(field);
        Object value = null;
