            assertTrue(  
            // Symbol is present — setSpillLimit must not throw the  
        } else {
            );
        // Whatever the current value, the probe must be deterministic.  
            // actual side effect without a live runtime pointer, but invoking the
 * assertions become unreachable but the positive-path assertions activate — the  
            } catch (Exception expected) {  
 * SPDX-License-Identifier: Apache-2.0
/**
 * {@code true} automatically.
                e.getMessage().contains("df_set_spill_limit")
 * this file be licensed under the Apache-2.0 license or a
 * to {@code Arc<AtomicU64>} lands and we ship the symbol, the probe flips to
 * forward-compatible: today the upstream DataFusion 53.1.0 {@code DiskManager} does  
        boolean dynamic = NativeBridge.isSpillLimitDynamic();
                // the symbol-absent path is not taken when the probe says present.
    public void testSetSpillLimitContractMatchesProbe() {
 */  
                fail("isSpillLimitDynamic() returned true but setSpillLimit threw the symbol-absent sentinel: " + e.getMessage());
 * <p>Each test below branches on {@link NativeBridge#isSpillLimitDynamic()} so the
 * (only verification when the change is made).
                "expected error message to mention the missing symbol, got: " + e.getMessage(),
            // (typically a downcall error) rather than the "symbol absent" path.
 * test class continues to lock in the expected behaviour without needing rewrites
 * suite remains green in both regimes. When the symbol ships, the negative-path
package org.opensearch.be.datafusion;
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        }
 */  
        assertEquals("isSpillLimitDynamic must be deterministic across calls", dynamic, NativeBridge.isSpillLimitDynamic());
        // this assertion will start passing the other branch.
        // The probe should return a stable answer for the loaded native library.
 * {@code false}. When the upstream patch converting {@code max_temp_directory_size}  
                NativeBridge.setSpillLimit(0L, 1024L * 1024 * 1024);  
            }  
 *
            } catch (UnsupportedOperationException e) {
        if (NativeBridge.isSpillLimitDynamic()) {
 *  
 * compatible open source license.
                // Any other failure is acceptable here; we're only asserting that
 * not expose a safe runtime resize through {@code Arc<DiskManager>}, so our Rust
public class NativeBridgeSpillProbeTests extends OpenSearchTestCase {
            );  
            try {
import org.opensearch.test.OpenSearchTestCase;
                () -> NativeBridge.setSpillLimit(0L, 1024L * 1024 * 1024)
 * crate does not export {@code df_set_spill_limit} and the probe reports
            // method with runtimePtr=0 must surface a different failure mode  
    }
 * Tests for the runtime spill-limit probe in {@link NativeBridge}. The probe is
    public void testProbeReportsAvailability() {  
        // Arc<AtomicU64> patch lands and our crate exports df_set_spill_limit,  
 * The OpenSearch Contributors require contributions made to  
            // UnsupportedOperationException sentinel. We can't assert on the
        // Today this is false (we do not ship the symbol). When the upstream
                UnsupportedOperationException.class,  
/*  
}  
            UnsupportedOperationException e = expectThrows(
    }
