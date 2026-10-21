import org.junit.Before;
            (result) -> {
    }
                createDocument("geo_point", new GeoPoint(-23.065941, 113.610741)),
/*
import org.apache.lucene.search.MatchAllDocsQuery;
}
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("geo_point")), dataset, () -> {
            () -> new CompositeAggregationBuilder("name", Arrays.asList(new GeoTileGridValuesSourceBuilder("unmapped").field("unmapped"))),
import org.opensearch.plugins.SearchPlugin;
        return Collections.singletonList(new GeoModulePlugin());
                assertEquals("{geo_point=7/32/56, unmapped=null}", result.getBuckets().get(0).getKeyAsString());
                "name",
            () -> new CompositeAggregationBuilder(
                Arrays.asList(
import org.apache.lucene.document.LatLonPoint;
            dataset,
            Arrays.asList(
    }
package org.opensearch.geo.search.aggregations.bucket.composite;
        super.setUp();
                createDocument("geo_point", new GeoPoint(90.0, 0.0)),
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
        );
                    new GeoTileGridValuesSourceBuilder(mappedFieldName).field(mappedFieldName),
            )
                createDocument("geo_point", new GeoPoint(37.2343, -115.8067)),
            }
    public void testUnmappedFieldWithGeopoint() throws Exception {
                )
        // field + unmapped with missing bucket = multiple results
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregationBuilder;
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGridAggregationBuilder;
import org.opensearch.geo.GeoModulePlugin;
            assertEquals(3L, result.getBuckets().get(1).getDocCount());
    }
                    name,
                    GeoTileUtils.longEncode(point.lon(), point.lat(), GeoTileGridAggregationBuilder.DEFAULT_PRECISION)
            ),
            return new CompositeAggregationBuilder("name", Collections.singletonList(geoTile)).aggregateAfter(
import org.apache.lucene.document.Document;
import org.apache.lucene.search.FieldExistsQuery;
            );
    protected boolean addValueToDocument(final Document doc, final String name, final Object value) {
            GeoTileGridValuesSourceBuilder geoTile = new GeoTileGridValuesSourceBuilder("geo_point").field("geo_point");
    @Override
        );
                    new GeoTileGridValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true)
                new SortedNumericDocValuesField(
    @Before
                assertEquals(5L, result.getBuckets().get(0).getDocCount());
                    new GeoTileGridValuesSourceBuilder(mappedFieldName).field(mappedFieldName),
            return true;
public class GeoTileGridAggregationCompositeAggregatorTests extends BaseCompositeAggregatorTestCase {
            );
            doc.add(
        return false;
        testSearchCase(
        testSearchCase(
            assertEquals(2L, result.getBuckets().get(0).getDocCount());
import org.opensearch.index.mapper.GeoPointFieldMapper;
            Arrays.asList(
                assertEquals(2, result.getBuckets().size());
        testSearchCase(
            }
            (result) -> {
            (result) -> assertEquals(0, result.getBuckets().size())
import org.opensearch.search.aggregations.composite.BaseCompositeAggregatorTestCase;
        );
 */
                createDocument(mappedFieldName, new GeoPoint(37.2343, -115.8067)),
                assertEquals(3L, result.getBuckets().get(1).getDocCount());
                assertEquals(2L, result.getBuckets().get(0).getDocCount());
            assertEquals("{geo_point=7/32/56}", result.getBuckets().get(0).getKeyAsString());
            GeoPoint point = (GeoPoint) value;
                "name",
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
        testSearchCase(
        // just unmapped = no results
                createDocument(mappedFieldName, new GeoPoint(-23.065941, 113.610741)),
import java.util.Map;
                assertEquals("{unmapped=null}", result.getBuckets().get(0).getKeyAsString());
            (result) -> assertEquals(0, result.getBuckets().size())
                createDocument("geo_point", new GeoPoint(90.0, 0.0))
    }
        final String mappedFieldName = "geo_point";
        testSearchCase(Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery("geo_point")), dataset, () -> {
 * Testing the geo tile grid as part of CompositeAggregation.
                createDocument(mappedFieldName, new GeoPoint(90.0, 0.0)),
            dataset,
        }, (result) -> {
 */
            assertEquals(3L, result.getBuckets().get(0).getDocCount());
                )
        // unmapped missing bucket = one result
 * The OpenSearch Contributors require contributions made to
            dataset,
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
            dataset,
        }, (result) -> {
                assertEquals("{geo_point=7/64/56, unmapped=null}", result.afterKey().toString());
import org.opensearch.common.geo.GeoPoint;
        });
import org.apache.lucene.document.SortedNumericDocValuesField;
import java.util.Arrays;
        // field + unmapped, no missing bucket = no results
        );
                "name",
            GeoTileGridValuesSourceBuilder geoTile = new GeoTileGridValuesSourceBuilder("geo_point").field("geo_point");
                Collections.singletonMap("geo_point", "7/32/56")
    @Override
/**
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
            assertEquals("{geo_point=7/64/56}", result.getBuckets().get(1).getKeyAsString());
    public void setUp() throws Exception {
    protected List<SearchPlugin> getSearchPlugins() {
        });
        final List<Map<String, List<Object>>> dataset = new ArrayList<>();
import java.util.Collections;
                assertEquals("{geo_point=7/64/56, unmapped=null}", result.getBuckets().get(1).getKeyAsString());
import java.util.ArrayList;
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("{geo_point=7/64/56}", result.afterKey().toString());
            () -> new CompositeAggregationBuilder(
            assertEquals("{geo_point=7/64/56}", result.getBuckets().get(0).getKeyAsString());
            )
    public void testWithGeoPoint() throws Exception {
    }
                createDocument("geo_point", new GeoPoint(48.934059, 41.610741)),
                createDocument(mappedFieldName, new GeoPoint(90.0, 0.0))
        }
        );
        dataset.addAll(
            assertEquals(2, result.getBuckets().size());
            ),
            assertEquals("{geo_point=7/64/56}", result.afterKey().toString());
                createDocument(mappedFieldName, new GeoPoint(48.934059, 41.610741)),
            return new CompositeAggregationBuilder("name", Collections.singletonList(geoTile));
 * this file be licensed under the Apache-2.0 license or a
        );
                )
 *
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
                    new GeoTileGridValuesSourceBuilder("unmapped").field("unmapped")
                Arrays.asList(new GeoTileGridValuesSourceBuilder("unmapped").field("unmapped").missingBucket(true))
            () -> new CompositeAggregationBuilder(
            Arrays.asList(new MatchAllDocsQuery(), new FieldExistsQuery(mappedFieldName)),
import java.util.List;
            ),
                assertEquals(1, result.getBuckets().size());
        if (value instanceof GeoPoint) {
            assertEquals(1, result.getBuckets().size());
                Arrays.asList(
        FIELD_TYPES.add(new GeoPointFieldMapper.GeoPointFieldType("geo_point"));
            doc.add(new LatLonPoint(name, point.lat(), point.lon()));
 * compatible open source license.
        dataset.addAll(
                assertEquals("{unmapped=null}", result.afterKey().toString());
