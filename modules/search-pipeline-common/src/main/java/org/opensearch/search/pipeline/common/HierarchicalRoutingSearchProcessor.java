        return TYPE;
    /**
        if (request.source() != null && request.source().query() != null) {
package org.opensearch.search.pipeline.common;
    }
        String normalizedPath = normalizePath(path);
        String normalized = path.trim();
     * Extracts anchor from path segments using specified depth
        // Use MurmurHash3 for consistent, fast hashing (same as ingest processor)
            for (String path : routingValues) {
        }
/*
                    if (pathPrefix != null && !pathPrefix.isEmpty()) {
    private class PathExtractionVisitor implements QueryBuilderVisitor {
            // Return a no-op visitor for SHOULD and MUST_NOT clauses
     * Computes routing value from path using same logic as ingest processor
        // Skip if routing is already explicitly set
                        paths.add(pathPrefix);
     * (same as ingest processor)
         */
        PathExtractionVisitor(Set<String> paths) {
                String routing = String.join(",", computedRouting);
 *
                throw newConfigurationException(TYPE, tag, "path_field", "cannot be null or empty");
        int addedSegments = 0;
                request.routing(routing);
                pathField,
        if (!routingValues.isEmpty()) {
import org.opensearch.index.query.WildcardQueryBuilder;
         * Creates a new HierarchicalRoutingSearchProcessor instance
        if (Strings.isNullOrEmpty(path)) {
            } else if (qb instanceof TermsQueryBuilder termsQuery) {
        @Override
        String pathField,
 * A search request processor that automatically adds routing to search requests
        if (pattern == null) return null;
import org.opensearch.action.search.SearchRequest;
    }
                if (addedSegments > 0) {
                    String pathPrefix = extractPrefixFromWildcard(pattern);
            }
                if (pathField.equals(termQuery.fieldName())) {
        }
        // Remove leading separators
     */
 * This processor works in conjunction with the HierarchicalRoutingProcessor
    private final java.util.regex.Pattern pathSeparatorPattern;
    /**
        byte[] anchorBytes = anchor.getBytes(StandardCharsets.UTF_8);
                throw newConfigurationException(TYPE, tag, "path_separator", "cannot be null or empty");
            request.source().query().visit(visitor);
        public HierarchicalRoutingSearchProcessor create(
import org.opensearch.search.pipeline.AbstractProcessor;
    private final String pathField;
     * Extracts the stable prefix from a wildcard pattern
        int anchorDepth,
        this.pathField = pathField;
        return request;
            } else if (qb instanceof PrefixQueryBuilder prefixQuery) {
         * @return new HierarchicalRoutingSearchProcessor instance
     * Example: "/company/engineering/*" -> "/company/engineering"
        }
    public static final String TYPE = "hierarchical_routing_search";
            Processor.PipelineContext pipelineContext
 * based on hierarchical path information found in queries.
 * this file be licensed under the Apache-2.0 license or a
                    paths.add(termQuery.value().toString());
        public Factory() {}
import java.util.Set;
            PathExtractionVisitor visitor = new PathExtractionVisitor(routingValues);
import org.opensearch.index.query.TermsQueryBuilder;
                pathSeparator = "/";
/**
     */
    }
                        paths.add(value.toString());
        }
            if (qb instanceof TermQueryBuilder termQuery) {
                if (routingValue != null) {
            String tag,
        this.multiSeparatorPattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(pathSeparator) + "{2,}");
         * Creates a new Factory instance
        // Remove trailing separators
 * SPDX-License-Identifier: Apache-2.0
        String pathSeparator,
 */
            String description,
         * @param processorFactories available processor factories
            String pathField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "path_field");
                }
         */
                    for (Object value : termsQuery.values()) {
            } else if (qb instanceof WildcardQueryBuilder wildcardQuery) {
                if (pathField.equals(prefixQuery.fieldName())) {
                String routingValue = computeRoutingValue(path);
        String tag,
import org.opensearch.common.hash.MurmurHash3;
    }
        }
         * @param tag processor tag
            String pathSeparator = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "path_separator");
        normalized = multiSeparatorPattern.matcher(normalized).replaceAll(pathSeparator);
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
        if (wildcardIndex >= 0) firstWildcard = wildcardIndex;
            return null;
        int questionIndex = pattern.indexOf('?');
            }
            // The visitor pattern will automatically handle other query types
    HierarchicalRoutingSearchProcessor(
import org.opensearch.ingest.ConfigurationUtils;
                }
 *
        int firstWildcard = -1;
        if (request.routing() != null && !request.routing().isEmpty()) {
        String[] segments = pathSeparatorPattern.split(normalizedPath);
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
import org.opensearch.index.query.QueryBuilderVisitor;
            boolean ignoreFailure,
    public String getType() {
            // Only process MUST and FILTER clauses as they restrict results
                throw newConfigurationException(TYPE, tag, "anchor_depth", "must be greater than 0");
        }
    }
                enableAutoDetection
    private final int anchorDepth;
}
 * search shards containing documents routed with "/company/engineering" prefix.
            if (!Strings.isNullOrEmpty(segments[i])) {
        if (anchor.length() == 0) {
                pathSeparator,
        this.pathSeparatorPattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(pathSeparator));
 * (ingest pipeline) to optimize searches by routing them only to shards
            }
import org.opensearch.index.query.PrefixQueryBuilder;
                description,
            boolean enableAutoDetection = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "enable_auto_detection", true);
                    anchor.append(pathSeparator);
            // Validation
                    paths.add(prefixQuery.value());
    /**
        this.anchorDepth = anchorDepth;
     * Factory for creating HierarchicalRoutingSearchProcessor instances
    /**
import org.apache.lucene.search.BooleanClause;
        }
        for (int i = 0; i < effectiveDepth && addedSegments < depth; i++) {
    @Override
            return QueryBuilderVisitor.NO_OP_VISITOR;
    /**
         * @param description processor description
            }
            return request;
 * compatible open source license.
import java.util.Map;
    }
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
        while (normalized.startsWith(pathSeparator)) {
            }
import java.util.HashSet;
                anchorDepth,
        }
    private String computeRoutingValue(String path) {
    private String extractAnchor(String[] segments, int depth) {
                    }
        StringBuilder anchor = new StringBuilder();
    private String normalizePath(String path) {
import org.opensearch.search.pipeline.SearchRequestProcessor;
        Set<String> routingValues = new HashSet<>();
         * @param pipelineContext pipeline context
    ) {
        }
                // Join multiple routing values with comma
            // SHOULD and MUST_NOT don't guarantee document presence on specific shards
                    String pattern = wildcardQuery.value();
            int anchorDepth = ConfigurationUtils.readIntProperty(TYPE, tag, config, "anchor_depth", 2);
        /**
        }
 * Example: A query with filter "path:/company/engineering/*" will only
        String description,
            }
            if (!computedRouting.isEmpty()) {
    @Override
                if (pathField.equals(wildcardQuery.fieldName())) {
        this.enableAutoDetection = enableAutoDetection;
        }
            Set<String> computedRouting = new HashSet<>();
    private String extractPrefixFromWildcard(String pattern) {
        // Extract path information from the search request using visitor pattern
        public void accept(QueryBuilder qb) {
        super(tag, description, ignoreFailure);
        boolean enableAutoDetection
            firstWildcard = questionIndex;
         * @param config processor configuration
    private final boolean enableAutoDetection;
        int effectiveDepth = Math.min(depth, segments.length);
        String anchor = extractAnchor(segments, anchorDepth);
     * collapsing multiple consecutive separators (same as ingest processor)
        }
            }
 * that contain documents with matching path prefixes.
        // If no valid segments found, use a default
            Map<String, Object> config,
    }
    public static final class Factory implements Processor.Factory<SearchRequestProcessor> {
        // If we found path information, compute routing and apply it
        this.pathSeparator = pathSeparator;
        ) throws Exception {
            normalized = normalized.substring(pathSeparator.length());
 *
            if (Strings.isNullOrEmpty(pathField)) {
     */
            normalized = normalized.substring(0, normalized.length() - pathSeparator.length());
import org.opensearch.core.common.Strings;
        if (firstWildcard >= 0) {
        }
    }
import org.opensearch.index.query.TermQueryBuilder;
                }
            return "_root";
 */
                ignoreFailure,
     * Visitor implementation for extracting hierarchical paths from queries
     */
 * The OpenSearch Contributors require contributions made to
        if (questionIndex >= 0 && (firstWildcard < 0 || questionIndex < firstWildcard)) {
            if (pathSeparator == null) {
            this.paths = paths;
                }
import java.nio.charset.StandardCharsets;
            return new HierarchicalRoutingSearchProcessor(
                if (pathField.equals(termsQuery.fieldName())) {
        @Override
                }
        return anchor.toString();
        public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
    /** The processor type identifier */
        /**
                    }
                    computedRouting.add(routingValue);
            }
    private final String pathSeparator;
import org.opensearch.search.pipeline.Processor;
    public SearchRequest processRequest(SearchRequest request) throws Exception {
            if (occur == BooleanClause.Occur.MUST || occur == BooleanClause.Occur.FILTER) {
        return normalized;
        int wildcardIndex = pattern.indexOf('*');
     */
        long hash = MurmurHash3.hash128(anchorBytes, 0, anchorBytes.length, 0, new MurmurHash3.Hash128()).h1;
            return pattern.substring(0, firstWildcard);
            if (Strings.isNullOrEmpty(pathSeparator)) {
        while (normalized.endsWith(pathSeparator)) {
    private final java.util.regex.Pattern multiSeparatorPattern;
            );
         * @param ignoreFailure whether to ignore failures
        }
     * Normalizes path by removing leading/trailing separators and
         * @throws Exception if configuration is invalid
            }
                return this;
                }
        boolean ignoreFailure,
     */
    }
        private final Set<String> paths;
import org.opensearch.index.query.QueryBuilder;
        @Override
                tag,
        return pattern; // No wildcards, return as-is
         *
public class HierarchicalRoutingSearchProcessor extends AbstractProcessor implements SearchRequestProcessor {
            // Set default path separator if not provided
                addedSegments++;
            if (anchorDepth <= 0) {
        // Replace multiple consecutive separators with single separator
                anchor.append(segments[i]);
    /**
