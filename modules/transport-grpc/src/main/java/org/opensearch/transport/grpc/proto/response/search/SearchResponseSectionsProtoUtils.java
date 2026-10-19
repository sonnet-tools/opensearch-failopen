/**
 */  
                detailBuilder.setDurationMillis(detail.getDurationMillis());
     *  
        SearchResponse response,
                }
import org.opensearch.action.search.SearchResponse;  
import java.util.List;
        }
    ) throws IOException {
    }
     * @param response The SearchResponse to convert
     * @param aggregateRegistry The converter registry for dispatching aggregation conversions  
     * @throws IOException if there's an error during conversion
        if (response.getProfileResults() != null && !response.getProfileResults().isEmpty()) {  
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
        }  
                    detailBuilder.setOutputData(ObjectMapProtoUtils.toProto(detail.getOutputData()).getObjectMap());
    }  
            for (org.opensearch.search.pipeline.ProcessorExecutionDetail detail : processorResults) {
}
                }
 *
                if (detail.getProcessorName() != null) {
        AggregationsProtoUtils.toProto(response.getAggregations(), builder, aggregateRegistry);
                }
import java.io.IOException;  
        // TODO: Implement search ext builders conversion
    /**
     */
        if (response.getSuggest() != null) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
                    detailBuilder.setTag(detail.getTag());
    protected static void toProto(  
     *
     * Converts a SearchResponse to its Protocol Buffer representation.
        if (processorResults != null && !processorResults.isEmpty()) {
        // Convert processor results
            throw new UnsupportedOperationException("ext builder responses are not supported yet");
 */
            throw new UnsupportedOperationException("suggest responses are not supported yet");
        List<org.opensearch.search.pipeline.ProcessorExecutionDetail> processorResults = response.getInternalResponse()
public class SearchResponseSectionsProtoUtils {  
 * Protocol Buffer representation.
        org.opensearch.protobufs.SearchResponse.Builder builder,
        // Convert hits using pass by reference
        if (response.getInternalResponse().getSearchExtBuilders() != null
     * Similar to {@link SearchResponseSections#toXContent(XContentBuilder, ToXContent.Params)}
        }
        // Check for other unsupported features
        AggregateProtoConverterRegistry aggregateRegistry  
            throw new UnsupportedOperationException("profile results are not supported yet");
        org.opensearch.protobufs.HitsMetadata.Builder hitsBuilder = org.opensearch.protobufs.HitsMetadata.newBuilder();  
                if (detail.getErrorMessage() != null) {  
        builder.setHits(hitsBuilder.build());
     * Helper method to check for unsupported features.  
                if (detail.getStatus() != null) {  
        SearchHitsProtoUtils.toProto(response.getHits(), hitsBuilder);
 * The OpenSearch Contributors require contributions made to  
        // TODO: Implement suggest conversion  
        checkUnsupportedFeatures(response);
                    .newBuilder();
                if (detail.getInputData() != null) {  
    /**  
                builder.addProcessorResults(detailBuilder.build());  
    private static void checkUnsupportedFeatures(SearchResponse response) {
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregationsProtoUtils;  
import java.util.Locale;
                }
    private SearchResponseSectionsProtoUtils() {
     */
 * Utility class for converting SearchResponse objects to Protocol Buffers.
 * SPDX-License-Identifier: Apache-2.0
            }
     * @throws UnsupportedOperationException if unsupported features are present  
        // Utility class, no instances  
        // Convert aggregations if present
    }  
                org.opensearch.protobufs.ProcessorExecutionDetail.Builder detailBuilder = org.opensearch.protobufs.ProcessorExecutionDetail  
 * compatible open source license.
        // TODO: Implement profile results conversion
                    detailBuilder.setError(detail.getErrorMessage());
     * @param response The SearchResponse to check
            && !response.getInternalResponse().getSearchExtBuilders().isEmpty()) {  
                if (detail.getOutputData() != null) {  
        }
package org.opensearch.transport.grpc.proto.response.search;
import org.opensearch.action.search.SearchResponseSections;
 * This class handles the conversion of search operation responses to their  
/*  
                if (detail.getTag() != null) {  
                    detailBuilder.setStatus(detail.getStatus().name().toLowerCase(Locale.ROOT));
                    detailBuilder.setInputData(ObjectMapProtoUtils.toProto(detail.getInputData()).getObjectMap());
                    detailBuilder.setProcessorName(detail.getProcessorName());  
            .getProcessorResult();  
     * @param builder The Protocol Buffer SearchResponse builder to populate
                }
                }
