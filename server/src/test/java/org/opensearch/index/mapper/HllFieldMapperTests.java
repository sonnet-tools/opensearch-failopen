            tempRight.close();
        // Create a sketch with precision 12
                merged.merge(0, sketch, 0);
        for (int precision : precisions) {
            }
                    );
    }
    }
                }
        // Test that copy_to is supported (inherited from ParametrizedFieldMapper.Builder)
            // Merge the two sketches
            assertEquals("Merge should be associative", leftCardinality, rightCardinality);
            for (int i = 0; i < numValues; i++) {
            wrongPrecisionSketch.collect(0, 1L);
            b.field("type", "hll");
        }));
        // Test that HLL++ field uses the same format as cardinality aggregation
            );
            }));
            for (int i = 0; i < cardinality; i++) {
public class HllFieldMapperTests extends MapperTestCase {
        int precision = 11;
                    BytesRef storedValue = doc.rootDoc().getBinaryValue("field");
                            );
        // Test that when no precision is specified, the default is used
        // Test that merge(merge(A, B), C) produces the same cardinality as merge(A, merge(B, C))
            sketch.writeTo(0, out);
        }
        for (int precision : precisions) {
        try {
        // The error gets wrapped, so check for the generic parse failure message
        assertThat(mapper, instanceOf(HllFieldMapper.class));
                single.collect(0, hash);
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        // Create a simple HLL++ sketch with default precision
                    // Store the sketch in a document
            tempLeft.merge(0, sketchA, 0);
        HyperLogLogPlusPlus sketch1 = new HyperLogLogPlusPlus(precision1, BigArrays.NON_RECYCLING_INSTANCE, 1);
                mergedAB.close();
                }
        }
                                    + ", cardinality="
        // This is verified by the testDerivedSourceSupport test which checks:
            b.field("type", "hll");
import org.opensearch.search.aggregations.metrics.HyperLogLogPlusPlus;
                new BytesArray(storedBytes.bytes, storedBytes.offset, storedBytes.length).streamInput(),
            b.field("type", "hll");
        }));
        // Test that precision cannot be changed even with a more realistic scenario
    public void testIndexParameterRejected() {
                } finally {
            long mergedCardinality = merged.cardinality(0);
        } finally {
                                deserializedCardinality
            long singleCardinality = single.cardinality(0);
                    long originalCardinality = originalSketch.cardinality(0);
                sketch.collect(0, BitMixer.mix64(i));
            BytesRef storedBytes = doc.rootDoc().getBinaryValue("field");
        // Create mapper service
        int[] cardinalities = { 0, 1, 10, 100, 1000, 10000 }; // Test various cardinalities
        }));
            }
                    sketchB.collect(0, hash);
                        BigArrays.NON_RECYCLING_INSTANCE
                                    + " exceeds bound "
            assertEquals(
    }
            }
                            new org.opensearch.core.common.bytes.BytesArray(storedBytes).streamInput(),
        // then verifying the merged result matches the single sketch
                    } finally {
        MapperService mapperService = createMapperService(fieldMapping(b -> { b.field("type", "hll"); }));
        }));
    }
            sketch.close();
            }
        // Test that custom precision values are respected
                            // For larger cardinalities, allow for HLL++ error
import static org.hamcrest.Matchers.equalTo;
            sketch.collect(0, 1L);
            // Store in HLL field
            b.field("type", "hll");
            sketchB.close();
            // Merge all sketches
            tempLeft.close();
                sketches[i] = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            HyperLogLogPlusPlus mergedBA = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        // Test that setting store=true is rejected
    }
            ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));
    }
        })));
            b.startObject("field1").field("type", "hll").field("copy_to", "field2").endObject();
            BytesStreamOutput out = new BytesStreamOutput();
/*
                HyperLogLogPlusPlus originalSketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        // Test that changing precision after field creation is rejected
    }
        }
                    // Verify the retrieved sketch is valid and has the correct cardinality
                b.field("type", "hll");
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
import org.opensearch.core.common.bytes.BytesArray;
                    assertNotNull(doc);
        // This enables storage optimization when _source is disabled
            sketch.collect(0, 1L);
}
            byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
    public void testTermQueryNotSupported() throws IOException {
            sketch.collect(0, 2L);
        }));
        int precision = 12;
        // Attempt to change precision should fail
        })));
            long mergedCardinality = merged.cardinality(0);
        }
            merged.close();
        } finally {
        }
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> sketch1.merge(0, sketch2, 0));
            leftAssoc.merge(0, sketchC, 0);
            BytesStreamOutput out = new BytesStreamOutput();
                long retrievedCardinality = retrievedSketch.cardinality(0);
        // This verifies that HLL fields can be reconstructed from doc values when _source is disabled
    public void testDefaultPrecision() throws Exception {
            MapperService mapperService = createMapperService(fieldMapping(b -> {
    public void testInvalidSketchRejection() throws IOException {
            try {
            for (int cardinality : cardinalities) {
            // Verify DocValueFormat is BINARY (for base64 encoding in synthetic source)
 * compatible open source license.
                    ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));
    }
        );
            containsString("precision must be between " + AbstractHyperLogLog.MIN_PRECISION + " and " + AbstractHyperLogLog.MAX_PRECISION)
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            b.field("type", "hll");
                                relativeError <= errorBound * 3 // Allow 3x error bound for safety
    }
    public void testStoreParameterRejected() {
                    // Serialize the sketch
        } finally {
                retrievedSketch.close();
    public void testExistsQuery() throws IOException {
        MapperService mapperService = createMapperService(fieldMapping(b -> {
    public void testStoreFalseIsAccepted() throws IOException {
        // Test that explicitly setting store=false is accepted (it's the default)
    public void testDefaultMapping() throws Exception {
        // Test that merging sketches with different precision is rejected
            for (int i = 25; i < 75; i++) {
            assertThat(e.getMessage(), containsString(String.valueOf(precision2)));
        // 2. Sketches can be reconstructed from doc values
        }));
                    for (int i = 0; i < cardinality; i++) {
    public void testMergeAccuracy() {
            for (int i = 0; i < numValues; i++) {
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        }
            b.field("doc_values", true);
        HllFieldMapper hllMapper = (HllFieldMapper) mapper;
        assertThat(mapper, instanceOf(HllFieldMapper.class));
                        b.field("type", "hll");
        assertThat(hllMapper.fieldType().precision(), equalTo(HyperLogLogPlusPlus.DEFAULT_PRECISION));
        try {
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
    public void testCopyToIsSupported() throws IOException {
            // Merged cardinality should equal single sketch cardinality
    }
        int[] precisions = { 4, 8, 11, 14, 18 }; // Test various precisions
        int precision = 11;
            // Add different values to each sketch
    }
        assertThat(mapper, instanceOf(HllFieldMapper.class));
                    BytesStreamOutput out = new BytesStreamOutput();
                    originalSketch.writeTo(0, out);
                            double errorBound = 1.04 / Math.sqrt(1 << precision);
                b.field("type", "hll");
            }));
        // Test that explicitly setting index=false is accepted (it's the default)
            sketch1.close();
    public void testDocValuesCannotBeDisabled() {
        assertThat(mapper, instanceOf(HllFieldMapper.class));
                sketchA.close();
        HyperLogLogPlusPlus merged = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                    org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus deserializedSketch =
        // The valueFetcher implementation creates a DocValueFetcher with BINARY format
        // We test this by collecting the same values into a single sketch and into two separate sketches,
                        org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus.readFrom(
        assertExistsQuery(mapperService);
        } finally {
        int precision2 = 14;
        assertThat(mapper, instanceOf(HllFieldMapper.class));
            assertThat(e.getMessage(), containsString("Cannot merge HLL++ sketches with different precision"));
    }
            tempLeft.merge(0, sketchB, 0);
                    BytesRef bytesRef = out.bytes().toBytesRef();
        // Test that HLL fields support derived source
        } finally {
            }
    }
        byte[] invalidData = new byte[] { 1, 2, 3, 4, 5 };
            sketch.close();
        int[] precisions = { 4, 8, 11, 14, 18 };
        assertThat(mapper, instanceOf(HllFieldMapper.class));
                b.field("precision", precision);
        HllFieldMapper mapper = (HllFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
        })));
                b.field("precision", 14);
            // Initialize all sketches
                try {
    }
        // but we can verify the docValueFormat is BINARY which is what enables synthetic source
                b.field("precision", precision);
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
            e.getMessage(),
        HyperLogLogPlusPlus merged = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            long originalCardinality = cardinalitySketch.cardinality(0);
            merged.close();
        }));
                            assertEquals(
        HyperLogLogPlusPlus wrongPrecisionSketch = new HyperLogLogPlusPlus(14, BigArrays.NON_RECYCLING_INSTANCE, 1);
            b.field("doc_values", false);
            sketch2.collect(0, 2L);
                        originalSketch.collect(0, i);
        // Test 2: Sketch with wrong precision
        try {
            b.field("type", "hll");
        int numValues = 1000;
                // Create and populate a sketch
        // Test that merge(A, B) produces the same cardinality as merge(B, A)
        // 1. Doc values are stored
            long leftCardinality = leftAssoc.cardinality(0);
                long originalCardinality = sketch.cardinality(0);
                    assertNotNull(doc.rootDoc().getBinaryValue("field"));
        }
                        b.field("precision", precision);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> fieldType.termQuery("value", null));
                        retrievedSketch.close();
        int numValues = 1000;
                mergedBA.close();
            // Now try to change precision - should fail
                }
            cardinalitySketch.writeTo(0, out);
 * The OpenSearch Contributors require contributions made to
        // Sketches serialized by cardinality aggregation should be readable by HLL field and vice versa
    public void testIndexFalseIsAccepted() throws IOException {
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus;
import java.util.Arrays;
                BigArrays.NON_RECYCLING_INSTANCE
            // Serialize the sketch
                    for (int i = 0; i < cardinality; i++) {
                    // Verify the document was created successfully
                }
            BytesRef bytesRef = out.bytes().toBytesRef();
                    try {
    public void testDerivedSourceSupport() throws IOException {
                    // Verify the sketch can be retrieved
        }
        int cardinality = 500;
                b.field("type", "hll");
        // 3. DocValueFormat is BINARY
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLog;
            // Retrieve and deserialize
                        assertEquals(
                BigArrays.NON_RECYCLING_INSTANCE
                            originalCardinality,
            b.field("precision", precision);
                    sketchA.collect(0, hash);
                            "Cardinality should be preserved for precision=" + precision + ", cardinality=" + cardinality,
            b.field("precision", 14);
                BINARY,
            ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));
            single.close();
        // This is a property-based test simulated with multiple random sketches
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            // Collect same values into single sketch and distribute across multiple sketches
                    // Deserialize and verify cardinality is preserved
                mergedAB.merge(0, sketchB, 0);
        // Test that precision values outside [4, 18] are rejected
                            retrievedCardinality
        HyperLogLogPlusPlus rightAssoc = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        HyperLogLogPlusPlus sketchC = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        // Test 1: Completely invalid binary data
            HyperLogLogPlusPlus mergedAB = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            b.field("precision", 11);
        } finally {
    public void testDocValuesTrueIsAccepted() throws IOException {
            );
                long cardinalityBA = mergedBA.cardinality(0);
                long hash = BitMixer.mix64(i);
                        }
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
                    // Create a mapper with the same precision
                    } finally {
        HyperLogLogPlusPlus single = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
    }
                    ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));
                    BytesStreamOutput out = new BytesStreamOutput();
            );
                mergedBA.merge(0, sketchB, 0);
                    byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
                    }
        // Test that ValueFetcher returns a DocValueFetcher (for synthetic source support)
        assertThat(
                        originalSketch.collect(0, i);
        // We can't easily test the full end-to-end fetching without complex mocking,
            }
import org.opensearch.core.xcontent.XContentBuilder;
            // Merged cardinality should equal single sketch cardinality
        // Test that setting index=true is rejected
                try {
                        );
        MapperService mapperService = createMapperService(mapping(b -> {
                sketches[i % numSketches].collect(0, hash);
            sketch.collect(0, 3L);
        HyperLogLogPlusPlus single = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
    @Override
            AbstractHyperLogLogPlusPlus retrievedSketch = AbstractHyperLogLogPlusPlus.readFrom(
            }
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            }
                    originalSketch.writeTo(0, out);
        }));
        // Test that setting doc_values=false is rejected
                    // Serialize the sketch
        try {
import java.io.IOException;
                    sketchA.collect(0, i);
            assertEquals("Merged cardinality should equal single sketch cardinality", singleCardinality, mergedCardinality);
            rightAssoc.merge(0, tempRight, 0);
            wrongPrecisionSketch.writeTo(0, out);
                fieldType.docValueFormat(null, null)
                        long deserializedCardinality = deserializedSketch.cardinality(0);
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            // Serialize using cardinality aggregation format
        // Verify initial precision
                                    + errorBound
        }));
                HyperLogLogPlusPlus originalSketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            }));
        assertTrue(e1.getMessage().contains("failed to parse") || e1.getCause() != null);
        // where the field already has data
        HllFieldMapper hllMapper = (HllFieldMapper) mapper;
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
                mergedBA.merge(0, sketchA, 0);
            for (HyperLogLogPlusPlus sketch : sketches) {
 *
            long rightCardinality = rightAssoc.cardinality(0);
                                "Relative error "
    public void testIncompatiblePrecisionHandling() {
                                "Cardinality mismatch for precision=" + precision + ", cardinality=" + cardinality,
        assertThat(hllMapper.fieldType().precision(), equalTo(HyperLogLogPlusPlus.DEFAULT_PRECISION));
                                    + relativeError
            sketch.close();
        })));
        );
import org.opensearch.common.io.stream.BytesStreamOutput;
        int precision1 = 8;
                mergedAB.merge(0, sketchA, 0);
        HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        assertThat(e.getMessage(), containsString("Cannot set [index] on field of type [hll]"));
        assertThat(e.getMessage(), containsString("Term queries are not supported on [hll] fields"));
package org.opensearch.index.mapper;
            sketch.writeTo(0, out);
            containsString("precision must be between " + AbstractHyperLogLog.MIN_PRECISION + " and " + AbstractHyperLogLog.MAX_PRECISION)
            HyperLogLogPlusPlus sketchB = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                        long originalCardinality = originalSketch.cardinality(0);
        }
                if (i < numValues / 2) {
        // Verify that valueFetcher uses DocValueFetcher (for synthetic source support)
            b.field("type", "hll");
                // Add different values to each sketch
                        assertEquals("Precision should match", precision, retrievedSketch.precision());
        MapperService mapperService = createMapperService(fieldMapping(b -> {
                                    + " for precision="
                // Merge in both orders
        })));
            } finally {
            // Verify the sketch can be reconstructed from doc values
        MappedFieldType fieldType = mapperService.fieldType("field");
        assertThat(e.getMessage(), containsString("Cannot disable [doc_values] on field of type [hll]"));
                        long retrievedCardinality = retrievedSketch.cardinality(0);
                assertEquals("Merge should be commutative for precision=" + precision, cardinalityAB, cardinalityBA);
            b.field("precision", 12);
            BytesStreamOutput out = new BytesStreamOutput();
import org.apache.lucene.util.BytesRef;
        HyperLogLogPlusPlus tempRight = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
            sketch.collect(0, 2L);
        checker.registerConflictCheck("precision", b -> b.field("precision", 12));
            leftAssoc.close();
                    sketchB.collect(0, i);
                sketchB.collect(0, i);
            sketchA.close();
            MapperParsingException e2 = expectThrows(
            // Right associative: merge(A, merge(B, C))
        int[] precisions = { 8, 11, 14 };
            }
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            for (int i = 50; i < 100; i++) {
            builder.value(Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length));
            for (HyperLogLogPlusPlus sketch : sketches) {
    }
                        } else {
            tempRight.merge(0, sketchB, 0);
    public void testPrecisionCannotBeChanged() throws IOException {
                if (sketch != null) sketch.close();
    }
                            BigArrays.NON_RECYCLING_INSTANCE
            b.field("precision", 11);
        }
            BytesRef bytesRef = out.bytes().toBytesRef();
        int numSketches = 5;
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field1");
            () -> mapperService.documentMapper().parse(source(b -> b.field("field", invalidData)))
                cardinalitySketch.collect(0, i);
            BytesRef bytesRef = out.bytes().toBytesRef();
                // Distribute values across sketches
        HyperLogLogPlusPlus sketchB = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            assertThat(e.getMessage(), containsString(String.valueOf(precision1)));
            try {
            })));
        // Create an HLL++ sketch
    public void testMergeProducesUnionCardinality() {
            byte[] wrongPrecisionData = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
            b.field("index", true);
            } finally {
            BytesStreamOutput out = new BytesStreamOutput();
            b.field("type", "hll");
        HyperLogLogPlusPlus sketch2 = new HyperLogLogPlusPlus(precision2, BigArrays.NON_RECYCLING_INSTANCE, 1);
        // Test that merging multiple sketches maintains HLL++ accuracy guarantees
                    assertNotNull("Document should be created", doc);
        );
                b.field("precision", precision);
            String fullMessage = e2.getMessage() + (e2.getCause() != null ? e2.getCause().getMessage() : "");
        int customPrecision = 14;
        int[] cardinalities = { 0, 5, 50, 500, 5000 };
            b.field("type", "hll");
        b.field("type", "hll");
            for (int i = 0; i < numSketches; i++) {
            MapperService mapperService = createMapperService(fieldMapping(b -> {
                    // Add values to reach the target cardinality
                } else {
            rightAssoc.close();
                b.field("type", "hll");
            }
                long hash = BitMixer.mix64(i);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, fieldMapping(b -> {
        int precision = 11;
            }
            b.field("type", "hll");
                MapperParsingException.class,
            b.field("type", "hll");
            }
        try {
            // Split values between sketchA and sketchB
            rightAssoc.merge(0, sketchA, 0);
            AbstractHyperLogLogPlusPlus retrievedSketch = AbstractHyperLogLogPlusPlus.readFrom(
        HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(12, BigArrays.NON_RECYCLING_INSTANCE, 1);
    public void testSerializationFormatCompatibility() throws IOException {
        })));
                    }
    public void testPrecisionParameterValidation() {
                    BytesRef bytesRef = out.bytes().toBytesRef();
            assertThat(e.getMessage(), containsString("Mapper for [field] conflicts with existing mapper"));
        try {
                    byte[] storedBytes = doc.rootDoc().getBinaryValue("field").bytes;
        HyperLogLogPlusPlus sketchA = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
    }
import org.opensearch.common.util.BigArrays;
        HyperLogLogPlusPlus tempLeft = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
            } finally {
        int cardinality = 100;
        try {
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, fieldMapping(b -> {
            MapperParsingException.class,
        try {
        assertThat(mapper.fieldType().precision(), equalTo(11));
                long cardinalityAB = mergedAB.cardinality(0);
    }
            // Left associative: merge(merge(A, B), C)
        MapperParsingException e1 = expectThrows(
        } finally {
            // Add some values to the sketch
                        new BytesArray(storedValue.bytes, storedValue.offset, storedValue.length).streamInput(),
        try {
        // Create a sketch using the cardinality aggregation code
            // Verify doc values are stored
                                    + cardinality,
            // Store in HLL field
        assertThat(e.getMessage(), containsString("Mapper for [field] conflicts with existing mapper"));
                assertEquals("Cardinality should be preserved across serialization formats", originalCardinality, retrievedCardinality);
    }
            for (int cardinality : cardinalities) {
                for (int i = 50; i < 150; i++) {
        HyperLogLogPlusPlus sketchB = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            // Index a document with the sketch
                sketchA.collect(0, i);
            sketch1.collect(0, 1L);
                    try {
        assertThat(mapper, instanceOf(HllFieldMapper.class));
            assertEquals("Merged cardinality should equal single sketch cardinality", singleCardinality, mergedCardinality);
    public void testMergeIsCommutative() {
                            assertTrue(
                sketchC.collect(0, i);
        }
            sketch.writeTo(0, out);
            assertThat(fullMessage, containsString("precision mismatch"));
    @Override
        e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
            tempRight.merge(0, sketchC, 0);
            ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));
    public void testStoredSketchRetrieval() throws IOException {
    }
                            double relativeError = Math.abs(deserializedCardinality - originalCardinality) / (double) cardinality;
        int precision = 11;
            single.close();
            MapperService mapperService = createMapperService(fieldMapping(b -> {
            assertNotNull(doc);
        HyperLogLogPlusPlus[] sketches = new HyperLogLogPlusPlus[numSketches];
                    // Parse a document with the serialized sketch
                    byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
        HllFieldMapper.HllFieldType fieldType = (HllFieldMapper.HllFieldType) mapperService.fieldType("field");
                        // Cardinality should be preserved (within HLL++ error bounds)
            // Check the cause for the precision mismatch message
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
                        deserializedSketch.close();
import org.opensearch.common.util.BitMixer;
                                originalCardinality,
    }
            BytesRef bytesRef = out.bytes().toBytesRef();
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            merged.merge(0, sketchB, 0);
                retrievedSketch.close();
            b.field("store", true);
            HllFieldMapper.HllFieldType fieldType = (HllFieldMapper.HllFieldType) mapperService.fieldType("field");
    }
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            for (int i = 0; i < cardinality; i++) {
    protected void minimalMapping(XContentBuilder b) throws IOException {
    }
        assertThat(hllMapper.fieldType().precision(), equalTo(customPrecision));
                }
            b.field("type", "hll");
            leftAssoc.merge(0, tempLeft, 0);
            }
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
        HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(HyperLogLogPlusPlus.DEFAULT_PRECISION, BigArrays.NON_RECYCLING_INSTANCE, 1);
    }
                new BytesArray(storedBytes.bytes, storedBytes.offset, storedBytes.length).streamInput(),
        // Get the field type
        assertThat(e.getMessage(), containsString("Cannot set [store] on field of type [hll]"));
 */
            for (int i = 0; i < 50; i++) {
        assertThat(
            BytesRef bytesRef = out.bytes().toBytesRef();
        HyperLogLogPlusPlus sketchA = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            // Collect all values into single sketch
    public void testValueFetcherWithDocValues() throws IOException {
        HllFieldMapper hllMapper = (HllFieldMapper) mapper;
    }
            b.field("precision", customPrecision);
            byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
            wrongPrecisionSketch.close();
                    AbstractHyperLogLogPlusPlus retrievedSketch = AbstractHyperLogLogPlusPlus.readFrom(
            assertNotNull("Doc values should be stored", storedBytes);
            try {
            BytesRef storedBytes = doc.rootDoc().getBinaryValue("field");
            sketchC.close();
                for (int i = 0; i < 100; i++) {
                } finally {
            b.field("type", "hll");
            sketchA.close();
            );
import static org.hamcrest.Matchers.instanceOf;
        HyperLogLogPlusPlus leftAssoc = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
    protected void registerParameters(ParameterChecker checker) throws IOException {
        for (int precision : precisions) {
                    originalSketch.close();
        } finally {
                () -> mapperService.documentMapper().parse(source(b -> b.field("field", wrongPrecisionData)))
            HyperLogLogPlusPlus sketchA = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            sketch2.close();
import static org.opensearch.search.DocValueFormat.BINARY;
                long retrievedCardinality = retrievedSketch.cardinality(0);
    @Override
                // Create a sketch with the given precision
        int precision = 14;
            b.field("index", false);
                    }
                    }));
            b.field("precision", 19);
    public void testPrecisionChangeRejectedWithExistingData() throws IOException {
            e.getMessage(),
        // Test that merging two sketches produces a sketch representing their union
                sketchB.close();
    }
            BytesStreamOutput out = new BytesStreamOutput();
    public void testMergeIsAssociative() {
                    assertNotNull("Sketch should be stored", storedValue);
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
                    originalSketch.close();
            }
        // Test that explicitly setting doc_values=true is accepted (it's the default)
                    MapperService mapperService = createMapperService(fieldMapping(b -> {
    public void testCustomPrecision() throws Exception {
                        // For small cardinalities, they should be exact
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            merged.merge(0, sketchA, 0);
        } finally {
            b.field("precision", 3);
                    }
                        if (cardinality <= 100) {
            long singleCardinality = single.cardinality(0);
    }
                assertEquals("Precision should match", precision, retrievedSketch.precision());
            // Serialize the sketch
                        );
 * this file be licensed under the Apache-2.0 license or a
        // Test that serializing and deserializing HLL++ sketches preserves cardinality
    public void testSerializationRoundTrip() throws IOException {
import static org.hamcrest.Matchers.containsString;
        }
    }
                "HLL fields should use BINARY doc value format for synthetic source",
        assertEquals("HLL fields should use BINARY doc value format for synthetic source", BINARY, fieldType.docValueFormat(null, null));
            b.startObject("field2").field("type", "hll").endObject();
            b.field("type", "hll");
            cardinalitySketch.close();
            }
            sketchB.close();
            b.field("store", false);
                                    + precision
                single.collect(0, hash);
                            );
            // Cardinality should be the same regardless of grouping
                // Cardinality should be the same regardless of merge order
        // Similar to testMergeProducesUnionCardinality but with more sketches
                assertEquals("Cardinality should be preserved", originalCardinality, retrievedCardinality);
        HyperLogLogPlusPlus cardinalitySketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
