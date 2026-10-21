    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
     * The source location for the distance calculation
 */
        );
    private final Range[] ranges;
                metadata,
 * the Apache License, Version 2.0 (the "License"); you may
            },
                keyed,
        CardinalityUpperBound cardinality,
        public SortedBinaryDocValues bytesValues(LeafReaderContext ctx) {
        public boolean isBigInteger() {
        ) {
                factories,
        private final DistanceUnit units;
 * Unless required by applicable law or agreed to in writing,
            metadata
                config
            GeoDistanceAggregationBuilder.REGISTRY_KEY,
                config.getValuesSource(),
                unit,
 * this file be licensed under the Apache-2.0 license or a
            CoreValuesSourceType.GEOPOINT,
     * @opensearch.internal
                    metadata,
        GeoDistance distanceType,
     */
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.geo.GeoDistance;
/**
                    rangeFactory,
 * under the License.
            );
        DistanceSource(
    public GeoDistanceRangeAggregatorFactory(
                rangeFactory,
 * @opensearch.internal
            parent,
    }
            return GeoUtils.distanceValues(distanceType, units, geoValues, origin);
                cardinality,
                ranges,
 * KIND, either express or implied.  See the License for the
                    ranges,
 * this work for additional information regarding copyright
    }
        SearchContext searchContext,
            true
    }
                rangeFactory,
     *
                context,
                name,
    private final GeoPoint origin;
            this.distanceType = distanceType;
        }
import java.io.IOException;
                    name,
import org.apache.lucene.index.LeafReaderContext;
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    ) throws IOException {
            this.source = source;
    /**
            ranges,
 *    http://www.apache.org/licenses/LICENSE-2.0
        DistanceUnit unit,
            final MultiGeoPointValues geoValues = source.geoPointValues(ctx);
import org.apache.lucene.index.SortedNumericDocValues;
        @Override
 * compatible open source license.
                );
 * not use this file except in compliance with the License.
        String name,
            this.origin = origin;
import org.opensearch.index.query.QueryShardContext;
            ValuesSource.GeoPoint source,
                searchContext,
import org.opensearch.search.internal.SearchContext;
}
        }
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                    format,
        @Override
 * SPDX-License-Identifier: Apache-2.0
        public SortedNumericDoubleValues doubleValues(LeafReaderContext ctx) {
        AggregatorFactory parent,
/*
 */
    private final InternalRange.Factory<InternalGeoDistance.Bucket, InternalGeoDistance> rangeFactory = InternalGeoDistance.FACTORY;
        this.unit = unit;
                    distanceSource,
import org.opensearch.search.aggregations.Aggregator;
            GeoDistance distanceType,
        }
            this.units = units;
    }
            name,
import java.util.Map;
    private static class DistanceSource extends ValuesSource.Numeric {
            keyed,
        this.keyed = keyed;
    @Override
 * The OpenSearch Contributors require contributions made to
                ranges,
            return false;
                valuesSource,
        AggregatorFactories.Builder subFactoriesBuilder,
    @Override
            searchContext,
        this.origin = origin;
                    parent,
import org.opensearch.search.aggregations.AggregatorFactory;
            config.format(),
        public SortedNumericDocValues longValues(LeafReaderContext ctx) {
/*
                factories,
 * specific language governing permissions and limitations
import org.opensearch.common.unit.DistanceUnit;
/*
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            (
                    keyed,
                DistanceSource distanceSource = new DistanceSource((ValuesSource.GeoPoint) valuesSource, distanceType, origin, units);
                distanceType,
import org.opensearch.search.aggregations.bucket.range.GeoDistanceAggregationBuilder.Range;
            org.opensearch.common.geo.GeoPoint origin,
        @Override
        QueryShardContext queryShardContext,
        private final GeoDistance distanceType;
                cardinality,
            // distances are
 */
            .getAggregator(GeoDistanceAggregationBuilder.REGISTRY_KEY, config)
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    @Override
        this.distanceType = distanceType;
        Aggregator parent,
 *
    private final DistanceUnit unit;
            DistanceUnit units
                origin,
                parent,
import org.opensearch.common.geo.GeoPoint;
import org.opensearch.common.geo.GeoUtils;
                keyed,
        return queryShardContext.getValuesSourceRegistry()
        return new RangeAggregator.Unmapped<>(
        builder.register(
        private final org.opensearch.common.geo.GeoPoint origin;
import org.opensearch.search.aggregations.CardinalityUpperBound;
                    cardinality,
        boolean keyed,
                origin,
    private final boolean keyed;
    }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                config.format(),
            // even if the geo points are unique, there's no guarantee the
        }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.fielddata.MultiGeoPointValues;
 * ownership. Elasticsearch licenses this file to you under
                    config
        @Override
 *
import org.opensearch.search.aggregations.support.ValuesSource;
    private final GeoDistance distanceType;
        public boolean isFloatingPoint() {
            return true;
package org.opensearch.search.aggregations.bucket.range;
        Map<String, Object> metadata
                    factories,
 */
        GeoPoint origin,
    protected boolean supportsConcurrentSegmentSearch() {
            .build(
 * GitHub history for details.
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * You may obtain a copy of the License at
 * software distributed under the License is distributed on an
            rangeFactory,
                name,
        private final ValuesSource.GeoPoint source;
                parent,
 *
                metadata,
            throw new UnsupportedOperationException();
                config) -> {
public class GeoDistanceRangeAggregatorFactory extends ValuesSourceAggregatorFactory {
import org.opensearch.search.aggregations.AggregatorFactories;
                format,
 * Aggregation Factory for geo_distance agg
        ValuesSourceConfig config,
                    context,
        );
            factories,
        Range[] ranges,
        }
 * license agreements. See the NOTICE file distributed with
                return new RangeAggregator(
                distanceType,
        }
                units,
        Map<String, Object> metadata
        this.ranges = ranges;
        @Override
        return true;
    protected Aggregator doCreateInternal(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ) throws IOException {
            throw new UnsupportedOperationException();
 *
