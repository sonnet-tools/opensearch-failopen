     */
import org.opensearch.search.profile.query.InternalProfileCollector;
    public void processPostCollection(Collector collectorTree) throws IOException {
     * DocValues created for a field is always used by the same thread for a request. In concurrent segment search case, the DocValues
            } else if (currentCollector instanceof MinimumScoreCollector minimumScoreCollector) {
     * gets initialized on different threads for different segments (or slices). Whereas the postProcess happens as part of reduce phase
        final Queue<Collector> collectors = new LinkedList<>();
     * </p>
    /**
        while (!collectors.isEmpty()) {
import org.opensearch.common.annotation.PublicApi;
            }
import java.util.Arrays;
                    allCollectors.addAll(Arrays.asList(multiBucketCollector.getCollectors()));
 * @opensearch.api
                internalAggregations.add(aggregator.getPostCollectionAggregation());
                    // Call postCollection() before building to ensure collectors finalize their data
                collectors.offer(internalProfileCollector.getCollector());
            }
 * this file be licensed under the Apache-2.0 license or a
            } else if (currentCollector instanceof MultiBucketCollector multiBucketCollector) {
                if (currentCollector instanceof Aggregator aggregator) {
public class BucketCollectorProcessor {
import java.util.ArrayList;
            } else if (currentCollector instanceof BucketCollector bucketCollector) {
 * after search on each leaf is completed and b) process the collectors to perform reduce after collection is completed
        List<InternalAggregation> internalAggregations = new ArrayList<>();
    /**
        final Queue<Collector> collectors = new LinkedList<>();
import java.util.Queue;
                }
            } else if (currentCollector instanceof MultiCollector multiCollector) {
     * concurrent segment search path this needs to be performed here. There are AssertingCodecs in lucene which validates that the
 */
                }
    }
            }
                for (Collector innerCollector : multiCollector.getCollectors()) {
    public List<InternalAggregation> toInternalAggregations(Collection<Collector> collectors) throws IOException {
     * during the reduce phase. This list of {@link Aggregator} is used to create {@link InternalAggregation} and optionally perform
        }
package org.opensearch.search.aggregations;
     * Unwraps the input collection of {@link Collector} to get the list of the {@link InternalAggregation}. The
                } else if (currentCollector instanceof MultiBucketCollector multiBucketCollector) {
     * Unwraps the input collection of {@link Collector} to get the list of the {@link Aggregator} used by different slice threads. The
 *
    public List<InternalAggregation> buildAggBatch(Collector collectorTree) throws IOException {
                    aggregator.buildTopLevel();
 * SPDX-License-Identifier: Apache-2.0
                    bucketCollector.postCollection();
     * from the slice thread by lucene itself
            if (currentCollector instanceof InternalProfileCollector internalProfileCollector) {
                    collectors.offer(innerCollector);
                }
     * @param collectorTree collector tree used by calling thread
                    bucketCollector.postCollection();
                    }
                currentCollector = internalProfileCollector.getCollector();
import org.apache.lucene.search.MultiCollector;
            if (currentCollector instanceof InternalProfileCollector internalProfileCollector) {
@PublicApi(since = "2.10.0")
     * after the collection of documents on a leaf is completed. This method will be called by different slice threads on its own collector
     * <a href="https://github.com/apache/lucene/issues/12375">issue-12375</a>. With this new change we should be able to implement
     * @param collectors collection of aggregation collectors to reduce
        }
}
                // Perform build aggregation during post collection
import org.opensearch.common.annotation.ExperimentalApi;
                }
import java.util.LinkedList;
                for (Collector innerCollector : multiCollector.getCollectors()) {
            } else if (currentCollector instanceof InternalProfileCollector internalProfileCollector) {
     * {@link BucketCollector#postCollection()} functionality using the lucene interface directly such that postCollection gets called
import org.apache.lucene.search.Collector;
     */
        final Deque<Collector> allCollectors = new LinkedList<>(collectors);
                        collectors.offer(innerCollector);
 */
import org.opensearch.search.internal.SearchContext;
import java.io.IOException;
     * </p>
import java.util.Deque;
     * DocValues for each segment is always accessed by a single thread at a time but those threads may be different (e.g. slice thread
        while (!allCollectors.isEmpty()) {
        while (!allCollectors.isEmpty()) {
     * <p>
    /**
                aggregators.add(aggregator);
     * perform collection of the documents for a leaf segment. For sequential search case, there is always a single search thread which
            Collector currentCollector = allCollectors.pop();
        collectors.offer(collectorTree);
     * during collection and then search thread during reduce)
     * tree instance in case of concurrent segment search such that postCollection happens on the same slice thread which initialize and
import java.util.Collection;
     * This was originally done in {@link org.opensearch.search.aggregations.AggregationProcessor#postProcess(SearchContext)}. But with
            } else if (currentCollector instanceof MinimumScoreCollector minimumScoreCollector) {
        }
                } else if (currentCollector instanceof MultiBucketCollector multiBucketCollector) {
/**
                        collectors.offer(innerCollector);
     * input is expected to contain the collectors related to Aggregations only as that is passed to {@link AggregationCollectorManager}
     */
     * performs the access on the DocValues causing the AssertingCodec to fail. From functionality perspective, there is no issue as
        List<Aggregator> aggregators = new ArrayList<>();
/*
            }
                allCollectors.addAll(Arrays.asList(multiBucketCollector.getCollectors()));
                if (internalProfileCollector.getCollector() instanceof Aggregator aggregator) {
        return aggregations;
    }
                    aggregations.add(aggregator.buildTopLevelBatch());
                    collectors.offer(innerCollector);
     * <p>
import java.util.List;
            }
            } else if (currentCollector instanceof MultiBucketCollector multiBucketCollector) {
                } else if (internalProfileCollector.getCollector() instanceof MultiBucketCollector multiBucketCollector) {
 * compatible open source license.
                    }
     * NOTE: We can evaluate and deprecate this postCollection processing once lucene release the changes described in the
        return aggregators;
                    for (Collector innerCollector : multiBucketCollector.getCollectors()) {
    }
    /**
     * returning response to coordinator
            if (currentCollector instanceof Aggregator aggregator) {
                collectors.offer(minimumScoreCollector.getCollector());
            Collector currentCollector = collectors.poll();
            } else if (currentCollector instanceof BucketCollector bucketCollector) {
     * during the reduce phase. This list of {@link InternalAggregation} is used to optionally perform reduce at shard level before
     * input is expected to contain the collectors related to Aggregations only as that is passed to {@link AggregationCollectorManager}
        }
                // Perform build aggregation during post collection
    }
    @ExperimentalApi
                allCollectors.addAll(Arrays.asList(multiBucketCollector.getCollectors()));
        collectors.offer(collectorTree);
     * @return list of unwrapped {@link InternalAggregation}
     * and is performed on the separate thread which is from search threadpool and not from slice threadpool. So two different threads
                    aggregators.add(aggregator);
     * Performs {@link BucketCollector#postCollection()} on all the {@link BucketCollector} in the given {@link Collector} collector tree
     */
     * reduce at shard level before returning response to coordinator
                    // Do not perform postCollection for MultiBucketCollector as we are unwrapping that below
 * Processor to perform collector level processing specific to {@link BucketCollector} in different stages like: a) PostCollection
    public List<Aggregator> toAggregators(Collection<Collector> collectors) {
            if (currentCollector instanceof Aggregator aggregator) {
 * The OpenSearch Contributors require contributions made to
            Collector currentCollector = collectors.poll();
                    // This is critical for aggregators like CardinalityAggregator that defer processing until postCollect()
     * @param collectors collection of aggregation collectors to reduce
     * For streaming aggregation, build one aggregation batch result
 *
            if (currentCollector instanceof InternalProfileCollector internalProfileCollector) {
import org.opensearch.common.lucene.MinimumScoreCollector;
                    for (Collector innerCollector : multiBucketCollector.getCollectors()) {
     * performs both collection and postCollection on {@link BucketCollector}.
                if (currentCollector instanceof Aggregator aggregator) {
        return internalAggregations;
                collectors.offer(minimumScoreCollector.getCollector());
            final Collector currentCollector = allCollectors.pop();
     * @return list of unwrapped {@link Aggregator}
        while (!collectors.isEmpty()) {
        final List<InternalAggregation> aggregations = new ArrayList<>();
                collectors.offer(internalProfileCollector.getCollector());
                }
            } else if (currentCollector instanceof MultiCollector multiCollector) {
        final Deque<Collector> allCollectors = new LinkedList<>(collectors);
