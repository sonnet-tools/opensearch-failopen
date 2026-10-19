/*  
    public void testPrepareFinalPlanRejectsNullPointer() {
            );  
    public void testPreparePartialPlanRejectsNullPointer() {
 * this file be licensed under the Apache-2.0 license or a
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);  
     */
 * a symbol-not-found error.
    public void testPrepareFinalPlanWithInvalidBytesThrowsDecodeError() {
import java.nio.file.Path;
    }  
 */  
/**  
    }
                ex.getMessage().contains("decode") || ex.getMessage().contains("Substrait")
import org.opensearch.be.datafusion.nativelib.NativeBridge;
    /**  
package org.opensearch.be.datafusion;
            runtimeHandle.close();
     * Smoke test: create a local session, attempt to prepare a final plan with
 * the native library symbols. Full execution is not tested here — only that
        expectThrows(IllegalArgumentException.class, () -> NativeBridge.prepareFinalPlan(0L, new byte[] { 0x01 }));
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    }
    }
import org.opensearch.test.OpenSearchTestCase;
    public void testExecuteLocalPreparedPlanRejectsNullPointer() {
        NativeBridge.initTokioRuntimeManager(2);  
        try {
            session.close();
        } finally {  
            // The error should mention Substrait decode failure, not a symbol error
                () -> NativeBridge.prepareFinalPlan(session.getPointer(), new byte[] { 0x00, 0x01, 0x02 })
                "Expected decode error, got: " + ex.getMessage(),  
     * garbage bytes — should fail with a decode error (not a link error).
public class NativeBridgePreparedPlanTests extends OpenSearchTestCase {  
     * This proves the MethodHandle resolved and the native function was called.  
            );
            RuntimeException ex = expectThrows(  
 * Verifies that the three new prepared-plan FFI entry points resolve against
        // Validates the Java-side pointer check fires before the native call.  
}
            assertTrue(
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
                RuntimeException.class,
        DatafusionLocalSession session = new DatafusionLocalSession(runtimeHandle.get());
 *
 */
        }  
        expectThrows(IllegalArgumentException.class, () -> NativeBridge.executeLocalPreparedPlan(0L, 0L));  
 * compatible open source license.
 * the MethodHandles link successfully and the methods can be invoked without  
        expectThrows(IllegalArgumentException.class, () -> NativeBridge.preparePartialPlan(0L, new byte[] { 0x01 }));
        Path spillDir = createTempDir("datafusion-spill");
