     */
     * </p>  
                    aggregators.add(aggregator);
     * perform collection of the documents for a leaf segment. For sequential search case, there is always a single search thread which
 * after search on each leaf is completed and b) process the collectors to perform reduce after collection is completed
import java.util.Deque;
                if (currentCollector instanceof Aggregator aggregator) {
}
 * compatible open source license.
                        collectors.offer(innerCollector);  
                    for (Collector innerCollector : multiBucketCollector.getCollectors()) {
        final Queue<Collector> collectors = new LinkedList<>();
                } else if (currentCollector instanceof MultiBucketCollector multiBucketCollector) {
                    // Do not perform postCollection for MultiBucketCollector as we are unwrapping that below
     * {@link BucketCollector#postCollection()} functionality using the lucene interface directly such that postCollection gets called
     * input is expected to contain the collectors related to Aggregations only as that is passed to {@link AggregationCollectorManager}
     */
import org.opensearch.search.profile.query.InternalProfileCollector;
                }
            } else if (currentCollector instanceof MinimumScoreCollector minimumScoreCollector) {
import org.opensearch.search.internal.SearchContext;  
     * @param collectors collection of aggregation collectors to reduce  
     * tree instance in case of concurrent segment search such that postCollection happens on the same slice thread which initialize and  
/**  
                    aggregations.add(aggregator.buildTopLevelBatch());
     * @return list of unwrapped {@link Aggregator}
     * @return list of unwrapped {@link InternalAggregation}  
     * @param collectors collection of aggregation collectors to reduce
        List<Aggregator> aggregators = new ArrayList<>();
    /**  
import java.io.IOException;  
        return internalAggregations;  
    public void processPostCollection(Collector collectorTree) throws IOException {  
    }
                    for (Collector innerCollector : multiBucketCollector.getCollectors()) {
 */  
        final Queue<Collector> collectors = new LinkedList<>();
     * DocValues for each segment is always accessed by a single thread at a time but those threads may be different (e.g. slice thread
                if (internalProfileCollector.getCollector() instanceof Aggregator aggregator) {  
                    collectors.offer(innerCollector);  
                    }
 * Processor to perform collector level processing specific to {@link BucketCollector} in different stages like: a) PostCollection
        while (!collectors.isEmpty()) {  
            } else if (currentCollector instanceof BucketCollector bucketCollector) {
        }
     * <p>
                    // Call postCollection() before building to ensure collectors finalize their data
                } else if (currentCollector instanceof MultiBucketCollector multiBucketCollector) {  
    @ExperimentalApi
     * </p>  
     * after the collection of documents on a leaf is completed. This method will be called by different slice threads on its own collector
     * reduce at shard level before returning response to coordinator
     * Unwraps the input collection of {@link Collector} to get the list of the {@link Aggregator} used by different slice threads. The
     * This was originally done in {@link org.opensearch.search.aggregations.AggregationProcessor#postProcess(SearchContext)}. But with
import java.util.LinkedList;
     * NOTE: We can evaluate and deprecate this postCollection processing once lucene release the changes described in the
     * gets initialized on different threads for different segments (or slices). Whereas the postProcess happens as part of reduce phase
    /**
                    bucketCollector.postCollection();
     * and is performed on the separate thread which is from search threadpool and not from slice threadpool. So two different threads
            Collector currentCollector = collectors.poll();
            Collector currentCollector = allCollectors.pop();
        return aggregations;
            } else if (currentCollector instanceof MultiCollector multiCollector) {
     * during the reduce phase. This list of {@link Aggregator} is used to create {@link InternalAggregation} and optionally perform
import java.util.Queue;
                    // This is critical for aggregators like CardinalityAggregator that defer processing until postCollect()  
                aggregators.add(aggregator);
                }
                }
import java.util.Arrays;
     */
 * SPDX-License-Identifier: Apache-2.0
     * performs both collection and postCollection on {@link BucketCollector}.
        while (!allCollectors.isEmpty()) {  
                }
                collectors.offer(internalProfileCollector.getCollector());  
     */  
/*  
        }
package org.opensearch.search.aggregations;
            }
                    bucketCollector.postCollection();
                // Perform build aggregation during post collection  
            } else if (currentCollector instanceof MultiCollector multiCollector) {  
            }  
        List<InternalAggregation> internalAggregations = new ArrayList<>();  
     * from the slice thread by lucene itself
                for (Collector innerCollector : multiCollector.getCollectors()) {
     * concurrent segment search path this needs to be performed here. There are AssertingCodecs in lucene which validates that the
                // Perform build aggregation during post collection
                currentCollector = internalProfileCollector.getCollector();  
                collectors.offer(minimumScoreCollector.getCollector());  
 */
            }
                collectors.offer(minimumScoreCollector.getCollector());
                if (currentCollector instanceof Aggregator aggregator) {  
        final Deque<Collector> allCollectors = new LinkedList<>(collectors);
                        collectors.offer(innerCollector);
        }  
    /**
    /**  
                    aggregator.buildTopLevel();  
     * For streaming aggregation, build one aggregation batch result
    }
            if (currentCollector instanceof Aggregator aggregator) {  
import org.opensearch.common.annotation.ExperimentalApi;  
            if (currentCollector instanceof InternalProfileCollector internalProfileCollector) {
     * input is expected to contain the collectors related to Aggregations only as that is passed to {@link AggregationCollectorManager}  
        }
            if (currentCollector instanceof Aggregator aggregator) {  
 * @opensearch.api
import java.util.List;  
            Collector currentCollector = collectors.poll();
     * <a href="https://github.com/apache/lucene/issues/12375">issue-12375</a>. With this new change we should be able to implement  
public class BucketCollectorProcessor {
import org.opensearch.common.lucene.MinimumScoreCollector;
     * performs the access on the DocValues causing the AssertingCodec to fail. From functionality perspective, there is no issue as  
    }
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to  
            } else if (currentCollector instanceof InternalProfileCollector internalProfileCollector) {
        while (!collectors.isEmpty()) {
        final Deque<Collector> allCollectors = new LinkedList<>(collectors);  
                    }  
    public List<InternalAggregation> buildAggBatch(Collector collectorTree) throws IOException {
                }  
            }
     * during the reduce phase. This list of {@link InternalAggregation} is used to optionally perform reduce at shard level before  
        collectors.offer(collectorTree);
    public List<InternalAggregation> toInternalAggregations(Collection<Collector> collectors) throws IOException {
     * Performs {@link BucketCollector#postCollection()} on all the {@link BucketCollector} in the given {@link Collector} collector tree
            } else if (currentCollector instanceof MultiBucketCollector multiBucketCollector) {
                allCollectors.addAll(Arrays.asList(multiBucketCollector.getCollectors()));  
            final Collector currentCollector = allCollectors.pop();
     * DocValues created for a field is always used by the same thread for a request. In concurrent segment search case, the DocValues  
                for (Collector innerCollector : multiCollector.getCollectors()) {
    }
 *  
            } else if (currentCollector instanceof MultiBucketCollector multiBucketCollector) {
                collectors.offer(internalProfileCollector.getCollector());
            if (currentCollector instanceof InternalProfileCollector internalProfileCollector) {
                    collectors.offer(innerCollector);
                allCollectors.addAll(Arrays.asList(multiBucketCollector.getCollectors()));  
            }
import org.apache.lucene.search.Collector;
            } else if (currentCollector instanceof MinimumScoreCollector minimumScoreCollector) {
     * <p>  
            } else if (currentCollector instanceof BucketCollector bucketCollector) {
        collectors.offer(collectorTree);  
     * during collection and then search thread during reduce)
     * returning response to coordinator
        while (!allCollectors.isEmpty()) {
     * @param collectorTree collector tree used by calling thread
 *
import org.apache.lucene.search.MultiCollector;
        return aggregators;  
        final List<InternalAggregation> aggregations = new ArrayList<>();  
                    allCollectors.addAll(Arrays.asList(multiBucketCollector.getCollectors()));  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collection;  
import java.util.ArrayList;
     * Unwraps the input collection of {@link Collector} to get the list of the {@link InternalAggregation}. The
                } else if (internalProfileCollector.getCollector() instanceof MultiBucketCollector multiBucketCollector) {
            if (currentCollector instanceof InternalProfileCollector internalProfileCollector) {  
    public List<Aggregator> toAggregators(Collection<Collector> collectors) {  
@PublicApi(since = "2.10.0")  
                internalAggregations.add(aggregator.getPostCollectionAggregation());
