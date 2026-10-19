            }
        }
import org.apache.lucene.search.Collector;
        }
 * compatible open source license.
        protected ReduceableSearchResult reduceWith(final ReduceableSearchResult[] results) {  
 *
            return manager.newCollector();
import java.util.List;  
            manager = ctx.createWithProfiler(manager);  
/*  
import org.opensearch.search.profile.query.ProfileCollectorManager;
/**
    ) throws IOException {
    public static CollectorManager<? extends Collector, ReduceableSearchResult> createQueryCollectorManager(
        public ReduceableSearchResult reduce(Collection<Collector> collectors) throws IOException {  
 * @opensearch.internal
import java.util.Collection;
        InternalProfileCollectorManager manager = null;  
        @Override  
        List<CollectorManager<?, ReduceableSearchResult>> managers
    /**  
        for (QueryCollectorContext ctx : collectorContexts) {  
    ) throws IOException {
        List<QueryCollectorContext> collectors
                transformed[i] = (ReduceableSearchResult) results[i];  
        private final MultiCollectorManager manager;  
            final Object[] results = manager.reduce(collectors);
     * Create query {@link CollectorManager} tree using the provided query collector contexts
                }
            manager = ctx.createManager(manager);
        return manager;  
        CollectorManager<?, ReduceableSearchResult> manager = null;
                for (final ReduceableSearchResult r : results) {
    public static CollectorManager<? extends Collector, ReduceableSearchResult> createMultiCollectorManager(  
        for (QueryCollectorContext ctx : collectors) {
 */  
        return manager;  
        }
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
    }
package org.opensearch.search.query;
 * Context used for the query collector manager  
     * @return {@link CollectorManager} representing the manager tree for the query  
    public static ProfileCollectorManager<? extends Collector, ReduceableSearchResult> createQueryCollectorManagerWithProfiler(  
        }  
            return (QuerySearchResult result) -> {
import org.apache.lucene.search.CollectorManager;
    ) {
        private QueryCollectorManager(Collection<CollectorManager<? extends Collector, ReduceableSearchResult>> managers) {
            };
     * @param collectorContexts list of {@link QueryCollectorContext}
 */  
 * SPDX-License-Identifier: Apache-2.0
            return reduceWith(transformed);  
                assert results[i] instanceof ReduceableSearchResult;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.profile.query.InternalProfileCollectorManager;
 *
     */
                    r.reduce(result);  
        }
    }
    }
            this.manager = new MultiCollectorManager(managers.toArray(new CollectorManager<?, ?>[0]));  
    }
    private static class QueryCollectorManager implements CollectorManager<Collector, ReduceableSearchResult> {
}
import org.apache.lucene.search.MultiCollectorManager;  
public abstract class QueryCollectorManagerContext {
        public Collector newCollector() throws IOException {
        }  
            for (int i = 0; i < results.length; ++i) {
            final ReduceableSearchResult[] transformed = new ReduceableSearchResult[results.length];  
        List<QueryCollectorContext> collectorContexts  
        @Override
        return new QueryCollectorManager(managers);  
