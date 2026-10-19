    public void testGetType() {
    }
import org.opensearch.action.search.SearchRequest;
        SearchRequest result = processor.processRequest(request);  
        request.source().query(boolQuery);
        assertThat(result.routing(), notNullValue());
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> config = new HashMap<>();
import java.util.HashMap;
    }
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        request2.source().query(QueryBuilders.termQuery("acl_group", aclValue));  
        Map<String, Object> config = new HashMap<>();
        SearchRequest result = processor.processRequest(request);
        Exception e = expectThrows(Exception.class, () -> factory.create(null, null, null, false, config, null));
        config.put("acl_field", "acl_group");
        SearchRequest request = createSearchRequest();
    }  
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", false);
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
    public void testConsistentRoutingGeneration() throws Exception {
        String aclValue = "team-alpha";  
        assertThat(processor.getType(), equalTo("acl_routing_search"));
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()  
        assertThat(request1.routing(), equalTo(request2.routing()));
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
package org.opensearch.search.pipeline.common;
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor("tag", "description", false, "acl_field", true);  
        assertThat(result.routing(), notNullValue());
        SearchRequest request = createSearchRequest();
        SearchRequest request = createSearchRequest();  
    public void testProcessRequestNoSource() throws Exception {
        config.put("extract_from_query", false);
        BoolQueryBuilder outerBool = QueryBuilders.boolQuery().must(innerBool).filter(QueryBuilders.termQuery("acl_group", "team-beta"));
            .should(QueryBuilders.termQuery("acl_group", "team-alpha"))
        request2.source().query(QueryBuilders.termQuery("acl_group", aclValue));  
        SearchRequest request = new SearchRequest();  
        SearchRequest request = createSearchRequest();
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);  
        assertThat(result.routing(), notNullValue());
        SearchRequest result = processor.processRequest(request);  
        SearchRequest result = processor.processRequest(request);
    }
    public void testHashingConsistency() throws Exception {
    }
        assertThat(result.routing(), notNullValue());  
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
    }
 *
        SearchRequest result = processor.processRequest(request);
    public void testNestedBoolQuery() throws Exception {
        request.source(new SearchSourceBuilder());  
        SearchRequest request2 = createSearchRequest();
        SearchRequest request1 = createSearchRequest();
        SearchRequest result = processor.processRequest(request);  
        assertThat(result.routing(), nullValue());  
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()  
    public void testProcessRequestExtractDisabled() throws Exception {  
        request.source().query(QueryBuilders.termQuery("acl_group", "team-alpha"));
import org.opensearch.search.builder.SearchSourceBuilder;
    public void testEmptyTermsQuery() throws Exception {  
        SearchRequest result = processor.processRequest(request);
        request.source().query(QueryBuilders.termsQuery("acl_group", "team-alpha", "team-beta"));
        request1.source().query(QueryBuilders.termQuery("acl_group", aclValue));  
        request.source().query(boolQuery);  
    }  
import static org.hamcrest.Matchers.nullValue;  
    }
        request.source().query(outerBool);
        assertThat(result, equalTo(request));  
    }
            .must(QueryBuilders.termQuery("status", "active"))
    }
    public void testProcessRequestWithBoolQuery() throws Exception {
        SearchRequest result = processor.processRequest(request);
        processor.processRequest(request2);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
/*  
    public void testBoolQueryWithMustNot() throws Exception {
        assertThat(request1.routing(), equalTo(request2.routing()));
    }
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        String aclValue = "team-production";  
    public void testFactoryCreationWithAllParams() throws Exception {
    public void testProcessRequestWithTermsQuery() throws Exception {  
        assertThat(result.routing(), notNullValue());  
    }  
        config.put("acl_field", "team_id");  
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);  
 */  
        assertThat(result.routing(), nullValue());
        assertThat(result.routing(), nullValue());
    }
        assertThat(processor.getType(), equalTo(AclRoutingSearchProcessor.TYPE));
    public void testBoolQueryWithShouldClauses() throws Exception {
        SearchRequest request = createSearchRequest();
        SearchRequest result = processor.processRequest(request);
import static org.hamcrest.Matchers.notNullValue;
    }  
        processor.processRequest(request2);
        AclRoutingSearchProcessor.Factory factory = new AclRoutingSearchProcessor.Factory();  
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
    public void testFactoryCreationMissingAclField() {
        SearchRequest request2 = createSearchRequest();
        SearchRequest request = createSearchRequest();
    }  
        return request;
        SearchRequest request = createSearchRequest();
        request.source().query(QueryBuilders.termQuery("acl_group", "team-alpha"));  
    }
    public void testProcessRequestNoQuery() throws Exception {  
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
 * The OpenSearch Contributors require contributions made to  
        request.source().query(QueryBuilders.termQuery("other_field", "value"));  
        AclRoutingSearchProcessor.Factory factory = new AclRoutingSearchProcessor.Factory();  
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);  
        assertThat(result.routing(), nullValue());
        assertThat(processor.getType(), equalTo(AclRoutingSearchProcessor.TYPE));
        request1.source().query(QueryBuilders.termQuery("acl_group", aclValue));  
        assertThat(result, equalTo(request));
            .mustNot(QueryBuilders.termQuery("acl_group", "team-alpha"));
        SearchRequest request1 = createSearchRequest();
            .should(QueryBuilders.termQuery("acl_group", "team-beta"))
    }  
        processor.processRequest(request1);
    public void testProcessRequestWithTermQuery() throws Exception {
        assertThat(result.routing(), notNullValue());
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
        SearchRequest request = createSearchRequest();
        SearchRequest result = processor.processRequest(request);
        AclRoutingSearchProcessor processor = factory.create(null, null, null, false, config, null);  
        AclRoutingSearchProcessor processor = factory.create(null, null, null, false, config, null);
        SearchRequest request = createSearchRequest();
            .filter(QueryBuilders.termQuery("acl_group", "team-beta"));  
        Map<String, Object> config = new HashMap<>();
    public void testFactoryCreation() throws Exception {
        processor.processRequest(request1);
        SearchRequest request = createSearchRequest();
        AclRoutingSearchProcessor processor = new AclRoutingSearchProcessor(null, null, false, "acl_group", true);
}  
        SearchRequest result = processor.processRequest(request);  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.index.query.QueryBuilders;  
 * compatible open source license.
        AclRoutingSearchProcessor.Factory factory = new AclRoutingSearchProcessor.Factory();
        BoolQueryBuilder innerBool = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("acl_group", "team-alpha"));  
    public void testProcessRequestNoAclInQuery() throws Exception {
    private SearchRequest createSearchRequest() {
        request.source().query(QueryBuilders.termsQuery("acl_group", new Object[] {}));
public class AclRoutingSearchProcessorTests extends OpenSearchTestCase {
    }  
import java.util.Map;
            .minimumShouldMatch(1);  
import org.opensearch.index.query.BoolQueryBuilder;
        assertTrue(e.getMessage().contains("acl_field"));
        request.source().query(boolQuery);
        SearchRequest request = new SearchRequest();
            .must(QueryBuilders.termQuery("acl_group", "team-alpha"))
