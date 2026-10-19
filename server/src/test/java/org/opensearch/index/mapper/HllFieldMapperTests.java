        // Test that setting index=true is rejected
        HllFieldMapper hllMapper = (HllFieldMapper) mapper;
import org.opensearch.common.io.stream.BytesStreamOutput;
            long mergedCardinality = merged.cardinality(0);
            for (int i = 0; i < numValues; i++) {  
        HllFieldMapper mapper = (HllFieldMapper) mapperService.documentMapper().mappers().getMapper("field");
    }  
        // Verify initial precision  
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus;
                                deserializedCardinality  
            b.field("precision", 14);
        // Test 1: Completely invalid binary data
                mergedAB.merge(0, sketchB, 0);
        // Sketches serialized by cardinality aggregation should be readable by HLL field and vice versa  
    }  
        } finally {
            containsString("precision must be between " + AbstractHyperLogLog.MIN_PRECISION + " and " + AbstractHyperLogLog.MAX_PRECISION)  
            b.field("precision", 11);
                    originalSketch.writeTo(0, out);
        // The error gets wrapped, so check for the generic parse failure message
        // Verify that valueFetcher uses DocValueFetcher (for synthetic source support)  
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> fieldType.termQuery("value", null));
                BigArrays.NON_RECYCLING_INSTANCE
        }
                    } finally {  
        byte[] invalidData = new byte[] { 1, 2, 3, 4, 5 };
        // where the field already has data  
    public void testDefaultMapping() throws Exception {  
            long leftCardinality = leftAssoc.cardinality(0);
        // Test that custom precision values are respected  
                        originalSketch.collect(0, i);
            BytesRef bytesRef = out.bytes().toBytesRef();
            HllFieldMapper.HllFieldType fieldType = (HllFieldMapper.HllFieldType) mapperService.fieldType("field");
import org.opensearch.core.xcontent.XContentBuilder;  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {  
                b.field("type", "hll");
            sketchB.close();
        // We can't easily test the full end-to-end fetching without complex mocking,
 */  
        }
                try {
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {  
                mergedBA.merge(0, sketchB, 0);  
            AbstractHyperLogLogPlusPlus retrievedSketch = AbstractHyperLogLogPlusPlus.readFrom(
                    assertNotNull(doc);
    public void testMergeIsCommutative() {  
                                originalCardinality,
            // Collect same values into single sketch and distribute across multiple sketches  
                assertEquals("Precision should match", precision, retrievedSketch.precision());
        HyperLogLogPlusPlus wrongPrecisionSketch = new HyperLogLogPlusPlus(14, BigArrays.NON_RECYCLING_INSTANCE, 1);
        }));
import org.opensearch.common.util.BigArrays;  
                // Cardinality should be the same regardless of merge order  
                        b.field("precision", precision);  
            sketchA.close();  
        }));  
import org.opensearch.search.aggregations.metrics.HyperLogLogPlusPlus;  
        HyperLogLogPlusPlus tempRight = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                sketchB.close();
            } finally {
            tempLeft.merge(0, sketchB, 0);
                    );
            sketch2.close();  
        assertThat(mapper.fieldType().precision(), equalTo(11));
        // Test that setting doc_values=false is rejected
    @Override
        // Create an HLL++ sketch
                    for (int i = 0; i < cardinality; i++) {  
            BytesStreamOutput out = new BytesStreamOutput();  
                    try {  
                MapperParsingException.class,
                    // Store the sketch in a document
        int cardinality = 100;  
            }
            BytesRef storedBytes = doc.rootDoc().getBinaryValue("field");
            for (int cardinality : cardinalities) {  
                b.field("type", "hll");
            for (int cardinality : cardinalities) {
    }  
            sketch2.collect(0, 2L);  
            b.field("type", "hll");
import java.io.IOException;
                // Merge in both orders
                b.field("precision", precision);  
            BytesRef bytesRef = out.bytes().toBytesRef();  
        assertThat(mapper, instanceOf(HllFieldMapper.class));  
            b.field("store", false);  
        // Similar to testMergeProducesUnionCardinality but with more sketches
            BytesRef bytesRef = out.bytes().toBytesRef();
import org.opensearch.core.common.bytes.BytesArray;
                mergedAB.merge(0, sketchA, 0);  
            }
            byte[] wrongPrecisionData = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
                    try {
            byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);  
                "HLL fields should use BINARY doc value format for synthetic source",  
        // Test that serializing and deserializing HLL++ sketches preserves cardinality  
    }
                b.field("precision", 14);
            }
        }
            }
        HyperLogLogPlusPlus single = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            // Left associative: merge(merge(A, B), C)  
        }));
    public void testMergeIsAssociative() {
        HyperLogLogPlusPlus[] sketches = new HyperLogLogPlusPlus[numSketches];  
            assertNotNull("Doc values should be stored", storedBytes);
            b.field("type", "hll");
    }
        } finally {
            }));
                mergedBA.merge(0, sketchA, 0);
        }
    }  
            wrongPrecisionSketch.collect(0, 1L);
                    byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
                    MapperService mapperService = createMapperService(fieldMapping(b -> {
            BytesStreamOutput out = new BytesStreamOutput();
                // Distribute values across sketches
        int precision = 11;
        for (int precision : precisions) {  
            ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));
                sketches[i % numSketches].collect(0, hash);
import org.opensearch.common.util.BitMixer;
                    originalSketch.writeTo(0, out);
        })));
                fieldType.docValueFormat(null, null)
        assertThat(e.getMessage(), containsString("Cannot set [index] on field of type [hll]"));
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        int[] precisions = { 4, 8, 11, 14, 18 };  
                sketchA.close();  
                    // Create a mapper with the same precision  
            }
            sketchA.close();  
import org.opensearch.search.aggregations.metrics.AbstractHyperLogLog;
        HyperLogLogPlusPlus cardinalitySketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
        assertThat(hllMapper.fieldType().precision(), equalTo(HyperLogLogPlusPlus.DEFAULT_PRECISION));  
            MapperService mapperService = createMapperService(fieldMapping(b -> {
        // Get the field type  
                    // Parse a document with the serialized sketch  
                    assertNotNull("Sketch should be stored", storedValue);
            b.field("store", true);
            b.field("type", "hll");  
        int[] precisions = { 4, 8, 11, 14, 18 }; // Test various precisions  
    }
                () -> mapperService.documentMapper().parse(source(b -> b.field("field", wrongPrecisionData)))  
        // 1. Doc values are stored
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
                        new BytesArray(storedValue.bytes, storedValue.offset, storedValue.length).streamInput(),  
    }
            b.field("type", "hll");  
            // Add different values to each sketch
                long retrievedCardinality = retrievedSketch.cardinality(0);  
        try {  
            // Index a document with the sketch  
        HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(HyperLogLogPlusPlus.DEFAULT_PRECISION, BigArrays.NON_RECYCLING_INSTANCE, 1);  
    }
        int precision = 12;
            b.field("type", "hll");
            tempLeft.close();
        int precision = 11;
            e.getMessage(),
        }
        })));  
            }
        }  
                    AbstractHyperLogLogPlusPlus retrievedSketch = AbstractHyperLogLogPlusPlus.readFrom(
                long originalCardinality = sketch.cardinality(0);
            merged.merge(0, sketchA, 0);
                sketchA.collect(0, i);  
                    sketchB.collect(0, hash);  
            assertThat(e.getMessage(), containsString("Mapper for [field] conflicts with existing mapper"));
        try {  
                    BytesRef bytesRef = out.bytes().toBytesRef();  
        int precision2 = 14;
                        BigArrays.NON_RECYCLING_INSTANCE
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        // This is verified by the testDerivedSourceSupport test which checks:  
                        long retrievedCardinality = retrievedSketch.cardinality(0);  
        try {  
        // Test that HLL fields support derived source
        // 2. Sketches can be reconstructed from doc values
                                    + " exceeds bound "  
        assertThat(
                            );
    public void testDefaultPrecision() throws Exception {
            // Collect all values into single sketch
                }  
    public void testValueFetcherWithDocValues() throws IOException {  
    protected void registerParameters(ParameterChecker checker) throws IOException {
            long singleCardinality = single.cardinality(0);  
        MapperService mapperService = createMapperService(fieldMapping(b -> {  
        HyperLogLogPlusPlus rightAssoc = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                } finally {  
                for (int i = 50; i < 150; i++) {
            assertThat(e.getMessage(), containsString(String.valueOf(precision1)));
            }));  
        int precision = 14;
        // Test that merge(merge(A, B), C) produces the same cardinality as merge(A, merge(B, C))  
        // Test that copy_to is supported (inherited from ParametrizedFieldMapper.Builder)
            // Serialize using cardinality aggregation format
            );  
            b.startObject("field1").field("type", "hll").field("copy_to", "field2").endObject();
            assertEquals("Merge should be associative", leftCardinality, rightCardinality);
                    // Verify the retrieved sketch is valid and has the correct cardinality
        int[] precisions = { 8, 11, 14 };  
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> sketch1.merge(0, sketch2, 0));
        // Test that merge(A, B) produces the same cardinality as merge(B, A)
                long hash = BitMixer.mix64(i);
            // Merge the two sketches
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
        for (int precision : precisions) {  
        try {
                            );
        // The valueFetcher implementation creates a DocValueFetcher with BINARY format
    public void testMergeAccuracy() {  
        HyperLogLogPlusPlus sketchC = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
    }
    }
    }
                                relativeError <= errorBound * 3 // Allow 3x error bound for safety  
        HyperLogLogPlusPlus sketch2 = new HyperLogLogPlusPlus(precision2, BigArrays.NON_RECYCLING_INSTANCE, 1);
    public void testInvalidSketchRejection() throws IOException {
                        assertEquals(
                mergedBA.close();  
    }
        HyperLogLogPlusPlus leftAssoc = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
        int numValues = 1000;  
        try {
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
            single.close();
        assertThat(mapper, instanceOf(HllFieldMapper.class));
            for (HyperLogLogPlusPlus sketch : sketches) {
        })));  
                } else {
                if (i < numValues / 2) {  
                // Create and populate a sketch
            containsString("precision must be between " + AbstractHyperLogLog.MIN_PRECISION + " and " + AbstractHyperLogLog.MAX_PRECISION)  
                                "Cardinality mismatch for precision=" + precision + ", cardinality=" + cardinality,
            sketch.writeTo(0, out);
            wrongPrecisionSketch.close();  
                        retrievedSketch.close();
        // Test that merging sketches with different precision is rejected
                            assertEquals(  
            // Store in HLL field  
        }
        // Test that precision values outside [4, 18] are rejected
        // This is a property-based test simulated with multiple random sketches
            b.field("type", "hll");  
                // Create a sketch with the given precision
            );
        // Test that merging multiple sketches maintains HLL++ accuracy guarantees
                                    + cardinality,
            b.field("type", "hll");
            }));
                }  
        MapperService mapperService = createMapperService(fieldMapping(b -> {
    }
                        // For small cardinalities, they should be exact
            cardinalitySketch.close();  
                }  
                HyperLogLogPlusPlus originalSketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
        }));
            b.field("type", "hll");
                    // Verify the sketch can be retrieved
                for (int i = 0; i < 100; i++) {
        try {
                                "Relative error "
            b.field("precision", 11);  
            b.startObject("field2").field("type", "hll").endObject();
        MapperService mapperService = createMapperService(fieldMapping(b -> {
                        long deserializedCardinality = deserializedSketch.cardinality(0);
            );
                } finally {
            assertThat(e.getMessage(), containsString(String.valueOf(precision2)));  
            }  
                            new org.opensearch.core.common.bytes.BytesArray(storedBytes).streamInput(),
            b.field("doc_values", true);
                HyperLogLogPlusPlus originalSketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            BytesStreamOutput out = new BytesStreamOutput();
            // Split values between sketchA and sketchB
    public void testDocValuesTrueIsAccepted() throws IOException {  
        })));  
        int precision1 = 8;
            for (HyperLogLogPlusPlus sketch : sketches) {  
            long mergedCardinality = merged.cardinality(0);  
            rightAssoc.merge(0, sketchA, 0);  
            builder.value(Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length));
            BytesStreamOutput out = new BytesStreamOutput();
                            originalCardinality,
            // Retrieve and deserialize
            String fullMessage = e2.getMessage() + (e2.getCause() != null ? e2.getCause().getMessage() : "");  
            AbstractHyperLogLogPlusPlus retrievedSketch = AbstractHyperLogLogPlusPlus.readFrom(  
        }  
            } finally {
        // This enables storage optimization when _source is disabled  
                    }  
 * SPDX-License-Identifier: Apache-2.0
            b.field("index", false);
        }));
            e.getMessage(),
            sketch.writeTo(0, out);
            for (int i = 0; i < 50; i++) {
        }));  
                    }
        // Create a sketch with precision 12
        assertExistsQuery(mapperService);
        int numSketches = 5;
        HyperLogLogPlusPlus sketchB = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
            ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));
        MappedFieldType fieldType = mapperService.fieldType("field");  
        }
        // Test that HLL++ field uses the same format as cardinality aggregation
                    BytesStreamOutput out = new BytesStreamOutput();
        HyperLogLogPlusPlus sketchA = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
    }
                        b.field("type", "hll");
            BytesRef bytesRef = out.bytes().toBytesRef();  
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            b.field("type", "hll");
            MapperService mapperService = createMapperService(fieldMapping(b -> {  
    }  
        }
        assertThat(hllMapper.fieldType().precision(), equalTo(customPrecision));
                long retrievedCardinality = retrievedSketch.cardinality(0);  
            sketch.close();
            b.field("type", "hll");  
        );  
    public void testSerializationRoundTrip() throws IOException {
            b.field("type", "hll");
        HyperLogLogPlusPlus tempLeft = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
                    // Verify the document was created successfully  
                    byte[] storedBytes = doc.rootDoc().getBinaryValue("field").bytes;
        MapperService mapperService = createMapperService(fieldMapping(b -> { b.field("type", "hll"); }));  
            // Merged cardinality should equal single sketch cardinality
    @Override  
        // Test that explicitly setting index=false is accepted (it's the default)
                        deserializedSketch.close();
        assertThat(e.getMessage(), containsString("Term queries are not supported on [hll] fields"));  
            b.field("type", "hll");
    }  
    public void testSerializationFormatCompatibility() throws IOException {
        // Create a sketch using the cardinality aggregation code
        assertThat(mapper, instanceOf(HllFieldMapper.class));
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");  
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
                                    + ", cardinality="
        HllFieldMapper hllMapper = (HllFieldMapper) mapper;  
                        // Cardinality should be preserved (within HLL++ error bounds)  
        } finally {
            for (int i = 0; i < cardinality; i++) {
            assertEquals("Merged cardinality should equal single sketch cardinality", singleCardinality, mergedCardinality);
        // Test that merging two sketches produces a sketch representing their union  
                sketchC.collect(0, i);  
    }  
            long rightCardinality = rightAssoc.cardinality(0);
                BINARY,
                    byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);  
                        );
            MapperService mapperService = createMapperService(fieldMapping(b -> {
        }));
 * The OpenSearch Contributors require contributions made to  
    }
                sketches[i] = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
            tempRight.merge(0, sketchB, 0);
    }
        HllFieldMapper hllMapper = (HllFieldMapper) mapper;
            HyperLogLogPlusPlus sketchA = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
                single.collect(0, hash);  
            assertEquals(
                    assertNotNull(doc.rootDoc().getBinaryValue("field"));
        // We test this by collecting the same values into a single sketch and into two separate sketches,
            for (int i = 0; i < numSketches; i++) {
        assertThat(e.getMessage(), containsString("Cannot set [store] on field of type [hll]"));
        MapperService mapperService = createMapperService(mapping(b -> {  
        HllFieldMapper.HllFieldType fieldType = (HllFieldMapper.HllFieldType) mapperService.fieldType("field");
        // Create mapper service  
            sketch.close();
                    // Serialize the sketch
            assertEquals("Merged cardinality should equal single sketch cardinality", singleCardinality, mergedCardinality);  
        MapperService mapperService = createMapperService(fieldMapping(b -> {
        // Test that setting store=true is rejected
import static org.hamcrest.Matchers.instanceOf;
            tempRight.close();  
        try {  
            b.field("type", "hll");  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {  
        assertThat(e.getMessage(), containsString("Mapper for [field] conflicts with existing mapper"));
            sketch1.collect(0, 1L);
            // Now try to change precision - should fail
            // Verify doc values are stored
            }  
        HyperLogLogPlusPlus merged = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                                    + errorBound
                                    + precision  
            assertThat(fullMessage, containsString("precision mismatch"));
                        org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus.readFrom(
                            double relativeError = Math.abs(deserializedCardinality - originalCardinality) / (double) cardinality;
    public void testDerivedSourceSupport() throws IOException {
                    sketchB.collect(0, i);
                sketchB.collect(0, i);  
                    originalSketch.close();
        );
            }
                    BytesRef storedValue = doc.rootDoc().getBinaryValue("field");
                mergedAB.close();
                b.field("type", "hll");  
            // Add some values to the sketch
        assertThat(mapper, instanceOf(HllFieldMapper.class));
        assertThat(
        // 3. DocValueFormat is BINARY  
            for (int i = 25; i < 75; i++) {
        );
        HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(12, BigArrays.NON_RECYCLING_INSTANCE, 1);
        } finally {
            HyperLogLogPlusPlus mergedBA = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
                new BytesArray(storedBytes.bytes, storedBytes.offset, storedBytes.length).streamInput(),
        // Test that changing precision after field creation is rejected  
        try {  
        // then verifying the merged result matches the single sketch
            try {  
            BytesRef bytesRef = out.bytes().toBytesRef();
            sketch.collect(0, 1L);
            sketch.collect(0, 1L);  
        int numValues = 1000;
            long singleCardinality = single.cardinality(0);
        // Test that ValueFetcher returns a DocValueFetcher (for synthetic source support)
            b.field("precision", customPrecision);
    public void testIndexParameterRejected() {
            }
                    assertNotNull("Document should be created", doc);  
                b.field("precision", precision);  
            b.field("precision", 12);
        } finally {
        })));  
                b.field("type", "hll");
                        originalSketch.collect(0, i);
                        }
            BytesRef storedBytes = doc.rootDoc().getBinaryValue("field");  
        int customPrecision = 14;
            try {
        // Attempt to change precision should fail
                new BytesArray(storedBytes.bytes, storedBytes.offset, storedBytes.length).streamInput(),
    }
                            retrievedCardinality
            })));
        int precision = 11;
                retrievedSketch.close();  
                    sketchA.collect(0, hash);
import static org.hamcrest.Matchers.equalTo;
    public void testExistsQuery() throws IOException {  
        // This verifies that HLL fields can be reconstructed from doc values when _source is disabled
                // Add different values to each sketch  
                        long originalCardinality = originalSketch.cardinality(0);
            leftAssoc.merge(0, sketchC, 0);
    }
        HyperLogLogPlusPlus sketch1 = new HyperLogLogPlusPlus(precision1, BigArrays.NON_RECYCLING_INSTANCE, 1);
                    ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));
        for (int precision : precisions) {
            // Store in HLL field
    }
                    } finally {
            sketch1.close();
            tempRight.merge(0, sketchC, 0);
import org.apache.lucene.util.BytesRef;
        assertThat(e.getMessage(), containsString("Cannot disable [doc_values] on field of type [hll]"));
                            // For larger cardinalities, allow for HLL++ error  
                merged.merge(0, sketch, 0);
            // Check the cause for the precision mismatch message
            // Initialize all sketches
            leftAssoc.close();  
        assertThat(mapper, instanceOf(HllFieldMapper.class));  
                long hash = BitMixer.mix64(i);
            // Right associative: merge(A, merge(B, C))  
import static org.hamcrest.Matchers.containsString;  
    }
        assertTrue(e1.getMessage().contains("failed to parse") || e1.getCause() != null);
 * this file be licensed under the Apache-2.0 license or a
                BigArrays.NON_RECYCLING_INSTANCE  
        e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {  
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
                cardinalitySketch.collect(0, i);  
        HyperLogLogPlusPlus merged = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                            BigArrays.NON_RECYCLING_INSTANCE  
                                    + " for precision="
                    // Serialize the sketch  
        b.field("type", "hll");
            try {
            ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));  
    public void testStoredSketchRetrieval() throws IOException {
            HyperLogLogPlusPlus mergedAB = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        // Test 2: Sketch with wrong precision
    }
import java.util.Arrays;  
        // Create a simple HLL++ sketch with default precision
            merged.close();
}
            // Serialize the sketch
                assertEquals("Cardinality should be preserved", originalCardinality, retrievedCardinality);
            sketch.collect(0, 2L);
    public void testIncompatiblePrecisionHandling() {
                    long originalCardinality = originalSketch.cardinality(0);
    public void testStoreParameterRejected() {
    }
            long originalCardinality = cardinalitySketch.cardinality(0);  
        } finally {  
        // Test that explicitly setting doc_values=true is accepted (it's the default)
                        assertEquals("Precision should match", precision, retrievedSketch.precision());
            // Verify the sketch can be reconstructed from doc values  
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            cardinalitySketch.writeTo(0, out);
            assertNotNull(doc);
        assertThat(mapper, instanceOf(HllFieldMapper.class));
                    ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", serialized)));  
                sketch.collect(0, BitMixer.mix64(i));  
                assertEquals("Cardinality should be preserved across serialization formats", originalCardinality, retrievedCardinality);
                                    + relativeError
                }
    }
            }
                retrievedSketch.close();  
        assertThat(hllMapper.fieldType().precision(), equalTo(HyperLogLogPlusPlus.DEFAULT_PRECISION));
            // Serialize the sketch  
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
package org.opensearch.index.mapper;
            // Cardinality should be the same regardless of grouping  
    @Override
            single.close();
        assertEquals("HLL fields should use BINARY doc value format for synthetic source", BINARY, fieldType.docValueFormat(null, null));  
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field");
            );  
        // but we can verify the docValueFormat is BINARY which is what enables synthetic source
            rightAssoc.merge(0, tempRight, 0);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, fieldMapping(b -> {
            }
        int cardinality = 500;  
    public void testStoreFalseIsAccepted() throws IOException {
        } finally {
            b.field("precision", precision);  
    public void testPrecisionChangeRejectedWithExistingData() throws IOException {
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {  
                assertEquals("Merge should be commutative for precision=" + precision, cardinalityAB, cardinalityBA);
import static org.opensearch.search.DocValueFormat.BINARY;
        MapperParsingException e1 = expectThrows(  
                    sketchA.collect(0, i);
                single.collect(0, hash);
            byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
    public void testMergeProducesUnionCardinality() {
            byte[] serialized = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
                long cardinalityBA = mergedBA.cardinality(0);
                    }
        HyperLogLogPlusPlus sketchB = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                    // Add values to reach the target cardinality
        }  
            tempLeft.merge(0, sketchA, 0);
            merged.merge(0, sketchB, 0);  
            wrongPrecisionSketch.writeTo(0, out);  
        // Test that explicitly setting store=false is accepted (it's the default)  
    protected void minimalMapping(XContentBuilder b) throws IOException {  
        } finally {
        FieldMapper mapper = (FieldMapper) mapperService.documentMapper().mappers().getMapper("field1");
                if (sketch != null) sketch.close();  
                }
            }
    public void testDocValuesCannotBeDisabled() {
        }
                            "Cardinality should be preserved for precision=" + precision + ", cardinality=" + cardinality,  
 *
/*  
            }
    }
            // Verify DocValueFormat is BINARY (for base64 encoding in synthetic source)  
        } finally {  
        // Test that precision cannot be changed even with a more realistic scenario
        int[] cardinalities = { 0, 5, 50, 500, 5000 };
            // Merged cardinality should equal single sketch cardinality
            MapperParsingException.class,
 * compatible open source license.
        int precision = 11;
                            double errorBound = 1.04 / Math.sqrt(1 << precision);
    public void testPrecisionParameterValidation() {  
            BytesStreamOutput out = new BytesStreamOutput();
                    BytesStreamOutput out = new BytesStreamOutput();  
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> merge(mapperService, fieldMapping(b -> {
        }));
            // Merge all sketches
            b.field("index", true);
        // Test that when no precision is specified, the default is used
            () -> mapperService.documentMapper().parse(source(b -> b.field("field", invalidData)))
            }
                    // Deserialize and verify cardinality is preserved
    public void testIndexFalseIsAccepted() throws IOException {
            sketch.collect(0, 3L);
            merged.close();
            b.field("type", "hll");
        assertThat(mapper, instanceOf(HllFieldMapper.class));
        int[] cardinalities = { 0, 1, 10, 100, 1000, 10000 }; // Test various cardinalities
                        if (cardinality <= 100) {
    public void testCopyToIsSupported() throws IOException {
        HyperLogLogPlusPlus single = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                        );  
                    org.opensearch.search.aggregations.metrics.AbstractHyperLogLogPlusPlus deserializedSketch =  
            sketchB.close();
            rightAssoc.close();
                            assertTrue(  
            b.field("doc_values", false);
                long cardinalityAB = mergedAB.cardinality(0);
    }
public class HllFieldMapperTests extends MapperTestCase {
                    originalSketch.close();
                        } else {
        })));  
            leftAssoc.merge(0, tempLeft, 0);  
        checker.registerConflictCheck("precision", b -> b.field("precision", 12));  
                    }  
            sketch.close();  
            sketch.collect(0, 2L);
                    for (int i = 0; i < cardinality; i++) {
    public void testPrecisionCannotBeChanged() throws IOException {
                try {  
    public void testTermQueryNotSupported() throws IOException {
    public void testCustomPrecision() throws Exception {
        HyperLogLogPlusPlus sketchA = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            b.field("precision", 3);
        }));
            for (int i = 50; i < 100; i++) {
                    BytesRef bytesRef = out.bytes().toBytesRef();
            sketch.writeTo(0, out);  
            MapperParsingException e2 = expectThrows(
            b.field("precision", 19);
                    }));
        try {
                b.field("precision", precision);
            sketchC.close();
            for (int i = 0; i < numValues; i++) {
            } finally {
            HyperLogLogPlusPlus sketchB = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            assertThat(e.getMessage(), containsString("Cannot merge HLL++ sketches with different precision"));
            for (int i = 0; i < cardinality; i++) {
