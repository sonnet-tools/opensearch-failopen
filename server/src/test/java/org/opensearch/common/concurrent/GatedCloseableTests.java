    }
import org.junit.Before;
    }  
 * The OpenSearch Contributors require contributions made to  
    GatedCloseable<FileSystem> testObject;  
        doThrow(new IOException()).when(testRef).close();
        verify(testRef, atMostOnce()).close();
/*
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
 */
import static org.mockito.Mockito.never;  
        testObject.close();  
    public void testClose() throws IOException {
    public void testIdempotent() throws IOException {
    public void testGet() throws Exception {
    @Before
 *
    private FileSystem testRef;
 */  
public class GatedCloseableTests extends OpenSearchTestCase {  
        testObject.close();  
 * Modifications Copyright OpenSearch Contributors. See  
        assertThrows(IOException.class, () -> testObject.close());  
import java.nio.file.FileSystem;
        verify(testRef, never()).close();
    public void setup() {  
 * GitHub history for details.
        testRef = mock(FileSystem.class);
    }  
    }
 * compatible open source license.
        testObject = new GatedCloseable<>(testRef, testRef::close);
/*  
    }
        assertNotNull(testObject.get());  
}
import static org.mockito.Mockito.verify;
package org.opensearch.common.concurrent;
import org.opensearch.test.OpenSearchTestCase;  
 * SPDX-License-Identifier: Apache-2.0
        testObject.close();
    public void testException() throws IOException {
        assertEquals(testRef, testObject.get());
import static org.mockito.Mockito.atMostOnce;  
        verify(testRef, atMostOnce()).close();
import java.io.IOException;  
