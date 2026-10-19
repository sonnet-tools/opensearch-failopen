                FakeIngestionSource.FakeIngestionShardPointer,  
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            "",  
        doThrow(new RuntimeException()).doNothing().when(mockQueue).put(any());
    public void testResetStateEarliest() throws InterruptedException {
        boolean completed = warmupPoller.awaitWarmupComplete(2000);  
        poller.start();
        poller.start();
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
            new XContentIngestionPayloadDecoder()  
            indexMetadata,
            1000,
        super.setUp();
    public void testWarmupTimesOutAndProceeds() throws InterruptedException, TimeoutException {
            1000,
        List<
    private final int sleepTime = 300;
            StreamPoller.ResetState.NONE,
    }
            0,  
        assertBusy(() -> {  
        assertTrue("Warmup should complete after timeout", warmupPoller.isWarmupComplete());
            "",
            0,
            "",
            0,  
                    new FakeIngestionSource.FakeIngestionShardPointer(1),
            0,
        ArrayBlockingQueue mockQueue = mock(ArrayBlockingQueue.class);  
import java.util.ArrayList;  
        blockingQueueContainer.close();  
            1000,
package org.opensearch.indices.pollingingest;
        assertBusy(() -> assertEquals(queuedPointer, poller.getBatchStartPointer()), 30, TimeUnit.SECONDS);  
            "",  
    public void testCloseWithoutStart() {
        IngestionErrorStrategy errorStrategy = spy(new BlockIngestionErrorStrategy("ingestion_source"));  
            indexSettings,
        doAnswer(invocation -> {
import static org.mockito.ArgumentMatchers.eq;
            "",
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
        warmupPoller.updateWarmupConfig(disabledConfig);  
            0,
            return null;
            partitionedBlockingQueueContainer,  
        verify(mockQueue, times(4)).put(any());
        poller = new DefaultStreamPoller(
            1000,
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);  
            indexMetadata,  
            errorStrategy,  
        blockingQueueContainer.close();
        List<  
        blockingQueueContainer.close();
import java.util.Map;
            new FakeIngestionSource.FakeIngestionShardPointer(2),
            fakeConsumerFactory,  
            StreamPoller.ResetState.NONE,
import static org.mockito.Mockito.mock;
        assertTrue("Should return true when warmup is disabled", completed);  
        // isWarmupComplete() checks warmupConfig.isEnabled(), so disabling makes it return true immediately
    }  
    }
    }
        // for validation.  
            fakeConsumerFactory,
        processorRunnable = new MessageProcessorRunnable(mockQueue, processor, errorStrategy, "test_index", 0);
            fakeConsumerFactory,  
            StreamPoller.ResetState.NONE,
        }  
            10000,
import org.opensearch.index.IngestionShardConsumer;
            indexMetadata,  
    public void testWarmupDisabledBehavior() {  
        PollingIngestStats pollingIngestStats = poller.getStats();
    }
            10000,
/*  
        // Wait briefly to ensure that no processing occurs.
        );
            errorStrategy,  
            new FakeIngestionSource.FakeIngestionMessage(payload),  
        );
            1000,  
        // Create another poller with warmup explicitly disabled
            fakeConsumerFactory,
        );
        when(initialConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
        doAnswer(invocation -> {
    public void testWarmupSkippedWhenPollerStartsInPausedState() throws InterruptedException, TimeoutException {  
            new DefaultIngestionMessageMapper(),
    public void testUpdateWarmupConfigDisableWhileInProgress() throws Exception {
        warmupPoller.close();
            "",
        BlockIngestionErrorStrategy mockErrorStrategy = spy(new BlockIngestionErrorStrategy("ingestion_source"));
        CountDownLatch latch = new CountDownLatch(1);  
                    2,
        // State should eventually transition from WARMING_UP to POLLING/PROCESSING  
        // Give it time to start  
        CountDownLatch initialLatch = new CountDownLatch(2);
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);  
import static org.hamcrest.Matchers.is;
        DefaultStreamPoller warmupDisabledPoller = new DefaultStreamPoller(  
        assertTrue("Message should be processed within timeout", latch.await(30, TimeUnit.SECONDS));
            new XContentIngestionPayloadDecoder()
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            errorStrategy,  
    }
            indexMetadata,  
        poller.pause();
    }
            10000,
    public void testWarmupCompletesImmediatelyWhenLagIsZero() throws InterruptedException {
            0,
            partitionedBlockingQueueContainer,  
        warmupPoller.close();  
            new XContentIngestionPayloadDecoder()  
        verify(mockErrorStrategy, times(1)).handleError(any(), eq(IngestionErrorStrategy.ErrorStage.PROCESSING));
            latch.countDown();  
            partitionedBlockingQueueContainer,
            "",
            "",
                    new FakeIngestionSource.FakeIngestionShardPointer(2),
        );  
            fakeConsumerFactory,  
    public void testStartPollWithoutStart() {
        // Start the poller - it will be paused, so warmup should be skipped
            "",
        DefaultStreamPoller poller = new DefaultStreamPoller(
            1000,
        // Create a mock consumer factory that reports lag slightly above threshold then drops to threshold
}
            "",  
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());  
        assertNull(processorRunnable.getCurrentShardPointer());
            fakeConsumerFactory,
        // Set up latch to wait for 2 messages to be processed  
            new DefaultIngestionMessageMapper(),  
        // We'll use a latch that counts the number of messages processed.  
            1000,  
        poller.clusterChanged(event2);  
        ClusterChangedEvent event2 = new ClusterChangedEvent("test", state3, state2);
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            "",
            0,
            errorStrategy,
            0,
        engine = mock(IngestionEngine.class);
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
    public void testGetBatchStartPointerWithNullInitialPointer() {
            indexSettings,
            1000,  
            IngestionShardConsumer currentConsumer = poller.getConsumer();
            fakeConsumerFactory,
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);
        // Create a mock consumer factory that returns negative pointer-based lag (unsupported)  
        // Even if lag never reaches threshold, warmup completes on timeout
            0,  
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            errorStrategy,
            "",
        // Wait for timeout - should eventually complete due to timeout
            1000,
            new ArrayBlockingQueue<>(5),  
        processorRunnable = new MessageProcessorRunnable(new ArrayBlockingQueue<>(5), processor, errorStrategy, "test_index", 0);
        when(mockConsumer.getShardId()).thenReturn(0);
            new DefaultIngestionMessageMapper(),
        CountDownLatch reinitLatch = new CountDownLatch(2);  // Expect 2 more messages: message 2 (reprocessed) and message 3 (new)
                    true,  
        // Create a mock consumer factory that always reports high lag  
            RuntimeException.class,  
    public void testClose() throws InterruptedException {  
        );
        assertTrue(poller.isClosed());  
        assertThrows(RuntimeException.class, () -> poller.clusterChanged(event));  
                FakeIngestionSource.FakeIngestionShardPointer,
            "",
        boolean completed = warmupPoller.awaitWarmupComplete(5000);
            10000,  
            StreamPoller.ResetState.NONE,
                    new IngestionShardConsumer.ReadResult<>(queuedPointer, message)  
            StreamPoller.State.NONE,  
            1000,  
        // FakeIngestionSource returns 0 for lag by default  
    }  
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
            "",
 * SPDX-License-Identifier: Apache-2.0
        resumeLatch.await();
                );  
        poller.requestConsumerReinitialization(indexMetadata);
        // Initial state should be NONE
        assertTrue(warmupPoller.isWarmupComplete());
            1000,
                    2,  
            StreamPoller.ResetState.NONE,  
        CountDownLatch latch = new CountDownLatch(1);
        }).when(processor).process(any(), any());
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);  
            errorStrategy,
            new DefaultIngestionMessageMapper(),  
            new DefaultIngestionMessageMapper(),  
            StreamPoller.ResetState.NONE,
            new DefaultIngestionMessageMapper(),
        Map<String, Object> payloadMap = IngestionUtils.getParsedPayloadMap(payload);  
        // 2 messages are processed  
    }
    }
            1000,
        super.tearDown();
        // Clear messages first and add them after poller starts  
        poller.resume();  
        IngestionSource.WarmupConfig disabledConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100L);
            errorStrategy,
            new XContentIngestionPayloadDecoder()
        reinitLatch.await();
            "",  
            "1",
        );
            resumeLatch.countDown();
        assertTrue("Warmup should complete when lag is at threshold", completed);
            indexMetadata,
        // Dynamically enable warmup - should NOT re-trigger since shard is already serving
        assertTrue(warmupPoller.isWarmupComplete());  
        poller.start();
        assertFalse(poller.isPaused());
        blockingQueueContainer.close();
            new XContentIngestionPayloadDecoder()
            1000,  
            1000,
            indexMetadata,  
        // the write to blockingQueue
        // Should eventually complete via timeout since negative lag won't satisfy threshold
        when(mockConsumer.readNext(any(), anyBoolean(), anyLong(), anyInt())).thenReturn(readResultsBatch1);  
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        List<
                    2,
            IngestionShardConsumer.ReadResult<
            StreamPoller.ResetState.NONE,
            indexMetadata,  
    private IndexSettings indexSettings;
            0,  
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);  
            return null;  
            StreamPoller.ResetState.NONE,
        poller.start();
        assertFalse(warmupPoller.isWarmupComplete());
            indexSettings,  
import java.util.concurrent.TimeoutException;  
        IngestionShardConsumer oldConsumer = poller.getConsumer();  
            partitionedBlockingQueueContainer,
            fakeConsumerFactory,  
            StreamPoller.State.NONE,
        assertFalse("Messages should not be processed while paused", processedWhilePaused);
    private
import org.opensearch.index.engine.IngestionEngine;
                    .addGlobalBlock(
            .build();  
            errorStrategy,
        warmupPoller.close();  
import static org.mockito.Mockito.spy;
    public void testConsumerReinitializationAfterProcessingMessages() throws Exception {  
        // Dynamically disable warmup (timeout=-1)
import org.opensearch.cluster.metadata.IngestionSource;
    }
            indexSettings,
                FakeIngestionSource.FakeIngestionShardPointer,
        verify(processor, times(4)).process(any(), any());
        doAnswer(invocation -> {
        doAnswer(invocation -> {
        // Request consumer reinitialization  
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            StreamPoller.State.NONE,
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            indexMetadata,  
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            "",  
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        partitionedBlockingQueueContainer.close();
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(readResultsBatch2).thenReturn(Collections.emptyList());  
        warmupPoller.awaitWarmupComplete(5000);
            StreamPoller.State.NONE,
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
    }  
        warmupPoller.close();  
    }  
            StreamPoller.State.NONE,  
            new XContentIngestionPayloadDecoder()  
        // Wait for the message to be processed  
            0,
        assertTrue(warmupPoller.isWarmupComplete());  
            10000,
            "",
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
                    fakeConsumer.earliestPointer(),
        FakeIngestionSource.FakeIngestionConsumer fakeConsumer = fakeConsumerFactory.createShardConsumer("", 0, indexMetadata);  
            errorStrategy,
import org.opensearch.cluster.ClusterName;
            indexMetadata,
import org.opensearch.cluster.metadata.IndexMetadata;
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
            10000,
        poller = new DefaultStreamPoller(  
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
                    true,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(  
        initialLatch.await();  
            fakeConsumerFactory,  
            fail("Expected an exception to be thrown");
        // Verify no messages processed
            mockConsumerFactory,
        }).when(processor).process(any(), any());
            "",
        );
            mockConsumerFactory,
        messages.clear();
            mockConsumerFactory,  
        poller.close();
        ArrayBlockingQueue mockQueue = mock(ArrayBlockingQueue.class);  
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
            1000,  
        CountDownLatch latch = new CountDownLatch(2);
    }  
            "",  
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);  
            10000,  
            "test_index",  
        } catch (IllegalStateException e) {  
        poller.start();  
            mockContainer,  
        blockingQueueContainer.startProcessorThreads();
            StreamPoller.State.PAUSED,
    public void testErrorApplyingClusterChange() {  
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
        try {  
            new DefaultIngestionMessageMapper(),
            new DefaultIngestionMessageMapper(),
    }
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
    }
        // set write block  
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(1000L);
import org.opensearch.indices.pollingingest.mappers.DefaultIngestionMessageMapper;
            "",
            "",  
        // Wait for the poll loop to call updateWarmupStatus() which counts down the latch
        }, 30, TimeUnit.SECONDS);
        doAnswer(invocation -> {
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(-1L); // Negative means unsupported
        // Create poller with null initial batch start pointer  
        blockingQueueContainer.close();
        // Warmup should not be complete yet
            1000,  
            .blocks(  
        poller.requestConsumerReinitialization(indexMetadata);
        MessageProcessorRunnable processorRunnable = new MessageProcessorRunnable(mockQueue, processor, errorStrategy, "test_index", 0);
            StreamPoller.ResetState.NONE,
    public void testBlockErrorIngestionStrategy() throws TimeoutException, InterruptedException {  
            indexMetadata,
import java.util.concurrent.ArrayBlockingQueue;  
            StreamPoller.ResetState.NONE,
        verify(processor, times(2)).process(any(), any());
            enabledConfig,
            StreamPoller.ResetState.NONE,
            new XContentIngestionPayloadDecoder()
            1000,
            assertNotNull(currentConsumer);
        verify(errorStrategy, times(1)).handleError(any(), eq(IngestionErrorStrategy.ErrorStage.POLLING));  
            10000,
            return null;
        verify(processor, never()).process(any(), any());
            partitionedBlockingQueueContainer,
        ArrayBlockingQueue mockQueue = mock(ArrayBlockingQueue.class);  
    private MessageProcessorRunnable processorRunnable;  
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));  
            new DefaultIngestionMessageMapper(),  
                FakeIngestionSource.FakeIngestionShardPointer,  
        poller.requestConsumerReinitialization(indexMetadata);
        warmupPoller.close();
    }
        assertNotNull(poller.getConsumer());  
            indexSettings,
            1000,  
        ).thenReturn(mockConsumer);
        // Add a 3rd message  
            0,
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
    public void testPauseAndResume() throws InterruptedException {
    }  
    public void testFirstQueuedPointerIsClearedWhenQueuePutFails() throws InterruptedException {
            new DefaultIngestionMessageMapper(),
            10000,  
        if (!poller.isClosed()) {
            StreamPoller.ResetState.NONE,  
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(500), 0),
    }
import org.opensearch.cluster.block.ClusterBlocks;  
        // Create a mock consumer that will be returned on successful initialization
            1000,
        warmupPoller.close();
        // Expecting the latch NOT to reach zero because we are paused.  
            1000,
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
        warmupPoller.close();
            indexSettings,
import java.util.Arrays;
import static org.mockito.ArgumentMatchers.anyLong;  
        assertTrue(poller.getErrorStrategy() instanceof DropIngestionErrorStrategy);
        // Create a poller with warmup enabled but starting in PAUSED state
            indexSettings,  
            1000,  
        );
        doThrow(new RuntimeException()).doNothing().when(mockQueue).put(any());
        }
            new XContentIngestionPayloadDecoder()
    }
    }  
            errorStrategy,
        }).when(processor).process(any(), any());
        warmupPoller.start();
        );  
            partitionedBlockingQueueContainer,
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
        poller = new DefaultStreamPoller(  
            errorStrategy,
        verify(processor, times(1)).process(any(), any());
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),  
        );
        // Create a poller with the mock factory  
        assertFalse(warmupPoller.isWarmupComplete());
    public void testPersistedBatchStartPointer() throws TimeoutException, InterruptedException {  
            10000,
            errorStrategy,
        poller = new DefaultStreamPoller(  
            mockConsumerFactory,
        createShardUpdateMessage(long pointer, String id) {
        messages.clear();
        try {  
        assertEquals(DefaultStreamPoller.State.POLLING, poller.getState());  
            IngestionShardConsumer.ReadResult<  
    public void testUpdateErrorStrategy() {
        }).when(processor).process(any(), any());
            0,
        IngestionShardConsumer initialConsumer = mock(IngestionShardConsumer.class);
        fakeConsumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);
            1000,
        IngestionShardConsumer reinitializedConsumer = mock(IngestionShardConsumer.class);
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch1 = fakeConsumer.readNext(  
        blockingQueueContainer.startProcessorThreads();
            poller.startPoll();
        when(initialConsumer.getShardId()).thenReturn(0);  
            1000,  
        }
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
            "",
        poller = new DefaultStreamPoller(
            indexMetadata,
            indexSettings,  
            StreamPoller.ResetState.NONE,
        assertBusy(() -> {
        messages.clear();  
            0,
            indexMetadata,  
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);  
        CountDownLatch resumeLatch = new CountDownLatch(2);  
import static org.mockito.ArgumentMatchers.anyString;
        boolean completed = warmupPoller.awaitWarmupComplete(2000);  
        List<
        warmupPoller.close();
        FakeIngestionSource.FakeIngestionConsumer fakeConsumer = fakeConsumerFactory.createShardConsumer("", 0, indexMetadata);  
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"charlie\", \"age\": 30}}".getBytes(StandardCharsets.UTF_8));
            new DefaultIngestionMessageMapper(),
            1000,
        assertTrue(warmupPoller.isWarmupComplete());
            blockingQueueContainer,
            10000,
            mockFactory,
            processor,
        // Warmup should be considered complete when disabled
 */  
        long startTime = System.currentTimeMillis();
        messages.add("{\"_id\":\"4\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
            StreamPoller.State.NONE,
    }
            partitionedBlockingQueueContainer,  
            indexMetadata,
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
        // When warmup is disabled, isWarmupComplete should return true immediately
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);  
            assertEquals(StreamPoller.State.POLLING, poller.getState());
            return null;
        messages.add("{\"_id\":\"2\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));  
            new DefaultIngestionMessageMapper(),
    private PartitionedBlockingQueueContainer partitionedBlockingQueueContainer;  
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch1 = fakeConsumer.readNext(
            0,
    public void testUpdateWarmupConfigThresholdAndTimeoutWhileInProgress() {
            initialLatch.countDown();
            payloadMap,
            0,
            "",  
            0
        warmupPoller.updateWarmupConfig(updatedConfig);  
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
                    fakeConsumer.earliestPointer(),
        FakeIngestionSource.FakeIngestionShardPointer queuedPointer = new FakeIngestionSource.FakeIngestionShardPointer(7);
            "",
            "",
            partitionedBlockingQueueContainer,
            new XContentIngestionPayloadDecoder()
            "",
        warmupPoller.start();
        warmupPoller.start();
        poller.close();  
        blockingQueueContainer.close();
            fail("Expected an exception to be thrown");
        // test no block change  
            0,  
            assertNotSame(oldConsumer, currentConsumer);  
import java.util.Collections;
    public void tearDown() throws Exception {  
    private DropIngestionErrorStrategy errorStrategy;
        warmupPoller.close();
 * compatible open source license.
            PollingIngestStats stats = poller.getStats();
        blockingQueueContainer.startProcessorThreads();
        poller = new DefaultStreamPoller(
        messages.add("{\"_id\":\"2\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
            new DefaultIngestionMessageMapper(),
        // Start and wait for 2 messages to be processed
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
    }
    private final int awaitTime = 300;  
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
        partitionedBlockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);  
            10000,
            new FakeIngestionSource.FakeIngestionShardPointer(pointer),
        assertEquals(new FakeIngestionSource.FakeIngestionShardPointer(5), poller.getBatchStartPointer());  
    public void testUpdateWarmupConfigDoesNotReEnableAfterCompletion() {
            1000,
        boolean completed = warmupPoller.awaitWarmupComplete(60000);  
            new FakeIngestionSource.FakeIngestionShardPointer(0),
                    100
            "",
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
            partitionedBlockingQueueContainer,
            10000,  
            () -> blockingQueueContainer.add(createShardUpdateMessage(5, "1"))
import static org.mockito.Mockito.doThrow;
            StreamPoller.ResetState.RESET_BY_OFFSET,
            10000,
        assertTrue("Warmup should complete after being dynamically disabled", warmupPoller.awaitWarmupComplete(30000));
            indexSettings,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(500), 0),
            10000,
        // Return lag of 50 which is below threshold of 100
        waitUntil(() -> poller.getState() == DefaultStreamPoller.State.POLLING, awaitTime, TimeUnit.MILLISECONDS);
            new DefaultIngestionMessageMapper(),  
                    2,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            "",  
            StreamPoller.ResetState.NONE,
                    2,
        poller.clusterChanged(event1);  
        ArrayBlockingQueue mockQueue = mock(ArrayBlockingQueue.class);
                    fakeConsumer.earliestPointer(),
            errorStrategy,  
            "",  
        Thread.sleep(sleepTime);
            1000,
        // Warmup should still not be complete (we just changed config values, not disabled it)
            1000,
            IngestionShardConsumer.ReadResult<
            10000,  
import java.nio.charset.StandardCharsets;
            StreamPoller.State.NONE,
            1000,
    private DefaultStreamPoller poller;
import org.opensearch.cluster.ClusterState;  
            StreamPoller.ResetState.NONE,  
        // Create a mock consumer factory that fails on first call but succeeds on second call  
            new XContentIngestionPayloadDecoder()  
        Thread.sleep(sleepTime);
    }  
    // ==================== Dynamic Warmup Config Update Tests ====================  
        // Wait for reprocessing of message 2 and processing of message 3  
            StreamPoller.State.NONE,
    @Before
                FakeIngestionSource.FakeIngestionMessage>> results = Collections.singletonList(
        return new ShardUpdateMessage<>(
            indexMetadata,
        );
        );
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            1000,
    }
            mockErrorStrategy,  
            10000,
            partitionedBlockingQueueContainer,
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
        // (since lag should be 0 from fake source)
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            indexSettings,  
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),  
public class DefaultStreamPollerTests extends OpenSearchTestCase {  
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);  
        assertTrue(poller.isWriteBlockEnabled());
            new XContentIngestionPayloadDecoder()  
        // Create a poller with warmup enabled and lag threshold of 0
            indexSettings,
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
            partitionedBlockingQueueContainer,
            "",
        when(reinitializedConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());  
                    true,
    @After
            indexMetadata,
            indexSettings,
    public void testBatchStartPointerUsesFirstQueuedPointerWhenProcessorPointerIsNull() throws InterruptedException {
    }  
            consumerFactory,
        // Start the poller  
    public void testStartClosedPoller() throws InterruptedException {
        poller = new DefaultStreamPoller(
        poller = new DefaultStreamPoller(
                    2,  
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
            StreamPoller.ResetState.NONE,
            initialPointer,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),  
            partitionedBlockingQueueContainer,
            "",  
        assertTrue("Warmup should be skipped when poller is paused", completed);  
        // Should return immediately without blocking since warmup is disabled
            partitionedBlockingQueueContainer,  
    }  
    // ==================== Warmup Tests ====================
            return null;  
import org.junit.Before;  
            "",
            return null;
            0,
            StreamPoller.State.NONE,
        );
        // Create a mock blocking queue container that returns null pointers
            StreamPoller.State.NONE,
        when(mockContainer.getCurrentShardPointers()).thenReturn(Arrays.asList(null, null, null));
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        when(mockConsumer.getShardId()).thenReturn(0);
            mockFactory,
        when(reinitializedConsumer.getShardId()).thenReturn(0);
            1000,
                FakeIngestionSource.FakeIngestionShardPointer,
        assertEquals(DefaultStreamPoller.State.PAUSED, poller.getState());
            blockingQueueContainer,
            1000,  
        assertTrue(poller.isWarmupComplete()); // Warmup disabled means it's considered complete  
            new FakeIngestionSource.FakeIngestionShardPointer(1),
        poller.start();  
        );
        assertEquals(Collections.singletonList(null), blockingQueueContainer.getCurrentShardPointers());
        assertTrue("Warmup should complete after timeout when pointer lag is unsupported", warmupPoller.isWarmupComplete());
        doThrow(new RuntimeException()).when(processor).process(any(), any());
    public void setUp() throws Exception {  
            1000,
            1000,
            0,
            indexMetadata,  
            StreamPoller.ResetState.LATEST,
            1000,  
        partitionedBlockingQueueContainer.startProcessorThreads();
            blockingQueueContainer,
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(readResultsBatch2).thenReturn(Collections.emptyList());
        verify(processor, times(2)).process(any(), any());  
                    true,  
            0,  
        boolean completed = warmupPoller.awaitWarmupComplete(5000);
    }
        assertTrue(warmupPoller.isWarmupComplete());  
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
        FakeIngestionSource.FakeIngestionConsumer fakeConsumer = fakeConsumerFactory.createShardConsumer("", 0, indexMetadata);
                    true,  
                FakeIngestionSource.FakeIngestionShardPointer,  
        ClusterChangedEvent event3 = new ClusterChangedEvent("test", state3, state3);
            StreamPoller.State.NONE,  
import org.opensearch.common.settings.Settings;  
            indexMetadata,
        );
        }, 30, TimeUnit.SECONDS);
 *
            assertEquals("poller is not started!", e.getMessage());
                );
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);  
            "",  
        waitUntil(() -> poller.getState() == DefaultStreamPoller.State.POLLING, awaitTime, TimeUnit.MILLISECONDS);
        // Verify that the messages added after starting from latest are processed
            "{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8)  
            StreamPoller.ResetState.NONE,
        warmupPoller.start();
            1000,  
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        when(initialConsumer.readNext(eq(initialPointer), eq(true), anyLong(), anyInt())).thenReturn(results);  
            "",
            partitionedBlockingQueueContainer,  
            StreamPoller.State.NONE,
            errorStrategy,  
            "",
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            StreamPoller.State.NONE,  
        IngestionSource.WarmupConfig disabledConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100L);
        poller.clusterChanged(event3);
            mockFactory,  
    }
        // Create a mock consumer that always reports high lag so warmup never completes on its own  
        );  
        FakeIngestionSource.FakeIngestionMessage message = new FakeIngestionSource.FakeIngestionMessage(
            10000,
                );  
            indexSettings,  
            indexMetadata,
        // Warmup should not be complete yet
    private FakeIngestionSource.FakeIngestionConsumerFactory fakeConsumerFactory;
        messages.add("{\"_id\":\"4\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
        // Initially warmup is not complete  
                );
            errorStrategy,  
            "",  
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        List<  
        verify(processor, times(2)).process(any(), any());
        poller.close();
            "",
        assertTrue(poller.isClosed());
    private MessageProcessorRunnable.MessageProcessor processor;
        assertBusy(() -> verify(reinitializedConsumer).readNext(eq(queuedPointer), eq(true), anyLong(), anyInt()), 30, TimeUnit.SECONDS);
        assertTrue(warmupPoller.isWarmupComplete());  
        // This ensures latestPointer() returns the correct value at initialization time
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(300000), 0),
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(initialConsumer)  
        MessageProcessorRunnable processorRunnable = new MessageProcessorRunnable(
            blockingQueueContainer,  
        poller.start();
            10000,
            indexSettings,  
        );  
            partitionedBlockingQueueContainer,
        );
            0,  
        indexSettings = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
            new XContentIngestionPayloadDecoder()  
            new XContentIngestionPayloadDecoder()
    public void testConsumerInitializationRetry() throws Exception {  
        List<
        doAnswer(invocation -> {
        verify(mockConsumerFactory, times(2)).createShardConsumer(anyString(), anyInt(), (IndexMetadata) any());
        poller = new DefaultStreamPoller(  
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
                    true,  
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(300000), 0),
            new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(10), 100L),
            new XContentIngestionPayloadDecoder()  
        assertFalse(warmupPoller.isWarmupComplete());  
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            new DefaultIngestionMessageMapper(),  
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        // When all queues return null and initialBatchStartPointer is null, getBatchStartPointer should return null  
        ShardUpdateMessage<FakeIngestionSource.FakeIngestionShardPointer, FakeIngestionSource.FakeIngestionMessage>  
import static org.mockito.Mockito.times;
            "",
            "",
            10000,
            IngestionShardConsumer.ReadResult<
            1000,
        when(mockConsumer.getShardId()).thenReturn(0);  
        // poller will continue to poll if an error is encountered during message processing but will be blocked by
import static org.mockito.Mockito.never;  
            fakeConsumerFactory,  
            mockFactory,  
        poller.start();
            indexSettings,
            StreamPoller.ResetState.NONE,
        Thread.sleep(200);
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        }).when(processor).process(any(), any());
import org.opensearch.cluster.ClusterChangedEvent;
            0,  
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
            -1
        doThrow(new RuntimeException("Error processing update")).when(processor).process(any(), any());
        assertNull(poller.getBatchStartPointer());
            StreamPoller.State.NONE,
            StreamPoller.State.NONE,
        assertFalse(poller.isWriteBlockEnabled());  
import org.opensearch.test.IndexSettingsModule;  
            1000,
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch2 = fakeConsumer.readNext(
            errorStrategy,  
            .thenReturn(reinitializedConsumer);
        // Verify batch start pointer was set to latest (which is 0 since messages list was empty)
            new XContentIngestionPayloadDecoder()
        warmupDisabledPoller.close();
            "",
        latch.await();  
        IngestionErrorStrategy errorStrategy = spy(new BlockIngestionErrorStrategy("ingestion_source"));
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenThrow(
        assertEquals(new FakeIngestionSource.FakeIngestionShardPointer(0), poller.getBatchStartPointer());
    public void testUpdateWarmupConfigDisableWithRunningPoller() throws InterruptedException, TimeoutException {
        assertFalse(warmupPoller.isWarmupComplete());
            "",  
            errorStrategy,
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
            new XContentIngestionPayloadDecoder()
            1000,
            fakeConsumerFactory,  
        );
        verify(processor, times(1)).process(any(), any());
        // Warmup should be complete since it was disabled
        messages.add("{\"_id\":\"4\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),  
            10000,
            return null;
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);  
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        when(mockConsumer.getShardId()).thenReturn(0);
            new XContentIngestionPayloadDecoder()
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            IngestionShardConsumer.ReadResult<
        latch.await();
            errorStrategy,
            assertEquals(1, stats.getConsumerStats().totalConsumerErrorCount());  
                    100
            new DefaultIngestionMessageMapper(),
        // Verify 1 message was processed  
        );
                    100
            10000,  
import org.opensearch.common.unit.TimeValue;
            new DefaultIngestionMessageMapper(),  
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);  
            1000,  
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);  
        } catch (IllegalStateException e) {  
            indexMetadata,
            latch.countDown();
import java.util.concurrent.CountDownLatch;
        IngestionErrorStrategy errorStrategy = spy(new DropIngestionErrorStrategy("ingestion_source"));
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);
        poller.start();
            StreamPoller.ResetState.EARLIEST,  
import static org.mockito.ArgumentMatchers.anyBoolean;
            indexSettings,  
        assertTrue(poller.isPaused());
            mockFactory,  
            pauseLatch.countDown();  
            assertEquals("poller is closed!", e.getMessage());
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(1000L); // High lag
        assertThat(pollingIngestStats.getConsumerStats().totalPollerMessageFailureCount(), is(1L));
        poller.close();
            errorStrategy,
        messages = new ArrayList<>();
        warmupPoller.updateWarmupConfig(new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100L));
            "",
            IngestionShardConsumer.ReadResult<
import static org.mockito.ArgumentMatchers.anyInt;
            errorStrategy,
        boolean completed = warmupPoller.awaitWarmupComplete(5000);
        indexMetadata = indexSettings.getIndexMetadata();  
            errorStrategy,
            StreamPoller.State.NONE,
    private List<byte[]> messages;
            new DefaultIngestionMessageMapper(),  
    public void testWarmupWithNonZeroLagThreshold() throws InterruptedException, TimeoutException {  
        ClusterChangedEvent event1 = new ClusterChangedEvent("test", state2, state1);
        assertEquals("put failed", exception.getMessage());  
        PartitionedBlockingQueueContainer mockContainer = mock(PartitionedBlockingQueueContainer.class);  
            new XContentIngestionPayloadDecoder()  
            1000,
            fakeConsumerFactory,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            indexMetadata,  
        // Start poller
        waitUntil(() -> poller.getState() == DefaultStreamPoller.State.POLLING, awaitTime, TimeUnit.MILLISECONDS);
            1000,  
        IngestionSource.WarmupConfig updatedConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(10), 50L);
        when(mockConsumer.readNext(any(), anyBoolean(), anyLong(), anyInt())).thenReturn(readResultsBatch1);
        when(mockConsumer.readNext(any(), anyBoolean(), anyLong(), anyInt())).thenReturn(readResultsBatch1);
        // The default poller in setUp has warmup disabled (timeout=-1)
            "",
        verify(processor, never()).process(any(), any());  
            0,  
            StreamPoller.ResetState.NONE,  
        messages.add("{\"_id\":\"4\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
            StreamPoller.State.NONE,  
        when(reinitializedConsumer.readNext(eq(queuedPointer), eq(true), anyLong(), anyInt())).thenReturn(Collections.emptyList());
            "",
        assertTrue("Warmup should complete when lag is below threshold", completed);  
        blockingQueueContainer.add(createShardUpdateMessage(5, "1"));  
        ClusterState state1 = ClusterState.builder(ClusterName.DEFAULT).build();
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        warmupPoller.start();  
        verify(processor, times(2)).process(any(), any());
            indexSettings,
        );
    private IngestionEngine engine;
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);  
                );
            1000,  
import static org.mockito.Mockito.verify;  
            1000,
        ClusterState state3 = ClusterState.builder(ClusterName.DEFAULT).build();
            errorStrategy,
import static org.mockito.ArgumentMatchers.any;  
            errorStrategy,
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
        blockingQueueContainer.close();  
        Thread.sleep(sleepTime);
            blockingQueueContainer,  
            return null;
        blockingQueueContainer.startProcessorThreads();
                );  
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
    public void testClusterStateChange() {
            partitionedBlockingQueueContainer,
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
        poller.start();  
        long elapsed = System.currentTimeMillis() - startTime;
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);  
    public void testWarmupCompletesViaTimeoutWhenPointerLagNegative() throws InterruptedException, TimeoutException {
import org.opensearch.index.IndexSettings;  
            1000,  
        assertEquals(new FakeIngestionSource.FakeIngestionShardPointer(0), poller.getBatchStartPointer());  
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        assertThat(pollingIngestStats.getConsumerStats().totalPollerMessageDroppedCount(), is(0L));
            indexMetadata,
    }  
        // Create a poller with warmup disabled (which means warmup is considered complete)
        );
            StreamPoller.State.NONE,  
            indexMetadata,
            null,
            StreamPoller.ResetState.NONE,  
            errorStrategy,  
            new XContentIngestionPayloadDecoder()
        // Start with no messages
            poller.close();
            new XContentIngestionPayloadDecoder()  
        // Verify the consumer factory was called twice (once for failure, once for success)
            indexMetadata,
        // Dynamically disable warmup - updateWarmupStatus will handle completion on next poll loop
            StreamPoller.State.NONE,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.rest.RestStatus;
                    100
            0,
        assertEquals(DefaultStreamPoller.State.CLOSED, poller.getState());
        IngestionSource.WarmupConfig enabledConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(5), 100L);
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            indexSettings,
        poller.updateErrorStrategy(new BlockIngestionErrorStrategy("ingestion_source"));
        doAnswer(invocation -> {  
            1000,  
        assertTrue(processorRunnable.getErrorStrategy() instanceof BlockIngestionErrorStrategy);  
            partitionedBlockingQueueContainer,  
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(readResultsBatch2).thenReturn(Collections.emptyList());
        ClusterState state2 = ClusterState.builder(ClusterName.DEFAULT)
        );  
        CountDownLatch latch = new CountDownLatch(2);
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        boolean processedWhilePaused = pauseLatch.await(awaitTime, TimeUnit.MILLISECONDS);
            StreamPoller.State.NONE,
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch2 = fakeConsumer.readNext(
        warmupPoller.start();
            partitionedBlockingQueueContainer,  
        warmupPoller.close();  
            reinitLatch.countDown();  
        );  
            StreamPoller.ResetState.NONE,
            StreamPoller.State.NONE,
import java.util.concurrent.TimeUnit;
            errorStrategy,  
        assertTrue(warmupPoller.isWarmupComplete());  
            indexSettings,
            StreamPoller.ResetState.NONE,
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(50L);  
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));  
        Thread.sleep(sleepTime);  
        // Create a poller with warmup disabled (warmup immediately complete)  
            new XContentIngestionPayloadDecoder()  
            10000,
            indexSettings,  
    }  
        errorStrategy = new DropIngestionErrorStrategy("ingestion_source");
            StreamPoller.State.NONE,
            new DefaultIngestionMessageMapper(),
        // This test publishes 4 messages, so use blocking queue of size 3. This ensures the poller is blocked when adding the 4th message
        warmupPoller.close();
        poller.start();
        // Now add messages after poller has started with LATEST reset
            )
    public void testConsumerReinitializationUsesRestartPointerCapturedBeforeClearingQueues() throws Exception {
 * The OpenSearch Contributors require contributions made to  
import java.util.EnumSet;  
    }  
        PollingIngestStats pollingIngestStats = poller.getStats();  
        Thread.sleep(sleepTime);  
import org.opensearch.test.OpenSearchTestCase;
            consumerFactory,
    public void testProcessingErrorWithBlockErrorIngestionStrategy() throws TimeoutException, InterruptedException {  
            1000,  
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        // Start the poller - it should complete warmup quickly since lag is 0  
            new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(5), 100L),
            new FakeIngestionSource.FakeIngestionShardPointer(0),
                    new FakeIngestionSource.FakeIngestionShardPointer(1),
        }).when(processor).process(any(), any());  
                    100
        latch.await();  
        processor = mock(MessageProcessorRunnable.MessageProcessor.class);  
        );
            StreamPoller.State.NONE,
        verify(errorStrategy, times(1)).handleError(any(), eq(IngestionErrorStrategy.ErrorStage.POLLING));
                    100
        // Update both threshold and timeout while warmup is in progress
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            0,
                    )
        doThrow(new RuntimeException("put failed")).when(mockQueue).put(any());
    }
        messages.add("{\"_id\":\"2\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
                );  
import org.opensearch.cluster.block.ClusterBlock;
            10000,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),  
        warmupPoller.start();  
            indexSettings,
                FakeIngestionSource.FakeIngestionShardPointer,  
        assertTrue("Should return immediately (< 1000ms)", elapsed < 1000);
        warmupPoller.updateWarmupConfig(enabledConfig);  
            new XContentIngestionPayloadDecoder()  
            poller.startPoll();
            indexSettings,
            "",
        assertFalse(warmupPoller.isWarmupComplete());
        IngestionSource.WarmupConfig initialConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(5), 100L);
            "",  
            new DefaultIngestionMessageMapper(),
            indexMetadata,
            new DefaultIngestionMessageMapper(),
        poller = new DefaultStreamPoller(
            new XContentIngestionPayloadDecoder()
    }  
        // 2 messages are processed
import org.opensearch.index.IngestionConsumerFactory;
        RuntimeException exception = expectThrows(
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            1000,
        // Request consumer reinitialization and wait for it to complete before adding messages
        assertTrue(warmupPoller.isWarmupComplete());
            new DefaultIngestionMessageMapper(),
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch2 = fakeConsumer.readNext(  
            new XContentIngestionPayloadDecoder()
        );
            new XContentIngestionPayloadDecoder()
    }  
        poller = new DefaultStreamPoller(
    public void testWarmupStateTransitions() throws InterruptedException {
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
        // Create a poller with warmup enabled  
import static org.mockito.Mockito.when;
            new FakeIngestionSource.FakeIngestionShardPointer(0),  
            new DefaultIngestionMessageMapper(),
            indexMetadata,
        assertThat(pollingIngestStats.getConsumerStats().totalPollerMessageDroppedCount(), is(1L));  
            1000,
        processorRunnable = new MessageProcessorRunnable(mockQueue, processor, errorStrategy, "test_index", 0);  
    }
        // Wait for warmup with timeout  
        poller = new DefaultStreamPoller(
            mockConsumerFactory,
        );
            indexSettings,
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(1000L);
            1000,  
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
    }  
        // Add a message after reinitialization is complete  
            0,
        assertTrue(poller.isPaused());  
        CountDownLatch pauseLatch = new CountDownLatch(2);
        byte[] payload = ("{\"_id\":\"" + id + "\",\"_source\":{\"name\":\"bob\", \"age\": 24}}").getBytes(StandardCharsets.UTF_8);
        // remove write block  
import org.junit.After;
        poller = new DefaultStreamPoller(
        // Expect total 4 messages, as 2nd message is processed twice due to consumer reinitialization  
        processorRunnable = new MessageProcessorRunnable(mockQueue, processor, errorStrategy, "test_index", 0);
        assertTrue(warmupDisabledPoller.isWarmupComplete());  
import static org.mockito.Mockito.doAnswer;  
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));  
            "",
        verify(processor, times(1)).process(any(), any());  
            indexSettings,
            indexMetadata,
            fakeConsumerFactory,
import org.opensearch.index.engine.FakeIngestionSource;  
            "",
            errorStrategy,  
        poller.start();
        );  
import org.opensearch.cluster.block.ClusterBlockLevel;
        List<
        // Wait for messages to be processed
                ClusterBlocks.builder()
            StreamPoller.State.NONE,
        assertTrue(poller.getErrorStrategy() instanceof BlockIngestionErrorStrategy);
            "",
            new DefaultIngestionMessageMapper(),  
        assertEquals(StreamPoller.State.NONE, warmupPoller.getState());
            new RuntimeException("Simulated consumer initialization failure")  
            partitionedBlockingQueueContainer,  
        // 1 message is processed
        IngestionSource.WarmupConfig enabledConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(5), 50L);
    public void testConsumerReinitializationWithNoInitialMessages() throws Exception {
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(30000), 100),  
        }).when(processor).process(any(), any());  
    public void testResetStateRewindByOffset() throws InterruptedException {  
            10000,
            1000,
            blockingQueueContainer,
    public void testDropErrorIngestionStrategy() throws TimeoutException, InterruptedException {
                        new ClusterBlock(1, "description", true, true, true, RestStatus.ACCEPTED, EnumSet.allOf((ClusterBlockLevel.class)))  
        FakeIngestionSource.FakeIngestionShardPointer initialPointer = new FakeIngestionSource.FakeIngestionShardPointer(3);  
            latch.countDown();
        assertFalse(poller.isWriteBlockEnabled());
            new DefaultIngestionMessageMapper(),  
            1000,
        assertEquals(DefaultStreamPoller.State.PAUSED, poller.getState());
            "",
        // Initially publish 2 messages, and later publish 3rd message after consumer reinitialization
            new DefaultIngestionMessageMapper(),  
        // Warmup should complete because poller is paused (updateWarmupStatus handles this)
        poller.start();
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
    public void testResetStateLatest() throws InterruptedException {
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch1 = fakeConsumer.readNext(
        );
        }).when(processor).process(any(), any());
        // Warmup should still be complete (not re-triggered)
            StreamPoller.ResetState.NONE,
        processorRunnable = new MessageProcessorRunnable(new ArrayBlockingQueue<>(3), processor, errorStrategy, "test_index", 0);  
        processorRunnable = new MessageProcessorRunnable(new ArrayBlockingQueue<>(5), processor, mockErrorStrategy, "test_index", 0);  
            "",
        poller.start();
            disabledConfig,
        assertTrue(processorRunnable.getErrorStrategy() instanceof DropIngestionErrorStrategy);  
            indexSettings,
        // Should complete quickly since lag (50) is below threshold (100)
            1000,
        );
    private IndexMetadata indexMetadata;  
            IngestionShardConsumer.ReadResult<
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
            new XContentIngestionPayloadDecoder()
            initialConfig,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            10000,
        // Set up latch to wait for message processing
import java.util.List;
            latch.countDown();  
            indexSettings,  
            fakeConsumerFactory,
        // Create a poller with warmup enabled  
        doAnswer(invocation -> {  
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);  
            StreamPoller.State.NONE,
        doThrow(new RuntimeException()).when(event).blocksChanged();
    public void testWarmupAwaitReturnsImmediatelyWhenAlreadyComplete() throws InterruptedException {  
