import java.nio.file.Files;
    }  
        SpillStats stats = SpillStatsCollector.collect(tmp.toString(), 1_000_000L);
    public void testCollectReadsFilesystemForExistingDirectory() throws IOException {
        assertEquals(missing.toString(), stats.getDirectory());
    }
        SpillStats stats = SpillStatsCollector.collect("", 999_999L);
        assertTrue(stats.getDiskAvailableBytes() > 0L);
        Files.writeString(tmp.resolve("loose.txt.stale"), "stale loose");
            // Symlinks unsupported here — accept the test on 2 entries instead of 3.
        assertEquals(4242L, stats.getDiskReservedBytes());
        // Two NON-.stale entries — must be ignored.
        Path missing = createTempDir().resolve("does-not-exist-" + UUID.randomUUID());
        assertTrue(stats.getDiskTotalBytes() > 0L);  
     */  
        assertEquals(tmp.toString(), stats.getDirectory());
}
package org.opensearch.be.datafusion.stats;
 *
        assertEquals(0L, stats.getStaleEntryCount());
/*  
            SpillStats statsNoLink = SpillStatsCollector.collect(tmp.toString(), 0L);
        } catch (UnsupportedOperationException | IOException e) {  
            return;
        assertEquals("only the three .stale entries should be counted", 3L, stats.getStaleEntryCount());  
import java.nio.file.Path;
 * The OpenSearch Contributors require contributions made to  
            assertEquals("dir + file should be counted", 2L, statsNoLink.getStaleEntryCount());  
    public void testCollectReturnsZeroForEmptyDirectory() {
public class SpillStatsCollectorTests extends OpenSearchTestCase {
        Files.createDirectory(tmp.resolve("datafusion-aB3kF7.stale"));
        assertEquals(0L, stats.getDiskUsedBytes());  
        assertFalse("precondition: path must not exist", Files.exists(missing));  
        assertEquals(0L, stats.getDiskReservedBytes());
        assertEquals(0L, stats.getDiskTotalBytes());
        // Symlinks may not be supported on every test platform; try and skip if unavailable.  
        Files.createDirectory(tmp.resolve("datafusion-newRandom"));
        SpillStats stats = SpillStatsCollector.collect(tmp.toString(), 0L);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1_000_000L, stats.getDiskReservedBytes());
     * and a regular file without the suffix). Verifies the count reports exactly 3.
        assertEquals(0L, stats.getStaleEntryCount());
     * plus two non-stale entries that must NOT be counted (a live datafusion-* dir
        Path tmp = createTempDir();  
        // Three .stale entries — should be counted.  
    }
            Files.createSymbolicLink(tmp.resolve("link.stale"), tmp.resolve("datafusion-aB3kF7.stale"));
import java.io.IOException;  
import java.util.UUID;  
        SpillStats stats = SpillStatsCollector.collect(missing.toString(), 4242L);
        assertEquals(stats.getDiskTotalBytes(), stats.getDiskAvailableBytes() + stats.getDiskUsedBytes());  
    public void testCollectCountsStaleEntries() throws IOException {
    /**
    public void testCollectReturnsZeroBytesForMissingDirectoryButPreservesReserved() {
     * Pre-seeds three {@code *.stale} entries (a dir, a regular file, and a symlink)  
        try {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("empty spill dir has no .stale entries", 0L, stats.getStaleEntryCount());
        }
    }  
        Files.writeString(tmp.resolve("README.md"), "live");  
 * compatible open source license.
        assertEquals(0L, stats.getDiskAvailableBytes());
        assertEquals("", stats.getDirectory());  
 */  
        Path tmp = createTempDir();
        assertEquals(0L, stats.getDiskTotalBytes());  
 * SPDX-License-Identifier: Apache-2.0
