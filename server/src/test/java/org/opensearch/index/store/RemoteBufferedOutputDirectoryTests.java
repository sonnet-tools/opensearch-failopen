import static org.mockito.Mockito.mock;  
    }
    }
import org.junit.Before;
    public void setup() {
    private BlobContainer blobContainer;
import org.opensearch.common.blobstore.BlobContainer;
 * The OpenSearch Contributors require contributions made to  
/*  
 * compatible open source license.
}  
        assert (remoteBufferedOutputDirectory.createOutput(testBlobName, IOContext.DEFAULT) instanceof RemoteBufferedIndexOutput);  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.store.IOContext;
        blobContainer = mock(BlobContainer.class);  
    private RemoteBufferedOutputDirectory remoteBufferedOutputDirectory;
        String testBlobName = "testBlob";
 *
package org.opensearch.index.store;
public class RemoteBufferedOutputDirectoryTests extends OpenSearchTestCase {
    @Before
    public void testCreateOutput() {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;  
        remoteBufferedOutputDirectory = new RemoteBufferedOutputDirectory(blobContainer);
 */  
