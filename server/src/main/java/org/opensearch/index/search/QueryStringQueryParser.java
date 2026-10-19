import org.opensearch.index.mapper.MappedFieldType;
 * software distributed under the License is distributed on an
    }
    /**
                null,
    }
        super(defaultField, analyzer);
            char c = query.charAt(i);  
            Query posQuery;  
            return existsQuery(actualField);  
            if (lenient) {
        if (queries.isEmpty()) {
            );  
     */
import org.apache.lucene.search.BoostQuery;
import org.apache.lucene.analysis.TokenStream;
        this(context, null, fieldsAndWeights, false, context.getMapperService().searchAnalyzer());
    public void setAutoGenerateMultiTermSynonymsPhraseQuery(boolean enable) {  
            }
import org.apache.lucene.queries.spans.SpanNearQuery;
    private Query getPossiblyAnalyzedPrefixQuery(String field, String termStr, MappedFieldType currentFieldType) throws ParseException {  
    private String quoteFieldSuffix;
            Query q = getWildcardQuerySingle(entry.getKey(), termStr);  
    public QueryStringQueryParser(QueryShardContext context, boolean lenient) {  
                context
            PositionIncrementAttribute posAtt = source.addAttribute(PositionIncrementAttribute.class);  
            return queryBuilder.context.getSearchAnalyzer(currentFieldType);
        } finally {
    public void setEnablePositionIncrements(boolean enable) {  
    static int maxParenthesisNestingDepth(String query) {
            } else {
        if (currentFieldType == null) {  
            return new DisjunctionMaxQuery(queries, tiebreaker);
                    + maxAllowedRegexLength
                return newLenientFieldQuery(field, e);
import org.opensearch.index.mapper.MapperService;
                "The length of regex ["  
                    }  
            if (lenient && !(e instanceof TooComplexToDeterminizeException)) {
     * @param fuzzyTranspositions Sets whether transpositions are supported in fuzzy queries.
        throws ParseException {  
            // query string query normalizes search value
        }  
     * @param analyzeWildcard If true, the wildcard operator analyzes the term to build a wildcard query.  
        QueryStringQueryParser.maxQueryNestingDepth = maxQueryNestingDepth;
import java.time.ZoneId;
import org.apache.lucene.util.BytesRef;
            // effectively, we check if a field exists or not
            assert q instanceof BoostQuery == false;
    protected Query getFuzzyQuery(String field, String termStr, float minSimilarity) throws ParseException {  
/*
                    return getRangeQuery(field, queryText, queryText, true, true);
        }
                    }
        List<BooleanClause> clauses = new ArrayList<>();
            extractedFields = resolveMappingFields(context, fieldsAndWeights, quoteFieldSuffix);
                        if (queryText.charAt(1) == '=') {
                new BooleanClause(posQuery, getDefaultOperator() == Operator.AND ? BooleanClause.Occur.MUST : BooleanClause.Occur.SHOULD)
            } else {  
                }
            termStr = getAnalyzer().normalize(currentFieldType.name(), termStr).utf8ToString();  
            lenient,
        } catch (RuntimeException e) {
     * @param fuzziness Sets the default {@link Fuzziness} for fuzzy query.
            );
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;  
    public void setFuzzyRewriteMethod(MultiTermQuery.RewriteMethod fuzzyRewriteMethod) {
    private static final Logger logger = LogManager.getLogger(QueryStringQueryParser.class);
            if (currentFieldType.getTextSearchInfo().isTokenized() == false) {
        }
import static org.opensearch.common.lucene.search.Queries.newLenientFieldQuery;
        int nestingDepth = maxParenthesisNestingDepth(query);
        if (fields.isEmpty()) {  
        this.quoteFieldSuffix = quoteFieldSuffix;
        } else if (quoted && quoteFieldSuffix != null) {
        Query q = super.getBooleanQuery(clauses);
import org.apache.lucene.search.BooleanClause;
        if (q instanceof PhraseQuery phraseQuery) {  
    }
        PhraseQuery.Builder builder = new PhraseQuery.Builder();
    public static void setMaxQueryStringLengthMonitorMode(boolean monitorMode) {
    }
            float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
        }  
            return currentFieldType.prefixQuery(
        }
            return applySlop(query, slop);
            // the requested fields do not match any field in the mapping
 * SPDX-License-Identifier: Apache-2.0
        TokenStream source = null;
    }
    }  
            }
            );  
        Map<String, Float> fields = extractMultiFields(field, quoted);  
 * GitHub history for details.
        }
            queryBuilder.setPhraseSlop(slop);
    }
            float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
            return rangeQuery;
        Map<String, Float> fields = extractMultiFields(field, false);
        } catch (IOException e) {
                if (c == '(') {
            if (forceAnalyzer != null && (analyzeWildcard || currentFieldType.getTextSearchInfo().isTokenized())) {
            // query string query is always normalized  
        Analyzer analyzer  
            }
            }
            throw e;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * The OpenSearch Contributors require contributions made to  
                    maxQueryStringLength,
            BytesRef part1Binary = part1 == null ? null : normalizer.normalize(field, part1);
                if (queryText.charAt(0) == '>') {  
        for (Map.Entry<String, Float> entry : fields.entrySet()) {  
            // make sure that the boost hasn't been set beforehand, otherwise we'd lose it
     * @param analyzer Force the provided analyzer to be used for all phrase query analysis regardless of the field.
import org.apache.lucene.search.WildcardQuery;
import org.opensearch.index.query.QueryShardContext;  
    public void setForceAnalyzer(Analyzer analyzer) {
    @Override  
import org.opensearch.common.lucene.search.Queries;
    /**
        if ("*".equals(termStr)) {
        }  
        this.groupTieBreaker = groupTieBreaker;
            tlist = new ArrayList<>();  
    @Override
    public void setType(MultiMatchQueryBuilder.Type type) {
     *                        Otherwise the query terms are only normalized.
     */  
        float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;
            // Lenient queries are intended for data type mismatches, but TooComplexToDeterminizeException  
        return ExistsQueryBuilder.newFilter(context, fieldName, false);
    private final Map<String, Float> fieldsAndWeights;
    /**  
                IOUtils.closeWhileHandlingException(source);
                    posQuery = newTermQuery(new Term(field, plist.get(0)), BoostAttribute.DEFAULT_BOOST);
        } else {  
            part2 = null;
    public void setAnalyzeWildcard(boolean analyzeWildcard) {  
                    query.length()
        float distance = Fuzziness.build(fuzzySlop.image.substring(1)).asDistance(termImage);
        }
    @Override  
            Query q = getPrefixQuerySingle(entry.getKey(), termStr);
    }
            );
                    + "] index level setting."
            }
        if (currentFieldType == null) {
            queries.add(applyBoost(q, entry.getValue()));  
                    posQuery = currentFieldType.prefixQuery(plist.get(0), getMultiTermRewriteMethod(), context);  
                posQuery = sb.build();
    /**
            Query query = null;
     */  
        for (Map.Entry<String, Float> entry : fields.entrySet()) {
        } else {
        Map<String, Float> fields = extractMultiFields(field, false);
     * @param quoteFieldSuffix The suffix to append to fields for quoted parts of the query string.
                getMultiTermRewriteMethod(),
            return addSlopToSpan(spanQuery, slop);  
            } else if (!inQuotes) {  
                );
            Query query = queryBuilder.parse(MultiMatchQueryBuilder.Type.PHRASE, fields, queryText, null);  
                part2Binary,  
     * @param context The query shard context.
            return queries.get(0);  
                    }
    private Query applyBoost(Query q, Float boost) {  
     * @param groupTieBreaker The tie breaker to apply when multiple fields are used.  
        } catch (RuntimeException e) {
            MappedFieldType currentFieldType = context.fieldMapper(field);
        }  
            // if there is no match in the mappings.
            extractedFields = fieldsAndWeights;
            if (getAllowLeadingWildcard() == false && (termStr.startsWith("*") || termStr.startsWith("?"))) {  
        Map<String, Float> fields = extractMultiFields(field, false);  
import org.opensearch.search.SearchService;
        if (field != null && EXISTS_FIELD.equals(field)) {
        } else if (query instanceof SpanOrQuery spanOrQuery) {  
                    + maxQueryNestingDepth
            // happens for wildcard fields only since we cannot expand to a valid field name  
 * Unless required by applicable law or agreed to in writing,
        final Term[] terms = query.getTerms();  
        }  
                // build a synonym query for terms in the same position.
     */
        }  
    @Override
            MappedFieldType currentFieldType = queryBuilder.context.fieldMapper(field);
        if (queries.size() == 1) {
        Map<String, Float> fields = extractMultiFields(field, false);
import org.opensearch.common.unit.Fuzziness;
            setAnalyzer(getSearchAnalyzer(currentFieldType));  
    /**
        }
        }  
        if (termStr.equals("*") && actualField != null) {
        // as logical operator by the query parser (e.g. age:>=10).  
                posQuery = getBooleanQuery(innerClauses);
                fuzzyMaxExpansions,
        final int[] positions = query.getPositions();
     * @param fieldsAndWeights The default fields and weights expansion for query terms.  
                queryBuilder.setAnalyzer(forceQuoteAnalyzer);
            List<String> plist = tlist.get(pos);
    }  
                        + " ("
    /**  
 * not use this file except in compliance with the License.
            part1 = null;
        if (fields.isEmpty()) {
        }
            if (lenient) {
            }
        List<Query> queries = new ArrayList<>();
            setAnalyzer(oldAnalyzer);
    }  
        }
            if (forceAnalyzer != null) {
            return currentFieldType.prefixQuery(tlist.get(0).get(0), getMultiTermRewriteMethod(), context);
    protected Query getPrefixQuery(String field, String termStr) throws ParseException {
    }
            resolveMappingField(context, "*", 1.0f, false, false, null),
    private static int maxQueryStringLength = SearchService.SEARCH_MAX_QUERY_STRING_LENGTH.get(Settings.EMPTY);
     */  
            return queries.get(0);
            }
import static org.opensearch.common.lucene.search.Queries.fixNegativeQueryIfNeeded;
        this.fieldsAndWeights = Collections.unmodifiableMap(fieldsAndWeights);
            throw new IllegalArgumentException(
    }  
        } finally {
            if (q != null) {  
        }
            queryBuilder.setAnalyzer(oldAnalyzer);
    }
        if (fields.isEmpty()) {
    /**
    }
                return null;
            // effectively, we check if a field exists or not
        }
                    + "); actual depth: "
        queryBuilder.setOccur(op == Operator.AND ? BooleanClause.Occur.MUST : BooleanClause.Occur.SHOULD);
            }
        for (Map.Entry<String, Float> entry : fields.entrySet()) {
    }
                    + "the allowed maximum of ["  
            if (currentFieldType == null || currentFieldType.getTextSearchInfo() == TextSearchInfo.NONE) {  
        // Detects additional operators '<', '<=', '>', '>=' to handle range query with one side unbounded.
            queryBuilder.setAnalyzer(oldAnalyzer);
        super.setDefaultOperator(op);
     */  
                        + maxQueryStringLength  
    private Analyzer getSearchAnalyzer(MappedFieldType currentFieldType) {  
     * This should be only called from SearchService on settings updates.
            return newUnmappedFieldQuery(field);
            }
        queryBuilder.setLenient(lenient);
import org.apache.lucene.index.Term;
    @Override  
    public void setQuoteFieldSuffix(String quoteFieldSuffix) {
            } else if (forceAnalyzer != null) {
                    break;  
    }
    private boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;
                try {  
            // The field_names_field is disabled so we switch to a wildcard query that matches all terms  
     */
    /**
    public QueryStringQueryParser(QueryShardContext context, String defaultField) {
                "Query string parenthesis nesting depth exceeds max allowed depth "
     */
        this(context, defaultField, Collections.emptyMap(), lenient, context.getMapperService().searchAnalyzer());
            float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;  
            throw new ParseException(  
    @Override
            try {  
            }
                    "Query string length exceeds max allowed length {} ({}); actual length: {}",
        boolean inQuotes = false;
    protected Query getWildcardQuery(String field, String termStr) throws ParseException {
            if (lenient) {  
    }  
                if (isLastPos) {
        QueryStringQueryParser.maxQueryStringLength = maxQueryStringLength;  
    protected Query newMatchAllDocsQuery() {
                    if (!source.incrementToken()) break;
                context
    /**
            if (currentPos.isEmpty() == false) {
        for (Map.Entry<String, Float> entry : fields.entrySet()) {  
    public QueryStringQueryParser(QueryShardContext context, Map<String, Float> fieldsAndWeights, boolean lenient) {  
    @Override
            return newUnmappedFieldQuery(field);
        try {
     */  
            return null;  
            }
                }
        }
        try {  
        );
package org.opensearch.index.search;
                    && context.fieldMapper(field).unwrap() instanceof DateFieldType
     * @param type Sets how multiple fields should be combined to build textual part queries.  
import org.apache.lucene.search.DisjunctionMaxQuery;
import org.apache.lucene.queryparser.classic.ParseException;
        this.fuzzyTranspositions = fuzzyTranspositions;  
    }
    private int fuzzyMaxExpansions = FuzzyQuery.defaultMaxExpansions;
                    "Query string length exceeds max allowed length "
    }
        if (fields.isEmpty()) {  
                queryBuilder.setAnalyzer(forceAnalyzer);  
    }  
            }
            BytesRef term = termStr == null ? null : normalizer.normalize(field, termStr);  
    }  
            if (allFields && this.field != null && this.field.equals(field)) {
    }  
                    return getRangeQuery(field, null, queryText.substring(1), true, false);
    public static void setMaxQueryStringLength(int maxQueryStringLength) {
    /**
        return Queries.newMatchAllQuery();  
 * @opensearch.internal
                        }
    /**  
    private Query getRegexpQuerySingle(String field, String termStr) throws ParseException {
        if (query instanceof SpanNearQuery spanNearQuery) {
                }  
    public void setFuzzyMaxExpansions(int fuzzyMaxExpansions) {
    protected Query getFieldQuery(String field, String queryText, int slop) throws ParseException {  
            throw e;  
    }
        }
 * the Apache License, Version 2.0 (the "License"); you may
                part1Binary,
            }
            }  
        boolean endInclusive,
                currentPos.add(termAtt.toString());  
                        }
            assert q != null;
     * Sets whether the max query string length should be enforced in or not
            }  
            context.getMapperService().searchAnalyzer()  
        }  
        this.type = type;  
            return newUnmappedFieldQuery(field);
        } else {
    public void setTimeZone(ZoneId timeZone) {
    protected Query newFuzzyQuery(Term term, float minimumSimilarity, int prefixLength) {
import org.apache.lucene.queries.spans.SpanQuery;
    private Query existsQuery(String fieldName) {
        String actualField = field != null ? field : this.field;  
import org.apache.lucene.search.BoostAttribute;  
                    if (queryText.length() > 2) {
    /**  
     * @param context The query shard context.
        return super.parse(query);
        builder.setSlop(slop);
/**
                for (String synonym : plist) {
        }  
    private final QueryShardContext context;  
    private Query getFuzzyQuerySingle(String field, String termStr, float minSimilarity) throws ParseException {
            queries.add(applyBoost(q, entry.getValue()));  
                } else if (c == ')') {  
            if (forceQuoteAnalyzer != null) {  
    public void setGroupTieBreaker(float groupTieBreaker) {
        if (fieldNamesFieldType == null) {
        }
        Analyzer oldAnalyzer = getAnalyzer();  
        return new FuzzyQuery(term, numEdits, prefixLength, fuzzyMaxExpansions, fuzzyTranspositions, fuzzyRewriteMethod);  
     */
                        if (queryText.charAt(1) == '=') {  
            return new SpanNearQuery(spanNearQuery.getClauses(), slop, spanNearQuery.isInOrder());
    ) {
     * @param analyzer Force the provided analyzer to be used for all query analysis regardless of the field.  
        boolean startInclusive,
 * KIND, either express or implied.  See the License for the
        } catch (RuntimeException e) {  
                    + "] used in the [query_string] has exceeded "
import java.util.ArrayList;
    public void setDefaultOperator(Operator op) {  
            if (currentFieldType == null) {
        Map<String, Float> extractedFields;
            setAnalyzer(oldAnalyzer);
    }
import org.apache.lucene.search.MultiTermQuery;  
        // Force the tie breaker in the query builder too  
import org.opensearch.index.mapper.FieldNamesFieldMapper;  
    private Query getRangeQuerySingle(  
    private Query getWildcardQuerySingle(String field, String termStr) throws ParseException {  
                    + nestingDepth  
 * A {@link XQueryParser} that uses the {@link MapperService} in order to build smarter  
            for (SpanQuery clause : spanOrQuery.getClauses()) {  
    public Query getFieldQuery(String field, String queryText, boolean quoted) throws ParseException {
        }  
 * license agreements. See the NOTICE file distributed with
            assert q != null;
     * Defaults to {@link Fuzziness#AUTO}.
                }
/*  
import java.io.IOException;  
        if (fields.isEmpty()) {
     * @param defaultField The default field for query terms.
    }  
public class QueryStringQueryParser extends XQueryParser {
    private static final String EXISTS_FIELD = "_exists_";  
     * @param timeZone Time Zone to be applied to any range query related to dates.
 *    http://www.apache.org/licenses/LICENSE-2.0
            return currentFieldType.normalizedWildcardQuery(termStr, getMultiTermRewriteMethod(), context);
     * @param defaultField The default field for query terms.
        Map<String, Float> fieldsAndWeights,
        }
                } else if (queryText.charAt(0) == '<') {
        } else {
    private Query applySlop(Query q, int slop) {
     * recursive-descent classic query parser.
     */  
        // build a boolean query with prefix on the last position only.
     */
        }
        return fixNegativeQueryIfNeeded(q);
        // Deep nesting can cause StackOverflowError due to Lucene's recursive grammar productions.  
     */
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
            List<String> currentPos = new ArrayList<>();
            return currentFieldType.regexpQuery(termStr, RegExp.ALL, 0, getDeterminizeWorkLimit(), getMultiTermRewriteMethod(), context);
            int pos = 0;
        int numEdits = Fuzziness.build(minimumSimilarity).asDistance(term.text());
        if (field != null) {  
        }
        MappedFieldType currentFieldType = context.fieldMapper(field);  
        queryBuilder.setZeroTermsQuery(MatchQuery.ZeroTermsQuery.NULL);  
        Analyzer oldAnalyzer = queryBuilder.analyzer;  
        }  
                        + "); actual length: "  
            } catch (IOException e) {  
        List<List<String>> tlist;
import org.apache.lucene.search.MultiPhraseQuery;
                    currentDepth--;
    public void setForceQuoteAnalyzer(Analyzer analyzer) {  
import static org.opensearch.index.search.QueryParserHelper.resolveMappingFields;  
    }  
        this.fuzzyRewriteMethod = fuzzyRewriteMethod;  
        }
            } else if (isLastPos == false) {
        List<Query> queries = new ArrayList<>();
    public QueryStringQueryParser(QueryShardContext context, Map<String, Float> fieldsAndWeights) {  
        } catch (IOException e) {
                setAnalyzer(forceAnalyzer);  
                SynonymQuery.Builder sb = new SynonymQuery.Builder(field);  
                } catch (IOException e) {
import static org.opensearch.index.search.QueryParserHelper.resolveMappingField;
        this(context, null, fieldsAndWeights, lenient, context.getMapperService().searchAnalyzer());
 * under the License.  
            return newUnmappedFieldQuery(field);  
import java.util.List;
    }
        } else if (q instanceof MultiPhraseQuery multiPhraseQuery) {
                queryBuilder.setAnalyzer(forceAnalyzer);
import org.apache.lucene.util.automaton.RegExp;  
    private MultiTermQuery.RewriteMethod fuzzyRewriteMethod = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;  
            return q;
     * Defaults to {@link FuzzyQuery#defaultTranspositions}.  
                timeZone,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
    private Float groupTieBreaker;  
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;
                );
    }  
    }  
 * specific language governing permissions and limitations
            );
     */
            // Filters metadata fields if all fields are requested
    }  
                    + SearchService.SEARCH_MAX_QUERY_NESTING_DEPTH.getKey()
    /**
import java.util.Map;
            BytesRef part2Binary = part2 == null ? null : normalizer.normalize(field, part2);  
                }  
            setAnalyzer(oldAnalyzer);
        if (field != null && EXISTS_FIELD.equals(field)) {
            return Queries.newMatchNoDocsQuery("Matching no documents because no terms present");  
    }  
                extractedFields = fieldsAndWeights;
                endInclusive,
                query = currentFieldType.prefixQuery(termStr, getMultiTermRewriteMethod(), context);  
        for (int i = 0; i < query.length(); i++) {
            queryBuilder.setPhraseSlop(oldSlop);  
            boolean isLastPos = (pos == tlist.size() - 1);
            }  
                List<BooleanClause> innerClauses = new ArrayList<>();  
 */  
                return newLenientFieldQuery(field, e);
        return builder.build();  
        }  
                    + "]. This maximum can be set by changing the ["
            context,
        } catch (RuntimeException e) {
    private Analyzer forceAnalyzer;
                tlist.add(currentPos);  
        this(context, defaultField, Collections.emptyMap(), false, context.getMapperService().searchAnalyzer());
        // Check parenthesis nesting depth before delegating to Lucene's recursive-descent parser.
        } finally {  
                            return getRangeQuery(field, null, queryText.substring(2), true, true);
    }
                for (String token : plist) {
        this.fuzziness = fuzziness;
        if (fields.isEmpty()) {
                fuzzyTranspositions,  
     * @param context The query shard context.  
        } else if (queries.size() == 1) {  
        this.lenient = lenient;
                logger.warn(  
                        maxDepth = currentDepth;
        if (fields.isEmpty()) {  
        if (fuzzySlop.image.length() == 1) {
        }  
            return getFieldQuery(field, queryText, getPhraseSlop());
        QueryShardContext context,
        List<Query> queries = new ArrayList<>();
    }
     * Defaults to all queryable fields extracted from the mapping for query terms
            return queryBuilder.parse(type, fields, queryText, null);  
    @Override
        if (queries.size() == 1) {
            if (c == '"') {
import org.opensearch.index.query.ExistsQueryBuilder;
                    + IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey()  
        }  
        return q;
                return newUnmappedFieldQuery(field);
        } finally {  
            }  
 * This class uses {@link MultiMatchQuery} to build the text query around operators and {@link XQueryParser}
        try {
                // Log a warning and continue
                    + termStr.length()
        boolean lenient,
        }
 */  
            if (currentFieldType == null) {
            return existsQuery(field);  
        }
    /**  
    /**
 *
    }  
        }  
            clauses.add(  
        this.fuzzyMaxExpansions = fuzzyMaxExpansions;
                startInclusive,
import org.apache.lucene.search.SynonymQuery;  
            if (forceAnalyzer != null) {  
            .fieldType(FieldNamesFieldMapper.NAME);
            assert q != null;
                source.reset();
                throw new ParseException("'*' or '?' not allowed as first character in WildcardQuery");
        if (query.trim().isEmpty()) {
        } else {  
        if (nestingDepth > maxQueryNestingDepth) {
            boolean allFields = Regex.isMatchAllPattern(field);
    public static void setMaxQueryNestingDepth(int maxQueryNestingDepth) {  
        }
        return getFuzzyQuery(field, termImage, distance);
import org.apache.lucene.queries.spans.SpanOrQuery;  
    }  
        }  
    @SuppressWarnings("NonFinalStaticField")
import org.apache.lucene.queryparser.classic.XQueryParser;
    }
    }  
     * @param lenient If set to `true` will cause format based failures (like providing text to a numeric field) to be ignored.
                return newMatchAllDocsQuery();  
        super.setEnablePositionIncrements(enable);
            return new DisjunctionMaxQuery(queries, tiebreaker);
        }
        this.forceQuoteAnalyzer = analyzer;
     * @param context The query shard context  
        checkForTooManyFields(extractedFields.size(), this.context, field);  
            builder.setSlop(slop);  
    private ZoneId timeZone;  
            MultiPhraseQuery.Builder builder = new MultiPhraseQuery.Builder(multiPhraseQuery);
            throw new ParseException(e.getMessage());  
        queryBuilder.setAutoGenerateSynonymsPhraseQuery(enable);
import org.opensearch.common.util.io.IOUtils;  
     * Computes the maximum parenthesis nesting depth in the given query string.  
 *  
            // Filters unsupported fields if a pattern is requested
            Query q = getRangeQuerySingle(entry.getKey(), part1, part2, startInclusive, endInclusive, context);  
    protected Query getBooleanQuery(List<BooleanClause> clauses) throws ParseException {  
    }  
    }
 */
            );
    public void setFuzziness(Fuzziness fuzziness) {
                }  
    private Query getPrefixQuerySingle(String field, String termStr) throws ParseException {
            }
            Analyzer normalizer = forceAnalyzer == null ? queryBuilder.context.getSearchAnalyzer(currentFieldType) : forceAnalyzer;
    /**
                // if we are querying a single date field, we also create a range query that leverages the time zone setting  
import java.util.Collections;  
            if (query == null) {
            CharTermAttribute termAtt = source.addAttribute(CharTermAttribute.class);
    }  
        Map<String, Float> fields = extractMultiFields(field, false);
            return query;
     */
                null,  
        return extractedFields;
     * This is a pre-parse check to prevent StackOverflowError in Lucene's
        return maxDepth;
            }
            Query q = getRegexpQuerySingle(entry.getKey(), termStr);
            return queries.get(0);
            }
            throw e;  
        if (quoted) {  
        if (queries.size() == 1) {
            return newUnmappedFieldQuery(termStr);
        }
        return getBooleanQuery(clauses);
                return newUnmappedFieldQuery(field);  
            return new MatchNoDocsQuery("No mappings yet");  
    }  
        }
            extractedFields = resolveMappingField(context, field, 1.0f, !allFields, !multiFields, quoted ? quoteFieldSuffix : null);  
                    sb.addTerm(new Term(field, synonym));
     */
                }
                return super.getWildcardQuery(currentFieldType.name(), termStr);
            queries.add(applyBoost(q, entry.getValue()));
            }  
        MappedFieldType currentFieldType = context.fieldMapper(field);
                } else {
    }
        if ("*".equals(part2)) {
            return getFuzzyQuery(field, termImage, fuzziness.asDistance(termImage));
    private Map<String, Float> extractMultiFields(String field, boolean quoted) {
        for (int pos = 0; pos < tlist.size(); pos++) {  
        final FieldNamesFieldMapper.FieldNamesFieldType fieldNamesFieldType = (FieldNamesFieldMapper.FieldNamesFieldType) context
            }
        List<Query> queries = new ArrayList<>();
            return existsQuery(queryText);
    private static boolean maxQueryStringLengthMonitorMode = SearchService.SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY.get(Settings.EMPTY);  
            return null;  
    @Override
    protected Query handleBareFuzzy(String field, Token fuzzySlop, String termImage) throws ParseException {  
            boolean multiFields = Regex.isSimpleMatchPattern(field);  
    /**  
        for (Map.Entry<String, Float> entry : fields.entrySet()) {
    public Query parse(String query) throws ParseException {
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    }
        }
import org.apache.lucene.analysis.Analyzer;  
}  
        String defaultField,  
     * @param fieldsAndWeights The default fields and weights expansion for query terms
    }
import org.opensearch.index.query.MultiMatchQueryBuilder;
    @Override
    @Override
        }
            }
        if (analyzeWildcard == false) {
            return currentFieldType.fuzzyQuery(
                setAnalyzer(forceAnalyzer);  
            return query;
     * Sets the maximum allowed parenthesis nesting depth for query strings.  
     * @param fuzzyRewriteMethod Sets the default rewrite method for fuzzy query.  
            // comes up from the same place in the code. Don't create a lenient query in this case.
        final int maxAllowedRegexLength = context.getIndexSettings().getMaxRegexLength();  
        }
        // It is required to use a prefix field operator to enable the detection since they are not treated
    public void setFuzzyTranspositions(boolean fuzzyTranspositions) {
            if (source != null) {  
import org.apache.lucene.search.FuzzyQuery;  
     * @param monitorMode if true, the max query string length will not be enforced
                term,
import org.opensearch.common.settings.Settings;
        queryBuilder.setEnablePositionIncrements(enable);
                    SearchService.SEARCH_MAX_QUERY_STRING_LENGTH.getKey(),  
    private PhraseQuery addSlopToPhrase(PhraseQuery query, int slop) {  
        } else {
                        + SearchService.SEARCH_MAX_QUERY_STRING_LENGTH.getKey()
    private boolean analyzeWildcard;
                if (currentPos.isEmpty() == false && posAtt.getPositionIncrement() > 0) {
            builder.add(terms[i], positions[i]);  
    private Query addSlopToSpan(SpanQuery query, int slop) {  
            } else {
                    currentDepth++;
        super.setPhraseSlop(phraseSlop);
import org.apache.lucene.search.MatchNoDocsQuery;
        if (queries.size() == 1) {  
                source = getAnalyzer().tokenStream(field, termStr);
            return newUnmappedFieldQuery(field);
    /**
        } else {
     */
import static org.opensearch.common.lucene.search.Queries.newUnmappedFieldQuery;  
import org.apache.lucene.queryparser.classic.Token;  
        Analyzer oldAnalyzer = getAnalyzer();
            if (Regex.isMatchAllPattern(actualField)) {
                query = getPossiblyAnalyzedPrefixQuery(currentFieldType.name(), termStr, currentFieldType);
import org.opensearch.common.regex.Regex;  
                context  
            return existsQuery(queryText);  
                    && this.timeZone != null) {  
    }  
        String part2,  
 * compatible open source license.
        } finally {
    protected Query getRangeQuery(String field, String part1, String part2, boolean startInclusive, boolean endInclusive)
     * Sets the maximum allowed length for query strings. This should be only called from SearchService on settings updates.  
        for (int i = 0; i < terms.length; ++i) {
            throw new ParseException(e.getMessage());
        if (tlist.size() == 1 && tlist.get(0).size() == 1) {  
        return forceAnalyzer;
            return new DisjunctionMaxQuery(queries, tiebreaker);  
            return null;
import org.apache.lucene.search.PhraseQuery;
 * You may obtain a copy of the License at  
 */  
        }  
        if (boost != null && boost != 1f) {
        }  
                throw new ParseException(
    /**
        try {  
        queryBuilder.setPhraseSlop(phraseSlop);
            return addSlopToPhrase(phraseQuery, slop);  
        // get Analyzer from superclass and tokenize the term  
            assert q != null;
     * @param fuzzyMaxExpansions Sets the maximum number of expansions allowed in a fuzzy query.
    private final MultiMatchQuery queryBuilder;
                clauses[pos++] = (SpanQuery) addSlopToSpan(clause, slop);
                return newLenientFieldQuery(field, e);  
        try {
    private Fuzziness fuzziness = Fuzziness.AUTO;
        }
            throw e;
    @Override
     */
        this.queryBuilder = new MultiMatchQuery(context);
            float tiebreaker = groupTieBreaker == null ? type.tieBreaker() : groupTieBreaker;  
                return newLenientFieldQuery(field, e);
            if (maxQueryStringLengthMonitorMode) {
        int oldSlop = queryBuilder.phraseSlop;
            return new WildcardQuery(new Term(fieldName, "*"));
import org.opensearch.index.IndexSettings;
        int currentDepth = 0;  
        return new DisjunctionMaxQuery(queries, tiebreaker);  
     * Rebuild a phrase query with a slop value
            }
import org.apache.logging.log4j.LogManager;
        Analyzer oldAnalyzer = getAnalyzer();
        if (query.length() > maxQueryStringLength) {  
                getFuzzyPrefixLength(),
                return newUnmappedFieldQuery(field);  
        this.timeZone = timeZone;
            }
        this(
                fuzzyRewriteMethod,
        }
                        + query.length()
                // "*" is the default field  
    }
        if (termStr.length() > maxAllowedRegexLength) {
            if (queryText.length() > 1) {
            }
    }
     * @param lenient If set to `true` will cause format based failures (like providing text to a numeric field) to be ignored.
        Analyzer oldAnalyzer = queryBuilder.analyzer;
        if (tlist.size() == 0) {
 * this work for additional information regarding copyright
     * Defaults to {@link FuzzyQuery#defaultMaxExpansions}.
        try {
        if (q == null) {
 * queries based on the mapping information.
        this.forceAnalyzer = analyzer;  
 * this file be licensed under the Apache-2.0 license or a
        } catch (RuntimeException e) {
 *
        String part1,
        if ("*".equals(part1)) {
import static org.opensearch.index.search.QueryParserHelper.checkForTooManyFields;
 * to assemble the result logically.  
                            return getRangeQuery(field, queryText.substring(2), null, true, true);  
            MappedFieldType currentFieldType = queryBuilder.context.fieldMapper(field);
        }
                    if (currentDepth > maxDepth) {  
        }
        }
 *
                return super.getPrefixQuery(field, termStr);
import org.opensearch.index.mapper.TextSearchInfo;  
        try {  
    /**
    @Override
    /**
                    innerClauses.add(new BooleanClause(super.getPrefixQuery(field, token), BooleanClause.Occur.SHOULD));
    public QueryStringQueryParser(QueryShardContext context, String defaultField, boolean lenient) {
            "*",  
        List<Query> queries = new ArrayList<>();  
        int maxDepth = 0;
    public void setPhraseSlop(int phraseSlop) {  
    ) {
            queries.add(applyBoost(q, entry.getValue()));
        }  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        if (fieldNamesFieldType.isEnabled() == false) {
            return builder.build();
    private MultiMatchQueryBuilder.Type type = MultiMatchQueryBuilder.Type.BEST_FIELDS;
            Analyzer normalizer = forceAnalyzer == null ? queryBuilder.context.getSearchAnalyzer(currentFieldType) : forceAnalyzer;
        } finally {
        if (forceAnalyzer == null) {
                queries.add(applyBoost(q, entry.getValue()));
            return newUnmappedFieldQuery(termStr);
            }  
        this.context = context;  
        this.analyzeWildcard = analyzeWildcard;
        QueryStringQueryParser.maxQueryStringLengthMonitorMode = monitorMode;
            while (true) {
            if (plist.size() == 1) {
                if (context.fieldMapper(field) != null
    }
            return newUnmappedFieldQuery(field);
        String field,
        queryBuilder.setTieBreaker(groupTieBreaker);
                inQuotes = !inQuotes;
    @Override  
        QueryShardContext context  
    private final boolean lenient;
    protected Query getRegexpQuery(String field, String termStr) throws ParseException {
            throw e;
            if (lenient) {  
import org.apache.lucene.search.Query;
                    tlist.add(currentPos);  
                }
            Query rangeQuery = currentFieldType.rangeQuery(
            return queries.get(0);  
     * @param context The query shard context  
     * @param lenient If set to `true` will cause format based failures (like providing text to a numeric field) to be ignored.
        try {
            return queries.get(0);
                    return getRangeQuery(field, queryText.substring(1), null, false, true);  
                Fuzziness.fromEdits((int) minSimilarity),  
        }  
        }
        }
import org.apache.logging.log4j.Logger;
        if (field != null) {
            SpanQuery[] clauses = new SpanQuery[spanOrQuery.getClauses().length];
    }
     */
/*  
    private Analyzer forceQuoteAnalyzer;  
                return newLenientFieldQuery(field, e);  
                getAnalyzer().normalize(field, termStr).utf8ToString(),  
     */  
    private static int maxQueryNestingDepth = SearchService.SEARCH_MAX_QUERY_NESTING_DEPTH.get(Settings.EMPTY);
     */  
            return new BoostQuery(q, boost);
            Query q = getFuzzyQuerySingle(entry.getKey(), termStr, minSimilarity);
                    if (queryText.length() > 2) {
    private QueryStringQueryParser(
            return new DisjunctionMaxQuery(queries, tiebreaker);
                    + " ("  
        } else if (q instanceof SpanQuery spanQuery) {
    }
            return newUnmappedFieldQuery(termStr);  
            return new SpanOrQuery(clauses);  
                    currentPos = new ArrayList<>();
        Map<String, Float> fields = extractMultiFields(field, true);
 * Licensed to Elasticsearch under one or more contributor  
            .getMapperService()  
