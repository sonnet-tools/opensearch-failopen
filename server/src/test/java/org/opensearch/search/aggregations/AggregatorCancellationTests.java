                // Create nested aggregations with our custom cancellable agg
        public String getType() {
                                .subAggregation(new TermsAggregationBuilder("brands").field("brand").size(20000))
 *
            QueryShardContext queryShardContext,
/*  
                            new TermsAggregationBuilder("subcategories").field("subcategory")  
                doc.add(new SortedSetDocValuesField("category", new BytesRef("cat" + (i % 10))));
                    () -> searchAndReduce(
import java.util.List;
                        "custom_cancellable",
    private static class CustomCancellableAggregator extends AggregatorBase {
import org.apache.lucene.tests.index.RandomIndexWriter;
        return List.of(new SearchPlugin() {
            return new InternalSum(name(), 0.0, DocValueFormat.RAW, metadata());
package org.opensearch.search.aggregations;
        }
import org.apache.lucene.index.DirectoryReader;
                        CustomCancellableAggregationBuilder.PARSER  
import java.util.Map;
        @Override
        @Override
        public CustomCancellableAggregationBuilder(StreamInput in) throws IOException {
            // Nothing to write  
        public BucketCardinality bucketCardinality() {  
        protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                }
}
    }
        }  
public class AggregatorCancellationTests extends AggregatorTestCase {
            for (int i = 0; i < 100; i++) {  
        }
        }  
            CustomCancellableAggregationBuilder::new  
 */  
                ) throws IOException {  
import org.apache.lucene.search.MatchAllDocsQuery;
        try (Directory directory = newDirectory()) {
    }
        public static final ObjectParser<CustomCancellableAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
        );
            }
                        keywordField("subcategory"),
        protected void doWriteTo(StreamOutput out) throws IOException {
        CustomCancellableAggregationBuilder(String name) {  
                indexWriter.addDocument(doc);  
import org.apache.lucene.store.Directory;  
import org.apache.lucene.document.Document;
                @Override  
 * this file be licensed under the Apache-2.0 license or a
                expectThrows(  
            SearchContext context,
            Aggregator parent,  
            return new CustomCancellableAggregationBuilder(getName()).setMetadata(metadata).subAggregations(factoriesBuilder);
            @Override  
                        keywordField("category"),  
        public CustomCancellableAggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
    }  
import org.apache.lucene.document.SortedSetDocValuesField;  
import org.opensearch.search.internal.SearchContext;
        @Override
            return NAME;
        ) throws IOException {  
            NAME,
import org.opensearch.core.xcontent.XContentBuilder;
            public List<AggregationSpec> getAggregations() {
            return builder;
                        )  
            super(in);
        public InternalAggregation buildEmptyAggregation() {  
            String name,
                        .subAggregation(
                        subfactoriesBuilder.build(queryShardContext, this),
import org.apache.lucene.document.SortedNumericDocValuesField;
        }
        public static final String NAME = "custom_cancellable";
                IndexSearcher searcher = newIndexSearcher(reader);
                        searchContext,  
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
            super(name);
                        aggBuilder,
import org.opensearch.search.DocValueFormat;
                    new AggregationSpec(  
        @Override  
            // Create documents
                        new MatchAllDocsQuery(),
                        null  
                        CustomCancellableAggregationBuilder::new,
import java.io.IOException;  
import org.opensearch.core.xcontent.ObjectParser;  
                        name,
import org.apache.lucene.index.LeafReaderContext;  
                doc.add(new SortedSetDocValuesField("brand", new BytesRef("brand" + (i % 20))));
                    new TermsAggregationBuilder("categories").field("category")  
                        parent,
 * compatible open source license.
                );
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                                .size(50000)
        }
            super(name, factories, context, parent, CardinalityUpperBound.NONE, metadata);
        }  
        }
            checkCancelled();  
                    )  
        ) throws IOException {
import org.opensearch.search.aggregations.metrics.InternalSum;  
        }  
            AggregatorFactories factories,
    public void testNestedAggregationCancellation() throws IOException {
                    OpenSearchRejectedExecutionException.class,
        protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
            return new AggregatorFactory(name, queryShardContext, parent, subfactoriesBuilder, metadata) {
            indexWriter.close();
import org.opensearch.plugins.SearchPlugin;  
        protected AggregatorFactory doBuild(  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                );
                    SearchContext searchContext,
        @Override
                    return new CustomCancellableAggregator(
            }  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.util.BytesRef;
            return new InternalAggregation[] { internalAggregation };
    private static class CustomCancellableAggregationBuilder extends AbstractAggregationBuilder<CustomCancellableAggregationBuilder> {  
                return List.of(
        CustomCancellableAggregator(  
                        searcher,  
        }
            try (IndexReader reader = DirectoryReader.open(directory)) {
                    CardinalityUpperBound cardinality,
import org.apache.lucene.search.IndexSearcher;
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
        });
            };  
            InternalAggregation internalAggregation = new InternalSum(name(), 0.0, DocValueFormat.RAW, metadata());
        }
                Document doc = new Document();
        @Override
import org.opensearch.index.query.QueryShardContext;
                doc.add(new SortedNumericDocValuesField("value", i));
 * SPDX-License-Identifier: Apache-2.0
            AggregatorFactories.Builder subfactoriesBuilder  
            AggregatorFactory parent,
                        .size(10)
            Map<String, Object> metadata
import org.apache.lucene.index.IndexReader;
        }
                protected Aggregator createInternal(
                    Aggregator parent,  
        protected void checkCancelled() {
import org.opensearch.core.common.io.stream.StreamOutput;
            }
        }  
                );
        @Override
        }  
                    Map<String, Object> metadata
            return BucketCardinality.NONE;
                    );
                    )
            throw new OpenSearchRejectedExecutionException("The request has been cancelled");
        @Override
                        keywordField("brand")
    @Override  
    }
                CustomCancellableAggregationBuilder aggBuilder = new CustomCancellableAggregationBuilder("test_agg").subAggregation(
import org.opensearch.core.common.io.stream.StreamInput;  
    protected List<SearchPlugin> getSearchPlugins() {
            return LeafBucketCollector.NO_OP_COLLECTOR;
                doc.add(new SortedSetDocValuesField("subcategory", new BytesRef("subcat" + (i % 50))));  
