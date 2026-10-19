        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
            freshMockShard.shardId(),  
        Map<String, Long> segmentSizeMap = new HashMap<>();  
     * Initializes all mock objects and the service under test.  
            freshMockShard.getThreadPool(),  
        public TestFilterDirectory(Directory in) {
    /**
            mockUploadListenerFunction,
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
            new HashMap<>()
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
import java.util.concurrent.CountDownLatch;
    /**
        CountDownLatch latch = new CountDownLatch(1);
        doAnswer(invocation -> {
            mock(RemoteStoreLockManager.class),
 * Test class for {@link RemoteStoreUploaderService}.
            exception -> fail("Should not fail for empty segments")  
        );  
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, true, null);  
        ActionListener<Void> listener = ActionListener.wrap(
     * instead of trying to mock the final class directly.  
            mock(RemoteDirectory.class),
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
     *
        TrackingSyncListenerDirectory(Directory in) {  
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);
        // Mock IndexShard methods instead of setting private fields
        // Create a mock directory structure that matches what the code expects
        // Create a fresh mock IndexShard
        mockIndexShard = mock(IndexShard.class);
            mock(RemoteDirectory.class),  
        CountDownLatch latch = new CountDownLatch(1);
    public void testUploadSegmentsSuccessWithLowPriorityUpload() throws Exception {
     * Creates a real RemoteSegmentStoreDirectory instance with mocked dependencies
        volatile String lastFile = null;
    }
 * this file be licensed under the Apache-2.0 license or a
            latch.countDown();
            mock(RemoteStoreLockManager.class),
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);  
    }  
            freshMockShard.shardId(),  
        verify(mockUploadListener, times(2)).beforeUpload(any(String.class));
     * @throws Exception if the test fails  
    /**
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
     */
    /**  
 */  
            throw new RuntimeException("Failed to create mock RemoteSegmentStoreDirectory", e);
        freshMockShard.shardRouting = mockShardRouting;  
        ShardId shardId = new ShardId(new Index("test", "test"), 0);
    /** Mock upload listener for tracking upload events */
        volatile int syncCount = 0;  
        ShardRouting mockShardRouting = mock(ShardRouting.class);
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);  
            freshMockShard,
    /**
            ShardId shardId = new ShardId(new Index("test", "test"), 0);
            outerFilterDirectory,
            remoteSegmentStoreDirectory
            assertEquals(corruptException, exception);  
    /** Mock Directory representing the local store directory */
        verify(mockCompositeDirectory).afterSyncToRemote("segment1");  
        } catch (IOException e) {  
    /** Mock IndexShard instance used across tests */
            freshMockShard.shardId(),
        Collection<String> segments = Arrays.asList("segment1", "segment2");  
            callback.onResponse(null);
 * Tests various scenarios of segment upload functionality including success cases,
/**  
     *
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);
    public void testSyncListenerAutoRegisteredFromDirectoryChain() throws Exception {
     */
            freshMockShard.getThreadPool(),
            mock(RemoteStoreLockManager.class),
            remoteDirectory,
            mock(RemoteDirectory.class),
     * Tests error handling when a CorruptIndexException occurs during segment upload.
     * Uploader auto-discovers RemoteSyncListener from directory chain at construction time.  
    }
 * SPDX-License-Identifier: Apache-2.0
            ActionListener<Void> callback = invocation.getArgument(5);
            freshMockShard,  
        when(mockShardRouting.primary()).thenReturn(true);
    public void testAddSyncListenerNullIsNoOp() throws Exception {  
            return true;
import org.opensearch.core.action.ActionListener;  
        segmentSizeMap.put("segment2", 200L);  
            mock(RemoteDirectory.class),  
            exception -> fail("Upload should succeed: " + exception.getMessage())  
        );
            RemoteDirectory remoteMetadataDirectory = mock(RemoteDirectory.class);
import static org.mockito.ArgumentMatchers.eq;
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
        mockUploadListener = mock(UploadListener.class);
import org.opensearch.common.util.UploadListener;
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
     * @throws Exception if the test fails
        // Use a real instance with mocked dependencies instead of mocking the final class
            false,
        );
            mock(RemoteDirectory.class),
        segmentSizeMap.put("segment1", 100L);  
            ActionListener<Void> callback = invocation.getArgument(5);  
import org.opensearch.threadpool.ThreadPool;  
            freshMockShard.getThreadPool(),  
        );  
        mockRemoteDirectory = createMockRemoteDirectory(remoteDataDirectory);
            freshMockShard.shardId(),
     *
        TestFilterDirectory outerDir = new TestFilterDirectory(new TestFilterDirectory(innerDir));
        Collection<String> segments = Arrays.asList("segment1", "segment2");  
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
        );
import static org.mockito.Mockito.doAnswer;
            ActionListener<Void> callback = invocation.getArgument(5);  
            callback.onResponse(null);
            mock(RemoteDirectory.class),  
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);
        TrackingSyncListenerDirectory listenerDir = new TrackingSyncListenerDirectory(innerMockDelegate);
        ShardId shardId = new ShardId(new Index("test", "test"), 0);
        when(freshMockShard.shardId()).thenReturn(shardId);
        // No exception = pass. No listener to call.  
        Collection<String> segments = Arrays.asList("segment1");
            mock(RemoteStoreLockManager.class),
        when(freshMockShard.shardId()).thenReturn(shardId);
    /**
        IndexShard freshMockShard = mock(IndexShard.class);  
            ActionListener<Void> callback = invocation.getArgument(5);
        doAnswer(invocation -> {
        testUploaderService.addSyncListener(null);
        );
            freshMockShard.getThreadPool(),
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerMockDelegate));
    private IndexShard mockIndexShard;
        );  
        // Create a fresh mock IndexShard
            new HashMap<>()
            mock(RemoteStoreLockManager.class),
        });  
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        // Create a concrete RemoteSyncListener directory that tracks afterSyncToRemote calls
        }).when(remoteDataDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());  
     */
     * Tests successful segment upload with low priority upload flag set to false.  
            return true;  
            ActionListener.wrap(r -> latch.countDown(), e -> fail("Should not fail")),  
    static class TrackingSyncListenerDirectory extends FilterDirectory implements RemoteSyncListener {
            outerFilterDirectory,
    private Directory mockStoreDirectory;
     * Tests error handling when a generic RuntimeException occurs during segment upload.  
        segmentSizeMap.put("segment1", 100L);
        doAnswer(invocation -> {
        Map<String, Long> segmentSizeMap = new HashMap<>();
import org.apache.lucene.index.CorruptIndexException;
            mockIndexShard,
     */  
import java.io.IOException;
import static org.mockito.Mockito.verify;  
            false,
        );  
            mock(RemoteStoreLockManager.class),
        CorruptIndexException corruptException = new CorruptIndexException("Index corrupted", "test");  
public class RemoteStoreUploaderServiceTests extends OpenSearchTestCase {
            new HashMap<>()
    public void testUploadSegmentsWithEmptyCollection() throws Exception {
    }
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerFilterDirectory));  
        RemoteSyncListener manualListener = mock(RemoteSyncListener.class);
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        );
            response -> latch.countDown(),
    private RemoteSegmentStoreDirectory mockRemoteDirectory;
            return new RemoteSegmentStoreDirectory(
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
        );
    private UploadListener mockUploadListener;
            ActionListener<Void> callback = invocation.getArgument(5);  
            freshMockShard,  
            super(in);
            outerDir,  
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
        freshMockShard.shardRouting = mockShardRouting;  
        verify(mockUploadListener).onFailure("segment1");  
        segmentSizeMap.put("segment1", 100L);
            outerFilterDirectory,  
        verify(mockUploadListener, times(2)).onSuccess(any(String.class));
     * @throws Exception if the test fails  
     */  
     */
            remoteSegmentStoreDirectory
 * error handling, and different directory configurations.  
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
            Map.of("seg1", 100L),
            return true;
            false,
            ActionListener<Void> callback = invocation.getArgument(5);  
            new HashMap<>()
    public void testUploadSegmentsWithGenericException() throws Exception {  
        when(freshMockShard.shardId()).thenReturn(shardId);  
    public void testUploadSegmentsSuccessWithHighPriorityUpload() throws Exception {
     */
        Directory innerMockDelegate = mock(Directory.class);
        IndexShard freshMockShard = mock(IndexShard.class);  
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerFilterDirectory));
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);  
    /**
            freshMockShard.shardId(),  
    public void testNoSyncListenerInChainStillWorks() throws Exception {
import static org.mockito.Mockito.when;
            mock(Directory.class),  
        // Create a new uploader service with the fresh mocks  
                new HashMap<>()
        verify(freshMockShard).failShard(eq("Index corrupted (resource=test)"), eq(corruptException));
            ThreadPool threadPool = mock(ThreadPool.class);
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);  
            Map.of("seg1", 100L),
        );
                remoteMetadataDirectory,  
                remoteDataDirectory,
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);  
        when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);  
        verify(mockUploadListener, times(2)).onSuccess(any(String.class));
        assertEquals("afterSyncToRemote should be called once", 1, listenerDir.syncCount);
        // Create a mock ShardRouting and set it as a field on the IndexShard mock
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
        when(freshMockShard.shardId()).thenReturn(shardId);
     * but the upload listener is still notified of the failure.
     * @param remoteDirectory the remote directory to use (currently unused)
    /** The service under test */
package org.opensearch.index.shard;
import static org.mockito.ArgumentMatchers.any;  
        });
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
        Map<String, Long> segmentSizeMap = new HashMap<>();
        Directory innerMockDelegate = mock(Directory.class);  
import java.util.HashMap;  
        // Create a new uploader service with the fresh mocks
        );
            Collections.singletonList("seg1"),  
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
                lockManager,
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerFilterDirectory));  
        uploaderService = new RemoteStoreUploaderService(mockIndexShard, mockStoreDirectory, mockRemoteDirectory);
            new HashMap<>()  
    @Override
            mock(RemoteDirectory.class),  
            null  
     * Verifies that segments are uploaded correctly and upload listeners are notified.
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());  
        super.setUp();  
        verify(manualListener).afterSyncToRemote("seg1");  
        // Create a new uploader service with the fresh mocks
    /** Mock function that creates upload listeners */
            remoteSegmentStoreDirectory
        );
    /**
     * @throws Exception if setup fails
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
        public void afterSyncToRemote(String file) {
        CountDownLatch latch = new CountDownLatch(1);
            remoteSegmentStoreDirectory
        // Create a mock ShardRouting and set it as a field on the IndexShard mock
     * addSyncListener with null is a no-op (no NPE).
import org.apache.lucene.store.Directory;
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            ActionListener<Void> callback = invocation.getArgument(5);
        ShardRouting mockShardRouting = mock(ShardRouting.class);  
import static org.mockito.Mockito.never;
            );
        RuntimeException genericException = new RuntimeException("Generic error");
    }
     */
        doAnswer(invocation -> {
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());  
     * in tests. This class simply delegates all operations to the wrapped directory.
            ActionListener.wrap(r -> latch.countDown(), e -> fail("Should not fail")),
import org.apache.lucene.store.FilterDirectory;  
            return true;
            freshMockShard,
        );
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerMockDelegate));
         */
        IndexShard freshMockShard = mock(IndexShard.class);  
     * Sets up the test environment before each test method.
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(  
        mockStoreDirectory = mock(FilterDirectory.class);
    }  
        when(mockUploadListenerFunction.apply(any())).thenReturn(mockUploadListener);
        testUploaderService.uploadSegments(  
            ActionListener.wrap(r -> latch.countDown(), e -> fail("Should not fail")),
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
     * that cannot be mocked directly.
            RemoteStoreLockManager lockManager = mock(RemoteStoreLockManager.class);  
            response -> latch.countDown(),
            remoteDirectory,
            freshMockShard,  
            lastFile = file;
        Map<String, Long> segmentSizeMap = new HashMap<>();
            freshMockShard,
            new HashMap<>()
        when(freshMockShard.shardId()).thenReturn(shardId);
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());  
        Directory innerDir = mock(Directory.class);  
        Collection<String> segments = Arrays.asList("segment1");
        verify(freshMockShard, never()).failShard(any(), any());
            response -> latch.countDown(),
        segmentSizeMap.put("segment1", 100L);
            mockUploadListenerFunction,  
        /**  
        CountDownLatch latch = new CountDownLatch(1);
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);  
            remoteDirectory,
        Directory innerMockDelegate = mock(Directory.class);  
    // ═══════════════════════════════════════════════════════════════  
     */
            syncCount++;  
    /**
        // Plain FilterDirectory — no RemoteSyncListener
    /**  
     */
        when(mockShardRouting.primary()).thenReturn(true);
import static org.mockito.Mockito.times;
    }  
        // Create a new uploader service with the fresh mocks
 */
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = createMockRemoteDirectory(remoteDataDirectory);
        testUploaderService.uploadSegments(
        ActionListener<Void> listener = ActionListener.wrap(response -> fail("Should not succeed with generic exception"), exception -> {  
            new HashMap<>()
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
    /**
            return true;
import static org.mockito.Mockito.mock;  
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerMockDelegate));
        );
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        testUploaderService.addSyncListener(manualListener);
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
        segmentSizeMap.put("segment2", 200L);  
        // Create a mock directory structure that matches what the code expects
     * @throws Exception if the test fails
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
        CountDownLatch latch = new CountDownLatch(1);  
     */
import org.opensearch.index.store.RemoteDirectory;
import java.util.concurrent.TimeUnit;  
 * The OpenSearch Contributors require contributions made to  
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(  
            remoteSegmentStoreDirectory
    private RemoteSegmentStoreDirectory createMockRemoteDirectory(RemoteDirectory remoteDirectory) {
        }
     * @throws RuntimeException if the directory creation fails  
            return true;
    public void setUp() throws Exception {
     * This approach is used because RemoteSegmentStoreDirectory is a final class
            callback.onResponse(null);
    /**  
        Directory innerDir = mock(Directory.class);  
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls  
    public void testAddSyncListenerManually() throws Exception {  
     */  
     * Tests successful segment upload with low priority upload flag set to true.  
    private RemoteStoreUploaderService uploaderService;
        // Verify the upload listener was called correctly  
    }  
        IndexShard freshMockShard = mock(IndexShard.class);  
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);  
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls  
            return true;
            response -> latch.countDown(),
        when(mockShardRouting.primary()).thenReturn(true);
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        Directory innerMockDelegate = mock(Directory.class);  
            freshMockShard.shardId(),  
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        ShardRouting mockShardRouting = mock(ShardRouting.class);
        );  
     * without performing any actual upload operations.
 *
     * after successful upload operations.
            null
        CountDownLatch latch = new CountDownLatch(1);
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);  
 * compatible open source license.
     * Tests segment upload functionality when using a CompositeDirectory.  
        verify(mockUploadListener).onFailure("segment1");
        );  
            outerFilterDirectory,
     * @throws Exception if the test fails
    }  
        ShardId shardId = new ShardId(new Index("test", "test"), 0);
import java.util.Map;
     */
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
        verify(mockUploadListener, times(2)).beforeUpload(any(String.class));
    /**  
            super(in);  
    private Function<Map<String, Long>, UploadListener> mockUploadListenerFunction;
     * @throws Exception if the test fails  
            remoteDataDirectory,
            remoteDataDirectory,
            remoteSegmentStoreDirectory  
        );
        segmentSizeMap.put("segment1", 100L);  
        CompositeDirectory mockCompositeDirectory = mock(CompositeDirectory.class);  
            RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
            ActionListener<Void> callback = invocation.getArgument(5);  
     *  
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerMockDelegate));
        mockUploadListenerFunction = mock(Function.class);  
            mock(RemoteDirectory.class),  
         * Creates a new TestFilterDirectory wrapping the given directory.
            outerFilterDirectory,
        doAnswer(invocation -> {
     * @return a new RemoteSegmentStoreDirectory instance with mocked dependencies
     * Verifies that segments are uploaded correctly and upload listeners are notified.
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(innerFilterDirectory);
        IndexShard freshMockShard = mock(IndexShard.class);
import java.util.Collections;
            Map.of("seg1", 100L),
import org.opensearch.test.OpenSearchTestCase;
            Collections.singletonList("seg1"),
        IndexShard freshMockShard = mock(IndexShard.class);
    }  
            freshMockShard.getThreadPool(),
            callback.onResponse(null);  
            outerDir,
     * and the upload listener is notified of the failure.  
import org.opensearch.cluster.routing.ShardRouting;
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);  
            return true;
     * addSyncListener allows manually adding extra listeners beyond auto-discovery.
            mock(RemoteStoreLockManager.class),
            null
        }
        try {  
        // Should not throw
         * @param in the directory to wrap  
        when(mockIndexShard.shardId()).thenReturn(shardId);  
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        Map<String, Long> segmentSizeMap = new HashMap<>();
            freshMockShard,
            remoteSegmentStoreDirectory
        );  
        // Create a new uploader service with the fresh mocks
    }  
    /** Mock RemoteSegmentStoreDirectory for remote storage operations */
        doAnswer(invocation -> {
        }
        ShardId shardId = new ShardId(new Index("test", "test"), 1);
        ActionListener<Void> listener = ActionListener.wrap(
        Map<String, Long> segmentSizeMap = new HashMap<>();
        testUploaderService.uploadSegments(segments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);  
    }
        ActionListener<Void> listener = ActionListener.wrap(response -> fail("Should not succeed with corrupt index"), exception -> {
            Collections.singletonList("seg1"),  
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        uploaderService.uploadSegments(emptySegments, segmentSizeMap, listener, mockUploadListenerFunction, false, null);  
     * Test implementation of FilterDirectory used for creating nested directory structures
        testUploaderService.uploadSegments(
            mockUploadListenerFunction,  
        // Create a mock ShardRouting and set it as a field on the IndexShard mock
    // RemoteSyncListener registration tests
        ActionListener<Void> listener = ActionListener.wrap(
    }
        // Setup the real RemoteSegmentStoreDirectory to handle copyFrom calls
        ActionListener<Void> listener = ActionListener.wrap(
import java.util.Collection;
     * Concrete FilterDirectory that implements RemoteSyncListener and tracks calls.  
     *  
            new HashMap<>()
    public void testUploadSegmentsWithCompositeDirectory() throws Exception {  
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
     *
        CountDownLatch latch = new CountDownLatch(1);
     *  
        TestFilterDirectory outerDir = new TestFilterDirectory(new TestFilterDirectory(innerDir));
        // Create a fresh mock IndexShard
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
     * Verifies that the shard is NOT failed (unlike CorruptIndexException)
     *
     * Verifies that the shard is failed with the appropriate error message
        );  
            remoteDirectory,  
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);
        // Verify the upload listener was called correctly  
        assertTrue(latch.await(1, TimeUnit.SECONDS));
     * When no RemoteSyncListener in directory chain, upload still succeeds (no-op notification).  
import org.opensearch.index.store.CompositeDirectory;  
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
        FilterDirectory innerFilterDirectory = new TestFilterDirectory(mockCompositeDirectory);
        }
        );
            latch.countDown();
        );
import java.util.Arrays;  
     * Tests that uploading an empty collection of segments completes successfully  
        // Create a fresh mock IndexShard  
    public static class TestFilterDirectory extends FilterDirectory {
            callback.onResponse(null);  
        // Create a fresh mock IndexShard
            remoteSegmentStoreDirectory
import org.opensearch.core.index.Index;
        when(freshMockShard.state()).thenReturn(IndexShardState.STARTED);  
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            outerDir,  
        RemoteDirectory remoteDataDirectory = mock(RemoteDirectory.class);  
            callback.onFailure(corruptException);
            assertEquals(genericException, exception);
            freshMockShard.getThreadPool(),
            freshMockShard.getThreadPool(),
            exception -> fail("Upload should succeed: " + exception.getMessage())  
            exception -> fail("Upload should succeed: " + exception.getMessage())  
        @Override
        CountDownLatch latch = new CountDownLatch(1);
        Directory innerMockDelegate = mock(Directory.class);  
            remoteDataDirectory,  
        }).when(remoteDataDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
            mock(RemoteStoreLockManager.class),  
/*  
        }).when(remoteDataDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());
        IndexShard freshMockShard = mock(IndexShard.class);  
        Collection<String> emptySegments = Collections.emptyList();  
        Collection<String> segments = Arrays.asList("segment1");
     */
        FilterDirectory outerFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(innerFilterDirectory));  
            remoteSegmentStoreDirectory
        }).when(remoteDirectory).copyFrom(any(), any(), any(), any(), any(), any(), any(Boolean.class), any());  
            freshMockShard.shardId(),
        ShardId shardId = new ShardId(new Index("test", "test"), 0);
                threadPool,
        doAnswer(invocation -> {  
         *
import java.util.function.Function;
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            remoteDirectory,
import org.opensearch.core.index.shard.ShardId;
            freshMockShard,  
            callback.onResponse(null);
        doAnswer(invocation -> {
        CountDownLatch latch = new CountDownLatch(1);
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
        TestFilterDirectory outerDir = new TestFilterDirectory(listenerDir);
            callback.onFailure(genericException);
    /**
    public void testUploadSegmentsWithCorruptIndexException() throws Exception {
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
        when(freshMockShard.shardId()).thenReturn(shardId);
        );
                shardId,  
        freshMockShard.shardRouting = mockShardRouting;
import org.opensearch.index.store.RemoteSyncListener;  
        when(freshMockShard.shardId()).thenReturn(shardId);  
        when(freshMockShard.shardId()).thenReturn(shardId);
     * Verifies that the afterSyncToRemote callback is invoked on the CompositeDirectory
        RemoteStoreUploaderService testUploaderService = new RemoteStoreUploaderService(
    }  
        );
        assertEquals("seg1", listenerDir.lastFile);
        IndexShard freshMockShard = mock(IndexShard.class);  
    // ═══════════════════════════════════════════════════════════════
            freshMockShard.shardId(),  
}
            freshMockShard.getThreadPool(),
