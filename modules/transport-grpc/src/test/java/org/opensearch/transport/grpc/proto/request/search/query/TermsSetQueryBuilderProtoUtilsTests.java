        assertEquals("", result.queryName()); // Empty string should be preserved
        Object value = result.getValues().get(0);
            .setMinimumShouldMatchField("count")
        // This should throw an IllegalArgumentException
                InlineScript.newBuilder()
            .build();
        assertNotNull(result);
            : value.toString();
    }
            .addTerms("term2") // Duplicate
            .setBoost(-1.0f) // Negative boost - should throw exception
        TermsSetQuery proto = TermsSetQuery.newBuilder()
        assertEquals(2.0f, result.boost(), 0.0f);
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(null));
            .setField("tags")
        // Both empty string and valid term should be included
        assertNull(result.queryName());
            .setXName("") // Empty query name
        TermsSetQuery proto = TermsSetQuery.newBuilder().addTerms("value").setMinimumShouldMatchField("count").build();
    public void testFromProtoWithScript() {
    public void testFromProtoWithDuplicateTerms() {
            .build();
        assertEquals(AbstractQueryBuilder.DEFAULT_BOOST, result.boost(), 0.0f);
        assertNotNull(result);
            .addTerms("programming")
        assertNotNull(result);
            .setXName("multi_terms_query")
import org.opensearch.index.query.AbstractQueryBuilder;
import org.opensearch.index.query.TermsSetQueryBuilder;
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
            .setMinimumShouldMatchField("term_count")
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
import org.opensearch.protobufs.ScriptLanguage;
        TermsSetQuery proto = TermsSetQuery.newBuilder()
    }
            .setMinimumShouldMatchField("category_count")
        assertEquals("category_count", result.getMinimumShouldMatchField());
        TermsSetQuery proto = TermsSetQuery.newBuilder()
            .setMinimumShouldMatchField("field_count") // Both field and script
        // Note: Field name is internal to the builder and not directly accessible for verification
            .setXName("test_query")
    public void testFromProtoWithNullInput() {
    }
        // OpenSearch TermsSetQueryBuilder doesn't allow both field and script to be set
                    .setSource("params.required_count")
    }
        assertEquals(1, result.getValues().size());
    public void testFromProtoWithNoTerms() {
            .setField("categories")
                    .build()
 * this file be licensed under the Apache-2.0 license or a
        TermsSetQuery proto = TermsSetQuery.newBuilder().setField("category").setMinimumShouldMatchField("count").build();
package org.opensearch.transport.grpc.proto.request.search.query;
            .setMinimumShouldMatchField("count")
    }
    public void testFromProtoWithEmptyQueryName() {
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
        assertEquals("tag_count", result.getMinimumShouldMatchField());
 */
            .addTerms("") // Empty string term
            .setMinimumShouldMatchField("count")
}
        assertNotNull(result);
            .setMinimumShouldMatchScript(script)
        String stringValue = value instanceof org.apache.lucene.util.BytesRef
            .build();
            .addTerms("valid_term")
            .addTerms("term1")
        TermsSetQuery proto = TermsSetQuery.newBuilder()
            .build();
/*
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
        TermsSetQuery proto = TermsSetQuery.newBuilder()
    }
            .addTerms("urgent")
        assertNotNull(result);
            .addTerms("science")
                    .build()
            .addTerms("term")
    public void testFromProtoWithMultipleTerms() {
            .setField("query_name_field")
            .setMinimumShouldMatchField("tag_count")
import org.opensearch.protobufs.TermsSetQuery;
        assertEquals("published", stringValue);
    }
    }
            .build();
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
    public void testFromProtoWithOptionalFields() {
        assertEquals(1, result.getValues().size());
        assertNotNull(result);
            ? ((org.apache.lucene.util.BytesRef) value).utf8ToString()
        TermsSetQuery proto = TermsSetQuery.newBuilder()
 * SPDX-License-Identifier: Apache-2.0
            .build();
            .setField("boost_field")
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
            .addTerms("term")
    public void testFromProtoMinimalFieldsOnly() {
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
            .setField("test_field")
            .build();
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
        assertEquals(AbstractQueryBuilder.DEFAULT_BOOST, result.boost(), 0.0f);
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
            )
            .addTerms("single_term")
            .addTerms("term")
        Script script = Script.newBuilder()
import org.opensearch.protobufs.BuiltinScriptLanguage;
                    .setLang(ScriptLanguage.newBuilder().setBuiltin(BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS))
            .addTerms("java")
    }
            .build();
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
        TermsSetQuery proto = TermsSetQuery.newBuilder()
            .setBoost(2.0f)
            .setField("negative_boost_field")
            .addTerms("published")
        assertEquals("painless", result.getMinimumShouldMatchScript().getLang());
import org.opensearch.protobufs.Script;
        assertNotNull(result.getMinimumShouldMatchScript());
                    .setSource("params.num_terms")
            .setMinimumShouldMatchField("count")
        // No field set should default to null or empty
            .setField("minimal_field")
        TermsSetQuery proto = TermsSetQuery.newBuilder().setField("skills").addTerms("java").setMinimumShouldMatchScript(script).build();
            .build(); // No boost or query name - should use defaults
            .addTerms("term1")
        assertEquals("test_query", result.queryName());
    }
    public void testFromProtoWithNegativeBoost() {
 * compatible open source license.
    }
    public void testFromProtoBasic() {
        assertNotNull(result);
        assertEquals("multi_terms_query", result.queryName());
        assertEquals(0.0f, result.boost(), 0.0f);
                    .setLang(ScriptLanguage.newBuilder().setBuiltin(BuiltinScriptLanguage.BUILTIN_SCRIPT_LANGUAGE_PAINLESS))
            .setBoost(1.5f)
        assertNull(result.getMinimumShouldMatchField());
        assertEquals(2, result.getValues().size());
        TermsSetQuery proto = TermsSetQuery.newBuilder()
 *
    public void testFromProtoWithZeroBoost() {
            .addTerms("term2")
    }
    }
            .addTerms("term1") // Duplicate
        assertEquals(1.5f, result.boost(), 0.0f);
public class TermsSetQueryBuilderProtoUtilsTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
            .setInline(
            .addTerms("tech")
    public void testFromProtoWithEmptyTermsString() {
        Script script = Script.newBuilder()
            .setMinimumShouldMatchField("min_count")
        assertNotNull(result);
            .build();
            .build();
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
    public void testFromProtoWithNullField() {
    public void testFromProtoWithBothFieldAndScript() {
            .setField("duplicate_field")
        TermsSetQueryBuilder result = TermsSetQueryBuilderProtoUtils.fromProto(proto);
        assertEquals(4, result.getValues().size());
            )
        assertEquals("min_count", result.getMinimumShouldMatchField());
        TermsSetQuery proto = TermsSetQuery.newBuilder().setField("").addTerms("value").setMinimumShouldMatchField("count").build();
            .setField("status")
            .setField("field_with_script")
                InlineScript.newBuilder()
        assertEquals(4, result.getValues().size()); // All terms included, including duplicates
        assertNull(result.queryName());
import org.opensearch.protobufs.InlineScript;
            .setInline(
        TermsSetQuery proto = TermsSetQuery.newBuilder()
    }
    public void testFromProtoWithEmptyField() {
            .build();
 * The OpenSearch Contributors require contributions made to
        assertNotNull(result);
    }
            .setMinimumShouldMatchField("count")
        expectThrows(IllegalArgumentException.class, () -> TermsSetQueryBuilderProtoUtils.fromProto(proto));
        TermsSetQuery proto = TermsSetQuery.newBuilder()
            .setBoost(0.0f) // Zero boost
