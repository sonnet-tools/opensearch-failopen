 * compatible open source license.
import java.util.ArrayList;
import java.util.List;
            earlyTerminatingListener.onEarlyTermination(maxCountHits, forcedTermination);  
 * SPDX-License-Identifier: Apache-2.0
        this.forceTermination = forceTermination;
    public void onEarlyTermination(int maxCountHits, boolean forcedTermination) {
 * @opensearch.internal  
    @Override  
    @Override
 * this file be licensed under the Apache-2.0 license or a
            }
                    r.terminatedEarly(true);
    @SuppressWarnings("unchecked")
import java.io.IOException;
            if (collector.hasEarlyTerminated()) {  
            };  
import org.apache.lucene.search.Collector;
    private final CollectorManager<C, ReduceableSearchResult> manager;
            final ReduceableSearchResult result = manager.reduce(innerCollectors);
/*  
        }  
                didTerminateEarly = true;
 *
    public EarlyTerminatingCollector newCollector() throws IOException {  
 *
    EarlyTerminatingCollectorManager(CollectorManager<C, ReduceableSearchResult> manager, int maxCountHits, boolean forceTermination) {
    }  
import java.util.Collection;  
    }
        if (manager instanceof EarlyTerminatingListener earlyTerminatingListener) {
            innerCollectors.add((C) collector.getCollector());
    private final int maxCountHits;
                public void reduce(QuerySearchResult r) throws IOException {
package org.opensearch.search.query;
                @Override
        this.manager = manager;  
        this.maxCountHits = maxCountHits;
                }
        boolean didTerminateEarly = false;  
        CollectorManager<EarlyTerminatingCollector, ReduceableSearchResult>,
                    result.reduce(r);  
            onEarlyTermination(maxCountHits, forceTermination);  
 */  
    @Override
        EarlyTerminatingListener {
        }
    public ReduceableSearchResult reduce(Collection<EarlyTerminatingCollector> collectors) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
    }
    }
 */
        if (didTerminateEarly) {
}  
        for (EarlyTerminatingCollector collector : collectors) {
            return new ReduceableSearchResult() {  
        return new EarlyTerminatingCollector(manager.newCollector(), maxCountHits, false /* forced termination is not supported */);
 * Manager for the EarlyTerminatingCollector
        }
        final List<C> innerCollectors = new ArrayList<>(collectors.size());
    private boolean forceTermination;  
import org.apache.lucene.search.CollectorManager;
        return manager.reduce(innerCollectors);  
    implements  
public class EarlyTerminatingCollectorManager<C extends Collector>
/**  
