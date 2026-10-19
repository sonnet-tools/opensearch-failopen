/**  
            for (Query disjunct : disjunctionMax.getDisjuncts()) {
 * match_only_text fields — their doc_values live in the parquet primary. Some queries that
     *  
        }  
            }
     * <p>This reaches us via the {@code query_string} the PPL {@code search} command compiles for
            // FieldExistsQuery reports itself only via visitLeaf, gated by acceptField.
                builder.add(rewritten, clause.occur());
        });  
            boolean changed = false;
 *  
 * <p>The secondary segment stores only the inverted index (postings) for keyword / text /
                    + ": "
import org.apache.lucene.search.Query;
        // doc-values, so unwrap to just the index query (TermRangeQuery against the term dictionary).
import org.apache.lucene.search.ConstantScoreQuery;
 * Helpers for adapting Lucene {@link Query} trees so they can execute against the
                    + query  
        }
        if (containsFieldExists(query)) {  
 * <b>lucene-secondary</b> segment of a composite parquet-primary index.
    static boolean containsFieldExists(Query query) {
import org.apache.lucene.search.FieldExistsQuery;  
            Query inner = rewriteFieldExistsForSecondary(constantScore.getQuery());
     * them and rebuild only the branches that changed (reference-equality short-circuit). Any other  
     * be deleted.  
import org.apache.lucene.search.IndexOrDocValuesQuery;
import java.util.ArrayList;  
            public void visitLeaf(Query leaf) {
import org.apache.lucene.search.DisjunctionMaxQuery;
                changed |= r != disjunct;
 * The OpenSearch Contributors require contributions made to  
     *
import java.util.List;
    /**
        if (query instanceof DisjunctionMaxQuery disjunctionMax) {
     * <p><b>Interim:</b> the clean long-term fix is for the secondary to read doc_values out of the
     *  
     * rather than the cryptic Lucene error at {@code searcher.rewrite()}.
            boolean changed = false;  
            return new TermRangeQuery(fieldExists.getField(), null, null, true, true);
            for (BooleanClause clause : bool.clauses()) {
            return changed ? new DisjunctionMaxQuery(rewritten, disjunctionMax.getTieBreakerMultiplier()) : disjunctionMax;
}  
                "Unhandled query container wrapping a FieldExistsQuery on a doc-values-less secondary "
            public QueryVisitor getSubVisitor(BooleanClause.Occur occur, Query parent) {
     * ConstantScore, Boost, or DisjunctionMax (multi-field) wrappers, so we recurse through all of
        if (query instanceof ConstantScoreQuery constantScore) {
                    found[0] = true;  
                    + query.getClass().getName()
     * match_only_text types that filter delegation supports.  
 * compatible open source license.
            }  
     *         when nothing changed
     * {@code QueryStringQueryParser} can nest the {@link FieldExistsQuery} under Boolean (AND/OR/NOT),
            @Override
            return rewriteFieldExistsForSecondary(idv.getIndexQuery());
/*  
        boolean[] found = { false };
            return inner == boost.getQuery() ? boost : new BoostQuery(inner, boost.getBoost());
        if (query instanceof BooleanQuery bool) {  
            // null lower/upper bound = unbounded both ends = "any term present for this field".
            }
 * this file be licensed under the Apache-2.0 license or a
 * those need rewriting to a postings-only equivalent here.
     * A {@link TermRangeQuery} with null bounds matches any doc that has ≥1 indexed term for the
     * @param query the compiled Lucene query (non-null)
import org.apache.lucene.search.TermRangeQuery;
     * parquet primary, after which {@link FieldExistsQuery} resolves natively and this rewrite can
package org.opensearch.be.lucene;
     * {@code FieldExistsQuery.rewrite()} throws ("indexes neither doc values, norms nor vectors").  
                return true;
     * @return an equivalent query with all {@link FieldExistsQuery}s rewritten; the same instance  
import org.apache.lucene.search.BooleanClause;
            return inner == constantScore.getQuery() ? constantScore : new ConstantScoreQuery(inner);  
     * Rewrite every {@link FieldExistsQuery} in {@code query} to a postings-only existence query.
                return this;  
import org.apache.lucene.search.BooleanQuery;
        if (query instanceof FieldExistsQuery fieldExists) {  
     * field — semantically equivalent to "field exists" for the postings-indexed keyword/text/
        if (query instanceof BoostQuery boost) {
     * {@code !=} / {@code NOT} / {@code _exists_} (e.g. {@code "_exists_:f AND NOT f:v"}). The  
 * OpenSearch builds assume doc_values are present on the same segment they execute against;  
    private LuceneQueryConversionUtils() {}
                Query rewritten = rewriteFieldExistsForSecondary(clause.query());
                    + "segment; rewriteFieldExistsForSecondary must cover "  
import org.apache.lucene.search.QueryVisitor;  
     * <p><b>Why:</b> {@code MappedFieldType.existsQuery} emits a {@link FieldExistsQuery} whenever
 */
public final class LuceneQueryConversionUtils {  
        query.visit(new QueryVisitor() {  
        }
    }
            return changed ? builder.build() : bool;  
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
 * SPDX-License-Identifier: Apache-2.0
    /** True if {@code query} contains a {@link FieldExistsQuery} anywhere in its subtree. */  
import org.apache.lucene.search.BoostQuery;  
 *
        return found[0];
    }
                Query r = rewriteFieldExistsForSecondary(disjunct);  
            @Override  
    public static Query rewriteFieldExistsForSecondary(Query query) {  
 */  
            builder.setMinimumNumberShouldMatch(bool.getMinimumNumberShouldMatch());
     */
            }
        }
            throw new IllegalStateException(
     * the mapping declares doc_values. On the secondary segment those doc_values are absent, and
        }
            @Override
            List<Query> rewritten = new ArrayList<>(disjunctionMax.getDisjuncts().size());  
        }
            Query inner = rewriteFieldExistsForSecondary(boost.getQuery());  
            );
     * container that still hides a {@link FieldExistsQuery} fails fast with an actionable message
            }
     *
            public boolean acceptField(String field) {  
        if (query instanceof IndexOrDocValuesQuery idv) {  
                }
        // IndexOrDocValuesQuery wraps an index query + a doc-values query; the secondary has no
                changed |= rewritten != clause.query();  
                rewritten.add(r);
                if (leaf instanceof FieldExistsQuery) {
        return query;  
        }
