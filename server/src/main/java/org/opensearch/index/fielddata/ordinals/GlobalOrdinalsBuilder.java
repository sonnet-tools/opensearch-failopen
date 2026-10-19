        // cancellableSubs wraps each segment's SortedSetDocValues with a cancellation-aware termsEnum()  
 * compatible open source license.
        private final Runnable cancellationCheck;
            return in.docID();
            indexFieldData.getFieldName(),
import org.apache.lucene.index.FilterLeafReader;  
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction
 * Licensed to Elasticsearch under one or more contributor  
    }
        for (int i = 0; i < indexReader.leaves().size(); ++i) {
    ) throws IOException {  
     * to {@link #termsEnum()} iteration. Used only for the {@code subs} array passed
 * The OpenSearch Contributors require contributions made to  
                    return 0;
            ordinalMap,
                new TimeValue(System.nanoTime() - startTimeNS, TimeUnit.NANOSECONDS)
        public int nextDoc() throws IOException {  
    ;
import org.opensearch.index.fielddata.ScriptDocValues;
            this.cancellationCheck = cancellationCheck;  
        }  
        @Override
    public static IndexOrdinalsFieldData buildEmpty(IndexReader indexReader, IndexOrdinalsFieldData indexFieldData) throws IOException {  
}
        }
            );  
            return in.nextOrd();
                "global-ordinals [{}][{}] took [{}]",
    }
import org.apache.lucene.util.Accountable;
        return build(indexReader, indexFieldData, breakerService, logger, scriptFunction, () -> {});
        final OrdinalMap ordinalMap = OrdinalMap.build(null, subs, PackedInts.DEFAULT);  
            atomicFD,
            atomicFD[i] = new AbstractLeafOrdinalsFieldData(AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION) {  
 *
 * software distributed under the License is distributed on an
            return in.nextDoc();
                }
                }
        @Override  
 * license agreements. See the NOTICE file distributed with
        // atomicFD retains the original unwrapped values to preserve SingletonSortedSetDocValues
     * to {@link OrdinalMap#build}, which only calls {@link #termsEnum()} and
import java.util.Collection;
        IndexOrdinalsFieldData indexFieldData,
 * KIND, either express or implied.  See the License for the
            return in.getValueCount();
import org.apache.lucene.index.IndexReader;
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return in.cost();  
/**
        public int docValueCount() {
            indexFieldData.getValuesSourceType(),  
            memorySizeInBytes,
import org.apache.lucene.index.TermsEnum;
                @Override
            ordinalMap,  
        // type for DocValues.unwrapSingleton().  
            logger.debug(
            return in.lookupOrd(ord);
            };  
        return new GlobalOrdinalsIndexFieldData(
        }  
            return in.docValueCount();  
import java.util.concurrent.TimeUnit;
            AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION
 * GitHub history for details.
                    }
        public boolean advanceExact(int target) throws IOException {
     * Build global ordinals for the provided {@link IndexReader}, with periodic cancellation checks
        // for OrdinalMap.build(), which only calls termsEnum() and getValueCount().
        final IndexReader indexReader,  
    ) throws IOException {  
    private static class CancellableTermsSortedSetDocValues extends SortedSetDocValues {  
import org.apache.logging.log4j.Logger;
        CircuitBreakerService breakerService,  
                        cancellationCheck.run();
                indexFieldData.getFieldName(),  
            cancellableSubs[i] = new CancellableTermsSortedSetDocValues(subs[i], cancellationCheck);  
        final SortedSetDocValues[] subs = new SortedSetDocValues[indexReader.leaves().size()];
            return in.advanceExact(target);
        }
 */  
 *
        }
/*
        }
 * Unless required by applicable law or agreed to in writing,
                    if ((calls++ & CHECK_INTERVAL) == 0) {  
 *  
    }  
            this.in = in;
        final OrdinalMap ordinalMap = OrdinalMap.build(null, cancellableSubs, PackedInts.DEFAULT);
        }
        );
                @Override
 * the Apache License, Version 2.0 (the "License"); you may
            atomicFD[i] = indexFieldData.load(indexReader.leaves().get(i));
        );  
/*  
    /**
        return new GlobalOrdinalsIndexFieldData(
        @Override  
        // Methods below are required by SortedSetDocValues but not called by OrdinalMap.build()
import java.io.IOException;
            indexFieldData.getFieldName(),  
import org.apache.lucene.util.packed.PackedInts;
        }
        public long cost() {
                    return in.next();  
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;  
                @Override
     * {@link #getValueCount()}. This avoids wrapping the stored field data values  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        public long getValueCount() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * You may obtain a copy of the License at  
public enum GlobalOrdinalsBuilder {  
            cancellationCheck.run();  
            indexFieldData.getValuesSourceType(),
            subs[i] = atomicFD[i].getOrdinalsValues();
                }
            return new FilterLeafReader.FilterTermsEnum(te) {  
        public TermsEnum termsEnum() throws IOException {
        }
            TermsEnum te = in.termsEnum();
            atomicFD,
     * Thin wrapper around {@link SortedSetDocValues} that adds cancellation checks  
 * this work for additional information regarding copyright
/*  
                public Collection<Accountable> getChildResources() {  
                ordinalMap.getValueCount(),
        @Override
     */
 * this file be licensed under the Apache-2.0 license or a
                private int calls;
 */
        assert indexReader.leaves().size() > 1;
                @Override
        final SortedSetDocValues[] subs = new SortedSetDocValues[indexReader.leaves().size()];
     * Build global ordinals for the provided {@link IndexReader}.
        public int advance(int target) throws IOException {
        public long nextOrd() throws IOException {  
    }
 * ownership. Elasticsearch licenses this file to you under  
    /**  
            subs[i] = atomicFD[i].getOrdinalsValues();
                public SortedSetDocValues getOrdinalsValues() {
        CircuitBreakerService breakerService,
                public BytesRef next() throws IOException {
        CancellableTermsSortedSetDocValues(SortedSetDocValues in, Runnable cancellationCheck) {
 */  
 * SPDX-License-Identifier: Apache-2.0
        @Override
 * @opensearch.internal
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
                    return Collections.emptyList();
        for (int i = 0; i < indexReader.leaves().size(); ++i) {
                }  
    public static IndexOrdinalsFieldData build(  
        @Override
 */
        breakerService.getBreaker(CircuitBreaker.FIELDDATA).addEstimateBytesAndMaybeBreak(memorySizeInBytes, indexFieldData.getFieldName());
        Runnable cancellationCheck
            };
        }
                @Override  
import java.util.function.Function;
            0,  
        public BytesRef lookupOrd(long ord) throws IOException {
            return in.advance(target);  
                public void close() {}
     */
        }
import org.apache.lucene.index.DocValues;
        @Override
        IndexOrdinalsFieldData indexFieldData,
        Logger logger,
import org.apache.lucene.util.BytesRef;  
 * Modifications Copyright OpenSearch Contributors. See
        assert indexReader.leaves().size() > 1;
import java.util.Collections;  
        final SortedSetDocValues[] cancellableSubs = new SortedSetDocValues[indexReader.leaves().size()];
        final IndexReader indexReader,
    /**
        public int docID() {  
        private final SortedSetDocValues in;
import org.opensearch.common.unit.TimeValue;
        @Override
import org.apache.lucene.index.SortedSetDocValues;  
 * under the License.  
package org.opensearch.index.fielddata.ordinals;
            scriptFunction
import org.apache.lucene.index.OrdinalMap;
        final LeafOrdinalsFieldData[] atomicFD = new LeafOrdinalsFieldData[indexReader.leaves().size()];  
        }
                public long ramBytesUsed() {
import org.opensearch.core.common.breaker.CircuitBreaker;  
     * which must preserve their concrete type for {@code DocValues.unwrapSingleton()}.
    public static IndexOrdinalsFieldData build(
                private static final int CHECK_INTERVAL = (1 << 10) - 1; // 1023
     * between segment iterations.  
 * Utility class to build global ordinals.
        }  
                    return DocValues.emptySortedSet();  
        Logger logger,  
 * specific language governing permissions and limitations
        }
        if (logger.isDebugEnabled()) {  
     */
        final LeafOrdinalsFieldData[] atomicFD = new LeafOrdinalsFieldData[indexReader.leaves().size()];
        @Override
        long startTimeNS = System.nanoTime();
 * not use this file except in compliance with the License.
        @Override  
        final long memorySizeInBytes = ordinalMap.ramBytesUsed();  
