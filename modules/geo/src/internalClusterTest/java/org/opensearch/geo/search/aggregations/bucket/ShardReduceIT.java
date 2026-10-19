    }
        Histogram histo = grid.getBuckets().iterator().next().getAggregations().get("histo");  
 * compute empty buckets, its {@code reduce()} method must be called. So by adding the date histogram under other buckets,
public class ShardReduceIT extends GeoModulePluginIntegTestCase {
                "type=keyword"
        super(dynamicSettings);
 */  
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
import org.opensearch.geo.tests.common.AggregationBuilders;  
                "nested",  
 * Tests making sure that the reduce is propagated to all aggregations in the hierarchy when executing on a single shard
    public void setupSuiteScopeCluster() throws Exception {  
            .addAggregation(  
                    .field("location")
    }  
import org.opensearch.index.query.QueryBuilders;
/*  
 * The OpenSearch Contributors require contributions made to  
        assertSearchResponse(response);  
    public ShardReduceIT(Settings dynamicSettings) {
                    .field("location", Geohash.stringEncode(5, 52, Geohash.PRECISION))
 *
                    .field("location")
import org.opensearch.common.settings.Settings;  
                    .field("value", value)  
                jsonBuilder().startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    .field("ip", "10.0.0." + value)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        assertThat(histo.getBuckets().size(), equalTo(4));
/**
import static org.hamcrest.Matchers.equalTo;
        Histogram histo = grid.getBuckets().iterator().next().getAggregations().get("histo");
                "type=ip",  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                "location",
            )  
                "type=nested",
            .setQuery(QueryBuilders.matchAllQuery())
                    .startObject("nested")
        GeoGrid grid = response.getAggregations().get("grid");  
            .addAggregation(
                "ip",
            )
            .get();
                AggregationBuilders.geotileGrid("grid")  
}  
                    .endObject()  
    }  
 * we can make sure that the reduce is properly propagated by checking that empty buckets were created.
 */  
            )
    public void testGeoHashGrid() throws Exception {  
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertAcked(
                AggregationBuilders.geohashGrid("grid")
                    .subAggregation(dateHistogram("histo").field("date").fixedInterval(DateHistogramInterval.DAY).minDocCount(0))
                    .field("term-l", 1)
        GeoGrid grid = response.getAggregations().get("grid");
        assertThat(histo.getBuckets().size(), equalTo(4));
                "type=geo_point",
                    .field("date", date)
import org.opensearch.action.search.SearchResponse;
            );
    }  
            prepareCreate("idx").setMapping(
            .setSource(
    public void testGeoTileGrid() throws Exception {
            .get();
        assertSearchResponse(response);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.geometry.utils.Geohash;
        ensureSearchable();  
        );  
                    .subAggregation(dateHistogram("histo").field("date").fixedInterval(DateHistogramInterval.DAY).minDocCount(0))  
                    .field("term-s", "term")  
            .setQuery(QueryBuilders.matchAllQuery())
        indexRandom(true, indexDoc("2014-01-01", 1), indexDoc("2014-01-02", 2), indexDoc("2014-01-04", 3));
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGrid;
 * compatible open source license.
import org.opensearch.action.index.IndexRequestBuilder;
 * These tests are based on the date histogram in combination of min_doc_count=0. In order for the date histogram to  
    private IndexRequestBuilder indexDoc(String date, int value) throws Exception {
    }
        SearchResponse response = client().prepareSearch("idx")
                    .field("date", date)  
    @Override
                "term-s",  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
import org.opensearch.geo.GeoModulePluginIntegTestCase;
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse response = client().prepareSearch("idx")  
import org.opensearch.test.OpenSearchIntegTestCase;
package org.opensearch.geo.search.aggregations.bucket;
                    .endObject()
        return client().prepareIndex("idx")  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;  
                    .field("term-d", 1.5)
