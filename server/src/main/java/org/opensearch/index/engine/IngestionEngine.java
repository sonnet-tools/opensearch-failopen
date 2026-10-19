                 * segments, including the local checkpoint amongst other values. The maximum sequence number is different, we never want  
                    engineException.addSuppressed(inner);
            });
 * The OpenSearch Contributors require contributions made to  
    /**  
 * IngestionEngine is an engine that ingests data from a stream source.
    ) throws IOException {
            currentVersion = versionValue.version;
            throw e;  
import org.opensearch.indices.pollingingest.IngestionErrorStrategy;  
    }
        IngestService ingestService,  
        // Also initialize cluster write block state in the poller.  
        DefaultStreamPoller.Builder streamPollerBuilder = new DefaultStreamPoller.Builder(
                delete.primaryTerm(),
                startPointer = this.ingestionConsumerFactory.parsePointerFromString(batchStartStr);
            writer.commit();  
            logger.warn("Ingestion warmup timed out for shard after {}ms, proceeding with potentially stale data.", timeoutMs);  
    @Override
    public void activateThrottling() {  
            currentNotFoundOrDeleted = true;
import org.opensearch.index.mapper.ParsedDocument;
                if (currentForceMergeUUID != null) {
            streamPoller.setWriteBlockEnabled(isWriteBlockEnabled);
import java.util.HashMap;
        } catch (RuntimeException | IOException e) {
        IngestionShardPointer currentBatchStartPointer = streamPoller.getBatchStartPointer();
    @Override
            );
        long seqNo,  
    @Override
/**  
        );
            assert doc.getField(SeqNoFieldMapper.TOMBSTONE_NAME) != null : "Delete tombstone document but _tombstone field is not set ["
        IngestionConsumerFactory ingestionConsumerFactory,
     * @param index the index request
    ) throws IOException {  
                    )
    /**  
            if (forceResetPoller) {
        }
            ingestionSource.getType()  
            if (isExternalVersioning) {
        final List<ParseContext.Document> docs,  
        );
            readLock,  
        // initialize ingestion start pointer  
        );
            // todo: possible to optimize addDoc instead of updateDoc if version is not present?  
                 * risk of re-using a sequence number for two different documents when restoring from this commit point and subsequently
        return commitDataAsMap(documentIndexWriter);
        assert Objects.equals(delete.uid().field(), IdFieldMapper.NAME) : delete.uid().field();
 */
            final ParsedDocument tombstone = engineConfig.getTombstoneDocSupplier().newDeleteTombstoneDoc(delete.id(), delete.routing());
    private final Supplier<DocumentMapperForType> documentMapperForTypeSupplier;
    }
     * @throws IOException if an error occurs
    public void updateIngestionSettings(IngestionSettings ingestionSettings) {
                    new DeleteVersionValue(
        }
                commitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(localCheckpoint));  
                e.addSuppressed(inner);
import org.opensearch.index.seqno.SequenceNumbers;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;  
        // update ingestion state
        }
    @Override
    private void updateDocs(
        return new PollingIngestStats(
        // initialize the stream poller
            throw new OpenSearchException("Exception during flush. Poller successfully reset, but reset value might not be persisted.", e);
            return true;
import org.opensearch.index.IngestionPayloadDecoder;  
            streamPoller.updateWarmupConfig(new IngestionSource.WarmupConfig(timeout, lagThreshold));
            engineConfig.getClusterApplierService().addListener(streamPoller);
                .mapperSettings(ingestionSource.getMapperSettings())
        }
            logger.debug("Consumer not yet initialized, skipping consumer reinitialization for ingestion source params update");  
        }
            .addAffixMapUpdateConsumer(IndexMetadata.INGESTION_SOURCE_PARAMS_SETTING, this::updateIngestionSourceParams, (x, y) -> {});
            }
    /**
    ) throws IOException {
        }
     */  
    }
import org.opensearch.index.translog.TranslogManager;
        // Enrich with pipeline execution metrics from the shared executor
            }  
                }  
        IngestionPayloadDecoder payloadDecoder = payloadDecoderFactory.create(
    @Override
            IndexResult indexResult = indexIntoLucene(index, isCreateMode);  
            streamPoller = streamPollerBuilder.resetState(resetState)
    public void indexInternal(Index index, boolean isCreateMode) throws IOException {  
        }
                .pipelineExecutor(pipelineExecutor)  
            // force flush to persist the new batch start pointer
        IndexMetadata indexMetadata = engineConfig.getIndexSettings().getIndexMetadata();
                delete.uid(),  
    private final IngestionPayloadDecoderFactory payloadDecoderFactory;
            this::ensureOpen,
        versionMap.enforceSafeAccess();
package org.opensearch.index.engine;
                    failEngine("lucene commit failed", engineException);
            boolean isExternalVersioning = index.versionType() == VersionType.EXTERNAL;  
        // TODO: add this when we have a thread pool for indexing in parallel
     */  
        final Term uid,
import org.opensearch.cluster.metadata.IngestionSource;
    /**  
        if (docs.size() > 1) {  
     * Block until warmup is complete or timeout occurs.  
                .pollTimeout(ingestionSource.getPollTimeout())  
        StreamPoller.ResetState resetState = ingestionSource.getPointerInitReset().getType();
        return new IndexResult(index.version(), index.primaryTerm(), index.seqNo(), true);
        assert Objects.equals(index.uid().field(), IdFieldMapper.NAME) : index.uid().field();
        }
    public GetResult get(Get get, BiFunction<String, SearcherScope, Searcher> searcherFactory) throws EngineException {  
        if (versionValue == null) {
     * Get current ingestion state. Used by management flows.
                 * of invocation of the commit data iterator (which occurs after all documents have been flushed to Lucene).
import java.io.IOException;  
import org.opensearch.index.mapper.IdFieldMapper;
            indexMetadata,
    }
     * Handler for updating ingestion error strategy in the stream poller on dynamic index settings update.
        final DocumentIndexWriter indexWriter,
    /**  
                }
import org.opensearch.index.VersionType;  
    private final IngestionConsumerFactory ingestionConsumerFactory;  
                index.parsedDoc().version().setLongValue(index.version());  
            if (resetState == StreamPoller.ResetState.RESET_BY_OFFSET) {  
            resetStreamPoller(ingestionSettings.getResetState(), ingestionSettings.getResetValue());
        engineConfig.getIndexSettings()
import java.util.List;
        if (streamPoller.getConsumer() == null) {  
            .getScopedSettings()
    private void updateIngestionState(IngestionSettings ingestionSettings) {
        @Nullable StreamPoller.ResetState resetStateOverride,
        if (engineConfig.getClusterApplierService() != null) {
        } catch (VersionConflictEngineException e) {
            streamPoller.close();  
            .addSettingsUpdateConsumer(IndexMetadata.INGESTION_SOURCE_ERROR_STRATEGY_SETTING, this::updateErrorHandlingStrategy);  
    ) {
                resetState = StreamPoller.ResetState.NONE;
import java.util.function.BiFunction;
import org.opensearch.ingest.IngestService;
                final EngineException engineException = new EngineException(shardId, "failed to commit engine", e);  
            errorStrategy,  
import org.apache.lucene.index.Term;
            indexWriter.softUpdateDocuments(uid, docs, version, seqNo, primaryTerm, softDeletesField);
        IngestionPayloadDecoderFactory payloadDecoderFactory
        unregisterStreamPollerListener();
                .pointerBasedLagUpdateInterval(ingestionSource.getPointerBasedLagUpdateInterval().millis())  
            return;  
        ensureOpen();  
        if (operation.versionType().isVersionConflictForWrites(currentVersion, operation.version(), currentNotFoundOrDeleted)) {
        assert indexMetadata.getIngestionSource() != null;  
            + engineConfig.getShardId().getId();
                e.addSuppressed(closeEx);  
            documentIndexWriter.deleteDocument(
    }
            indexWriter.addDocument(docs.get(0), uid);  
                // reset to none so the poller will poll from the startPointer  
                // try recovering from commit data
            );
        if (streamPoller.isPaused() == false) {
                startPointer = streamPoller.getConsumer().pointerFromTimestampMillis(Long.parseLong(resetValue));  
            + "-"
            currentNotFoundOrDeleted = versionValue.isDelete();
    public NoOpResult noOp(NoOp noOp) throws IOException {
import org.opensearch.indices.pollingingest.DefaultStreamPoller;
 * compatible open source license.
        this.ingestionConsumerFactory = Objects.requireNonNull(ingestionConsumerFactory);
        // Check if batchStartPointer has changed since last commit
     * Handler for updating warmup configuration on dynamic index settings update.
        } catch (RuntimeException | IOException e) {
        }
     */  
            engineConfig.getShardId().getId(),  
        if (streamPoller.getConsumer() == null) {
    }
        } else {
    }
        ensureOpen();  
    private void addDocs(final List<ParseContext.Document> docs, final DocumentIndexWriter indexWriter, Term uid) throws IOException {
            .getScopedSettings()  
            }  
        @Nullable String resetValueOverride,  
        }
    }
            shardId,
                commitData.put(Translog.TRANSLOG_UUID_KEY, translogUUID);
                throw e;
    @Override
            }
        if (streamPoller != null) {
            engineConfig.getClusterApplierService().removeListener(streamPoller);  
            streamPoller.close();  
import org.opensearch.index.IngestionPayloadDecoderFactory;
        TranslogDeletionPolicy translogDeletionPolicy,
            shardPointer != null ? shardPointer.toString() : ""
        );  
 *
                    new IndexVersionValue(EMPTY_TRANSLOG_LOCATION, index.version(), index.seqNo(), index.primaryTerm())
    @Override
    @Override
            if (isExternalVersioning) {
    /**
            Objects.requireNonNull(ingestService),
    @Override
        }
import static org.opensearch.index.translog.Translog.EMPTY_TRANSLOG_SNAPSHOT;
                        engineConfig.getThreadPool().relativeTimeInMillis()  
            } catch (Exception inner) {
            }  
            }
        try {
        long primaryTerm
     *
        } catch (Exception e) {  
            throw ex;
        return new ShardIngestionState(  
            } else {
        boolean completed = streamPoller.awaitWarmupComplete(timeoutMs);  
        // Get current index metadata with updated ingestion source params  
            engineConfig.getShardId().getId(),  
     * Update ingestion state of the poller.
        throw new IngestionEngineException("push-based deletion is not supported in ingestion engine, use streaming source instead");  
        IngestionSource ingestionSource = Objects.requireNonNull(indexMetadata.getIngestionSource());
                 * poller has been completely initialized.  
    }
                    delete.uid().bytes(),
                .blocks()
     */
            new TranslogStats(),
    private void registerDynamicIndexSettingsHandlers() {  
    private void updateIngestionSourceParams(Map<String, Object> updatedParams) {
    /**  
                );
        return EMPTY_TRANSLOG_SNAPSHOT;  
                commitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(localCheckpointTracker.getMaxSeqNo()));
            flush(true, true);  
        }
    }
}
            engineConfig.getIndexSettings()  
            }
                .numProcessorThreads(ingestionSource.getNumProcessorThreads())
        IngestionSource ingestionSource = engineConfig.getIndexSettings().getIndexMetadata().getIngestionSource();  
import org.opensearch.core.common.Strings;
        streamPoller.start();
import java.util.function.Supplier;  
    }  
    public boolean shouldPeriodicallyFlush() {
import org.opensearch.common.lease.Releasable;  
    private final IngestPipelineExecutor pipelineExecutor;  
                .blockingQueueSize(ingestionSource.getBlockingQueueSize())
        throw new IngestionEngineException("push-based indexing is not supported in ingestion engine, use streaming source instead");  
    }
            if (isExternalVersioning) {
        }  
            true
                 */  
                .maxPollSize(ingestionSource.getMaxPollSize())
     * the new poller. Once new poller is initialized, a flush is triggered to persist the new batch start pointer.
     * Validates document version for pull-based ingestion. Only external versioning is supported.
import java.util.Objects;
                    commitData.put(FORCE_MERGE_UUID_KEY, currentForceMergeUUID);  
            writer.setLiveCommitData(() -> {  
    /**  
     */
                        delete.seqNo(),
        } catch (Exception e) {
            final IngestionShardPointer batchStartPointer = streamPoller.getBatchStartPointer();
        CompositeTranslogEventListener translogEventListener
    /**  
     * @param isCreateMode if true, a new document is created. Existing document with same docID will not be updated.  
            : StreamPoller.State.NONE;
     * Processes delete operations. This is used internally by the stream poller only.
        );
            streamPoller.pause();  
    }
                commitData.put(HISTORY_UUID_KEY, historyUUID);  
            engineConfig.getIndexSettings().getIndex().getName(),
    }  
            indexWriter.addDocuments(docs, uid);
        ) {
    private void registerStreamPollerListener() {
     */
                .initialState(initialPollerState)
                maybeFailEngine("index", e);  
            indexWriter.softUpdateDocument(uid, docs.get(0), version, seqNo, primaryTerm, softDeletesField);  
        if (ingestionSettings.getResetState() != null && ingestionSettings.getResetValue() != null) {  
            } else if (resetState == StreamPoller.ResetState.RESET_BY_TIMESTAMP) {
                e.addSuppressed(inner);
import org.opensearch.ExceptionsHelper;
        } catch (final Exception ex) {
        versionMap.enforceSafeAccess();  
                maybeFailEngine("delete", e);  
                delete.seqNo(),
    }
            boolean isExternalVersioning = delete.versionType() == VersionType.EXTERNAL;  
    public DocumentMapperForType getDocumentMapperForType() {  
            throw new OpenSearchException("Failed to reset stream poller", e);
        } else {  
                IndexMetadata.INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING,
            EMPTY_TRANSLOG_SNAPSHOT,  
            ? StreamPoller.State.PAUSED
            }  
    }
public class IngestionEngine extends InternalEngine {  
                }
            } else {
                throw engineException;  
    public void deactivateThrottling() {
        // reset poller position and reinitialize poller
        if (operation.versionType() != VersionType.EXTERNAL) {
        // Check if flush needed after big merge
            final long localCheckpoint = localCheckpointTracker.getProcessedCheckpoint();
            resetValue = resetValueOverride;
    @Override
            try {
    /**  
                softDeletesField  
        ) {  
            IngestionShardPointer startPointer = null;
    }
                /*  
            logger.debug("Version conflict encountered when processing index operation", e);
                 * the maximum sequence number to be less than the last sequence number to go into a Lucene commit, otherwise we run the
        try {  
            refresh("reset poller", SearcherScope.INTERNAL, true);  
        String source,  
            throw e;  
        String translogUUID,  
import org.opensearch.index.translog.TranslogDeletionPolicy;  
import org.opensearch.cluster.block.ClusterBlockLevel;
                this::updateWarmupConfig  
            && startPointerOverride != null;
    public DeleteResult delete(Delete delete) throws IOException {
        }
            lastCommittedBatchStartPointer = batchStartPointer;
        EngineConfig engineConfig,
            clientId,
    }
                final String currentForceMergeUUID = forceMergeUUID;
    private volatile StreamPoller streamPoller;
     * Reinitialize the poller with provided state and value. The current poller is first closed, before initializing
import org.opensearch.index.translog.Translog;
                .resetValue(resetValue)
        }
            startPointer,  
                if (batchStartPointer != null) {
    }
        }
     * This method handles all warmup logic internally. On timeout, always logs a warning and proceeds.
            ingestionSource.getErrorStrategy(),
        // If this is the first commit or pointer has changed, flush is needed  
            try {  
        engineConfig.getIndexSettings()
    /**
        assert indexMetadata != null;
                        delete.version(),  
        return new NoOpTranslogManager(
            && Strings.isNullOrEmpty(resetValueOverride) == false  
        } else {
        String resetValue = ingestionSource.getPointerInitReset().getValue();  
                try {
        long toSeqNo,
        return noOpResult;
            engineConfig.getShardId().getId(),
        // prune based only on timestamp and not sequence number
        assert indexMetadata != null;
import org.opensearch.OpenSearchException;  
                    index.uid().bytes(),  
        }  
            if (ExceptionsHelper.stackTrace(e).contains("org.apache.lucene.index.IndexWriter.filesExist")) {
    public void close() throws IOException {
        return getFromSearcher(get, searcherFactory, SearcherScope.EXTERNAL);
            assert tombstone.docs().size() == 1 : "Tombstone doc should have single doc [" + tombstone + "]";
        if (shouldPeriodicallyFlushAfterBigMerge.get()) {  
    private void updateWarmupConfig(TimeValue timeout, Long lagThreshold) {  
        logger.info("Successfully processed ingestion source params update");
        logger.info("Ingestion source params updated, reinitializing consumer");
        if (!completed) {
    }  
    private void unregisterStreamPollerListener() {
            /*
                /*
            }  
        PollingIngestStats pollerStats = streamPoller.getStats();  
            throw e;
        streamPoller.requestConsumerReinitialization(indexMetadata);  
            addDocs(index.docs(), documentIndexWriter, index.uid());
            pipelineExecutor.getMetrics()
        IngestionShardPointer startPointer = null;
    @Override  
    }
    public ShardIngestionState getIngestionState() {  
                .warmupConfig(ingestionSource.getWarmupConfig())
 */  
        super(engineConfig);  
            pollerStats.getConsumerStats(),
            streamPoller.resume();
        String clientId = engineConfig.getIndexSettings().getNodeName()
            try {  
        long fromSeqNo,
    }
import org.opensearch.indices.pollingingest.IngestionSettings;
            pollerStats.getMessageProcessorStats(),  
import org.opensearch.index.mapper.ParseContext;  
                 * writing new documents to the index. Since we only know which Lucene documents made it into the final commit after the  
    }
            // refresh is needed for persisted pointers to be visible
    }
            currentVersion = Versions.NOT_FOUND;
                .indexBlocked(ClusterBlockLevel.WRITE, engineConfig.getIndexSettings().getIndex().getName());  
/*  
            streamPoller.isWriteBlockEnabled(),  
            } catch (final Exception inner) {
            throw new IllegalStateException("Cannot reset consumer when poller is not paused");  
import org.opensearch.action.admin.indices.streamingingestion.state.ShardIngestionState;
            + engineConfig.getIndexSettings().getIndex().getName()  
            return true;
    public void start() {  
        initializeStreamPoller(null, null, null);
     * Indexes the document into the engine. This is used internally by the stream poller only.
        IndexMetadata indexMetadata = engineConfig.getIndexSettings().getIndexMetadata();  
     */  
        super.close();  
        } catch (VersionConflictEngineException e) {
                payloadDecoder.close();
    /**
    /**
    private void validateDocumentVersion(final Operation operation) throws IOException {
        @Nullable IngestionShardPointer startPointerOverride
                .payloadDecoder(payloadDecoder)  
    protected void commitIndexWriter(final DocumentIndexWriter writer, final String translogUUID) throws IOException {
            updateIngestionState(ingestionSettings);  
import static org.opensearch.index.translog.Translog.EMPTY_TRANSLOG_LOCATION;  
        }
            Releasable releasableLock2 = versionMap.acquireLock(index.uid().bytes())
     */
            .getScopedSettings()
        final long currentVersion;
        registerDynamicIndexSettingsHandlers();  
        this.payloadDecoderFactory = Objects.requireNonNull(payloadDecoderFactory);
    public IngestionEngine(  
                } else {
                final Map<String, String> commitData = new HashMap<>(7);
                + " ]";  
        // Register the poller with the ClusterService for receiving cluster state updates.
            }  
            streamPoller.getState().toString(),  
        }  
    protected TranslogManager createTranslogManager(
            unregisterStreamPollerListener();
import org.opensearch.common.Nullable;
    public Translog.Snapshot newChangesSnapshot(
            boolean isWriteBlockEnabled = engineConfig.getClusterApplierService()  
     * This method is a copy of commitIndexWriter method from {@link InternalEngine} with some additions for ingestion
                 * {@link IndexWriter#commit()} call flushes all documents, we defer computation of the maximum sequence number to the time
            ensureOpen();
            return;
    }  
    protected Map<String, String> commitDataAsMap() {  
        }
        if (docs.size() > 1) {  
     */  
        );
    }
                validateDocumentVersion(index);
        final VersionValue versionValue = resolveDocVersion(operation, false);
        maybePruneDeletes();
                .indexMetadata(indexMetadata)
            }
        Map<String, String> commitData = commitDataAsMap(documentIndexWriter);
        // TODO: is this needed?  
                failEngine("lucene commit failed", ex);
                    logger.warn("ignore null batch start pointer");
        if (ingestionSource == null || !ingestionSource.getWarmupConfig().isEnabled() || streamPoller.isPaused()) {
        lastWriteNanos = delete.startTime();  
        try {  
        // If current pointer is null, no flush needed
import org.opensearch.common.lucene.uid.Versions;
        IngestionErrorStrategy ingestionErrorStrategy = IngestionErrorStrategy.create(
            doc.add(softDeletesField);
 * this file be licensed under the Apache-2.0 license or a
            streamPoller.getErrorStrategy().getName(),
    private void initializeStreamPoller(
        } else {
            final ParseContext.Document doc = tombstone.docs().get(0);  
    }
                versionMap.maybePutIndexUnderLock(
            Releasable releasableLock2 = versionMap.acquireLock(delete.uid().bytes())
     * Handler for updating ingestion source params on dynamic index settings update.
    }
        if (engineConfig.getClusterApplierService() != null) {
            throw new IllegalStateException("Consumer is not yet initialized");
        this.documentMapperForTypeSupplier = engineConfig.getDocumentMapperForTypeSupplier();
    public void deleteInternal(Delete delete) throws IOException {  
     * Apply updated ingestion settings, resetting consumer and updating poller.
            ensureOpen();  
            return false;  
                + doc
        return currentBatchStartPointer.equals(lastCommittedBatchStartPointer) == false;
    }  
        }
            ReleasableLock releasableLock1 = readLock.acquire();  
    }
import org.opensearch.cluster.metadata.IndexMetadata;  
                IndexMetadata.INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING,
            validateDocumentVersion(delete);
    /**
            .addSettingsUpdateConsumer(  
                delete.version(),  
            shouldPeriodicallyFlushAfterBigMerge.set(false);
                 */
                false,
                commitData.put(MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, Long.toString(maxUnsafeAutoIdTimestamp.get()));
    @Override
        if (ingestionSettings.getIsPaused() != null) {
    public IndexResult index(Index index) throws IOException {
            throw e;
            } catch (Exception inner) {
        boolean requiredFullRange,  
        versionMap.pruneTombstones(maxTimestampToPrune, Long.MAX_VALUE);  
            } catch (Exception closeEx) {
            engineConfig.getIndexSettings().getIndexMetadata().getIngestionSource().getType()
                 * The user data captured above (e.g. local checkpoint) contains data that must be evaluated *before* Lucene flushes
            updateDocs(index.uid(), index.docs(), documentIndexWriter, index.version(), index.seqNo(), index.primaryTerm());  
        }  
            try {
    protected void pruneDeletedTombstones() {
        } catch (final AssertionError e) {  
        lastDeleteVersionPruneTimeMSec = timeMSec;
        streamPoller.updateErrorStrategy(updatedIngestionErrorStrategy);  
    public PollingIngestStats pollingIngestStats() {
        if (streamPoller != null) {
        engineConfig.getIndexSettings()
                commitData.put(Engine.MIN_RETAINED_SEQNO, Long.toString(softDeletesPolicy.getMinRetainedSeqNo()));
    }
        long version,
                .errorStrategy(ingestionErrorStrategy)  
                 * Batch start pointer can be null at index creation time, if flush is called before the stream
        // start the polling loop  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.index.IngestionShardPointer;
        NoOpResult noOpResult = new NoOpResult(noOp.primaryTerm(), noOp.seqNo());
            if (isExternalVersioning && indexResult.getResultType() == Result.Type.SUCCESS) {
        if (lastCommittedBatchStartPointer == null) {
                        delete.primaryTerm(),
import org.opensearch.indices.pollingingest.StreamPoller;  
            ingestionConsumerFactory,
     * source.
                .mapperType(ingestionSource.getMapperType())
                } catch (final Exception inner) {  
        // Create the decoder before the builder so it can be closed if poller initialization fails.  
        }
        } else {
            + "-"
        // Register listener for dynamic ingestion source params updates
    }
    private void resetStreamPoller(StreamPoller.ResetState resetState, String resetValue) {
        try (  
import org.opensearch.index.mapper.DocumentMapperForType;
    public void awaitWarmupComplete() throws InterruptedException {
                .build();
                logger.trace("committing writer with commit data [{}]", commitData);
                String batchStartStr = commitData.get(StreamPoller.BATCH_START);  
    private void updateErrorHandlingStrategy(IngestionErrorStrategy.ErrorStrategy errorStrategy) {
     * Periodic flush is required if the batchStartPointer has changed since the last commit or there is a big merge.
    @Override
        }  
import org.opensearch.index.translog.TranslogStats;
            if (index.getAutoGeneratedIdTimestamp() == UNSET_AUTO_GENERATED_TIMESTAMP) {
    }
                versionMap.putDeleteUnderLock(  
            engineConfig.getIndexSettings().getIndex().getName(),
        );  
import org.opensearch.common.util.concurrent.ReleasableLock;  
     */
            ReleasableLock releasableLock1 = readLock.acquire();
            throw e;
import org.opensearch.index.IngestionConsumerFactory;
import org.opensearch.indices.pollingingest.PollingIngestStats;
        final boolean currentNotFoundOrDeleted;  
        if (forceResetPoller) {
            return;
        this.pipelineExecutor = new IngestPipelineExecutor(  
            initializeStreamPoller(resetState, resetValue, startPointer);
        }  
                tombstone.version().setLongValue(delete.version());
        StreamPoller.State initialPollerState = indexMetadata.getIngestionStatus().isPaused()  
import org.opensearch.index.translog.NoOpTranslogManager;
                 * Ingestion engine needs to record batch start pointer.
import org.opensearch.index.translog.listener.CompositeTranslogEventListener;  
        registerStreamPollerListener();
        final long timeMSec = engineConfig.getThreadPool().relativeTimeInMillis();  
                return commitData.entrySet().iterator();  
        if (currentBatchStartPointer == null) {
             */
        if (isCreateMode || index.getAutoGeneratedIdTimestamp() != UNSET_AUTO_GENERATED_TIMESTAMP) {  
    private volatile IngestionShardPointer lastCommittedBatchStartPointer;
        boolean forceResetPoller = resetStateOverride != null
    ) {
             * If assertions are enabled, IndexWriter throws AssertionError on commit if any files don't exist, but tests that randomly
    private IndexResult indexIntoLucene(Index index, boolean isCreateMode) throws IOException {
            streamPoller.isPaused(),
            resetState = resetStateOverride;  
            this
                ex.addSuppressed(inner);  
            translogUUID,
        );
             * throw FileNotFoundException or NoSuchFileException can also hit this.  
                startPointer = streamPoller.getConsumer().pointerFromOffset(resetValue);
     * Starts the ingestion engine to pull.
     * @throws InterruptedException if the thread is interrupted while waiting  
        if (ingestionSettings.getIsPaused()) {
        try {
    }
                    commitData.put(StreamPoller.BATCH_START, batchStartPointer.asString());  
     */
        final long maxTimestampToPrune = timeMSec - engineConfig.getIndexSettings().getGcDeletesInMillis();
        long timeoutMs = ingestionSource.getWarmupConfig().timeout().millis();
        }
        IngestionErrorStrategy updatedIngestionErrorStrategy = IngestionErrorStrategy.create(
     */  
                .state()
import static org.opensearch.action.index.IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP;
                startPointer = startPointerOverride;  
        }
     * This will reinitialize the streamPoller's consumer with new configurations.
            ingestionSource.getDecoderSettings()
                doc,
            lastWriteNanos = index.startTime();
                );
        // Request consumer reinitialization in the poller
    }
import org.opensearch.indices.pollingingest.IngestPipelineExecutor;
        } catch (Exception e) {
        boolean accurateCount
            }  
     */  
import org.opensearch.index.mapper.SeqNoFieldMapper;
            throw new VersionConflictEngineException(shardId, operation, currentVersion, currentNotFoundOrDeleted);  
        if (commitData.containsKey(StreamPoller.BATCH_START) || forceResetPoller) {
        }  
        IngestionShardPointer shardPointer = streamPoller.getBatchStartPointer();
     */  
        return documentMapperForTypeSupplier.get();
        }  
            logger.debug("Version conflict encountered when processing deletes", e);
        try (
