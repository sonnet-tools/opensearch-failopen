import org.apache.lucene.search.TermQuery;
    private static FieldExistsQuery exists(String field) {
    public void testBareFieldExistsIsRewritten() {  
            if (clause.occur() == BooleanClause.Occur.MUST) {
 * interim rewrite that turns {@link FieldExistsQuery} (needs doc_values/norms, absent on the  
        assertNull("lower bound should be unbounded", trq.getLowerTerm());
    public void testLeafNonExistsReturnedAsSameInstance() {  
public class LuceneQueryConversionUtilsTests extends OpenSearchTestCase {  
 *
import org.apache.lucene.index.Term;
        DisjunctionMaxQuery in = new DisjunctionMaxQuery(List.of(exists("a"), new TermQuery(new Term("b", "x"))), 0.3f);
        assertNull("upper bound should be unbounded", trq.getUpperTerm());  
        );
        Query in = new TermQuery(new Term("f", "v"));
        Query out = LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(in);
import org.apache.lucene.search.MatchAllDocsQuery;
 * this file be licensed under the Apache-2.0 license or a
    }
        assertTrue("a FieldExistsQuery disjunct should have become a TermRangeQuery", sawRange);
import org.apache.lucene.search.TermRangeQuery;
        assertThat(out, instanceOf(BooleanQuery.class));
        boolean sawRange = dm.getDisjuncts().stream().anyMatch(q -> q instanceof TermRangeQuery);
 * compatible open source license.
import static org.hamcrest.MatcherAssert.assertThat;
    private static void assertExistsRewrite(Query rewritten, String field) {
    }  
        DisjunctionMaxQuery dm = (DisjunctionMaxQuery) out;
import org.opensearch.test.OpenSearchTestCase;  
/**
        assertSame(in, LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(in));  
    }  
        }
        Query out = LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(in);  
/*  
        BoostQuery boost = (BoostQuery) bool.clauses().get(0).query();  
            .build();
        assertTrue(LuceneQueryConversionUtils.containsFieldExists(new ConstantScoreQuery(exists("f"))));  
        assertEquals(field, trq.getField());
        assertThat(rewritten, instanceOf(TermRangeQuery.class));
        assertExistsRewrite(LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(exists("severityText")), "severityText");
}  
        assertEquals(0.3f, dm.getTieBreakerMultiplier(), 0.0f);  
    }  
 * lucene-secondary segment) into a postings-only {@link TermRangeQuery}.
    /** The q19/search shape: "_exists_:f AND NOT f:v" → Boolean{MUST exists, MUST_NOT term}. */
        assertFalse(LuceneQueryConversionUtils.containsFieldExists(new TermQuery(new Term("f", "v"))));
import org.apache.lucene.search.ConstantScoreQuery;
    public void testNestedWrappers() {
 */
        return new FieldExistsQuery(field);  
        assertExistsRewrite(boost.getQuery(), "deep");
import org.apache.lucene.search.BooleanQuery;  
 * SPDX-License-Identifier: Apache-2.0
 */  
        assertSame(in, LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(in));
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.BoostQuery;
    public void testContainsFieldExistsDetection() {
import java.util.List;
        assertThat(out, instanceOf(DisjunctionMaxQuery.class));
package org.opensearch.be.lucene;
        for (BooleanClause clause : bool.clauses()) {
    }
    public void testUnaffectedQueryReturnedAsSameInstance() {
    public void testFieldExistsUnderConstantScore() {
            .add(new MatchAllDocsQuery(), BooleanClause.Occur.FILTER)
        assertExistsRewrite(((ConstantScoreQuery) out).getQuery(), "f");
            .build();
        BooleanQuery bool = (BooleanQuery) out;
    }
    }
        assertExistsRewrite(((BoostQuery) out).getQuery(), "f");
        TermRangeQuery trq = (TermRangeQuery) rewritten;  
import org.apache.lucene.search.Query;  
    public void testFieldExistsUnderBooleanAndNot() {
            }  
        assertEquals(2, bool.clauses().size());  
        BooleanQuery in = new BooleanQuery.Builder().add(exists("severityText"), BooleanClause.Occur.MUST)  
        Query out = LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(in);  
    public void testFieldExistsUnderBoost() {
        assertThat(out, instanceOf(ConstantScoreQuery.class));
import org.apache.lucene.search.BooleanClause;
 * Unit tests for {@link LuceneQueryConversionUtils#rewriteFieldExistsForSecondary} — the
        Query out = LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(in);  
        Query in = new BoostQuery(exists("f"), 2.0f);  
    /** No FieldExistsQuery anywhere → same instance returned (no needless rebuild). */
import org.apache.lucene.search.FieldExistsQuery;
        Query in = new ConstantScoreQuery(  
            } else {
    /** A TermRangeQuery over {@code field} with both bounds null = "any term present". */  
    public void testFieldExistsUnderDisjunctionMax() {
                assertThat(clause.query(), instanceOf(TermQuery.class)); // untouched
            .add(new TermQuery(new Term("severityText", "INFO")), BooleanClause.Occur.MUST_NOT)
        Query in = new ConstantScoreQuery(exists("f"));
        BooleanQuery bool = (BooleanQuery) ((ConstantScoreQuery) out).getQuery();
        // unwrap CS -> Boolean -> Boost -> TermRangeQuery
    }
        Query out = LuceneQueryConversionUtils.rewriteFieldExistsForSecondary(in);  
import static org.hamcrest.Matchers.instanceOf;
            new BooleanQuery.Builder().add(new BoostQuery(exists("deep"), 1.5f), BooleanClause.Occur.SHOULD).build()
                assertExistsRewrite(clause.query(), "severityText");  
        Query in = new BooleanQuery.Builder().add(new TermQuery(new Term("f", "v")), BooleanClause.Occur.MUST)  
    }
import org.apache.lucene.search.DisjunctionMaxQuery;  
        assertEquals(2.0f, ((BoostQuery) out).getBoost(), 0.0f);  
        assertThat(out, instanceOf(BoostQuery.class));
    }
    }
