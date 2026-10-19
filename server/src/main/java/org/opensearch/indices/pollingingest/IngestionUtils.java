}
    public static Map<String, Object> getParsedPayloadMap(byte[] payload) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Map<String, Object> payloadMap = XContentHelper.convertToMap(payloadBR, false, MediaTypeRegistry.xContentType(payloadBR)).v2();
 *
        return payloadMap;  
 */
public final class IngestionUtils {
 * Holds common utilities for streaming ingestion.  
 * compatible open source license.
import org.opensearch.common.xcontent.XContentHelper;
package org.opensearch.indices.pollingingest;
 * The OpenSearch Contributors require contributions made to  
 */  
 * this file be licensed under the Apache-2.0 license or a
        BytesReference payloadBR = new BytesArray(payload);
    private IngestionUtils() {}
/**
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.core.common.bytes.BytesArray;
/*  
import java.util.Map;  
    }
 * SPDX-License-Identifier: Apache-2.0
