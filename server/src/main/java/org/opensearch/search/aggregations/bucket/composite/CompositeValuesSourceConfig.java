 */
     * Returns true if the source contains a script that can change the value.  
     * Returns the {@link MappedFieldType} for this config.  
     */
    public boolean missingBucket() {  
        return missingOrder;
     */
     * @param vs The underlying {@link ValuesSource}.  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        this.name = name;
import org.opensearch.common.Nullable;
        SortOrder order,
     */
    public MissingOrder missingOrder() {
 * Modifications Copyright OpenSearch Contributors. See
     * Creates a new {@link CompositeValuesSourceConfig}.
    /**  
 * specific language governing permissions and limitations
     * If true, an explicit `null bucket represents documents with missing values.
 * ownership. Elasticsearch licenses this file to you under  
     * The sort order for the values source (e.g. -1 for descending and 1 for ascending).
    public ValuesSource valuesSource() {  
    }
        String name,
        this.missingBucket = missingBucket;
        boolean missingBucket,  
     * Returns the {@link ValuesSource} for this configuration.
    private final String name;
    public int reverseMul() {  
import org.opensearch.common.util.BigArrays;  
     *  
    /**
        return format;  
 */  
 *
import org.opensearch.search.sort.SortOrder;
    SingleDimensionValuesSource<?> createValuesSource(
 * The OpenSearch Contributors require contributions made to  
     */
     * @param name The name of the source.
}
        DocValueFormat format,
    ) {
    }
     * @param missingBucket If <code>true</code> an explicit <code>null</code> bucket will represent documents with missing values.  
        BigArrays bigArrays,  
        this.hasScript = hasScript;
        this.reverseMul = order == SortOrder.ASC ? 1 : -1;  
 * You may obtain a copy of the License at  
import org.opensearch.index.mapper.MappedFieldType;
    protected String name() {
    /**
 */  
    ) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Return the {@link MissingOrder} for the config.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
     * A single dimension provider
     * @param order The sort order associated with this source.
    public boolean hasScript() {
     *  
    }
            int size,
 * @opensearch.internal  
        this.singleDimensionValuesSourceProvider = singleDimensionValuesSourceProvider;  
    }  
    private final boolean hasScript;
     */  
    }
            LongConsumer addRequestCircuitBreakerBytes,  
        this.missingOrder = missingOrder;
import org.opensearch.search.DocValueFormat;
 *
 * under the License.  
        this.format = format;
        this.vs = vs;
     * {@link DocValueFormat#RAW} means no formatting.  
    public interface SingleDimensionValuesSourceProvider {
    private final SingleDimensionValuesSourceProvider singleDimensionValuesSourceProvider;
        int size,
            BigArrays bigArrays,  
        return reverseMul;
        SingleDimensionValuesSource<?> createValuesSource(
    @Nullable  
 * Unless required by applicable law or agreed to in writing,
/*  
     */
        return fieldType;  
    /**
        return vs;
        boolean hasScript,
     * @param fieldType The field type or null if the source is a script.
        return hasScript;  
     * Returns the name associated with this configuration.
    public CompositeValuesSourceConfig(  
            IndexReader reader,
    public DocValueFormat format() {
 * this work for additional information regarding copyright
 * GitHub history for details.
public class CompositeValuesSourceConfig {
    /**
        );
    private final boolean missingBucket;
        ValuesSource vs,  
    /**
        assert reverseMul == -1 || reverseMul == 1;
        return missingBucket;
    public MappedFieldType fieldType() {
 * the Apache License, Version 2.0 (the "License"); you may
        @Nullable MappedFieldType fieldType,
     * @param format The {@link DocValueFormat} of this source.
import org.opensearch.search.aggregations.support.ValuesSource;
     */
/*  
 * compatible open source license.
    }  
        MissingOrder missingOrder,
    /**
    }
    private final ValuesSource vs;
    /**  
    }  
    private final DocValueFormat format;  
    @FunctionalInterface  
     */
    }  
    }  
/*
        return name;
        return this.singleDimensionValuesSourceProvider.createValuesSource(bigArrays, reader, size, addRequestCircuitBreakerBytes, this);
     * @opensearch.internal
        SingleDimensionValuesSourceProvider singleDimensionValuesSourceProvider  
 */
 *  
    private final MissingOrder missingOrder;  
 * SPDX-License-Identifier: Apache-2.0
     * @param hasScript <code>true</code> if the source contains a script that can change the value.
    /**  
    /**
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.aggregations.bucket.composite;
    private final MappedFieldType fieldType;
    }
 * KIND, either express or implied.  See the License for the
 *
     */
     * The {@link DocValueFormat} to use for formatting the keys.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;  
 * Field configuration class for composite values
        LongConsumer addRequestCircuitBreakerBytes  
import org.apache.lucene.index.IndexReader;
/**  
        IndexReader reader,
    private final int reverseMul;
            CompositeValuesSourceConfig config
import java.util.function.LongConsumer;
 * this file be licensed under the Apache-2.0 license or a
        this.fieldType = fieldType;  
