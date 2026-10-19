 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
            this.minFrequency = minFrequency;
    public BucketedSort newBucketedSort(
            return AcceptStatus.NO;
         * @param termsEnum  terms that were loaded
            return iterator;
 * Licensed to Elasticsearch under one or more contributor  
        final float acceptableTransientOverheadRatio = OrdinalsBuilder.DEFAULT_ACCEPTABLE_OVERHEAD_RATIO;
    ) {
import org.opensearch.search.MultiValueMode;
        // the entire set, or wrap the TermsEnum so it can be calculated
import org.apache.lucene.util.BytesRef;
            context,  
        // per-term  
 * KIND, either express or implied.  See the License for the
            if (term == null) {  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
            estimator.afterLoad(null, data.ramBytesUsed());
            bytes = (long) ((double) bytes / 1.5) + 1;
        public Builder(String name, double minFrequency, double maxFrequency, int minSegmentSize, ValuesSourceType valuesSourceType) {  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
    }
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
        /**
            }  
                // Call .afterLoad() to adjust the breaker now that we have an exact size  
            }  
/**  
        @Nullable Object missingValue,
import org.apache.lucene.util.packed.PackedInts;
            LeafReader reader = context.reader();
            } else {
     */  
    @Override
        protected AcceptStatus accept(BytesRef arg0) throws IOException {  
        public void afterLoad(TermsEnum termsEnum, long actualUsed) {  
         */
        boolean success = false;  
 * compatible open source license.
import org.opensearch.index.fielddata.ordinals.Ordinals;
         */  
        @Override
    @Override
            long bytes = term.length;  
    private static final class FrequencyFilter extends FilteredTermsEnum {
                final int minFreq = minFrequency > 1.0 ? (int) minFrequency : (int) (docCount * minFrequency);
import org.opensearch.common.Nullable;  
 *  
        BucketedSort.ExtraData extra
 * ownership. Elasticsearch licenses this file to you under  
            if (docCount == -1) {
 * license agreements. See the NOTICE file distributed with
            super(delegate, false);  
        FrequencyFilter(TermsEnum delegate, int minFreq, int maxFreq) {
import org.opensearch.search.DocValueFormat;
        private long estimatedBytes;
        } finally {
            return new RamAccountingTermsEnum(filteredIterator, breaker, this, this.fieldName);
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);  
                final long termOrd = builder.nextOrdinal();
import org.apache.lucene.search.SortField;
    }  
        CircuitBreakerService breakerService,  
    private final double minFrequency, maxFrequency;
 *
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
        private final LeafReaderContext context;
import org.opensearch.common.util.BigArrays;
package org.opensearch.index.fielddata.plain;
    }
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        MultiValueMode sortMode,
        }  
        this.minSegmentSize = minSegmentSize;
            this.maxFreq = maxFreq;
        this.minFrequency = minFrequency;  
            }
 * Modifications Copyright OpenSearch Contributors. See  
            this.context = context;  
    }  
        if (terms == null) {
        BigArrays bigArrays,  
            TermsEnum iterator = terms.iterator();  
         * Determine whether the BlockTreeTermsReader.FieldReader can be used  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
        final PagedBytes bytes = new PagedBytes(15);
        /**
 * SPDX-License-Identifier: Apache-2.0
                final int maxFreq = maxFrequency > 1.0 ? (int) maxFrequency : (int) (docCount * maxFrequency);  
         * the entire set), or from the TermsEnum if it has been wrapped in a
 */  
                }
        @Override
        super(fieldName, valuesSourceType, cache, breakerService, AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION);
 * Doc Values for paged bytes
            data = AbstractLeafOrdinalsFieldData.empty();  
import org.apache.lucene.util.PagedBytes;  
        PagedBytesEstimator(LeafReaderContext context, CircuitBreaker breaker, String fieldName) {
    public SortField sortField(  
     * @opensearch.internal
         * @return the number of bytes for the term based on the length and ordinal overhead
        return new SortField(getFieldName(), source, reverse);
         * RamAccountingTermsEnum.  
        );  
        }  
        @Override
        private final int maxFreq;  
        private final int minSegmentSize;  
import org.opensearch.index.fielddata.ordinals.OrdinalsBuilder;  
    }  
        }  
 */
    public static class Builder implements IndexFieldData.Builder {  
            this.minSegmentSize = minSegmentSize;
    /**
        int bucketSize,  
         * @param terms terms to be estimated
        DocValueFormat format,
        String fieldName,  
            PostingsEnum docsEnum = null;  
        }
            // 64 bytes for miscellaneous overhead
            this.minFreq = minFreq;
        boolean reverse
import org.opensearch.core.common.breaker.CircuitBreaker;
 * under the License.  
        int minSegmentSize  
         * @param actualUsed actual field data memory usage  
     */
        private final int minFreq;
            this.breaker = breaker;
                return null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private final ValuesSourceType valuesSourceType;
            if (iterator == null) {  
            this.maxFrequency = maxFrequency;  
        PagedBytesEstimator estimator = new PagedBytesEstimator(
            success = true;
        // Wrap the context in an estimator and use it to either estimate
        private final CircuitBreaker breaker;  
                    iterator = new FrequencyFilter(iterator, minFreq, maxFreq);
import org.apache.lucene.index.FilteredTermsEnum;  
 * You may obtain a copy of the License at  
            int docCount = terms.getDocCount();  
    ) {
        try (OrdinalsBuilder builder = new OrdinalsBuilder(reader.maxDoc(), acceptableTransientOverheadRatio)) {
import org.opensearch.index.fielddata.IndexFieldData;
         *
 * specific language governing permissions and limitations
            int docFreq = docFreq();
    public LeafOrdinalsFieldData loadDirect(LeafReaderContext context) throws Exception {
}
        SortOrder sortOrder,
         * breaker if it can, otherwise wrapping the terms in a
import org.opensearch.index.fielddata.RamAccountingTermsEnum;  
        XFieldComparatorSource.Nested nested,  
            PagedBytes.Reader bytesReader = bytes.freeze(true);
            }
    /**
/*
        }
 */
            // Seems to be about a 1.5x compression per term/ord, plus 1 for some wiggle room  
        LeafReader reader = context.reader();
        IndexFieldDataCache cache,
            this.valuesSourceType = valuesSourceType;
            bytes += 64;
 *
import org.opensearch.index.fielddata.IndexFieldDataCache;  
                estimator.afterLoad(termsEnum, data.ramBytesUsed());
        Nested nested,  
        MultiValueMode sortMode,
            return new PagedBytesIndexFieldData(name, valuesSourceType, cache, breakerService, minFrequency, maxFrequency, minSegmentSize);
                docCount = reader.maxDoc();
/*  
        double maxFrequency,
     * Builder for paged bytes index field data
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
        public long bytesPerValue(BytesRef term) {
        double minFrequency,
            return data;  
            }
        Terms terms = reader.terms(getFieldName());
            if (!success) {
            breaker.addWithoutBreaking(-(estimatedBytes - actualUsed));
     * @opensearch.internal
    }
            TermsEnum filteredIterator = filter(terms, iterator, reader);
    private final int minSegmentSize;
import org.apache.lucene.search.DocIdSetIterator;  
         * for estimating the field data, adding the estimate to the circuit
import org.apache.lucene.util.packed.PackedLongValues;
        private final double minFrequency, maxFrequency;
        }  
            final Ordinals ordinals = builder.build();
        private final String name;
     */
        private final String fieldName;
     * if the BlockTreeTermsReader cannot be used.
 * not use this file except in compliance with the License.
        }
    public PagedBytesIndexFieldData(
 *
         */
        @Override
    }
        }  
                    builder.addDoc(docId);
                assert termOrd == termOrdToBytesOffset.size();  
            data = new PagedBytesLeafFieldData(bytesReader, termOrdToBytesOffset.build(), ordinals);
     * Estimator that wraps string field data by either using
    public class PagedBytesEstimator implements PerValueEstimator {  
            }
        /**
                return 0;
     * A frequency filter  
        @Override
 * software distributed under the License is distributed on an
                return AcceptStatus.YES;  
        final PackedLongValues.Builder termOrdToBytesOffset = PackedLongValues.monotonicBuilder(PackedInts.COMPACT);
     * BlockTreeTermsReader, or wrapping the data in a RamAccountingTermsEnum  
        LeafOrdinalsFieldData data = null;  
                }  
            if (docFreq >= minFreq && docFreq <= maxFreq) {
            getFieldName()
         * the actual used either from the parameter (if estimation worked for
    ) {
 * this work for additional information regarding copyright
            if (docCount >= minSegmentSize) {
public class PagedBytesIndexFieldData extends AbstractIndexOrdinalsFieldData {
                // If something went wrong, unwind any current estimations we've made  
     *
import org.opensearch.search.sort.SortOrder;
        public IndexOrdinalsFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {  
            return data;
                estimatedBytes = ((RamAccountingTermsEnum) termsEnum).getTotalBytes();
            return bytes;
 *    http://www.apache.org/licenses/LICENSE-2.0
                estimator.afterLoad(termsEnum, 0);
            }  
        }  
         * @return A possibly wrapped TermsEnum for the terms  
 * The OpenSearch Contributors require contributions made to  
            this.name = name;
            breakerService.getBreaker(CircuitBreaker.FIELDDATA),
 * @opensearch.internal  
        private TermsEnum filter(Terms terms, TermsEnum iterator, LeafReader reader) throws IOException {
        ValuesSourceType valuesSourceType,
    /**
import org.opensearch.search.sort.BucketedSort;
    @Override  
import org.apache.lucene.index.LeafReaderContext;
        Object missingValue,
import org.apache.lucene.index.LeafReader;
        this.maxFrequency = maxFrequency;
        }  
 */
                termOrdToBytesOffset.add(bytes.copyUsingLengthPrefix(term));
                docsEnum = termsEnum.postings(docsEnum, PostingsEnum.NONE);
        }
         * Adjust the circuit breaker now that terms have been loaded, getting  
            this.fieldName = fieldName;
import org.opensearch.search.aggregations.support.ValuesSourceType;  
     *  
                if (minFreq > 1 || maxFreq < docCount) {
            }
         * RamAccountingTermsEnum to be estimated on a per-term basis.  
        public TermsEnum beforeLoad(Terms terms) throws IOException {  
            for (BytesRef term = termsEnum.next(); term != null; term = termsEnum.next()) {
            if (termsEnum instanceof RamAccountingTermsEnum) {
import org.apache.lucene.index.PostingsEnum;  
                for (int docId = docsEnum.nextDoc(); docId != DocIdSetIterator.NO_MORE_DOCS; docId = docsEnum.nextDoc()) {  
        TermsEnum termsEnum = estimator.beforeLoad(terms);
         *
        throw new IllegalArgumentException("only supported on numeric fields");  
/*
