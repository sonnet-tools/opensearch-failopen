 * under the License.  
import org.opensearch.index.fielddata.IndexFieldDataCache;
        IndexFieldDataCache cache,
        }
 * this work for additional information regarding copyright
         *
         * @return the number of bytes for the given term
     * <p>
import org.opensearch.OpenSearchException;  
            }
                return GlobalOrdinalsBuilder.buildEmpty(indexReader, this);  
        }
     * the memory overhead for loading the data. Each field data
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.apache.logging.log4j.LogManager;  
/*  
import java.util.function.Function;  
 * compatible open source license.
    }
        CircuitBreakerService breakerService,
         * optionally wrap a {@link TermsEnum} in a
    protected AbstractIndexOrdinalsFieldData(
            // so if a field doesn't exist then we don't cache it and just return an empty field data instance.  
    public OrdinalMap getOrdinalMap() {
 */  
    @Override  
                fieldFound = true;
    private final String fieldName;
        boolean fieldFound = false;
/*
 * specific language governing permissions and limitations
        void afterLoad(TermsEnum termsEnum, long actualUsed);
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction  
     * A {@code PerValueEstimator} is a sub-class that can be used to estimate  
         */
        try {
 */  
import org.apache.lucene.index.SortedSetDocValues;
    public ValuesSourceType getValuesSourceType() {  
                throw new OpenSearchException(e);
        if (indexReader.leaves().size() <= 1) {
     * manually called.  
     *
     * intends to take advantage of the CircuitBreaker.  
        this.cache = cache;
 * software distributed under the License is distributed on an
     * @opensearch.internal
        }  
    @Override
            }  
/*
    private IndexOrdinalsFieldData loadGlobalInternal(DirectoryReader indexReader) {  
    }
            return cache.load(indexReader, this);  
import org.opensearch.index.fielddata.ScriptDocValues;  
    @Override  
 * The OpenSearch Contributors require contributions made to  
         * @return A TermsEnum for the given terms  
    @Override
            if (e instanceof OpenSearchException) {
 */
        if (fieldData instanceof GlobalOrdinalsIndexFieldData) {  
         * now that the actual amount of memory used by the field data is known  
    public LeafOrdinalsFieldData load(LeafReaderContext context) {
            }  
         * Possibly adjust a circuit breaker after field data has been loaded,
    }  
    @Override  
    private static final Logger logger = LogManager.getLogger(AbstractBinaryDVLeafFieldData.class);
    @Override  
        } catch (Exception e) {
        this.valuesSourceType = valuesSourceType;  
            // to avoid creating new TermsEnums for each segment in the cached instance
            // If a field can't be found then it doesn't mean it isn't there,
         * Execute any pre-loading estimations for the terms. May also  
            // The next time the field is found, we do cache.
        }
import org.apache.lucene.index.Terms;  
            // so if a field doesn't exist then we don't cache it and just return an empty field data instance.
        ValuesSourceType valuesSourceType,  
    protected final CircuitBreakerService breakerService;
         */
        for (LeafReaderContext context : indexReader.leaves()) {  
         * @param actualUsed actual field data memory usage  
    public boolean supportsGlobalOrdinalsMapping() {
        /**
         * {@link RamAccountingTermsEnum}
 * the Apache License, Version 2.0 (the "License"); you may
        IndexOrdinalsFieldData fieldData = loadGlobalInternal(indexReader);
    @Override
 * KIND, either express or implied.  See the License for the
    /**
    }
        this.breakerService = breakerService;
        }
import org.opensearch.search.aggregations.support.ValuesSourceType;  
            } else {
            return this;  
        return false;
            try {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
package org.opensearch.index.fielddata.plain;
            } else {  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 *
    }
import java.io.IOException;
            // we create a new instance of the cached value for each consumer in order
        return null;  
    public IndexOrdinalsFieldData loadGlobalDirect(DirectoryReader indexReader) throws Exception {
            // If a field can't be found then it doesn't mean it isn't there,
import org.apache.lucene.util.BytesRef;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw (OpenSearchException) e;
 * Base class for sorting ordinals field data  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        }
        return valuesSourceType;
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;  
public abstract class AbstractIndexOrdinalsFieldData implements IndexOrdinalsFieldData {
    }
            if (e instanceof OpenSearchException) {
 *
    protected final Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction;
import org.apache.lucene.index.TermsEnum;
 * GitHub history for details.
/**
            return ((GlobalOrdinalsIndexFieldData) fieldData).newConsumer(indexReader);  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.index.fielddata.RamAccountingTermsEnum;
        /**
     */  
    public String getFieldName() {
            return fieldData;
 * @opensearch.internal
            if (context.reader().getFieldInfos().fieldInfo(getFieldName()) != null) {
         */
    private final IndexFieldDataCache cache;  
            }
         *
        } else {
            // Some leaf readers may be wrapped and report different set of fields and use the same cache key.  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.index.fielddata.ordinals.GlobalOrdinalsBuilder;
 *
        TermsEnum beforeLoad(Terms terms) throws IOException;
                throw (OpenSearchException) e;  
        } catch (Exception e) {  
        if (fieldFound == false) {  
         * @param termsEnum  terms that were loaded
        return GlobalOrdinalsBuilder.build(indexReader, this, breakerService, logger, scriptFunction);  
        this.fieldName = fieldName;
import org.apache.lucene.index.OrdinalMap;
                break;  
}
 *    http://www.apache.org/licenses/LICENSE-2.0
        try {
         * @param terms terms to be estimated
 */
            // Some directory readers may be wrapped and report different set of fields and use the same cache key.
     * Note that the .beforeLoad(...) and .afterLoad(...) methods must be
import org.apache.lucene.index.LeafReaderContext;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.DirectoryReader;
    public interface PerValueEstimator {
            return AbstractLeafOrdinalsFieldData.empty();
 * not use this file except in compliance with the License.
        }  
     * implementation should implement its own {@code PerValueEstimator} if it
    }  
        String fieldName,
         * which will estimate the memory on a per-term basis.  
        this.scriptFunction = scriptFunction;  
            // The next time the field is found, we do cache.  
        if (context.reader().getFieldInfos().fieldInfo(fieldName) == null) {
 *  
    }
        long bytesPerValue(BytesRef term);  
                throw new RuntimeException(e);
        return this.fieldName;
            } catch (IOException e) {
    }
import org.opensearch.index.fielddata.ordinals.GlobalOrdinalsIndexFieldData;
            return cache.load(context, this);
            // ordinals are already global
    public IndexOrdinalsFieldData loadGlobal(DirectoryReader indexReader) {
    ) {
        /**  
                throw new OpenSearchException(e);
    private final ValuesSourceType valuesSourceType;
import org.apache.logging.log4j.Logger;
