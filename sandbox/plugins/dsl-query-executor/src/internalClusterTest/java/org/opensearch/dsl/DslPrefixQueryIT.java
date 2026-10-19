        createTestIndex();  
    }  
        );
        refresh(INDEX);
            )  
 * Integration tests for prefix query delegation to Lucene via PREFIX_QUERY RexCall.
            .get();
        createTestIndex();  
    public void testPrefixQueryInBoolQuery() {  
        ensureGreen();  
            .setId("2")
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.prefixQuery("name", ""))));
}
    }
        createTestIndex();
 * The OpenSearch Contributors require contributions made to  
    @Override  
    public void testBasicPrefixQuery() {
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            .setSource("{\"name\":\"phone\",\"brand\":\"Samsung\",\"model\":\"Galaxy S21\"}", XContentType.JSON)
    }
        client().prepareIndex(INDEX)  
            .setId("3")
 *
            .setSource("{\"name\":\"laptop\",\"brand\":\"Apple\",\"model\":\"MacBook Pro\"}", XContentType.JSON)
            .setSource("{\"name\":\"tablet\",\"brand\":\"apple\",\"model\":\"iPad Air\"}", XContentType.JSON)  
                new SearchSourceBuilder().query(
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.prefixQuery("brand", "Apple"))));  
    protected void createTestIndex() {
/**  
        createTestIndex();
                )
/*  
    public void testPrefixQueryWithEmptyString() {
            .get();
        assertOk(
    }
 */
        client().prepareIndex(INDEX)
            .get();  
 * SPDX-License-Identifier: Apache-2.0
                        .should(QueryBuilders.prefixQuery("brand", "App"))
public class DslPrefixQueryIT extends DslIntegTestBase {
import org.opensearch.index.query.QueryBuilders;  
        createTestIndex();
 * this file be licensed under the Apache-2.0 license or a
                    QueryBuilders.boolQuery()
        createIndex(INDEX);
    }  
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.prefixQuery("brand", "apple").caseInsensitive(true))));
    public void testPrefixQueryCaseInsensitive() {  
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.prefixQuery("model", "MacBook"))));  
import org.opensearch.search.builder.SearchSourceBuilder;
            search(  
package org.opensearch.dsl;
    }
 * compatible open source license.
    }
    public void testPrefixQueryWithMultipleWords() {
        createTestIndex();
 */  
        client().prepareIndex(INDEX)
    public void testPrefixQueryWithSpecialCharacters() {
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.prefixQuery("model", "Galaxy S"))));  
                        .must(QueryBuilders.prefixQuery("name", "lap"))  
    }
            .setId("1")  
import org.opensearch.common.xcontent.XContentType;
    public void testPrefixQueryCaseSensitive() {
@AwaitsFix(bugUrl = "DSL query pipeline not fully wired E2E: fragment conversion, shard execution and Arrow Flight drain pending")  
        createTestIndex();
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.prefixQuery("name", "lap"))));
