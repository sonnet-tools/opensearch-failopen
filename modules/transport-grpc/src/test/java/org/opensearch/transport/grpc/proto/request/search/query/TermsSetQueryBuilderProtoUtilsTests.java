 * SPDX-License-Identifier: Apache-2.0
        assertEquals("tag_count", result.getMinimumShouldMatchField());
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
            .build();
        assertEquals("published", stringValue);  
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
        assertEquals(1, result.getValues().size());
            .build();
            .addTerms("single_term")  
        assertNotNull(result);
            .addTerms("term")
        TermsSetQuery proto = TermsSetQuery.newBuilder()
                InlineScript.newBuilder()  
            .build();  
        // Note: Field name is internal to the builder and not directly accessible for verification  
            .build();  
            .setMinimumShouldMatchField("count")  
    }  
                    .setSource("params.num_terms")
        assertNotNull(result);
            .addTerms("java")
        assertNotNull(result);  
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
            .setInline(  
        TermsSetQuery proto = TermsSetQuery.newBuilder()
    }  
            .setMinimumShouldMatchScript(script)
        TermsSetQuery proto = TermsSetQuery.newBuilder().setField("category").setMinimumShouldMatchField("count").build();
            .setBoost(-1.0f) // Negative boost - should throw exception
            .addTerms("tech")
    }
            .build(); // No boost or query name - should use defaults
            .setField("field_with_script")
        assertEquals(0.0f, result.boost(), 0.0f);
            .addTerms("term1")  
    public void testFromProtoWithZeroBoost() {
            .setMinimumShouldMatchField("min_count")
        assertEquals("painless", result.getMinimumShouldMatchScript().getLang());  
        assertEquals("test_query", result.queryName());  
            .build();  
        TermsSetQuery proto = TermsSetQuery.newBuilder()  
            .build();  
            .setBoost(1.5f)
            : value.toString();
        assertNotNull(result.getMinimumShouldMatchScript());
        TermsSetQuery proto = TermsSetQuery.newBuilder()  
import org.opensearch.test.OpenSearchTestCase;
        TermsSetQuery proto = TermsSetQuery.newBuilder().addTerms("value").setMinimumShouldMatchField("count").build();  
        Script script = Script.newBuilder()
                    .build()
            .setField("query_name_field")  
        assertNotNull(result);  
        TermsSetQuery proto = TermsSetQuery.newBuilder()
            .setXName("") // Empty query name
 *
            .addTerms("term")
 */  
    public void testFromProtoWithDuplicateTerms() {
        assertNull(result.getMinimumShouldMatchField());
            .setMinimumShouldMatchField("tag_count")
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(null));
    }  
    public void testFromProtoWithNegativeBoost() {
    }
            .setMinimumShouldMatchField("count")
            .addTerms("programming")
            .setField("status")
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);  
        // OpenSearch TermsSetQueryBuilder doesn't allow both field and script to be set
import org.opensearch.protobufs.InlineScript;
        assertEquals(1, result.getValues().size());
            .addTerms("published")  
        TermsSetQuery proto = TermsSetQuery.newBuilder()
    public void testFromProtoWithOptionalFields() {
    public void testFromProtoWithEmptyTermsString() {
    public void testFromProtoWithEmptyField() {
            .setXName("test_query")
    }
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
        assertEquals(1.5f, result.boost(), 0.0f);
            .setMinimumShouldMatchField("count")  
            .addTerms("term2")
            .setBoost(0.0f) // Zero boost  
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));  
    }
        assertEquals("", result.queryName()); // Empty string should be preserved  
            .build();
            .addTerms("term")
        assertNotNull(result);  
            .addTerms("term1") // Duplicate  
            .build();  
    }
        Script script = Script.newBuilder()
    }
            )
    }
            .addTerms("term1")
    public void testFromProtoWithScript() {
    }
    public void testFromProtoWithNullField() {
            .setXName("multi_terms_query")
        TermsSetQuery proto = TermsSetQuery.newBuilder().setField("skills").addTerms("java").setMinimumShouldMatchScript(script).build();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.AbstractQueryBuilder;
    public void testFromProtoMinimalFieldsOnly() {  
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
    public void testFromProtoWithEmptyQueryName() {
    public void testFromProtoWithMultipleTerms() {
            .setField("duplicate_field")  
        TermsSetQuery proto = TermsSetQuery.newBuilder()
        assertEquals("category_count", result.getMinimumShouldMatchField());
 * this file be licensed under the Apache-2.0 license or a
                InlineScript.newBuilder()
            .setMinimumShouldMatchField("field_count") // Both field and script
import org.opensearch.protobufs.BuiltinScriptLanguage;  
        Object value = result.getValues().get(0);
        assertNotNull(result);  
    public void testFromProtoWithBothFieldAndScript() {  
    }
                    .setLang(ScriptLanguage.newBuilder().setBuiltin(BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS))  
                    .setSource("params.required_count")
    public void testFromProtoWithNoTerms() {
        // Both empty string and valid term should be included
import org.opensearch.protobufs.Script;
import org.opensearch.protobufs.TermsSetQuery;
            .addTerms("urgent")
            .setField("tags")
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
    }
            ? ((org.apache.lucene.util.BytesRef) value).utf8ToString()
            .setMinimumShouldMatchField("term_count")
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
            .setField("categories")
                    .setLang(ScriptLanguage.newBuilder().setBuiltin(BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS))
        assertEquals(4, result.getValues().size());
/*  
import org.opensearch.protobufs.ScriptLanguage;  
            )
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
            .addTerms("valid_term")
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
            .setMinimumShouldMatchField("count")
            .setBoost(2.0f)  
        String stringValue = value instanceof org.apache.lucene.util.BytesRef  
public class TermsSetQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
    public void testFromProtoWithNullInput() {  
            .addTerms("") // Empty string term
            .build();
        assertNull(result.queryName());
    public void testFromProtoBasic() {  
                    .build()  
        TermsSetQuery proto = TermsSetQuery.newBuilder().setField("").addTerms("value").setMinimumShouldMatchField("count").build();
        assertEquals(4, result.getValues().size()); // All terms included, including duplicates
        assertEquals(2.0f, result.boost(), 0.0f);
        assertNotNull(result);
            .setInline(
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
            .setMinimumShouldMatchField("count")  
    }
        assertNotNull(result);
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
        assertEquals(AbstractQueryBuilder.DEFAULT_BOOST, result.boost(), 0.0f);  
        TermsSetQuery proto = TermsSetQuery.newBuilder()
            .build();
        assertEquals("multi_terms_query", result.queryName());  
            .setField("negative_boost_field")  
    }
            .addTerms("science")  
        // This should throw an IllegalArgumentException  
            .addTerms("term2") // Duplicate
            .setMinimumShouldMatchField("category_count")  
            .build();
        // No field set should default to null or empty
            .setField("boost_field")
        assertEquals(2, result.getValues().size());  
        assertEquals(AbstractQueryBuilder.DEFAULT_BOOST, result.boost(), 0.0f);
}  
        assertNull(result.queryName());
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);  
            .setField("test_field")  
        TermsSetQuery proto = TermsSetQuery.newBuilder()  
package org.opensearch.transport.grpc.proto.request.search.query;
        assertEquals("min_count", result.getMinimumShouldMatchField());
        assertNotNull(result);
 * compatible open source license.
        TermsSetQuery proto = TermsSetQuery.newBuilder()
import org.opensearch.index.query.TermsSetQueryBuilder;
            .setField("minimal_field")
