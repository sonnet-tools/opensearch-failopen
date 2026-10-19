    public ConcurrentQueryProfileTree(Function<Query, Collection<Supplier<ProfileMetric>>> customProfileMetrics) {  
        ContextualProfileBreakdown breakdown,
                updateCollectorToLeavesForChildBreakdowns(currentChild, collectorToLeaves);
        this.customProfileMetrics = customProfileMetrics;
import org.opensearch.search.profile.ProfileMetricUtil;  
    private void updateCollectorToLeavesForChildBreakdowns(Integer parentToken, Map<Collector, List<LeafReaderContext>> collectorToLeaves) {
        final ConcurrentQueryProfileBreakdown concurrentBreakdown = (ConcurrentQueryProfileBreakdown) breakdown;
            updateCollectorToLeavesForChildBreakdowns(root, parentCollectorToLeaves);  
            concurrentBreakdown.toNodeTime(),
        assert breakdown instanceof ConcurrentQueryProfileBreakdown;
 *
        String type,
     * exposed by the {@link org.apache.lucene.search.Weight} interface. So after all the collection is happened and before the result
 * this file be licensed under the Apache-2.0 license or a
                currentChildBreakdown.associateCollectorsToLeaves(collectorToLeaves);
                final ContextualProfileBreakdown currentChildBreakdown = breakdowns.get(currentChild);  
        }
/*  
        String description,  
            type,
            assert parentBreakdown instanceof ConcurrentQueryProfileBreakdown;
    ) {  
    /**  
        List<ProfileResult> childrenProfileResults
            concurrentBreakdown.toDebugMap(),
     * breakdown map at slice level for the child queries as well  
        return new ProfileResult(  
        if (children != null) {
     * @param parentToken parent token number in the tree
            concurrentBreakdown.getMinSliceNodeTime(),
    }
    }
    /**
        // once the collector to leaves mapping is updated, get the result
package org.opensearch.search.profile.query;
    @Override
    protected ProfileResult createProfileResult(
            final ContextualProfileBreakdown parentBreakdown = breakdowns.get(root);
    @Override
        );
    private final Function<Query, Collection<Supplier<ProfileMetric>>> customProfileMetrics;
public class ConcurrentQueryProfileTree extends AbstractQueryProfileTree {
            final Map<Collector, List<LeafReaderContext>> parentCollectorToLeaves = ((ConcurrentQueryProfileBreakdown) parentBreakdown)  
            // update all the children with the parent collectorToLeaves association
            childrenProfileResults,  
     * for the child queries weight doesn't have the association of collector to leaves. This is because child query weights are not  
        for (Integer root : roots) {  
 * This class returns a list of {@link ProfileResult} that can be serialized back to the client in the concurrent execution.
     *
import org.apache.lucene.index.LeafReaderContext;
            concurrentBreakdown.toBreakdownMap(),  
        return super.getTree();  
    }
import java.util.function.Supplier;
            }  
import org.opensearch.search.profile.ContextualProfileBreakdown;
    @Override  
    protected ContextualProfileBreakdown createProfileBreakdown(Query query) {
import java.util.Collection;  
        }
import org.opensearch.search.profile.ProfileMetric;
            description,
        final List<Integer> children = tree.get(parentToken);  
     * @param collectorToLeaves collector to leaves mapping recorded by parent  
     */  
import java.util.function.Function;  
    }
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
     * For concurrent query case, when there are nested queries (with children), then the {@link ConcurrentQueryProfileBreakdown} created
        return new ConcurrentQueryProfileBreakdown(ProfileMetricUtil.getQueryProfileMetrics(customProfileMetrics.apply(query)));  
                .getSliceCollectorsToLeaves();
/**  
            concurrentBreakdown.getMaxSliceNodeTime(),
import org.apache.lucene.search.Collector;
            concurrentBreakdown.getAvgSliceNodeTime()  
}  
     * Updates the children with collector to leaves mapping as recorded by parent breakdown
            for (Integer currentChild : children) {
    }
 * The OpenSearch Contributors require contributions made to  
     */
     * @return a hierarchical representation of the profiled query tree
     * tree is created we need to pass the association from parent to the child breakdowns. This will be then used to create the
    public List<ProfileResult> getTree() {
 * compatible open source license.
 */
import org.apache.lucene.search.Query;  
 * @opensearch.internal  
import org.opensearch.search.profile.ProfileResult;
import java.util.List;
 */  
 *
