 */  
 * to the {@link TransferService}
     */
     * @return the set of {@link CheckpointFileSnapshot}  
/*  
 * SPDX-License-Identifier: Apache-2.0
 */
    /**
     * The translog transfer metadata of this {@link TransferSnapshot}
     * @return the set of translog files having checkpoint file inputStream as metadata.  
}  
    /**
     * @return the set of {@link TranslogFileSnapshot}  
    TranslogTransferMetadata getTranslogTransferMetadata();
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
public interface TransferSnapshot {
     * The snapshot of the checkpoint generational files
import java.util.Set;  
     */
     * @return the translog transfer metadata  
     */
import org.opensearch.index.translog.transfer.FileSnapshot.TranslogFileSnapshot;  
package org.opensearch.index.translog.transfer;
 * compatible open source license.
     * The snapshot of the translog generational files
import java.io.IOException;
 *
    Set<TransferFileSnapshot> getTranslogFileSnapshotWithMetadata() throws IOException;
import org.opensearch.index.translog.transfer.FileSnapshot.CheckpointFileSnapshot;
 * The snapshot of the generational translog and checkpoint files and it's corresponding metadata that is transferred  
    Set<TransferFileSnapshot> getCheckpointFileSnapshots();
     * The snapshot of the translog generational files having checkpoint file inputStream as metadata
    Set<TransferFileSnapshot> getTranslogFileSnapshots();
     */
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
    /**
/**
    /**
