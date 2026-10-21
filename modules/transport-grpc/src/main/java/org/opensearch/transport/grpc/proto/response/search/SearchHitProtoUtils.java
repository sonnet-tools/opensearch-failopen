     * @param hit The SearchHit to process
    /**
     * @param hitBuilder The builder to populate with the shard information
     *
     * @param hitBuilder The builder to populate with the document fields
            hit.getDocumentFields().values().stream().anyMatch(df -> !df.getValues().isEmpty())) {
                    namesBuilder.addStringArray(matchedFilter);
            // boolean includeMatchedQueriesScore = params.paramAsBoolean(RestSearchAction.INCLUDE_NAMED_QUERIES_SCORE_PARAM, false);
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
     * @param hitBuilder The builder to populate with the score information
        }
                matchedQueriesBuilder.setNames(namesBuilder.build());
            }
                hitBuilder.putInnerHits(entry.getKey(), InnerHitsResult.newBuilder().setHits(hitsBuilder.build()).build());
import org.opensearch.core.common.bytes.BytesReference;
     *
    ) throws IOException {
                // Populate deprecated matched_queries field for backward compatibility with old clients
     * @return A Protocol Buffer Hit representation
    }
     */
                SearchHitsProtoUtils.toProto(entry.getValue(), hitsBuilder);
    /**
        protoExplanationBuilder.setValue(explanation.getValue().floatValue());
        // Process matched queries
                protoExplanationBuilder.addDetails(detailBuilder.build());
import org.opensearch.protobufs.ObjectMap;
                // matchedQueriesBuilder.setScores(doubleMapBuilder.build());
         */
        // Process document fields
        // Process metadata fields
    }
        // ignore fields all together if they are all empty
     * Helper method to process metadata fields.
        }
                toProto(nestedIdentity.getChild(), childBuilder);
        }
                for (String matchedFilter : hit.getMatchedQueries()) {
                // Map<String, Float> matchedQueriesWithScores = hit.getMatchedQueriesAndScores();
            org.opensearch.protobufs.HitMatchedQueries.Builder matchedQueriesBuilder = org.opensearch.protobufs.HitMatchedQueries
    /**
import com.google.protobuf.ByteString;
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
            for (DocumentField field : hit.getMetaFields().values()) {
     * @param hitBuilder The builder to populate with the SearchHit data
                    fieldsStructBuilder.putFields(field.getName(), ObjectMapProtoUtils.toProto(field.getValues()));
            scoreBuilder.setNullValue(org.opensearch.protobufs.NullValue.NULL_VALUE_NULL);
        processSource(hit, hitBuilder);
     * @throws IOException if there's an error during conversion
    /**
     * @param hit The SearchHit to process
     * Helper method to process score information.
            scoreBuilder.setDouble(hit.getScore());
import org.opensearch.transport.RemoteClusterAware;
        } else {
     */
            for (Map.Entry<String, SearchHits> entry : hit.getInnerHits().entrySet()) {
         */
        // Set index if available
        processBasicInfo(hit, hitBuilder);
            org.opensearch.protobufs.HitXScore.Builder scoreBuilder = org.opensearch.protobufs.HitXScore.newBuilder();
     * @param hitBuilder The builder to populate with the explanation
            NestedIdentity.Builder nestedIdentityBuilder = NestedIdentity.newBuilder();
        // Process explanation
        }
            toProto(nestedIdentity, nestedIdentityBuilder);
    private static void processExplanation(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder)
        if (hit.getMetaFields().values().stream().anyMatch(field -> !field.getValues().isEmpty())) {
    private static void processInnerHits(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder)
         * @param nestedIdentity The NestedIdentity to convert
    protected static class NestedIdentityProtoUtils {
public class SearchHitProtoUtils {
                buildExplanation(exp, detailBuilder);
         * @return A Protocol Buffer NestedIdentity representation
     * @throws IOException if there's an error during conversion
     * Helper method to process inner hits.
     *
            for (DocumentField field : hit.getDocumentFields().values()) {
            }
        throws IOException {
        }
            if (nestedIdentity.getChild() != null) {
            boolean includeMatchedQueriesScore = false;
     */
         * @param nestedIdentityBuilder The builder to populate with the nested identity data
     * @throws IOException if there's an error during conversion
        }
 * Protocol Buffer representation for gRPC communication.
package org.opensearch.transport.grpc.proto.response.search;
            // TODO pass params in
     */
        SearchSortValuesProtoUtils.toProto(hitBuilder, hit.getSortValues());
                }
     *
import org.opensearch.search.SearchHits;
        org.apache.lucene.search.Explanation[] innerExps = explanation.getDetails();
     *
            }
    private SearchHitProtoUtils() {
     * @param hitBuilder The builder to populate with the highlight fields
        if (hit.getExplanation() != null && hit.getShard() != null) {
    private static void processMatchedQueries(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
                hitBuilder.setXSource(ByteString.copyFrom(bytesRef.bytes, bytesRef.offset, bytesRef.length));
     */
        if (hit.getExplanation() != null) {
     * This method is equivalent to {@link SearchHit#toXContent(XContentBuilder, ToXContent.Params)}
         * Private constructor to prevent instantiation.
     * This class handles the transformation of nested document identity information to ensure proper
                if (bytesRef.offset == 0 && bytesRef.length == bytesRef.bytes.length) {
     * This method converts the Lucene explanation structure, including nested details,
                // org.opensearch.protobufs.DoubleMap.Builder doubleMapBuilder = org.opensearch.protobufs.DoubleMap.newBuilder();
     * Converts a SearchHit to its Protocol Buffer representation.
                    hitBuilder.setXSource(UnsafeByteOperations.unsafeWrap(bytesRef.bytes));
                if (!field.getValues().isEmpty()) {
     * @param hit The SearchHit to convert
     * Converts a SearchHit to its Protocol Buffer representation.
        if (hit.getIndex() != null) {
                org.opensearch.protobufs.HitsMetadata.Builder hitsBuilder = org.opensearch.protobufs.HitsMetadata.newBuilder();
    }
        // Set ID if available
import java.io.IOException;
        if (hit.getInnerHits() != null) {
            hitBuilder.setXExplanation(explanationBuilder.build());
                nestedIdentityBuilder.setXNested(childBuilder.build());
     */
 * SPDX-License-Identifier: Apache-2.0
            }
                objectMapBuilder.putFields(field.getName(), ObjectMapProtoUtils.toProto(field.getValues()));
     * @param hit The SearchHit to process
        }
    private static void processMetadataFields(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
            hitBuilder.setMatchedQueries2(matchedQueriesBuilder.build());
     */
                nestedIdentityBuilder.setField(nestedIdentity.getField().string());
        // Set nested identity if available
         * Similar to {@link SearchHit.NestedIdentity#toXContent(XContentBuilder, ToXContent.Params)}
        }
        if (hit.getVersion() != -1) {
    private static void buildExplanation(
        if (hit.getSourceRef() != null) {
        // Even if this was included in the inner_hit hits this would be the same, so better leave it out.
     * Helper method to process highlight fields.
        }
        // Process source
        }
    protected static void toProto(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) throws IOException {
     * @param hit The SearchHit to process
    }
            // Set offset if available
     *
            }
        }
    /**
    private static void processDocumentFields(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
        processInnerHits(hit, hitBuilder);
        processShardInfo(hit, hitBuilder);
 * this file be licensed under the Apache-2.0 license or a
            hitBuilder.setXIndex(RemoteClusterAware.buildRemoteIndexName(hit.getClusterAlias(), hit.getIndex()));
import org.opensearch.protobufs.NestedIdentity;
     * @param hit The SearchHit to process
    private static void processScore(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
     * @param hit The SearchHit to process
     *
    /**
         * @param nestedIdentity The NestedIdentity to convert
            // Handle null/NaN score case
        }
            hitBuilder.setFields(fieldsStructBuilder.build());
        // Process sort values
                // ignore empty metadata fields
                }
import org.opensearch.index.seqno.SequenceNumbers;
import org.apache.lucene.util.BytesRef;
                for (String matchedFilter : hit.getMatchedQueries()) {
    /**
    /**
    }
                    continue;
            buildExplanation(hit.getExplanation(), explanationBuilder);
    protected static org.opensearch.protobufs.HitsMetadataHitsInner toProto(SearchHit hit) throws IOException {
     * @param hitBuilder The builder to populate with the metadata fields
                    hitBuilder.setXSource(UnsafeByteOperations.unsafeWrap(bytesRef.bytes, bytesRef.offset, bytesRef.length));
        protected static void toProto(SearchHit.NestedIdentity nestedIdentity, NestedIdentity.Builder nestedIdentityBuilder) {
    }
import com.google.protobuf.UnsafeByteOperations;
 */
     * Helper method to process matched queries.
        // Process score
                org.opensearch.protobufs.StringArray.Builder namesBuilder = org.opensearch.protobufs.StringArray.newBuilder();
     */
        org.opensearch.protobufs.Explanation.Builder protoExplanationBuilder
            BytesRef bytesRef = sourceRef.toBytesRef();
        if (hit.getHighlightFields() != null && !hit.getHighlightFields().isEmpty()) {
     */
            if (sourceRef instanceof BytesArray) {
     *
        }
 * Utility class for converting SearchHit objects to Protocol Buffers.
         * This is a utility class with only static methods.
                }
     * @param hitBuilder The builder to populate with the matched queries
        // Process inner hits
        if (hit.getId() != null) {
            hitBuilder.setXId(hit.getId());
     * @param hit The SearchHit to process
            for (HighlightField field : hit.getHighlightFields().values()) {
    /**
            }
            } else {
    }
        // For inner_hit hits shard is null and that is ok, because the parent search hit has all this information.
     */
     * @param hitBuilder The builder to populate with the basic information
                NestedIdentity.Builder childBuilder = NestedIdentity.newBuilder();
        throws IOException {
import org.opensearch.common.document.DocumentField;
     * Helper method to process document fields.
     *
            if (nestedIdentity.getOffset() != -1) {
 */
        if (innerExps != null) {
        if (hit.getMatchedQueries().length > 0) {
            hitBuilder.setXScore(scoreBuilder.build());
import java.util.Map;
         * Similar to {@link SearchHit.NestedIdentity#innerToXContent(XContentBuilder, ToXContent.Params)}
                // TODO: uncomment when have a way to pass the param to the converter
    }
     * @param hit The SearchHit to process
        processScore(hit, hitBuilder);
     */
        org.apache.lucene.search.Explanation explanation,
            hitBuilder.setXScore(scoreBuilder.build());
            }
     * This method is equivalent to {@link SearchHit#toInnerXContent(XContentBuilder, ToXContent.Params)}
        }
            org.opensearch.protobufs.HitXScore.Builder scoreBuilder = org.opensearch.protobufs.HitXScore.newBuilder();
    }
 * This class handles the conversion of search hit data to their
 * The OpenSearch Contributors require contributions made to
     * Helper method to process basic hit information.
            return nestedIdentityBuilder.build();
                }
        return hitBuilder.build();
     * @throws IOException if there's an error during conversion
    }
    /**
    private static void processSource(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
    private static void processHighlightFields(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
        processMatchedQueries(hit, hitBuilder);
                // doubleMapBuilder.putDoubleMap(entry.getKey(), entry.getValue().doubleValue());
    /**
        if (!Float.isNaN(hit.getScore())) {
         */
     * representation of nested search hits.
import org.opensearch.search.SearchHit;
    }
                .newBuilder();
            for (Explanation exp : innerExps) {
import org.opensearch.protobufs.InnerHitsResult;
         * Converts a SearchHit.NestedIdentity to its Protocol Buffer representation.
        /**
        private NestedIdentityProtoUtils() {
 * compatible open source license.
        if (hit.getSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        if (hit.getNestedIdentity() != null) {
        /**
     */
            // Set child if available
     * @param hit The SearchHit to convert
                }
            org.opensearch.protobufs.Explanation.Builder explanationBuilder = org.opensearch.protobufs.Explanation.newBuilder();
            ObjectMap.Builder fieldsStructBuilder = ObjectMap.newBuilder();
        processMetadataFields(hit, hitBuilder);
            if (includeMatchedQueriesScore) {
        // Process highlight fields
 *
        }
    /**
            BytesReference sourceRef = hit.getSourceRef();
/*
         * Converts a SearchHit.NestedIdentity to its Protocol Buffer representation.
    }
    /**
            }
     *
        protoExplanationBuilder.setDescription(explanation.getDescription());
     *
                hitBuilder.putHighlight(field.getName(), HighlightFieldProtoUtils.toProto(field.getFragments()));
    private static void processShardInfo(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
    }
     * into the corresponding Protocol Buffer representation.
            hitBuilder.setXNested(NestedIdentityProtoUtils.toProto(hit.getNestedIdentity()));
                } else {
                    hitBuilder.addMatchedQueries(matchedFilter);
     *
            hitBuilder.setXVersion(hit.getVersion());
        if (!hit.getDocumentFields().isEmpty() &&
                if (field.getValues().isEmpty()) {
     * @param explanation The Lucene Explanation to convert
    }
        processDocumentFields(hit, hitBuilder);
        }
import org.opensearch.core.common.bytes.BytesArray;
     * Recursively builds a Protocol Buffer Explanation from a Lucene Explanation.
            ObjectMap.Builder objectMapBuilder = ObjectMap.newBuilder();
            }
     * @param hitBuilder The builder to populate with the inner hits
        // Set version if available
            // Set field if available
            hitBuilder.setXSeqNo(hit.getSeqNo());
     * Helper method to process explanation.
        /**
        // Process basic hit information
     * @param protoExplanationBuilder The builder to populate with the explanation data
     */
/**
     *
            if (nestedIdentity.getField() != null) {
     * @param hit The SearchHit to process
        protected static NestedIdentity toProto(SearchHit.NestedIdentity nestedIdentity) {
            hitBuilder.setXShard(String.valueOf(hit.getShard().getShardId().id()));
            hitBuilder.setXNode(hit.getShard().getNodeIdText().string());
        // Process shard information
                // }
    }
         *
import org.opensearch.core.xcontent.XContentBuilder;
     * @throws IOException if there's an error during conversion
        toProto(hit, hitBuilder);
        }
        org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder = org.opensearch.protobufs.HitsMetadataHitsInner.newBuilder();
        processHighlightFields(hit, hitBuilder);
import org.apache.lucene.search.Explanation;
        processExplanation(hit, hitBuilder);
            hitBuilder.setMetaFields(objectMapBuilder.build());
            // Utility class, no instances
     * @param hit The SearchHit to process
            }
     */
        }
                org.opensearch.protobufs.Explanation.Builder detailBuilder = org.opensearch.protobufs.Explanation.newBuilder();
    private static void processBasicInfo(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
                nestedIdentityBuilder.setOffset(nestedIdentity.getOffset());
            } else {
            hitBuilder.setXPrimaryTerm(hit.getPrimaryTerm());
     * Utility class for converting NestedIdentity components between OpenSearch and Protocol Buffers formats.
     * Helper method to process shard information.
     * Helper method to process source information.
        // Utility class, no instances
     * @param hitBuilder The builder to populate with the source information
        // Only process if there are non-empty metadata fields
}
                // for (Map.Entry<String, Float> entry : matchedQueriesWithScores.entrySet()) {
         *
        // Set sequence number and primary term if available
         * This method creates a new builder and returns a built value.
    /**
