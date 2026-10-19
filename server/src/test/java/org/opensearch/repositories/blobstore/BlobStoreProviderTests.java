import org.apache.logging.log4j.Level;
        // Test - should not throw
        // Note: Since SetOnce is used internally, we need to first call blobStore() to initialize it
        // Test
        // Verify  
     */  
package org.opensearch.repositories.blobstore;
        provider = new BlobStoreProvider(mockRepository, mockMetadata, mockLifecycle, lock);
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
        super.setUp();  
        verify(mockRepository).createBlobStore();
        provider.reloadBlobStore(newMetadata);
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
        BlobStore result = provider.getBlobStore(true);  
        provider.reloadBlobStore(newMetadata);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(BlobStoreProvider.class))) {  
        // Verify: only the SSE store was reloaded; non-SSE store was never touched  
 */
    }
    private RepositoryMetadata mockMetadata;
    private BlobStoreProvider provider;
    /**
     * The SSE blob store should not be reloaded because it has never been created.
            provider.blobStore(false);  
                    "blob store init timing",  
import org.junit.Before;  
                    "initialized blob store for repository [test-type][test-repository] in [*]"  
    /**
        BlobStore secondResult = provider.blobStore(false);
        // Verify: neither store had reload invoked on it
        when(newMetadata.name()).thenReturn("test-repository");  
        MockitoAnnotations.openMocks(this);
                    Level.INFO,
    public void testReloadBlobStoreOnlyReloadsNonSseStoreWhenOnlyNonSseInitialized() throws Exception {
    public void testInitBlobStoreLogsTimeTakenOnFailure() throws Exception {
        }
        provider.blobStore(false);
        provider.reloadBlobStore(newMetadata);  
    public void testBlobStoreWithClientSideEncryptionEnabledSubsequentCalls() throws Exception {
     */
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);  
        assertEquals(mockBlobStore, secondResult);
        lock = new Object();
        BlobStore firstResult = provider.blobStore(false);
                    "blob store init timing",  
        when(mockLifecycle.started()).thenReturn(true);
        // Test
        // Verify
import static org.mockito.Mockito.never;
        // First call  
    }  
                    BlobStoreProvider.class.getCanonicalName(),
    public void testBlobStoreWithClientSideEncryptionFirstTime() throws Exception {  
    /**
        // Verify: only the non-SSE store was reloaded; SSE store was never touched
        RepositoryMetadata newMetadata = mock(RepositoryMetadata.class);  
                    BlobStoreProvider.class.getCanonicalName(),
        when(mockRepository.createBlobStore()).thenReturn(mockServerSideEncryptionBlobStore);  
    }  
    @Mock
        assertEquals(mockBlobStore, firstResult);
        verify(mockBlobStore, times(1)).reload(newMetadata);
        verify(mockBlobStore, never()).reload(any());
        when(mockMetadata.type()).thenReturn("test-type");
    }
        // Setup  
            appender.assertAllExpectationsMatched();
        BlobStore result = provider.getBlobStore(false);
        assertEquals(mockBlobStore, result);  
        verify(mockBlobStore, never()).reload(any());
        provider.reloadBlobStore(newMetadata);
 * compatible open source license.
        when(mockLifecycle.started()).thenReturn(false);
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore).thenReturn(mockServerSideEncryptionBlobStore);
     * Verifies that only the SSE blob store is reloaded when only it has been initialized.
        when(mockLifecycle.started()).thenReturn(true);  
        when(mockMetadata.name()).thenReturn("test-repository");  
    public void testInitBlobStoreLogsTimeTaken() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                    "initialized blob store for repository [test-type][test-repository] in [*]"  
/*  
                )
     * The non-SSE blob store should not be reloaded because it has never been created.  
 * Test class for {@link BlobStoreProvider}.
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
        verify(mockServerSideEncryptionBlobStore, never()).reload(any());
     */
        // Test
import org.opensearch.common.lifecycle.Lifecycle;
            appender.assertAllExpectationsMatched();
     * Verifies that {@link BlobStoreProvider#reloadBlobStore(RepositoryMetadata)} reloads BOTH the  
    public void testGetBlobStoreWithServerSideEncryption() throws Exception {
        provider.blobStore(true);
        provider.blobStore(true);
        when(mockLifecycle.started()).thenReturn(true);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(BlobStoreProvider.class))) {  
        verify(mockServerSideEncryptionBlobStore, times(1)).reload(newMetadata);  
    private BlobStoreRepository mockRepository;
            );
        // Test  
    public void testReloadBlobStoreReloadsBothStoresWhenBothInitialized() throws Exception {
        when(mockLifecycle.started()).thenReturn(true);  
        expectThrows(RepositoryException.class, () -> provider.initBlobStore());
        RepositoryMetadata newMetadata = mock(RepositoryMetadata.class);
 */  
            );
        // Setup: initialize both non-SSE and SSE blob stores  
        // Verify createServerSideEncryptedBlobStore is called only once
     * Verifies that only the non-SSE blob store is reloaded when only it has been initialized.
import org.apache.logging.log4j.LogManager;
    }
        // Verify both stores were reloaded with the new metadata
        assertEquals(mockBlobStore, result);
    public void testInitBlobStoreWhenLifecycleNotStarted() {
            expectThrows(RepositoryException.class, () -> provider.blobStore(false));  
    public void testGetBlobStore() throws Exception {
        verify(mockRepository, times(1)).createBlobStore();
                )
    public void setUp() throws Exception {
                new MockLogAppender.SeenEventExpectation(
        provider.blobStore(true);  // initializes SSE store
        assertEquals(mockServerSideEncryptionBlobStore, result);  
import org.opensearch.common.blobstore.BlobStore;
        when(mockLifecycle.state()).thenReturn(Lifecycle.State.STOPPED);
     * non-SSE store was reloaded.  
    }
        // Setup: Mock the serverSideEncryptedBlobStore to return a value  
    @Before
        when(newMetadata.name()).thenReturn("test-repository");
        // Setup
        // Setup: initialize only the non-SSE blob store
        when(mockLifecycle.started()).thenReturn(true);  
        // Verify
    private BlobStore mockBlobStore;
    private BlobStore mockServerSideEncryptionBlobStore;
     * Verifies that {@link BlobStoreProvider#reloadBlobStore(RepositoryMetadata)} is a safe no-op  
        }
import org.opensearch.cluster.metadata.RepositoryMetadata;  
/**  
        when(newMetadata.name()).thenReturn("test-repository");
        when(mockLifecycle.started()).thenReturn(true);
        // Setup
        when(mockLifecycle.started()).thenReturn(true);
     * non-SSE and SSE blob stores when both have been initialized. This is the regression test for
        // Verify
    }  
    }  
        // Note: Since SetOnce is used internally, we need to first call blobStore() to initialize it  
        RepositoryMetadata newMetadata = mock(RepositoryMetadata.class);
import org.mockito.MockitoAnnotations;  
     * the bug where SSE-enabled repositories did not pick up updated metadata because only the
import static org.mockito.ArgumentMatchers.any;
        when(mockRepository.createBlobStore()).thenReturn(mockServerSideEncryptionBlobStore);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        assertSame(firstResult, secondResult);  
        RepositoryMetadata newMetadata = mock(RepositoryMetadata.class);
    }  
        // Initialize the server-side encrypted blob store
                    Level.INFO,
    /**  
     * when neither blob store has been initialized yet. This guards against NPEs when reload is
import static org.mockito.Mockito.when;
        verify(mockServerSideEncryptionBlobStore, times(1)).reload(newMetadata);
        when(mockRepository.createBlobStore()).thenThrow(new RuntimeException("blob store creation failed"));
        when(mockMetadata.type()).thenReturn("test-type");
        // Test - should throw RepositoryException
 *
     */  
        // Setup: Mock the serverSideEncryptedBlobStore to return a value
    @Mock
        BlobStore result = provider.blobStore(false);  
        verify(mockBlobStore, times(1)).reload(newMetadata);  
    }
public class BlobStoreProviderTests extends OpenSearchTestCase {  
        provider.blobStore(false); // initializes non-SSE store
        // Setup: initialize only the SSE blob store  
import org.opensearch.repositories.RepositoryException;  
    }
        verify(mockServerSideEncryptionBlobStore, never()).reload(any());  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.MockLogAppender;
            appender.addExpectation(
import org.mockito.Mock;
}
import static org.mockito.Mockito.verify;  
    @Mock
import static org.mockito.Mockito.mock;  
                new MockLogAppender.SeenEventExpectation(
    }  
    private Lifecycle mockLifecycle;
    @Mock
     * triggered before any blob store has been lazily created.
        // Second call  
    private Object lock;
    public void testReloadBlobStoreNoOpWhenNeitherStoreInitialized() {
    @Mock
import static org.mockito.Mockito.times;
        // Test
        when(mockLifecycle.started()).thenReturn(true);
            appender.addExpectation(
        when(mockLifecycle.started()).thenReturn(true);  
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
    public void testReloadBlobStoreOnlyReloadsSseStoreWhenOnlySseInitialized() throws Exception {
        provider.blobStore(false);  
