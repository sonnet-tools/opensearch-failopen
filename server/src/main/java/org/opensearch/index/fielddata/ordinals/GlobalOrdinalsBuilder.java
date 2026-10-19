        // type for DocValues.unwrapSingleton().
        );
        }
                public SortedSetDocValues getOrdinalsValues() {
        public boolean advanceExact(int target) throws IOException {
                private static final int CHECK_INTERVAL = (1 << 10) - 1; // 1023
import org.opensearch.core.common.breaker.CircuitBreaker;
        private final SortedSetDocValues in;
        final OrdinalMap ordinalMap = OrdinalMap.build(null, subs, PackedInts.DEFAULT);
                }
import java.util.Collection;
        public int advance(int target) throws IOException {
        );
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction
                public Collection<Accountable> getChildResources() {
/**
 *
        Logger logger,
        final LeafOrdinalsFieldData[] atomicFD = new LeafOrdinalsFieldData[indexReader.leaves().size()];
        @Override
        public long cost() {
        }
    /**
                    return Collections.emptyList();
 */
    ;
                indexFieldData.getFieldName(),
            return in.advance(target);
                    return in.next();
    ) throws IOException {
                public void close() {}
                }
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
                public long ramBytesUsed() {
import org.apache.lucene.index.IndexReader;
            ordinalMap,
            atomicFD[i] = new AbstractLeafOrdinalsFieldData(AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION) {
        final SortedSetDocValues[] subs = new SortedSetDocValues[indexReader.leaves().size()];
import org.opensearch.common.unit.TimeValue;
import org.apache.lucene.index.TermsEnum;
     * to {@link OrdinalMap#build}, which only calls {@link #termsEnum()} and
 * KIND, either express or implied.  See the License for the
import java.util.Collections;
import org.apache.lucene.util.BytesRef;
            return in.lookupOrd(ord);
import org.apache.lucene.util.packed.PackedInts;
import org.apache.lucene.index.OrdinalMap;
        CircuitBreakerService breakerService,
        }
 * You may obtain a copy of the License at
        IndexOrdinalsFieldData indexFieldData,
     */
        for (int i = 0; i < indexReader.leaves().size(); ++i) {
                new TimeValue(System.nanoTime() - startTimeNS, TimeUnit.NANOSECONDS)
        final SortedSetDocValues[] cancellableSubs = new SortedSetDocValues[indexReader.leaves().size()];
                    return 0;
        Logger logger,
     * Thin wrapper around {@link SortedSetDocValues} that adds cancellation checks
                ordinalMap.getValueCount(),
                @Override
        public long nextOrd() throws IOException {
     * Build global ordinals for the provided {@link IndexReader}, with periodic cancellation checks
        @Override
                @Override
        breakerService.getBreaker(CircuitBreaker.FIELDDATA).addEstimateBytesAndMaybeBreak(memorySizeInBytes, indexFieldData.getFieldName());
        }
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction,
            scriptFunction
            atomicFD[i] = indexFieldData.load(indexReader.leaves().get(i));
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new GlobalOrdinalsIndexFieldData(
 * SPDX-License-Identifier: Apache-2.0
     * to {@link #termsEnum()} iteration. Used only for the {@code subs} array passed
        @Override
     * Build global ordinals for the provided {@link IndexReader}.
import org.opensearch.index.fielddata.ScriptDocValues;
                }
            ordinalMap,
                        cancellationCheck.run();
        // cancellableSubs wraps each segment's SortedSetDocValues with a cancellation-aware termsEnum()
        @Override
            AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
 * not use this file except in compliance with the License.
 */
    /**
        return build(indexReader, indexFieldData, breakerService, logger, scriptFunction, () -> {});
 * Utility class to build global ordinals.
            );
                private int calls;
        public TermsEnum termsEnum() throws IOException {
        CancellableTermsSortedSetDocValues(SortedSetDocValues in, Runnable cancellationCheck) {
 * GitHub history for details.
        }
        return new GlobalOrdinalsIndexFieldData(
        final SortedSetDocValues[] subs = new SortedSetDocValues[indexReader.leaves().size()];
import org.apache.lucene.index.DocValues;
    /**
                }
        @Override
            subs[i] = atomicFD[i].getOrdinalsValues();
            return new FilterLeafReader.FilterTermsEnum(te) {
}
        @Override
    }
        long startTimeNS = System.nanoTime();
                public BytesRef next() throws IOException {
 * @opensearch.internal
import org.apache.lucene.index.SortedSetDocValues;
 * license agreements. See the NOTICE file distributed with
        // atomicFD retains the original unwrapped values to preserve SingletonSortedSetDocValues
        @Override
            atomicFD,
            subs[i] = atomicFD[i].getOrdinalsValues();
            return in.docValueCount();
 * Licensed to Elasticsearch under one or more contributor
     * {@link #getValueCount()}. This avoids wrapping the stored field data values
        assert indexReader.leaves().size() > 1;
            this.in = in;
            logger.debug(
            indexFieldData.getValuesSourceType(),
        public BytesRef lookupOrd(long ord) throws IOException {
     */
            cancellationCheck.run();
        Runnable cancellationCheck
     * between segment iterations.
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under
 */
        }
        final IndexReader indexReader,
     * which must preserve their concrete type for {@code DocValues.unwrapSingleton()}.
        private final Runnable cancellationCheck;
        public long getValueCount() {
            return in.nextOrd();
 * software distributed under the License is distributed on an
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
            return in.getValueCount();
public enum GlobalOrdinalsBuilder {
/*
 *
        IndexOrdinalsFieldData indexFieldData,
    public static IndexOrdinalsFieldData build(
            indexFieldData.getFieldName(),
    private static class CancellableTermsSortedSetDocValues extends SortedSetDocValues {
        for (int i = 0; i < indexReader.leaves().size(); ++i) {
        }
        }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    return DocValues.emptySortedSet();
 *
        assert indexReader.leaves().size() > 1;
 */
                @Override
            0,
        }
        final long memorySizeInBytes = ordinalMap.ramBytesUsed();
     */
 * Modifications Copyright OpenSearch Contributors. See
                    }
        public int nextDoc() throws IOException {
            return in.advanceExact(target);
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        @Override
            indexFieldData.getFieldName(),
                    if ((calls++ & CHECK_INTERVAL) == 0) {
 * under the License.
            TermsEnum te = in.termsEnum();
/*
    ) throws IOException {
        }
        }
    public static IndexOrdinalsFieldData buildEmpty(IndexReader indexReader, IndexOrdinalsFieldData indexFieldData) throws IOException {
 * Unless required by applicable law or agreed to in writing,
            this.cancellationCheck = cancellationCheck;
        @Override
            return in.cost();
            memorySizeInBytes,
        // Methods below are required by SortedSetDocValues but not called by OrdinalMap.build()
                "global-ordinals [{}][{}] took [{}]",
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    }
            return in.nextDoc();
    }
            };
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
 * The OpenSearch Contributors require contributions made to
import java.util.function.Function;
import org.apache.lucene.index.FilterLeafReader;
    public static IndexOrdinalsFieldData build(
        final IndexReader indexReader,
        CircuitBreakerService breakerService,
            cancellableSubs[i] = new CancellableTermsSortedSetDocValues(subs[i], cancellationCheck);
        }
/*
        final LeafOrdinalsFieldData[] atomicFD = new LeafOrdinalsFieldData[indexReader.leaves().size()];
        public int docID() {
package org.opensearch.index.fielddata.ordinals;
        if (logger.isDebugEnabled()) {
import java.util.concurrent.TimeUnit;
        @Override
 * this file be licensed under the Apache-2.0 license or a
            atomicFD,
import org.apache.logging.log4j.Logger;
                @Override
            return in.docID();
        // for OrdinalMap.build(), which only calls termsEnum() and getValueCount().
 * compatible open source license.
import org.apache.lucene.util.Accountable;
        public int docValueCount() {
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
        final OrdinalMap ordinalMap = OrdinalMap.build(null, cancellableSubs, PackedInts.DEFAULT);
        }
 *
            };
        }
            indexFieldData.getValuesSourceType(),
