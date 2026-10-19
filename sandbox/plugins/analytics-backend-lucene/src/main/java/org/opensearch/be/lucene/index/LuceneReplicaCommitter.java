    }
 */  
            sis.changed();
        }
        store.commitSegmentInfos(sis);
    private void ensureOpen() {
        }
        // use last committed one only
        // (set by SegmentReplicationTarget during replication), clone it so the commit on
        Map<String, String> userData = new HashMap<>(sis.userData);
        SegmentInfos sis = getSegmentInfos(commitInput.catalogSnapshot());
            store.decRef();
 * {@code segments_N} files from the store directory.
import java.util.concurrent.atomic.AtomicBoolean;  
    @Override
     */
     * (which races with concurrent segment replication and surfaces as Store corruption).  
    @Override
        return null;
            sis = lastCommittedSegmentInfos;  
import java.util.Objects;
    }  
    public static SegmentInfos getSegmentInfos(CatalogSnapshot catalogSnapshot) {
            sis.counter = store.readLastCommittedSegmentsInfo().counter + commitInput.bumpCounter();  
 * SPDX-License-Identifier: Apache-2.0
    public boolean isCommitManagedFile(String fileName) {
    public Map<String, String> getLastCommittedData() throws IOException {  
        // disk contains the real Lucene segment entries. This is critical for primary  
        }
            sis = sis.clone();
 * The OpenSearch Contributors require contributions made to  
 * Replica-side {@link Committer} implementation backed by Lucene's {@link SegmentInfos} commit mechanism.  
import org.apache.lucene.index.IndexFileNames;
/*  
        return fileName.startsWith(IndexFileNames.SEGMENTS) || IndexWriter.WRITE_LOCK_NAME.equals(fileName);  
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
package org.opensearch.be.lucene.index;
    @Override  
import org.apache.lucene.index.SegmentInfos;  
import java.util.Map;
    private final AtomicBoolean isClosed = new AtomicBoolean();
        return loadCommittedSnapshots(store).values().stream().filter(Objects::nonNull).collect(Collectors.toList());
 * using {@link Store#commitSegmentInfos(SegmentInfos, long, long)}. This is appropriate for replicas
    public void deleteCommit(CatalogSnapshot snapshot) throws IOException {  
        sis.setUserData(userData, false);  
    }  
        SegmentInfos committed = SegmentInfos.readLatestCommit(store.directory());
        // empty commit and any Lucene secondary-format files become orphans.  
import java.util.stream.Collectors;
        // promotion: when this replica is later promoted, the new IndexWriter must open on
    public void close() throws IOException {
        assert sis.userData.equals(committed.getUserData()) : "Committer user data is different from requested user data";  
        }  
        if (isClosed.compareAndSet(false, true)) {  
    @Override
 * the user data (containing the serialized {@link CatalogSnapshot}), and writes it as a new commit.
    /**
 * The commit path clones the primary's {@link SegmentInfos} (received during replication), injects
 * compatible open source license.
    private volatile SegmentInfos lastCommittedSegmentInfos;
 * that receive segments via segment replication and only need to persist the commit point.
        // a commit that includes all Lucene segments. Without this, the IndexWriter sees an
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        } else {
    public synchronized CommitResult commit(CommitInput commitInput) throws IOException {  
            // We got a catalog snapshot as part of finalize replication
        assert sis.getGeneration() == committed.getGeneration() : "Committed generation is different from requested generation";
            userData.put(entries.getKey(), entries.getValue());
        long version = LuceneVersionConverter.encode(committed.getCommitLuceneVersion());  
        if (commitInput.bumpCounter() > 0) {
        for (Map.Entry<String, String> entries : commitInput.userData()) {  
        ensureOpen();  
        store.deleteQuiet(snapshot.getLastCommitFileName());
    public List<CatalogSnapshot> listCommittedSnapshots() throws IOException {
public class LuceneReplicaCommitter implements Committer {
    @Override
    @Override
 * The {@link #listCommittedSnapshots()} method discovers existing commits by reading all  
import org.opensearch.index.store.Store;
        }
        this.lastCommittedSegmentInfos = committed;
        store.directory().sync(commitInput.catalogSnapshot().getFiles(true));
        if (isClosed.get()) {  
        if (sis == null) {
import java.util.List;  
import org.opensearch.index.engine.CommitStats;
            return (SegmentInfos) dfacs.getReplicatingCommitData();
    @Override
    }
import org.opensearch.index.engine.exec.commit.Committer;
 */
import java.io.IOException;  
import static org.opensearch.be.lucene.index.LuceneCommitter.loadCommittedSnapshots;  
        return new CommitResult(committed.getSegmentsFileName(), committed.getGeneration(), version);
        return new CommitStats(lastCommittedSegmentInfos);
import org.opensearch.index.engine.exec.commit.CommitterConfig;  
    }  
        // Build the SegmentInfos to commit. If the primary's SegmentInfos is available
    @Override
 * <p>  
    private final Store store;
 * operates without a writer — it directly writes {@code segments_N} files to the store directory  
    }
 * <p>
        return lastCommittedSegmentInfos.getUserData();
        // Encode writer's Lucene version as a long — keeps CatalogSnapshot Lucene-type-agnostic.
 *
import java.util.HashMap;
            throw new IllegalStateException("LuceneCommitter is closed");
/**
import org.apache.lucene.index.IndexWriter;
 * this file be licensed under the Apache-2.0 license or a
import java.io.UnsupportedEncodingException;
 *
    public CommitStats getCommitStats() {  
    public LuceneReplicaCommitter(CommitterConfig committerConfig) throws IOException {  
import org.opensearch.index.engine.exec.coord.LuceneVersionConverter;  
    }  
    public byte[] serializeToCommitFormat(CatalogSnapshot catalogSnapshot) throws IOException {
        this.store = committerConfig.engineConfig().getStore();
}
     * Returns commit stats from the cached {@link SegmentInfos} to avoid a per-call disk read
    }
        this.lastCommittedSegmentInfos = store.readLastCommittedSegmentsInfo();
        }
    }
    }  
    }  
            sis.updateGeneration(lastCommittedSegmentInfos);  
 * Unlike the primary's {@link LuceneCommitter} which owns an {@link IndexWriter}, this committer
        if (catalogSnapshot instanceof DataformatAwareCatalogSnapshot dfacs) {  
 * @opensearch.experimental  
        throw new UnsupportedEncodingException("serialization is only for uploads. store committer is for replicas");
