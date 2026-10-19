        return ((CollectorManager<Collector, ReduceableSearchResult>) manager).reduce(subCollectors);
}
    public MinimumScoreCollector newCollector() throws IOException {
    @SuppressWarnings("unchecked")  
 * The OpenSearch Contributors require contributions made to  
 * Manager for the MinimumCollector
/*  
import org.opensearch.common.lucene.MinimumScoreCollector;  
        return new MinimumScoreCollector(manager.newCollector(), minimumScore);
    }
class MinimumCollectorManager implements CollectorManager<MinimumScoreCollector, ReduceableSearchResult> {  
        this.manager = manager;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    private final float minimumScore;
            subCollectors.add(collector.getCollector());
    private final CollectorManager<? extends Collector, ReduceableSearchResult> manager;
    }  
 */
/**  
 *
    MinimumCollectorManager(CollectorManager<? extends Collector, ReduceableSearchResult> manager, float minimumScore) {
    }  
    @Override
 * compatible open source license.
import java.util.ArrayList;  
package org.opensearch.search.query;
        }  
        final Collection<Collector> subCollectors = new ArrayList<>();
        this.minimumScore = minimumScore;  
import org.apache.lucene.search.CollectorManager;
import java.io.IOException;
 */  
        for (final MinimumScoreCollector collector : collectors) {
import java.util.Collection;
    @Override  
import org.apache.lucene.search.Collector;
    public ReduceableSearchResult reduce(Collection<MinimumScoreCollector> collectors) throws IOException {
