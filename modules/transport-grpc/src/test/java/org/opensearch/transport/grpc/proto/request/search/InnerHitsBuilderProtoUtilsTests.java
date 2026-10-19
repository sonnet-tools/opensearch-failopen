        assertNotNull("HighlightBuilder should not be null", innerHitBuilder.getHighlightBuilder());
        // Create multiple protobuf InnerHits
        // Call the method under test
            .setLang(
        for (org.opensearch.search.fetch.subphase.FieldAndFormat fieldAndFormat : innerHitBuilder.getDocValueFields()) {
        }
        InnerHits innerHits = InnerHits.newBuilder()
                foundField2 = true;
                assertNull("Format should be null for field2", fieldAndFormat.format);
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
            .build();
 * compatible open source license.
            .build();
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
    }
        IllegalArgumentException exception = expectThrows(
        boolean foundScriptField1 = false;
                foundField2 = true;
        );
                    .build()
        assertTrue("IgnoreUnmapped should be true", innerHitBuilder.isIgnoreUnmapped());
        // Verify the result
            .setName("test_inner_hits")
        boolean foundField1 = false;
            .build();
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
        assertArrayEquals("Excludes should match", new String[] { "exclude1" }, fetchSourceContext.excludes());
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
    public void testFromProtoWithStoredFields() throws IOException {
        assertNotNull("StoredFieldNames should not be null", innerHitBuilder.getStoredFieldsContext());
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
    }
import org.opensearch.protobufs.FieldAndFormat;
        InlineScript inlineScript1 = InlineScript.newBuilder()
        assertTrue("TrackScores should be true", innerHitBuilder.isTrackScores());
            .addFields(org.opensearch.protobufs.FieldAndFormat.newBuilder().setField("field2").build())
        assertArrayEquals("Includes should match", new String[] { "include1", "include2" }, fetchSourceContext.includes());
        assertEquals("Second size should match", 20, innerHitBuilder2.getSize());
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
            .setLang(
        boolean foundField2 = false;
            .addFields(org.opensearch.protobufs.FieldAndFormat.newBuilder().setField("field1").build())
        InnerHits innerHits = InnerHits.newBuilder()
    }
import org.opensearch.protobufs.SourceConfig;
        org.opensearch.protobufs.Highlight highlightProto = org.opensearch.protobufs.Highlight.newBuilder().build();
                assertFalse("IgnoreFailure should be false for script_field2", scriptField.ignoreFailure());
    }
        innerHitsBuilder.putScriptFields("script_field1", scriptField1);
 * SPDX-License-Identifier: Apache-2.0
        org.opensearch.protobufs.Script script1 = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript1).build();
        // Create a protobuf InnerHits with basic fields
        // Check field names and formats
            .setField("category")
        assertTrue("Explain should be true", innerHitBuilder.isExplain());
        // Call the method under test
        // Create a protobuf InnerHits with collapse
        assertNotNull("Sorts should not be null", innerHitBuilder.getSorts());
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
            .build();
import org.opensearch.protobufs.ScriptField;
        }
            }
package org.opensearch.transport.grpc.proto.request.search;
            innerHitBuilders.add(InnerHitsBuilderProtoUtils.fromProto(innerHits, registry));
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
            .setExplain(true)
        SourceConfig sourceContext = SourceConfig.newBuilder()
        // Create script field 1
        ScriptField scriptField1 = ScriptField.newBuilder().setScript(script1).setIgnoreFailure(true).build();
        List<InnerHits> innerHitsList = Arrays.asList(innerHits1, innerHits2);
import org.opensearch.protobufs.InlineScript;
import org.opensearch.search.builder.SearchSourceBuilder;
    public void testFromProtoWithMultipleInnerHits() throws IOException {
        // Create a protobuf InnerHits with doc value fields
        InnerHits innerHits = InnerHits.newBuilder().setName("test_inner_hits").setXSource(sourceContext).build();
import org.opensearch.protobufs.SourceFilter;
        assertNotNull("FetchFields should not be null", innerHitBuilder.getFetchFields());
    private QueryBuilderProtoConverterRegistry registry;
        assertNotNull("ScriptFields should not be null", scriptFields);
/*
            .setFilter(SourceFilter.newBuilder().addIncludes("include1").addIncludes("include2").addExcludes("exclude1").build())
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
        // Call the method under test
            .build();
                foundField1 = true;
    }
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
            .addStoredFields("field3")
    public void testFromProtoWithSource() throws IOException {
            IllegalArgumentException.class,
    }
    public void testFromProtoWithSort() throws IOException {
            .addSort(org.opensearch.protobufs.SortCombinations.newBuilder().build())
        // Verify the result
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
        assertTrue("Should find field2", foundField2);
            )
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("InnerHits cannot be null", exception.getMessage());
        ScriptField scriptField2 = ScriptField.newBuilder().setScript(script2).build();
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
    public void testFromProtoWithFetchFields() throws IOException {
import java.util.Set;
            .setName("test_inner_hits")
        Set<SearchSourceBuilder.ScriptField> scriptFields = innerHitBuilder.getScriptFields();
        InnerHits innerHits = InnerHits.newBuilder()
        assertEquals("Name should match", "test_inner_hits", innerHitBuilder.getName());
        InnerHitBuilder innerHitBuilder1 = innerHitBuilders.get(0);
        InnerHits innerHits = innerHitsBuilder.build();
        InnerHits innerHits = InnerHits.newBuilder()
        assertTrue("Should find field1", foundField1);
        assertTrue("StoredFieldNames should contain field1", innerHitBuilder.getStoredFieldsContext().fieldNames().contains("field1"));
        assertEquals("From should match", 10, innerHitBuilder.getFrom());
public class InnerHitsBuilderProtoUtilsTests extends OpenSearchTestCase {
        // Call the method under test
 * The OpenSearch Contributors require contributions made to
                foundScriptField1 = true;
            } else if (fieldAndFormat.field.equals("field2")) {
    }
                assertEquals("Format should match for field2", "format2", fieldAndFormat.format);
            .addDocvalueFields(FieldAndFormat.newBuilder().setField("field2").setFormat("format2").build())
        }
        assertEquals("Size should match", 20, innerHitBuilder.getSize());
        assertEquals("Name should match", "test_inner_hits", innerHitBuilder.getName());
            .build();
        InnerHits innerHits1 = InnerHits.newBuilder().setName("inner_hits1").setSize(10).build();
        InnerHits innerHits2 = InnerHits.newBuilder().setName("inner_hits2").setSize(20).build();
            .setSource("doc['field1'].value * 2")
        // Verify the result
        assertTrue("Should find script_field1", foundScriptField1);
        }
        // Check second InnerHitBuilder
import java.util.Arrays;
    public void setUp() throws Exception {
            .setSource("doc['field2'].value + '_suffix'")
        assertTrue("Version should be true", innerHitBuilder.isVersion());
                foundScriptField2 = true;
            .setSeqNoPrimaryTerm(true)
        // Create a protobuf InnerHits with fetch fields
        // Call the method under test
        // Verify the result
        for (InnerHits innerHits : emptyList) {
        assertEquals("Second name should match", "inner_hits2", innerHitBuilder2.getName());
            .build();
        for (org.opensearch.search.fetch.subphase.FieldAndFormat fieldAndFormat : innerHitBuilder.getFetchFields()) {
    public void testFromProtoWithNullInnerHits() {
            .setFrom(10)
            .setName("test_inner_hits")
        for (SearchSourceBuilder.ScriptField scriptField : scriptFields) {
    }
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
            .setTrackScores(true)
        // Create a protobuf InnerHits with source context
        // Create a protobuf InnerHits with script fields
    }
        InlineScript inlineScript2 = InlineScript.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
        // This should work and create the InnerHitBuilder with collapse
        List<InnerHitBuilder> innerHitBuilders = new ArrayList<>();
        assertTrue("StoredFieldNames should contain field3", innerHitBuilder.getStoredFieldsContext().fieldNames().contains("field3"));
                    .build()
        // Check first InnerHitBuilder
                assertEquals("Format should match for field1", "format1", fieldAndFormat.format);
        assertTrue("StoredFieldNames should contain field2", innerHitBuilder.getStoredFieldsContext().fieldNames().contains("field2"));
        assertTrue("SeqNoAndPrimaryTerm should be true", innerHitBuilder.isSeqNoAndPrimaryTerm());
import org.opensearch.protobufs.InnerHits;
        assertEquals("First name should match", "inner_hits1", innerHitBuilder1.getName());
            .setVersion(true)
        List<InnerHitBuilder> innerHitBuilders = new ArrayList<>();
    public void testFromProtoWithHighlight() throws IOException {
            .setName("test_inner_hits")
        assertTrue("Should find field1", foundField1);
            if (fieldAndFormat.field.equals("field1")) {
            } else if (fieldAndFormat.field.equals("field2")) {
        InnerHits innerHits = InnerHits.newBuilder().setName("test_inner_hits").setHighlight(highlightProto).build();
            .addStoredFields("field2")
    public void testFromProtoWithEmptyList() throws IOException {
                foundField1 = true;
        org.opensearch.protobufs.FieldCollapse collapseProto = org.opensearch.protobufs.FieldCollapse.newBuilder()
            .setName("test_inner_hits")
            }
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
        registry = new QueryBuilderProtoConverterRegistryImpl();
        assertTrue("Should find field2", foundField2);
            .build();
        assertNotNull("InnerHitBuilder list should not be null", innerHitBuilders);
        assertEquals("ScriptFields size should match", 2, scriptFields.size());
            if (scriptField.fieldName().equals("script_field1")) {
        assertNotNull("InnerCollapseBuilder should not be null", innerHitBuilder.getInnerCollapseBuilder());
        // Check script fields
        }
    @Override
        // Create a protobuf InnerHits with stored fields
        assertTrue("Should find script_field2", foundScriptField2);
 */
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
    public void testFromProtoWithScriptFields() throws IOException {
    }
        for (InnerHits innerHits : innerHitsList) {
        // Verify the result
                assertTrue("IgnoreFailure should be true for script_field1", scriptField.ignoreFailure());
        // Verify the result
    public void testFromProtoWithBasicFields() throws IOException {
        // Check field names (formats will be null for string-based fields)
}
        // Call the method under test
        assertTrue("FetchSource should be true", fetchSourceContext.fetchSource());
    public void testFromProtoWithDocValueFields() throws IOException {
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
        InnerHits innerHits = InnerHits.newBuilder()
        boolean foundField1 = false;
        boolean foundScriptField2 = false;
        org.opensearch.search.fetch.subphase.FetchSourceContext fetchSourceContext = innerHitBuilder.getFetchSourceContext();
        InnerHits.Builder innerHitsBuilder = InnerHits.newBuilder().setName("test_inner_hits");
        assertNotNull("InnerHitBuilder list should not be null", innerHitBuilders);
        // Verify the result
import java.io.IOException;
        assertEquals("Should have 2 InnerHitBuilders", 2, innerHitBuilders.size());
        assertNotNull("DocValueFields should not be null", innerHitBuilder.getDocValueFields());
        boolean foundField2 = false;
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
        super.setUp();
        assertEquals("First size should match", 10, innerHitBuilder1.getSize());
            .setIgnoreUnmapped(true)
        List<InnerHits> emptyList = Arrays.asList();
import org.opensearch.protobufs.ScriptLanguage;
            () -> InnerHitsBuilderProtoUtils.fromProto((InnerHits) null, registry)
            }
        assertNotNull("FetchSourceContext should not be null", fetchSourceContext);
            .setSize(20)
        assertEquals("Should have 0 InnerHitBuilders", 0, innerHitBuilders.size());
        InnerHits innerHits = InnerHits.newBuilder().setName("test_inner_hits").setCollapse(collapseProto).build();
        // Verify the result
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
 *
    }
        innerHitsBuilder.putScriptFields("script_field2", scriptField2);
            .build();
        assertEquals("StoredFieldNames size should match", 3, innerHitBuilder.getStoredFieldsContext().fieldNames().size());
    }
            .addStoredFields("field1")
        // Create script field 2
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            innerHitBuilders.add(InnerHitsBuilderProtoUtils.fromProto(innerHits, registry));
            .addDocvalueFields(FieldAndFormat.newBuilder().setField("field1").setFormat("format1").build())
                assertNull("Format should be null for field1", fieldAndFormat.format);
        assertEquals("FetchFields size should match", 2, innerHitBuilder.getFetchFields().size());
        assertEquals("Name should match", "test_inner_hits", innerHitBuilder.getName());
        // Test null input validation for single InnerHits
                ScriptLanguage.newBuilder()
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
            } else if (scriptField.fieldName().equals("script_field2")) {
import java.util.ArrayList;
            if (fieldAndFormat.field.equals("field1")) {
    public void testFromProtoWithCollapse() throws IOException {
        assertEquals("DocValueFields size should match", 2, innerHitBuilder.getDocValueFields().size());
        org.opensearch.protobufs.Script script2 = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript2).build();
    }
import java.util.List;
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            )
                ScriptLanguage.newBuilder()
import org.opensearch.index.query.InnerHitBuilder;
        // Verify the result
        InnerHitBuilder innerHitBuilder2 = innerHitBuilders.get(1);
