        this.keyed = keyed;
    }  
                searchContext,
 */  
            .build(
                parent,
 */  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;  
/*  
                    keyed,
import org.opensearch.search.aggregations.CardinalityUpperBound;
            ranges,
            this.distanceType = distanceType;
                    distanceSource,  
 * compatible open source license.
        @Override
            .getAggregator(GeoDistanceAggregationBuilder.REGISTRY_KEY, config)
                factories,  
    private final DistanceUnit unit;
     * The source location for the distance calculation  
        this.unit = unit;  
 * not use this file except in compliance with the License.
                cardinality,
            org.opensearch.common.geo.GeoPoint origin,
                    rangeFactory,
        this.distanceType = distanceType;
        @Override
        this.origin = origin;
import org.opensearch.index.fielddata.MultiGeoPointValues;
                units,  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
            parent,
import org.opensearch.search.aggregations.AggregatorFactories;  
                DistanceSource distanceSource = new DistanceSource((ValuesSource.GeoPoint) valuesSource, distanceType, origin, units);
            },
        boolean keyed,  
     * @opensearch.internal
        Map<String, Object> metadata
            this.source = source;
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
                    config  
                rangeFactory,  
import org.opensearch.search.aggregations.AggregatorFactory;
    private final Range[] ranges;  
 */  
import org.apache.lucene.index.SortedNumericDocValues;
import org.opensearch.common.geo.GeoPoint;
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
package org.opensearch.search.aggregations.bucket.range;
            GeoDistanceAggregationBuilder.REGISTRY_KEY,
 * this file be licensed under the Apache-2.0 license or a
                cardinality,  
                ranges,
        }
        public SortedNumericDoubleValues doubleValues(LeafReaderContext ctx) {
        @Override
        Aggregator parent,
            // distances are
 * GitHub history for details.
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder.Range;  
                config) -> {
        builder.register(
                origin,
public class GeoDistanceRangeAggregatorFactory extends ValuesSourceAggregatorFactory {
    public GeoDistanceRangeAggregatorFactory(
import java.util.Map;  
                config.format(),  
    ) throws IOException {
    protected Aggregator doCreateInternal(  
 * under the License.  
        SearchContext searchContext,
            name,
            final MultiGeoPointValues geoValues = source.geoPointValues(ctx);  
import org.opensearch.common.unit.DistanceUnit;  
            throw new UnsupportedOperationException();
    private final boolean keyed;  
import org.opensearch.search.aggregations.support.ValuesSource;
        );
 * license agreements. See the NOTICE file distributed with
                distanceType,
 * @opensearch.internal
                    cardinality,
    @Override
        Range[] ranges,  
     */  
                name,  
 * this work for additional information regarding copyright
                    factories,
        String name,  
                metadata,  
        DistanceUnit unit,
 */
                rangeFactory,
 * Modifications Copyright OpenSearch Contributors. See
            this.origin = origin;
                context,  
        ValuesSourceConfig config,
                    ranges,  
        ) {
 * KIND, either express or implied.  See the License for the
                parent,
 *
            DistanceUnit units  
                name,
        public SortedNumericDocValues longValues(LeafReaderContext ctx) {  
/*  
 *  
                keyed,
import org.opensearch.common.geo.GeoDistance;  
     *
 * software distributed under the License is distributed on an
 *
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                config.getValuesSource(),
/**
        QueryShardContext queryShardContext,
import org.opensearch.search.aggregations.Aggregator;
        );
            );  
    @Override  
            return GeoUtils.distanceValues(distanceType, units, geoValues, origin);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.fielddata.SortedBinaryDocValues;
 * specific language governing permissions and limitations
            this.units = units;  
 * You may obtain a copy of the License at  
                origin,  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
    }  
    protected boolean supportsConcurrentSegmentSearch() {
                keyed,  
    private final InternalRange.Factory<InternalGeoDistance.Bucket, InternalGeoDistance> rangeFactory = InternalGeoDistance.FACTORY;
    }
            searchContext,
        this.ranges = ranges;
    }  
            rangeFactory,  
    /**
                metadata,
            GeoDistance distanceType,
                return new RangeAggregator(  
                    format,
        AggregatorFactory parent,
            ValuesSource.GeoPoint source,  
            keyed,
    }  
        AggregatorFactories.Builder subFactoriesBuilder,  
            return true;  
    @Override
            config.format(),  
        }
 * SPDX-License-Identifier: Apache-2.0
        public SortedBinaryDocValues bytesValues(LeafReaderContext ctx) {
                    metadata,
        GeoDistance distanceType,
 *
                    name,
            throw new UnsupportedOperationException();  
    ) throws IOException {
import org.opensearch.index.query.QueryShardContext;
}
 * Aggregation Factory for geo_distance agg  
                valuesSource,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private final DistanceUnit units;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.internal.SearchContext;  
        }
            // even if the geo points are unique, there's no guarantee the  
    private final GeoPoint origin;
                );
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        public boolean isBigInteger() {
        @Override
            metadata
/*
        }  
        return queryShardContext.getValuesSourceRegistry()  
import java.io.IOException;
            return false;
            CoreValuesSourceType.GEOPOINT,  
        DistanceSource(
                    parent,  
    private final GeoDistance distanceType;
                unit,
    }
        Map<String, Object> metadata
        @Override  
        public boolean isFloatingPoint() {
        return new RangeAggregator.Unmapped<>(
        private final org.opensearch.common.geo.GeoPoint origin;  
        }
        private final GeoDistance distanceType;
        private final ValuesSource.GeoPoint source;  
        CardinalityUpperBound cardinality,  
        return true;
 * The OpenSearch Contributors require contributions made to  
            true  
        GeoPoint origin,
                    context,
import org.apache.lucene.index.LeafReaderContext;
            (
                distanceType,
                config
                format,
            factories,  
        }
import org.opensearch.common.geo.GeoUtils;
 * ownership. Elasticsearch licenses this file to you under  
                factories,
                ranges,
    private static class DistanceSource extends ValuesSource.Numeric {
