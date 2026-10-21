            Map.of("logs-000001", Optional.empty(), "logs-000002", Optional.of(domain(false, false)))
    }
public class SearchIndexPruningServiceTests extends OpenSearchTestCase {
    private static ClusterSettings clusterSettings() {
        }
        return shardIterator(null, index, shardId);
        private TestFieldDomain(String field) {
            return field;
        assertTrue(result.pruned());
        return (source, fields) -> fields.contains(FIELD) ? List.of(new TestQueryConstraint(FIELD)) : List.of();
            null,
import org.opensearch.action.search.pruning.QueryConstraintExtractor;
            metadata.put(metadataEntry, false);
        SearchIndexPruningService service = serviceWithDomains(
import java.util.concurrent.atomic.AtomicInteger;
            if (pruningResult.isPrunedShardGroup(shardGroupIndex)) {
        assertFalse(matchingIndex.skip());
            .putList(SearchIndexPruningSettings.FIELDS.getKey(), fields)
        return new SearchShardIterator(
    private static QueryConstraintExtractor genericConstraintExtractor() {
        assertFalse(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).pruned());
            .put(SearchIndexPruningSettings.MIN_SHARDS.getKey(), minShards)
    }
        for (int shardGroupIndex = 0; shardGroupIndex < pruningResult.originalShardGroups(); shardGroupIndex++) {
    }
        Settings settings = Settings.builder()
        SearchRequest request = searchRequest();
        ClusterState clusterState = clusterState(
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;
        public String type() {
            evaluationContext()
import static org.hamcrest.Matchers.equalTo;
    private static FieldDomainEvaluationContext evaluationContext() {
        }
            .settings(
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(true)))
        );
        assertFalse(result.pruned());
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        alreadySkipped.resetAndSkip();
    }
        AtomicInteger lookups = new AtomicInteger();
        }
            indexMetadata("logs-000001", new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test")),
        return serviceWithDomains(clusterSettings(), domainsByIndex);
        SearchShardIterator shardIterator = shardIterator("logs-000001", 0);
            return field;
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        public String field() {
    }
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);
 * SPDX-License-Identifier: Apache-2.0
            .numberOfReplicas(0);
        );
            genericConstraintExtractor(),
        Map<String, Optional<FieldDomain>> domainsByIndex
        assertThat(result.prunedShardGroups(), equalTo(1));
            this.canMatch = canMatch;
        return indexMetadataBuilder(index).build();
            null
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.action.search.pruning.FieldDomainEvaluators;
        SearchShardIterator activeCandidate = shardIterator("logs-000002", 0);
        assertFalse(result.isPrunedShardGroup(1));
            return Optional.of(new TestFieldDomain(field));
import org.opensearch.action.search.pruning.FieldDomainEvaluationContext;
        assertTrue(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).isPrunedShardGroup(0));
import org.opensearch.cluster.metadata.IndexMetadata;
    private static SearchShardIterator shardIterator(String clusterAlias, String index, int shardId) {
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(true)))
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.containsAll(SearchIndexPruningSettings.getSettings()));
        return new SearchIndexPruningService(clusterSettings, provider, genericConstraintExtractor(), genericEvaluators());
        assertFalse(result.isPrunedShardGroup(1));
import java.util.List;
    }
    private static TestFieldDomain domain(boolean finalized, boolean canMatch) {
            provider,
        assertFalse(matchingIndex.skip());
    }
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(alreadySkipped, activeCandidate));
        @Override
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
    public void testPruningSettingsAreRegisteredAsBuiltInClusterSettings() {
    public void testKeepsShardGroupsWhenDomainIsMissingOrUnfinalized() {
}
            indexMetadata("logs-000002", new DateRangeFieldDomain("@timestamp", 350L, 450L, true, "test"))
        );
import org.opensearch.index.fielddomain.FieldDomain;
        clusterSettings.applySettings(pruningSettings(true, 1, "event.ingested"));
        assertThat(lookups.get(), equalTo(0));
    private static FieldDomainEvaluators genericEvaluators() {
        clusterSettings.applySettings(pruningSettings(true, 1, FIELD));
 *
    }
import org.opensearch.search.builder.SearchSourceBuilder;
            .build();
    }
                pruningResult.shardIterators().get(shardGroupIndex).resetAndSkip();
        );
    public void testKeepsRemoteShardGroups() {
        return domain(true, canMatch);
            Map.of("logs-000001", Optional.empty(), "logs-000002", Optional.of(domain(false)))
    private static SearchRequest dateRangeSearchRequest(long from, long to) {
 * compatible open source license.
    }
        );
            lookups.incrementAndGet();
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(shardIterator));
        private final String field;
    private static Settings pruningSettings(boolean enabled, int minShards, String... fields) {
        assertFalse(result.pruned());
            lookups.incrementAndGet();
        assertFalse(second.skip());
        return IndexFieldDomainMetadata.getInstance().putFieldDomain(plainIndexMetadata(index), domain);
        );
    public void testMinShardThresholdUsesActiveShardGroups() {
        assertThat(result.originalShardGroups(), equalTo(2));
        };
        assertThat(lookups.get(), equalTo(1));
        private TestFieldDomain(String field, boolean finalized, boolean canMatch) {
        assertFalse(result.isPrunedShardGroup(0));
        );
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
            .put(SearchIndexPruningSettings.ENABLED.getKey(), enabled)
        };
    private static ClusterSettings clusterSettings(Settings settings) {
        assertFalse(result.pruned());
            .numberOfShards(1)
import org.opensearch.index.fielddomain.ClusterStateFieldDomainProvider;
    private static final class TestQueryConstraint implements QueryConstraint {
        return ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).build();
import org.opensearch.cluster.routing.GroupShardsIterator;
        SearchShardIterator unfinalizedDomain = shardIterator("logs-000002", 0);
    }
        clusterSettings.applySettings(pruningSettings(true, 1, FIELD));
        assertFalse(missingMetadata.skip());
    ) {
            .build();
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(first, second));
        SearchShardIterator localIndex = shardIterator("logs-000002", 0);
    private static SearchRequest searchRequest() {
    }
        );
            clusterSettings,
        }
    }
                Settings.builder()
            lookups.incrementAndGet();
        assertFalse(matchingIndex.skip());
        private boolean canMatch() {
        assertFalse(localIndex.skip());
        assertTrue(result.isPrunedShardGroup(0));
        assertTrue(result.pruned());
    private static IndexMetadata.Builder indexMetadataBuilder(String index) {
            this.finalized = finalized;
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(
    private static void applyPruningResult(SearchIndexPruningResult pruningResult) {
        assertTrue(oldIndex.skip());
        AtomicInteger lookups = new AtomicInteger();
import org.opensearch.action.search.pruning.SearchIndexPruningResult;
            List.of(shardIterator("logs-000001", 0), shardIterator("logs-000002", 0))
            new ShardId(index, "_na_", shardId),
        assertFalse(activeCandidate.skip());
        private final boolean finalized;
        }
    }
        SearchShardIterator activeCandidate = shardIterator("logs-000002", 0);
    private static SearchIndexPruningService serviceWithDomains(Map<String, Optional<FieldDomain>> domainsByIndex) {
 */
import org.opensearch.cluster.ClusterName;
            .putList(SearchIndexPruningSettings.FIELDS.getKey(), FIELD)
import org.opensearch.action.search.pruning.QueryConstraint;
        SearchShardIterator matchingIndex = shardIterator("logs-000002", 0);
        clusterSettings.applySettings(pruningSettings(true, 3, FIELD));
        FieldDomainProvider provider = (clusterState, indexName, field) -> {
        private TestQueryConstraint(String field) {
        assertThat(result.originalShardGroups(), equalTo(1));
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(alreadySkipped, activeCandidate));
            clusterSettings(),
        clusterSettings.applySettings(pruningSettings(false, 1, FIELD));
        assertTrue(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).isPrunedShardGroup(0));
    public void testAppliesDynamicPruningSettingsAsConsistentConfigSnapshot() {
        SearchShardIterator alreadySkipped = shardIterator("logs-000001", 0);
/*
        assertTrue(alreadySkipped.skip());
        assertThat(result.prunedShardGroups(), equalTo(0));
        public boolean finalized() {
        assertFalse(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).pruned());
        );
    }
    }
            this.field = field;
        assertTrue(result.pruned());
        assertFalse(oldIndex.skip());
    }
    private static SearchShardIterator shardIterator(String index, int shardId) {
            dateRangeSearchRequest(300L, 400L),
        SearchShardIterator remoteIndex = shardIterator("remote-cluster", "logs-000001", 0);
        SearchIndexPruningService service = serviceWithDomains(
    public void testCachesBoundsLookupPerIndexAndFieldDuringSinglePruningPass() {
import org.opensearch.action.search.pruning.SearchIndexPruningSettings;
        assertFalse(result.pruned());
    public void testPruneIsFailOpenWhenDomainProviderThrows() {
        );
            throw new IllegalStateException("exception");
        SearchIndexPruningService service = serviceWithDomains(
        QueryConstraintExtractor extractor = (source, fields) -> List.of(new TestQueryConstraint(FIELD));
        @Override
            .build();
        FieldDomainEvaluators evaluators = new FieldDomainEvaluators(List.of((bounds, constraint, context) -> false));
import org.opensearch.cluster.ClusterState;
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(oldIndex, matchingIndex));
        SearchShardIterator alreadySkipped = shardIterator("logs-000001", 0);
        assertFalse(result.pruned());
        );
            genericEvaluators()
        assertTrue(result.isPrunedShardGroup(1));
            .put(SearchIndexPruningSettings.MIN_SHARDS.getKey(), 1)
        return clusterSettings(settings);
    private static final class TestFieldDomain implements FieldDomain {
            genericConstraintExtractor(),
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(true)))
        FieldDomainProvider provider = (clusterState, indexName, field) -> {
import org.opensearch.test.OpenSearchTestCase;
    public void testFallsBackWhenAllActiveShardGroupsWouldBePrunedAndPreservesExistingSkips() {
        );
        SearchShardIterator oldIndex = shardIterator("logs-000001", 0);
        Metadata.Builder metadata = Metadata.builder();
        };
    }
    }
import org.opensearch.common.settings.ClusterSettings;
        for (IndexMetadata metadataEntry : indexMetadata) {
    }
        alreadySkipped.resetAndSkip();
            return Optional.of(domain(false));
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
            this(field, true, true);
        SearchShardIterator missingMetadata = shardIterator("logs-000001", 0);
        SearchIndexPruningService service = new SearchIndexPruningService(
    }
        );
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
        assertFalse(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).pruned());
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        Set<Setting<?>> builtInSettings = Set.copyOf(SearchIndexPruningSettings.getSettings());
        return new FieldDomainEvaluationContext(() -> 0L);
            genericEvaluators()
import org.opensearch.common.settings.Settings;
import org.opensearch.action.OriginalIndices;
        assertFalse(result.pruned());
        assertFalse(first.skip());
        return Settings.builder()
        return IndexMetadata.builder(index)
import org.opensearch.common.settings.Setting;
                    .build()
        private final boolean canMatch;
    private static ClusterSettings dateClusterSettings() {
        SearchIndexPruningService service = serviceWithDomains(
    }
        assertFalse(shardIterator.skip());
            clusterSettings(pruningSettings(true, 2, FIELD)),
package org.opensearch.action.search;
        return new TestFieldDomain(FIELD, finalized, canMatch);
        );
        }
import java.util.Optional;
        return new SearchRequest().source(new SearchSourceBuilder());
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(remoteIndex, localIndex));
        }
        }
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(oldIndex, matchingIndex));
        SearchIndexPruningService service = serviceWithDomains(
        );
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(missingMetadata, unfinalizedDomain));
        SearchShardIterator oldIndex = shardIterator("logs-000001", 0);
        service.prune(new SearchRequest().source(new SearchSourceBuilder()), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
    }
            .put(SearchIndexPruningSettings.ENABLED.getKey(), true)
        public String field() {
    }
    public void testPrunesOnlyProvablyDisjointLocalShardGroups() {
            .put(SearchIndexPruningSettings.MIN_SHARDS.getKey(), 1)
    private static ClusterState clusterState(IndexMetadata... indexMetadata) {
        return new ClusterSettings(settings, builtInSettings);
        @Override
import org.opensearch.cluster.metadata.Metadata;
        ClusterSettings clusterSettings,
        SearchIndexPruningService service = new SearchIndexPruningService(dateClusterSettings(), new ClusterStateFieldDomainProvider());
    }
        FieldDomainProvider provider = (clusterState, indexName, field) -> {
        assertFalse(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).pruned());
    public void testFallsBackWhenAllShardGroupsWouldBePruned() {
    }
import org.opensearch.search.builder.PointInTimeBuilder;
    private static TestFieldDomain domain(boolean canMatch) {
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(oldIndex, matchingIndex));
        applyPruningResult(result);
        Settings settings = Settings.builder()
        SearchShardIterator matchingIndex = shardIterator("logs-000002", 0);
            provider,
        SearchShardIterator matchingIndex = shardIterator("logs-000002", 0);
            clusterAlias,
            )
            List.of(shardIterator("logs-000001", 0), shardIterator("logs-000001", 1))
        SearchIndexPruningResult result = service.prune(
    }
    public void testDoesNotPrunePointInTimeSearches() {
            return "test";
    private static IndexMetadata indexMetadata(String index, DateRangeFieldDomain domain) {
        assertThat(result.prunedShardGroups(), equalTo(0));
                    .put(IndexMetadata.SETTING_INDEX_UUID, "_na_")
import java.util.Set;
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.fielddomain.FieldDomainProvider;
            return canMatch;
        return clusterSettings(settings);
        assertTrue(result.isPrunedShardGroup(0));
    }
            clusterState,
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(false)))
        request.source().pointInTimeBuilder(new PointInTimeBuilder("pit-id"));
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
        SearchShardIterator oldIndex = shardIterator("logs-000001", 0);
        SearchIndexPruningResult result = service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        SearchRequest request = searchRequest();
            .putList(SearchIndexPruningSettings.FIELDS.getKey(), "@timestamp")
        private final String field;
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
            this.field = field;
            }
        return new SearchRequest().source(new SearchSourceBuilder().query(QueryBuilders.rangeQuery("@timestamp").gte(from).lte(to)));
        SearchShardIterator first = shardIterator("logs-000001", 0);
    }
        SearchIndexPruningService service = new SearchIndexPruningService(clusterSettings(), provider, extractor, evaluators);
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(false)))
    }
            return finalized;
        }
 * this file be licensed under the Apache-2.0 license or a
        SearchIndexPruningService service = new SearchIndexPruningService(
    }
        SearchIndexPruningService service = serviceWithDomains(
        assertFalse(oldIndex.skip());
        return new FieldDomainEvaluators(
            shardIterators,
        @Override
import org.opensearch.Version;
    public void testWiresDateRangeMetadataFromClusterStateProvider() {
        FieldDomainProvider provider = (clusterState, indexName, field) -> domainsByIndex.getOrDefault(indexName, Optional.empty());
import org.opensearch.core.index.shard.ShardId;
    }
        assertFalse(remoteIndex.skip());
    private static final String FIELD = "field_a";
            .put(SearchIndexPruningSettings.ENABLED.getKey(), true)
    private static SearchIndexPruningService serviceWithDomains(
            List.of("node-1"),
        assertThat(lookups.get(), equalTo(1));
    private static IndexMetadata plainIndexMetadata(String index) {
        assertFalse(unfinalizedDomain.skip());
    }
        SearchIndexPruningService service = serviceWithDomains(
        AtomicInteger lookups = new AtomicInteger();
import java.util.Map;
            List.of((domain, constraint, context) -> domain instanceof TestFieldDomain ? ((TestFieldDomain) domain).canMatch() : true)
            OriginalIndices.NONE,
        SearchShardIterator second = shardIterator("logs-000002", 0);
