import org.opensearch.index.query.QueryBuilders;  
    public void testWildcardWithBothWildcards() {  
        createTestIndex();
        );  
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.wildcardQuery("name", "*"))));
public class DslWildcardQueryIT extends DslIntegTestBase {
                        .must(QueryBuilders.wildcardQuery("name", "lap*"))
        createTestIndex();
    }
    public void testWildcardInBoolQuery() {
        client().prepareIndex(INDEX)
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.wildcardQuery("sku", "*-2021-*"))));  
import org.opensearch.common.xcontent.XContentType;
 *
        assertOk(
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.wildcardQuery("name", "lap*"))));
/**  
            .setId("3")
    protected void createTestIndex() {
    }  
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.wildcardQuery("model", "MACBOOK*").caseInsensitive(true))));
        createTestIndex();
                    QueryBuilders.boolQuery()
        createIndex(INDEX);
            search(
 * The OpenSearch Contributors require contributions made to  
            .setSource("{\"name\":\"laptop\",\"model\":\"MacBook Pro\",\"sku\":\"MB-2021-001\"}", XContentType.JSON)
        client().prepareIndex(INDEX)
import org.opensearch.search.builder.SearchSourceBuilder;
 */
        ensureGreen();  
 */  
        createTestIndex();  
        createTestIndex();
package org.opensearch.dsl;
            .get();  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    public void testWildcardCaseInsensitive() {
                        .should(QueryBuilders.wildcardQuery("model", "*Pro"))  
/*  
    }
    public void testWildcardWithQuestionMark() {
 * Integration tests for wildcard query delegation to Lucene via WILDCARD_QUERY_DSL RexCall.
            .setSource("{\"name\":\"tablet\",\"model\":\"iPad Air\",\"sku\":\"IP-2020-003\"}", XContentType.JSON)  
            .get();
    }
                )
}
            .setId("2")
    }  
    public void testWildcardMatchAll() {  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        refresh(INDEX);
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.wildcardQuery("name", "p?one"))));  
        createTestIndex();  
    }  
            .get();
        client().prepareIndex(INDEX)  
    public void testWildcardWithMultipleAsterisks() {
        createTestIndex();  
    }
            )
 * compatible open source license.
            .setSource("{\"name\":\"phone\",\"model\":\"Galaxy S21\",\"sku\":\"GS-2021-002\"}", XContentType.JSON)
            .setId("1")  
    public void testWildcardWithAsterisk() {
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.wildcardQuery("model", "?acBook*"))));
@AwaitsFix(bugUrl = "DSL query pipeline not fully wired E2E: fragment conversion, shard execution and Arrow Flight drain pending")  
    }
    @Override  
                new SearchSourceBuilder().query(  
