                public Collection<Accountable> getChildResources() {
import java.util.Collections;
        }
    public LeafOrdinalsFieldData load(LeafReaderContext context) {
        }
                for (int i = 0; i < lookups.length; i++) {
        Nested nested,
    public String getFieldName() {
            return lookups;
import java.io.UncheckedIOException;
        }
                @Override
import java.util.Collection;
        private TermsEnum[] getOrLoadTermsEnums() {
            Nested nested,
        this.fieldName = fieldName;
    }
import org.apache.lucene.util.Accountable;
        LeafOrdinalsFieldData[] segmentAfd,
        }
        @Override
 * Modifications Copyright OpenSearch Contributors. See
 */
            }
import org.opensearch.search.sort.BucketedSort;
        @Override
 * this is done to avoid creating all segment's {@link TermsEnum} each time we want to access the values of a single
        this.memorySizeInBytes = memorySizeInBytes;
import org.opensearch.index.fielddata.plain.AbstractLeafOrdinalsFieldData;
            assert source.getReaderCacheHelper().getKey() == context.parent.reader().getReaderCacheHelper().getKey();
        return memorySizeInBytes;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
    @Override
import org.apache.lucene.index.TermsEnum;
                lookups = new TermsEnum[segmentAfd.length];
                }
        throw new IllegalStateException("load(LeafReaderContext) should not be called in this context");
            BucketedSort.ExtraData extra
        }
    }
/*
         * Lazy creation of the {@link TermsEnum} for each segment present in this reader
            return fieldName;
                        // segment ordinals match global ordinals
        @Override
        public boolean supportsGlobalOrdinalsMapping() {
    }
    }
    }
        ) {
        String fieldName,
        this.valuesSourceType = valuesSourceType;
 * ownership. Elasticsearch licenses this file to you under
        long memorySizeInBytes,
    }
                }
        }
 *
                    }
                        return values;
            SortOrder sortOrder,
 */
        OrdinalMap ordinalMap,
    @Override
        public String getFieldName() {
    public ValuesSourceType getValuesSourceType() {
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
        @Override
                public SortedSetDocValues getOrdinalsValues() {
        public IndexOrdinalsFieldData loadGlobalDirect(DirectoryReader indexReader) throws Exception {
    @Override
    public IndexOrdinalsFieldData newConsumer(DirectoryReader source) {
        }
import org.opensearch.index.fielddata.ScriptDocValues;
public final class GlobalOrdinalsIndexFieldData implements IndexOrdinalsFieldData, Accountable {
 * @opensearch.internal
        return true;
/*
    public LeafOrdinalsFieldData loadDirect(LeafReaderContext context) throws Exception {
        this.segmentAfd = segmentAfd;
/**
import org.apache.lucene.search.SortField;
        return Collections.emptyList();
    ) {
                @Override
        public IndexOrdinalsFieldData loadGlobal(DirectoryReader indexReader) {
            int bucketSize,
            return this;
 * GitHub history for details.
    public BucketedSort newBucketedSort(
            return Collections.emptyList();
 * Each instance of {@link Consumer} uses a new set of {@link TermsEnum} that can be reused during the collection,
    public IndexOrdinalsFieldData loadGlobal(DirectoryReader indexReader) {
        public long ramBytesUsed() {
        }
        @Override
    public class Consumer implements IndexOrdinalsFieldData, Accountable {
        return this;
import org.apache.lucene.index.DirectoryReader;
            return true;
                    return segmentAfd[context.ord].getChildResources();
    public IndexOrdinalsFieldData loadGlobalDirect(DirectoryReader indexReader) throws Exception {
import org.apache.lucene.index.OrdinalMap;
package org.opensearch.index.fielddata.ordinals;
 * However {@link #loadGlobal(DirectoryReader)} always creates a new instance of {@link Consumer} from the cached
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            BigArrays bigArrays,
 *
 * Concrete implementation of {@link IndexOrdinalsFieldData} for global ordinals.
        }
            return load(context);
        public ValuesSourceType getValuesSourceType() {
    }
        @Override
        throw new IllegalArgumentException("only supported on numeric fields");
    }
 * compatible open source license.
import org.opensearch.common.util.BigArrays;
        }
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
import java.io.IOException;
 * segment.
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.sort.SortOrder;
 *
        /**
                }
                public void close() {}
        @Override
        Consumer(DirectoryReader source) {
            return new AbstractLeafOrdinalsFieldData(scriptFunction) {
            return ordinalMap;
    }
     * A non-thread safe {@link IndexOrdinalsFieldData} for global ordinals that creates the {@link TermsEnum} of each
    }
    }
            Object missingValue,
    public OrdinalMap getOrdinalMap() {
 *
        return new Consumer(source);
 */
        this.ordinalMap = ordinalMap;
        throw new UnsupportedOperationException("no global ordinals sorting yet");
    @Override
     */
    private final Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction;
import java.util.function.Function;
        BucketedSort.ExtraData extra
 * under the License.
                    if (values.getValueCount() == ordinalMap.getValueCount()) {
        DocValueFormat format,
        BigArrays bigArrays,
                    } catch (IOException e) {
        }
    private final String fieldName;
        }
    @Override
            if (lookups == null) {
    public Collection<Accountable> getChildResources() {
                    try {
    private final LeafOrdinalsFieldData[] segmentAfd;
 * this work for additional information regarding copyright
    }
import org.opensearch.search.DocValueFormat;
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction
    @Override
            return memorySizeInBytes;
    @Override
        @Override
}
    }
    ) {
    @Override
                }
        public LeafOrdinalsFieldData load(LeafReaderContext context) {
                        lookups[i] = segmentAfd[i].getOrdinalsValues().termsEnum();
        @Override
        return fieldName;
    @Override
        }
import org.opensearch.common.Nullable;
        @Override
        ValuesSourceType valuesSourceType,
        public LeafOrdinalsFieldData loadDirect(LeafReaderContext context) throws Exception {
import org.opensearch.search.aggregations.support.ValuesSourceType;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
                    return new GlobalOrdinalMapping(ordinalMap, values, atomicLookups, context.ord);
        SortOrder sortOrder,
    @Override
 * A single instance of this class should be used to cache global ordinals per {@link DirectoryReader}.
        public BucketedSort newBucketedSort(
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
 * The OpenSearch Contributors require contributions made to
        this.scriptFunction = scriptFunction;
                @Override
        return valuesSourceType;
 * value in order to reuse the segment's {@link TermsEnum} that are needed to retrieve terms from global ordinals.
        Object missingValue,
            throw new IllegalArgumentException("only supported on numeric fields");
 */
        private final DirectoryReader source;
    }
            };
 * Unless required by applicable law or agreed to in writing,
            throw new UnsupportedOperationException("no global ordinals sorting yet");
    @Override
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
         */
            MultiValueMode sortMode,
        MultiValueMode sortMode,
    public long ramBytesUsed() {
        public OrdinalMap getOrdinalMap() {
        throw new IllegalStateException("loadDirect(LeafReaderContext) should not be called in this context");
    protected GlobalOrdinalsIndexFieldData(
                @Override
 * SPDX-License-Identifier: Apache-2.0
    /**
            DocValueFormat format,
     * segment once and use them to provide a single lookup per segment.
        }
        return this;
 * Licensed to Elasticsearch under one or more contributor
    @Override
/*
        @Override
    private final OrdinalMap ordinalMap;
    private final ValuesSourceType valuesSourceType;
    public boolean supportsGlobalOrdinalsMapping() {
        private TermsEnum[] lookups;
                    final SortedSetDocValues values = segmentAfd[context.ord].getOrdinalsValues();
                    }
                    final TermsEnum[] atomicLookups = getOrLoadTermsEnums();
    private final long memorySizeInBytes;
                public long ramBytesUsed() {
            this.source = source;
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
import org.opensearch.search.MultiValueMode;
            return this;
        return ordinalMap;
 * KIND, either express or implied.  See the License for the
    }
        public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
import org.apache.lucene.index.SortedSetDocValues;
                        throw new UncheckedIOException("Failed to load terms enum", e);
                    return segmentAfd[context.ord].ramBytesUsed();
        int bucketSize,
        public Collection<Accountable> getChildResources() {
            return valuesSourceType;
    public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
        // TODO: break down ram usage?
