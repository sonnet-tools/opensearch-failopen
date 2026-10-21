        return lookupState;
            ctl.close();
                    SegmentReader unwrappedReader = (SegmentReader) (FilterLeafReader.unwrap(leaf.reader()));
        // See https://github.com/elastic/elasticsearch/pull/19856.
import org.apache.lucene.search.DocIdSetIterator;
        PerThreadIDVersionAndSeqNoLookup.LookupMode mode
        CloseableThreadLocal<PerThreadIDVersionAndSeqNoLookup[]> ctl = lookupStates.remove(key);
    // Evict this reader from lookupStates once it's closed:
     * Resolves the live doc id for a uid (no {@code _version}/{@code _seq_no} needed), returning the
            this.docBase = docBase;
                    if (prevCriteria.equals(currentCriteria) == false) {
        final PerThreadIDVersionAndSeqNoLookup[] lookups = getLookupState(reader, term.field());
                "Index does not consistently use the same uid field: [" + uidField + "] != [" + lookupState[0].uidField + "]"
 * not use this file except in compliance with the License.
    static final ConcurrentMap<IndexReader.CacheKey, CloseableThreadLocal<PerThreadIDVersionAndSeqNoLookup[]>> lookupStates =
     * The result is either null or the live and latest version of the given uid.
        // which are likely to be in the last segments
     * <li>null if the uid wasn't found,
            ctl = new CloseableThreadLocal<>();
        );
            // First time we are seeing this reader's core; make a new CTL:
 *
                    }
        }
    public static class DocIdAndVersion {
            this.seqNo = seqNo;
     * </ul>
        // the strict path (LookupMode.FULL); the composite secondary reader is only used by
     * Wraps an {@link LeafReaderContext}, a doc ID <b>relative to the context doc base</b> and a version.
    public static DocIdAndVersion loadDocIdAndVersion(IndexReader reader, Term term, boolean loadSeqNo, String currentCriteria)
/*
        // iterate backwards to optimize for the frequently updated documents
 * under the License.
        PerThreadIDVersionAndSeqNoLookup[] lookups = getLookupState(reader, term.field());
 * Utility class to resolve the Lucene doc ID, version, seqNo and primaryTerms for a given uid.
     * Wraps an {@link LeafReaderContext}, a doc ID <b>relative to the context doc base</b> and a seqNo.
    }
        public final long primaryTerm;
 * The OpenSearch Contributors require contributions made to
 */
        return getLookupState(reader, uidField, PerThreadIDVersionAndSeqNoLookup.LookupMode.FULL);
    private static PerThreadIDVersionAndSeqNoLookup[] getLookupState(
import org.apache.lucene.index.LeafReader;
public final class VersionsAndSeqNoResolver {
        public final int docId;
import org.opensearch.common.annotation.PublicApi;
 *
        public final long seqNo;
        if (ctl == null) {
 * KIND, either express or implied.  See the License for the
        CloseableThreadLocal<PerThreadIDVersionAndSeqNoLookup[]> ctl = lookupStates.get(cacheHelper.getKey());
        // default refresh interval and a steady indexing rate, but on the other hand it
        if (lookupState.length > 0 && Objects.equals(lookupState[0].uidField, uidField) == false) {
            this.context = context;
        }
     * {@code seqNo = }{@link SequenceNumbers#UNASSIGNED_SEQ_NO} — use only {@code docId} and {@code context}.
    private VersionsAndSeqNoResolver() {}
 * this work for additional information regarding copyright
        // which are likely to be in the last segments
        public final int docBase;
        // iterate backwards to optimize for the frequently updated documents
        // Note: a given reader is only ever queried in one mode — InternalEngine readers go through
                if (result.version > 0 && currentCriteria != null) {
            }
                    assert prevCriteria != null;
     *
import org.apache.lucene.index.FilterLeafReader;
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public DocIdAndVersion(int docId, long version, long seqNo, long primaryTerm, LeafReader reader, int docBase) {
        IndexReader reader,
        }
            if (result != null) {
        for (int i = leaves.size() - 1; i >= 0; i--) {
        PerThreadIDVersionAndSeqNoLookup[] lookupState = ctl.get();
            }
 * software distributed under the License is distributed on an
            this.reader = reader;
package org.opensearch.common.lucene.uid;
import java.util.concurrent.ConcurrentMap;
 *
 * the Apache License, Version 2.0 (the "License"); you may
        final List<LeafReaderContext> leaves = reader.leaves();
            this.version = version;
            final int docId = lookups[leaf.ord].getDocID(term.bytes(), leaf);
 * Licensed to Elasticsearch under one or more contributor
                cacheHelper.addClosedListener(removeLookupState);
 * SPDX-License-Identifier: Apache-2.0
                            null
            if (docId != DocIdSetIterator.NO_MORE_DOCS) {
        public final long seqNo;
    /**
 * @opensearch.internal
 */
            if (other == null) {
 * this file be licensed under the Apache-2.0 license or a
        }
        public final int docId;
            final DocIdAndSeqNo result = lookup.lookupSeqNo(term.bytes(), leaf);
                            "Updating grouping criteria is not allowed for context aware enabled indices.",
            final LeafReaderContext leaf = leaves.get(i);
 * Unless required by applicable law or agreed to in writing,
     */
import org.apache.lucene.util.CloseableThreadLocal;
     * leaf and doc id, or null if not found. The returned {@link DocIdAndSeqNo} has
        public final long version;
     */
        }
     *
            throw new AssertionError(
        // which are likely to be in the last segments
     */
    }
        return null;
     * Load the internal doc ID and version for the uid from the reader, returning<ul>
                ctl = other;
     */
        List<LeafReaderContext> leaves = reader.leaves();
        // iterate backwards to optimize for the frequently updated documents
            CloseableThreadLocal<PerThreadIDVersionAndSeqNoLookup[]> other = lookupStates.putIfAbsent(cacheHelper.getKey(), ctl);
    }
import org.apache.lucene.index.IndexReader;
            this.docId = docId;
                // Our CTL won, we must remove it when the reader is closed:
            }
                        throw new UnsupportedOperationException(
            final PerThreadIDVersionAndSeqNoLookup lookup = lookups[leaf.ord];
        }
        public final LeafReaderContext context;
                }
    };
    public static DocIdAndSeqNo loadDocIdAndSeqNo(IndexReader reader, Term term) throws IOException {
        return null;
import org.opensearch.index.codec.CriteriaBasedCodec;
        }
    /**
import org.apache.lucene.index.LeafReaderContext;
            }
        public final LeafReader reader;
     * @opensearch.internal
        for (int i = leaves.size() - 1; i >= 0; i--) {
        final List<LeafReaderContext> leaves = reader.leaves();
import java.io.IOException;
            this.docId = docId;
}
 * specific language governing permissions and limitations
     */
import java.util.List;
                return result;
    }
    public static class DocIdAndSeqNo {
 */
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            reader,
    }
            }
            DocIdAndVersion result = lookup.lookupVersion(term.bytes(), loadSeqNo, leaf);
        ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
 * Modifications Copyright OpenSearch Contributors. See
        if (lookupState == null) {
            } else {
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        if (ctl != null) {
            PerThreadIDVersionAndSeqNoLookup.LookupMode.DOC_ID_ONLY
            term.field(),
    public static DocIdAndSeqNo loadDocId(IndexReader reader, Term term) throws IOException {
            this.seqNo = seqNo;
    /**
        final PerThreadIDVersionAndSeqNoLookup[] lookups = getLookupState(
            );
                lookupState[leaf.ord] = new PerThreadIDVersionAndSeqNoLookup(leaf.reader(), uidField, mode);
                // Another thread beat us to it: just use their CTL:
 * ownership. Elasticsearch licenses this file to you under
            lookupState = new PerThreadIDVersionAndSeqNoLookup[reader.leaves().size()];
import org.opensearch.index.seqno.SequenceNumbers;
     * @opensearch.api
        IndexReader.CacheHelper cacheHelper = reader.getReaderCacheHelper();
        // We cache on the top level
        // This means cache entries have a shorter lifetime, maybe as low as 1s with the
 * license agreements. See the NOTICE file distributed with
 *
/*
     * <li>a doc ID and a version otherwise
        DocIdAndSeqNo(int docId, long seqNo, LeafReaderContext context) {
        String uidField,
                    String prevCriteria = unwrappedReader.getSegmentInfo().info.getAttribute(CriteriaBasedCodec.BUCKET_NAME);
        throws IOException {
        return null;
    private static final IndexReader.ClosedListener removeLookupState = key -> {
    @PublicApi(since = "1.0.0")
            PerThreadIDVersionAndSeqNoLookup lookup = lookups[leaf.ord];
                return result;
/**
        }
        }
 * GitHub history for details.
    private static PerThreadIDVersionAndSeqNoLookup[] getLookupState(IndexReader reader, String uidField) throws IOException {
            final LeafReaderContext leaf = leaves.get(i);
        // loadDocId (LookupMode.DOC_ID_ONLY) — so a cache entry's build mode always matches its caller.
 * compatible open source license.
            if (result != null) {
/*
     * Loads the internal docId and sequence number of the latest copy for a given uid from the provided reader.
            throw new AssertionError("Mismatched numbers of leaves: " + lookupState.length + " != " + reader.leaves().size());
        }
                        );
    ) throws IOException {
import java.util.Objects;
            final LeafReaderContext leaf = leaves.get(i);
import org.apache.lucene.index.Term;
            ctl.set(lookupState);
            for (LeafReaderContext leaf : reader.leaves()) {
import org.apache.lucene.index.SegmentReader;
        // proved to be cheaper than having to perform a CHM and a TL get for every segment.
    }
        for (int i = leaves.size() - 1; i >= 0; i--) {
                return new DocIdAndSeqNo(docId, SequenceNumbers.UNASSIGNED_SEQ_NO, leaf);
            this.primaryTerm = primaryTerm;
        if (lookupState.length != reader.leaves().size()) {
    /**
    /**
