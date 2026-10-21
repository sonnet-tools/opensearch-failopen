    public void testDiskBytesErrorMessageContainsBadValue() {
    }
    }
        );
            new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.75, 0L);
    public void testDiskBytesGuardFiresBeforeDiskDirNullCheck() {
            IllegalArgumentException.class,
    }
        );
    }
            NullPointerException.class,
        assertTrue("message should mention sweepIntervalSecs", ex.getMessage().contains("sweepIntervalSecs"));
        } catch (Throwable ignored) {
    // ── sweepThresholdRatio validation ────────────────────────────────────────
        assertTrue(ex.getMessage().contains("diskBytes"));
 * compatible open source license.
        IllegalArgumentException ex = expectThrows(
     * Verify error messages include the bad value so operators can act on them
            () -> new FoyerBlockCache(1L, "", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
        );
    public void testConstructorThrowsWhenDiskBytesIsNegative() {
    public void testConstructorThrowsWhenDiskDirIsBlank() {
            IllegalArgumentException.class,
    public void testConstructorThrowsWhenDiskDirIsNull() {
        );
 *
            IllegalArgumentException.class,
 * <p>All validation guards throw before reaching {@code FoyerBridge.createCache()},
    }
        );
        IllegalArgumentException ex = expectThrows(
        } catch (IllegalArgumentException e) {
            fail("Expected native library call to fail");
    }
     * should throw on diskBytes, not NPE on diskDir.
            fail("Expected native library call to fail");
        try {
        IllegalArgumentException ex = expectThrows(
    }
 *
            () -> new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, -0.01, 0L)
    }
    // ── ioEngine validation ───────────────────────────────────────────────────
    }
}
    }
    public void testConstructorThrowsWhenIoEngineIsNull() {
        );
            () -> new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", -1L, 0.0, 0L)
 * Unit tests for {@link FoyerBlockCache} constructor argument validation.
    // ── Error message quality ─────────────────────────────────────────────────
    public void testConstructorThrowsWhenSweepThresholdRatioExceedsOne() {
 */
     * diskBytes is checked before diskDir, so a zero diskBytes with null diskDir
        try {
            () -> new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, null, 0L, 0.0, 0L)
    public void testConstructorAcceptsSweepThresholdRatioOfOne() {
    }
        // This will fail at the native call, but not at argument validation.
            IllegalArgumentException.class,
    public void testConstructorThrowsWhenSweepIntervalSecsIsNegative() {
    public void testConstructorAcceptsSweepThresholdRatioOf0dot75() {
        );
            IllegalArgumentException.class,
 */
            IllegalArgumentException.class,
            fail("Expected native library call to fail (UnsatisfiedLinkError or similar)");
    }
            new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L);
 * The OpenSearch Contributors require contributions made to
        IllegalArgumentException ex = expectThrows(
    }
        // 1.0 = only sweep when cache is 100% full; valid boundary value
        );
            () -> new FoyerBlockCache(1L, "/tmp/cache", 0L, 1L, 2L, "auto", 0L, 0.0, 0L)
        // typical production value: skip sweep when < 75% full
            () -> new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 1.01, 0L)
    // ── Guard ordering: earlier guard fires first ─────────────────────────────
        try {
        // We can't fully invoke the constructor without the native library, so we just
        IllegalArgumentException ex = expectThrows(
        assertTrue("error message should contain the bad value -42", ex.getMessage().contains("-42"));
public class FoyerBlockCacheTests extends OpenSearchTestCase {
            fail("Validation guard fired unexpectedly for sweepThresholdRatio=1.0: " + e.getMessage());
        assertTrue(ex.getMessage().contains("diskBytes"));
            () -> new FoyerBlockCache(-42L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
package org.opensearch.blockcache.foyer;
            new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L);
            fail("Validation guard fired unexpectedly for sweepThresholdRatio=0.0: " + e.getMessage());
        );
 * so these tests run without the native library.
        // verify the guard doesn't fire for 0.
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException ex = expectThrows(
            NullPointerException.class,
            fail("Validation guard fired unexpectedly for sweepIntervalSecs=0: " + e.getMessage());
        assertTrue("message should mention sweepThresholdRatio", ex.getMessage().contains("sweepThresholdRatio"));
        // 0 = disabled (no background sweep task spawned); must NOT throw before reaching FoyerBridge
            new FoyerBlockCache(1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 1.0, 0L);
        IllegalArgumentException ex = expectThrows(
        IllegalArgumentException ex = expectThrows(
        } catch (Throwable ignored) {
    }
            fail("Expected native library call to fail");
        } catch (IllegalArgumentException e) {
            // Expected: native library not loaded in unit test environment
    // ── blockSizeBytes validation ─────────────────────────────────────────────
            IllegalArgumentException.class,
     */
            () -> new FoyerBlockCache(1L, "/tmp/cache", -8L, 1L, 2L, "auto", 0L, 0.0, 0L)
        }
            () -> new FoyerBlockCache(1L, null, 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
    public void testConstructorAcceptsSweepThresholdRatioOfZero() {
        assertTrue(ex.getMessage().contains("blockSizeBytes"));
            // Expected: native library not loaded in unit test environment
    public void testConstructorThrowsWhenSweepThresholdRatioIsNegative() {
        assertTrue("message should mention blockSizeBytes", ex.getMessage().contains("blockSizeBytes"));
    // ── diskDir validation ────────────────────────────────────────────────────
        NullPointerException ex = expectThrows(
            IllegalArgumentException.class,
        assertTrue("error message should contain the bad value -8", ex.getMessage().contains("-8"));
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        }
    public void testConstructorThrowsWhenDiskBytesIsZero() {
        );
            () -> new FoyerBlockCache(1L, "   ", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
            IllegalArgumentException.class,
        assertTrue("message should mention diskDir", ex.getMessage().contains("diskDir"));
            // Expected: native library not loaded in unit test environment
        IllegalArgumentException ex = expectThrows(
    }
    public void testConstructorAcceptsSweepIntervalSecsOfZero() {
        assertTrue("message should mention ioEngine", ex.getMessage().contains("ioEngine"));
            () -> new FoyerBlockCache(-1L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
    public void testConstructorThrowsWhenDiskDirIsEmptyString() {
        );
        // 0.0 = disabled (always sweep); must NOT throw before reaching FoyerBridge
        NullPointerException ex = expectThrows(
        assertTrue("message should mention sweepThresholdRatio", ex.getMessage().contains("sweepThresholdRatio"));
        }
        } catch (IllegalArgumentException e) {
            () -> new FoyerBlockCache(1L, "/tmp/cache", -1L, 1L, 2L, "auto", 0L, 0.0, 0L)
     */
            () -> new FoyerBlockCache(0L, "/tmp/cache", 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("message should contain the bad value -1", ex.getMessage().contains("-1"));
        } catch (Throwable ignored) {
/*
 * this file be licensed under the Apache-2.0 license or a
        );
            fail("Validation guard fired unexpectedly for sweepThresholdRatio=0.75: " + e.getMessage());
        // zero diskBytes + null diskDir: first guard (diskBytes) should fire
        }
        assertTrue("message should mention diskBytes", ex.getMessage().contains("diskBytes"));
    public void testConstructorThrowsWhenBlockSizeBytesIsZero() {
    }
    /**
    }
        assertTrue(ex.getMessage().contains("diskDir"));
            // Expected: native library not loaded in unit test environment
     * without reading source code.
        IllegalArgumentException ex = expectThrows(
        );
    public void testBlockSizeBytesErrorMessageContainsBadValue() {
    // ── diskBytes validation ──────────────────────────────────────────────────
        try {
    public void testConstructorThrowsWhenBlockSizeBytesIsNegative() {
            () -> new FoyerBlockCache(0L, null, 1L, 1L, 2L, "auto", 0L, 0.0, 0L)
        } catch (IllegalArgumentException e) {
    /**
        IllegalArgumentException ex = expectThrows(
        );
    // ── sweepIntervalSecs validation ──────────────────────────────────────────
/**
        } catch (Throwable ignored) {
        IllegalArgumentException ex = expectThrows(
        assertTrue(ex.getMessage().contains("diskDir"));
    }
            IllegalArgumentException.class,
