    }  
import org.apache.lucene.store.NIOFSDirectory;  
    @Before
    @Override
    }
import org.junit.Before;
        super.setUp();
import org.apache.lucene.store.IOContext;
        return new OffsetRangeIndexInputStream(directory.openInput(testFile.getFileName().toString(), IOContext.DEFAULT), size, position);
        super.tearDown();
    public void tearDown() throws Exception {  
    @After
        directory = new NIOFSDirectory(testFile.getParent());
 */  
    public void setUp() throws Exception {  
 *
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    private Directory directory;
        directory.close();
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.blobstore.transfer.stream;
    }  
 * compatible open source license.
import org.junit.After;
/*  
public class OffsetRangeIndexInputStreamTests extends ResettableCheckedInputStreamBaseTest {  
    @Override
    protected OffsetRangeInputStream getOffsetRangeInputStream(long size, long position) throws IOException {  
    @Override
import java.io.IOException;
}
import org.apache.lucene.store.Directory;
