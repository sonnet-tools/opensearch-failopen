        super.tearDown();
                FakeIngestionSource.FakeIngestionMessage>> readResults = fakeConsumer.readNext(
import java.util.concurrent.TimeoutException;  
            );  
    private FakeIngestionSource.FakeIngestionConsumer fakeConsumer;  
    private MessageProcessorRunnable.MessageProcessor processor;
        blockingQueueContainer.updateErrorStrategy(new BlockIngestionErrorStrategy("source"));  
import org.opensearch.index.engine.FakeIngestionSource;  
            FakeIngestionSource.FakeIngestionShardPointer,  
        assertEquals(1, blockingQueueContainer.getPartitionToQueueMap().size());  
/*  
    private MessageProcessorRunnable processorRunnable;  
    public void testUpdateErrorStrategy() {
        assertEquals(1, blockingQueueContainer.getPartitionToMessageProcessorMap().size());
import java.util.concurrent.CountDownLatch;
    @Before
            new ArrayBlockingQueue<>(5),
        fakeConsumer = new FakeIngestionSource.FakeIngestionConsumer(messages, 0);
                    true,  
        for (IngestionShardConsumer.ReadResult<
    private IngestionMessageMapper mapper;
                readResult.getPointer(),  
            ShardUpdateMessage shardUpdateMessage = mapper.mapAndProcess(
        this.mapper = new DefaultIngestionMessageMapper();
                new XContentIngestionPayloadDecoder().decode(readResult.getMessage())
import org.opensearch.indices.pollingingest.mappers.DefaultIngestionMessageMapper;
        CountDownLatch updatesLatch = new CountDownLatch(2);
                FakeIngestionSource.FakeIngestionShardPointer,  
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.verify;  
                    100
import java.util.concurrent.ArrayBlockingQueue;
import static org.mockito.Mockito.mock;
        assertEquals(1, blockingQueueContainer.getPartitionToProcessorExecutorMap().size());
import java.util.ArrayList;
        blockingQueueContainer.close();
                readResult.getMessage(),
        super.setUp();  
            FakeIngestionSource.FakeIngestionMessage> readResult : readResults) {
import java.nio.charset.StandardCharsets;
        assertEquals(2, blockingQueueContainer.getMessageProcessorMetrics().processedCounter().count());  
                );  
    }  
        verify(processor, times(2)).process(any(), any());
}  
 */  
 * SPDX-License-Identifier: Apache-2.0
            blockingQueueContainer.add(shardUpdateMessage);
import java.util.List;  
import org.opensearch.test.OpenSearchTestCase;  
            .get(0)  
        this.blockingQueueContainer = new PartitionedBlockingQueueContainer(processorRunnable, 0);
    }
        messages.add("{\"_source\":{\"name\":\"alice\", \"age\": 21}}".getBytes(StandardCharsets.UTF_8));  
            updatesLatch.countDown();
        assertTrue(processorRunnable.getErrorStrategy() instanceof DropIngestionErrorStrategy);
        assertTrue(processorRunnable.getErrorStrategy() instanceof BlockIngestionErrorStrategy);
        messages.add("{\"_id\":\"1\",\"_source\":{\"name\":\"bob\", \"age\": 24}}".getBytes(StandardCharsets.UTF_8));
    private List<byte[]> messages;
        List<
import static org.mockito.Mockito.doAnswer;  
package org.opensearch.indices.pollingingest;
        processorRunnable = new MessageProcessorRunnable(  
    public void setUp() throws Exception {
        updatesLatch.await();
        );  
 * compatible open source license.
import org.junit.After;
        doAnswer(invocation -> {  
    }  
    private PartitionedBlockingQueueContainer blockingQueueContainer;
 *
        }
            new DropIngestionErrorStrategy("ingestion_source"),  
            0
import static org.mockito.Mockito.times;
        // start processor threads and verify updates are processed  
import org.opensearch.core.common.Strings;
        // verify ID is present on all messages
            "test_index",
        processor = mock(MessageProcessorRunnable.MessageProcessor.class);
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.ArgumentMatchers.any;
public class PartitionedBlockingQueueContainerTests extends OpenSearchTestCase {
    public void tearDown() throws Exception {  
import org.junit.Before;
            processor,
                    5,
import org.opensearch.index.IngestionShardConsumer;
    public void testAddMessage() throws TimeoutException, InterruptedException {
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;
                    fakeConsumer.earliestPointer(),
            IngestionShardConsumer.ReadResult<
    }
        }).when(processor).process(any(), any());  
        blockingQueueContainer.startProcessorThreads();
            .forEach(update -> assertTrue(Strings.hasText((String) update.parsedPayloadMap().get("_id"))));
            return null;
    @After
        blockingQueueContainer.getPartitionToQueueMap()
        messages = new ArrayList<>();
