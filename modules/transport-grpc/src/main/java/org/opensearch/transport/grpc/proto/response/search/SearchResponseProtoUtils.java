        // Set optional fields only if they exist
        org.opensearch.protobufs.SearchResponse.Builder searchResponseProtoBuilder = org.opensearch.protobufs.SearchResponse.newBuilder();
            org.opensearch.protobufs.PhaseTook.Builder phaseTookProtoBuilder
        // Utility class, no instances
                // Create and populate the cluster statistics builder
            response.getSkippedShards(),
     * @throws IOException if there's an error during conversion
    protected static class ClustersProtoUtils {
 * Utility class for converting SearchResponse objects to Protocol Buffers.
                    case QUERY:
            org.opensearch.protobufs.SearchResponse.Builder protoResponseBuilder,
                    case DFS_QUERY:
        ) {
        ClustersProtoUtils.toProto(searchResponseProtoBuilder, response.getClusters());
         */
                // Get the value from the map or default to 0
         * Private constructor to prevent instantiation.
         * @param phaseTook The PhaseTook to convert
        searchResponseProtoBuilder.setTook(response.getTook().getMillis());
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.transport.grpc.proto.response.search;
        return searchResponseProtoBuilder.build();
            searchResponseProtoBuilder.setTerminatedEarly(response.isTerminatedEarly());
            Map<String, Long> phaseTookMap = phaseTook.getPhaseTookMap();
 * The OpenSearch Contributors require contributions made to
        if (response.getNumReducePhases() != 1) {
 */
            for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        // Set required fields
import org.opensearch.action.search.SearchResponse;
        searchResponseProtoBuilder.setTimedOut(response.isTimedOut());
         * Similar to {@link SearchResponse.Clusters#toXContent(XContentBuilder, ToXContent.Params)}
        private ClustersProtoUtils() {
                        phaseTookProtoBuilder.setQuery(value);
                long value = phaseTookMap.getOrDefault(searchPhaseName.getName(), 0L);
 */
                        phaseTookProtoBuilder.setCanMatch(value);
            searchResponseProtoBuilder.setNumReducePhases(response.getNumReducePhases());
        private PhaseTookProtoUtils() {
    /**
    }
 *
        SearchResponseSectionsProtoUtils.toProto(searchResponseProtoBuilder, response, aggregateRegistry);
     */
     * @param response The SearchResponse to convert
                        break;
                }
         */
        protected static void toProto(
                    .setTotal(clusters.getTotal())
        }
        /**
                        phaseTookProtoBuilder.setExpand(value);
            // Utility class, no instances
     *
            searchResponseProtoBuilder.setPhaseTook(phaseTookBuilder.build());
            // Get the phase took map once to avoid repeated method calls
         * Similar to {@link SearchResponse.PhaseTook#toXContent(XContentBuilder, ToXContent.Params)}
            searchResponseProtoBuilder.setPitId(response.pointInTimeId());
                        phaseTookProtoBuilder.setDfsPreQuery(value);
         * @param clusters The Clusters to convert
            if (phaseTook == null) {
        if (response.getScrollId() != null) {
     * of search phase execution times.
import org.opensearch.protobufs.ClusterStatistics;
        // Set phase took information if available
     * @param aggregateRegistry The converter registry for dispatching aggregation conversions
        /**
            response.getShardFailures()
     * Utility class for converting Clusters components between OpenSearch and Protocol Buffers formats.
                // Set the appropriate field based on the phase name
     * @param response The SearchResponse to convert
         * This is a utility class with only static methods.
    public static void toProto(
    }
    }
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
         *
         */
        org.opensearch.protobufs.SearchResponse.Builder searchResponseProtoBuilder,
        // Build broadcast shards header
            response.getSuccessfulShards(),
import org.opensearch.core.xcontent.XContentBuilder;
            SearchResponse.Clusters clusters
     * This class handles the transformation of phase timing information to ensure proper reporting
     * @param aggregateRegistry The converter registry for dispatching aggregation conversions
        SearchResponse response,
            PhaseTookProtoUtils.toProto(response.getPhaseTook(), phaseTookBuilder);
         * @param phaseTookProtoBuilder The builder to populate with the PhaseTook data
            SearchResponse.PhaseTook phaseTook,
                // Set the clusters field in the response builder
     *
        }
            // Only add clusters information if there are clusters
         * This is a utility class with only static methods.
/*
    }
        // Add clusters information
                        break;
 * compatible open source license.
        // Add search response sections
     */
    /**
        /**
        SearchResponse response,
    private SearchResponseProtoUtils() {
/**
            if (clusters.getTotal() > 0) {
                        phaseTookProtoBuilder.setFetch(value);
        }
     */
                        break;
     * Converts a SearchResponse to its Protocol Buffer representation.
        }
        }
        /**
        ) {
import java.util.Map;
        }
            // Process each search phase
         * @param protoResponseBuilder The builder to populate with the Clusters data
    public static org.opensearch.protobufs.SearchResponse toProto(
        );
            response.getFailedShards(),
                    case DFS_PRE_QUERY:
     * @param searchResponseProtoBuilder The builder to populate with the SearchResponse data
        }
    /**
     * of cross-cluster search results.
        }
            }
 * SPDX-License-Identifier: Apache-2.0
    }
        AggregateProtoConverterRegistry aggregateRegistry
                        phaseTookProtoBuilder.setDfsQuery(value);
        toProto(response, searchResponseProtoBuilder, aggregateRegistry);
     * Similar to {@link SearchResponse#innerToXContent(XContentBuilder, ToXContent.Params)}
            response.getTotalShards(),
import org.opensearch.core.xcontent.ToXContent;
                    case FETCH:
     * @return A Protocol Buffer SearchResponse representation
     */
                        break;
public class SearchResponseProtoUtils {
        if (response.pointInTimeId() != null) {
                switch (searchPhaseName) {
         *
     * This class handles the transformation of cluster statistics information to ensure proper reporting
        ProtoActionsProtoUtils.buildBroadcastShardsHeader(
        if (response.isTerminatedEarly() != null) {
            searchResponseProtoBuilder,
            }
            searchResponseProtoBuilder.setXScrollId(response.getScrollId());
            // Utility class, no instances
                        throw new UnsupportedOperationException("searchPhaseName cannot be converted to phaseTook protobuf type");
         * Private constructor to prevent instantiation.
        }
    ) throws IOException {
        // Set optional fields only if they differ from defaults
                    case EXPAND:
}
                    case CAN_MATCH:
    /**
        protected static void toProto(
                    .setSuccessful(clusters.getSuccessful())
     * Utility class for converting PhaseTook components between OpenSearch and Protocol Buffers formats.
            org.opensearch.protobufs.PhaseTook.Builder phaseTookBuilder = org.opensearch.protobufs.PhaseTook.newBuilder();
                        break;
        if (response.getPhaseTook() != null) {
     * Converts a SearchResponse to its Protocol Buffer representation.
     * @throws IOException if there's an error during conversion
 * Protocol Buffer representation.
    protected static class PhaseTookProtoUtils {
            }
import java.io.IOException;
    ) throws IOException {
                    default:
                protoResponseBuilder.setXClusters(clusterStatistics.build());
 * This class handles the conversion of search operation responses to their
                ClusterStatistics.Builder clusterStatistics = ClusterStatistics.newBuilder()
import org.opensearch.action.search.SearchPhaseName;
                        break;
                    .setSkipped(clusters.getSkipped());
                return;
     * This method is equivalent to {@link SearchResponse#toXContent(XContentBuilder, ToXContent.Params)}
        AggregateProtoConverterRegistry aggregateRegistry
         */
