 * The OpenSearch Contributors require contributions made to
    public void testRegisterFormatPreCreatesContainer() {
        // blobContainer called once for basePath (constructor) + once for parquet (first access)
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(mock(BlobContainer.class));
 * Tests for {@link FormatBlobRouter}.
        // Cache unchanged
public class FormatBlobRouterTests extends OpenSearchTestCase {
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        verify(blobStore).blobContainer(parquetPath);
        assertEquals("parquet", router.resolveFormat("_0.pqt__UUID"));
    }
}
    public void testReplaceBlobFormatCache() {
    }
        router.registerFormat("lucene");
    }
        when(blobStore.blobContainer(basePath.parent().add("parquet"))).thenReturn(container);
        // Only lucene should be registered (default), no extra containers created
        router.registerBlobFormat("_0.pqt__UUID", "parquet");
        assertEquals("arrow", router.resolveFormat("new_key"));
import static org.mockito.Mockito.when;
    public void testLuceneFormatReturnsBaseContainer() {
    }
    public void testUnregisterBlobFormat() {
        // Should create path with lowercase "parquet"
    }
    public void testNullFormatReturnsBaseContainer() {
        verify(blobStore).blobContainer(basePath.parent().add("parquet"));
        assertSame(first, second);
    public void testReplaceBlobFormatCache_ImmutableSnapshot() {
package org.opensearch.index.store.remote;
        BlobPath parquetPath = basePath.parent().add("parquet");
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        router.unregisterBlobFormat(null);
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    public void testSameFormatReturnsSameContainer() {
 * compatible open source license.
        BlobContainer parquetContainer = mock(BlobContainer.class);
        assertTrue(router.registeredFormats().contains("parquet"));
        router.unregisterBlobFormat("_0.pqt__UUID");
        router.registerFormat(null);
        assertEquals(1, router.registeredFormats().size());
    private BlobStore blobStore;
    }
        when(blobStore.blobContainer(basePath.parent().add("parquet"))).thenReturn(parquetContainer);
        assertEquals("lucene", router.resolveFormat("_0.pqt__UUID"));
    }
        assertTrue(router.registeredFormats().contains("arrow"));
        assertEquals("parquet", router.resolveFormat("_0.pqt__UUID"));
    }
        assertSame(baseContainer, router.containerFor("metadata"));
import static org.mockito.Mockito.verify;
        router.registerFormat("parquet");
    public void testClearBlobFormatCache() {
        BlobContainer second = router.containerFor("parquet");
        when(blobStore.blobContainer(parquetPath)).thenReturn(parquetContainer);
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        verify(blobStore, times(1)).blobContainer(basePath.parent().add("parquet"));
        assertEquals("parquet", router.resolveFormat("_0.pqt__UUID"));
    }
    public void testRegisterFormatIgnoresBasePathFormats() {
        BlobContainer result = router.containerFor("parquet");
        router.registerBlobFormat("old_key", "parquet");
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
import org.opensearch.common.blobstore.BlobPath;
    public void testFormatNameIsLowercasedForPath() {
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        router.containerFor("Parquet");
        mutable.put("key2", "arrow");
        baseContainer = mock(BlobContainer.class);
        java.util.Map<String, String> mutable = new java.util.HashMap<>();
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    }
    }
        router.registerBlobFormat("_0.pqt__UUID", "parquet");
 */
        router.registerBlobFormat("_0.pqt__UUID", "parquet");
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        verify(blobStore).blobContainer(basePath.parent().add("parquet"));
        BlobContainer parquetContainer = mock(BlobContainer.class);
 * this file be licensed under the Apache-2.0 license or a
        blobStore = mock(BlobStore.class);
        BlobContainer parquetContainer = mock(BlobContainer.class);
        router.containerFor("arrow");
    public void setUp() throws Exception {
    public void testBaseContainerAccessor() {
        assertEquals(3, router.registeredFormats().size());
    private BlobPath basePath;
        BlobContainer container = mock(BlobContainer.class);
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
/*
        assertEquals("lucene", router.resolveFormat("_0.pqt__UUID"));
import org.opensearch.test.OpenSearchTestCase;
        // Mutating the original map should not affect the cache
    public void testRegisterBlobFormat_NullKeyIgnored() {
        router.containerFor("parquet");
        assertEquals("lucene", router.resolveFormat("_0.pqt__UUID"));
        router.replaceBlobFormatCache(java.util.Map.of("new_key", "arrow"));
import static org.mockito.Mockito.times;
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    @Override
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        when(blobStore.blobContainer(basePath.parent().add("parquet"))).thenReturn(parquetContainer);
 * SPDX-License-Identifier: Apache-2.0
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        assertEquals("parquet", router.resolveFormat("_0.pqt__UUID"));
    // Blob Format Cache Tests
    }
        when(blobStore.blobContainer(basePath)).thenReturn(baseContainer);
        assertEquals(1, router.registeredFormats().size());
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        router.replaceBlobFormatCache(mutable);
    private BlobContainer baseContainer;
    }
 *
        router.registerBlobFormat(null, "parquet");
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    public void testRegisteredFormatsGrowsWithAccess() {
        assertEquals("lucene", router.resolveFormat("old_key"));
        BlobContainer first = router.containerFor("parquet");
    }
    }
    public void testRegisteredFormatsIncludesLuceneByDefault() {
        assertEquals("lucene", router.resolveFormat("anything"));
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        assertSame(baseContainer, router.containerFor("lucene"));
        router.registerFormat("metadata");
import org.opensearch.common.blobstore.BlobContainer;
    }
    }
        super.setUp();
    public void testNonLuceneFormatCreatesSubPathContainer() {
    public void testMetadataFormatReturnsBaseContainer() {
        router.registerBlobFormat("_0.pqt__UUID", "parquet");
    // ═══════════════════════════════════════════════════════════════
        assertTrue(router.registeredFormats().contains("lucene"));
        assertSame(baseContainer, router.baseContainer());
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    // ═══════════════════════════════════════════════════════════════
import org.opensearch.common.blobstore.BlobStore;
 */
        router.clearBlobFormatCache();
    }
        // Should not throw, cache unchanged
import static org.mockito.Mockito.mock;
        assertEquals("lucene", router.resolveFormat("_0.cfs__UUID"));
        assertEquals("lucene", router.resolveFormat("key2"));
    public void testUnregisterBlobFormat_NullKeyIgnored() {
    public void testRegisterBlobFormat_ThenResolve() {
import static org.mockito.ArgumentMatchers.any;
    }
        assertSame(parquetContainer, result);
    }
        mutable.put("key1", "parquet");
    }
    public void testRegisterBlobFormat_NullFormatIgnored() {
        basePath = new BlobPath().add("indices").add("shard0").add("segments");
        assertTrue(router.registeredFormats().contains("lucene"));
    public void testResolveFormat_DefaultsToLucene() {
        assertSame(baseContainer, router.containerFor(null));
/**
        assertTrue(router.registeredFormats().contains("parquet"));
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        router.registerBlobFormat("_0.pqt__UUID", null);
