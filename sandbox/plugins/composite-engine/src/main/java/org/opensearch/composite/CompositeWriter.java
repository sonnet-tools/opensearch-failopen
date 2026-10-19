    @Override
            for (Writer<?> w : secondaryWritersByFormat.values()) {  
            for (Writer<DocumentInput<?>> w : touched) {
            allWriters.addAll(secondaryWritersByFormat.values());  
    public WriteResult addDoc(CompositeDocumentInput doc) throws IOException {  
     * recovery can replay the translog.
            return worst;
        // Count every write attempt so write_*_failures can be read as a rate.
import java.util.Map;
                        + secondary.mappingVersion()
import org.apache.logging.log4j.Logger;
                );
        try {  
        FlushInput secondaryFlushInput = rowIdMapping != null ? new FlushInput(rowIdMapping) : FlushInput.EMPTY;
                    sf.cause()
    @Override
            .<Writer<?>>map(Map.Entry::getValue)
    private final CompositeShardStatsTracker statsTracker;
                    + writerGeneration  
     * @return the writer generation
        }  
    }
    private long mappingVersion;  
            WriterState worst = WriterState.ACTIVE;  
 *  
        if (primaryResult instanceof WriteResult.Failure pf) {
            return new WriteResult.Failure(pf.cause(), -1, -1, -1);  
            }  
        WriteResult primaryResult = primaryWriter.addDoc(doc.getPrimaryInput());
package org.opensearch.composite;
import java.util.Collections;
        FileInfos.Builder builder = FileInfos.builder();  
 * <p>
                case PENDING_ROLLBACK -> 2;
            }
    public FileInfos flush(FlushInput flushInput) throws IOException {
    public long mappingVersion() {
        for (Map.Entry<DataFormat, Writer<DocumentInput<?>>> entry : secondaryWritersByFormat.entrySet()) {
            worst = worse(worst, primary.state());
 * @opensearch.experimental
    private final Writer<DocumentInput<?>> primaryWriter;  
        if (result.writerFilesMap().isEmpty() == false && result.writerFilesMap().size() < expectedFormats) {
                case RETIRED_FLUSHABLE -> 1;  
            allWriters.add(primaryWriter);
        int expectedFormats = 1 + secondaryWritersByFormat.size();  
            Writer<DocumentInput<?>> primary,
            return switch (s) {
    private final FailureHandlerStrategy failureHandler;  
}  
                        + "] must match primary ["  
    }
    @Override
        this.mappingVersion = primaryWriter.mappingVersion();
            + " expected="
                statsTracker.incWriteSecondaryFailures();
/**
     * Returns the writer generation number.  
        }
        }  
 * delegates to create per-format writers. The primary format's writer is always first  
            List<Closeable> allWriters = new ArrayList<>(1 + secondaryWritersByFormat.size());
                    : "Secondary writer mapping version ["
     * Per-composite failure-handling helper. Owns rollback orchestration and aggregates  
    /**
            }  
 * in the {@code writers} list. A {@code postWrite} callback releases this writer back
            statsTracker.incWritePrimaryFailures();  
import java.io.Closeable;
        Map<DataFormat, Writer<DocumentInput<?>>> secondaries = new IdentityHashMap<>();
        // Flush primary first to capture the row ID mapping that secondaries need.
        }
        return writerGeneration;
    private final DataFormat primaryFormat;
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
        }  
                secondaries.put(delegate.getDataFormat(), secondary);  
    // LuceneWriter.close() triggers indexWriter.rollback() → NativeFSLock.close() →
        return mappingVersion;  
    }
        List<Writer<DocumentInput<?>>> touched = new ArrayList<>();
                return new WriteResult.Failure(sf.cause(), -1, -1, -1);
     */
    /**
        RowIdMapping rowIdMapping = primaryFileInfos.rowIdMapping();
 * The OpenSearch Contributors require contributions made to  
        if (primaryFormat.name().equals(formatName)) return Optional.of(primaryWriter);  
            );
        }
 */  
/*  
        // Close already-created writers if a secondary createWriter() fails. LuceneWriter
    @Override  
            .stream()
    }
    // Use IOUtils.close to ensure all writers are closed even if one throws. Each  
                builder.putWriterFileSet(fileEntry.getKey(), fileEntry.getValue());
            throw e;
        }
         * Rolls back each writer in {@code touched} to the composite's current  
import java.util.ArrayList;  
        return primaryResult;
     * secondaries) and a fresh {@link FailureHandlerStrategy} that lives for the writer's lifetime.
        for (Writer<?> w : secondaryWritersByFormat.values()) {
            IOUtils.closeWhileHandlingException(primaryWriter);  
class CompositeWriter implements Writer<CompositeDocumentInput> {
        if (doc.getRowId() != acceptedRows) {  
        try {  
    public void updateMappingVersion(long newVersion) {
 * this file be licensed under the Apache-2.0 license or a
    /**
                        + this.mappingVersion
        return failureHandler.aggregateState(closed, primaryWriter, secondaryWritersByFormat.values());
            return FileInfos.empty();
            .filter(e -> e.getKey().name().equals(formatName))  
        }
                () -> new ParameterizedMessage("Failed to add document in primary format [{}], rolling back", primaryFormat.name()),
        Optional<WriterFileSet> primaryWfs = primaryFileInfos.getWriterFileSet(primaryFormat);
                    () -> new ParameterizedMessage("Failed to add document in secondary format [{}], rolling back", format.name()),  
import java.util.IdentityHashMap;
        /**
    /** Successful addDoc count — every incoming rowId must equal this. */
            closed = true;  
        this.failureHandler = new FailureHandlerStrategy();
            throw new IllegalStateException("Cannot add document to writer in state " + currentState);  
            primaryWriter.updateMappingVersion(newVersion);
            return rank(a) >= rank(b) ? a : b;  
     * the worst (most-progressed) state across primary and all secondary writers.
     * <p>  
            builder.rowIdMapping(rowIdMapping);  
                worst = worse(worst, w.state());  
import org.opensearch.index.engine.exec.WriterFileSet;
        for (Map.Entry<DataFormat, DocumentInput<?>> inputEntry : secondaryInputs.entrySet()) {
                assert fileEntry.getValue().writerGeneration() == writerGeneration : "secondary WriterFileSet generation ["
        touched.add(primaryWriter);  
            // A generation must publish every format or none. Partial output could expose primary rows
     * a rollback that itself throws propagates to DFAE, which fails the engine so  
        if (newVersion > this.mappingVersion) {
    // LOCK_HELD.remove(path). Without this, a throwing primary.close() would skip
     * @param engine the composite indexing execution engine
            IOUtils.close(allWriters);
import org.opensearch.composite.stats.CompositeShardStatsTracker;  
    private static final Logger logger = LogManager.getLogger(CompositeWriter.class);  
            java.util.Collection<Writer<DocumentInput<?>>> secondaries  
                pf.cause()  
import org.opensearch.index.engine.dataformat.WriterConfig;  
     *  
        }
     */  
        // generation counter re-produces the same value, a LockObtainFailedException is thrown.
 * compatible open source license.
            throw new IllegalStateException("rowId [" + doc.getRowId() + "] does not match accepted row count [" + acceptedRows + "]");
import org.opensearch.index.engine.dataformat.WriterState;
                    + fileEntry.getValue().writerGeneration()
            };  
            DataFormat format = inputEntry.getKey();
                    + "]";
     * sub-writer states into the single {@link WriterState} the engine acts on.
    /**
            + touched.size()  
     * @param config the writer configuration
        }
    }  
        // Roll back exactly the writers we've called addDoc on, in order.
    @Override  
            }  
         * {@code acceptedRows}. Each writer either reaches the target or throws.
import org.opensearch.common.annotation.ExperimentalApi;
     * {@link #rollback} undoes the in-flight doc on each writer the composite touched;
        if (rowIdMapping != null) {
            WriteResult result = writer.addDoc(inputEntry.getValue());
    public Optional<Writer<?>> getWriterForFormat(String formatName) {
    private volatile boolean closed;
            for (Map.Entry<DataFormat, WriterFileSet> fileEntry : fileInfos.writerFilesMap().entrySet()) {  
                + expectedFormats;
            + (1 + secondaryInputs.size());
        this.writerGeneration = config.writerGeneration();  
            }
        IndexingExecutionEngine<?, ?> primaryDelegate = engine.getPrimaryDelegate();
import org.opensearch.index.engine.dataformat.DataFormat;
        // acquires a NativeFSLock on construction, tracked in a static LOCK_HELD set. If not
     */  
 */
     */  
    }  
import org.opensearch.index.engine.dataformat.Writer;
                w.rollbackTo(targetRowCount);
                Writer<DocumentInput<?>> secondary = (Writer<DocumentInput<?>>) delegate.createWriter(config);
        }
    /**
        assert touched.size() == 1 + secondaryInputs.size() : "all writers must succeed if we reach here; touched="
 *
import org.opensearch.index.engine.dataformat.WriteResult;
        return result;
     */
            : "flush must produce files for all formats or none; got "
        return true;
        return getWriterGeneration();
     *
    long getWriterGeneration() {
        this.statsTracker = engine.statsTracker();
    }
        assert result.writerFilesMap().isEmpty() || result.writerFilesMap().size() == expectedFormats  
                IOUtils.closeWhileHandlingException(w);
        return secondaryWritersByFormat.entrySet()
    @SuppressWarnings("unchecked")
import org.apache.logging.log4j.message.ParameterizedMessage;  
     * Constructs a CompositeWriter from the given engine and writer generation.
        Map<DataFormat, DocumentInput<?>> secondaryInputs = doc.getSecondaryInputs();  
import java.util.Optional;
    @Override
    // secondary close, leaking the lock and causing LockObtainFailedException on restart.  
import java.util.List;  
    private long acceptedRows = 0L;
     * Returns the lifecycle state aggregated by the composite's {@link FailureHandlerStrategy} —  
 * Constructed from a {@link CompositeIndexingExecutionEngine}, it iterates the engine's
                        + "]";
        ) {
    @Override
            Writer<DocumentInput<?>> writer = secondaryWritersByFormat.get(format);  
    }  
                w.updateMappingVersion(newVersion);
import org.opensearch.index.engine.dataformat.FileInfos;  
                    + "] must match composite writer generation ["
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.index.engine.dataformat.FlushInput;
    }
 * and delegates write operations to each per-format writer.  
import org.apache.logging.log4j.LogManager;
        if (primaryWriter.isSchemaMutable() == false) return false;  
@ExperimentalApi  
    public long generation() {  
import org.opensearch.index.engine.dataformat.RowIdMapping;  
    }  
    public boolean isSchemaMutable() {
                case CLOSED -> 3;
     * Creates a per-format {@link Writer} for each delegate engine (primary first, then
            boolean closed,
                + " expected 0 or "  
            statsTracker.incMappingUpdateExecutedTotal();  
    CompositeWriter(CompositeIndexingExecutionEngine engine, WriterConfig config) {
            .findFirst();
        // closed, the path remains in LOCK_HELD and on engine restart (same JVM) when the  
        WriterState aggregateState(  
            for (Writer<DocumentInput<?>> w : secondaries.values()) {
    }  
        this.primaryWriter = (Writer<DocumentInput<?>>) primaryDelegate.createWriter(config);
                assert secondary.isSchemaMutable() && secondary.mappingVersion() >= this.mappingVersion  
         */
                case ACTIVE -> 0;
        private static int rank(WriterState s) {  
    private static final class FailureHandlerStrategy {  
    private final long writerGeneration;
        }
        private static WriterState worse(WriterState a, WriterState b) {
    }
                    + fileEntry.getKey().name()
        this.secondaryWritersByFormat = Collections.unmodifiableMap(secondaries);  
                logger.warn(
    public WriterState state() {
        } catch (Exception e) {
        void rollback(List<Writer<DocumentInput<?>>> touched, long targetRowCount) throws IOException {  
            for (IndexingExecutionEngine<?, ?> delegate : engine.getSecondaryDelegates()) {
 * A composite {@link Writer} that wraps one {@link Writer} per registered data format
        this.primaryFormat = primaryDelegate.getDataFormat();  
        statsTracker.incWriteTotal();
            if (result instanceof WriteResult.Failure sf) {  
        primaryWfs.ifPresent(writerFileSet -> builder.putWriterFileSet(primaryFormat, writerFileSet));
        } finally {
                failureHandler.rollback(touched, acceptedRows);  
                    + "] for format ["  
            if (w.isSchemaMutable() == false) return false;
 * to the pool after each write cycle.
        acceptedRows++;  
            for (Writer<?> w : secondaries) {
        if (currentState != WriterState.ACTIVE) {
    @Override
     * Searches primary and secondary formats by {@link DataFormat#name()}.
 * SPDX-License-Identifier: Apache-2.0
            // without corresponding live-doc state, so drop it; orphan cleanup reclaims unpublished files.  
            }
import java.io.IOException;
            logger.warn(
        WriterState currentState = state();
            failureHandler.rollback(touched, acceptedRows);
import org.opensearch.index.engine.dataformat.DocumentInput;
            FileInfos fileInfos = entry.getValue().flush(secondaryFlushInput);
        FileInfos primaryFileInfos = primaryWriter.flush(flushInput);  
        }
            touched.add(writer);
                + result.writerFilesMap().size()
    public void close() throws IOException {
        }  
        }
            if (closed) return WriterState.CLOSED;
        FileInfos result = builder.build();
    private final Map<DataFormat, Writer<DocumentInput<?>>> secondaryWritersByFormat;
            }
    @Override
            this.mappingVersion = newVersion;
