    private String extractAnchor(String[] segments, int depth) {
        String[] segments = pathSeparatorPattern.split(normalizedPath);  
            String pathSeparator = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "path_separator");
                pathSeparator,
            normalized = normalized.substring(0, normalized.length() - pathSeparator.length());  
            );
        // Use MurmurHash3 for consistent, fast hashing  
                pathSeparator = "/";
        }
 * The OpenSearch Contributors require contributions made to  
        // If no valid segments found, use a default
            if (Strings.isNullOrEmpty(pathSeparator)) {
            if (!Strings.isNullOrEmpty(segments[i])) {
import org.opensearch.common.Nullable;
 *
        this.overrideExisting = overrideExisting;
            @Nullable String description,
        boolean overrideExisting
            int anchorDepth = ConfigurationUtils.readIntProperty(TYPE, tag, config, "anchor_depth", 2);
    }
        }
    public static final String TYPE = "hierarchical_routing";
        String normalizedPath = normalizePath(path);
    @Override
    private String computeRoutingValue(String path) {
                throw newConfigurationException(TYPE, tag, "path_separator", "cannot be null or empty");
                addedSegments++;  
    }
            }  
        this.pathSeparator = pathSeparator;  
import java.nio.charset.StandardCharsets;  
                throw newConfigurationException(TYPE, tag, "anchor_depth", "must be greater than 0");
                anchor.append(segments[i]);
            }
        super(tag, description);  
        normalized = multiSeparatorPattern.matcher(normalized).replaceAll(pathSeparator);
            }
            throw new IllegalArgumentException("field [" + pathField + "] doesn't exist");
    public String getType() {
        return TYPE;
        return anchor.toString();  
            String tag,
                if (addedSegments > 0) {
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "ignore_missing", false);  
        }
        this.pathField = pathField;
        long hash = MurmurHash3.hash128(anchorBytes, 0, anchorBytes.length, 0, new MurmurHash3.Hash128()).h1;
import org.opensearch.ingest.IngestDocument;  
     */  
            }  
            Map<String, Object> config  
                description,
        if (pathValue == null && ignoreMissing) {
        int anchorDepth,
 * this file be licensed under the Apache-2.0 license or a
        @Nullable String description,
                overrideExisting
        if (pathValue == null) {  
        boolean ignoreMissing,  
                // Field doesn't exist, continue with processing
    }
     * Normalizes the path by removing leading/trailing separators and
import org.opensearch.common.hash.MurmurHash3;
 * compatible open source license.
                    return document;
 * Introduced in OpenSearch 3.2.0 to enable intelligent document co-location  
        }
            normalized = normalized.substring(pathSeparator.length());
        }  
            if (Strings.isNullOrEmpty(pathField)) {
    ) {
 * Processor that sets document routing based on hierarchical path structure.  
        // Check if routing already exists and we shouldn't override  
import org.opensearch.ingest.AbstractProcessor;
            if (anchorDepth <= 0) {  
    private String normalizePath(String path) {
/**
    }
            // Validation
                tag,
            throw new IllegalArgumentException("field [" + pathField + "] is null or empty");  
        String pathSeparator,
        }
 */  
        return normalized;  
package org.opensearch.ingest.common;
                Object existingRouting = document.getFieldValue("_routing", Object.class, true);  
        // Remove leading separators
        int addedSegments = 0;
        byte[] anchorBytes = anchor.getBytes(StandardCharsets.UTF_8);
        String path = pathValue.toString();
    public static final class Factory implements Processor.Factory {
import java.util.Map;
        this.anchorDepth = anchorDepth;
}
        int effectiveDepth = Math.min(depth, segments.length);  
        return document;  
import org.opensearch.core.common.Strings;  
 * This processor extracts a path from a specified field, normalizes it,
public final class HierarchicalRoutingProcessor extends AbstractProcessor {  
            return "_root";  
        @Override
        if (Strings.isNullOrEmpty(path)) {
                }
            return new HierarchicalRoutingProcessor(  
        }
        String tag,
     * extracting the anchor segments, and hashing.
    }  
        Object pathValue = document.getFieldValue(pathField, Object.class, ignoreMissing);  
        }
    }
        for (int i = 0; i < effectiveDepth && addedSegments < depth; i++) {  
                return document;
        StringBuilder anchor = new StringBuilder();
            }
import org.opensearch.ingest.ConfigurationUtils;
        this.pathSeparatorPattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(pathSeparator));  
        while (normalized.endsWith(pathSeparator)) {
        if (anchor.length() == 0) {
            }  
    private final int anchorDepth;
            return document;  
            boolean overrideExisting = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "override_existing", true);
 *
        if (!overrideExisting) {
            Map<String, Processor.Factory> processorFactories,  
 * and uses a configurable depth of path segments to compute a routing value  
        this.multiSeparatorPattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(pathSeparator) + "{2,}");
                ignoreMissing,  
    private final boolean ignoreMissing;
     * collapsing multiple consecutive separators.  
    public IngestDocument execute(IngestDocument document) throws Exception {
        public HierarchicalRoutingProcessor create(
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
            }
     */
 *
import org.opensearch.ingest.Processor;
    /**
/*  
                anchorDepth,
                pathField,  
            try {
     * Extracts the anchor from path segments using the specified depth.
            if (pathSeparator == null) {
            if (ignoreMissing) {  
     */  
        // Replace multiple consecutive separators with single separator  
        ) throws Exception {
        String normalized = path.trim();  
    private final java.util.regex.Pattern pathSeparatorPattern;  
 */
    HierarchicalRoutingProcessor(  
 * using MurmurHash3 for consistent distribution across shards.
    private final java.util.regex.Pattern multiSeparatorPattern;
            // Set default path separator if not provided  
     * Computes the routing value from the given path by normalizing,
        this.ignoreMissing = ignoreMissing;
     * Empty segments are filtered out.
    /**  
                    anchor.append(pathSeparator);  
    /**  
        document.setFieldValue("_routing", routingValue);
            String pathField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "path_field");  
        while (normalized.startsWith(pathSeparator)) {  
 * based on hierarchical path structures.
                if (existingRouting != null) {
            } catch (Exception e) {
    private final String pathSeparator;  
        // Remove trailing separators
                throw newConfigurationException(TYPE, tag, "path_field", "cannot be null or empty");  
 * SPDX-License-Identifier: Apache-2.0
        String routingValue = computeRoutingValue(path);  
    private final String pathField;
        }
    private final boolean overrideExisting;
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;  
        String anchor = extractAnchor(segments, anchorDepth);
                }  
        String pathField,  
    @Override  
    }
