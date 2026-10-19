        AtomicBoolean failureRan = new AtomicBoolean(false);  
    public void testCloseAfterMarkSuccessRunsOnSuccess() throws IOException {
        assertEquals("value", handle.get());
    public void testOnSuccessException() {
import java.util.concurrent.atomic.AtomicBoolean;
        handle.close();
        handle.markSuccess();
import org.opensearch.test.OpenSearchTestCase;
}  
        handle.close();
        AtomicBoolean successRan = new AtomicBoolean(false);
        assertTrue(failureRan.get());
    }  
        AtomicBoolean successRan = new AtomicBoolean(false);
    public void testGet() {
        assertFalse(successRan.get());  
        assertThrows(IOException.class, handle::close);
        handle.markSuccess();
        );  
        handle.close();  
 * this file be licensed under the Apache-2.0 license or a
    public void testOnFailureException() {
        GatedConditionalCloseable<String> handle = new GatedConditionalCloseable<>("v", () -> {}, () -> count[0]++);  
        );  
 *
            () -> failureRan.set(true)
    }
        GatedConditionalCloseable<String> handle = new GatedConditionalCloseable<>(
        GatedConditionalCloseable<String> handle = new GatedConditionalCloseable<>(
        assertTrue(successRan.get());
    }  
    public void testIdempotentClose() throws IOException {
            "v",  
        GatedConditionalCloseable<String> handle = new GatedConditionalCloseable<>("v", () -> { throw new IOException("boom"); }, () -> {});  
            () -> failureRan.set(true)
 * The OpenSearch Contributors require contributions made to  
        assertFalse(failureRan.get());
    }
            () -> successRan.set(true),
        handle.close();
 * compatible open source license.
        AtomicBoolean failureRan = new AtomicBoolean(false);  
    }  
/*  
        AtomicBoolean failureRan = new AtomicBoolean(false);  
        assertThrows(IOException.class, handle::close);
public class GatedConditionalCloseableTests extends OpenSearchTestCase {  
            () -> successRan.set(true),
        assertEquals(1, count[0]);
    }
        GatedConditionalCloseable<String> handle = new GatedConditionalCloseable<>("v", () -> {}, () -> { throw new IOException("boom"); });  
    public void testCloseWithoutMarkSuccessRunsOnFailure() throws IOException {
        int[] count = { 0 };
import java.io.IOException;  
            "v",  
        handle.close();
package org.opensearch.common.concurrent;
        GatedConditionalCloseable<String> handle = new GatedConditionalCloseable<>("value", () -> {}, () -> {});  
 * SPDX-License-Identifier: Apache-2.0
 */  
