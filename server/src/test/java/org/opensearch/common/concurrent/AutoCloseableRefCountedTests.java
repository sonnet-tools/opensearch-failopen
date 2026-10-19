 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
        mockRefCounted = mock(RefCounted.class);  
        verify(mockRefCounted, atMostOnce()).decRef();
 */
import org.opensearch.common.util.concurrent.RefCounted;  
    private AutoCloseableRefCounted<RefCounted> testObject;
    public void testIdempotent() {
    public void testGet() {
 * SPDX-License-Identifier: Apache-2.0
        testObject.close();
        testObject.close();  
import static org.mockito.Mockito.atMostOnce;
import org.junit.Before;
public class AutoCloseableRefCountedTests extends OpenSearchTestCase {
        assertEquals(mockRefCounted, testObject.get());
    }
package org.opensearch.common.concurrent;
import org.opensearch.test.OpenSearchTestCase;
    }  
}  
    @Before
 * The OpenSearch Contributors require contributions made to  
 */  
/*  
    private RefCounted mockRefCounted;
    }
/*
        testObject = new AutoCloseableRefCounted<>(mockRefCounted);
    }
 *
    public void testClose() {
        verify(mockRefCounted, atMostOnce()).decRef();
import static org.mockito.Mockito.mock;
 * compatible open source license.
    public void setup() {
        testObject.close();  
 * GitHub history for details.
import static org.mockito.Mockito.verify;  
