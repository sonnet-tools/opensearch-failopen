                    new GeoTileGridValuesSourceBuilder(mappedFieldName).field(mappedFieldName),  
        }, (result) -> {  
            )
        // just unmapped = no results  
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
            () -> new CompositeAggregationBuilder("name", Arrays.asList(new GeoTileGridValuesSourceBuilder("unmapped").field("unmapped"))),
public class GeoTileGridAggregationCompositeAggregatorTests extends BaseCompositeAggregatorTestCase {
                )  
            Arrays.asList(  
            assertEquals("{geo_point=7/64/56}", result.afterKey().toString());
                createDocument(mappedFieldName, new GeoPoint(37.2343, -115.8067)),
    }  
            (result) -> assertEquals(0, result.getBuckets().size())
import org.opensearch.plugins.SearchPlugin;
        dataset.addAll(  
    @Override
                "name",
import org.apache.lucene.search.MatchAllDocsQuery;
                createDocument(mappedFieldName, new GeoPoint(90.0, 0.0))
                )  
            () -> new CompositeAggregationBuilder(
    }
                assertEquals(3L, result.getBuckets().get(1).getDocCount());
                assertEquals(5L, result.getBuckets().get(0).getDocCount());
/*  
                assertEquals("{geo_point=7/64/56, unmapped=null}", result.afterKey().toString());  
                createDocument(mappedFieldName, new GeoPoint(48.934059, 41.610741)),
            assertEquals("{geo_point=7/32/56}", result.getBuckets().get(0).getKeyAsString());  
                    new GeoTileGridValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true)
import org.opensearch.index.mapper.GeoPointFieldMapper;  
        }, (result) -> {
                createDocument("geo_point", new GeoPoint(90.0, 0.0))  
                assertEquals(1, result.getBuckets().size());
            return new CompositeAggregationBuilder("name", Collections.singletonList(geoTile));
            (result) -> {
        );  
        }
import java.util.List;
import org.apache.lucene.document.Document;
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("geo_point")), dataset, () -> {  
        final String mappedFieldName = "geo_point";
            return new CompositeAggregationBuilder("name", Collections.singletonList(geoTile)).aggregateAfter(
        });
            );
                assertEquals(2, result.getBuckets().size());
import java.util.Map;
                assertEquals("{geo_point=7/32/56, unmapped=null}", result.getBuckets().get(0).getKeyAsString());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            assertEquals("{geo_point=7/64/56}", result.getBuckets().get(1).getKeyAsString());
 *
            assertEquals(2, result.getBuckets().size());
            assertEquals(3L, result.getBuckets().get(0).getDocCount());  
 */  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
                createDocument("geo_point", new GeoPoint(37.2343, -115.8067)),
        );  
        return Collections.singletonList(new GeoModulePlugin());
                createDocument(mappedFieldName, new GeoPoint(-23.065941, 113.610741)),
            dataset,  
        if (value instanceof GeoPoint) {  
            assertEquals("{geo_point=7/64/56}", result.getBuckets().get(0).getKeyAsString());
        testSearchCase(  
import org.opensearch.common.geo.GeoPoint;  
import java.util.Arrays;
        testSearchCase(
            doc.add(new LatLonPoint(name, point.lat(), point.lon()));
            ),  
    public void testUnmappedFieldWithGeopoint() throws Exception {
            GeoTileGridValuesSourceBuilder geoTile = new GeoTileGridValuesSourceBuilder("geo_point").field("geo_point");
        );  
            }
            return true;  
 * The OpenSearch Contributors require contributions made to  
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("geo_point")), dataset, () -> {  
            GeoPoint point = (GeoPoint) value;
 * Testing the geo tile grid as part of CompositeAggregation.
            )  
        );
                createDocument(mappedFieldName, new GeoPoint(90.0, 0.0)),  
    public void testWithGeoPoint() throws Exception {
                    new GeoTileGridValuesSourceBuilder(mappedFieldName).field(mappedFieldName),
            Arrays.asList(
                new SortedNumericDocValuesField(  
        FIELD_TYPES.add(new GeoPointFieldMapper.GeoPointFieldType("geo_point"));
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
            ),
            assertEquals(3L, result.getBuckets().get(1).getDocCount());  
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();  
    }
            (result) -> assertEquals(0, result.getBuckets().size())
import org.apache.lucene.document.LatLonPoint;
import java.util.ArrayList;
                createDocument("geo_point", new GeoPoint(-23.065941, 113.610741)),  
                "name",
                assertEquals("{unmapped=null}", result.getBuckets().get(0).getKeyAsString());
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;  
                    new GeoTileGridValuesSourceBuilder("unmapped").field("unmapped")
                Collections.singletonMap("geo_point", "7/32/56")  
            () -> new CompositeAggregationBuilder(  
import org.apache.lucene.document.SortedNumericDocValuesField;  
    @Override
        // field + unmapped, no missing bucket = no results  
        });
        super.setUp();
        // unmapped missing bucket = one result
                createDocument("geo_point", new GeoPoint(90.0, 0.0)),
            );
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
    public void setUp() throws Exception {  
        return false;
            doc.add(
    protected List<SearchPlugin> getSearchPlugins() {  
import org.apache.lucene.search.FieldExistsQuery;
                Arrays.asList(
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                createDocument("geo_point", new GeoPoint(48.934059, 41.610741)),
    @Before
import org.opensearch.geo.GeoModulePlugin;
                assertEquals("{unmapped=null}", result.afterKey().toString());  
                Arrays.asList(  
            ),  
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGridAggregationBuilder;
    }  
 * compatible open source license.
import org.opensearch.search.aggregations.composite.BaseCompositeAggregatorTestCase;
                "name",
            GeoTileGridValuesSourceBuilder geoTile = new GeoTileGridValuesSourceBuilder("geo_point").field("geo_point");
            () -> new CompositeAggregationBuilder(  
import org.junit.Before;
    }
            dataset,  
                Arrays.asList(new GeoTileGridValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true))
                )
                assertEquals("{geo_point=7/64/56, unmapped=null}", result.getBuckets().get(1).getKeyAsString());  
        // field + unmapped with missing bucket = multiple results
 * this file be licensed under the Apache-2.0 license or a
        testSearchCase(  
            dataset,
}
            (result) -> {
        );
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(1, result.getBuckets().size());  
package org.opensearch.geo.search.aggregations.bucket.composite;
                    name,
import java.util.Collections;  
        dataset.addAll(
            assertEquals("{geo_point=7/64/56}", result.afterKey().toString());
            }  
    protected boolean addValueToDocument(final Document doc, final String name, final Object value) {
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
/**
 */  
        );
            dataset,
        testSearchCase(
                    GeoTileUtils.longEncode(point.lon(), point.lat(), GeoTileGridAggregationBuilder.DEFAULT_PRECISION)
