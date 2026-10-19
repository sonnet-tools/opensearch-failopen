        if (store.tryIncRef() == false) {  
    @Override
        DataformatAwareCatalogSnapshot snapshot = (DataformatAwareCatalogSnapshot) CatalogSnapshotManager.createInitialSnapshot(
    private final Store store;
 * this file be licensed under the Apache-2.0 license or a
    public List<CatalogSnapshot> listCommittedSnapshots() {  
        return markCorruptedCalled;
import java.util.Map;  
    public CommitStats getCommitStats() {
    public void markStoreCorrupted(IOException cause) {
        this.store = store;
    }
    public void deleteCommit(CatalogSnapshot snapshot) {}
    }  
        try {  
        this.markCorruptedCalled = v;
            committedData
    private final long initialCommitGeneration;
    @Override
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
package org.opensearch.index.engine.dataformat.stub;
    private volatile Map<String, String> committedData;
        }
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (existing, replacement) -> replacement, HashMap::new));
import org.apache.lucene.index.SegmentInfos;
 * Lucene commit (bootstrapped in setUp), then stores subsequent commits in memory.
            0L,
            -1L,  
        this.commitFailure = supplier;  
    public boolean isCommitManagedFile(String fileName) {
}
            List.of(),
    }  
import java.util.HashMap;
    public Map<String, String> getLastCommittedData() {  
import org.opensearch.index.store.Store;
            0L,
 * SPDX-License-Identifier: Apache-2.0
    }
            return;
    private volatile boolean markCorruptedCalled;  
                throw new IOException(failure);  
            return new CommitStats(segmentInfos);
        throw new UnsupportedOperationException("InMemoryCommitter does not serialize commits");  
    @Override
            return null;
import java.util.List;
 */  
            // test stub: best-effort  
import org.opensearch.index.engine.CommitStats;
        try {  
            0L,  
 * The OpenSearch Contributors require contributions made to  
        // Test stub does not upload to remote store.
    public void setCommitFailure(Supplier<Exception> supplier) {
        return committedData;
/*  
    @Override  
    public void close() {}  
 * In-memory Committer for testing. Reads initial commit data from the store's  
        markCorruptedCalled = true;
                if (failure instanceof IOException) throw (IOException) failure;
        }
        this.initialCommitGeneration = segmentInfos.getGeneration();
    public byte[] serializeToCommitFormat(CatalogSnapshot snapshot) {
    }
        } finally {
import java.util.stream.Collectors;
        return List.of(snapshot);
 * compatible open source license.
    @Override
    public void setMarkCorruptedCalled(boolean v) {
    @Override
 *
            Exception failure = supplier.get();  
    }  
import org.opensearch.index.engine.exec.commit.Committer;  
        this.committedData = StreamSupport.stream(commitData.userData().spliterator(), false)  
    }
        } catch (IOException e) {  
        return fileName.startsWith("segments_") || fileName.equals("write.lock");  
        );
        snapshot.setLastCommitInfo("segments_" + initialCommitGeneration, initialCommitGeneration, 0L);  
    public CommitResult commit(CommitInput commitData) throws IOException {  
        }
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
        if (supplier != null) {
        this.committedData = Map.copyOf(segmentInfos.getUserData());  
    @Override
        Supplier<Exception> supplier = commitFailure;
    }  
            SegmentInfos segmentInfos = store.readLastCommittedSegmentsInfo();
            store.decRef();
import java.io.IOException;  
 */
    @Override
    }
            if (failure != null) {
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;  
    }
        }  
public class InMemoryCommitter implements Committer {  
/**
    @Override  
    }
import java.util.function.Supplier;
    private volatile Supplier<Exception> commitFailure;
import java.util.stream.StreamSupport;  
        } catch (IOException ignored) {
        SegmentInfos segmentInfos = store.readLastCommittedSegmentsInfo();
            }
            store.markStoreCorrupted(cause);
    public boolean isMarkCorruptedCalled() {  
        return null;
    public InMemoryCommitter(Store store) throws IOException {
