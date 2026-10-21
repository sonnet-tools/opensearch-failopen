                            "source not found for seqno=" + seqNo + " from_seqno=" + fromSeqNo + " to_seqno=" + toSeqNo
                throw new MissingHistoryOperationsException(
    private StoredFields sequentialStoredFields;
        } else {
                ArrayUtil.introSort(scoreDocs, Comparator.comparingInt(i -> i.shardIndex));
        }
            // so track the owning thread and recreate it if consumed by another thread.
    private boolean useSequentialStoredFieldsReader;
        final TopFieldCollector topFieldCollector = new TopFieldCollectorManager(
                );
    private ScoreDoc[] scoreDocs;
            int idx = docIndex;
        this.indexSearcher.setQueryCache(null);
    private final ParallelArray parallelArray;
            useSequentialStoredFieldsReader = scoreDocs.length >= MIN_SEQUENTIAL_ACCESS_BATCH_SIZE && hasSequentialAccess(scoreDocs);
 * A {@link Translog.Snapshot} from changes in a Lucene index
                throw new MissingHistoryOperationsException(
                        + op
        final boolean[] hasRecoverySource;
import java.io.IOException;
     * matching sequence number order. This allows for an optimization to decompress a block once and
                    seqNo,
    }
        boolean accurateCount
     * @param toSeqNo           the maximum requesting seq# - inclusive
                final int index = scoreDoc.shardIndex;
        final long[] primaryTerm;
     * Returns a merge-optimized (sequential) stored fields reader for the leaf
        onClose.close();
    private final Closeable onClose;
            if (isTombstone) {
 * GitHub history for details.
            fillParallelArray(scoreDocs, parallelArray);
            primaryTerm = new long[size];
        final TopDocs topDocs = searchOperations(null, accurateCount);
        }
        if (useSequentialStoredFieldsReader) {
    private int nextDocIndex() throws IOException {
            // A StoredFields instance may only be consumed in the thread that acquired it,
            seqNo = new long[size];
                    if (requiredFullRange) {
                parallelArray.primaryTerm[index] = combinedDocValues.docPrimaryTerm(segmentDocID);
                    fields.routing(),
        final long seqNo = parallelArray.seqNo[docIndex];
            }
 * You may obtain a copy of the License at
 */
        final NumericDocValues ndv = leafReader.getNumericDocValues(Lucene.SOFT_DELETES_FIELD);
 * under the License.
        } else {
    /**
            int maxDoc = 0;
 * The OpenSearch Contributors require contributions made to
                        + toSeqNo
     */
        this.onClose = () -> {
import org.apache.lucene.util.ArrayUtil;
        this.indexSearcher = new IndexSearcher(Lucene.wrapAllDocsLive(engineSearcher.getDirectoryReader()));
                parallelArray.hasRecoverySource[index] = combinedDocValues.hasRecoverySource(segmentDocID);
import org.apache.lucene.index.FilterLeafReader;
import org.opensearch.common.lucene.Lucene;
     * Drops the cached reader, if any
                return false;
        }
import java.io.Closeable;
    }
                    primaryTerm,
     * Whether to use a sequential stored fields reader. Only used when there is a gapless run of docIDs
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
    private void fillParallelArray(ScoreDoc[] scoreDocs, ParallelArray parallelArray) throws IOException {
        sequentialStoredFields = null;
                        + toSeqNo
    private TopDocs searchOperations(FieldDoc after, boolean accurate) throws IOException {
            if (useSequentialStoredFieldsReader == false) {
     * @param engineSearcher    the internal engine searcher which will be taken over if the snapshot is opened successfully
            }
        return -1;
    // for testing
        long toSeqNo,
                op = new Translog.Index(
        return indexSearcher.count(operationsRangeQuery(fromSeqNo, toSeqNo));
            if (lastSeenSeqNo < toSeqNo) {
        this.parallelArray = new ParallelArray(this.searchBatchSize);
     */
                    } while (scoreDoc.doc >= docBase + maxDoc);
                        maxDoc = leaf.reader().maxDoc();
    @Override
            final String id = fields.id();
    public Translog.Operation next() throws IOException {
        if (op == null) {
        return true;
            }
            op = readDocAsOp(idx);
    private static boolean hasSequentialAccess(ScoreDoc[] scoreDocs) {
        for (int i = 0; i < scoreDocs.length - 1; i++) {
                        + "] found; expected seqno ["
    private long lastSeenSeqNo;
        final long requestingSize = (toSeqNo - fromSeqNo) == Long.MAX_VALUE ? Long.MAX_VALUE : (toSeqNo - fromSeqNo + 1L);
    private final long fromSeqNo, toSeqNo;
    }
                sequentialStoredFieldsOwner = currentThread;
                // TODO: pass the latest timestamp from engine.
package org.opensearch.index.engine;
        this.searchBatchSize = requestingSize < searchBatchSize ? Math.toIntExact(requestingSize) : searchBatchSize;
            + "], op ["
        for (int idx = nextDocIndex(); idx != -1; idx = nextDocIndex()) {
                // then visit all leaves in order.
    private Translog.Operation readDocAsOp(int docIndex) throws IOException {
                }
    private final boolean requiredFullRange;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.ScoreDoc;
 * this work for additional information regarding copyright
     * reader clone plus the decompression of a whole block, which only pays for itself over enough documents.
import org.opensearch.index.fieldvisitor.FieldsVisitor;
        // we have processed all docs in the current search - fetch the next batch
    private void rangeCheck(Translog.Operation op) {
            if (op.seqNo() != expectedSeqNo) {
        }
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.TopDocs;
    boolean useSequentialStoredFieldsReader() {
            docIndex++;
                break;
        return op;
                        + expectedSeqNo
        indexSearcher.search(rangeQuery, topFieldCollector);
 * Licensed to Elasticsearch under one or more contributor
                );
            if (reader instanceof SequentialStoredFieldsLeafReader) {
    }
        final boolean isTombstone = parallelArray.isTombStone[docIndex];
            assert assertDocSoftDeleted(leaf.reader(), segmentDocID) : "Noop but soft_deletes field is not set [" + op + "]";
     * Returns whether the batch, in the order it will be read, is a strictly increasing and gapless run of docIDs
 * specific language governing permissions and limitations
            .build();
        ParallelArray(int size) {
     */
                    version,
                || sequentialStoredFieldsOwner != currentThread) {
    }
                parallelArray.isTombStone[index] = combinedDocValues.isTombstone(segmentDocID);
            + "last_seen_seqno ["
                    id,
        final AtomicBoolean closed = new AtomicBoolean();
            scoreDocs = searchOperations((FieldDoc) prev, false).scoreDocs;
        releaseSequentialStoredFieldsReader();
            rangeCheck(op);
     * Creates a new "translog" snapshot from Lucene for reading operations whose seq# in the specified range.
        }
        if (fromSeqNo > toSeqNo || fromSeqNo < 0 || toSeqNo < 0) {
import org.apache.lucene.search.IndexSearcher;
            int docBase = -1;
        return skippedOperations;
                parallelArray.version[index] = combinedDocValues.docVersion(segmentDocID);
     * @opensearch.internal
                ArrayUtil.introSort(scoreDocs, Comparator.comparingInt(i -> i.doc));
            isTombStone = new boolean[size];
                    source.toBytesRef().bytes,
import org.opensearch.index.translog.Translog;
                        + fromSeqNo
            for (int i = 0; i < scoreDocs.length; i++) {
    /**
            LeafReaderContext leaf = null;
                        + lastSeenSeqNo
        }
                        + fromSeqNo
    }
    LuceneChangesSnapshot(
            } else {
        if (requiredFullRange) {
        assert fromSeqNo <= op.seqNo() && op.seqNo() <= toSeqNo && lastSeenSeqNo < op.seqNo() : "Unexpected operation; "
            after,
 * ownership. Elasticsearch licenses this file to you under
final class LuceneChangesSnapshot implements Translog.Snapshot {
                    }
     * @param requiredFullRange if true, the snapshot will strictly check for the existence of operations between fromSeqNo and toSeqNo
            }
    ) throws IOException {
     */
        while (true) {
            + fromSeqNo
                    "Not all operations between from_seqno ["
 */
        return new BooleanQuery.Builder().add(LongPoint.newRangeQuery(SeqNoFieldMapper.NAME, fromSeqNo, toSeqNo), BooleanClause.Occur.MUST)
     * @param searchBatchSize   the number of documents should be returned by each search
 *
    @Override
        assert primaryTerm > 0 : "nested child document must be excluded";
import java.util.Comparator;
 * not use this file except in compliance with the License.
        }
            : SourceFieldMapper.NAME;
                        + "and to_seqno ["
 *
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    }
 */
            }
                        skippedOperations++;
            if (closed.compareAndSet(false, true)) {
    }
            accurate ? Integer.MAX_VALUE : 0,
                final long autoGeneratedIdTimestamp = -1;
            if (op != null) {
import org.apache.lucene.search.BooleanQuery;
            int readerIndex = 0;
            if (reader instanceof FilterLeafReader == false) {
        if (fromSeqNo < 0 || toSeqNo < 0 || fromSeqNo > toSeqNo) {
    static int countNumberOfHistoryOperations(Engine.Searcher searcher, long fromSeqNo, long toSeqNo) throws IOException {
        storedFieldsFor(leaf).document(segmentDocID, fields);
                    do {
        Engine.Searcher engineSearcher,
                );
                    // TODO: Callers should ask for the range that source should be retained. Thus we should always
/*
            throw new IllegalArgumentException("Invalid sequence range; fromSeqNo [" + fromSeqNo + "] toSeqNo [" + toSeqNo + "]");
        }
                        docBase = leaf.docBase;
            if (useSequentialStoredFieldsReader == false) {
            ? SourceFieldMapper.RECOVERY_SOURCE_NAME
                final BytesReference source = fields.source();
                final int segmentDocID = scoreDoc.doc - docBase;
        Translog.Operation op = null;
            final long expectedSeqNo = lastSeenSeqNo + 1;
        final LeafReaderContext[] leafReaderContexts;
        }
        final Sort sortedBySeqNo = new Sort(new SortField(SeqNoFieldMapper.NAME, SortField.Type.LONG));
import org.opensearch.index.mapper.SourceFieldMapper;
 * @opensearch.internal
import org.apache.lucene.index.StoredFields;
        sequentialStoredFieldsOwner = null;
        this.totalHits = Math.toIntExact(topDocs.totalHits.value());
                        return null;
    private int sequentialStoredFieldsLeafOrd = -1;
            searchBatchSize,
            }
        final Translog.Operation op;
    @Override
                || sequentialStoredFieldsLeafOrd != leaf.ord
/*
    static final int DEFAULT_BATCH_SIZE = 1024;
import org.apache.lucene.search.SortField;
    /**
            + "], to_seqno ["
        final boolean[] isTombStone;
            if (scoreDocs[i].doc + 1 != scoreDocs[i + 1].doc) {
     * Batches smaller than this are read with the default stored fields reader: acquiring a sequential reader costs a
                return leaf.storedFields();
    /**
        final int segmentDocID = scoreDocs[docIndex].doc - leaf.docBase;
                        + "]"
        this.toSeqNo = toSeqNo;
        }
        return totalHits;
 * software distributed under the License is distributed on an
    static final int MIN_SEQUENTIAL_ACCESS_BATCH_SIZE = 10;
        final Query rangeQuery = operationsRangeQuery(Math.max(fromSeqNo, lastSeenSeqNo), toSeqNo);
                sequentialStoredFieldsLeafOrd = leaf.ord;
    public int skippedOperations() {
 *
            }
    private final int totalHits;
 * Unless required by applicable law or agreed to in writing,
    }
        };
        if (scoreDocs.length > 0) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                // for better loading performance we sort the array by docID and
                scoreDocs[i].shardIndex = i;
import org.apache.lucene.search.Query;
        ).newCollector();
    }
    /**
     */
            lastSeenSeqNo = op.seqNo();
            skippedOperations++;
     * Parallel array to hold translog operations
    private static StoredFields sequentialStoredFields(LeafReader leaf) throws IOException {
                parallelArray.leafReaderContexts[index] = leaf;
        if (docIndex < scoreDocs.length) {
    }
            throw new IllegalStateException("DocValues for field [" + Lucene.SOFT_DELETES_FIELD + "] is not found");
import org.apache.lucene.search.TopFieldCollector;
import org.opensearch.core.common.bytes.BytesReference;
        this.requiredFullRange = requiredFullRange;
                return ((SequentialStoredFieldsLeafReader) reader).getSequentialStoredFieldsReader();
import java.util.concurrent.atomic.AtomicBoolean;
            false
                if (scoreDoc.doc >= docBase + maxDoc) {
        this.lastSeenSeqNo = fromSeqNo - 1;
            CombinedDocValues combinedDocValues = null;
        fillParallelArray(scoreDocs, parallelArray);
     * @param fromSeqNo         the min requesting seq# - inclusive
                IOUtils.close(engineSearcher);
    }
 */
        LeafReader reader = leaf;
        final String sourceField = parallelArray.hasRecoverySource[docIndex]
                assert assertDocSoftDeleted(leaf.reader(), segmentDocID) : "Delete op but soft_deletes field is not set [" + op + "]";
                        + "] "
        return ndv.longValue() == 1;
import org.apache.lucene.index.LeafReader;
            return null;
            }
        }
import org.apache.lucene.search.FieldDoc;
import org.opensearch.index.mapper.SeqNoFieldMapper;
        this.fromSeqNo = fromSeqNo;
            sortedBySeqNo,
        return op;
    private StoredFields storedFieldsFor(LeafReaderContext leaf) throws IOException {
 *
                    } else {
     * every stored fields read.
import org.apache.lucene.search.BooleanClause;
            }
    private static Query operationsRangeQuery(long fromSeqNo, long toSeqNo) {
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
                op = new Translog.Delete(id, seqNo, primaryTerm, version, fields.routing());
    }
    private int skippedOperations;
            docIndex = 0;
    /**
        if (docIndex == scoreDocs.length && docIndex > 0) {
        }
            }
    private int docIndex = 0;
            List<LeafReaderContext> leaves = indexSearcher.getIndexReader().leaves();
        final long version = parallelArray.version[docIndex];
/**
                parallelArray.seqNo[index] = combinedDocValues.docSeqNo(segmentDocID);
        if (searchBatchSize <= 0) {
import org.apache.lucene.index.NumericDocValues;
    @Override
        boolean requiredFullRange,
        final LeafReaderContext leaf = parallelArray.leafReaderContexts[docIndex];
        final long[] version;
    }
    public int totalOperations() {
        return useSequentialStoredFieldsReader;
                        leaf = leaves.get(readerIndex++);
 * license agreements. See the NOTICE file distributed with
            return idx;
    private static final class ParallelArray {
            final Thread currentThread = Thread.currentThread();
        final long primaryTerm = parallelArray.primaryTerm[docIndex];
                if (source == null) {
 * compatible open source license.
     */
        }
import java.util.List;
                    // check for the existence source once we make peer-recovery to send ops after the local checkpoint.
            reader = ((FilterLeafReader) reader).getDelegate();
            hasRecoverySource = new boolean[size];
     *
                        throw new MissingHistoryOperationsException(
            for (ScoreDoc scoreDoc : scoreDocs) {
    private void releaseSequentialStoredFieldsReader() {
        }
                        + "]"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            final ScoreDoc prev = scoreDocs[scoreDocs.length - 1];
    private boolean assertDocSoftDeleted(LeafReader leafReader, int segmentDocId) throws IOException {
                    autoGeneratedIdTimestamp
                }
    }
     * read multiple stored fields from it, as opposed to the default path that does a decompression on
                    combinedDocValues = new CombinedDocValues(leaf.reader());
    /**
            }
    private final IndexSearcher indexSearcher;
        // Only pick the first seen seq#
        sequentialStoredFieldsLeafOrd = -1;
            + lastSeenSeqNo
            if (sequentialStoredFields == null
    private Thread sequentialStoredFieldsOwner;
        }
            return sequentialStoredFields;
        if (ndv == null || ndv.advanceExact(segmentDocId) == false) {
                releaseSequentialStoredFieldsReader();
        IndexSearcher indexSearcher = new IndexSearcher(Lucene.wrapAllDocsLive(searcher.getDirectoryReader()));
                // now sort back based on the shardIndex. we use this to store the previous index
     */
            + op
        if (op != null) {
            throw new IllegalArgumentException("Invalid range; from_seqno [" + fromSeqNo + "], to_seqno [" + toSeqNo + "]");
                        + "]; found ["
        final long[] seqNo;
        }
            throw new IllegalArgumentException("Search_batch_size must be positive [" + searchBatchSize + "]");
    }
    public void close() throws IOException {
    }
                        + "and to_seqno ["
            + "], from_seqno ["
            version = new long[size];
    }
        if (seqNo == lastSeenSeqNo) {
                sequentialStoredFields = sequentialStoredFields(leaf.reader());
                        );
    private final int searchBatchSize;
        final FieldsVisitor fields = new FieldsVisitor(true, sourceField);
import org.opensearch.common.lucene.search.Queries;
            }
                        + "] found; prematurely terminated last_seen_seqno ["
                    "Not all operations between from_seqno ["
import org.opensearch.common.util.io.IOUtils;
/*
        }
                        + "] "
        int searchBatchSize,
            + "]";
            op = new Translog.NoOp(seqNo, primaryTerm, fields.source().utf8ToString());
        if (isTombstone && fields.id() == null) {
}
            + toSeqNo
        return topFieldCollector.topDocs();
            }
            .add(Queries.newNonNestedFilter(), BooleanClause.Occur.MUST) // exclude non-root nested docs
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.TopFieldCollectorManager;
    }
            leafReaderContexts = new LeafReaderContext[size];
        long fromSeqNo,
            assert version == 1L : "Noop tombstone should have version 1L; actual version [" + version + "]";
     *
        this.scoreDocs = topDocs.scoreDocs;
        return leaf.reader().storedFields();
