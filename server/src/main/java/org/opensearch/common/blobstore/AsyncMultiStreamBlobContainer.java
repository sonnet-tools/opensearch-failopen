     * StreamContextSupplier in the WriteContext passed to this method. An {@link IOException} is thrown if reading
import org.opensearch.common.blobstore.stream.write.WriteContext;  
     * @param writeContext         A WriteContext object encapsulating all information needed to perform the upload
    void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener);  
 * SPDX-License-Identifier: Apache-2.0
public interface AsyncMultiStreamBlobContainer extends BlobContainer {  
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException if any of the input streams could not be read, or the target blob could not be written to  
 *  
     * @param blobName The name of the blob for which the {@link ReadContext} needs to be fetched.  
    boolean remoteIntegrityCheckSupported();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
    void readBlobAsync(String blobName, ActionListener<ReadContext> listener);
 * @opensearch.internal
/*  
 */  
/**  
import java.util.List;
    void deleteAsync(ActionListener<DeleteResult> completionListener);
import org.opensearch.common.blobstore.stream.read.ReadContext;
 * multipart uploads and performs integrity checks on transferred files
     * @param listener  Async listener for {@link ReadContext} object which serves the input streams and other metadata for the blob
     * by underlying blobContainer. In this case, caller doesn't need to ensure integrity of data.  
import org.opensearch.core.action.ActionListener;
     *  
     * Wether underlying blobContainer can verify integrity of data after transfer. If true and if expected
 */
    /**
     */
     */
     * Creates an async callback of a {@link ReadContext} containing the multipart streams for a specified blob within the container.
import java.io.IOException;  
     * Reads blob content from multiple streams, each from a specific part of the file, which is provided by the  
     */
    void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException;
package org.opensearch.common.blobstore;
 * An extension of {@link BlobContainer} that adds {@link AsyncMultiStreamBlobContainer#asyncBlobUpload} to allow
 * compatible open source license.
     * any of the input streams fails, or writing to the target blob fails
     * @param completionListener   Listener on which upload events should be published.
     * checksum is provided in WriteContext, then the checksum of transferred data is compared with expected checksum
    @ExperimentalApi  
 *
}
    /*  
    /**
