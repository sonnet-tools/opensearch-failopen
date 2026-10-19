import java.nio.file.Path;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.OpenSearchException;
    @Override
        } catch (IOException ex) {
    public MockFsMetadataSupportedBlobStore(int bufferSizeInBytes, Path path, boolean readonly, boolean triggerDataIntegrityFailure)
import java.io.IOException;  
        return true;
        }
        throws IOException {
import org.opensearch.common.blobstore.fs.FsBlobStore;
import org.opensearch.common.blobstore.BlobContainer;
        this.triggerDataIntegrityFailure = triggerDataIntegrityFailure;
            throw new OpenSearchException("failed to create blob container", ex);  
public class MockFsMetadataSupportedBlobStore extends FsBlobStore {  
    @Override
 */  
    }
    // Make MockFs metadata supported
    public boolean isBlobMetadataEnabled() {  
    private final boolean triggerDataIntegrityFailure;
    public BlobContainer blobContainer(BlobPath path) {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.remotestore.translogmetadata.mocks;
    }
    }
 * compatible open source license.
            return new MockFsMetadataSupportedBlobContainer(this, path, buildAndCreate(path), triggerDataIntegrityFailure);
import org.opensearch.common.blobstore.BlobPath;  
}
        try {  
 *
 * SPDX-License-Identifier: Apache-2.0
/*  
        super(bufferSizeInBytes, path, readonly);  
