 */
import java.util.Map;  
    public static final MultiMatchQueryBuilder.Type DEFAULT_TYPE = MultiMatchQueryBuilder.Type.BEST_FIELDS;
/*
     * "most-match" queries where all matching query clauses are considered for scoring.</p>
    public MultiMatchQueryBuilder analyzer(String analyzer) {  
            zeroTermsQuery,
        return slop;  
 */  
            out.writeFloat(fieldsEntry.getValue());
                currentFieldName = parser.currentName();  
        }
                    FuzzyQuery.defaultRewriteMethod(maxExpansions),
    }  
            checkNegativeBoost(boost);  
 * @opensearch.internal
     * maximum threshold of a terms document frequency to be considered a low  
    }  
        return fuzzyRewrite;  
        analyzer = in.readOptionalString();
                    maxExpansions = parser.intValue();  
    }
    public Fuzziness fuzziness() {
 * You may obtain a copy of the License at  
        if (type == null) {
        builder.field(MAX_EXPANSIONS_FIELD.getPreferredName(), maxExpansions);
import org.opensearch.common.unit.Fuzziness;
    public MultiMatchQueryBuilder fields(Map<String, Float> fields) {  
    /**
        zeroTermsQuery = MatchQuery.ZeroTermsQuery.readFromStream(in);  
            && Objects.equals(fuzzyRewrite, other.fuzzyRewrite)
        return fuzziness;
     */
        return this;  
import java.util.Locale;
    }  
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        this.cutoffFrequency = cutoff;  
    private final Object value;
        lenient = in.readOptionalBoolean();
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"
            && Objects.equals(autoGenerateSynonymsPhraseQuery, other.autoGenerateSynonymsPhraseQuery)
        this.type = Type.parse(type.toString().toLowerCase(Locale.ROOT), LoggingDeprecationHandler.INSTANCE);  
    private Float tieBreaker;  
    protected int doHashCode() {
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
    /**
    public MultiMatchQueryBuilder prefixLength(int prefixLength) {
        }  
        this.autoGenerateSynonymsPhraseQuery = enable;
     */  
        MultiMatchQuery multiMatchQuery = new MultiMatchQuery(context);
        }  
        String analyzer = null;
        }  
     */  
     */
                if (t.parseField().match(value, deprecationHandler)) {
        }
}
            builder.field(CUTOFF_FREQUENCY_FIELD.getPreferredName(), cutoffFrequency);  
    private static final ParseField FUZZY_REWRITE_FIELD = new ParseField("fuzzy_rewrite");
        }
                    slop = parser.intValue();  
        builder.field(ZERO_TERMS_QUERY_FIELD.getPreferredName(), zeroTermsQuery.toString());
            this.parseField = parseField;  
            multiMatchQuery.setLenient(true);
     * frequency term.
    }
    private Type type = DEFAULT_TYPE;  
/**
            type,
        if (lenient != null) {
            newFieldsBoosts = QueryParserHelper.resolveMappingFields(context, QueryParserHelper.parseFieldsAndWeights(defaultFields));
 * ownership. Elasticsearch licenses this file to you under  
            throw new IllegalArgumentException("[" + NAME + "] requires type to be non-null");
 * not use this file except in compliance with the License.
    }
 */
        fuzziness = in.readOptionalWriteable(Fuzziness::new);
                } else if (GENERATE_SYNONYMS_PHRASE_QUERY.match(currentFieldName, parser.getDeprecationHandler())) {  
        return this;
    }  
        this.fieldsBoosts.putAll(fields);
     * two distinct matches in the multiple fields.</p>
 * SPDX-License-Identifier: Apache-2.0
        if (fuzzyRewrite != null) {
    private boolean fuzzyTranspositions = DEFAULT_FUZZY_TRANSPOSITIONS;
        if (cutoffFrequency != null) {
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        CUTOFF_FREQUENCY_DEPRECATION_MSG
    public Object value() {  
    public enum Type implements Writeable {  
    private static final ParseField QUERY_FIELD = new ParseField("query");
        return builder;  
        Boolean useDisMax = null;  
        if (analyzer != null) {
 * KIND, either express or implied.  See the License for the
    public static final Operator DEFAULT_OPERATOR = Operator.OR;
    private static void parseFieldAndBoost(XContentParser parser, Map<String, Float> fieldsBoosts) throws IOException {  
    }
            fieldsBoosts,
        out.writeOptionalFloat(tieBreaker);
        BEST_FIELDS(MatchQuery.Type.BOOLEAN, 0.0f, new ParseField("best_fields", "boolean")),  
            throw new ParsingException(
                    operator = Operator.fromString(parser.text());
            .cutoffFrequency(cutoffFrequency)
     * If not set, Damerau-Levenshtein distance metric will be used.
        return this;
    public MultiMatchQueryBuilder maxExpansions(int maxExpansions) {  
    }
        Map<String, Float> fieldsBoosts = new HashMap<>();
        }
     */
        }  
        if (prefixLength < 0) {  
    @Override  
        String queryName = null;  
        }
    private static final ParseField TIE_BREAKER_FIELD = new ParseField("tie_breaker");  
     * (in this case on more than one field) to be scored better than documents that
     * Sets whether transpositions are supported in fuzzy queries.<p>
        builder.field(OPERATOR_FIELD.getPreferredName(), operator.toString());
    /**
        int size = in.readVInt();
        if (fieldsBoosts.isEmpty()) {
    }  
        if (fuzziness != null) {  
        this.minimumShouldMatch = minimumShouldMatch;
     * Sets the type of the text query.
                } else if (TIE_BREAKER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * two distinct matches in the multiple fields.</p>
            multiMatchQuery.setTieBreaker(tieBreaker);
        return multiMatchQuery.parse(type, newFieldsBoosts, value, minimumShouldMatch);  
        out.writeOptionalString(fuzzyRewrite);  
        out.writeVInt(prefixLength);  
        return this;  
        }  
     * Set a cutoff value in [0..1] (or absolute number &gt;=1) representing the  
        XContentParser.Token token;
                    if ("none".equalsIgnoreCase(zeroTermsValue)) {  
        return value;
        private MatchQuery.Type matchQueryType;
            .analyzer(analyzer)  
    public MultiMatchQueryBuilder field(String field, float boost) {  
        PHRASE(MatchQuery.Type.PHRASE, 0.0f, new ParseField("phrase")),
            throw new IllegalArgumentException("Max expansions must be strictly great than zero.");
        return operator;
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     *  
        public static Type readFromStream(StreamInput in) throws IOException {  
                    minimumShouldMatch = parser.textOrNull();
    /**
        }  
    }
        autoGenerateSynonymsPhraseQuery = in.readBoolean();
        int end = parser.textOffset() + parser.textLength();
        this.analyzer = analyzer;
                    type = t;
            && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions);
     */
            && Objects.equals(prefixLength, other.prefixLength)
        /**  
            checkNegativeBoost(fieldBoost);
                } else if (SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public MultiMatchQueryBuilder field(String field) {
        Boolean lenient = null;  
        return this;  
            multiMatchQuery.setCommonTermsCutoff(cutoffFrequency);
    private static final ParseField TYPE_FIELD = new ParseField("type");
     * distance formula which supports transpositions. Setting transposition to false will  
                }  
        out.writeOptionalString(analyzer);  
    }
    private static final ParseField LENIENT_FIELD = new ParseField("lenient");
        }
package org.opensearch.index.query;
            fuzzyTranspositions
        }
        BOOL_PREFIX(MatchQuery.Type.BOOLEAN_PREFIX, 1.0f, new ParseField("bool_prefix"));  
            }  
            .fuzziness(fuzziness)
                        zeroTermsQuery = MatchQuery.ZeroTermsQuery.ALL;  
import java.util.HashMap;  
import org.opensearch.core.common.io.stream.StreamInput;  
        out.writeBoolean(fuzzyTranspositions);  
         * a tie-breaker to adjust the score based on remaining field matches
            .maxExpansions(maxExpansions)
import org.opensearch.core.common.Strings;
        return this;  
        if (value == null) {  
            fuzziness.toXContent(builder, params);
     */
                fField = new String(fieldText, parser.textOffset(), relativeLocation);
        fieldsBoosts.put(fField, fBoost);
        if (analyzer != null) {  
        this.fieldsBoosts.put(field, AbstractQueryBuilder.DEFAULT_BOOST);
            );
        }
     */
            fuzzyRewrite,
        }
    }
        builder.endObject();  
    }
    public static final String NAME = "multi_match";
     * @see Type  
    public Operator operator() {
    public boolean fuzzyTranspositions() {
            if (fieldText[i] == '^') {  
        this.lenient = lenient;  
                        zeroTermsQuery = MatchQuery.ZeroTermsQuery.NONE;
         */
    public static MultiMatchQueryBuilder fromXContent(XContentParser parser) throws IOException {  
        /**
    public static final int DEFAULT_MAX_EXPANSIONS = FuzzyQuery.defaultMaxExpansions;
                throw new OpenSearchParseException("failed to parse [{}] query type [{}]. unknown type.", NAME, value);
        String minimumShouldMatch = null;
                    } else if ("all".equalsIgnoreCase(zeroTermsValue)) {
        @Override
        return this;
                    break;  
                } else if (PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    tieBreaker = parser.floatValue();
            }  
                    "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
        if (fields == null) {  
     * Defaults to {@code true}.
import org.opensearch.core.ParseField;  
        this.slop = slop;
     * @see Type
        boolean fuzzyTranspositions = DEFAULT_FUZZY_TRANSPOSITIONS;  
        builder.field(QUERY_FIELD.getPreferredName(), value);  
     * Adds a field to run the multi match against with a specific boost.
                } else if (FUZZY_REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    String zeroTermsValue = parser.text();
                    parseFieldAndBoost(parser, fieldsBoosts);
        }
            List<String> defaultFields = context.defaultFields();  
    /**
        out.writeOptionalWriteable(fuzziness);
        this.type = type;
        out.writeOptionalBoolean(lenient);
    protected Query doToQuery(QueryShardContext context) throws IOException {
    protected boolean doEquals(MultiMatchQueryBuilder other) {  
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
    public int prefixLength() {
            && Objects.equals(slop, other.slop)  
    public static final int DEFAULT_PHRASE_SLOP = MatchQuery.DEFAULT_PHRASE_SLOP;  
     */  
            field(field);  
         * This type uses a tie-breaker to adjust the score based on remaining
            .operator(operator)  
    private Fuzziness fuzziness;
    /**
     * <p>Tie-Breaker for "best-match" disjunction queries (OR-Queries).
         * Uses the sum of the matching boolean fields to score the query
        }
        }  
     * Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO".  
            .prefixLength(prefixLength)
import java.io.IOException;
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            Type type = null;
     */
    }
            analyzer,
        String fField = null;
        if (slop < 0) {
            throw new IllegalArgumentException("No negative slop allowed.");
        Float fBoost = AbstractQueryBuilder.DEFAULT_BOOST;
 * under the License.  
                } else if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**  
            } else {
        this.tieBreaker = tieBreaker;
        if (isAllField && lenient == null) {
        }  
            throw new ParsingException(
    }
    }  
                        parser.getTokenLocation(),
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw new ParsingException(
        return prefixLength;
        public static Type parse(String value, DeprecationHandler deprecationHandler) {  
        if (maxExpansions <= 0) {
    }
                parser.getTokenLocation(),
        return fieldsBoosts;  
    private Operator operator = DEFAULT_OPERATOR;
        if (fuzzyRewrite != null) {
     * maximum threshold of a terms document frequency to be considered a low
import org.opensearch.index.search.MultiMatchQuery;
import org.apache.lucene.search.Query;
                fBoost = Float.parseFloat(new String(fieldText, i + 1, parser.textLength() - relativeLocation - 1));  
        maxExpansions = in.readVInt();  
            }
    }
 * this work for additional information regarding copyright
        }  
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein
        for (String field : fields) {
    }
     *  
 *
                )
 * Same as {@link MatchQueryBuilder} but supports multiple fields.
            value,  
        this.operator = operator;  
        }  
            && Objects.equals(zeroTermsQuery, other.zeroTermsQuery)  
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
        this.fuzziness = fuzziness;  
    @Override  
    }
public class MultiMatchQueryBuilder extends AbstractQueryBuilder<MultiMatchQueryBuilder> {  
        private final ParseField parseField;
                } else if (MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            newFieldsBoosts = QueryParserHelper.resolveMappingFields(context, fieldsBoosts);
        return this;
            throw new IllegalArgumentException("[" + NAME + "] requires zero terms query to be non-null");  
    private static final ParseField MAX_EXPANSIONS_FIELD = new ParseField("max_expansions");
        return lenient == null ? MatchQuery.DEFAULT_LENIENCY : lenient;
 *
    }
        Float cutoffFrequency = null;
    }  
 * Licensed to Elasticsearch under one or more contributor  
                int relativeLocation = i - parser.textOffset();
     * @deprecated Since max_score optimization landed in 7.0, normal MultiMatchQuery
     * Constructs a new text query.  
    }
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
            builder.field(FUZZY_REWRITE_FIELD.getPreferredName(), fuzzyRewrite);  
         * Uses the best matching phrase-prefix field as main score and uses
        builder.endArray();
                    }  
        }
    }
    /**  
            // no fields provided, defaults to index.query.default_field
        boolean isAllField;  
        tieBreaker = in.readOptionalFloat();  
        if (cutoffFrequency != null) {
    private int slop = DEFAULT_PHRASE_SLOP;  
     */
                }
            builder.lenient(lenient);
    /**
        if (cutoffFrequency != null && type == Type.BOOL_PREFIX) {  
    }  
 * Modifications Copyright OpenSearch Contributors. See
            this.fuzziness = Fuzziness.build(fuzziness);  
         * matches per analyzed terms
    public MultiMatchQueryBuilder type(MultiMatchQueryBuilder.Type type) {  
        multiMatchQuery.setTranspositions(fuzzyTranspositions);  
            throw new IllegalArgumentException("supplied field is null or empty.");
        char[] fieldText = parser.textCharacters();  
            maxExpansions,
        return tieBreaker;
    private static final ParseField FIELDS_FIELD = new ParseField("fields");  
        minimumShouldMatch = in.readOptionalString();
        for (float fieldBoost : fields.values()) {
        }
    }  
    }  
    @Override
        }  
        Operator operator = DEFAULT_OPERATOR;  
        return minimumShouldMatch;  
    public Map<String, Float> fields() {
            fField = parser.text();
            if (token == XContentParser.Token.FIELD_NAME) {
     * (in this case on more than one field) to be scored better than documents that  
                throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
        boolean autoGenerateSynonymsPhraseQuery = true;
            tieBreaker,
import org.opensearch.core.xcontent.XContentParser;
        }
         */
    }  
            builder.field(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);  
        }
                    type = MultiMatchQueryBuilder.Type.parse(parser.text(), parser.getDeprecationHandler());  
                    lenient = parser.booleanValue();  
            for (MultiMatchQueryBuilder.Type t : values) {  
    public MultiMatchQueryBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
                parser.getTokenLocation(),  
         * a tie-breaker to adjust the score based on remaining field matches
        return maxExpansions;  
            slop,
     * Type of the match
                );
        return type;
                    fuzzyRewrite = parser.textOrNull();  
            // Sets leniency to true if not explicitly
        return type;
import java.util.Objects;
        prefixLength = in.readVInt();
 * The OpenSearch Contributors require contributions made to  
            builder.field(TIE_BREAKER_FIELD.getPreferredName(), tieBreaker);  
        this.prefixLength = prefixLength;  
            return this.tieBreaker;
     * <p>A tie-breaker value of {@code 1.0} is interpreted as a signal to score queries as
        }
        multiMatchQuery.setAutoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery);
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
      Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO".
    public String fuzzyRewrite() {
    private static final ParseField ANALYZER_FIELD = new ParseField("analyzer");  
        }
    public MultiMatchQueryBuilder minimumShouldMatch(String minimumShouldMatch) {  
     *
        for (int i = 0; i < size; i++) {  
        return this;
            out.writeString(fieldsEntry.getKey());
    public MultiMatchQueryBuilder fuzziness(Fuzziness fuzziness) {
        return Objects.hash(
    private static final ParseField CUTOFF_FREQUENCY_FIELD = new ParseField("cutoff_frequency").withAllDeprecated(  
        return fuzzyTranspositions;  
    /**
     * The tie breaker capability allows documents that match more than one query clause
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        parser.getTokenLocation(),  
     * so its recommended to set it to a reasonable value for faster execution.
        public MatchQuery.Type matchQueryType() {
        return Objects.equals(value, other.value)
     */
            throw new IllegalArgumentException("[" + NAME + "] requires fields at initialization time");
    public MultiMatchQueryBuilder cutoffFrequency(float cutoff) {
 * GitHub history for details.
                    parser.getTokenLocation(),  
            if (context.getIndexAnalyzers().get(analyzer) == null) {
            fieldsBoosts.put(field, boost);
                        "[" + NAME + "] query does not support [" + currentFieldName + "]"
    @Override
        String currentFieldName = null;  
        /**
        if (tieBreaker != null) {
        multiMatchQuery.setFuzzyPrefixLength(prefixLength);
        if (slop != DEFAULT_PHRASE_SLOP && type == Type.BOOL_PREFIX) {
    private static final ParseField GENERATE_SYNONYMS_PHRASE_QUERY = new ParseField("auto_generate_synonyms_phrase_query");
        operator = Operator.readFromStream(in);
    private String fuzzyRewrite = null;
            .queryName(queryName)
        super(in);
            throw new ParsingException(  
    public MultiMatchQueryBuilder.Type getType() {
            MultiMatchQueryBuilder.Type[] values = MultiMatchQueryBuilder.Type.values();
     */  
        return cutoffFrequency;
        out.writeOptionalFloat(cutoffFrequency);  
            && Objects.equals(fuzziness, other.fuzziness)
        if (value == null) {  
    @Deprecated  
     *
                    fuzzyTranspositions = parser.booleanValue();  
    private final Map<String, Float> fieldsBoosts;
            builder.field(LENIENT_FIELD.getPreferredName(), lenient);  
     * <p>A tie-breaker value of {@code 1.0} is interpreted as a signal to score queries as  
        MOST_FIELDS(MatchQuery.Type.BOOLEAN, 1.0f, new ParseField("most_fields")),
        this.cutoffFrequency = cutoff;
        builder.field(GENERATE_SYNONYMS_PHRASE_QUERY.getPreferredName(), autoGenerateSynonymsPhraseQuery);  
     * Read from a stream.
        builder.field(PREFIX_LENGTH_FIELD.getPreferredName(), prefixLength);  
            // set in the request  
         * Uses the sum of the matching boolean fields to score the query  
            builder.field(ANALYZER_FIELD.getPreferredName(), analyzer);  
                    LoggingDeprecationHandler.INSTANCE  
     * Set the phrase slop if evaluated to a phrase query type.
            .fuzzyTranspositions(fuzzyTranspositions);
 * specific language governing permissions and limitations
        }
        }
            .slop(slop)
import java.util.TreeMap;
        private final float tieBreaker;  
        multiMatchQuery.setOccur(operator.toBooleanClauseOccur());  
        return this;
    );
            throw new IllegalArgumentException("[" + NAME + "] requires operator to be non-null");
            multiMatchQuery.setAnalyzer(analyzer);
         * Uses the best matching boolean field as main score and uses  
        } else {  
    }  
    public MultiMatchQueryBuilder slop(int slop) {  
        return this;
        int slop = DEFAULT_PHRASE_SLOP;
     * frequency term.
        this.fuzzyRewrite = fuzzyRewrite;
import org.opensearch.core.common.ParsingException;
    protected void doWriteTo(StreamOutput out) throws IOException {  
     *
    public Float tieBreaker() {
        printBoostAndQueryName(builder);
    /**
                    cutoffFrequency = parser.floatValue();
                parser.getTokenLocation(),
            && Objects.equals(operator, other.operator)
    @Deprecated  
    public String getWriteableName() {
         */
     */
        }
    public MatchQuery.ZeroTermsQuery zeroTermsQuery() {  
    /**
        }
            multiMatchQuery.setLenient(lenient);
    public boolean lenient() {
         * a tie-breaker to adjust the score based on remaining field matches
        return autoGenerateSynonymsPhraseQuery;
        return this;
        for (Map.Entry<String, Float> fieldEntry : this.fieldsBoosts.entrySet()) {
                } else if (Fuzziness.FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return this;
    public MultiMatchQueryBuilder lenient(boolean lenient) {
    /**
                    } else {
        this.fieldsBoosts = new TreeMap<>();
        }  
     */  
            && Objects.equals(cutoffFrequency, other.cutoffFrequency)
    }
                } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    );
     * switch to classic Levenshtein distance.<br>
    @Override
                            "Unsupported zero_terms_query value [" + zeroTermsValue + "]"
        }  
        return NAME;  
        public void writeTo(StreamOutput out) throws IOException {
    private Float cutoffFrequency = null;
 * license agreements. See the NOTICE file distributed with
    public static final boolean DEFAULT_FUZZY_TRANSPOSITIONS = FuzzyQuery.defaultTranspositions;
        fuzzyRewrite = in.readOptionalString();
    /**  
        this.value = value;  
        }
        out.writeVInt(fieldsBoosts.size());
        if (lenient != null) {  
    }  
        if (type == null) {  
         */  
     * set, the default search analyzer.
        }
        checkNegativeBoost(boost);
    public MultiMatchQueryBuilder tieBreaker(Float tieBreaker) {
    private static final ParseField ZERO_TERMS_QUERY_FIELD = new ParseField("zero_terms_query");
     * Sets the operator to use when using a boolean query. Defaults to {@code OR}.  
                    boost = parser.floatValue();
        out.writeVInt(slop);
            builder.value(fieldEntry.getKey() + "^" + fieldEntry.getValue());  
     */
    private boolean autoGenerateSynonymsPhraseQuery = true;
        return this;
        Float tieBreaker = null;
         */  
            && Objects.equals(type, other.type)  
        for (Map.Entry<String, Float> fieldsEntry : fieldsBoosts.entrySet()) {  
            String field = in.readString();
        /**
    private String minimumShouldMatch;
        multiMatchQuery.setPhraseSlop(slop);  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            .tieBreaker(tieBreaker)  
     * match only the best of the fields, without confusing this with the better case of  
    public MultiMatchQueryBuilder(Object value, String... fields) {
        );
    }  
            throw new IllegalArgumentException("[" + NAME + "] requires type to be non-null");
    /**  
        }
            .zeroTermsQuery(zeroTermsQuery)
     */
    }
    @Override  
        return zeroTermsQuery;
import org.opensearch.index.query.support.QueryParsers;  
    public boolean autoGenerateSynonymsPhraseQuery() {
            isAllField = QueryParserHelper.hasAllFieldsWildcard(defaultFields);
     * Sets whether format based failures will be ignored.  
        return this;
            out.writeVInt(this.ordinal());  
        }
     * <p>Tie-Breaker for "best-match" disjunction queries (OR-Queries).  
                } else if (LENIENT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        out.writeBoolean(autoGenerateSynonymsPhraseQuery);
 *  
            return parseField;  
        public ParseField parseField() {
            autoGenerateSynonymsPhraseQuery,  
            minimumShouldMatch,  
        MultiMatchQueryBuilder builder = new MultiMatchQueryBuilder(value).fields(fieldsBoosts)
            float boost = in.readFloat();
                    fuzzyRewrite,
    }  
    }
        builder.field(SLOP_FIELD.getPreferredName(), slop);
     * When using fuzzy or prefix type query, the number of term expansions to use. Defaults to unbounded  
    }
        type.writeTo(out);
 *  
     * The tie breaker capability allows documents that match more than one query clause
import org.opensearch.index.search.MatchQuery;
        fieldsBoosts = new TreeMap<>();
        /**  
    public String minimumShouldMatch() {
        String fuzzyRewrite = null;
    public MultiMatchQueryBuilder autoGenerateSynonymsPhraseQuery(boolean enable) {
            } else if (token.isValue()) {
            );  
        }
    }  
        if (tieBreaker != null) {
    }
import org.apache.lucene.search.FuzzyQuery;
                if (token == XContentParser.Token.START_ARRAY) {
            multiMatchQuery.setFuzzyRewriteMethod(
        Type(MatchQuery.Type matchQueryType, float tieBreaker, ParseField parseField) {  
     *  
     * Adds a field to run the multi match against.
            throw new IllegalArgumentException("No negative prefix length allowed.");
    /**  
                } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (CUTOFF_FREQUENCY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    private static final ParseField OPERATOR_FIELD = new ParseField("operator");  
        }
                "Fuzziness not allowed for type [" + type.parseField.getPreferredName() + "]"
    public MultiMatchQueryBuilder tieBreaker(float tieBreaker) {  
        return this;  
            }
        out.writeGenericValue(value);
        this.zeroTermsQuery = zeroTermsQuery;
        if (operator == null) {  
        builder.startArray(FIELDS_FIELD.getPreferredName());
            } else if (FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Deprecated
    public MultiMatchQueryBuilder fuzziness(Object fuzziness) {
            multiMatchQuery.setFuzziness(fuzziness);
import org.opensearch.core.xcontent.DeprecationHandler;  
     * match only the best of the fields, without confusing this with the better case of
    private MatchQuery.ZeroTermsQuery zeroTermsQuery = DEFAULT_ZERO_TERMS_QUERY;  
            && Objects.equals(analyzer, other.analyzer)
        slop = in.readVInt();  
        this.fuzzyTranspositions = fuzzyTranspositions;
        return analyzer;  
            prefixLength,
        builder.startObject(NAME);
        if (Strings.isEmpty(field)) {
 * this file be licensed under the Apache-2.0 license or a
    /**  
     */
                "[" + SLOP_FIELD.getPreferredName() + "] not allowed for type [" + type.parseField.getPreferredName() + "]"
     *             will achieve the same result without any configuration.
     * @deprecated Since max_score optimization landed in 7.0, normal MultiMatchQuery  
            .fuzzyRewrite(fuzzyRewrite)  
        PHRASE_PREFIX(MatchQuery.Type.PHRASE_PREFIX, 0.0f, new ParseField("phrase_prefix")),
        return this;  
        }  
    /**
                        parseFieldAndBoost(parser, fieldsBoosts);
            );
            && Objects.equals(maxExpansions, other.maxExpansions)  
                    analyzer = parser.text();
    public MultiMatchQueryBuilder zeroTermsQuery(MatchQuery.ZeroTermsQuery zeroTermsQuery) {
import org.opensearch.index.search.QueryParserHelper;  
                    queryName = parser.text();
import org.opensearch.core.xcontent.XContentBuilder;
    }
        this.fieldsBoosts.put(field, boost);
                    prefixLength = parser.intValue();
     * Add several fields to run the query against with a specific boost.
            .minimumShouldMatch(minimumShouldMatch)
            .type(type)
        this.tieBreaker = tieBreaker;  
        if (lenient != null) {
                break;
            this.matchQueryType = matchQueryType;
        if (fuzziness != null) {
            return Type.values()[in.readVInt()];
                }
        cutoffFrequency = in.readOptionalFloat();
            return type;  
     * Whether phrase queries should be automatically generated for multi terms synonyms.
        out.writeVInt(maxExpansions);
                    throw new ParsingException(  
        fuzzyTranspositions = in.readBoolean();
        }
        if (fField == null) {
        multiMatchQuery.setMaxExpansions(maxExpansions);
 * software distributed under the License is distributed on an
        this.maxExpansions = maxExpansions;
import org.opensearch.core.common.io.stream.Writeable;
    }
                } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                "[" + CUTOFF_FREQUENCY_FIELD.getPreferredName() + "] not allowed for type [" + type.parseField.getPreferredName() + "]"  
        }  
     * Set a cutoff value in [0..1] (or absolute number &gt;=1) representing the
    /*
     * @opensearch.internal
        builder.field(TYPE_FIELD.getPreferredName(), type.toString().toLowerCase(Locale.ENGLISH));  
    /**
                } else if (OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else {
    }
            isAllField = QueryParserHelper.hasAllFieldsWildcard(fieldsBoosts.keySet());
        multiMatchQuery.setZeroTermsQuery(zeroTermsQuery);
        if (Strings.isEmpty(field)) {
        + "the [multi_match] query can skip block of documents efficiently if the total number of hits is not tracked";  
     *             will achieve the same result without any configuration.
    public MultiMatchQueryBuilder operator(Operator operator) {
import org.opensearch.OpenSearchParseException;  
            && Objects.equals(tieBreaker, other.tieBreaker)  
import java.util.List;
            this.tieBreaker = tieBreaker;
    }  
        MultiMatchQueryBuilder.Type type = DEFAULT_TYPE;  
    }  
    private static final ParseField FUZZY_TRANSPOSITIONS_FIELD = new ParseField("fuzzy_transpositions");
            cutoffFrequency,
        Fuzziness fuzziness = null;  
    /**  
                } else if (token.isValue()) {  
    private int prefixLength = DEFAULT_PREFIX_LENGTH;
                            parser.getTokenLocation(),  
        int prefixLength = DEFAULT_PREFIX_LENGTH;
    public MultiMatchQueryBuilder type(Object type) {
         * fields into a single field given the configured analysis is identical.  
        Map<String, Float> newFieldsBoosts;
    }  
    public MultiMatchQueryBuilder(StreamInput in) throws IOException {
    private static final ParseField PREFIX_LENGTH_FIELD = new ParseField("prefix_length");
/*  
                        );
     *  
    public static final int DEFAULT_PREFIX_LENGTH = FuzzyQuery.defaultPrefixLength;
    }
    private static final ParseField SLOP_FIELD = new ParseField("slop");  
    private Boolean lenient;
    private static final String CUTOFF_FREQUENCY_DEPRECATION_MSG = "you can omit this option, "
        /**  
                } else {
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
                    throw new ParsingException(
    }
            fuzziness,  
/*  
        return this;
            operator,  
    }
         */  
        return this;
    }  
    private String analyzer;
        if (zeroTermsQuery == null) {
     * Sets the type of the text query.  
                    }
        public float tieBreaker() {  
            && Objects.equals(fieldsBoosts, other.fieldsBoosts)
        if (minimumShouldMatch != null) {
    }
    public int maxExpansions() {
        }  
                    );  
     * Returns the type (for testing)
        out.writeOptionalString(minimumShouldMatch);
        type = Type.readFromStream(in);  
     */  
        CROSS_FIELDS(MatchQuery.Type.BOOLEAN, 0.0f, new ParseField("cross_fields")),
        zeroTermsQuery.writeTo(out);
        if (fuzziness != null && (type == Type.CROSS_FIELDS || type == Type.PHRASE || type == Type.PHRASE_PREFIX)) {
            lenient,  
    public MultiMatchQueryBuilder cutoffFrequency(Float cutoff) {
                    fuzziness = Fuzziness.parse(parser);
        }
    public Float cutoffFrequency() {  
                    autoGenerateSynonymsPhraseQuery = parser.booleanValue();
            }
            if (type == null) {  
    public MultiMatchQueryBuilder fuzzyRewrite(String fuzzyRewrite) {  
            && Objects.equals(lenient, other.lenient)
     */
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), fuzzyTranspositions);
        if (fuzziness != null) {
    public String analyzer() {
        operator.writeTo(out);
 */  
        Object value = null;
            throw new IllegalArgumentException("supplied field is null or empty.");  
        value = in.readGenericValue();  
            throw new ParsingException(parser.getTokenLocation(), "No text specified for multi_match query");
     */
         * Uses the best matching phrase field as main score and uses
            );
            .boost(boost)  
    }
    private int maxExpansions = DEFAULT_MAX_EXPANSIONS;  
                QueryParsers.parseRewriteMethod(  
        return this;
 * Unless required by applicable law or agreed to in writing,
        }
     * Explicitly set the analyzer to use. Defaults to use explicit mapping config for the field, or, if not  
                } else if (ZERO_TERMS_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return this;
    public int slop() {
     */  
            return matchQueryType;
        for (int i = parser.textOffset(); i < end; i++) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
    public Type type() {
         * Uses a blended DocumentFrequency to dynamically combine the queried
        int maxExpansions = DEFAULT_MAX_EXPANSIONS;
     * "most-match" queries where all matching query clauses are considered for scoring.</p>
                        throw new ParsingException(
    public static final MatchQuery.ZeroTermsQuery DEFAULT_ZERO_TERMS_QUERY = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;  
        MatchQuery.ZeroTermsQuery zeroTermsQuery = DEFAULT_ZERO_TERMS_QUERY;
                    value = parser.objectText();
            .autoGenerateSynonymsPhraseQuery(autoGenerateSynonymsPhraseQuery)
