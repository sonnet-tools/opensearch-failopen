         */  
        }
        // Even if this was included in the inner_hit hits this would be the same, so better leave it out.
 */
            hitBuilder.setXShard(String.valueOf(hit.getShard().getShardId().id()));  
        // Process metadata fields
    private static void processDocumentFields(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {  
import java.util.Map;
        // Set ID if available
        if (hit.getNestedIdentity() != null) {
                hitBuilder.putHighlight(field.getName(), HighlightFieldProtoUtils.toProto(field.getFragments()));
     */  
            for (Map.Entry<String, SearchHits> entry : hit.getInnerHits().entrySet()) {  
        protoExplanationBuilder.setValue(explanation.getValue().floatValue());
            }
    }  
    /**
         * Converts a SearchHit.NestedIdentity to its Protocol Buffer representation.
     */  
                // TODO: uncomment when have a way to pass the param to the converter
 * compatible open source license.
        if (hit.getExplanation() != null && hit.getShard() != null) {
                buildExplanation(exp, detailBuilder);
     * Helper method to process highlight fields.  
            return nestedIdentityBuilder.build();  
import org.opensearch.common.document.DocumentField;
     * @param hit The SearchHit to process
     * @param hit The SearchHit to process
            // Utility class, no instances
                // doubleMapBuilder.putDoubleMap(entry.getKey(), entry.getValue().doubleValue());
import org.opensearch.core.common.bytes.BytesReference;  
     * @param hit The SearchHit to convert
                    namesBuilder.addStringArray(matchedFilter);
    /**  
            hitBuilder.setFields(fieldsStructBuilder.build());
        /**
        if (hit.getMatchedQueries().length > 0) {
 * Protocol Buffer representation for gRPC communication.  
        processHighlightFields(hit, hitBuilder);
import org.opensearch.protobufs.InnerHitsResult;  
     * @param hitBuilder The builder to populate with the score information
            hit.getDocumentFields().values().stream().anyMatch(df -> !df.getValues().isEmpty())) {  
     * @param protoExplanationBuilder The builder to populate with the explanation data  
        protected static NestedIdentity toProto(SearchHit.NestedIdentity nestedIdentity) {  
     * @throws IOException if there's an error during conversion  
            }
                if (field.getValues().isEmpty()) {
        }
     * Helper method to process score information.
     * @param explanation The Lucene Explanation to convert
import org.opensearch.core.xcontent.XContentBuilder;
                if (!field.getValues().isEmpty()) {
            for (DocumentField field : hit.getMetaFields().values()) {  
    private static void processMetadataFields(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
     *
    ) throws IOException {  
     * Helper method to process basic hit information.  
     */
        // Set nested identity if available
     * @return A Protocol Buffer Hit representation
                }
/**  
    private static void processHighlightFields(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
        processMetadataFields(hit, hitBuilder);
     *  
     * @param hitBuilder The builder to populate with the inner hits  
 * This class handles the conversion of search hit data to their
                nestedIdentityBuilder.setField(nestedIdentity.getField().string());
            for (HighlightField field : hit.getHighlightFields().values()) {
                // Map<String, Float> matchedQueriesWithScores = hit.getMatchedQueriesAndScores();
     *
                objectMapBuilder.putFields(field.getName(), ObjectMapProtoUtils.toProto(field.getValues()));  
     * @param hitBuilder The builder to populate with the shard information  
        processBasicInfo(hit, hitBuilder);
         * @param nestedIdentityBuilder The builder to populate with the nested identity data
                }
    }  
            // boolean includeMatchedQueriesScore = params.paramAsBoolean(RestSearchAction.INCLUDE_NAMED_QUERIES_SCORE_PARAM, false);
                org.opensearch.protobufs.HitsMetadata.Builder hitsBuilder = org.opensearch.protobufs.HitsMetadata.newBuilder();
        org.apache.lucene.search.Explanation[] innerExps = explanation.getDetails();
            if (includeMatchedQueriesScore) {  
                // for (Map.Entry<String, Float> entry : matchedQueriesWithScores.entrySet()) {
            // Set offset if available
        // Only process if there are non-empty metadata fields
 * this file be licensed under the Apache-2.0 license or a
            for (Explanation exp : innerExps) {  
    }
     */  
     * This method converts the Lucene explanation structure, including nested details,
        // Set sequence number and primary term if available
     * @throws IOException if there's an error during conversion
     */
     *  
    }  
            }
                    fieldsStructBuilder.putFields(field.getName(), ObjectMapProtoUtils.toProto(field.getValues()));  
            for (DocumentField field : hit.getDocumentFields().values()) {
     *
     * Helper method to process inner hits.  
        }
                NestedIdentity.Builder childBuilder = NestedIdentity.newBuilder();
    /**
    }  
            } else {  
        }  
    protected static void toProto(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) throws IOException {  
     * Helper method to process shard information.  
     * @param hit The SearchHit to process  
     * @param hitBuilder The builder to populate with the basic information  
                    hitBuilder.addMatchedQueries(matchedFilter);
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
        }
        // Process source
        }  
        // Process document fields
import java.io.IOException;  
            if (sourceRef instanceof BytesArray) {  
    /**
            ObjectMap.Builder fieldsStructBuilder = ObjectMap.newBuilder();
                for (String matchedFilter : hit.getMatchedQueries()) {
     * @param hit The SearchHit to process
/*  
        if (hit.getSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {  
                // org.opensearch.protobufs.DoubleMap.Builder doubleMapBuilder = org.opensearch.protobufs.DoubleMap.newBuilder();  
     * Utility class for converting NestedIdentity components between OpenSearch and Protocol Buffers formats.  
     *
            if (nestedIdentity.getField() != null) {  
        private NestedIdentityProtoUtils() {  
        processDocumentFields(hit, hitBuilder);
     */
                for (String matchedFilter : hit.getMatchedQueries()) {
        if (!hit.getDocumentFields().isEmpty() &&
     * @param hitBuilder The builder to populate with the document fields
     * @param hit The SearchHit to convert  
    }  
         */
     *
    private static void buildExplanation(  
     * @param hitBuilder The builder to populate with the matched queries
        // Process explanation
                hitBuilder.setXSource(ByteString.copyFrom(bytesRef.bytes, bytesRef.offset, bytesRef.length));
     */
        }
    /**  
     * This method is equivalent to {@link SearchHit#toXContent(XContentBuilder, ToXContent.Params)}
    /**
import com.google.protobuf.ByteString;  
            }
         * Similar to {@link SearchHit.NestedIdentity#innerToXContent(XContentBuilder, ToXContent.Params)}
         * This method creates a new builder and returns a built value.
     */  
            if (nestedIdentity.getChild() != null) {
                // matchedQueriesBuilder.setScores(doubleMapBuilder.build());
 *
import org.opensearch.core.common.bytes.BytesArray;
         * @param nestedIdentity The NestedIdentity to convert  
        protoExplanationBuilder.setDescription(explanation.getDescription());
                .newBuilder();
        /**  
public class SearchHitProtoUtils {
            hitBuilder.setXScore(scoreBuilder.build());
    }
        processScore(hit, hitBuilder);
        org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder = org.opensearch.protobufs.HitsMetadataHitsInner.newBuilder();
                    continue;  
        // Process sort values
                nestedIdentityBuilder.setOffset(nestedIdentity.getOffset());  
            hitBuilder.setXScore(scoreBuilder.build());  
        processInnerHits(hit, hitBuilder);
         * @return A Protocol Buffer NestedIdentity representation
        if (hit.getMetaFields().values().stream().anyMatch(field -> !field.getValues().isEmpty())) {  
        if (hit.getVersion() != -1) {
 * Utility class for converting SearchHit objects to Protocol Buffers.
    private static void processExplanation(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder)
        if (hit.getExplanation() != null) {
        }
                SearchHitsProtoUtils.toProto(entry.getValue(), hitsBuilder);
    private static void processSource(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
        throws IOException {  
            hitBuilder.setXSeqNo(hit.getSeqNo());
        if (hit.getIndex() != null) {
        processExplanation(hit, hitBuilder);
        }  
                }  
     * This class handles the transformation of nested document identity information to ensure proper
                // }  
    }  
            hitBuilder.setMetaFields(objectMapBuilder.build());  
            }
         *  
            buildExplanation(hit.getExplanation(), explanationBuilder);  
            } else {
    }
            hitBuilder.setXNested(NestedIdentityProtoUtils.toProto(hit.getNestedIdentity()));  
     * representation of nested search hits.
        }  
     * @param hitBuilder The builder to populate with the metadata fields
        // Set version if available  
            hitBuilder.setXId(hit.getId());
            hitBuilder.setXIndex(RemoteClusterAware.buildRemoteIndexName(hit.getClusterAlias(), hit.getIndex()));
     * into the corresponding Protocol Buffer representation.  
            scoreBuilder.setNullValue(org.opensearch.protobufs.NullValue.NULL_VALUE_NULL);
    private static void processShardInfo(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
    protected static org.opensearch.protobufs.HitsMetadataHitsInner toProto(SearchHit hit) throws IOException {
        if (!Float.isNaN(hit.getScore())) {
                protoExplanationBuilder.addDetails(detailBuilder.build());  
        // Process basic hit information
import org.opensearch.index.seqno.SequenceNumbers;
            org.opensearch.protobufs.Explanation.Builder explanationBuilder = org.opensearch.protobufs.Explanation.newBuilder();
                if (bytesRef.offset == 0 && bytesRef.length == bytesRef.bytes.length) {
        // Process highlight fields
        SearchSortValuesProtoUtils.toProto(hitBuilder, hit.getSortValues());
            org.opensearch.protobufs.HitXScore.Builder scoreBuilder = org.opensearch.protobufs.HitXScore.newBuilder();
import com.google.protobuf.UnsafeByteOperations;
    protected static class NestedIdentityProtoUtils {
     * Helper method to process metadata fields.
        // Utility class, no instances
                toProto(nestedIdentity.getChild(), childBuilder);  
     *  
            hitBuilder.setXExplanation(explanationBuilder.build());
     *
        }
        }
        throws IOException {
     * @param hitBuilder The builder to populate with the explanation
    /**
     * @param hit The SearchHit to process
}
     *
        return hitBuilder.build();
            hitBuilder.setXNode(hit.getShard().getNodeIdText().string());
        org.opensearch.protobufs.Explanation.Builder protoExplanationBuilder
     * @throws IOException if there's an error during conversion
    /**
        // Set index if available  
            // Handle null/NaN score case  
        } else {
    private SearchHitProtoUtils() {
     * @param hit The SearchHit to process
 * The OpenSearch Contributors require contributions made to  
    /**  
    /**
     */
                matchedQueriesBuilder.setNames(namesBuilder.build());
     * @param hit The SearchHit to process
     *
        // Process inner hits
                }  
     * Helper method to process document fields.
         * Similar to {@link SearchHit.NestedIdentity#toXContent(XContentBuilder, ToXContent.Params)}  
     *
        if (hit.getHighlightFields() != null && !hit.getHighlightFields().isEmpty()) {  
            boolean includeMatchedQueriesScore = false;
         * Private constructor to prevent instantiation.  
     * @param hit The SearchHit to process
        if (innerExps != null) {
         * This is a utility class with only static methods.
import org.apache.lucene.search.Explanation;
        }
        protected static void toProto(SearchHit.NestedIdentity nestedIdentity, NestedIdentity.Builder nestedIdentityBuilder) {
     * @throws IOException if there's an error during conversion
    }
            ObjectMap.Builder objectMapBuilder = ObjectMap.newBuilder();
     * Helper method to process source information.
import org.opensearch.transport.RemoteClusterAware;  
        }  
import org.opensearch.protobufs.NestedIdentity;
            hitBuilder.setXVersion(hit.getVersion());
    private static void processMatchedQueries(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
    private static void processBasicInfo(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {
    }
            }  
     * @param hitBuilder The builder to populate with the source information
         *
        // Process score
     * @throws IOException if there's an error during conversion
            org.opensearch.protobufs.HitXScore.Builder scoreBuilder = org.opensearch.protobufs.HitXScore.newBuilder();
        if (hit.getSourceRef() != null) {
     * This method is equivalent to {@link SearchHit#toInnerXContent(XContentBuilder, ToXContent.Params)}  
     * @param hitBuilder The builder to populate with the SearchHit data  
import org.opensearch.transport.grpc.proto.response.common.ObjectMapProtoUtils;
            // TODO pass params in  
    }
            if (nestedIdentity.getOffset() != -1) {
    private static void processInnerHits(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder)  
                // ignore empty metadata fields
            hitBuilder.setXPrimaryTerm(hit.getPrimaryTerm());
        // For inner_hit hits shard is null and that is ok, because the parent search hit has all this information.  
            // Set child if available  
        toProto(hit, hitBuilder);  
                hitBuilder.putInnerHits(entry.getKey(), InnerHitsResult.newBuilder().setHits(hitsBuilder.build()).build());
import org.apache.lucene.util.BytesRef;  
package org.opensearch.transport.grpc.proto.response.search;
            scoreBuilder.setDouble(hit.getScore());  
 */  
     */  
            toProto(nestedIdentity, nestedIdentityBuilder);
        org.apache.lucene.search.Explanation explanation,
import org.opensearch.search.SearchHits;
        processShardInfo(hit, hitBuilder);
            BytesReference sourceRef = hit.getSourceRef();  
            hitBuilder.setMatchedQueries2(matchedQueriesBuilder.build());  
        // Process shard information
     * Converts a SearchHit to its Protocol Buffer representation.
     * Recursively builds a Protocol Buffer Explanation from a Lucene Explanation.
         * @param nestedIdentity The NestedIdentity to convert
     */
        }
     * Converts a SearchHit to its Protocol Buffer representation.  
    }
        // ignore fields all together if they are all empty
         */
        if (hit.getInnerHits() != null) {
        if (hit.getId() != null) {  
                org.opensearch.protobufs.Explanation.Builder detailBuilder = org.opensearch.protobufs.Explanation.newBuilder();
     */
                nestedIdentityBuilder.setXNested(childBuilder.build());
    private static void processScore(SearchHit hit, org.opensearch.protobufs.HitsMetadataHitsInner.Builder hitBuilder) {  
     * @param hit The SearchHit to process
        // Process matched queries
         * Converts a SearchHit.NestedIdentity to its Protocol Buffer representation.
    /**
        /**
        processSource(hit, hitBuilder);
import org.opensearch.protobufs.ObjectMap;
        }
            // Set field if available
     */
                    hitBuilder.setXSource(UnsafeByteOperations.unsafeWrap(bytesRef.bytes, bytesRef.offset, bytesRef.length));
            }
 * SPDX-License-Identifier: Apache-2.0
            NestedIdentity.Builder nestedIdentityBuilder = NestedIdentity.newBuilder();
            }
     *  
    }
            org.opensearch.protobufs.HitMatchedQueries.Builder matchedQueriesBuilder = org.opensearch.protobufs.HitMatchedQueries
import org.opensearch.search.SearchHit;  
    /**
        }
     */
     * Helper method to process explanation.
        processMatchedQueries(hit, hitBuilder);
            BytesRef bytesRef = sourceRef.toBytesRef();
            }
                org.opensearch.protobufs.StringArray.Builder namesBuilder = org.opensearch.protobufs.StringArray.newBuilder();  
                    hitBuilder.setXSource(UnsafeByteOperations.unsafeWrap(bytesRef.bytes));
                }
                // Populate deprecated matched_queries field for backward compatibility with old clients  
        }  
    /**
    /**
            }
     * Helper method to process matched queries.
                } else {  
    }
     * @param hit The SearchHit to process  
     * @param hitBuilder The builder to populate with the highlight fields  
