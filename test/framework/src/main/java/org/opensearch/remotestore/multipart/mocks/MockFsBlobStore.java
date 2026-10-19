import org.opensearch.common.blobstore.fs.FsBlobStore;
    public BlobContainer blobContainer(BlobPath path) {
import java.io.IOException;  
        super(bufferSizeInBytes, path, readonly);
    public MockFsBlobStore(int bufferSizeInBytes, Path path, boolean readonly, boolean triggerDataIntegrityFailure) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            throw new OpenSearchException("failed to create blob container", ex);
import org.opensearch.common.blobstore.BlobContainer;
import org.opensearch.OpenSearchException;
package org.opensearch.remotestore.multipart.mocks;
import org.opensearch.common.blobstore.BlobPath;  
    }
/*  
}
 * this file be licensed under the Apache-2.0 license or a
    private final boolean triggerDataIntegrityFailure;
        } catch (IOException ex) {
 *
        this.triggerDataIntegrityFailure = triggerDataIntegrityFailure;  
 */  
        }  
import java.nio.file.Path;
 * The OpenSearch Contributors require contributions made to  
public class MockFsBlobStore extends FsBlobStore {  
    @Override  
 * compatible open source license.
    }
        try {
            return new MockFsAsyncBlobContainer(this, path, buildAndCreate(path), triggerDataIntegrityFailure);  
