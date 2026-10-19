    public void testToProtoWithNoMatchedQueries() throws IOException {  
        assertTrue("Source should be set", hit.hasXSource());  
    }  
            if (i > 0) largeJsonBuilder.append(",");  
        SearchHit searchHit = new SearchHit(1);  
        highlightFields.put("field1", new HighlightField("field1", fragments));
        // Create a SearchHit with CompositeBytesReference source (should use ByteString.copyFrom)  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
    }
        assertNotNull("Hit should not be null", hit);
import org.opensearch.search.SearchHit;  
        SearchHit searchHit = new SearchHit(1);
        assertNotNull("Hit with score should not be null", hitWithScore);  
        // Add inner hits
        byte[] fullBytes = fullContent.getBytes(StandardCharsets.UTF_8);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
    }
    public void testToProtoWithDocumentFields() throws IOException {
        Explanation explanation = Explanation.match(1.0f, "explanation");  
        SearchHit searchHit = new SearchHit(1);  
    }  
        int length = jsonContent.length();
        assertEquals("First sort value should match", "first", hit.getSort(0).getString());
        assertNotNull("Hit should not be null", hit);  
        byte[] largeSourceBytes = largeJsonBuilder.toString().getBytes(StandardCharsets.UTF_8);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertEquals(
        // Verify the result
    }
        byte[] fullBytes = fullContent.getBytes(StandardCharsets.UTF_8);
        BytesArray part2 = new BytesArray(jsonBytes, jsonBytes.length / 2, jsonBytes.length - jsonBytes.length / 2);  
        searchHit.setInnerHits(innerHits);  
import org.apache.lucene.search.TotalHits;
public class SearchHitProtoUtilsTests extends OpenSearchTestCase {  
        assertEquals("Highlight field1 should have 1 fragment", 1, hit.getHighlightOrThrow("field1").getStringArrayCount());  
        searchHit.explanation(explanation);
        assertTrue("Source should be set", hit.hasXSource());
        searchHit.sourceRef(null);  
        SearchHit searchHit = new SearchHit(1);  
        assertNotNull("Hit should not be null", hit);
        // Test with zero score
        assertTrue("Second sort value should be null", hit.getSort(1).hasNullValue());  
        assertTrue("Field1 should exist", hit.getFields().containsFields("field1"));
import org.opensearch.search.DocValueFormat;
        String fullContent = "HEADER{\"important\":\"data\",\"field\":\"value\"}FOOTER";  
        assertTrue("Score should be set", hitWithZeroScore.hasXScore());  
        assertTrue("Highlight field1 should exist", hit.containsHighlight("field1"));
        int jsonStart = 6; // "HEADER".length()
        // Verify the result
    }
import org.opensearch.core.common.bytes.BytesArray;
    }
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        BytesArray bytesArray = new BytesArray(fullBytes, offset, length);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        // Verify the result
        assertFalse("Should not use scores (DoubleMap)", hit.getMatchedQueries2().hasScores());
        assertNotNull("Hit should not be null", hit);  
import org.opensearch.core.common.text.Text;  
        SearchHit searchHitWithZeroScore = new SearchHit(2);  
        HitsMetadataHitsInner hitWithZeroScore = SearchHitProtoUtils.toProto(searchHitWithZeroScore);  
        assertEquals("Should have 1 highlight field", 1, hit.getHighlightCount());
        byte[] sourceBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        SearchHit searchHit = new SearchHit(1);
        assertFalse("Source should not be set when sourceRef is null", hit.hasXSource());
        assertTrue("Source should be set", hit.hasXSource());
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
    public void testToProtoWithOnlyNullSortValue() throws IOException {
        SearchHit searchHit = new SearchHit(1);  
        assertEquals("Second matched query should match", "query2", hit.getMatchedQueries(1));  
        assertNotNull("Hit should not be null", hit);
        assertEquals("SeqNo should match", 4, hit.getXSeqNo());
        assertEquals("Score value should match", 3.14159, hitWithScore.getXScore().getDouble(), 0.00001);
        // Verify the result  
        byte[] expectedJsonBytes = jsonContent.getBytes(StandardCharsets.UTF_8);  
        assertEquals("Source size should match JSON length", jsonLength, hit.getXSource().size());
        assertTrue("Should use names (StringArray)", hit.getMatchedQueries2().hasNames());
        CompositeBytesReference compositeBytesRef = (CompositeBytesReference) CompositeBytesReference.of(part1, part2);  
import org.opensearch.search.SearchHits;
        // Create BytesArray with offset > 0 to extract just the JSON part
        String jsonContent = "{\"test\":\"optimization\"}";  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        byte[] sourceBytes = "{\"field\":\"value\",\"number\":42}".getBytes(StandardCharsets.UTF_8);
import org.opensearch.core.common.bytes.CompositeBytesReference;
        // Call the method under test  
    }
        searchHitWithComposite.sourceRef(composite);
        assertEquals("Inner hit should have 1 hit", 1, hit.getInnerHitsOrThrow("inner_hit").getHits().getHitsCount());  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        // Explicitly set source to null to test null handling
        assertFalse("SeqNo should not be set", hit.hasXSeqNo());
        SearchHit searchHitWithScore = new SearchHit(1);
        // Verify the result
    public void testToProtoWithNestedIdentity() throws Exception {
        // Create a BytesArray that represents just the JSON part  
        SearchHit searchHit = new SearchHit(1);
import org.opensearch.test.OpenSearchTestCase;
        SearchHit searchHit = new SearchHit(1);  
        assertEquals("Score should match", 2.0, hit.getXScore().getDouble(), 0.0);  
        // Call the method under test
            hitWithBytesArray.getXSource().toByteArray(),
        // Call the method under test
        int offset = 6; // "prefix".length()
        SearchHit searchHit = new SearchHit(1);
            largeJsonBuilder.append("{\"id\":").append(i).append(",\"value\":\"item").append(i).append("\"}");
        // Call the method under test
        assertArrayEquals("Source bytes should match only the JSON portion", expectedJsonBytes, hit.getXSource().toByteArray());
    }
        searchHit.setSeqNo(4);
        searchHit.matchedQueries(new String[] { "filter1", "filter2" });
    public void testToProtoWithNullScore() throws IOException {
        assertNotNull("Hit should not be null", hit);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        // Verify the result  
            "First value should match",
        assertArrayEquals(  
import org.apache.lucene.search.Explanation;
        SearchHit searchHit = new SearchHit(1);  
        // Call the method under test  
        String fullContent = prefix + jsonContent + suffix;
    }  
        BytesArray bytesArray = new BytesArray(jsonBytes);
        String jsonContent = "{\"field\":\"value\"}";
 * SPDX-License-Identifier: Apache-2.0
        StringBuilder largeJsonBuilder = new StringBuilder("{\"data\":[");
        assertFalse("Zero score should not have null value", hitWithZeroScore.getXScore().hasNullValue());
    }
        assertNotNull("Hit should not be null", hit);
import org.opensearch.core.index.shard.ShardId;
        // Test with CompositeBytesReference (should use deep copy)  
    }  
        searchHit.sourceRef(slicedBytesArray);  
    public void testToProtoWithActuallyEmptyBytesArray() throws IOException {
        assertNotNull("Hit should not be null", hit);
        assertEquals("Should have 2 matched query names", 2, hit.getMatchedQueries2().getNames().getStringArrayCount());  
 */  
        assertTrue("Score should be set", hit.hasXScore());
        // Call the method under test
        assertTrue("Source should be set", hit.hasXSource());
        assertArrayEquals("Source bytes should match exactly", largeSourceBytes, hit.getXSource().toByteArray());
        assertFalse("Score should not be null", hit.getXScore().hasNullValue());
        assertNotNull("Hit should not be null", hit);
        // Call the method under test  
        assertTrue("Source should be set", hit.hasXSource());
        assertEquals("Source size should match JSON length", length, hit.getXSource().size());
        // Call the method under test
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        BytesArray bytesArray = new BytesArray(sourceBytes);
        BytesArray part1 = new BytesArray(bytes1);
        // Create a larger byte array
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        BytesArray largeBytesArray = new BytesArray(largeSourceBytes);  
        assertEquals("Source size should match large content", largeSourceBytes.length, hit.getXSource().size());  
            hit.getXScore().getNullValue()
        SearchHit searchHit = new SearchHit(1);  
        HitsMetadataHitsInner hitWithComposite = SearchHitProtoUtils.toProto(searchHitWithComposite);  
        searchHitWithZeroScore.score(0.0f);
        // Add document fields
    public void testToProtoWithNullSourceRef() throws IOException {  
import java.util.ArrayList;
import java.util.HashMap;  
        assertArrayEquals("Source bytes should match exactly", sourceBytes, hit.getXSource().toByteArray());
        SearchHit searchHit = new SearchHit(1);
        assertEquals("Should have 1 sort value", 1, hit.getSortCount());
        assertEquals("Should have 2 matched queries", 2, hit.getMatchedQueriesCount());
        assertNotNull("Hit should not be null", hit);
        byte[] expectedBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        // Create a SearchHit with explanation
        innerHits.put("inner_hit", new SearchHits(innerHitsArray, new TotalHits(1, EQUAL_TO), 1.0f));
        // Call the method under test
        // Test behavior when source reference is null
    public void testToProtoWithBytesArrayZeroCopyOptimization() throws IOException {
        String jsonContent = "{\"important\":\"data\",\"field\":\"value\"}";
        assertEquals("Inner hit ID should match", "inner_id", hit.getInnerHitsOrThrow("inner_hit").getHits().getHits(0).getXId());
 * The OpenSearch Contributors require contributions made to  
        assertTrue("matched_queries_2 should be set", hit.hasMatchedQueries2());  
        searchHit.sourceRef(new BytesArray(sourceBytes));  
        // Verify the result  
        searchHit.highlightFields(highlightFields);  
        SearchHit searchHit = new SearchHit(1, "1", nestedIdentity, null, null);
        String expectedJson = "{\"field1\":\"value1\"}";
        // Create a SearchHit with BytesArray source that has offset/length (should use zero-copy with offset)
        // Test the optimization with a BytesArray that represents a slice of a larger array
        assertArrayEquals("Source bytes should match empty JSON object", emptyJsonBytes, hit.getXSource().toByteArray());
        // Create a SearchHit with highlight fields
        // Call the method under test
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        assertEquals("Should have 2 sort values", 2, hit.getSortCount());  
        // Call the method under test
    }
        // Create a SearchHit with inner hits
        searchHit.setDocumentField("field1", new DocumentField("field1", fieldValues));  
    }  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        // Create a SearchHit with source  
        fieldValues.add("value1");
        assertEquals("Negative score value should match", -1.5, hitWithNegativeScore.getXScore().getDouble(), 0.0);  
        searchHit.score(Float.NaN);
        // Both should produce the same result
        assertNotNull("Hit should not be null", hit);  
    }
        byte[] jsonBytes = jsonContent.getBytes(StandardCharsets.UTF_8);
        assertEquals("Highlight fragment should match", "highlighted text", hit.getHighlightOrThrow("field1").getStringArray(0));
        byte[] fullBytes = "prefix{\"field\":\"value\"}suffix".getBytes(StandardCharsets.UTF_8);  
        // Verify the result
}
        assertFalse("PrimaryTerm should not be set", hit.hasXPrimaryTerm());
        SearchHit searchHit = new SearchHit(1);
        assertEquals("ID should match", "test_id", hit.getXId());
        // Verify the result
            "Both approaches should produce identical byte content",
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
import org.opensearch.common.document.DocumentField;  
            hitWithComposite.getXSource().size()
        assertFalse("Negative score should not have null value", hitWithNegativeScore.getXScore().hasNullValue());
        // Verify the result
        // by checking if the source is null before processing  
        assertTrue("Score should be set", hitWithScore.hasXScore());
        assertFalse("Version should not be set", hit.hasXVersion());
        assertNotNull("Hit should not be null", hit);  
        // Test with negative score
        // Create a SearchHit with NaN score
        assertEquals("Explanation value should match", 1.0, hit.getXExplanation().getValue(), 0.0);  
        SearchHit searchHitWithComposite = new SearchHit(2);
        assertTrue("Score should have null value for NaN", hit.getXScore().hasNullValue());  
    public void testToProtoSourceOptimizationBehaviorComparison() throws IOException {
            hit.getFields().getFieldsOrThrow("field1").getListValue().getValue(1).getString()  
        );
        // Verify the result
        assertEquals("Explanation description should match", "explanation", hit.getXExplanation().getDescription());
        // Call the method under test  
        // Call the method under test
        // Test with BytesArray (should use zero-copy optimization)  
        int length = expectedBytes.length;  
    public void testToProtoWithEmptyBytesArraySource() throws IOException {
        // Create a SearchHit with cluster alias  
        SearchHit searchHit = new SearchHit(1, "test_id", null, null);
    }  
        // Don't set any fields
        assertTrue("Score should be set for NaN", hit.hasXScore());
        assertEquals("Nested offset should match", 5, hit.getXNested().getOffset());
        // Add matched queries
        assertFalse("Score should not have null value", hitWithScore.getXScore().hasNullValue());  
        assertEquals("First matched query should match", "query1", hit.getMatchedQueries(0));
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        // Test the specific condition coverage for BytesArray when offset != 0 OR length != bytes.length
    }
        assertNotNull("Hit should not be null", hit);
        byte[] expectedBytes = jsonContent.getBytes(StandardCharsets.UTF_8);
        BytesArray part1 = new BytesArray(jsonBytes, 0, jsonBytes.length / 2);
            "value1",  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertTrue("Source should be set", hit.hasXSource());
        List<Object> fieldValues = new ArrayList<>();  
        // Test with a valid score  
        // This will trigger the condition: bytesRef.offset != 0 || bytesRef.length != bytesRef.bytes.length
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        // Verify the result
        for (int i = 0; i < 1000; i++) {
        // Call the method under test  
        assertNotNull("Hit should not be null", hit);  
        CompositeBytesReference composite = (CompositeBytesReference) CompositeBytesReference.of(part1, part2);
        assertNotNull("Hit should not be null", hit);  
    public void testToProtoWithNullSortValue() throws IOException {
        // Call the method under test
        // Create a SearchHit with matched queries
        assertEquals("Index should match", "test_index", hit.getXIndex());
        // This is an indirect test - we verify the content is correct and assume the optimization was used
        assertNotNull("Hit should not be null", hit);  
    public void testToProtoWithBytesArraySliceZeroCopyOptimization() throws IOException {
        BytesArray slicedBytesArray = new BytesArray(fullBytes, jsonStart, jsonLength);
        byte[] emptyJsonBytes = "{}".getBytes(StandardCharsets.UTF_8);
        searchHit.matchedQueries(new String[] { "query1", "query2" });  
        assertEquals("Source size should match combined length", expectedBytes.length, hit.getXSource().size());
        // Add highlight fields
        HitsMetadataHitsInner hitWithBytesArray = SearchHitProtoUtils.toProto(searchHitWithBytesArray);
        Map<String, SearchHits> innerHits = new HashMap<>();  
        searchHit.shard(new SearchShardTarget("test_node", new ShardId("test_index", "_na_", 0), null, null));  
        // Call the method under test  
        // Create a SearchHit with unassigned seqNo
        assertArrayEquals("Source bytes should match the combined content", expectedBytes, hit.getXSource().toByteArray());
        Text[] fragments = new Text[] { new Text("highlighted text") };
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        // Verify the result - should use the offset/length version of unsafeWrap
        // This covers the else branch in the optimization logic (lines 207-208)  
        assertFalse("Source should not be set", hit.hasXSource());
        // Create a SearchHit with basic fields  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
    public void testToProtoWithSource() throws IOException {
import java.util.Map;
        int offset = prefix.length();  
        searchHit.version(3);
        SearchHit.NestedIdentity nestedIdentity = new SearchHit.NestedIdentity("parent_field", 5, null);  
        assertEquals("Source should contain empty JSON object", emptyJsonBytes.length, hit.getXSource().size());  
        assertArrayEquals("Source bytes should match JSON content", expectedBytes, hit.getXSource().toByteArray());
        // Create a SearchHit with BytesArray source (should use zero-copy optimization)
    }
        // Create a SearchHit with null fields  
        searchHit.shard(new SearchShardTarget("test_node", new ShardId("test_index", "_na_", 0), null, null));  
        SearchHit searchHit = new SearchHit(1);
        // Create a SearchHit with large BytesArray source to test performance benefit
        String suffix = "SUFFIX";  
        SearchHit searchHit = new SearchHit(1);
import org.opensearch.protobufs.HitsMetadataHitsInner;  
        assertTrue("Explanation should be set", hit.hasXExplanation());
        Map<String, HighlightField> highlightFields = new HashMap<>();  
    public void testToProtoWithBytesArrayWithOffsetZeroCopyOptimization() throws IOException {  
        assertTrue("Inner hit should exist", hit.containsInnerHits("inner_hit"));
import java.io.IOException;  
        assertTrue("Fields should be set", hit.hasFields());
            "Second value should match",
        assertTrue("Source should not be empty", hit.getXSource().size() > 0);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
    public void testToProtoWithNullFields() throws IOException {
        // Test to demonstrate the difference in behavior between BytesArray and other BytesReference types
        SearchHit searchHitWithNegativeScore = new SearchHit(3);
import org.opensearch.index.seqno.SequenceNumbers;
            "value2",
        assertNotNull("Hit should not be null", hit);  
        );
    }  
        assertNotNull("Hit with zero score should not be null", hitWithZeroScore);
        // Verify the result
        assertArrayEquals("Source bytes should match", sourceBytes, hit.getXSource().toByteArray());
        assertEquals("Null sort value should match proto enum", NullValue.NULL_VALUE_NULL, hit.getSort(1).getNullValue());
        searchHitWithNegativeScore.score(-1.5f);  
        assertNotNull("Hit should not be null", hit);
        SearchHit searchHit = new SearchHit(1);
        assertNotNull("Hit with negative score should not be null", hitWithNegativeScore);
        assertNotNull("Hit should not be null", hit);
import org.opensearch.protobufs.NullValue;
    public void testToProtoWithBytesArrayOffsetConditionCoverage() throws IOException {
        // Call the method under test
        int jsonLength = jsonContent.length();  
            hitWithBytesArray.getXSource().size(),
        assertNotNull("Hit should not be null", hit);  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
    public void testToProtoWithClusterAlias() throws IOException {
        searchHit.sourceRef(largeBytesArray);
            hit.getFields().getFieldsOrThrow("field1").getListValue().getValue(0).getString()
        searchHit.sourceRef(emptyJsonBytesArray);
    public void testToProtoWithUnassignedSeqNo() throws IOException {  
        BytesArray part2 = new BytesArray(bytes2);
        SearchHit searchHit = new SearchHit(1);
        searchHit.sourceRef(slicedBytesArray);
        searchHit.shard(new SearchShardTarget("test_node", new ShardId("test_index", "_na_", 0), "test_cluster", null));
        );
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertTrue("Source should be set", hit.hasXSource());  
 *
        SearchHit searchHit = new SearchHit(1);  
    public void testToProtoWithMatchedQueries() throws IOException {
        // Verify the result
        assertNotNull("Hit should not be null", hit);
        // Verify the result  
        assertFalse("SeqNo should not be set", hit.hasXSeqNo());  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);  
        assertTrue("First sort value should be a string", hit.getSort(0).hasString());
        HitsMetadataHitsInner hitWithNegativeScore = SearchHitProtoUtils.toProto(searchHitWithNegativeScore);
        BytesArray emptyJsonBytesArray = new BytesArray(emptyJsonBytes);  
        // Call the method under test
import org.opensearch.search.SearchShardTarget;
        assertEquals("Zero score value should match", 0.0, hitWithZeroScore.getXScore().getDouble(), 0.0);
        // Verify the combined content is correct
 * compatible open source license.
        assertArrayEquals("Source bytes should match the sliced portion", expectedBytes, hit.getXSource().toByteArray());
        byte[] bytes2 = "\"value1\"}".getBytes(StandardCharsets.UTF_8);  
        // Don't set any source reference (sourceRef remains null)  
        );  
    }
        assertEquals("Index with cluster alias should match", "test_cluster:test_index", hit.getXIndex());  
        // Verify that the ByteString was created using UnsafeByteOperations.unsafeWrap
        searchHit.score(2.0f);
    }
        assertEquals("Source size should match expected length", length, hit.getXSource().size());
    public void testToProtoWithLargeBytesArrayZeroCopyOptimization() throws IOException {
        // Create a SearchHit with document fields
        searchHit.setPrimaryTerm(5);  
        // Verify the result
    }
        // Call the method under test
import java.nio.charset.StandardCharsets;
        SearchHit searchHit = new SearchHit(1);  
        searchHit.sourceRef(compositeBytesRef);
        assertEquals("Field1 should have 2 values", 2, hit.getFields().getFieldsOrThrow("field1").getListValue().getValueCount());  
        SearchHit searchHit = new SearchHit(1);
            org.opensearch.protobufs.NullValue.NULL_VALUE_NULL,  
        // Verify the score structure
        searchHit.sourceRef(bytesArray);
/*  
        assertEquals("Source size should match", sourceBytes.length, hit.getXSource().size());  
        searchHit.sortValues(new Object[] { "first", null }, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW });
    public void testToProtoWithScoreStructure() throws IOException {
        HitsMetadataHitsInner hitWithScore = SearchHitProtoUtils.toProto(searchHitWithScore);
        assertNotNull("Hit should not be null", hit);  
        assertNotNull("Hit should not be null", hit);
        SearchHit searchHit = new SearchHit(1);
        assertFalse("Source should not be set when explicitly null", hit.hasXSource());
        byte[] bytes1 = "{\"field1\":".getBytes(StandardCharsets.UTF_8);
        // Create a SearchHit with nested identity
        BytesArray slicedBytesArray = new BytesArray(fullBytes, offset, length);
        assertEquals("Should have 1 inner hit", 1, hit.getInnerHitsCount());
        // Call the method under test
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertFalse("PrimaryTerm should not be set", hit.hasXPrimaryTerm());
import static org.apache.lucene.search.TotalHits.Relation.EQUAL_TO;
        searchHit.setSeqNo(SequenceNumbers.UNASSIGNED_SEQ_NO);  
        searchHitWithBytesArray.sourceRef(bytesArray);  
        // Verify the result  
    public void testToProtoWithInnerHits() throws IOException {
        assertEquals(
        assertNotNull("Hit should not be null", hit);  
        SearchHit searchHit = new SearchHit(1);  
            hitWithComposite.getXSource().toByteArray()  
        // Verify the result  
        assertEquals("Version should match", 3, hit.getXVersion());  
        assertEquals(  
    public void testToProtoWithMatchedQueriesWithoutScores() throws IOException {
        // Call the method under test
        SearchHit[] innerHitsArray = new SearchHit[] { new SearchHit(2, "inner_id", null, null) };
        searchHit.sourceRef(bytesArray);  
        // Create a SearchHit with minimal valid JSON as source (empty object)  
        }
    public void testToProtoWithExplanation() throws IOException {  
        assertEquals("Index should not be set", "", hit.getXIndex());  
        largeJsonBuilder.append("]}");  
        assertTrue("Nested identity should be set", hit.hasXNested());
        assertEquals("Nested field should match", "parent_field", hit.getXNested().getField());  
        // Verify the result
 * this file be licensed under the Apache-2.0 license or a
    }
        byte[] expectedBytes = expectedJson.getBytes(StandardCharsets.UTF_8);  
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertEquals(
        // Add explanation
    public void testToProtoWithCompositeBytesReferenceUsesDeepCopy() throws IOException {
    public void testToProtoWithBasicFields() throws IOException {
import org.opensearch.search.fetch.subphase.highlight.HighlightField;  
    }
        // Create a larger byte array with prefix and suffix  
        // Test the edge case of truly empty bytes - this should be handled gracefully
            "Both approaches should produce same size",  
        String prefix = "PREFIX";
        SearchHit searchHitWithBytesArray = new SearchHit(1);
        assertNotNull("Hit should not be null", hit);
package org.opensearch.transport.grpc.proto.response.search;
        fieldValues.add("value2");
        searchHitWithScore.score(3.14159f);
    }
            "Score null value should be NULL_VALUE_NULL",
        // Verify the result
        assertEquals("PrimaryTerm should match", 5, hit.getXPrimaryTerm());
        assertTrue("Score should be set", hitWithNegativeScore.hasXScore());
    }
        SearchHit searchHit = new SearchHit(1);
    }
    public void testToProtoWithHighlightFields() throws IOException {
        assertEquals("Null sort value should match proto enum", NullValue.NULL_VALUE_NULL, hit.getSort(0).getNullValue());
        assertFalse("matched_queries_2 should not be set", hit.hasMatchedQueries2());  
        searchHit.sortValues(new Object[] { null }, new DocValueFormat[] { DocValueFormat.RAW });  
        );
        assertEquals("ID should not be set", "", hit.getXId());
import java.util.List;
        assertTrue("Sort value should be null", hit.getSort(0).hasNullValue());  
