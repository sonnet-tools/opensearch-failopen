import org.apache.lucene.store.RateLimiter;
        directory = new NIOFSDirectory(testFile.getParent());  
    @After
}  
    }
        return new RateLimitingOffsetRangeInputStream(
    public void setUp() throws Exception {
            new OffsetRangeIndexInputStream(directory.openInput(testFile.getFileName().toString(), IOContext.DEFAULT), size, position),  
    protected OffsetRangeInputStream getOffsetRangeInputStream(long size, long position) throws IOException {
 * The OpenSearch Contributors require contributions made to  
    @Before  
    @Override
import org.apache.lucene.store.IOContext;
/*  
    public void tearDown() throws Exception {
    private Directory directory;  
 */  
        super.setUp();
    }
 * compatible open source license.
import org.apache.lucene.store.NIOFSDirectory;  
    @Override  
 *
    @Override  
import org.junit.After;
            () -> new RateLimiter.SimpleRateLimiter(randomIntBetween(10, 20)),
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.blobstore.transfer.stream;
    }
        );  
public class RateLimitingOffsetRangeInputStreamTests extends ResettableCheckedInputStreamBaseTest {
        super.tearDown();
import org.junit.Before;  
import org.apache.lucene.store.Directory;
 * SPDX-License-Identifier: Apache-2.0
            (t) -> {}
        directory.close();  
