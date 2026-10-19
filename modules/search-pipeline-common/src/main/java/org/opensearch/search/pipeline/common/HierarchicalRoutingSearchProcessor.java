                // Join multiple routing values with comma
    /** The processor type identifier */  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;  
    private final String pathSeparator;
        this.pathField = pathField;
            normalized = normalized.substring(0, normalized.length() - pathSeparator.length());  
            return pattern.substring(0, firstWildcard);  
                    anchor.append(pathSeparator);  
        return pattern; // No wildcards, return as-is  
    /**
     */
            // Validation  
        if (request.source() != null && request.source().query() != null) {
    private String computeRoutingValue(String path) {  
        PathExtractionVisitor(Set<String> paths) {
            // SHOULD and MUST_NOT don't guarantee document presence on specific shards
        return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
         * @return new HierarchicalRoutingSearchProcessor instance
        int effectiveDepth = Math.min(depth, segments.length);  
         * Creates a new HierarchicalRoutingSearchProcessor instance
        while (normalized.endsWith(pathSeparator)) {
                    paths.add(termQuery.value().toString());
         * Creates a new Factory instance  
        return TYPE;  
                }
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,  
            String pathField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "path_field");
            Set<String> computedRouting = new HashSet<>();
            }
        String pathSeparator,
    private String extractAnchor(String[] segments, int depth) {
 * this file be licensed under the Apache-2.0 license or a
                }
            return null;
    @Override
        Set<String> routingValues = new HashSet<>();
        /**
    /**  
            }
    /**
        // Use MurmurHash3 for consistent, fast hashing (same as ingest processor)  
         * @param processorFactories available processor factories
        // If no valid segments found, use a default
            if (!Strings.isNullOrEmpty(segments[i])) {
            }
    @Override  
}  
    private final int anchorDepth;
        String tag,
     * Computes routing value from path using same logic as ingest processor
import org.opensearch.index.query.TermQueryBuilder;
    public static final class Factory implements Processor.Factory<SearchRequestProcessor> {  
        this.anchorDepth = anchorDepth;  
                    String pathPrefix = extractPrefixFromWildcard(pattern);
                    String pattern = wildcardQuery.value();  
/**
    public String getType() {
     * Visitor implementation for extracting hierarchical paths from queries  
        while (normalized.startsWith(pathSeparator)) {  
                    }
            normalized = normalized.substring(pathSeparator.length());
    }
        this.enableAutoDetection = enableAutoDetection;
            if (Strings.isNullOrEmpty(pathField)) {  
        ) throws Exception {  
         * @throws Exception if configuration is invalid
            String tag,
    private final java.util.regex.Pattern multiSeparatorPattern;
        }
            request.source().query().visit(visitor);  
                if (pathField.equals(wildcardQuery.fieldName())) {
                throw newConfigurationException(TYPE, tag, "anchor_depth", "must be greater than 0");
                String routingValue = computeRoutingValue(path);
                    computedRouting.add(routingValue);  
        public Factory() {}
            firstWildcard = questionIndex;
    HierarchicalRoutingSearchProcessor(
import org.opensearch.search.pipeline.AbstractProcessor;  
            }  
            }
public class HierarchicalRoutingSearchProcessor extends AbstractProcessor implements SearchRequestProcessor {
        this.pathSeparator = pathSeparator;
     */
 * SPDX-License-Identifier: Apache-2.0
        }
            if (!computedRouting.isEmpty()) {
        boolean ignoreFailure,
         */
import org.opensearch.index.query.QueryBuilder;  
        this.multiSeparatorPattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(pathSeparator) + "{2,}");
        String normalized = path.trim();  
     */  
        public HierarchicalRoutingSearchProcessor create(
         */  
    }
        int wildcardIndex = pattern.indexOf('*');
     * Normalizes path by removing leading/trailing separators and
        if (request.routing() != null && !request.routing().isEmpty()) {  
                anchor.append(segments[i]);
        }
            return "_root";  
        String description,  
                pathSeparator = "/";  
            if (pathSeparator == null) {
            );  
 * that contain documents with matching path prefixes.
     */
        // Remove leading separators
                return this;  
    public SearchRequest processRequest(SearchRequest request) throws Exception {
        // If we found path information, compute routing and apply it  
                if (routingValue != null) {
     * Example: "/company/engineering/*" -> "/company/engineering"  
                enableAutoDetection
                anchorDepth,  
            Processor.PipelineContext pipelineContext
        @Override
        if (pattern == null) return null;  
            } else if (qb instanceof PrefixQueryBuilder prefixQuery) {  
                if (addedSegments > 0) {
                if (pathField.equals(prefixQuery.fieldName())) {
            if (anchorDepth <= 0) {
            if (qb instanceof TermQueryBuilder termQuery) {
                }
                throw newConfigurationException(TYPE, tag, "path_separator", "cannot be null or empty");  
 * based on hierarchical path information found in queries.
     */
         * @param config processor configuration
        return request;
    private String normalizePath(String path) {
        }
    }
            // Set default path separator if not provided
import org.opensearch.index.query.TermsQueryBuilder;  
            return new HierarchicalRoutingSearchProcessor(
        if (questionIndex >= 0 && (firstWildcard < 0 || questionIndex < firstWildcard)) {
import org.opensearch.ingest.ConfigurationUtils;
 * The OpenSearch Contributors require contributions made to  
        return anchor.toString();  
        // Replace multiple consecutive separators with single separator  
                String routing = String.join(",", computedRouting);  
     * collapsing multiple consecutive separators (same as ingest processor)  
 * This processor works in conjunction with the HierarchicalRoutingProcessor  
        /**
            boolean enableAutoDetection = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "enable_auto_detection", true);
 *  
            String pathSeparator = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "path_separator");
        }
import java.nio.charset.StandardCharsets;
                    }
        public void accept(QueryBuilder qb) {
        if (anchor.length() == 0) {
    public static final String TYPE = "hierarchical_routing_search";
package org.opensearch.search.pipeline.common;
import java.util.HashSet;
        }
        String normalizedPath = normalizePath(path);
    }
        int questionIndex = pattern.indexOf('?');  
        this.pathSeparatorPattern = java.util.regex.Pattern.compile(java.util.regex.Pattern.quote(pathSeparator));  
                    for (Object value : termsQuery.values()) {
    private final java.util.regex.Pattern pathSeparatorPattern;
            PathExtractionVisitor visitor = new PathExtractionVisitor(routingValues);
import org.opensearch.common.hash.MurmurHash3;  
import java.util.Map;  
/*  
     * Factory for creating HierarchicalRoutingSearchProcessor instances
        // Skip if routing is already explicitly set
    /**
                pathField,
                        paths.add(value.toString());  
 * compatible open source license.
            return request;
import org.opensearch.core.common.Strings;
        if (wildcardIndex >= 0) firstWildcard = wildcardIndex;  
        byte[] anchorBytes = anchor.getBytes(StandardCharsets.UTF_8);
        }  
 * search shards containing documents routed with "/company/engineering" prefix.
     * Extracts the stable prefix from a wildcard pattern
        }
        String pathField,
 * (ingest pipeline) to optimize searches by routing them only to shards
        public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
         * @param pipelineContext pipeline context  
        long hash = MurmurHash3.hash128(anchorBytes, 0, anchorBytes.length, 0, new MurmurHash3.Hash128()).h1;
         * @param tag processor tag
     * (same as ingest processor)
import org.opensearch.index.query.WildcardQueryBuilder;
        super(tag, description, ignoreFailure);
        if (firstWildcard >= 0) {
        boolean enableAutoDetection
        String anchor = extractAnchor(segments, anchorDepth);
        }
import org.opensearch.search.pipeline.SearchRequestProcessor;
        }  
                    if (pathPrefix != null && !pathPrefix.isEmpty()) {
                ignoreFailure,
    }  
                description,  
         *  
        // Remove trailing separators
            this.paths = paths;  
            boolean ignoreFailure,  
import org.apache.lucene.search.BooleanClause;
        int addedSegments = 0;
        String[] segments = pathSeparatorPattern.split(normalizedPath);  
    /**  
            // Return a no-op visitor for SHOULD and MUST_NOT clauses
        private final Set<String> paths;  
            return QueryBuilderVisitor.NO_OP_VISITOR;  
                if (pathField.equals(termQuery.fieldName())) {  
        normalized = multiSeparatorPattern.matcher(normalized).replaceAll(pathSeparator);
import org.opensearch.index.query.PrefixQueryBuilder;
            } else if (qb instanceof TermsQueryBuilder termsQuery) {  
        }
     * Extracts anchor from path segments using specified depth
    private String extractPrefixFromWildcard(String pattern) {
            }
import org.opensearch.index.query.QueryBuilderVisitor;
import org.opensearch.search.pipeline.Processor;
                if (pathField.equals(termsQuery.fieldName())) {
                pathSeparator,
        @Override  
            }  
            int anchorDepth = ConfigurationUtils.readIntProperty(TYPE, tag, config, "anchor_depth", 2);  
    private class PathExtractionVisitor implements QueryBuilderVisitor {
        int anchorDepth,  
        StringBuilder anchor = new StringBuilder();
            if (Strings.isNullOrEmpty(pathSeparator)) {
        }
                        paths.add(pathPrefix);  
            for (String path : routingValues) {  
            if (occur == BooleanClause.Occur.MUST || occur == BooleanClause.Occur.FILTER) {
        if (!routingValues.isEmpty()) {
                throw newConfigurationException(TYPE, tag, "path_field", "cannot be null or empty");
 * Example: A query with filter "path:/company/engineering/*" will only
            // The visitor pattern will automatically handle other query types
        return normalized;  
        if (Strings.isNullOrEmpty(path)) {
        }  
        }
     */
        @Override
            }
                addedSegments++;  
                tag,
                request.routing(routing);
                }  
    ) {  
        // Extract path information from the search request using visitor pattern  
    }
                }
        for (int i = 0; i < effectiveDepth && addedSegments < depth; i++) {  
         * @param ignoreFailure whether to ignore failures
        int firstWildcard = -1;
import org.opensearch.action.search.SearchRequest;
                    paths.add(prefixQuery.value());
 *
    }
            // Only process MUST and FILTER clauses as they restrict results  
            Map<String, Object> config,
         * @param description processor description  
                }
            } else if (qb instanceof WildcardQueryBuilder wildcardQuery) {
 *
            String description,
    }
    private final String pathField;  
    }
import java.util.Set;
 */  
    /**  
    private final boolean enableAutoDetection;  
 * A search request processor that automatically adds routing to search requests  
 */  
            }
