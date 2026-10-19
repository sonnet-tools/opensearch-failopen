            anchorDepth,
}
        OpenSearchParseException exception = expectThrows(
    public void testEmptySearchRequest() throws Exception {  
            0,  
                assertThat("Pattern: " + pattern, transformedRequest.routing(), notNullValue());
    // Helper methods
    public void testWildcardPrefixExtraction() throws Exception {
            false,
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        QueryBuilder boolQuery = new BoolQueryBuilder().must(textQuery).filter(pathFilter);
            () -> factory.create(Collections.emptyMap(), "test", null, false, config2, null)
        }  
        QueryBuilder query = new TermQueryBuilder("content", "some text");
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
        HierarchicalRoutingSearchProcessor processor1 = createProcessor("path_field", 1, "/", true);
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        QueryBuilder query = new BoolQueryBuilder().filter(
        long hash = org.opensearch.common.hash.MurmurHash3.hash128(
        SearchRequest transformedRequest = processor.processRequest(request);  
        SearchRequest request = new SearchRequest().source(source);  
    public void testMultiplePathsInQuery() throws Exception {  
        assertTrue("Should contain comma-separated routing values", routing.contains(","));
        config.put("anchor_depth", 3);  
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
            if (expectedPrefix.isEmpty()) {
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));  
        exception = expectThrows(  
        String routing = transformedRequest.routing();  
        SearchRequest transformedRequest = processor.processRequest(request);
        assertNotEquals(result1.routing(), result2.routing());  
            enableAutoDetection  
    ) {
        SearchRequest transformedRequest = processor.processRequest(request);
        config3.put("path_separator", "");
        config.put("path_separator", "\\");
            new TermsQueryBuilder("path_field", "/company/engineering/team1/file.txt", "/company/marketing/campaigns/q1.pdf")
            { "/company/engineering/exact", "/company/engineering/exact" } };
        QueryBuilder textQuery = new TermQueryBuilder("content", "presentation");
        QueryBuilder query = new TermQueryBuilder("path_field", "/company/engineering/team/file.txt");
        );  
        // No routing should be added if no path field is found
        SearchRequest request = new SearchRequest().source(source);
    }
        boolean enableAutoDetection  
        QueryBuilder query1 = new TermQueryBuilder("path_field", path);
package org.opensearch.search.pipeline.common;
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
        SearchRequest transformedRequest = processor.processRequest(request);  
    public void testDifferentAnchorDepths() throws Exception {  
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
        Map<String, Object> config3 = new HashMap<>();  
        assertThat(result1.routing(), equalTo(computeExpectedRouting("company", "/")));  
        config3.put("path_field", "path");
            separator,
        // Should contain routing for both paths (engineering and marketing have different anchors at depth 2)
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchRequest transformedRequest = processor.processRequest(request);
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
import org.opensearch.OpenSearchParseException;
        assertThat(exception.getMessage(), containsString("path_field"));
    public void testTermQueryRouting() throws Exception {
            { "/company/engineering/team?", "/company/engineering/team" },
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "\\", true);
        // This mirrors the logic in HierarchicalRoutingSearchProcessor
            } else {  
import org.opensearch.index.query.TermQueryBuilder;  
    }
        assertThat(transformedRequest.routing(), nullValue());
import java.util.HashMap;
        assertThat(transformedRequest.routing(), nullValue());
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);  
            null
    }  
        );  
        assertThat(transformedRequest.routing(), notNullValue());  
            }
import java.util.Collections;  
        assertThat(exception.getMessage(), containsString("cannot be null or empty"));
        Map<String, Object> config = new HashMap<>();
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
        QueryBuilder pathFilter = new PrefixQueryBuilder("path_field", "/company/engineering");  
            .mustNot(new PrefixQueryBuilder("path_field", "/company/marketing"));
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);  
 * compatible open source license.
        String[][] testCases = {
        Map<String, Object> config1 = new HashMap<>();
        QueryBuilder query = new BoolQueryBuilder().should(new PrefixQueryBuilder("path_field", "/company/engineering"))
        // Should not add routing since paths are only in should/must_not clauses  
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);  
        // Query with paths only in should and must_not clauses  
        SearchRequest transformedRequest = processor.processRequest(request);  
        config2.put("path_field", "path");  
    private String computeExpectedRouting(String anchor, String separator) {
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);  
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
import org.opensearch.index.query.WildcardQueryBuilder;
            "test",  
        config2.put("anchor_depth", 0);
import org.opensearch.index.query.TermsQueryBuilder;
        SearchSourceBuilder source = new SearchSourceBuilder().query(boolQuery);
    }
 * this file be licensed under the Apache-2.0 license or a
    }
        // Verify expected routing values
        assertThat(transformedRequest.routing(), notNullValue());
        String expectedRouting = computeExpectedRouting("company\\engineering", "\\");
        assertThat(result2.routing(), equalTo(computeExpectedRouting("company/engineering", "/")));
        // Query with multiple path filters - using filter clauses which do affect routing  
        SearchRequest request1 = new SearchRequest().source(new SearchSourceBuilder().query(query1));  
        assertThat(transformedRequest.routing(), notNullValue());  
 * The OpenSearch Contributors require contributions made to  
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
        SearchRequest request = new SearchRequest().source(source);
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
            Collections.emptyMap(),
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
        QueryBuilder query = new TermQueryBuilder("path_field", "/company/engineering/team/file.txt");
        ).h1;
        assertThat(processor.getType(), equalTo(HierarchicalRoutingSearchProcessor.TYPE));
        assertThat(exception.getMessage(), containsString("must be greater than 0"));  
    public void testWildcardQueryRouting() throws Exception {
import org.opensearch.index.query.BoolQueryBuilder;  
        SearchRequest request = new SearchRequest().source(source);  
    }
        config.put("path_field", "file_path");
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
    public void testPrefixQueryRouting() throws Exception {
        HierarchicalRoutingSearchProcessor.Factory factory = new HierarchicalRoutingSearchProcessor.Factory();
        // Existing routing should be preserved
            0,
        // Test depth 1  
        // Both paths should result in same routing since they share same anchor
    }
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));  
        String expectedRouting = computeExpectedRouting("company/engineering", "/");
            OpenSearchParseException.class,
        SearchRequest transformedRequest = processor.processRequest(request);
            "test processor",
            SearchSourceBuilder source = new SearchSourceBuilder().query(query);
            false,
        );
        );
import org.opensearch.search.builder.SearchSourceBuilder;  
        HierarchicalRoutingSearchProcessor processor = factory.create(
        HierarchicalRoutingSearchProcessor.Factory factory = new HierarchicalRoutingSearchProcessor.Factory();
    public void testTermsQueryRouting() throws Exception {
        String path = "/company/engineering/team/project/file.txt";
            () -> factory.create(Collections.emptyMap(), "test", null, false, config3, null)
        SearchRequest transformedRequest = processor.processRequest(request);
            SearchRequest request = new SearchRequest().source(source);  
            OpenSearchParseException.class,
            () -> factory.create(Collections.emptyMap(), "test", null, false, config1, null)  
        SearchRequest request = new SearchRequest().source(source);
        QueryBuilder query = new TermsQueryBuilder(
        SearchRequest request = new SearchRequest().source(source);  
            pathField,  
        // Routing should be deterministic for same input  
        assertThat(transformedRequest.routing(), notNullValue());
    public void testFactoryValidation() throws Exception {
import org.opensearch.index.query.QueryBuilder;
        HierarchicalRoutingSearchProcessor processor2 = createProcessor("path_field", 2, "/", true);
            "path_field",  
        SearchRequest transformedRequest = processor.processRequest(request);
        // No routing should be added for empty request  
        assertThat(transformedRequest.routing(), notNullValue());
        SearchRequest request = new SearchRequest().source(source).routing("existing_routing");
            SearchRequest transformedRequest = processor.processRequest(request);
            { "*.txt", "" },  
        QueryBuilder query2 = new TermQueryBuilder("path_field", path);
        assertThat(result1.routing(), notNullValue());
        SearchRequest request = new SearchRequest().source(source);
        QueryBuilder query = new PrefixQueryBuilder("path_field", "/company/engineering");
    }  
        // Test invalid anchor_depth
        // Test empty path_separator
        String pathField,  
        assertThat(transformedRequest.routing(), notNullValue());
import static org.hamcrest.Matchers.notNullValue;  
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));  
        config.put("enable_auto_detection", false);
    }
    public void testBoolQueryRouting() throws Exception {  
            "/company/engineering/team1/file.txt",
    private HierarchicalRoutingSearchProcessor createProcessor(
        assertNull("Should not add routing for should/must_not clauses", transformedRequest.routing());
        );
        // Different depths should produce different routing values  
            QueryBuilder query = new WildcardQueryBuilder("path_field", pattern);
    }  
import static org.hamcrest.Matchers.nullValue;
        int anchorDepth,
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);  
            "test processor",
import java.util.Map;
/*  
        );
            String pattern = testCase[0];
        String expectedRouting = computeExpectedRouting("company/engineering", "/");  
            { "/company/*", "/company" },
        SearchRequest result1 = processor1.processRequest(request1);
        assertThat(result2.routing(), notNullValue());
    }
        assertThat(transformedRequest.routing(), equalTo("existing_routing"));  
        QueryBuilder query = new WildcardQueryBuilder("path_field", "/company/engineering/*");
    public void testShouldAndMustNotClausesIgnored() throws Exception {  
        SearchRequest request2 = new SearchRequest().source(new SearchSourceBuilder().query(query2));  
            "/company/engineering/team2/file.txt"
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);  
        SearchRequest request = new SearchRequest();  
        String separator,
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);  
        Map<String, Object> config2 = new HashMap<>();
        SearchRequest transformedRequest = processor.processRequest(request);
    public void testExistingRoutingPreserved() throws Exception {
import static org.hamcrest.Matchers.equalTo;
    public void testNoPathFieldInQuery() throws Exception {
        );  
 *
    }
        SearchRequest transformedRequest = processor.processRequest(request);
            OpenSearchParseException.class,  
 */  
        return String.valueOf(Math.abs(hash));
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
    }  
    }
        return new HierarchicalRoutingSearchProcessor(
public class HierarchicalRoutingSearchProcessorTests extends AbstractBuilderTestCase {  
            String expectedPrefix = testCase[1];
import org.opensearch.index.query.PrefixQueryBuilder;
        SearchRequest request = new SearchRequest().source(source);
        assertThat(transformedRequest.routing(), notNullValue());
        QueryBuilder query = new TermQueryBuilder("path_field", "company\\engineering\\team\\file.txt");
            anchorBytes,
    }
        for (String[] testCase : testCases) {  
import org.opensearch.action.search.SearchRequest;
        HierarchicalRoutingSearchProcessor processor = createProcessor("path_field", 2, "/", true);
    public void testCustomSeparator() throws Exception {
                assertThat("Pattern: " + pattern, transformedRequest.routing(), nullValue());
            { "/company/engineering/*", "/company/engineering" },  
        SearchRequest request = new SearchRequest().source(source);  
            "test",  
            new org.opensearch.common.hash.MurmurHash3.Hash128()  
            anchorBytes.length,
        exception = expectThrows(
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
    }
        // Test missing path_field
        // Test depth 2  
    }
        config1.put("anchor_depth", 2);  
    public void testFactory() throws Exception {
import static org.hamcrest.Matchers.containsString;
            config,  
 * SPDX-License-Identifier: Apache-2.0
        byte[] anchorBytes = anchor.getBytes(java.nio.charset.StandardCharsets.UTF_8);  
        // Test various wildcard patterns
        assertThat(transformedRequest.routing(), equalTo(expectedRouting));
        SearchRequest result2 = processor2.processRequest(request2);
import org.opensearch.test.AbstractBuilderTestCase;
