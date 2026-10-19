        public String resolve(LimiterRequestContext ctx) {
            return threadContext.getHeader(ActionConcurrencyLimitPlugin.TIER_HEADER);  
     * Routes a search to a partition by its shape: requests carrying aggregations go to the
    // -------------------------------------------------------------------------
        }
 * Returning {@code null} routes the request to the built-in {@code unknownPartition}, which
            case BY_HEADER:  
     * (reject-delay) behaviour.
    final class FixedPartitionResolver implements PartitionResolver {
    }
        }
    final class BySearchTypePartitionResolver implements PartitionResolver {  
     */  
     *   partition.resolver.bySearchType.aggregation = aggregation   # partition for agg searches
import org.opensearch.action.ActionRequest;
     * exactly (case-sensitive). Requests without the header, or with an unrecognised  
@FunctionalInterface
        }
        switch (resolverType) {
    String resolve(LimiterRequestContext ctx);
    /**  
     *   partition.resolver.bySearchType.filter      = filter        # partition for non-agg searches  
     * Returns the partition name for this request, or {@code null} to route to
        private final String filterPartition;
        public String resolve(LimiterRequestContext ctx) {
                return new ByHeaderPartitionResolver(resolverConfig, threadContext);
     * </pre>
 */  
    }  
        @Override  
            case BY_SEARCH_TYPE:
 * <p>  
     * {@code aggregation} partition, all other searches go to the {@code filter} partition.
 * compatible open source license.
    /**
     * from the thread context. The header value must match a configured partition name
     * (aggregations dominate cost). Non-search requests (e.g. {@code _msearch}, or a non-search  
package org.opensearch.concurrency;
     * A request that has both a query and aggregations is classed as {@code aggregation}
     * Reads the {@link ActionConcurrencyLimitPlugin#TIER_HEADER X-Request-Tier} header
     * Always routes every request to the same partition. Useful for testing or for
     * @param resolverType  the resolver type enum  
        @Override
     *
        FixedPartitionResolver(Settings config) {
     * <p>
 * this file be licensed under the Apache-2.0 license or a
    final class ByHeaderPartitionResolver implements PartitionResolver {  
            this.threadContext = threadContext;
 */  
                return ctx -> null;
     * Inspects the {@link SearchRequest} directly on the coordinator — no client header required.  
     * <pre>
            return partition;
     * {@code unknownPartition}.  
    static PartitionResolver build(ConcurrencyLimitResolverType resolverType, Settings resolverConfig, ThreadContext threadContext) {
        }
/**
    }
            return hasAggs ? aggregationPartition : filterPartition;
 * Maps an incoming request to a partition name for use with the partitioned concurrency limiter.
        ByHeaderPartitionResolver(Settings config, ThreadContext threadContext) {  
    /**
 * holds any unallocated share of the total limit.
            this.aggregationPartition = config.get("aggregation", "aggregation");
            ActionRequest req = ctx.request();
import org.opensearch.common.settings.Settings;  
 * SPDX-License-Identifier: Apache-2.0
     * @param ctx the request context
     * Configuration:  
        private final String partition;  
            boolean hasAggs = source != null && source.aggregations() != null && source.aggregations().count() > 0;
     * Factory — creates the appropriate resolver from the alias configuration.
                return new FixedPartitionResolver(resolverConfig);  
        @Override  
/*  
     * <p>
     */
        }
            default:  
    /**  
            case FIXED:
public interface PartitionResolver {
                return null;  // not a search → unknownPartition
import org.opensearch.action.search.SearchRequest;
 *
     * @param threadContext  request-scoped thread context (used by {@code byHeader} resolver)
        }  
     * value, fall through to {@code unknownPartition}.
import org.opensearch.common.util.concurrent.ThreadContext;
        private final ThreadContext threadContext;
            this.filterPartition = config.get("filter", "filter");  
                return new BySearchTypePartitionResolver(resolverConfig);
     */
    // Built-in implementations  
    /**  
     * single-partition deployments where partitioning is used only for the delay  
import org.opensearch.search.builder.SearchSourceBuilder;
    // -------------------------------------------------------------------------
}
        BySearchTypePartitionResolver(Settings config) {
     *
     * <p>
     * action) resolve to {@code null} → {@code unknownPartition}.
            SearchSourceBuilder source = ((SearchRequest) req).source();  
     * @param resolverConfig sub-settings under {@code partition.resolver.<type>.*}
            }
        private final String aggregationPartition;
        public String resolve(LimiterRequestContext ctx) {
    }
     */  
            this.partition = config.get("partition", "default");  
     * Configuration: {@code partition.resolver.fixed.partition = premium}  
        }  
 * The OpenSearch Contributors require contributions made to  
            if (!(req instanceof SearchRequest)) {  
     */
