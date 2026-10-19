        String getCriteriaForDoc(BytesRef key) {
            lock1.close();
        // IndexWriter.  
 */  
        Term uid = new Term(IdFieldMapper.NAME, DUMMY_TOMBSTONE_DOC_ID);  
    private long ramBytesUsedUtil(LiveIndexWriterDeletesMap currentLiveIndexWriterDeletesMap) {
            nativeIndexWriterFactory.createWriter(
     */
        }
        for (DisposableIndexWriter disposableIndexWriter : currentLiveIndexWriterDeletesMap.current.criteriaBasedIndexWriterMap.values()) {
                new CriteriaBasedIndexWriterLookup(
    public Map<BytesRef, DeleteEntry> getLastDeleteEntrySet() {
        if (closed.get() == true) {  
    // has uncommited changes, we report it as writer having uncommited changes. Since during add indexes new set of changes will be added.
                ramBytesUsed += disposableIndexWriter.getIndexWriter().ramBytesUsed();  
            } finally {
        for (DisposableIndexWriter disposableIndexWriter : currentLiveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap.values()) {
 *
            if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {  
        return liveIndexWriterDeletesMap.old.lastDeleteEntrySet;  
            Releasable ignore = liveIndexWriterDeletesMap.old.mapWriteLock.acquire();
    public boolean isWriteLockedByCurrentThread() {  
        private final long seqNo;
                    if (lookup.isClosed()) {
            return criteria;
     *  
            this(
     *
        }
        return previousCriteria != null && previousCriteria.equals(currentCriteria) == false;
                    childWriterPendingNumDocs.incrementAndGet();
        /**
                }
                if (count == 1) {
    public final synchronized void setLiveCommitData(Iterable<Map.Entry<String, String>> commitUserData) {  
 * rotating the WriterMap. Since the write lock is acquired only when there is no  
    private void ensureOpen() throws AlreadyClosedException {
        // We obtain a read lock on a child level IndexWriter and then return it. Post Indexing completes, we close this
            current.putCriteriaForDoc(key, criteria);
            this.old = old;  
                current
            return seqNo;  
 *
                }
    public ReleasableLock getNewWriteLock() {  
     *  
        );  
    public Map<String, DisposableIndexWriter> getMarkForRefreshIndexWriterMap() {  
 * Therefore, document versions must be synchronized across IndexWriters. This is achieved
 * document is present in the version map, it queries Lucene via the searcher to look
        }
    }
    @Override  
            // this may cause updates to go out of sync with current IndexWriter.
 * by performing a partial soft delete (delete without indexing tombstone entry) on the  
                true,
    }
        return flushingBytes + accumulatingIndexWriter.getFlushingBytes();
        CompositeIndexWriter.DisposableIndexWriter oldDisposableWriter = getIndexWriterForIdFromOld(uid.bytes());
    }  
        for (DisposableIndexWriter disposableIndexWriter : currentLiveIndexWriterDeletesMap.current.criteriaBasedIndexWriterMap.values()) {  
        private boolean closed;
        }
            // This ensures writer map is not rotated during the time when we are obtaining an IndexWriter from map. As
    }
            long pendingNumDocsByOldChildWriter = childDisposableWriter.getIndexWriter().getPendingNumDocs();  
            try {
        DisposableIndexWriter computeIndexWriterIfAbsentForCriteria(  
    public void close() throws IOException {
        ) {  
            this.primaryTerm = primaryTerm;
import static org.opensearch.index.BucketedCompositeDirectory.CHILD_DIRECTORY_PREFIX;  
        boolean isCriteriaNotNull = false;  
 * OpenSearch currently utilizes ReentrantReadWriteLock to ensure the underlying
import org.opensearch.common.unit.TimeValue;  
    public void beforeRefresh() throws IOException {
    @Override  
            }
                new OpenSearchConcurrentMergeScheduler(  
                if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
        Field... softDeletesField
        CriteriaBasedWriterLock getMapReadLock() {
     * Should there be no active IndexWriter for a group, a new IndexWriter will be instantiated
     * IndexWriter associated with lookup). Composite IndexWriter syncs a lookup with accumulating IndexWriter during
            long seqNo = disposableIndexWriter.getIndexWriter().addDocument(doc);
    }
        Field... softDeletesField
        this.engineConfig = engineConfig;  
        boolean hasNewChanges() {  
            CriteriaBasedIndexWriterLookup oldMap = liveIndexWriterDeletesMap.old;
        accumulatingIndexWriter.forceMerge(maxNumSegments, doWait);
import org.apache.lucene.store.Directory;
            ShardId shardId  
        ensureOpen();
        // All writes (adds and deletes) go into here:
    @Override
     *
    public boolean hasNewIndexingOrUpdates() {
     * LiveIndexWriterDeletesMap, we should not worry about double counting due to map rotation from current to old. Also
        // Rotate map first so all new writes goes to new generation writers.  
                disposableIndexWriter.getIndexWriter().rollback();
     * This class represents a lookup entry inside LiveIndexWriterDeletesMap. This class is mapped similar to <code>
            current.putLastDeleteEntry(uid, deleteEntry);
    public synchronized void deleteUnusedFiles() throws IOException {
                final Integer current = holdingThreads.get();
    CriteriaBasedIndexWriterLookup acquireNewReadLock() {
    private FSDirectory getLocalFSDirectory(Directory localDirectory) {
         */
                    throw e;
        }
                    holdingThreads.remove();
    public Releasable obtainWriteLockOnAllMap() {  
                } else {  
                    engineConfig.getShardId(),
    @Override  
 * Version Resolution
     * This function is used for performing partial soft delete (delete without inserting a tombstone entry). This is  
     */
 * @see org.apache.lucene.index.IndexWriter  
        );
     * pendingNumDocs is used to track pendingNumDocs for child level IndexWriters. Since pendingNumDocs is incremented  
    /**
     *
        accumulatingIndexWriter.setLiveCommitData(commitUserData);
        return ramBytesUsedUtil(liveIndexWriterDeletesMap);
     *
                if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
                return disposableIndexWriter.getIndexWriter().getTragicException();
        ensureOpen();
        Document document = new Document();
        private final IndexWriter indexWriter;
    }  
        }  
        }
 * associated with the map is acquired. This lock is released when indexing completes.
    ) throws IOException {
        }
            }
        void putCriteriaForDoc(BytesRef key, String criteria) {
 * compatible open source license.
        }
import org.apache.lucene.index.LiveIndexWriterConfig;
                this.lookup = lookup;  
                    addDeleteEntryToWriter(new DeleteEntry(uid, version, seqNo, primaryTerm), currentDisposableWriter.getIndexWriter());  
 * This wrapper serves as a unified interface for coordinating write operations  
        deleteInLucene(uid, isStaleOperation, accumulatingIndexWriter, doc, softDeletesField);  
        assert localDirectory instanceof FSDirectory;
     * document (delete without indexing tombstone entry). We do a similar thing for old map IndexWriter. For parent, we  
            directoryToCombine = childDisposableWriter.getIndexWriter().getDirectory();
            try {
        // previousCriteria may be null in case version is coming from a tombstone. In that case, we should ignore  
        return liveIndexWriterDeletesMap.old.mapWriteLock;  
            closed.set(true);  
        SoftDeletesPolicy softDeletesPolicy,
         * Builds a new map for the refresh transition this should be called in beforeRefresh()
 * for this criteria and added to the map  
                assert addCurrentThread();
    }
        ReleasableLock lock1 = this.getOldWriteLock().acquire();
import org.apache.lucene.index.IndexWriter;
        LiveIndexWriterDeletesMap currentLiveIndexWriterDeletesMap,
     */
            this.criteria = criteria;
        private final ReentrantReadWriteLock mapLock;
 *
    public static final class CriteriaBasedIndexWriterLookup implements Closeable {  
            lastDeleteEntrySet.put(uid, deleteEntry);
        Field... softDeletesField
    }
        this.softDeletesPolicy = softDeletesPolicy;
            rollback();  
                if (holdingThreads == null) {
        }
        return accumulatingIndexWriter.commit();
        for (DisposableIndexWriter disposableIndexWriter : liveIndexWriterDeletesMap.current.criteriaBasedIndexWriterMap.values()) {
    private final EngineConfig engineConfig;
                }  
                }  
        }  
    }  
 * Locking Mechanism
     */  
                return disposableIndexWriter.getIndexWriter().getTragicException();
        this.accumulatingIndexWriter = accumulatingIndexWriter;
    /**  
     * - addDocument
    }
        ensureOpen();
        DisposableIndexWriter disposableIndexWriter = getAssociatedIndexWriterForCriteria(criteria);  
 *
            public boolean isHeldByCurrentThread() {  
 * During each write/update/delete operation, a read lock on the ReentrantLock  
        long primaryTerm,
 * <p>  
    /**
import org.opensearch.common.lease.Releasable;
    }
        }
    /**
                }  
     * <p>At this stage, OpenSearch will sync the content of group specific IndexWriters with  
            addDeleteEntryToWriter(deleteEntry, accumulatingIndexWriter);
        boolean hasNewIndexingOrUpdates() {  
            }
                }  
        this.logger = Loggers.getLogger(Engine.class, engineConfig.getShardId());  
import org.opensearch.common.util.concurrent.ReleasableLock;
        liveIndexWriterDeletesMap = liveIndexWriterDeletesMap.buildTransitionMap();
    public final void maybeMerge() throws IOException {  
    }
            }
        void putCriteriaForDoc(BytesRef key, String criteria) {
    DisposableIndexWriter computeIndexWriterIfAbsentForCriteria(  
        try {
 * active read lock on the writer, all writers in a map are closed and synced with
        try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignoreLock = disposableIndexWriter.getLookupMap().getMapReadLock()) {
                    // never applied on this map as write lock gets only during closing time. We are doing this instead of acquire,  
    }
            this.lastDeleteEntrySet = lastDeleteEntrySet;  
            } catch (AlreadyClosedException e) {
            disposableIndexWriter.getIndexWriter().softUpdateDocument(uid, doc, softDeletesField);  
                boolean locked = lock.tryLock(timeout.duration(), timeout.timeUnit());
     * <h3>Active</h3>  
        // TODO: Should we do this for old writer as well?
    }
 * the parent writer only when there are no active writes happening on these IndexWriters.
            return mapReadLock;  
     *
     * a document will depend on the outcome of the document for the grouping criteria function.  
 * <p>  
     * active state. OpenSearch maintains a mapping of active IndexWriters, each associated
    @Override  
        return closed.get() == false;  
 * IndexWriters containing the previous version of the document.
                final Integer count = holdingThreads.get();
                    // because acquire can also apply a read lock in case refresh completed and map is closed.
        final String criteria = getGroupingCriteriaForDoc(docs.iterator().next());
     * <h3>Mark for Refresh</h3>
        return doc == null ? null : doc.getGroupingCriteria();  
            this.indexWriter = indexWriter;
            Path childDirectoryPath = getLocalFSDirectory(directoryToCombine).getDirectory();
        document.add(new Field("_id", DUMMY_TOMBSTONE_DOC_ID, IdFieldMapper.Defaults.FIELD_TYPE));
 * using a refresh-rotating map structure analogous to LiveVersionMap's implementation.  
            disposableIndexWriter.getIndexWriter().softUpdateDocuments(uid, docs, softDeletesField);  
 * With multiple IndexWriters, indexing and updates can occur on different IndexWriters.
            // TODO: Do we need to add more info in delete entry like id, seqNo, primaryTerm for debugging??
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.lucene.document.NumericDocValuesField;
     * Map used for maintaining <code>CriteriaBasedIndexWriterLookup</code>
        return accumulatingIndexWriter.getConfig();
        }
        ReleasableLock acquireCurrentWriteLock() {
                    0  
                } else {
            logger.debug("Acquired write lock during refresh of composite IndexWriter.");
                if (Assertions.ENABLED) {  
        private final Map<String, DisposableIndexWriter> criteriaBasedIndexWriterMap;
                return count != null && count > 0;
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(),
        }  
        accumulatingIndexWriter.forceMergeDeletes(doWait);
     * RamBytesUsed is summation of deleteBytes, flushBytes and activeBytes.  
     *
     */
            String criteria,
        ) {
            // TODO Or should we do this in Reader before listner where we are syncing data??  
        }
    /**
    @Override  
        this.closed = new AtomicBoolean(false);
        ParseContext.Document doc,
import org.apache.logging.log4j.Logger;
            private final CriteriaBasedIndexWriterLookup lookup;
import org.apache.lucene.index.IndexableField;
 * <p>
            throw new AlreadyClosedException("CompositeIndexWriter is closed");
        public IndexWriter getIndexWriter() {  
        long version,
            // TODO: Do we need to add more info in delete entry like id, seqNo, primaryTerm for debugging??
        } catch (Throwable ex) {
            }
    /**
            return seqNo;
 * an entire refresh cycle, there is no change in how versions are resolved in the above  
                    throw new OpenSearchException(e);
        public DisposableIndexWriter(IndexWriter indexWriter, CriteriaBasedIndexWriterLookup lookupMap) {
                if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {  
    }
    static class DisposableIndexWriter {
     * a DWPT on which indexing is happening is already marked for flush or in case we mark a dwpt for flush. ActiveBytes  
        }
        private final ReleasableLock mapWriteLock;  
            return indexWriter;
     * when old will be synced with parent writer, old writer is closed so we do not need to worry about double counting
            }
    public boolean isOpen() {
        logger.debug("Trying to acquire write lock during refresh of composite IndexWriter. ");
import java.nio.file.Path;
            long seqNo = disposableIndexWriter.getIndexWriter().addDocuments(docs);  
import java.io.IOException;
                DisposableIndexWriter disposableIndexWriter = indexWriterLookup.getIndexWriterForCriteria(criteria);
            // version).
            } catch (AlreadyClosedException e) {
    }
        return getIndexWriterForIdFromLookup(uid, liveIndexWriterDeletesMap.current);
        long seqNo,  
        Term uid,
                ramBytesUsed += disposableIndexWriter.getIndexWriter().ramBytesUsed();
        Term uid,  
    public void deleteDocument(
            }  
        NumericDocValuesField softDeletesField,  
                    return lookup;
    }
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(current.sizeOfLastDeleteEntrySet()),
        }
        for (CompositeIndexWriter.DisposableIndexWriter childDisposableWriter : markForRefreshIndexWritersMap.values()) {  
     *  
                if (currentDisposableWriter.getLookupMap().isClosed() == false && isStaleOperation == false) {
        String associatedCriteria,  
            // Validate if this is going wrong?? Last entry should be checked to handle scenario when there is a indexing post delete.
    private final NumericDocValuesField softDeletesField;
        boolean isStaleOperation,
import org.opensearch.OpenSearchException;
    }  
            } catch (AlreadyClosedException e) {  
            try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignore = currentDisposableWriter.getLookupMap().getMapReadLock()) {
        return computeIndexWriterIfAbsentForCriteria(criteria, childIndexWriterFactory);
     * to an intermediate refresh pending state. At this stage, these IndexWriters will not be
     * @return flushingBytes
        return (FSDirectory) localDirectory;
                    holdingThreads = new ThreadLocal<>();
 * grouping criteria function. The specific IndexWriter selected for indexing a document  
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(),
        }
package org.opensearch.index.engine;
                    throw e;
                    current.version + 1
     *
    }
     * LiveIndexWriterDeletesMap, we should not worry about double counting due to map rotation from current to old. Also  
        }  
    @Override
     * a pair of read/write lock which is used to ensure that a look is correctly closed (no ongoing operation on
            try {  
 * During refresh, a write lock on the same ReentrantLock is obtained just before
                    // Validate that no write lock is applied on the map and the map is not closed. Idea here is write lock was
                if (success == false && current != null) {  
     * each refresh cycle.  
        DisposableIndexWriter disposableIndexWriter = getAssociatedIndexWriterForCriteria(criteria);  
                    throw e;  
            return current.hasNewChanges() || old.hasNewChanges();
     * are increased whenever indexing completes and dwpt is not marked for flush.
    private void addDeleteEntryToWriter(DeleteEntry deleteEntry, IndexWriter currentWriter) throws IOException {  
            this.seqNo = seqNo;
            || liveIndexWriterDeletesMap.old.mapLock.isWriteLockedByCurrentThread();
    }  
            );  
                softDeletesPolicy,
            // TODO No more write should happen post this, so that before refresh for syncing writers have all old writers available.
        private final long primaryTerm;
     * specific IndexWriter associated with this refresh cycle, the updates/deletes that came in this refresh cycle and  
        }
     * <p>IndexWriters in this state will handle all write requests coming to InternalEngine.
        }
                    addDeleteEntryToWriter(new DeleteEntry(uid, version, seqNo, primaryTerm), oldDisposableWriter.getIndexWriter());
        ReleasableLock lock2 = this.getNewWriteLock().acquire();
    /**
    }  
        }  
            try {
        CompositeIndexWriter.CriteriaBasedIndexWriterLookup lookup
            currentWriter.softUpdateDocument(uid, doc, softDeletesField);
            childWriterPendingNumDocs.addAndGet(docs.size());
    }
    // Avoid the issue of write lock getting applied on a separate map due to map getting rotated.
        ensureOpen();
 * <p>
    }  
    ) throws IOException {  
        this.softDeletesField = softDeletesField;
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(current.sizeOfLastDeleteEntrySet()),  
     * All write operations will now be handled by a pool of group specific disposable
    @Override  
        return liveIndexWriterDeletesMap.current.mapWriteLock;
    }  
    public long getFlushingBytesUtil(LiveIndexWriterDeletesMap currentLiveIndexWriterDeletesMap) {
        CompositeIndexWriter.DisposableIndexWriter currentDisposableWriter = getIndexWriterForIdFromCurrent(uid.bytes());
import org.apache.lucene.util.BytesRef;
     */
        for (DisposableIndexWriter disposableIndexWriter : liveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap.values()) {
                }
            return criteriaBasedIndexWriterMap.computeIfAbsent(criteria, (key) -> {
 * During indexing, CompositeIndexWriter evaluates the group for a document using a
    private void deleteDummyTombstoneEntry() throws IOException {
 * all updates and deletions applied during each refresh cycle. This state is maintained
                final Integer count = holdingThreads.get();
        void putLastDeleteEntry(BytesRef uid, DeleteEntry deleteEntry) {
        }  
 * relevant IndexWriter entry inside the map be null, a new IndexWriter will be instantiated
    private final SoftDeletesPolicy softDeletesPolicy;
        final String criteria = getGroupingCriteriaForDoc(doc);
            try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignore = oldDisposableWriter.getLookupMap().getMapReadLock()) {  
    public boolean hasUncommittedChanges() {
                    return null;
                    engineConfig.getMergedSegmentTransferTracker()  
        EngineConfig engineConfig,  
        try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignoreLock = disposableIndexWriter.getLookupMap().getMapReadLock()) {
            this.version = version;  
            Map<BytesRef, DeleteEntry> lastDeleteEntrySet,
    }
                return true;  
                this.lock = lock;
     * @throws IOException
                boolean locked = lock.tryLock();
import org.opensearch.common.logging.Loggers;
        ensureOpen();  
            }  
            childDisposableWriter.getIndexWriter().close();
        liveIndexWriterDeletesMap = new LiveIndexWriterDeletesMap();  
        return liveIndexWriterDeletesMap.current.mapLock.isWriteLockedByCurrentThread()
                if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
import org.opensearch.index.store.Store;
        }  
            putCriteria(uid.bytes(), criteria);
                CriteriaBasedIndexWriterLookup.EMPTY
 * <p>  
import org.apache.lucene.document.Field;  
            public CriteriaBasedIndexWriterLookup tryAcquire(TimeValue timeout) throws InterruptedException {  
     * @param softDeletesField the soft delete field
    // Since we are doing a commit only on parent IndexWriter, in case there is any child level writers or parent writer
    }  
    @Override
 * with group-specific IndexWriters and managing read operations through an
        this.nativeIndexWriterFactory = nativeIndexWriterFactory;
    }
        this.store = engineConfig.getStore();
    DisposableIndexWriter computeIndexWriterIfAbsentForCriteria(
    DisposableIndexWriter getIndexWriterForIdFromCurrent(BytesRef uid) {  
     * an accumulating parent IndexWriter via Lucene's addIndexes API call. Post the sync, we
        }
    @Override
    }
    private String getCriteriaForUID(BytesRef uid, LiveIndexWriterDeletesMap currentMap) {
            disposableIndexWriter.getLookupMap().putLastDeleteEntry(uid.bytes(), new DeleteEntry(uid, version, seqNo, primaryTerm));  
     * @return  
        List<ParseContext.Document> docs,
     * This value may overshoot during refresh temporarily due to double counting few documents in both old child  
    @Override  
        long seqNo,  
                }  
 * InternalEngine resolves the current version of a document before indexing it to
            return null;  
        return childWriterPendingNumDocs.get() + accumulatingIndexWriter.getPendingNumDocs();
            public CriteriaBasedWriterLock(Lock lock, CriteriaBasedIndexWriterLookup lookup) {
            return !criteriaBasedIndexWriterMap.isEmpty() || !lastDeleteEntrySet.isEmpty();
            childWriterPendingNumDocs.addAndGet(docs.size());
        if (currentDisposableWriter != null) {  
                    assert current.mapReadLock.isHeldByCurrentThread() == true;
            childWriterPendingNumDocs.incrementAndGet();
        void putLastDeleteEntryInCurrentMap(BytesRef uid, DeleteEntry deleteEntry) {  
                }  
        // it.
        if (criteria != null) {
        LiveIndexWriterDeletesMap buildTransitionMap() {  
    DisposableIndexWriter getIndexWriterForIdFromLookup(BytesRef uid, CriteriaBasedIndexWriterLookup indexWriterLookup) {
             */
import org.apache.lucene.index.IndexWriterConfig;  
                IndexWriterConfig.OpenMode.CREATE,  
            }
        deletePreviousVersionsForUpdatedDocuments();
        String getCriteriaForDoc(BytesRef key) {  
            return criteriaBasedIndexWriterMap.size();  
        long ramBytesUsed = 0;  
            this.criteria.put(key, criteria);  
    private String getGroupingCriteriaForDoc(final ParseContext.Document doc) {
        // Since we are validating child IndexWriter directory, it will always be instance of FSDirectory.  
    }
        }
        }
        }
        ensureOpen();  
import org.opensearch.index.mapper.SeqNoFieldMapper;
 * performs this by first doing a lookup in the version map. In case no version of the  
        long flushingBytes = 0;
            }
    @Override
    }  
    public void afterRefresh(boolean didRefresh) throws IOException {
        Field... softDeletesField
 * Updates and Deletes
import java.util.concurrent.locks.Lock;  
        ensureOpen();
                }
            }
 * <p>  
        ensureOpen();
            return criteria.get(key);
        Term uid,
                success = true;  
                lock.unlock();
            // child level IndexWriters are closed and there is no case of file leaks. Incase rollback throws any  
            lookup
        ensureOpen();
                } else {
    public void forceMergeDeletes(boolean doWait) throws IOException {
                config(),  
                null,
    }
        }
        return accumulatingIndexWriter;  
            long version  
 * <p>
            throw ex;
     * - softUpdateDocuments
            childWriterPendingNumDocs.incrementAndGet();
        currentWriter.softUpdateDocument(deleteEntry.term, document, softDeletesField);
 * @see org.opensearch.index.engine.InternalEngine  
 *
                flushingBytes += disposableIndexWriter.getIndexWriter().getFlushingBytes();
            }  
        IndexWriter accumulatingIndexWriter,
    @Override
            indexWriterLookup.mapReadLock.acquire();
    private static class DeleteEntry {
        return computeIndexWriterIfAbsentForCriteria(criteria, liveIndexWriterDeletesMap, indexWriterSupplier);  
    DisposableIndexWriter getIndexWriterForIdFromOld(BytesRef uid) {
            return current.mapWriteLock.acquire();  
            // a per-thread count indicating how many times the thread has entered the lock; only works if assertions are enabled  
            return criteriaBasedIndexWriterMap.get(criteria);
 *
    public long getPendingNumDocs() {  
        long primaryTerm,
     * <p>During refresh, we transition all group specific active IndexWriters from active pool  
    }  
        try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignoreLock = disposableIndexWriter.getLookupMap().getMapReadLock()) {
            disposableIndexWriter.getLookupMap().putLastDeleteEntry(uid.bytes(), new DeleteEntry(uid, version, seqNo, primaryTerm));  
    public boolean validateImmutableFieldNotUpdated(ParseContext.Document currentDocument, BytesRef currentUID) {  
        return liveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap;
        };  
 * CompositeIndexWriter class rather than directly interacting with IndexWriter.
    @Override
     *  
 * by implementing the RefreshListener interface.
        Term uid,  
    public void forceMerge(int maxNumSegments, boolean doWait) throws IOException {  
 * <p>  
            for (DisposableIndexWriter disposableIndexWriter : liveIndexWriterDeletesMap.current.criteriaBasedIndexWriterMap.values()) {  
import org.apache.lucene.store.FSDirectory;  
     * is hard deleted just before refresh.  
                    // This function acquires a first read lock on a map which does not have any write lock present. Current keeps  
    private DisposableIndexWriter getAssociatedIndexWriterForCriteria(final String criteria) throws IOException {
 * approach. InternalEngine performs a lookup for the document first in the version map
     * used for maintaining a single version of documents across all IndexWriter in a shard. To do this, we perform a
     *  
            return term;  
             * Try acquiring lock, returning null if unable.
    }  
        final String criteria = getGroupingCriteriaForDoc(doc);  
            putCriteria(uid.bytes(), criteria);
            } catch (AlreadyClosedException e) {
 * this file be licensed under the Apache-2.0 license or a
            CriteriaBasedIndexWriterLookup current = null;  
 *
        void removeLastDeleteEntry(BytesRef key) {
        liveIndexWriterDeletesMap = liveIndexWriterDeletesMap.invalidateOldMap();
    public long getFlushingBytes() {
     *
 * @see org.opensearch.index.engine.LiveVersionMap
        document.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, deleteEntry.primaryTerm));
        final String criteria,  
    public LiveIndexWriterConfig getConfig() {  
     */
public class CompositeIndexWriter implements DocumentIndexWriter {
    /**
            }  
     *  
        document.add(new NumericDocValuesField(VersionFieldMapper.NAME, deleteEntry.version));  
            0
        // Used for Test Case.
     * @param isStaleOperation signify if this is a stale operation (say if document is already deleted).  
                return lookup;  
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
                disposableIndexWriter.getIndexWriter().rollback();
            // TODO: Entry can be null for first version or if there is term bum up (validate if this is because we need to keep previous  
import org.opensearch.index.mapper.ParseContext;
     * (DocumentsWriterPerThread).  
    }  
            currentWriter.addDocument(doc);
import java.util.concurrent.atomic.AtomicBoolean;
        long version,
    }
                if (oldDisposableWriter.getLookupMap().isClosed() == false && isStaleOperation == false) {
    private static final String DUMMY_TOMBSTONE_DOC_ID = "-2";  
        IndexWriter currentWriter,  
        }
            }
    }  
    public void softUpdateDocuments(
                ),
        long version,
    }  
        Iterable<? extends IndexableField> doc,
     *
 */
         * builds a new map that invalidates the old map but maintains the current. This should be called in afterRefresh()  
    }
        }
 * determine whether the request is an indexing or update operation. InternalEngine
        return accumulatingIndexWriter.hasPendingMerges();
import org.opensearch.core.Assertions;
    public void softUpdateDocument(
    }  
                holdingThreads.set(current == null ? 1 : current + 1);  
    }  
 * InternalEngine delegates all IndexWriter specific operations through the
    @Override
    }
    private final Store store;
                        return null;  
        public void close() throws IOException {
        return hasNewIndexingOrUpdates() || accumulatingIndexWriter.hasUncommittedChanges();  
                ),
        private final long version;  
         */
            this.mapWriteLock = new ReleasableLock(mapLock.writeLock());  
        }  
     *  
    public final synchronized Iterable<Map.Entry<String, String>> getLiveCommitData() {
            IOUtils.closeWhileHandlingException(directoryToCombine);  
    }
 * followed by querying the document associated with the parent IndexWriter.
    }  
                    assert addCurrentThread();  
        public boolean isClosed() {  
            private boolean addCurrentThread() {
    protected final Logger logger;
            public void close() {
    ) {
import org.opensearch.common.util.io.IOUtils;  
                new CriteriaBasedIndexWriterLookup(
import org.opensearch.common.util.concurrent.ConcurrentCollections;
     * For deleteDocument call, we will take a lock on current writer, do a partial delete of the
                while (current == null || current.isClosed()) {
     *
    }
            Collections.emptyMap(),
    }
    // We always set live commit data for parent writer as we are commiting data only in parent writer (after refreshing child level  
import org.apache.lucene.store.AlreadyClosedException;
     * @return ramBytesUsed  
    @Override  
    private void deletePreviousVersionsForUpdatedDocuments() throws IOException {
import java.util.UUID;  
            }
    public IndexWriter getAccumulatingIndexWriter() {
                    throw new UnsupportedOperationException("asserts must be enabled");
                    return disposableIndexWriter;
        return currentMap.old.getCriteriaForDoc(uid);
        return () -> {  
                    return null;  
 * In addition to managing group-specific IndexWriters, CompositeIndexWriter tracks
            // Validate if this is going wrong?? Last entry should be checked to handle scenario when there is a indexing post delete.
     * for this criteria and added to the pool.</p>
                assert count != null && count > 0;  
        DisposableIndexWriter getIndexWriterForCriteria(String criteria) {
            // do delete entry in parent. For delete, do a delete in parent. This will take care of scenario incase deleteInLucene,
                store.newTempDirectory(CHILD_DIRECTORY_PREFIX + associatedCriteria + "_" + UUID.randomUUID()),
     * @param deleteEntry
        }
            lock2.close();
        }
     */
        private final Map<BytesRef, DeleteEntry> lastDeleteEntrySet;
        /**  
                if (locked) {
        private final CriteriaBasedWriterLock mapReadLock;
    }  
        private final long version;
     * with a specific group. During indexing, the specific IndexWriter selected for indexing
                    // only increment this when addDeleteEntry for child writers are called.
                    return indexWriterSupplier.apply(criteria, this);  
        IndexWriterFactory nativeIndexWriterFactory
 * The OpenSearch Contributors require contributions made to  
     * @param currentLiveIndexWriterDeletesMap current point in time instance of LiveIndexWriterDeletesMap.
     * @param currentWriter  
    }  
import org.opensearch.index.mapper.VersionFieldMapper;  
        return closed.get() == false;
            /**  
                    // on getting rotated during refresh, so there will be one current on which read lock can be obtained.
            refreshDocumentsForParentDirectory(oldMap);
            boolean success = false;
    }  
        }
        long primaryTerm,
        }
            String criteria = indexWriterLookup.getCriteriaForDoc(uid);  
        }  
        return engineConfig;  
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(current.sizeOfCriteriaBasedIndexWriterMap()),
        private static final class CriteriaBasedWriterLock implements Releasable {
        }
        ensureOpen();
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;  
        ensureOpen();
    final static class LiveIndexWriterDeletesMap {  
import java.io.Closeable;  
    void putCriteria(BytesRef uid, String criteria) {
            IOUtils.rm(childDirectoryPath);
        String currentCriteria = currentDocument.getGroupingCriteria();
     *  
import java.util.List;
        private CriteriaBasedIndexWriterLookup(
        liveIndexWriterDeletesMap.putLastDeleteEntryInCurrentMap(uid, entry);
    public final long ramBytesUsed() {  
     * Utility class to calculate flushingBytes. Since we are point in time current instance of
        return new CompositeIndexWriter.DisposableIndexWriter(  
    private EngineConfig config() {
    @Override
        int sizeOfLastDeleteEntrySet() {  
        if (shouldClose()) {
                flushingBytes += disposableIndexWriter.getIndexWriter().getFlushingBytes();  
        String previousCriteria = getCriteriaForUID(currentUID, liveIndexWriterDeletesMap);
        liveIndexWriterDeletesMap.putCriteriaForDoc(uid, criteria);  
    }  
    ) throws IOException {  
            // Though calling rollback on child level writer seems like a redundant thing, but this ensures all the
        } finally {
     * @throws IOException if there is a low-level IO error.
                DisposableIndexWriter writer = current.computeIndexWriterIfAbsentForCriteria(criteria, indexWriterSupplier);
        }  
        final String criteria = getGroupingCriteriaForDoc(docs.iterator().next());
        deleteDummyTombstoneEntry();
        } else {  
 * SPDX-License-Identifier: Apache-2.0
     * deleteBytes are increased when any updates are added to document. flushBytes are increased post indexing in case
        CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> indexWriterSupplier
     * LiveVersionMap.VersionLookup</code>. This is maintained on per refresh cycle basis. This contains the group
        }  
 * <p>  
            return new LiveIndexWriterDeletesMap(  
                    }
            return closed;
            // For both updates and deletes do a delete only in parent. For updates, latest writes will be on mark for flush writer,
            private boolean removeCurrentThread() {
        // Used while refresh is running, and to hold adds/deletes until refresh finishes. We read from both current and old on lookup:
            // version).
     * remove all group specific IndexWriters from Mark for refresh stage and close them.</p>
                return writer;
        LiveIndexWriterDeletesMap() {  
        try (  
    private final IndexWriterFactory nativeIndexWriterFactory;
            this.closed = true;  
        }
     * do a full delete (delete doc + tombstone entry). This ensures only a single tombstone entry is made after delete
        LiveIndexWriterDeletesMap invalidateOldMap() {
 * for the current version of the document. Since the version map is maintained throughout
        rollback();
        ) {  
            this.version = version;
            }
            try {
            private final Lock lock;
    }
    }
        return currentLiveIndexWriterDeletesMap.computeIndexWriterIfAbsentForCriteria(
    @Override
     * accepting any active writes, but will continue to handle any ongoing operation.</p>
                    return lookup;  
     * @param uid uid of the document that is getting deleted.
        );  
    private boolean shouldClose() {
        private final Map<BytesRef, String> criteria;  
                if (locked) {
     * <h3>Close</h3>
                indexWriterLookup.mapReadLock.close();  
     *
            }
 * @see org.apache.lucene.search.ReferenceManager.RefreshListener
        return getIndexWriterForIdFromLookup(uid, liveIndexWriterDeletesMap.old);
     * @opensearch.internal
            if (criteria != null) {
            Collections.emptyMap(),
    ) throws IOException {
import java.util.concurrent.atomic.AtomicLong;
            // TODO: Entry can be null for first version or if there is term bum up (validate if this is because we need to keep previous  
                    holdingThreads = null;  
     * inconsistent state (which may become an issue with segrep).  
import java.util.Map;
    }  
                return true;
            return lastDeleteEntrySet.size();
                logger,
            return lookupMap;
    }
            });
        }  
            return current.getCriteriaForDoc(key);  
        accumulatingIndexWriter.maybeMerge();
                assert removeCurrentThread();  
 * accumulating parent IndexWriter. This wrapper class also handles synchronization
        return liveIndexWriterDeletesMap.hasNewIndexingOrUpdates();  
        final CriteriaBasedIndexWriterLookup current;
 * additional lock is used for each IndexWriterMap inside CompositeIndexWriter.  
            for (DisposableIndexWriter disposableIndexWriter : liveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap.values()) {
    @Override
            this.lookupMap = lookupMap;  
    public void rollback() throws IOException {  
import org.apache.lucene.document.Document;
        return accumulatingIndexWriter.getLiveCommitData();  
            if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {  
     * Utility class to calculate ramBytesUsedUtil. Since we are point in time current instance of  
        }  
            }
    CompositeIndexWriter.DisposableIndexWriter createChildWriterUtil(
        }
            engineConfig.getShardId()
        if (oldDisposableWriter != null) {
            this.mapLock = new ReentrantReadWriteLock();
     * <h2>States of Disposable IndexWriters</h2>
             * Try acquiring lock, returning null if unable to acquire lock within timeout.
     * soft delete using a dummy temporary document as a tombstone entry during the soft update call. This dummy document
        for (DeleteEntry deleteEntry : deleteEntrySet.values()) {  
    public Throwable getTragicException() {
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(),  
    private void deleteInLucene(  
        public DeleteEntry(Term term, long version, long seqNo, long primaryTerm) {
        }
             */
                    childWriterPendingNumDocs.incrementAndGet();
     * <p>Similar to DWPTs, these disposable IndexWriters will have three states:</p>
                    assert addCurrentThread();  
 * depends on the outcome of the document for the grouping criteria function. Should the
     * - softUpdateDocument
     * For each group/tenant, there will be at most a single IndexWriter that will be in the  
import org.apache.lucene.index.Term;  
     * @param currentLiveIndexWriterDeletesMap current point in time instance of LiveIndexWriterDeletesMap.
    ) throws IOException {  
 * Indexing  
    ) throws IOException {  
        childWriterPendingNumDocs.incrementAndGet();
     * in parent and old IndexWriters.  
     * on childWriter:  
            public CriteriaBasedIndexWriterLookup acquire() throws EngineException {  
            // delete went to mark for refresh.  
                }
import org.opensearch.common.CheckedBiFunction;  
        @Override
        Directory directoryToCombine;
        }
                    isCriteriaNotNull = true;
            final Map<String, DisposableIndexWriter> criteriaBasedIndexWriterMap,  
        LiveIndexWriterDeletesMap(CriteriaBasedIndexWriterLookup current, CriteriaBasedIndexWriterLookup old) {
        accumulatingIndexWriter.deleteDocuments(uid);
            this.closed = false;  
    }
        accumulatingIndexWriter.deleteUnusedFiles();
     *
                }  
            ),  
    @Override
        this.childIndexWriterFactory = this::createChildWriterUtil;  
            );
            return new LiveIndexWriterDeletesMap(current, CriteriaBasedIndexWriterLookup.EMPTY);  
        DisposableIndexWriter disposableIndexWriter = getAssociatedIndexWriterForCriteria(criteria);
        return liveIndexWriterDeletesMap.current.mapReadLock.acquire();  
                }
    private final IndexWriter accumulatingIndexWriter;
            String criteria,
        return ramBytesUsed + accumulatingIndexWriter.ramBytesUsed();  
            childWriterPendingNumDocs.addAndGet(-pendingNumDocsByOldChildWriter);
    }  
    }
    @Override  
    ) {
    }  
        try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignoreLock = disposableIndexWriter.getLookupMap().getMapReadLock()) {
            criteria,  
                } else {
            }
     * @param doc tombstone entry.
                    current = this.current.mapReadLock.tryAcquire();
 * of group-specific IndexWriters with the accumulating IndexWriter during refresh  
     */
        }  
 * <p>  
    // writers).
    public synchronized boolean hasPendingMerges() {  
            }
     * pendingNumDocs by one for each of these operations. We increment this value whenever we call following functions
            }
    public CompositeIndexWriter(
    // Used for unit tests.
                    // only increment this when addDeleteEntry for child writers are called.  
                        this.close();
 * IndexWriter is not closed during active indexing. With context-aware segments, an
                    current.mapReadLock.close();
            // exception close the shard as rollback gets called in close flow. And rollback throwin exception means
    void putLastDeleteEntryUnderLockInNewMap(BytesRef uid, DeleteEntry entry) {  
        boolean isStaleOperation,  
            accumulatingIndexWriter.addIndexes(directoryToCombine);
    @Override
                associatedCriteria
            if (isCriteriaNotNull == false) {
            CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> indexWriterSupplier
        Map<BytesRef, DeleteEntry> deleteEntrySet = getLastDeleteEntrySet();
import java.util.Collections;  
 * <p>
            /**  
        private final CriteriaBasedIndexWriterLookup lookupMap;
            indexWriterSupplier,
     * (by one) only in DocumentsWriterPerThread#reserveOneDoc for any index or update operation, we keep incrementing
            CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> indexWriterSupplier,
    private void refreshDocumentsForParentDirectory(CriteriaBasedIndexWriterLookup oldMap) throws IOException {
        final String criteria,
}
                }
    }
import org.opensearch.index.mapper.IdFieldMapper;  
            // there is already leaks.
                ),  
        private final Term term;
        return accumulatingIndexWriter.getTragicException();
            public CriteriaBasedIndexWriterLookup tryAcquire() {  
                try {
            @Override  
        private static final CriteriaBasedIndexWriterLookup EMPTY = new CriteriaBasedIndexWriterLookup(
            putCriteria(uid.bytes(), criteria);  
                    engineConfig.getIndexSettings(),
     * IndexWriters and parent which should ok as undershooting pendingNumDocs can be problematic.
     * - addDocuments  
        int sizeOfCriteriaBasedIndexWriterMap() {
    public final long commit() throws IOException {
        ensureOpen();
        long seqNo,  
        ) {
        final Map<String, CompositeIndexWriter.DisposableIndexWriter> markForRefreshIndexWritersMap = oldMap.criteriaBasedIndexWriterMap;  
    /**
            accumulatingIndexWriter.rollback();
            this.criteriaBasedIndexWriterMap = criteriaBasedIndexWriterMap;
    public long addDocument(ParseContext.Document doc, Term uid) throws IOException {
        public Term getTerm() {
    }
    private volatile AtomicBoolean closed;  
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
                    throw e;  
        }
     * in parent and old IndexWriters.
            this.mapReadLock = new CriteriaBasedWriterLock(mapLock.readLock(), this);
    public long addDocuments(final List<ParseContext.Document> docs, Term uid) throws IOException {
     * operation. Also doing a full delete on parent ensures, that accumulating IndexWriter is never left in an
        for (DisposableIndexWriter disposableIndexWriter : currentLiveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap.values()) {
        return getFlushingBytesUtil(liveIndexWriterDeletesMap);
    private final AtomicLong childWriterPendingNumDocs = new AtomicLong();  
import org.opensearch.core.index.shard.ShardId;
            private final ThreadLocal<Integer> holdingThreads;
    private volatile LiveIndexWriterDeletesMap liveIndexWriterDeletesMap = new LiveIndexWriterDeletesMap();
        public CriteriaBasedIndexWriterLookup getLookupMap() {
                }  
     * when old will be synced with parent writer, old writer is closed so we do not need to worry about double counting
            this.term = term;
        String criteria = currentMap.current.getCriteriaForDoc(uid);  
        DisposableIndexWriter disposableIndexWriter = getAssociatedIndexWriterForCriteria(criteria);  
            this.current = current;
            Collections.emptyMap(),  
                    holdingThreads.set(count - 1);
                } catch (IOException e) {
     * IndexWriters. These disposable IndexWriters will be modelled after Lucene's DWPTs
        }
    private final CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> childIndexWriterFactory;  
/**
            lastDeleteEntrySet.remove(key);
        final CriteriaBasedIndexWriterLookup old;
                if (disposableIndexWriter != null) {  
        if (isStaleOperation) {
    }  
/*  
                lock.lock();
    @Override
        CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> indexWriterSupplier  
            putCriteria(uid.bytes(), criteria);
    public ReleasableLock getOldWriteLock() {
    }
        DisposableIndexWriter computeIndexWriterIfAbsentForCriteria(  
        ParseContext.Document doc,
            Map<BytesRef, String> criteria,
