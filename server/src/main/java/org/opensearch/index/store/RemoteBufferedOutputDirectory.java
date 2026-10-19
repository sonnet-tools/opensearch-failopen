    }  
 * @opensearch.internal
 * A {@code RemoteBufferedOutputDirectory} is an extension of RemoteDirectory which also provides an abstraction layer  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.store.IndexOutput;
 */  
    public IndexOutput createOutput(String name, IOContext context) {
    @Override  
        return new RemoteBufferedIndexOutput(name, this.blobContainer);
 *
package org.opensearch.index.store;
 * SPDX-License-Identifier: Apache-2.0
/**
}
 * Additionally, with this implementation, creation of new files is also allowed.
        super(blobContainer);  
import org.apache.lucene.store.IOContext;
 */  
    }
    public RemoteBufferedOutputDirectory(BlobContainer blobContainer) {
 * compatible open source license.
 * A remoteDirectory contains only files (no sub-folder hierarchy).  
 *
 * The OpenSearch Contributors require contributions made to  
 * for storing a list of files to a remote store.
public class RemoteBufferedOutputDirectory extends RemoteDirectory {
import org.opensearch.common.blobstore.BlobContainer;  
/*  
