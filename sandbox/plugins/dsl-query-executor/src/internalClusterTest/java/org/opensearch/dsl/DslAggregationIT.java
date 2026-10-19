                        new TermsAggregationBuilder("by_brand").field("brand")
    public void testTermsBucketOrderByMetric() {
            )  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            )
    public void testMultipleMetrics() {
                        new TermsAggregationBuilder("by_brand").field("brand")
        assertOk(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.opensearch.search.builder.SearchSourceBuilder;
        );  
                    .aggregation(AggregationBuilders.max("max_price").field("price"))  
            search(
@AwaitsFix(bugUrl = "analytics engine pipeline not E2E complete: fragment conversion + shard execution + Arrow Flight drain not yet wired")
    }  
                                new TermsAggregationBuilder("by_name").field("name")
        createTestIndex();  
    public void testNestedBuckets() {
        assertOk(  
                new SearchSourceBuilder().size(0)
/*  
        createTestIndex();
 */  
            search(
                new SearchSourceBuilder().size(0)
        assertOk(  
            search(  
            )
                    .aggregation(AggregationBuilders.avg("avg_price").field("price"))  
    public void testTermsBucket() {
                    .aggregation(AggregationBuilders.min("min_price").field("price"))
        assertOk(  
    public void testTermsBucketWithMetric() {
        // size > 0 with aggs produces both HITS + AGGREGATION plans  
        createTestIndex();  
            )
    }
        assertOk(search(new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.avg("avg_price").field("price"))));
 * Uses matchAllQuery; focus is on aggregation plan building.  
 * The OpenSearch Contributors require contributions made to  
        createTestIndex();
        );  
                    )
    }
        assertOk(
public class DslAggregationIT extends DslIntegTestBase {  
                            .order(BucketOrder.aggregation("avg_price", false))
        assertOk(
    }  
                new SearchSourceBuilder().size(0)
                        new TermsAggregationBuilder("by_brand").field("brand")
package org.opensearch.dsl;
}
    }
/**
            )  
                    .aggregation(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(true)))  
                new SearchSourceBuilder().size(0)
 * Integration tests for DSL aggregation conversion.
import org.opensearch.search.aggregations.BucketOrder;  
 *
                            .subAggregation(AggregationBuilders.avg("avg_price").field("price"))
    }
        );
                    .aggregation(  
    public void testTermsBucketOrderByKeyDesc() {
            search(
            search(
 * SPDX-License-Identifier: Apache-2.0
    public void testTermsBucketOrderByKeyAsc() {
                            .subAggregation(AggregationBuilders.avg("avg_price").field("price"))  
                    .aggregation(AggregationBuilders.sum("total_price").field("price"))
                new SearchSourceBuilder().size(0)
        );
        assertOk(search(new SearchSourceBuilder().size(0).aggregation(new TermsAggregationBuilder("by_brand").field("brand"))));
        createTestIndex();
                new SearchSourceBuilder().size(0)  
 * this file be licensed under the Apache-2.0 license or a
                                    .subAggregation(AggregationBuilders.avg("avg_price").field("price"))  
            )
                            .subAggregation(AggregationBuilders.sum("total").field("price"))  
        assertOk(  
                            )
 */
                    .aggregation(
import org.opensearch.search.aggregations.AggregationBuilders;
        createTestIndex();
                    .aggregation(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.count(true)))
    }
            search(
        assertOk(search(new SearchSourceBuilder().size(10).aggregation(AggregationBuilders.avg("avg_price").field("price"))));
        createTestIndex();  
                new SearchSourceBuilder().size(0)  
    }
        createTestIndex();  
                    .aggregation(new TermsAggregationBuilder("by_brand").field("brand").order(BucketOrder.key(false)))
        );
            search(
 * compatible open source license.
    public void testMetricOnly() {
        );
                            .subAggregation(
        createTestIndex();
    }  
    public void testAggsWithHits() {
                    )
    public void testTermsBucketOrderByCountAsc() {  
    }
                    )  
        createTestIndex();
            )
                    .aggregation(  
        );
