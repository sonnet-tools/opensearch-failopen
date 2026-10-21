import org.opensearch.core.xcontent.XContentBuilder;
import org.apache.lucene.tests.index.RandomIndexWriter;
        protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
            return LeafBucketCollector.NO_OP_COLLECTOR;
                    new TermsAggregationBuilder("categories").field("category")
                Document doc = new Document();
                                .size(50000)
                );
                    OpenSearchRejectedExecutionException.class,
        @Override
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                        name,
import java.util.Map;
                    return new CustomCancellableAggregator(
                    CardinalityUpperBound cardinality,
        @Override
                        keywordField("brand")
        public static final ObjectParser<CustomCancellableAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
                    SearchContext searchContext,
            AggregatorFactory parent,
            return new InternalAggregation[] { internalAggregation };
                }
 * The OpenSearch Contributors require contributions made to
    @Override
                doc.add(new SortedSetDocValuesField("subcategory", new BytesRef("subcat" + (i % 50))));
        @Override
                );
import org.opensearch.core.xcontent.ObjectParser;
import org.apache.lucene.index.DirectoryReader;
        public BucketCardinality bucketCardinality() {
        public static final String NAME = "custom_cancellable";
                        CustomCancellableAggregationBuilder.PARSER
        protected AggregatorFactory doBuild(
    protected List<SearchPlugin> getSearchPlugins() {
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import java.io.IOException;
        @Override
            super(in);
                        subfactoriesBuilder.build(queryShardContext, this),
import org.apache.lucene.index.IndexReader;
                                .subAggregation(new TermsAggregationBuilder("brands").field("brand").size(20000))
        }
            InternalAggregation internalAggregation = new InternalSum(name(), 0.0, DocValueFormat.RAW, metadata());
                );
import org.apache.lucene.index.LeafReaderContext;
                    Map<String, Object> metadata
        try (Directory directory = newDirectory()) {
import org.apache.lucene.document.SortedNumericDocValuesField;
        }
                            new TermsAggregationBuilder("subcategories").field("subcategory")
                        .size(10)
        protected void checkCancelled() {
        }
        ) throws IOException {
                doc.add(new SortedSetDocValuesField("brand", new BytesRef("brand" + (i % 20))));
package org.opensearch.search.aggregations;
        @Override
            Map<String, Object> metadata
/*
}
import org.apache.lucene.search.MatchAllDocsQuery;
    private static class CustomCancellableAggregator extends AggregatorBase {
            return new AggregatorFactory(name, queryShardContext, parent, subfactoriesBuilder, metadata) {
            CustomCancellableAggregationBuilder::new
                    );
            SearchContext context,
        }
        @Override
        public String getType() {
                doc.add(new SortedNumericDocValuesField("value", i));
                IndexSearcher searcher = newIndexSearcher(reader);
        });
        protected void doWriteTo(StreamOutput out) throws IOException {
        }
 */
                // Create nested aggregations with our custom cancellable agg
    }
        CustomCancellableAggregator(
                        aggBuilder,
import org.opensearch.plugins.SearchPlugin;
        @Override
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
                    new AggregationSpec(
            for (int i = 0; i < 100; i++) {
                        searchContext,
            return new CustomCancellableAggregationBuilder(getName()).setMetadata(metadata).subAggregations(factoriesBuilder);
                ) throws IOException {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                        new MatchAllDocsQuery(),
        CustomCancellableAggregationBuilder(String name) {
        public InternalAggregation buildEmptyAggregation() {
    }
                        .subAggregation(
        }
            super(name);
                    )
                        CustomCancellableAggregationBuilder::new,
                CustomCancellableAggregationBuilder aggBuilder = new CustomCancellableAggregationBuilder("test_agg").subAggregation(
            // Create documents
        public CustomCancellableAggregationBuilder(StreamInput in) throws IOException {
                        keywordField("subcategory"),
        }
            checkCancelled();
        }
            Aggregator parent,
            }
        );
                return List.of(
            }
            QueryShardContext queryShardContext,
import org.opensearch.search.aggregations.metrics.InternalSum;
            return NAME;
            throw new OpenSearchRejectedExecutionException("The request has been cancelled");
    }
                doc.add(new SortedSetDocValuesField("category", new BytesRef("cat" + (i % 10))));
                        parent,
            return builder;
    }
        return List.of(new SearchPlugin() {
        public CustomCancellableAggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
                    )
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.document.SortedSetDocValuesField;
                    () -> searchAndReduce(
            String name,
                @Override
        }
            public List<AggregationSpec> getAggregations() {
            NAME,
        }
public class AggregatorCancellationTests extends AggregatorTestCase {
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.search.DocValueFormat;
            // Nothing to write
                        "custom_cancellable",
    private static class CustomCancellableAggregationBuilder extends AbstractAggregationBuilder<CustomCancellableAggregationBuilder> {
import org.opensearch.index.query.QueryShardContext;
import org.apache.lucene.document.Document;
                indexWriter.addDocument(doc);
            return BucketCardinality.NONE;
        }
                        )
                protected Aggregator createInternal(
        }
            super(name, factories, context, parent, CardinalityUpperBound.NONE, metadata);
            AggregatorFactories factories,
import org.opensearch.search.internal.SearchContext;
        }
            AggregatorFactories.Builder subfactoriesBuilder
        ) throws IOException {
            try (IndexReader reader = DirectoryReader.open(directory)) {
        protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
import java.util.List;
                        null
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.IndexSearcher;
            return new InternalSum(name(), 0.0, DocValueFormat.RAW, metadata());
            }
                    Aggregator parent,
        }
import org.apache.lucene.store.Directory;
                expectThrows(
        @Override
    public void testNestedAggregationCancellation() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
                        keywordField("category"),
                        searcher,
            };
            indexWriter.close();
 * compatible open source license.
            @Override
