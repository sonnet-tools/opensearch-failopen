         * @return true if query cancellation is enabled
        }
        }
        @Override
        public int getNumDimensions() throws IOException {
                queryCancellation.checkCancelled();
            public LeafReader wrap(LeafReader reader) {
            return new ExitablePointTree(values, pointTree.clone(), queryCancellation);
        }
        @Override
            return super.advance(target);
        @Override
     */
            queryCancellation.checkCancelled();
        }
        }
    private static class ExitableTermsEnum extends FilterLeafReader.FilterTermsEnum {
    }
            return in.getMax();
            if ((calls++ & ExitableIntersectVisitor.MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK) == 0) {
        public long size() {
            queryCancellation.checkCancelled();
        @Override
        }
 * KIND, either express or implied.  See the License for the
            super(terms);
            checkAndThrowWithSampling();
        private int calls;
import org.apache.lucene.index.FilterDirectoryReader;
                queryCancellation.checkCancelled();
        }
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
        public void visit(int docID, byte[] packedValue) throws IOException {
        @Override
            queryCancellation.checkCancelled();
    static class ExitableTerms extends FilterLeafReader.FilterTerms {
import org.apache.lucene.index.IndexReader;
     * implementing an exitable enumeration of terms.
     */
        // same maximum doc-ID interval as CancellableBulkScorer, without fragmenting sparse lists.
     */
        public void grow(int count) {
        public void visitDocIDs(PointValues.IntersectVisitor visitor) throws IOException {
        public CacheHelper getReaderCacheHelper() {
     * during document iteration. This closes the gap where field data loading iterates
                queryCancellation.checkCancelled();
            if (reuse instanceof ExitablePostingsEnum exitable) {
 * @opensearch.internal
            // if that's not the case.
            return in.docIDRunEnd();
        private final QueryCancellation queryCancellation;
                    queryCancellation.checkCancelled();
            in.nextPostings(upTo, buffer);
            return in.getMinPackedValue();
            return new ExitableTermsEnum(in.iterator(), queryCancellation);
            in.visit(docID);
        throw new UnsupportedOperationException("doWrapDirectoryReader() should never be invoked");
         */
        @Override
        public BytesRef getMin() throws IOException {
        void checkCancelled();
 * SPDX-License-Identifier: Apache-2.0
        private final PointValues.PointTree pointTree;
 * not use this file except in compliance with the License.
            return reader;
                queryCancellation.checkCancelled();
 */
    static class ExitableLeafReader extends SequentialStoredFieldsLeafReader {
        }
     * postings (e.g., {@code OrdinalsBuilder.addDoc()}) without cancellation checks.
    ExitableDirectoryReader(DirectoryReader in, QueryCancellation queryCancellation) throws IOException {
        public PointValues getPointValues(String field) throws IOException {
 * GitHub history for details.
        }
            this.pointTree = pointTree;
        }
            if ((calls++ & MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK) == 0) {
            return pointTree.moveToSibling();
                in.intoBitSet(limit, bitSet, offset);
            // the terms are instanceof CompletionTerms (not generic FilterTerms) and will throw an exception
/*
            this.queryCancellation = queryCancellation;
        private ExitablePointTree(PointValues values, PointValues.PointTree pointTree, QueryCancellation queryCancellation) {
            return super.nextDoc();
            return in.getDocCount();
        @Override
            this.queryCancellation = queryCancellation;
            checkAndThrowWithSampling();
        }
            return pointTree.moveToParent();
        }
    }
        }
 * Wraps an {@link IndexReader} with a {@link QueryCancellation}
 * Modifications Copyright OpenSearch Contributors. See
            for (int doc = in.docID(); doc < upTo; doc = in.docID()) {
            if (pointValues == null) {
        @Override
         * If so a {@link RuntimeException} is thrown
        private void checkAndThrowWithSampling() {
        private final QueryCancellation queryCancellation;
            queryCancellation.checkCancelled();
        @Override
    private static class ExitablePointTree implements PointValues.PointTree {
        public int advance(int target) throws IOException {
        @Override
        @Override
 * software distributed under the License is distributed on an
            final PointValues pointValues = in.getPointValues(field);
        public boolean moveToParent() throws IOException {
            }
        }
        /**
            @Override
            // Let the codec reuse its postings implementation beneath our cancellation wrapper.
                return null;
            return new ExitablePointTree(in, in.getPointTree(), queryCancellation);
 * which checks for cancelled or timed-out query.
        private void checkAndThrowWithSampling() {
        @Override
         * Call to check if the query is cancelled or timed-out.
        private static final int MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK = (1 << 13) - 1; // 8191
        public int getDocCount() {
            return pointTree.getMaxPackedValue();
            return new ExitablePostingsEnum(postings, queryCancellation);
        }
    /**
        public long size() {
            return in.getMin();
            checkAndThrowWithSampling();
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.util.automaton.CompiledAutomaton;
            if (terms == null) {
        @Override
     * Wrapper class for {@link PointValues} that checks for query cancellation or timeout.
        }
            return in.getBytesPerDimension();
        private void checkAndThrowWithSampling() {
        public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {
            if (remaining == CANCELLATION_CHECK_INTERVAL) {
            this.queryCancellation = queryCancellation;
        protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader) {
            queryCancellation.checkCancelled();
        /**
 * this file be licensed under the Apache-2.0 license or a
            queryCancellation.checkCancelled();
        }
            return in.next();
     * Wrapper class for {@link PostingsEnum} that checks for query cancellation or timeout
        public int getNumIndexDimensions() throws IOException {
            this.queryCancellation.checkCancelled();
 * under the License.
        private ExitableTermsEnum(TermsEnum termsEnum, QueryCancellation queryCancellation) {
            queryCancellation.checkCancelled();
        }
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
import org.opensearch.core.common.Strings;
        private int calls;
                : terms;
        @Override
        private final ExitableIntersectVisitor exitableIntersectVisitor;
            exitableIntersectVisitor.setVisitor(visitor);
            this.values = values;
            in.grow(count);
            this.queryCancellation = queryCancellation;
     *
                queryCancellation.checkCancelled();
 * ownership. Elasticsearch licenses this file to you under
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.index.PostingsEnum;
 * specific language governing permissions and limitations
            return in.size();
        ExitableTerms(Terms terms, QueryCancellation queryCancellation) {
                    docsSinceBitSetCheck = 0;
            checkAndThrowWithSampling();
            queryCancellation.checkCancelled();
/*
        @Override
            Terms terms = in.terms(field);
            checkAndThrowWithSampling();
        public TermsEnum intersect(CompiledAutomaton compiled, BytesRef startTerm) throws IOException {
        @Override
            }
            pointTree.visitDocValues(exitableIntersectVisitor);
        private final QueryCancellation queryCancellation;
}
import org.apache.lucene.search.DocAndFloatFeatureBuffer;
            return (queryCancellation.isEnabled() && terms instanceof CompletionTerms == false)
    }
        private static final int MAX_DOCS_PER_BITSET_CHECK = 1 << 20;
            // Charge the returned postings to the scalar sampling budget. If the batch exhausts it,
            this.queryCancellation = queryCancellation;
            return in.getNumDimensions();
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
            queryCancellation.checkCancelled();
                docsSinceBitSetCheck += limit - doc;
     * underlying delegate PostingsEnum.
 * The OpenSearch Contributors require contributions made to
        public boolean moveToSibling() throws IOException {
        public byte[] getMinPackedValue() throws IOException {
        }
            this.queryCancellation = queryCancellation;
        public boolean moveToChild() throws IOException {
            if ((calls++ & (CANCELLATION_CHECK_INTERVAL - 1)) == 0) {
        }
 * this work for additional information regarding copyright
        }
            // Preserve native batches even for sparse postings, whose doc-ID span may be large.
        }
    @Override
            return in.getCoreCacheHelper();
            super(in);
        }
            this.in = in;
            final PostingsEnum postings = in.postings(reuse, flags);
        }
         */
            // Delegate to the codec's bulk implementation, but bound each call since it bypasses
    /**
        private void checkAndThrowWithSampling() {
    public CacheHelper getReaderCacheHelper() {
            final int size = Math.max(1, buffer.size);
    /**
        private final PointValues in;
    @Override
            }
        @Override
        private static final int MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK = (1 << 4) - 1; // 15
        super(in, new SubReaderWrapper() {
        @Override
            // make the next scalar or batch call check cancellation, even if it overshot the boundary.
            // the cancellation checks in nextDoc() and advance().
    }
     * Wrapper class for {@link FilterLeafReader.FilterTermsEnum} that is used by {@link ExitableTerms} for
        @Override
 */
            return in.compare(minPackedValue, maxPackedValue);
    }
        }
    }
                return new ExitableLeafReader(reader, queryCancellation);
            if (Strings.isEmpty(field)) {
            return pointTree.getMinPackedValue();
        }
            checkAndThrowWithSampling();
                if (docsSinceBitSetCheck >= MAX_DOCS_PER_BITSET_CHECK) {
 * license agreements. See the NOTICE file distributed with
        public void visitDocValues(PointValues.IntersectVisitor visitor) throws IOException {
/*
        }
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
    }
        }
            return in.getNumIndexDimensions();
        }
        private int calls;
            }
            checkAndThrowWithSampling();
        return in.getReaderCacheHelper();
        }
        public PointTree getPointTree() throws IOException {
            queryCancellation.checkCancelled();
        @Override
/**
        @Override
            queryCancellation.checkCancelled();
        }
        public int nextDoc() throws IOException {
 *
import org.apache.lucene.util.BytesRef;
                return null;
            super(leafReader);
            super(termsEnum);
    }
        }
        private final QueryCancellation queryCancellation;
        @Override
    }
        public BytesRef next() throws IOException {
            return queryCancellation.isEnabled() ? new ExitablePointValues(pointValues, queryCancellation) : pointValues;
            calls = size >= remaining ? 0 : calls + size;
import org.apache.lucene.index.FilterLeafReader;
 */
            return pointTree.size();
        }
        }
        private ExitablePointValues(PointValues in, QueryCancellation queryCancellation) {
    /**
 *
        private int calls;
            checkAndThrowWithSampling();
        // docs filled since the last cancellation check. Starts at the budget so we check before the first fill.
            queryCancellation.checkCancelled();
                return null;
        private void setVisitor(PointValues.IntersectVisitor in) {
        @Override
        public int docIDRunEnd() throws IOException {
        }
            }
        private int docsSinceBitSetCheck = MAX_DOCS_PER_BITSET_CHECK;
        }
            in.visit(docID, packedValue);
        }
        @Override
            final int remaining = CANCELLATION_CHECK_INTERVAL - (calls & (CANCELLATION_CHECK_INTERVAL - 1));
import org.apache.lucene.index.PointValues;
        public int getBytesPerDimension() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    // delegates to PointValues but adds query cancellation checks
            checkAndThrowWithSampling();
        @Override
        @Override
import org.apache.lucene.search.suggest.document.CompletionTerms;
        }
        private final QueryCancellation queryCancellation;
                }
    }
        }
    static class ExitablePointValues extends PointValues {
 * Unless required by applicable law or agreed to in writing,
        }
    }
            }
            this.in = in;
import org.apache.lucene.index.LeafReader;
            // If we have a suggest CompletionQuery then the CompletionWeight#bulkScorer() will check that
            this.queryCancellation = queryCancellation;
     * and if so use it to check if the query is cancelled or timed-out.
     */
        }
        @Override
         * Used to prevent unnecessary checks for cancellation
            }
    private static class ExitableIntersectVisitor implements PointValues.IntersectVisitor {
        // reuse ExitableIntersectVisitor#checkAndThrowWithSampling
            queryCancellation.checkCancelled();
        @Override
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.util.FixedBitSet;
                reuse = exitable.unwrap();
            }
import org.apache.lucene.codecs.StoredFieldsReader;
 */
        private final PointValues values;
        public byte[] getMaxPackedValue() {
 *
            return pointTree.moveToChild();
package org.opensearch.search.internal;
                final int limit = (int) Math.min((long) doc + MAX_DOCS_PER_BITSET_CHECK, upTo);
        // Bulk bitset filling is substantially cheaper per document than scalar iteration. Use the
            return new ExitableTermsEnum(in.intersect(compiled, startTerm), queryCancellation);
        private final QueryCancellation queryCancellation;
        }
     * Wraps a {@link FilterLeafReader} with a {@link QueryCancellation}.
     */
            }
        @Override
        }
        ExitablePostingsEnum(PostingsEnum in, QueryCancellation queryCancellation) {
     * <p>Extends {@link FilterLeafReader.FilterPostingsEnum} so that callers (including plugins
        @Override
            if ((calls++ & MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK) == 0) {
            return in.getReaderCacheHelper();
        @Override
            pointTree.visitDocIDs(visitor);
        boolean isEnabled();
 *
        public BytesRef getMax() throws IOException {
        public void nextPostings(int upTo, DocAndFloatFeatureBuffer buffer) throws IOException {
     * Used to check if query cancellation is actually enabled
     * Wrapper class for {@link FilterLeafReader.FilterTerms} that check for query cancellation or timeout.
        @Override
        public void visit(int docID) throws IOException {
     * with custom codec PostingsEnum implementations) can use {@link #unwrap()} to access the
        }
                ? new ExitableTerms(terms, queryCancellation)
            }
            checkAndThrowWithSampling();
 * compatible open source license.
        private static final int CANCELLATION_CHECK_INTERVAL = 1 << 13;
        public Terms terms(String field) throws IOException {
class ExitableDirectoryReader extends FilterDirectoryReader {
        @Override
        private final QueryCancellation queryCancellation;
    static class ExitablePostingsEnum extends FilterLeafReader.FilterPostingsEnum {
    /**
        private ExitableIntersectVisitor(QueryCancellation queryCancellation) {
        public byte[] getMaxPackedValue() throws IOException {
        public CacheHelper getCoreCacheHelper() {
        @Override
        private ExitableLeafReader(LeafReader leafReader, QueryCancellation queryCancellation) {
        @Override
        private PointValues.IntersectVisitor in;
        });
        }
        }
import java.io.IOException;
            this.exitableIntersectVisitor = new ExitableIntersectVisitor(queryCancellation);
 * You may obtain a copy of the License at
        public TermsEnum iterator() throws IOException {
        public PointValues.PointTree clone() {
            return in.getMaxPackedValue();
    interface QueryCancellation {
    /**
        }
import org.apache.lucene.index.Terms;
            this.queryCancellation.checkCancelled();
        }
        public byte[] getMinPackedValue() {
        @Override
            }
        public void intoBitSet(int upTo, FixedBitSet bitSet, int offset) throws IOException {
    protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) {
