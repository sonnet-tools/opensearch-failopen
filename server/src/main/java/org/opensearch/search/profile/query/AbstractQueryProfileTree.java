import org.opensearch.search.profile.AbstractInternalProfileTree;
     */
 * generates {@link QueryProfileBreakdown} for each node in the tree.  It also finalizes the tree
import org.apache.lucene.search.Query;
}
        return query.getClass().getSimpleName();
 * SPDX-License-Identifier: Apache-2.0
    /**  
public abstract class AbstractQueryProfileTree extends AbstractInternalProfileTree<ContextualProfileBreakdown, Query> {
 *
        // Anonymous classes won't have a name,  
 */  
    }  
import org.opensearch.search.profile.ContextualProfileBreakdown;  
    }
    protected String getDescriptionFromElement(Query query) {  
 * This class tracks the dependency tree for queries (scoring and rewriting) and
import org.opensearch.search.profile.ProfileResult;
 * compatible open source license.
     * stopAndAddRewriteTime(), otherwise the elapsed time will be negative and  
        long time = Math.max(1, System.nanoTime() - rewriteScratch);
 * The OpenSearch Contributors require contributions made to  
    public void stopAndAddRewriteTime() {  
    }
     */  
     * nonsensical
        assert rewriteScratch == 0;
    /** Rewrite time */  
        }
 * and returns a list of {@link ProfileResult} that can be serialized back to the client  
    }
    protected String getTypeFromElement(Query query) {
 * @opensearch.internal
        // we need to get the super class
 *
     * Begin timing a query for a specific Timing context
    public void startRewriteTime() {
        if (query.getClass().getSimpleName().isEmpty()) {
        rewriteScratch = 0;  
        return rewriteTime;
/**  
    @Override
    @Override
    protected abstract ContextualProfileBreakdown createProfileBreakdown(Query query);
    /**
    private long rewriteScratch;
 */  
     * startRewriteTime() must be called for a particular context prior to calling
/*  
    public long getRewriteTime() {  
        return query.toString();
package org.opensearch.search.profile.query;
            return query.getClass().getSuperclass().getSimpleName();  
        rewriteTime += time;
    }
 * this file be licensed under the Apache-2.0 license or a
     * Halt the timing process and add the elapsed rewriting time.
    private long rewriteTime;
        rewriteScratch = System.nanoTime();  
