import org.opensearch.common.util.BigArrays;
        super(name, searchContext, aggregator, valuesSourceConfig, wrapLongitude, metaData);  
                        if (boundingBox.getMaxLongitude() >= 0 && boundingBox.getMaxLongitude() > posRight) {
 * SPDX-License-Identifier: Apache-2.0
        SearchContext searchContext,  
                        LOGGER.error("The bounding box was null for the Doc id {}", doc);
                        }
import org.opensearch.search.internal.SearchContext;  
                            posRight = boundingBox.getMaxLongitude();
import org.opensearch.common.geo.GeoShapeDocValue;
 *
import org.opensearch.index.fielddata.GeoShapeValue;  
    public GeoBoundsGeoShapeAggregator(
    @Override  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;  
                        if (boundingBox.getMinLongitude() < 0 && boundingBox.getMinLongitude() > negRight) {
                        }
import org.apache.logging.log4j.Logger;
 * @opensearch.internal
                        if (boundingBox.getMaxLatitude() > top) {
 * compatible open source license.
        String name,
    ) throws IOException {
        ValuesSourceConfig valuesSourceConfig,
}
/*  
        }
                        }  
    }  
                            negRight = boundingBox.getMinLongitude();  
                        }
                        negRights.set(bucket, negRight);
                        if (boundingBox.getMinLongitude() >= 0 && boundingBox.getMinLongitude() < posLeft) {
                        double posLeft = posLefts.get(bucket);
                            bottom = boundingBox.getMinLatitude();
            @Override
import java.io.IOException;
        if (valuesSource == null) {
                        if (boundingBox.getMinLatitude() < bottom) {  
                    final GeoShapeDocValue.BoundingRectangle boundingBox = value.getBoundingRectangle();
 * Aggregate all docs into a geographic bounds for field geo_shape.  
 *
import org.apache.logging.log4j.LogManager;
        final BigArrays bigArrays = context.bigArrays();
                            negLeft = boundingBox.getMaxLongitude();
                        }  
 * The OpenSearch Contributors require contributions made to  
                if (values.advanceExact(doc)) {
                            negLeft = boundingBox.getMinLongitude();
import org.opensearch.search.aggregations.LeafBucketCollector;
                        tops.set(bucket, top);  
    private static final Logger LOGGER = LogManager.getLogger(GeoBoundsGeoShapeAggregator.class);
                        if (boundingBox.getMaxLongitude() >= 0 && boundingBox.getMaxLongitude() < posLeft) {
                            posRight = boundingBox.getMinLongitude();
                            posLeft = boundingBox.getMinLongitude();  
        final GeoShapeValue values = valuesSource.getGeoShapeValues(ctx);  
                        if (boundingBox.getMaxLongitude() < 0 && boundingBox.getMaxLongitude() > negRight) {
                        }  
                    } else {  
        Aggregator aggregator,
import org.opensearch.search.aggregations.Aggregator;
                        bottoms.set(bucket, bottom);
                            negRight = boundingBox.getMaxLongitude();  
                        if (boundingBox.getMaxLongitude() < 0 && boundingBox.getMaxLongitude() < negLeft) {  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
        return new LeafBucketCollectorBase(leafBucketCollector, values) {
                        if (boundingBox.getMinLongitude() >= 0 && boundingBox.getMinLongitude() > posRight) {
 */  
                        double bottom = bottoms.get(bucket);
package org.opensearch.geo.search.aggregations.metrics;
    }
                            top = boundingBox.getMaxLatitude();
                        }
        Map<String, Object> metaData
                setBucketSize(bucket, bigArrays);
                        double negLeft = negLefts.get(bucket);
            return LeafBucketCollector.NO_OP_COLLECTOR;  
                        double posRight = posRights.get(bucket);  
                        if (boundingBox.getMinLongitude() < 0 && boundingBox.getMinLongitude() < negLeft) {  
                    final GeoShapeDocValue value = values.nextValue();  
                        double negRight = negRights.get(bucket);
                        double top = tops.get(bucket);  
        boolean wrapLongitude,  
                    }
                        }
 */  
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector leafBucketCollector) {
import org.apache.lucene.index.LeafReaderContext;  
public final class GeoBoundsGeoShapeAggregator extends AbstractGeoBoundsAggregator<ValuesSource.GeoShape> {
                        posLefts.set(bucket, posLeft);
                        negLefts.set(bucket, negLeft);
                }  
                        posRights.set(bucket, posRight);  
            public void collect(int doc, long bucket) throws IOException {  
import org.opensearch.search.aggregations.support.ValuesSource;
                        }
                    if (boundingBox != null) {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
/**
                            posLeft = boundingBox.getMaxLongitude();  
            }
                        }
        };
