 * observable consequence: every hit scores exactly 1.0 through the alias, identical to the same query against
        AliasActions add = AliasActions.add().index(INDEX).alias(ALIAS).filter(QueryBuilders.termQuery("dept", "cardiology"));
 * this file be licensed under the Apache-2.0 license or a
/*  
    public void testConstantScoreStaysConstantThroughFilteredAlias() throws Exception {
        // query were scored (different content lengths -> different norms).  
 * <b>filtered alias</b>. Adding the alias filter wraps the user's query in a {@link org.apache.lucene.search.BooleanQuery}  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest.AliasActions;
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
        }  
        SearchResponse viaBacking = client().prepareSearch(INDEX).setQuery(constantScoreAlpha).setSize(200).get();
            assertEquals("constant_score on backing index must score 1.0", 1.0f, hit.getScore(), 0.0f);
 * the backing index directly.
            .get();
    /** A constant_score query over "alpha" must score every hit exactly 1.0, on both the backing index and the
    private static final String INDEX = "docs";  
            prepareCreate(INDEX).setMapping("dept", "type=keyword", "content", "type=text")
 * <p>
        // Enough docs carrying the term that BM25 scoring would produce clearly non-1.0, varying scores if the
 * compatible open source license.
            client().prepareIndex(INDEX).setSource("dept", "cardiology", "content", ("alpha ".repeat(i % 5 + 1)) + "beta").get();
        client().prepareIndex(INDEX)
 * {@link DefaultSearchContext#buildFilteredQuery} re-wraps the filtered result in a {@code ConstantScoreQuery}
        refresh(INDEX);
 * Verifies that a {@code constant_score} query keeps its non-scoring behavior when it is run through a
 */  
            client().prepareIndex(INDEX).setSource("dept", "oncology", "content", "alpha gamma " + i).get();
}
        }  
import org.opensearch.test.OpenSearchIntegTestCase;  
        }  
        assertTrue("alias returns hits", viaAlias.getHits().getTotalHits().value() > 0);
public class ConstantScoreFilteredAliasIT extends OpenSearchIntegTestCase {
        );
            .setSource("dept", "cardiology", "content", "alpha probe")
        assertAcked(client().admin().indices().prepareAliases().addAliasAction(add));
    private void buildCorpus() throws Exception {  
        SearchResponse viaAlias = client().prepareSearch(ALIAS).setQuery(constantScoreAlpha).setSize(200).get();
 * {@link org.apache.lucene.search.ConstantScoreQuery} inside a <em>scoring</em> boolean, which both scores the
        assertTrue("backing index returns hits", viaBacking.getHits().getTotalHits().value() > 0);
        for (SearchHit hit : viaAlias.getHits().getHits()) {
package org.opensearch.search;
 */  
/**
        for (int i = 0; i < 50; i++) {
        assertAcked(
     *  filtered alias. Before the fix, the alias path scored hits (values != 1.0) because the alias filter  
import org.opensearch.common.settings.Settings;
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))  
 * SPDX-License-Identifier: Apache-2.0
    private static final String ALIAS = "docs_view";
    }  
        for (int i = 0; i < 50; i++) {
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.action.search.SearchResponse;
 * when the main query was already constant-scored, so the outermost query stays non-scoring. This asserts the  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        buildCorpus();  
 * The OpenSearch Contributors require contributions made to  
    }
 *
        var constantScoreAlpha = QueryBuilders.constantScoreQuery(QueryBuilders.matchQuery("content", "alpha"));
        for (SearchHit hit : viaBacking.getHits().getHits()) {
 * hits (breaking the "no scoring" contract) and defeats Lucene's no-scoring fast path.  
        }  
            assertEquals("constant_score through filtered alias must also score 1.0", 1.0f, hit.getScore(), 0.0f);
 * ({@code bool[query MUST, aliasFilter FILTER]}); without special handling this nests the
            .setRefreshPolicy(RefreshPolicy.IMMEDIATE)  
     *  nested the ConstantScoreQuery inside a scoring BooleanQuery. */
