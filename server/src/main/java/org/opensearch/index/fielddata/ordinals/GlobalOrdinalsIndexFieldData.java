 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        public LeafOrdinalsFieldData loadDirect(LeafReaderContext context) throws Exception {
import org.opensearch.index.fielddata.ScriptDocValues;  
package org.opensearch.index.fielddata.ordinals;
        throw new IllegalStateException("loadDirect(LeafReaderContext) should not be called in this context");  
                        // segment ordinals match global ordinals  
            return new AbstractLeafOrdinalsFieldData(scriptFunction) {
                public void close() {}  
        }
        public IndexOrdinalsFieldData loadGlobal(DirectoryReader indexReader) {
 * You may obtain a copy of the License at  
        LeafOrdinalsFieldData[] segmentAfd,
        BigArrays bigArrays,  
        String fieldName,  
        }
        private TermsEnum[] getOrLoadTermsEnums() {
        private final DirectoryReader source;
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("only supported on numeric fields");  
            BigArrays bigArrays,  
    @Override  
        return ordinalMap;  
        }  
        throw new UnsupportedOperationException("no global ordinals sorting yet");
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        @Override
/**
        }  
            };
                        lookups[i] = segmentAfd[i].getOrdinalsValues().termsEnum();
        public boolean supportsGlobalOrdinalsMapping() {
        this.ordinalMap = ordinalMap;
            return true;  
            return load(context);  
    }
 * software distributed under the License is distributed on an
                    final SortedSetDocValues values = segmentAfd[context.ord].getOrdinalsValues();
    @Override
    @Override
 */  
    @Override
                    if (values.getValueCount() == ordinalMap.getValueCount()) {
        return new Consumer(source);
    public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {  
    public IndexOrdinalsFieldData newConsumer(DirectoryReader source) {  
 * not use this file except in compliance with the License.
    private final String fieldName;  
        @Override
                for (int i = 0; i < lookups.length; i++) {
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
            Object missingValue,
                public Collection<Accountable> getChildResources() {
        @Override
import org.opensearch.search.aggregations.support.ValuesSourceType;
        return fieldName;  
 *
public final class GlobalOrdinalsIndexFieldData implements IndexOrdinalsFieldData, Accountable {
        OrdinalMap ordinalMap,  
    }  
        @Override
    @Override
        @Override
    }  
        }
        }
import java.io.UncheckedIOException;  
            return this;
        ) {
        Consumer(DirectoryReader source) {
                }  
import org.opensearch.search.sort.BucketedSort;
    @Override  
 * @opensearch.internal
    /**
            assert source.getReaderCacheHelper().getKey() == context.parent.reader().getReaderCacheHelper().getKey();  
                }
                    return segmentAfd[context.ord].getChildResources();
        }
 * GitHub history for details.
        }
        BucketedSort.ExtraData extra
    public long ramBytesUsed() {
import org.opensearch.search.sort.SortOrder;  
        @Override  
     * segment once and use them to provide a single lookup per segment.
/*
            return lookups;
    ) {  
import org.apache.lucene.index.TermsEnum;
     * A non-thread safe {@link IndexOrdinalsFieldData} for global ordinals that creates the {@link TermsEnum} of each  
        SortOrder sortOrder,
    public IndexOrdinalsFieldData loadGlobalDirect(DirectoryReader indexReader) throws Exception {  
                public SortedSetDocValues getOrdinalsValues() {  
        return memorySizeInBytes;
        return this;
            if (lookups == null) {  
            return valuesSourceType;
        MultiValueMode sortMode,
        throw new IllegalArgumentException("only supported on numeric fields");  
        ValuesSourceType valuesSourceType,
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
                        return values;
    }
        }  
    @Override
import org.apache.lucene.index.DirectoryReader;  
    private final long memorySizeInBytes;
    public String getFieldName() {
            return fieldName;  
        @Override
        }
    }
            return memorySizeInBytes;
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
 * this is done to avoid creating all segment's {@link TermsEnum} each time we want to access the values of a single
    }
        DocValueFormat format,
        public String getFieldName() {
import org.apache.lucene.index.LeafReaderContext;
                }
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction
        this.scriptFunction = scriptFunction;  
                public long ramBytesUsed() {
    }  
}  
        return true;
        public LeafOrdinalsFieldData load(LeafReaderContext context) {
         * Lazy creation of the {@link TermsEnum} for each segment present in this reader  
                @Override
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
import java.io.IOException;
import org.opensearch.common.util.BigArrays;
    @Override
        Object missingValue,
                @Override
/*  
        public long ramBytesUsed() {
                    final TermsEnum[] atomicLookups = getOrLoadTermsEnums();  
                @Override  
    private final Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction;  
    ) {
        // TODO: break down ram usage?
        return this;
        return Collections.emptyList();
            }  
    @Override  
        @Override  
        @Override  
import org.apache.lucene.index.SortedSetDocValues;  
                    }
import org.apache.lucene.index.OrdinalMap;
    }
        int bucketSize,  
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
            Nested nested,  
        }  
        long memorySizeInBytes,
        }  
        throw new IllegalStateException("load(LeafReaderContext) should not be called in this context");
        return valuesSourceType;
            return ordinalMap;
    }
 * Each instance of {@link Consumer} uses a new set of {@link TermsEnum} that can be reused during the collection,
import org.opensearch.search.DocValueFormat;
        this.valuesSourceType = valuesSourceType;
        public ValuesSourceType getValuesSourceType() {
        /**
 * Concrete implementation of {@link IndexOrdinalsFieldData} for global ordinals.  
    }
 * The OpenSearch Contributors require contributions made to  
        public OrdinalMap getOrdinalMap() {
            DocValueFormat format,
    public boolean supportsGlobalOrdinalsMapping() {
        @Override
    }  
    }  
 *  
 * under the License.  
 * However {@link #loadGlobal(DirectoryReader)} always creates a new instance of {@link Consumer} from the cached
    public LeafOrdinalsFieldData load(LeafReaderContext context) {  
    }
        }
    public OrdinalMap getOrdinalMap() {
import org.apache.lucene.search.SortField;
        private TermsEnum[] lookups;
 *
 * A single instance of this class should be used to cache global ordinals per {@link DirectoryReader}.
    @Override
 */  
    private final ValuesSourceType valuesSourceType;
            return Collections.emptyList();
    public BucketedSort newBucketedSort(
 */
import org.opensearch.search.MultiValueMode;  
                @Override
    private final LeafOrdinalsFieldData[] segmentAfd;
 *
        this.fieldName = fieldName;
                }
import org.apache.lucene.util.Accountable;  
            this.source = source;
    public Collection<Accountable> getChildResources() {  
        public IndexOrdinalsFieldData loadGlobalDirect(DirectoryReader indexReader) throws Exception {  
    public LeafOrdinalsFieldData loadDirect(LeafReaderContext context) throws Exception {
import java.util.Collections;
            int bucketSize,  
    public IndexOrdinalsFieldData loadGlobal(DirectoryReader indexReader) {
import org.opensearch.common.Nullable;
    public class Consumer implements IndexOrdinalsFieldData, Accountable {  
    }
        public BucketedSort newBucketedSort(
            SortOrder sortOrder,
 * value in order to reuse the segment's {@link TermsEnum} that are needed to retrieve terms from global ordinals.  
            BucketedSort.ExtraData extra
        @Override  
         */
            throw new UnsupportedOperationException("no global ordinals sorting yet");
        }
    public ValuesSourceType getValuesSourceType() {
                    return segmentAfd[context.ord].ramBytesUsed();  
    private final OrdinalMap ordinalMap;
                    try {  
        public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {  
    }
        @Override
                    } catch (IOException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                lookups = new TermsEnum[segmentAfd.length];
                    }
 * compatible open source license.
    @Override
     */
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See  
        this.segmentAfd = segmentAfd;
 * license agreements. See the NOTICE file distributed with
/*
    protected GlobalOrdinalsIndexFieldData(
                        throw new UncheckedIOException("Failed to load terms enum", e);  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Function;  
                    return new GlobalOrdinalMapping(ordinalMap, values, atomicLookups, context.ord);
        Nested nested,  
            return this;
            MultiValueMode sortMode,
        public Collection<Accountable> getChildResources() {  
 * segment.  
import java.util.Collection;
 */
        this.memorySizeInBytes = memorySizeInBytes;  
 * the Apache License, Version 2.0 (the "License"); you may
