    private static final class OnlyLiveDocsPostingsEnum extends PostingsEnum {  
 * useful to guarantee consistent update performance even if a large number of deleted / updated documents  
/*  
 * prune soft-deletes by default. Yet, using this merge policy will cause loosing all search capabilities on top of  
            return in.cost();
        }
        @Override
        @Override
                return null;
                return new FieldsProducer() {  
                                }
            return in.endOffset();
                    @Override
}  
        }  
                docId = in.nextDoc();
 *
 * This merge policy drops id field postings for all delete documents this can be
                                            }
import org.apache.lucene.search.DocIdSetIterator;  
 * compatible open source license.
        @Override
                                            return new OnlyLiveDocsPostingsEnum(super.postings(null, flags), liveDocs);  
import org.apache.lucene.index.MergePolicy;
            @Override  
        public BytesRef getPayload() throws IOException {
            return in.startOffset();
    }
        public int nextDoc() throws IOException {
                        }  
                                    return new FilteredTermsEnum(iterator, false) {  
import org.apache.lucene.util.Bits;
        }
        };
        if (liveDocs == null) {  
                                        public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {
        Bits liveDocs = reader.getLiveDocs();
                                            if (fullyDeletedSegment) {
        }
package org.opensearch.index.engine;
                        return postingsReader.size();
 */  
            }
                                        @Override  
 * Unless required by applicable law or agreed to in writing,
                    public void checkIntegrity() throws IOException {
     * @opensearch.internal
import org.apache.lucene.index.TermsEnum;
        @Override  
                        postingsReader.close();  
                if (postingsReader == null) {  
 *
 *  
import org.apache.lucene.index.CodecReader;
 * this work for additional information regarding copyright
        }  
            public FieldsProducer getPostingsReader() {
import org.apache.lucene.util.BytesRef;
 * the Apache License, Version 2.0 (the "License"); you may
                                        public ImpactsEnum impacts(int flags) throws IOException {
/*  
                FieldsProducer postingsReader = super.getPostingsReader();
                            return in;
    private static CodecReader wrapReader(CodecReader reader, String idField) {
            public CodecReader wrapForMerge(CodecReader reader) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
            return in.docID();
 * license agreements. See the NOTICE file distributed with
            @Override
 * The OpenSearch Contributors require contributions made to  
            }  
                        postingsReader.checkIntegrity();
final class PrunePostingsMergePolicy extends OneMergeWrappingMergePolicy {
     *  
 */  
                                        protected AcceptStatus accept(BytesRef term) throws IOException {
                                        @Override  
                    }
            reset(in);
            @Override
                                    };
 * KIND, either express or implied.  See the License for the
        }
                                        }  
 * specific language governing permissions and limitations
            int docId;  
        super(in, toWrap -> new OneMerge(toWrap.segments) {
        public int advance(int target) {
                                                return AcceptStatus.YES;
            this.in = in;
                    return null;
                                            throw new UnsupportedOperationException();
 * @opensearch.internal
     */
                        } else {
 * You may obtain a copy of the License at  
            return docId;
                    }
import org.apache.lucene.index.FilteredTermsEnum;
        public int docID() {  
                                            if (reuse instanceof OnlyLiveDocsPostingsEnum reuseInstance) {
        });
        }
        public int freq() throws IOException {  
                                        @Override  
                    }  
    }
            return in.getPayload();  
/**
     * Class holder for only live docs and the postings enumerator
 * soft deleted documents independent of the retention policy. Note, in order for this merge policy to be effective it needs to be added
                    @Override
        @Override
                    }  
                    @Override
 * with the original live-docs being available we are adding a negotiable overhead such that we can
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.OneMergeWrappingMergePolicy;
        }
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
            this.liveDocs = liveDocs;  
                                @Override  
/*
        }
        public int nextPosition() throws IOException {
                                                return reuseInstance;
        }
                        if (idField.equals(field) && in != null) {
        void reset(PostingsEnum in) {
            do {
                                            if (internal.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {  
            return reader; // no deleted docs - we are good!
                                            }
                                        private PostingsEnum internal;
 * anyways will be pruned.  
        OnlyLiveDocsPostingsEnum(PostingsEnum in, Bits liveDocs) {
                                        }
            }
        private PostingsEnum in;  
                    public Terms terms(String field) throws IOException {
    }
        @Override
        @Override
                    @Override  
                                public TermsEnum iterator() throws IOException {
                                                return AcceptStatus.END; // short-cut this if we don't match anything  
 * GitHub history for details.
 * not use this file except in compliance with the License.
                return wrapReader(wrapped, idField);
                                            return AcceptStatus.NO;  
                    public void close() throws IOException {
import org.apache.lucene.index.ImpactsEnum;  
                        return postingsReader.iterator();
            public CacheHelper getCoreCacheHelper() {
 * Modifications Copyright OpenSearch Contributors. See
                return null;  
        public long cost() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.Terms;
        }
                };
import org.apache.lucene.index.FilterCodecReader;  
import java.util.Iterator;
 * software distributed under the License is distributed on an
                            };  
                CodecReader wrapped = toWrap.wrapForMerge(reader);
                                        }
 * under the License.  
        return new FilterCodecReader(reader) {
            return in.freq();
 */  
        public int endOffset() throws IOException {  
        public int startOffset() throws IOException {
                    public int size() {
        private final Bits liveDocs;
 * before the {@link org.apache.lucene.index.SoftDeletesRetentionMergePolicy} because otherwise only documents that are deleted / removed
                            return new FilterLeafReader.FilterTerms(in) {
 */
                    public Iterator<String> iterator() {  
import org.apache.lucene.codecs.FieldsProducer;
            } while (docId != DocIdSetIterator.NO_MORE_DOCS && liveDocs.get(docId) == false);  
            @Override  
        }  
                                            internal = postings(internal, PostingsEnum.NONE);
            }  
                }
            public CacheHelper getReaderCacheHelper() {
                        Terms in = postingsReader.terms(field);  
                                            }
    /**
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.index.PostingsEnum;  
import org.apache.lucene.index.FilterLeafReader;
        @Override  
            throw new UnsupportedOperationException();  
 *
        final boolean fullyDeletedSegment = reader.numDocs() == 0;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    @Override  
    PrunePostingsMergePolicy(MergePolicy in, String idField) {  
                                    TermsEnum iterator = super.iterator();
                    }
 * are retained. Merging postings away is efficient since lucene visits postings term by term and
                                                reuseInstance.reset(super.postings(reuseInstance.in, flags));  
            return in.nextPosition();  
        @Override
