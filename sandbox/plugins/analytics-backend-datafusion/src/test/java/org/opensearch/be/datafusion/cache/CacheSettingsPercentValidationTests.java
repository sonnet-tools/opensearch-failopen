/*  
        assertTrue("statistics cache must get non-zero bytes", sizes[3] > 0);
    public void testComputeSizesSumWithinBudget() {  
    }
        long total = 1_000_000L;
        assertTrue("error must name statistics key", ex.getMessage().contains("statistics_percent"));
        );
            assertEquals(0L, s);  
            () -> CacheSettings.validatePercentSum(50, 35, 20, 5)  // 110
        CacheSettings.validatePercentSum(1, 1, 1, 1);     // 4% — valid
        long sum = sizes[0] + sizes[1] + sizes[2] + sizes[3];  
 *
        CacheSettings.validatePercentSum(45, 33, 12, 5);  // 95% — headroom allowed
        // Defaults: 48 + 34 + 13 + 5 = 100  
    }
        assertTrue("sum must be close to total", sum >= total - 3);  
        assertTrue("error must mention sum", ex.getMessage().contains("sum=110"));  
    public void testSumOver100Throws() {
    }  
    }  
        assertEquals(total * 13 / 100, sizes[2]); // column index ~150 MB
    public void testSumUnder100PassesHeadroomAccepted() {
        CacheSettings.validatePercentSum(33, 34, 28, 5);  
        assertTrue(ex.getMessage().contains("offset_index_percent"));
        long[] sizes = CacheSettings.computeCacheSizes(48, 34, 13, 5, total);
 * The OpenSearch Contributors require contributions made to  
        assertTrue("sum must not exceed total", sum <= total);
 */  
            IllegalArgumentException.class,  
/**  
    }
        long total = 1_000_000L;
            IllegalArgumentException.class,  
    public void testSinglePercentRaisedAloneBreaks() {
    }
        CacheSettings.validatePercentSum(1, 1, 97, 1);
        assertTrue(ex.getMessage().contains("column_index_percent"));  
        CacheSettings.validatePercentSum(40, 30, 10, 5);  // 85% — headroom OK  
    public void testStatisticsUsesPercentDerivedLimit() {  
        CacheSettings.validatePercentSum(40, 40, 15, 5);  // 100% — exact
        for (long s : sizes)
    public void testDefaultsSumTo100() {
    // ── computeCacheSizes ─────────────────────────────────────────────────────
        long[] sizes = CacheSettings.computeCacheSizes(48, 34, 13, 5, 0L);
        );  
    }
 * compatible open source license.
}  
        long[] sizes = CacheSettings.computeCacheSizes(48, 34, 13, 5, total);
package org.opensearch.be.datafusion.cache;
        CacheSettings.validatePercentSum(60, 25, 10, 5);
        assertTrue(ex.getMessage().contains("statistics_percent"));
    }
            IllegalArgumentException.class,
    }
    public void testAtomicUpdateAllFourPasses() {  
 * Tests for {@link CacheSettings#validatePercentSum} and
    public void testComputeSizesStatisticsNotZero() {
import org.opensearch.test.OpenSearchTestCase;
        CacheSettings.validatePercentSum(48, 34, 13, 1);  // 96% — 4% unused
        assertEquals(total * 5 / 100, sizes[3]);  // statistics ~58 MB
        long total = 1_000_000L;  
    public void testComputeSizesDefaultSplit() {
        // Statistics bytes come from the unified percent budget, not a standalone hardcoded limit.
        assertEquals(total * 48 / 100, sizes[0]); // footer ~552 MB
    }
        IllegalArgumentException ex = expectThrows(  
            () -> CacheSettings.validatePercentSum(48, 34, 13, 15)  // 110
        IllegalArgumentException ex = expectThrows(
    }  
        assertTrue("error must mention sum", ex.getMessage().contains("sum=110"));  
        // 48+34+13+5=100, integer division may lose up to 3 bytes
        assertEquals(50_000L, sizes[3]); // 5% of 1_000_000  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(4, sizes.length);
        assertTrue(ex.getMessage().contains("footer_metadata_percent"));
    public void testSumExactly100Passes() {
        assertEquals("statistics cache must use percent-derived limit", 50_000L, sizes[3]);
 * {@link CacheSettings#computeCacheSizes}.
    public void testComputeSizesZeroTotalGivesZeros() {  
        assertEquals(total * 34 / 100, sizes[1]); // offset index ~391 MB  
        long total = 1_150_000_000L; // ~1.15 GB sample metadata-index cache total budget
    }
 */  
        CacheSettings.validatePercentSum(48, 34, 13, 5);
            () -> CacheSettings.validatePercentSum(48, 34, 13, 10)  // 105
 * this file be licensed under the Apache-2.0 license or a
    // ── validatePercentSum ────────────────────────────────────────────────────  
        assertTrue(ex.getMessage().contains("sum=105"));
        IllegalArgumentException ex = expectThrows(
        long[] sizes = CacheSettings.computeCacheSizes(48, 34, 13, 5, total);  
public class CacheSettingsPercentValidationTests extends OpenSearchTestCase {
        );
    public void testErrorMessageNamesAllKeys() {
        long[] sizes = CacheSettings.computeCacheSizes(48, 34, 13, 5, total);  
