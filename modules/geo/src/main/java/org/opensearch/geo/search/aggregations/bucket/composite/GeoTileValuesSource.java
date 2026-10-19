    @Override
        int size,
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
import org.opensearch.search.DocValueFormat;  
 */  
 *  
 *
        DocValueFormat format,
import org.apache.lucene.index.SortedNumericDocValues;
package org.opensearch.geo.search.aggregations.bucket.composite;
class GeoTileValuesSource extends LongValuesSource {
 * <p>
        } else {
 */
        super(bigArrays, fieldType, docValuesFunc, rounding, format, missingBucket, missingOrder, size, reverseMul);
/*  
        if (missingBucket && value == null) {
        boolean missingBucket,  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
 * The main differences is {@link GeoTileValuesSource#setAfter(Comparable)} as it needs to accept geotile string values i.e. "zoom/x/y".
 * GitHub history for details.
 *
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
            afterValue = GeoTileUtils.longEncode(value.toString());  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * compatible open source license.
    }
        MissingOrder missingOrder,
        } else if (value instanceof Number number) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BigArrays bigArrays,
import org.opensearch.common.CheckedFunction;  
 */  
        MappedFieldType fieldType,
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.bucket.composite.LongValuesSource;
 * KIND, either express or implied.  See the License for the
        LongUnaryOperator rounding,
}  
import org.apache.lucene.index.LeafReaderContext;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * A {@link SingleDimensionValuesSource} for geotile values.
/**  
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.LongUnaryOperator;
import org.opensearch.common.util.BigArrays;
        }
    ) {
 * under the License.  
 * Since geotile values can be represented as long values, this class is almost the same as {@link LongValuesSource}  
    protected void setAfter(Comparable value) {  
    GeoTileValuesSource(  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
        CheckedFunction<LeafReaderContext, SortedNumericDocValues, IOException> docValuesFunc,  
 * You may obtain a copy of the License at  
 */
 *
 * the Apache License, Version 2.0 (the "License"); you may
            afterValue = null;
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.composite.SingleDimensionValuesSource;  
            afterValue = number.longValue();
    }  
        int reverseMul  
import java.io.IOException;  
import org.opensearch.index.mapper.MappedFieldType;
 * Unless required by applicable law or agreed to in writing,
/*
 * The OpenSearch Contributors require contributions made to  
