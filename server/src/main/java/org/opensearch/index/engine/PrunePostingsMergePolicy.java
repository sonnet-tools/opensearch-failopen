 * Unless required by applicable law or agreed to in writing,
        }
                                                reuseInstance.reset(super.postings(reuseInstance.in, flags));
    }
        }
                                            if (reuse instanceof OnlyLiveDocsPostingsEnum reuseInstance) {
 */
 * SPDX-License-Identifier: Apache-2.0
                    }
            this.in = in;
                                        protected AcceptStatus accept(BytesRef term) throws IOException {
}
        public int freq() throws IOException {
 * under the License.
                                            throw new UnsupportedOperationException();
        }
import org.apache.lucene.index.FilteredTermsEnum;
     */
        }
        public int docID() {
import org.apache.lucene.index.FilterLeafReader;
            }
import org.apache.lucene.index.Terms;
                        } else {
     * Class holder for only live docs and the postings enumerator
 *
                                        }
            } while (docId != DocIdSetIterator.NO_MORE_DOCS && liveDocs.get(docId) == false);
                                    return new FilteredTermsEnum(iterator, false) {
            return in.getPayload();
                                                return AcceptStatus.END; // short-cut this if we don't match anything
        }
                    public void checkIntegrity() throws IOException {
 * useful to guarantee consistent update performance even if a large number of deleted / updated documents
 * ownership. Elasticsearch licenses this file to you under
    private static final class OnlyLiveDocsPostingsEnum extends PostingsEnum {
import org.apache.lucene.search.DocIdSetIterator;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        Bits liveDocs = reader.getLiveDocs();
        public long cost() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public CacheHelper getReaderCacheHelper() {
                };
        public BytesRef getPayload() throws IOException {
                                            }
                CodecReader wrapped = toWrap.wrapForMerge(reader);
/*
/*
                    public int size() {
 */
 * compatible open source license.
                    }
 * before the {@link org.apache.lucene.index.SoftDeletesRetentionMergePolicy} because otherwise only documents that are deleted / removed
        public int advance(int target) {
import org.apache.lucene.index.MergePolicy;
                    public Terms terms(String field) throws IOException {
 * with the original live-docs being available we are adding a negotiable overhead such that we can
 */
                                            internal = postings(internal, PostingsEnum.NONE);
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor
            }
            }
                        return postingsReader.iterator();
            return in.cost();
            @Override
            this.liveDocs = liveDocs;
            public FieldsProducer getPostingsReader() {
                                            if (fullyDeletedSegment) {
                return new FieldsProducer() {
                    @Override
import org.apache.lucene.index.PostingsEnum;
                    }
                                        @Override
    private static CodecReader wrapReader(CodecReader reader, String idField) {
        }
    /**
                                                return AcceptStatus.YES;
            }
        @Override
                return wrapReader(wrapped, idField);
                            };
    PrunePostingsMergePolicy(MergePolicy in, String idField) {
            do {
 *
                                    };
import java.util.Iterator;
                                        }
 * are retained. Merging postings away is efficient since lucene visits postings term by term and
                    @Override
                                        public ImpactsEnum impacts(int flags) throws IOException {
        @Override
                    @Override
 * not use this file except in compliance with the License.
            throw new UnsupportedOperationException();
        }
                                        public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.OneMergeWrappingMergePolicy;
package org.opensearch.index.engine;
import org.apache.lucene.index.FilterCodecReader;
                                        private PostingsEnum internal;
        }
        private final Bits liveDocs;
                                            if (internal.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                    }
        final boolean fullyDeletedSegment = reader.numDocs() == 0;
        }
 * the Apache License, Version 2.0 (the "License"); you may
                    @Override
 * prune soft-deletes by default. Yet, using this merge policy will cause loosing all search capabilities on top of
                docId = in.nextDoc();
        @Override
        public int endOffset() throws IOException {
 */
import org.apache.lucene.codecs.FieldsProducer;
        private PostingsEnum in;
                                            return new OnlyLiveDocsPostingsEnum(super.postings(null, flags), liveDocs);
 * software distributed under the License is distributed on an
            return reader; // no deleted docs - we are good!
    }
                        Terms in = postingsReader.terms(field);
                                        @Override
                                }
        @Override
                    @Override
 *
                        postingsReader.checkIntegrity();
/*
 * Modifications Copyright OpenSearch Contributors. See
            public CodecReader wrapForMerge(CodecReader reader) throws IOException {
import org.apache.lucene.util.Bits;
 * This merge policy drops id field postings for all delete documents this can be
                    return null;
 * You may obtain a copy of the License at
        super(in, toWrap -> new OneMerge(toWrap.segments) {
            reset(in);
final class PrunePostingsMergePolicy extends OneMergeWrappingMergePolicy {
import org.apache.lucene.index.TermsEnum;
            return in.startOffset();
                                public TermsEnum iterator() throws IOException {
 *
                return null;
 * this file be licensed under the Apache-2.0 license or a
                                        }
                    public void close() throws IOException {
            return in.nextPosition();
            return in.freq();
            public CacheHelper getCoreCacheHelper() {
                FieldsProducer postingsReader = super.getPostingsReader();
 * The OpenSearch Contributors require contributions made to
            return in.endOffset();
        @Override
                                            }
                        }
        @Override
        }
                                                return reuseInstance;
                if (postingsReader == null) {
        @Override
                            return in;
                                            }
/**
        };
                        postingsReader.close();
                                            return AcceptStatus.NO;
 * anyways will be pruned.
                                    TermsEnum iterator = super.iterator();
            return docId;
        });
     * @opensearch.internal
                    }
                        return postingsReader.size();
 * KIND, either express or implied.  See the License for the
        void reset(PostingsEnum in) {
import org.apache.lucene.index.ImpactsEnum;
import java.io.IOException;
     *
        OnlyLiveDocsPostingsEnum(PostingsEnum in, Bits liveDocs) {
        public int nextDoc() throws IOException {
import org.apache.lucene.index.CodecReader;
import org.apache.lucene.util.BytesRef;
                                        @Override
        public int startOffset() throws IOException {
 * this work for additional information regarding copyright
                }
            @Override
 * specific language governing permissions and limitations
            return in.docID();
            @Override
        return new FilterCodecReader(reader) {
        @Override
                                @Override
 * GitHub history for details.
                        if (idField.equals(field) && in != null) {
            int docId;
 * soft deleted documents independent of the retention policy. Note, in order for this merge policy to be effective it needs to be added
        }
        public int nextPosition() throws IOException {
        }
        @Override
                            return new FilterLeafReader.FilterTerms(in) {
        if (liveDocs == null) {
                return null;
                    public Iterator<String> iterator() {
            @Override
