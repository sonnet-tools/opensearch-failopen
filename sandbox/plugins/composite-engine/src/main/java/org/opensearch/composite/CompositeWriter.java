                logger.warn(
 *
        // Flush primary first to capture the row ID mapping that secondaries need.
            return rank(a) >= rank(b) ? a : b;
                    + "]";
            }
            if (closed) return WriterState.CLOSED;
            }
            for (Writer<?> w : secondaryWritersByFormat.values()) {
            java.util.Collection<Writer<DocumentInput<?>>> secondaries
    /**
     * @param config the writer configuration
}
    /**
            : "flush must produce files for all formats or none; got "
    }
                case ACTIVE -> 0;
    }
    public WriterState state() {
            DataFormat format = inputEntry.getKey();
import org.apache.logging.log4j.message.ParameterizedMessage;
    /** Successful addDoc count — every incoming rowId must equal this. */
            .filter(e -> e.getKey().name().equals(formatName))
        if (primaryResult instanceof WriteResult.Failure pf) {
    private final DataFormat primaryFormat;
import java.io.Closeable;
    private final Writer<DocumentInput<?>> primaryWriter;
                IOUtils.closeWhileHandlingException(w);
        }
     */
 * to the pool after each write cycle.
    private final FailureHandlerStrategy failureHandler;
            }
    private static final class FailureHandlerStrategy {
        }
import org.opensearch.index.engine.dataformat.WriterState;
        // generation counter re-produces the same value, a LockObtainFailedException is thrown.
                        + secondary.mappingVersion()
        }
                statsTracker.incWriteSecondaryFailures();
        return failureHandler.aggregateState(closed, primaryWriter, secondaryWritersByFormat.values());
    }
 * The OpenSearch Contributors require contributions made to
        if (result.writerFilesMap().isEmpty() == false && result.writerFilesMap().size() < expectedFormats) {
                Writer<DocumentInput<?>> secondary = (Writer<DocumentInput<?>>) delegate.createWriter(config);
            allWriters.add(primaryWriter);
import java.util.Map;
    @Override
                    + "] must match composite writer generation ["
            );
        // Count every write attempt so write_*_failures can be read as a rate.
            boolean closed,
        if (newVersion > this.mappingVersion) {
        if (currentState != WriterState.ACTIVE) {
    private long acceptedRows = 0L;
    }
                pf.cause()
         * Rolls back each writer in {@code touched} to the composite's current
     * Per-composite failure-handling helper. Owns rollback orchestration and aggregates
/**
@ExperimentalApi
    public void close() throws IOException {
        private static int rank(WriterState s) {
        }
    @Override
        primaryWfs.ifPresent(writerFileSet -> builder.putWriterFileSet(primaryFormat, writerFileSet));
                case RETIRED_FLUSHABLE -> 1;
     * @return the writer generation
            Writer<DocumentInput<?>> writer = secondaryWritersByFormat.get(format);
                    () -> new ParameterizedMessage("Failed to add document in secondary format [{}], rolling back", format.name()),
    // LuceneWriter.close() triggers indexWriter.rollback() → NativeFSLock.close() →
import org.opensearch.index.engine.exec.WriterFileSet;
import java.util.Optional;
                case CLOSED -> 3;
            for (Writer<DocumentInput<?>> w : touched) {
    }
        this.secondaryWritersByFormat = Collections.unmodifiableMap(secondaries);
     * sub-writer states into the single {@link WriterState} the engine acts on.
    }
    // secondary close, leaking the lock and causing LockObtainFailedException on restart.
            Writer<DocumentInput<?>> primary,
                        + this.mappingVersion
        List<Writer<DocumentInput<?>>> touched = new ArrayList<>();
            }
    /**
            throw new IllegalStateException("rowId [" + doc.getRowId() + "] does not match accepted row count [" + acceptedRows + "]");
        int expectedFormats = 1 + secondaryWritersByFormat.size();
        this.failureHandler = new FailureHandlerStrategy();
     * Searches primary and secondary formats by {@link DataFormat#name()}.
     * recovery can replay the translog.
        WriterState aggregateState(
            // A generation must publish every format or none. Partial output could expose primary rows
    public FileInfos flush(FlushInput flushInput) throws IOException {
    public long generation() {
        }
        // Close already-created writers if a secondary createWriter() fails. LuceneWriter
     * Returns the writer generation number.
     *
                assert secondary.isSchemaMutable() && secondary.mappingVersion() >= this.mappingVersion
        void rollback(List<Writer<DocumentInput<?>>> touched, long targetRowCount) throws IOException {
    private final long writerGeneration;
package org.opensearch.composite;
    private final Map<DataFormat, Writer<DocumentInput<?>>> secondaryWritersByFormat;
        ) {
    }
        }
        this.statsTracker = engine.statsTracker();
 * SPDX-License-Identifier: Apache-2.0
                    + fileEntry.getKey().name()
        }
        }
        // closed, the path remains in LOCK_HELD and on engine restart (same JVM) when the
        this.mappingVersion = primaryWriter.mappingVersion();
    /**
     */
                () -> new ParameterizedMessage("Failed to add document in primary format [{}], rolling back", primaryFormat.name()),
            for (Writer<?> w : secondaries) {
            throw e;
            primaryWriter.updateMappingVersion(newVersion);
 * @opensearch.experimental
            touched.add(writer);
            for (IndexingExecutionEngine<?, ?> delegate : engine.getSecondaryDelegates()) {
        return writerGeneration;
    }
 */
            List<Closeable> allWriters = new ArrayList<>(1 + secondaryWritersByFormat.size());
        assert touched.size() == 1 + secondaryInputs.size() : "all writers must succeed if we reach here; touched="
        FlushInput secondaryFlushInput = rowIdMapping != null ? new FlushInput(rowIdMapping) : FlushInput.EMPTY;
 */
            return FileInfos.empty();
    @SuppressWarnings("unchecked")
                assert fileEntry.getValue().writerGeneration() == writerGeneration : "secondary WriterFileSet generation ["
import java.io.IOException;
        return primaryResult;
                        + "] must match primary ["
        }
            throw new IllegalStateException("Cannot add document to writer in state " + currentState);
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        /**
     */
                case PENDING_ROLLBACK -> 2;
    long getWriterGeneration() {
            WriteResult result = writer.addDoc(inputEntry.getValue());
                failureHandler.rollback(touched, acceptedRows);
        } finally {
import org.opensearch.index.engine.dataformat.FlushInput;
            FileInfos fileInfos = entry.getValue().flush(secondaryFlushInput);
                );
import org.opensearch.common.util.io.IOUtils;
import org.apache.logging.log4j.LogManager;
                w.updateMappingVersion(newVersion);
     * Returns the lifecycle state aggregated by the composite's {@link FailureHandlerStrategy} —
            .<Writer<?>>map(Map.Entry::getValue)
            for (Map.Entry<DataFormat, WriterFileSet> fileEntry : fileInfos.writerFilesMap().entrySet()) {
     */
        }
    private volatile boolean closed;
            logger.warn(
        this.primaryFormat = primaryDelegate.getDataFormat();
     *
        acceptedRows++;
     * <p>
    @Override
    @Override
            return new WriteResult.Failure(pf.cause(), -1, -1, -1);
                    + "] for format ["
 * compatible open source license.
import org.opensearch.index.engine.dataformat.DocumentInput;
            };
 * <p>
                return new WriteResult.Failure(sf.cause(), -1, -1, -1);
                secondaries.put(delegate.getDataFormat(), secondary);
        IndexingExecutionEngine<?, ?> primaryDelegate = engine.getPrimaryDelegate();
    // LOCK_HELD.remove(path). Without this, a throwing primary.close() would skip
        return secondaryWritersByFormat.entrySet()
        return result;
                    + writerGeneration
            for (Writer<DocumentInput<?>> w : secondaries.values()) {
        // acquires a NativeFSLock on construction, tracked in a static LOCK_HELD set. If not
        return true;
    public long mappingVersion() {
            }
    CompositeWriter(CompositeIndexingExecutionEngine engine, WriterConfig config) {
            return worst;
import java.util.ArrayList;
    @Override
                w.rollbackTo(targetRowCount);
        }
            + " expected="
 * Constructed from a {@link CompositeIndexingExecutionEngine}, it iterates the engine's
         */
import org.opensearch.index.engine.dataformat.RowIdMapping;
        FileInfos.Builder builder = FileInfos.builder();
        for (Map.Entry<DataFormat, DocumentInput<?>> inputEntry : secondaryInputs.entrySet()) {
        // Roll back exactly the writers we've called addDoc on, in order.
        return mappingVersion;
        } catch (Exception e) {
    }
        Optional<WriterFileSet> primaryWfs = primaryFileInfos.getWriterFileSet(primaryFormat);
        if (primaryWriter.isSchemaMutable() == false) return false;
        private static WriterState worse(WriterState a, WriterState b) {
        Map<DataFormat, DocumentInput<?>> secondaryInputs = doc.getSecondaryInputs();
     * secondaries) and a fresh {@link FailureHandlerStrategy} that lives for the writer's lifetime.
    @Override
 * this file be licensed under the Apache-2.0 license or a
     */
     * the worst (most-progressed) state across primary and all secondary writers.
        FileInfos result = builder.build();
        try {
     * a rollback that itself throws propagates to DFAE, which fails the engine so
        RowIdMapping rowIdMapping = primaryFileInfos.rowIdMapping();
        if (rowIdMapping != null) {
                worst = worse(worst, w.state());
    @Override
        if (primaryFormat.name().equals(formatName)) return Optional.of(primaryWriter);
        Map<DataFormat, Writer<DocumentInput<?>>> secondaries = new IdentityHashMap<>();
        }
        }
 *
            }
            worst = worse(worst, primary.state());
import java.util.Collections;
    @Override
     * Constructs a CompositeWriter from the given engine and writer generation.
            .stream()
                        + "]";
     * Creates a per-format {@link Writer} for each delegate engine (primary first, then
        statsTracker.incWriteTotal();
        this.writerGeneration = config.writerGeneration();
import org.opensearch.index.engine.dataformat.Writer;
            WriterState worst = WriterState.ACTIVE;
                + " expected 0 or "
            if (result instanceof WriteResult.Failure sf) {
            failureHandler.rollback(touched, acceptedRows);
import org.opensearch.index.engine.dataformat.DataFormat;
        WriteResult primaryResult = primaryWriter.addDoc(doc.getPrimaryInput());
            }
    private final CompositeShardStatsTracker statsTracker;
            allWriters.addAll(secondaryWritersByFormat.values());
            + (1 + secondaryInputs.size());
import org.opensearch.composite.stats.CompositeShardStatsTracker;
            statsTracker.incWritePrimaryFailures();
                + result.writerFilesMap().size()
import java.util.List;
            IOUtils.closeWhileHandlingException(primaryWriter);
     * @param engine the composite indexing execution engine
    @Override
                    : "Secondary writer mapping version ["
        assert result.writerFilesMap().isEmpty() || result.writerFilesMap().size() == expectedFormats
import org.opensearch.index.engine.dataformat.WriteResult;
         * {@code acceptedRows}. Each writer either reaches the target or throws.
                    + fileEntry.getValue().writerGeneration()
        try {
            // without corresponding live-doc state, so drop it; orphan cleanup reclaims unpublished files.
 * A composite {@link Writer} that wraps one {@link Writer} per registered data format
    public Optional<Writer<?>> getWriterForFormat(String formatName) {
            closed = true;
        }
                builder.putWriterFileSet(fileEntry.getKey(), fileEntry.getValue());
    private static final Logger logger = LogManager.getLogger(CompositeWriter.class);
/*
            if (w.isSchemaMutable() == false) return false;
    }
    public boolean isSchemaMutable() {
            .findFirst();
import org.opensearch.index.engine.dataformat.FileInfos;
            this.mappingVersion = newVersion;
class CompositeWriter implements Writer<CompositeDocumentInput> {
    private long mappingVersion;
                    sf.cause()
        }
    }
import org.opensearch.index.engine.dataformat.WriterConfig;
        WriterState currentState = state();
            builder.rowIdMapping(rowIdMapping);
import org.opensearch.common.annotation.ExperimentalApi;
        for (Map.Entry<DataFormat, Writer<DocumentInput<?>>> entry : secondaryWritersByFormat.entrySet()) {
            IOUtils.close(allWriters);
import org.apache.logging.log4j.Logger;
    // Use IOUtils.close to ensure all writers are closed even if one throws. Each
        for (Writer<?> w : secondaryWritersByFormat.values()) {
        FileInfos primaryFileInfos = primaryWriter.flush(flushInput);
        return getWriterGeneration();
            return switch (s) {
import java.util.IdentityHashMap;
    public WriteResult addDoc(CompositeDocumentInput doc) throws IOException {
    /**
                + expectedFormats;
        touched.add(primaryWriter);
 * and delegates write operations to each per-format writer.
     * {@link #rollback} undoes the in-flight doc on each writer the composite touched;
 * delegates to create per-format writers. The primary format's writer is always first
 * in the {@code writers} list. A {@code postWrite} callback releases this writer back
            statsTracker.incMappingUpdateExecutedTotal();
    }
        this.primaryWriter = (Writer<DocumentInput<?>>) primaryDelegate.createWriter(config);
            + touched.size()
    public void updateMappingVersion(long newVersion) {
        if (doc.getRowId() != acceptedRows) {
