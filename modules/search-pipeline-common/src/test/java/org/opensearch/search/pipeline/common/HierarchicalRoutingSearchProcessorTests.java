import org.opensearch.action.search.SearchRequest;
        assertThat(transformedRequest.routing(), notNullValue());
        // Test depth 1
    }
            "test",
    }
 * this file be licensed under the Apache-2.0 license or a
        assertThat(result2.routing(), notNullValue());
import java.util.Collections;
public class HierarchicalRoutingSearchProcessorTests extends AbstractBuilderTestCase {
}
            "/company/engineering/team2/file.txt"
import java.util.Map;
        byte[] anchorBytes = anchor.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            if (expectedPrefix.isEmpty()) {
        QueryBuilder query2 = new TermQueryBuilder("path_field", path);
            anchorBytes,
        assertThat(transformedRequest.routing(), notNullValue());
    private String computeExpectedRouting(String anchor, String separator) {
            () -> factory.create(Collections.emptyMap(), "test", null, false, config3, null)
        SearchRequest transformedRequest = processor.processRequest(request);
            { "/company/engineering/team?", "/company/engineering/team" },
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
            Collections.emptyMap(),
    public void testFactoryValidation() throws Exception {
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
            pathField,
        SearchRequest request = new SearchRequest().source(source);
        // Test depth 2
        SearchRequest transformedRequest = processor.processRequest(request);
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        SearchRequest result1 = processor1.processRequest(request1);
import org.opensearch.index.query.TermQueryBuilder;
        assertThat(result1.routing(), equalTo(computeExpectedRouting("company", "/")));
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
            enableAutoDetection
import static org.hamcrest.Matchers.nullValue;
        QueryBuilder query = new TermQueryBuilder("path_field", "company\\engineering\\team\\file.txt");
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        String routing = transformedRequest.routing();
        );
    public void testEmptySearchRequest() throws Exception {
    }
        // Should contain routing for both paths (engineering and marketing have different anchors at depth 2)
            .mustNot(new PrefixQueryBuilder("path_field", "/company/marketing"));
        config2.put("path_field", "path");
        int anchorDepth,
    }
        SearchRequest request2 = new SearchRequest().source(new SearchSourceBuilder().query(query2));
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
import org.opensearch.search.builder.SearchSourceBuilder;
        assertThat(transformedRequest.routing(), nullValue());
import org.opensearch.test.AbstractBuilderTestCase;
        // Test missing path_field
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
        assertThat(processor.getType(), equalTo(HierarchicalRoutingSearchProcessor.TYPE));
    // Helper methods
        assertThat(result2.routing(), equalTo(computeExpectedRouting("company/engineering", "/")));
        );
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        assertNull("Should not add routing for should/must_not clauses", transformedRequest.routing());
        SearchRequest transformedRequest = processor.processRequest(request);
            OpenSearchParseException.class,
    public void testWildcardPrefixExtraction() throws Exception {
        assertThat(exception.getMessage(), containsString("cannot be null or empty"));
        // No routing should be added for empty request
            0,
        // Test empty path_separator
    public void testCustomSeparator() throws Exception {
        exception = expectThrows(
        SearchRequest result2 = processor2.processRequest(request2);
        QueryBuilder pathFilter = new PrefixQueryBuilder("path_field", "/company/engineering");
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
        SearchRequest request = new SearchRequest().source(source);
    }
        config2.put("anchor_depth", 0);
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
            String pattern = testCase[0];
        HierarchicalRoutingSearchProcessor processor1 = createProcessor("path_field", 1, "/", true);
        SearchRequest transformedRequest = processor.processRequest(request);
    }
            } else {
        // Query with paths only in should and must_not clauses
            false,
        SearchRequest request = new SearchRequest().source(source);
            "test",
import org.opensearch.index.query.WildcardQueryBuilder;
        // Test invalid anchor_depth
        assertThat(transformedRequest.routing(), notNullValue());
        assertThat(result1.routing(), notNullValue());
        SearchRequest request = new SearchRequest().source(source);
 */
        SearchRequest transformedRequest = processor.processRequest(request);
        // No routing should be added if no path field is found
package org.opensearch.search.pipeline.common;
import static org.hamcrest.Matchers.equalTo;
        String separator,
            config,
        Map<String, Object> config = new HashMap<>();
        assertThat(transformedRequest.routing(), notNullValue());
        QueryBuilder query = new TermsQueryBuilder(
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
    }
    public void testShouldAndMustNotClausesIgnored() throws Exception {
        SearchSourceBuilder source = new SearchSourceBuilder().query(boolQuery);
        config.put("path_field", "file_path");
        SearchRequest transformedRequest = processor.processRequest(request);
            "test processor",
            () -> factory.create(Collections.emptyMap(), "test", null, false, config1, null)
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
        // This mirrors the logic in HierarchicalRoutingSearchProcessor
        assertThat(transformedRequest.routing(), notNullValue());
        QueryBuilder textQuery = new TermQueryBuilder("content", "presentation");
        String path = "/company/engineering/team/project/file.txt";
            }
            false,
 * compatible open source license.
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
    }
            () -> factory.create(Collections.emptyMap(), "test", null, false, config2, null)
import org.opensearch.index.query.PrefixQueryBuilder;
            "test processor",
        QueryBuilder query = new TermQueryBuilder("path_field", "/company/engineering/team/file.txt");
        return String.valueOf(Math.abs(hash));
            null
    }
            new org.opensearch.common.hash.MurmurHash3.Hash128()
        );
    public void testDifferentAnchorDepths() throws Exception {
        long hash = org.opensearch.common.hash.MurmurHash3.hash128(
        config.put("enable_auto_detection", false);
            new TermsQueryBuilder("path_field", "/company/engineering/team1/file.txt", "/company/marketing/campaigns/q1.pdf")
        SearchRequest request = new SearchRequest().source(source);
        QueryBuilder query = new TermQueryBuilder("path_field", "/company/engineering/team/file.txt");
        config3.put("path_separator", "");
        QueryBuilder query = new BoolQueryBuilder().should(new PrefixQueryBuilder("path_field", "/company/engineering"))
        // Routing should be deterministic for same input
        Map<String, Object> config1 = new HashMap<>();
        SearchRequest request1 = new SearchRequest().source(new SearchSourceBuilder().query(query1));
        QueryBuilder query = new PrefixQueryBuilder("path_field", "/company/engineering");
        HierarchicalRoutingSearchProcessor processor2 = createProcessor("path_field", 2, "/", true);
        SearchRequest transformedRequest = processor.processRequest(request);
        );
    public void testTermQueryRouting() throws Exception {
            0,
        String expectedRouting = computeExpectedRouting("company\\engineering", "\\");
            { "/company/engineering/exact", "/company/engineering/exact" } };
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
import org.opensearch.OpenSearchParseException;
        SearchRequest transformedRequest = processor.processRequest(request);
        Map<String, Object> config2 = new HashMap<>();
    public void testTermsQueryRouting() throws Exception {
        // Query with multiple path filters - using filter clauses which do affect routing
        config.put("anchor_depth", 3);
        Map<String, Object> config3 = new HashMap<>();
import org.opensearch.index.query.BoolQueryBuilder;
        );
        assertThat(exception.getMessage(), containsString("path_field"));
        config1.put("anchor_depth", 2);
    }
        );
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        assertTrue("Should contain comma-separated routing values", routing.contains(","));
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
            "path_field",
        QueryBuilder boolQuery = new BoolQueryBuilder().must(textQuery).filter(pathFilter);
        QueryBuilder query = new WildcardQueryBuilder("path_field", "/company/engineering/*");
    }
    }
 *
        SearchRequest request = new SearchRequest().source(source);
            OpenSearchParseException.class,
        // Existing routing should be preserved
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        // Test various wildcard patterns
        ).h1;
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        String pathField,
        SearchRequest transformedRequest = processor.processRequest(request);
import java.util.HashMap;
    public void testFactory() throws Exception {
    public void testMultiplePathsInQuery() throws Exception {
    }
        assertThat(transformedRequest.routing(), nullValue());
        return new HierarchicalRoutingSearchProcessor(
        QueryBuilder query = new BoolQueryBuilder().filter(
    public void testWildcardQueryRouting() throws Exception {
        // Verify expected routing values
            anchorDepth,
            "/company/engineering/team1/file.txt",
        SearchRequest request = new SearchRequest().source(source);
    public void testPrefixQueryRouting() throws Exception {
        OpenSearchParseException exception = expectThrows(
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
import static org.hamcrest.Matchers.notNullValue;
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        String[][] testCases = {
        assertNotEquals(result1.routing(), result2.routing());
    ) {
            separator,
        assertThat(transformedRequest.routing(), notNullValue());
        SearchRequest request = new SearchRequest().source(source).routing("existing_routing");
            anchorBytes.length,
        SearchRequest transformedRequest = processor.processRequest(request);
            String expectedPrefix = testCase[1];
        assertThat(transformedRequest.routing(), equalTo("existing_routing"));
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
    public void testBoolQueryRouting() throws Exception {
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
        config3.put("path_field", "path");
        for (String[] testCase : testCases) {
        // Different depths should produce different routing values
        );
/*
        // Should not add routing since paths are only in should/must_not clauses
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchRequest request = new SearchRequest().source(source);
    public void testExistingRoutingPreserved() throws Exception {
    }
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
        HierarchicalRoutingSearchProcessor.Factory factory = new HierarchicalRoutingSearchProcessor.Factory();
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
 * The OpenSearch Contributors require contributions made to
                assertThat("Pattern: " + pattern, transformedRequest.routing(), notNullValue());
import org.opensearch.index.query.QueryBuilder;
        QueryBuilder query = new TermQueryBuilder("content", "some text");
                assertThat("Pattern: " + pattern, transformedRequest.routing(), nullValue());
            SearchRequest transformedRequest = processor.processRequest(request);
import static org.hamcrest.Matchers.containsString;
            { "*.txt", "" },
        HierarchicalRoutingSearchProcessor processor = factory.create(
        QueryBuilder query1 = new TermQueryBuilder("path_field", path);
        HierarchicalRoutingSearchProcessor.Factory factory = new HierarchicalRoutingSearchProcessor.Factory();
        exception = expectThrows(
import org.opensearch.index.query.TermsQueryBuilder;
    public void testNoPathFieldInQuery() throws Exception {
        assertThat(transformedRequest.routing(), notNullValue());
            OpenSearchParseException.class,
        boolean enableAutoDetection
        SearchRequest request = new SearchRequest();
            SearchRequest request = new SearchRequest().source(source);
            { "/company/*", "/company" },
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "\\", true);
        assertThat(exception.getMessage(), containsString("must be greater than 0"));
            QueryBuilder query = new WildcardQueryBuilder("path_field", pattern);
        SearchRequest request = new SearchRequest().source(source);
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
            { "/company/engineering/*", "/company/engineering" },
        SearchRequest transformedRequest = processor.processRequest(request);
        }
    private HierarchicalRoutingSearchProcessor createProcessor(
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
 * SPDX-License-Identifier: Apache-2.0
    }
    }
    }
            SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        // Both paths should result in same routing since they share same anchor
        config.put("path_separator", "\\");
