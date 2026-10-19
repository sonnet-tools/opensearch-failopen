     * @param override Override context in JSON format
                if (token == XContentParser.Token.FIELD_NAME) {
            throw new UncheckedIOException("Failed to parse JSON for cryptofs conversion", e);
            } else {
import org.opensearch.core.xcontent.NamedXContentRegistry;
        } else if (repoCtx != null && !repoCtx.isEmpty()) {
        if (repositoryCryptoMetadata == null) {
 * and Base64 encoding for S3 operations.
            String indexJson = indexCtx.trim().startsWith("{") ? indexCtx : cryptofsToJson(indexCtx);
                repoJson = new String(decoded, StandardCharsets.UTF_8);
        String repoJson = null;
                String mergedCryptofs = jsonToCryptofs(mergedJson);
     *
        }
     */
                byte[] decoded = Base64.getDecoder().decode(repoEncContext);
        // Merge encryption contexts from settings
     * Base provides baseline, override takes precedence on conflicts.
            map.putAll(parseJsonToMap(base));
            }
        if (json == null || json.trim().isEmpty()) {
     * Merging strategy: Repository context provides baseline, index context keys override on conflict.
        if (indexMetadata == null && repositoryCryptoMetadata == null) {
     * Simple JSON parser for string-string maps.
        }
    public static CryptoMetadata mergeCryptoMetadata(CryptoMetadata indexMetadata, CryptoMetadata repositoryCryptoMetadata) {
     * Merges index-level and repository-level CryptoMetadata.
                if (kv.length == 2) {
            }
            return override != null ? override : "{}";
 * compatible open source license.
                    parser.nextToken(); // Move to value
     * @param json JSON string to parse
 */
import org.opensearch.common.settings.Settings;
     * @param indexEncContext Index-level encryption context - can be cryptofs or JSON format
     * @param repositoryCryptoMetadata The repository-level CryptoMetadata
    public static String cryptofsToJson(String cryptofs) {
     * @throws IOException if JSON parsing fails
import java.util.Base64;
        if (cryptofs == null || cryptofs.isEmpty()) {
                settingsBuilder.put("kms.encryption_context", mergedCryptofs);
     * Output: {"key1":"value1","key2":"value2"}
            } catch (IllegalArgumentException e) {
     * @param repoEncContext  Repository-level encryption context - already Base64 encoded JSON
                indexJson = trimmed;
            if (repoCtx != null && !repoCtx.isEmpty()) {
                    builder.field(kv[0].trim(), kv[1].trim());
                String repoJson = repoCtx.trim().startsWith("{") ? repoCtx : cryptofsToJson(repoCtx);
     * Converts cryptofs format to JSON.
        } catch (IOException e) {
public class EncryptionContextUtils {
    }
            throw new UncheckedIOException("Failed to parse JSON", e);
        }
 * The OpenSearch Contributors require contributions made to
            builder.startObject();
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, json)
        } catch (IOException e) {
            for (Map.Entry<String, String> e : map.entrySet()) {
        // Parse index context to JSON
     * @return Merged CryptoMetadata with combined key and context
     * Input: {"key1":"value1","key2":"value2"}
                first = false;
        if ((indexEncContext == null || indexEncContext.isEmpty()) && (repoEncContext == null || repoEncContext.isEmpty())) {
 * SPDX-License-Identifier: Apache-2.0
            } else {
            }
        Map<String, String> map = new LinkedHashMap<>();
            return "";
 * Utility class for encryption context operations.
     * Input: "key1=value1,key2=value2"
        // Merge settings: start with repo, overlay index settings
            XContentParser.Token token = parser.nextToken();
     * Parses JSON string into a map using XContentParser for robust parsing.
        }
     * Handles all JSON escape sequences correctly including quotes, backslashes, and control characters.
        // Use index key provider if present, else repository
                repoJson = repoEncContext;
            return builder.toString();
     * when converting back to JSON.</p>
     * This method is kept for backward compatibility with existing tests and code.
                if (!first) sb.append(",");
     * <p><b>IMPORTANT LIMITATION:</b> This format uses comma (,) as a delimiter between
            return indexMetadata;
    public static String mergeAndEncodeEncryptionContexts(@Nullable String indexEncContext, @Nullable String repoEncContext) {
            for (Map.Entry<String, String> e : map.entrySet()) {
     */
            }
     * Context: Index context merged with repository context (EncA + EncB)
            return sb.toString();
 * Provides methods for format conversion, merging contexts,
            return null;
            ? indexMetadata.keyProviderType()
            builder.endObject();
            XContentBuilder builder = XContentFactory.jsonBuilder();
        }
     * Parses JSON format into Map using XContentParser for robust handling.
import org.opensearch.common.xcontent.XContentFactory;
     * @return Merged JSON string
            return new LinkedHashMap<>();
    }
            try {
        try {
        if (base == null || base.isEmpty()) {
     */
        }
import org.opensearch.common.Nullable;
        }
/**
 * this file be licensed under the Apache-2.0 license or a
            return null;
        if (indexMetadata == null) {
            // Convert cryptofs format to JSON if needed
        }
        if (override == null || override.isEmpty()) {
            StringBuilder sb = new StringBuilder();
        try (
     *
        try {
     * Output: "key1=value1,key2=value2"
     * @param map Map to populate with parsed key-value pairs
        Settings.Builder settingsBuilder = Settings.builder().put(repositoryCryptoMetadata.settings()).put(indexMetadata.settings());
            Map<String, String> map = parseJsonToMap(json);
        String indexCtx = indexMetadata.settings().get("kms.encryption_context");
    /**
            : repositoryCryptoMetadata.keyProviderName();
        }
    /**
            map.putAll(parseJsonToMap(json));
     * @param indexMetadata            The index-level CryptoMetadata
        // Decode repository context from Base64
            XContentParser parser = XContentType.JSON.xContent()
        }
     *
    public static void parseSimpleJson(String json, Map<String, String> map) {
     * and Base64 encodes for S3.
     * @return Map of key-value pairs
        }
        String indexJson = null;
        if (indexEncContext != null && !indexEncContext.isEmpty()) {
                    map.put(key, value);
import org.opensearch.common.xcontent.XContentType;
        String mergedJson = mergeJson(repoJson, indexJson);
    }
        } catch (IOException e) {
import org.opensearch.core.xcontent.XContentBuilder;
     * keys and values <b>MUST NOT contain</b> these characters, or data corruption will occur
}
    }
import org.opensearch.core.xcontent.XContentParser;
     *
        }
     * Priority: Index key greater than Repository key
            String trimmed = indexEncContext.trim();
            if (token != XContentParser.Token.START_OBJECT) {
    }
            }
                throw new IllegalArgumentException("Expected JSON object, got: " + token);
        }
import org.opensearch.core.xcontent.DeprecationHandler;
            builder.startObject();
        if (indexCtx != null && !indexCtx.isEmpty()) {
    /**
        }
            return "{}";
     * <p>
     * Merges index-level and repository-level encryption contexts, converts to JSON format if needed,
    }
    public static String mergeJson(String base, String override) {
                builder.field(e.getKey(), e.getValue());
     * @param json JSON string to parse
                sb.append(e.getKey()).append("=").append(e.getValue());
        // If both null, return null
        try {
            ? indexMetadata.keyProviderName()
            throw new UncheckedIOException("Failed to merge JSON contexts", e);
                settingsBuilder.put("kms.encryption_context", indexCtx);  // Keep original format
            }
            boolean first = true;
import java.io.UncheckedIOException;
     */
        if (json == null || json.isEmpty()) {
                }
            if (trimmed.startsWith("{")) {
            Map<String, String> map = new LinkedHashMap<>();
            return builder.toString();
import java.util.LinkedHashMap;
 *
            builder.endObject();
     *
/*
     */
    /**
    private static Map<String, String> parseJsonToMap(String json) throws IOException {
                    String value = parser.text();
        }
        // Base64 encode the merged result
     * @return Base64 encoded merged JSON encryption context, or null if both are null
import org.opensearch.cluster.metadata.CryptoMetadata;
import java.io.IOException;
            settingsBuilder.put("kms.encryption_context", repoCtx);  // Keep original format
    public static String jsonToCryptofs(String json) {
     * @param base Base context in JSON format
                indexJson = cryptofsToJson(trimmed);
            map.putAll(parseJsonToMap(override));
        if (repoEncContext != null && !repoEncContext.isEmpty()) {
        ) {
        String keyProviderType = (indexMetadata.keyProviderType() != null)
    /**
    /**
        }
        return Base64.getEncoder().encodeToString(mergedJson.getBytes(StandardCharsets.UTF_8));
                    String key = parser.currentName();
     */
import java.util.Map;
                String[] kv = pair.trim().split("=", 2);
        String keyProviderName = (indexMetadata.keyProviderName() != null)
            XContentBuilder builder = XContentFactory.jsonBuilder();
            }
            }
            return repositoryCryptoMetadata;
            for (String pair : cryptofs.split(",")) {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     *
            throw new UncheckedIOException("Failed to convert cryptofs format to JSON", e);
package org.opensearch.repositories.blobstore;
            return base;
    /**
     */
                String mergedJson = mergeJson(repoJson, indexJson);
        } catch (IOException e) {
 */
     * key-value pairs and equals (=) as a delimiter between keys and values. Therefore,
    }
            : repositoryCryptoMetadata.keyProviderType();
                }
     * This ensures KMS grants created with combined context work correctly.
import java.nio.charset.StandardCharsets;
     * Converts JSON format back to cryptofs format.
        }
        return new CryptoMetadata(keyProviderName, keyProviderType, settingsBuilder.build());
        return map;
        String repoCtx = repositoryCryptoMetadata.settings().get("kms.encryption_context");
     * Merges two JSON strings.
        try {
