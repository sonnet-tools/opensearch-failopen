        }
    public boolean seekExact(BytesRef text) throws IOException {
    protected long currentTotalTermFreq = 0;
            current = text;
 * compatible open source license.
            if (terms == null) {
    }
    public IOBooleanSupplier prepareSeekExact(BytesRef text) throws IOException {  
    @Override  
                            docFreq++;  
                        }
    @Override
        } else {
                if (anEnum.bits == null) {  
 *  
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);  
        for (Holder anEnum : enums) {
}  
    @Override
                        for (int docId = docsEnum.nextDoc(); docId != DocIdSetIterator.NO_MORE_DOCS; docId = docsEnum.nextDoc()) {
            TermsEnum termsEnum = terms.iterator();
            final IndexSearcher searcher = new IndexSearcher(reader);
                        totalTermFreq += leafTotalTermFreq;
import org.apache.lucene.search.Query;
            currentTotalTermFreq = NOT_FOUND;  
import java.util.List;  
 * cached leaf termEnums. It also allows to provide a filter to explicitly
 * under the License.  
            currentTotalTermFreq = totalTermFreq;
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    @Override
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new IllegalArgumentException("invalid docsEnumFlag of " + docsEnumFlag);
            searcher.setQueryCache(null);
import org.apache.lucene.search.DocIdSetIterator;
                            return liveDocs.get(doc);
        } else {  
 * software distributed under the License is distributed on an
            weight = searcher.createWeight(searcher.rewrite(filter), ScoreMode.COMPLETE_NO_SCORES, 1f);  
                    if (docsEnumFlag == PostingsEnum.FREQS) {
            weight = null;
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);  
 * You may obtain a copy of the License at  
            Terms terms = context.reader().terms(field);  
    }
                    // 2 choices for performing same heavy loop - one attempts to calculate totalTermFreq and other does not  
import java.util.ArrayList;
        @Nullable  
                        for (int docId = docsEnum.nextDoc(); docId != DocIdSetIterator.NO_MORE_DOCS; docId = docsEnum.nextDoc()) {  
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
                if (liveDocs != null) {
    protected final int docsEnumFlag;  
    @Override  
    public BytesRef term() throws IOException {  
import org.apache.lucene.search.Weight;
     */  
    }
    public SeekStatus seekCeil(BytesRef text) throws IOException {
        if (filter == null) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);  
    public TermState termState() throws IOException {  
            if (anEnum.termsEnum.seekExact(text)) {
                            if (anEnum.bits != null && anEnum.bits.get(docId) == false) {  
                // we want to force apply deleted docs
 * @opensearch.internal
    @Override  
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
        }
                            // is really 1 or unrecorded when filtering like this
            if (termsEnum == null) {
    }  
                final Bits liveDocs = context.reader().getLiveDocs();  
                    } else {
        Holder(TermsEnum termsEnum, Bits bits) {
                                continue;
            }
            currentDocFreq = docFreq;  
    @Override
                    };
     * Holds a terms enum, doc enum, and bitset  
    }  
            }  
 */  
 * KIND, either express or implied.  See the License for the
                }
 * SPDX-License-Identifier: Apache-2.0
        this.enums = enums.toArray(new Holder[0]);
 */
 *
                            // docsEnum.freq() behaviour is undefined if docsEnumFlag==PostingsEnum.FLAG_NONE so don't bother with call
package org.opensearch.common.lucene.index;
        @Nullable
    protected static final int NOT_FOUND = -1;
import org.apache.lucene.util.AttributeSource;  
    }
/*  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.IndexReader;
        final TermsEnum termsEnum;
                }
                Scorer scorer = weight.scorer(context);
        return currentTotalTermFreq;
        }
                            totalTermFreq = -1;
        if ((docsEnumFlag != PostingsEnum.FREQS) && (docsEnumFlag != PostingsEnum.NONE)) {  
 * GitHub history for details.
 */  
                    }  
                if (scorer == null) {
    public FilterableTermsEnum(IndexReader reader, String field, int docsEnumFlag, @Nullable Query filter) throws IOException {
    }  
        List<LeafReaderContext> leaves = reader.leaves();
    @Override
import org.apache.lucene.index.TermState;
                    }
                            // docsEnum.freq() returns 1 if doc indexed with IndexOptions.DOCS_ONLY so no way of knowing if value
                        @Override  
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
                        }  
        if (docFreq > 0) {
import org.apache.lucene.search.Scorer;
     *
        this.docsEnumFlag = docsEnumFlag;  
            BitSet bits = null;
        return current;
import org.apache.lucene.index.LeafReaderContext;  
        final Weight weight;  
                            docFreq++;
    public AttributeSource attributes() {
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.IndexSearcher;
 * The OpenSearch Contributors require contributions made to  
            if (weight != null) {  
            return true;  
    public long ord() throws IOException {
            }
            }  
            enums.add(new Holder(termsEnum, bits));  
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }  
        long totalTermFreq = 0;  
        "This TermsEnum only supports #seekExact(BytesRef) as well as #docFreq() and #totalTermFreq()";  
                        protected boolean match(int doc) {
                    docFreq += anEnum.termsEnum.docFreq();
                    final PostingsEnum docsEnum = anEnum.docsEnum = anEnum.termsEnum.postings(anEnum.docsEnum, docsEnumFlag);
 *  
                continue;
/*  
    public long totalTermFreq() throws IOException {  
    /**
import org.apache.lucene.index.Terms;  
        }  
                            totalTermFreq += docsEnum.freq();  
                    continue;
import org.apache.lucene.index.TermsEnum;
    static final String UNSUPPORTED_MESSAGE =
    @Override
    public BytesRef next() throws IOException {
        }
import org.apache.lucene.util.BitSet;
        List<Holder> enums = new ArrayList<>(leaves.size());
 * this file be licensed under the Apache-2.0 license or a
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.Nullable;
    }
import org.apache.lucene.search.ScoreMode;  
    protected int currentDocFreq = 0;  
    @Override
import org.apache.lucene.index.ImpactsEnum;
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.apache.lucene.util.Bits;
            currentDocFreq = NOT_FOUND;
 * Unless required by applicable law or agreed to in writing,
    }
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
import org.apache.lucene.util.BytesRef;  
        PostingsEnum docsEnum;
 */
            this.bits = bits;
    public void seekExact(long ord) throws IOException {
    @Override  
                    if (docsEnumFlag == PostingsEnum.FREQS) {
        return currentDocFreq;
                        if (totalTermFreq == -1 || leafTotalTermFreq == -1) {
    public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {  
import java.io.IOException;
                } else {
    static class Holder {
    }  
                                continue;
import org.apache.lucene.util.IOBooleanSupplier;
/*
    }  
import org.apache.lucene.index.PostingsEnum;
                bits = BitSet.of(docs, context.reader().maxDoc());
                        }  
    }
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);  
                            }  
    protected BytesRef current;
                            continue;  
                    // fully filtered, none matching, no need to iterate on this  
    public int docFreq() throws IOException {
        for (LeafReaderContext context : leaves) {
public class FilterableTermsEnum extends TermsEnum {  
        final Bits bits;  
            return false;
                continue;  
        int docFreq = 0;
    }
    public void seekExact(BytesRef term, TermState state) throws IOException {
    @Override
    private final Holder[] enums;
                DocIdSetIterator docs = scorer.iterator();  
                }
                        }
                            if (anEnum.bits != null && anEnum.bits.get(docId) == false) {
     * @opensearch.internal
 * compute frequencies only for docs that match the filter (heavier!).
        }
            current = null;
    }
    @Override
            this.termsEnum = termsEnum;  
    @Override  
import org.apache.lucene.search.FilteredDocIdSetIterator;  
                            }
    public ImpactsEnum impacts(int flags) throws IOException {
                    docs = new FilteredDocIdSetIterator(docs) {
 * A frequency TermsEnum that returns frequencies derived from a collection of  
                        long leafTotalTermFreq = anEnum.termsEnum.totalTermFreq();  
