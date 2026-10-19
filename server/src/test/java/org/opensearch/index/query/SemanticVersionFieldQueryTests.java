 * The OpenSearch Contributors require contributions made to  
     * Expected behavior:  
import org.opensearch.core.xcontent.XContentBuilder;  
     * 1.1.0 (Match)
    public void testWildcardQuery() throws IOException {  
    /**
    }  
        String doc4 = """
            }""";
     * 1.0.0 (Match)
        assertHitCount(response, 7);
            .startObject("version")
        super.setUp();
        assertHitCount(response, 1); // Match only "1.0.0" in "version"  
     * 2.0.0 (Ignore)
            {
     * 1.0.0+build.123 (Ignore)  
        String doc3 = """
     * 1.0.0 (Ignore)
     * 1.0.0+build.123 (Ignore)  
     * 1.0.0-beta (Match)
    }  
    /**  
            }""";
     * @throws IOException  
     * 1.0.0+build.123 (Ignore)  
     * 1.0.0-beta (Ignore)
     * @throws IOException
    public void testTermQueryInvalidVersion() throws IOException {
     */
import org.opensearch.action.index.IndexRequest;
     * 2.0.0 (Ignore)
 * SPDX-License-Identifier: Apache-2.0
        client().index(new IndexRequest("test").id("5").source(doc5, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     * 1.0.0-alpha (Ignore)
            {
     */  
     * 1.1.0 (Match)  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
     * 1.0.0-beta (Ignore)
     * @throws IOException
     * 1.0.1 (Ignore)  
    /**  
     * 1.0.0+build.123 (Ignore)  
            }""";
            .setQuery(
     */  
            {
import java.io.IOException;  
    }
import org.opensearch.common.unit.Fuzziness;  
        ensureGreen();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
     * Fourth hit: 1.0.0+build.123
    protected XContentBuilder createMapping() throws IOException {  
                    .should(QueryBuilders.termQuery("version", "1.0.0"))
        assertHitCount(response, 1);
            .get();
    }
    /**  
    }
        client().index(new IndexRequest("test").id("4").source(doc4, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     * 1.1.0 (Match)  
        assertHitCount(response, 4);  
        assertEquals("1.0.0-alpha", response.getHits().getAt(0).getSourceAsMap().get("version"));  
     */
    /**
                "version": "1.0.0+build.123"  
     * 1.0.1 (Ignore)
        // Term query  
        assertSearchResponse(response);
        client().index(new IndexRequest("test").id("3").source(doc3, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
        assertSearchResponse(response);
     * 1.0.1 (Match)
     * First hit: 1.0.0-alpha
                "version": "1.0.0-alpha"  
     * 1.0.0-alpha (Ignore)  
     */  
     * @throws IOException if the search request fails
     * 1.0.0 (Ignore)
     * 1.0.1 (Ignore)
        assertSearchResponse(response);
    public void testMatchPhraseQuery() throws IOException {
     * 2.0.0 — excluded (does not start with 1.)
     * 1.0.0-beta (Ignore)  
        SearchResponse response = client().prepareSearch("test")
     * 1.0.1 (Match)  
        assertHitCount(response, 1);
            .setQuery(QueryBuilders.functionScoreQuery(QueryBuilders.termQuery("version", "1.0.0")))
    public void testMatchQuery() throws IOException {
        // Test exists query
     */  
     * @throws IOException
            .setQuery(QueryBuilders.multiMatchQuery("1.0.0", "version", "non_existent_field"))
        setupIndex();
     * 1.0.1 (Match)  
    /**
     * Sorted ascending:  
                "version": "1.0.0"  
    }
    /**  
        assertHitCount(response, 2);  
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.matchQuery("version", "1.0.0")).get();
     * Test that a term query for an invalid version returns no hits.
     * 2.0.0 (Ignore)  
public class SemanticVersionFieldQueryTests extends OpenSearchSingleNodeTestCase {  
     * 1.0.0 (Match)  
    /**
    public void testExistsQuery() throws IOException {
        GetResponse getResponse = client().prepareGet("test", "1").get();
            .get();
     */  
    }
     * 1.0.0 (Match)
        SearchResponse response = client().prepareSearch("test")
        assertHitCount(response, 0);  
     * 1.0.0 (Match)
    public void testPrefixQuery() throws IOException {
     * 1.1.0 (Match)
     */  
     * @throws IOException  
    }  
    public void testIdsQuery() throws IOException {  
            {
    public void testTermQuery() throws IOException {
        assertHitCount(response, 4);
        client().index(new IndexRequest("test").id("1").source(doc1, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
        XContentBuilder mapping = createMapping();  
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.termsQuery("version", "1.0.0", "1.0.1")).get();  
        assertSearchResponse(response);
        client().index(new IndexRequest("test").id("2").source(doc2, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     * 1.0.0+build.123 (Ignore)
            .endObject();
    public void testFunctionScoreQuery() throws IOException {  
     * @throws IOException
        assertSearchResponse(response);  
            }""";
        assertSearchResponse(response);  
    }
                QueryBuilders.boolQuery()
     * 1.1.0 (Ignore)
            {
    }  
}
import org.opensearch.common.xcontent.XContentFactory;
     * 1.0.0-alpha (Match)
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
     */
            .field("type", "version")
     * 1.0.0-alpha (Ignore)  
     * @throws IOException  
     * 2.0.0 (Ignore)
     * 1.0.0 (Match)
     * 1.0.0+build.123 (Ignore)
        assertHitCount(response, 1);  
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.termQuery("version", "1.0.0")).get();
     * @throws IOException  
 *
    public void testRegexpQuery() throws IOException {
            }""";
    public void testRangeQuery() throws IOException {
        assertSearchResponse(response);
     * 1.1.0 (Ignore)
            .get();
     * 1.0.0-alpha (Ignore)
    public void testConstantScoreQuery() throws IOException {
     * 1.0.0+build.123 (Ignore)
            .endObject()
     * 1.0.0+build.123 (Match)  
        assertSearchResponse(response);
     * 1.0.0-beta — excluded (mustNot)  
     */
     * @throws IOException
     * 1.1.0 (Match)  
     * 1.1.0 — included (starts with 1. and no dash)
     * Fifth hit: 1.0.1
     * 1.0.0 (Match)
        assertHitCount(response, 2);
     * 1.0.0-beta (Ignore)
     * 1.0.0+build.123 (Match)  
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.existsQuery("version")).get();  
        response = client().prepareSearch("test").setQuery(QueryBuilders.existsQuery("non_existent_field")).get();  
        assertHitCount(response, 2);
            .get();
import org.opensearch.action.search.SearchResponse;
     * Document 1 - version 1.0.0
     * Document 2 - version 1.0.1  
     * 1.0.0-beta (Ignore)
 */  
        assertSearchResponse(response);
     * 2.0.0 (Match)
            .startObject("properties")  
     * 1.0.0-beta (Ignore)
            .setQuery(QueryBuilders.rangeQuery("version").gt("1.0.0").lt("2.0.0"))  
        assertSearchResponse(response);
                    .mustNot(QueryBuilders.regexpQuery("version", ".*-.*"))
        assertHitCount(response, 1); // Should match "1.0.0" if analyzed, or 0 if not.
     * 1.1.0 (Ignore)  
     * 1.1.0 (Match)  
        assertSearchResponse(response);
    /**
        client().index(new IndexRequest("test").id("6").source(doc6, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
     * 1.1.0 (Ignore)
    /**  
    }
     * 1.0.0-alpha (Ignore)  
        assertHitCount(response, 2);
            {
     * 1.0.0-alpha (Ignore)
        String doc1 = """
     * @throws IOException
     * 1.0.0+build.123 (Ignore)  
     * @throws IOException  
     * Sixth hit: 1.1.0  
     * 1.0.1 (Ignore)
    }  
     * 1.0.1 (Ignore)
    public void testFuzzyQuery() throws IOException {
     * 2.0.0 (Ignore)
    public void testMultiMatchQuery() throws IOException {  
     * 1.0.0 (Match)
     * Seventh hit: 2.0.0
     * 1.0.1 (Match)
     * 1.0.0-beta (Ignore)
            .get();  
     * 1.1.0 (Ignore)
        ensureGreen("test");  
     * 1.0.0+build.123 (Ignore)
    }
import org.opensearch.test.OpenSearchSingleNodeTestCase;
     * 1.1.0 (Match)  
    }  
     * 1.0.1 — included  
     * 1.0.1 (Match)
            .setQuery(QueryBuilders.rangeQuery("version").gte("1.0.0-alpha").lt("1.0.1"))  
     * 1.0.1 (Match)
     * Second hit: 1.0.0-beta
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.wildcardQuery("version", "*.0.0")).get();
            )  
     * 1.0.0 — included
        assertSearchResponse(response);  
        assertEquals("1.0.0", getResponse.getSourceAsMap().get("version"));
    }
        // Test with non-existent field
    /**  
                "version": "1.1.0"  
     * 1.0.0-alpha (Match)
        client().index(new IndexRequest("test").id("7").source(doc7, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
        assertSearchResponse(response);
     * @throws IOException
            {
     * @throws IOException
    }
            }""";
        assertSearchResponse(response);
     * 1.0.0 (Match)
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.prefixQuery("version", "1.")).get();  
        String doc2 = """
     * 1.0.0-beta (Match)
package org.opensearch.index.query;
     * 1.0.0-alpha (Match)
     */
    /**
     * 1.0.0-alpha (Ignore)
        assertHitCount(response, 2);  
 * compatible open source license.
        assertSearchResponse(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
     */  
        assertSearchResponse(response);  
     * 2.0.0 (Ignore)
     */
     * @throws IOException
        String doc6 = """
                    .must(QueryBuilders.prefixQuery("version", "1."))  
     */  
        String doc5 = """
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.matchPhraseQuery("version", "1.0.0")).get();
     * 1.0.0-alpha (Ignore)
     * 1.0.0 (Match)  
    /**
        assertHitCount(response, 0);
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.idsQuery().addIds("1", "2")).get();
     * 1.0.0-beta (Ignore)
     * Should match documents with IDs 1 and 2 regardless of version:
    /**
            .get();
    public void setUp() throws Exception {  
    public void testTermsQuery() throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .setQuery(QueryBuilders.matchAllQuery())
    @Override
        assertHitCount(response, 1);
        SearchResponse response = client().prepareSearch("test")
    public void testSortByVersion() throws IOException {
    }
     * 1.0.1 (Match)
     * 1.0.0 (Ignore)
        return XContentFactory.jsonBuilder()
     * Third hit: 1.0.0  
     * 1.0.0-alpha (Ignore)
     * 1.1.0 (Ignore)
                "version": "1.0.0-beta"  
        assertTrue("Document should exist", getResponse.isExists());  
     */
        assertSearchResponse(response);
     * 1.1.0 (Ignore)  
     * 1.0.0-beta (Match)  
        SearchResponse response = client().prepareSearch("test")
            .get();  
        SearchResponse response = client().prepareSearch("test")  
     */  
     * 2.0.0 (Ignore)
     */
    }
     * @throws IOException
import org.opensearch.action.get.GetResponse;  
     * 1.0.0-beta (Ignore)  
    }
     * 2.0.0 (Ignore)
     * @throws IOException
    /**
     * 1.0.0-alpha (Ignore)
        assertHitCount(response, 2);  
     * 2.0.0 (Ignore)  
        assertHitCount(response, 6);
            .setQuery(QueryBuilders.fuzzyQuery("version", "1.0.1").fuzziness(Fuzziness.ONE))
        SearchResponse response = client().prepareSearch("test")  
     * 2.0.0 (Ignore)
    /**  
     * 1.0.0-beta (Ignore)
     * 1.0.0+build.123 (Ignore)
     * 1.0.0-alpha — excluded because of dash (mustNot)
     * 1.0.0 (Ignore)  
        SearchResponse response = client().prepareSearch("test")  
     * 1.0.0+build.123 (Match)
    public void testComplexQuery() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    protected void setupIndex() throws IOException {
                "version": "1.0.1"  
     * 1.0.0+build.123 — no dash, starts with 1. → included
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.regexpQuery("version", "1\\..*\\.0")).get();
     * 1.0.1 (Match)  
     * 1.0.0-alpha (Ignore)
     * @throws IOException
        assertSearchResponse(response);
        assertSearchResponse(response);  
/*  
     * 1.0.0 (Match)
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.termQuery("version", "invalid-version")).get();
            .endObject()  
        SearchResponse response = client().prepareSearch("test")
                "version": "2.0.0"  
        assertHitCount(response, 7);  // Should match all documents with a version field  
     * 2.0.0 (Ignore)
            .get();
    /**  
    }
     * 2.0.0 (Match)  
     * 1.0.1 (Ignore)
     */
        String doc7 = """
            .startObject()
     * 1.0.0-beta (Ignore)  
     * 2.0.0 (Ignore)
     * 1.0.0+build.123 (Ignore)
    public void testRangeQueryIncludingPreRelease() throws IOException {
    }  
    /**
            .addSort("version", org.opensearch.search.sort.SortOrder.ASC)  
            }""";
            .setQuery(QueryBuilders.constantScoreQuery(QueryBuilders.termQuery("version", "1.0.0")))
