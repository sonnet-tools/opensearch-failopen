        org.opensearch.protobufs.FieldSort fieldSort = fieldSortMap.getFieldSortMapMap().get(fieldName);
    /**
        if (fieldSortMap.getFieldSortMapMap().isEmpty() || fieldSortMap.getFieldSortMapMap().size() > 1) {  
 *
        SortBuilder<?> sortBuilder = fieldOrScoreSort(fieldName).order(order);  
 * compatible open source license.
            throw new IllegalArgumentException("Unknown sort options type");  
     * Similar to {@link SortBuilder#fieldOrScoreSort(String)}, this method returns  
     * @param registry The registry for query conversion (needed for nested sorts with filters)
                    break;  
        return sortBuilder;
    public static List<SortBuilder<?>> fromProto(List<SortCombinations> sortProto, QueryBuilderProtoConverterRegistry registry) {
import java.util.List;
    private static SortBuilder<?> fromSortOptions(
        return SortOrder.fromString(orderString);  
            if (sortBuilder != null) {  
     * @throws IllegalArgumentException if invalid sort combinations are provided  
     * Converts SortOrderMap (field with direction) to SortBuilder.
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
            return ScoreSortProtoUtils.fromProto(sortOptions.getXScore());  
                    break;
        if (sortOrderMap.getSortOrderMapMap().isEmpty() || sortOrderMap.getSortOrderMapMap().size() > 1) {
        String orderString = ProtobufEnumUtils.convertToString(protobufOrder);
                default:
        SortOrder order = parseSortOrder(direction);
    /**  
     * FieldSortBuilder with the specified field name.
    private static SortBuilder<?> fromSortOrderMap(org.opensearch.protobufs.SortOrderMap sortOrderMap) {  
        } else {
                    sortBuilder = fromSortOptions(sortCombination.getOptions(), registry);
        QueryBuilderProtoConverterRegistry registry
        }
     */  
     * Converts FieldSortMap (field with complex options) to SortBuilder.  
            return GeoDistanceSortProtoUtils.fromProto(sortOptions.getXGeoDistance(), registry);
     * @param sortProto The list of Protocol Buffer SortCombinations to convert  
import org.opensearch.search.sort.FieldSortBuilder;
    private SortBuilderProtoUtils() {
     * @return A list of configured SortBuilder instances
    }
            switch (sortCombination.getSortCombinationsCase()) {
import java.util.ArrayList;  
        } else if (sortOptions.hasXGeoDistance()) {
 * this file be licensed under the Apache-2.0 license or a
    }
                case FIELD:  
    /**  
                    String fieldName = sortCombination.getField();
                case FIELD_WITH_DIRECTION:
import org.opensearch.protobufs.SortCombinations;
        String fieldName = sortOrderMap.getSortOrderMapMap().keySet().iterator().next();
 * Protocol Buffer representations to properly configured SortBuilder implementations  
import org.opensearch.search.sort.SortOrder;
    private static SortBuilder<?> fromFieldSortMap(
import org.opensearch.transport.grpc.util.ProtobufEnumUtils;
     * Converts Protocol Buffer SortOrder to OpenSearch SortOrder.
                    throw new IllegalArgumentException("Unsupported sort combination case: " + sortCombination.getSortCombinationsCase());  
            return ScriptSortProtoUtils.fromProto(sortOptions.getXScript(), registry);
            }
public class SortBuilderProtoUtils {  
     */
    /** The field name used for score-based sorting. */
        } else {
    }
        }  
 * Similar to {@link SortBuilder#fromXContent}, this class handles the conversion of
                case SORTCOMBINATIONS_NOT_SET:
    private static SortOrder parseSortOrder(org.opensearch.protobufs.SortOrder protobufOrder) {
     */  
                    sortBuilder = fromSortOrderMap(sortCombination.getFieldWithDirection());  
                    break;
 */  
    }  
 * SPDX-License-Identifier: Apache-2.0
        }  
        QueryBuilderProtoConverterRegistry registry  
}
                case FIELD_WITH_ORDER:  
 * by delegating to specific sort utilities for different sort types.
        // Utility class, no instances  
    }
     */
     * Protocol Buffer representations and creates properly configured SortBuilder instances  
/*  
     * by delegating to specific sort utilities based on the SortCombinations structure.
                case OPTIONS:
        org.opensearch.protobufs.SortOptions sortOptions,
        return sortFields;
                sortFields.add(sortBuilder);
    public static SortBuilder<?> fieldOrScoreSort(String fieldName) {
        String fieldName = fieldSortMap.getFieldSortMapMap().keySet().iterator().next();
 * Utility class for converting SortBuilder Protocol Buffers to OpenSearch objects.
                    sortBuilder = fromFieldSortMap(sortCombination.getFieldWithOrder(), registry);
        org.opensearch.protobufs.SortOrder direction = sortOrderMap.getSortOrderMapMap().get(fieldName);  
        }
        if (sortOptions.hasXScore()) {
/**  
     * Similar to {@link SortBuilder#fromXContent(XContentParser)}, this method parses the
    ) {
     * @param fieldName The name of the field to sort by, or "_score" for score-based sorting
        List<SortBuilder<?>> sortFields = new ArrayList<>(sortProto.size());  
        }  
                    continue;  
     * a ScoreSortBuilder if the field name is "_score", otherwise it returns a
 * The OpenSearch Contributors require contributions made to  
 */
        } else if (sortOptions.hasXScript()) {  
            SortBuilder<?> sortBuilder = null;  
            return new FieldSortBuilder(fieldName);
        if (SCORE_NAME.equals(fieldName)) {
     */  
import org.opensearch.core.xcontent.XContentParser;  
        org.opensearch.protobufs.FieldSortMap fieldSortMap,  
     * Converts SortOptions to SortBuilder.
     *  
import org.opensearch.search.sort.ScoreSortBuilder;  
     *
    ) {
            }
            throw new IllegalArgumentException("SortOrderMap cannot be empty or contain multiple entries");
            throw new IllegalArgumentException("FieldSortMap cannot be empty or contain multiple entries");
                    sortBuilder = fieldOrScoreSort(fieldName);
    public static final String SCORE_NAME = "_score";  
    /**
     * Creates either a ScoreSortBuilder or FieldSortBuilder based on the field name.
package org.opensearch.transport.grpc.proto.request.search.sort;
                    break;  
            return new ScoreSortBuilder();  
        for (SortCombinations sortCombination : sortProto) {
        return FieldSortBuilderProtoUtils.fromProto(fieldName, fieldSort, registry);
     */
    /**
     * @return A SortBuilder instance (either ScoreSortBuilder or FieldSortBuilder)
    /**
import org.opensearch.search.sort.SortBuilder;
     * Converts a list of Protocol Buffer SortCombinations to a list of OpenSearch SortBuilder objects.
    }
    }
