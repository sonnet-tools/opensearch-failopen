            String aclField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "acl_field");
        return TYPE;
            value >>= 8;  
import org.opensearch.ingest.AbstractProcessor;
 */
import org.opensearch.ingest.Processor;
            result[i] = (byte) (value & 0xFF);
    private final boolean overrideExisting;
        String tag,
            throw new IllegalArgumentException("field [" + aclField + "] not present as part of path [" + aclField + "]");
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);  
 * The OpenSearch Contributors require contributions made to  
        this.targetField = targetField;
import java.util.Map;  
        System.arraycopy(longToBytes(hash.h2), 0, hashBytes, 8, 8);  
 */  
            Map<String, Processor.Factory> registry,
import org.opensearch.ingest.ConfigurationUtils;  
        byte[] result = new byte[8];  
        }
import org.opensearch.ingest.IngestDocument;
            String description,
        // Convert to base64 for routing value  
    }
            String processorTag,  
                return document;  
        String targetField,
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(bytes, 0, bytes.length, 0, new MurmurHash3.Hash128());
        public AclRoutingProcessor create(
        this.aclField = aclField;  
        byte[] hashBytes = new byte[16];
        String routingValue = generateRoutingValue(aclValue.toString());
        // Use MurmurHash3 for consistent hashing
        byte[] bytes = aclValue.getBytes(StandardCharsets.UTF_8);  
    ) {
    }  
 * compatible open source license.
        boolean overrideExisting  
        if (aclValue == null) {
            boolean overrideExisting = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "override_existing", true);
        document.setFieldValue(targetField, routingValue);
    private byte[] longToBytes(long value) {
        this.ignoreMissing = ignoreMissing;
    @Override
/**
            return document;
import org.opensearch.common.hash.MurmurHash3;
    public static final class Factory implements Processor.Factory {
        }
    }
        for (int i = 7; i >= 0; i--) {
 * this file be licensed under the Apache-2.0 license or a
        }  
 * Processor that sets the _routing field based on ACL metadata.  
        boolean ignoreMissing,
        Object aclValue = document.getFieldValue(aclField, Object.class, ignoreMissing);
            }
    public String getType() {  
        ) throws Exception {  
    public static final String TYPE = "acl_routing";
        System.arraycopy(longToBytes(hash.h1), 0, hashBytes, 0, 8);
import java.nio.charset.StandardCharsets;
    }  
            if (ignoreMissing) {
    }
        @Override  
        this.overrideExisting = overrideExisting;  
        // Check if routing already exists
            Map<String, Object> config
 *
    private String generateRoutingValue(String aclValue) {
        String aclField,  
/*  
    private static final Base64.Encoder BASE64_ENCODER = Base64.getUrlEncoder().withoutPadding();
    public IngestDocument execute(IngestDocument document) throws Exception {
public final class AclRoutingProcessor extends AbstractProcessor {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Base64;
        super(tag, description);
    @Override  
        return document;
        return BASE64_ENCODER.encodeToString(hashBytes);
        }
    private final boolean ignoreMissing;  
}  
        return result;
        if (!overrideExisting && document.hasField(targetField)) {  
    }
    private final String aclField;
package org.opensearch.ingest.common;
    private final String targetField;
            return new AclRoutingProcessor(processorTag, description, aclField, targetField, ignoreMissing, overrideExisting);  
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", "_routing");
    AclRoutingProcessor(  
        String description,
