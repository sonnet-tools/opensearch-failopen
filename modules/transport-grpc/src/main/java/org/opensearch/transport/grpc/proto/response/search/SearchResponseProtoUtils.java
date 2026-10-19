            Map<String, Long> phaseTookMap = phaseTook.getPhaseTookMap();
 * compatible open source license.
         */
        }  
                return;
         *
         * Similar to {@link SearchResponse.Clusters#toXContent(XContentBuilder, ToXContent.Params)}
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
                        break;
            searchResponseProtoBuilder.setPitId(response.pointInTimeId());
        if (response.isTerminatedEarly() != null) {
                        break;
         * Private constructor to prevent instantiation.
        }
     * @param aggregateRegistry The converter registry for dispatching aggregation conversions  
            searchResponseProtoBuilder.setTerminatedEarly(response.isTerminatedEarly());  
    /**  
     * Converts a SearchResponse to its Protocol Buffer representation.
 * SPDX-License-Identifier: Apache-2.0
        SearchResponseSectionsProtoUtils.toProto(searchResponseProtoBuilder, response, aggregateRegistry);
     * @param response The SearchResponse to convert
import org.opensearch.action.search.SearchPhaseName;  
                    case DFS_PRE_QUERY:
                // Set the appropriate field based on the phase name  
        org.opensearch.protobufs.SearchResponse.Builder searchResponseProtoBuilder = org.opensearch.protobufs.SearchResponse.newBuilder();
                    case EXPAND:
    public static void toProto(  
        }
        // Set optional fields only if they exist  
                        phaseTookProtoBuilder.setFetch(value);  
     * @throws IOException if there's an error during conversion
            // Utility class, no instances
         */  
            org.opensearch.protobufs.SearchResponse.Builder protoResponseBuilder,
        }  
        ) {
                // Create and populate the cluster statistics builder  
        ClustersProtoUtils.toProto(searchResponseProtoBuilder, response.getClusters());
                        phaseTookProtoBuilder.setDfsQuery(value);  
        protected static void toProto(
 * The OpenSearch Contributors require contributions made to  
    ) throws IOException {  
            SearchResponse.PhaseTook phaseTook,  
        // Build broadcast shards header  
                long value = phaseTookMap.getOrDefault(searchPhaseName.getName(), 0L);
    }
     * This class handles the transformation of phase timing information to ensure proper reporting
     * of cross-cluster search results.
                    case CAN_MATCH:
 * This class handles the conversion of search operation responses to their  
        toProto(response, searchResponseProtoBuilder, aggregateRegistry);
    public static org.opensearch.protobufs.SearchResponse toProto(  
}
         * @param phaseTook The PhaseTook to convert
     * of search phase execution times.  
    protected static class PhaseTookProtoUtils {
/**
         * This is a utility class with only static methods.
        if (response.getPhaseTook() != null) {
            response.getFailedShards(),  
        /**
         * @param phaseTookProtoBuilder The builder to populate with the PhaseTook data  
     * @return A Protocol Buffer SearchResponse representation  
        // Add clusters information
import org.opensearch.protobufs.ClusterStatistics;
        protected static void toProto(  
            response.getSkippedShards(),
        }  
        private ClustersProtoUtils() {
            if (phaseTook == null) {  
        ProtoActionsProtoUtils.buildBroadcastShardsHeader(
                    case DFS_QUERY:
            SearchResponse.Clusters clusters
import java.util.Map;
            for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        SearchResponse response,
import org.opensearch.core.xcontent.ToXContent;
            response.getSuccessfulShards(),
        }
    protected static class ClustersProtoUtils {  
            }
                        break;
        private PhaseTookProtoUtils() {
        if (response.pointInTimeId() != null) {
            response.getShardFailures()
     * @param aggregateRegistry The converter registry for dispatching aggregation conversions
     * Similar to {@link SearchResponse#innerToXContent(XContentBuilder, ToXContent.Params)}
 * Protocol Buffer representation.
     *  
    ) throws IOException {
         */
    /**  
                    .setSuccessful(clusters.getSuccessful())  
                        break;
    }
        org.opensearch.protobufs.SearchResponse.Builder searchResponseProtoBuilder,
         * Private constructor to prevent instantiation.
     * @param searchResponseProtoBuilder The builder to populate with the SearchResponse data
import org.opensearch.action.search.SearchResponse;
                    .setTotal(clusters.getTotal())
        }  
         * @param protoResponseBuilder The builder to populate with the Clusters data  
import org.opensearch.core.xcontent.XContentBuilder;  
        if (response.getNumReducePhases() != 1) {
                    case FETCH:
        searchResponseProtoBuilder.setTimedOut(response.isTimedOut());
                // Get the value from the map or default to 0  
                        phaseTookProtoBuilder.setExpand(value);  
        /**
        // Set optional fields only if they differ from defaults
    }
        ) {  
    }
         * This is a utility class with only static methods.  
            searchResponseProtoBuilder,
                        phaseTookProtoBuilder.setDfsPreQuery(value);  
            searchResponseProtoBuilder.setXScrollId(response.getScrollId());
    /**  
        );
        AggregateProtoConverterRegistry aggregateRegistry  
        /**  
     * Converts a SearchResponse to its Protocol Buffer representation.
     * This method is equivalent to {@link SearchResponse#toXContent(XContentBuilder, ToXContent.Params)}
package org.opensearch.transport.grpc.proto.response.search;
            // Get the phase took map once to avoid repeated method calls
        return searchResponseProtoBuilder.build();  
                    .setSkipped(clusters.getSkipped());
            }
    /**
                    default:
                switch (searchPhaseName) {
            // Only add clusters information if there are clusters
         * Similar to {@link SearchResponse.PhaseTook#toXContent(XContentBuilder, ToXContent.Params)}  
                    case QUERY:
                        break;
     */
            PhaseTookProtoUtils.toProto(response.getPhaseTook(), phaseTookBuilder);  
            org.opensearch.protobufs.PhaseTook.Builder phaseTookBuilder = org.opensearch.protobufs.PhaseTook.newBuilder();
                ClusterStatistics.Builder clusterStatistics = ClusterStatistics.newBuilder()
 * Utility class for converting SearchResponse objects to Protocol Buffers.
     * Utility class for converting Clusters components between OpenSearch and Protocol Buffers formats.
     */
        // Set required fields
            // Process each search phase
            searchResponseProtoBuilder.setPhaseTook(phaseTookBuilder.build());
        AggregateProtoConverterRegistry aggregateRegistry
                // Set the clusters field in the response builder  
        if (response.getScrollId() != null) {
                        throw new UnsupportedOperationException("searchPhaseName cannot be converted to phaseTook protobuf type");  
     *  
     * @param response The SearchResponse to convert
        }
            if (clusters.getTotal() > 0) {
    }
        // Utility class, no instances  
            searchResponseProtoBuilder.setNumReducePhases(response.getNumReducePhases());  
                        phaseTookProtoBuilder.setQuery(value);  
/*  
        }  
            response.getTotalShards(),  
         *
 */  
public class SearchResponseProtoUtils {  
                protoResponseBuilder.setXClusters(clusterStatistics.build());
            // Utility class, no instances  
     */
                        break;
                }
        SearchResponse response,
     * @throws IOException if there's an error during conversion
 */
        searchResponseProtoBuilder.setTook(response.getTook().getMillis());  
            org.opensearch.protobufs.PhaseTook.Builder phaseTookProtoBuilder
         */
 * this file be licensed under the Apache-2.0 license or a
    private SearchResponseProtoUtils() {
        // Add search response sections
        /**  
         * @param clusters The Clusters to convert
     */
     * This class handles the transformation of cluster statistics information to ensure proper reporting  
        // Set phase took information if available  
            }
                        phaseTookProtoBuilder.setCanMatch(value);  
     * Utility class for converting PhaseTook components between OpenSearch and Protocol Buffers formats.
import java.io.IOException;
 *
