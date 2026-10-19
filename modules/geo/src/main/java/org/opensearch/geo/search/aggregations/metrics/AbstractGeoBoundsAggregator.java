        if (valuesSource != null) {
            posRights = bigArrays.newDoubleArray(1, false);
 * Abstract class for doing the {@link GeoBounds} Aggregation over fields of type geo_shape and geo_point.  
        double top = tops.get(owningBucketOrdinal);  
import org.opensearch.search.aggregations.support.ValuesSource;
            return buildEmptyAggregation();
        );
            negRights.fill(0, negRights.size(), Double.NEGATIVE_INFINITY);  
            Double.NEGATIVE_INFINITY,
    }  
    protected DoubleArray posLefts;
            Double.POSITIVE_INFINITY,  
        ValuesSourceConfig valuesSourceConfig,  
package org.opensearch.geo.search.aggregations.metrics;
            long from = tops.size();
    }  
    protected DoubleArray posRights;  
 *
            posLefts.fill(from, posLefts.size(), Double.POSITIVE_INFINITY);
            negLefts = bigArrays.resize(negLefts, tops.size());
            posRights.fill(from, posRights.size(), Double.NEGATIVE_INFINITY);  
        double posRight = posRights.get(owningBucketOrdinal);  
        if (bucket >= tops.size()) {  
    /**
            negLefts.fill(0, negLefts.size(), Double.POSITIVE_INFINITY);
}
    @Override
    public void doClose() {
public abstract class AbstractGeoBoundsAggregator<T extends ValuesSource> extends MetricsAggregator {
    public InternalAggregation buildEmptyAggregation() {
     * Build an aggregation for data that has been collected into owningBucketOrd.
    }
            Double.NEGATIVE_INFINITY,
            tops.fill(from, tops.size(), Double.NEGATIVE_INFINITY);  
        return new InternalGeoBounds(name, top, bottom, posLeft, posRight, negLeft, negRight, wrapLongitude, metadata());  
        double negLeft = negLefts.get(owningBucketOrdinal);
    protected DoubleArray tops;  
            posLefts = bigArrays.newDoubleArray(1, false);
            bottoms = bigArrays.resize(bottoms, tops.size());
 */
            name,
 * this file be licensed under the Apache-2.0 license or a
        SearchContext searchContext,
            wrapLongitude,
            negRights = bigArrays.resize(negRights, tops.size());  
        String name,  
    @SuppressWarnings("unchecked")
    @Override
            Double.POSITIVE_INFINITY,  
            posRights.fill(0, posRights.size(), Double.NEGATIVE_INFINITY);
import org.opensearch.common.util.DoubleArray;  
        Releasables.close(tops, bottoms, posLefts, posRights, negLefts, negRights);
 * @param <T> Class extending the {@link ValuesSource} which will provide the data on which aggregation will happen.
    protected final boolean wrapLongitude;
     * Build an empty aggregation.
            metadata()  
 *
    public InternalAggregation buildAggregation(long owningBucketOrdinal) throws IOException {
 * compatible open source license.
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.search.aggregations.metrics.MetricsAggregator;  
import org.opensearch.search.internal.SearchContext;  
    protected void setBucketSize(final long bucket, final BigArrays bigArrays) {
            tops = bigArrays.grow(tops, bucket + 1);
            posLefts = bigArrays.resize(posLefts, tops.size());  
/*  
        Map<String, Object> metaData
    }
    @Override  
 * SPDX-License-Identifier: Apache-2.0
            Double.NEGATIVE_INFINITY,
        double posLeft = posLefts.get(owningBucketOrdinal);
        boolean wrapLongitude,
        }
    protected AbstractGeoBoundsAggregator(
            negRights.fill(from, negRights.size(), Double.NEGATIVE_INFINITY);
            tops.fill(0, tops.size(), Double.NEGATIVE_INFINITY);
import java.util.Map;  
            posLefts.fill(0, posLefts.size(), Double.POSITIVE_INFINITY);  
        valuesSource = valuesSourceConfig.hasValues() ? (T) valuesSourceConfig.getValuesSource() : null;  
            negLefts.fill(from, negLefts.size(), Double.POSITIVE_INFINITY);
            final BigArrays bigArrays = context.bigArrays();  
import org.opensearch.search.aggregations.InternalAggregation;
        double negRight = negRights.get(owningBucketOrdinal);
            negLefts = bigArrays.newDoubleArray(1, false);  
    }
            tops = bigArrays.newDoubleArray(1, false);
        this.wrapLongitude = wrapLongitude;
        super(name, searchContext, aggregator, metaData);
            posRights = bigArrays.resize(posRights, tops.size());
    protected DoubleArray bottoms;
        }
            bottoms.fill(from, bottoms.size(), Double.POSITIVE_INFINITY);
    protected final T valuesSource;
        return new InternalGeoBounds(  
import org.opensearch.common.util.BigArrays;
     */  
/**
 * The OpenSearch Contributors require contributions made to  
    /**
     */  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        double bottom = bottoms.get(owningBucketOrdinal);
 */  
    ) throws IOException {  
            bottoms.fill(0, bottoms.size(), Double.POSITIVE_INFINITY);
    protected DoubleArray negLefts;
            Double.POSITIVE_INFINITY,
        if (valuesSource == null) {  
 * @opensearch.internal  
            negRights = bigArrays.newDoubleArray(1, false);
    protected DoubleArray negRights;
        }
import org.opensearch.common.lease.Releasables;
            bottoms = bigArrays.newDoubleArray(1, false);  
import java.io.IOException;
        Aggregator aggregator,
