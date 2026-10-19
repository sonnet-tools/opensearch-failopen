                // Now mark as cancelled — should throw TaskCancelledException
import org.opensearch.index.query.QueryShardContext;
                IndexSearcher searcher = newIndexSearcher(reader);
import org.apache.lucene.util.BytesRef;  
import org.opensearch.search.internal.SearchContext;  
import org.apache.lucene.document.Document;
                    searcher,
package org.opensearch.search.aggregations;
            for (int i = 0; i < 10; i++) {
import static org.mockito.Mockito.when;  
import java.util.List;  
                    keywordField("field")  
                TermsAggregationBuilder aggBuilder = new TermsAggregationBuilder("terms").field("field").size(10);
                    createIndexSettings(),  
            }  
                assertFalse(aggregators.isEmpty());  
 * SPDX-License-Identifier: Apache-2.0
/*  
/**
    }
}
import org.apache.lucene.document.SortedSetDocValuesField;
import org.apache.lucene.search.MatchAllDocsQuery;  
                    new MatchAllDocsQuery(),
                );  
            }
                );
                indexWriter.addDocument(doc);
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
 */  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.DirectoryReader;  
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
 * Tests that {@link AggregatorFactories#createTopLevelAggregators} checks for task cancellation  
import org.opensearch.core.common.breaker.CircuitBreaker;
            indexWriter.close();
                expectThrows(TaskCancelledException.class, () -> factories.createTopLevelAggregators(searchContext));
                List<Aggregator> aggregators = factories.createTopLevelAggregators(searchContext);
 */
import java.io.IOException;
 * between aggregator factory creates.
                doc.add(new SortedSetDocValuesField("field", new BytesRef("value" + i)));
 * this file be licensed under the Apache-2.0 license or a
                MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(  
 *
                when(searchContext.isCancelled()).thenReturn(true);  
                QueryShardContext qsc = searchContext.getQueryShardContext();
                // Verify it works when not cancelled  
import org.apache.lucene.store.Directory;
                    new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                    DEFAULT_MAX_BUCKETS,
import org.apache.lucene.search.IndexSearcher;
                AggregatorFactories factories = factoriesBuilder.build(qsc, null);
    public void testCreateTopLevelAggregatorsThrowsWhenCancelled() throws IOException {
        try (Directory directory = newDirectory()) {  
 * The OpenSearch Contributors require contributions made to  
        }  
                Document doc = new Document();  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
public class AggregatorFactoriesCancellationTests extends AggregatorTestCase {  
                AggregatorFactories.Builder factoriesBuilder = new AggregatorFactories.Builder().addAggregator(aggBuilder);  
            try (IndexReader reader = DirectoryReader.open(directory)) {  
                    bucketConsumer,
 * compatible open source license.
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.opensearch.core.tasks.TaskCancelledException;  
                SearchContext searchContext = createSearchContext(
                when(searchContext.isCancelled()).thenReturn(false);
                // Build AggregatorFactories from a builder with an actual aggregation  
