        assertArrayEquals(HighlightBuilder.DEFAULT_STYLED_POST_TAGS, postTags);
import org.opensearch.protobufs.HighlighterTagsSchema;
        assertEquals(2, preTags.length);
        assertEquals(1, fields.size());
            .addPreTags("<em>")
        Highlight highlightSentence = Highlight.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_SENTENCE).build();
import org.opensearch.protobufs.HighlighterEncoder;
import org.opensearch.protobufs.MatchAllQuery;
        assertEquals("title", field.name());
    }
        assertEquals(50, (int) result.boundaryMaxScan());
            .setHighlightFilter(true)
            .putFields("title", titleField)
            .setNumberOfFragments(3)
        assertNotNull(result);
            .setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_SCORE)
        assertEquals(3, (int) field.numOfFragments());
            .setNoMatchSize(250)
        assertNotNull(postTags);
    @Override
        assertEquals(42, resultOptions.get("key2"));
    public void testFromProto_WithTagsAndBasicSettings() {
        HighlightField fieldWord = HighlightField.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD).build();
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
    }
 * The OpenSearch Contributors require contributions made to
        // The tags schema should have been applied - verify the field was created
            .setMaxAnalyzerOffset(1000)
        HighlightBuilder.Field field = fields.get(0);
    }
    }
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
            .setFragmenter(HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_SPAN)
        assertNotNull(result);
        List<HighlightBuilder.Field> fields = result.fields();
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setFragmentSize(200)
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, result.boundaryScannerType());
            .setFragmenter(HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_SPAN)
    public void testFromProto_WithMultipleFields() {
        assertNotNull(result);
import org.opensearch.test.OpenSearchTestCase;
        HighlightField titleField = HighlightField.newBuilder()
    public void testFromProto_WithAllFieldSettings() {
        Highlight highlightProto = Highlight.newBuilder()
        assertEquals(1, fields.size());
        assertEquals(150, (int) field.fragmentSize());
        // Verify default tags were applied
    }
    }
            .setFragmentOffset(10)
    public void testFromProto_WithFieldOrder() {
        assertNull(result.encoder());
        assertEquals(HighlightBuilder.BoundaryScannerType.CHARS, resultChars.boundaryScannerType());
        String[] postTags = field.postTags();
            .addPreTags("<em>")
        assertEquals(100, (int) field.noMatchSize());
        List<HighlightBuilder.Field> fields = result.fields();
package org.opensearch.transport.grpc.proto.request.search;
        HighlightField contentField = HighlightField.newBuilder()
        assertEquals(150, (int) result.fragmentSize());
        assertEquals("</mark>", postTags[0]);
        assertEquals("field_value", fieldOptions.get("field_key"));
        assertEquals("fvh", field.highlighterType());
            .setRequireFieldMatch(true)
        List<HighlightBuilder.Field> fields = result.fields();
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_FVH).build())
        HighlightField fieldProto = HighlightField.newBuilder().setTagsSchema(HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_STYLED).build();
        assertEquals(1, preTags.length);
    }
        assertNotNull(preTags);
        assertEquals("html", result.encoder());
        assertEquals("</em>", postTags[0]);
        String[] postTags = result.postTags();
    public void testFromProto_WithFieldPhraseLimit() {
            .build();
            .setHighlightQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
            .build();
        assertEquals("<strong>", preTags[1]);
                ObjectMap.newBuilder()
            .setNumberOfFragments(2)
        assertEquals("simple", fields.get(0).fragmenter());
        // Test with all field settings combined (excluding tagsSchema to test explicit pre/post tags)
        assertNotNull(result.highlightQuery());
        assertEquals(1, fields.size());
        assertEquals(250, (int) field.noMatchSize());
    }
        Highlight highlightProto = Highlight.newBuilder().setTagsSchema(HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_STYLED).build();
import org.opensearch.protobufs.HighlighterOrder;
        String[] preTags = field.preTags();
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setHighlightFilter(true)
            )
            .putFields("field3", fieldSentence)
        HighlightBuilder.Field field = fields.get(0);
        HighlightField fieldChars = HighlightField.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_CHARS).build();
            .addPreTags("<em>")
        HighlightField fieldProto = HighlightField.newBuilder().setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_SCORE).build();
        // Check fields
            .setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_UNSPECIFIED)
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_FVH).build())
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, resultWord.boundaryScannerType());
        assertEquals("fvh", result.highlighterType());
        String[] preTags = result.preTags();
            .addMatchedFields("title")
        assertEquals(4, boundaryChars.length);
            .build();
        });
        assertArrayEquals(HighlightBuilder.DEFAULT_PRE_TAGS, preTags);
        HighlightBuilder.Field field = fields.get(0);
        Highlight highlightWithQuery = Highlight.newBuilder()
        Map<String, Object> fieldOptions = titleField.options();
        assertNotNull(preTags);
            .setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD)
                    .build()
            .setNumberOfFragments(3)
            .setEncoder(HighlighterEncoder.HIGHLIGHTER_ENCODER_UNSPECIFIED)
        assertEquals("title", field.name());
import org.opensearch.protobufs.QueryContainer;
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        assertNotNull(result);
        assertTrue(result.forceSource());
            .setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_SCORE)
        assertEquals(1, fields.size());
        assertEquals("</strong>", postTags[1]);
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals("<em>", preTags[0]);
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, result.boundaryScannerType());
        assertEquals(1000, (int) result.maxAnalyzerOffset());
            .putFields("content", contentField)
        List<HighlightBuilder.Field> fields = result.fields();
    public void testFromProto_WithFieldOptions() {
            .build();
        assertEquals("match_all", field.highlightQuery().getName());
    }
            .build();
import java.util.Map;
    public void testFromProto_WithHighlighterSettings() {
        assertEquals(10, (int) result.phraseLimit());
        HighlightBuilder resultChars = HighlightBuilderProtoUtils.fromProto(highlightChars, registry);
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
 */
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_UNSPECIFIED)
        // Check global settings
        assertEquals("title", resultTitleField.name());
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertArrayEquals(HighlightBuilder.DEFAULT_POST_TAGS, postTags);
        assertEquals(1, preTags.length);
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals('.', boundaryChars[0]);
            .build();
        assertNull(result.fragmenter());
            .setBoundaryScannerLocale("en-US")
            .setHighlightQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertNotNull(postTags);
        assertTrue(field.requireFieldMatch());
            .putFields("field1", fieldChars)
        HighlightBuilder.Field field = fields.get(0);
            .setFragmenter(HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_UNSPECIFIED)
 * compatible open source license.
        assertEquals(HighlightBuilder.Order.SCORE, result.order());
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals(1, postTags.length);
                    .putFields("key2", ObjectMap.Value.newBuilder().setInt32(42).build())
        registry = new QueryBuilderProtoConverterRegistryImpl();
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
 * SPDX-License-Identifier: Apache-2.0
            .setRequireFieldMatch(true)
            .setOptions(
    }
        HighlightField fieldProto = HighlightField.newBuilder().setBoundaryChars(".,!?;:").setBoundaryScannerLocale("fr-FR").build();
        assertEquals(HighlightBuilder.Order.SCORE, field.order());
        HighlightField fieldProto = HighlightField.newBuilder()
            .setNumberOfFragments(5)
        // Set up the registry with all built-in converters
    public void testFromProto_NullHighlight() {
        HighlightBuilder.Field titleField = fields.get(0);
            .addPostTags("</em>")
            .build();
        HighlightBuilder.Field field = fields.get(0);
        Highlight highlightWord = Highlight.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD).build();
        assertTrue(result.requireFieldMatch());
            .setPhraseLimit(10)
        char[] boundaryChars = field.boundaryChars();
        assertTrue(field.forceSource());
        assertNotNull(result);
 */
        Highlight highlightProto = Highlight.newBuilder()
            .setFragmentSize(150)
            .setForceSource(true)
        List<HighlightBuilder.Field> fields = result.fields();
        // fragmentOffset is package-private, can't verify directly
        assertEquals("<strong>", preTags[1]);
        assertEquals("title", titleField.name());
        assertNotNull(result.boundaryScannerLocale());
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, field.boundaryScannerType());
            .setNoMatchSize(100)
        assertEquals("plain", resultContentField.highlighterType());
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
            .setBoundaryMaxScan(50)
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_PLAIN).build())
        assertNull(result.boundaryScannerType());
        String[] preTags = field.preTags();
    public void testFromProto_WithBoundarySettings() {
        HighlightBuilder.Field field = fields.get(0);
        assertEquals(1, fields.size());
import org.opensearch.protobufs.HighlighterFragmenter;
    }
        Highlight highlightProto = Highlight.newBuilder().build();
        assertEquals("<em>", preTags[0]);
        assertEquals(6, boundaryChars.length);
        assertNotNull(result);
        assertEquals(HighlightBuilder.Order.SCORE, field.order());
    }
}
        assertEquals(512, (int) field.phraseLimit());
            .addPreTags("<mark>")
            .build();
            .setEncoder(HighlighterEncoder.HIGHLIGHTER_ENCODER_HTML)
        assertEquals("span", result.fragmenter());
        assertNotNull(result);
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
    }
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        // matchedFields is package-private, can't verify directly
        assertEquals("en-US", result.boundaryScannerLocale().toLanguageTag());
        assertEquals("unified", result.highlighterType());
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, fields.get(1).boundaryScannerType());
            .setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_SCORE)
        assertTrue(result.highlightFilter());
            .setTagsSchema(HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_DEFAULT)
        assertEquals(200, (int) result.noMatchSize());
        assertEquals("fr-FR", field.boundaryScannerLocale().toLanguageTag());
        HighlightField fieldProto = HighlightField.newBuilder().setForceSource(true).build();
import java.util.List;
        HighlightField fieldProto = HighlightField.newBuilder()
        assertEquals(1, fields.size());
        assertNotNull(result);
        Highlight highlightProto = Highlight.newBuilder()
        assertNotNull(titleField.highlightQuery());
        assertNull(result.highlighterType());
        List<HighlightBuilder.Field> fields = result.fields();
        List<HighlightBuilder.Field> fields = result.fields();
        assertEquals("</em>", postTags[0]);
        String[] preTags = field.preTags();
            .build();
            .setForceSource(true)
                    .putFields("key1", ObjectMap.Value.newBuilder().setString("value1").build())
        assertEquals("Highlight cannot be null", exception.getMessage());
        List<HighlightBuilder.Field> fields = result.fields();
        HighlightBuilder.Field resultContentField = fields.get(1);
        String[] preTags = titleField.preTags();
    public void testFromProto_WithHighlightQuery() {
        assertEquals(30, (int) field.boundaryMaxScan());
            .build();
        assertEquals(2, preTags.length);
        List<HighlightBuilder.Field> fields = result.fields();
            .setMaxAnalyzerOffset(500)
            .setNumberOfFragments(5)
    public void testFromProto_EmptyHighlight() {
    }
            .setBoundaryScannerLocale("en-US")
        assertEquals(1, fields.size());
import org.opensearch.protobufs.BuiltinHighlighterType;
        assertEquals("QueryBuilderProtoConverterRegistry cannot be null.", exception.getMessage());
            .setHighlightQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
        assertEquals(1000, (int) field.maxAnalyzerOffset());
            .build();
    }
        assertEquals(2, postTags.length);
        assertNotNull(resultOptions);
        HighlightField fieldProto = HighlightField.newBuilder()
            )
    public void testFromProto_WithFieldRequireFieldMatch() {
    }
        assertEquals("</em>", postTags[0]);
        String[] postTags = titleField.postTags();
        assertEquals(1, fields.size());
            .setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD)
/**
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertNotNull(result);
        assertEquals(1, fields.size());
    public void testFromProto_WithoutRegistry() {
        assertNotNull(result);
        assertEquals(200, (int) resultContentField.fragmentSize());
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setOptions(
    }
    public void testFromProto_WithFieldTagsSchemaDefault() {
            .addPostTags("</strong>")
        assertTrue(field.highlightFilter());
        HighlightBuilder.Field resultTitleField = fields.get(0);
        assertTrue(result.highlightQuery() instanceof org.opensearch.index.query.MatchAllQueryBuilder);
import org.opensearch.protobufs.BoundaryScanner;
    }
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        String[] postTags = field.postTags();
        assertEquals(2, fields.size());
    public void testFromProto_WithOptions() {
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
    public void testFromProto_WithFieldBoundaryCharsAndLocale() {
            .addPostTags("</mark>")
    public void setUp() throws Exception {
    public void testFromProto_WithFieldBoundaryScannerTypes() {
            .setFragmentSize(100)
            .setBoundaryMaxScan(30)
        assertEquals("title", field.name());
        HighlightBuilder resultWord = HighlightBuilderProtoUtils.fromProto(highlightWord, registry);
        assertNotNull(preTags);
            .setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD)
        HighlightField fieldProto = HighlightField.newBuilder()
        List<HighlightBuilder.Field> fields = result.fields();
        assertNotNull(field.boundaryScannerLocale());
        assertNotNull(result);
            .setNoMatchSize(200)
        HighlightBuilder.Field titleField = fields.get(0);
/*
        assertEquals(1, fields.size());
        HighlightBuilder.Field field = fields.get(0);
        Highlight highlightProto = Highlight.newBuilder()
        assertNotNull(result);
    }
        HighlightField fieldProto = HighlightField.newBuilder()
        HighlightBuilder.Field field = fields.get(0);
        assertNotNull(field.highlightQuery());
        assertNotNull(resultContentField);
 *
            .build();
        // Verify styled tags were applied
        assertNotNull(fieldOptions);
    }
import org.opensearch.protobufs.HighlightField;
    public void testFromProto_WithFieldFragmenter() {
        assertEquals(100, (int) resultTitleField.fragmentSize());
        assertEquals(HighlightBuilder.BoundaryScannerType.SENTENCE, resultSentence.boundaryScannerType());
    public void testFromProto_WithUnspecifiedEnums() {
            .setFragmentSize(100)
        Highlight highlightChars = Highlight.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_CHARS).build();
        assertEquals(3, (int) result.numOfFragments());
        assertEquals("fvh", resultTitleField.highlighterType());
        HighlightField fieldProto = HighlightField.newBuilder().setRequireFieldMatch(false).build();
        // The tags schema should have been applied - verify the field was created
        assertNotNull(result);
import org.opensearch.protobufs.Highlight;
    public void testFromProto_WithFieldHighlightQueryAndNoMatchSize() {
        assertEquals(3, fields.size());
            .addPostTags("</strong>")
            .build();
    public void testFromProto_WithFieldPreAndPostTags() {
    }
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        });
import org.opensearch.protobufs.ObjectMap;
        assertEquals(HighlightBuilder.Order.SCORE, result.order());
        assertNotNull(result);
    public void testFromProto_WithFieldTagsSchemaStyled() {
    public void testFromProto_WithTagsSchema() {
            .setBoundaryChars(".,!?")
            .setHighlightQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
            .addPreTags("<strong>")
        assertNotNull(postTags);
        assertEquals(5, (int) resultContentField.numOfFragments());
                ObjectMap.newBuilder().putFields("field_key", ObjectMap.Value.newBuilder().setString("field_value").build()).build()
            .build();
            .build();
        HighlightField fieldSentence = HighlightField.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_SENTENCE).build();
        HighlightBuilder resultSentence = HighlightBuilderProtoUtils.fromProto(highlightSentence, registry);
    }
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals("<mark>", preTags[0]);
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_UNSPECIFIED).build())
            HighlightBuilderProtoUtils.fromProto(highlightWithQuery, null);
        Highlight highlightProto = Highlight.newBuilder()
        assertEquals(1, fields.size());
import org.opensearch.protobufs.HighlighterType;
            HighlightBuilderProtoUtils.fromProto(null, registry);
        assertEquals(256, (int) field.phraseLimit());
        assertNotNull(result);
        Highlight highlightProto = Highlight.newBuilder().putFields("content", fieldProto).build();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
        assertEquals(2, (int) resultTitleField.numOfFragments());
        List<HighlightBuilder.Field> fields = result.fields();
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals(5, (int) result.numOfFragments());
        assertNull(result.order());
        assertNotNull(result);
            .build();
        List<HighlightBuilder.Field> fields = result.fields();
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> {
        assertEquals(1, postTags.length);
        assertNotNull(result);
        List<HighlightBuilder.Field> fields = result.fields();
        assertArrayEquals(HighlightBuilder.DEFAULT_STYLED_PRE_TAG, preTags);
        assertFalse(field.requireFieldMatch());
        super.setUp();
        Highlight highlightProto = Highlight.newBuilder()
        assertEquals("span", field.fragmenter());
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_FVH).build())
            .addPostTags("</em>")
        String[] preTags = result.preTags();
    }
            .setMaxAnalyzerOffset(1000)
        HighlightField fieldProto = HighlightField.newBuilder().setPhraseLimit(512).build();
        Highlight highlightProto = Highlight.newBuilder()
        Highlight highlightProto = Highlight.newBuilder()
            .setBoundaryChars(".,!?")
        assertEquals("content", resultContentField.name());
            .setPhraseLimit(256)
        assertEquals(HighlightBuilder.BoundaryScannerType.SENTENCE, fields.get(2).boundaryScannerType());
        assertNotNull(result);
        assertEquals(2, postTags.length);
        assertNotNull(result);
public class HighlightBuilderProtoUtilsTests extends OpenSearchTestCase {
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_UNIFIED).build())
        String[] postTags = field.postTags();
        assertEquals("match_all", titleField.highlightQuery().getName());
        Map<String, Object> resultOptions = result.options();
        assertEquals("<em>", preTags[0]);
        assertEquals(HighlightBuilder.BoundaryScannerType.CHARS, fields.get(0).boundaryScannerType());
        char[] boundaryChars = result.boundaryChars();
 * Tests for {@link HighlightBuilderProtoUtils}.
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        List<HighlightBuilder.Field> fields = result.fields();
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        HighlightField fieldProto = HighlightField.newBuilder().setFragmenter(HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_SIMPLE).build();
        assertTrue(field.forceSource());
        assertEquals(500, (int) titleField.maxAnalyzerOffset());
    public void testFromProto_WithFieldForceSource() {
 * this file be licensed under the Apache-2.0 license or a
            .putFields("field2", fieldWord)
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
    public void testFromProto_WithAllBoundaryScannerTypes() {
            .addPostTags("</em>")
    }
        assertEquals("value1", resultOptions.get("key1"));
    private QueryBuilderProtoConverterRegistry registry;
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        HighlightBuilder.Field field = fields.get(0);
        assertEquals(100, (int) result.fragmentSize());
        Highlight highlightProto = Highlight.newBuilder().putFields("content", fieldProto).build();
        assertNotNull(result);
        String[] postTags = result.postTags();
    }
        assertNotNull(result);
            .setFragmentSize(150)
    }
        assertNotNull(resultTitleField);
        assertEquals("</strong>", postTags[1]);
        assertEquals("match_all", result.highlightQuery().getName());
            .addPreTags("<strong>")
            .addMatchedFields("title.raw")
