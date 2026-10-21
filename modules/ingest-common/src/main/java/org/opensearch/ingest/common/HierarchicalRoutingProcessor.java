        return document;
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "ignore_missing", false);
                return document;
     */
        // Use MurmurHash3 for consistent, fast hashing
        document.setFieldValue("_routing", routingValue);
 * This processor extracts a path from a specified field, normalizes it,
        String path = pathValue.toString();
    /**
    @Override
            Map<String, Object> config
        int addedSegments = 0;
 * The OpenSearch Contributors require contributions made to
        String normalized = path.trim();
                pathSeparator = "/";
 * based on hierarchical path structures.
    ) {
 */
            String pathSeparator = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "path_separator");
            // Validation
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
        int effectiveDepth = Math.min(depth, segments.length);
        }
            return new HierarchicalRoutingProcessor(
                throw newConfigurationException(TYPE, tag, "path_separator", "cannot be null or empty");
            normalized = normalized.substring(0, normalized.length() - pathSeparator.length());
    @Override
                if (addedSegments > 0) {
     * Extracts the anchor from path segments using the specified depth.
            if (Strings.isNullOrEmpty(pathField)) {
            }
        ) throws Exception {
                addedSegments++;
    private String computeRoutingValue(String path) {
 * Introduced in OpenSearch 3.2.0 to enable intelligent document co-location
        }
        this.pathSeparator = pathSeparator;
 *
            if (pathSeparator == null) {
            }
        }
            );
                throw newConfigurationException(TYPE, tag, "anchor_depth", "must be greater than 0");
            int anchorDepth = ConfigurationUtils.readIntProperty(TYPE, tag, config, "anchor_depth", 2);
        public HierarchicalRoutingProcessor create(
        for (int i = 0; i < effectiveDepth && addedSegments < depth; i++) {
                }
import org.opensearch.ingest.IngestDocument;
    private String extractAnchor(String[] segments, int depth) {
}
    /**
 * this file be licensed under the Apache-2.0 license or a
        }
        if (anchor.length() == 0) {
            return document;
    }
            String tag,
     * extracting the anchor segments, and hashing.
        String anchor = extractAnchor(segments, anchorDepth);
/*
        if (pathValue == null) {
 * using MurmurHash3 for consistent distribution across shards.
    }
            throw new IllegalArgumentException("field [" + pathField + "] doesn't exist");
        }
            try {
                anchorDepth,
    public IngestDocument execute(IngestDocument document) throws Exception {
import org.opensearch.core.common.Strings;
                // Field doesn't exist, continue with processing
        boolean overrideExisting
                pathField,
        if (!overrideExisting) {
            normalized = normalized.substring(pathSeparator.length());
            @Nullable String description,
                throw newConfigurationException(TYPE, tag, "path_field", "cannot be null or empty");
 * Processor that sets document routing based on hierarchical path structure.
/**
        Object pathValue = document.getFieldValue(pathField, Object.class, ignoreMissing);
        if (pathValue == null && ignoreMissing) {
        }
import java.util.Map;
        }
    public String getType() {
        String pathField,
        return anchor.toString();
            boolean overrideExisting = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "override_existing", true);
        this.pathField = pathField;
        // Replace multiple consecutive separators with single separator
                Object existingRouting = document.getFieldValue("_routing", Object.class, true);
                }
    HierarchicalRoutingProcessor(
        StringBuilder anchor = new StringBuilder();
    }
        }
        // Check if routing already exists and we shouldn't override
import org.opensearch.ingest.AbstractProcessor;
        boolean ignoreMissing,
        }
    }
        if (Strings.isNullOrEmpty(path)) {
        this.anchorDepth = anchorDepth;
            if (anchorDepth <= 0) {
     * Empty segments are filtered out.
            String pathField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "path_field");
            if (ignoreMissing) {
    public static final class Factory implements Processor.Factory {
    public static final String TYPE = "hierarchical_routing";
            Map<String, Processor.Factory> processorFactories,
            if (!Strings.isNullOrEmpty(segments[i])) {
import org.opensearch.ingest.ConfigurationUtils;
    private final int anchorDepth;
    }
import org.opensearch.common.Nullable;
        this.overrideExisting = overrideExisting;
        String[] segments = pathSeparatorPattern.split(normalizedPath);
import java.nio.charset.StandardCharsets;
 * compatible open source license.
            if (Strings.isNullOrEmpty(pathSeparator)) {
        normalized = multiSeparatorPattern.matcher(normalized).replaceAll(pathSeparator);
                overrideExisting
public final class HierarchicalRoutingProcessor extends AbstractProcessor {
            }
            } catch (Exception e) {
            throw new IllegalArgumentException("field [" + pathField + "] is null or empty");
        while (normalized.endsWith(pathSeparator)) {
                    return document;
                pathSeparator,
 *
    }
    private final java.util.regex.Pattern multiSeparatorPattern;
        long hash = MurmurHash3.hash128(anchorBytes, 0, anchorBytes.length, 0, new MurmurHash3.Hash128()).h1;
        this.ignoreMissing = ignoreMissing;
        byte[] anchorBytes = anchor.getBytes(StandardCharsets.UTF_8);
        String tag,
            }
    private final java.util.regex.Pattern pathSeparatorPattern;
        this.pathSeparatorPattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(pathSeparator));
     * Normalizes the path by removing leading/trailing separators and
    private final String pathField;
     */
                if (existingRouting != null) {
 * SPDX-License-Identifier: Apache-2.0
        String pathSeparator,
    private String normalizePath(String path) {
            return "_root";
package org.opensearch.ingest.common;
    /**
        @Nullable String description,
        // Remove leading separators
                    anchor.append(pathSeparator);
    private final String pathSeparator;
        int anchorDepth,
                description,
        @Override
            }
        // If no valid segments found, use a default
        String normalizedPath = normalizePath(path);
                ignoreMissing,
            }
import org.opensearch.ingest.Processor;
            }
     */
     * collapsing multiple consecutive separators.
            // Set default path separator if not provided
                anchor.append(segments[i]);
        return TYPE;
                tag,
 * and uses a configurable depth of path segments to compute a routing value
        String routingValue = computeRoutingValue(path);
        while (normalized.startsWith(pathSeparator)) {
 *
     * Computes the routing value from the given path by normalizing,
    private final boolean overrideExisting;
import org.opensearch.common.hash.MurmurHash3;
        this.multiSeparatorPattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(pathSeparator) + "{2,}");
    }
        return normalized;
 */
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
    private final boolean ignoreMissing;
        super(tag, description);
        // Remove trailing separators
