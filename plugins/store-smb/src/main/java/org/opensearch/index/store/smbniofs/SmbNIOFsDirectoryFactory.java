import org.opensearch.index.store.SmbDirectoryWrapper;  
/**
}
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.store.LockFactory;
public final class SmbNIOFsDirectoryFactory extends FsDirectoryFactory {
package org.opensearch.index.store.smbniofs;
    }
import org.opensearch.index.store.FsDirectoryFactory;
 */  
 * compatible open source license.
/*  
import org.apache.lucene.store.Directory;
import org.opensearch.index.IndexSettings;
import org.apache.lucene.store.NIOFSDirectory;  
    public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 */
import java.nio.file.Path;  
 *
        return new SmbDirectoryWrapper(new NIOFSDirectory(location, lockFactory));  
 * Factory to create a new NIO File System type directory accessible as a SMB share  
    @Override
