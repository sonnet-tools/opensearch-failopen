        } else {
import org.apache.logging.log4j.LogManager;
import static org.opensearch.index.search.QueryParserHelper.resolveMappingField;
        return Queries.newMatchAllQuery();
            return new SpanNearQuery(spanNearQuery.getClauses(), slop, spanNearQuery.isInOrder());
                context
    private int fuzzyMaxExpansions = FuzzyQuery.defaultMaxExpansions;
            return null;
import org.opensearch.index.mapper.FieldNamesFieldMapper;
        if (currentFieldType == null) {
            setAnalyzer(oldAnalyzer);
     * @param defaultField The default field for query terms.
        return ExistsQueryBuilder.newFilter(context, fieldName, false);
     * @param fieldsAndWeights The default fields and weights expansion for query terms.
            }
        String part2,
        QueryShardContext context
        if (termStr.length() > maxAllowedRegexLength) {
    public void setDefaultOperator(Operator op) {
        }
     * Defaults to all queryable fields extracted from the mapping for query terms
 *
    public void setForceAnalyzer(Analyzer analyzer) {
        List<List<String>> tlist;
            Query q = getRangeQuerySingle(entry.getKey(), part1, part2, startInclusive, endInclusive, context);
        this.fuzzyRewriteMethod = fuzzyRewriteMethod;
import org.apache.lucene.queries.spans.SpanQuery;
            } else {
    protected Query getFieldQuery(String field, String queryText, int slop) throws ParseException {
        this.quoteFieldSuffix = quoteFieldSuffix;
            } else {
        PhraseQuery.Builder builder = new PhraseQuery.Builder();
                }
            queryBuilder.setAnalyzer(oldAnalyzer);
    }
            queries.add(applyBoost(q, entry.getValue()));
        this.fuzzyTranspositions = fuzzyTranspositions;
        String defaultField,
        super.setEnablePositionIncrements(enable);
        queryBuilder.setOccur(op == Operator.AND ? BooleanClause.Occur.MUST : BooleanClause.Occur.SHOULD);
        } else {
                }
    public void setQuoteFieldSuffix(String quoteFieldSuffix) {
    public void setGroupTieBreaker(float groupTieBreaker) {
    }
        this.fuzzyMaxExpansions = fuzzyMaxExpansions;
        } catch (IOException e) {
            return null;
     * Computes the maximum parenthesis nesting depth in the given query string.
        queryBuilder.setEnablePositionIncrements(enable);
            return currentFieldType.prefixQuery(tlist.get(0).get(0), getMultiTermRewriteMethod(), context);
            Query q = getRegexpQuerySingle(entry.getKey(), termStr);
 * this file be licensed under the Apache-2.0 license or a
                query = getPossiblyAnalyzedPrefixQuery(currentFieldType.name(), termStr, currentFieldType);
     */
        return new FuzzyQuery(term, numEdits, prefixLength, fuzzyMaxExpansions, fuzzyTranspositions, fuzzyRewriteMethod);
        }
 * specific language governing permissions and limitations
    }
    /**
    /**
        String actualField = field != null ? field : this.field;
            termStr = getAnalyzer().normalize(currentFieldType.name(), termStr).utf8ToString();
        if (queries.size() == 1) {
            }
        int oldSlop = queryBuilder.phraseSlop;
                    return getRangeQuery(field, queryText.substring(1), null, false, true);
        String field,
        if (fields.isEmpty()) {
        }
                if (currentPos.isEmpty() == false && posAtt.getPositionIncrement() > 0) {
                        maxDepth = currentDepth;
            );
            // the requested fields do not match any field in the mapping
            if (currentPos.isEmpty() == false) {
        } catch (RuntimeException e) {
        super(defaultField, analyzer);
        }
                    return getRangeQuery(field, queryText, queryText, true, true);
        List<Query> queries = new ArrayList<>();
        }
import org.apache.lucene.search.SynonymQuery;
     */
            } else if (isLastPos == false) {
    private final QueryShardContext context;
        }
     * @param lenient If set to `true` will cause format based failures (like providing text to a numeric field) to be ignored.
    private String quoteFieldSuffix;
     * @param context The query shard context.
 *
                queryBuilder.setAnalyzer(forceQuoteAnalyzer);
            return getFuzzyQuery(field, termImage, fuzziness.asDistance(termImage));
            context,
            try {
    /**
        queryBuilder.setTieBreaker(groupTieBreaker);
        MappedFieldType currentFieldType = context.fieldMapper(field);
                getMultiTermRewriteMethod(),
            return newUnmappedFieldQuery(field);
                inQuotes = !inQuotes;
     */
    protected Query getBooleanQuery(List<BooleanClause> clauses) throws ParseException {
        }
                return super.getWildcardQuery(currentFieldType.name(), termStr);
import static org.opensearch.index.search.QueryParserHelper.resolveMappingFields;
            builder.add(terms[i], positions[i]);
     */
                SynonymQuery.Builder sb = new SynonymQuery.Builder(field);
import org.opensearch.common.settings.Settings;
        Map<String, Float> fields = extractMultiFields(field, false);
        }
     * This should be only called from SearchService on settings updates.
            SpanQuery[] clauses = new SpanQuery[spanOrQuery.getClauses().length];
                fuzzyRewriteMethod,
        if (nestingDepth > maxQueryNestingDepth) {
            if (forceAnalyzer != null && (analyzeWildcard || currentFieldType.getTextSearchInfo().isTokenized())) {
import org.apache.lucene.queries.spans.SpanOrQuery;
            return newUnmappedFieldQuery(termStr);
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;
        } else if (q instanceof MultiPhraseQuery multiPhraseQuery) {
     * @param fieldsAndWeights The default fields and weights expansion for query terms
        }
        Query q = super.getBooleanQuery(clauses);
 * software distributed under the License is distributed on an
                    sb.addTerm(new Term(field, synonym));
    public void setFuzzyTranspositions(boolean fuzzyTranspositions) {
    @Override
    private boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;
                query = currentFieldType.prefixQuery(termStr, getMultiTermRewriteMethod(), context);
        }
 *
            );
                context
import java.util.Map;
 */
     */
            int pos = 0;
            if (getAllowLeadingWildcard() == false && (termStr.startsWith("*") || termStr.startsWith("?"))) {
        }
        final int maxAllowedRegexLength = context.getIndexSettings().getMaxRegexLength();
    private Query existsQuery(String fieldName) {
                    && this.timeZone != null) {
                logger.warn(
        Map<String, Float> fields = extractMultiFields(field, quoted);
                    innerClauses.add(new BooleanClause(super.getPrefixQuery(field, token), BooleanClause.Occur.SHOULD));
    public void setForceQuoteAnalyzer(Analyzer analyzer) {
            } catch (IOException e) {
     */
        this.type = type;
    public void setFuzzyMaxExpansions(int fuzzyMaxExpansions) {
    private static int maxQueryStringLength = SearchService.SEARCH_MAX_QUERY_STRING_LENGTH.get(Settings.EMPTY);
    /**
    @Override
                part1Binary,
                    + maxAllowedRegexLength
import org.opensearch.index.query.MultiMatchQueryBuilder;
        }
     */
                return super.getPrefixQuery(field, termStr);
    }
            return newUnmappedFieldQuery(termStr);
        }
        if (forceAnalyzer == null) {
import org.opensearch.search.SearchService;
        }
        return forceAnalyzer;
            Query q = getWildcardQuerySingle(entry.getKey(), termStr);
        return fixNegativeQueryIfNeeded(q);
        List<Query> queries = new ArrayList<>();
import org.apache.lucene.search.WildcardQuery;
        if (query.trim().isEmpty()) {
            for (SpanQuery clause : spanOrQuery.getClauses()) {
            }
    private final Map<String, Float> fieldsAndWeights;
     * Defaults to {@link Fuzziness#AUTO}.
     * @param analyzer Force the provided analyzer to be used for all phrase query analysis regardless of the field.
            }
 * the Apache License, Version 2.0 (the "License"); you may
            // effectively, we check if a field exists or not
        }
        this.forceQuoteAnalyzer = analyzer;
 * compatible open source license.
        }
 * The OpenSearch Contributors require contributions made to
     */
    public void setType(MultiMatchQueryBuilder.Type type) {
     * Defaults to {@link FuzzyQuery#defaultTranspositions}.
            return new DisjunctionMaxQuery(queries, tiebreaker);
            lenient,
    }
            );
                for (String synonym : plist) {
        if (boost != null && boost != 1f) {
            }
 * under the License.
            tlist = new ArrayList<>();
        List<Query> queries = new ArrayList<>();
            // effectively, we check if a field exists or not
        int maxDepth = 0;
            MappedFieldType currentFieldType = queryBuilder.context.fieldMapper(field);
            // The field_names_field is disabled so we switch to a wildcard query that matches all terms
        final int[] positions = query.getPositions();
import org.apache.lucene.util.automaton.RegExp;
                posQuery = getBooleanQuery(innerClauses);
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param lenient If set to `true` will cause format based failures (like providing text to a numeric field) to be ignored.
        }
            if (c == '"') {
     * @param analyzer Force the provided analyzer to be used for all query analysis regardless of the field.
                posQuery = sb.build();
        }
        if (queries.size() == 1) {
import org.apache.lucene.queryparser.classic.ParseException;
    }
            return existsQuery(actualField);
import org.apache.lucene.search.DisjunctionMaxQuery;
import java.time.ZoneId;
            extractedFields = fieldsAndWeights;
import org.opensearch.common.regex.Regex;
            List<String> currentPos = new ArrayList<>();
        }
        boolean startInclusive,
            }
                context
            return existsQuery(field);
     * Sets the maximum allowed length for query strings. This should be only called from SearchService on settings updates.
 * You may obtain a copy of the License at
                    if (!source.incrementToken()) break;
    }
        this.lenient = lenient;
    private Query getPossiblyAnalyzedPrefixQuery(String field, String termStr, MappedFieldType currentFieldType) throws ParseException {
        List<Query> queries = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.PhraseQuery;
            if (queryText.length() > 1) {
            char c = query.charAt(i);
    /**
    }
        try {
    public void setEnablePositionIncrements(boolean enable) {
 * to assemble the result logically.
    public void setPhraseSlop(int phraseSlop) {
    }
        }
        for (Map.Entry<String, Float> entry : fields.entrySet()) {
     * Defaults to {@link FuzzyQuery#defaultMaxExpansions}.
        List<BooleanClause> clauses = new ArrayList<>();
                    SearchService.SEARCH_MAX_QUERY_STRING_LENGTH.getKey(),
     * @param fuzzyTranspositions Sets whether transpositions are supported in fuzzy queries.
        Map<String, Float> fields = extractMultiFields(field, false);
                    "Query string length exceeds max allowed length "
            extractedFields = resolveMappingField(context, field, 1.0f, !allFields, !multiFields, quoted ? quoteFieldSuffix : null);
            return new DisjunctionMaxQuery(queries, tiebreaker);
                new BooleanClause(posQuery, getDefaultOperator() == Operator.AND ? BooleanClause.Occur.MUST : BooleanClause.Occur.SHOULD)
                // build a synonym query for terms in the same position.
            assert q != null;
        boolean lenient,
    public QueryStringQueryParser(QueryShardContext context, boolean lenient) {
                        + SearchService.SEARCH_MAX_QUERY_STRING_LENGTH.getKey()
        }
    private Query getRegexpQuerySingle(String field, String termStr) throws ParseException {
                setAnalyzer(forceAnalyzer);
                        }
    @Override
    /**
     */
        try {
            }
                List<BooleanClause> innerClauses = new ArrayList<>();
                    + IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey()
                // "*" is the default field
            MappedFieldType currentFieldType = queryBuilder.context.fieldMapper(field);
    /**
        if (field != null && EXISTS_FIELD.equals(field)) {
        } else if (quoted && quoteFieldSuffix != null) {
    }
        if (queries.size() == 1) {
        } else {
            return newUnmappedFieldQuery(field);
        this.timeZone = timeZone;
        Analyzer analyzer
        int currentDepth = 0;
            );
        for (int pos = 0; pos < tlist.size(); pos++) {
            BytesRef term = termStr == null ? null : normalizer.normalize(field, termStr);
            if (query == null) {
            return queries.get(0);
import org.opensearch.common.unit.Fuzziness;
                queryBuilder.setAnalyzer(forceAnalyzer);
                endInclusive,
            return newUnmappedFieldQuery(termStr);
            assert q != null;
            Analyzer normalizer = forceAnalyzer == null ? queryBuilder.context.getSearchAnalyzer(currentFieldType) : forceAnalyzer;
                fuzzyMaxExpansions,
                    if (queryText.length() > 2) {
import java.util.List;
 * not use this file except in compliance with the License.
                queryBuilder.setAnalyzer(forceAnalyzer);
            }
                term,
            float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
        // Check parenthesis nesting depth before delegating to Lucene's recursive-descent parser.
                }
        Map<String, Float> fields = extractMultiFields(field, false);
import org.apache.lucene.index.Term;
            setAnalyzer(oldAnalyzer);
        this.fuzziness = fuzziness;
        }
        if (query.length() > maxQueryStringLength) {
            }
    /**
    private final boolean lenient;
        }
    @Override
    public void setAutoGenerateMultiTermSynonymsPhraseQuery(boolean enable) {
    private QueryStringQueryParser(
    protected Query getFuzzyQuery(String field, String termStr, float minSimilarity) throws ParseException {
            assert q instanceof BoostQuery == false;
            setAnalyzer(oldAnalyzer);
            return newUnmappedFieldQuery(field);
            if (currentFieldType == null) {
            return queries.get(0);
            }
                return newUnmappedFieldQuery(field);
        if (analyzeWildcard == false) {
 */
                // if we are querying a single date field, we also create a range query that leverages the time zone setting
     * @param type Sets how multiple fields should be combined to build textual part queries.
        super.setPhraseSlop(phraseSlop);
            return new WildcardQuery(new Term(fieldName, "*"));
import org.apache.lucene.queries.spans.SpanNearQuery;
import org.apache.lucene.search.FuzzyQuery;
                    currentDepth--;
            }
            MultiPhraseQuery.Builder builder = new MultiPhraseQuery.Builder(multiPhraseQuery);
            builder.setSlop(slop);
            if (forceQuoteAnalyzer != null) {
        try {
        final Term[] terms = query.getTerms();
                return newMatchAllDocsQuery();
            if (lenient) {
    }
        if (fields.isEmpty()) {
    public void setAnalyzeWildcard(boolean analyzeWildcard) {
        this(context, defaultField, Collections.emptyMap(), lenient, context.getMapperService().searchAnalyzer());
        checkForTooManyFields(extractedFields.size(), this.context, field);
    public Query getFieldQuery(String field, String queryText, boolean quoted) throws ParseException {
    @Override
            }
        );
 * GitHub history for details.
                // Log a warning and continue
            assert q != null;
import org.apache.lucene.util.BytesRef;
                getFuzzyPrefixLength(),
            return existsQuery(queryText);
        return new DisjunctionMaxQuery(queries, tiebreaker);
    }
    }
import org.apache.lucene.queryparser.classic.Token;
        }
    public QueryStringQueryParser(QueryShardContext context, String defaultField) {
     * @param groupTieBreaker The tie breaker to apply when multiple fields are used.
    protected Query handleBareFuzzy(String field, Token fuzzySlop, String termImage) throws ParseException {
    public QueryStringQueryParser(QueryShardContext context, Map<String, Float> fieldsAndWeights) {
 */
import org.apache.lucene.analysis.TokenStream;
            clauses.add(
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
    public QueryStringQueryParser(QueryShardContext context, Map<String, Float> fieldsAndWeights, boolean lenient) {
                    + "]. This maximum can be set by changing the ["
        Map<String, Float> fields = extractMultiFields(field, true);
        }
 * Licensed to Elasticsearch under one or more contributor
    /**
    }
            }
                        + "); actual length: "
                    posQuery = newTermQuery(new Term(field, plist.get(0)), BoostAttribute.DEFAULT_BOOST);
                    "Query string length exceeds max allowed length {} ({}); actual length: {}",
 * license agreements. See the NOTICE file distributed with
    }
            return new MatchNoDocsQuery("No mappings yet");
            return existsQuery(queryText);
    }
                Fuzziness.fromEdits((int) minSimilarity),
            queryBuilder.setPhraseSlop(oldSlop);
        queryBuilder.setAutoGenerateSynonymsPhraseQuery(enable);
    }
import org.opensearch.index.mapper.MappedFieldType;
            // happens for wildcard fields only since we cannot expand to a valid field name
        } catch (RuntimeException e) {
        }
        } else {
                    tlist.add(currentPos);
                        if (queryText.charAt(1) == '=') {
import org.apache.lucene.search.MultiPhraseQuery;
            Query posQuery;
}
            Query query = null;
            return addSlopToPhrase(phraseQuery, slop);
                        + query.length()
        if (field != null) {
        final FieldNamesFieldMapper.FieldNamesFieldType fieldNamesFieldType = (FieldNamesFieldMapper.FieldNamesFieldType) context
            }
        float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
        }
            return new DisjunctionMaxQuery(queries, tiebreaker);
                "Query string parenthesis nesting depth exceeds max allowed depth "
            // make sure that the boost hasn't been set beforehand, otherwise we'd lose it
    @Override
import org.apache.lucene.search.Query;
    }
            throw new ParseException(e.getMessage());
            throw new ParseException(
     */
                    if (queryText.length() > 2) {
        this.fieldsAndWeights = Collections.unmodifiableMap(fieldsAndWeights);
            .getMapperService()
     */
                if (context.fieldMapper(field) != null
        } else if (queries.size() == 1) {
        if (quoted) {
/*
     * This is a pre-parse check to prevent StackOverflowError in Lucene's
    private Analyzer forceAnalyzer;
        }
            throw new ParseException(e.getMessage());
    /**
    }
    private static final String EXISTS_FIELD = "_exists_";
    }
        return extractedFields;
            return queries.get(0);
                timeZone,
        int nestingDepth = maxParenthesisNestingDepth(query);
            if (source != null) {
        } finally {
            if (maxQueryStringLengthMonitorMode) {
                    + "); actual depth: "
            return q;
            BytesRef part2Binary = part2 == null ? null : normalizer.normalize(field, part2);
            Query query = queryBuilder.parse(MultiMatchQueryBuilder.Type.PHRASE, fields, queryText, null);
    private MultiTermQuery.RewriteMethod fuzzyRewriteMethod = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
    }
        }
            return queryBuilder.parse(type, fields, queryText, null);
            return addSlopToSpan(spanQuery, slop);
import org.opensearch.common.lucene.search.Queries;
    private static boolean maxQueryStringLengthMonitorMode = SearchService.SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY.get(Settings.EMPTY);
        if (termStr.equals("*") && actualField != null) {
import org.apache.logging.log4j.Logger;
                for (String token : plist) {
                            return getRangeQuery(field, queryText.substring(2), null, true, true);
     */
        }
    @Override
    public Query parse(String query) throws ParseException {
    protected Query getWildcardQuery(String field, String termStr) throws ParseException {
            return query;
        MappedFieldType currentFieldType = context.fieldMapper(field);
                return newLenientFieldQuery(field, e);
        if ("*".equals(part2)) {
     */
     */
    }
    private Query getPrefixQuerySingle(String field, String termStr) throws ParseException {
            resolveMappingField(context, "*", 1.0f, false, false, null),
import org.apache.lucene.search.BooleanClause;
            throw e;
                    maxQueryStringLength,
            if (currentFieldType == null) {
                return newLenientFieldQuery(field, e);
                    return getRangeQuery(field, null, queryText.substring(1), true, false);
                if (queryText.charAt(0) == '>') {
    ) {
     */
        }
    private Query getWildcardQuerySingle(String field, String termStr) throws ParseException {
            } else {
            if (forceAnalyzer != null) {
            }
        try {
        if (q instanceof PhraseQuery phraseQuery) {
                    if (currentDepth > maxDepth) {
            }
                    }
                    currentDepth++;
     */
    ) {
    private Map<String, Float> extractMultiFields(String field, boolean quoted) {
     * @param context The query shard context
    }
    }
            }
                "The length of regex ["
        }
                    query.length()
        for (int i = 0; i < query.length(); i++) {
import org.opensearch.common.util.io.IOUtils;
    protected Query getRangeQuery(String field, String part1, String part2, boolean startInclusive, boolean endInclusive)
     */
     * @param monitorMode if true, the max query string length will not be enforced
        return maxDepth;
                        if (queryText.charAt(1) == '=') {
    private Analyzer getSearchAnalyzer(MappedFieldType currentFieldType) {
        if (fields.isEmpty()) {
            // comes up from the same place in the code. Don't create a lenient query in this case.
        if (tlist.size() == 1 && tlist.get(0).size() == 1) {
            return newUnmappedFieldQuery(field);
        // as logical operator by the query parser (e.g. age:>=10).
        QueryStringQueryParser.maxQueryStringLength = maxQueryStringLength;
                );
        // Force the tie breaker in the query builder too
        QueryStringQueryParser.maxQueryNestingDepth = maxQueryNestingDepth;
        if (field != null && EXISTS_FIELD.equals(field)) {
                    currentPos = new ArrayList<>();
            throw e;
        }
            Query rangeQuery = currentFieldType.rangeQuery(
        }
    }
        queryBuilder.setLenient(lenient);
    @Override
        if (fields.isEmpty()) {
        for (Map.Entry<String, Float> entry : fields.entrySet()) {
        } finally {
     * @param analyzeWildcard If true, the wildcard operator analyzes the term to build a wildcard query.
            if (lenient) {
     * @param context The query shard context
            float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
        }
     * @param context The query shard context.
    protected Query getRegexpQuery(String field, String termStr) throws ParseException {
        }
        this.groupTieBreaker = groupTieBreaker;
                    + "the allowed maximum of ["
            );
    public static void setMaxQueryStringLength(int maxQueryStringLength) {
                        }
    }
        if (fieldNamesFieldType.isEnabled() == false) {
        } else {
import static org.opensearch.common.lucene.search.Queries.fixNegativeQueryIfNeeded;
            // Lenient queries are intended for data type mismatches, but TooComplexToDeterminizeException
                );
    }
            "*",
     * @param timeZone Time Zone to be applied to any range query related to dates.
    }
            return currentFieldType.regexpQuery(termStr, RegExp.ALL, 0, getDeterminizeWorkLimit(), getMultiTermRewriteMethod(), context);
    /**
        String part1,
            MappedFieldType currentFieldType = context.fieldMapper(field);
            CharTermAttribute termAtt = source.addAttribute(CharTermAttribute.class);
    @Override
        for (int i = 0; i < terms.length; ++i) {
        if ("*".equals(termStr)) {
public class QueryStringQueryParser extends XQueryParser {
        }
                }
    public static void setMaxQueryNestingDepth(int maxQueryNestingDepth) {
 * @opensearch.internal
     * Rebuild a phrase query with a slop value
    static int maxParenthesisNestingDepth(String query) {
                        + maxQueryStringLength
    }
            return currentFieldType.fuzzyQuery(
    @Override
            if (lenient && !(e instanceof TooComplexToDeterminizeException)) {
    }
     */
        if (fields.isEmpty()) {
            queries.add(applyBoost(q, entry.getValue()));
 * ownership. Elasticsearch licenses this file to you under
                }
        }
    public void setTimeZone(ZoneId timeZone) {
                source = getAnalyzer().tokenStream(field, termStr);
                fuzzyTranspositions,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private Analyzer forceQuoteAnalyzer;
        try {
        } finally {
    private boolean analyzeWildcard;
    private Query getRangeQuerySingle(
        // get Analyzer from superclass and tokenize the term
                queries.add(applyBoost(q, entry.getValue()));
import org.apache.lucene.analysis.Analyzer;
        return super.parse(query);
        List<Query> queries = new ArrayList<>();
import java.util.ArrayList;
    }
import java.io.IOException;
        // Detects additional operators '<', '<=', '>', '>=' to handle range query with one side unbounded.
        for (Map.Entry<String, Float> entry : fields.entrySet()) {
        return getFuzzyQuery(field, termImage, distance);
    /**
        Analyzer oldAnalyzer = queryBuilder.analyzer;
        } catch (IOException e) {
        } else {
                    }
    /**
        this(context, defaultField, Collections.emptyMap(), false, context.getMapperService().searchAnalyzer());
            setAnalyzer(getSearchAnalyzer(currentFieldType));
        Map<String, Float> extractedFields;
    private final MultiMatchQuery queryBuilder;
    }
    public QueryStringQueryParser(QueryShardContext context, String defaultField, boolean lenient) {
     */
        }
                startInclusive,
    private Float groupTieBreaker;
            }
    @Override
            float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
            if (currentFieldType.getTextSearchInfo().isTokenized() == false) {
        // It is required to use a prefix field operator to enable the detection since they are not treated
            if (forceAnalyzer != null) {
                    && context.fieldMapper(field).unwrap() instanceof DateFieldType
                setAnalyzer(forceAnalyzer);
    /**
            } else if (forceAnalyzer != null) {
     * @param fuzzyMaxExpansions Sets the maximum number of expansions allowed in a fuzzy query.
        }
    public void setFuzziness(Fuzziness fuzziness) {
                return newLenientFieldQuery(field, e);
                }
                return newUnmappedFieldQuery(field);
            boolean isLastPos = (pos == tlist.size() - 1);
    @Override
        }
    /**
            return new SpanOrQuery(clauses);
    /**
    /**
            }
        Analyzer oldAnalyzer = getAnalyzer();
     * Sets whether the max query string length should be enforced in or not
            if (Regex.isMatchAllPattern(actualField)) {
import org.apache.lucene.search.BoostQuery;
        if (fuzzySlop.image.length() == 1) {
import static org.opensearch.common.lucene.search.Queries.newUnmappedFieldQuery;
                    + "] index level setting."
            }
/*
    }
        }
    private Query applyBoost(Query q, Float boost) {
        throws ParseException {
 * this work for additional information regarding copyright
                    + "] used in the [query_string] has exceeded "
        if (queries.size() == 1) {
        } finally {
    }
     * @param context The query shard context.
        if (tlist.size() == 0) {
 *
                currentPos.add(termAtt.toString());
        } else {
            );
            boolean multiFields = Regex.isSimpleMatchPattern(field);
        if ("*".equals(part1)) {
                part2Binary,
        }
            Analyzer normalizer = forceAnalyzer == null ? queryBuilder.context.getSearchAnalyzer(currentFieldType) : forceAnalyzer;
                    break;
            // Filters metadata fields if all fields are requested
        Map<String, Float> fieldsAndWeights,
                    + termStr.length()
 * KIND, either express or implied.  See the License for the
                } catch (IOException e) {
    /**
        builder.setSlop(slop);
            return query;
            throw e;
        }
import static org.opensearch.common.lucene.search.Queries.newLenientFieldQuery;
import org.apache.lucene.search.BoostAttribute;
        }
                if (c == '(') {
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
                } else if (queryText.charAt(0) == '<') {
 * A {@link XQueryParser} that uses the {@link MapperService} in order to build smarter
            }
            throw e;
 * SPDX-License-Identifier: Apache-2.0
                            return getRangeQuery(field, null, queryText.substring(2), true, true);
        }
        } else if (q instanceof SpanQuery spanQuery) {
     *                        Otherwise the query terms are only normalized.
            .fieldType(FieldNamesFieldMapper.NAME);
    }
        // Deep nesting can cause StackOverflowError due to Lucene's recursive grammar productions.
            Query q = getPrefixQuerySingle(entry.getKey(), termStr);
        this(
            } else if (!inQuotes) {
        }
            }
                throw new ParseException("'*' or '?' not allowed as first character in WildcardQuery");
        QueryShardContext context,
    /**
        }
     * @param defaultField The default field for query terms.
                tlist.add(currentPos);
import org.apache.lucene.search.MatchNoDocsQuery;
            part1 = null;
            if (allFields && this.field != null && this.field.equals(field)) {
        if (field != null) {
            if (lenient) {
                }
                getAnalyzer().normalize(field, termStr).utf8ToString(),
        }
        boolean endInclusive,
        super.setDefaultOperator(op);
            return getFieldQuery(field, queryText, getPhraseSlop());
     */
    @Override
        Analyzer oldAnalyzer = getAnalyzer();
        }
import org.opensearch.index.mapper.MapperService;
            boolean allFields = Regex.isMatchAllPattern(field);
    }
            return builder.build();
        if (fields.isEmpty()) {
    }
        return q;
            PositionIncrementAttribute posAtt = source.addAttribute(PositionIncrementAttribute.class);
            // query string query normalizes search value
            assert q != null;
                source.reset();
    private static final Logger logger = LogManager.getLogger(QueryStringQueryParser.class);
    protected Query getPrefixQuery(String field, String termStr) throws ParseException {
            return Queries.newMatchNoDocsQuery("Matching no documents because no terms present");
    private MultiMatchQueryBuilder.Type type = MultiMatchQueryBuilder.Type.BEST_FIELDS;
            throw new IllegalArgumentException(
     */
import org.opensearch.index.query.QueryShardContext;
        this.context = context;
                throw new ParseException(
            part2 = null;
        if (fieldNamesFieldType == null) {
        if (fields.isEmpty()) {
    }
        for (Map.Entry<String, Float> entry : fields.entrySet()) {
            return queries.get(0);
                }
            Query q = getFuzzyQuerySingle(entry.getKey(), termStr, minSimilarity);
        this.queryBuilder = new MultiMatchQuery(context);
        } catch (RuntimeException e) {
    }
import org.apache.lucene.search.MultiTermQuery;
                if (isLastPos) {
/**
        if (queries.isEmpty()) {
        if (currentFieldType == null) {
                clauses[pos++] = (SpanQuery) addSlopToSpan(clause, slop);
                    + " ("
            return newUnmappedFieldQuery(field);
            extractedFields = resolveMappingFields(context, fieldsAndWeights, quoteFieldSuffix);
    private PhraseQuery addSlopToPhrase(PhraseQuery query, int slop) {
                return null;
        return builder.build();
            return null;
        this(context, null, fieldsAndWeights, false, context.getMapperService().searchAnalyzer());
    private Fuzziness fuzziness = Fuzziness.AUTO;
     * @param lenient If set to `true` will cause format based failures (like providing text to a numeric field) to be ignored.
 * queries based on the mapping information.
                    + maxQueryNestingDepth
        boolean inQuotes = false;
            context.getMapperService().searchAnalyzer()
    private Query applySlop(Query q, int slop) {
                    + nestingDepth
    }
        int numEdits = Fuzziness.build(minimumSimilarity).asDistance(term.text());
            return newUnmappedFieldQuery(field);
            return applySlop(query, slop);
                } else if (c == ')') {
            if (plist.size() == 1) {
            queries.add(applyBoost(q, entry.getValue()));
    private Query getFuzzyQuerySingle(String field, String termStr, float minSimilarity) throws ParseException {
            return currentFieldType.prefixQuery(
            if (lenient) {
            return queries.get(0);
        Analyzer oldAnalyzer = getAnalyzer();
        } finally {
    protected Query newMatchAllDocsQuery() {
import org.opensearch.index.query.ExistsQueryBuilder;
     * Sets the maximum allowed parenthesis nesting depth for query strings.
            }
        TokenStream source = null;
import org.opensearch.index.mapper.TextSearchInfo;
        try {
            queryBuilder.setAnalyzer(oldAnalyzer);
    }
    @Override
    private ZoneId timeZone;
        } catch (RuntimeException e) {
        if (q == null) {
    }
        for (Map.Entry<String, Float> entry : fields.entrySet()) {
 * This class uses {@link MultiMatchQuery} to build the text query around operators and {@link XQueryParser}
                IOUtils.closeWhileHandlingException(source);
    private Query addSlopToSpan(SpanQuery query, int slop) {
    @Override
            return new BoostQuery(q, boost);
    }
        this.forceAnalyzer = analyzer;
            }
            if (currentFieldType == null || currentFieldType.getTextSearchInfo() == TextSearchInfo.NONE) {
    private static int maxQueryNestingDepth = SearchService.SEARCH_MAX_QUERY_NESTING_DEPTH.get(Settings.EMPTY);
/*
                        + " ("
 * Unless required by applicable law or agreed to in writing,
     * @param fuzziness Sets the default {@link Fuzziness} for fuzzy query.
            throw e;
            }
        }
                null,
                } else {
        }
     * recursive-descent classic query parser.
                return newUnmappedFieldQuery(field);
     * @param quoteFieldSuffix The suffix to append to fields for quoted parts of the query string.
    public void setFuzzyRewriteMethod(MultiTermQuery.RewriteMethod fuzzyRewriteMethod) {
        } else if (query instanceof SpanOrQuery spanOrQuery) {
        try {
     * @param fuzzyRewriteMethod Sets the default rewrite method for fuzzy query.
    }
 */
                extractedFields = fieldsAndWeights;
            return rangeQuery;
            List<String> plist = tlist.get(pos);
            queries.add(applyBoost(q, entry.getValue()));
    public static void setMaxQueryStringLengthMonitorMode(boolean monitorMode) {
        try {
import org.apache.lucene.queryparser.classic.XQueryParser;
package org.opensearch.index.search;
                null,
        } catch (RuntimeException e) {
        return getBooleanQuery(clauses);
        float distance = Fuzziness.build(fuzzySlop.image.substring(1)).asDistance(termImage);
        Map<String, Float> fields = extractMultiFields(field, false);
    }
        queryBuilder.setPhraseSlop(phraseSlop);
            return currentFieldType.normalizedWildcardQuery(termStr, getMultiTermRewriteMethod(), context);
            BytesRef part1Binary = part1 == null ? null : normalizer.normalize(field, part1);
    }
                return newLenientFieldQuery(field, e);
import java.util.Collections;
    }
        if (query instanceof SpanNearQuery spanNearQuery) {
        Map<String, Float> fields = extractMultiFields(field, false);
            return queryBuilder.context.getSearchAnalyzer(currentFieldType);
            if (q != null) {
        } finally {
    }
    @Override
            }
            // query string query is always normalized
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        this.analyzeWildcard = analyzeWildcard;
                    + SearchService.SEARCH_MAX_QUERY_NESTING_DEPTH.getKey()
            return new DisjunctionMaxQuery(queries, tiebreaker);
                try {
import static org.opensearch.index.search.QueryParserHelper.checkForTooManyFields;
    @SuppressWarnings("NonFinalStaticField")
    /**
            while (true) {
import org.opensearch.index.IndexSettings;
        QueryStringQueryParser.maxQueryStringLengthMonitorMode = monitorMode;
            float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
            // Filters unsupported fields if a pattern is requested
    protected Query newFuzzyQuery(Term term, float minimumSimilarity, int prefixLength) {
                return newLenientFieldQuery(field, e);
            queryBuilder.setPhraseSlop(slop);
        // build a boolean query with prefix on the last position only.
            // if there is no match in the mappings.
                    posQuery = currentFieldType.prefixQuery(plist.get(0), getMultiTermRewriteMethod(), context);
        this(context, null, fieldsAndWeights, lenient, context.getMapperService().searchAnalyzer());
        }
        }
        Analyzer oldAnalyzer = queryBuilder.analyzer;
            }
                    }
    }
    }
        queryBuilder.setZeroTermsQuery(MatchQuery.ZeroTermsQuery.NULL);
