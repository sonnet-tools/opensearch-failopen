    private final MergeIndexWriter parentWriter;
            );
 */
import org.opensearch.index.mapper.Uid;
        this.idToGen = new ConcurrentHashMap<>();
    @Override
    @Override
    public DeleteResult deleteDocument(DeleteInput deleteInput, Writer<?> writer) throws IOException {
        if (deleter == null) {
    }
                    );
        Set<String> uniqueIds = new LinkedHashSet<>(drained);
    }
            return parentDeleted;
import java.util.Queue;
            terms[i++] = new Term(IdFieldMapper.NAME, Uid.encodeId(deletedId));
import org.opensearch.index.engine.exec.commit.Committer;
                // The generation retired; apply the late delete to the parent writer.
    /** Records a positional delete for the tracked previous copy, if its generation is active. */
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
package org.opensearch.be.lucene.index;
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
        Deleter previousDeleter = generationToDeleterMap.get(previous.generation());
import org.opensearch.index.mapper.IdFieldMapper;
        return true;
        }
        DocumentLocation previous = idToGen.get(id);
import org.opensearch.index.engine.dataformat.Deleter;
    private final DataFormat dataFormat;
        }
        });
    /**
        return total;
}
                if (tracker != null) {
        return this.dataFormat;
        }
        if (drained.isEmpty()) {
        return null;
            previousDeleter.recordPositionalDelete(previous.rowId());
    @Override
            currentDeleter.recordBufferedDeletes(deleteInput.id());
 */
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
                LuceneShardStatsTracker tracker = provider.getTracker(store.shardId());
        this.generationToDeleterMap = new ConcurrentHashMap<>();
     * Registers a deleter for the writer's Lucene delegate. A missing delegate is tolerated until
 * compatible open source license.
    }
            return new DeleteResult.Success(1L, 1L, 1L);
import org.opensearch.index.engine.dataformat.Writer;
        Deleter deleter = generationToDeleterMap.remove(generation);
    private static final long BYTES_PER_ID_TO_GEN_ENTRY = RamUsageEstimator.HASHTABLE_RAM_BYTES_PER_ENTRY + RamUsageEstimator
import org.opensearch.index.engine.dataformat.DeleteInput;
    @Override
     * removed when their generation is checked out.
        this.parentWriter = luceneCommitter.getIndexWriter();
 * @opensearch.experimental
        boolean parentDeleted = parentDeleteApplied.getAndSet(false);
        long total = idToGen.size() * BYTES_PER_ID_TO_GEN_ENTRY;
        idToGen.clear();
                // retired. The locked writer distinguishes these cases.
    public long ramBytesUsed() {
            if (location.generation() == generation) {
    public DataFormat getDataFormat() {
            Deleter deleter = new DeleterImpl<>(luceneWriter);
            generationToDeleterMap.put(writer.generation(), deleter);
import org.opensearch.index.engine.dataformat.RefreshResult;
        idToGen.put(id, location);
        }
    private static final Logger logger = LogManager.getLogger(LuceneDeleteExecutionEngine.class);
    }
            return parentDeleted;
     */
import org.apache.lucene.index.Term;
        try {
import org.opensearch.index.engine.dataformat.RefreshInput;
            return;
                LuceneStatsProvider.FORMAT_NAME
    public Deleter createDeleter(Writer<?> writer) {
        }
    public LuceneDeleteExecutionEngine(DataFormat dataFormat, Committer committer) {
import java.util.concurrent.atomic.AtomicBoolean;
        Queue<String> drained = deleter.deactivate();
import org.opensearch.index.engine.dataformat.DeleteResult;
 * Tracks per-generation Lucene deleters and document locations for updates and deletes.
    @Override
import org.apache.lucene.index.MergeIndexWriter;
        } finally {
    }
 * The OpenSearch Contributors require contributions made to
            assert currentDeleter.isActive() : "current-gen deleter must be active while caller holds the writer lock; gen="
            }
    /**
import org.opensearch.index.store.Store;
                // A missing deleter means either the index has no Lucene delegate or the generation
            if (currentDeleter == null) {
        // Resolve the Lucene delegate instead of casting the top-level writer, which may be composite.
    public void recordWrite(String id, DocumentLocation location) {
            total += deleter.ramBytesUsed();
import org.opensearch.be.lucene.LuceneDataFormat;
        if (previous == null) {
    }
            Deleter currentDeleter = generationToDeleterMap.get(deleteInput.generation());
        }
            }
                + deleteInput.generation();
import org.apache.logging.log4j.Logger;
        LuceneCommitter luceneCommitter = (LuceneCommitter) committer;
                return new DeleteResult.Success(1L, 1L, 1L);
 *
                recordPreviousPositionalDelete(deleteInput.id());
        long start = System.nanoTime();
    }
    private final Map<Long, Deleter> generationToDeleterMap;
            deleter.close();
 * this file be licensed under the Apache-2.0 license or a
                parentWriter.deleteDocuments(new Term(IdFieldMapper.NAME, Uid.encodeId(deleteInput.id())));
    private final Store store;
            }
    }
        generationToDeleterMap.clear();
    private void recordPreviousPositionalDelete(String id) {
        // Conditional removal prevents a concurrent write from losing a re-added entry.
public class LuceneDeleteExecutionEngine implements DeleteExecutionEngine<DataFormat> {
        if (previousDeleter != null) {
        }
                            + "(requires a format such as Lucene)"
        parentWriter.deleteDocuments(terms);
 * SPDX-License-Identifier: Apache-2.0
        for (Deleter deleter : generationToDeleterMap.values()) {
    public void close() throws IOException {
import java.util.LinkedHashSet;
    private static final int ESTIMATED_ID_LENGTH = 24;
 *
     * the first update or delete.
            if (provider != null) {
            recordPreviousPositionalDelete(deleteInput.id());
     * Returns heap used by active document-location and buffered-delete state. Location entries are
        return null;
import org.apache.logging.log4j.LogManager;
        }
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
        idToGen.forEach((trackedId, location) -> {
            LuceneStatsProvider provider = (LuceneStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
import java.util.concurrent.TimeUnit;
                    tracker.addDeleteTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
    }
        for (Deleter deleter : generationToDeleterMap.values()) {
import java.util.Map;
                }
import org.opensearch.index.engine.dataformat.DataFormat;
                    tracker.incDeleteTotal();
    private final ConcurrentMap<String, DocumentLocation> idToGen;
        }
        for (String deletedId : uniqueIds) {
    private final AtomicBoolean parentDeleteApplied = new AtomicBoolean();
/*
    @Override
        .shallowSizeOfInstance(DocumentLocation.class) + RamUsageEstimator.sizeOf("0".repeat(ESTIMATED_ID_LENGTH));
    @Override
import java.util.Set;
        this.dataFormat = dataFormat;
import org.opensearch.index.engine.dataformat.DeleterImpl;
import org.opensearch.index.engine.dataformat.DocumentLocation;
                if (writer.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME).isEmpty()) {
    public boolean onWriterCheckedOut(long generation) throws IOException {
    }
                parentDeleteApplied.set(true);
     */
            return deleter;
    @Override
                }
import java.io.IOException;
                        "Update/delete is not supported for this index: no delete-applicable data format "
/**
import org.apache.lucene.util.RamUsageEstimator;
        this.store = luceneCommitter.getStore();
                idToGen.remove(trackedId, location);
        if (writer.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME).orElse(null) instanceof LuceneWriter luceneWriter) {
        int i = 0;
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
        Term[] terms = new Term[uniqueIds.size()];
                    throw new IllegalArgumentException(
