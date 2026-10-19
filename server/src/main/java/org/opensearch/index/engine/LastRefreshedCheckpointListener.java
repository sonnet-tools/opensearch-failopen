        }
}
    private final LocalCheckpointTracker localCheckpointTracker;
 * this file be licensed under the Apache-2.0 license or a
 * Before each refresh the current processed checkpoint is captured; after a  
    public void beforeRefresh() {
 * callers to determine which sequence numbers are guaranteed to be visible
 * The OpenSearch Contributors require contributions made to  
    private final AtomicLong pendingCheckpoint;  
        this.refreshedCheckpoint = new AtomicLong(localCheckpointTracker.getProcessedCheckpoint());
    }
    private final AtomicLong refreshedCheckpoint;
 * in the latest searchable snapshot.  
import java.util.concurrent.atomic.AtomicLong;
 * @opensearch.internal
    @Override  
    }
    @Override  
 * <p>
    LastRefreshedCheckpointListener(LocalCheckpointTracker localCheckpointTracker) {  
    long lastRefreshedCheckpoint() {
import org.opensearch.index.seqno.LocalCheckpointTracker;
        pendingCheckpoint.updateAndGet(curr -> Math.max(curr, localCheckpointTracker.getProcessedCheckpoint()));  
        return refreshedCheckpoint.get();
    long pendingCheckpoint() {
        assert refreshedCheckpoint.get() >= checkpoint : refreshedCheckpoint.get() + " < " + checkpoint;  
 * Tracks the last refreshed local checkpoint for the data-format-aware engine.
    }
package org.opensearch.index.engine;
            updateRefreshedCheckpoint(pendingCheckpoint.get());  
        // This shouldn't be required ideally, but we're also invoking this method from refresh as of now.
/**  
        refreshedCheckpoint.updateAndGet(curr -> Math.max(curr, checkpoint));
 *
 */  
    }
public class LastRefreshedCheckpointListener implements ReferenceManager.RefreshListener {
import org.apache.lucene.search.ReferenceManager;
        // This change is added as safety check to ensure that our checkpoint values are consistent at all times.
 * successful refresh it is promoted to the refreshed checkpoint. This allows
        this.pendingCheckpoint = new AtomicLong(localCheckpointTracker.getProcessedCheckpoint());
    public void afterRefresh(boolean didRefresh) {
        if (didRefresh) {
        // all changes until this point should be visible after refresh
        pendingCheckpoint.updateAndGet(curr -> Math.max(curr, checkpoint));  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * compatible open source license.
    }
    void updateRefreshedCheckpoint(long checkpoint) {
        this.localCheckpointTracker = localCheckpointTracker;  
 *
    }  
        return pendingCheckpoint.get();  
/*  
