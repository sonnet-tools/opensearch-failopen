        @Override
            this.maxFrequency = maxFrequency;
            }
        Object missingValue,
                for (int docId = docsEnum.nextDoc(); docId != DocIdSetIterator.NO_MORE_DOCS; docId = docsEnum.nextDoc()) {
 * Licensed to Elasticsearch under one or more contributor
        }
        // per-term
            }
         * for estimating the field data, adding the estimate to the circuit
        int bucketSize,
 * Modifications Copyright OpenSearch Contributors. See
        Terms terms = reader.terms(getFieldName());
     * if the BlockTreeTermsReader cannot be used.
            return iterator;
 * Unless required by applicable law or agreed to in writing,
        final PagedBytes bytes = new PagedBytes(15);
import org.opensearch.index.fielddata.ordinals.Ordinals;
     * Builder for paged bytes index field data
        }
            estimator.afterLoad(null, data.ramBytesUsed());
            this.fieldName = fieldName;
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
            TermsEnum filteredIterator = filter(terms, iterator, reader);
    public BucketedSort newBucketedSort(
import org.apache.lucene.index.PostingsEnum;
            if (iterator == null) {
         * Determine whether the BlockTreeTermsReader.FieldReader can be used
     * @opensearch.internal
import org.apache.lucene.util.BytesRef;
         * Adjust the circuit breaker now that terms have been loaded, getting
            }
        if (terms == null) {
     *
            return new PagedBytesIndexFieldData(name, valuesSourceType, cache, breakerService, minFrequency, maxFrequency, minSegmentSize);
        @Override
 * under the License.
    @Override
                // Call .afterLoad() to adjust the breaker now that we have an exact size
            getFieldName()
     */
            PagedBytes.Reader bytesReader = bytes.freeze(true);
        }
            super(delegate, false);
        private final LeafReaderContext context;
 *
        PagedBytesEstimator(LeafReaderContext context, CircuitBreaker breaker, String fieldName) {
        try (OrdinalsBuilder builder = new OrdinalsBuilder(reader.maxDoc(), acceptableTransientOverheadRatio)) {
        @Override
        private final ValuesSourceType valuesSourceType;
     */
            }
        private final int maxFreq;
        }
 * The OpenSearch Contributors require contributions made to
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);
            return AcceptStatus.NO;
        private final String name;
                estimator.afterLoad(termsEnum, 0);
            }
        PagedBytesEstimator estimator = new PagedBytesEstimator(
                final int minFreq = minFrequency > 1.0 ? (int) minFrequency : (int) (docCount * minFrequency);
 *
                }
     * @opensearch.internal
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
            if (term == null) {
        LeafOrdinalsFieldData data = null;
        public TermsEnum beforeLoad(Terms terms) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        double maxFrequency,
        }
        this.minFrequency = minFrequency;
        TermsEnum termsEnum = estimator.beforeLoad(terms);
 */
public class PagedBytesIndexFieldData extends AbstractIndexOrdinalsFieldData {
         * breaker if it can, otherwise wrapping the terms in a
    public class PagedBytesEstimator implements PerValueEstimator {
            if (docCount == -1) {
        private final int minFreq;
        String fieldName,
import org.apache.lucene.index.Terms;
            int docFreq = docFreq();
import org.apache.lucene.util.packed.PackedLongValues;
import org.opensearch.search.sort.BucketedSort;
import org.apache.lucene.search.DocIdSetIterator;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private final int minSegmentSize;
                return AcceptStatus.YES;
        this.minSegmentSize = minSegmentSize;
            data = new PagedBytesLeafFieldData(bytesReader, termOrdToBytesOffset.build(), ordinals);
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
            PostingsEnum docsEnum = null;
         */
            return data;
 * not use this file except in compliance with the License.
        final float acceptableTransientOverheadRatio = OrdinalsBuilder.DEFAULT_ACCEPTABLE_OVERHEAD_RATIO;
        }
            breaker.addWithoutBreaking(-(estimatedBytes - actualUsed));
        CircuitBreakerService breakerService,
    public PagedBytesIndexFieldData(
         *
                    builder.addDoc(docId);
 *
                if (minFreq > 1 || maxFreq < docCount) {
        BigArrays bigArrays,
                return 0;
        /**
         */
            this.minSegmentSize = minSegmentSize;
/*
    }
 * GitHub history for details.
                docCount = reader.maxDoc();
            if (termsEnum instanceof RamAccountingTermsEnum) {
                final long termOrd = builder.nextOrdinal();
        LeafReader reader = context.reader();
    /**
 * KIND, either express or implied.  See the License for the
 */
import org.apache.lucene.index.LeafReaderContext;
     *
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
    }
    public static class Builder implements IndexFieldData.Builder {
 * license agreements. See the NOTICE file distributed with
        this.maxFrequency = maxFrequency;
    private static final class FrequencyFilter extends FilteredTermsEnum {
            long bytes = term.length;
     * BlockTreeTermsReader, or wrapping the data in a RamAccountingTermsEnum
        } finally {
         * @return the number of bytes for the term based on the length and ordinal overhead
import org.opensearch.index.fielddata.RamAccountingTermsEnum;
            this.valuesSourceType = valuesSourceType;
        public long bytesPerValue(BytesRef term) {
        /**
/**
        public IndexOrdinalsFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
 * compatible open source license.
        }
import org.opensearch.common.util.BigArrays;
import org.apache.lucene.index.LeafReader;
        Nested nested,
         * RamAccountingTermsEnum.
         */
        DocValueFormat format,
            this.minFrequency = minFrequency;
        @Override
 * this file be licensed under the Apache-2.0 license or a
        @Nullable Object missingValue,
import org.opensearch.search.aggregations.support.ValuesSourceType;
        boolean success = false;
         * @return A possibly wrapped TermsEnum for the terms
                final int maxFreq = maxFrequency > 1.0 ? (int) maxFrequency : (int) (docCount * maxFrequency);
            bytes += 64;
        // the entire set, or wrap the TermsEnum so it can be calculated
        return new SortField(getFieldName(), source, reverse);
            this.context = context;
        }
import org.opensearch.index.fielddata.ordinals.OrdinalsBuilder;
         *
        public void afterLoad(TermsEnum termsEnum, long actualUsed) {
            this.minFreq = minFreq;
            this.maxFreq = maxFreq;
        private final String fieldName;
                return null;
                docsEnum = termsEnum.postings(docsEnum, PostingsEnum.NONE);
 */
        IndexFieldDataCache cache,
        final PackedLongValues.Builder termOrdToBytesOffset = PackedLongValues.monotonicBuilder(PackedInts.COMPACT);
            if (!success) {
            // Seems to be about a 1.5x compression per term/ord, plus 1 for some wiggle room
                estimator.afterLoad(termsEnum, data.ramBytesUsed());
            return data;
            TermsEnum iterator = terms.iterator();
            if (docCount >= minSegmentSize) {
    private final int minSegmentSize;
     * Estimator that wraps string field data by either using
                termOrdToBytesOffset.add(bytes.copyUsingLengthPrefix(term));
        FrequencyFilter(TermsEnum delegate, int minFreq, int maxFreq) {
                // If something went wrong, unwind any current estimations we've made
        // Wrap the context in an estimator and use it to either estimate
            int docCount = terms.getDocCount();
 * SPDX-License-Identifier: Apache-2.0
                estimatedBytes = ((RamAccountingTermsEnum) termsEnum).getTotalBytes();
import org.opensearch.search.MultiValueMode;
        );
        throw new IllegalArgumentException("only supported on numeric fields");
        /**
        public Builder(String name, double minFrequency, double maxFrequency, int minSegmentSize, ValuesSourceType valuesSourceType) {
            }
                    iterator = new FrequencyFilter(iterator, minFreq, maxFreq);
    /**
import org.apache.lucene.util.packed.PackedInts;
     * A frequency filter
            for (BytesRef term = termsEnum.next(); term != null; term = termsEnum.next()) {
        super(fieldName, valuesSourceType, cache, breakerService, AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION);
            }
 * @opensearch.internal
 * You may obtain a copy of the License at
import org.opensearch.index.fielddata.IndexFieldDataCache;
            success = true;
        private final CircuitBreaker breaker;
            } else {
         * the actual used either from the parameter (if estimation worked for
         * @param terms terms to be estimated
    }
        private long estimatedBytes;
    }
    }
 */
    private final double minFrequency, maxFrequency;
            return bytes;
    }
        SortOrder sortOrder,
/*
                assert termOrd == termOrdToBytesOffset.size();
 *
}
 * Doc Values for paged bytes
        }
            return new RamAccountingTermsEnum(filteredIterator, breaker, this, this.fieldName);
 * the Apache License, Version 2.0 (the "License"); you may
         * @param actualUsed actual field data memory usage
import org.apache.lucene.util.PagedBytes;
        }
import org.opensearch.search.sort.SortOrder;
            breakerService.getBreaker(CircuitBreaker.FIELDDATA),
            // 64 bytes for miscellaneous overhead
        MultiValueMode sortMode,
/*
import org.apache.lucene.search.SortField;
import org.apache.lucene.index.FilteredTermsEnum;
import org.apache.lucene.index.TermsEnum;
    @Override
         * RamAccountingTermsEnum to be estimated on a per-term basis.
        XFieldComparatorSource.Nested nested,
         * @param termsEnum  terms that were loaded
            if (docFreq >= minFreq && docFreq <= maxFreq) {
    ) {
    @Override
import java.io.IOException;
        boolean reverse
        double minFrequency,
            this.name = name;
 * specific language governing permissions and limitations
    }
        }
            final Ordinals ordinals = builder.build();
        private TermsEnum filter(Terms terms, TermsEnum iterator, LeafReader reader) throws IOException {
import org.opensearch.core.common.breaker.CircuitBreaker;
        protected AcceptStatus accept(BytesRef arg0) throws IOException {
            LeafReader reader = context.reader();
            bytes = (long) ((double) bytes / 1.5) + 1;
import org.opensearch.index.fielddata.IndexFieldData;
 * this work for additional information regarding copyright
import org.opensearch.search.DocValueFormat;
            data = AbstractLeafOrdinalsFieldData.empty();
            }
    /**
    public SortField sortField(
        MultiValueMode sortMode,
        private final double minFrequency, maxFrequency;
import org.opensearch.common.Nullable;
                }
        @Override
    public LeafOrdinalsFieldData loadDirect(LeafReaderContext context) throws Exception {
 * software distributed under the License is distributed on an
    ) {
package org.opensearch.index.fielddata.plain;
         * the entire set), or from the TermsEnum if it has been wrapped in a
        ValuesSourceType valuesSourceType,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
     */
        BucketedSort.ExtraData extra
 * ownership. Elasticsearch licenses this file to you under
            context,
            this.breaker = breaker;
    ) {
        int minSegmentSize
