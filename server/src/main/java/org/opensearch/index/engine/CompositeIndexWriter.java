    public boolean validateImmutableFieldNotUpdated(ParseContext.Document currentDocument, BytesRef currentUID) {
            disposableIndexWriter.getLookupMap().putLastDeleteEntry(uid.bytes(), new DeleteEntry(uid, version, seqNo, primaryTerm));
        ensureOpen();
import org.opensearch.common.logging.Loggers;
     * an accumulating parent IndexWriter via Lucene's addIndexes API call. Post the sync, we
             */
        Document document = new Document();
 * OpenSearch currently utilizes ReentrantReadWriteLock to ensure the underlying
    }
        Field... softDeletesField
            lookup
            }
     * For each group/tenant, there will be at most a single IndexWriter that will be in the
        }
    }
    @Override
            }
     * @param currentLiveIndexWriterDeletesMap current point in time instance of LiveIndexWriterDeletesMap.
 * the parent writer only when there are no active writes happening on these IndexWriters.
import org.apache.lucene.store.FSDirectory;
     * to an intermediate refresh pending state. At this stage, these IndexWriters will not be
    public void forceMergeDeletes(boolean doWait) throws IOException {
                if (count == 1) {
        return currentMap.old.getCriteriaForDoc(uid);
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                    current.mapReadLock.close();
                final Integer count = holdingThreads.get();
            try {
                    // on getting rotated during refresh, so there will be one current on which read lock can be obtained.
 * grouping criteria function. The specific IndexWriter selected for indexing a document
    }
 * The OpenSearch Contributors require contributions made to
        }
            0
        this.childIndexWriterFactory = this::createChildWriterUtil;
     *
             */
        this.nativeIndexWriterFactory = nativeIndexWriterFactory;
 * InternalEngine resolves the current version of a document before indexing it to
     * <p>Similar to DWPTs, these disposable IndexWriters will have three states:</p>
        Map<BytesRef, DeleteEntry> deleteEntrySet = getLastDeleteEntrySet();
            current.putCriteriaForDoc(key, criteria);
import org.apache.logging.log4j.Logger;
import org.opensearch.index.mapper.ParseContext;
    }
        this.engineConfig = engineConfig;
     *
        ReleasableLock acquireCurrentWriteLock() {
        accumulatingIndexWriter.deleteDocuments(uid);
        LiveIndexWriterDeletesMap() {
     * when old will be synced with parent writer, old writer is closed so we do not need to worry about double counting
     * For deleteDocument call, we will take a lock on current writer, do a partial delete of the
    /**
            this.mapLock = new ReentrantReadWriteLock();
            // version).
    private final SoftDeletesPolicy softDeletesPolicy;
        final String criteria = getGroupingCriteriaForDoc(doc);
            return mapReadLock;
        Field... softDeletesField
        }
            private boolean addCurrentThread() {
            try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignore = oldDisposableWriter.getLookupMap().getMapReadLock()) {
    @Override
        return previousCriteria != null && previousCriteria.equals(currentCriteria) == false;
 * <p>
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
        }
    @Override
     *
        }
import org.apache.lucene.document.NumericDocValuesField;
            // this may cause updates to go out of sync with current IndexWriter.
        private final long version;
        private final long version;
            private boolean removeCurrentThread() {
    public void rollback() throws IOException {
        }
                new CriteriaBasedIndexWriterLookup(
import java.util.List;
     * @param doc tombstone entry.
            // For both updates and deletes do a delete only in parent. For updates, latest writes will be on mark for flush writer,
        }
            } catch (AlreadyClosedException e) {
            }
            }
     * on childWriter:
 * Version Resolution
        LiveIndexWriterDeletesMap buildTransitionMap() {
            public void close() {
 * additional lock is used for each IndexWriterMap inside CompositeIndexWriter.
            throw ex;
    }
            logger.debug("Acquired write lock during refresh of composite IndexWriter.");
            // Validate if this is going wrong?? Last entry should be checked to handle scenario when there is a indexing post delete.
                if (success == false && current != null) {
            long version
    }
        SoftDeletesPolicy softDeletesPolicy,
    @Override
            return criteriaBasedIndexWriterMap.size();
        for (DeleteEntry deleteEntry : deleteEntrySet.values()) {
            childWriterPendingNumDocs.addAndGet(-pendingNumDocsByOldChildWriter);
    private boolean shouldClose() {
 * using a refresh-rotating map structure analogous to LiveVersionMap's implementation.
     * a DWPT on which indexing is happening is already marked for flush or in case we mark a dwpt for flush. ActiveBytes
 * compatible open source license.
        }
                    // only increment this when addDeleteEntry for child writers are called.
            childWriterPendingNumDocs.incrementAndGet();
                associatedCriteria
 * determine whether the request is an indexing or update operation. InternalEngine
        EngineConfig engineConfig,
        liveIndexWriterDeletesMap = liveIndexWriterDeletesMap.buildTransitionMap();
         * builds a new map that invalidates the old map but maintains the current. This should be called in afterRefresh()
    }
import java.util.concurrent.locks.ReentrantReadWriteLock;
    public void softUpdateDocuments(
     * do a full delete (delete doc + tombstone entry). This ensures only a single tombstone entry is made after delete
                    return null;
    private final IndexWriterFactory nativeIndexWriterFactory;
     * LiveVersionMap.VersionLookup</code>. This is maintained on per refresh cycle basis. This contains the group
                new CriteriaBasedIndexWriterLookup(
        long primaryTerm,
 * This wrapper serves as a unified interface for coordinating write operations
    public final synchronized void setLiveCommitData(Iterable<Map.Entry<String, String>> commitUserData) {
            return current.mapWriteLock.acquire();
 * Indexing
        private CriteriaBasedIndexWriterLookup(
        Field... softDeletesField
    // Since we are doing a commit only on parent IndexWriter, in case there is any child level writers or parent writer
                DisposableIndexWriter writer = current.computeIndexWriterIfAbsentForCriteria(criteria, indexWriterSupplier);
        return (FSDirectory) localDirectory;
        }
import org.opensearch.common.lease.Releasable;
        ensureOpen();
        assert localDirectory instanceof FSDirectory;
        }
     * each refresh cycle.
    DisposableIndexWriter getIndexWriterForIdFromCurrent(BytesRef uid) {
            disposableIndexWriter.getIndexWriter().softUpdateDocuments(uid, docs, softDeletesField);
        Iterable<? extends IndexableField> doc,
        for (DisposableIndexWriter disposableIndexWriter : currentLiveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap.values()) {
     */
        LiveIndexWriterDeletesMap currentLiveIndexWriterDeletesMap,
                try {
    public void deleteDocument(
        // IndexWriter.
            this.version = version;
import org.opensearch.index.mapper.SeqNoFieldMapper;
        if (currentDisposableWriter != null) {
                    if (lookup.isClosed()) {
        ) {
        return ramBytesUsedUtil(liveIndexWriterDeletesMap);
public class CompositeIndexWriter implements DocumentIndexWriter {
    public Throwable getTragicException() {
 *
    /**
        ) {
        );
     * LiveIndexWriterDeletesMap, we should not worry about double counting due to map rotation from current to old. Also
                    holdingThreads = null;
/**
             * Try acquiring lock, returning null if unable to acquire lock within timeout.
    @Override
            this.closed = true;
     * (by one) only in DocumentsWriterPerThread#reserveOneDoc for any index or update operation, we keep incrementing
        }
    public final void maybeMerge() throws IOException {
    public long addDocument(ParseContext.Document doc, Term uid) throws IOException {
        }
            /**
        IndexWriterFactory nativeIndexWriterFactory
        liveIndexWriterDeletesMap = liveIndexWriterDeletesMap.invalidateOldMap();
        final CriteriaBasedIndexWriterLookup old;
            }
    private static class DeleteEntry {
                } else {
     * inconsistent state (which may become an issue with segrep).
                }
     * for this criteria and added to the pool.</p>
            private final ThreadLocal<Integer> holdingThreads;
        for (DisposableIndexWriter disposableIndexWriter : currentLiveIndexWriterDeletesMap.current.criteriaBasedIndexWriterMap.values()) {
                    engineConfig.getMergedSegmentTransferTracker()
            return lookupMap;
    public ReleasableLock getNewWriteLock() {
        private static final CriteriaBasedIndexWriterLookup EMPTY = new CriteriaBasedIndexWriterLookup(
                return true;
        }
        } catch (Throwable ex) {
            this.primaryTerm = primaryTerm;
         * Builds a new map for the refresh transition this should be called in beforeRefresh()
    public Releasable obtainWriteLockOnAllMap() {
    public boolean isOpen() {
            return new LiveIndexWriterDeletesMap(
            if (criteria != null) {
     * pendingNumDocs is used to track pendingNumDocs for child level IndexWriters. Since pendingNumDocs is incremented
                disposableIndexWriter.getIndexWriter().rollback();
                ),
     * IndexWriters and parent which should ok as undershooting pendingNumDocs can be problematic.
        currentWriter.softUpdateDocument(deleteEntry.term, document, softDeletesField);
    public boolean isWriteLockedByCurrentThread() {
        CriteriaBasedWriterLock getMapReadLock() {
    }
            CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> indexWriterSupplier,
 * accumulating parent IndexWriter. This wrapper class also handles synchronization
        accumulatingIndexWriter.forceMergeDeletes(doWait);
import java.io.Closeable;
        long version,
            lastDeleteEntrySet.put(uid, deleteEntry);
     *
            nativeIndexWriterFactory.createWriter(
     * @throws IOException
            }
        final String criteria = getGroupingCriteriaForDoc(doc);
            try {
     * operation. Also doing a full delete on parent ensures, that accumulating IndexWriter is never left in an
            return criteria;
                new OpenSearchConcurrentMergeScheduler(
    private final AtomicLong childWriterPendingNumDocs = new AtomicLong();
            }
    }
        document.add(new NumericDocValuesField(VersionFieldMapper.NAME, deleteEntry.version));
        // We obtain a read lock on a child level IndexWriter and then return it. Post Indexing completes, we close this
        }
                    assert addCurrentThread();
 *
        return closed.get() == false;
            throw new AlreadyClosedException("CompositeIndexWriter is closed");
                indexWriterLookup.mapReadLock.close();
            // there is already leaks.
            } catch (AlreadyClosedException e) {
    }
 * With multiple IndexWriters, indexing and updates can occur on different IndexWriters.
        // it.
            lock1.close();
    }
        private final Map<BytesRef, DeleteEntry> lastDeleteEntrySet;
        }
        for (DisposableIndexWriter disposableIndexWriter : currentLiveIndexWriterDeletesMap.current.criteriaBasedIndexWriterMap.values()) {
    }
            return criteria.get(key);
                    }
 * CompositeIndexWriter class rather than directly interacting with IndexWriter.
    // Used for unit tests.
                    assert current.mapReadLock.isHeldByCurrentThread() == true;
        }
        DisposableIndexWriter computeIndexWriterIfAbsentForCriteria(
    public void afterRefresh(boolean didRefresh) throws IOException {
        String getCriteriaForDoc(BytesRef key) {
    private DisposableIndexWriter getAssociatedIndexWriterForCriteria(final String criteria) throws IOException {
    public boolean hasNewIndexingOrUpdates() {
        CompositeIndexWriter.DisposableIndexWriter oldDisposableWriter = getIndexWriterForIdFromOld(uid.bytes());
     * soft delete using a dummy temporary document as a tombstone entry during the soft update call. This dummy document
    }
import org.apache.lucene.document.Document;
                flushingBytes += disposableIndexWriter.getIndexWriter().getFlushingBytes();
    }
        }
            // child level IndexWriters are closed and there is no case of file leaks. Incase rollback throws any
        }
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(),
    private void deletePreviousVersionsForUpdatedDocuments() throws IOException {
            // TODO: Do we need to add more info in delete entry like id, seqNo, primaryTerm for debugging??
    final static class LiveIndexWriterDeletesMap {
        }
            public CriteriaBasedIndexWriterLookup tryAcquire(TimeValue timeout) throws InterruptedException {
        return accumulatingIndexWriter.getLiveCommitData();
    }
    private String getCriteriaForUID(BytesRef uid, LiveIndexWriterDeletesMap currentMap) {
        return currentLiveIndexWriterDeletesMap.computeIndexWriterIfAbsentForCriteria(
                    holdingThreads.set(count - 1);
                }
    }
        }
    @Override
    }
        ensureOpen();
    private EngineConfig config() {
    public long addDocuments(final List<ParseContext.Document> docs, Term uid) throws IOException {
            indexWriterSupplier,
     *
 */
     * - addDocuments
    private void deleteDummyTombstoneEntry() throws IOException {
import org.apache.lucene.document.Field;
                assert count != null && count > 0;
    public IndexWriter getAccumulatingIndexWriter() {
        deleteDummyTombstoneEntry();
}
            try {
        return computeIndexWriterIfAbsentForCriteria(criteria, liveIndexWriterDeletesMap, indexWriterSupplier);
     * @param uid uid of the document that is getting deleted.
 */
    @Override
     * @return ramBytesUsed
        DisposableIndexWriter disposableIndexWriter = getAssociatedIndexWriterForCriteria(criteria);
    DisposableIndexWriter computeIndexWriterIfAbsentForCriteria(
     * deleteBytes are increased when any updates are added to document. flushBytes are increased post indexing in case
            refreshDocumentsForParentDirectory(oldMap);
            this.version = version;
        long seqNo,
 * During each write/update/delete operation, a read lock on the ReentrantLock
        public Term getTerm() {
            indexWriterLookup.mapReadLock.acquire();
        childWriterPendingNumDocs.incrementAndGet();
import org.opensearch.core.Assertions;
     * @return
     *
        private static final class CriteriaBasedWriterLock implements Releasable {
    public LiveIndexWriterConfig getConfig() {
        ReleasableLock lock2 = this.getNewWriteLock().acquire();
            Collections.emptyMap(),
                if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
            );
     * pendingNumDocs by one for each of these operations. We increment this value whenever we call following functions
    }
        Field... softDeletesField
            // Though calling rollback on child level writer seems like a redundant thing, but this ensures all the
 * @see org.apache.lucene.search.ReferenceManager.RefreshListener
 * <p>
            return term;
        this.accumulatingIndexWriter = accumulatingIndexWriter;
        document.add(new Field("_id", DUMMY_TOMBSTONE_DOC_ID, IdFieldMapper.Defaults.FIELD_TYPE));
     * is hard deleted just before refresh.
 * Updates and Deletes
     * are increased whenever indexing completes and dwpt is not marked for flush.
                logger,
            }
     * Utility class to calculate ramBytesUsedUtil. Since we are point in time current instance of
 * In addition to managing group-specific IndexWriters, CompositeIndexWriter tracks
    public final long ramBytesUsed() {
                    assert addCurrentThread();
            public boolean isHeldByCurrentThread() {
     *
            }
     * - addDocument
        ensureOpen();
                    return lookup;
                }
import org.opensearch.common.util.io.IOUtils;
        DisposableIndexWriter disposableIndexWriter = getAssociatedIndexWriterForCriteria(criteria);
        Term uid,
    public final synchronized Iterable<Map.Entry<String, String>> getLiveCommitData() {
        deleteInLucene(uid, isStaleOperation, accumulatingIndexWriter, doc, softDeletesField);
                assert addCurrentThread();
                    childWriterPendingNumDocs.incrementAndGet();
            for (DisposableIndexWriter disposableIndexWriter : liveIndexWriterDeletesMap.current.criteriaBasedIndexWriterMap.values()) {
    }
        accumulatingIndexWriter.maybeMerge();
        @Override
 * <p>
            putCriteria(uid.bytes(), criteria);
    // writers).
     */
            }
     * @param currentWriter
        ensureOpen();
        public DisposableIndexWriter(IndexWriter indexWriter, CriteriaBasedIndexWriterLookup lookupMap) {
        long primaryTerm,
 *
     */
        ensureOpen();
    }
        boolean isStaleOperation,
    @Override
        }
    /**
            return indexWriter;
                if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
    ) throws IOException {
                boolean locked = lock.tryLock(timeout.duration(), timeout.timeUnit());
            return current.getCriteriaForDoc(key);
    public void close() throws IOException {
     * @param deleteEntry
     * - softUpdateDocuments
            CriteriaBasedIndexWriterLookup current = null;
    ) throws IOException {
            // TODO: Entry can be null for first version or if there is term bum up (validate if this is because we need to keep previous
            /**
 *
package org.opensearch.index.engine;
 * @see org.apache.lucene.index.IndexWriter
     *
    public synchronized boolean hasPendingMerges() {
import org.opensearch.common.util.concurrent.ReleasableLock;
            this.lookupMap = lookupMap;
        long ramBytesUsed = 0;
         */
        }
                while (current == null || current.isClosed()) {
import org.opensearch.core.index.shard.ShardId;
            IOUtils.rm(childDirectoryPath);
                    return null;
    }
    }
                if (currentDisposableWriter.getLookupMap().isClosed() == false && isStaleOperation == false) {
            for (DisposableIndexWriter disposableIndexWriter : liveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap.values()) {
            return criteriaBasedIndexWriterMap.get(criteria);
        boolean isCriteriaNotNull = false;
        ensureOpen();
import org.apache.lucene.store.Directory;
    /**
        return liveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap;
            this.old = old;
            this.criteria.put(key, criteria);
            public CriteriaBasedIndexWriterLookup tryAcquire() {
                    // This function acquires a first read lock on a map which does not have any write lock present. Current keeps
            long seqNo = disposableIndexWriter.getIndexWriter().addDocuments(docs);
    ) throws IOException {
            engineConfig.getShardId()
     *
import org.apache.lucene.store.AlreadyClosedException;
    private void deleteInLucene(
            return seqNo;
        return new CompositeIndexWriter.DisposableIndexWriter(
            // version).
                holdingThreads.set(current == null ? 1 : current + 1);
            putCriteria(uid.bytes(), criteria);
        return () -> {
                    isCriteriaNotNull = true;
                success = true;
            CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> indexWriterSupplier
            long seqNo = disposableIndexWriter.getIndexWriter().addDocument(doc);
    private final NumericDocValuesField softDeletesField;
        }
        }
        };
        }
    }
        ensureOpen();
    private volatile LiveIndexWriterDeletesMap liveIndexWriterDeletesMap = new LiveIndexWriterDeletesMap();
        Term uid,
            this(
        public boolean isClosed() {
        CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> indexWriterSupplier
            Map<BytesRef, String> criteria,
        // Used for Test Case.
                return disposableIndexWriter.getIndexWriter().getTragicException();
    /**
        private final CriteriaBasedIndexWriterLookup lookupMap;
    }
    private String getGroupingCriteriaForDoc(final ParseContext.Document doc) {
        );
        IndexWriter accumulatingIndexWriter,
        this.logger = Loggers.getLogger(Engine.class, engineConfig.getShardId());
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(),
            // TODO Or should we do this in Reader before listner where we are syncing data??
                return writer;
        final String criteria,
        String associatedCriteria,
            current.putLastDeleteEntry(uid, deleteEntry);
    @Override
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(),
    /**
    }
    }
                    addDeleteEntryToWriter(new DeleteEntry(uid, version, seqNo, primaryTerm), oldDisposableWriter.getIndexWriter());
import org.opensearch.index.mapper.VersionFieldMapper;
        try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignoreLock = disposableIndexWriter.getLookupMap().getMapReadLock()) {
                    // only increment this when addDeleteEntry for child writers are called.
        private final long primaryTerm;
    @Override
        return liveIndexWriterDeletesMap.old.lastDeleteEntrySet;
        logger.debug("Trying to acquire write lock during refresh of composite IndexWriter. ");
        long primaryTerm,
                    engineConfig.getIndexSettings(),
        CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> indexWriterSupplier
            }
 * <p>
            } catch (AlreadyClosedException e) {
     * when old will be synced with parent writer, old writer is closed so we do not need to worry about double counting
        try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignoreLock = disposableIndexWriter.getLookupMap().getMapReadLock()) {
        if (oldDisposableWriter != null) {
            Releasable ignore = liveIndexWriterDeletesMap.old.mapWriteLock.acquire();
        void removeLastDeleteEntry(BytesRef key) {
        Directory directoryToCombine;
                    current.version + 1
                }
     * All write operations will now be handled by a pool of group specific disposable
            CriteriaBasedIndexWriterLookup oldMap = liveIndexWriterDeletesMap.old;
     *
     *
        try {
    protected final Logger logger;
        return accumulatingIndexWriter.commit();
                    // never applied on this map as write lock gets only during closing time. We are doing this instead of acquire,
        final String criteria = getGroupingCriteriaForDoc(docs.iterator().next());
        } finally {
            return !criteriaBasedIndexWriterMap.isEmpty() || !lastDeleteEntrySet.isEmpty();
 * <p>
        }
    }
    public void beforeRefresh() throws IOException {
        DisposableIndexWriter disposableIndexWriter = getAssociatedIndexWriterForCriteria(criteria);
        /**
    static class DisposableIndexWriter {
                    // because acquire can also apply a read lock in case refresh completed and map is closed.
     * RamBytesUsed is summation of deleteBytes, flushBytes and activeBytes.
                store.newTempDirectory(CHILD_DIRECTORY_PREFIX + associatedCriteria + "_" + UUID.randomUUID()),
 * IndexWriters containing the previous version of the document.
     * This value may overshoot during refresh temporarily due to double counting few documents in both old child
     */
        private final ReentrantReadWriteLock mapLock;
        private final IndexWriter indexWriter;
    private static final String DUMMY_TOMBSTONE_DOC_ID = "-2";
        }
     * a document will depend on the outcome of the document for the grouping criteria function.
            }
        /**
     * LiveIndexWriterDeletesMap, we should not worry about double counting due to map rotation from current to old. Also
    // has uncommited changes, we report it as writer having uncommited changes. Since during add indexes new set of changes will be added.
        // Used while refresh is running, and to hold adds/deletes until refresh finishes. We read from both current and old on lookup:
 * Locking Mechanism
    ) {
 * followed by querying the document associated with the parent IndexWriter.
        return liveIndexWriterDeletesMap.current.mapReadLock.acquire();
            // TODO: Do we need to add more info in delete entry like id, seqNo, primaryTerm for debugging??
 * <p>
        return accumulatingIndexWriter.hasPendingMerges();
            rollback();
 * <p>
            childWriterPendingNumDocs.addAndGet(docs.size());
        return liveIndexWriterDeletesMap.old.mapWriteLock;
            String criteria = indexWriterLookup.getCriteriaForDoc(uid);
import java.util.Map;
    @Override
        String criteria = currentMap.current.getCriteriaForDoc(uid);
        String currentCriteria = currentDocument.getGroupingCriteria();
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
            if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
        return childWriterPendingNumDocs.get() + accumulatingIndexWriter.getPendingNumDocs();
        return accumulatingIndexWriter;
    public Map<BytesRef, DeleteEntry> getLastDeleteEntrySet() {
 * all updates and deletions applied during each refresh cycle. This state is maintained
 * of group-specific IndexWriters with the accumulating IndexWriter during refresh
        }
            }
        return liveIndexWriterDeletesMap.current.mapWriteLock;
            putCriteria(uid.bytes(), criteria);
                final Integer current = holdingThreads.get();
        List<ParseContext.Document> docs,
        String getCriteriaForDoc(BytesRef key) {
     * <p>IndexWriters in this state will handle all write requests coming to InternalEngine.
                return true;
    DisposableIndexWriter computeIndexWriterIfAbsentForCriteria(
        return accumulatingIndexWriter.getTragicException();
     *
        CompositeIndexWriter.DisposableIndexWriter currentDisposableWriter = getIndexWriterForIdFromCurrent(uid.bytes());
    public long getFlushingBytes() {
            currentWriter.softUpdateDocument(uid, doc, softDeletesField);
        Term uid,
 * by implementing the RefreshListener interface.
            // a per-thread count indicating how many times the thread has entered the lock; only works if assertions are enabled
        long seqNo,
            try {
        final CriteriaBasedIndexWriterLookup current;
        }
import org.apache.lucene.util.BytesRef;
            // exception close the shard as rollback gets called in close flow. And rollback throwin exception means
            private final Lock lock;
                }
            return lastDeleteEntrySet.size();
        try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignoreLock = disposableIndexWriter.getLookupMap().getMapReadLock()) {
     *
                        return null;
                    engineConfig.getShardId(),
        accumulatingIndexWriter.deleteUnusedFiles();
    public long getFlushingBytesUtil(LiveIndexWriterDeletesMap currentLiveIndexWriterDeletesMap) {
                    throw e;
 * performs this by first doing a lookup in the version map. In case no version of the
    private final IndexWriter accumulatingIndexWriter;
        }
import java.util.UUID;
    }
        // Since we are validating child IndexWriter directory, it will always be instance of FSDirectory.
     * - softUpdateDocument
 * During indexing, CompositeIndexWriter evaluates the group for a document using a
            this.indexWriter = indexWriter;
import java.util.concurrent.atomic.AtomicBoolean;
        public DeleteEntry(Term term, long version, long seqNo, long primaryTerm) {
        ensureOpen();
                }
            this.term = term;
/*
        return ramBytesUsed + accumulatingIndexWriter.ramBytesUsed();
                if (disposableIndexWriter != null) {
    }
    @Override
            if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
        try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignoreLock = disposableIndexWriter.getLookupMap().getMapReadLock()) {
        Term uid = new Term(IdFieldMapper.NAME, DUMMY_TOMBSTONE_DOC_ID);
                } catch (IOException e) {
                CriteriaBasedIndexWriterLookup.EMPTY
 * associated with the map is acquired. This lock is released when indexing completes.
 * @see org.opensearch.index.engine.LiveVersionMap
    // Avoid the issue of write lock getting applied on a separate map due to map getting rotated.
        final String criteria,
 *
        private final Map<BytesRef, String> criteria;
        this.closed = new AtomicBoolean(false);
 * with group-specific IndexWriters and managing read operations through an
        // previousCriteria may be null in case version is coming from a tombstone. In that case, we should ignore
    }
            }
        }
            return seqNo;
    }
                } else {
     * IndexWriters. These disposable IndexWriters will be modelled after Lucene's DWPTs
        final String criteria = getGroupingCriteriaForDoc(docs.iterator().next());
                    current = this.current.mapReadLock.tryAcquire();
        ensureOpen();
        }
        // All writes (adds and deletes) go into here:
                ramBytesUsed += disposableIndexWriter.getIndexWriter().ramBytesUsed();
        boolean hasNewChanges() {
                }
        private final CriteriaBasedWriterLock mapReadLock;
        boolean isStaleOperation,
                DisposableIndexWriter disposableIndexWriter = indexWriterLookup.getIndexWriterForCriteria(criteria);
            }
     * Utility class to calculate flushingBytes. Since we are point in time current instance of
                }
     * @opensearch.internal
     */
                if (locked) {
 * <p>
    }
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(current.sizeOfLastDeleteEntrySet()),
                ),
 * <p>
    }
        liveIndexWriterDeletesMap.putCriteriaForDoc(uid, criteria);
        DisposableIndexWriter disposableIndexWriter = getAssociatedIndexWriterForCriteria(criteria);
        ensureOpen();
     */
    }
        long version,
        private final long seqNo;
    }
     * specific IndexWriter associated with this refresh cycle, the updates/deletes that came in this refresh cycle and
    public void softUpdateDocument(
        for (DisposableIndexWriter disposableIndexWriter : currentLiveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap.values()) {
     *
            childWriterPendingNumDocs.addAndGet(docs.size());
            IOUtils.closeWhileHandlingException(directoryToCombine);
            this.mapReadLock = new CriteriaBasedWriterLock(mapLock.readLock(), this);
        LiveIndexWriterDeletesMap(CriteriaBasedIndexWriterLookup current, CriteriaBasedIndexWriterLookup old) {
        void putCriteriaForDoc(BytesRef key, String criteria) {
            public CriteriaBasedIndexWriterLookup acquire() throws EngineException {
        for (CompositeIndexWriter.DisposableIndexWriter childDisposableWriter : markForRefreshIndexWritersMap.values()) {
import org.apache.lucene.index.IndexWriterConfig;
                ramBytesUsed += disposableIndexWriter.getIndexWriter().ramBytesUsed();
        CompositeIndexWriter.CriteriaBasedIndexWriterLookup lookup
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(current.sizeOfCriteriaBasedIndexWriterMap()),
                if (oldDisposableWriter.getLookupMap().isClosed() == false && isStaleOperation == false) {
import java.util.Collections;
    }
        }
    }
                    holdingThreads.remove();
        return hasNewIndexingOrUpdates() || accumulatingIndexWriter.hasUncommittedChanges();
        return getFlushingBytesUtil(liveIndexWriterDeletesMap);
    }
    }
                }
                    childWriterPendingNumDocs.incrementAndGet();
        }
 * During refresh, a write lock on the same ReentrantLock is obtained just before
        long version,
            closed.set(true);
 * by performing a partial soft delete (delete without indexing tombstone entry) on the
            try (CriteriaBasedIndexWriterLookup.CriteriaBasedWriterLock ignore = currentDisposableWriter.getLookupMap().getMapReadLock()) {
    }
     * <p>During refresh, we transition all group specific active IndexWriters from active pool
import org.opensearch.index.store.Store;
            ),
    public long getPendingNumDocs() {
    @Override
            childWriterPendingNumDocs.incrementAndGet();
 * active read lock on the writer, all writers in a map are closed and synced with
                    // Validate that no write lock is applied on the map and the map is not closed. Idea here is write lock was
            childDisposableWriter.getIndexWriter().close();
     *
    public ReleasableLock getOldWriteLock() {
        public CriteriaBasedIndexWriterLookup getLookupMap() {
        return computeIndexWriterIfAbsentForCriteria(criteria, childIndexWriterFactory);
    }
        if (criteria != null) {
                flushingBytes += disposableIndexWriter.getIndexWriter().getFlushingBytes();
     * <p>At this stage, OpenSearch will sync the content of group specific IndexWriters with
    // We always set live commit data for parent writer as we are commiting data only in parent writer (after refreshing child level
        return engineConfig;
                if (locked) {
 * @see org.opensearch.index.engine.InternalEngine
            this.criteriaBasedIndexWriterMap = criteriaBasedIndexWriterMap;
import org.opensearch.common.unit.TimeValue;
        }
 * SPDX-License-Identifier: Apache-2.0
    public boolean hasUncommittedChanges() {
     * remove all group specific IndexWriters from Mark for refresh stage and close them.</p>
        DisposableIndexWriter computeIndexWriterIfAbsentForCriteria(
    /**
 * relevant IndexWriter entry inside the map be null, a new IndexWriter will be instantiated
                null,
import java.util.concurrent.atomic.AtomicLong;
            private final CriteriaBasedIndexWriterLookup lookup;
import org.apache.lucene.index.IndexableField;
        return flushingBytes + accumulatingIndexWriter.getFlushingBytes();
                    0
        Term uid,
        return getIndexWriterForIdFromLookup(uid, liveIndexWriterDeletesMap.current);
    private final EngineConfig engineConfig;
            this.criteria = criteria;
            accumulatingIndexWriter.addIndexes(directoryToCombine);
            }
     * <h3>Mark for Refresh</h3>
        try (
    void putCriteria(BytesRef uid, String criteria) {
        IndexWriter currentWriter,
        }
            // do delete entry in parent. For delete, do a delete in parent. This will take care of scenario incase deleteInLucene,
 * document is present in the version map, it queries Lucene via the searcher to look
            );
        return closed.get() == false;
        }
     * used for maintaining a single version of documents across all IndexWriter in a shard. To do this, we perform a
        String previousCriteria = getCriteriaForUID(currentUID, liveIndexWriterDeletesMap);
     * @return flushingBytes
    }
        document.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, deleteEntry.primaryTerm));
            });
 * IndexWriter is not closed during active indexing. With context-aware segments, an
                    throw new UnsupportedOperationException("asserts must be enabled");
        }
     * <h2>States of Disposable IndexWriters</h2>
import org.apache.lucene.index.Term;
        private boolean closed;
        for (DisposableIndexWriter disposableIndexWriter : liveIndexWriterDeletesMap.old.criteriaBasedIndexWriterMap.values()) {
                }
    private void addDeleteEntryToWriter(DeleteEntry deleteEntry, IndexWriter currentWriter) throws IOException {
            public CriteriaBasedWriterLock(Lock lock, CriteriaBasedIndexWriterLookup lookup) {
    }
    @Override
        if (closed.get() == true) {
     * @param isStaleOperation signify if this is a stale operation (say if document is already deleted).
            return closed;
            putCriteria(uid.bytes(), criteria);
            // This ensures writer map is not rotated during the time when we are obtaining an IndexWriter from map. As
            currentWriter.addDocument(doc);
            // TODO No more write should happen post this, so that before refresh for syncing writers have all old writers available.
        // TODO: Should we do this for old writer as well?
            lastDeleteEntrySet.remove(key);
     * <h3>Active</h3>
    }
import org.apache.lucene.index.LiveIndexWriterConfig;
        }
        // Rotate map first so all new writes goes to new generation writers.
        int sizeOfCriteriaBasedIndexWriterMap() {
                    throw e;
        public void close() throws IOException {
     * Map used for maintaining <code>CriteriaBasedIndexWriterLookup</code>
                if (holdingThreads == null) {
    @Override
     * IndexWriter associated with lookup). Composite IndexWriter syncs a lookup with accumulating IndexWriter during
            // TODO: Entry can be null for first version or if there is term bum up (validate if this is because we need to keep previous
        DisposableIndexWriter getIndexWriterForCriteria(String criteria) {
        }
        long flushingBytes = 0;
    private void ensureOpen() throws AlreadyClosedException {
    private void refreshDocumentsForParentDirectory(CriteriaBasedIndexWriterLookup oldMap) throws IOException {
            addDeleteEntryToWriter(deleteEntry, accumulatingIndexWriter);
            ShardId shardId
        NumericDocValuesField softDeletesField,
 * Therefore, document versions must be synchronized across IndexWriters. This is achieved
            accumulatingIndexWriter.rollback();
        ensureOpen();
                final Integer count = holdingThreads.get();
        int sizeOfLastDeleteEntrySet() {
     *
     */
            if (isCriteriaNotNull == false) {
        for (DisposableIndexWriter disposableIndexWriter : liveIndexWriterDeletesMap.current.criteriaBasedIndexWriterMap.values()) {
                current
import java.nio.file.Path;
        public IndexWriter getIndexWriter() {
                this.lookup = lookup;
    }
                config(),
        this.softDeletesField = softDeletesField;
    @Override
    }
import static org.opensearch.index.BucketedCompositeDirectory.CHILD_DIRECTORY_PREFIX;
     * (DocumentsWriterPerThread).
                ),
        }
                    throw new OpenSearchException(e);
        long seqNo,
                lock.lock();
    }
            try {
import java.io.IOException;
    @Override
                if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
 * InternalEngine delegates all IndexWriter specific operations through the
     * This class represents a lookup entry inside LiveIndexWriterDeletesMap. This class is mapped similar to <code>
                    throw e;
    }
                return disposableIndexWriter.getIndexWriter().getTragicException();
                    holdingThreads = new ThreadLocal<>();
                } else {
            this.mapWriteLock = new ReleasableLock(mapLock.writeLock());
                    return indexWriterSupplier.apply(criteria, this);
     *
    }
 * this file be licensed under the Apache-2.0 license or a
                return lookup;
     * in parent and old IndexWriters.
            }
     * @throws IOException if there is a low-level IO error.
    private final CheckedBiFunction<String, CriteriaBasedIndexWriterLookup, DisposableIndexWriter, IOException> childIndexWriterFactory;
            disposableIndexWriter.getIndexWriter().softUpdateDocument(uid, doc, softDeletesField);
        }
    CriteriaBasedIndexWriterLookup acquireNewReadLock() {
 * rotating the WriterMap. Since the write lock is acquired only when there is no
        );
                    ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency(current.sizeOfLastDeleteEntrySet()),
        this.softDeletesPolicy = softDeletesPolicy;
    ) throws IOException {
     */
            Map<BytesRef, DeleteEntry> lastDeleteEntrySet,
                } else {
    ) {
        return doc == null ? null : doc.getGroupingCriteria();
        }
        boolean hasNewIndexingOrUpdates() {
    public Map<String, DisposableIndexWriter> getMarkForRefreshIndexWriterMap() {
        ) {
            }
                    throw e;
        liveIndexWriterDeletesMap = new LiveIndexWriterDeletesMap();
     * with a specific group. During indexing, the specific IndexWriter selected for indexing
            String criteria,
            return criteriaBasedIndexWriterMap.computeIfAbsent(criteria, (key) -> {
        }
    }
        void putLastDeleteEntryInCurrentMap(BytesRef uid, DeleteEntry deleteEntry) {
            this.seqNo = seqNo;
                    return lookup;
 *
        }
                }
     * @param softDeletesField the soft delete field
                disposableIndexWriter.getIndexWriter().rollback();
                    addDeleteEntryToWriter(new DeleteEntry(uid, version, seqNo, primaryTerm), currentDisposableWriter.getIndexWriter());
    CompositeIndexWriter.DisposableIndexWriter createChildWriterUtil(
     * document (delete without indexing tombstone entry). We do a similar thing for old map IndexWriter. For parent, we
    @Override
            lock2.close();
         */
    private final Store store;
            || liveIndexWriterDeletesMap.old.mapLock.isWriteLockedByCurrentThread();
import java.util.concurrent.locks.Lock;
     * accepting any active writes, but will continue to handle any ongoing operation.</p>
        }
    void putLastDeleteEntryUnderLockInNewMap(BytesRef uid, DeleteEntry entry) {
 * approach. InternalEngine performs a lookup for the document first in the version map
        return liveIndexWriterDeletesMap.hasNewIndexingOrUpdates();
 * an entire refresh cycle, there is no change in how versions are resolved in the above
    ) throws IOException {
    public CompositeIndexWriter(
                true,
    public static final class CriteriaBasedIndexWriterLookup implements Closeable {
    private volatile AtomicBoolean closed;
     * Should there be no active IndexWriter for a group, a new IndexWriter will be instantiated
        }
     * in parent and old IndexWriters.
        }
    }
     */
        if (shouldClose()) {
 *
            Collections.emptyMap(),
        ParseContext.Document doc,
import org.opensearch.OpenSearchException;
 * for the current version of the document. Since the version map is maintained throughout
            } catch (AlreadyClosedException e) {
                if (disposableIndexWriter.getIndexWriter().getTragicException() != null) {
    }
    }
        return accumulatingIndexWriter.getConfig();
                }
import org.apache.lucene.index.IndexWriter;
    /**
            }
     * active state. OpenSearch maintains a mapping of active IndexWriters, each associated
        void putCriteriaForDoc(BytesRef key, String criteria) {
        liveIndexWriterDeletesMap.putLastDeleteEntryInCurrentMap(uid, entry);
     * <h3>Close</h3>
    }
    private long ramBytesUsedUtil(LiveIndexWriterDeletesMap currentLiveIndexWriterDeletesMap) {
        ParseContext.Document doc,
     *
    /**
    @Override
        final Map<String, CompositeIndexWriter.DisposableIndexWriter> markForRefreshIndexWritersMap = oldMap.criteriaBasedIndexWriterMap;
            this.current = current;
    private FSDirectory getLocalFSDirectory(Directory localDirectory) {
    @Override
    }
    }
                }
                IndexWriterConfig.OpenMode.CREATE,
        private final ReleasableLock mapWriteLock;
            boolean success = false;
        private final Map<String, DisposableIndexWriter> criteriaBasedIndexWriterMap;
    }
        deletePreviousVersionsForUpdatedDocuments();
        rollback();
                        this.close();
                assert removeCurrentThread();
            directoryToCombine = childDisposableWriter.getIndexWriter().getDirectory();
            @Override
 * depends on the outcome of the document for the grouping criteria function. Should the
     *
            } finally {
                boolean locked = lock.tryLock();
            this.lastDeleteEntrySet = lastDeleteEntrySet;
            String criteria,
            }
 * <p>
     *
import org.opensearch.common.CheckedBiFunction;
        ReleasableLock lock1 = this.getOldWriteLock().acquire();
    }
        assert uid.bytes.length == uid.length : "Oversized _uid! UID length: " + uid.length + ", bytes length: " + uid.bytes.length;
                this.lock = lock;
    DisposableIndexWriter getIndexWriterForIdFromOld(BytesRef uid) {
                lock.unlock();
    }
    }
                }
            Collections.emptyMap(),
        }
        void putLastDeleteEntry(BytesRef uid, DeleteEntry deleteEntry) {
    public void forceMerge(int maxNumSegments, boolean doWait) throws IOException {
                }
            disposableIndexWriter.getLookupMap().putLastDeleteEntry(uid.bytes(), new DeleteEntry(uid, version, seqNo, primaryTerm));
        LiveIndexWriterDeletesMap invalidateOldMap() {
            long pendingNumDocsByOldChildWriter = childDisposableWriter.getIndexWriter().getPendingNumDocs();
            Path childDirectoryPath = getLocalFSDirectory(directoryToCombine).getDirectory();
    public final long commit() throws IOException {
 * for this criteria and added to the map
             * Try acquiring lock, returning null if unable.
        ) {
                if (Assertions.ENABLED) {
        accumulatingIndexWriter.forceMerge(maxNumSegments, doWait);
    @Override
            // Validate if this is going wrong?? Last entry should be checked to handle scenario when there is a indexing post delete.
 * <p>
     * @param currentLiveIndexWriterDeletesMap current point in time instance of LiveIndexWriterDeletesMap.
            // delete went to mark for refresh.
    DisposableIndexWriter getIndexWriterForIdFromLookup(BytesRef uid, CriteriaBasedIndexWriterLookup indexWriterLookup) {
    @Override
            return null;
    public synchronized void deleteUnusedFiles() throws IOException {
    ) throws IOException {
        } else {
        private final Term term;
            criteria,
        accumulatingIndexWriter.setLiveCommitData(commitUserData);
            return current.hasNewChanges() || old.hasNewChanges();
    }
                softDeletesPolicy,
            }
            final Map<String, DisposableIndexWriter> criteriaBasedIndexWriterMap,
        return getIndexWriterForIdFromLookup(uid, liveIndexWriterDeletesMap.old);
            return new LiveIndexWriterDeletesMap(current, CriteriaBasedIndexWriterLookup.EMPTY);
     * a pair of read/write lock which is used to ensure that a look is correctly closed (no ongoing operation on
        if (isStaleOperation) {
    @Override
        this.store = engineConfig.getStore();
        return liveIndexWriterDeletesMap.current.mapLock.isWriteLockedByCurrentThread()
                    return disposableIndexWriter;
                return count != null && count > 0;
import org.opensearch.index.mapper.IdFieldMapper;
     * This function is used for performing partial soft delete (delete without inserting a tombstone entry). This is
            this.closed = false;
