         * @param index            the index name
    }
                        logger.error(errorMessage);
            ? (String) shardUpdateMessage.parsedPayloadMap().get(ID)
                            1,
        }
    public void run() {
                        messageProcessorMetrics.failedMessageDroppedCounter.inc();
                    );
            MessageProcessorMetrics combinedMetrics = create();  
                    messageProcessorMetrics.versionConflictCounter.inc();
     */
                    "_op_type field is of type %s but not string. Invalid message.",  
            @SuppressWarnings("unchecked")
        this.errorStrategy = errorStrategy;
    private boolean hasExhaustedRetries(Exception e, int retryCount) {
/*  
                String errorMessage = String.format(
    }
                throw new IllegalArgumentException(errorMessage);
                        System.nanoTime(),  
    ) {
            }  
        this.messageProcessor = messageProcessor;
        return this.errorStrategy;  
     * @param blockingQueue    the blocking queue to poll messages from  
                            0,  
import org.apache.logging.log4j.Logger;
            shardUpdateMessage.pointer().asString()
    }
            // By default, writes succeed regardless of document version.
            }
    @Nullable
    }
        );
            : "null";
            shardId,  
import java.util.concurrent.TimeUnit;
                                System.nanoTime(),
    public void setErrorStrategy(IngestionErrorStrategy errorStrategy) {  
import org.opensearch.index.mapper.IdFieldMapper;  
                        logDroppedMessage(shardUpdateMessage);
        ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message> shardUpdateMessage = null;  
                        sourceMap = transformedSource;  
                    break;
                        String errorMessage = "Missing _source field. Invalid message";  
            if (payloadMap.containsKey(OP_TYPE) && !(payloadMap.get(OP_TYPE) instanceof String)) {
                        new Term(IdFieldMapper.NAME, Uid.encodeId(id)),
 */
         * Visible for testing. Process the message and create an engine operation.
    private final int shardId;
                            "Delete operation is missing ID. Skipping message."
            combinedMetrics.failedMessageDroppedCounter.inc(
                        // failed messages are retried indefinitely until it succeeds or is dropped.
                    try {
            }  
                    } else {  
        protected MessageOperation getOperation(ShardUpdateMessage shardUpdateMessage, MessageProcessorMetrics messageProcessorMetrics)
            switch (opType) {
         * @return the message operation  
            }  
        return blockingQueue;  
    }
        }
                        throw new IllegalArgumentException("Invalid operation: " + operation.engineOperation);  
        String indexName,  
                    // set the offset as the offset field
                }
                this.processorThreadInterruptCounter.count() + other.processorThreadInterruptCounter.count()  
                    }  
                        false,
                messageProcessorMetrics.processorThreadInterruptCounter.inc();  
                    e
        logger.warn(  
                                Engine.Operation.Origin.PRIMARY,  
                        engine.indexInternal((Engine.Index) operation.engineOperation, isCreateMode);
        closed = true;
import java.util.Map;
        }
                MessageOperation operation = getOperation(shardUpdateMessage, messageProcessorMetrics);  
            if (payloadMap.containsKey(ID) == false) {
    /**
                    currentShardPointer = shardUpdateMessage.pointer();
                            id,
    public static final String OP_TYPE = "_op_type";
        IngestPipelineExecutor pipelineExecutor  
            this.index = index;  
                        throw new IllegalArgumentException(errorMessage);
import org.opensearch.action.DocWriteRequest;
                        shardUpdateMessage = null;  
            } catch (InterruptedException e) {
    }
                        Engine.Operation.Origin.PRIMARY,
    private final BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>> blockingQueue;
            return new MessageOperation(operation, opType);
        /**
         */  
                        operation = new Engine.NoOp(
                    document.add(pointer.asPointField(IngestionShardPointer.OFFSET_FIELD));  
                String errorMessage = "ID field is missing. Invalid message.";  
                        logger.info("Delete operation without ID received, and will be dropped.");  
         *  
    /**  
                    shardUpdateMessage.originalMessage(),
                    BytesReference source = convertToBytes(sourceMap);
                new CounterMetric(),
import org.opensearch.index.mapper.Uid;
    }
    static class MessageProcessor {
            if (shardUpdateMessage != null) {
            combinedMetrics.invalidMessageCounter.inc(this.invalidMessageCounter.count() + other.invalidMessageCounter.count());
                } catch (VersionConflictEngineException e) {
                    break;  
import org.opensearch.index.mapper.ParsedDocument;  
    /**
                        }
         * @param shardUpdateMessage      contains the message to process
        public static MessageProcessorMetrics create() {  
        String id = shardUpdateMessage.autoGeneratedIdTimestamp() == UNSET_AUTO_GENERATED_TIMESTAMP  
    @Override
                        1,
                messageProcessorMetrics.invalidMessageCounter.inc();  
                        messageProcessorMetrics.invalidMessageCounter.inc();
                    messageProcessorMetrics.failedMessageCounter.inc();
                logger.debug("MessageProcessorRunnable poll interruptedException", e);
import org.opensearch.common.metrics.CounterMetric;
        private final IngestPipelineExecutor pipelineExecutor;
     */
                        );
            new MessageProcessor(engine, pipelineExecutor),
        CounterMetric versionConflictCounter, CounterMetric failedMessageCounter, CounterMetric failedMessageDroppedCounter,
        }
                new CounterMetric(),  
                    if (!(payloadMap.get(SOURCE) instanceof Map)) {
            try {
                        retryCount++;
            return combinedMetrics;  
     *
 */  
            );
     * Tracks MessageProcessor metrics.
                    default:
     */  
    public static final String SOURCE = "_source";
        /**  
        protected void process(ShardUpdateMessage shardUpdateMessage, MessageProcessorMetrics messageProcessorMetrics) {
    public MessageProcessorMetrics getMessageProcessorMetrics() {
                        0
/**
        }
                new CounterMetric(),  
                }
import org.opensearch.index.mapper.MapperParsingException;
    }  
         * @param shardUpdateMessage      an update message containing payload and pointer for the update
    @Override  
                documentVersion = Long.parseLong((String) payloadMap.get(VersionFieldMapper.NAME));
         * Visible for testing. Get the engine operation from the message.
import java.util.Locale;
         * Visible for testing.
                    errorStrategy.handleError(e, IngestionErrorStrategy.ErrorStage.PROCESSING);
            engine.config().getShardId().getId()
            throws IOException {  
    }  
                            Engine.Operation.Origin.PRIMARY,
     * @param pipelineExecutor the pipeline executor for ingest pipeline execution  
            errorStrategy,
import org.opensearch.index.IngestionShardPointer;  
                );
    MessageProcessorRunnable(
import org.opensearch.index.VersionType;
         *
import org.opensearch.common.lucene.uid.Versions;
                    }  
                    Map<String, Object> sourceMap = (Map<String, Object>) payloadMap.get(SOURCE);
        }  
                    // Execute ingest pipelines
    private static final int WAIT_BEFORE_RETRY_DURATION_MS = 2000;  
import java.io.IOException;  
    /**  
        }
         * @param messageProcessorMetrics message processor metrics
            blockingQueue,  
            Map<String, Object> payloadMap = shardUpdateMessage.parsedPayloadMap();
     * @param errorStrategy    the error strategy/policy to use
    // currentShardPointer tracks the most recent pointer that is being processed  
        try {
            }
                this.failedMessageDroppedCounter.count() + other.failedMessageDroppedCounter.count()  
    private volatile IngestionErrorStrategy errorStrategy;
                        shardUpdateMessage.autoGeneratedIdTimestamp(),
         * @param messageProcessorMetrics message processor metrics
                    SourceToParse sourceToParse = new SourceToParse(index, id, source, MediaTypeRegistry.xContentType(source), null);
 * engine operation.  
                            Engine.Operation.Origin.PRIMARY,
                new CounterMetric(),
    public IngestionShardPointer getCurrentShardPointer() {
     * Closes and stops the message processor.
    }
import org.opensearch.common.Nullable;  
import org.apache.logging.log4j.LogManager;
         *  
    protected record MessageOperation(Engine.Operation engineOperation, DocWriteRequest.OpType opType) {
import org.opensearch.index.mapper.VersionFieldMapper;  
import org.apache.lucene.index.Term;
    private void logDroppedMessage(ShardUpdateMessage shardUpdateMessage) {
            Thread.sleep(WAIT_BEFORE_RETRY_DURATION_MS);  
        return messageProcessorMetrics;
    }
         * field used for range search, (2) a stored field for retrieval.
                            UNASSIGNED_SEQ_NO,  
        this.blockingQueue = Objects.requireNonNull(blockingQueue);  
                }
         * @param pipelineExecutor the pipeline executor for ingest pipeline execution
                    "Failed to process operation from message {} at pointer {}: {}",
                    // store the offset as string in stored field
                        documentVersionType,
                            return new MessageOperation(operation, opType);
                case INDEX:
    BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>> getBlockingQueue() {
        return currentShardPointer;  
        IngestionErrorStrategy errorStrategy,
        }
     * @param shardId          the shard ID  
                        );
    private static boolean isNonRetryable(Exception e) {  
        this.shardId = shardId;
import org.opensearch.index.Message;
        }  
                            documentVersionType,  
                        String errorMessage = "_source field does not contain a map. Invalid message";  
                        // ingestion adds routing support, thread it through here as well.
        CounterMetric processorThreadInterruptCounter) {
            return true;  
                documentVersionType = VersionType.EXTERNAL;  
                    if (!payloadMap.containsKey(SOURCE)) {
        } catch (InterruptedException e) {
                    logger.debug("Dropping message due to version conflict. ShardPointer: " + shardUpdateMessage.pointer().asString(), e);  
import java.util.concurrent.BlockingQueue;
                    ParseContext.Document document = doc.rootDoc();
import java.io.Closeable;
            IngestionShardPointer pointer = shardUpdateMessage.pointer();  
                    Locale.getDefault(),
                        // TODO: routing is not available from the ingestion message; if pull-based
            } catch (IOException e) {
 * SPDX-License-Identifier: Apache-2.0
     * Constructor.
    private static final int MIN_RETRY_COUNT = 2;
     * @param indexName        the index name
        if (retryCount >= MIN_RETRY_COUNT) {
                        engine.deleteInternal((Engine.Delete) operation.engineOperation);
                        retryCount = 0;
            combinedMetrics.processorThreadInterruptCounter.inc(
                    logger.error("Unsupported operation type {}", opType);
                            new Term(IdFieldMapper.NAME, Uid.encodeId(id)),
import org.opensearch.index.engine.Engine;  
                            );  
 * compatible open source license.
                        logger.error(errorMessage);
    }  
                    case NO_OP:  
                    ParsedDocument doc = engine.getDocumentMapperForType().getDocumentMapper().parse(sourceToParse);  
    private static final Logger logger = LogManager.getLogger(MessageProcessorRunnable.class);
                            System.nanoTime(),
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
import org.opensearch.index.engine.VersionConflictEngineException;
     * @param engine           the ingestion engine
                        if (transformedSource == null) {
                new CounterMetric(),
            VersionType documentVersionType = VersionType.INTERNAL;  
                case DELETE:
    private void waitBeforeRetry() {
                    // Messages with version conflicts will be dropped. This should not have any impact to data  
import org.opensearch.index.engine.IngestionEngine;
                    }
        IngestionErrorStrategy errorStrategy,
            // Check message for document version. Pull-based ingestion only supports external versioning.  
                        break;
                    boolean retriesExhausted = hasExhaustedRetries(e, retryCount);  
         */
 *
    @Nullable
                    payloadMap.get(OP_TYPE).getClass()
                new CounterMetric()
                messageProcessorMetrics.invalidMessageCounter.inc();
                    }
                    document.add(new StoredField(IngestionShardPointer.OFFSET_FIELD, pointer.asString()));
     */
            );
                        documentVersion,  
                } catch (Exception e) {
            this.engine = engine;
        while (Thread.currentThread().isInterrupted() == false && closed == false) {  
 * The OpenSearch Contributors require contributions made to  
            Engine.Operation operation;  
        BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>> blockingQueue,  
                        waitBeforeRetry();  
                        Map<String, Object> transformedSource = pipelineExecutor.executePipelines(id, sourceMap);  
            }  
                    shardUpdateMessage = blockingQueue.poll(1000, TimeUnit.MILLISECONDS);  
        this.indexName = indexName;  
                            operation = new Engine.NoOp(  
    private volatile boolean closed = false;  
     * Constructor visible for testing.  
                        messageProcessorMetrics.invalidMessageCounter.inc();
                    }  
        public MessageProcessorMetrics combine(MessageProcessorMetrics other) {
        return e instanceof IllegalArgumentException || e instanceof MapperParsingException || e instanceof IllegalStateException;
    public IngestionErrorStrategy getErrorStrategy() {
                    case INDEX:
            combinedMetrics.failedMessageCounter.inc(this.failedMessageCounter.count() + other.failedMessageCounter.count());
 * this file be licensed under the Apache-2.0 license or a
                    shardUpdateMessage.pointer().asString(),  
}  
                    throw new IllegalArgumentException("Unsupported operation");
import org.opensearch.index.mapper.ParseContext;
                    // correctness as pull-based ingestion does not support partial updates.
    }
                if (shardUpdateMessage == null) {
                            // Document dropped by pipeline
        MessageProcessor(IngestionEngine engine, String index, IngestPipelineExecutor pipelineExecutor) {
         * Process the message and create an engine operation. It also records the offset in the document as (1) a point
        int retryCount = 0;
            long documentVersion = Versions.MATCH_ANY;
            try {
            id,
                logger.error(  
     * @param errorStrategy    the error strategy/policy to use
                    shardUpdateMessage = null;  
    public static final String ID = "_id";  
                try {
     * is retried indefinitely after a retry wait time, unless a DROP error policy is used to skip the failed message.
import static org.opensearch.action.index.IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP;
         * @param engine           the ingestion engine  
    private final String indexName;  
    private static BytesReference convertToBytes(Object object) throws IOException {  
     *
        private final String index;  
            return new MessageProcessorMetrics(
                    retryCount = 0;
            String id = (String) payloadMap.get(ID);
            combinedMetrics.versionConflictCounter.inc(this.versionConflictCounter.count() + other.versionConflictCounter.count());  
                    operation = new Engine.Index(
            this.pipelineExecutor = pipelineExecutor;
import org.opensearch.common.xcontent.XContentFactory;  
    /**  
                        doc,  
        int shardId
        this.errorStrategy = errorStrategy;
import org.opensearch.core.common.bytes.BytesReference;
                        UNASSIGNED_SEQ_NO,  
    }
                logger.error(errorMessage);
public class MessageProcessorRunnable implements Runnable, Closeable {
                        throw new RuntimeException("Ingest pipeline execution failed", e);
     * @param blockingQueue    the blocking queue to poll messages from
            DocWriteRequest.OpType opType = DocWriteRequest.OpType.fromString(opTypeString);
     */
            this.index = engine.config().getIndexSettings().getIndex().getName();
            if (payloadMap.containsKey(VersionFieldMapper.NAME)) {
                case CREATE:  
            indexName,
                    messageProcessor.process(shardUpdateMessage, messageProcessorMetrics);
            String opTypeString = (String) payloadMap.getOrDefault(OP_TYPE, "index");  
            );
    private final MessageProcessor messageProcessor;  
     * This record is a wrapper for holding the engine operation and corresponding operation type.
    }
                throw new IllegalArgumentException(errorMessage);
                default:
                            documentVersion,
    }
                            0
        IngestionEngine engine,
                    logger.error("[Message Processor] Error processing message. Index={}, Shard={}, error={}", indexName, shardId, e);  
                            1,
            }
                            System.nanoTime(),  
                                0,
import org.opensearch.index.mapper.SourceToParse;
    private volatile IngestionShardPointer currentShardPointer;
        return BytesReference.bytes(XContentFactory.jsonBuilder().map((Map) object));
                        messageProcessorMetrics.invalidMessageCounter.inc();
                    messageProcessorMetrics.invalidMessageCounter.inc();  
            combinedMetrics.processedCounter.inc(this.processedCounter.count() + other.processedCounter.count());
 * A class to process messages from the ingestion stream. It extracts the payload from the message and creates an
                    shardUpdateMessage = null;
        MessageProcessor(IngestionEngine engine, IngestPipelineExecutor pipelineExecutor) {  
                    if (shardUpdateMessage.autoGeneratedIdTimestamp() != UNSET_AUTO_GENERATED_TIMESTAMP) {
         * <p>  
                        operation = new Engine.Delete(  
                        break;
        BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>> blockingQueue,  
            Thread.currentThread().interrupt(); // Restore interrupt status  
                                "Document dropped by ingest pipeline"
                    } catch (Exception e) {  
     */  
                        break;
                logger.error(errorMessage);  
     * @param messageProcessor the message processor  
                throw new RuntimeException(e);  
package org.opensearch.indices.pollingingest;
    private final MessageProcessorMetrics messageProcessorMetrics = MessageProcessorMetrics.create();
                    if (retriesExhausted && errorStrategy.shouldIgnoreError(e, IngestionErrorStrategy.ErrorStage.PROCESSING)) {
    ) {
                    case DELETE:  
            "Exhausted retries, dropping message: Index={}, Shard={}, _id:{}, pointer:{}",
                Thread.currentThread().interrupt(); // Restore interrupt status
                );
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        boolean isCreateMode = operation.opType == DocWriteRequest.OpType.CREATE;  
                switch (operation.engineOperation.operationType()) {
            engine.config().getShardId().getIndexName(),  
                            0,  
            this.engine = engine;
                        0,
                                1,
        MessageProcessor messageProcessor,
    }  
import java.util.Objects;  
    public MessageProcessorRunnable(
        this(
        );  
                    messageProcessorMetrics.processedCounter.inc();  
                    } else {  
                        throw e; // guardrail violations (e.g., _id mutation) — don't wrap, allow skip-retry
    /**  
                        throw new IllegalArgumentException(errorMessage);
        return isNonRetryable(e);  
    public record MessageProcessorMetrics(CounterMetric processedCounter, CounterMetric invalidMessageCounter,  
            this.pipelineExecutor = pipelineExecutor;  
import org.apache.lucene.document.StoredField;  
         */  
        assert object instanceof Map;
        private final IngestionEngine engine;
    public void close() {
        /**
     * Polls messages from the blocking queue and processes messages. If message processing fails, the failed message
            logger.debug("MessageProcessor thread interrupted while waiting for retry", e);
                    } catch (IllegalStateException e) {
