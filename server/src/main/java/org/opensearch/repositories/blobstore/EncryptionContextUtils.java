                byte[] decoded = Base64.getDecoder().decode(repoEncContext);  
import java.util.Map;
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, json)  
     * Parses JSON string into a map using XContentParser for robust parsing.
     */  
     *
        // Use index key provider if present, else repository  
        String keyProviderName = (indexMetadata.keyProviderName() != null)
            for (Map.Entry<String, String> e : map.entrySet()) {
     *
     * Output: "key1=value1,key2=value2"  
        }  
        }
            map.putAll(parseJsonToMap(override));
     * @param indexEncContext Index-level encryption context - can be cryptofs or JSON format
            if (repoCtx != null && !repoCtx.isEmpty()) {
     */  
        // Base64 encode the merged result  
            }
     * Parses JSON format into Map using XContentParser for robust handling.
        try {  
            : repositoryCryptoMetadata.keyProviderType();
        } else if (repoCtx != null && !repoCtx.isEmpty()) {
        if (repositoryCryptoMetadata == null) {
                first = false;
    public static CryptoMetadata mergeCryptoMetadata(CryptoMetadata indexMetadata, CryptoMetadata repositoryCryptoMetadata) {
                if (!first) sb.append(",");  
        }
     * Input: "key1=value1,key2=value2"
import org.opensearch.common.Nullable;
     * Merges index-level and repository-level encryption contexts, converts to JSON format if needed,
                sb.append(e.getKey()).append("=").append(e.getValue());
            builder.endObject();
     */  
import java.io.IOException;
                settingsBuilder.put("kms.encryption_context", mergedCryptofs);  
        if ((indexEncContext == null || indexEncContext.isEmpty()) && (repoEncContext == null || repoEncContext.isEmpty())) {
import org.opensearch.common.xcontent.XContentType;
     * @param json JSON string to parse
     * @param json JSON string to parse
 */  
     * Priority: Index key greater than Repository key  
    }
            return indexMetadata;  
            XContentBuilder builder = XContentFactory.jsonBuilder();
/*  
    public static String jsonToCryptofs(String json) {
import org.opensearch.core.xcontent.DeprecationHandler;  
            }  
                if (kv.length == 2) {  
            : repositoryCryptoMetadata.keyProviderName();  
     * Simple JSON parser for string-string maps.
                String mergedCryptofs = jsonToCryptofs(mergedJson);
                if (token == XContentParser.Token.FIELD_NAME) {  
    private static Map<String, String> parseJsonToMap(String json) throws IOException {  
        // Merge settings: start with repo, overlay index settings  
        if (indexMetadata == null && repositoryCryptoMetadata == null) {
        if (base == null || base.isEmpty()) {
            return "{}";  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            builder.endObject();
    }
    }
                    parser.nextToken(); // Move to value
 * SPDX-License-Identifier: Apache-2.0
public class EncryptionContextUtils {
        if (repoEncContext != null && !repoEncContext.isEmpty()) {
            // Convert cryptofs format to JSON if needed
/**  
            } catch (IllegalArgumentException e) {
     *
     * @param repositoryCryptoMetadata The repository-level CryptoMetadata
            settingsBuilder.put("kms.encryption_context", repoCtx);  // Keep original format
            Map<String, String> map = parseJsonToMap(json);
            XContentParser.Token token = parser.nextToken();  
    /**
        // Merge encryption contexts from settings  
     * Output: {"key1":"value1","key2":"value2"}
            try {
        String indexCtx = indexMetadata.settings().get("kms.encryption_context");
import org.opensearch.core.xcontent.XContentParser;  
            map.putAll(parseJsonToMap(base));
     * @param override Override context in JSON format  
        } catch (IOException e) {
        if (json == null || json.trim().isEmpty()) {
     * Input: {"key1":"value1","key2":"value2"}
    /**
            String indexJson = indexCtx.trim().startsWith("{") ? indexCtx : cryptofsToJson(indexCtx);  
            return base;
                repoJson = new String(decoded, StandardCharsets.UTF_8);
                    String key = parser.currentName();
        // If both null, return null
            return builder.toString();  
        }
     * @return Map of key-value pairs  
     * Handles all JSON escape sequences correctly including quotes, backslashes, and control characters.  
     * Converts cryptofs format to JSON.  
            return repositoryCryptoMetadata;  
     *
                builder.field(e.getKey(), e.getValue());
        Map<String, String> map = new LinkedHashMap<>();
        }  
        }  
     * @return Merged JSON string
import java.util.Base64;
     * @throws IOException if JSON parsing fails
    public static String mergeJson(String base, String override) {  
        String mergedJson = mergeJson(repoJson, indexJson);
        return map;  
                settingsBuilder.put("kms.encryption_context", indexCtx);  // Keep original format
            }  
            } else {
                indexJson = trimmed;
     * Base provides baseline, override takes precedence on conflicts.  
     * keys and values <b>MUST NOT contain</b> these characters, or data corruption will occur
            throw new UncheckedIOException("Failed to parse JSON", e);  
            Map<String, String> map = new LinkedHashMap<>();  
    /**  
        try {  
     * when converting back to JSON.</p>
 * compatible open source license.
                    builder.field(kv[0].trim(), kv[1].trim());
            }  
                String[] kv = pair.trim().split("=", 2);
     */
        }
            return "";  
            StringBuilder sb = new StringBuilder();  
import java.nio.charset.StandardCharsets;
 * Utility class for encryption context operations.
        return Base64.getEncoder().encodeToString(mergedJson.getBytes(StandardCharsets.UTF_8));
import java.util.LinkedHashMap;  
        }  
                indexJson = cryptofsToJson(trimmed);
     * @return Merged CryptoMetadata with combined key and context
            if (token != XContentParser.Token.START_OBJECT) {
     * This method is kept for backward compatibility with existing tests and code.  
        }  
     * @param indexMetadata            The index-level CryptoMetadata  
            return new LinkedHashMap<>();
     */
            } else {  
import java.io.UncheckedIOException;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.CryptoMetadata;
            builder.startObject();
    }  
}  
     * <p><b>IMPORTANT LIMITATION:</b> This format uses comma (,) as a delimiter between
        try {
            if (trimmed.startsWith("{")) {
        if (json == null || json.isEmpty()) {
     * @param base Base context in JSON format
            return override != null ? override : "{}";
        }
        // Parse index context to JSON  
    /**
                    map.put(key, value);
     * Converts JSON format back to cryptofs format.
        String repoJson = null;  
        // Decode repository context from Base64
            throw new UncheckedIOException("Failed to merge JSON contexts", e);
            String trimmed = indexEncContext.trim();  
            for (String pair : cryptofs.split(",")) {
    }
            }  
import org.opensearch.common.settings.Settings;  
import org.opensearch.core.xcontent.XContentBuilder;
        }
            builder.startObject();
        String keyProviderType = (indexMetadata.keyProviderType() != null)
        }
     * <p>
        }
            XContentBuilder builder = XContentFactory.jsonBuilder();
            }
        String repoCtx = repositoryCryptoMetadata.settings().get("kms.encryption_context");
    public static String cryptofsToJson(String cryptofs) {
                    String value = parser.text();  
        try {  
     * Context: Index context merged with repository context (EncA + EncB)
            return null;  
        try (
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 */
            return builder.toString();  
            }  
                String repoJson = repoCtx.trim().startsWith("{") ? repoCtx : cryptofsToJson(repoCtx);  
            ? indexMetadata.keyProviderType()  
                }
        }  
        } catch (IOException e) {
        return new CryptoMetadata(keyProviderName, keyProviderType, settingsBuilder.build());
        ) {
            ? indexMetadata.keyProviderName()
     */
     * @return Base64 encoded merged JSON encryption context, or null if both are null
        }
        Settings.Builder settingsBuilder = Settings.builder().put(repositoryCryptoMetadata.settings()).put(indexMetadata.settings());
     *
        } catch (IOException e) {
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to parse JSON for cryptofs conversion", e);  
    public static String mergeAndEncodeEncryptionContexts(@Nullable String indexEncContext, @Nullable String repoEncContext) {  
        }  
        if (override == null || override.isEmpty()) {
    /**
package org.opensearch.repositories.blobstore;
            XContentParser parser = XContentType.JSON.xContent()
    public static void parseSimpleJson(String json, Map<String, String> map) {
                String mergedJson = mergeJson(repoJson, indexJson);
 * and Base64 encoding for S3 operations.  
                }
 *
            return null;  
                repoJson = repoEncContext;  
     * This ensures KMS grants created with combined context work correctly.  
 * this file be licensed under the Apache-2.0 license or a
        String indexJson = null;
            throw new UncheckedIOException("Failed to convert cryptofs format to JSON", e);
     * and Base64 encodes for S3.  
            }  
     * Merges index-level and repository-level CryptoMetadata.
        if (indexCtx != null && !indexCtx.isEmpty()) {
    }
            for (Map.Entry<String, String> e : map.entrySet()) {
            boolean first = true;
     * @param repoEncContext  Repository-level encryption context - already Base64 encoded JSON  
    /**  
     * Merges two JSON strings.
     *
        if (indexMetadata == null) {
    }
     * Merging strategy: Repository context provides baseline, index context keys override on conflict.
     * @param map Map to populate with parsed key-value pairs  
     */
            return sb.toString();
            map.putAll(parseJsonToMap(json));
        if (cryptofs == null || cryptofs.isEmpty()) {
    /**
 * Provides methods for format conversion, merging contexts,
     * key-value pairs and equals (=) as a delimiter between keys and values. Therefore,  
        }
import org.opensearch.common.xcontent.XContentFactory;
                throw new IllegalArgumentException("Expected JSON object, got: " + token);
        if (indexEncContext != null && !indexEncContext.isEmpty()) {
