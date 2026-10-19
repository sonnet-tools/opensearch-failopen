        );  
        try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
            }  
                TranslogTransferMetadata.CURRENT_VERSION,
    }  
     * from the provided IndexInput.  
        BytesStreamOutput output = new BytesStreamOutput();  
            indexOutput.writeLong(legacy.getPrimaryTerm());
    }
            assertEquals(metadata.getGenerationToChecksumMapper() == null ? Map.of() : metadata.getGenerationToChecksumMapper(), trailing);
    /**
        TranslogTransferMetadata actualMetadata = handler.readContent(indexInput);
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
     */
            indexInput.readMapOfStrings();
        return new VersionedCodecStreamWrapper<>(  
            indexOutput.writeMapOfStrings(checksums);
     * must yield an empty checksum map rather than misinterpreting the footer bytes.
    /**
                codecWrapper().writeStream(indexOutput, expected);  
     * Tests the writeContent method of the TranslogTransferMetadataHandler, which writes the provided
        Map<String, String> generationToChecksumMapper = indexInput.readMapOfStrings();  
    public void testWriteContentWithGeneratonToChecksumMap() throws IOException {  
        BytesStreamOutput output = new BytesStreamOutput();  
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
        try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {  
            CodecUtil.writeHeader(indexOutput, TranslogTransferMetadata.METADATA_CODEC, TranslogTransferMetadata.CURRENT_VERSION);
                "version-1 metadata must end with the checksum map followed only by the codec footer",
            Map<String, String> expectedChecksums = expected.getGenerationToChecksumMapper() == null
        for (Map<String, String> implausible : List.of(unknownGeneration, nonNumericKey, nonNumericChecksum)) {
 * SPDX-License-Identifier: Apache-2.0
     * field someone appended to version 1, or a corrupted marker - are ignored and the map is dropped; the
        Map<String, String> nonNumericKey = Map.of("300", "1234", "abc", "5678");
     * followed only by the codec footer. Read through the same versioned wrapper the transfer manager uses, it  
            String.valueOf(4567)
    }
     */
        throws IOException {
        assertEquals(Map.of("300", "1234", "400", "5678"), accepted.getGenerationToChecksumMapper());
        TranslogTransferMetadata base = getTestMetadata();
        metadata.setGenerationToChecksumMapper(generationToChecksumMapper);
            CodecUtil.writeFooter(indexOutput);
                indexOutput.writeMapOfStrings(metadata.getGenerationToChecksumMapper());
        verifyWriteContent(getTestMetadata());  
            new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes()))
            TranslogTransferMetadata.CURRENT_VERSION,  
        IndexInput indexInput = new ByteArrayIndexInput("metadata file", getTestMetadataBytes(expectedMetadata));
            assertEquals(TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER, indexInput.readInt());  
        assertEquals(300, base.getMinTranslogGeneration());
        Map<String, String> generationToChecksumMapper = Map.of(
    }  
            indexInput.readLong();
        OutputStreamIndexOutput actualMetadataStream = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096);
     */
        super.setUp();  
        assertEquals(expectedMetadata, actualMetadata);
        TranslogTransferMetadata base = getTestMetadata();  
        IndexInput indexInput = new ByteArrayIndexInput("metadata file", getTestMetadataBytes(expectedMetadata));
        return BytesReference.toBytes(output.bytes());  
     */
            );
        metadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);  
 * The OpenSearch Contributors require contributions made to  
            }
    public void testTrailingBytesAfterChecksumMapDropTheMap() throws IOException {
     * primary-term map and the rest of the metadata are unaffected.  
    @Before
            indexOutput.writeBytes(unrelated, unrelated.length);  
     * Metadata written by a node that predates the generation-to-checksum map ends with the primary-term map,
    public void testReadContent() throws IOException {
     */
        TranslogTransferMetadata metadata = getTestMetadata();  
     * map (announced by the real marker) and {@code extra} bytes placed between that map and the footer.
     * the primary term, generation, minimum translog generation, generation-to-primary term mapping, and
    }  
        Map<String, String> primaryTerms = new HashMap<>(base.getGenerationToPrimaryTermMapper());
        // Verification: Compare actual metadata written to the target output stream.
     * Verifies the writeContent method of the TranslogTransferMetadataHandler by writing the provided  
     */
     * Tests the writeContent method of the TranslogTransferMetadataHandler, which writes the provided  
    /**
            String.valueOf(400),
        assertEquals(base.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
        return BytesReference.toBytes(output.bytes());
        }
            indexOutput.writeLong(metadata.getMinTranslogGeneration());
                new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes()))  
            indexOutput.writeMapOfStrings(legacy.getGenerationToPrimaryTermMapper());
            indexOutput.writeMapOfStrings(base.getGenerationToPrimaryTermMapper());
    }
        }
        assertEquals(base.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
        // A well-formed map with a wrong marker in front of it.
     */
        // A key the primary-term map lists but that lies outside [min, max] is rejected too: the range is the
            indexOutput.writeMapOfStrings(base.getGenerationToPrimaryTermMapper());  
                new ByteArrayIndexInput("metadata file", writeThroughCodec(base, implausible, new byte[0]))  
     * Creates a byte array representation of the provided TranslogTransferMetadata instance, which includes  
        assertEquals(TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER, indexInput.readInt());
        TranslogTransferMetadata actual = codecWrapper().readStream(
import org.apache.lucene.store.OutputStreamIndexOutput;  
        verifyWriteContent(getTestMetadataWithGenerationToChecksumMap());
            byte[] unrelated = randomByteArrayOfLength(randomIntBetween(1, 64));
    }  
import org.opensearch.test.OpenSearchTestCase;
    public void testImplausibleTrailingMapIsDroppedRatherThanTrusted() throws IOException {
    }  
import org.opensearch.common.io.VersionedCodecStreamWrapper;
            new TranslogTransferMetadataHandlerFactory(),
     * dropped rather than assumed to be complete or correct.  
                ? Map.of()
    /**  
            Map<String, String> trailing = indexInput.readMapOfStrings();
    public void testCodecWrapperRoundTripPreservesChecksumMap() throws IOException {
    }  
    /**
     * @param expectedMetadata the expected TranslogTransferMetadata to be written and verified
     * The trailing map is inferred from the remaining byte count, so what is read is validated before it is trusted.  
    /**
        long primaryTerm = indexInput.readLong();
/*  
                : expected.getGenerationToChecksumMapper();  
            String.valueOf(300),
        assertEquals(500, base.getGeneration());  
        actualMetadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);  
        return metadata;
        assertEquals(expectedMetadata, actualMetadata);
            indexOutput.writeInt(marker);
            assertEquals(expected.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());  
                codecWrapper().writeStream(indexOutput, metadata);
     * @throws IOException if there is an error writing the metadata to the OutputStreamIndexOutput
        Map<String, String> checksums = Map.of("300", "1234", "400", "5678");
        actualMetadata.setGenerationToChecksumMapper(generationToChecksumMapper);
        BytesStreamOutput output = new BytesStreamOutput();  
     * @throws IOException if there is an error writing the metadata to the OutputStreamIndexOutput  
            indexOutput.writeBytes(extra, extra.length);  
    public void testTrailingBytesWithoutMarkerAreNotReadAsChecksumMap() throws IOException {
    public void testReadContentForMetadataWithgenerationToChecksumMap() throws IOException {  
            indexOutput.writeLong(base.getPrimaryTerm());  
            TranslogTransferMetadata.METADATA_CODEC
        }
            CodecUtil.writeHeader(indexOutput, TranslogTransferMetadata.METADATA_CODEC, TranslogTransferMetadata.CURRENT_VERSION);  
            new ByteArrayIndexInput("metadata file", writeThroughCodec(base, Map.of("300", "1234", "400", "5678"), new byte[0]))
            TranslogTransferMetadata.CURRENT_VERSION,
                TranslogTransferMetadata.CURRENT_VERSION
    public void testReadLegacyMetadataThroughCodecWrapperYieldsEmptyChecksumMap() throws IOException {  
        TranslogTransferMetadata base = getTestMetadata();  
     * @throws IOException if there is an error reading the metadata from the IndexInput
        // Verification: Compare actual metadata read from the source input stream.
            new ByteArrayIndexInput("metadata file", writeThroughCodec(base, wrongMarker, checksums, new byte[0]))
        IndexInput indexInput = new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes()));  
            indexInput.readLong();
    public void setUp() throws Exception {
        generationToPrimaryTermMapper.put("400", "2");
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
 *
            TranslogTransferMetadata actual = codecWrapper().readStream(
     * TranslogTransferMetadata that includes the generation-to-checksum map to the OutputStreamIndexOutput.
     *  
            indexInput.readLong();  
     */
            );
            // A legacy writer stops here; anything a current writer adds must be exactly the marked checksum map.
            CodecUtil.writeFooter(indexOutput);
                indexInput.length() - indexInput.getFilePointer()  
import org.opensearch.core.common.bytes.BytesReference;
        try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
            CodecUtil.writeHeader(indexOutput, TranslogTransferMetadata.METADATA_CODEC, TranslogTransferMetadata.CURRENT_VERSION);
        assertEquals(base.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
            BytesStreamOutput output = new BytesStreamOutput();
     * Writes {@code base} through the codec wrapper's header/footer with {@code checksums} appended as the trailing  
import java.util.Map;
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());  
    }
        TranslogTransferMetadata legacy = getTestMetadata();
    /**  
        }
        );
            TranslogTransferMetadata actual = codecWrapper().readStream(
        TranslogTransferMetadata accepted = codecWrapper().readStream(
        int count = generationToPrimaryTermMapper.size();
     * TranslogTransferMetadata to the OutputStreamIndexOutput.
 * this file be licensed under the Apache-2.0 license or a
    public void testVersionOneLayoutEndsWithTheChecksumMap() throws IOException {  
        Map<String, String> generationToPrimaryTermMapper = new HashMap<>();  
    }  
     */
        Map<String, String> unknownGeneration = Map.of("300", "1234", "999", "5678");
        }
import org.junit.Before;  
     * that includes the generation-to-checksum map from the provided IndexInput.
    }
     * @throws IOException if there is an error writing or reading the metadata
        // Operation: Read expected metadata from source input stream.
 */  
            indexOutput.writeLong(base.getPrimaryTerm());
            IndexInput indexInput = new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes()));  
                indexOutput.writeInt(TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER);
     *  
    /**
    private static VersionedCodecStreamWrapper<TranslogTransferMetadata> codecWrapper() {
    }  
     * @return the byte array representation of the TranslogTransferMetadata
     * also knows, or whose value is not a checksum, means the bytes were not written as a checksum map; the map is
        // Operation: Read expected metadata from source input stream.  
     * @param metadata the TranslogTransferMetadata instance to be converted to a byte array
        actual = codecWrapper().readStream(new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes())));  
        assertEquals(legacy, actual);  
        Map<String, String> nonNumericChecksum = Map.of("300", "1234", "400", "not-a-checksum");  
    }
        handler = new TranslogTransferMetadataHandler();
    private static byte[] writeThroughCodec(TranslogTransferMetadata base, int marker, Map<String, String> checksums, byte[] extra)
     */  
}
            assertEquals(  
    }  
        BytesStreamOutput output = new BytesStreamOutput();
import java.io.IOException;
        // The same entries with valid keys inside the range are accepted, so the rejections above are about content.  
            if (metadata.getGenerationToChecksumMapper() != null) {  
        long generation = 500;
    /**
     * @throws IOException if there is an error writing the metadata to the byte array  
            );
        try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
    /**  
        assertEquals(legacy.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
     * Tests the readContent method of the TranslogTransferMetadataHandler, which reads the TranslogTransferMetadata
            indexOutput.writeLong(base.getGeneration());
        TranslogTransferMetadata actual = codecWrapper().readStream(
        long minTranslogGeneration = indexInput.readLong();  
     * to the original metadata.
     * would be missing), but it would silently disable the checksum map on new readers. If this test fails, the  
     * The marker, not the byte count, announces the checksum map. Trailing bytes that do not start with it - a
    private byte[] getTestMetadataBytes(TranslogTransferMetadata metadata) throws IOException {
import java.util.HashMap;  
            }
            BytesStreamOutput output = new BytesStreamOutput();
     */
import org.opensearch.common.io.stream.BytesStreamOutput;
    private TranslogTransferMetadata getTestMetadataWithGenerationToChecksumMap() {
        // Operation: Write expected metadata to the target output stream.
            );  
        // metadata's own statement of what it covers, and the maps must agree with it.  
            CodecUtil.checkHeader(
        return metadata;
        generationToPrimaryTermMapper.put("300", "1");
        for (TranslogTransferMetadata expected : List.of(getTestMetadata(), getTestMetadataWithGenerationToChecksumMap())) {  
    private void verifyWriteContent(TranslogTransferMetadata expectedMetadata) throws IOException {
     * Pins the version-1 layout: header, three longs, primary-term map, checksum-map marker, checksum map, codec
        // Arbitrary bytes where the marker would be, as an unrelated field appended to version 1 would leave them.  
        Map<String, String> generationToPrimaryTermMapper = indexInput.readMapOfStrings();
        long primaryTerm = 3;  
            indexOutput.writeLong(legacy.getGeneration());  
     *  
        return writeThroughCodec(base, TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER, checksums, extra);
        primaryTerms.put("200", "1");  
            indexOutput.writeLong(base.getMinTranslogGeneration());  
     * dropped and every generation is downloaded, rather than the metadata being misread.  
        TranslogTransferMetadata actualMetadata = new TranslogTransferMetadata(primaryTerm, generation, minTranslogGeneration, count);
                indexInput,
            new ByteArrayIndexInput("metadata file", writeThroughCodec(base, checksums, randomByteArrayOfLength(randomIntBetween(1, 64))))  
    private TranslogTransferMetadataHandler handler;
            assertEquals(base.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
        BytesStreamOutput output = new BytesStreamOutput();
    /**
     *
            try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {  
                TranslogTransferMetadata.METADATA_CODEC,  
        long generation = indexInput.readLong();
     *  
                CodecUtil.footerLength(),
            indexOutput.writeMapOfStrings(metadata.getGenerationToPrimaryTermMapper());
        for (TranslogTransferMetadata metadata : List.of(getTestMetadata(), getTestMetadataWithGenerationToChecksumMap())) {
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
    private static byte[] writeThroughCodec(TranslogTransferMetadata base, Map<String, String> checksums, byte[] extra) throws IOException {  
import org.apache.lucene.store.IndexInput;
        TranslogTransferMetadata expectedMetadata = getTestMetadataWithGenerationToChecksumMap();
        generationToPrimaryTermMapper.put("500", "3");  
     */
     * TranslogTransferMetadata to an OutputStreamIndexOutput, and then reading it back and comparing it
        );  
    private TranslogTransferMetadata getTestMetadata() {
     * generation-to-checksum mapping (if available).
        );  
        // Verification: Compare actual metadata read from the source input stream.
    public void testWriteContent() throws IOException {
    /**  
    }
    /**
    }  
        );
        TranslogTransferMetadata expectedMetadata = getTestMetadata();
        TranslogTransferMetadata actualMetadata = handler.readContent(indexInput);  
        Map<String, String> checksums = Map.of("300", "1234", "400", "5678");
            assertEquals(Map.of(), actual.getGenerationToChecksumMapper());  
            assertEquals(expected, actual);
public class TranslogTransferMetadataHandlerTests extends OpenSearchTestCase {
        );
     * @throws IOException if there is an error reading the metadata from the IndexInput
            String.valueOf(1234),  
        }
        // Fixture range is [300, 500] with primary-term entries for 300, 400 and 500.  
 * compatible open source license.
     * Anything after the checksum map other than the codec footer violates the last-field invariant; the map is
    }
     * Full round trip through the versioned codec wrapper, with and without checksum entries, must preserve both maps.  
        assertEquals(expectedMetadata, actualMetadata);  
        TranslogTransferMetadata actual = codecWrapper().readStream(
            new ByteArrayIndexInput("metadata file", writeThroughCodec(inconsistent, Map.of("200", "1234", "300", "5678"), new byte[0]))  
        handler.writeContent(actualMetadataStream, expectedMetadata);
        TranslogTransferMetadata metadata = new TranslogTransferMetadata(primaryTerm, generation, minTranslogGeneration, count);
     */  
            indexOutput.writeLong(base.getMinTranslogGeneration());
     * Tests the readContent method of the TranslogTransferMetadataHandler, which reads the TranslogTransferMetadata
        actualMetadataStream.close();  
            try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
        TranslogTransferMetadata inconsistent = new TranslogTransferMetadata(3, 500, 300, 4);
import org.apache.lucene.codecs.CodecUtil;
        long minTranslogGeneration = 300;
     * footer, and nothing else. A field added within this version can no longer be misread as the map (the marker
        );
     *
        inconsistent.setGenerationToPrimaryTermMapper(primaryTerms);
            CodecUtil.writeFooter(indexOutput);  
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
            indexOutput.writeLong(base.getGeneration());
        int wrongMarker = randomValueOtherThan(TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER, OpenSearchTestCase::randomInt);  
     * change needs a CURRENT_VERSION bump with a reader-first rollout, not a fix to the test.
package org.opensearch.index.translog.transfer;
            indexOutput.writeLong(metadata.getGeneration());  
            indexOutput.writeLong(legacy.getMinTranslogGeneration());
            indexOutput.writeLong(metadata.getPrimaryTerm());
import java.util.List;
        }
            assertEquals(expectedChecksums, actual.getGenerationToChecksumMapper());
        int count = generationToPrimaryTermMapper.size();
     * An entry whose key is not a generation inside this metadata's own range [min, max] that the primary-term map
        TranslogTransferMetadata actual = codecWrapper().readStream(  
