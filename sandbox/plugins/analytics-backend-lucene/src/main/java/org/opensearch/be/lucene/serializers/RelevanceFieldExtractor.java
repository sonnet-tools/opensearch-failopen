        if (QUERY_STRING_FUNCTIONS.contains(functionName) && operands.query() != null) {  
    }
            public void consumeTerms(Query q, Term... terms) {
 *
 * simply delegate their {@code referencedFields} to this helper.
                }  
     *                       the query string is parsed for in-string fields, and used for log context
    /** Field name for the EXISTS pseudo-operator: {@code _exists_:status} references field {@code status}. */  
            public boolean acceptField(String field) {
    /**  
                queryString,  
import java.util.List;  
    private static boolean resolveLenient(Map<String, String> optionalParams) {
        // 2. Only query_string carries in-string field:value syntax; parse it for in-string fields.
     * future functions here. Entries match the serializers' {@code functionName()}.  
import org.apache.lucene.queryparser.classic.ParseException;
        }  
     * Sentinel default field for parsing {@code query_string} bodies. Unqualified terms resolve to
     */
 *  
     * Effective lenient flag: the explicit {@code lenient} param when present, otherwise {@code false}  
        Map<String, String> optionalParams
            collectInStringFields(functionName, operands.query(), tokens);
     * query string is additionally parsed for in-string fields only when {@code functionName} is a
     * <p>Best-effort: the plan-time parser does not implement OpenSearch's {@code query_string}
     * Relevance functions whose query string carries in-string {@code field:value} syntax and should
    static FieldReferences referencedFields(
     * (assume non-lenient when unset). Treating unset as non-lenient preserves the planner's eager
     * @param optionalParams the predicate's optional key/value params; the {@code lenient} flag is
            );
     * named field (its term text) rather than {@code _exists_}.  
        }  
     * <p>Explicit {@code fields}/{@code field} tokens are collected for every relevance function; the  
                literalFields.add(token);
            tokens.add(operands.fieldName());
            if (Regex.isSimpleMatchPattern(token)) {
import org.apache.logging.log4j.LogManager;
import org.opensearch.analytics.spi.FieldReferences;
    /**  
    /**
                for (Term term : terms) {
 * SPDX-License-Identifier: Apache-2.0
     * extraction is skipped and validation relies on the explicit {@code fields} operand — the
     * Parses the query string with Lucene's classic grammar and records every field a leaf clause
import org.apache.lucene.search.Query;  
        List<String> literalFields = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
     * rejection of explicitly-named non-text fields; an explicit {@code lenient=true} opts out.
     *
                functionName,
final class RelevanceFieldExtractor {
package org.opensearch.be.lucene.serializers;
                // Skip the sentinel (unqualified terms) and _exists_ (handled via term text below).
            }
                patternTokens.add(token);  
        String value = optionalParams.get("lenient");
        try {  
            @Override  
    }  
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.index.Term;  
 * OpenSearch's resolver uses — so plan-time classification matches runtime. Only literals are validated  
     * touches. The sentinel default field marks fan-out; {@code _exists_:field} contributes the
        String functionName,
 * <p>Explicit field tokens come from the already-parsed {@link ConversionUtils.RelevanceOperands}
     * {@code simple_query_string}/{@code multi_match} have no in-string field grammar (a {@code :} is
 * For {@code query_string} only, the query string is additionally parsed with Lucene's classic grammar  
 * by the planner; patterns and fan-out pass through.
        } catch (ParseException | RuntimeException e) {
    /**
 * compatible open source license.
            @Override  
    private static final Logger LOGGER = LogManager.getLogger(RelevanceFieldExtractor.class);
     * query-string-style function (see {@link #QUERY_STRING_FUNCTIONS}).
import org.opensearch.be.lucene.ConversionUtils;  
        // 1. Explicit fields from the `fields`/`field` operand (already mapping-resolved for $ref forms).  
 * @opensearch.internal  
    private static final Set<String> QUERY_STRING_FUNCTIONS = Set.of("query_string");
        ConversionUtils.RelevanceOperands operands,  
 * Tokens are classified literal vs. pattern via {@link Regex#isSimpleMatchPattern} — the same predicate
                return true;  
        return new FieldReferences(literalFields, patternTokens, resolveLenient(optionalParams));  
                "[{}] skipping in-string field extraction; query string not parseable by plan-time parser [{}]: {}",
            }  
/*  
     *
        for (String token : tokens) {
     * Computes the referenced fields for a relevance predicate.
     * treated literally), so their referenced fields come solely from the {@code fields} operand. Add
        }
        return value != null && Boolean.parseBoolean(value);  
     */
        // 3. Classify literal vs. pattern; only literals are validated by the planner.
    private static final String EXISTS_FIELD = "_exists_";
    }
 * (no-op analyzer) to collect fields written inside it (e.g. {@code category:A}, {@code _exists_:status}).
    private static void collectInStringFields(String functionName, String queryString, Set<String> tokens) {
import org.opensearch.common.regex.Regex;
import java.util.ArrayList;
        List<String> patternTokens = new ArrayList<>();  
     */  
                }
     * field and are not emitted as field references.  
                    if (EXISTS_FIELD.equals(term.field())) {  
                        tokens.add(term.text());
     * extensions (e.g. {@code field:>15} unbounded ranges). On any parse failure, in-string  
import org.apache.lucene.search.QueryVisitor;
        }
        if (operands.fieldName() != null) {
                    }
        // Collect referenced field tokens in first-appearance order, deduped.  
 */
import org.opensearch.common.lucene.Lucene;
            query = parser.parse(queryString);
                    tokens.add(field);
            } else {
        Query query;
            tokens.addAll(operands.fields());
import java.util.LinkedHashSet;
    private RelevanceFieldExtractor() {}
/**
            return;  
}
 * plan-time field-type validation. Kept separate from the serializers so the serializer base stays  
                if (DEFAULT_FIELD_SENTINEL.equals(field) == false && EXISTS_FIELD.equals(field) == false) {  
 * Derives the {@link FieldReferences} a multi-field relevance predicate references, for the planner's
     *  
        parser.setAllowLeadingWildcard(true);
        Set<String> tokens = new LinkedHashSet<>();
 * (the same operands the serializer builds its query from, so extraction cannot drift from execution).
 */  
import java.util.Map;
        if (operands.fields() != null) {
    private static final String DEFAULT_FIELD_SENTINEL = "\u0000__analytics_default_field__";
     *                       read from here (absent → non-lenient, preserving eager rejection)
 *
     * this field; it is skipped rather than emitted as a reference. Uses a control char so it can
            }
        query.visit(new QueryVisitor() {
                e.getMessage()
     * therefore be parsed for in-string fields. Only {@code query_string} qualifies today;  
     */  
        });
     * authoritative parse happens at execution. Unqualified terms resolve to the sentinel default
     * @param functionName   the relevance function name (e.g. {@code "query_string"}); decides whether
 * focused on building {@link org.opensearch.index.query.QueryBuilder}s; the relevance serializers
import org.apache.logging.log4j.Logger;
     * never collide with a real mapping field name.  
        QueryParser parser = new QueryParser(DEFAULT_FIELD_SENTINEL, Lucene.KEYWORD_ANALYZER);  
import java.util.Set;
     */
    /**  
 * this file be licensed under the Apache-2.0 license or a
        }
            LOGGER.warn(  
     * @param operands       the predicate's extracted operands (fields, query, etc.)  
    ) {
