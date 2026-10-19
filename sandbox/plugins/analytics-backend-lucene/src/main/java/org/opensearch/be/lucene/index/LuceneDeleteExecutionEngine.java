            return;
/**
        return this.dataFormat;
    /**
        Deleter previousDeleter = generationToDeleterMap.get(previous.generation());  
        return true;  
    public DeleteResult deleteDocument(DeleteInput deleteInput, Writer<?> writer) throws IOException {
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
}
    @Override
        if (drained.isEmpty()) {  
        }
import java.util.concurrent.atomic.AtomicBoolean;  
        this.idToGen = new ConcurrentHashMap<>();
import org.opensearch.be.lucene.LuceneDataFormat;  
    private static final Logger logger = LogManager.getLogger(LuceneDeleteExecutionEngine.class);  
        } finally {  
        }
                LuceneShardStatsTracker tracker = provider.getTracker(store.shardId());
                // The generation retired; apply the late delete to the parent writer.  
     * the first update or delete.
import java.util.concurrent.ConcurrentMap;
            if (location.generation() == generation) {
    }  
    }  
     * Registers a deleter for the writer's Lucene delegate. A missing delegate is tolerated until  
import java.util.Set;
    private final Map<Long, Deleter> generationToDeleterMap;
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
            previousDeleter.recordPositionalDelete(previous.rowId());
import org.opensearch.index.engine.dataformat.RefreshInput;
    private final ConcurrentMap<String, DocumentLocation> idToGen;
    }  
    private void recordPreviousPositionalDelete(String id) {
import java.util.LinkedHashSet;
 * The OpenSearch Contributors require contributions made to  
        LuceneCommitter luceneCommitter = (LuceneCommitter) committer;  
    public LuceneDeleteExecutionEngine(DataFormat dataFormat, Committer committer) {
                    );
    public boolean onWriterCheckedOut(long generation) throws IOException {  
 * @opensearch.experimental
        }
    public Deleter createDeleter(Writer<?> writer) {
        });
import org.opensearch.index.mapper.Uid;  
     * removed when their generation is checked out.  
import java.util.concurrent.ConcurrentHashMap;  
        long start = System.nanoTime();  
            );  
 * compatible open source license.
                recordPreviousPositionalDelete(deleteInput.id());  
                    throw new IllegalArgumentException(
public class LuceneDeleteExecutionEngine implements DeleteExecutionEngine<DataFormat> {
    private final DataFormat dataFormat;  
    }
        for (Deleter deleter : generationToDeleterMap.values()) {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.engine.dataformat.Writer;  
        idToGen.forEach((trackedId, location) -> {  
            terms[i++] = new Term(IdFieldMapper.NAME, Uid.encodeId(deletedId));
    private static final int ESTIMATED_ID_LENGTH = 24;  
import org.apache.lucene.index.MergeIndexWriter;  
        if (previousDeleter != null) {
    }  
            if (currentDeleter == null) {  
        parentWriter.deleteDocuments(terms);
        }
        if (deleter == null) {
import org.opensearch.index.engine.dataformat.DeleterImpl;
    }
import org.apache.lucene.index.Term;
        DocumentLocation previous = idToGen.get(id);
    private final Store store;  
        Term[] terms = new Term[uniqueIds.size()];
    private final AtomicBoolean parentDeleteApplied = new AtomicBoolean();
        try {
        return total;
                parentDeleteApplied.set(true);
            }  
        Set<String> uniqueIds = new LinkedHashSet<>(drained);
        generationToDeleterMap.clear();
                            + "(requires a format such as Lucene)"  
     * Returns heap used by active document-location and buffered-delete state. Location entries are
import org.apache.logging.log4j.LogManager;
    }
                        "Update/delete is not supported for this index: no delete-applicable data format "
    @Override
        // Resolve the Lucene delegate instead of casting the top-level writer, which may be composite.
/*  
import org.opensearch.index.engine.exec.commit.Committer;
            assert currentDeleter.isActive() : "current-gen deleter must be active while caller holds the writer lock; gen="  
        this.store = luceneCommitter.getStore();
        idToGen.clear();
 * Tracks per-generation Lucene deleters and document locations for updates and deletes.  
        }
                parentWriter.deleteDocuments(new Term(IdFieldMapper.NAME, Uid.encodeId(deleteInput.id())));
import org.apache.lucene.util.RamUsageEstimator;
        }  
 */  
                    tracker.incDeleteTotal();
import org.opensearch.index.engine.dataformat.DataFormat;  
        idToGen.put(id, location);
    @Override
import java.util.Map;  
    private static final long BYTES_PER_ID_TO_GEN_ENTRY = RamUsageEstimator.HASHTABLE_RAM_BYTES_PER_ENTRY + RamUsageEstimator
        for (String deletedId : uniqueIds) {
            Deleter currentDeleter = generationToDeleterMap.get(deleteInput.generation());
                if (tracker != null) {  
import org.opensearch.index.engine.dataformat.Deleter;
        this.parentWriter = luceneCommitter.getIndexWriter();
    }
 * SPDX-License-Identifier: Apache-2.0
        Deleter deleter = generationToDeleterMap.remove(generation);  
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {  
        this.dataFormat = dataFormat;
import org.opensearch.index.engine.dataformat.DeleteInput;
import org.opensearch.index.engine.dataformat.DeleteResult;  
        // Conditional removal prevents a concurrent write from losing a re-added entry.
        this.generationToDeleterMap = new ConcurrentHashMap<>();  
     */
            generationToDeleterMap.put(writer.generation(), deleter);
            LuceneStatsProvider provider = (LuceneStatsProvider) DataFormatStatsProviderRegistry.INSTANCE.get(
        .shallowSizeOfInstance(DocumentLocation.class) + RamUsageEstimator.sizeOf("0".repeat(ESTIMATED_ID_LENGTH));  
import org.opensearch.index.store.Store;
    }
                idToGen.remove(trackedId, location);
import java.util.concurrent.TimeUnit;
     */
                    tracker.addDeleteTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
            return deleter;  
        }
                + deleteInput.generation();
    @Override
            recordPreviousPositionalDelete(deleteInput.id());
        return null;
            deleter.close();
            return parentDeleted;
                }  
                }
            if (provider != null) {
 */  
    public DataFormat getDataFormat() {  
                if (writer.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME).isEmpty()) {  
        }  
import org.apache.logging.log4j.Logger;
            }
import java.util.Queue;
        return null;
    public void recordWrite(String id, DocumentLocation location) {  
    /** Records a positional delete for the tracked previous copy, if its generation is active. */  
        }  
    @Override
        int i = 0;  
        boolean parentDeleted = parentDeleteApplied.getAndSet(false);
        if (writer.getWriterForFormat(LuceneDataFormat.LUCENE_FORMAT_NAME).orElse(null) instanceof LuceneWriter luceneWriter) {  
        for (Deleter deleter : generationToDeleterMap.values()) {
 *
                // A missing deleter means either the index has no Lucene delegate or the generation
    @Override
            return new DeleteResult.Success(1L, 1L, 1L);
            Deleter deleter = new DeleterImpl<>(luceneWriter);
        long total = idToGen.size() * BYTES_PER_ID_TO_GEN_ENTRY;
                // retired. The locked writer distinguishes these cases.
            total += deleter.ramBytesUsed();  
    public void close() throws IOException {
 *
            return parentDeleted;
    private final MergeIndexWriter parentWriter;
            }
import org.opensearch.index.engine.dataformat.DocumentLocation;  
    /**
import org.opensearch.index.mapper.IdFieldMapper;
    public long ramBytesUsed() {  
        if (previous == null) {  
                return new DeleteResult.Success(1L, 1L, 1L);
package org.opensearch.be.lucene.index;
            currentDeleter.recordBufferedDeletes(deleteInput.id());  
    }  
import java.io.IOException;
    @Override
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
import org.opensearch.index.engine.dataformat.RefreshResult;
    @Override  
        Queue<String> drained = deleter.deactivate();
                LuceneStatsProvider.FORMAT_NAME
