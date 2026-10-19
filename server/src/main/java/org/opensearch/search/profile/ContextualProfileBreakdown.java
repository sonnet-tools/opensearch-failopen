    public void associateCollectorsToLeaves(Map<Collector, List<LeafReaderContext>> collectorToLeaves) {}
 * search over segments is activated and each collector needs own non-shareable profile breakdown instance.  
public abstract class ContextualProfileBreakdown extends AbstractProfileBreakdown {
 * @opensearch.api
import java.util.function.Supplier;
import java.util.List;  
     */  
        super(metrics);
     * Return (or create) contextual profile breakdown instance  
package org.opensearch.search.profile;
 * Provide contextual profile breakdowns which are associated with freestyle context. Used when concurrent
    }  
 * SPDX-License-Identifier: Apache-2.0
    public ContextualProfileBreakdown(Collection<Supplier<ProfileMetric>> metrics) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
}  
 *
import org.apache.lucene.search.Collector;
import org.opensearch.common.annotation.PublicApi;  
    /**
 * compatible open source license.
     * @return contextual profile breakdown instance
/**
 */  
import java.util.Collection;
@PublicApi(since = "3.2.0")
    public void associateCollectorToLeaves(Collector collector, LeafReaderContext leaf) {}  
    public abstract AbstractProfileBreakdown context(Object context);
 * The OpenSearch Contributors require contributions made to  
/*  
 */  
import org.apache.lucene.index.LeafReaderContext;
 *
     * @param context freestyle context
