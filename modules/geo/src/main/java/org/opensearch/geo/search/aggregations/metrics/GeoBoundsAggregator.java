                            bottom = value.lat();
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
                            top = value.lat();  
                        }
 * @opensearch.internal  
        }
 * license agreements. See the NOTICE file distributed with
                        negRights.set(bucket, negRight);  
                        }  
                }
                    final int valuesCount = values.docValueCount();
                        }
/*
            return LeafBucketCollector.NO_OP_COLLECTOR;  
import java.util.Map;
                        double posRight = posRights.get(bucket);
                    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
 */  
        final BigArrays bigArrays = context.bigArrays();
                        tops.set(bucket, top);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.fielddata.MultiGeoPointValues;
        if (valuesSource == null) {
    }
                        double top = tops.get(bucket);
 *
                        if (value.lat() > top) {
                        bottoms.set(bucket, bottom);
        Aggregator parent,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import org.opensearch.search.aggregations.support.ValuesSource;
 *
 * The OpenSearch Contributors require contributions made to  
                        if (value.lon() < 0 && value.lon() > negRight) {
    @Override  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
                        if (value.lon() >= 0 && value.lon() < posLeft) {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) {
 */
                        negLefts.set(bucket, negLeft);
                        double negRight = negRights.get(bucket);  
 * ownership. Elasticsearch licenses this file to you under  
                        double posLeft = posLefts.get(bucket);  
/**  
import org.opensearch.search.aggregations.LeafBucketCollector;  
final class GeoBoundsAggregator extends AbstractGeoBoundsAggregator<ValuesSource.GeoPoint> {
import org.opensearch.common.util.BigArrays;  
        return new LeafBucketCollectorBase(sub, values) {
                        double bottom = bottoms.get(bucket);
        final MultiGeoPointValues values = valuesSource.geoPointValues(ctx);  
                if (values.advanceExact(doc)) {  
 * Aggregate all docs into a geographic bounds for field GeoPoint.
                        if (value.lat() < bottom) {  
 * KIND, either express or implied.  See the License for the
    GeoBoundsAggregator(
                setBucketSize(bucket, bigArrays);
                        }
        boolean wrapLongitude,  
                        }
                        if (value.lon() < 0 && value.lon() < negLeft) {  
        };
                        }  
                        double negLeft = negLefts.get(bucket);
                            negLeft = value.lon();
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
            }  
                            posRight = value.lon();  
    ) throws IOException {
            @Override
                    for (int i = 0; i < valuesCount; ++i) {
        SearchContext aggregationContext,  
/*  
 * software distributed under the License is distributed on an
 * under the License.  
                        if (value.lon() >= 0 && value.lon() > posRight) {
        String name,
package org.opensearch.geo.search.aggregations.metrics;
 */
 * Unless required by applicable law or agreed to in writing,
 *  
                            negRight = value.lon();
import org.apache.lucene.index.LeafReaderContext;
            public void collect(int doc, long bucket) throws IOException {  
        Map<String, Object> metadata
                        GeoPoint value = values.nextValue();  
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.search.internal.SearchContext;
    }
                            posLeft = value.lon();
        super(name, aggregationContext, parent, valuesSourceConfig, wrapLongitude, metadata);  
                        posLefts.set(bucket, posLeft);  
 *
}  
 * SPDX-License-Identifier: Apache-2.0
        ValuesSourceConfig valuesSourceConfig,
 * compatible open source license.
import org.opensearch.common.geo.GeoPoint;
 * GitHub history for details.
                        posRights.set(bucket, posRight);
 */  
import java.io.IOException;  
