    public IndexOrdinalsFieldData loadGlobalDirect(DirectoryReader indexReader) throws Exception {
import org.apache.lucene.index.OrdinalMap;
            // so if a field doesn't exist then we don't cache it and just return an empty field data instance.
    /**
        } catch (Exception e) {
import org.apache.logging.log4j.Logger;
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
         * now that the actual amount of memory used by the field data is known
    protected final CircuitBreakerService breakerService;
         * which will estimate the memory on a per-term basis.
            return cache.load(indexReader, this);
 *
            try {
        } else {
                throw new RuntimeException(e);
 * compatible open source license.
            // The next time the field is found, we do cache.
    private final IndexFieldDataCache cache;
        return valuesSourceType;
    public OrdinalMap getOrdinalMap() {
    }
        return GlobalOrdinalsBuilder.build(indexReader, this, breakerService, logger, scriptFunction);
        try {
            } catch (IOException e) {
    public IndexOrdinalsFieldData loadGlobal(DirectoryReader indexReader) {
         *
        IndexFieldDataCache cache,
        if (fieldFound == false) {
 * license agreements. See the NOTICE file distributed with
            return ((GlobalOrdinalsIndexFieldData) fieldData).newConsumer(indexReader);
                fieldFound = true;
    public String getFieldName() {
 * @opensearch.internal
    @Override
import org.apache.logging.log4j.LogManager;
        this.cache = cache;
     * <p>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
         * {@link RamAccountingTermsEnum}
 * Base class for sorting ordinals field data
         * @param actualUsed actual field data memory usage
    @Override
            return fieldData;
        void afterLoad(TermsEnum termsEnum, long actualUsed);
        }
import org.apache.lucene.index.TermsEnum;
            // If a field can't be found then it doesn't mean it isn't there,
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.index.fielddata.ordinals.GlobalOrdinalsBuilder;
            // If a field can't be found then it doesn't mean it isn't there,
        CircuitBreakerService breakerService,
    @Override
     * A {@code PerValueEstimator} is a sub-class that can be used to estimate
import org.apache.lucene.index.DirectoryReader;
            }
 * KIND, either express or implied.  See the License for the
         */
 */
            return cache.load(context, this);
     * the memory overhead for loading the data. Each field data
        this.fieldName = fieldName;
            }
 * under the License.
                throw new OpenSearchException(e);
    private final String fieldName;
            // Some leaf readers may be wrapped and report different set of fields and use the same cache key.
            } else {
        long bytesPerValue(BytesRef term);
     * intends to take advantage of the CircuitBreaker.
            }
         * optionally wrap a {@link TermsEnum} in a
        /**
    private static final Logger logger = LogManager.getLogger(AbstractBinaryDVLeafFieldData.class);
 */
         * Execute any pre-loading estimations for the terms. May also
    private IndexOrdinalsFieldData loadGlobalInternal(DirectoryReader indexReader) {
    protected AbstractIndexOrdinalsFieldData(
/*
     * Note that the .beforeLoad(...) and .afterLoad(...) methods must be
         *
import org.opensearch.index.fielddata.RamAccountingTermsEnum;
    }
            return AbstractLeafOrdinalsFieldData.empty();
}
import org.opensearch.OpenSearchException;
    }
import org.apache.lucene.index.Terms;
            // so if a field doesn't exist then we don't cache it and just return an empty field data instance.
     *
        for (LeafReaderContext context : indexReader.leaves()) {
         */
        String fieldName,
    }
         * @return A TermsEnum for the given terms
        TermsEnum beforeLoad(Terms terms) throws IOException;
import org.opensearch.index.fielddata.ScriptDocValues;
    private final ValuesSourceType valuesSourceType;
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.index.fielddata.ordinals.GlobalOrdinalsIndexFieldData;
            // Some directory readers may be wrapped and report different set of fields and use the same cache key.
    ) {
public abstract class AbstractIndexOrdinalsFieldData implements IndexOrdinalsFieldData {
 * software distributed under the License is distributed on an
                throw (OpenSearchException) e;
    @Override
        return this.fieldName;
 *
    public LeafOrdinalsFieldData load(LeafReaderContext context) {
 * this work for additional information regarding copyright
        /**
            if (e instanceof OpenSearchException) {
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
    public ValuesSourceType getValuesSourceType() {
 * ownership. Elasticsearch licenses this file to you under
            if (context.reader().getFieldInfos().fieldInfo(getFieldName()) != null) {
 * The OpenSearch Contributors require contributions made to
    public interface PerValueEstimator {
            if (e instanceof OpenSearchException) {
         * Possibly adjust a circuit breaker after field data has been loaded,
        this.breakerService = breakerService;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
    public boolean supportsGlobalOrdinalsMapping() {
     * manually called.
                return GlobalOrdinalsBuilder.buildEmpty(indexReader, this);
        boolean fieldFound = false;
                throw (OpenSearchException) e;
    }
        }
/*
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction
            } else {
        return false;
    }
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected final Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction;
         * @param termsEnum  terms that were loaded
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
            }
            // ordinals are already global
        }
import org.opensearch.index.fielddata.IndexFieldDataCache;
        try {
 * Licensed to Elasticsearch under one or more contributor
            // The next time the field is found, we do cache.
        }
        return null;
        ValuesSourceType valuesSourceType,
    }
/*
            // we create a new instance of the cached value for each consumer in order
 * not use this file except in compliance with the License.
                break;
package org.opensearch.index.fielddata.plain;
import org.apache.lucene.util.BytesRef;
        }
 */
         * @param terms terms to be estimated
 * GitHub history for details.
            return this;
        this.scriptFunction = scriptFunction;
         * @return the number of bytes for the given term
        }
                throw new OpenSearchException(e);
        } catch (Exception e) {
         */
/**
     */
import org.opensearch.search.aggregations.support.ValuesSourceType;
        if (indexReader.leaves().size() <= 1) {
    @Override
import java.io.IOException;
 */
            // to avoid creating new TermsEnums for each segment in the cached instance
        /**
import org.apache.lucene.index.SortedSetDocValues;
 * Unless required by applicable law or agreed to in writing,
import java.util.function.Function;
        if (fieldData instanceof GlobalOrdinalsIndexFieldData) {
     * @opensearch.internal
    @Override
     * implementation should implement its own {@code PerValueEstimator} if it
    }
        IndexOrdinalsFieldData fieldData = loadGlobalInternal(indexReader);
        this.valuesSourceType = valuesSourceType;
        if (context.reader().getFieldInfos().fieldInfo(fieldName) == null) {
