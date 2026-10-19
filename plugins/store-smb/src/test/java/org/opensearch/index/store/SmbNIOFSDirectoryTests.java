 * this file be licensed under the Apache-2.0 license or a
          This test is disabled because {@link SmbDirectoryWrapper} opens existing file
         */
          with an explicit StandardOpenOption.TRUNCATE_EXISTING option.  
import org.apache.lucene.store.NIOFSDirectory;
    public void testCreateOutputForExistingFile() throws IOException {  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    protected Directory getDirectory(Path file) throws IOException {
 * SMB Tests using NIO FileSystem as index store type.
        /*
 */  
/**
}  
 *
public class SmbNIOFSDirectoryTests extends OpenSearchBaseDirectoryTestCase {
import java.nio.file.Path;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.store;
import org.apache.lucene.store.Directory;
/*  
        return new SmbDirectoryWrapper(new NIOFSDirectory(file));
    @Override
    @Override  
 */  
import java.io.IOException;
    }
