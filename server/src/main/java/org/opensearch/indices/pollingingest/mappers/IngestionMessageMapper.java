        }  
}
     * Enum representing different mapper types.  
     * @param mapperType the mapper type
 * SPDX-License-Identifier: Apache-2.0
 */  
     * @param decodedPayload the payload decoded by the shard's {@link org.opensearch.index.IngestionPayloadDecoder}
    /**
     * Factory method to create a mapper instance based on type string.
            case FIELD_MAPPING:
    static IngestionMessageMapper create(String mapperTypeString, int shardId) {
                break;  
                return new RawPayloadIngestionMessageMapper(shardId);
                if (type.name.equalsIgnoreCase(value)) {
                return new FieldMappingIngestionMessageMapper(mapperSettings);  
            default:
    }
/**
    }
        FIELD_MAPPING("field_mapping");  
 * <p>Note that IngestionMessageMapper will only map the incoming message to a {@link ShardUpdateMessage} and will not
        public static MapperType fromString(String value) {  
            case FIELD_MAPPING:
        }  
        switch (mapperType) {  
 *
    }
    }  
            case DEFAULT:
 * compatible open source license.
        DEFAULT("default"),
                return new DefaultIngestionMessageMapper();
    String OP_TYPE_CREATE = "create";  
                throw new IllegalArgumentException("Unknown mapper type: " + mapperType);
     * @return the shard update message
                    "Unknown ingestion mapper type: %s. Valid values are: default, raw_payload, field_mapping",  
        MapperType(String name) {
    /**
    /**  
package org.opensearch.indices.pollingingest.mappers;
    ShardUpdateMessage mapAndProcess(IngestionShardPointer pointer, Message message, Map<String, Object> decodedPayload)
public interface IngestionMessageMapper {
     * @param shardId the shard ID
        }
 * Different implementations can support different message formats from streaming sources.  
            for (MapperType type : MapperType.values()) {
    @PublicApi(since = "3.6.0")
import org.opensearch.indices.pollingingest.ShardUpdateMessage;
     * @param mapperTypeString the type of mapper to create as a string
     *
    /** Operation type value for delete operations */  
    /** Operation type value for index operations */
     */
        RAW_PAYLOAD("raw_payload"),
     *
    String OP_TYPE_INDEX = "index";
import org.opensearch.common.annotation.PublicApi;
     * @throws IllegalArgumentException if the decoded payload is structurally invalid  
import java.util.Map;
 */
 * Interface for mapping ingestion messages to ShardUpdateMessage format.
                }
     *
        private final String name;
     * @return the mapper instance
                FieldMappingIngestionMessageMapper.validateSettings(mapperSettings);
                    throw new IllegalArgumentException("mapper_settings are not supported for mapper_type [" + mapperType.getName() + "]");  
     * Factory method to create a mapper instance based on type string and mapper settings.  
/*  
            );  
     * @param mapperSettings the mapper settings to validate
 * validate and drop messages. Validations will be done as part of message processing in the {@link org.opensearch.indices.pollingingest.MessageProcessorRunnable}</p>  
                }
            return name;  
        return create(mapperTypeString, shardId, Collections.emptyMap());
     */  
        throws IllegalArgumentException;  
     * Maps an already-decoded message into a shard update.  
    static IngestionMessageMapper create(String mapperTypeString, int shardId, Map<String, Object> mapperSettings) {
        MapperType mapperType = MapperType.fromString(mapperTypeString);
     * @param message       the original message (used for metadata such as timestamp)  
     * @param mapperTypeString the type of mapper to create as a string  
 * this file be licensed under the Apache-2.0 license or a
     * @param pointer       the shard pointer for this message
            }
        }  
        }
            default:
     * @return the mapper instance
     *  
                if (mapperSettings != null && mapperSettings.isEmpty() == false) {
    /**
     * @param mapperSettings mapper-specific settings
            case RAW_PAYLOAD:  
    /**
            this.name = name;
            throw new IllegalArgumentException(  
import org.opensearch.index.IngestionShardPointer;
     */
import java.util.Collections;  
        switch (mapperType) {  
                )
                    return type;  
     */  
    String OP_TYPE_DELETE = "delete";
     * @param shardId the shard ID  
 *
     * @throws IllegalArgumentException if validation fails  
                break;
    /** Operation type value for create operations */
                    Locale.ROOT,
import org.opensearch.index.Message;  
 * The OpenSearch Contributors require contributions made to  
                    value
                String.format(
    enum MapperType {  
    static void validateSettings(MapperType mapperType, Map<String, Object> mapperSettings) {
     * Validates mapper settings for the given mapper type.
     */
        public String getName() {
import java.util.Locale;
