        assertTrue("Warmup should complete after timeout when pointer lag is unsupported", warmupPoller.isWarmupComplete());
            "",
        );
        doThrow(new RuntimeException()).doNothing().when(mockQueue).put(any());
            1000,
        assertTrue(warmupPoller.isWarmupComplete());
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
            StreamPoller.State.NONE,
    public void testResetStateEarliest() throws InterruptedException {
        assertNotNull(poller.getConsumer());
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
        assertTrue(poller.isPaused());
    }
            fail("Expected an exception to be thrown");
            indexSettings,
            "",
 *
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            partitionedBlockingQueueContainer,
import java.util.EnumSet;
            StreamPoller.State.NONE,
        assertTrue(warmupDisabledPoller.isWarmupComplete());
            "",
        poller.start();
        List<
            indexMetadata,
        poller = new DefaultStreamPoller(
        blockingQueueContainer.close();
        doAnswer(invocation -> {
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        assertEquals(DefaultStreamPoller.State.POLLING, poller.getState());
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        super.tearDown();
        List<
        // Create a mock consumer that always reports high lag so warmup never completes on its own
        assertThat(pollingIngestStats.getConsumerStats().totalPollerMessageDroppedCount(), is(0L));
        FakeIngestionSource.FakeIngestionShardPointer queuedPointer = new FakeIngestionSource.FakeIngestionShardPointer(7);
            indexSettings,
        ClusterState state1 = ClusterState.builder(ClusterName.DEFAULT).build();
            1000,
        // Create a mock blocking queue container that returns null pointers
        // Update both threshold and timeout while warmup is in progress
    private IndexMetadata indexMetadata;
        poller.resume();
        Map<String, Object> payloadMap = IngestionUtils.getParsedPayloadMap(payload);
            errorStrategy,
        verify(errorStrategy, times(1)).handleError(any(), eq(IngestionErrorStrategy.ErrorStage.POLLING));
                FakeIngestionSource.FakeIngestionMessage>> results = Collections.singletonList(
            StreamPoller.ResetState.NONE,
            "",
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
            StreamPoller.State.NONE,
 * this file be licensed under the Apache-2.0 license or a
            new XContentIngestionPayloadDecoder()
            StreamPoller.ResetState.NONE,
    private IndexSettings indexSettings;
            return null;
import static org.mockito.Mockito.never;
    }
        assertTrue("Warmup should complete when lag is at threshold", completed);
        blockingQueueContainer.startProcessorThreads();
import org.opensearch.index.IngestionShardConsumer;
        warmupPoller.start();
            StreamPoller.ResetState.NONE,
        ClusterChangedEvent event2 = new ClusterChangedEvent("test", state3, state2);
            StreamPoller.ResetState.NONE,
/*
            partitionedBlockingQueueContainer,
            0,
                FakeIngestionSource.FakeIngestionShardPointer,
        IngestionSource.WarmupConfig enabledConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(5), 50L);
            StreamPoller.State.NONE,
        );
        warmupPoller.start();
    public void testUpdateErrorStrategy() {
import org.opensearch.cluster.ClusterChangedEvent;
        doThrow(new RuntimeException("Error processing update")).when(processor).process(any(), any());
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
            StreamPoller.State.NONE,
    private List<byte[]> messages;
        PollingIngestStats pollingIngestStats = poller.getStats();
            "",
            new DefaultIngestionMessageMapper(),
        messages.add("{\"_id\":\"2\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
        warmupPoller.close();
            "",
            new XContentIngestionPayloadDecoder()
            new DefaultIngestionMessageMapper(),
        assertTrue(poller.isWarmupComplete()); // Warmup disabled means it's considered complete
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(500), 0),
            .thenReturn(reinitializedConsumer);
            new FakeIngestionSource.FakeIngestionShardPointer(1),
            10000,
            1000,
    }
    private
import static org.mockito.ArgumentMatchers.anyString;
            indexSettings,
        when(initialConsumer.getShardId()).thenReturn(0);
        when(mockConsumer.readNext(any(), anyBoolean(), anyLong(), anyInt())).thenReturn(readResultsBatch1);
            consumerFactory,
        // The default poller in setUp has warmup disabled (timeout=-1)
        MessageProcessorRunnable processorRunnable = new MessageProcessorRunnable(
        // We'll use a latch that counts the number of messages processed.
                FakeIngestionSource.FakeIngestionShardPointer,
    }
        List<
            blockingQueueContainer,
                    2,
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(-1L); // Negative means unsupported
        assertTrue(poller.isClosed());
        IngestionErrorStrategy errorStrategy = spy(new BlockIngestionErrorStrategy("ingestion_source"));
            new XContentIngestionPayloadDecoder()
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
            payloadMap,
        // Create a mock consumer factory that reports lag slightly above threshold then drops to threshold
            1000,
            new XContentIngestionPayloadDecoder()
            indexMetadata,
        // Start the poller - it should complete warmup quickly since lag is 0
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch1 = fakeConsumer.readNext(
        // Dynamically disable warmup - updateWarmupStatus will handle completion on next poll loop
    // ==================== Warmup Tests ====================
        messages.add("{\"_id\":\"4\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
        processorRunnable = new MessageProcessorRunnable(new ArrayBlockingQueue<>(5), processor, errorStrategy, "test_index", 0);
        verify(processor, times(2)).process(any(), any());
            fakeConsumerFactory,
            StreamPoller.State.NONE,
            partitionedBlockingQueueContainer,
        poller.start();
        poller.start();
        poller.clusterChanged(event1);
            "",
            1000,
            fakeConsumerFactory,
        PartitionedBlockingQueueContainer mockContainer = mock(PartitionedBlockingQueueContainer.class);
import java.util.concurrent.CountDownLatch;
        FakeIngestionSource.FakeIngestionShardPointer initialPointer = new FakeIngestionSource.FakeIngestionShardPointer(3);
        // Dynamically enable warmup - should NOT re-trigger since shard is already serving
        assertFalse(warmupPoller.isWarmupComplete());
    }
        // Add a 3rd message
            new FakeIngestionSource.FakeIngestionShardPointer(2),
        // Create poller with null initial batch start pointer
            new RuntimeException("Simulated consumer initialization failure")
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);
    }
            new FakeIngestionSource.FakeIngestionShardPointer(0),
import static org.mockito.ArgumentMatchers.anyInt;
            "",
        super.setUp();
        );
            IngestionShardConsumer.ReadResult<
            1000,
        when(mockContainer.getCurrentShardPointers()).thenReturn(Arrays.asList(null, null, null));
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        // Should return immediately without blocking since warmup is disabled
        ClusterState state2 = ClusterState.builder(ClusterName.DEFAULT)
        doAnswer(invocation -> {
            errorStrategy,
            "",
            indexMetadata,
        assertTrue(warmupPoller.isWarmupComplete());
        }, 30, TimeUnit.SECONDS);
import static org.mockito.Mockito.when;
            new DefaultIngestionMessageMapper(),
            1000,
                    new FakeIngestionSource.FakeIngestionShardPointer(1),
        // Give it time to start
            "",
        warmupPoller.updateWarmupConfig(disabledConfig);
            StreamPoller.State.NONE,
        poller.start();
                    new IngestionShardConsumer.ReadResult<>(queuedPointer, message)
        IngestionShardConsumer reinitializedConsumer = mock(IngestionShardConsumer.class);
            new DefaultIngestionMessageMapper(),
            new XContentIngestionPayloadDecoder()
        // Warmup should still be complete (not re-triggered)
    public void testGetBatchStartPointerWithNullInitialPointer() {
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch2 = fakeConsumer.readNext(
    }
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
import org.opensearch.common.unit.TimeValue;
        // Warmup should still not be complete (we just changed config values, not disabled it)
            StreamPoller.ResetState.NONE,
        poller = new DefaultStreamPoller(
        warmupPoller.start();
        doThrow(new RuntimeException()).when(event).blocksChanged();
        verify(processor, times(2)).process(any(), any());
        warmupPoller.start();
    }
            mockConsumerFactory,
import java.util.Map;
            1000,
                );
            1000,
    }
        // Create a poller with warmup disabled (which means warmup is considered complete)
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);
            mockErrorStrategy,
            assertEquals("poller is not started!", e.getMessage());
            new DefaultIngestionMessageMapper(),
        poller.start();
        );
        poller.start();
        poller.start();
        assertEquals(DefaultStreamPoller.State.CLOSED, poller.getState());
        assertEquals(StreamPoller.State.NONE, warmupPoller.getState());
                );
            poller.startPoll();
    }
import java.util.concurrent.ArrayBlockingQueue;
    }
            StreamPoller.ResetState.NONE,
        }
            blockingQueueContainer,
        warmupPoller.start();
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(1000L);
            10000,
        assertThat(pollingIngestStats.getConsumerStats().totalPollerMessageDroppedCount(), is(1L));
        // Set up latch to wait for message processing
    public void testWarmupDisabledBehavior() {
            IngestionShardConsumer.ReadResult<
        assertBusy(() -> {
    private MessageProcessorRunnable processorRunnable;
            StreamPoller.ResetState.NONE,
            IngestionShardConsumer currentConsumer = poller.getConsumer();
            indexSettings,
            10000,
        } catch (IllegalStateException e) {
        PollingIngestStats pollingIngestStats = poller.getStats();
            0,
            0,
            "",
            new DefaultIngestionMessageMapper(),
        );
        partitionedBlockingQueueContainer.startProcessorThreads();
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"charlie\", \"age\": 30}}".getBytes(StandardCharsets.UTF_8));
            1000,
        assertFalse(poller.isPaused());
        indexSettings = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
                    new FakeIngestionSource.FakeIngestionShardPointer(2),
                    new FakeIngestionSource.FakeIngestionShardPointer(1),
        assertTrue(warmupPoller.isWarmupComplete());
            partitionedBlockingQueueContainer,
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
import java.util.concurrent.TimeUnit;
            0,
        // This test publishes 4 messages, so use blocking queue of size 3. This ensures the poller is blocked when adding the 4th message
            StreamPoller.State.NONE,
    public void testCloseWithoutStart() {
        warmupPoller.close();
        try {
    public void testErrorApplyingClusterChange() {
        Thread.sleep(sleepTime);
            new XContentIngestionPayloadDecoder()
            10000,
            indexSettings,
        verify(processor, times(1)).process(any(), any());
        CountDownLatch latch = new CountDownLatch(2);
            StreamPoller.State.NONE,
            return null;
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        poller.start();
            1000,
            10000,
            new XContentIngestionPayloadDecoder()
        );
            new XContentIngestionPayloadDecoder()
            StreamPoller.State.NONE,
            1000,
import org.opensearch.index.engine.IngestionEngine;
        // 2 messages are processed
        // Verify batch start pointer was set to latest (which is 0 since messages list was empty)
import org.opensearch.index.engine.FakeIngestionSource;
            initialPointer,
    }
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
        }
            indexSettings,
            return null;
            indexSettings,
            indexMetadata,
            fakeConsumerFactory,
        messages.add("{\"_id\":\"2\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
            IngestionShardConsumer.ReadResult<
            indexMetadata,
            indexMetadata,
            StreamPoller.ResetState.NONE,
            )
            10000,
        assertBusy(() -> verify(reinitializedConsumer).readNext(eq(queuedPointer), eq(true), anyLong(), anyInt()), 30, TimeUnit.SECONDS);
                    2,
            errorStrategy,
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
            "",
                    fakeConsumer.earliestPointer(),
            indexSettings,
            "",
        doAnswer(invocation -> {
import java.util.ArrayList;
    public void tearDown() throws Exception {
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(300000), 0),
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        );
            -1
        // Verify the consumer factory was called twice (once for failure, once for success)
        poller = new DefaultStreamPoller(
import org.opensearch.test.OpenSearchTestCase;
        IngestionSource.WarmupConfig disabledConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100L);
            new DefaultIngestionMessageMapper(),
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            "",
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
                    fakeConsumer.earliestPointer(),
            "",
            indexSettings,
            StreamPoller.ResetState.NONE,
        // 1 message is processed
        // Add a message after reinitialization is complete
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
            1000,
        poller.start();
            indexSettings,
            partitionedBlockingQueueContainer,
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
            "test_index",
        poller.clusterChanged(event3);
            StreamPoller.State.NONE,
import java.util.Arrays;
            mockFactory,
                    true,
            fail("Expected an exception to be thrown");
            1000,
            1000,
        poller = new DefaultStreamPoller(
                    2,
                FakeIngestionSource.FakeIngestionShardPointer,
            StreamPoller.State.NONE,
        assertEquals(new FakeIngestionSource.FakeIngestionShardPointer(5), poller.getBatchStartPointer());
            indexSettings,
        assertFalse(warmupPoller.isWarmupComplete());
        doAnswer(invocation -> {
        poller = new DefaultStreamPoller(
    private PartitionedBlockingQueueContainer partitionedBlockingQueueContainer;
            partitionedBlockingQueueContainer,
            fakeConsumerFactory,
            errorStrategy,
            "",
        latch.await();
        warmupPoller.updateWarmupConfig(enabledConfig);
            initialLatch.countDown();
import static org.mockito.Mockito.spy;
    }
            StreamPoller.ResetState.NONE,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
                    100
            enabledConfig,
        ClusterChangedEvent event = mock(ClusterChangedEvent.class);
        );
import static org.mockito.Mockito.times;
        blockingQueueContainer.startProcessorThreads();
        IngestionErrorStrategy errorStrategy = spy(new BlockIngestionErrorStrategy("ingestion_source"));
        assertThrows(RuntimeException.class, () -> poller.clusterChanged(event));
            indexMetadata,
        // This ensures latestPointer() returns the correct value at initialization time
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        assertTrue("Warmup should complete after being dynamically disabled", warmupPoller.awaitWarmupComplete(30000));
            1000,
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
            "",
            new XContentIngestionPayloadDecoder()
            1000,
            StreamPoller.State.NONE,
        Thread.sleep(sleepTime);
                    100
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
            indexSettings,
            "",
            indexMetadata,
        warmupPoller.close();
        verify(mockQueue, times(4)).put(any());
            partitionedBlockingQueueContainer,
        assertTrue(poller.getErrorStrategy() instanceof DropIngestionErrorStrategy);
    }
            new XContentIngestionPayloadDecoder()
            partitionedBlockingQueueContainer,
            0,
        CountDownLatch resumeLatch = new CountDownLatch(2);
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
            new DefaultIngestionMessageMapper(),
        warmupPoller.close();
            errorStrategy,
            StreamPoller.ResetState.NONE,
        assertEquals(DefaultStreamPoller.State.PAUSED, poller.getState());
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        // Start poller
        blockingQueueContainer.close();
    private MessageProcessorRunnable.MessageProcessor processor;
            StreamPoller.State.NONE,
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(readResultsBatch2).thenReturn(Collections.emptyList());
            () -> blockingQueueContainer.add(createShardUpdateMessage(5, "1"))
    public void testStartClosedPoller() throws InterruptedException {
import org.opensearch.test.IndexSettingsModule;
            "",
        assertTrue("Should return immediately (< 1000ms)", elapsed < 1000);
            fakeConsumerFactory,
        } catch (IllegalStateException e) {
            1000,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        blockingQueueContainer.close();
            new XContentIngestionPayloadDecoder()
            StreamPoller.ResetState.NONE,
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
        CountDownLatch pauseLatch = new CountDownLatch(2);
            blockingQueueContainer,
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
            0,
            new XContentIngestionPayloadDecoder()
            10000,
        // Wait for the poll loop to call updateWarmupStatus() which counts down the latch
            StreamPoller.State.NONE,
        warmupPoller.close();
    }
            IngestionShardConsumer.ReadResult<
import static org.mockito.ArgumentMatchers.eq;
        // Create a poller with warmup disabled (warmup immediately complete)
        // Create a mock consumer that will be returned on successful initialization
        Thread.sleep(sleepTime);
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);
    public void testConsumerReinitializationWithNoInitialMessages() throws Exception {
            1000,
    }
import java.util.Collections;
        warmupPoller.updateWarmupConfig(new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100L));
            1000,
        );
            partitionedBlockingQueueContainer,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        ).thenReturn(mockConsumer);
public class DefaultStreamPollerTests extends OpenSearchTestCase {
            new XContentIngestionPayloadDecoder()
        );
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
    }
            new XContentIngestionPayloadDecoder()
            mockConsumerFactory,
            10000,
            1000,
        // Create a mock consumer factory that returns negative pointer-based lag (unsupported)
}
            0,
            StreamPoller.State.NONE,
        processorRunnable = new MessageProcessorRunnable(mockQueue, processor, errorStrategy, "test_index", 0);
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
            errorStrategy,
            new XContentIngestionPayloadDecoder()
        // Dynamically disable warmup (timeout=-1)
    public void setUp() throws Exception {
        // Verify no messages processed
        RuntimeException exception = expectThrows(
        );
        assertTrue(warmupPoller.isWarmupComplete());
        poller = new DefaultStreamPoller(
            1000,
            new FakeIngestionSource.FakeIngestionShardPointer(0),
                );
            partitionedBlockingQueueContainer,
import org.opensearch.index.IngestionConsumerFactory;
        when(mockConsumer.getShardId()).thenReturn(0);
            errorStrategy,
        verify(mockErrorStrategy, times(1)).handleError(any(), eq(IngestionErrorStrategy.ErrorStage.PROCESSING));
        warmupPoller.start();
            errorStrategy,
            0,
        assertEquals(DefaultStreamPoller.State.PAUSED, poller.getState());
    private FakeIngestionSource.FakeIngestionConsumerFactory fakeConsumerFactory;
            new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(5), 100L),
        );
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(300000), 0),
        );
        poller.updateErrorStrategy(new BlockIngestionErrorStrategy("ingestion_source"));
        CountDownLatch initialLatch = new CountDownLatch(2);
        messages.clear();
        }).when(processor).process(any(), any());
        boolean completed = warmupPoller.awaitWarmupComplete(5000);
            1000,
        boolean processedWhilePaused = pauseLatch.await(awaitTime, TimeUnit.MILLISECONDS);
            blockingQueueContainer,
    }
            "",
            1000,
            1000,
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);
            RuntimeException.class,
        // Wait for the message to be processed
            "",
                );
        );
    public void testStartPollWithoutStart() {
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
                    true,
            partitionedBlockingQueueContainer,
            indexMetadata,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(10), 100L),
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
        try {
        poller = new DefaultStreamPoller(
            1000,
            mockFactory,
            indexSettings,
            indexMetadata,
            StreamPoller.ResetState.NONE,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            "",
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(initialConsumer)
 * SPDX-License-Identifier: Apache-2.0
        poller.clusterChanged(event2);
            10000,
        waitUntil(() -> poller.getState() == DefaultStreamPoller.State.POLLING, awaitTime, TimeUnit.MILLISECONDS);
        // Create a mock consumer factory that always reports high lag
            new DefaultIngestionMessageMapper(),
            indexMetadata,
        }).when(processor).process(any(), any());
            StreamPoller.ResetState.RESET_BY_OFFSET,
        ArrayBlockingQueue mockQueue = mock(ArrayBlockingQueue.class);
            partitionedBlockingQueueContainer,
            StreamPoller.ResetState.NONE,
            "",
            mockFactory,
        IngestionShardConsumer initialConsumer = mock(IngestionShardConsumer.class);
    public void testPauseAndResume() throws InterruptedException {
            "",
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
            errorStrategy,
        assertTrue(poller.getErrorStrategy() instanceof BlockIngestionErrorStrategy);
import org.opensearch.cluster.ClusterState;
            new XContentIngestionPayloadDecoder()
        FakeIngestionSource.FakeIngestionConsumer fakeConsumer = fakeConsumerFactory.createShardConsumer("", 0, indexMetadata);
        // Should eventually complete via timeout since negative lag won't satisfy threshold
        doAnswer(invocation -> {
        warmupPoller.updateWarmupConfig(updatedConfig);
        }).when(processor).process(any(), any());
        );
            indexSettings,
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
                    true,
            resumeLatch.countDown();
    // ==================== Dynamic Warmup Config Update Tests ====================
        );
    }
        assertTrue(warmupPoller.isWarmupComplete());
            10000,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
 * compatible open source license.
            .blocks(
            new DefaultIngestionMessageMapper(),
        messages.add("{\"_id\":\"2\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
        processorRunnable = new MessageProcessorRunnable(mockQueue, processor, errorStrategy, "test_index", 0);
            PollingIngestStats stats = poller.getStats();
    }
        if (!poller.isClosed()) {
            partitionedBlockingQueueContainer,
        when(reinitializedConsumer.readNext(eq(queuedPointer), eq(true), anyLong(), anyInt())).thenReturn(Collections.emptyList());
        assertTrue("Should return true when warmup is disabled", completed);
        // Create a mock consumer factory that fails on first call but succeeds on second call
                    100
        }).when(processor).process(any(), any());
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        // Start and wait for 2 messages to be processed
        poller = new DefaultStreamPoller(
        assertEquals(Collections.singletonList(null), blockingQueueContainer.getCurrentShardPointers());
            partitionedBlockingQueueContainer,
import org.opensearch.core.rest.RestStatus;
        IngestionSource.WarmupConfig disabledConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100L);
        DefaultStreamPoller poller = new DefaultStreamPoller(
            10000,
        assertFalse(poller.isWriteBlockEnabled());
            indexSettings,
            fakeConsumerFactory,
                    )
        fakeConsumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);
        warmupPoller.close();
            StreamPoller.ResetState.NONE,
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
            indexSettings,
        FakeIngestionSource.FakeIngestionMessage message = new FakeIngestionSource.FakeIngestionMessage(
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(30000), 100),
            fakeConsumerFactory,
import org.opensearch.cluster.block.ClusterBlock;
        partitionedBlockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
        // Wait for timeout - should eventually complete due to timeout
        // poller will continue to poll if an error is encountered during message processing but will be blocked by
import org.junit.Before;
            new XContentIngestionPayloadDecoder()
        assertNull(processorRunnable.getCurrentShardPointer());
        messages.add("{\"_id\":\"3\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
        );
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
            new FakeIngestionSource.FakeIngestionShardPointer(pointer),
        blockingQueueContainer.startProcessorThreads();
        assertBusy(() -> assertEquals(queuedPointer, poller.getBatchStartPointer()), 30, TimeUnit.SECONDS);
            new DefaultIngestionMessageMapper(),
        List<
    public void testResetStateRewindByOffset() throws InterruptedException {
        assertFalse(warmupPoller.isWarmupComplete());
        // Create a poller with the mock factory
            new DefaultIngestionMessageMapper(),
            new DefaultIngestionMessageMapper(),
            0,
            errorStrategy,
            1000,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            mockConsumerFactory,
    public void testWarmupWithNonZeroLagThreshold() throws InterruptedException, TimeoutException {
        poller.close();
            partitionedBlockingQueueContainer,
            "",
                ClusterBlocks.builder()
            indexSettings,
                    fakeConsumer.earliestPointer(),
 * The OpenSearch Contributors require contributions made to
        // Initial state should be NONE
            0,
        // Wait for messages to be processed
            "",
        doAnswer(invocation -> {
            1000,
            10000,
            0,
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            new XContentIngestionPayloadDecoder()
        CountDownLatch latch = new CountDownLatch(1);
            1000,
        when(mockConsumer.getShardId()).thenReturn(0);
        resumeLatch.await();
        partitionedBlockingQueueContainer.close();
        CountDownLatch latch = new CountDownLatch(2);
        blockingQueueContainer.close();
            indexSettings,
            "1",
        FakeIngestionSource.FakeIngestionConsumer fakeConsumer = fakeConsumerFactory.createShardConsumer("", 0, indexMetadata);
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            new FakeIngestionSource.FakeIngestionMessage(payload),
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        );
            10000,
        // isWarmupComplete() checks warmupConfig.isEnabled(), so disabling makes it return true immediately
    private final int sleepTime = 300;
        CountDownLatch reinitLatch = new CountDownLatch(2);  // Expect 2 more messages: message 2 (reprocessed) and message 3 (new)
            indexMetadata,
import java.util.concurrent.TimeoutException;
                    2,
            1000,
        // Set up latch to wait for 2 messages to be processed
        );
        // Request consumer reinitialization
            partitionedBlockingQueueContainer,
            10000,
        poller.start();
            StreamPoller.ResetState.NONE,
            1000,
        warmupPoller.close();
        warmupPoller.start();
            new FakeIngestionSource.FakeIngestionShardPointer(0),
    }
        poller.close();
        poller = new DefaultStreamPoller(
            1000,
        Thread.sleep(sleepTime);
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
        List<
        waitUntil(() -> poller.getState() == DefaultStreamPoller.State.POLLING, awaitTime, TimeUnit.MILLISECONDS);
            indexMetadata,
        // State should eventually transition from WARMING_UP to POLLING/PROCESSING
import org.opensearch.cluster.block.ClusterBlockLevel;
            new XContentIngestionPayloadDecoder()
            indexMetadata,
            indexSettings,
            errorStrategy,
import org.opensearch.cluster.metadata.IngestionSource;
        BlockIngestionErrorStrategy mockErrorStrategy = spy(new BlockIngestionErrorStrategy("ingestion_source"));
            mockFactory,
            StreamPoller.ResetState.NONE,
            StreamPoller.State.NONE,
            "",
        assertTrue("Message should be processed within timeout", latch.await(30, TimeUnit.SECONDS));
            1000,
    public void testBlockErrorIngestionStrategy() throws TimeoutException, InterruptedException {
            errorStrategy,
            errorStrategy,
            poller.close();
        // Even if lag never reaches threshold, warmup completes on timeout
                        new ClusterBlock(1, "description", true, true, true, RestStatus.ACCEPTED, EnumSet.allOf((ClusterBlockLevel.class)))
                );
package org.opensearch.indices.pollingingest;
            1000,
            IngestionShardConsumer.ReadResult<
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch2 = fakeConsumer.readNext(
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
            "",
        verify(mockConsumerFactory, times(2)).createShardConsumer(anyString(), anyInt(), (IndexMetadata) any());
            StreamPoller.State.NONE,
            1000,
import org.opensearch.common.settings.Settings;
        verify(processor, never()).process(any(), any());
            new DefaultIngestionMessageMapper(),
    @After
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            "",
            new XContentIngestionPayloadDecoder()
            StreamPoller.ResetState.NONE,
        boolean completed = warmupPoller.awaitWarmupComplete(60000);
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch1 = fakeConsumer.readNext(
        Thread.sleep(200);
        // test no block change
            10000,
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
            0,
        when(initialConsumer.readNext(eq(initialPointer), eq(true), anyLong(), anyInt())).thenReturn(results);
        );
        MessageProcessorRunnable processorRunnable = new MessageProcessorRunnable(mockQueue, processor, errorStrategy, "test_index", 0);
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        IngestionSource.WarmupConfig initialConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(5), 100L);
        // FakeIngestionSource returns 0 for lag by default
        // Should complete quickly since lag (50) is below threshold (100)
        boolean completed = warmupPoller.awaitWarmupComplete(5000);
            10000,
        // Start the poller - it will be paused, so warmup should be skipped
            indexMetadata,
    public void testWarmupSkippedWhenPollerStartsInPausedState() throws InterruptedException, TimeoutException {
            "",
        IngestionErrorStrategy errorStrategy = spy(new DropIngestionErrorStrategy("ingestion_source"));
        ClusterChangedEvent event1 = new ClusterChangedEvent("test", state2, state1);
            indexMetadata,
            return null;
        poller = new DefaultStreamPoller(
            errorStrategy,
        assertFalse(warmupPoller.isWarmupComplete());
        long startTime = System.currentTimeMillis();
            0,
        assertEquals(new FakeIngestionSource.FakeIngestionShardPointer(0), poller.getBatchStartPointer());
        assertTrue(poller.isPaused());
import static org.mockito.Mockito.doThrow;
        );
            assertEquals(1, stats.getConsumerStats().totalConsumerErrorCount());
        poller = new DefaultStreamPoller(
    }
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
        assertTrue(processorRunnable.getErrorStrategy() instanceof DropIngestionErrorStrategy);
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
    private IngestionEngine engine;
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        // When warmup is disabled, isWarmupComplete should return true immediately
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            10000,
            new XContentIngestionPayloadDecoder()
        processorRunnable = new MessageProcessorRunnable(new ArrayBlockingQueue<>(5), processor, mockErrorStrategy, "test_index", 0);
            0,
            fakeConsumerFactory,
            indexMetadata,
            "{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8)
            errorStrategy,
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(1000L); // High lag
            indexSettings,
            new DefaultIngestionMessageMapper(),
        boolean completed = warmupPoller.awaitWarmupComplete(5000);
            assertEquals("poller is closed!", e.getMessage());
        PartitionedBlockingQueueContainer blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
import java.util.List;
        assertFalse("Messages should not be processed while paused", processedWhilePaused);
            mockContainer,
            1000,
            "",
        // Wait for reprocessing of message 2 and processing of message 3
        ArrayBlockingQueue mockQueue = mock(ArrayBlockingQueue.class);
        ArrayBlockingQueue mockQueue = mock(ArrayBlockingQueue.class);
        long elapsed = System.currentTimeMillis() - startTime;
        assertTrue(warmupPoller.isWarmupComplete());
        assertTrue(poller.isClosed());
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
                    true,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
        // When all queues return null and initialBatchStartPointer is null, getBatchStartPointer should return null
        poller.requestConsumerReinitialization(indexMetadata);
        engine = mock(IngestionEngine.class);
    @Before
            new FakeIngestionSource.FakeIngestionShardPointer(0),
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
            errorStrategy,
 */
        verify(processor, never()).process(any(), any());
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
            poller.startPoll();
        blockingQueueContainer.startProcessorThreads();
        createShardUpdateMessage(long pointer, String id) {
        poller.start();
        when(reinitializedConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
            indexMetadata,
        ClusterChangedEvent event3 = new ClusterChangedEvent("test", state3, state3);
        // Create another poller with warmup explicitly disabled
            1000,
    }
            10000,
        byte[] payload = ("{\"_id\":\"" + id + "\",\"_source\":{\"name\":\"bob\", \"age\": 24}}").getBytes(StandardCharsets.UTF_8);
            new DefaultIngestionMessageMapper(),
            0,
import static org.mockito.ArgumentMatchers.any;
        assertFalse(poller.isWriteBlockEnabled());
            1000,
        // set write block
        poller.close();
import org.opensearch.cluster.metadata.IndexMetadata;
            indexMetadata,
    }
        verify(processor, times(2)).process(any(), any());
            latch.countDown();
            "",
        // Warmup should complete because poller is paused (updateWarmupStatus handles this)
        // remove write block
            indexMetadata,
            10000,
            "",
                    true,
                    true,
        when(initialConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
            new XContentIngestionPayloadDecoder()
        verify(processor, times(1)).process(any(), any());
                    2,
        processor = mock(MessageProcessorRunnable.MessageProcessor.class);
            new ArrayBlockingQueue<>(5),
        messages.clear();
    }
            errorStrategy,
import org.opensearch.indices.pollingingest.mappers.DefaultIngestionMessageMapper;
            0,
            new DefaultIngestionMessageMapper(),
        // Now add messages after poller has started with LATEST reset
            1000,
        // 2 messages are processed
        messages.clear();
        warmupPoller.close();
            StreamPoller.ResetState.NONE,
        assertBusy(() -> {
    public void testPersistedBatchStartPointer() throws TimeoutException, InterruptedException {
            1000,
            StreamPoller.ResetState.NONE,
        );
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
            IngestionShardConsumer.ReadResult<
            StreamPoller.State.NONE,
            errorStrategy,
        doThrow(new RuntimeException()).when(processor).process(any(), any());
            1000,
            fakeConsumerFactory,
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            "",
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            new DefaultIngestionMessageMapper(),
            "",
        doAnswer(invocation -> {
        verify(processor, times(2)).process(any(), any());
        warmupDisabledPoller.close();
import org.opensearch.index.IndexSettings;
import org.junit.After;
            10000,
    }
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(50L);
        );
        reinitLatch.await();
            indexSettings,
            1000,
            0,
        // Warmup should be considered complete when disabled
            StreamPoller.ResetState.EARLIEST,
            "",
            "",
import static org.hamcrest.Matchers.is;
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(Collections.emptyList());
            new DefaultIngestionMessageMapper(),
    public void testConsumerReinitializationAfterProcessingMessages() throws Exception {
        assertTrue("Warmup should complete when lag is below threshold", completed);
        assertTrue("Warmup should be skipped when poller is paused", completed);
        poller = new DefaultStreamPoller(
            errorStrategy,
        verify(processor, times(4)).process(any(), any());
            "",
        latch.await();
            errorStrategy,
            indexSettings,
        // Verify 1 message was processed
            new DefaultIngestionMessageMapper(),
            10000,
    }
    }
            reinitLatch.countDown();
            10000,
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
        // the write to blockingQueue
            "",
    public void testUpdateWarmupConfigDisableWhileInProgress() throws Exception {
                    100
            indexMetadata,
            1000,
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        indexMetadata = indexSettings.getIndexMetadata();
            fakeConsumerFactory,
    public void testWarmupTimesOutAndProceeds() throws InterruptedException, TimeoutException {
        );
        latch.await();
        );
            partitionedBlockingQueueContainer,
        IngestionSource.WarmupConfig updatedConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(10), 50L);
        );
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(readResultsBatch2).thenReturn(Collections.emptyList());
            "",
            "",
        Thread.sleep(sleepTime);
            null,
            StreamPoller.State.NONE,
            "",
    }
        assertTrue("Warmup should complete after timeout", warmupPoller.isWarmupComplete());
        // Create a poller with warmup enabled
        waitUntil(() -> poller.getState() == DefaultStreamPoller.State.POLLING, awaitTime, TimeUnit.MILLISECONDS);
        when(reinitializedConsumer.getShardId()).thenReturn(0);
        }, 30, TimeUnit.SECONDS);
    }
            errorStrategy,
        ArrayBlockingQueue mockQueue = mock(ArrayBlockingQueue.class);
            StreamPoller.State.PAUSED,
            StreamPoller.State.NONE,
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            fakeConsumerFactory,
            assertNotSame(oldConsumer, currentConsumer);
import org.opensearch.cluster.block.ClusterBlocks;
            indexMetadata,
            new XContentIngestionPayloadDecoder()
    public void testDropErrorIngestionStrategy() throws TimeoutException, InterruptedException {
        }).when(processor).process(any(), any());
            assertNotNull(currentConsumer);
    }
        when(mockFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenReturn(mockConsumer);
        // Create a poller with warmup enabled but starting in PAUSED state
        assertThat(pollingIngestStats.getConsumerStats().totalPollerMessageFailureCount(), is(1L));
    }
        // Warmup should be complete since it was disabled
        return new ShardUpdateMessage<>(
            blockingQueueContainer,
            return null;
import static org.mockito.Mockito.mock;
    public void testWarmupCompletesViaTimeoutWhenPointerLagNegative() throws InterruptedException, TimeoutException {
        assertEquals(new FakeIngestionSource.FakeIngestionShardPointer(0), poller.getBatchStartPointer());
        errorStrategy = new DropIngestionErrorStrategy("ingestion_source");
        // Warmup should not be complete yet
        verify(processor, times(1)).process(any(), any());
    public void testUpdateWarmupConfigDoesNotReEnableAfterCompletion() {
            0,
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            errorStrategy,
        IngestionShardConsumer oldConsumer = poller.getConsumer();
            1000,
            0,
        poller.start();
        DefaultStreamPoller warmupPoller = new DefaultStreamPoller(
        blockingQueueContainer.close();
        poller.pause();
    public void testFirstQueuedPointerIsClearedWhenQueuePutFails() throws InterruptedException {
                FakeIngestionSource.FakeIngestionShardPointer,
                    100
    }
            new DefaultIngestionMessageMapper(),
            10000,
import static org.mockito.Mockito.doAnswer;
        assertTrue(warmupPoller.isWarmupComplete());
        // Return lag of 50 which is below threshold of 100
        when(mockConsumer.getShardId()).thenReturn(0);
        }
            "",
    public void testUpdateWarmupConfigDisableWithRunningPoller() throws InterruptedException, TimeoutException {
import static org.mockito.Mockito.verify;
        // (since lag should be 0 from fake source)
        IngestionSource.WarmupConfig enabledConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMinutes(5), 100L);
            1000,
        messages = new ArrayList<>();
        initialLatch.await();
        // Initially publish 2 messages, and later publish 3rd message after consumer reinitialization
    }
        }).when(processor).process(any(), any());
            StreamPoller.ResetState.LATEST,
            "",
            return null;
                );
            new DefaultIngestionMessageMapper(),
            0
            10000,
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
        }).when(processor).process(any(), any());
            "",
            0,
            0,
        poller.close();
        doThrow(new RuntimeException()).doNothing().when(mockQueue).put(any());
        );
        boolean completed = warmupPoller.awaitWarmupComplete(2000);
        // Warmup should not be complete yet
        assertTrue(poller.isWriteBlockEnabled());
            StreamPoller.ResetState.NONE,
        messages.add("{\"_id\":\"4\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
        }).when(processor).process(any(), any());
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        // Create a poller with warmup enabled and lag threshold of 0
            new DefaultIngestionMessageMapper(),
            1000,
        FakeIngestionSource.FakeIngestionConsumerFactory consumerFactory = new FakeIngestionSource.FakeIngestionConsumerFactory(messages);
            new FakeIngestionSource.FakeIngestionShardPointer(0),
            "",
        when(mockConsumer.readNext(anyLong(), anyInt())).thenReturn(readResultsBatch2).thenReturn(Collections.emptyList());
        List<
            1000,
            StreamPoller.ResetState.NONE,
            disabledConfig,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        assertFalse(warmupPoller.isWarmupComplete());
            0,
            new XContentIngestionPayloadDecoder()
                    100
            errorStrategy,
            return null;
            "",
import static org.mockito.ArgumentMatchers.anyLong;
import java.nio.charset.StandardCharsets;
            errorStrategy,
            0,
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
    public void testClusterStateChange() {
            "",
            indexMetadata,
                FakeIngestionSource.FakeIngestionShardPointer,
            fakeConsumerFactory,
        assertNull(poller.getBatchStartPointer());
        // Wait for warmup with timeout
        processorRunnable = new MessageProcessorRunnable(new ArrayBlockingQueue<>(3), processor, errorStrategy, "test_index", 0);
        boolean completed = warmupPoller.awaitWarmupComplete(2000);
        doAnswer(invocation -> {
        poller.start();
import org.opensearch.cluster.ClusterName;
        doThrow(new RuntimeException("put failed")).when(mockQueue).put(any());
            indexSettings,
        ShardUpdateMessage<FakeIngestionSource.FakeIngestionShardPointer, FakeIngestionSource.FakeIngestionMessage>
        when(mockConsumerFactory.createShardConsumer(anyString(), anyInt(), (IndexMetadata) any())).thenThrow(
                    2,
        when(mockConsumer.getShardId()).thenReturn(0);
            StreamPoller.State.NONE,
        ClusterState state3 = ClusterState.builder(ClusterName.DEFAULT).build();
            return null;
            "",
        DefaultStreamPoller warmupDisabledPoller = new DefaultStreamPoller(
        blockingQueueContainer.close();
    public void testResetStateLatest() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        warmupPoller.awaitWarmupComplete(5000);
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(500), 0),
            IngestionShardConsumer.ReadResult<
            new XContentIngestionPayloadDecoder()
        messages.add("{\"_id\":\"4\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
            indexSettings,
    private final int awaitTime = 300;
            10000,
            "",
            partitionedBlockingQueueContainer,
        );
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);
        messages.add("{\"_id\":\"4\",\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));
    public void testBatchStartPointerUsesFirstQueuedPointerWhenProcessorPointerIsNull() throws InterruptedException {
                FakeIngestionSource.FakeIngestionShardPointer,
            .build();
    public void testWarmupCompletesImmediatelyWhenLagIsZero() throws InterruptedException {
            errorStrategy,
        // Start the poller
        processorRunnable = new MessageProcessorRunnable(mockQueue, processor, errorStrategy, "test_index", 0);
        // Initially warmup is not complete
            mockFactory,
        blockingQueueContainer.add(createShardUpdateMessage(5, "1"));
            pauseLatch.countDown();
        // Wait briefly to ensure that no processing occurs.
        // Create a poller with warmup enabled
    public void testUpdateWarmupConfigThresholdAndTimeoutWhileInProgress() {
            1000,
            StreamPoller.State.NONE,
            new FakeIngestionSource.FakeIngestionShardPointer(0),
    public void testProcessingErrorWithBlockErrorIngestionStrategy() throws TimeoutException, InterruptedException {
            indexSettings,
            1000,
            0,
            mockConsumerFactory,
            assertEquals(StreamPoller.State.POLLING, poller.getState());
        assertTrue(warmupPoller.isWarmupComplete());
            initialConfig,
        warmupPoller.close();
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch1 = fakeConsumer.readNext(
        when(mockConsumer.readNext(any(), anyBoolean(), anyLong(), anyInt())).thenReturn(readResultsBatch1);
            10000,
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
    public void testWarmupStateTransitions() throws InterruptedException {
            indexMetadata,
        FakeIngestionSource.FakeIngestionConsumer fakeConsumer = fakeConsumerFactory.createShardConsumer("", 0, indexMetadata);
    public void testConsumerInitializationRetry() throws Exception {
            blockingQueueContainer,
            new DefaultIngestionMessageMapper(),
        List<
    private DefaultStreamPoller poller;
        when(mockConsumer.readNext(any(), anyBoolean(), anyLong(), anyInt())).thenReturn(readResultsBatch1);
        IngestionShardConsumer mockConsumer = mock(IngestionShardConsumer.class);
        IngestionConsumerFactory mockConsumerFactory = mock(IngestionConsumerFactory.class);
            new XContentIngestionPayloadDecoder()
        // Expecting the latch NOT to reach zero because we are paused.
        assertEquals("put failed", exception.getMessage());
        // Verify that the messages added after starting from latest are processed
            new DefaultIngestionMessageMapper(),
        warmupPoller.close();
        verify(errorStrategy, times(1)).handleError(any(), eq(IngestionErrorStrategy.ErrorStage.POLLING));
                    .addGlobalBlock(
            StreamPoller.State.NONE,
                );
            "",
            processor,
            consumerFactory,
        // Start with no messages
            1000,
    }
    public void testClose() throws InterruptedException {
            1000,
            latch.countDown();
        poller.requestConsumerReinitialization(indexMetadata);
    public void testConsumerReinitializationUsesRestartPointerCapturedBeforeClearingQueues() throws Exception {
            0,
            StreamPoller.State.NONE,
                FakeIngestionSource.FakeIngestionMessage>> readResultsBatch2 = fakeConsumer.readNext(
            new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 0),
        warmupPoller.close();
        // Expect total 4 messages, as 2nd message is processed twice due to consumer reinitialization
            new FakeIngestionSource.FakeIngestionShardPointer(0),
import static org.mockito.ArgumentMatchers.anyBoolean;
    }
        poller.start();
    public void testWarmupAwaitReturnsImmediatelyWhenAlreadyComplete() throws InterruptedException {
            latch.countDown();
            indexMetadata,
            1000,
                FakeIngestionSource.FakeIngestionShardPointer,
            errorStrategy,
            partitionedBlockingQueueContainer,
    private DropIngestionErrorStrategy errorStrategy;
            latch.countDown();
        poller = new DefaultStreamPoller(
            new DefaultIngestionMessageMapper(),
        assertTrue(processorRunnable.getErrorStrategy() instanceof BlockIngestionErrorStrategy);
            StreamPoller.ResetState.NONE,
        // for validation.
        blockingQueueContainer.close();
        when(mockConsumer.getPointerBasedLag(any())).thenReturn(1000L);
            fakeConsumerFactory,
            0,
        // Request consumer reinitialization and wait for it to complete before adding messages
        poller.requestConsumerReinitialization(indexMetadata);
            mockConsumerFactory,
            fakeConsumerFactory,
        IngestionConsumerFactory mockFactory = mock(IngestionConsumerFactory.class);
    }
        // Clear messages first and add them after poller starts
        );
        );
            indexMetadata,
            indexSettings,
