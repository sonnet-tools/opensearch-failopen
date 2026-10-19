    private PrecomputedChecksumStrategy strategy;
        assertEquals(expected, strategy.computeChecksum(directory, "j.parquet"));  
    }
        super.tearDown();
        assertEquals(42L, strategy.computeChecksum(directory, "g.parquet"));
        }
        strategy.registerChecksum((String) null, 1234L, 1L);     // null name is a no-op  
        try (IndexOutput out = directory.createOutput(name, IOContext.DEFAULT)) {
        writeFile("f.parquet", "payload");  
        directory.close();  
        writeFile("h.parquet", "x");
 * The OpenSearch Contributors require contributions made to  
        // Prime the cache with the fallback (generation 0).  
    public void testClearChecksumsEmptiesCache() throws IOException {
 *
        // Retained file still returns the registered value.  
    }
 */  
        assertEquals(999L, strategy.computeChecksum(directory, "c.parquet"));  
        writeFile("g.parquet", "data");
 * Unit tests for {@link PrecomputedChecksumStrategy} covering register/lookup, fallback
}
        super.setUp();
        assertEquals(expected, second);  
        assertEquals(expected, strategy.computeChecksum(directory, "g.parquet"));
    @Override
        } catch (IOException e) {  
    }
        assertEquals(12345L, strategy.computeChecksum(directory, "a.parquet"));  
    private void writeFile(String name, byte[] bytes) throws IOException {  
    }  
        assertEquals(expected, first);
        // Since no real register happened, compute falls back to scanning the file.
    }  
        strategy.registerChecksum("h.parquet", 111L, 1L);
    }
 * SPDX-License-Identifier: Apache-2.0
    private static long fullFileCrc32(byte[] bytes) {  
        writeFile("i.parquet", "y");  
import org.apache.lucene.store.IOContext;  
        long expected = fullFileCrc32(payload);
        writeFile("c.parquet", "payload");
        writeFile("b.parquet", payload);
import java.nio.charset.StandardCharsets;
        long expected = fullFileCrc32("payload".getBytes(StandardCharsets.UTF_8));  
    }
        writeFile("a.parquet", "payload");
    // ─── helpers ─────────────────────────────────────────────────────────────  
        directory = new ByteBuffersDirectory();  
import org.apache.lucene.store.ByteBuffersDirectory;
        return crc.getValue();  
        byte[] payload = "hello-world".getBytes(StandardCharsets.UTF_8);
    private Directory directory;  
    public void testEqualGenerationRegistrationOverwrites() throws IOException {
        // After eviction, lookup falls back to the file contents.
/**  
public class PrecomputedChecksumStrategyTests extends OpenSearchTestCase {
        long second = strategy.computeChecksum(directory, "b.parquet");
    }
        strategy.evictChecksum("g.parquet");  
        // Second call should hit the cache and return the same value without re-reading.
        assertNotEquals(scanned, 999L);
    }
        // Write path registers a different value with a real generation; it must overwrite.  
        strategy.registerChecksum("j.parquet", 777L, 1L);  
        writeFile("j.parquet", "z");
        strategy.registerChecksum("f.parquet", 0L, 1L); // zero treated as "unset"
import org.apache.lucene.store.IndexOutput;
        strategy.clearChecksums();
            out.writeBytes(bytes, bytes.length);
    public void testWriteRegistrationOverwritesFallbackEntry() throws IOException {  
 * caching, generation-based overwrite semantics, and retain/evict behavior.
/*  
import java.util.zip.CRC32;
        CRC32 crc = new CRC32();
        strategy.registerChecksum("e.parquet", 2000L, 5L);
        // Strategy should return the registered value, not the scanned CRC32 of "payload".
        }  
        // Newer generation first.
 * this file be licensed under the Apache-2.0 license or a
        // Evicted file falls back to a scan.
        // Older generation arriving late must NOT clobber.
            assertEquals(2000L, strategy.computeChecksum(directory, "d.parquet"));
        // First call: cache miss — scans the file.  
        strategy.registerChecksum("c.parquet", 999L, 5L);
        assertEquals(expected, strategy.computeChecksum(directory, "f.parquet"));
        strategy.registerChecksum("g.parquet", 42L, 1L);  
        long expectedI = fullFileCrc32("y".getBytes(StandardCharsets.UTF_8));  
    public void testRegisteredChecksumIsReturnedWithoutScanning() throws IOException {
        long scanned = strategy.computeChecksum(directory, "c.parquet");
        strategy.registerChecksum("i.parquet", 222L, 1L);
        strategy.retainOnly(List.of("h.parquet"));
    @Override  
        // After clear, lookup falls back to a scan.
 */  
        strategy.registerChecksum("e.parquet", 1000L, 5L);  
    }
import org.opensearch.test.OpenSearchTestCase;
        strategy = new PrecomputedChecksumStrategy();
        long expected = fullFileCrc32("z".getBytes(StandardCharsets.UTF_8));
    public void testFallbackScanMatchesFullFileCrc32AndIsCached() throws IOException {  
        assertEquals(expectedI, strategy.computeChecksum(directory, "i.parquet"));
    public void testEvictChecksumRemovesEntry() throws IOException {
        strategy.registerChecksum("d.parquet", 2000L, 10L);  
    public void testStaleRegistrationDoesNotOverwriteNewerEntry() {
    public void tearDown() throws Exception {
        writeFile(name, content.getBytes(StandardCharsets.UTF_8));  
    public void setUp() throws Exception {
    public void testRegisterIgnoresZeroChecksumAndNullName() throws IOException {
        assertEquals(111L, strategy.computeChecksum(directory, "h.parquet"));
        try {
 * compatible open source license.
        crc.update(bytes);
        long expected = fullFileCrc32("data".getBytes(StandardCharsets.UTF_8));  
            throw new AssertionError(e);
    }
        assertEquals(2000L, strategy.computeChecksum(directory, "e.parquet"));
    public void testRetainOnlyEvictsFilesNotInActiveSet() throws IOException {
    }
    }
import org.apache.lucene.store.Directory;
    }
package org.opensearch.index.store;
        long first = strategy.computeChecksum(directory, "b.parquet");
import java.util.List;  
        strategy.registerChecksum("d.parquet", 1000L, 5L);
    private void writeFile(String name, String content) throws IOException {
        strategy.registerChecksum("a.parquet", 12345L, 1L);  
import java.io.IOException;
