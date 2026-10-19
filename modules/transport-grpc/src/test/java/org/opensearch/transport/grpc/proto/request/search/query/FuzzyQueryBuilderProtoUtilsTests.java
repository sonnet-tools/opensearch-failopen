            .setTranspositions(false)
            .setValue(value)  
/*  
package org.opensearch.transport.grpc.proto.request.search.query;
        assertEquals("Default transpositions should match", FuzzyQuery.defaultTranspositions, fuzzyQueryBuilder.transpositions());  
        FuzzyQueryBuilder fuzzyQueryBuilder = FuzzyQueryBuilderProtoUtils.fromProto(fuzzyQuery);
    public void testFromProtoWithTranspositionsTrue() {
        assertNotNull("FuzzyQueryBuilder should not be null", fuzzyQueryBuilder);  
            .setXName("test_query")
    public void testFromProtoWithMinimalFields() {  
import org.opensearch.common.unit.Fuzziness;
            .setField("name")
 */  
import org.apache.lucene.search.FuzzyQuery;  
        FuzzyQueryBuilder fuzzyQueryBuilder = FuzzyQueryBuilderProtoUtils.fromProto(fuzzyQuery);
        org.opensearch.protobufs.FuzzyQuery fuzzyQuery = org.opensearch.protobufs.FuzzyQuery.newBuilder()
        assertEquals("Boost should match", 1.5f, fuzzyQueryBuilder.boost(), 0.001f);
        assertNull("Query name should be null", fuzzyQueryBuilder.queryName());  
            .build();
            .setFuzziness(fuzziness)
        assertEquals("Transpositions should match", true, fuzzyQueryBuilder.transpositions());  
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull("FuzzyQueryBuilder should not be null", fuzzyQueryBuilder);  
 *
    }
            .build();
        assertNotNull("FuzzyQueryBuilder should not be null", fuzzyQueryBuilder);  
            .setValue(value)
            .setField("name")
        FieldValue value = FieldValue.newBuilder().setString("jonh").build();
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Field name should match", "name", fuzzyQueryBuilder.fieldName());  
        org.opensearch.protobufs.FuzzyQuery fuzzyQuery = org.opensearch.protobufs.FuzzyQuery.newBuilder()
    }
        assertEquals("Default fuzziness should match", FuzzyQueryBuilder.DEFAULT_FUZZINESS, fuzzyQueryBuilder.fuzziness());  
            .setFuzziness(fuzziness)
        org.opensearch.protobufs.FuzzyQuery fuzzyQuery = org.opensearch.protobufs.FuzzyQuery.newBuilder()
        assertEquals("Value should match", "jonh", fuzzyQueryBuilder.value());
        assertEquals("Prefix length should match", 2, fuzzyQueryBuilder.prefixLength());
        FieldValue value = FieldValue.newBuilder().setString("jonh").build();  
        assertEquals("Field name should match", "description", fuzzyQueryBuilder.fieldName());
 * compatible open source license.
        org.opensearch.protobufs.Fuzziness fuzziness = org.opensearch.protobufs.Fuzziness.newBuilder().setString("AUTO").build();
            .build();
            .setField("name")
}
            .setValue(value)  
        assertEquals("Max expansions should match", 100, fuzzyQueryBuilder.maxExpansions());
        assertEquals("Rewrite should match", "constant_score", fuzzyQueryBuilder.rewrite());
    }
            .setField("description")  
        FuzzyQueryBuilder fuzzyQueryBuilder = FuzzyQueryBuilderProtoUtils.fromProto(fuzzyQuery);  
    public void testFromProtoWithFuzzinessInt() {  
        assertEquals("Fuzziness should match", Fuzziness.fromEdits(2), fuzzyQueryBuilder.fuzziness());
        FuzzyQueryBuilder fuzzyQueryBuilder = FuzzyQueryBuilderProtoUtils.fromProto(fuzzyQuery);
            .setPrefixLength(2)
        FieldValue value = FieldValue.newBuilder().setString("jonh").build();
        assertEquals("Transpositions should match", false, fuzzyQueryBuilder.transpositions());  
        assertNotNull("FuzzyQueryBuilder should not be null", fuzzyQueryBuilder);
import org.opensearch.index.query.FuzzyQueryBuilder;
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Query name should match", "test_query", fuzzyQueryBuilder.queryName());  
    }
public class FuzzyQueryBuilderProtoUtilsTests extends OpenSearchTestCase {  
        assertEquals("Default prefix length should match", FuzzyQuery.defaultPrefixLength, fuzzyQueryBuilder.prefixLength());
        assertEquals("Default boost should be 1.0", 1.0f, fuzzyQueryBuilder.boost(), 0.0f);
        assertEquals("Default max expansions should match", FuzzyQuery.defaultMaxExpansions, fuzzyQueryBuilder.maxExpansions());
        FieldValue value = FieldValue.newBuilder().setString("jonh").build();
    }
        org.opensearch.protobufs.FuzzyQuery fuzzyQuery = org.opensearch.protobufs.FuzzyQuery.newBuilder()  
        org.opensearch.protobufs.FuzzyQuery fuzzyQuery = org.opensearch.protobufs.FuzzyQuery.newBuilder()
 * this file be licensed under the Apache-2.0 license or a
        org.opensearch.protobufs.Fuzziness fuzziness = org.opensearch.protobufs.Fuzziness.newBuilder().setInt32(2).build();
            .setMaxExpansions(100)  
        assertEquals("Value should match", "text", fuzzyQueryBuilder.value());
        assertEquals("Field name should match", "name", fuzzyQueryBuilder.fieldName());
            .setBoost(1.5f)  
        FuzzyQueryBuilder fuzzyQueryBuilder = FuzzyQueryBuilderProtoUtils.fromProto(fuzzyQuery);  
            .build();
            .setTranspositions(true)  
            .setValue(value)
    public void testFromProtoWithAllParameters() {  
        assertEquals("Value should match", "jonh", fuzzyQueryBuilder.value());
        assertEquals("Fuzziness should match", Fuzziness.AUTO, fuzzyQueryBuilder.fuzziness());  
import org.opensearch.protobufs.FieldValue;  
        FieldValue value = FieldValue.newBuilder().setString("text").build();
            .build();
            .setRewrite("constant_score")
        assertNotNull("FuzzyQueryBuilder should not be null", fuzzyQueryBuilder);
    public void testFromProtoWithBasicFuzzyQuery() {
            .setValue(value)  
            .setField("name")
