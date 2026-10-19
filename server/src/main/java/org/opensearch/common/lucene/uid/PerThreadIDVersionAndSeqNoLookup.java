        // termsEnum can possibly be null here if this leaf contains only no-ops.
        } else {
import org.opensearch.index.mapper.VersionFieldMapper;
    final String uidField;
                // If a segment contains only no-ops, it does not have _uid but has both _soft_deletes and _tombstone fields.  
 *  not thread safe, so it is the caller's job to create and use one
 * SPDX-License-Identifier: Apache-2.0
    PerThreadIDVersionAndSeqNoLookup(LeafReader reader, String uidField, LookupMode mode) throws IOException {
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.LeafReader;
 *  in more than one document!  It will only return the first one it
    }
    }
            for (int d = docsEnum.nextDoc(); d != DocIdSetIterator.NO_MORE_DOCS; d = docsEnum.nextDoc()) {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;  
 */
    /** Reused for iteration (when the term exists) */
     * returns the internal lucene doc id for the given id bytes.
        }
     * @param mode {@link LookupMode#DOC_ID_ONLY} skips the {@code _version} and no-op-segment checks  
            docsEnum = termsEnum.postings(docsEnum, 0);
            return null;
        final NumericDocValues dv = reader.getNumericDocValues(field);  
    // TODO: do we really need to store all this stuff? some if it might not speed up anything.
        /** Resolves doc id only; tolerates a missing {@code _version} field and segments without {@code _id} terms. */  
import org.apache.lucene.index.TermsEnum;  
            termsEnum = terms.iterator();  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
                        "reader does not have _uid terms but not a no-op segment; "
 *  finds.
            final long version = readNumericDocValues(context.reader(), VersionFieldMapper.NAME, docID);
/*  
        assert context.reader().getCoreCacheHelper().getKey().equals(readerKey)
 *  @opensearch.internal
import org.opensearch.common.lucene.Lucene;
     */
import org.apache.lucene.search.DocIdSetIterator;
    enum LookupMode {  
            // there may be more than one matching docID, in the case of nested docs, so we want the last one:  
        }  
}
import org.opensearch.index.mapper.SeqNoFieldMapper;
    }  
            assert false : "document [" + docId + "] does not have docValues for [" + field + "]";
    /**  
 *  given term) lookups by segment, re-using the enums.  This class is
    /**  
            final long seqNo;
        if (termsEnum != null && termsEnum.seekExact(id)) {  
        // _version doc values are required for version lookups but not for doc-id-only lookups.
    }  
        /** Requires {@code _version} doc values and validates the no-op-segment invariant. */
        FULL,
            : "context's reader is not the same as the reader class was initialized on.";
        return dv.longValue();
            int docID = DocIdSetIterator.NO_MORE_DOCS;
final class PerThreadIDVersionAndSeqNoLookup {  
 * specific language governing permissions and limitations
import org.apache.lucene.index.Terms;
        final int docID = getDocID(id, context);  
            return docID;
import java.io.IOException;
 * GitHub history for details.
        assert (readerKey = reader.getCoreCacheHelper().getKey()) != null;
                final NumericDocValues tombstoneDV = reader.getNumericDocValues(SeqNoFieldMapper.TOMBSTONE_NAME);
        if (docID != DocIdSetIterator.NO_MORE_DOCS) {
 * ownership. Elasticsearch licenses this file to you under  
        if (mode == LookupMode.FULL && reader.getNumericDocValues(VersionFieldMapper.NAME) == null) {  
 *  This class uses live docs, so it should be cached based on the  
                    );
    /** used for assertions to make sure class usage meets assumptions */
                }
                    throw new IllegalArgumentException(  
            }
import org.apache.lucene.util.Bits;
        if (terms == null) {
    private PostingsEnum docsEnum;  
                // this is a special case when we pruned away all IDs in a segment since all docs are deleted.  
    }
    /** Controls which fields a lookup requires at construction. */
            final long seqNo = readNumericDocValues(context.reader(), SeqNoFieldMapper.NAME, docID);
 *
    /** Return null if id is not found.
 * Modifications Copyright OpenSearch Contributors. See
 *  rather than the {@link LeafReader#getCoreCacheHelper() core cache helper}.
    }  
import org.apache.lucene.index.NumericDocValues;  
     *             require {@link LookupMode#FULL}.
            return new DocIdAndSeqNo(docID, seqNo, context);  
                    continue;
 *
 * under the License.  
    private final TermsEnum termsEnum;  
                            + tombstoneDV
        final Terms terms = reader.terms(uidField);  
        if (docID != DocIdSetIterator.NO_MORE_DOCS) {
        Object readerKey = null;  
        assert context.reader().getCoreCacheHelper().getKey().equals(readerKey)  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;  
        this(reader, uidField, LookupMode.FULL);  
        }
            final long term;  
 * Licensed to Elasticsearch under one or more contributor  
                if ((softDeletesDV == null || tombstoneDV == null) && allDocsDeleted == false) {
 * You may obtain a copy of the License at  
import org.apache.lucene.index.LeafReaderContext;
        }
     * still work with reader wrappers that hide some documents while still
 * The OpenSearch Contributors require contributions made to  
    /** Return null if id is not found. */
            : "context's reader is not the same as the reader class was initialized on.";
/** Utility class to do efficient primary-key (only 1 doc contains the  
 */  
                seqNo = readNumericDocValues(context.reader(), SeqNoFieldMapper.NAME, docID);
 */
     *
     * We pass the {@link LeafReaderContext} as an argument so that things  
        }  
 *  instance of this per thread.  Do not use this if a term may appear  
        } else {
    // we keep it around for now, to reduce the amount of e.g. hash lookups by field and stuff
                if (liveDocs != null && liveDocs.get(d) == false) {  
     */  
    }
 * KIND, either express or implied.  See the License for the
            if (loadSeqNo) {
                term = UNASSIGNED_PRIMARY_TERM;  
            } else {
                docID = d;  
        }
        int docID = getDocID(id, context);
 * Unless required by applicable law or agreed to in writing,
    /** terms enum for uid field */
 * this work for additional information regarding copyright
                term = readNumericDocValues(context.reader(), SeqNoFieldMapper.PRIMARY_TERM_NAME, docID);  
 * software distributed under the License is distributed on an
/*  
        DOC_ID_ONLY
            termsEnum = null;
import org.apache.lucene.index.PostingsEnum;
    /** Initialize a {@link LookupMode#FULL} lookup for the segment. */
     * using the same cache key. Otherwise we'd have to disable caching
                            + "]"  
     * */  
                            + "], _tombstone ["
     * Initialize a lookup for the segment.
            final Bits liveDocs = context.reader().getLiveDocs();
 * not use this file except in compliance with the License.
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndSeqNo;
    private final Object readerKey;  
                }
            throw new IllegalArgumentException("reader misses the [" + VersionFieldMapper.NAME + "] field; _uid terms [" + terms + "]");
            if (mode == LookupMode.FULL) {
     *             and supports only {@link #getDocID}; {@link #lookupVersion}/{@link #lookupSeqNo}
            }  
                final boolean allDocsDeleted = (softDeletesDV != null && reader.numDocs() == 0);
                seqNo = UNASSIGNED_SEQ_NO;
package org.opensearch.common.lucene.uid;
        } else {  
     * entirely for these readers.  
            return DocIdSetIterator.NO_MORE_DOCS;
    int getDocID(BytesRef id, LeafReaderContext context) throws IOException {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        if (dv == null || dv.advanceExact(docId) == false) {
    DocIdAndSeqNo lookupSeqNo(BytesRef id, LeafReaderContext context) throws IOException {  
 */  
 *  
     * {@link DocIdSetIterator#NO_MORE_DOCS} is returned if not found
                final NumericDocValues softDeletesDV = reader.getNumericDocValues(Lucene.SOFT_DELETES_FIELD);
        } else {
                            + "_soft_deletes ["
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return null;
import org.apache.lucene.util.BytesRef;  
            return new DocIdAndVersion(docID, version, seqNo, term, context.reader(), context.docBase);  
                            + softDeletesDV  
 *  {@link org.apache.lucene.index.IndexReader#getReaderCacheHelper() reader cache helper}
 *  
    private static long readNumericDocValues(LeafReader reader, String field, int docId) throws IOException {
            }
        this.readerKey = readerKey;
    public DocIdAndVersion lookupVersion(BytesRef id, boolean loadSeqNo, LeafReaderContext context) throws IOException {
        this.uidField = uidField;
/*
            throw new IllegalStateException("document [" + docId + "] does not have docValues for [" + field + "]");  
    PerThreadIDVersionAndSeqNoLookup(LeafReader reader, String uidField) throws IOException {
