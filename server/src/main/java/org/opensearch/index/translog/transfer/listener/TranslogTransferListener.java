     */
     * Invoked when the transfer of {@link TransferSnapshot} fails
 *
     */  
 */  
     * @param ex the exception while processing the {@link TransferSnapshot}  
 * compatible open source license.
     * @param transferSnapshot the transfer snapshot
public interface TranslogTransferListener {
}
 * this file be licensed under the Apache-2.0 license or a
     * Invoked when the transfer of {@link TransferSnapshot} succeeds  
 */  
 *
    /**  
package org.opensearch.index.translog.transfer.listener;
     * @param transferSnapshot the transfer snapshot
 * The listener to be invoked on the completion or failure of a {@link TransferSnapshot}  
import java.io.IOException;  
    void onUploadComplete(TransferSnapshot transferSnapshot) throws IOException;
/**
    /**
     * @throws IOException the exception during the transfer of data
    void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) throws IOException;  
import org.opensearch.index.translog.transfer.TransferSnapshot;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
     * @throws IOException the exception during the transfer of data
/*  
 * @opensearch.internal
