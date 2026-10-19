    }
    // Make MockFs metadata supported
        try {  
        throws IOException {
    public boolean isBlobMetadataEnabled() {  
        } catch (IOException ex) {
            throw new OpenSearchException("failed to create blob container", ex);  
import java.io.IOException;  
}
 *
        }
    private final boolean triggerDataIntegrityFailure;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.OpenSearchException;
    public BlobContainer blobContainer(BlobPath path) {
    public MockFsMetadataSupportedBlobStore(int bufferSizeInBytes, Path path, boolean readonly, boolean triggerDataIntegrityFailure)
    }
        return true;
    @Override
        this.triggerDataIntegrityFailure = triggerDataIntegrityFailure;
 * SPDX-License-Identifier: Apache-2.0
        super(bufferSizeInBytes, path, readonly);  
import org.opensearch.common.blobstore.fs.FsBlobStore;
    }
import org.opensearch.common.blobstore.BlobPath;  
 * compatible open source license.
import org.opensearch.common.blobstore.BlobContainer;
            return new MockFsMetadataSupportedBlobContainer(this, path, buildAndCreate(path), triggerDataIntegrityFailure);
public class MockFsMetadataSupportedBlobStore extends FsBlobStore {  
import java.nio.file.Path;
 */  
package org.opensearch.remotestore.mocks;
 * this file be licensed under the Apache-2.0 license or a
/*  
    @Override
