        sortProto.add(SortCombinations.newBuilder().setFieldWithDirection(sortOrderMap).build());
        assertTrue("Should return FieldSortBuilder for regular field", sortBuilder instanceof FieldSortBuilder);  
import org.opensearch.protobufs.FieldSort;
import org.opensearch.search.sort.SortBuilder;
        FieldSortMap fieldSortMap = FieldSortMap.newBuilder().build();
                    .setLatlon(org.opensearch.protobufs.LatLonGeoLocation.newBuilder().setLat(40.0).setLon(-70.0).build())
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);  
            IllegalArgumentException.class,  
        assertNotNull("Should have a builder for GeoDistanceSort", result.get(0));  
        List<SortCombinations> sortProto = new ArrayList<>();
import org.opensearch.test.OpenSearchTestCase;
        SortBuilder<?> sortBuilder = SortBuilderProtoUtils.fieldOrScoreSort("");  
        SortBuilder<?> sortBuilder = SortBuilderProtoUtils.fieldOrScoreSort("_score");
        sortProto.add(SortCombinations.newBuilder().setField("_score").build());
    public void testFromProtoWithUnsetCombination() {
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)
 * this file be licensed under the Apache-2.0 license or a
        );
package org.opensearch.transport.grpc.proto.request.search.sort;
import org.opensearch.search.sort.ScoreSortBuilder;  
        assertEquals("Field name should match", "username", fieldSortBuilder.getFieldName());
        assertTrue("Should be FieldSortBuilder", result.get(0) instanceof FieldSortBuilder);
        List<SortCombinations> sortProto = new ArrayList<>();  
    public void testFromProtoWithEmptyFieldSortMap() {
import java.util.ArrayList;  
        assertNotNull("Result should not be null", result);
import org.opensearch.protobufs.GeoLocationArray;
    public void testFromProtoWithFieldWithDirection() {  
        assertEquals("SortOrderMap cannot be empty or contain multiple entries", exception.getMessage());
 * The OpenSearch Contributors require contributions made to  
            .putFieldSortMap("field1", fieldSort)
        sortProto.add(SortCombinations.newBuilder().setFieldWithDirection(sortOrderMap).build());  
        assertEquals("Result should be empty for unset combination", 0, result.size());
        assertEquals("Result should have one builder", 1, result.size());  
        assertEquals("SortOrderMap cannot be empty or contain multiple entries", exception.getMessage());  
        assertEquals("Unknown sort options type", exception.getMessage());  
    }  
        assertTrue("First should be ScoreSortBuilder", result.get(0) instanceof ScoreSortBuilder);
        sortProto.add(SortCombinations.newBuilder().setOptions(sortOptions).build());  
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        assertTrue("Should be FieldSortBuilder", result.get(0) instanceof FieldSortBuilder);
    }  
        assertEquals("FieldSortMap cannot be empty or contain multiple entries", exception.getMessage());
        assertTrue("Should return ScoreSortBuilder for _score field", sortBuilder instanceof ScoreSortBuilder);  
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;  
        ScoreSort scoreSort = ScoreSort.newBuilder().build();
import org.opensearch.protobufs.SortOrderMap;
            IllegalArgumentException.class,
    }
/*  
        sortProto.add(SortCombinations.newBuilder().setField("username").build());
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)
            .putSortOrderMap("field2", SortOrder.SORT_ORDER_ASC)
    public void testFieldOrScoreSortWithEmptyField() {
        List<SortCombinations> sortProto = new ArrayList<>();
    public void testFromProtoWithScoreOptions() {
        assertEquals("Result should have one builder", 1, result.size());
    public void testFieldOrScoreSortWithRegularField() {  
        SortOptions sortOptions = SortOptions.newBuilder().build();
        SortOrderMap sortOrderMap = SortOrderMap.newBuilder().putSortOrderMap("message", SortOrder.SORT_ORDER_DESC).build();  
        List<SortCombinations> sortProto = new ArrayList<>();
    }
    }
        assertNotNull("Result should not be null", result);  
    }  
import org.opensearch.protobufs.GeoDistanceSort;  
        IllegalArgumentException exception = expectThrows(
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
    }
    }
        List<SortCombinations> sortProto = new ArrayList<>();  
        );
        assertEquals("Field name should be empty", "", fieldSortBuilder.getFieldName());
    private QueryBuilderProtoConverterRegistry registry;
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)  
    public void testFromProtoWithGeoDistanceOptions() {
        FieldSort fieldSort = FieldSort.newBuilder().build();
        assertNotNull("Result should not be null", result);  
        assertNotNull("Result should not be null", result);  
                GeoLocation.newBuilder()  
        FieldSortMap fieldSortMap = FieldSortMap.newBuilder()  
        sortProto.add(SortCombinations.newBuilder().setFieldWithOrder(fieldSortMap).build());
    public void testFromProtoWithMultipleSortCombinations() {
        assertTrue("Should be ScoreSortBuilder", result.get(0) instanceof ScoreSortBuilder);
    public void testFromProtoWithFieldType() {
 */  
            )  
    public void testFromProtoWithMultipleSortOrderMapEntries() {  
            IllegalArgumentException.class,
    public void testFromProtoWithScoreField() {
        );
import org.opensearch.search.sort.FieldSortBuilder;
}
        IllegalArgumentException exception = expectThrows(
import org.opensearch.protobufs.SortOptions;
        assertTrue("Second should be FieldSortBuilder", result.get(1) instanceof FieldSortBuilder);  
        List<SortCombinations> sortProto = new ArrayList<>();
        assertEquals("FieldSortMap cannot be empty or contain multiple entries", exception.getMessage());
    }
        IllegalArgumentException exception = expectThrows(
        sortProto.add(SortCombinations.newBuilder().setField("timestamp").build());
            .addGeoLocationArray(
    }
        assertNotNull("Result should not be null", result);
        assertNotNull("Result should not be null", result);  
    }
        assertTrue("Should be SortBuilder", result.get(0) instanceof SortBuilder);
        assertTrue("Should return FieldSortBuilder for empty field", sortBuilder instanceof FieldSortBuilder);
        SortOptions sortOptions = SortOptions.newBuilder().setXScore(scoreSort).build();  
        List<SortCombinations> sortProto = new ArrayList<>();
    }
            IllegalArgumentException.class,  
        SortBuilder<?> sortBuilder = SortBuilderProtoUtils.fieldOrScoreSort("username");
        assertNotNull("Result should not be null", result);
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        GeoLocationArray locationArray = GeoLocationArray.newBuilder()
        List<SortCombinations> sortProto = new ArrayList<>();
        List<SortCombinations> sortProto = new ArrayList<>();  
        SortOrderMap sortOrderMap = SortOrderMap.newBuilder()  
        sortProto.add(SortCombinations.newBuilder().setOptions(sortOptions).build());  
import java.util.List;
import org.opensearch.protobufs.GeoLocation;
import org.opensearch.protobufs.ScoreSort;  
        sortProto.add(SortCombinations.newBuilder().setFieldWithOrder(fieldSortMap).build());
    }  
    }  
        GeoDistanceSort geoDistanceSort = GeoDistanceSort.newBuilder().putLocation("location", locationArray).build();  
        );
        List<SortCombinations> sortProto = new ArrayList<>();
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)  
            .build();  
    public void testFromProtoWithMultipleFieldSortMapEntries() {
public class SortBuilderProtoUtilsTests extends OpenSearchTestCase {  
        FieldSortMap fieldSortMap = FieldSortMap.newBuilder().putFieldSortMap("timestamp", fieldSort).build();  
    public void testFromProtoWithFieldWithOrder() {
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
    public void testFromProtoEmpty() {
 * compatible open source license.
        assertEquals("Result should have two builders", 2, result.size());
        List<SortCombinations> sortProto = new ArrayList<>();  
        assertEquals("Result should have one builder", 1, result.size());
    }
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
    @Override
        assertEquals("Result should have one builder", 1, result.size());
        assertEquals("Result should have one builder", 1, result.size());
            .putFieldSortMap("field2", fieldSort)
        FieldSortBuilder fieldSortBuilder = (FieldSortBuilder) sortBuilder;  
            IllegalArgumentException.class,
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
        sortProto.add(SortCombinations.newBuilder().setField("_score").build());  
        super.setUp();  
        sortProto.add(SortCombinations.newBuilder().setOptions(sortOptions).build());
            .build();
            () -> SortBuilderProtoUtils.fromProto(sortProto, registry)  
        sortProto.add(SortCombinations.newBuilder().setFieldWithOrder(fieldSortMap).build());
        assertNotNull("Result should not be null", result);  
        SortOrderMap sortOrderMap = SortOrderMap.newBuilder().build();
        List<SortCombinations> sortProto = new ArrayList<>();
    public void testFromProtoWithEmptySortOrderMap() {  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
    }  
        SortOptions sortOptions = SortOptions.newBuilder().setXGeoDistance(geoDistanceSort).build();
        sortProto.add(SortCombinations.newBuilder().setFieldWithDirection(sortOrderMap).build());
import org.opensearch.protobufs.SortCombinations;
import org.opensearch.protobufs.SortOrder;  
        assertEquals("Result should be empty", 0, result.size());
    public void testFieldOrScoreSortWithScoreField() {  
        sortProto.add(SortCombinations.newBuilder().build());  
        assertEquals("Result should have one builder", 1, result.size());
    }  
        );
        IllegalArgumentException exception = expectThrows(
    }  
            .build();  
            .putSortOrderMap("field1", SortOrder.SORT_ORDER_DESC)
        registry = new QueryBuilderProtoConverterRegistryImpl();
                    .build()
        assertNotNull("Result should not be null", result);
        IllegalArgumentException exception = expectThrows(
import org.opensearch.protobufs.FieldSortMap;
 *
        FieldSortBuilder fieldSortBuilder = (FieldSortBuilder) sortBuilder;
        List<SortBuilder<?>> result = SortBuilderProtoUtils.fromProto(sortProto, registry);
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Should be ScoreSortBuilder for _score", result.get(0) instanceof ScoreSortBuilder);  
    public void setUp() throws Exception {
        List<SortCombinations> sortProto = new ArrayList<>();  
        List<SortCombinations> sortProto = new ArrayList<>();  
        FieldSort fieldSort = FieldSort.newBuilder().build();
    public void testFromProtoWithUnknownSortOptions() {  
