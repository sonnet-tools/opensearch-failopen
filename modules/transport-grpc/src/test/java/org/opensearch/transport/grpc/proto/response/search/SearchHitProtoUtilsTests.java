import java.util.HashMap;
        assertFalse("SeqNo should not be set", hit.hasXSeqNo());
    }
        assertEquals("Nested field should match", "parent_field", hit.getXNested().getField());
        searchHit.matchedQueries(new String[] { "filter1", "filter2" });
        // Call the method under test
            "Both approaches should produce identical byte content",
        SearchHit searchHit = new SearchHit(1, "test_id", null, null);
import org.opensearch.core.common.bytes.CompositeBytesReference;
        // Call the method under test
        assertArrayEquals("Source bytes should match JSON content", expectedBytes, hit.getXSource().toByteArray());
        assertTrue("Source should be set", hit.hasXSource());
        assertTrue("Source should be set", hit.hasXSource());
    public void testToProtoWithBytesArrayOffsetConditionCoverage() throws IOException {
    public void testToProtoWithNestedIdentity() throws Exception {
        // Test the edge case of truly empty bytes - this should be handled gracefully
    }
        byte[] fullBytes = "prefix{\"field\":\"value\"}suffix".getBytes(StandardCharsets.UTF_8);
    public void testToProtoWithNullSortValue() throws IOException {
        BytesArray bytesArray = new BytesArray(jsonBytes);
        SearchHit searchHitWithZeroScore = new SearchHit(2);
        // Create a SearchHit with BytesArray source that has offset/length (should use zero-copy with offset)
        BytesArray bytesArray = new BytesArray(fullBytes, offset, length);
        assertFalse("Score should not have null value", hitWithScore.getXScore().hasNullValue());
        );
        assertFalse("Source should not be set when sourceRef is null", hit.hasXSource());
        // Verify the result
        highlightFields.put("field1", new HighlightField("field1", fragments));
        assertFalse("Negative score should not have null value", hitWithNegativeScore.getXScore().hasNullValue());
        // Verify the result
        // Test behavior when source reference is null
        SearchHit searchHit = new SearchHit(1);
        // Verify the result
        // by checking if the source is null before processing
        // Call the method under test
        assertTrue("Score should be set", hitWithZeroScore.hasXScore());
        assertEquals("First sort value should match", "first", hit.getSort(0).getString());
        // Create a SearchHit with NaN score
    }
        assertFalse("Score should not be null", hit.getXScore().hasNullValue());
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        }
        );
        // Create a larger byte array with prefix and suffix
        searchHit.setSeqNo(SequenceNumbers.UNASSIGNED_SEQ_NO);
        String fullContent = prefix + jsonContent + suffix;
        // Call the method under test
            hit.getFields().getFieldsOrThrow("field1").getListValue().getValue(1).getString()
            hitWithComposite.getXSource().size()
        assertEquals("Should have 1 sort value", 1, hit.getSortCount());
        // Create a SearchHit with explanation
        assertNotNull("Hit with score should not be null", hitWithScore);
    public void testToProtoWithEmptyBytesArraySource() throws IOException {
        assertArrayEquals("Source bytes should match the sliced portion", expectedBytes, hit.getXSource().toByteArray());
        assertEquals("Negative score value should match", -1.5, hitWithNegativeScore.getXScore().getDouble(), 0.0);
    public void testToProtoWithMatchedQueries() throws IOException {
    public void testToProtoWithScoreStructure() throws IOException {
        BytesArray bytesArray = new BytesArray(sourceBytes);
        searchHit.matchedQueries(new String[] { "query1", "query2" });
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        // Call the method under test
        // Create a SearchHit with large BytesArray source to test performance benefit
        assertEquals("ID should match", "test_id", hit.getXId());
        SearchHit searchHit = new SearchHit(1);
    public void testToProtoWithBytesArrayZeroCopyOptimization() throws IOException {
        assertTrue("Score should be set", hitWithScore.hasXScore());
        );
        assertEquals("Version should match", 3, hit.getXVersion());
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
            if (i > 0) largeJsonBuilder.append(",");
        assertEquals(
        // Test with zero score
        // Both should produce the same result
        // This will trigger the condition: bytesRef.offset != 0 || bytesRef.length != bytesRef.bytes.length
        // This covers the else branch in the optimization logic (lines 207-208)
        byte[] expectedBytes = jsonContent.getBytes(StandardCharsets.UTF_8);
        SearchHit searchHit = new SearchHit(1);
            hitWithBytesArray.getXSource().toByteArray(),
        assertTrue("Field1 should exist", hit.getFields().containsFields("field1"));
    public void testToProtoWithHighlightFields() throws IOException {
    }
        assertFalse("PrimaryTerm should not be set", hit.hasXPrimaryTerm());
        // Test with a valid score
        for (int i = 0; i < 1000; i++) {
        // Verify the combined content is correct
        Text[] fragments = new Text[] { new Text("highlighted text") };
        byte[] bytes1 = "{\"field1\":".getBytes(StandardCharsets.UTF_8);
        searchHit.sourceRef(emptyJsonBytesArray);
        searchHit.highlightFields(highlightFields);
        assertEquals("Index should not be set", "", hit.getXIndex());
        String jsonContent = "{\"test\":\"optimization\"}";
        // Don't set any fields
        assertNotNull("Hit should not be null", hit);
    public void testToProtoWithMatchedQueriesWithoutScores() throws IOException {
    public void testToProtoWithExplanation() throws IOException {
    public void testToProtoWithBytesArraySliceZeroCopyOptimization() throws IOException {
        assertFalse("Source should not be set when explicitly null", hit.hasXSource());
import org.opensearch.common.document.DocumentField;
        // Create a SearchHit with basic fields
        // Test with negative score
        byte[] sourceBytes = "{\"field\":\"value\",\"number\":42}".getBytes(StandardCharsets.UTF_8);
        byte[] expectedJsonBytes = jsonContent.getBytes(StandardCharsets.UTF_8);
        int length = expectedBytes.length;
        assertTrue("Highlight field1 should exist", hit.containsHighlight("field1"));
import org.opensearch.core.common.bytes.BytesArray;
        assertNotNull("Hit should not be null", hit);
        assertTrue("Nested identity should be set", hit.hasXNested());
        SearchHit searchHitWithNegativeScore = new SearchHit(3);
        SearchHit searchHit = new SearchHit(1);
        assertNotNull("Hit with zero score should not be null", hitWithZeroScore);
        // Call the method under test
        assertFalse("Zero score should not have null value", hitWithZeroScore.getXScore().hasNullValue());
    }
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
import java.util.ArrayList;
    public void testToProtoSourceOptimizationBehaviorComparison() throws IOException {
        assertEquals("Should have 1 inner hit", 1, hit.getInnerHitsCount());
    }
        HitsMetadataHitsInner hitWithComposite = SearchHitProtoUtils.toProto(searchHitWithComposite);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertNotNull("Hit should not be null", hit);
        SearchHit searchHit = new SearchHit(1);
        assertNotNull("Hit should not be null", hit);
        assertNotNull("Hit should not be null", hit);
        // Verify the result
        assertNotNull("Hit should not be null", hit);
        assertEquals("First matched query should match", "query1", hit.getMatchedQueries(0));
        assertNotNull("Hit should not be null", hit);
        // Add highlight fields
        searchHit.sourceRef(bytesArray);
        searchHit.sourceRef(bytesArray);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertEquals("PrimaryTerm should match", 5, hit.getXPrimaryTerm());
    public void testToProtoWithClusterAlias() throws IOException {
import org.opensearch.index.seqno.SequenceNumbers;
            "Second value should match",
        // Don't set any source reference (sourceRef remains null)
        searchHitWithBytesArray.sourceRef(bytesArray);
        SearchHit searchHitWithScore = new SearchHit(1);
        // Verify the result
        byte[] expectedBytes = expectedJson.getBytes(StandardCharsets.UTF_8);
import org.opensearch.search.SearchHits;
        Explanation explanation = Explanation.match(1.0f, "explanation");
        assertEquals("Source size should match large content", largeSourceBytes.length, hit.getXSource().size());
        assertTrue("Source should be set", hit.hasXSource());
        assertEquals("Should have 2 matched queries", 2, hit.getMatchedQueriesCount());
        HitsMetadataHitsInner hitWithZeroScore = SearchHitProtoUtils.toProto(searchHitWithZeroScore);
        assertEquals("Score value should match", 3.14159, hitWithScore.getXScore().getDouble(), 0.00001);
    public void testToProtoWithCompositeBytesReferenceUsesDeepCopy() throws IOException {
        // Add explanation
        // Create a SearchHit with null fields
 *
        BytesArray slicedBytesArray = new BytesArray(fullBytes, jsonStart, jsonLength);
        SearchHit searchHit = new SearchHit(1);
        SearchHit searchHit = new SearchHit(1);
        searchHit.shard(new SearchShardTarget("test_node", new ShardId("test_index", "_na_", 0), "test_cluster", null));
        // Test the optimization with a BytesArray that represents a slice of a larger array
import java.util.List;
        assertEquals("Inner hit ID should match", "inner_id", hit.getInnerHitsOrThrow("inner_hit").getHits().getHits(0).getXId());
        int offset = 6; // "prefix".length()
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        searchHit.setPrimaryTerm(5);
    public void testToProtoWithUnassignedSeqNo() throws IOException {
    }
    public void testToProtoWithLargeBytesArrayZeroCopyOptimization() throws IOException {
        // Verify the result
        assertTrue("Should use names (StringArray)", hit.getMatchedQueries2().hasNames());
        assertNotNull("Hit should not be null", hit);
    }
        assertNotNull("Hit should not be null", hit);
    public void testToProtoWithBytesArrayWithOffsetZeroCopyOptimization() throws IOException {
import org.opensearch.protobufs.HitsMetadataHitsInner;
        assertArrayEquals("Source bytes should match the combined content", expectedBytes, hit.getXSource().toByteArray());
        int jsonStart = 6; // "HEADER".length()
        byte[] fullBytes = fullContent.getBytes(StandardCharsets.UTF_8);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.shard.ShardId;
        // Create a SearchHit with source
package org.opensearch.transport.grpc.proto.response.search;
        fieldValues.add("value2");
        assertNotNull("Hit should not be null", hit);
        searchHit.sourceRef(largeBytesArray);
        HitsMetadataHitsInner hitWithBytesArray = SearchHitProtoUtils.toProto(searchHitWithBytesArray);
        BytesArray largeBytesArray = new BytesArray(largeSourceBytes);
        );
        // Call the method under test
        SearchHit searchHitWithBytesArray = new SearchHit(1);
        // Create a SearchHit with inner hits
        assertEquals("Highlight fragment should match", "highlighted text", hit.getHighlightOrThrow("field1").getStringArray(0));
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertEquals("Source should contain empty JSON object", emptyJsonBytes.length, hit.getXSource().size());
        assertTrue("Inner hit should exist", hit.containsInnerHits("inner_hit"));
        // Test to demonstrate the difference in behavior between BytesArray and other BytesReference types
        assertNotNull("Hit should not be null", hit);
        BytesArray emptyJsonBytesArray = new BytesArray(emptyJsonBytes);
        Map<String, HighlightField> highlightFields = new HashMap<>();
        // Verify the result
        searchHit.setInnerHits(innerHits);
        assertTrue("Score should be set", hit.hasXScore());
        assertFalse("Should not use scores (DoubleMap)", hit.getMatchedQueries2().hasScores());
        searchHit.score(Float.NaN);
        SearchHit searchHit = new SearchHit(1);
        searchHit.sortValues(new Object[] { "first", null }, new DocValueFormat[] { DocValueFormat.RAW, DocValueFormat.RAW });
        assertTrue("Source should not be empty", hit.getXSource().size() > 0);
        byte[] sourceBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        assertEquals("Zero score value should match", 0.0, hitWithZeroScore.getXScore().getDouble(), 0.0);
        searchHit.sortValues(new Object[] { null }, new DocValueFormat[] { DocValueFormat.RAW });
import org.opensearch.protobufs.NullValue;
        assertTrue("matched_queries_2 should be set", hit.hasMatchedQueries2());
        // Create a SearchHit with nested identity
        assertEquals("Index with cluster alias should match", "test_cluster:test_index", hit.getXIndex());
    public void testToProtoWithInnerHits() throws IOException {
        searchHit.shard(new SearchShardTarget("test_node", new ShardId("test_index", "_na_", 0), null, null));
        assertEquals("Source size should match combined length", expectedBytes.length, hit.getXSource().size());
        assertNotNull("Hit should not be null", hit);
        assertEquals("Score should match", 2.0, hit.getXScore().getDouble(), 0.0);
import org.apache.lucene.search.TotalHits;
        assertArrayEquals("Source bytes should match", sourceBytes, hit.getXSource().toByteArray());
        assertEquals("Null sort value should match proto enum", NullValue.NULL_VALUE_NULL, hit.getSort(1).getNullValue());
        assertEquals(
        String suffix = "SUFFIX";
    public void testToProtoWithDocumentFields() throws IOException {
        assertNotNull("Hit with negative score should not be null", hitWithNegativeScore);
 * The OpenSearch Contributors require contributions made to
        assertTrue("Fields should be set", hit.hasFields());
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        CompositeBytesReference composite = (CompositeBytesReference) CompositeBytesReference.of(part1, part2);
        assertNotNull("Hit should not be null", hit);
import java.nio.charset.StandardCharsets;
        // Verify the result
import org.opensearch.search.DocValueFormat;
        assertEquals("Source size should match expected length", length, hit.getXSource().size());
        assertEquals("ID should not be set", "", hit.getXId());
        // Verify the score structure
            "value2",
            hitWithComposite.getXSource().toByteArray()
        // Add document fields
        // Create a SearchHit with BytesArray source (should use zero-copy optimization)
        assertFalse("PrimaryTerm should not be set", hit.hasXPrimaryTerm());
        assertEquals("Index should match", "test_index", hit.getXIndex());
        byte[] expectedBytes = "{\"field\":\"value\"}".getBytes(StandardCharsets.UTF_8);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        assertNotNull("Hit should not be null", hit);
        List<Object> fieldValues = new ArrayList<>();
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
public class SearchHitProtoUtilsTests extends OpenSearchTestCase {
        searchHit.sourceRef(new BytesArray(sourceBytes));
        SearchHit searchHit = new SearchHit(1);
        // Verify that the ByteString was created using UnsafeByteOperations.unsafeWrap
        HitsMetadataHitsInner hitWithNegativeScore = SearchHitProtoUtils.toProto(searchHitWithNegativeScore);
        // Create a BytesArray that represents just the JSON part
        assertEquals("Null sort value should match proto enum", NullValue.NULL_VALUE_NULL, hit.getSort(0).getNullValue());
        SearchHit searchHit = new SearchHit(1);
        assertTrue("Source should be set", hit.hasXSource());
        assertArrayEquals("Source bytes should match exactly", largeSourceBytes, hit.getXSource().toByteArray());
    }
        SearchHit searchHit = new SearchHit(1);
    public void testToProtoWithSource() throws IOException {
        BytesArray part1 = new BytesArray(jsonBytes, 0, jsonBytes.length / 2);
    }
        SearchHit searchHit = new SearchHit(1);
        // Create a SearchHit with highlight fields
    }
    }
        searchHitWithZeroScore.score(0.0f);
            org.opensearch.protobufs.NullValue.NULL_VALUE_NULL,
        BytesArray part1 = new BytesArray(bytes1);
            "value1",
        // Call the method under test
        assertFalse("Version should not be set", hit.hasXVersion());
    public void testToProtoWithNullScore() throws IOException {
    }
        SearchHit.NestedIdentity nestedIdentity = new SearchHit.NestedIdentity("parent_field", 5, null);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        // Create a SearchHit with minimal valid JSON as source (empty object)
    public void testToProtoWithNullFields() throws IOException {
            largeJsonBuilder.append("{\"id\":").append(i).append(",\"value\":\"item").append(i).append("\"}");
    public void testToProtoWithNullSourceRef() throws IOException {
    }
        BytesArray part2 = new BytesArray(jsonBytes, jsonBytes.length / 2, jsonBytes.length - jsonBytes.length / 2);
        // Verify the result
        // Call the method under test
        SearchHit searchHit = new SearchHit(1);
        StringBuilder largeJsonBuilder = new StringBuilder("{\"data\":[");
        assertTrue("Score should have null value for NaN", hit.getXScore().hasNullValue());
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
import org.apache.lucene.search.Explanation;
        // Verify the result
        String fullContent = "HEADER{\"important\":\"data\",\"field\":\"value\"}FOOTER";
    public void testToProtoWithActuallyEmptyBytesArray() throws IOException {
        searchHit.sourceRef(null);
        // Create a SearchHit with CompositeBytesReference source (should use ByteString.copyFrom)
 * this file be licensed under the Apache-2.0 license or a
        // Verify the result
        SearchHit searchHit = new SearchHit(1);
        largeJsonBuilder.append("]}");
        assertEquals("Field1 should have 2 values", 2, hit.getFields().getFieldsOrThrow("field1").getListValue().getValueCount());
        assertEquals("SeqNo should match", 4, hit.getXSeqNo());
        assertTrue("Second sort value should be null", hit.getSort(1).hasNullValue());
import java.util.Map;
        byte[] emptyJsonBytes = "{}".getBytes(StandardCharsets.UTF_8);
        assertEquals("Explanation description should match", "explanation", hit.getXExplanation().getDescription());
import org.opensearch.test.OpenSearchTestCase;
        // Verify the result
        assertTrue("Score should be set for NaN", hit.hasXScore());
        assertTrue("Explanation should be set", hit.hasXExplanation());
        assertEquals("Inner hit should have 1 hit", 1, hit.getInnerHitsOrThrow("inner_hit").getHits().getHitsCount());
    public void testToProtoWithOnlyNullSortValue() throws IOException {
        assertNotNull("Hit should not be null", hit);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        searchHitWithComposite.sourceRef(composite);
    }
        assertArrayEquals("Source bytes should match only the JSON portion", expectedJsonBytes, hit.getXSource().toByteArray());
        SearchHit searchHit = new SearchHit(1);
        // Create a SearchHit with cluster alias
        SearchHit searchHit = new SearchHit(1);
        assertEquals("Second matched query should match", "query2", hit.getMatchedQueries(1));
        // Call the method under test
        assertNotNull("Hit should not be null", hit);
        // Verify the result
        // Call the method under test
        fieldValues.add("value1");
        assertTrue("First sort value should be a string", hit.getSort(0).hasString());
        byte[] fullBytes = fullContent.getBytes(StandardCharsets.UTF_8);
        byte[] jsonBytes = jsonContent.getBytes(StandardCharsets.UTF_8);
        SearchHit searchHitWithComposite = new SearchHit(2);
        SearchHit searchHit = new SearchHit(1);
        assertEquals("Source size should match JSON length", jsonLength, hit.getXSource().size());
        searchHit.sourceRef(compositeBytesRef);
    }
import org.opensearch.search.SearchHit;
        assertTrue("Sort value should be null", hit.getSort(0).hasNullValue());
        // Verify the result
        // Call the method under test
        // Create BytesArray with offset > 0 to extract just the JSON part
        assertEquals("Should have 2 matched query names", 2, hit.getMatchedQueries2().getNames().getStringArrayCount());
        String expectedJson = "{\"field1\":\"value1\"}";
        // Explicitly set source to null to test null handling
        searchHit.sourceRef(slicedBytesArray);
        assertNotNull("Hit should not be null", hit);
/*
            "First value should match",
        searchHit.setSeqNo(4);
    public void testToProtoWithNoMatchedQueries() throws IOException {
        // Call the method under test
        int jsonLength = jsonContent.length();
        assertTrue("Source should be set", hit.hasXSource());
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        // Call the method under test
        // Verify the result
        HitsMetadataHitsInner hitWithScore = SearchHitProtoUtils.toProto(searchHitWithScore);
        // Verify the result
        assertNotNull("Hit should not be null", hit);
    }
        innerHits.put("inner_hit", new SearchHits(innerHitsArray, new TotalHits(1, EQUAL_TO), 1.0f));
        assertTrue("Source should be set", hit.hasXSource());
    }
        assertTrue("Score should be set", hitWithNegativeScore.hasXScore());
        SearchHit searchHit = new SearchHit(1);
        // Call the method under test
import org.opensearch.search.SearchShardTarget;
        // Call the method under test
        Map<String, SearchHits> innerHits = new HashMap<>();
        CompositeBytesReference compositeBytesRef = (CompositeBytesReference) CompositeBytesReference.of(part1, part2);
        byte[] bytes2 = "\"value1\"}".getBytes(StandardCharsets.UTF_8);
        // Create a SearchHit with unassigned seqNo
        assertFalse("SeqNo should not be set", hit.hasXSeqNo());
        byte[] largeSourceBytes = largeJsonBuilder.toString().getBytes(StandardCharsets.UTF_8);
        assertEquals(
            "Score null value should be NULL_VALUE_NULL",
        assertFalse("Source should not be set", hit.hasXSource());
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        BytesArray slicedBytesArray = new BytesArray(fullBytes, offset, length);
    }
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        searchHit.version(3);
        );
        // Test with BytesArray (should use zero-copy optimization)
        searchHit.shard(new SearchShardTarget("test_node", new ShardId("test_index", "_na_", 0), null, null));
        assertEquals("Should have 2 sort values", 2, hit.getSortCount());
        // Add matched queries
    }
        assertEquals("Source size should match", sourceBytes.length, hit.getXSource().size());
        SearchHit searchHit = new SearchHit(1, "1", nestedIdentity, null, null);
        assertNotNull("Hit should not be null", hit);
            "Both approaches should produce same size",
        assertTrue("Source should be set", hit.hasXSource());
}
        int offset = prefix.length();
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        // Test with CompositeBytesReference (should use deep copy)
        assertNotNull("Hit should not be null", hit);
import static org.apache.lucene.search.TotalHits.Relation.EQUAL_TO;
        assertArrayEquals(
        assertNotNull("Hit should not be null", hit);
    }
    }
        assertEquals("Should have 1 highlight field", 1, hit.getHighlightCount());
 * compatible open source license.
    public void testToProtoWithBasicFields() throws IOException {
        String prefix = "PREFIX";
        assertArrayEquals("Source bytes should match exactly", sourceBytes, hit.getXSource().toByteArray());
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
            hitWithBytesArray.getXSource().size(),
        // Create a SearchHit with document fields
    }
        searchHit.sourceRef(slicedBytesArray);
        // Call the method under test
    }
    }
        assertFalse("matched_queries_2 should not be set", hit.hasMatchedQueries2());
 */
        // Verify the result
        assertEquals(
        // Verify the result
            hit.getXScore().getNullValue()
import java.io.IOException;
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        SearchHit searchHit = new SearchHit(1);
        // Call the method under test
        assertArrayEquals("Source bytes should match empty JSON object", emptyJsonBytes, hit.getXSource().toByteArray());
    }
        SearchHit searchHit = new SearchHit(1);
        assertEquals("Highlight field1 should have 1 fragment", 1, hit.getHighlightOrThrow("field1").getStringArrayCount());
        // Add inner hits
        String jsonContent = "{\"field\":\"value\"}";
        int length = jsonContent.length();
        // Verify the result - should use the offset/length version of unsafeWrap
        assertNotNull("Hit should not be null", hit);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
            hit.getFields().getFieldsOrThrow("field1").getListValue().getValue(0).getString()
        assertNotNull("Hit should not be null", hit);
        // This is an indirect test - we verify the content is correct and assume the optimization was used
        searchHitWithScore.score(3.14159f);
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
import org.opensearch.core.common.text.Text;
        assertNotNull("Hit should not be null", hit);
        // Verify the result
        BytesArray part2 = new BytesArray(bytes2);
        searchHit.explanation(explanation);
        searchHitWithNegativeScore.score(-1.5f);
        SearchHit searchHit = new SearchHit(1);
        assertNotNull("Hit should not be null", hit);
        String jsonContent = "{\"important\":\"data\",\"field\":\"value\"}";
        // Test the specific condition coverage for BytesArray when offset != 0 OR length != bytes.length
        // Verify the result
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        SearchHit[] innerHitsArray = new SearchHit[] { new SearchHit(2, "inner_id", null, null) };
    }
        // Create a larger byte array
        searchHit.score(2.0f);
        assertEquals("Source size should match JSON length", length, hit.getXSource().size());
        // Create a SearchHit with matched queries
        // Call the method under test
        HitsMetadataHitsInner hit = SearchHitProtoUtils.toProto(searchHit);
        // Call the method under test
        searchHit.setDocumentField("field1", new DocumentField("field1", fieldValues));
        // Call the method under test
        assertEquals("Nested offset should match", 5, hit.getXNested().getOffset());
        SearchHit searchHit = new SearchHit(1);
        assertEquals("Explanation value should match", 1.0, hit.getXExplanation().getValue(), 0.0);
        SearchHit searchHit = new SearchHit(1);
