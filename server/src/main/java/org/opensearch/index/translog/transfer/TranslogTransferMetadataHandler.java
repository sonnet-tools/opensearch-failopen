    }
        if (content.getGenerationToPrimaryTermMapper() != null) {
}
                "ignoring generation-to-checksum map in translog metadata [{}]: [{}] unexpected bytes follow it",
            indexOutput.writeMapOfStrings(new HashMap<>());
        int count = generationToPrimaryTermMapper.size();
        }
        } else {
    public void writeContent(IndexOutput indexOutput, TranslogTransferMetadata content) throws IOException {
 * @opensearch.internal
                    "ignoring generation-to-checksum map in translog metadata [{}]: entry [{}={}] is not a known generation and checksum",
import org.apache.logging.log4j.Logger;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to
        // TranslogTransferMetadataHandlerTests#testVersionOneLayoutEndsWithTheChecksumMap catches.
                indexInput,
     *
                logger.warn(
                "ignoring trailing bytes in translog metadata [{}]: expected checksum map marker [{}] but found [{}]",
                Integer.toHexString(CHECKSUM_MAP_MARKER),
        // The generation-to-checksum map was appended to the version-1 layout after the primary-term map, preceded
    private static final Logger logger = LogManager.getLogger(TranslogTransferMetadataHandler.class);
        throws IOException {
        // therefore cannot be misread as the map; it can only disable the optimisation on new readers, which
        long trailingBytes = indexInput.length() - indexInput.getFilePointer();
        return generationToChecksumMapper;
            );
            logger.warn(
            return Map.of();
 */
            // Written before the checksum map existed.
            Long.parseLong(value);
            logger.warn(
        // Older readers stop after the primary-term map and never look at the extra bytes, which keeps the file
     * Implements logic to read content from file input stream {@code indexInput} and parse into {@link TranslogTransferMetadata}
        }
import org.apache.lucene.store.IndexOutput;
     * Marker written immediately before the generation-to-checksum map. Its presence, not the number of bytes left
    private static boolean isKnownGeneration(
     *
     * @return content parsed to {@link TranslogTransferMetadata}
 * Handler for {@link TranslogTransferMetadata}
    }
                );
    /**
                return Map.of();
                    indexInput,
        TranslogTransferMetadata metadata = new TranslogTransferMetadata(primaryTerm, generation, minTranslogGeneration, count);
        long generation = Long.parseLong(key);
            return true;
        Map<String, String> generationToChecksumMapper = indexInput.readMapOfStrings();
        //
        Map<String, String> generationToPrimaryTermMapper = metadata.getGenerationToPrimaryTermMapper();
                    entry.getKey(),
        // whatever their length. Anything read is still validated before it is trusted (keys are generations inside
                Integer.toHexString(marker)
        }
                trailingBytes - CodecUtil.footerLength()
        if (indexInput.length() - indexInput.getFilePointer() <= CodecUtil.footerLength()) {
     * before the codec footer, is what tells a reader the map is there. Visible for testing.
     */
            if (isKnownGeneration(entry.getKey(), metadata, generationToPrimaryTermMapper) == false || isLong(entry.getValue()) == false) {
        String key,
     */
     * @param content metadata content to be written
            indexOutput.writeMapOfStrings(content.getGenerationToChecksumMapper());
import java.util.HashMap;
     * @param indexOutput file input stream
import org.apache.lucene.store.IndexInput;
            return false;
 * compatible open source license.
    private static Map<String, String> readChecksumMapIfPresent(IndexInput indexInput, TranslogTransferMetadata metadata)
        if (trailingBytes > CodecUtil.footerLength()) {
     * Implements logic to write content from {@code content} to file output stream {@code indexOutput}
        // footer follows). The map only ever lets a download be skipped, so on any doubt it is dropped and every
        }
        // metadata stream wrapper in TranslogTransferManager accepts only [CURRENT_VERSION, CURRENT_VERSION].
        // this metadata's own range that the primary-term map knows, values are checksums, nothing but the codec
        // readable in both directions during a rolling upgrade; a version bump could not offer that, because the
import org.apache.lucene.codecs.CodecUtil;
 *
        if (marker != CHECKSUM_MAP_MARKER) {
    }
     * @param indexInput file input stream
    @Override
        Map<String, String> generationToPrimaryTermMapper
                    entry.getValue()
            indexOutput.writeMapOfStrings(new HashMap<>());
        // by CHECKSUM_MAP_MARKER. Metadata written before that ends right here, followed only by the codec footer.
        }
        indexOutput.writeLong(content.getMinTranslogGeneration());
        }
/*
        metadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);
        long generation = indexInput.readLong();
        indexOutput.writeInt(CHECKSUM_MAP_MARKER);
        indexOutput.writeLong(content.getGeneration());
                indexInput,
import org.opensearch.common.io.IndexIOStreamHandler;
        // The marker makes the map's presence explicit: bytes that do not start with it are not a checksum map,
            return false;
        for (Map.Entry<String, String> entry : generationToChecksumMapper.entrySet()) {
        // The generation-to-checksum map is written last, announced by CHECKSUM_MAP_MARKER so that readers identify
public class TranslogTransferMetadataHandler implements IndexIOStreamHandler<TranslogTransferMetadata> {
        long minTranslogGeneration = indexInput.readLong();
    static final int CHECKSUM_MAP_MARKER = 0x434B534D; // "CKSM"
        }
import java.util.Map;
        try {
    /**
        } catch (NumberFormatException e) {
    public TranslogTransferMetadata readContent(IndexInput indexInput) throws IOException {
        // it explicitly (see readContent). Do not add fields to this version; a new field needs a CURRENT_VERSION
        // generation is downloaded, which is the pre-existing behaviour. A field added to version 1 by mistake
import org.apache.logging.log4j.LogManager;
        }
    }
    @Override
    }
        if (isLong(key) == false || generationToPrimaryTermMapper.containsKey(key) == false) {
    ) {
            indexOutput.writeMapOfStrings(content.getGenerationToPrimaryTermMapper());
        TranslogTransferMetadata metadata,
        long primaryTerm = indexInput.readLong();
            return Map.of();
        indexOutput.writeLong(content.getPrimaryTerm());
        int marker = indexInput.readInt();
        metadata.setGenerationToChecksumMapper(readChecksumMapIfPresent(indexInput, metadata));
        } else {
        return generation >= metadata.getMinTranslogGeneration() && generation <= metadata.getGeneration();
package org.opensearch.index.translog.transfer;
/**
 * this file be licensed under the Apache-2.0 license or a
        if (content.getGenerationToChecksumMapper() != null) {
        Map<String, String> generationToPrimaryTermMapper = indexInput.readMapOfStrings();
            );
 *
            return Map.of();
            }
    private static boolean isLong(String value) {
        // bump with a reader-first rollout.
    /**
 */
        return metadata;
 * SPDX-License-Identifier: Apache-2.0
     */
