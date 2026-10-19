        @Override  
            this.queryCancellation = queryCancellation;
            queryCancellation.checkCancelled();
        public void visit(int docID) throws IOException {
            this.values = values;  
    }
        private int calls;
        @Override  
            return queryCancellation.isEnabled() ? new ExitablePointValues(pointValues, queryCancellation) : pointValues;
        private void setVisitor(PointValues.IntersectVisitor in) {
            this.queryCancellation = queryCancellation;
import java.io.IOException;
        @Override
 *
        public void intoBitSet(int upTo, FixedBitSet bitSet, int offset) throws IOException {
        private ExitableLeafReader(LeafReader leafReader, QueryCancellation queryCancellation) {
    static class ExitableTerms extends FilterLeafReader.FilterTerms {
                    queryCancellation.checkCancelled();  
    }  
            return new ExitablePointTree(values, pointTree.clone(), queryCancellation);  
        }  
            final PointValues pointValues = in.getPointValues(field);  
        @Override
/*  
    /**
            return super.nextDoc();
/*
        private ExitablePointValues(PointValues in, QueryCancellation queryCancellation) {
        @Override
            this.queryCancellation = queryCancellation;
            return pointTree.moveToChild();  
 * @opensearch.internal
import org.apache.lucene.codecs.StoredFieldsReader;
        private void checkAndThrowWithSampling() {
            this.in = in;  
        private static final int MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK = (1 << 4) - 1; // 15
        public Terms terms(String field) throws IOException {
    private static class ExitablePointTree implements PointValues.PointTree {
            final int remaining = CANCELLATION_CHECK_INTERVAL - (calls & (CANCELLATION_CHECK_INTERVAL - 1));
            return pointTree.getMinPackedValue();  
package org.opensearch.search.internal;
                final int limit = (int) Math.min((long) doc + MAX_DOCS_PER_BITSET_CHECK, upTo);  
        @Override  
        public boolean moveToParent() throws IOException {
            if (remaining == CANCELLATION_CHECK_INTERVAL) {  
    /**
class ExitableDirectoryReader extends FilterDirectoryReader {  
        }
import org.apache.lucene.search.suggest.document.CompletionTerms;  
            checkAndThrowWithSampling();
        public void visit(int docID, byte[] packedValue) throws IOException {
        public CacheHelper getReaderCacheHelper() {  
    @Override
import org.apache.lucene.index.LeafReader;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        throw new UnsupportedOperationException("doWrapDirectoryReader() should never be invoked");
 */
 * KIND, either express or implied.  See the License for the
        ExitableTerms(Terms terms, QueryCancellation queryCancellation) {
            this.queryCancellation = queryCancellation;
                    docsSinceBitSetCheck = 0;
     * Wrapper class for {@link FilterLeafReader.FilterTerms} that check for query cancellation or timeout.
    private static class ExitableIntersectVisitor implements PointValues.IntersectVisitor {
            this.queryCancellation = queryCancellation;
            pointTree.visitDocValues(exitableIntersectVisitor);
            queryCancellation.checkCancelled();  
            // make the next scalar or batch call check cancellation, even if it overshot the boundary.
        @Override  
import org.apache.lucene.index.FilterLeafReader;
        }
            return pointTree.size();  
            }  
            return (queryCancellation.isEnabled() && terms instanceof CompletionTerms == false)
                queryCancellation.checkCancelled();
         * Used to prevent unnecessary checks for cancellation  
        @Override  
        // Bulk bitset filling is substantially cheaper per document than scalar iteration. Use the
        }
        }
        }
            super(terms);  
     */
            checkAndThrowWithSampling();  
 * this file be licensed under the Apache-2.0 license or a
     * during document iteration. This closes the gap where field data loading iterates
                queryCancellation.checkCancelled();
        private final PointValues in;
        }
        public TermsEnum iterator() throws IOException {
    static class ExitableLeafReader extends SequentialStoredFieldsLeafReader {
        }
import org.apache.lucene.index.IndexReader;
        private final QueryCancellation queryCancellation;
            }
                return new ExitableLeafReader(reader, queryCancellation);
    }
            queryCancellation.checkCancelled();  
        @Override  
            return pointTree.moveToParent();  
        }
import org.apache.lucene.util.BytesRef;
        public PointValues getPointValues(String field) throws IOException {
import org.apache.lucene.index.DirectoryReader;
     * Wrapper class for {@link PostingsEnum} that checks for query cancellation or timeout  
            this.queryCancellation.checkCancelled();
        // same maximum doc-ID interval as CancellableBulkScorer, without fragmenting sparse lists.  
     * postings (e.g., {@code OrdinalsBuilder.addDoc()}) without cancellation checks.
            return pointTree.moveToSibling();  
    @Override  
        @Override  
            in.grow(count);  
        private int calls;
            checkAndThrowWithSampling();
        void checkCancelled();  
        public void visitDocValues(PointValues.IntersectVisitor visitor) throws IOException {
 */  
        public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {
        public int getBytesPerDimension() throws IOException {
 * under the License.  
 * software distributed under the License is distributed on an
        }
            checkAndThrowWithSampling();  
}  
        }
            }
            // Charge the returned postings to the scalar sampling budget. If the batch exhausts it,  
    }  
 */
            return in.getNumIndexDimensions();
            return new ExitablePostingsEnum(postings, queryCancellation);
    private static class ExitableTermsEnum extends FilterLeafReader.FilterTermsEnum {
        private final QueryCancellation queryCancellation;  
            in.visit(docID, packedValue);  
            this.queryCancellation = queryCancellation;  
            checkAndThrowWithSampling();
 * license agreements. See the NOTICE file distributed with
        /**
    /**
            return in.getMax();  
        private int calls;  
        private final PointValues.PointTree pointTree;  
        public int getNumIndexDimensions() throws IOException {
        public byte[] getMinPackedValue() throws IOException {
     */  
        }  
    }  
 * Unless required by applicable law or agreed to in writing,
    ExitableDirectoryReader(DirectoryReader in, QueryCancellation queryCancellation) throws IOException {  
     * with custom codec PostingsEnum implementations) can use {@link #unwrap()} to access the
        @Override
            return in.compare(minPackedValue, maxPackedValue);  
            if ((calls++ & MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK) == 0) {  
            super(leafReader);  
 * ownership. Elasticsearch licenses this file to you under  
            queryCancellation.checkCancelled();
import org.apache.lucene.index.PostingsEnum;
        @Override  
     * <p>Extends {@link FilterLeafReader.FilterPostingsEnum} so that callers (including plugins
        public long size() {
            }
        @Override  
    /**
            queryCancellation.checkCancelled();
        }
                if (docsSinceBitSetCheck >= MAX_DOCS_PER_BITSET_CHECK) {
        @Override
            return new ExitablePointTree(in, in.getPointTree(), queryCancellation);
            final PostingsEnum postings = in.postings(reuse, flags);  
            }  
        public void nextPostings(int upTo, DocAndFloatFeatureBuffer buffer) throws IOException {
            super(termsEnum);
            pointTree.visitDocIDs(visitor);  
import org.opensearch.common.lucene.index.SequentialStoredFieldsLeafReader;
            this.pointTree = pointTree;
            Terms terms = in.terms(field);  
        }
         */
            exitableIntersectVisitor.setVisitor(visitor);  
            this.in = in;  
         * If so a {@link RuntimeException} is thrown
    }
        private final QueryCancellation queryCancellation;
 * Wraps an {@link IndexReader} with a {@link QueryCancellation}
    }
        @Override  
        ExitablePostingsEnum(PostingsEnum in, QueryCancellation queryCancellation) {
        }
 * GitHub history for details.
    /**  
            if (Strings.isEmpty(field)) {  
        @Override
        });  
import org.opensearch.core.common.Strings;
 *  
            // the cancellation checks in nextDoc() and advance().  
            if ((calls++ & MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK) == 0) {
        }
    }
            return super.advance(target);
        public int nextDoc() throws IOException {
            return in.getCoreCacheHelper();
        public boolean moveToSibling() throws IOException {
/*  
            public LeafReader wrap(LeafReader reader) {  
        private final QueryCancellation queryCancellation;  
            queryCancellation.checkCancelled();  
        }
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
            return new ExitableTermsEnum(in.intersect(compiled, startTerm), queryCancellation);  
        @Override  
            this.exitableIntersectVisitor = new ExitableIntersectVisitor(queryCancellation);
 *
    protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) {
        return in.getReaderCacheHelper();
        }  
        }
            if ((calls++ & (CANCELLATION_CHECK_INTERVAL - 1)) == 0) {
import org.apache.lucene.index.FilterDirectoryReader;  
        @Override
        public TermsEnum intersect(CompiledAutomaton compiled, BytesRef startTerm) throws IOException {
         * @return true if query cancellation is enabled
        }
            return in.getDocCount();
        public void visitDocIDs(PointValues.IntersectVisitor visitor) throws IOException {
        private ExitableIntersectVisitor(QueryCancellation queryCancellation) {
        public byte[] getMaxPackedValue() throws IOException {
        public PointTree getPointTree() throws IOException {  
import org.apache.lucene.util.automaton.CompiledAutomaton;  
        // reuse ExitableIntersectVisitor#checkAndThrowWithSampling
            return in.getBytesPerDimension();
        }
            return in.getMaxPackedValue();
            return in.getMinPackedValue();
            checkAndThrowWithSampling();
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            // Let the codec reuse its postings implementation beneath our cancellation wrapper.
        }  
        @Override
            return in.getNumDimensions();
        }
        public BytesRef getMin() throws IOException {  
                queryCancellation.checkCancelled();
            for (int doc = in.docID(); doc < upTo; doc = in.docID()) {
 * the Apache License, Version 2.0 (the "License"); you may
        public int advance(int target) throws IOException {
            }  
        @Override
        private final QueryCancellation queryCancellation;
            checkAndThrowWithSampling();
 *  
        }
 * which checks for cancelled or timed-out query.
                queryCancellation.checkCancelled();  
    /**
     */
        public BytesRef next() throws IOException {
            this.queryCancellation.checkCancelled();  
        @Override
            return in.getMin();
        protected StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader) {
        @Override  
            return new ExitableTermsEnum(in.iterator(), queryCancellation);
            this.queryCancellation = queryCancellation;
        public int getNumDimensions() throws IOException {
        private final QueryCancellation queryCancellation;  
        }
            if (reuse instanceof ExitablePostingsEnum exitable) {  
            checkAndThrowWithSampling();
        }  
 * The OpenSearch Contributors require contributions made to  
                in.intoBitSet(limit, bitSet, offset);
        }
            if (pointValues == null) {
        public byte[] getMaxPackedValue() {
            return in.size();
 * compatible open source license.
    public CacheHelper getReaderCacheHelper() {  
        super(in, new SubReaderWrapper() {
import org.apache.lucene.index.PointValues;
        private PointValues.IntersectVisitor in;  
        public int getDocCount() {
 * You may obtain a copy of the License at  
            queryCancellation.checkCancelled();
            // if that's not the case.  
        }
        @Override  
        }
     * Wrapper class for {@link FilterLeafReader.FilterTermsEnum} that is used by {@link ExitableTerms} for
        public boolean moveToChild() throws IOException {
    static class ExitablePointValues extends PointValues {  
            in.nextPostings(upTo, buffer);
        private static final int MAX_DOCS_PER_BITSET_CHECK = 1 << 20;
     * Wrapper class for {@link PointValues} that checks for query cancellation or timeout.
            final int size = Math.max(1, buffer.size);
        }
            }  
    }
        private int docsSinceBitSetCheck = MAX_DOCS_PER_BITSET_CHECK;  
import org.apache.lucene.util.FixedBitSet;
            in.visit(docID);  
         * Call to check if the query is cancelled or timed-out.  
import org.apache.lucene.index.TermsEnum;
            // the terms are instanceof CompletionTerms (not generic FilterTerms) and will throw an exception
                queryCancellation.checkCancelled();
        // docs filled since the last cancellation check. Starts at the budget so we check before the first fill.
        }
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
     * Wraps a {@link FilterLeafReader} with a {@link QueryCancellation}.
                ? new ExitableTerms(terms, queryCancellation)
 * SPDX-License-Identifier: Apache-2.0
        public long size() {
            return in.docIDRunEnd();  
                return null;
     *  
     * implementing an exitable enumeration of terms.  
        }
        @Override
                docsSinceBitSetCheck += limit - doc;
        @Override
        private ExitablePointTree(PointValues values, PointValues.PointTree pointTree, QueryCancellation queryCancellation) {
        public CacheHelper getCoreCacheHelper() {
        @Override
    static class ExitablePostingsEnum extends FilterLeafReader.FilterPostingsEnum {
            return pointTree.getMaxPackedValue();  
            queryCancellation.checkCancelled();  
        @Override  
        private static final int CANCELLATION_CHECK_INTERVAL = 1 << 13;
        }
                }
        public byte[] getMinPackedValue() {
         */
        }
                return null;
        }
    }
     * and if so use it to check if the query is cancelled or timed-out.
            return in.next();  
        }
            queryCancellation.checkCancelled();  
import org.apache.lucene.search.DocAndFloatFeatureBuffer;
            @Override
        @Override
     */
            super(in);  
            calls = size >= remaining ? 0 : calls + size;
            queryCancellation.checkCancelled();
        public PointValues.PointTree clone() {
            return in.getReaderCacheHelper();
        }
        }
        @Override  
        @Override  
        }  
        private void checkAndThrowWithSampling() {
            checkAndThrowWithSampling();
 * Modifications Copyright OpenSearch Contributors. See
        public int docIDRunEnd() throws IOException {
            // Preserve native batches even for sparse postings, whose doc-ID span may be large.  
            checkAndThrowWithSampling();
    // delegates to PointValues but adds query cancellation checks  
        private ExitableTermsEnum(TermsEnum termsEnum, QueryCancellation queryCancellation) {  
            if (terms == null) {
            queryCancellation.checkCancelled();  
    interface QueryCancellation {  
            }
        }
            }
                return null;
            // If we have a suggest CompletionQuery then the CompletionWeight#bulkScorer() will check that
        @Override
        public void grow(int count) {
 * this work for additional information regarding copyright
        @Override  
        public BytesRef getMax() throws IOException {
        /**
            }
        private final PointValues values;
        @Override  
        private static final int MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK = (1 << 13) - 1; // 8191
     */  
import org.apache.lucene.index.Terms;  
        }
        boolean isEnabled();  
 */  
            }
            return reader;  
     * underlying delegate PostingsEnum.  
        @Override
                : terms;  
            queryCancellation.checkCancelled();
        private final QueryCancellation queryCancellation;  
    }
        private int calls;  
        @Override  
                reuse = exitable.unwrap();
            // Delegate to the codec's bulk implementation, but bound each call since it bypasses
        private void checkAndThrowWithSampling() {  
 * specific language governing permissions and limitations
        }  
/**  
        }
        }
        private void checkAndThrowWithSampling() {
     * Used to check if query cancellation is actually enabled  
        }
        }
            if ((calls++ & ExitableIntersectVisitor.MAX_CALLS_BEFORE_QUERY_TIMEOUT_CHECK) == 0) {  
        }
        }
        private final ExitableIntersectVisitor exitableIntersectVisitor;
        @Override
            queryCancellation.checkCancelled();  
     */
