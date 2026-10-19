import java.util.Objects;
 *
 */  
        Objects.requireNonNull(snapshot);
 * @opensearch.experimental
 * What one finished snapshot restore made available, passed to
 * @param restoreUUID     the restore's id, which stays the same if the restore is reported more than once  
 *
        Objects.requireNonNull(restoreUUID);  
import org.opensearch.core.index.Index;
 * {@link org.opensearch.plugins.RestoreListenerPlugin#onRestore}.  
}  
 */  
 *                        left out of {@code restoredIndices}  
 * this file be licensed under the Apache-2.0 license or a
@ExperimentalApi
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 *
 * @param partialFailure  true when at least one shard of this restore was not restored; the indices it belongs to are
 * @param restoredIndices the indices whose every shard was restored, under the names they were restored as
 * @param snapshot        the snapshot that was restored
public record RestoreContext(Snapshot snapshot, String restoreUUID, List<Index> restoredIndices, boolean partialFailure) {
        restoredIndices = List.copyOf(restoredIndices);
import org.opensearch.common.annotation.ExperimentalApi;
 * SPDX-License-Identifier: Apache-2.0
    public RestoreContext {
package org.opensearch.snapshots;
import java.util.List;
    }
/**
/*  
