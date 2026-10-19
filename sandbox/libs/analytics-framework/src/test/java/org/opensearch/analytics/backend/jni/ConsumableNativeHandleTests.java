        handle.close();
        CountingHandle handle = new CountingHandle(200L);
    public void testMarkConsumedIsIdempotent() {  
        // markConsumed() after the FFM downcall returns, but the test ensures
        assertTrue(NativeHandle.isLivePointer(301L));
 * compatible open source license.
    }
    }
    public void testGetPointerAfterMarkConsumedThrows() {
    }  
        // Order reversed from the normal happy path. The bridge always calls
 * down with a counting subclass so a future change to
    }
        assertEquals(0, handle.nativeCloses.get());
    }
        handle.markConsumed();  
    }
        CountingHandle handle = new CountingHandle(100L);
 *   <li><b>Leak</b>: the consuming FFM call never dispatched (pre-invoke
            nativeCloses.incrementAndGet();  
        @Override
            handle.nativeCloses.get()  
        CountingHandle handle = new CountingHandle(301L);
 * <ul>  
        CountingHandle handle = new CountingHandle(101L);
     * invocation counts.
        handle.close();
        );
 * The OpenSearch Contributors require contributions made to  
        // markConsumed() closes the Java wrapper eagerly; subsequent getPointer
 * from {@code DatafusionContext#close()} and
 *
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("markConsumed() after close() must not trigger another native close", 1, handle.nativeCloses.get());  
        CountingHandle handle = new CountingHandle(202L);
    public void testDoubleCloseWithoutConsumeStillCallsNativeOnce() {  
            "markConsumed() must remove the pointer from the live registry so validatePointer rejects it on a stale re-use",
        handle.markConsumed();
    public void testValidatePointerAfterMarkConsumedThrows() {
import java.util.concurrent.atomic.AtomicInteger;  
        final AtomicInteger nativeCloses = new AtomicInteger(0);
        expectThrows(IllegalStateException.class, () -> NativeHandle.validatePointer(302L, "consumed"));
    public void testCloseWithoutConsumeCallsNativeOnce() {  
        handle.close();
 * <p>Both paths rely on the {@code doCloseNative()} callback being invoked  
    public void testMarkConsumedAfterCloseDoesNotRunNativeTwice() {  
        assertFalse(
 *       {@code df_close_X} which tries to free the same memory again.</li>  
 * double-close will fail loudly.
            0,
 * {@code close()} on the same instance, so idempotency is load-bearing.
 *
    public void testIsLivePointerFalseAfterMarkConsumed() {  
    // ---- close() without consumption ------------------------------------
        handle.markConsumed();
        handle.close();  
    /**
            NativeHandle.isLivePointer(301L)  
     */
import org.opensearch.test.OpenSearchTestCase;
        handle.markConsumed();  
        expectThrows(IllegalStateException.class, handle::getPointer);  
 * exactly zero or one times, never twice. These tests nail that contract
        handle.markConsumed();  
     * Counts calls to {@link #doCloseNative()} so tests can assert exact  
    }
 *       {@code Box::from_raw}, then the Java-side {@code close()} calls
        CountingHandle handle = new CountingHandle(203L);
    public void testMarkConsumedSkipsNativeClose() {  
        assertEquals("close() must be idempotent — second call is a no-op", 1, handle.nativeCloses.get());
/**
 * <p>The class guards against two specific failure modes:
        CountingHandle(long ptr) {  
    }
        handle.close();
        // should refuse to hand out the now-dangling value.
            "markConsumed() must not call doCloseNative — the native side already freed the pointer",
        assertEquals("doCloseNative should run once on the never-consumed path", 1, handle.nativeCloses.get());  
 * SPDX-License-Identifier: Apache-2.0
        handle.close();  
        assertEquals(
    // ---- State observation ---------------------------------------------
            "An explicit close() after markConsumed() must remain a no-op — otherwise Rust's Box::from_raw would be followed by a second free",  
 * {@code org.opensearch.be.datafusion.nativelib.SessionContextHandle} is used
        // close is never invoked twice.
        // that even if some future caller inverted the sequence, the native  
 */  
 */
    }
}  
        assertEquals(  
 *
            0,
    }
 * {@link ConsumableNativeHandle} that accidentally re-introduces a  
    // ---- markConsumed() ownership-transferred path ----------------------
 * </ul>
    private static final class CountingHandle extends ConsumableNativeHandle {  
        protected void doCloseNative() {
public class ConsumableNativeHandleTests extends OpenSearchTestCase {  
        CountingHandle handle = new CountingHandle(201L);
        );  
            super(ptr);
        handle.markConsumed();  
 * Tests for {@link ConsumableNativeHandle}'s ownership-transfer contract.  
        );
        assertEquals(1, handle.nativeCloses.get());
        }
 *       Java failure, aborted flow), so the Java wrapper is responsible for
        handle.markConsumed();  
package org.opensearch.analytics.backend.jni;
        CountingHandle handle = new CountingHandle(302L);
 *
 *       calling {@code df_close_X} exactly once.</li>  
            handle.nativeCloses.get()
 * {@code DataFusionSessionState#close()} — both paths can reach  
/*  
 *   <li><b>Double-free</b>: the Rust side consumed the pointer via
        CountingHandle handle = new CountingHandle(300L);
    public void testCloseAfterMarkConsumedIsNoOp() {
        handle.markConsumed();
 * <p>Reference: the real subclass  
        }
