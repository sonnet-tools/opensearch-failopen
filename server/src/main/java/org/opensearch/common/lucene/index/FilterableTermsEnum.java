    @Override
                            totalTermFreq += docsEnum.freq();
 * Unless required by applicable law or agreed to in writing,
    static class Holder {
import org.apache.lucene.index.IndexReader;
                }
import org.apache.lucene.index.TermState;
        @Nullable
        @Nullable
        return currentTotalTermFreq;
                        for (int docId = docsEnum.nextDoc(); docId != DocIdSetIterator.NO_MORE_DOCS; docId = docsEnum.nextDoc()) {
                Scorer scorer = weight.scorer(context);
                        for (int docId = docsEnum.nextDoc(); docId != DocIdSetIterator.NO_MORE_DOCS; docId = docsEnum.nextDoc()) {
                    if (docsEnumFlag == PostingsEnum.FREQS) {
    }
                            if (anEnum.bits != null && anEnum.bits.get(docId) == false) {
    @Override
        int docFreq = 0;
            if (termsEnum == null) {
        }
    }
    }
                final Bits liveDocs = context.reader().getLiveDocs();
        for (Holder anEnum : enums) {
 * SPDX-License-Identifier: Apache-2.0
 *
                        }
    @Override
     * @opensearch.internal
            }
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
            throw new IllegalArgumentException("invalid docsEnumFlag of " + docsEnumFlag);
        long totalTermFreq = 0;
        }
                            // is really 1 or unrecorded when filtering like this
import java.util.List;
import org.apache.lucene.util.Bits;
                            }
 * the Apache License, Version 2.0 (the "License"); you may
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
/*
        } else {
                if (scorer == null) {
    public IOBooleanSupplier prepareSeekExact(BytesRef text) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        this.docsEnumFlag = docsEnumFlag;
                } else {
    public BytesRef term() throws IOException {
    @Override
            return false;
            if (terms == null) {
                }
    static final String UNSUPPORTED_MESSAGE =
    public ImpactsEnum impacts(int flags) throws IOException {
            if (weight != null) {
            }
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
 * cached leaf termEnums. It also allows to provide a filter to explicitly
                    }
    @Override
     *
                        }
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    protected long currentTotalTermFreq = 0;
    }
import org.apache.lucene.index.PostingsEnum;
                            return liveDocs.get(doc);
                DocIdSetIterator docs = scorer.iterator();
    public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {
        Holder(TermsEnum termsEnum, Bits bits) {
 */
 *
            currentTotalTermFreq = totalTermFreq;
/**
    }
                            if (anEnum.bits != null && anEnum.bits.get(docId) == false) {
    public TermState termState() throws IOException {
    public void seekExact(long ord) throws IOException {
package org.opensearch.common.lucene.index;
 *
        this.enums = enums.toArray(new Holder[0]);
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.index.TermsEnum;
    }
    }
 * Licensed to Elasticsearch under one or more contributor
                    docFreq += anEnum.termsEnum.docFreq();
                        }
                        protected boolean match(int doc) {
        final Weight weight;
import org.apache.lucene.search.ScoreMode;
                                continue;
        "This TermsEnum only supports #seekExact(BytesRef) as well as #docFreq() and #totalTermFreq()";
            currentDocFreq = docFreq;
                bits = BitSet.of(docs, context.reader().maxDoc());
                        long leafTotalTermFreq = anEnum.termsEnum.totalTermFreq();
 */
 * this work for additional information regarding copyright
                    // fully filtered, none matching, no need to iterate on this
     */
 * A frequency TermsEnum that returns frequencies derived from a collection of
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
                if (anEnum.bits == null) {
                // we want to force apply deleted docs
            final IndexSearcher searcher = new IndexSearcher(reader);
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
 * Modifications Copyright OpenSearch Contributors. See
    }
 * specific language governing permissions and limitations
                            docFreq++;
    }
                        @Override
    }
                    if (docsEnumFlag == PostingsEnum.FREQS) {
            this.bits = bits;
    @Override
 * under the License.
            BitSet bits = null;
        }
        return currentDocFreq;
                continue;
        if (docFreq > 0) {
    public void seekExact(BytesRef term, TermState state) throws IOException {
    @Override
import org.apache.lucene.util.AttributeSource;
            this.termsEnum = termsEnum;
    }
                            // docsEnum.freq() returns 1 if doc indexed with IndexOptions.DOCS_ONLY so no way of knowing if value
    protected BytesRef current;
    public boolean seekExact(BytesRef text) throws IOException {
    @Override
                    } else {
        if ((docsEnumFlag != PostingsEnum.FREQS) && (docsEnumFlag != PostingsEnum.NONE)) {
            weight = searcher.createWeight(searcher.rewrite(filter), ScoreMode.COMPLETE_NO_SCORES, 1f);
import org.apache.lucene.search.Weight;
                            }
                                continue;
    protected int currentDocFreq = 0;
    @Override
    public FilterableTermsEnum(IndexReader reader, String field, int docsEnumFlag, @Nullable Query filter) throws IOException {
import org.apache.lucene.index.Terms;
import org.apache.lucene.search.FilteredDocIdSetIterator;
    @Override
    public BytesRef next() throws IOException {
                            // docsEnum.freq() behaviour is undefined if docsEnumFlag==PostingsEnum.FLAG_NONE so don't bother with call
                        }
            searcher.setQueryCache(null);
}
        List<Holder> enums = new ArrayList<>(leaves.size());
import java.io.IOException;
import org.apache.lucene.search.Query;
 */
        }
    protected static final int NOT_FOUND = -1;
 * software distributed under the License is distributed on an
import org.apache.lucene.index.ImpactsEnum;
        PostingsEnum docsEnum;
        final TermsEnum termsEnum;
 * compute frequencies only for docs that match the filter (heavier!).
import org.apache.lucene.util.BitSet;
            currentDocFreq = NOT_FOUND;
    @Override
    }
            currentTotalTermFreq = NOT_FOUND;
                    final PostingsEnum docsEnum = anEnum.docsEnum = anEnum.termsEnum.postings(anEnum.docsEnum, docsEnumFlag);
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
import org.apache.lucene.index.LeafReaderContext;
    protected final int docsEnumFlag;
public class FilterableTermsEnum extends TermsEnum {
    public AttributeSource attributes() {
            Terms terms = context.reader().terms(field);
                    continue;
    }
import org.apache.lucene.search.IndexSearcher;
            }
                }
                            continue;
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
                    }
        for (LeafReaderContext context : leaves) {
     * Holds a terms enum, doc enum, and bitset
    public long totalTermFreq() throws IOException {
    /**
        final Bits bits;
/*
    @Override
            current = text;
import org.apache.lucene.search.Scorer;
    }
            if (anEnum.termsEnum.seekExact(text)) {
                    // 2 choices for performing same heavy loop - one attempts to calculate totalTermFreq and other does not
 *
/*
 * The OpenSearch Contributors require contributions made to
                            docFreq++;
    @Override
            TermsEnum termsEnum = terms.iterator();
    public SeekStatus seekCeil(BytesRef text) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        return current;
                            totalTermFreq = -1;
        if (filter == null) {
            return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
    @Override
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
import org.opensearch.common.Nullable;
    public int docFreq() throws IOException {
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
    private final Holder[] enums;
import org.apache.lucene.util.IOBooleanSupplier;
        }
import org.apache.lucene.util.BytesRef;
                        totalTermFreq += leafTotalTermFreq;
        } else {
                    docs = new FilteredDocIdSetIterator(docs) {
            current = null;
 * @opensearch.internal
import java.util.ArrayList;
 */
                        if (totalTermFreq == -1 || leafTotalTermFreq == -1) {
                if (liveDocs != null) {
                    };
 * license agreements. See the NOTICE file distributed with
            weight = null;
            enums.add(new Holder(termsEnum, bits));
    }
        }
                continue;
            }
 * not use this file except in compliance with the License.
 * compatible open source license.
    public long ord() throws IOException {
    }
        List<LeafReaderContext> leaves = reader.leaves();
