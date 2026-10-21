    public void testSortByVersion() throws IOException {
            {
     */
     */
    /**
        assertSearchResponse(response);
    }
     * 1.1.0 (Ignore)
     * 1.0.1 (Ignore)
import org.opensearch.action.get.GetResponse;
    }
     * @throws IOException
            {
     */
     * 1.0.0-alpha (Ignore)
            }""";
    /**
     * 1.0.0-beta (Ignore)
     * 1.0.0-beta (Ignore)
     * 1.0.0 (Ignore)
            .get();
        response = client().prepareSearch("test").setQuery(QueryBuilders.existsQuery("non_existent_field")).get();
     * @throws IOException
        assertHitCount(response, 4);
     * @throws IOException
    public void testExistsQuery() throws IOException {
        client().index(new IndexRequest("test").id("5").source(doc5, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
        assertSearchResponse(response);
        assertSearchResponse(response);
     * Fourth hit: 1.0.0+build.123
        SearchResponse response = client().prepareSearch("test")
     * 1.1.0 (Ignore)
    }
     * 1.0.1 (Match)
            }""";
        client().index(new IndexRequest("test").id("1").source(doc1, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     * 1.0.0+build.123 (Match)
    public void testMatchQuery() throws IOException {
    /**
            .get();
        assertHitCount(response, 1); // Should match "1.0.0" if analyzed, or 0 if not.
        assertHitCount(response, 0);
                    .must(QueryBuilders.prefixQuery("version", "1."))
    protected void setupIndex() throws IOException {
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.termQuery("version", "invalid-version")).get();
                    .mustNot(QueryBuilders.regexpQuery("version", ".*-.*"))
/*
            {
                "version": "1.1.0"
     * 2.0.0 (Ignore)
    }
    }
     * 1.0.0-alpha (Match)
        assertHitCount(response, 1);
     * 1.0.0+build.123 (Ignore)
    }
     * 1.0.0-alpha (Ignore)
     */
            .addSort("version", org.opensearch.search.sort.SortOrder.ASC)
            .setQuery(
     * 1.0.1 (Match)
    public void testIdsQuery() throws IOException {
    public void testRangeQuery() throws IOException {
            }""";
}
     * 1.0.0-beta (Match)
     * 2.0.0 (Match)
    @Override
     * @throws IOException
        assertSearchResponse(response);
    }
        setupIndex();
     * 1.0.0-alpha (Ignore)
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException
     * 1.0.0-alpha (Ignore)
        assertHitCount(response, 1);
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.regexpQuery("version", "1\\..*\\.0")).get();
    /**
    /**
import org.opensearch.action.index.IndexRequest;
     * 1.0.0+build.123 (Ignore)
    public void testComplexQuery() throws IOException {
     * @throws IOException
     * 1.0.0 (Ignore)
            .setQuery(QueryBuilders.rangeQuery("version").gt("1.0.0").lt("2.0.0"))
     * 1.0.0-alpha (Ignore)
        assertSearchResponse(response);
    public void testConstantScoreQuery() throws IOException {
     * 1.1.0 (Ignore)
     * 2.0.0 (Match)
     * 1.0.1 (Ignore)
     */
        assertHitCount(response, 2);
    public void testTermsQuery() throws IOException {
     * 1.1.0 (Match)
        String doc1 = """
     * 1.1.0 — included (starts with 1. and no dash)
     * 1.0.1 (Ignore)
        super.setUp();
                "version": "2.0.0"
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.termsQuery("version", "1.0.0", "1.0.1")).get();
     * Document 2 - version 1.0.1
        SearchResponse response = client().prepareSearch("test")
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("test")
            {
     * 1.0.1 (Ignore)
        assertHitCount(response, 1);
     * 1.0.0-beta (Ignore)
     */
            .setQuery(QueryBuilders.functionScoreQuery(QueryBuilders.termQuery("version", "1.0.0")))
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.termQuery("version", "1.0.0")).get();
     * 1.0.0+build.123 (Ignore)
            .startObject()
     * 1.0.1 (Match)
import org.opensearch.test.OpenSearchSingleNodeTestCase;
     * 1.0.0 (Match)
    }
        String doc5 = """
     * 1.0.0+build.123 (Match)
import org.opensearch.core.xcontent.MediaTypeRegistry;
        ensureGreen();
     * Sorted ascending:
     * Second hit: 1.0.0-beta
     * 1.0.1 — included
    }
    public void testRangeQueryIncludingPreRelease() throws IOException {
    }
        SearchResponse response = client().prepareSearch("test")
    public void testFuzzyQuery() throws IOException {
     * Test that a term query for an invalid version returns no hits.
    }
     */
    /**
    }
    public void testTermQuery() throws IOException {
            .get();
        XContentBuilder mapping = createMapping();
            }""";
     * 2.0.0 (Ignore)
     * 1.0.1 (Match)
        assertSearchResponse(response);
            .get();
     * 1.0.0-beta (Ignore)
     * 2.0.0 — excluded (does not start with 1.)
        String doc2 = """
     * 1.0.0+build.123 (Ignore)
     * 1.1.0 (Ignore)
            }""";
        String doc4 = """
        assertEquals("1.0.0-alpha", response.getHits().getAt(0).getSourceAsMap().get("version"));
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.idsQuery().addIds("1", "2")).get();
     */
import org.opensearch.core.xcontent.XContentBuilder;
    public void testMultiMatchQuery() throws IOException {
     * 1.0.0-beta (Ignore)
    public void testPrefixQuery() throws IOException {
        assertHitCount(response, 1);
     * 1.1.0 (Match)
     */
            .field("type", "version")
    /**
     * 1.0.0-beta (Match)
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.existsQuery("version")).get();
    /**
            .get();
        SearchResponse response = client().prepareSearch("test")
     * 1.0.0 (Match)
        assertSearchResponse(response);
     * 1.0.0-beta (Ignore)
     * 1.0.0-alpha (Ignore)
        assertHitCount(response, 2);
     * 2.0.0 (Ignore)
     * 1.0.0+build.123 (Ignore)
        assertHitCount(response, 2);
        client().index(new IndexRequest("test").id("7").source(doc7, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     */
     * Fifth hit: 1.0.1
            .endObject();
     * 1.0.0 (Match)
     * @throws IOException if the search request fails
     * 1.0.0+build.123 (Ignore)
     * 1.0.0-alpha (Match)
            )
     * 1.0.0-alpha (Ignore)
        assertEquals("1.0.0", getResponse.getSourceAsMap().get("version"));
        assertSearchResponse(response);
     * Sixth hit: 1.1.0
        String doc6 = """
     * 1.0.1 (Match)
     * 1.1.0 (Match)
    /**
import java.io.IOException;
     * 1.1.0 (Match)
    }
     * 1.0.0-alpha (Ignore)
                "version": "1.0.0+build.123"
     * 1.0.0+build.123 (Ignore)
import org.opensearch.common.xcontent.XContentFactory;
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.wildcardQuery("version", "*.0.0")).get();
    public void testFunctionScoreQuery() throws IOException {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        client().index(new IndexRequest("test").id("4").source(doc4, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     * @throws IOException
            }""";
            .setQuery(QueryBuilders.constantScoreQuery(QueryBuilders.termQuery("version", "1.0.0")))
            .startObject("properties")
 */
        assertHitCount(response, 0);
                "version": "1.0.0"
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.matchPhraseQuery("version", "1.0.0")).get();
     * 1.0.1 (Match)
     * 1.0.0-beta (Ignore)
    public void testTermQueryInvalidVersion() throws IOException {
     * 1.0.0 (Match)
    /**
    public void testWildcardQuery() throws IOException {
        assertHitCount(response, 7);
     * 1.0.1 (Ignore)
    public void setUp() throws Exception {
     */
     * 1.0.0+build.123 (Ignore)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
     * 2.0.0 (Ignore)
        assertHitCount(response, 1); // Match only "1.0.0" in "version"
            .setQuery(QueryBuilders.matchAllQuery())
     * Third hit: 1.0.0
    }
    }
     * 1.1.0 (Ignore)
    protected XContentBuilder createMapping() throws IOException {
        assertHitCount(response, 2);
        return XContentFactory.jsonBuilder()
    }
     * Expected behavior:
     */
    /**
     * 1.0.0+build.123 — no dash, starts with 1. → included
        assertTrue("Document should exist", getResponse.isExists());
 * compatible open source license.
     * @throws IOException
        assertSearchResponse(response);
        assertSearchResponse(response);
    /**
     * 1.1.0 (Match)
     * 1.0.0-alpha — excluded because of dash (mustNot)
            .startObject("version")
        assertSearchResponse(response);
        // Term query
        assertSearchResponse(response);
     * 1.0.0 (Ignore)
     */
     * 2.0.0 (Ignore)
        SearchResponse response = client().prepareSearch("test")
        String doc3 = """
        assertHitCount(response, 6);
     * 1.0.0 (Match)
     * 2.0.0 (Ignore)
public class SemanticVersionFieldQueryTests extends OpenSearchSingleNodeTestCase {
        assertSearchResponse(response);
import org.opensearch.action.search.SearchResponse;
     * 1.0.0+build.123 (Ignore)
        assertSearchResponse(response);
     * 1.0.0 (Match)
            .get();
     * 1.0.0 (Match)
     * First hit: 1.0.0-alpha
        assertSearchResponse(response);
     * Should match documents with IDs 1 and 2 regardless of version:
    public void testRegexpQuery() throws IOException {
    }
            {
            .get();
            }""";
package org.opensearch.index.query;
    }
 *
 * SPDX-License-Identifier: Apache-2.0
            .setQuery(QueryBuilders.fuzzyQuery("version", "1.0.1").fuzziness(Fuzziness.ONE))
     * @throws IOException
     * 1.0.0+build.123 (Ignore)
import org.opensearch.common.unit.Fuzziness;
    /**
        assertSearchResponse(response);
    public void testMatchPhraseQuery() throws IOException {
    /**
     * @throws IOException
    /**
                "version": "1.0.1"
     * @throws IOException
     */
        assertSearchResponse(response);
    }
     * @throws IOException
            {
            .get();
        client().index(new IndexRequest("test").id("3").source(doc3, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
        String doc7 = """
    }
     * 1.1.0 (Match)
     * 1.0.0-beta (Match)
     * 2.0.0 (Ignore)
        assertHitCount(response, 2);
        assertHitCount(response, 4);
     * 1.1.0 (Match)
     * 1.1.0 (Ignore)
        client().index(new IndexRequest("test").id("6").source(doc6, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     * 2.0.0 (Ignore)
     * 2.0.0 (Ignore)
        GetResponse getResponse = client().prepareGet("test", "1").get();
     * 1.0.0 (Match)
        client().index(new IndexRequest("test").id("2").source(doc2, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     * 1.0.0-beta (Ignore)
     */
     * 1.0.0 (Match)
     * 1.0.0-beta — excluded (mustNot)
     */
     * 1.0.1 (Match)
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
                QueryBuilders.boolQuery()
     * 1.1.0 (Ignore)
     * 1.0.0-alpha (Ignore)
        assertSearchResponse(response);
        ensureGreen("test");
        assertHitCount(response, 7);  // Should match all documents with a version field
     * 1.0.0+build.123 (Match)
     * 1.0.0-beta (Ignore)
        // Test exists query
     * 1.0.0-alpha (Ignore)
     * 2.0.0 (Ignore)
     * 1.0.0-alpha (Match)
     * Seventh hit: 2.0.0
            .setQuery(QueryBuilders.multiMatchQuery("1.0.0", "version", "non_existent_field"))
     * 2.0.0 (Ignore)
            {
        SearchResponse response = client().prepareSearch("test")
     */
     * @throws IOException
     * @throws IOException
                "version": "1.0.0-beta"
            .endObject()
                "version": "1.0.0-alpha"
     * @throws IOException
        SearchResponse response = client().prepareSearch("test")
     * 1.0.1 (Ignore)
        assertHitCount(response, 2);
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
    }
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.matchQuery("version", "1.0.0")).get();
     */
     * 1.0.0-beta (Ignore)
     * Document 1 - version 1.0.0
     * @throws IOException
        // Test with non-existent field
    /**
     * 2.0.0 (Ignore)
    /**
            .endObject()
     * @throws IOException
 * The OpenSearch Contributors require contributions made to
     * 1.0.0 (Match)
    /**
     * 1.0.0 — included
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.prefixQuery("version", "1.")).get();
     * 1.0.0-beta (Ignore)
     * 1.0.0 (Ignore)
     * 1.0.1 (Match)
     * 1.0.0-alpha (Ignore)
     * 1.0.0+build.123 (Ignore)
                    .should(QueryBuilders.termQuery("version", "1.0.0"))
            .setQuery(QueryBuilders.rangeQuery("version").gte("1.0.0-alpha").lt("1.0.1"))
