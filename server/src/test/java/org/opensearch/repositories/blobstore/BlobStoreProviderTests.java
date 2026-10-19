import org.opensearch.test.OpenSearchTestCase;
        verify(mockBlobStore, never()).reload(any());
    }
        // Second call
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(BlobStoreProvider.class))) {
    public void setUp() throws Exception {
    public void testInitBlobStoreWhenLifecycleNotStarted() {
        when(mockLifecycle.started()).thenReturn(false);
        provider.blobStore(true);
    @Mock
        BlobStore secondResult = provider.blobStore(false);
     * Verifies that only the non-SSE blob store is reloaded when only it has been initialized.
        // Verify
    private BlobStore mockBlobStore;
    @Before
        // Verify: neither store had reload invoked on it
    public void testReloadBlobStoreOnlyReloadsSseStoreWhenOnlySseInitialized() throws Exception {
import org.opensearch.test.MockLogAppender;
import static org.mockito.ArgumentMatchers.any;
        expectThrows(RepositoryException.class, () -> provider.initBlobStore());
        // Setup: initialize only the SSE blob store
                    "initialized blob store for repository [test-type][test-repository] in [*]"
        provider.reloadBlobStore(newMetadata);
        when(mockLifecycle.state()).thenReturn(Lifecycle.State.STOPPED);
        assertEquals(mockServerSideEncryptionBlobStore, result);
        // Setup: Mock the serverSideEncryptedBlobStore to return a value
        provider.reloadBlobStore(newMetadata);
        // Setup: initialize only the non-SSE blob store
        verify(mockRepository).createBlobStore();
import org.apache.logging.log4j.Level;
    /**
     */
import org.opensearch.common.blobstore.BlobStore;
    }
        provider.reloadBlobStore(newMetadata);
    @Mock
     * when neither blob store has been initialized yet. This guards against NPEs when reload is
        // Test - should not throw
public class BlobStoreProviderTests extends OpenSearchTestCase {
        provider.blobStore(false);
import org.opensearch.common.lifecycle.Lifecycle;
        RepositoryMetadata newMetadata = mock(RepositoryMetadata.class);
        // Setup
        verify(mockBlobStore, times(1)).reload(newMetadata);
        verify(mockServerSideEncryptionBlobStore, never()).reload(any());
            appender.assertAllExpectationsMatched();
        verify(mockBlobStore, never()).reload(any());
    public void testGetBlobStoreWithServerSideEncryption() throws Exception {
     * The SSE blob store should not be reloaded because it has never been created.
        MockitoAnnotations.openMocks(this);
     * Verifies that only the SSE blob store is reloaded when only it has been initialized.
    }
 */
                    "blob store init timing",
            );
import org.apache.logging.log4j.LogManager;
        verify(mockServerSideEncryptionBlobStore, times(1)).reload(newMetadata);
        provider = new BlobStoreProvider(mockRepository, mockMetadata, mockLifecycle, lock);
        BlobStore firstResult = provider.blobStore(false);
        // Verify createServerSideEncryptedBlobStore is called only once
    private Lifecycle mockLifecycle;
    public void testGetBlobStore() throws Exception {
                new MockLogAppender.SeenEventExpectation(
    public void testBlobStoreWithClientSideEncryptionFirstTime() throws Exception {
    private RepositoryMetadata mockMetadata;
    /**
        assertEquals(mockBlobStore, firstResult);
        // Verify: only the non-SSE store was reloaded; SSE store was never touched
        when(newMetadata.name()).thenReturn("test-repository");
        // First call
                new MockLogAppender.SeenEventExpectation(
        when(mockLifecycle.started()).thenReturn(true);
        when(mockRepository.createBlobStore()).thenReturn(mockServerSideEncryptionBlobStore);
        // Verify
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(mockBlobStore, result);
                )
     */
import static org.mockito.Mockito.when;
        // Setup: Mock the serverSideEncryptedBlobStore to return a value
        provider.blobStore(true);
        when(mockRepository.createBlobStore()).thenThrow(new RuntimeException("blob store creation failed"));
        RepositoryMetadata newMetadata = mock(RepositoryMetadata.class);
        assertEquals(mockBlobStore, result);
    }
    @Mock
        // Test
    public void testInitBlobStoreLogsTimeTaken() throws Exception {
import org.opensearch.cluster.metadata.RepositoryMetadata;
    @Mock
                    BlobStoreProvider.class.getCanonicalName(),
 *
     */
        // Verify: only the SSE store was reloaded; non-SSE store was never touched
    }
        BlobStore result = provider.getBlobStore(false);
                )
    }
        when(newMetadata.name()).thenReturn("test-repository");
        verify(mockBlobStore, times(1)).reload(newMetadata);
        when(mockRepository.createBlobStore()).thenReturn(mockServerSideEncryptionBlobStore);
     * triggered before any blob store has been lazily created.
        when(newMetadata.name()).thenReturn("test-repository");
        // Test
    }
    /**
        RepositoryMetadata newMetadata = mock(RepositoryMetadata.class);
                    BlobStoreProvider.class.getCanonicalName(),
        verify(mockServerSideEncryptionBlobStore, times(1)).reload(newMetadata);
        // Note: Since SetOnce is used internally, we need to first call blobStore() to initialize it
    public void testReloadBlobStoreNoOpWhenNeitherStoreInitialized() {
        verify(mockServerSideEncryptionBlobStore, never()).reload(any());
        when(mockMetadata.type()).thenReturn("test-type");
    }
 * SPDX-License-Identifier: Apache-2.0
        // Setup: initialize both non-SSE and SSE blob stores
        super.setUp();
    }
    private BlobStoreProvider provider;
        when(mockLifecycle.started()).thenReturn(true);
    public void testReloadBlobStoreReloadsBothStoresWhenBothInitialized() throws Exception {
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
    }
 * Test class for {@link BlobStoreProvider}.
        when(mockLifecycle.started()).thenReturn(true);
        provider.blobStore(false); // initializes non-SSE store
            );
     * non-SSE and SSE blob stores when both have been initialized. This is the regression test for
}
import static org.mockito.Mockito.mock;
        verify(mockRepository, times(1)).createBlobStore();
        // Test - should throw RepositoryException
        when(mockLifecycle.started()).thenReturn(true);
import org.junit.Before;
        provider.reloadBlobStore(newMetadata);
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore).thenReturn(mockServerSideEncryptionBlobStore);
    private BlobStoreRepository mockRepository;
        when(mockLifecycle.started()).thenReturn(true);
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
        // Test
                    "blob store init timing",
        // Setup
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
 * The OpenSearch Contributors require contributions made to
    }
        // Verify
        when(mockLifecycle.started()).thenReturn(true);
import org.mockito.MockitoAnnotations;
        when(mockLifecycle.started()).thenReturn(true);
    private Object lock;
        assertEquals(mockBlobStore, secondResult);
            expectThrows(RepositoryException.class, () -> provider.blobStore(false));
     * Verifies that {@link BlobStoreProvider#reloadBlobStore(RepositoryMetadata)} is a safe no-op
package org.opensearch.repositories.blobstore;
import org.mockito.Mock;
        // Test
    public void testBlobStoreWithClientSideEncryptionEnabledSubsequentCalls() throws Exception {
                    Level.INFO,
        // Initialize the server-side encrypted blob store
        }
        when(mockLifecycle.started()).thenReturn(true);
        RepositoryMetadata newMetadata = mock(RepositoryMetadata.class);
        assertSame(firstResult, secondResult);
    private BlobStore mockServerSideEncryptionBlobStore;
        }
 * compatible open source license.
        when(mockMetadata.type()).thenReturn("test-type");
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
    public void testReloadBlobStoreOnlyReloadsNonSseStoreWhenOnlyNonSseInitialized() throws Exception {
/*
        provider.blobStore(true);  // initializes SSE store
            appender.addExpectation(
        provider.blobStore(false);
        when(mockRepository.createBlobStore()).thenReturn(mockBlobStore);
            appender.addExpectation(
import org.opensearch.repositories.RepositoryException;
     * The non-SSE blob store should not be reloaded because it has never been created.
import static org.mockito.Mockito.times;
 */
        // Note: Since SetOnce is used internally, we need to first call blobStore() to initialize it
        when(mockMetadata.name()).thenReturn("test-repository");
     * the bug where SSE-enabled repositories did not pick up updated metadata because only the
                    Level.INFO,
     * Verifies that {@link BlobStoreProvider#reloadBlobStore(RepositoryMetadata)} reloads BOTH the
import static org.mockito.Mockito.never;
        // Test
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(BlobStoreProvider.class))) {
        // Setup
        // Verify both stores were reloaded with the new metadata
    /**
/**
    }
                    "initialized blob store for repository [test-type][test-repository] in [*]"
        // Verify
    @Mock
        BlobStore result = provider.blobStore(false);
        when(mockLifecycle.started()).thenReturn(true);
    public void testInitBlobStoreLogsTimeTakenOnFailure() throws Exception {
     * non-SSE store was reloaded.
import static org.mockito.Mockito.verify;
     */
            provider.blobStore(false);
        lock = new Object();
        BlobStore result = provider.getBlobStore(true);
            appender.assertAllExpectationsMatched();
