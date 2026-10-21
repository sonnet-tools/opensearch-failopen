                "version-1 metadata must end with the checksum map followed only by the codec footer",
     */
    @Before
    public void setUp() throws Exception {
                codecWrapper().writeStream(indexOutput, metadata);
     * footer, and nothing else. A field added within this version can no longer be misread as the map (the marker
        Map<String, String> generationToChecksumMapper = Map.of(
     * @param metadata the TranslogTransferMetadata instance to be converted to a byte array
        assertEquals(legacy, actual);
            assertEquals(
            String.valueOf(1234),
            );
     * An entry whose key is not a generation inside this metadata's own range [min, max] that the primary-term map
            TranslogTransferMetadata.CURRENT_VERSION,
            Map<String, String> expectedChecksums = expected.getGenerationToChecksumMapper() == null
     * @return the byte array representation of the TranslogTransferMetadata
     * The trailing map is inferred from the remaining byte count, so what is read is validated before it is trusted.
import org.apache.lucene.codecs.CodecUtil;
    public void testCodecWrapperRoundTripPreservesChecksumMap() throws IOException {
        // Arbitrary bytes where the marker would be, as an unrelated field appended to version 1 would leave them.
        );
            indexOutput.writeLong(legacy.getGeneration());
                indexInput.length() - indexInput.getFilePointer()
    }
            );
        Map<String, String> checksums = Map.of("300", "1234", "400", "5678");
        TranslogTransferMetadata base = getTestMetadata();
 * The OpenSearch Contributors require contributions made to
                codecWrapper().writeStream(indexOutput, expected);
     * would be missing), but it would silently disable the checksum map on new readers. If this test fails, the
        TranslogTransferMetadata actual = codecWrapper().readStream(
        assertEquals(TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER, indexInput.readInt());
     */
 *
            indexInput.readMapOfStrings();
            indexOutput.writeMapOfStrings(base.getGenerationToPrimaryTermMapper());
    }
        assertEquals(base.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
        verifyWriteContent(getTestMetadata());
        }
    }
    }
            String.valueOf(400),
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
    }
    }
            assertEquals(metadata.getGenerationToChecksumMapper() == null ? Map.of() : metadata.getGenerationToChecksumMapper(), trailing);
                TranslogTransferMetadata.CURRENT_VERSION,
            new TranslogTransferMetadataHandlerFactory(),
                new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes()))
            }
    }
        BytesStreamOutput output = new BytesStreamOutput();
            new ByteArrayIndexInput("metadata file", writeThroughCodec(base, wrongMarker, checksums, new byte[0]))
            indexOutput.writeMapOfStrings(checksums);
     * Verifies the writeContent method of the TranslogTransferMetadataHandler by writing the provided
            Map<String, String> trailing = indexInput.readMapOfStrings();
        return writeThroughCodec(base, TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER, checksums, extra);
        Map<String, String> nonNumericKey = Map.of("300", "1234", "abc", "5678");
            indexOutput.writeLong(base.getMinTranslogGeneration());
        }
                new ByteArrayIndexInput("metadata file", writeThroughCodec(base, implausible, new byte[0]))
import org.opensearch.core.common.bytes.BytesReference;
            indexOutput.writeLong(metadata.getPrimaryTerm());
        // Verification: Compare actual metadata read from the source input stream.
import org.apache.lucene.store.IndexInput;
        Map<String, String> primaryTerms = new HashMap<>(base.getGenerationToPrimaryTermMapper());
            indexOutput.writeLong(metadata.getGeneration());
        TranslogTransferMetadata actualMetadata = handler.readContent(indexInput);
        int count = generationToPrimaryTermMapper.size();
            CodecUtil.writeHeader(indexOutput, TranslogTransferMetadata.METADATA_CODEC, TranslogTransferMetadata.CURRENT_VERSION);
     * Writes {@code base} through the codec wrapper's header/footer with {@code checksums} appended as the trailing
    }
            indexOutput.writeLong(base.getMinTranslogGeneration());
            CodecUtil.writeFooter(indexOutput);
    private void verifyWriteContent(TranslogTransferMetadata expectedMetadata) throws IOException {
            indexOutput.writeLong(base.getGeneration());
    }
        long generation = indexInput.readLong();
        for (Map<String, String> implausible : List.of(unknownGeneration, nonNumericKey, nonNumericChecksum)) {
        assertEquals(Map.of("300", "1234", "400", "5678"), accepted.getGenerationToChecksumMapper());
        for (TranslogTransferMetadata metadata : List.of(getTestMetadata(), getTestMetadataWithGenerationToChecksumMap())) {
        metadata.setGenerationToChecksumMapper(generationToChecksumMapper);
     */
        // The same entries with valid keys inside the range are accepted, so the rejections above are about content.
            new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes()))
            TranslogTransferMetadata.METADATA_CODEC
        primaryTerms.put("200", "1");
     */
        inconsistent.setGenerationToPrimaryTermMapper(primaryTerms);
            assertEquals(base.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
            BytesStreamOutput output = new BytesStreamOutput();
            IndexInput indexInput = new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes()));
        TranslogTransferMetadata actual = codecWrapper().readStream(
    }
 * this file be licensed under the Apache-2.0 license or a
                indexOutput.writeInt(TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER);
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
                ? Map.of()
        return BytesReference.toBytes(output.bytes());
        }
        // Verification: Compare actual metadata written to the target output stream.
            String.valueOf(4567)
 * SPDX-License-Identifier: Apache-2.0
    }
            try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
        );
            CodecUtil.writeHeader(indexOutput, TranslogTransferMetadata.METADATA_CODEC, TranslogTransferMetadata.CURRENT_VERSION);
            );
        );
import java.util.Map;
            indexOutput.writeLong(base.getPrimaryTerm());
        assertEquals(expectedMetadata, actualMetadata);
    /**
     */
                TranslogTransferMetadata.METADATA_CODEC,
            indexOutput.writeLong(metadata.getMinTranslogGeneration());
            CodecUtil.writeFooter(indexOutput);
            // A legacy writer stops here; anything a current writer adds must be exactly the marked checksum map.
     */
     * from the provided IndexInput.
     *
        metadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);
        try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
        // Operation: Read expected metadata from source input stream.
    /**
        // Fixture range is [300, 500] with primary-term entries for 300, 400 and 500.
        return metadata;
package org.opensearch.index.translog.transfer;
        IndexInput indexInput = new ByteArrayIndexInput("metadata file", getTestMetadataBytes(expectedMetadata));
        }
    private static VersionedCodecStreamWrapper<TranslogTransferMetadata> codecWrapper() {
            String.valueOf(300),
        }
        // A well-formed map with a wrong marker in front of it.
     * Anything after the checksum map other than the codec footer violates the last-field invariant; the map is
        );
            assertEquals(TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER, indexInput.readInt());
        // Operation: Write expected metadata to the target output stream.
            BytesStreamOutput output = new BytesStreamOutput();
     * Full round trip through the versioned codec wrapper, with and without checksum entries, must preserve both maps.
    /**
        TranslogTransferMetadata metadata = getTestMetadata();
        long minTranslogGeneration = 300;
}
        );
            indexInput.readLong();
     * TranslogTransferMetadata to the OutputStreamIndexOutput.
        generationToPrimaryTermMapper.put("300", "1");
        assertEquals(base.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
        try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
 * compatible open source license.
        handler.writeContent(actualMetadataStream, expectedMetadata);
     * Tests the writeContent method of the TranslogTransferMetadataHandler, which writes the provided
import org.junit.Before;
            CodecUtil.checkHeader(
     * the primary term, generation, minimum translog generation, generation-to-primary term mapping, and
import org.opensearch.common.io.VersionedCodecStreamWrapper;
            assertEquals(expected, actual);
     * generation-to-checksum mapping (if available).
     * Metadata written by a node that predates the generation-to-checksum map ends with the primary-term map,
    /**
    public void testVersionOneLayoutEndsWithTheChecksumMap() throws IOException {
    /**
    /**
            assertEquals(expected.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
        assertEquals(expectedMetadata, actualMetadata);
            TranslogTransferMetadata.CURRENT_VERSION,
            indexOutput.writeLong(base.getPrimaryTerm());
        );
        return BytesReference.toBytes(output.bytes());
    /**
     * @throws IOException if there is an error reading the metadata from the IndexInput
        OutputStreamIndexOutput actualMetadataStream = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096);
    }
     * change needs a CURRENT_VERSION bump with a reader-first rollout, not a fix to the test.
        assertEquals(expectedMetadata, actualMetadata);
     */
        // metadata's own statement of what it covers, and the maps must agree with it.
            indexOutput.writeMapOfStrings(base.getGenerationToPrimaryTermMapper());
import java.io.IOException;
            assertEquals(expectedChecksums, actual.getGenerationToChecksumMapper());
     *
        super.setUp();
                : expected.getGenerationToChecksumMapper();
        );
        TranslogTransferMetadata actual = codecWrapper().readStream(
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
            try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
    public void testReadContentForMetadataWithgenerationToChecksumMap() throws IOException {
        assertEquals(300, base.getMinTranslogGeneration());
            indexInput.readLong();
     * to the original metadata.
        Map<String, String> generationToChecksumMapper = indexInput.readMapOfStrings();
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
        TranslogTransferMetadata actualMetadata = new TranslogTransferMetadata(primaryTerm, generation, minTranslogGeneration, count);
            TranslogTransferMetadata actual = codecWrapper().readStream(
        TranslogTransferMetadata legacy = getTestMetadata();
        try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
        assertEquals(500, base.getGeneration());
            indexOutput.writeInt(marker);
        TranslogTransferMetadata expectedMetadata = getTestMetadata();
/*
    private static byte[] writeThroughCodec(TranslogTransferMetadata base, Map<String, String> checksums, byte[] extra) throws IOException {
        // A key the primary-term map lists but that lies outside [min, max] is rejected too: the range is the
     * @param expectedMetadata the expected TranslogTransferMetadata to be written and verified
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
        assertEquals(base.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
            indexOutput.writeMapOfStrings(legacy.getGenerationToPrimaryTermMapper());
    }
        int count = generationToPrimaryTermMapper.size();
            indexInput.readLong();
     * @throws IOException if there is an error writing the metadata to the OutputStreamIndexOutput
        TranslogTransferMetadata metadata = new TranslogTransferMetadata(primaryTerm, generation, minTranslogGeneration, count);
            indexOutput.writeBytes(extra, extra.length);
import java.util.HashMap;
     * primary-term map and the rest of the metadata are unaffected.
                indexInput,
    /**
     * Tests the readContent method of the TranslogTransferMetadataHandler, which reads the TranslogTransferMetadata
            );
    }
     * @throws IOException if there is an error reading the metadata from the IndexInput
     *
        TranslogTransferMetadata base = getTestMetadata();
    /**
        long primaryTerm = indexInput.readLong();
     * followed only by the codec footer. Read through the same versioned wrapper the transfer manager uses, it
     * that includes the generation-to-checksum map from the provided IndexInput.
        BytesStreamOutput output = new BytesStreamOutput();
        // Operation: Read expected metadata from source input stream.
     * Tests the readContent method of the TranslogTransferMetadataHandler, which reads the TranslogTransferMetadata
        Map<String, String> unknownGeneration = Map.of("300", "1234", "999", "5678");
     */
     *
        }
        long generation = 500;
     *
    private TranslogTransferMetadataHandler handler;
        return new VersionedCodecStreamWrapper<>(
     */
     */
        actualMetadata.setGenerationToChecksumMapper(generationToChecksumMapper);
     * @throws IOException if there is an error writing or reading the metadata
     */
    public void testReadContent() throws IOException {
        }
        TranslogTransferMetadata base = getTestMetadata();
    /**
        long primaryTerm = 3;
    }
    }
     * also knows, or whose value is not a checksum, means the bytes were not written as a checksum map; the map is
import org.opensearch.test.OpenSearchTestCase;
     * Tests the writeContent method of the TranslogTransferMetadataHandler, which writes the provided
        // Verification: Compare actual metadata read from the source input stream.
            TranslogTransferMetadata actual = codecWrapper().readStream(
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
        try (OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096)) {
        int wrongMarker = randomValueOtherThan(TranslogTransferMetadataHandler.CHECKSUM_MAP_MARKER, OpenSearchTestCase::randomInt);
                TranslogTransferMetadata.CURRENT_VERSION
        TranslogTransferMetadata actualMetadata = handler.readContent(indexInput);
            CodecUtil.writeHeader(indexOutput, TranslogTransferMetadata.METADATA_CODEC, TranslogTransferMetadata.CURRENT_VERSION);
            indexOutput.writeLong(base.getGeneration());
        BytesStreamOutput output = new BytesStreamOutput();
            new ByteArrayIndexInput("metadata file", writeThroughCodec(base, checksums, randomByteArrayOfLength(randomIntBetween(1, 64))))
    /**
            }
                indexOutput.writeMapOfStrings(metadata.getGenerationToChecksumMapper());
     * dropped rather than assumed to be complete or correct.
     */
        Map<String, String> nonNumericChecksum = Map.of("300", "1234", "400", "not-a-checksum");
     * @throws IOException if there is an error writing the metadata to the byte array
        long minTranslogGeneration = indexInput.readLong();
     * Pins the version-1 layout: header, three longs, primary-term map, checksum-map marker, checksum map, codec
    public void testImplausibleTrailingMapIsDroppedRatherThanTrusted() throws IOException {
        TranslogTransferMetadata expectedMetadata = getTestMetadataWithGenerationToChecksumMap();
        assertEquals(Map.of(), actual.getGenerationToChecksumMapper());
 */
    }
public class TranslogTransferMetadataHandlerTests extends OpenSearchTestCase {
    public void testTrailingBytesAfterChecksumMapDropTheMap() throws IOException {
     * @throws IOException if there is an error writing the metadata to the OutputStreamIndexOutput
import org.apache.lucene.store.OutputStreamIndexOutput;
            new ByteArrayIndexInput("metadata file", writeThroughCodec(inconsistent, Map.of("200", "1234", "300", "5678"), new byte[0]))
                CodecUtil.footerLength(),
     * The marker, not the byte count, announces the checksum map. Trailing bytes that do not start with it - a
    /**
            indexOutput.writeBytes(unrelated, unrelated.length);
        return metadata;
    /**
        Map<String, String> checksums = Map.of("300", "1234", "400", "5678");
            byte[] unrelated = randomByteArrayOfLength(randomIntBetween(1, 64));
        actual = codecWrapper().readStream(new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes())));
        TranslogTransferMetadata actual = codecWrapper().readStream(
    }
            new ByteArrayIndexInput("metadata file", writeThroughCodec(base, Map.of("300", "1234", "400", "5678"), new byte[0]))
            indexOutput.writeMapOfStrings(metadata.getGenerationToPrimaryTermMapper());
    public void testTrailingBytesWithoutMarkerAreNotReadAsChecksumMap() throws IOException {
        IndexInput indexInput = new ByteArrayIndexInput("metadata file", BytesReference.toBytes(output.bytes()));
        TranslogTransferMetadata accepted = codecWrapper().readStream(
     * TranslogTransferMetadata that includes the generation-to-checksum map to the OutputStreamIndexOutput.
        Map<String, String> generationToPrimaryTermMapper = new HashMap<>();
        Map<String, String> generationToPrimaryTermMapper = indexInput.readMapOfStrings();
        generationToPrimaryTermMapper.put("500", "3");
     * field someone appended to version 1, or a corrupted marker - are ignored and the map is dropped; the
    private TranslogTransferMetadata getTestMetadata() {
    private static byte[] writeThroughCodec(TranslogTransferMetadata base, int marker, Map<String, String> checksums, byte[] extra)
import java.util.List;
     * dropped and every generation is downloaded, rather than the metadata being misread.
        throws IOException {
     * map (announced by the real marker) and {@code extra} bytes placed between that map and the footer.
        handler = new TranslogTransferMetadataHandler();
            CodecUtil.writeFooter(indexOutput);
        BytesStreamOutput output = new BytesStreamOutput();
        assertEquals(legacy.getGenerationToPrimaryTermMapper(), actual.getGenerationToPrimaryTermMapper());
        generationToPrimaryTermMapper.put("400", "2");
        actualMetadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);
    private TranslogTransferMetadata getTestMetadataWithGenerationToChecksumMap() {
     *
        verifyWriteContent(getTestMetadataWithGenerationToChecksumMap());
     * TranslogTransferMetadata to an OutputStreamIndexOutput, and then reading it back and comparing it
        actualMetadataStream.close();
    private byte[] getTestMetadataBytes(TranslogTransferMetadata metadata) throws IOException {
    public void testWriteContentWithGeneratonToChecksumMap() throws IOException {
        for (TranslogTransferMetadata expected : List.of(getTestMetadata(), getTestMetadataWithGenerationToChecksumMap())) {
     * must yield an empty checksum map rather than misinterpreting the footer bytes.
        TranslogTransferMetadata inconsistent = new TranslogTransferMetadata(3, 500, 300, 4);
    public void testReadLegacyMetadataThroughCodecWrapperYieldsEmptyChecksumMap() throws IOException {
            indexOutput.writeLong(legacy.getPrimaryTerm());
        BytesStreamOutput output = new BytesStreamOutput();
            if (metadata.getGenerationToChecksumMapper() != null) {
     * Creates a byte array representation of the provided TranslogTransferMetadata instance, which includes
        IndexInput indexInput = new ByteArrayIndexInput("metadata file", getTestMetadataBytes(expectedMetadata));
            indexOutput.writeLong(legacy.getMinTranslogGeneration());
     */
            }
    public void testWriteContent() throws IOException {
