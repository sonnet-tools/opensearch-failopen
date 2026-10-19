        SearchIndexPruningService service = serviceWithDomains(  
import org.opensearch.search.builder.SearchSourceBuilder;
    private static FieldDomainEvaluationContext evaluationContext() {  
            dateRangeSearchRequest(300L, 400L),
        assertFalse(missingMetadata.skip());
 *
            this.field = field;
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        SearchIndexPruningService service = serviceWithDomains(
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());  
        assertThat(result.originalShardGroups(), equalTo(2));
import org.opensearch.action.search.pruning.SearchIndexPruningSettings;
        assertFalse(result.pruned());
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(
        );
    }
        @Override  
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(alreadySkipped, activeCandidate));
import java.util.List;
    public void testFallsBackWhenAllActiveShardGroupsWouldBePrunedAndPreservesExistingSkips() {  
/*  
        assertFalse(matchingIndex.skip());  
import org.opensearch.index.fielddomain.IndexFieldDomainMetadata;
        alreadySkipped.resetAndSkip();  
    private static QueryConstraintExtractor genericConstraintExtractor() {
package org.opensearch.action.search;
    private static final String FIELD = "field_a";
import org.opensearch.action.search.pruning.SearchIndexPruningResult;
        private final String field;  
        alreadySkipped.resetAndSkip();  
    }
    private static TestFieldDomain domain(boolean finalized, boolean canMatch) {
    private static TestFieldDomain domain(boolean canMatch) {  
        );
        assertTrue(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).isPrunedShardGroup(0));  
            }
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(oldIndex, matchingIndex));
            genericConstraintExtractor(),  
            List.of(shardIterator("logs-000001", 0), shardIterator("logs-000001", 1))
                    .put(IndexMetadata.SETTING_INDEX_UUID, "_na_")
        SearchIndexPruningService service = new SearchIndexPruningService(dateClusterSettings(), new ClusterStateFieldDomainProvider());
import org.opensearch.cluster.routing.GroupShardsIterator;
            OriginalIndices.NONE,  
            this(field, true, true);  
        assertTrue(alreadySkipped.skip());
            genericConstraintExtractor(),
    }  
        FieldDomainProvider provider = (clusterState, indexName, field) -> {
        }
        assertThat(result.prunedShardGroups(), equalTo(0));
        SearchRequest request = searchRequest();
        assertThat(lookups.get(), equalTo(1));
        public String type() {  
            evaluationContext()
        Metadata.Builder metadata = Metadata.builder();  
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(shardIterator));
        return new FieldDomainEvaluators(
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());  
        clusterSettings.applySettings(pruningSettings(true, 1, FIELD));
        Settings settings = Settings.builder()
        SearchShardIterator oldIndex = shardIterator("logs-000001", 0);
    private static SearchIndexPruningService serviceWithDomains(  
    private static final class TestQueryConstraint implements QueryConstraint {
        SearchIndexPruningService service = serviceWithDomains(
    private static ClusterSettings clusterSettings(Settings settings) {
            return Optional.of(domain(false));
        AtomicInteger lookups = new AtomicInteger();  
    }  
    private static IndexMetadata.Builder indexMetadataBuilder(String index) {  
            .put(SearchIndexPruningSettings.MIN_SHARDS.getKey(), 1)
        clusterSettings.applySettings(pruningSettings(true, 3, FIELD));
        );
        );  
            .putList(SearchIndexPruningSettings.FIELDS.getKey(), fields)
        );
    }
import java.util.Set;
import org.opensearch.action.search.pruning.QueryConstraintExtractor;  
        FieldDomainProvider provider = (clusterState, indexName, field) -> {
        @Override  
    }  
            return finalized;  
    }
        SearchIndexPruningService service = serviceWithDomains(
            clusterSettings(pruningSettings(true, 2, FIELD)),
            genericEvaluators()
        }
            return "test";
import static org.hamcrest.Matchers.equalTo;
        private final boolean canMatch;  
        private final String field;
        assertFalse(oldIndex.skip());
        }
            .put(SearchIndexPruningSettings.ENABLED.getKey(), true)  
import org.opensearch.cluster.metadata.Metadata;  
        return Settings.builder()
            .settings(
    }
    private static SearchRequest searchRequest() {
            List.of(shardIterator("logs-000001", 0), shardIterator("logs-000002", 0))
    private static SearchIndexPruningService serviceWithDomains(Map<String, Optional<FieldDomain>> domainsByIndex) {
        ClusterState clusterState = clusterState(
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(
    }
            .put(SearchIndexPruningSettings.ENABLED.getKey(), enabled)
            this.canMatch = canMatch;  
    }
            this.field = field;  
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(true)))
    }  
    public void testCachesBoundsLookupPerIndexAndFieldDuringSinglePruningPass() {  
        assertFalse(second.skip());  
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());  
            List.of((domain, constraint, context) -> domain instanceof TestFieldDomain ? ((TestFieldDomain) domain).canMatch() : true)
        assertFalse(result.pruned());
        return domain(true, canMatch);
            .build();  
        public String field() {
            clusterSettings,  
        for (int shardGroupIndex = 0; shardGroupIndex < pruningResult.originalShardGroups(); shardGroupIndex++) {
        assertTrue(result.isPrunedShardGroup(1));  
        SearchIndexPruningService service = new SearchIndexPruningService(
    private static SearchRequest dateRangeSearchRequest(long from, long to) {
import org.opensearch.cluster.metadata.IndexMetadata;
        SearchShardIterator alreadySkipped = shardIterator("logs-000001", 0);
        ClusterSettings clusterSettings = clusterSettings(Settings.EMPTY);
}
        SearchShardIterator shardIterator = shardIterator("logs-000001", 0);  
    }
            new ShardId(index, "_na_", shardId),
    private static IndexMetadata plainIndexMetadata(String index) {
        assertFalse(unfinalizedDomain.skip());  
        assertFalse(result.pruned());  
    public void testPrunesOnlyProvablyDisjointLocalShardGroups() {  
            return canMatch;
import org.opensearch.action.OriginalIndices;
        assertFalse(result.pruned());  
        assertTrue(oldIndex.skip());
    }
        private TestFieldDomain(String field, boolean finalized, boolean canMatch) {  
        assertFalse(matchingIndex.skip());
        SearchIndexPruningResult result = service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        SearchShardIterator activeCandidate = shardIterator("logs-000002", 0);
        assertFalse(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).pruned());  
import java.util.Map;
    private static final class TestFieldDomain implements FieldDomain {  
    ) {  
        };
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(alreadySkipped, activeCandidate));
        assertTrue(result.isPrunedShardGroup(0));
            lookups.incrementAndGet();  
        assertThat(result.prunedShardGroups(), equalTo(1));  
            shardIterators,  
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(true)))
        return new SearchRequest().source(new SearchSourceBuilder());
        for (IndexMetadata metadataEntry : indexMetadata) {
        SearchShardIterator matchingIndex = shardIterator("logs-000002", 0);
        Settings settings = Settings.builder()
        assertFalse(matchingIndex.skip());
        SearchIndexPruningService service = serviceWithDomains(  
    }  
        );  
        SearchIndexPruningService service = new SearchIndexPruningService(  
            throw new IllegalStateException("exception");  
            .put(SearchIndexPruningSettings.ENABLED.getKey(), true)  
    }  
    }  
        return IndexFieldDomainMetadata.getInstance().putFieldDomain(plainIndexMetadata(index), domain);
            indexMetadata("logs-000002", new DateRangeFieldDomain("@timestamp", 350L, 450L, true, "test"))
import org.opensearch.action.search.pruning.QueryConstraint;
    }
        assertThat(result.originalShardGroups(), equalTo(1));
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
        );  
            return Optional.of(new TestFieldDomain(field));
import org.opensearch.action.search.pruning.FieldDomainEvaluationContext;  
    public void testWiresDateRangeMetadataFromClusterStateProvider() {
    }
        assertFalse(shardIterator.skip());
        Set<Setting<?>> builtInSettings = Set.copyOf(SearchIndexPruningSettings.getSettings());
        private boolean canMatch() {  
            genericEvaluators()  
        assertFalse(result.isPrunedShardGroup(0));
            .putList(SearchIndexPruningSettings.FIELDS.getKey(), "@timestamp")
    private static void applyPruningResult(SearchIndexPruningResult pruningResult) {  
        }  
        assertFalse(localIndex.skip());
        assertFalse(first.skip());
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(first, second));
            indexMetadata("logs-000001", new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test")),  
        return IndexMetadata.builder(index)
        SearchShardIterator remoteIndex = shardIterator("remote-cluster", "logs-000001", 0);
        SearchRequest request = searchRequest();
    }
        return new SearchShardIterator(
    }
import org.opensearch.index.fielddomain.ClusterStateFieldDomainProvider;  
    private static ClusterSettings dateClusterSettings() {
        service.prune(new SearchRequest().source(new SearchSourceBuilder()), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(missingMetadata, unfinalizedDomain));  
import org.opensearch.action.search.pruning.FieldDomainEvaluators;
    }  
        SearchShardIterator oldIndex = shardIterator("logs-000001", 0);
        Map<String, Optional<FieldDomain>> domainsByIndex
        assertFalse(result.isPrunedShardGroup(1));
    public void testFallsBackWhenAllShardGroupsWouldBePruned() {
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertTrue(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).isPrunedShardGroup(0));  
        return new SearchRequest().source(new SearchSourceBuilder().query(QueryBuilders.rangeQuery("@timestamp").gte(from).lte(to)));  
import org.opensearch.index.query.QueryBuilders;
        return new ClusterSettings(settings, builtInSettings);  
        clusterSettings.applySettings(pruningSettings(false, 1, FIELD));
    }  
            .build();
    }
        private TestQueryConstraint(String field) {
        );  
            return field;
    private static IndexMetadata indexMetadata(String index, DateRangeFieldDomain domain) {
public class SearchIndexPruningServiceTests extends OpenSearchTestCase {  
                pruningResult.shardIterators().get(shardGroupIndex).resetAndSkip();  
        }
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(remoteIndex, localIndex));  
import org.opensearch.common.settings.Settings;
            null
            .putList(SearchIndexPruningSettings.FIELDS.getKey(), FIELD)
    }
        return new FieldDomainEvaluationContext(() -> 0L);
        public boolean finalized() {
import org.opensearch.index.fielddomain.FieldDomainProvider;  
        assertFalse(result.pruned());  
        SearchShardIterator second = shardIterator("logs-000002", 0);
        SearchIndexPruningResult result = service.prune(
        return new TestFieldDomain(FIELD, finalized, canMatch);
        SearchIndexPruningService service = new SearchIndexPruningService(clusterSettings(), provider, extractor, evaluators);
        clusterSettings.applySettings(pruningSettings(true, 1, "event.ingested"));
        SearchShardIterator unfinalizedDomain = shardIterator("logs-000002", 0);
                Settings.builder()  
        SearchShardIterator activeCandidate = shardIterator("logs-000002", 0);
        assertFalse(remoteIndex.skip());
        SearchShardIterator first = shardIterator("logs-000001", 0);  
        QueryConstraintExtractor extractor = (source, fields) -> List.of(new TestQueryConstraint(FIELD));  
            Map.of("logs-000001", Optional.empty(), "logs-000002", Optional.of(domain(false)))  
    public void testAppliesDynamicPruningSettingsAsConsistentConfigSnapshot() {  
        SearchShardIterator alreadySkipped = shardIterator("logs-000001", 0);
            .put(SearchIndexPruningSettings.MIN_SHARDS.getKey(), minShards)  
            Map.of("logs-000001", Optional.empty(), "logs-000002", Optional.of(domain(false, false)))
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(true)))
    }  
        SearchIndexPruningService service = serviceWithDomains(
        assertTrue(result.pruned());
        return indexMetadataBuilder(index).build();  
        };
        return clusterSettings(settings);
        }  
        return serviceWithDomains(clusterSettings(), domainsByIndex);  
    public void testMinShardThresholdUsesActiveShardGroups() {  
        }  
        SearchShardIterator oldIndex = shardIterator("logs-000001", 0);  
        );
        return clusterSettings(settings);
            null,
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.ClusterName;  
        SearchShardIterator localIndex = shardIterator("logs-000002", 0);
    private static Settings pruningSettings(boolean enabled, int minShards, String... fields) {  
        @Override
        return shardIterator(null, index, shardId);
        };
        assertTrue(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.containsAll(SearchIndexPruningSettings.getSettings()));  
            lookups.incrementAndGet();  
            List.of("node-1"),
                    .build()  
import org.opensearch.search.builder.PointInTimeBuilder;  
        @Override
            clusterState,
        assertFalse(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).pruned());  
    private static SearchShardIterator shardIterator(String index, int shardId) {  
        AtomicInteger lookups = new AtomicInteger();
        ClusterSettings clusterSettings,
    private static SearchShardIterator shardIterator(String clusterAlias, String index, int shardId) {
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(oldIndex, matchingIndex));  
        assertFalse(activeCandidate.skip());
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(false)))
    public void testKeepsRemoteShardGroups() {  
        assertFalse(result.isPrunedShardGroup(1));
            provider,
    }
        );  
    }
            provider,
        return ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).build();
        }
import java.util.Optional;  
            .numberOfShards(1)
    private static FieldDomainEvaluators genericEvaluators() {  
    public void testPruneIsFailOpenWhenDomainProviderThrows() {
 * The OpenSearch Contributors require contributions made to  
        AtomicInteger lookups = new AtomicInteger();
        assertThat(lookups.get(), equalTo(1));
        FieldDomainProvider provider = (clusterState, indexName, field) -> domainsByIndex.getOrDefault(indexName, Optional.empty());
        );
import org.opensearch.index.fielddomain.FieldDomain;
        FieldDomainEvaluators evaluators = new FieldDomainEvaluators(List.of((bounds, constraint, context) -> false));
    private static ClusterState clusterState(IndexMetadata... indexMetadata) {
    public void testKeepsShardGroupsWhenDomainIsMissingOrUnfinalized() {  
 * this file be licensed under the Apache-2.0 license or a
        FieldDomainProvider provider = (clusterState, indexName, field) -> {
        applyPruningResult(result);  
            metadata.put(metadataEntry, false);
        public String field() {
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        private TestFieldDomain(String field) {
    }
        return new SearchIndexPruningService(clusterSettings, provider, genericConstraintExtractor(), genericEvaluators());
    }
        );  
        return (source, fields) -> fields.contains(FIELD) ? List.of(new TestQueryConstraint(FIELD)) : List.of();  
import org.opensearch.common.settings.Setting;  
import org.opensearch.core.index.shard.ShardId;
        );  
            this.finalized = finalized;
            .build();  
    }
 * compatible open source license.
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.cluster.ClusterState;
        assertFalse(oldIndex.skip());  
        SearchShardIterator matchingIndex = shardIterator("logs-000002", 0);
 * SPDX-License-Identifier: Apache-2.0
    }
            lookups.incrementAndGet();
        assertTrue(result.isPrunedShardGroup(0));  
        private final boolean finalized;
        request.source().pointInTimeBuilder(new PointInTimeBuilder("pit-id"));
            .put(SearchIndexPruningSettings.MIN_SHARDS.getKey(), 1)
    public void testPruningSettingsAreRegisteredAsBuiltInClusterSettings() {
        assertTrue(result.pruned());
 */  
        SearchShardIterator matchingIndex = shardIterator("logs-000002", 0);
            clusterSettings(),  
    }  
    }
        assertFalse(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).pruned());  
            return field;
        assertThat(result.prunedShardGroups(), equalTo(0));  
    public void testDoesNotPrunePointInTimeSearches() {
        assertThat(lookups.get(), equalTo(0));  
        }
        }
        assertFalse(result.pruned());
        );
            clusterAlias,  
        SearchShardIterator missingMetadata = shardIterator("logs-000001", 0);
            )
    private static ClusterSettings clusterSettings() {
        SearchIndexPruningService service = serviceWithDomains(
import org.opensearch.common.settings.ClusterSettings;
        SearchIndexPruningResult result = service.prune(searchRequest(), shardIterators, ClusterState.EMPTY_STATE, evaluationContext());
        assertFalse(service.prune(request, shardIterators, ClusterState.EMPTY_STATE, evaluationContext()).pruned());  
    }
            .numberOfReplicas(0);  
        GroupShardsIterator<SearchShardIterator> shardIterators = new GroupShardsIterator<>(List.of(oldIndex, matchingIndex));  
        clusterSettings.applySettings(pruningSettings(true, 1, FIELD));
        );  
        assertTrue(result.pruned());
            if (pruningResult.isPrunedShardGroup(shardGroupIndex)) {
            Map.of("logs-000001", Optional.of(domain(false)), "logs-000002", Optional.of(domain(false)))
import org.opensearch.Version;
