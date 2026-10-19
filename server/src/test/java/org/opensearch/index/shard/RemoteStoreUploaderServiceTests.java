        Map<String, Long> segmentSizeMap = new HashMap<>();
     * Tests that uploading an empty collection of segments completes successfully
            Collections.singletonList("seg1"),
    }
            null
        @Override
                threadPool,
        doAnswer(invocation -> {
        );
            remoteDataDirectory,
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);
            freshMockShard.getThreadPool(),
    /**
    /** Mock Directory representing the local store directory */
            mock(RemoteStoreLockManager.class),
        CountDownLatch latch = new CountDownLatch(1);
     *
        assertEquals("afterSyncToRemote should be called once", 1, listenerDir.syncCount);
    /**
package org.opensearch.index.shard;
    /**
        ShardId shardId = new ShardId(new Index("test", "test"), 0);
            remoteSegmentStoreDirectory
        Map<String, Long> segmentSizeMap = new HashMap<>();
        // Create a fresh mock IndexShard
    }
        IndexShard freshMockShard = mock(IndexShard.class);
            remoteDirectory,
    static class TrackingSyncListenerDirectory extends FilterDirectory implements RemoteSyncListener {
    }
            ActionListener<Void> callback = invocation.getArgument(5);
        Collection<String> segments = Arrays.asList("segment1");
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
        doAnswer(invocation -> {
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerFilterDirectory));
    private Directory mockStoreDirectory;
            outerFilterDirectory,
        Collection<String> segments = Arrays.asList("segment1");
        assertEquals("seg1", listenerDir.lastFile);
        }
        Collection<String> segments = Arrays.asList("segment1", "segment2");
        RuntimeException genericException = new RuntimeException("Generic error");
            remoteDirectory,
        segmentSizeMap.put("segment1", 100L);
        // Create a fresh mock IndexShard
        // Create a fresh mock IndexShard
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.index.store.RemoteDirectory;
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
            return true;
}
    }
    /**
         * Creates a new TestFilterDirectory wrapping the given directory.
        );
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
     * When no RemoteSyncListener in directory chain, upload still succeeds (no-op notification).
            remoteDirectory,
        CorruptIndexException corruptException = new CorruptIndexException("Index corrupted", "test");
            new HashMap<>()
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            RemoteDirectory remoteMetadataDirectory = mock(RemoteDirectory.class);
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
            RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
            remoteDirectory,
        );
        // Plain FilterDirectory — no RemoteSyncListener
     * @throws Exception if the test fails
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);
    // ═══════════════════════════════════════════════════════════════
    }
        );
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
import java.util.HashMap;
    /**
     * but the upload listener is still notified of the failure.
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.action.ActionListener;
        verify(manualListener).afterSyncToRemote("seg1");
import org.opensearch.core.index.shard.ShardId;
        ActionListener<Void> listener = ActionListener.wrap(
        );
                new HashMap<>()
            mockIndexShard,
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
    /**
import static org.mockito.ArgumentMatchers.eq;
        when(mockShardRouting.primary()).thenReturn(true);
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = createMockRemoteDirectory(remoteDataDirectory);
        ActionListener<Void> listener = ActionListener.wrap(
            freshMockShard.getThreadPool(),
     * addSyncListener with null is a no-op (no NPE).
        CountDownLatch latch = new CountDownLatch(1);
     * and the upload listener is notified of the failure.
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
            outerFilterDirectory,
            mock(RemoteDirectory.class),
        segmentSizeMap.put("segment2", 200L);
        doAnswer(invocation -> {
    }
        mockRemoteDirectory = createMockRemoteDirectory(remoteDataDirectory);
     */
            mock(RemoteStoreLockManager.class),
    public void setUp() throws Exception {
            );
        TestFilterDirectory outerDir = new TestFilterDirectory(new TestFilterDirectory(innerDir));
    /**
     */
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerMockDelegate));
            outerFilterDirectory,
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);
    @Override
        volatile int syncCount = 0;
 * compatible open source license.
        mockUploadListenerFunction = mock(Function.class);
            remoteSegmentStoreDirectory
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
        IndexShard freshMockShard = mock(IndexShard.class);
        );
            freshMockShard.shardId(),
    public void testUploadSegmentsWithGenericException() throws Exception {
            ActionListener.wrap(r -> latch.countDown(), e -> fail("Should not fail")),
        // Create a mock directory structure that matches what the code expects
            ShardId shardId = new ShardId(new Index("test", "test"), 0);
    public void testUploadSegmentsSuccessWithHighPriorityUpload() throws Exception {
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerMockDelegate));
            callback.onFailure(genericException);
        Directory innerMockDelegate = mock(Directory.class);
     */
            Map.of("seg1", 100L),
        TrackingSyncListenerDirectory(Directory in) {
     * without performing any actual upload operations.
        // Create a concrete RemoteSyncListener directory that tracks afterSyncToRemote calls
     * Verifies that the shard is failed with the appropriate error message
        );
            mock(RemoteStoreLockManager.class),
        );
        ActionListener<Void> listener = ActionListener.wrap(
                shardId,
        Directory innerMockDelegate = mock(Directory.class);
 * Test class for {@link RemoteStoreUploaderService}.
    private RemoteSegmentStoreDirectory mockRemoteDirectory;
        testUploaderService.addSyncListener(null);
        ShardId shardId = new ShardId(new Index("test", "test"), 0);
        ShardId shardId = new ShardId(new Index("test", "test"), 0);
            return true;
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    private RemoteStoreUploaderService uploaderService;
     * @return a new RemoteSegmentStoreDirectory instance with mocked dependencies
            Collections.singletonList("seg1"),
    /**
        ShardRouting mockShardRouting = mock(ShardRouting.class);
import java.util.concurrent.TimeUnit;
            freshMockShard,
        // Create a mock directory structure that matches what the code expects
        segmentSizeMap.put("segment1", 100L);
     * This approach is used because RemoteSegmentStoreDirectory is a final class
        );
     *
        doAnswer(invocation -> {
        );
            remoteDataDirectory,
            mock(RemoteDirectory.class),
            freshMockShard.getThreadPool(),
    /** Mock function that creates upload listeners */
            freshMockShard.shardId(),
            response -> latch.countDown(),
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        TestFilterDirectory outerDir = new TestFilterDirectory(new TestFilterDirectory(innerDir));
            ActionListener.wrap(r -> latch.countDown(), e -> fail("Should not fail")),
     * @throws Exception if the test fails
        );
        when(mockUploadListenerFunction.apply(any())).thenReturn(mockUploadListener);
            mock(RemoteDirectory.class),
    public static class TestFilterDirectory extends FilterDirectory {
        Collection<String> segments = Arrays.asList("segment1", "segment2");
        testUploaderService.addSyncListener(manualListener);
        assertTrue(latch.await(1, TimeUnit.SECONDS));
            freshMockShard,
     * after successful upload operations.
 * error handling, and different directory configurations.
                lockManager,
            mock(RemoteDirectory.class),
            callback.onResponse(null);
    public void testAddSyncListenerManually() throws Exception {
    /**
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);
        when(freshMockShard.shardId()).thenReturn(shardId);
import static org.mockito.Mockito.never;
    /**
            mockUploadListenerFunction,
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
import static org.mockito.ArgumentMatchers.any;
        segmentSizeMap.put("segment2", 200L);
        when(mockShardRouting.primary()).thenReturn(true);
     * Tests successful segment upload with low priority upload flag set to true.
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
            ActionListener<Void> callback = invocation.getArgument(5);
            mock(RemoteStoreLockManager.class),
        // Should not throw
            remoteSegmentStoreDirectory
        );
        // Mock IndexShard methods instead of setting private fields
        uploaderService = new RemoteStoreUploaderService(mockIndexShard, mockStoreDirectory, mockRemoteDirectory);
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
/*
        ShardId shardId = new ShardId(new Index("test", "test"), 0);
        CompositeDirectory mockCompositeDirectory = mock(CompositeDirectory.class);
        verify(mockUploadListener, times(2)).beforeUpload(any(String.class));
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
            ActionListener<Void> callback = invocation.getArgument(5);
        );
        segmentSizeMap.put("segment1", 100L);
        testUploaderService.uploadSegments(
            mock(RemoteStoreLockManager.class),
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
     * in tests. This class simply delegates all operations to the wrapped directory.
            freshMockShard,
     * Sets up the test environment before each test method.
        CountDownLatch latch = new CountDownLatch(1);
        verify(mockUploadListener, times(2)).onSuccess(any(String.class));
        ActionListener<Void> listener = ActionListener.wrap(response -> fail("Should not succeed with generic exception"), exception -> {
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
        );
        freshMockShard.shardRouting = mockShardRouting;
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
            outerDir,
            callback.onResponse(null);
        );
    private IndexShard mockIndexShard;
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
        TrackingSyncListenerDirectory listenerDir = new TrackingSyncListenerDirectory(innerMockDelegate);
     */
            callback.onResponse(null);
            exception -> fail("Upload should succeed: " + exception.getMessage())
            mockUploadListenerFunction,
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
    /** The service under test */
        verify(mockUploadListener).onFailure("segment1");
         *
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);
            freshMockShard,
     * Verifies that segments are uploaded correctly and upload listeners are notified.
        freshMockShard.shardRouting = mockShardRouting;
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
        CountDownLatch latch = new CountDownLatch(1);
        // Create a new uploader service with the fresh mocks
import org.apache.lucene.store.FilterDirectory;
            mock(RemoteDirectory.class),
        // Verify the upload listener was called correctly
import java.util.concurrent.CountDownLatch;
            ActionListener.wrap(r -> latch.countDown(), e -> fail("Should not fail")),
                remoteDataDirectory,
import static org.mockito.Mockito.verify;
        );
     */
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
            mock(RemoteStoreLockManager.class),
            mock(RemoteDirectory.class),
        // Create a new uploader service with the fresh mocks
        IndexShard freshMockShard = mock(IndexShard.class);
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
    /** Mock upload listener for tracking upload events */
import org.opensearch.index.store.RemoteSyncListener;
        CountDownLatch latch = new CountDownLatch(1);
            false,
        );
        // Create a mock ShardRouting and set it as a field on the IndexShard mock
        // Use a real instance with mocked dependencies instead of mocking the final class
            freshMockShard.getThreadPool(),
     * addSyncListener allows manually adding extra listeners beyond auto-discovery.
        // Verify the upload listener was called correctly
            mock(RemoteDirectory.class),
     *
import org.apache.lucene.store.Directory;
     * @throws Exception if the test fails
            freshMockShard.shardId(),
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);
            null
        verify(mockUploadListener).onFailure("segment1");
        // Create a fresh mock IndexShard
    /**
            freshMockShard.shardId(),
import static org.mockito.Mockito.doAnswer;
            return true;
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
            response -> latch.countDown(),
            ActionListener<Void> callback = invocation.getArgument(5);
        );
        public TestFilterDirectory(Directory in) {
        CountDownLatch latch = new CountDownLatch(1);
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
        testUploaderService.uploadSegments(
     * Tests successful segment upload with low priority upload flag set to false.
        });
 * this file be licensed under the Apache-2.0 license or a
     * Tests segment upload functionality when using a CompositeDirectory.
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
        IndexShard freshMockShard = mock(IndexShard.class);
            freshMockShard.shardId(),
            null
            remoteSegmentStoreDirectory
     * instead of trying to mock the final class directly.
        Directory innerMockDelegate = mock(Directory.class);
            latch.countDown();
import org.opensearch.cluster.routing.ShardRouting;
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
        );
            new HashMap<>()
     * that cannot be mocked directly.
        mockUploadListener = mock(UploadListener.class);
import org.apache.lucene.index.CorruptIndexException;
     *
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
        // No exception = pass. No listener to call.
import static org.mockito.Mockito.mock;
 *
        CountDownLatch latch = new CountDownLatch(1);
        }).when(remoteDataDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
        TestFilterDirectory outerDir = new TestFilterDirectory(listenerDir);
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
            callback.onResponse(null);
public class RemoteStoreUploaderServiceTests extends OpenSearchTestCase {
    }
            callback.onResponse(null);
    /**
            Collections.singletonList("seg1"),
     * Uploader auto-discovers RemoteSyncListener from directory chain at construction time.
            return true;
     */
 */
     *
        }
            outerDir,
 * SPDX-License-Identifier: Apache-2.0
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        when(freshMockShard.shardId()).thenReturn(shardId);
            ActionListener<Void> callback = invocation.getArgument(5);
        mockIndexShard = mock(IndexShard.class);
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            mock(RemoteStoreLockManager.class),
        verify(mockCompositeDirectory).afterSyncToRemote("segment1");
import java.io.IOException;
            outerFilterDirectory,
     * @throws Exception if the test fails
    }
            new HashMap<>()
        volatile String lastFile = null;
            exception -> fail("Should not fail for empty segments")
    }
            mock(Directory.class),
        Map<String, Long> segmentSizeMap = new HashMap<>();
            return true;
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);
            new HashMap<>()
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, true, null);
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerMockDelegate));
            response -> latch.countDown(),
    }
     * Concrete FilterDirectory that implements RemoteSyncListener and tracks calls.
        when(freshMockShard.shardId()).thenReturn(shardId);
    private UploadListener mockUploadListener;
import org.opensearch.common.util.UploadListener;
        public void afterSyncToRemote(String file) {
        verify(mockUploadListener, times(2)).beforeUpload(any(String.class));
 */
            return true;
        );
     *
            freshMockShard.shardId(),
            freshMockShard.getThreadPool(),
            ActionListener<Void> callback = invocation.getArgument(5);
        doAnswer(invocation -> {
        }).when(remoteDataDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
            latch.countDown();
        );
        Map<String, Long> segmentSizeMap = new HashMap<>();
            remoteSegmentStoreDirectory
     * @param remoteDirectory the remote directory to use (currently unused)
        CountDownLatch latch = new CountDownLatch(1);
        }
     * Creates a real RemoteSegmentStoreDirectory instance with mocked dependencies
            freshMockShard.getThreadPool(),
            super(in);
        Directory innerDir = mock(Directory.class);
    public void testUploadSegmentsWithEmptyCollection() throws Exception {
            new HashMap<>()
    public void testUploadSegmentsWithCompositeDirectory() throws Exception {
        uploaderService.uploadSegments(emptySegments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);
            Map.of("seg1", 100L),
            RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);
        Directory innerDir = mock(Directory.class);
            ActionListener<Void> callback = invocation.getArgument(5);
import java.util.Collection;
     * Tests error handling when a CorruptIndexException occurs during segment upload.
    }
            false,
                remoteMetadataDirectory,
    }
        segmentSizeMap.put("segment1", 100L);
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerFilterDirectory));
     * Initializes all mock objects and the service under test.
            callback.onFailure(corruptException);
import java.util.function.Function;
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
     * Verifies that the shard is NOT failed (unlike CorruptIndexException)
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            outerFilterDirectory,
        // Create a mock ShardRouting and set it as a field on the IndexShard mock
import static org.mockito.Mockito.times;
         */
        /**
    // RemoteSyncListener registration tests
        Directory innerMockDelegate = mock(Directory.class);
            ActionListener<Void> callback = invocation.getArgument(5);
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
            remoteSegmentStoreDirectory
            freshMockShard.shardId(),
        }).when(remoteDataDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
    public void testUploadSegmentsWithCorruptIndexException() throws Exception {
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
     */
    public void testNoSyncListenerInChainStillWorks() throws Exception {
     */
            remoteDataDirectory,
        when(freshMockShard.shardId()).thenReturn(shardId);
        ActionListener<Void> listener = ActionListener.wrap(
        RemoteSyncListener manualListener = mock(RemoteSyncListener.class);
     */
     * Verifies that segments are uploaded correctly and upload listeners are notified.
    public void testUploadSegmentsSuccessWithLowPriorityUpload() throws Exception {
            lastFile = file;
        when(mockIndexShard.shardId()).thenReturn(shardId);
            new HashMap<>()
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
     */
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
        IndexShard freshMockShard = mock(IndexShard.class);
            mock(RemoteStoreLockManager.class),
     */
            freshMockShard,
        when(freshMockShard.shardId()).thenReturn(shardId);
        testUploaderService.uploadSegments(
            outerDir,
        });
        when(freshMockShard.shardId()).thenReturn(shardId);
import java.util.Arrays;
    /** Mock RemoteSegmentStoreDirectory for remote storage operations */
        IndexShard freshMockShard = mock(IndexShard.class);
            exception -> fail("Upload should succeed: " + exception.getMessage())
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);
    public void testAddSyncListenerNullIsNoOp() throws Exception {
            freshMockShard,
        mockStoreDirectory = mock(FilterDirectory.class);
            exception -> fail("Upload should succeed: " + exception.getMessage())
     */
     * @throws Exception if the test fails
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
            freshMockShard,
        when(mockShardRouting.primary()).thenReturn(true);
     * @throws Exception if setup fails
            freshMockShard,
            return true;
            return true;
        ShardRouting mockShardRouting = mock(ShardRouting.class);
        super.setUp();
    private Function<Map<String, Long>, UploadListener> mockUploadListenerFunction;
        Map<String, Long> segmentSizeMap = new HashMap<>();
        // Create a mock ShardRouting and set it as a field on the IndexShard mock
        IndexShard freshMockShard = mock(IndexShard.class);
        Map<String, Long> segmentSizeMap = new HashMap<>();
        freshMockShard.shardRouting = mockShardRouting;
     */
        doAnswer(invocation -> {
            Map.of("seg1", 100L),
        // Create a new uploader service with the fresh mocks
        IndexShard freshMockShard = mock(IndexShard.class);
    // ═══════════════════════════════════════════════════════════════
        when(freshMockShard.shardId()).thenReturn(shardId);
        verify(mockUploadListener, times(2)).onSuccess(any(String.class));
        // Create a new uploader service with the fresh mocks
        ActionListener<Void> listener = ActionListener.wrap(response -> fail("Should not succeed with corrupt index"), exception -> {
        );
     * Test implementation of FilterDirectory used for creating nested directory structures
import java.util.Map;
     */
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(innerFilterDirectory);
            false,
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(mockCompositeDirectory);
        // Create a new uploader service with the fresh mocks
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
            syncCount++;
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerFilterDirectory));
        try {
            freshMockShard.shardId(),
     * Tests error handling when a generic RuntimeException occurs during segment upload.
/**
 * The OpenSearch Contributors require contributions made to
            ThreadPool threadPool = mock(ThreadPool.class);
        when(freshMockShard.shardId()).thenReturn(shardId);
     *
        Collection<String> segments = Arrays.asList("segment1");
            new HashMap<>()
            callback.onResponse(null);
    public void testSyncListenerAutoRegisteredFromDirectoryChain() throws Exception {
        verify(freshMockShard, never()).failShard(any(), any());
        Collection<String> emptySegments = Collections.emptyList();
            new HashMap<>()
        verify(freshMockShard).failShard(eq("Index corrupted (resource=test)"), eq(corruptException));
            remoteSegmentStoreDirectory
            remoteSegmentStoreDirectory
    /**
            assertEquals(corruptException, exception);
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
     * Verifies that the afterSyncToRemote callback is invoked on the CompositeDirectory
        doAnswer(invocation -> {
            mockUploadListenerFunction,
import java.util.Collections;
        ShardRouting mockShardRouting = mock(ShardRouting.class);
            assertEquals(genericException, exception);
        }
 * Tests various scenarios of segment upload functionality including success cases,
    private RemoteSegmentStoreDirectory createMockRemoteDirectory(RemoteDirectory remoteDirectory) {
import org.opensearch.core.index.Index;
        Directory innerMockDelegate = mock(Directory.class);
    /** Mock IndexShard instance used across tests */
            super(in);
            response -> latch.countDown(),
            freshMockShard.getThreadPool(),
    }
         * @param in the directory to wrap
import static org.mockito.Mockito.when;
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerMockDelegate));
            remoteSegmentStoreDirectory
        } catch (IOException e) {
            remoteDirectory,
import org.opensearch.index.store.CompositeDirectory;
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
    /**
     *
        );
        // Create a fresh mock IndexShard
            return new RemoteSegmentStoreDirectory(
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
        doAnswer(invocation -> {
     * @throws RuntimeException if the directory creation fails
    }
        );
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerFilterDirectory));
            mock(RemoteDirectory.class),
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
        segmentSizeMap.put("segment1", 100L);
     * @throws Exception if the test fails
            freshMockShard.getThreadPool(),
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            throw new RuntimeException("Failed to create mock RemoteSegmentStoreDirectory", e);
