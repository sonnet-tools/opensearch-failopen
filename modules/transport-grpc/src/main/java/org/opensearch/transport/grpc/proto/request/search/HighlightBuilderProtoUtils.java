import org.opensearch.protobufs.BoundaryScanner;
                fieldBuilder.preTags(HighlightBuilder.DEFAULT_PRE_TAGS);
                throw new IllegalArgumentException("Unknown tags schema: " + tagsSchema);
    }
            highlightBuilder.boundaryScannerType(boundaryScanner);
                    fieldBuilder.preTags(preTags);
                if (fieldProto.hasPhraseLimit()) {
                if (fieldProto.hasBoundaryChars()) {
     * The {@code tagsSchema} method on {@link HighlightBuilder} sets built-in pre and post tags based on a schema name.
    /**
 * The OpenSearch Contributors require contributions made to
                break;
            case BOUNDARY_SCANNER_CHARS:
                    }
     * Convert protobuf BoundaryScanner enum to OpenSearch BoundaryScannerType enum
 * this file be licensed under the Apache-2.0 license or a
                    QueryBuilder query = registry.fromProto(fieldProto.getHighlightQuery());
        if (highlightProto.hasRequireFieldMatch()) {
            default:
        }
    }
                    if (fieldProto.getType().hasBuiltin()
                }
                    }
    private static void applyTagsSchemaToField(HighlightBuilder.Field fieldBuilder, HighlighterTagsSchema tagsSchema) {
        }
                        postTags[j] = fieldProto.getPostTags(j);
        }
        }
            highlightBuilder.highlightFilter(highlightProto.getHighlightFilter());
            throw new IllegalArgumentException("Highlight cannot be null");
            case HIGHLIGHTER_TAGS_SCHEMA_STYLED:
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        if (highlightProto.hasPhraseLimit()) {
            }
        }
            highlightBuilder.numOfFragments(highlightProto.getNumberOfFragments());
 * SPDX-License-Identifier: Apache-2.0
            } else if (highlightProto.getType().hasCustom()) {
        // A spec fix is required and a corresponding protobuf version upgrade.
                if (fieldProto.hasHighlightQuery()) {
            }
    /**
                if (fieldProto.getMatchedFieldsCount() > 0) {
                        fieldBuilder.highlighterType(fieldProto.getType().getCustom());
                    fieldBuilder.highlightFilter(fieldProto.getHighlightFilter());
            highlightBuilder.noMatchSize(highlightProto.getNoMatchSize());
                    fieldBuilder.boundaryMaxScan(fieldProto.getBoundaryMaxScan());
        }
        return highlightBuilder;
                    String[] preTags = new String[fieldProto.getPreTagsCount()];
import org.opensearch.protobufs.HighlighterTagsSchema;
                }
            case BOUNDARY_SCANNER_WORD:
 * compatible open source license.
        if (highlightProto.hasNoMatchSize()) {
     *
}
import org.opensearch.protobufs.HighlighterOrder;
                    }
            }
     * <p>
        }
            HighlightBuilder.BoundaryScannerType boundaryScanner = parseBoundaryScanner(highlightProto.getBoundaryScanner());
        if (highlightProto.getPreTagsCount() > 0) {
        }
                    String[] postTags = new String[fieldProto.getPostTagsCount()];
     * @param registry The registry for converting highlight queries
                }
        }
            highlightBuilder.order(HighlightBuilder.Order.SCORE);
                    fieldBuilder.fragmenter(ProtobufEnumUtils.convertToString(fieldProto.getFragmenter()));
                }
                        fieldBuilder.highlighterType(ProtobufEnumUtils.convertToString(fieldProto.getType().getBuiltin()));
            highlightBuilder.tagsSchema(ProtobufEnumUtils.convertToString(highlightProto.getTagsSchema()));
            for (int i = 0; i < highlightProto.getPostTagsCount(); i++) {
                break;
                }
     * @return A configured HighlightBuilder instance
                if (fieldProto.hasHighlightFilter()) {
                }
                }
                }
                }
                }
            case BOUNDARY_SCANNER_SENTENCE:
import org.opensearch.core.xcontent.XContentParser;
                }
        }
import org.opensearch.protobufs.BuiltinHighlighterType;
        switch (tagsSchema) {
        switch (boundaryScanner) {
        if (highlightProto.getPostTagsCount() > 0) {
                postTags[i] = highlightProto.getPostTags(i);
                    fieldBuilder.postTags(postTags);
                    fieldBuilder.fragmentOffset(fieldProto.getFragmentOffset());
 *
                    fieldBuilder.noMatchSize(fieldProto.getNoMatchSize());
                if (fieldProto.hasFragmentSize()) {
     * @param tagsSchema the tags schema to apply (e.g., STYLED)
import org.opensearch.protobufs.HighlighterFragmenter;
        if (highlightProto.hasBoundaryChars()) {
                }
        if (highlightProto.hasFragmentSize()) {
        if (highlightProto.hasHighlightFilter()) {
                    fieldBuilder.order(HighlightBuilder.Order.SCORE);
                }
        }
     *
            QueryBuilder query = registry.fromProto(highlightProto.getHighlightQuery());
                    fieldBuilder.numOfFragments(fieldProto.getNumberOfFragments());
        if (highlightProto.hasTagsSchema() && highlightProto.getTagsSchema() != HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_UNSPECIFIED) {
        }
        if (highlightProto.hasFragmenter() && highlightProto.getFragmenter() != HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_UNSPECIFIED) {
    static HighlightBuilder fromProto(Highlight highlightProto, QueryBuilderProtoConverterRegistry registry) {
            highlightBuilder.preTags(preTags);
     * Similar to {@link HighlightBuilder#fromXContent(XContentParser)}, this method
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
     * @param fieldBuilder the highlight field builder to apply the tags schema to
import org.opensearch.transport.grpc.proto.request.common.ObjectMapProtoUtils;
    /**
                throw new IllegalStateException("QueryBuilderProtoConverterRegistry cannot be null.");
                preTags[i] = highlightProto.getPreTags(i);
            for (java.util.Map.Entry<String, org.opensearch.protobufs.HighlightField> entry : highlightProto.getFieldsMap().entrySet()) {
                    fieldBuilder.matchedFields(matchedFields);
     * @throws IllegalArgumentException if highlightProto is null
                        && fieldProto.getType().getBuiltin() != BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_UNSPECIFIED) {
        if (highlightProto.getFieldsCount() > 0) {
            highlightBuilder.encoder(ProtobufEnumUtils.convertToString(highlightProto.getEncoder()));
                    }
                if (fieldProto.hasNumberOfFragments()) {
                if (fieldProto.hasBoundaryScanner() && fieldProto.getBoundaryScanner() != BoundaryScanner.BOUNDARY_SCANNER_UNSPECIFIED) {
                }
                        throw new IllegalStateException("QueryBuilderProtoConverterRegistry cannot be null.");
 * into their corresponding OpenSearch HighlightBuilder implementations for search result highlighting.
            case HIGHLIGHTER_TAGS_SCHEMA_DEFAULT:
        }
            highlightBuilder.highlightQuery(query);
            highlightBuilder.requireFieldMatch(highlightProto.getRequireFieldMatch());
     * Converts a Protocol Buffer Highlight to an OpenSearch HighlightBuilder.
                }
class HighlightBuilderProtoUtils {
import org.opensearch.protobufs.HighlighterEncoder;
                if (fieldProto.hasNoMatchSize()) {
                    fieldBuilder.boundaryChars(fieldProto.getBoundaryChars().toCharArray());
        }
     * HighlightBuilder with the appropriate settings.
                fieldBuilder.postTags(HighlightBuilder.DEFAULT_POST_TAGS);
        if (highlightProto.hasOrder() && highlightProto.getOrder() == HighlighterOrder.HIGHLIGHTER_ORDER_SCORE) {
            default:
        if (highlightProto.hasBoundaryScannerLocale()) {
            highlightBuilder.boundaryChars(highlightProto.getBoundaryChars().toCharArray());
                if (fieldProto.hasForceSource()) {
import org.opensearch.protobufs.Highlight;
        if (highlightProto.hasBoundaryMaxScan()) {
                if (fieldProto.getPostTagsCount() > 0) {
            String[] preTags = new String[highlightProto.getPreTagsCount()];
            highlightBuilder.forceSource(highlightProto.getForceSource());
        if (highlightProto.hasForceSource()) {
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
        if (highlightProto.hasType()) {
                    for (int j = 0; j < fieldProto.getPreTagsCount(); j++) {
                if (fieldProto.hasFragmentOffset()) {
                        matchedFields[j] = fieldProto.getMatchedFields(j);
        if (highlightProto.hasBoundaryScanner() && highlightProto.getBoundaryScanner() != BoundaryScanner.BOUNDARY_SCANNER_UNSPECIFIED) {
            highlightBuilder.options(ObjectMapProtoUtils.fromProto(highlightProto.getOptions()));
        if (highlightProto == null) {
                HighlightBuilder.Field fieldBuilder = new HighlightBuilder.Field(fieldName);
            highlightBuilder.postTags(postTags);
    private HighlightBuilderProtoUtils() {
                if (fieldProto.hasTagsSchema() && fieldProto.getTagsSchema() != HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_UNSPECIFIED) {
                highlightBuilder.highlighterType(highlightProto.getType().getCustom());
                    } else if (fieldProto.getType().hasCustom()) {
                    applyTagsSchemaToField(fieldBuilder, fieldProto.getTagsSchema());
                    HighlightBuilder.BoundaryScannerType boundaryScanner = parseBoundaryScanner(fieldProto.getBoundaryScanner());
 * This class provides methods to transform Protocol Buffer representations of highlights
                    fieldBuilder.boundaryScannerType(boundaryScanner);
    }
                    fieldBuilder.options(ObjectMapProtoUtils.fromProto(fieldProto.getOptions()));
                fieldBuilder.preTags(HighlightBuilder.DEFAULT_STYLED_PRE_TAG);
                highlightBuilder.field(fieldBuilder);
                        preTags[j] = fieldProto.getPreTags(j);
                    fieldBuilder.phraseLimit(fieldProto.getPhraseLimit());
        }
     * logic by directly setting the pre/post tags on the field.
            }
     * Apply tags schema to a highlight field by setting pre/post tags.
                }
     */
 */
                if (fieldProto.getPreTagsCount() > 0) {
        if (highlightProto.hasNumberOfFragments()) {
                }
            highlightBuilder.fragmentSize(highlightProto.getFragmentSize());
                String fieldName = entry.getKey();
                }
     * @see HighlightBuilder#tagsSchema(String)
                    String[] matchedFields = new String[fieldProto.getMatchedFieldsCount()];
                return HighlightBuilder.BoundaryScannerType.SENTENCE;
                    fieldBuilder.maxAnalyzerOffset(fieldProto.getMaxAnalyzerOffset());
                && highlightProto.getType().getBuiltin() != BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_UNSPECIFIED) {
 * Utility class for converting Highlight Protocol Buffers to OpenSearch objects.
        if (highlightProto.hasOptions()) {
            }
                if (fieldProto.hasRequireFieldMatch()) {
            if (highlightProto.getType().hasBuiltin()
    private static HighlightBuilder.BoundaryScannerType parseBoundaryScanner(BoundaryScanner boundaryScanner) {
package org.opensearch.transport.grpc.proto.request.search;
 */
                if (fieldProto.hasFragmenter() && fieldProto.getFragmenter() != HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_UNSPECIFIED) {
                if (fieldProto.hasBoundaryMaxScan()) {
                }
import org.opensearch.transport.grpc.util.ProtobufEnumUtils;
        }
                return HighlightBuilder.BoundaryScannerType.CHARS;
                    fieldBuilder.forceSource(fieldProto.getForceSource());
                highlightBuilder.highlighterType(ProtobufEnumUtils.convertToString(highlightProto.getType().getBuiltin()));
        }
     * This mirrors the behavior of {@link HighlightBuilder#tagsSchema(String)} but for field-level settings.
                if (fieldProto.hasType()) {
                }
        }
import org.opensearch.index.query.QueryBuilder;
        }
                if (fieldProto.hasOrder() && fieldProto.getOrder() == HighlighterOrder.HIGHLIGHTER_ORDER_SCORE) {
                    fieldBuilder.requireFieldMatch(fieldProto.getRequireFieldMatch());
            highlightBuilder.boundaryScannerLocale(highlightProto.getBoundaryScannerLocale());
            String[] postTags = new String[highlightProto.getPostTagsCount()];
            for (int i = 0; i < highlightProto.getPreTagsCount(); i++) {
        }
     * Since {@link HighlightBuilder.Field} doesn't have a {@code tagsSchema} method, this helper applies the same
            highlightBuilder.maxAnalyzerOffset(highlightProto.getMaxAnalyzerOffset());
                org.opensearch.protobufs.HighlightField fieldProto = entry.getValue();
/**
     */
     * parses the Protocol Buffer representation and creates a properly configured
                    for (int j = 0; j < fieldProto.getPostTagsCount(); j++) {
            if (registry == null) {
                fieldBuilder.postTags(HighlightBuilder.DEFAULT_STYLED_POST_TAGS);
        }
            highlightBuilder.phraseLimit(highlightProto.getPhraseLimit());
        if (highlightProto.hasHighlightQuery()) {
     */
                }
                    fieldBuilder.boundaryScannerLocale(fieldProto.getBoundaryScannerLocale());
/*
        if (highlightProto.hasMaxAnalyzerOffset()) {
                    fieldBuilder.highlightQuery(query);
    }
        }
        if (highlightProto.hasEncoder() && highlightProto.getEncoder() != HighlighterEncoder.HIGHLIGHTER_ENCODER_UNSPECIFIED) {
            highlightBuilder.boundaryMaxScan(highlightProto.getBoundaryMaxScan());
        }
                }
                if (fieldProto.hasBoundaryScannerLocale()) {
            highlightBuilder.fragmenter(ProtobufEnumUtils.convertToString(highlightProto.getFragmenter()));
        }
     * @param highlightProto The Protocol Buffer Highlight to convert
                throw new IllegalArgumentException("Unknown BoundaryScanner value: " + boundaryScanner);
                    fieldBuilder.fragmentSize(fieldProto.getFragmentSize());
        }
                if (fieldProto.hasMaxAnalyzerOffset()) {
                    }
        // TODO: Support useExplicitFieldOrder
        // Utility class, no instances
                    for (int j = 0; j < fieldProto.getMatchedFieldsCount(); j++) {
                    if (registry == null) {
                return HighlightBuilder.BoundaryScannerType.WORD;
                if (fieldProto.hasOptions()) {
