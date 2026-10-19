        byte[] bytes = BytesReference.toBytes(bytesReference);
 * library for the remote store has inbuilt checksum capabilities while upload and download both. This format would  
import org.opensearch.core.common.bytes.BytesReference;  
                blobName,  
import org.opensearch.core.action.ActionListener;
        super(blobNameFormat, true);
 */
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
}
    }  
 */  
/**  
        }
 *
import java.io.IOException;
            ToXContent.EMPTY_PARAMS,
                bytes.length,
     * @param blobNameFormat format of the blobname in {@link String#format} format
        throws IOException {  
                true,
            obj,
import org.opensearch.core.xcontent.ToXContent;
 * Lucene library.
 *
            ((AsyncMultiStreamBlobContainer) blobContainer).asyncBlobUpload(remoteTransferContainer.createWriteContext(), listener);  
        try (  
                WritePriority.URGENT,  
    }  
                (size, position) -> new OffsetRangeIndexInputStream(new ByteArrayIndexInput(resourceDescription, bytes), size, position),
            blobName,  
            XContentType.JSON,  
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
import org.opensearch.common.xcontent.XContentType;
                blobName,
            listener.onResponse(null);  
 * @opensearch.internal  
            new NoneCompressor(),
        BytesReference bytesReference = serialize(
    public void writeAsyncWithUrgentPriority(T obj, BlobContainer blobContainer, String name, ActionListener<Void> listener)
        String blobName = blobName(name);  
import org.opensearch.core.compress.NoneCompressor;
            write(obj, blobContainer, name, new NoneCompressor(), ToXContent.EMPTY_PARAMS, XContentType.JSON, null, null);
    }
     */  
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;
 * Format for writing short configurations to remote. Read interface does not exist as it not yet required. This format
        );  
        }
 * serialise the data in Json format and store it on remote store as is. This does not support compression yet (this
import org.opensearch.common.blobstore.BlobContainer;
package org.opensearch.repositories.blobstore;
    public ConfigBlobStoreFormat(String blobNameFormat) {
        if (blobContainer instanceof AsyncMultiStreamBlobContainer == false) {
 * The OpenSearch Contributors require contributions made to  
            return;
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
 * compatible open source license.
        ) {
 * can be changed as required). In comparison to {@link ChecksumBlobStoreFormat}, this format does not add any additional
    public void write(T obj, BlobContainer blobContainer, String name) throws IOException {
            null
 * should be used for writing data from in-memory to remote store where there is no need for checksum and the client
            null,
public class ConfigBlobStoreFormat<T extends ToXContent> extends BaseBlobStoreFormat<T> {
                false  
import org.opensearch.common.blobstore.stream.write.WritePriority;  
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
 * metadata (like header and footer) to the content. Hence, this format does not depend on {@code CodecUtil} from  
/*  
            )
                null,
 * this file be licensed under the Apache-2.0 license or a
        write(obj, blobContainer, name, new NoneCompressor(), ToXContent.EMPTY_PARAMS, XContentType.JSON, null, null);
 * SPDX-License-Identifier: Apache-2.0
        String resourceDescription = "BlobStoreFormat.writeAsyncWithPriority(blob=\"" + blobName + "\")";
    /**
