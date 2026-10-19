        }
                if (fieldProto.hasType()) {  
                if (fieldProto.hasTagsSchema() && fieldProto.getTagsSchema() != HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_UNSPECIFIED) {
                }  
import org.opensearch.protobufs.BuiltinHighlighterType;  
    }
        if (highlightProto.hasFragmentSize()) {
            default:  
     * @return A configured HighlightBuilder instance  
        }
            String[] postTags = new String[highlightProto.getPostTagsCount()];
 * compatible open source license.
import org.opensearch.transport.grpc.util.ProtobufEnumUtils;  
        }  
        if (highlightProto.hasOrder() && highlightProto.getOrder() == HighlighterOrder.HIGHLIGHTER_ORDER_SCORE) {
        }
                if (fieldProto.hasBoundaryScanner() && fieldProto.getBoundaryScanner() != BoundaryScanner.BOUNDARY_SCANNER_UNSPECIFIED) {
            } else if (highlightProto.getType().hasCustom()) {
        if (highlightProto.hasPhraseLimit()) {  
 * this file be licensed under the Apache-2.0 license or a
/**
            default:  
                    fieldBuilder.postTags(postTags);  
            highlightBuilder.noMatchSize(highlightProto.getNoMatchSize());
                    fieldBuilder.fragmentOffset(fieldProto.getFragmentOffset());  
            highlightBuilder.encoder(ProtobufEnumUtils.convertToString(highlightProto.getEncoder()));
import org.opensearch.protobufs.HighlighterFragmenter;  
            highlightBuilder.fragmentSize(highlightProto.getFragmentSize());
                }  
                    fieldBuilder.boundaryChars(fieldProto.getBoundaryChars().toCharArray());
}
                        throw new IllegalStateException("QueryBuilderProtoConverterRegistry cannot be null.");
package org.opensearch.transport.grpc.proto.request.search;
                    String[] postTags = new String[fieldProto.getPostTagsCount()];
                return HighlightBuilder.BoundaryScannerType.CHARS;
                    HighlightBuilder.BoundaryScannerType boundaryScanner = parseBoundaryScanner(fieldProto.getBoundaryScanner());  
        switch (boundaryScanner) {
 */  
    private static HighlightBuilder.BoundaryScannerType parseBoundaryScanner(BoundaryScanner boundaryScanner) {
                throw new IllegalArgumentException("Unknown BoundaryScanner value: " + boundaryScanner);
     * @param tagsSchema the tags schema to apply (e.g., STYLED)
                    fieldBuilder.phraseLimit(fieldProto.getPhraseLimit());
        }
        }  
            case HIGHLIGHTER_TAGS_SCHEMA_STYLED:
                }
                        fieldBuilder.highlighterType(ProtobufEnumUtils.convertToString(fieldProto.getType().getBuiltin()));  
            }
                    fieldBuilder.boundaryScannerLocale(fieldProto.getBoundaryScannerLocale());
                }
                if (fieldProto.hasForceSource()) {
            highlightBuilder.fragmenter(ProtobufEnumUtils.convertToString(highlightProto.getFragmenter()));
                if (fieldProto.hasPhraseLimit()) {  
                if (fieldProto.getMatchedFieldsCount() > 0) {  
                }  
                if (fieldProto.getPreTagsCount() > 0) {
                }  
class HighlightBuilderProtoUtils {
 * into their corresponding OpenSearch HighlightBuilder implementations for search result highlighting.
     * Apply tags schema to a highlight field by setting pre/post tags.  
                        preTags[j] = fieldProto.getPreTags(j);
        if (highlightProto.hasType()) {  
                    fieldBuilder.order(HighlightBuilder.Order.SCORE);  
        // A spec fix is required and a corresponding protobuf version upgrade.
                    fieldBuilder.numOfFragments(fieldProto.getNumberOfFragments());  
                if (fieldProto.hasNoMatchSize()) {
     */
                }
                    QueryBuilder query = registry.fromProto(fieldProto.getHighlightQuery());  
        if (highlightProto.getPostTagsCount() > 0) {  
        if (highlightProto.hasFragmenter() && highlightProto.getFragmenter() != HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_UNSPECIFIED) {  
        switch (tagsSchema) {  
                    for (int j = 0; j < fieldProto.getPostTagsCount(); j++) {  
            highlightBuilder.boundaryMaxScan(highlightProto.getBoundaryMaxScan());
                    fieldBuilder.preTags(preTags);
        if (highlightProto.hasBoundaryScannerLocale()) {
        }
            highlightBuilder.preTags(preTags);  
                    fieldBuilder.maxAnalyzerOffset(fieldProto.getMaxAnalyzerOffset());
            highlightBuilder.phraseLimit(highlightProto.getPhraseLimit());
                    if (registry == null) {  
                    } else if (fieldProto.getType().hasCustom()) {
        }
                }
            String[] preTags = new String[highlightProto.getPreTagsCount()];
            highlightBuilder.tagsSchema(ProtobufEnumUtils.convertToString(highlightProto.getTagsSchema()));  
        if (highlightProto.hasTagsSchema() && highlightProto.getTagsSchema() != HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_UNSPECIFIED) {
            if (highlightProto.getType().hasBuiltin()
            throw new IllegalArgumentException("Highlight cannot be null");
 *
     */  
                    fieldBuilder.boundaryMaxScan(fieldProto.getBoundaryMaxScan());
                if (fieldProto.hasMaxAnalyzerOffset()) {  
                fieldBuilder.postTags(HighlightBuilder.DEFAULT_POST_TAGS);
     * Convert protobuf BoundaryScanner enum to OpenSearch BoundaryScannerType enum
                    applyTagsSchemaToField(fieldBuilder, fieldProto.getTagsSchema());  
            }
     * Since {@link HighlightBuilder.Field} doesn't have a {@code tagsSchema} method, this helper applies the same
            highlightBuilder.order(HighlightBuilder.Order.SCORE);  
                    }  
import org.opensearch.protobufs.Highlight;
                throw new IllegalStateException("QueryBuilderProtoConverterRegistry cannot be null.");
import org.opensearch.protobufs.HighlighterEncoder;
            highlightBuilder.boundaryScannerType(boundaryScanner);  
            case BOUNDARY_SCANNER_CHARS:  
                highlightBuilder.field(fieldBuilder);  
                if (fieldProto.hasBoundaryScannerLocale()) {
            for (int i = 0; i < highlightProto.getPostTagsCount(); i++) {
                highlightBuilder.highlighterType(highlightProto.getType().getCustom());
        }
                    fieldBuilder.requireFieldMatch(fieldProto.getRequireFieldMatch());
                throw new IllegalArgumentException("Unknown tags schema: " + tagsSchema);
 * This class provides methods to transform Protocol Buffer representations of highlights
        if (highlightProto.hasBoundaryScanner() && highlightProto.getBoundaryScanner() != BoundaryScanner.BOUNDARY_SCANNER_UNSPECIFIED) {
            for (int i = 0; i < highlightProto.getPreTagsCount(); i++) {  
                return HighlightBuilder.BoundaryScannerType.WORD;  
        if (highlightProto.hasBoundaryChars()) {
            case HIGHLIGHTER_TAGS_SCHEMA_DEFAULT:
            highlightBuilder.boundaryScannerLocale(highlightProto.getBoundaryScannerLocale());  
import org.opensearch.protobufs.HighlighterTagsSchema;
                }
     * @param fieldBuilder the highlight field builder to apply the tags schema to
                        postTags[j] = fieldProto.getPostTags(j);
    /**
        }
            highlightBuilder.highlightFilter(highlightProto.getHighlightFilter());
                HighlightBuilder.Field fieldBuilder = new HighlightBuilder.Field(fieldName);  
import org.opensearch.transport.grpc.proto.request.common.ObjectMapProtoUtils;
            highlightBuilder.maxAnalyzerOffset(highlightProto.getMaxAnalyzerOffset());
                }
     * This mirrors the behavior of {@link HighlightBuilder#tagsSchema(String)} but for field-level settings.
        if (highlightProto.hasBoundaryMaxScan()) {  
     * parses the Protocol Buffer representation and creates a properly configured
        if (highlightProto.hasHighlightFilter()) {  
            highlightBuilder.requireFieldMatch(highlightProto.getRequireFieldMatch());
                break;
        }
                String fieldName = entry.getKey();  
     *  
                    for (int j = 0; j < fieldProto.getPreTagsCount(); j++) {
    }  
                        fieldBuilder.highlighterType(fieldProto.getType().getCustom());
            highlightBuilder.options(ObjectMapProtoUtils.fromProto(highlightProto.getOptions()));  
                    fieldBuilder.highlightFilter(fieldProto.getHighlightFilter());
        }
    /**
        // TODO: Support useExplicitFieldOrder
        }
        if (highlightProto.hasNumberOfFragments()) {
            case BOUNDARY_SCANNER_WORD:
                    if (fieldProto.getType().hasBuiltin()
                    fieldBuilder.forceSource(fieldProto.getForceSource());
        }
            }
        if (highlightProto.hasForceSource()) {
                highlightBuilder.highlighterType(ProtobufEnumUtils.convertToString(highlightProto.getType().getBuiltin()));  
     * @param registry The registry for converting highlight queries
        }  
                    for (int j = 0; j < fieldProto.getMatchedFieldsCount(); j++) {
                if (fieldProto.hasHighlightFilter()) {
                }
                }
    }  
     * <p>
        }  
     * Similar to {@link HighlightBuilder#fromXContent(XContentParser)}, this method  
                    fieldBuilder.fragmentSize(fieldProto.getFragmentSize());
import org.opensearch.protobufs.BoundaryScanner;
        return highlightBuilder;
                    fieldBuilder.matchedFields(matchedFields);
                    fieldBuilder.fragmenter(ProtobufEnumUtils.convertToString(fieldProto.getFragmenter()));  
        if (highlightProto.hasOptions()) {
                return HighlightBuilder.BoundaryScannerType.SENTENCE;
                }
        if (highlightProto.hasEncoder() && highlightProto.getEncoder() != HighlighterEncoder.HIGHLIGHTER_ENCODER_UNSPECIFIED) {  
 * The OpenSearch Contributors require contributions made to  
                fieldBuilder.postTags(HighlightBuilder.DEFAULT_STYLED_POST_TAGS);  
import org.opensearch.index.query.QueryBuilder;
                    fieldBuilder.noMatchSize(fieldProto.getNoMatchSize());
                if (fieldProto.hasHighlightQuery()) {
                }
                break;
        }
        if (highlightProto.hasRequireFieldMatch()) {  
 */  
                fieldBuilder.preTags(HighlightBuilder.DEFAULT_STYLED_PRE_TAG);
        if (highlightProto.getFieldsCount() > 0) {
    /**
     * @see HighlightBuilder#tagsSchema(String)  
            if (registry == null) {
                if (fieldProto.hasBoundaryMaxScan()) {
                if (fieldProto.hasOrder() && fieldProto.getOrder() == HighlighterOrder.HIGHLIGHTER_ORDER_SCORE) {
            highlightBuilder.forceSource(highlightProto.getForceSource());  
     * Converts a Protocol Buffer Highlight to an OpenSearch HighlightBuilder.
     * @throws IllegalArgumentException if highlightProto is null
            QueryBuilder query = registry.fromProto(highlightProto.getHighlightQuery());
                        && fieldProto.getType().getBuiltin() != BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_UNSPECIFIED) {
        if (highlightProto == null) {
            highlightBuilder.highlightQuery(query);
            case BOUNDARY_SCANNER_SENTENCE:
            highlightBuilder.numOfFragments(highlightProto.getNumberOfFragments());  
        }
                if (fieldProto.hasBoundaryChars()) {  
                if (fieldProto.getPostTagsCount() > 0) {
                && highlightProto.getType().getBuiltin() != BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_UNSPECIFIED) {
                }
            for (java.util.Map.Entry<String, org.opensearch.protobufs.HighlightField> entry : highlightProto.getFieldsMap().entrySet()) {
        }  
     * logic by directly setting the pre/post tags on the field.
        }
                    fieldBuilder.highlightQuery(query);
                }  
import org.opensearch.protobufs.HighlighterOrder;
                }
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
                postTags[i] = highlightProto.getPostTags(i);  
     * @param highlightProto The Protocol Buffer Highlight to convert
 * SPDX-License-Identifier: Apache-2.0
     */
     * The {@code tagsSchema} method on {@link HighlightBuilder} sets built-in pre and post tags based on a schema name.  
                fieldBuilder.preTags(HighlightBuilder.DEFAULT_PRE_TAGS);  
                        matchedFields[j] = fieldProto.getMatchedFields(j);  
            }  
                if (fieldProto.hasOptions()) {  
                }  
                if (fieldProto.hasFragmenter() && fieldProto.getFragmenter() != HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_UNSPECIFIED) {
     *  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
        if (highlightProto.getPreTagsCount() > 0) {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        }
                    String[] matchedFields = new String[fieldProto.getMatchedFieldsCount()];
                }
        if (highlightProto.hasNoMatchSize()) {
                    String[] preTags = new String[fieldProto.getPreTagsCount()];  
                    }
                if (fieldProto.hasNumberOfFragments()) {
                    }
/*  
                if (fieldProto.hasFragmentOffset()) {
                preTags[i] = highlightProto.getPreTags(i);
        if (highlightProto.hasMaxAnalyzerOffset()) {
     * HighlightBuilder with the appropriate settings.
                    }
        }  
            HighlightBuilder.BoundaryScannerType boundaryScanner = parseBoundaryScanner(highlightProto.getBoundaryScanner());
                if (fieldProto.hasFragmentSize()) {  
                }
 * Utility class for converting Highlight Protocol Buffers to OpenSearch objects.  
        }  
        // Utility class, no instances
    private HighlightBuilderProtoUtils() {  
        }
        }
    static HighlightBuilder fromProto(Highlight highlightProto, QueryBuilderProtoConverterRegistry registry) {  
                    fieldBuilder.boundaryScannerType(boundaryScanner);
    private static void applyTagsSchemaToField(HighlightBuilder.Field fieldBuilder, HighlighterTagsSchema tagsSchema) {
                org.opensearch.protobufs.HighlightField fieldProto = entry.getValue();
            }  
                if (fieldProto.hasRequireFieldMatch()) {
                    }  
    }
            highlightBuilder.postTags(postTags);
                }  
        if (highlightProto.hasHighlightQuery()) {  
                    fieldBuilder.options(ObjectMapProtoUtils.fromProto(fieldProto.getOptions()));
            highlightBuilder.boundaryChars(highlightProto.getBoundaryChars().toCharArray());
                }
