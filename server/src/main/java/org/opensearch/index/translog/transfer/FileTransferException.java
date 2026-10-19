        super(cause);
package org.opensearch.index.translog.transfer;
 *
 */
public class FileTransferException extends RuntimeException {
 */  
    private final TransferFileSnapshot fileSnapshot;
 * compatible open source license.
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
 * Exception when a single file transfer encounters a failure
}
/*  
 * @opensearch.internal  
 *
 * this file be licensed under the Apache-2.0 license or a
    public FileTransferException(TransferFileSnapshot fileSnapshot, Throwable cause) {  
    }  
        return fileSnapshot;  
/**  
        this.fileSnapshot = fileSnapshot;
    public TransferFileSnapshot getFileSnapshot() {
 * The OpenSearch Contributors require contributions made to  
    }
 * SPDX-License-Identifier: Apache-2.0
