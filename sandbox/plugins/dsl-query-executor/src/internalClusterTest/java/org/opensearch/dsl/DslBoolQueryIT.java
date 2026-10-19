    }  
        client().prepareIndex(INDEX)  
        createTestIndex();
        );
        createTestIndex();
                new SearchSourceBuilder().query(  
        // Index multiple documents with different field values
                        .minimumShouldMatch("1")  
        );
                    QueryBuilders.boolQuery()
                        .should(QueryBuilders.termQuery("brand", "brandX"))
 * compatible open source license.
                        .minimumShouldMatch("2")
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("brand", "brandX")))));
                )  
    }
                        .should(QueryBuilders.termQuery("tag", "electronics"))
                        .should(QueryBuilders.termQuery("brand", "brandX"))
                        .must(QueryBuilders.termQuery("tag", "electronics"))
                XContentType.JSON
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("tag", "electronics")))));  
                new SearchSourceBuilder().query(
                                .minimumShouldMatch("2")
 * The OpenSearch Contributors require contributions made to  
    // minimum_should_match: Percentage tests
                        .must(QueryBuilders.termQuery("tag", "electronics"))  
        createTestIndex();  
 *
        assertOk(
                        .should(QueryBuilders.termQuery("brand", "brandX"))
                )  
                "{\"name\":\"laptop\",\"price\":1200,\"brand\":\"brandX\",\"rating\":4.5,\"tag\":\"electronics\"}",  
                        )  
            )
    }  
            .setId("2")
    }  
        );  
                                .should(QueryBuilders.termQuery("brand", "brandX"))
                        .should(QueryBuilders.termQuery("brand", "brandX"))  
                )
        );
    // Basic bool query tests
            )  
    }
@AwaitsFix(bugUrl = "DSL query pipeline not fully wired E2E: fragment conversion, shard execution and Arrow Flight drain pending")  
            .setId("4")
                        .should(QueryBuilders.termQuery("rating", 4.5))
                        .should(QueryBuilders.termQuery("brand", "brandY"))  
                )  
                new SearchSourceBuilder().query(  
                        .should(QueryBuilders.termQuery("brand", "brandY"))  
        );
    public void testMinimumShouldMatchSingleCombination() {
                new SearchSourceBuilder().query(
            search(
        );
                new SearchSourceBuilder().query(
                        .must(QueryBuilders.termQuery("tag", "electronics"))  
                            QueryBuilders.boolQuery()
        createTestIndex();
        assertOk(
    public void testNestedBoolQueryWithMinimumShouldMatch() {
    public void testNestedBoolQuery() {  
        );
                        .should(QueryBuilders.termQuery("rating", 4.5))
    }
                        .should(QueryBuilders.termQuery("brand", "brandY"))  
                    QueryBuilders.boolQuery()  
            )
            )
        assertOk(
        assertOk(
    public void testBoolQueryWithMustNot() {  
    public void testMinimumShouldMatchWithMust() {
package org.opensearch.dsl;
            .setSource("{\"name\":\"tablet\",\"price\":600,\"brand\":\"brandX\",\"rating\":3.5,\"tag\":\"electronics\"}", XContentType.JSON)
            search(
                        .should(QueryBuilders.termQuery("brand", "brandZ"))
                    QueryBuilders.boolQuery()
                        .should(QueryBuilders.termQuery("brand", "brandX"))
                        .must(
        client().prepareIndex(INDEX)
        );  
                        .should(QueryBuilders.termQuery("brand", "brandX"))
        assertOk(  
                )
    public void testMinimumShouldMatchNegativePercentage() {
 */
        createTestIndex();
                "{\"name\":\"monitor\",\"price\":400,\"brand\":\"brandZ\",\"rating\":4.2,\"tag\":\"accessories\"}",  
                        .should(QueryBuilders.termQuery("name", "laptop"))  
                        .should(QueryBuilders.termQuery("tag", "electronics"))
            .get();
                )  
        );
                        .minimumShouldMatch("1")
        createTestIndex();
                        .mustNot(QueryBuilders.termQuery("brand", "brandZ"))
                        .should(QueryBuilders.termQuery("name", "laptop"))
        assertOk(
                        .must(  
    }  
 * this file be licensed under the Apache-2.0 license or a
    }  
            )
            search(  
        createTestIndex();
            )
        createTestIndex();
        createTestIndex();  
        assertOk(
        createTestIndex();
    public void testBoolQueryWithMinimumShouldMatchOne() {
                    QueryBuilders.boolQuery()  
            .setId("3")  
                    QueryBuilders.boolQuery()
    // Edge cases  
        createTestIndex();  
        createTestIndex();
/*  
            )
    // minimum_should_match: Combination tests  
                new SearchSourceBuilder().query(
                        .should(QueryBuilders.termQuery("brand", "brandX"))
                    QueryBuilders.boolQuery()
                        )
    public void testBoolQueryWithFilter() {
            search(
import org.opensearch.search.builder.SearchSourceBuilder;
            search(
                                .should(QueryBuilders.termQuery("brand", "brandX"))  
        refresh(INDEX);
        assertOk(  
}
        assertOk(
            search(
            search(
            search(
        createTestIndex();  
            search(
    public void testMinimumShouldMatchNegativeInteger() {
                    QueryBuilders.boolQuery()
                new SearchSourceBuilder().query(
import org.opensearch.common.xcontent.XContentType;
                        .minimumShouldMatch("75%")
        createTestIndex();  
            )
                new SearchSourceBuilder().query(  
            )  
                        .should(QueryBuilders.termQuery("brand", "brandY"))
                )
    }  
    }
                    QueryBuilders.boolQuery()  
    public void testMinimumShouldMatchPositiveInteger() {
                        .must(QueryBuilders.termQuery("tag", "electronics"))
        createTestIndex();  
 * SPDX-License-Identifier: Apache-2.0
                        .minimumShouldMatch("-1")
                                .should(QueryBuilders.termQuery("brand", "brandY"))  
            )
        );
                    QueryBuilders.boolQuery()
                        .should(QueryBuilders.termQuery("name", "laptop"))  
            )
/**  
                            QueryBuilders.boolQuery()
 * Integration tests for bool query with minimum_should_match parameter.
        assertOk(  
        );  
                        .should(QueryBuilders.termQuery("brand", "brandX"))
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
                    QueryBuilders.boolQuery()
                        .mustNot(QueryBuilders.termQuery("name", "phone"))
                        .should(QueryBuilders.termQuery("brand", "brandZ"))
                        .filter(QueryBuilders.termQuery("rating", 4.5))  
                        .should(QueryBuilders.termQuery("brand", "brandY"))  
            .setSource(
                )
                        .should(QueryBuilders.termQuery("tag", "electronics"))
            )
    @Override  
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("tag", "electronics")))));
                        .minimumShouldMatch("-25%")  
            )  
                    QueryBuilders.boolQuery()  
        );
    public void testMinimumShouldMatchMultipleCombinations() {
            search(
    public void testBoolQueryWithShould() {
    }
                )  
    public void testBoolQueryWithMinimumShouldMatchAll() {  
                XContentType.JSON
    protected void createTestIndex() {
    }
                )
                        .should(QueryBuilders.termQuery("brand", "brandY"))  
        client().prepareIndex(INDEX)
                    QueryBuilders.boolQuery()
                        .should(QueryBuilders.termQuery("brand", "brandX"))
            .setSource("{\"name\":\"phone\",\"price\":800,\"brand\":\"brandY\",\"rating\":4.0,\"tag\":\"electronics\"}", XContentType.JSON)  
    public void testMinimumShouldMatchWithFilter() {
 */  
    }
    }
                        .filter(QueryBuilders.termQuery("tag", "electronics"))
                new SearchSourceBuilder().query(  
            .get();  
                new SearchSourceBuilder().query(  
    // Nested bool queries
                        .must(QueryBuilders.termQuery("tag", "electronics"))  
        ensureGreen();  
    // minimum_should_match: Integer tests  
            search(  
                        .should(QueryBuilders.termQuery("brand", "brandX"))
    public void testMinimumShouldMatchPositivePercentage() {
        createTestIndex();
    }
                )
    }  
                )
        createTestIndex();  
            .get();
                        .minimumShouldMatch("2<75%")
            search(  
import org.opensearch.index.query.QueryBuilders;  
            .get();  
                )
                )
            )  
                        .should(QueryBuilders.termQuery("rating", 4.5))
        assertOk(
    }
                    QueryBuilders.boolQuery()
            search(
        );  
                    QueryBuilders.boolQuery()
    }
            .setSource(
            )
        );
        assertOk(
                        .should(QueryBuilders.termQuery("brand", "brandX"))
        assertOk(  
                        .minimumShouldMatch("3<-1 5<50%")
                        .minimumShouldMatch("1")
            )
        assertOk(
public class DslBoolQueryIT extends DslIntegTestBase {
                        .should(QueryBuilders.termQuery("tag", "electronics"))  
                new SearchSourceBuilder().query(
        client().prepareIndex(INDEX)  
        );  
                )  
        createIndex(INDEX);
                new SearchSourceBuilder().query(  
    // minimum_should_match with must/filter
            )
        createTestIndex();
                        .should(QueryBuilders.termQuery("brand", "brandY"))  
                                .should(QueryBuilders.termQuery("brand", "brandY"))
            search(  
        assertOk(  
                new SearchSourceBuilder().query(
                                .should(QueryBuilders.termQuery("brand", "brandZ"))
    public void testBoolQueryWithOnlyShouldClause() {
            search(
                        .minimumShouldMatch("2")
                        .should(QueryBuilders.termQuery("brand", "brandX"))
    public void testBoolQueryWithMust() {  
                new SearchSourceBuilder().query(
    }
    public void testBoolQueryWithAllClauses() {  
                new SearchSourceBuilder().query(
                    QueryBuilders.boolQuery()  
            .setId("1")
