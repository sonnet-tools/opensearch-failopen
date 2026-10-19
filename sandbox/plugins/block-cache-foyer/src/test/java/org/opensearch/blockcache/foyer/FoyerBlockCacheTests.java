/**  
        // typical production value: skip sweep when < 75% full
            // Expected: native library not loaded in unit test environment  
    public void testConstructorThrowsWhenDiskDirIsEmptyString() {
        // We can't fully invoke the constructor without the native library, so we just
        } catch (Throwable ignored) {
            IllegalArgumentException.class,
            () -> new FoyerBlockCache(0L, null, 1L, 1L, 2L, "auto", 0L, 0.0, 0L)  
        }
 *
        // 0.0 = disabled (always sweep); must NOT throw before reaching FoyerBridge
        } catch (Throwable ignored) {
public class FoyerBlockCacheTests extends OpenSearchTestCase {  
    // ── blockSizeBytes validation ─────────────────────────────────────────────
        } catch (IllegalArgumentException e) {  
        try {  
        );  
 * <p>All validation guards throw before reaching {@code FoyerBridge.createCache()},  
            fail("Validation guard fired unexpectedly for sweepThresholdRatio=0.0: " + e.getMessage());
            IllegalArgumentException.class,
 * SPDX-License-Identifier: Apache-2.0
            () -> new FoyerBlockCache(1L, "", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
            NullPointerException.class,  
    }
    public void testDiskBytesErrorMessageContainsBadValue() {
            fail("Validation guard fired unexpectedly for sweepIntervalSecs=0: " + e.getMessage());
     */  
            () -> new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, null, 0L, 0.0, 0L)  
        // verify the guard doesn't fire for 0.
    /**
            fail("Expected native library call to fail (UnsatisfiedLinkError or similar)");
    public void testConstructorThrowsWhenDiskDirIsNull() {
     */
}
 */  
            () -> new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 1.01, 0L)
        assertTrue(ex.getMessage().contains("diskDir"));
    // ── Guard ordering: earlier guard fires first ─────────────────────────────
        // 0 = disabled (no background sweep task spawned); must NOT throw before reaching FoyerBridge
        assertTrue(ex.getMessage().contains("diskDir"));
            () -> new FoyerBlockCache(1L, "/tmp/cache", -1L, 1L, 2L, "auto", 0L, 0.0, 0L)
        );
    }
            // Expected: native library not loaded in unit test environment  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(ex.getMessage().contains("diskBytes"));
    public void testConstructorThrowsWhenDiskDirIsBlank() {  
/*  
        IllegalArgumentException ex = expectThrows(
    }  
            () -> new FoyerBlockCache(-42L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
        );
        );
        assertTrue("error message should contain the bad value -42", ex.getMessage().contains("-42"));  
    }
        try {  
        IllegalArgumentException ex = expectThrows(
    public void testConstructorThrowsWhenBlockSizeBytesIsZero() {  
 *
    }  
            fail("Validation guard fired unexpectedly for sweepThresholdRatio=1.0: " + e.getMessage());
        assertTrue("message should contain the bad value -1", ex.getMessage().contains("-1"));
    public void testConstructorThrowsWhenSweepIntervalSecsIsNegative() {
        IllegalArgumentException ex = expectThrows(
            () -> new FoyerBlockCache(1L, "/tmp/cache", 0L, 1L, 2L, "auto", 0L, 0.0, 0L)  
    // ── diskDir validation ────────────────────────────────────────────────────
            IllegalArgumentException.class,  
        } catch (IllegalArgumentException e) {  
    }
            new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 1.0, 0L);
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException ex = expectThrows(  
        IllegalArgumentException ex = expectThrows(
    public void testConstructorAcceptsSweepIntervalSecsOfZero() {
            IllegalArgumentException.class,
            // Expected: native library not loaded in unit test environment  
            IllegalArgumentException.class,
            // Expected: native library not loaded in unit test environment  
        assertTrue("message should mention sweepThresholdRatio", ex.getMessage().contains("sweepThresholdRatio"));
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        IllegalArgumentException ex = expectThrows(
        );  
        } catch (IllegalArgumentException e) {  
        assertTrue("message should mention ioEngine", ex.getMessage().contains("ioEngine"));
        NullPointerException ex = expectThrows(
    public void testConstructorThrowsWhenDiskBytesIsZero() {
 * so these tests run without the native library.
     * diskBytes is checked before diskDir, so a zero diskBytes with null diskDir
    public void testConstructorAcceptsSweepThresholdRatioOf0dot75() {
        );
            new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.75, 0L);
    }
            () -> new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, -0.01, 0L)  
            NullPointerException.class,
            fail("Expected native library call to fail");
    }  
    // ── sweepThresholdRatio validation ────────────────────────────────────────
    public void testDiskBytesGuardFiresBeforeDiskDirNullCheck() {
    }
        } catch (IllegalArgumentException e) {  
    }
     * Verify error messages include the bad value so operators can act on them
            () -> new FoyerBlockCache(1L, "/tmp/cache", -8L, 1L, 2L, "auto", 0L, 0.0, 0L)  
        );
    }  
        try {  
        // This will fail at the native call, but not at argument validation.  
 * compatible open source license.
    }
    // ── sweepIntervalSecs validation ──────────────────────────────────────────
        IllegalArgumentException ex = expectThrows(
     * without reading source code.
    // ── ioEngine validation ───────────────────────────────────────────────────
            fail("Validation guard fired unexpectedly for sweepThresholdRatio=0.75: " + e.getMessage());
            fail("Expected native library call to fail");
    // ── diskBytes validation ──────────────────────────────────────────────────
    public void testConstructorThrowsWhenIoEngineIsNull() {  
    }  
        assertTrue("message should mention diskDir", ex.getMessage().contains("diskDir"));  
        );
    public void testConstructorThrowsWhenSweepThresholdRatioExceedsOne() {
        assertTrue("message should mention sweepThresholdRatio", ex.getMessage().contains("sweepThresholdRatio"));
    public void testConstructorThrowsWhenSweepThresholdRatioIsNegative() {  
    }  
     * should throw on diskBytes, not NPE on diskDir.  
    }  
        assertTrue(ex.getMessage().contains("blockSizeBytes"));
            IllegalArgumentException.class,
        );
            () -> new FoyerBlockCache(0L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
            () -> new FoyerBlockCache(-1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)  
        assertTrue("message should mention diskBytes", ex.getMessage().contains("diskBytes"));  
    // ── Error message quality ─────────────────────────────────────────────────
        IllegalArgumentException ex = expectThrows(
        IllegalArgumentException ex = expectThrows(  
        // zero diskBytes + null diskDir: first guard (diskBytes) should fire  
    }
    public void testConstructorAcceptsSweepThresholdRatioOfZero() {
        }
        IllegalArgumentException ex = expectThrows(  
            IllegalArgumentException.class,  
        );  
        IllegalArgumentException ex = expectThrows(
            () -> new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", -1L, 0.0, 0L)
        );
        );
        assertTrue("message should mention sweepIntervalSecs", ex.getMessage().contains("sweepIntervalSecs"));  
 * Unit tests for {@link FoyerBlockCache} constructor argument validation.
    public void testConstructorThrowsWhenBlockSizeBytesIsNegative() {
        assertTrue("message should mention blockSizeBytes", ex.getMessage().contains("blockSizeBytes"));
package org.opensearch.blockcache.foyer;
            new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L);
        assertTrue(ex.getMessage().contains("diskBytes"));
        }
        assertTrue("error message should contain the bad value -8", ex.getMessage().contains("-8"));
            IllegalArgumentException.class,
            () -> new FoyerBlockCache(1L, null, 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
 * The OpenSearch Contributors require contributions made to  
            IllegalArgumentException.class,  
        );
        } catch (Throwable ignored) {
        try {  
            () -> new FoyerBlockCache(1L, "   ", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)  
        } catch (Throwable ignored) {
    }
        IllegalArgumentException ex = expectThrows(
            new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L);
            IllegalArgumentException.class,
        NullPointerException ex = expectThrows(
    public void testBlockSizeBytesErrorMessageContainsBadValue() {  
    }
        }
            fail("Expected native library call to fail");
 */
        // 1.0 = only sweep when cache is 100% full; valid boundary value
    public void testConstructorThrowsWhenDiskBytesIsNegative() {  
    /**  
        );
    public void testConstructorAcceptsSweepThresholdRatioOfOne() {
