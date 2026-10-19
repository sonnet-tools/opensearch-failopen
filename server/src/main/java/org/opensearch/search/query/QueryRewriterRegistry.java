                QueryBuilder rewritten = rewriter.rewrite(current, context);
import java.util.Comparator;  
        clusterSettings.addSettingsUpdateConsumer(  
 * @opensearch.internal
        for (QueryRewriter rewriter : sortedRewriters) {  
                    current = rewritten;
 * compatible open source license.
    private final CopyOnWriteArrayList<QueryRewriter> rewriters;
        QueryBuilder current = query;
        registerRewriter(BooleanFlatteningRewriter.INSTANCE);  
        }  
        if (!enabled || query == null) {
    public void registerRewriter(QueryRewriter rewriter) {  
    }  
    /**
    private volatile boolean enabled;  
     * Initialize the registry with cluster settings.
                logger.warn("Query rewriter {} failed: {}", rewriter.name(), e.getMessage());
import org.opensearch.search.query.rewriters.MustNotToShouldRewriter;
import java.util.concurrent.CopyOnWriteArrayList;
     */
import org.opensearch.common.settings.ClusterSettings;  
        sortedRewriters.sort(Comparator.comparingInt(QueryRewriter::priority));  
    /**  
     * @param settings Initial cluster settings  
import org.opensearch.index.query.QueryBuilder;
     * This must be called once during system startup to properly configure  
 *
     * Register a custom query rewriter.
        this.enabled = SearchService.QUERY_REWRITING_ENABLED_SETTING.get(settings);
import org.apache.logging.log4j.Logger;
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
        registerRewriter(MustToFilterRewriter.INSTANCE);
    /**
import java.util.List;
        this.rewriters = new CopyOnWriteArrayList<>();  
            SearchService.QUERY_REWRITING_ENABLED_SETTING,
/**
            }
    /**  
import org.opensearch.common.settings.Settings;
        // Register default rewriters using singletons
}
package org.opensearch.search.query;
     */
     *  
            try {
import org.opensearch.index.query.QueryShardContext;  
        );  
        registerRewriter(MustNotToShouldRewriter.INSTANCE);
    public static final QueryRewriterRegistry INSTANCE = new QueryRewriterRegistry();
import org.opensearch.search.query.rewriters.TermsMergingRewriter;  
import org.opensearch.search.query.rewriters.BooleanFlatteningRewriter;
    private static final Logger logger = LogManager.getLogger(QueryRewriterRegistry.class);
        }  
public final class QueryRewriterRegistry {  
     * CopyOnWriteArrayList is used for thread-safety during registration.
     */
     * Default rewriters.
            return query;
/*  
    public void initialize(Settings settings, ClusterSettings clusterSettings) {  
                if (rewritten != current) {  
     * @param clusterSettings Cluster settings for registering update consumers
 *  
 * this file be licensed under the Apache-2.0 license or a
    }
            logger.debug("Registered query rewriter: {}", rewriter.name());  
 */
    private QueryRewriterRegistry() {
import org.opensearch.search.SearchService;
import org.apache.logging.log4j.LogManager;
     */  
     * Whether query rewriting is enabled.
 */  
     * the TermsMergingRewriter with settings and update consumers.
    }
        if (rewriter != null) {
            rewriters.add(rewriter);
                }
            } catch (Exception e) {  
        return current;
 * Registry for query rewriters
        registerRewriter(MatchAllRemovalRewriter.INSTANCE);  
import org.opensearch.search.query.rewriters.MustToFilterRewriter;
import org.opensearch.search.query.rewriters.MatchAllRemovalRewriter;  
        List<QueryRewriter> sortedRewriters = new ArrayList<>(rewriters);
    public QueryBuilder rewrite(QueryBuilder query, QueryShardContext context) {  
    }
            (Boolean enabled) -> this.enabled = enabled
     * @param rewriter The rewriter to register
 * SPDX-License-Identifier: Apache-2.0
        registerRewriter(TermsMergingRewriter.INSTANCE);
     *
        TermsMergingRewriter.INSTANCE.initialize(settings, clusterSettings);
        }
