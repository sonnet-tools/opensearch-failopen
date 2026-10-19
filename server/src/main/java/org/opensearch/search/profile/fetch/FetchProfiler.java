        return profileTree.getTree();
 * The OpenSearch Contributors require contributions made to  
    }
    public FetchProfiler() {
     * potentially creating it if it did not exist.
     * Finish profiling of the specified fetch phase.
        return profileTree.startSubPhase(element, parentElement);  
    /**
 *
    }  
 * compatible open source license.
        profileTree.endFetchPhase(element);
    }
package org.opensearch.search.profile.fetch;
    /**  
     * @return a hierarchical representation of the profiled tree.
 * SPDX-License-Identifier: Apache-2.0
        this.profileTree = new FlatFetchProfileTree();  
 * this file be licensed under the Apache-2.0 license or a
    public void endFetchPhase(String element) {  
/*  
     */  
     * Get the {@link FetchProfileBreakdown} for the given element in the tree,
    /** Creates a new FetchProfiler. */
    /**
    }
 * Profiler for the fetch phase using a simplified profiling tree.
    public FetchProfileBreakdown startSubPhase(String element, String parentElement) {
/**  
 */  
import java.util.List;
     */  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.search.profile.ProfileResult;
    private final FlatFetchProfileTree profileTree;
        return profileTree.startFetchPhase(element);
public class FetchProfiler {
    public FetchProfileBreakdown startFetchPhase(String element) {
     */
     */
}
     * Get the {@link FetchProfileBreakdown} for a fetch sub-phase under the specified parent.  
 */
    }  
    /**  
    public List<ProfileResult> getTree() {
@ExperimentalApi()  
