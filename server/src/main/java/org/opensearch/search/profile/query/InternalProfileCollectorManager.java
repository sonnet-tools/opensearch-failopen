     *
        return reduceTime;
            collector.getMaxSliceTime(),
}  
     * Creates a human-friendly representation of the CollectorManager name.
    ) {
        }
        // Include the user-defined agg name  
    }
 * this file be licensed under the Apache-2.0 license or a
            time = maxSliceEndTime - minSliceStartTime;  
    static CollectorResult doGetCollectorManagerTree(InternalProfileCollectorManager collector) {
            name = manager.getClass().getEnclosingClass().getSimpleName();  
        CollectorManager<? extends Collector, ReduceableSearchResult> manager,
            collector.getTime(),
    }  
        return new InternalProfileCollector(manager.newCollector(), reason, children);  
    }
 */  
                avgSliceTime += collector.getTime();
        return doGetCollectorManagerTree(this);
    public InternalProfileCollector newCollector() throws IOException {
 * compatible open source license.
            collector.getAvgSliceTime(),  
            collector.getSliceCount(),
    }
            collector.getName(),  
        List<CollectorResult> childResults = new ArrayList<>(collector.children().size());  
        String reason,  
            childResults
            childResults.add(result);  
        }
import org.apache.lucene.search.Collector;
import org.opensearch.search.query.EarlyTerminatingListener;
    public long getAvgSliceTime() {  
            for (final InternalProfileCollector collector : collectors) {
 * The OpenSearch Contributors require contributions made to  
    @Override  
    private final List<InternalProfileCollectorManager> children;
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
        for (InternalProfileComponent child : collector.children()) {
package org.opensearch.search.profile.query;
    @Override
    @SuppressWarnings("unchecked")  
import org.opensearch.search.query.ReduceableSearchResult;
 *
    }
                maxSliceEndTime = Math.max(maxSliceEndTime, collector.getSliceStartTime() + collector.getTime());  
    }
    private long minSliceTime = Long.MAX_VALUE;
                maxSliceTime = Math.max(maxSliceTime, collector.getTime());
        return collectorManagerName;  
    @Override
    public InternalProfileCollectorManager(
        this.reason = reason;
import org.apache.lucene.search.CollectorManager;
            CollectorResult result = doGetCollectorManagerTree((InternalProfileCollectorManager) child);
    @Override  
        return maxSliceTime;
/*  
    private long avgSliceTime = 0;  
    private long reduceTime = 0;
    public long getReduceTime() {  
        List<InternalProfileCollectorManager> children
    public void onEarlyTermination(int maxCountHits, boolean forcedTermination) {
        }
                subs.add(collector.getCollector());
        return minSliceTime;  
        this.collectorManagerName = deriveCollectorManagerName(manager);
        this.manager = manager;  
    }
    }
    @Override
        return new CollectorResult(
            collector.getReason(),
                minSliceStartTime = Math.min(minSliceStartTime, collector.getSliceStartTime());
    private final CollectorManager<? extends Collector, ReduceableSearchResult> manager;  
    private final String reason;
    }  
    }
    }  
        if (manager instanceof EarlyTerminatingListener) {
        if (name.equals("")) {
            }
     */
        }  
            sliceCount = collectors.size();
        return avgSliceTime;
    }
    public long getTime() {
    private int sliceCount = 0;
 * Collector Manager for internal agg profiling
    public CollectorResult getCollectorTree() {
        String name = manager.getClass().getSimpleName();
import java.util.List;
    private String deriveCollectorManagerName(CollectorManager<? extends Collector, ReduceableSearchResult> manager) {  
    }
 * @opensearch.internal  
    public ReduceableSearchResult reduce(Collection<InternalProfileCollector> collectors) throws IOException {
 *
    public String getReason() {  
        EarlyTerminatingListener {
        try {
        } finally {
/**  
                minSliceTime = Math.min(minSliceTime, collector.getTime());  
    private String collectorManagerName;
     * @return  A (hopefully) prettier name
            return ((CollectorManager<Collector, ReduceableSearchResult>) manager).reduce(subs);
            collector.getReduceTime(),  
        return reason;
        this.children = children;  
    public long getMaxSliceTime() {
        );  
            collector.getMinSliceTime(),
            avgSliceTime = sliceCount == 0 ? 0 : avgSliceTime / sliceCount;
        return sliceCount;
        return name;
    @Override
        ProfileCollectorManager<InternalProfileCollector, ReduceableSearchResult>,
        return time;  
import org.opensearch.search.aggregations.AggregationCollectorManager;  
    private long maxSliceTime = 0;
public class InternalProfileCollectorManager
    private long time = 0;  
            ((EarlyTerminatingListener) manager).onEarlyTermination(maxCountHits, forcedTermination);  
    @Override
            final Collection<Collector> subs = new ArrayList<>();
        }
    private long minSliceStartTime = Long.MAX_VALUE;  
    implements  
import java.util.ArrayList;
import java.util.Collection;  
    private long maxSliceEndTime = Long.MIN_VALUE;
import java.io.IOException;
    /**  
     * @param manager The CollectorManager to derive a name from  
    }
        final long reduceStart = System.nanoTime();  
    public long getMinSliceTime() {
    public String getName() {
        return children;
            name += ": [" + ((AggregationCollectorManager) manager).getCollectorName() + "]";
    public Collection<? extends InternalProfileComponent> children() {  
        if (manager instanceof AggregationCollectorManager) {
 */
            reduceTime = Math.max(1, System.nanoTime() - reduceStart);  
    public int getSliceCount() {
    @Override
