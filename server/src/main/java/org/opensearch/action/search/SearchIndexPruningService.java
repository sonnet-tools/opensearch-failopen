            this.enabled = enabled;
                activeShardGroups++;
                clusterSettings.get(SearchIndexPruningSettings.MIN_SHARDS),
 */
 * unsupported, unfinalized, remote, or ambiguous metadata causes the shard group to be kept.
        }
                    prune = true;
 *
    private SearchIndexPruningResult doPrune(
            }
        final List<QueryConstraint> constraints = constraintExtractor.extractMandatoryConstraints(request.source(), pruningFields);
                    continue;
    SearchIndexPruningService(
                SearchIndexPruningSettings.MIN_SHARDS.get(settings),
            return true;
    ) {
    /**
     *
import org.opensearch.action.search.pruning.QueryConstraintExtractor;
        return iterators.size();
import java.util.Objects;
        if (constraints.isEmpty()) {
        FieldDomainProvider domainProvider,
        }
                continue;
     * @param shardIterators shard groups resolved for this request
        FieldDomainEvaluationContext evaluationContext
        if (config.enabled == false) {
        GroupShardsIterator<SearchShardIterator> shardIterators,
        int activeShardGroups = 0;
    private static int size(GroupShardsIterator<SearchShardIterator> iterators) {
            }
     * The returned result does not mutate the shard iterators. Callers decide when to materialize the result by marking
                continue;
    }
 * compatible open source license.
     */
        private static SearchIndexPruningConfig fromClusterSettings(ClusterSettings clusterSettings) {
            this.minShards = minShards;
        this.fieldDomainEvaluators = Objects.requireNonNull(fieldDomainEvaluators, "fieldDomainEvaluators must not be null");
    }
            if (prune) {
                final FieldDomain domain = maybeDomain.get();
     */
    private final FieldDomainProvider domainProvider;
import java.util.HashMap;
        if (request.pointInTimeBuilder() != null) {
        final SearchIndexPruningConfig currentConfig = config.get();
    SearchIndexPruningService(
    private final FieldDomainEvaluators fieldDomainEvaluators;
                }
     * @param clusterState cluster state used to read index metadata
        }
                    break;
import org.opensearch.action.search.pruning.SearchIndexPruningSettings;
import java.util.Map;
            return SearchIndexPruningResult.notPruned(shardIterators);
            SearchIndexPruningSettings.getSettings()
            return SearchIndexPruningResult.notPruned(shardIterators);
import org.apache.logging.log4j.LogManager;
 */
        }
        private final boolean enabled;
    }
            );
import org.opensearch.action.search.pruning.SearchIndexPruningResult;
    }
                }
    private static boolean shouldAlwaysKeep(SearchShardIterator shardIterator) {
            }
            return new SearchIndexPruningConfig(
        QueryConstraintExtractor constraintExtractor
             * search execution step.
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.fielddomain.FieldDomain;
                SearchIndexPruningSettings.ENABLED.get(settings),
        final Set<String> pruningFields = currentConfig.fields;
        ClusterState clusterState,
public final class SearchIndexPruningService {
     * Creates a pruning service backed by cluster settings and index field domains stored in cluster state.
        Objects.requireNonNull(evaluationContext, "evaluationContext must not be null");
import org.apache.logging.log4j.Logger;
import java.util.Collection;
            );
        }
import org.opensearch.action.search.pruning.QueryConstraint;
        private static SearchIndexPruningConfig fromSettings(Settings settings) {
        }
                if (domain.finalized() == false) {
        return activeShardGroups;
 * The OpenSearch Contributors require contributions made to
        if (request == null || request.source() == null) {
import java.util.Set;
        return config.fields.isEmpty();
    }
            // PIT searches must preserve the shard set captured by the PIT creation snapshot.
    public SearchIndexPruningService(ClusterSettings clusterSettings, FieldDomainProvider domainProvider) {
     * @param domainProvider provider that resolves index-level field domains for candidate shard groups
            return new SearchIndexPruningConfig(
            for (QueryConstraint constraint : constraints) {
        }
                    .computeIfAbsent(constraint.field(), field -> domainProvider.getDomain(clusterState, indexName, field));
            return true;
import org.opensearch.common.settings.Settings;
 *
    }
    private final AtomicReference<SearchIndexPruningConfig> config;
        private final Set<String> fields;
                final Optional<FieldDomain> maybeDomain = domainsByIndexAndField.computeIfAbsent(indexName, ignored -> new HashMap<>())
        FieldDomainEvaluators fieldDomainEvaluators
        private SearchIndexPruningConfig(boolean enabled, int minShards, Collection<String> fields) {
        Map<String, Map<String, Optional<FieldDomain>>> domainsByIndexAndField = new HashMap<>();
                prunedShardGroupIndexes.set(shardGroupIndex);
import org.opensearch.index.fielddomain.FieldDomainProvider;
             */
                clusterSettings.get(SearchIndexPruningSettings.FIELDS)
 * is provably disjoint from finalized index-level field domains stored in cluster state. Missing, malformed,
package org.opensearch.action.search;
                clusterSettings.get(SearchIndexPruningSettings.ENABLED),
        clusterSettings.addSettingsUpdateConsumer(
            return true;
import org.opensearch.common.settings.ClusterSettings;
        this.constraintExtractor = Objects.requireNonNull(constraintExtractor, "constraintExtractor must not be null");
     * @param clusterSettings cluster settings used to read and subscribe to pruning settings
             * the original iterators until zero-shard response semantics are covered explicitly for this
        SearchRequest request,
import org.opensearch.action.search.pruning.FieldDomainEvaluators;
            SearchShardIterator shardIterator = shardIterators.get(shardGroupIndex);
 * SPDX-License-Identifier: Apache-2.0
        return SearchIndexPruningResult.pruned(shardIterators, prunedShardGroupIndexes);
        final int activeShardGroups = activeShardGroups(shardIterators);
        this(clusterSettings, domainProvider, constraintExtractor, FieldDomainEvaluators.defaultEvaluators());
        FieldDomainEvaluationContext evaluationContext
    private static int activeShardGroups(GroupShardsIterator<SearchShardIterator> iterators) {
        }
        Objects.requireNonNull(clusterSettings, "clusterSettings must not be null");
    ) {
import org.opensearch.cluster.routing.GroupShardsIterator;
                SearchIndexPruningSettings.FIELDS.get(settings)
import org.opensearch.cluster.ClusterState;
            this.fields = Set.copyOf(fields);
        FieldDomainProvider domainProvider,
     *
        }
        this.domainProvider = Objects.requireNonNull(domainProvider, "domainProvider must not be null");
     * Computes which shard groups can be skipped for the supplied search request.
            /*
        ClusterSettings clusterSettings,
     * @param request search request being executed
            logger.warn("failed to compute search index pruning; continuing without pruning", e);
    ) {
        ClusterSettings clusterSettings,
                pruned++;
            return SearchIndexPruningResult.notPruned(shardIterators);
import java.util.List;
import org.opensearch.action.search.pruning.FieldDomainEvaluationContext;
        }
        GroupShardsIterator<SearchShardIterator> shardIterators,
/**
        QueryConstraintExtractor constraintExtractor,
    /**
        this.config = new AtomicReference<>(SearchIndexPruningConfig.fromClusterSettings(clusterSettings));
        this(clusterSettings, domainProvider, new MandatoryQueryConstraintExtractor(), FieldDomainEvaluators.defaultEvaluators());
import org.opensearch.action.search.pruning.MandatoryQueryConstraintExtractor;
                if (fieldDomainEvaluators.canMatch(domain, constraint, evaluationContext) == false) {
        return shardIterator.getClusterAlias() != null;
    public SearchIndexPruningResult prune(
            return SearchIndexPruningResult.notPruned(shardIterators);
                if (maybeDomain.isEmpty()) {
            return doPrune(request, shardIterators, clusterState, evaluationContext);
                    continue;
        private final int minShards;
     * @return pruning result containing the original shard iterators and any pruned shard group indexes
            if (shardIterator.skip()) {
             * pre-can-match stage. Existing skip flags are preserved because they may have been set by another
        if (activeShardGroups < config.minShards) {
            boolean prune = false;
        if (pruned == 0) {
    private final QueryConstraintExtractor constraintExtractor;
    private static final Logger logger = LogManager.getLogger(SearchIndexPruningService.class);
    }
            return true;
import java.util.Optional;
}
        int pruned = 0;
/*
        ClusterState clusterState,
        } catch (RuntimeException e) {
 * This service is deliberately conservative: it only returns pruned shard groups when a mandatory query constraint
            if (shouldAlwaysKeep(shardIterator)) {
    private static boolean shouldSkip(SearchRequest request, int activeShardGroups, SearchIndexPruningConfig config) {
        );
        if (pruned == activeShardGroups) {
            return SearchIndexPruningResult.notPruned(shardIterators);
        }
 * Computes index-level shard-group pruning decisions for a search request before can-match or query execution.
import java.util.concurrent.atomic.AtomicReference;
        final int originalSize = size(shardIterators);
            settings -> config.set(SearchIndexPruningConfig.fromSettings(settings)),
        for (int i = 0; i < iterators.size(); i++) {
    }
             * Pruning is an optimization. If every currently active shard group would be skipped, fall back to
        Objects.requireNonNull(shardIterators, "shardIterators must not be null");
        }
            if (iterators.get(i).skip() == false) {
        BitSet prunedShardGroupIndexes = new BitSet(originalSize);
    private static final class SearchIndexPruningConfig {
     * @param evaluationContext request-scoped values needed while evaluating field domains
        for (int shardGroupIndex = 0; shardGroupIndex < shardIterators.size(); shardGroupIndex++) {
    }
                }
            }
import java.util.BitSet;
    }
        if (shouldSkip(request, activeShardGroups, currentConfig)) {
     * the selected {@link SearchShardIterator}s as skipped.
    ) {
            }
        SearchRequest request,
            final String indexName = shardIterator.shardId().getIndexName();
        }
        try {
     *
