                )
        );
    public void testMinimumShouldMatchNegativeInteger() {
                    QueryBuilders.boolQuery()
                    QueryBuilders.boolQuery()
                    QueryBuilders.boolQuery()
            .setId("1")
            .setSource(
    public void testMinimumShouldMatchWithMust() {
        );
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("tag", "electronics")))));
                )
                        .should(QueryBuilders.termQuery("brand", "brandX"))
package org.opensearch.dsl;
    }
        );
public class DslBoolQueryIT extends DslIntegTestBase {
 * this file be licensed under the Apache-2.0 license or a
            )
                        .should(QueryBuilders.termQuery("brand", "brandX"))
    }
        createTestIndex();
        assertOk(
import org.opensearch.common.xcontent.XContentType;
                        .should(QueryBuilders.termQuery("brand", "brandX"))
 *
        createTestIndex();
            )
            )
            search(
        assertOk(
        );
    // minimum_should_match: Combination tests
        );
                    QueryBuilders.boolQuery()
                    QueryBuilders.boolQuery()
                )
    }
                        .must(
                                .should(QueryBuilders.termQuery("brand", "brandZ"))
            search(
        createTestIndex();
                "{\"name\":\"laptop\",\"price\":1200,\"brand\":\"brandX\",\"rating\":4.5,\"tag\":\"electronics\"}",
                XContentType.JSON
                        .should(QueryBuilders.termQuery("tag", "electronics"))
            .setId("3")
                            QueryBuilders.boolQuery()
                        .minimumShouldMatch("1")
/*
        assertOk(
        createTestIndex();
        assertOk(
            )
            .setId("4")
                new SearchSourceBuilder().query(
                    QueryBuilders.boolQuery()
        createTestIndex();
                        .must(QueryBuilders.termQuery("tag", "electronics"))
    protected void createTestIndex() {
                new SearchSourceBuilder().query(
                        .minimumShouldMatch("75%")
        assertOk(
                        .minimumShouldMatch("1")
        createTestIndex();
    public void testMinimumShouldMatchNegativePercentage() {
 * Integration tests for bool query with minimum_should_match parameter.
    }
    public void testBoolQueryWithShould() {
                new SearchSourceBuilder().query(
                )
                        .should(QueryBuilders.termQuery("rating", 4.5))
                new SearchSourceBuilder().query(
    // minimum_should_match: Percentage tests
            )
                        .should(QueryBuilders.termQuery("brand", "brandY"))
                new SearchSourceBuilder().query(
                new SearchSourceBuilder().query(
        );
                        .minimumShouldMatch("2")
import org.opensearch.index.query.QueryBuilders;
        createTestIndex();
    public void testBoolQueryWithMust() {
        createTestIndex();
            )
        client().prepareIndex(INDEX)
                        .should(QueryBuilders.termQuery("brand", "brandZ"))
                        .should(QueryBuilders.termQuery("brand", "brandX"))
        assertOk(
        );
        assertOk(
        createTestIndex();
                    QueryBuilders.boolQuery()
        createTestIndex();
                        .must(QueryBuilders.termQuery("tag", "electronics"))
                    QueryBuilders.boolQuery()
                )
            search(
        createTestIndex();
        );
                new SearchSourceBuilder().query(
        createTestIndex();
            )
                new SearchSourceBuilder().query(
            )
        ensureGreen();
                        .mustNot(QueryBuilders.termQuery("brand", "brandZ"))
    }
            search(
            )
                        .should(QueryBuilders.termQuery("brand", "brandY"))
            search(
                        .should(QueryBuilders.termQuery("brand", "brandX"))
            .get();
            )
 */
                    QueryBuilders.boolQuery()
        assertOk(
    }
                                .minimumShouldMatch("2")
        createTestIndex();
                        .should(QueryBuilders.termQuery("tag", "electronics"))
                        .minimumShouldMatch("-25%")
}
        );
        createTestIndex();
                )
                        .should(QueryBuilders.termQuery("brand", "brandX"))
                    QueryBuilders.boolQuery()
    public void testBoolQueryWithFilter() {
                        .should(QueryBuilders.termQuery("brand", "brandX"))
        );
import org.opensearch.search.builder.SearchSourceBuilder;
    }
        assertOk(
            .get();
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
                )
                new SearchSourceBuilder().query(
    }
        client().prepareIndex(INDEX)
                )
    }
                new SearchSourceBuilder().query(
                        .should(QueryBuilders.termQuery("brand", "brandX"))
        createTestIndex();
        );
    // Nested bool queries
                        .should(QueryBuilders.termQuery("tag", "electronics"))
                )
    public void testMinimumShouldMatchMultipleCombinations() {
 * The OpenSearch Contributors require contributions made to
        );
                        .should(QueryBuilders.termQuery("rating", 4.5))
    }
        createTestIndex();
        createIndex(INDEX);
            search(
            .get();
                new SearchSourceBuilder().query(
        assertOk(
            )
    // minimum_should_match with must/filter
        refresh(INDEX);
    // Basic bool query tests
                        .should(QueryBuilders.termQuery("brand", "brandX"))
    public void testBoolQueryWithMustNot() {
            search(
                )
    }
            .setSource(
                )
                        .should(QueryBuilders.termQuery("brand", "brandY"))
            search(
        assertOk(
                        .should(QueryBuilders.termQuery("brand", "brandZ"))
            search(
    }
        assertOk(
                        .should(QueryBuilders.termQuery("brand", "brandX"))
            .setSource("{\"name\":\"phone\",\"price\":800,\"brand\":\"brandY\",\"rating\":4.0,\"tag\":\"electronics\"}", XContentType.JSON)
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("brand", "brandX")))));
                    QueryBuilders.boolQuery()
            .setId("2")
            .setSource("{\"name\":\"tablet\",\"price\":600,\"brand\":\"brandX\",\"rating\":3.5,\"tag\":\"electronics\"}", XContentType.JSON)
                    QueryBuilders.boolQuery()
                                .should(QueryBuilders.termQuery("brand", "brandX"))
    public void testMinimumShouldMatchPositivePercentage() {
                        .minimumShouldMatch("-1")
    }
    public void testMinimumShouldMatchWithFilter() {
            search(
                new SearchSourceBuilder().query(
                                .should(QueryBuilders.termQuery("brand", "brandX"))
        client().prepareIndex(INDEX)
            )
                        .minimumShouldMatch("3<-1 5<50%")
                                .should(QueryBuilders.termQuery("brand", "brandY"))
    // Edge cases
            search(
    public void testNestedBoolQueryWithMinimumShouldMatch() {
        client().prepareIndex(INDEX)
                )
    public void testBoolQueryWithAllClauses() {
                        .should(QueryBuilders.termQuery("brand", "brandY"))
                )
    public void testMinimumShouldMatchSingleCombination() {
                        .should(QueryBuilders.termQuery("tag", "electronics"))
    // minimum_should_match: Integer tests
        // Index multiple documents with different field values
        );
                )
                        .must(
                        .should(QueryBuilders.termQuery("brand", "brandX"))
                    QueryBuilders.boolQuery()
                            QueryBuilders.boolQuery()
                        .should(QueryBuilders.termQuery("name", "laptop"))
        createTestIndex();
        );
 * SPDX-License-Identifier: Apache-2.0
            .get();
    }
                        .should(QueryBuilders.termQuery("brand", "brandX"))
            )
        assertOk(
    public void testMinimumShouldMatchPositiveInteger() {
            )
    public void testBoolQueryWithMinimumShouldMatchAll() {
    }
            )
                    QueryBuilders.boolQuery()
                        )
 * compatible open source license.
@AwaitsFix(bugUrl = "DSL query pipeline not fully wired E2E: fragment conversion, shard execution and Arrow Flight drain pending")
        assertOk(search(new SearchSourceBuilder().query(QueryBuilders.boolQuery().filter(QueryBuilders.termQuery("tag", "electronics")))));
                        .should(QueryBuilders.termQuery("name", "laptop"))
    }
                        .minimumShouldMatch("2<75%")
                                .should(QueryBuilders.termQuery("brand", "brandY"))
        );
                new SearchSourceBuilder().query(
                        .minimumShouldMatch("1")
            search(
            search(
                        .should(QueryBuilders.termQuery("rating", 4.5))
        createTestIndex();
    @Override
                        .filter(QueryBuilders.termQuery("tag", "electronics"))
                XContentType.JSON
                        .should(QueryBuilders.termQuery("name", "laptop"))
                        .should(QueryBuilders.termQuery("brand", "brandY"))
            )
    }
    }
 */
            )
                        )
                        .must(QueryBuilders.termQuery("tag", "electronics"))
/**
        assertOk(
        assertOk(
            search(
                    QueryBuilders.boolQuery()
            search(
                        .mustNot(QueryBuilders.termQuery("name", "phone"))
    public void testNestedBoolQuery() {
                new SearchSourceBuilder().query(
                        .should(QueryBuilders.termQuery("brand", "brandY"))
                        .must(QueryBuilders.termQuery("tag", "electronics"))
    public void testBoolQueryWithOnlyShouldClause() {
                        .must(QueryBuilders.termQuery("tag", "electronics"))
    public void testBoolQueryWithMinimumShouldMatchOne() {
                        .should(QueryBuilders.termQuery("brand", "brandY"))
    }
                "{\"name\":\"monitor\",\"price\":400,\"brand\":\"brandZ\",\"rating\":4.2,\"tag\":\"accessories\"}",
                new SearchSourceBuilder().query(
                        .filter(QueryBuilders.termQuery("rating", 4.5))
                        .minimumShouldMatch("2")
                )
