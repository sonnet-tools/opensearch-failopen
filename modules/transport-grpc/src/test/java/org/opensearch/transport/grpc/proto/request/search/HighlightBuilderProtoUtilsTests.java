        HighlightField fieldProto = HighlightField.newBuilder()  
            .setNumberOfFragments(5)
import org.opensearch.protobufs.HighlightField;
        assertNotNull(result);  
        List<HighlightBuilder.Field> fields = result.fields();
        assertNotNull(preTags);  
        HighlightField fieldProto = HighlightField.newBuilder().setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_SCORE).build();
        assertEquals(2, preTags.length);
        assertEquals(1000, (int) field.maxAnalyzerOffset());  
        assertEquals(1, fields.size());  
        assertEquals(6, boundaryChars.length);
        String[] postTags = field.postTags();  
        HighlightField fieldProto = HighlightField.newBuilder()
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
    public void setUp() throws Exception {
        assertNotNull(result);
            .setFragmentSize(150)  
        // Set up the registry with all built-in converters
        HighlightField fieldProto = HighlightField.newBuilder()  
        assertEquals(2, postTags.length);
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setFragmentSize(100)  
        assertTrue(result.highlightFilter());  
        assertTrue(result.forceSource());
        assertEquals(150, (int) result.fragmentSize());
        String[] postTags = result.postTags();
        assertEquals("unified", result.highlighterType());
            .addPostTags("</mark>")  
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
        assertEquals("title", titleField.name());  
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, result.boundaryScannerType());
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        assertEquals("<mark>", preTags[0]);
        // Test with all field settings combined (excluding tagsSchema to test explicit pre/post tags)
            .setFragmenter(HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_SPAN)
    public void testFromProto_WithTagsSchema() {  
            .addPreTags("<em>")
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        HighlightField contentField = HighlightField.newBuilder()
        assertEquals("<em>", preTags[0]);
        // matchedFields is package-private, can't verify directly
        assertEquals("title", resultTitleField.name());  
        assertArrayEquals(HighlightBuilder.DEFAULT_POST_TAGS, postTags);
        assertNotNull(result);
        String[] preTags = result.preTags();
            .addPostTags("</strong>")
        List<HighlightBuilder.Field> fields = result.fields();
        assertEquals("field_value", fieldOptions.get("field_key"));  
import org.opensearch.protobufs.QueryContainer;  
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_FVH).build())
        String[] postTags = field.postTags();  
        assertEquals(42, resultOptions.get("key2"));
        assertNotNull(preTags);
    }
        HighlightBuilder.Field field = fields.get(0);
    }  
        assertNotNull(resultOptions);  
    }  
            .setNumberOfFragments(5)
    }
            .setHighlightQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
        Highlight highlightProto = Highlight.newBuilder().putFields("content", fieldProto).build();  
        HighlightBuilder resultChars = HighlightBuilderProtoUtils.fromProto(highlightChars, registry);  
    public void testFromProto_WithFieldBoundaryCharsAndLocale() {
        String[] preTags = field.preTags();  
        HighlightField fieldSentence = HighlightField.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_SENTENCE).build();
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, fields.get(1).boundaryScannerType());  
        assertTrue(field.highlightFilter());
        assertEquals("value1", resultOptions.get("key1"));
        HighlightField fieldProto = HighlightField.newBuilder().setPhraseLimit(512).build();
            .build();
            .setEncoder(HighlighterEncoder.HIGHLIGHTER_ENCODER_HTML)  
        assertEquals("simple", fields.get(0).fragmenter());
 *
import java.util.Map;
            .build();  
        assertEquals(200, (int) result.noMatchSize());
    public void testFromProto_WithTagsAndBasicSettings() {  
        List<HighlightBuilder.Field> fields = result.fields();  
        assertNotNull(fieldOptions);
    }
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_PLAIN).build())
                    .build()
        assertEquals(HighlightBuilder.BoundaryScannerType.SENTENCE, fields.get(2).boundaryScannerType());
            .build();
            .putFields("field1", fieldChars)
        // The tags schema should have been applied - verify the field was created
        assertNotNull(titleField.highlightQuery());  
        assertEquals("fvh", resultTitleField.highlighterType());  
        HighlightBuilder.Field titleField = fields.get(0);
        List<HighlightBuilder.Field> fields = result.fields();  
            .setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD)
        Highlight highlightProto = Highlight.newBuilder()
        // Verify styled tags were applied
            .setBoundaryMaxScan(50)  
        assertNotNull(result);  
        assertFalse(field.requireFieldMatch());
        assertEquals(3, (int) result.numOfFragments());
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);  
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setNoMatchSize(100)
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setFragmentSize(150)
        assertEquals("title", field.name());
        List<HighlightBuilder.Field> fields = result.fields();
        assertEquals(1, fields.size());  
        assertEquals(1, fields.size());
        HighlightBuilder.Field field = fields.get(0);  
        assertEquals(1, preTags.length);
        String[] preTags = result.preTags();
            HighlightBuilderProtoUtils.fromProto(null, registry);
        HighlightField titleField = HighlightField.newBuilder()
        assertEquals("html", result.encoder());  
        assertNotNull(result);
        assertEquals(30, (int) field.boundaryMaxScan());  
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setHighlightFilter(true)  
    public void testFromProto_WithBoundarySettings() {  
                    .putFields("key1", ObjectMap.Value.newBuilder().setString("value1").build())
            .setBoundaryChars(".,!?")
import org.opensearch.protobufs.HighlighterFragmenter;  
            .setFragmentSize(200)  
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        assertEquals("<em>", preTags[0]);  
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals("content", resultContentField.name());
            .setHighlightQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())  
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();  
            .putFields("field3", fieldSentence)
        assertTrue(result.requireFieldMatch());
 * Tests for {@link HighlightBuilderProtoUtils}.
            .setPhraseLimit(10)  
        Highlight highlightWithQuery = Highlight.newBuilder()
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
            .setFragmenter(HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_UNSPECIFIED)
            .setBoundaryMaxScan(30)
            .build();  
    }
    public void testFromProto_WithOptions() {
        assertEquals(150, (int) field.fragmentSize());
        assertNotNull(resultTitleField);
        assertEquals(HighlightBuilder.Order.SCORE, field.order());
        Highlight highlightProto = Highlight.newBuilder().build();
        assertNotNull(result.highlightQuery());
    public void testFromProto_WithFieldFragmenter() {
        assertEquals(512, (int) field.phraseLimit());
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .build();  
        assertEquals(2, fields.size());
            .addPostTags("</strong>")
            .setEncoder(HighlighterEncoder.HIGHLIGHTER_ENCODER_UNSPECIFIED)
            .setOptions(
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        Highlight highlightProto = Highlight.newBuilder()  
        assertEquals(HighlightBuilder.BoundaryScannerType.SENTENCE, resultSentence.boundaryScannerType());  
        assertNull(result.highlighterType());
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
    }
        Highlight highlightProto = Highlight.newBuilder().putFields("content", fieldProto).build();
        assertEquals(200, (int) resultContentField.fragmentSize());
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertNull(result.fragmenter());
        assertEquals(1000, (int) result.maxAnalyzerOffset());
    public void testFromProto_EmptyHighlight() {  
    public void testFromProto_WithFieldTagsSchemaDefault() {
            .setBoundaryScannerLocale("en-US")
            .putFields("title", titleField)
        assertEquals("</strong>", postTags[1]);  
        assertEquals("fvh", result.highlighterType());
        assertEquals("title", field.name());
            .setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD)
            .putFields("field2", fieldWord)  
        assertTrue(result.highlightQuery() instanceof org.opensearch.index.query.MatchAllQueryBuilder);  
        assertEquals("match_all", titleField.highlightQuery().getName());
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_FVH).build())
            .setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD)
        List<HighlightBuilder.Field> fields = result.fields();  
        assertEquals(HighlightBuilder.Order.SCORE, result.order());
    }
            .build();  
            .setFragmentOffset(10)  
        assertNotNull(result);
        HighlightBuilder.Field titleField = fields.get(0);
import org.opensearch.test.OpenSearchTestCase;
            .addPostTags("</em>")
        HighlightField fieldProto = HighlightField.newBuilder().setForceSource(true).build();  
        // Check fields  
            .setMaxAnalyzerOffset(1000)
        assertEquals("plain", resultContentField.highlighterType());
 */  
        assertNotNull(result);  
            .addPostTags("</em>")
            .setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_SCORE)
        assertArrayEquals(HighlightBuilder.DEFAULT_STYLED_POST_TAGS, postTags);
        assertEquals("span", field.fragmenter());
        assertNotNull(postTags);
/*  
    }
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);  
        // The tags schema should have been applied - verify the field was created
        HighlightBuilder.Field field = fields.get(0);  
        assertEquals(2, postTags.length);
import org.opensearch.protobufs.BuiltinHighlighterType;
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);  
    public void testFromProto_WithHighlighterSettings() {
        assertEquals(HighlightBuilder.Order.SCORE, result.order());  
        assertNotNull(resultContentField);  
            .setFragmentSize(100)
public class HighlightBuilderProtoUtilsTests extends OpenSearchTestCase {  
        HighlightBuilder.Field field = fields.get(0);  
        assertEquals(100, (int) field.noMatchSize());  
            .addPreTags("<strong>")  
    }  
        Map<String, Object> resultOptions = result.options();
        HighlightField fieldProto = HighlightField.newBuilder().setRequireFieldMatch(false).build();  
        assertEquals("</em>", postTags[0]);
        assertNotNull(result);
        HighlightBuilder resultWord = HighlightBuilderProtoUtils.fromProto(highlightWord, registry);
            .setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_SCORE)
        assertNull(result.order());
        assertEquals(1, fields.size());
    public void testFromProto_WithFieldOrder() {
    }
            .addPreTags("<mark>")
        Highlight highlightProto = Highlight.newBuilder()  
        assertNotNull(result);
            .setBoundaryScannerLocale("en-US")
        assertNotNull(result);  
        assertNotNull(result);
        assertTrue(field.requireFieldMatch());
        Highlight highlightProto = Highlight.newBuilder().setTagsSchema(HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_STYLED).build();
    }
    public void testFromProto_WithFieldTagsSchemaStyled() {
        HighlightBuilder.Field resultContentField = fields.get(1);
            .putFields("content", contentField)
        assertEquals("</em>", postTags[0]);
    }  
            .setBoundaryChars(".,!?")  
        assertEquals(1, fields.size());  
}  
            )
 */
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> {
        assertEquals(100, (int) resultTitleField.fragmentSize());
            .setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_SCORE)  
    }
    public void testFromProto_WithoutRegistry() {  
            .build();
            .setNoMatchSize(250)  
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
    public void testFromProto_WithFieldPhraseLimit() {  
import java.util.List;  
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_FVH).build())  
    public void testFromProto_WithFieldRequireFieldMatch() {
            .setNoMatchSize(200)
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();  
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, field.boundaryScannerType());
        super.setUp();  
import org.opensearch.protobufs.ObjectMap;
            .setTagsSchema(HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_DEFAULT)
 * this file be licensed under the Apache-2.0 license or a
        HighlightField fieldProto = HighlightField.newBuilder().setBoundaryChars(".,!?;:").setBoundaryScannerLocale("fr-FR").build();
            .build();  
        assertNotNull(result);  
            .setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_UNSPECIFIED)
        HighlightField fieldProto = HighlightField.newBuilder().setTagsSchema(HighlighterTagsSchema.HIGHLIGHTER_TAGS_SCHEMA_STYLED).build();
        assertNull(result.encoder());  
        assertNotNull(result.boundaryScannerLocale());
            .setForceSource(true)
        String[] postTags = field.postTags();  
import org.opensearch.protobufs.HighlighterType;  
        assertNotNull(result);
        char[] boundaryChars = result.boundaryChars();
            .setNumberOfFragments(2)
        assertEquals("span", result.fragmenter());
 * compatible open source license.
            .setNumberOfFragments(3)
        assertNotNull(postTags);  
        assertEquals(1, fields.size());
    }
    }
        assertTrue(field.forceSource());
        List<HighlightBuilder.Field> fields = result.fields();
        assertTrue(field.forceSource());
    }
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals(100, (int) result.fragmentSize());  
        HighlightField fieldProto = HighlightField.newBuilder()
        assertEquals(1, fields.size());
 * The OpenSearch Contributors require contributions made to  
        assertEquals(250, (int) field.noMatchSize());
    public void testFromProto_WithFieldPreAndPostTags() {
        assertNotNull(field.boundaryScannerLocale());
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);  
    }
import org.opensearch.protobufs.HighlighterOrder;
    public void testFromProto_WithFieldHighlightQueryAndNoMatchSize() {  
    }
    }  
    }
            .setRequireFieldMatch(true)  
        assertEquals("</mark>", postTags[0]);
            .setNumberOfFragments(3)
        assertEquals(5, (int) resultContentField.numOfFragments());  
        assertEquals("title", field.name());
        assertNotNull(preTags);
        assertEquals(1, fields.size());
        String[] preTags = field.preTags();
        assertEquals(1, postTags.length);  
        // Verify default tags were applied
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals("match_all", result.highlightQuery().getName());
        assertEquals("QueryBuilderProtoConverterRegistry cannot be null.", exception.getMessage());  
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, result.boundaryScannerType());  
            .setPhraseLimit(256)
        assertEquals(1, postTags.length);
        List<HighlightBuilder.Field> fields = result.fields();
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .build();
        assertEquals(2, (int) resultTitleField.numOfFragments());
 * SPDX-License-Identifier: Apache-2.0
        HighlightBuilder.Field resultTitleField = fields.get(0);
    public void testFromProto_WithFieldForceSource() {
        assertEquals(1, fields.size());  
                ObjectMap.newBuilder().putFields("field_key", ObjectMap.Value.newBuilder().setString("field_value").build()).build()  
        HighlightBuilder.Field field = fields.get(0);
    }
        assertNotNull(field.highlightQuery());
        assertNotNull(result);
        assertEquals("match_all", field.highlightQuery().getName());  
        assertEquals(HighlightBuilder.BoundaryScannerType.CHARS, fields.get(0).boundaryScannerType());
        assertEquals("fvh", field.highlighterType());
        assertEquals(1, fields.size());  
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        Highlight highlightProto = Highlight.newBuilder()
        assertEquals(10, (int) result.phraseLimit());  
        Highlight highlightProto = Highlight.newBuilder()
        assertEquals('.', boundaryChars[0]);  
        assertEquals(HighlightBuilder.Order.SCORE, field.order());  
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_UNSPECIFIED).build())  
        String[] postTags = titleField.postTags();
        HighlightBuilder.Field field = fields.get(0);
        Highlight highlightProto = Highlight.newBuilder()
package org.opensearch.transport.grpc.proto.request.search;
            .setOptions(  
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            .setHighlightQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
        HighlightField fieldProto = HighlightField.newBuilder().setFragmenter(HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_SIMPLE).build();
        Highlight highlightProto = Highlight.newBuilder()
        assertNotNull(result);  
        assertEquals("fr-FR", field.boundaryScannerLocale().toLanguageTag());  
    }  
            .setRequireFieldMatch(true)  
            .addPreTags("<em>")  
        HighlightBuilder.Field field = fields.get(0);  
    public void testFromProto_WithHighlightQuery() {
            .addPostTags("</em>")  
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
            )
/**  
            .setHighlightQuery(QueryContainer.newBuilder().setMatchAll(MatchAllQuery.newBuilder().build()).build())
import org.opensearch.protobufs.HighlighterTagsSchema;
        assertEquals(1, preTags.length);  
        HighlightBuilder.Field field = fields.get(0);  
        List<HighlightBuilder.Field> fields = result.fields();
            .addMatchedFields("title")
            .build();
        assertEquals("<strong>", preTags[1]);  
import org.opensearch.protobufs.Highlight;  
            .addPreTags("<strong>")
        });
            .build();  
import org.opensearch.protobufs.HighlighterEncoder;
            .addMatchedFields("title.raw")
        assertEquals("</em>", postTags[0]);
                    .putFields("key2", ObjectMap.Value.newBuilder().setInt32(42).build())  
        assertEquals("<em>", preTags[0]);  
            .addPreTags("<em>")
    public void testFromProto_WithAllBoundaryScannerTypes() {
import org.opensearch.protobufs.BoundaryScanner;
    private QueryBuilderProtoConverterRegistry registry;
        HighlightBuilder resultSentence = HighlightBuilderProtoUtils.fromProto(highlightSentence, registry);
            HighlightBuilderProtoUtils.fromProto(highlightWithQuery, null);  
            .build();
    public void testFromProto_WithAllFieldSettings() {
            .setOrder(HighlighterOrder.HIGHLIGHTER_ORDER_UNSPECIFIED)  
        List<HighlightBuilder.Field> fields = result.fields();
            .setType(HighlighterType.newBuilder().setBuiltin(BuiltinHighlighterType.BUILTIN_HIGHLIGHTER_TYPE_UNIFIED).build())  
        registry = new QueryBuilderProtoConverterRegistryImpl();
            .build();  
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
            .setHighlightFilter(true)
        assertEquals(1, fields.size());  
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        Highlight highlightSentence = Highlight.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_SENTENCE).build();
        String[] postTags = result.postTags();  
        // fragmentOffset is package-private, can't verify directly
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        String[] preTags = field.preTags();  
        List<HighlightBuilder.Field> fields = result.fields();
        HighlightBuilder result = HighlightBuilderProtoUtils.fromProto(highlightProto, registry);
        assertEquals(3, fields.size());
        HighlightField fieldProto = HighlightField.newBuilder()  
    @Override
        List<HighlightBuilder.Field> fields = result.fields();
        assertNotNull(result);
        Highlight highlightChars = Highlight.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_CHARS).build();
    }
        List<HighlightBuilder.Field> fields = result.fields();  
            .setMaxAnalyzerOffset(1000)
        assertEquals(2, preTags.length);
        assertNull(result.boundaryScannerType());
        HighlightField fieldChars = HighlightField.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_CHARS).build();
        });
        assertEquals(3, (int) field.numOfFragments());  
        Map<String, Object> fieldOptions = titleField.options();
        char[] boundaryChars = field.boundaryChars();  
        assertEquals("</strong>", postTags[1]);  
import org.opensearch.protobufs.MatchAllQuery;
        assertNotNull(result);  
        List<HighlightBuilder.Field> fields = result.fields();
    public void testFromProto_WithUnspecifiedEnums() {
        assertArrayEquals(HighlightBuilder.DEFAULT_PRE_TAGS, preTags);
        assertNotNull(result);  
            .build();
        assertEquals(4, boundaryChars.length);
    }  
        assertEquals("Highlight cannot be null", exception.getMessage());  
    public void testFromProto_NullHighlight() {
    public void testFromProto_WithMultipleFields() {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {  
        HighlightBuilder.Field field = fields.get(0);
        assertEquals(256, (int) field.phraseLimit());  
        // Check global settings  
    }
        assertEquals(HighlightBuilder.BoundaryScannerType.CHARS, resultChars.boundaryScannerType());
        HighlightField fieldWord = HighlightField.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD).build();  
            .setMaxAnalyzerOffset(500)
    public void testFromProto_WithFieldBoundaryScannerTypes() {  
        assertNotNull(result);
        assertEquals("en-US", result.boundaryScannerLocale().toLanguageTag());
        assertEquals("<strong>", preTags[1]);
        assertNotNull(result);
        Highlight highlightWord = Highlight.newBuilder().setBoundaryScanner(BoundaryScanner.BOUNDARY_SCANNER_WORD).build();  
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;  
    public void testFromProto_WithFieldOptions() {  
        assertEquals(500, (int) titleField.maxAnalyzerOffset());
        assertEquals(HighlightBuilder.BoundaryScannerType.WORD, resultWord.boundaryScannerType());
            .build();
        Highlight highlightProto = Highlight.newBuilder()
        assertNotNull(postTags);
            .setFragmenter(HighlighterFragmenter.HIGHLIGHTER_FRAGMENTER_SPAN)
            .build();
                ObjectMap.newBuilder()
        assertEquals(50, (int) result.boundaryMaxScan());  
        assertEquals(5, (int) result.numOfFragments());
            .setForceSource(true)
        Highlight highlightProto = Highlight.newBuilder().putFields("title", fieldProto).build();
        assertArrayEquals(HighlightBuilder.DEFAULT_STYLED_PRE_TAG, preTags);
        assertNotNull(result);
        String[] preTags = titleField.preTags();
