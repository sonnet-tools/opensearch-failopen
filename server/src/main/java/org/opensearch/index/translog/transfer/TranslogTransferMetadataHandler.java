     * @param indexOutput file input stream
                return Map.of();
import org.apache.lucene.store.IndexInput;
        // therefore cannot be misread as the map; it can only disable the optimisation on new readers, which
import org.apache.logging.log4j.Logger;
        return generation >= metadata.getMinTranslogGeneration() && generation <= metadata.getGeneration();
                Integer.toHexString(marker)
    private static final Logger logger = LogManager.getLogger(TranslogTransferMetadataHandler.class);
    @Override
        TranslogTransferMetadata metadata = new TranslogTransferMetadata(primaryTerm, generation, minTranslogGeneration, count);
            return Map.of();
    private static boolean isKnownGeneration(
            }
     * Implements logic to write content from {@code content} to file output stream {@code indexOutput}
 * @opensearch.internal  
            // Written before the checksum map existed.
        // by CHECKSUM_MAP_MARKER. Metadata written before that ends right here, followed only by the codec footer.  
        }  
     */  
        long trailingBytes = indexInput.length() - indexInput.getFilePointer();
        long generation = Long.parseLong(key);  
     * Marker written immediately before the generation-to-checksum map. Its presence, not the number of bytes left
        String key,
/*  
        Map<String, String> generationToPrimaryTermMapper = indexInput.readMapOfStrings();
        for (Map.Entry<String, String> entry : generationToChecksumMapper.entrySet()) {
        metadata.setGenerationToPrimaryTermMapper(generationToPrimaryTermMapper);  
     * before the codec footer, is what tells a reader the map is there. Visible for testing.
        } catch (NumberFormatException e) {
 * Handler for {@link TranslogTransferMetadata}
     */  
        // The marker makes the map's presence explicit: bytes that do not start with it are not a checksum map,
        if (trailingBytes > CodecUtil.footerLength()) {
 * this file be licensed under the Apache-2.0 license or a
            );
                    entry.getValue()
        // readable in both directions during a rolling upgrade; a version bump could not offer that, because the
        long minTranslogGeneration = indexInput.readLong();
        int count = generationToPrimaryTermMapper.size();
import org.opensearch.common.io.IndexIOStreamHandler;  
        }
            indexOutput.writeMapOfStrings(new HashMap<>());  
            return true;
        if (content.getGenerationToChecksumMapper() != null) {  
     *  
                indexInput,  
    private static Map<String, String> readChecksumMapIfPresent(IndexInput indexInput, TranslogTransferMetadata metadata)
    /**  
        return generationToChecksumMapper;
        // footer follows). The map only ever lets a download be skipped, so on any doubt it is dropped and every
     * @param indexInput file input stream  
                );  
 * compatible open source license.
    }
        Map<String, String> generationToPrimaryTermMapper
        }
        }
        indexOutput.writeLong(content.getPrimaryTerm());  
        }
    @Override  
            return false;
    private static boolean isLong(String value) {
 *
        } else {
    }
     * Implements logic to read content from file input stream {@code indexInput} and parse into {@link TranslogTransferMetadata}
                indexInput,
 * SPDX-License-Identifier: Apache-2.0
        indexOutput.writeInt(CHECKSUM_MAP_MARKER);
        if (indexInput.length() - indexInput.getFilePointer() <= CodecUtil.footerLength()) {
        if (content.getGenerationToPrimaryTermMapper() != null) {  
            return false;  
import java.io.IOException;
        // Older readers stop after the primary-term map and never look at the extra bytes, which keeps the file
import org.apache.lucene.codecs.CodecUtil;  
    /**  
        }  
                trailingBytes - CodecUtil.footerLength()  
            if (isKnownGeneration(entry.getKey(), metadata, generationToPrimaryTermMapper) == false || isLong(entry.getValue()) == false) {  
 * The OpenSearch Contributors require contributions made to  
    public void writeContent(IndexOutput indexOutput, TranslogTransferMetadata content) throws IOException {
            logger.warn(
        } else {
            logger.warn(  
                Integer.toHexString(CHECKSUM_MAP_MARKER),
        TranslogTransferMetadata metadata,  
/**  
        // whatever their length. Anything read is still validated before it is trusted (keys are generations inside  
        // metadata stream wrapper in TranslogTransferManager accepts only [CURRENT_VERSION, CURRENT_VERSION].  
            return Map.of();  
        //
        // The generation-to-checksum map is written last, announced by CHECKSUM_MAP_MARKER so that readers identify
            indexOutput.writeMapOfStrings(content.getGenerationToPrimaryTermMapper());
        // TranslogTransferMetadataHandlerTests#testVersionOneLayoutEndsWithTheChecksumMap catches.
        }
        Map<String, String> generationToPrimaryTermMapper = metadata.getGenerationToPrimaryTermMapper();
                    entry.getKey(),
        indexOutput.writeLong(content.getMinTranslogGeneration());
        try {
            );  
 */
import java.util.Map;
                    "ignoring generation-to-checksum map in translog metadata [{}]: entry [{}={}] is not a known generation and checksum",
        metadata.setGenerationToChecksumMapper(readChecksumMapIfPresent(indexInput, metadata));  
        Map<String, String> generationToChecksumMapper = indexInput.readMapOfStrings();  
}  
import org.apache.logging.log4j.LogManager;
        int marker = indexInput.readInt();
        // generation is downloaded, which is the pre-existing behaviour. A field added to version 1 by mistake  
 *
        long primaryTerm = indexInput.readLong();
            indexOutput.writeMapOfStrings(content.getGenerationToChecksumMapper());
     */
        if (isLong(key) == false || generationToPrimaryTermMapper.containsKey(key) == false) {  
 */  
            indexOutput.writeMapOfStrings(new HashMap<>());  
public class TranslogTransferMetadataHandler implements IndexIOStreamHandler<TranslogTransferMetadata> {
    }  
                "ignoring trailing bytes in translog metadata [{}]: expected checksum map marker [{}] but found [{}]",
    }
    static final int CHECKSUM_MAP_MARKER = 0x434B534D; // "CKSM"
        long generation = indexInput.readLong();  
        if (marker != CHECKSUM_MAP_MARKER) {  
     *
        // bump with a reader-first rollout.
        return metadata;
        indexOutput.writeLong(content.getGeneration());
            return Map.of();
    }
import org.apache.lucene.store.IndexOutput;
        }
     * @return content parsed to {@link TranslogTransferMetadata}
package org.opensearch.index.translog.transfer;
    ) {
                "ignoring generation-to-checksum map in translog metadata [{}]: [{}] unexpected bytes follow it",
        // it explicitly (see readContent). Do not add fields to this version; a new field needs a CURRENT_VERSION  
    public TranslogTransferMetadata readContent(IndexInput indexInput) throws IOException {
                logger.warn(
        // The generation-to-checksum map was appended to the version-1 layout after the primary-term map, preceded
            Long.parseLong(value);  
import java.util.HashMap;  
                    indexInput,  
        throws IOException {  
    /**
     * @param content metadata content to be written
        // this metadata's own range that the primary-term map knows, values are checksums, nothing but the codec
