     *                       the query string is parsed for in-string fields, and used for log context
     * @param optionalParams the predicate's optional key/value params; the {@code lenient} flag is
    /**
        QueryParser parser = new QueryParser(DEFAULT_FIELD_SENTINEL, Lucene.KEYWORD_ANALYZER);
                }
 * SPDX-License-Identifier: Apache-2.0
        try {
     * this field; it is skipped rather than emitted as a reference. Uses a control char so it can
import java.util.Set;
        String functionName,
            tokens.addAll(operands.fields());
     * Relevance functions whose query string carries in-string {@code field:value} syntax and should
 */
     * @param functionName   the relevance function name (e.g. {@code "query_string"}); decides whether
import org.apache.logging.log4j.Logger;
    }
     */
 * compatible open source license.
            @Override
import org.apache.lucene.queryparser.classic.QueryParser;
            }
 * @opensearch.internal
                "[{}] skipping in-string field extraction; query string not parseable by plan-time parser [{}]: {}",
        List<String> literalFields = new ArrayList<>();
    private static final String DEFAULT_FIELD_SENTINEL = "\u0000__analytics_default_field__";
     * @param operands       the predicate's extracted operands (fields, query, etc.)
     * touches. The sentinel default field marks fan-out; {@code _exists_:field} contributes the
     * Parses the query string with Lucene's classic grammar and records every field a leaf clause
     * query string is additionally parsed for in-string fields only when {@code functionName} is a
     * field and are not emitted as field references.
            public boolean acceptField(String field) {
     */
 */
 * (the same operands the serializer builds its query from, so extraction cannot drift from execution).
 * OpenSearch's resolver uses — so plan-time classification matches runtime. Only literals are validated
import java.util.LinkedHashSet;
            public void consumeTerms(Query q, Term... terms) {
     * Effective lenient flag: the explicit {@code lenient} param when present, otherwise {@code false}
        }
     */
import org.apache.lucene.search.QueryVisitor;
import org.opensearch.common.regex.Regex;
        // 1. Explicit fields from the `fields`/`field` operand (already mapping-resolved for $ref forms).
            return;
 * The OpenSearch Contributors require contributions made to
            LOGGER.warn(
    private static final Logger LOGGER = LogManager.getLogger(RelevanceFieldExtractor.class);
     *
     * query-string-style function (see {@link #QUERY_STRING_FUNCTIONS}).
import org.opensearch.common.lucene.Lucene;
 * plan-time field-type validation. Kept separate from the serializers so the serializer base stays
 * focused on building {@link org.opensearch.index.query.QueryBuilder}s; the relevance serializers
 * Tokens are classified literal vs. pattern via {@link Regex#isSimpleMatchPattern} — the same predicate
            } else {
import org.apache.lucene.index.Term;
    /** Field name for the EXISTS pseudo-operator: {@code _exists_:status} references field {@code status}. */
 *
     * extraction is skipped and validation relies on the explicit {@code fields} operand — the
        ConversionUtils.RelevanceOperands operands,
import java.util.List;
    /**
    }
 * For {@code query_string} only, the query string is additionally parsed with Lucene's classic grammar
import java.util.ArrayList;
                patternTokens.add(token);
        query.visit(new QueryVisitor() {
                e.getMessage()
        Query query;
import org.opensearch.analytics.spi.FieldReferences;
        Set<String> tokens = new LinkedHashSet<>();
 *
                    if (EXISTS_FIELD.equals(term.field())) {
        if (operands.fieldName() != null) {
        }
            }
        parser.setAllowLeadingWildcard(true);
     * named field (its term text) rather than {@code _exists_}.
     *                       read from here (absent → non-lenient, preserving eager rejection)
 * by the planner; patterns and fan-out pass through.
        });
    private static boolean resolveLenient(Map<String, String> optionalParams) {
     * never collide with a real mapping field name.
        String value = optionalParams.get("lenient");
     * rejection of explicitly-named non-text fields; an explicit {@code lenient=true} opts out.
     * treated literally), so their referenced fields come solely from the {@code fields} operand. Add
 * Derives the {@link FieldReferences} a multi-field relevance predicate references, for the planner's
import java.util.Map;
}
        // Collect referenced field tokens in first-appearance order, deduped.
     * (assume non-lenient when unset). Treating unset as non-lenient preserves the planner's eager
    }
final class RelevanceFieldExtractor {
            query = parser.parse(queryString);
        if (QUERY_STRING_FUNCTIONS.contains(functionName) && operands.query() != null) {
            }
     * Computes the referenced fields for a relevance predicate.
        }
                literalFields.add(token);
        Map<String, String> optionalParams
                        tokens.add(term.text());
                if (DEFAULT_FIELD_SENTINEL.equals(field) == false && EXISTS_FIELD.equals(field) == false) {
    private static final Set<String> QUERY_STRING_FUNCTIONS = Set.of("query_string");
 * simply delegate their {@code referencedFields} to this helper.
            );
     * authoritative parse happens at execution. Unqualified terms resolve to the sentinel default
        }
        } catch (ParseException | RuntimeException e) {
        for (String token : tokens) {
                queryString,
    /**
/**
 * (no-op analyzer) to collect fields written inside it (e.g. {@code category:A}, {@code _exists_:status}).
        return new FieldReferences(literalFields, patternTokens, resolveLenient(optionalParams));
package org.opensearch.be.lucene.serializers;
                }
            @Override
 * <p>Explicit field tokens come from the already-parsed {@link ConversionUtils.RelevanceOperands}
     * future functions here. Entries match the serializers' {@code functionName()}.
import org.opensearch.be.lucene.ConversionUtils;
    private RelevanceFieldExtractor() {}
            collectInStringFields(functionName, operands.query(), tokens);
     *
                    tokens.add(field);
import org.apache.lucene.queryparser.classic.ParseException;
    ) {
        // 3. Classify literal vs. pattern; only literals are validated by the planner.
 * this file be licensed under the Apache-2.0 license or a
 *
     * Sentinel default field for parsing {@code query_string} bodies. Unqualified terms resolve to
        List<String> patternTokens = new ArrayList<>();
    private static final String EXISTS_FIELD = "_exists_";
     */
    /**
     * <p>Explicit {@code fields}/{@code field} tokens are collected for every relevance function; the
            tokens.add(operands.fieldName());
        // 2. Only query_string carries in-string field:value syntax; parse it for in-string fields.
     * {@code simple_query_string}/{@code multi_match} have no in-string field grammar (a {@code :} is
import org.apache.logging.log4j.LogManager;
    static FieldReferences referencedFields(
/*
                return true;
                functionName,
     * therefore be parsed for in-string fields. Only {@code query_string} qualifies today;
                for (Term term : terms) {
     * extensions (e.g. {@code field:>15} unbounded ranges). On any parse failure, in-string
        }
     *
    /**
     */
     * <p>Best-effort: the plan-time parser does not implement OpenSearch's {@code query_string}
                    }
        return value != null && Boolean.parseBoolean(value);
import org.apache.lucene.search.Query;
        if (operands.fields() != null) {
                // Skip the sentinel (unqualified terms) and _exists_ (handled via term text below).
    private static void collectInStringFields(String functionName, String queryString, Set<String> tokens) {
            if (Regex.isSimpleMatchPattern(token)) {
