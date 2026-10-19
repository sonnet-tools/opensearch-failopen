                foundField2 = true;
                assertEquals("Format should match for field1", "format1", fieldAndFormat.format);
        super.setUp();
    public void testFromProtoWithScriptFields() throws IOException {
        assertNotNull("InnerHitBuilder list should not be null", innerHitBuilders);
                foundField1 = true;
        org.opensearch.protobufs.Script script1 = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript1).build();  
            .setSeqNoPrimaryTerm(true)  
        assertTrue("StoredFieldNames should contain field3", innerHitBuilder.getStoredFieldsContext().fieldNames().contains("field3"));
            .setFrom(10)
        InnerHitBuilder innerHitBuilder1 = innerHitBuilders.get(0);
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)
            .setField("category")
    public void testFromProtoWithSource() throws IOException {
        ScriptField scriptField2 = ScriptField.newBuilder().setScript(script2).build();
        InlineScript inlineScript2 = InlineScript.newBuilder()
        registry = new QueryBuilderProtoConverterRegistryImpl();  
        org.opensearch.protobufs.FieldCollapse collapseProto = org.opensearch.protobufs.FieldCollapse.newBuilder()  
            .build();
        // Verify the result
    }
        SourceConfig sourceContext = SourceConfig.newBuilder()
        boolean foundField1 = false;  
        // Verify the result  
        InnerHits innerHits1 = InnerHits.newBuilder().setName("inner_hits1").setSize(10).build();  
        InnerHits innerHits = InnerHits.newBuilder().setName("test_inner_hits").setHighlight(highlightProto).build();
            .addFields(org.opensearch.protobufs.FieldAndFormat.newBuilder().setField("field2").build())
    public void setUp() throws Exception {
        // Verify the result  
        InnerHits innerHits = InnerHits.newBuilder()
            innerHitBuilders.add(InnerHitsBuilderProtoUtils.fromProto(innerHits, registry));
            .setName("test_inner_hits")
                assertNull("Format should be null for field1", fieldAndFormat.format);  
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
        List<InnerHitBuilder> innerHitBuilders = new ArrayList<>();  
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
        assertEquals("ScriptFields size should match", 2, scriptFields.size());
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
    public void testFromProtoWithMultipleInnerHits() throws IOException {
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
            .addSort(org.opensearch.protobufs.SortCombinations.newBuilder().build())  
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);  
import org.opensearch.protobufs.InnerHits;
        }  
        boolean foundField1 = false;
import java.io.IOException;
        // Create a protobuf InnerHits with script fields  
        assertNotNull("FetchFields should not be null", innerHitBuilder.getFetchFields());
        boolean foundField2 = false;
            .build();  
        }
        assertEquals("First name should match", "inner_hits1", innerHitBuilder1.getName());
        IllegalArgumentException exception = expectThrows(
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
            .setName("test_inner_hits")
                ScriptLanguage.newBuilder()
            .addStoredFields("field2")  
            .build();  
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
        InnerHits innerHits = InnerHits.newBuilder()
        assertTrue("IgnoreUnmapped should be true", innerHitBuilder.isIgnoreUnmapped());
        // Verify the result
        assertTrue("StoredFieldNames should contain field1", innerHitBuilder.getStoredFieldsContext().fieldNames().contains("field1"));
                assertTrue("IgnoreFailure should be true for script_field1", scriptField.ignoreFailure());  
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);  
    public void testFromProtoWithFetchFields() throws IOException {  
            .setIgnoreUnmapped(true)
        assertEquals("InnerHits cannot be null", exception.getMessage());  
        assertEquals("Should have 2 InnerHitBuilders", 2, innerHitBuilders.size());
 * SPDX-License-Identifier: Apache-2.0
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
        assertEquals("Name should match", "test_inner_hits", innerHitBuilder.getName());
        assertEquals("Name should match", "test_inner_hits", innerHitBuilder.getName());
        assertNotNull("ScriptFields should not be null", scriptFields);
        InnerHits innerHits = InnerHits.newBuilder()
import org.opensearch.test.OpenSearchTestCase;
            .setSource("doc['field1'].value * 2")
        assertNotNull("HighlightBuilder should not be null", innerHitBuilder.getHighlightBuilder());  
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
    public void testFromProtoWithCollapse() throws IOException {
            }  
            .setSize(20)  
        // Create multiple protobuf InnerHits
        ScriptField scriptField1 = ScriptField.newBuilder().setScript(script1).setIgnoreFailure(true).build();
            .build();
    public void testFromProtoWithNullInnerHits() {
        // Create a protobuf InnerHits with fetch fields
            }
    public void testFromProtoWithDocValueFields() throws IOException {
            IllegalArgumentException.class,
        for (InnerHits innerHits : innerHitsList) {
        InnerHits innerHits2 = InnerHits.newBuilder().setName("inner_hits2").setSize(20).build();
        // Create a protobuf InnerHits with doc value fields
    }  
    public void testFromProtoWithHighlight() throws IOException {
        assertTrue("Explain should be true", innerHitBuilder.isExplain());
        }  
        assertTrue("SeqNoAndPrimaryTerm should be true", innerHitBuilder.isSeqNoAndPrimaryTerm());  
            .build();
        // Verify the result
        assertNotNull("StoredFieldNames should not be null", innerHitBuilder.getStoredFieldsContext());  
        // Verify the result  
        // Check script fields
        assertEquals("Should have 0 InnerHitBuilders", 0, innerHitBuilders.size());
            .setLang(
import org.opensearch.transport.grpc.proto.request.search.query.QueryBuilderProtoConverterRegistryImpl;
            if (fieldAndFormat.field.equals("field1")) {
        // Call the method under test
    }  
            .addFields(org.opensearch.protobufs.FieldAndFormat.newBuilder().setField("field1").build())
        innerHitsBuilder.putScriptFields("script_field2", scriptField2);  
        InnerHits.Builder innerHitsBuilder = InnerHits.newBuilder().setName("test_inner_hits");
import org.opensearch.protobufs.FieldAndFormat;
            .addDocvalueFields(FieldAndFormat.newBuilder().setField("field1").setFormat("format1").build())
        assertTrue("Should find script_field2", foundScriptField2);
    }  
            .setExplain(true)
        // Call the method under test
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);  
        // Call the method under test
    public void testFromProtoWithBasicFields() throws IOException {  
}
        for (org.opensearch.search.fetch.subphase.FieldAndFormat fieldAndFormat : innerHitBuilder.getDocValueFields()) {
        assertEquals("DocValueFields size should match", 2, innerHitBuilder.getDocValueFields().size());  
        // Test null input validation for single InnerHits  
            .setFilter(SourceFilter.newBuilder().addIncludes("include1").addIncludes("include2").addExcludes("exclude1").build())
        assertTrue("Version should be true", innerHitBuilder.isVersion());
import org.opensearch.protobufs.SourceFilter;
            .addDocvalueFields(FieldAndFormat.newBuilder().setField("field2").setFormat("format2").build())  
        InnerHitBuilder innerHitBuilder2 = innerHitBuilders.get(1);  
        assertEquals("Second name should match", "inner_hits2", innerHitBuilder2.getName());
        // Check field names (formats will be null for string-based fields)
/*  
    @Override  
            } else if (fieldAndFormat.field.equals("field2")) {  
                    .build()
            .setVersion(true)
        assertEquals("Size should match", 20, innerHitBuilder.getSize());  
            .setTrackScores(true)
import org.opensearch.protobufs.InlineScript;  
        boolean foundScriptField2 = false;  
        assertArrayEquals("Includes should match", new String[] { "include1", "include2" }, fetchSourceContext.includes());  
        assertTrue("FetchSource should be true", fetchSourceContext.fetchSource());
                foundScriptField1 = true;
        // Create a protobuf InnerHits with basic fields
 * compatible open source license.
            .addStoredFields("field3")
import org.opensearch.protobufs.ScriptField;
    }
        // Verify the result
        // Create a protobuf InnerHits with source context  
        List<InnerHitBuilder> innerHitBuilders = new ArrayList<>();
public class InnerHitsBuilderProtoUtilsTests extends OpenSearchTestCase {
        List<InnerHits> emptyList = Arrays.asList();  
        assertTrue("Should find field2", foundField2);
        assertTrue("Should find script_field1", foundScriptField1);
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
        assertNotNull("InnerCollapseBuilder should not be null", innerHitBuilder.getInnerCollapseBuilder());
        // Verify the result
            )
        // This should work and create the InnerHitBuilder with collapse  
 *
                assertEquals("Format should match for field2", "format2", fieldAndFormat.format);
 */  
    }  
        // Check second InnerHitBuilder
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
        assertTrue("Should find field1", foundField1);
        // Call the method under test
        for (InnerHits innerHits : emptyList) {
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
        InlineScript inlineScript1 = InlineScript.newBuilder()
package org.opensearch.transport.grpc.proto.request.search;
import org.opensearch.index.query.InnerHitBuilder;
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
import java.util.Arrays;
        // Check first InnerHitBuilder  
        org.opensearch.protobufs.Script script2 = org.opensearch.protobufs.Script.newBuilder().setInline(inlineScript2).build();
                assertNull("Format should be null for field2", fieldAndFormat.format);  
    }
            )
            .setName("test_inner_hits")
            .setLang(  
                foundField1 = true;
import org.opensearch.search.builder.SearchSourceBuilder;  
            .build();
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
    }
                ScriptLanguage.newBuilder()
        assertTrue("StoredFieldNames should contain field2", innerHitBuilder.getStoredFieldsContext().fieldNames().contains("field2"));  
        List<InnerHits> innerHitsList = Arrays.asList(innerHits1, innerHits2);
    public void testFromProtoWithSort() throws IOException {  
        assertNotNull("FetchSourceContext should not be null", fetchSourceContext);
        assertNotNull("Sorts should not be null", innerHitBuilder.getSorts());  
import org.opensearch.protobufs.SourceConfig;
                foundScriptField2 = true;
            innerHitBuilders.add(InnerHitsBuilderProtoUtils.fromProto(innerHits, registry));  
import java.util.ArrayList;  
    }  
        // Create a protobuf InnerHits with stored fields
    }
        boolean foundScriptField1 = false;
        assertEquals("From should match", 10, innerHitBuilder.getFrom());
        assertTrue("TrackScores should be true", innerHitBuilder.isTrackScores());
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);  
        Set<SearchSourceBuilder.ScriptField> scriptFields = innerHitBuilder.getScriptFields();  
        InnerHits innerHits = innerHitsBuilder.build();
            .setName("test_inner_hits")  
    private QueryBuilderProtoConverterRegistry registry;
            if (scriptField.fieldName().equals("script_field1")) {
        assertEquals("First size should match", 10, innerHitBuilder1.getSize());  
    }
            .build();
        // Create script field 2
                    .setBuiltin(org.opensearch.protobufs.BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS)  
        InnerHits innerHits = InnerHits.newBuilder().setName("test_inner_hits").setCollapse(collapseProto).build();
 * The OpenSearch Contributors require contributions made to  
        InnerHitBuilder innerHitBuilder = InnerHitsBuilderProtoUtils.fromProto(innerHits, registry);
        assertEquals("FetchFields size should match", 2, innerHitBuilder.getFetchFields().size());
        for (org.opensearch.search.fetch.subphase.FieldAndFormat fieldAndFormat : innerHitBuilder.getFetchFields()) {
        innerHitsBuilder.putScriptFields("script_field1", scriptField1);
            } else if (scriptField.fieldName().equals("script_field2")) {
        org.opensearch.search.fetch.subphase.FetchSourceContext fetchSourceContext = innerHitBuilder.getFetchSourceContext();  
            .setSource("doc['field2'].value + '_suffix'")  
            }
    }
            } else if (fieldAndFormat.field.equals("field2")) {
        // Create a protobuf InnerHits with collapse
import org.opensearch.protobufs.ScriptLanguage;  
        for (SearchSourceBuilder.ScriptField scriptField : scriptFields) {
        // Verify the result
        // Call the method under test  
        assertArrayEquals("Excludes should match", new String[] { "exclude1" }, fetchSourceContext.excludes());
        }
            if (fieldAndFormat.field.equals("field1")) {  
        );
        assertTrue("Should find field2", foundField2);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("StoredFieldNames size should match", 3, innerHitBuilder.getStoredFieldsContext().fieldNames().size());
    public void testFromProtoWithStoredFields() throws IOException {
                assertFalse("IgnoreFailure should be false for script_field2", scriptField.ignoreFailure());  
    }
        // Create script field 1  
        // Call the method under test
import java.util.List;
        assertNotNull("DocValueFields should not be null", innerHitBuilder.getDocValueFields());
                    .build()  
            .build();  
        org.opensearch.protobufs.Highlight highlightProto = org.opensearch.protobufs.Highlight.newBuilder().build();
                foundField2 = true;
            .setName("test_inner_hits")  
        InnerHits innerHits = InnerHits.newBuilder()  
            () -> InnerHitsBuilderProtoUtils.fromProto((InnerHits) null, registry)  
        boolean foundField2 = false;  
        InnerHits innerHits = InnerHits.newBuilder().setName("test_inner_hits").setXSource(sourceContext).build();
        }  
        assertNotNull("InnerHitBuilder list should not be null", innerHitBuilders);  
            .build();
        InnerHits innerHits = InnerHits.newBuilder()  
    public void testFromProtoWithEmptyList() throws IOException {
            .addStoredFields("field1")
        // Check field names and formats
        assertEquals("Name should match", "test_inner_hits", innerHitBuilder.getName());  
import java.util.Set;  
        assertEquals("Second size should match", 20, innerHitBuilder2.getSize());
        assertNotNull("InnerHitBuilder should not be null", innerHitBuilder);
        assertTrue("Should find field1", foundField1);
