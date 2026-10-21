        SearchRequest request = createSearchRequest();
        SearchRequest request = createSearchRequest();
            .should(QueryBuilders.termQuery("acl_group", "team-beta"))
        assertThat(request1.routing(), equalTo(request2.routing()));
        SearchRequest result = processor.processRequest(request);
        assertThat(result.routing(), nullValue());
import org.opensearch.search.builder.SearchSourceBuilder;
        assertThat(result, equalTo(request));
    public void testProcessRequestWithTermsQuery() throws Exception {
        request.source().query(QueryBuilders.termQuery("other_field", "value"));
            .must(QueryBuilders.termQuery("status", "active"))
    }
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
    public void testProcessRequestNoAclInQuery() throws Exception {
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", false);
        Exception e = expectThrows(Exception.class, () -> factory.create(null, null, null, false, config, null));
        assertThat(result.routing(), notNullValue());
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        request1.source().query(QueryBuilders.termQuery("acl_group", aclValue));
    }
    public void testProcessRequestWithTermQuery() throws Exception {
    public void testBoolQueryWithShouldClauses() throws Exception {
        SearchRequest request1 = createSearchRequest();
    public void testConsistentRoutingGeneration() throws Exception {
    }
        config.put("acl_field", "acl_group");
        AclRoutingSearchProcessor.Factory factory = new AclRoutingSearchProcessor.Factory();
        assertThat(result.routing(), nullValue());
import static org.hamcrest.Matchers.equalTo;
        AclRoutingSearchProcessor.Factory factory = new AclRoutingSearchProcessor.Factory();
        request.source().query(boolQuery);
    public void testHashingConsistency() throws Exception {
        SearchRequest request = createSearchRequest();
    public void testProcessRequestExtractDisabled() throws Exception {
        SearchRequest request1 = createSearchRequest();
    }
    public void testFactoryCreationWithAllParams() throws Exception {
        assertThat(processor.getType(), equalTo(AclRoutingSearchProcessor.TYPE));
        request.source().query(boolQuery);
        BoolQueryBuilder innerBool = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("acl_group", "team-alpha"));
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        return request;
    }
        SearchRequest request = createSearchRequest();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
            .should(QueryBuilders.termQuery("acl_group", "team-alpha"))
        config.put("acl_field", "team_id");
        processor.processRequest(request2);
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        Map<String, Object> config = new HashMap<>();
        request.source(new SearchSourceBuilder());
        SearchRequest result = processor.processRequest(request);
        assertThat(processor.getType(), equalTo(AclRoutingSearchProcessor.TYPE));
    }
        SearchRequest request2 = createSearchRequest();
import java.util.HashMap;
        processor.processRequest(request1);
        processor.processRequest(request1);
        SearchRequest result = processor.processRequest(request);
    public void testProcessRequestNoQuery() throws Exception {
        SearchRequest request = createSearchRequest();
        SearchRequest request = new SearchRequest();
    }
            .filter(QueryBuilders.termQuery("acl_group", "team-beta"));
        AclRoutingSearchProcessor processor = factory.create(null, null, null, false, config, null);
    }
    }
        BoolQueryBuilder outerBool = QueryBuilders.boolQuery().must(innerBool).filter(QueryBuilders.termQuery("acl_group", "team-beta"));
        processor.processRequest(request2);
        SearchRequest request2 = createSearchRequest();
import org.opensearch.action.search.SearchRequest;
        SearchRequest result = processor.processRequest(request);
        assertThat(result, equalTo(request));
package org.opensearch.search.pipeline.common;
        AclRoutingSearchProcessor.Factory factory = new AclRoutingSearchProcessor.Factory();
        assertThat(result.routing(), notNullValue());
    public void testGetType() {
        SearchRequest request = new SearchRequest();
public class AclRoutingSearchProcessorTests extends OpenSearchTestCase {
    }
 * this file be licensed under the Apache-2.0 license or a
    public void testProcessRequestWithBoolQuery() throws Exception {
        assertThat(result.routing(), notNullValue());
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
 * compatible open source license.
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
    }
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
        SearchRequest result = processor.processRequest(request);
 */
    public void testNestedBoolQuery() throws Exception {
        assertThat(request1.routing(), equalTo(request2.routing()));
import org.opensearch.test.OpenSearchTestCase;
    public void testBoolQueryWithMustNot() throws Exception {
        assertThat(processor.getType(), equalTo("acl_routing_search"));
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
        request.source().query(QueryBuilders.termQuery("acl_group", "team-alpha"));
            .mustNot(QueryBuilders.termQuery("acl_group", "team-alpha"));
 * SPDX-License-Identifier: Apache-2.0
    public void testFactoryCreationMissingAclField() {
            .minimumShouldMatch(1);
    }
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
    }
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.Matchers.nullValue;
        SearchRequest result = processor.processRequest(request);
        SearchRequest request = createSearchRequest();
    }
        request.source().query(outerBool);
import java.util.Map;
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
    public void testFactoryCreation() throws Exception {
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        assertTrue(e.getMessage().contains("acl_field"));
    public void testEmptyTermsQuery() throws Exception {
        request.source().query(QueryBuilders.termsQuery("acl_group", new Object[] {}));
        SearchRequest result = processor.processRequest(request);
        request1.source().query(QueryBuilders.termQuery("acl_group", aclValue));
        SearchRequest request = createSearchRequest();
        SearchRequest result = processor.processRequest(request);
        Map<String, Object> config = new HashMap<>();
    }
        String aclValue = "team-production";
        config.put("extract_from_query", false);
    }
    private SearchRequest createSearchRequest() {
        request2.source().query(QueryBuilders.termQuery("acl_group", aclValue));
        request.source().query(QueryBuilders.termQuery("acl_group", "team-alpha"));
        AclRoutingSearchProcessor processor = factory.create(null, null, null, false, config, null);
        SearchRequest request = createSearchRequest();
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        assertThat(result.routing(), notNullValue());
        request2.source().query(QueryBuilders.termQuery("acl_group", aclValue));
        assertThat(result.routing(), notNullValue());
        assertThat(result.routing(), nullValue());
    }
        SearchRequest result = processor.processRequest(request);
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        request.source().query(QueryBuilders.termsQuery("acl_group", "team-alpha", "team-beta"));
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor("tag", "description", false, "acl_field", true);
    public void testProcessRequestNoSource() throws Exception {
import org.opensearch.index.query.BoolQueryBuilder;
        SearchRequest result = processor.processRequest(request);
import org.opensearch.index.query.QueryBuilders;
 *
        assertThat(result.routing(), notNullValue());
        SearchRequest request = createSearchRequest();
    }
        SearchRequest result = processor.processRequest(request);
        SearchRequest request = createSearchRequest();
/*
        String aclValue = "team-alpha";
        request.source().query(boolQuery);
        assertThat(result.routing(), nullValue());
import static org.hamcrest.Matchers.notNullValue;
}
            .must(QueryBuilders.termQuery("acl_group", "team-alpha"))
        Map<String, Object> config = new HashMap<>();
