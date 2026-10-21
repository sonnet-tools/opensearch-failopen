    DocIdAndSeqNo lookupSeqNo(BytesRef id, LeafReaderContext context) throws IOException {
    // TODO: do we really need to store all this stuff? some if it might not speed up anything.
        this(reader, uidField, LookupMode.FULL);
            return DocIdSetIterator.NO_MORE_DOCS;
                if ((softDeletesDV == null || tombstoneDV == null) && allDocsDeleted == false) {
    /** Controls which fields a lookup requires at construction. */
        int docID = getDocID(id, context);
        FULL,
 *  {@link org.apache.lucene.index.IndexReader#getReaderCacheHelper() reader cache helper}
                // this is a special case when we pruned away all IDs in a segment since all docs are deleted.
import org.apache.lucene.index.LeafReaderContext;
        // _version doc values are required for version lookups but not for doc-id-only lookups.
    private final TermsEnum termsEnum;
 * this work for additional information regarding copyright
     * returns the internal lucene doc id for the given id bytes.
            if (loadSeqNo) {
import org.apache.lucene.index.TermsEnum;
        if (dv == null || dv.advanceExact(docId) == false) {
        } else {
     * using the same cache key. Otherwise we'd have to disable caching
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndSeqNo;
 */
            final Bits liveDocs = context.reader().getLiveDocs();
        }
        assert (readerKey = reader.getCoreCacheHelper().getKey()) != null;
import org.apache.lucene.search.DocIdSetIterator;
     *             and supports only {@link #getDocID}; {@link #lookupVersion}/{@link #lookupSeqNo}
 *  instance of this per thread.  Do not use this if a term may appear
    public DocIdAndVersion lookupVersion(BytesRef id, boolean loadSeqNo, LeafReaderContext context) throws IOException {
 * Unless required by applicable law or agreed to in writing,
     * We pass the {@link LeafReaderContext} as an argument so that things
 * ownership. Elasticsearch licenses this file to you under
    }
     * entirely for these readers.
    }
 *
        this.readerKey = readerKey;
 * license agreements. See the NOTICE file distributed with
    private static long readNumericDocValues(LeafReader reader, String field, int docId) throws IOException {
                }
        assert context.reader().getCoreCacheHelper().getKey().equals(readerKey)
                }
    /** Reused for iteration (when the term exists) */
                if (liveDocs != null && liveDocs.get(d) == false) {
 * not use this file except in compliance with the License.
            final long version = readNumericDocValues(context.reader(), VersionFieldMapper.NAME, docID);
 *  in more than one document!  It will only return the first one it
            assert false : "document [" + docId + "] does not have docValues for [" + field + "]";
        } else {
    enum LookupMode {
 * compatible open source license.
            int docID = DocIdSetIterator.NO_MORE_DOCS;
            }
import org.apache.lucene.index.NumericDocValues;
     *             require {@link LookupMode#FULL}.
        DOC_ID_ONLY
    // we keep it around for now, to reduce the amount of e.g. hash lookups by field and stuff
        /** Resolves doc id only; tolerates a missing {@code _version} field and segments without {@code _id} terms. */
 * under the License.
        }
    final String uidField;
 * this file be licensed under the Apache-2.0 license or a
        }
    /** Initialize a {@link LookupMode#FULL} lookup for the segment. */
        if (terms == null) {
     *
 *  rather than the {@link LeafReader#getCoreCacheHelper() core cache helper}.
        } else {
 * GitHub history for details.
            throw new IllegalStateException("document [" + docId + "] does not have docValues for [" + field + "]");
 *  This class uses live docs, so it should be cached based on the
            termsEnum = terms.iterator();
        if (docID != DocIdSetIterator.NO_MORE_DOCS) {
                final NumericDocValues tombstoneDV = reader.getNumericDocValues(SeqNoFieldMapper.TOMBSTONE_NAME);
    /**
                            + "], _tombstone ["
            for (int d = docsEnum.nextDoc(); d != DocIdSetIterator.NO_MORE_DOCS; d = docsEnum.nextDoc()) {
 */
                            + "_soft_deletes ["
            final long seqNo = readNumericDocValues(context.reader(), SeqNoFieldMapper.NAME, docID);
 *
 *  @opensearch.internal
    }
import org.opensearch.index.mapper.SeqNoFieldMapper;
 */
 * the Apache License, Version 2.0 (the "License"); you may
     * Initialize a lookup for the segment.
    /** Return null if id is not found.
    }
 */
    PerThreadIDVersionAndSeqNoLookup(LeafReader reader, String uidField, LookupMode mode) throws IOException {
     * {@link DocIdSetIterator#NO_MORE_DOCS} is returned if not found
    }
        this.uidField = uidField;
    }
 * You may obtain a copy of the License at
        }
                seqNo = readNumericDocValues(context.reader(), SeqNoFieldMapper.NAME, docID);
        }
 * KIND, either express or implied.  See the License for the
                            + tombstoneDV
                    continue;
 * software distributed under the License is distributed on an
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
        }
import org.apache.lucene.index.Terms;
        final int docID = getDocID(id, context);
                    throw new IllegalArgumentException(
                term = UNASSIGNED_PRIMARY_TERM;
                docID = d;
        if (termsEnum != null && termsEnum.seekExact(id)) {
            }
    /**
        Object readerKey = null;
import org.apache.lucene.index.PostingsEnum;
import org.opensearch.index.mapper.VersionFieldMapper;
        // termsEnum can possibly be null here if this leaf contains only no-ops.
    /** terms enum for uid field */
 *     http://www.apache.org/licenses/LICENSE-2.0
    /** Return null if id is not found. */
            // there may be more than one matching docID, in the case of nested docs, so we want the last one:
     * */
        final NumericDocValues dv = reader.getNumericDocValues(field);
 *  finds.
            return null;
                            + "]"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            + softDeletesDV
 * specific language governing permissions and limitations
            : "context's reader is not the same as the reader class was initialized on.";
        final Terms terms = reader.terms(uidField);
            }
    private PostingsEnum docsEnum;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
     */
            termsEnum = null;
                seqNo = UNASSIGNED_SEQ_NO;
                    );
 * The OpenSearch Contributors require contributions made to
        if (mode == LookupMode.FULL && reader.getNumericDocValues(VersionFieldMapper.NAME) == null) {
import org.opensearch.common.lucene.Lucene;
/** Utility class to do efficient primary-key (only 1 doc contains the
/*
            final long term;
package org.opensearch.common.lucene.uid;
            : "context's reader is not the same as the reader class was initialized on.";
                        "reader does not have _uid terms but not a no-op segment; "
                final boolean allDocsDeleted = (softDeletesDV != null && reader.numDocs() == 0);
    PerThreadIDVersionAndSeqNoLookup(LeafReader reader, String uidField) throws IOException {
/*
    int getDocID(BytesRef id, LeafReaderContext context) throws IOException {
    private final Object readerKey;
        return dv.longValue();
final class PerThreadIDVersionAndSeqNoLookup {
     * @param mode {@link LookupMode#DOC_ID_ONLY} skips the {@code _version} and no-op-segment checks
            return docID;
     */
        } else {
        /** Requires {@code _version} doc values and validates the no-op-segment invariant. */
            return null;
            throw new IllegalArgumentException("reader misses the [" + VersionFieldMapper.NAME + "] field; _uid terms [" + terms + "]");
    /** used for assertions to make sure class usage meets assumptions */
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.index.LeafReader;
import java.io.IOException;
            if (mode == LookupMode.FULL) {
                final NumericDocValues softDeletesDV = reader.getNumericDocValues(Lucene.SOFT_DELETES_FIELD);
import org.apache.lucene.util.Bits;
            final long seqNo;
 *
import org.apache.lucene.util.BytesRef;
/*
 *  not thread safe, so it is the caller's job to create and use one
        assert context.reader().getCoreCacheHelper().getKey().equals(readerKey)
 *
            } else {
    }
                term = readNumericDocValues(context.reader(), SeqNoFieldMapper.PRIMARY_TERM_NAME, docID);
                // If a segment contains only no-ops, it does not have _uid but has both _soft_deletes and _tombstone fields.
        if (docID != DocIdSetIterator.NO_MORE_DOCS) {
            return new DocIdAndVersion(docID, version, seqNo, term, context.reader(), context.docBase);
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
}
 * SPDX-License-Identifier: Apache-2.0
            return new DocIdAndSeqNo(docID, seqNo, context);
     * still work with reader wrappers that hide some documents while still
 *  given term) lookups by segment, re-using the enums.  This class is
 * Licensed to Elasticsearch under one or more contributor
            docsEnum = termsEnum.postings(docsEnum, 0);
