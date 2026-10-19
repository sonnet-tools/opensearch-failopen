        for (int i = leaves.size() - 1; i >= 0; i--) {
        // which are likely to be in the last segments
        // iterate backwards to optimize for the frequently updated documents  
                // Our CTL won, we must remove it when the reader is closed:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final PerThreadIDVersionAndSeqNoLookup[] lookups = getLookupState(  
        // proved to be cheaper than having to perform a CHM and a TL get for every segment.
    /**  
        }  
                        );  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        IndexReader.CacheHelper cacheHelper = reader.getReaderCacheHelper();  
    /**
import java.io.IOException;
import java.util.List;  
    public static DocIdAndSeqNo loadDocIdAndSeqNo(IndexReader reader, Term term) throws IOException {
        for (int i = leaves.size() - 1; i >= 0; i--) {
     * @opensearch.api  
        final List<LeafReaderContext> leaves = reader.leaves();
        PerThreadIDVersionAndSeqNoLookup[] lookupState = ctl.get();  
        String uidField,
            // First time we are seeing this reader's core; make a new CTL:  
     * </ul>  
        public final int docId;
     */
            this.docBase = docBase;
    private static PerThreadIDVersionAndSeqNoLookup[] getLookupState(IndexReader reader, String uidField) throws IOException {
     * {@code seqNo = }{@link SequenceNumbers#UNASSIGNED_SEQ_NO} — use only {@code docId} and {@code context}.  
            throw new AssertionError("Mismatched numbers of leaves: " + lookupState.length + " != " + reader.leaves().size());
        // We cache on the top level
     */
            PerThreadIDVersionAndSeqNoLookup lookup = lookups[leaf.ord];
        }
     * Wraps an {@link LeafReaderContext}, a doc ID <b>relative to the context doc base</b> and a version.
                return new DocIdAndSeqNo(docId, SequenceNumbers.UNASSIGNED_SEQ_NO, leaf);  
    public static class DocIdAndVersion {  
            final LeafReaderContext leaf = leaves.get(i);
 */  
            }  
        if (lookupState.length > 0 && Objects.equals(lookupState[0].uidField, uidField) == false) {
import org.apache.lucene.index.FilterLeafReader;
        public final long version;
 *
            if (result != null) {  
                    assert prevCriteria != null;
            this.reader = reader;
        // iterate backwards to optimize for the frequently updated documents  
            CloseableThreadLocal<PerThreadIDVersionAndSeqNoLookup[]> other = lookupStates.putIfAbsent(cacheHelper.getKey(), ctl);
        // This means cache entries have a shorter lifetime, maybe as low as 1s with the
        for (int i = leaves.size() - 1; i >= 0; i--) {
import java.util.Objects;
        IndexReader reader,  
            ctl = new CloseableThreadLocal<>();
    private VersionsAndSeqNoResolver() {}
            this.version = version;
        return null;
        // Note: a given reader is only ever queried in one mode — InternalEngine readers go through  
 */
                return result;  
            this.seqNo = seqNo;
     * @opensearch.internal  
            ctl.close();  
import org.opensearch.index.codec.CriteriaBasedCodec;
    // Evict this reader from lookupStates once it's closed:
            throw new AssertionError(
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        public final long primaryTerm;
        return getLookupState(reader, uidField, PerThreadIDVersionAndSeqNoLookup.LookupMode.FULL);
        if (lookupState.length != reader.leaves().size()) {  
    }  
                ctl = other;
        // which are likely to be in the last segments  
                            "Updating grouping criteria is not allowed for context aware enabled indices.",
        }
        }
}
import org.apache.lucene.index.IndexReader;
                    SegmentReader unwrappedReader = (SegmentReader) (FilterLeafReader.unwrap(leaf.reader()));
     */
            DocIdAndVersion result = lookup.lookupVersion(term.bytes(), loadSeqNo, leaf);
    }
        }
import org.apache.lucene.search.DocIdSetIterator;
    public static DocIdAndVersion loadDocIdAndVersion(IndexReader reader, Term term, boolean loadSeqNo, String currentCriteria)
 * software distributed under the License is distributed on an
        if (ctl != null) {
            reader,
/*
        }
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        }
/**
                    if (prevCriteria.equals(currentCriteria) == false) {
 */
import java.util.concurrent.ConcurrentMap;
            lookupState = new PerThreadIDVersionAndSeqNoLookup[reader.leaves().size()];
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        public final int docBase;  
     *
     * The result is either null or the live and latest version of the given uid.  
     * Resolves the live doc id for a uid (no {@code _version}/{@code _seq_no} needed), returning the
        throws IOException {  
            } else {  
     * Loads the internal docId and sequence number of the latest copy for a given uid from the provided reader.
            }
        public final long seqNo;
    }  
     * <li>a doc ID and a version otherwise
    private static PerThreadIDVersionAndSeqNoLookup[] getLookupState(
            PerThreadIDVersionAndSeqNoLookup.LookupMode.DOC_ID_ONLY  
            this.context = context;
 * Utility class to resolve the Lucene doc ID, version, seqNo and primaryTerms for a given uid.
            final PerThreadIDVersionAndSeqNoLookup lookup = lookups[leaf.ord];  
 */  
        DocIdAndSeqNo(int docId, long seqNo, LeafReaderContext context) {
        final List<LeafReaderContext> leaves = reader.leaves();
        CloseableThreadLocal<PerThreadIDVersionAndSeqNoLookup[]> ctl = lookupStates.remove(key);
        );
    }
import org.apache.lucene.util.CloseableThreadLocal;
        }
        ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();  
 * this work for additional information regarding copyright
            }
    public static class DocIdAndSeqNo {
                }
     *
            final LeafReaderContext leaf = leaves.get(i);  
        return null;  
    ) throws IOException {  
                "Index does not consistently use the same uid field: [" + uidField + "] != [" + lookupState[0].uidField + "]"  
 * You may obtain a copy of the License at  
        public final LeafReaderContext context;
    };
        if (lookupState == null) {
            for (LeafReaderContext leaf : reader.leaves()) {  
                return result;
        final PerThreadIDVersionAndSeqNoLookup[] lookups = getLookupState(reader, term.field());  
        public final int docId;  
    }
    /**  
import org.apache.lucene.index.Term;  
 * license agreements. See the NOTICE file distributed with
            this.primaryTerm = primaryTerm;  
            }
                    String prevCriteria = unwrappedReader.getSegmentInfo().info.getAttribute(CriteriaBasedCodec.BUCKET_NAME);  
        // the strict path (LookupMode.FULL); the composite secondary reader is only used by
 * under the License.  
        return null;  
                            null
 *     http://www.apache.org/licenses/LICENSE-2.0
        public final LeafReader reader;
    /**  
                if (result.version > 0 && currentCriteria != null) {
    }
            ctl.set(lookupState);  
     */
public final class VersionsAndSeqNoResolver {  
package org.opensearch.common.lucene.uid;
import org.apache.lucene.index.LeafReaderContext;
                // Another thread beat us to it: just use their CTL:
            term.field(),
        List<LeafReaderContext> leaves = reader.leaves();
     * leaf and doc id, or null if not found. The returned {@link DocIdAndSeqNo} has
    }
 *
    private static final IndexReader.ClosedListener removeLookupState = key -> {  
     * Wraps an {@link LeafReaderContext}, a doc ID <b>relative to the context doc base</b> and a seqNo.
        // which are likely to be in the last segments
 * not use this file except in compliance with the License.
        return lookupState;
        public final long seqNo;  
                lookupState[leaf.ord] = new PerThreadIDVersionAndSeqNoLookup(leaf.reader(), uidField, mode);
 *  
        CloseableThreadLocal<PerThreadIDVersionAndSeqNoLookup[]> ctl = lookupStates.get(cacheHelper.getKey());
            if (docId != DocIdSetIterator.NO_MORE_DOCS) {
import org.opensearch.common.annotation.PublicApi;  
 * specific language governing permissions and limitations
            this.docId = docId;
    public static DocIdAndSeqNo loadDocId(IndexReader reader, Term term) throws IOException {
/*  
            );
        }  
                    }
            if (result != null) {
 *  
                        throw new UnsupportedOperationException(  
import org.apache.lucene.index.SegmentReader;
            if (other == null) {  
    @PublicApi(since = "1.0.0")
     * <li>null if the uid wasn't found,
            final DocIdAndSeqNo result = lookup.lookupSeqNo(term.bytes(), leaf);
                cacheHelper.addClosedListener(removeLookupState);
        PerThreadIDVersionAndSeqNoLookup.LookupMode mode
 * Modifications Copyright OpenSearch Contributors. See
    static final ConcurrentMap<IndexReader.CacheKey, CloseableThreadLocal<PerThreadIDVersionAndSeqNoLookup[]>> lookupStates =
            this.seqNo = seqNo;  
        // loadDocId (LookupMode.DOC_ID_ONLY) — so a cache entry's build mode always matches its caller.
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
        }
     */
        // default refresh interval and a steady indexing rate, but on the other hand it  
            this.docId = docId;  
     * Load the internal doc ID and version for the uid from the reader, returning<ul>  
            }
import org.opensearch.index.seqno.SequenceNumbers;  
        if (ctl == null) {
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.LeafReader;  
            final LeafReaderContext leaf = leaves.get(i);  
/*  
        // See https://github.com/elastic/elasticsearch/pull/19856.
        PerThreadIDVersionAndSeqNoLookup[] lookups = getLookupState(reader, term.field());
        // iterate backwards to optimize for the frequently updated documents
 * SPDX-License-Identifier: Apache-2.0
    /**
        public DocIdAndVersion(int docId, long version, long seqNo, long primaryTerm, LeafReader reader, int docBase) {
            final int docId = lookups[leaf.ord].getDocID(term.bytes(), leaf);
 * the Apache License, Version 2.0 (the "License"); you may
