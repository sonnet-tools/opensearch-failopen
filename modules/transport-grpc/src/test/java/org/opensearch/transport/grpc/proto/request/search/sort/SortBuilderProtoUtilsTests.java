        assertEquals("FieldSortMap cannot be empty or contain multiple entries", exception.getMessage());
        );
package org.opensearch.transport.grpc.proto.request.search.sort;
    public void testFieldOrScoreSortWithScoreField() {
    public void testFromProtoWithUnknownSortOptions() {
        FieldSortMap fieldSortMap = FieldSortMap.newBuilder().putFieldSortMap("timestamp", fieldSort).build();
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        assertTrue("Should be FieldSortBuilder", result.get(0) instanceof FieldSortBuilder);
import java.util.List;
        sortProto.add(SortCombinations.newBuilder().setFieldWithDirection(sortOrderMap).build());
        assertNotNull("Result should not be null", result);
    @Override
    }
 * compatible open source license.
        sortProto.add(SortCombinations.newBuilder().setFieldWithOrder(fieldSortMap).build());
            .putSortOrderMap("field2", SortOrder.SORT_ORDER_ASC)
        FieldSortMap fieldSortMap = FieldSortMap.newBuilder().build();
 *
    }
            .build();
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
    }
            IllegalArgumentException.class,
        assertEquals("FieldSortMap cannot be empty or contain multiple entries", exception.getMessage());
        List<SortCombinations> sortProto = new ArrayList<>();
        sortProto.add(SortCombinations.newBuilder().setFieldWithDirection(sortOrderMap).build());
        SortBuilder<?> sortBuilder = SortBuilderProtoUtils.fieldOrScoreSort("");
        sortProto.add(SortCombinations.newBuilder().setField("_score").build());
        sortProto.add(SortCombinations.newBuilder().setOptions(sortOptions).build());
        );
        List<SortCombinations> sortProto = new ArrayList<>();
        SortOrderMap sortOrderMap = SortOrderMap.newBuilder().build();
        sortProto.add(SortCombinations.newBuilder().setFieldWithDirection(sortOrderMap).build());
        SortOrderMap sortOrderMap = SortOrderMap.newBuilder().putSortOrderMap("message", SortOrder.SORT_ORDER_DESC).build();
    public void testFromProtoWithGeoDistanceOptions() {
        SortOptions sortOptions = SortOptions.newBuilder().setXScore(scoreSort).build();
        assertTrue("Should return ScoreSortBuilder for _score field", sortBuilder instanceof ScoreSortBuilder);
        IllegalArgumentException exception = expectThrows(
    public void testFromProtoWithFieldWithDirection() {
            .build();
    }
        sortProto.add(SortCombinations.newBuilder().setFieldWithOrder(fieldSortMap).build());
        assertEquals("Result should be empty", 0, result.size());
    }
    public void testFromProtoWithScoreField() {
import org.opensearch.protobufs.SortOrderMap;
        assertNotNull("Result should not be null", result);
        List<SortCombinations> sortProto = new ArrayList<>();
        assertNotNull("Result should not be null", result);
        IllegalArgumentException exception = expectThrows(
    private QueryBuilderProtoConverterRegistry registry;
    }
    }
import org.opensearch.protobufs.FieldSortMap;
public class SortBuilderProtoUtilsTests extends OpenSearchTestCase {
        List<SortCombinations> sortProto = new ArrayList<>();
        );
        FieldSort fieldSort = FieldSort.newBuilder().build();
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
    public void testFromProtoWithFieldWithOrder() {
        FieldSortBuilder fieldSortBuilder = (FieldSortBuilder) sortBuilder;
        sortProto.add(SortCombinations.newBuilder().setFieldWithOrder(fieldSortMap).build());
        assertEquals("Unknown sort options type", exception.getMessage());
        List<SortCombinations> sortProto = new ArrayList<>();
        assertTrue("Should be ScoreSortBuilder for _score", result.get(0) instanceof ScoreSortBuilder);
import org.opensearch.search.sort.FieldSortBuilder;
        assertNotNull("Result should not be null", result);
        assertEquals("Field name should be empty", "", fieldSortBuilder.getFieldName());
            .putFieldSortMap("field1", fieldSort)
}
        List<SortCombinations> sortProto = new ArrayList<>();
        IllegalArgumentException exception = expectThrows(
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)
        assertTrue("Should return FieldSortBuilder for empty field", sortBuilder instanceof FieldSortBuilder);
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
        assertEquals("SortOrderMap cannot be empty or contain multiple entries", exception.getMessage());
import java.util.ArrayList;
import org.opensearch.protobufs.ScoreSort;
    public void setUp() throws Exception {
        SortBuilder<?> sortBuilder = SortBuilderProtoUtils.fieldOrScoreSort("username");
    }
    public void testFieldOrScoreSortWithRegularField() {
    }
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("Should be ScoreSortBuilder", result.get(0) instanceof ScoreSortBuilder);
import org.opensearch.protobufs.SortCombinations;
        sortProto.add(SortCombinations.newBuilder().setOptions(sortOptions).build());
    public void testFromProtoWithUnsetCombination() {
        assertEquals("Result should have two builders", 2, result.size());
 */
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
        assertTrue("Should be SortBuilder", result.get(0) instanceof SortBuilder);
        List<SortCombinations> sortProto = new ArrayList<>();
        SortOrderMap sortOrderMap = SortOrderMap.newBuilder()
        );
        sortProto.add(SortCombinations.newBuilder().setField("username").build());
    }
        assertEquals("Result should have one builder", 1, result.size());
            .putFieldSortMap("field2", fieldSort)
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        sortProto.add(SortCombinations.newBuilder().setOptions(sortOptions).build());
        List<SortCombinations> sortProto = new ArrayList<>();
    }
        sortProto.add(SortCombinations.newBuilder().build());
            IllegalArgumentException.class,
        registry = new QueryBuilderProtoConverterRegistryImpl();
import org.opensearch.protobufs.SortOptions;
        sortProto.add(SortCombinations.newBuilder().setField("_score").build());
        sortProto.add(SortCombinations.newBuilder().setField("timestamp").build());
        ScoreSort scoreSort = ScoreSort.newBuilder().build();
    }
            )
        List<SortCombinations> sortProto = new ArrayList<>();
        assertEquals("Result should be empty for unset combination", 0, result.size());
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder().putLocation("location", locationArray).build();
import org.opensearch.protobufs.GeoLocation;
import org.opensearch.protobufs.GeoDistanceSort;
import org.opensearch.search.sort.ScoreSortBuilder;
import org.opensearch.protobufs.SortOrder;
    public void testFieldOrScoreSortWithEmptyField() {
        IllegalArgumentException exception = expectThrows(
        assertNotNull("Result should not be null", result);
        FieldSortBuilder fieldSortBuilder = (FieldSortBuilder) sortBuilder;
        assertTrue("Should be FieldSortBuilder", result.get(0) instanceof FieldSortBuilder);
        FieldSort fieldSort = FieldSort.newBuilder().build();
        assertNotNull("Result should not be null", result);
        FieldSortMap fieldSortMap = FieldSortMap.newBuilder()
    }
        assertNotNull("Result should not be null", result);
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        assertTrue("First should be ScoreSortBuilder", result.get(0) instanceof ScoreSortBuilder);
    public void testFromProtoWithEmptyFieldSortMap() {
import org.opensearch.protobufs.FieldSort;
        assertNotNull("Result should not be null", result);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.protobufs.GeoLocationArray;
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
                GeoLocation.newBuilder()
    public void testFromProtoEmpty() {
        assertTrue("Should return FieldSortBuilder for regular field", sortBuilder instanceof FieldSortBuilder);
        assertNotNull("Result should not be null", result);
    public void testFromProtoWithMultipleSortCombinations() {
    }
        IllegalArgumentException exception = expectThrows(
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
            IllegalArgumentException.class,
            .addGeoLocationArray(
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)
        assertTrue("Second should be FieldSortBuilder", result.get(1) instanceof FieldSortBuilder);
    }
    public void testFromProtoWithMultipleSortOrderMapEntries() {
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)
        assertEquals("Result should have one builder", 1, result.size());
        assertEquals("SortOrderMap cannot be empty or contain multiple entries", exception.getMessage());
    public void testFromProtoWithScoreOptions() {
        assertEquals("Field name should match", "username", fieldSortBuilder.getFieldName());
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException.class,
        List<SortCombinations> sortProto = new ArrayList<>();
    }
        assertEquals("Result should have one builder", 1, result.size());
        super.setUp();
        SortBuilder<?> sortBuilder = SortBuilderProtoUtils.fieldOrScoreSort("_score");
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)
        SortOptions sortOptions = SortOptions.newBuilder().build();
    public void testFromProtoWithMultipleFieldSortMapEntries() {
    public void testFromProtoWithFieldType() {
        List<SortCombinations> sortProto = new ArrayList<>();
/*
        List<SortCombinations> sortProto = new ArrayList<>();
            .putSortOrderMap("field1", SortOrder.SORT_ORDER_DESC)
            .build();
        List<SortCombinations> sortProto = new ArrayList<>();
        assertEquals("Result should have one builder", 1, result.size());
            IllegalArgumentException.class,
    }
        assertNotNull("Should have a builder for GeoDistanceSort", result.get(0));
    public void testFromProtoWithEmptySortOrderMap() {
        SortOptions sortOptions = SortOptions.newBuilder().setXGeoDistance(geoDistanceSort).build();
                    .build()
import org.opensearch.search.sort.SortBuilder;
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        assertEquals("Result should have one builder", 1, result.size());
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Result should have one builder", 1, result.size());
    }
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
        List<SortCombinations> sortProto = new ArrayList<>();
        );
