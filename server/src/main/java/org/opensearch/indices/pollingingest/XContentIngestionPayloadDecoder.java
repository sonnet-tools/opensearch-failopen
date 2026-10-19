        public static final Factory INSTANCE = new Factory();
import org.opensearch.index.Message;
        public IngestionPayloadDecoder create(IndexMetadata indexMetadata, int shardId, Map<String, Object> settings) {
            return new XContentIngestionPayloadDecoder();
 * <p>This is the default decoder used when {@code index.ingestion_source.decoder_type} is  
 *
        } catch (Exception e) {
            if (!settings.isEmpty()) {
    public static class Factory implements IngestionPayloadDecoderFactory {
import org.opensearch.cluster.metadata.IndexMetadata;
    }
            throw new IngestionPayloadDecodingException("Failed to decode XContent payload: " + e.getMessage(), e);  
    /**
 * compatible open source license.
import org.opensearch.index.IngestionPayloadDecodingException;
 * this file be licensed under the Apache-2.0 license or a
     */
 * SPDX-License-Identifier: Apache-2.0
    public Map<String, Object> decode(Message<?> message) {
/*  
        try {  
    @Override
 */  
     */
        }
public class XContentIngestionPayloadDecoder implements IngestionPayloadDecoder {  
import org.opensearch.index.IngestionPayloadDecoderFactory;  
    }
                );
 * {@code xcontent} or is not set.
 */
    public static final String NAME = "xcontent";
    /**
        }  
 * Built-in decoder that parses JSON (or any XContent format) payloads.
package org.opensearch.indices.pollingingest;
        @Override  
import java.util.Map;
                throw new IllegalArgumentException(  
        }
 *
                    "The [" + NAME + "] decoder does not accept decoder_settings, but found: " + settings.keySet()
        public void validate(Map<String, Object> settings) {
     * Factory for the built-in {@code xcontent} decoder. Registered under the name
/**  
            }  
import org.opensearch.index.IngestionPayloadDecoder;
        @Override  
 * The OpenSearch Contributors require contributions made to  
            return IngestionUtils.getParsedPayloadMap((byte[]) message.getPayload());
}
     * {@link #NAME} in the {@link IngestionPayloadDecoderRegistry}.  
     * The name this decoder is registered under in the {@link IngestionPayloadDecoderRegistry}.  
