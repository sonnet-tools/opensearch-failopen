        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        when(blobStore.blobContainer(basePath)).thenReturn(baseContainer);  
    }
        router.unregisterBlobFormat(null);
    }  
    }
    // Blob Format Cache Tests
 */  
        router.registerBlobFormat(null, "parquet");
        assertEquals("lucene", router.resolveFormat("old_key"));  
 * compatible open source license.
        super.setUp();
    public void testFormatNameIsLowercasedForPath() {
    public void testRegisterBlobFormat_ThenResolve() {  
        assertTrue(router.registeredFormats().contains("lucene"));
 * this file be licensed under the Apache-2.0 license or a
    public void testNonLuceneFormatCreatesSubPathContainer() {  
        router.replaceBlobFormatCache(mutable);
    public void testUnregisterBlobFormat_NullKeyIgnored() {
        // Cache unchanged
        BlobContainer parquetContainer = mock(BlobContainer.class);
        router.unregisterBlobFormat("_0.pqt__UUID");  
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        when(blobStore.blobContainer(basePath.parent().add("parquet"))).thenReturn(parquetContainer);  
        when(blobStore.blobContainer(basePath.parent().add("parquet"))).thenReturn(parquetContainer);
 *
    }
        BlobContainer second = router.containerFor("parquet");  
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        BlobContainer parquetContainer = mock(BlobContainer.class);
        assertEquals("lucene", router.resolveFormat("_0.pqt__UUID"));
/*  
        assertEquals(1, router.registeredFormats().size());
        assertTrue(router.registeredFormats().contains("parquet"));
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        // Should create path with lowercase "parquet"
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    public void testLuceneFormatReturnsBaseContainer() {  
    }
    }
    }
        assertEquals("parquet", router.resolveFormat("_0.pqt__UUID"));
 */
        assertEquals("lucene", router.resolveFormat("anything"));
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1, router.registeredFormats().size());  
        router.registerFormat(null);
    private BlobStore blobStore;
    private BlobContainer baseContainer;
        router.registerBlobFormat("_0.pqt__UUID", "parquet");
        assertSame(baseContainer, router.containerFor("metadata"));  
import org.opensearch.common.blobstore.BlobContainer;
 * SPDX-License-Identifier: Apache-2.0
        BlobContainer parquetContainer = mock(BlobContainer.class);
        // Only lucene should be registered (default), no extra containers created  
import static org.mockito.ArgumentMatchers.any;  
        // blobContainer called once for basePath (constructor) + once for parquet (first access)  
    }
    }
        router.containerFor("Parquet");  
        router.registerBlobFormat("old_key", "parquet");
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        router.containerFor("parquet");
    public void testRegisterFormatIgnoresBasePathFormats() {  
        blobStore = mock(BlobStore.class);  
        mutable.put("key1", "parquet");
        verify(blobStore, times(1)).blobContainer(basePath.parent().add("parquet"));
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
 * Tests for {@link FormatBlobRouter}.
        router.registerBlobFormat("_0.pqt__UUID", "parquet");  
        basePath = new BlobPath().add("indices").add("shard0").add("segments");
    public void testRegisteredFormatsGrowsWithAccess() {  
        when(blobStore.blobContainer(basePath.parent().add("parquet"))).thenReturn(container);  
        assertSame(baseContainer, router.containerFor("lucene"));
    public void testNullFormatReturnsBaseContainer() {
        java.util.Map<String, String> mutable = new java.util.HashMap<>();  
    }
        router.registerFormat("metadata");  
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        router.containerFor("arrow");
        BlobPath parquetPath = basePath.parent().add("parquet");
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
import org.opensearch.common.blobstore.BlobPath;
        assertEquals("lucene", router.resolveFormat("key2"));  
import static org.mockito.Mockito.verify;  
    public void testUnregisterBlobFormat() {
    public void testReplaceBlobFormatCache() {  
        assertEquals("arrow", router.resolveFormat("new_key"));
    private BlobPath basePath;  
        assertEquals("lucene", router.resolveFormat("_0.pqt__UUID"));
        assertEquals("lucene", router.resolveFormat("_0.cfs__UUID"));  
    public void testMetadataFormatReturnsBaseContainer() {
    }
        router.replaceBlobFormatCache(java.util.Map.of("new_key", "arrow"));
        assertEquals("parquet", router.resolveFormat("_0.pqt__UUID"));  
        assertEquals(3, router.registeredFormats().size());
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        verify(blobStore).blobContainer(basePath.parent().add("parquet"));  
}
        assertSame(baseContainer, router.containerFor(null));
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        assertSame(first, second);
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(mock(BlobContainer.class));
        assertTrue(router.registeredFormats().contains("arrow"));  
        router.registerBlobFormat("_0.pqt__UUID", null);  
/**  
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        verify(blobStore).blobContainer(parquetPath);  
public class FormatBlobRouterTests extends OpenSearchTestCase {  
        assertTrue(router.registeredFormats().contains("parquet"));
    @Override  
    public void testRegisterBlobFormat_NullFormatIgnored() {
    public void testSameFormatReturnsSameContainer() {  
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        mutable.put("key2", "arrow");
    public void testRegisterBlobFormat_NullKeyIgnored() {  
import static org.mockito.Mockito.times;
    // ═══════════════════════════════════════════════════════════════  
        assertEquals("parquet", router.resolveFormat("_0.pqt__UUID"));  
        assertSame(baseContainer, router.baseContainer());  
    }
    public void testClearBlobFormatCache() {
import static org.mockito.Mockito.when;
    public void testResolveFormat_DefaultsToLucene() {
    // ═══════════════════════════════════════════════════════════════
        assertSame(parquetContainer, result);
 * The OpenSearch Contributors require contributions made to  
        router.clearBlobFormatCache();  
    }
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
        // Mutating the original map should not affect the cache
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    public void testRegisteredFormatsIncludesLuceneByDefault() {  
    }
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);  
    public void testRegisterFormatPreCreatesContainer() {
        router.registerFormat("lucene");
    }
    }
        // Should not throw, cache unchanged  
        assertTrue(router.registeredFormats().contains("lucene"));
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);  
        FormatBlobRouter router = new FormatBlobRouter(blobStore, basePath);
    }
    public void testReplaceBlobFormatCache_ImmutableSnapshot() {
        router.registerFormat("parquet");  
import org.opensearch.common.blobstore.BlobStore;  
        BlobContainer first = router.containerFor("parquet");
    public void setUp() throws Exception {
    public void testBaseContainerAccessor() {
    }
    }
        baseContainer = mock(BlobContainer.class);
        BlobContainer result = router.containerFor("parquet");  
    }
        router.registerBlobFormat("_0.pqt__UUID", "parquet");  
        assertEquals("lucene", router.resolveFormat("_0.pqt__UUID"));
    }
package org.opensearch.index.store.remote;
        verify(blobStore).blobContainer(basePath.parent().add("parquet"));  
        assertEquals("parquet", router.resolveFormat("_0.pqt__UUID"));
        BlobContainer container = mock(BlobContainer.class);
        when(blobStore.blobContainer(parquetPath)).thenReturn(parquetContainer);  
        router.registerBlobFormat("_0.pqt__UUID", "parquet");  
import static org.mockito.Mockito.mock;
