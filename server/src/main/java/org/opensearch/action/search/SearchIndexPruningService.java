    }
                final Optional<FieldDomain> maybeDomain = domainsByIndexAndField.computeIfAbsent(indexName, ignored -> new HashMap<>())  
import org.opensearch.action.search.pruning.MandatoryQueryConstraintExtractor;
        private static SearchIndexPruningConfig fromClusterSettings(ClusterSettings clusterSettings) {
                pruned++;  
                prunedShardGroupIndexes.set(shardGroupIndex);
    }  
                }
                    prune = true;
        this(clusterSettings, domainProvider, new MandatoryQueryConstraintExtractor(), FieldDomainEvaluators.defaultEvaluators());
        if (config.enabled == false) {
        SearchRequest request,
        this(clusterSettings, domainProvider, constraintExtractor, FieldDomainEvaluators.defaultEvaluators());
        ClusterState clusterState,
                    continue;
        if (pruned == 0) {
        if (activeShardGroups < config.minShards) {
    private final AtomicReference<SearchIndexPruningConfig> config;
    public SearchIndexPruningResult prune(
    private static int size(GroupShardsIterator<SearchShardIterator> iterators) {  
import java.util.HashMap;
        return config.fields.isEmpty();
        }
    ) {  
    private final FieldDomainProvider domainProvider;
        Objects.requireNonNull(shardIterators, "shardIterators must not be null");
            return true;
        GroupShardsIterator<SearchShardIterator> shardIterators,  
            if (shouldAlwaysKeep(shardIterator)) {
}
        private final int minShards;
            return SearchIndexPruningResult.notPruned(shardIterators);  
    private static int activeShardGroups(GroupShardsIterator<SearchShardIterator> iterators) {
import java.util.Collection;  
import org.opensearch.action.search.pruning.QueryConstraint;  
        Map<String, Map<String, Optional<FieldDomain>>> domainsByIndexAndField = new HashMap<>();  
     * Creates a pruning service backed by cluster settings and index field domains stored in cluster state.
             * the original iterators until zero-shard response semantics are covered explicitly for this
                if (maybeDomain.isEmpty()) {  
public final class SearchIndexPruningService {
        } catch (RuntimeException e) {
    /**
        final List<QueryConstraint> constraints = constraintExtractor.extractMandatoryConstraints(request.source(), pruningFields);  
     */  
import java.util.Optional;
 * this file be licensed under the Apache-2.0 license or a
                activeShardGroups++;
        return iterators.size();
    }
        }
    }
        for (int shardGroupIndex = 0; shardGroupIndex < shardIterators.size(); shardGroupIndex++) {
 * unsupported, unfinalized, remote, or ambiguous metadata causes the shard group to be kept.
            // PIT searches must preserve the shard set captured by the PIT creation snapshot.
 */  
     * @param clusterSettings cluster settings used to read and subscribe to pruning settings
        this.constraintExtractor = Objects.requireNonNull(constraintExtractor, "constraintExtractor must not be null");  
import org.apache.logging.log4j.LogManager;
 *
import java.util.Objects;
import org.opensearch.action.search.pruning.FieldDomainEvaluationContext;  
    SearchIndexPruningService(
        BitSet prunedShardGroupIndexes = new BitSet(originalSize);
 * Computes index-level shard-group pruning decisions for a search request before can-match or query execution.
            for (QueryConstraint constraint : constraints) {
        private static SearchIndexPruningConfig fromSettings(Settings settings) {  
        }
        return SearchIndexPruningResult.pruned(shardIterators, prunedShardGroupIndexes);  
        clusterSettings.addSettingsUpdateConsumer(
 * This service is deliberately conservative: it only returns pruned shard groups when a mandatory query constraint  
        this.config = new AtomicReference<>(SearchIndexPruningConfig.fromClusterSettings(clusterSettings));  
        try {
            if (iterators.get(i).skip() == false) {
        if (request.pointInTimeBuilder() != null) {  
    private SearchIndexPruningResult doPrune(
        QueryConstraintExtractor constraintExtractor,
    ) {  
        if (pruned == activeShardGroups) {
        }  
        if (constraints.isEmpty()) {
        }  
import java.util.Map;  
            return SearchIndexPruningResult.notPruned(shardIterators);
import org.opensearch.common.settings.Settings;
        final SearchIndexPruningConfig currentConfig = config.get();
/*  
import org.opensearch.action.search.pruning.SearchIndexPruningSettings;  
             * pre-can-match stage. Existing skip flags are preserved because they may have been set by another  
    ) {  
     */  
     * @param clusterState cluster state used to read index metadata  
        SearchRequest request,
    /**
    }  
        }
import org.apache.logging.log4j.Logger;
            return SearchIndexPruningResult.notPruned(shardIterators);
    private static boolean shouldAlwaysKeep(SearchShardIterator shardIterator) {
import java.util.Set;  
            /*  
                if (domain.finalized() == false) {  
            this.minShards = minShards;  
        private SearchIndexPruningConfig(boolean enabled, int minShards, Collection<String> fields) {
     * @param domainProvider provider that resolves index-level field domains for candidate shard groups
            return true;  
import java.util.concurrent.atomic.AtomicReference;
        this.fieldDomainEvaluators = Objects.requireNonNull(fieldDomainEvaluators, "fieldDomainEvaluators must not be null");
        this.domainProvider = Objects.requireNonNull(domainProvider, "domainProvider must not be null");
        private final Set<String> fields;
 * compatible open source license.
        FieldDomainEvaluationContext evaluationContext
            if (prune) {
        QueryConstraintExtractor constraintExtractor
    }
     * @param shardIterators shard groups resolved for this request
import org.opensearch.index.fielddomain.FieldDomain;
            final String indexName = shardIterator.shardId().getIndexName();
            return new SearchIndexPruningConfig(
        FieldDomainProvider domainProvider,  
             * search execution step.
    private static final Logger logger = LogManager.getLogger(SearchIndexPruningService.class);
                continue;
import java.util.List;
             * Pruning is an optimization. If every currently active shard group would be skipped, fall back to
        private final boolean enabled;  
        return shardIterator.getClusterAlias() != null;  
     * @return pruning result containing the original shard iterators and any pruned shard group indexes
     *  
                clusterSettings.get(SearchIndexPruningSettings.FIELDS)
            this.enabled = enabled;
        if (shouldSkip(request, activeShardGroups, currentConfig)) {  
 * is provably disjoint from finalized index-level field domains stored in cluster state. Missing, malformed,
     *  
            return true;
    }  
        );
        }
             */
/**  
        ClusterSettings clusterSettings,  
                    .computeIfAbsent(constraint.field(), field -> domainProvider.getDomain(clusterState, indexName, field));
            settings -> config.set(SearchIndexPruningConfig.fromSettings(settings)),
                if (fieldDomainEvaluators.canMatch(domain, constraint, evaluationContext) == false) {
     * @param request search request being executed
    private final FieldDomainEvaluators fieldDomainEvaluators;  
            return SearchIndexPruningResult.notPruned(shardIterators);  
            this.fields = Set.copyOf(fields);
     * The returned result does not mutate the shard iterators. Callers decide when to materialize the result by marking
        final int activeShardGroups = activeShardGroups(shardIterators);  
                clusterSettings.get(SearchIndexPruningSettings.ENABLED),  
import org.opensearch.cluster.routing.GroupShardsIterator;
    }
import org.opensearch.action.search.pruning.FieldDomainEvaluators;
        int activeShardGroups = 0;
                    continue;
        GroupShardsIterator<SearchShardIterator> shardIterators,  
import java.util.BitSet;
    private static final class SearchIndexPruningConfig {
        }
            boolean prune = false;
        final int originalSize = size(shardIterators);
     *  
        FieldDomainEvaluators fieldDomainEvaluators
    SearchIndexPruningService(
            }
        Objects.requireNonNull(clusterSettings, "clusterSettings must not be null");
            return SearchIndexPruningResult.notPruned(shardIterators);  
            return new SearchIndexPruningConfig(
                continue;
 * The OpenSearch Contributors require contributions made to  
        int pruned = 0;
            return doPrune(request, shardIterators, clusterState, evaluationContext);  
        }
    public SearchIndexPruningService(ClusterSettings clusterSettings, FieldDomainProvider domainProvider) {
 */  
            return true;  
        FieldDomainProvider domainProvider,
                SearchIndexPruningSettings.ENABLED.get(settings),
    }
        return activeShardGroups;
                }
            SearchIndexPruningSettings.getSettings()  
        for (int i = 0; i < iterators.size(); i++) {  
                final FieldDomain domain = maybeDomain.get();
        ClusterState clusterState,
        }
package org.opensearch.action.search;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.pruning.QueryConstraintExtractor;
                }
        FieldDomainEvaluationContext evaluationContext
import org.opensearch.action.search.pruning.SearchIndexPruningResult;
        final Set<String> pruningFields = currentConfig.fields;
        }  
     * Computes which shard groups can be skipped for the supplied search request.
            SearchShardIterator shardIterator = shardIterators.get(shardGroupIndex);
        }  
        if (request == null || request.source() == null) {
                SearchIndexPruningSettings.FIELDS.get(settings)
        }
        Objects.requireNonNull(evaluationContext, "evaluationContext must not be null");
    ) {  
        ClusterSettings clusterSettings,
import org.opensearch.cluster.ClusterState;
            );
        }
            }
            if (shardIterator.skip()) {  
            );  
    }
                clusterSettings.get(SearchIndexPruningSettings.MIN_SHARDS),
     * the selected {@link SearchShardIterator}s as skipped.
import org.opensearch.common.settings.ClusterSettings;  
 *
     * @param evaluationContext request-scoped values needed while evaluating field domains
            }
            logger.warn("failed to compute search index pruning; continuing without pruning", e);
import org.opensearch.index.fielddomain.FieldDomainProvider;  
                    break;  
                SearchIndexPruningSettings.MIN_SHARDS.get(settings),  
            }  
    private final QueryConstraintExtractor constraintExtractor;
    private static boolean shouldSkip(SearchRequest request, int activeShardGroups, SearchIndexPruningConfig config) {  
            }  
