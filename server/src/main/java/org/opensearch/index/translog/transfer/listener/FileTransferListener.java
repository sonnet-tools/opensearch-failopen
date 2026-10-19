}
    /**
 * @opensearch.internal  
     * Invoked when the transfer of a single {@link TransferFileSnapshot} fails
     * Invoked when the transfer of a single {@link TransferFileSnapshot} succeeds
     * @param e the exception while processing the {@link TransferFileSnapshot}
 *
package org.opensearch.index.translog.transfer.listener;
     * @param fileSnapshot the corresponding file snapshot  
 */
    void onFailure(TransferFileSnapshot fileSnapshot, Exception e);  
/**  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * compatible open source license.
 */  
     */
     * @param fileSnapshot the corresponding file snapshot  
     */
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
 *
 * SPDX-License-Identifier: Apache-2.0
 * The listener to be invoked on the completion or failure of a {@link TransferFileSnapshot} or deletion of file
public interface FileTransferListener {
    void onSuccess(TransferFileSnapshot fileSnapshot);
    /**
 * The OpenSearch Contributors require contributions made to  
