        }
import org.opensearch.cluster.ClusterState;
 */
    public void testDataStreamResolvesToBackingIndices() {
    private static IndexMetadata.Builder closedIndexBuilder(String name, String mappingJson) {
                        new DataStream(
        AliasMetadata filterAlias = AliasMetadata.builder("active_only").filter("{\"term\":{\"status\":\"active\"}}").build();
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("test", "test1"));
        assertTrue("error must mention the conflicting field: " + ex.getMessage(), ex.getMessage().contains("age"));
    public void testAliasResolvesToAllBackingIndicesWhenSchemasMatch() {
        ClusterState state = ClusterState.builder(new ClusterName("test"))
                    Settings.builder()
        assertTrue("error must mention the alias name: " + ex.getMessage(), ex.getMessage().contains("active_only"));
import org.opensearch.cluster.metadata.DataStream;
        IllegalArgumentException ex = expectThrows(
        IndexMetadata.Builder closed = indexBuilder("bank_b", longField("age")).state(IndexMetadata.State.CLOSE)
                            DataStreamTestHelper.createTimestampField("@timestamp"),
        return "{\"properties\":{\"" + name + "\":{\"type\":\"text\"}}}";
        assertEquals(1, result.concreteIndices().size());
        );
        IndexResolution result = IndexResolution.resolve("logs", state, RESOLVER);
     * and schema-compat checks apply — DS backings should have identical mappings by construction,
        return ClusterState.builder(new ClusterName("test")).metadata(mb.build()).build();
                        )
import org.opensearch.test.OpenSearchTestCase;
        ClusterState state = clusterStateOf(indexBuilder("bank", longField("age")));
    // TODO honor IndicesOptions.allowNoIndices() — vanilla OpenSearch lets `ignore_unavailable=true`
                Metadata.builder()
    }
        assertEquals("closed backing index must be excluded", 1, result.concreteIndices().size());
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("left", "right"));
                            List.of(b1.getIndex(), b2.getIndex())
                )
        ClusterState state = ClusterState.builder(new ClusterName("test"))
        IllegalArgumentException ex = expectThrows(
     * closed indices, so all three resolution paths (literal-name, alias, wildcard) converge on
        assertEquals(2, result.concreteIndices().size());
        IndexMetadata.Builder open = indexBuilder("bank_a", longField("age")).putAlias(AliasMetadata.builder("bank_all").build());
import java.util.Locale;
     * Data stream backings with conflicting mappings fail the same schema-compat check as aliases.
        ClusterState state = clusterStateOf(indexBuilder("bank", longField("age")));
        ClusterState state = clusterStateOf(a, b);
    public void testCommaSeparatedExpressionResolvesToUnion() {
                            "logs",
    public void testAliasRejectsWhenFieldTypesDiffer() {
        assertTrue("error must mention the missing name: " + ex.getMessage(), ex.getMessage().contains("does_not_exist"));
        return indexBuilder(name, mappingJson).state(IndexMetadata.State.CLOSE);
     * Pins the documented gap in {@link IndexResolution} schema-compatibility validation: the
    private static final IndexNameExpressionResolver RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("active_only", state));
        IndexMetadata.Builder b = indexBuilder("bank_b", longField("age")).putAlias(AliasMetadata.builder("bank_all").build());
            indexBuilder("other", longField("age"))
                            List.of(b1.getIndex(), b2.getIndex())
        try {
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("test", "test1"));
        assertEquals("bank", result.requestedName());
        IndexMetadata.Builder b = indexBuilder("bank_b", keywordField("age")).putAlias(AliasMetadata.builder("bank_all").build());
public class IndexResolutionTests extends OpenSearchTestCase {
package org.opensearch.analytics.planner;
            IllegalArgumentException.class,
            mb.put(b);
                    .put(
    private static ClusterState clusterStateOf(IndexMetadata.Builder... indices) {
                Metadata.builder()
                        )
                            DataStreamTestHelper.createTimestampField("@timestamp"),
        ClusterState state = clusterStateOf(left, right);
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexMetadata b1 = indexBuilder(DataStream.getDefaultBackingIndexName("logs", 1), longField("age")).build();
     * trees, OR document this as deferred-to-bind-time and add a regression test for the bind-time
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("logs", state, RESOLVER));
     */
     * <p>TODO: extend {@code validateSchemaCompatibility} to descend into object {@code properties}
            indexBuilder("test", longField("age")),
            ex.getMessage().contains("bank_a") && ex.getMessage().contains("bank_b")
            .build();
    }
        IndexMetadata.Builder b = indexBuilder("bank_b", keywordField("name")).putAlias(AliasMetadata.builder("bank_all").build());
import java.util.List;
        IndexResolution result = IndexResolution.resolve("both", state);
                    )
        assertEquals("bank_a", result.concreteIndices().get(0).getIndex().getName());
            indexBuilder("test", longField("age")),
    }
        assertTrue("error must mention the conflicting field: " + ex.getMessage(), ex.getMessage().contains("age"));
    public void testAliasResolvingOnlyToClosedIndicesThrows() {
            .metadata(
     * "closed indices are not searchable through analytics-engine."
    public void testConcreteClosedIndexIsRejected() {
        IndexMetadata b2 = indexBuilder(DataStream.getDefaultBackingIndexName("logs", 2), longField("age")).build();
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("bank", "test"));
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder(b1.getIndex().getName(), b2.getIndex().getName()));
    }
    }
        IndexMetadata b1 = indexBuilder(DataStream.getDefaultBackingIndexName("logs", 1), longField("age")).build();
    public void testMissingConcreteNameWithResolverStillThrows() {
    }
                    .put(b1, false)
        IndexMetadata b2 = indexBuilder(DataStream.getDefaultBackingIndexName("logs", 2), keywordField("age")).build();
    }
    private static String textField(String name) {
        ClusterState state = clusterStateOf(
     */
            return IndexMetadata.builder(name)
    public void testWildcardResolvesToMatchingConcreteIndices() {
    public void testConcreteIndexResolvesToSingleton() {
        assertTrue("error must mention the unmatched expression: " + ex.getMessage(), ex.getMessage().contains("nomatch*"));
import org.opensearch.cluster.DataStreamTestHelper;
    public void testAliasSkipsClosedBackingIndices() {
                    .put(
        IndexMetadata.Builder right = indexBuilder(
    /**
                    )
import org.opensearch.common.util.concurrent.ThreadContext;
                    .put(b1, false)
        assertTrue("error must mention 'filter': " + ex.getMessage(), ex.getMessage().toLowerCase(Locale.ROOT).contains("filter"));
        ClusterState state = clusterStateOf(a);
            .metadata(
 * Unit tests for {@link IndexResolution} — the helper that expands a table name
        assertEquals("test*", result.requestedName());
            indexBuilder("test", longField("age")),
                        .put("index.version.created", org.opensearch.Version.CURRENT.id)
        );
        assertTrue("error must mention the conflicting field: " + ex.getMessage(), ex.getMessage().contains("age"));
     * step instead of at resolution time.
    public void testAliasRejectsFilterAlias() {
            "right",
    public void testExclusionPatternResolvesCorrectly() {
        // a.b is long in index "left", keyword in index "right" — but a itself is "object" in both,
            throw new AssertionError(e);
    public void testMissingNameThrows() {
            "error must mention both indices: " + ex.getMessage(),
        IndexMetadata.Builder a = indexBuilder("bank_a", textField("name")).putAlias(AliasMetadata.builder("bank_all").build());
            .putAlias(AliasMetadata.builder("bank_all").build());
        IndexResolution result = IndexResolution.resolve("bank_all", state);
        ClusterState state = clusterStateOf(indexBuilder("bank", longField("age")));
        for (IndexMetadata.Builder b : indices) {
    // pass-through), then either flip this test or add a permissive overload.
        );
 * this file be licensed under the Apache-2.0 license or a
        ClusterState state = clusterStateOf(a, b);
            )
                    .build()
 */
                        .put("index.number_of_replicas", 0)
        IndexResolution result = IndexResolution.resolve("bank_all", state);
        ClusterState state = clusterStateOf(
 * compatible open source license.
            "{\"properties\":{\"a\":{\"type\":\"object\",\"properties\":{\"b\":{\"type\":\"long\"}}}}}"
    private static String keywordField(String name) {
        assertTrue("error must name the closed index: " + ex.getMessage(), ex.getMessage().contains("frozen"));
     * Closed indices named directly are rejected with the same error style as alias-only-backed
    }
    public void testWildcardMatchingNothingThrows() {
     *
        );
    /**
    }
            indexBuilder("other", longField("age"))
     * (DS backings *should* be identical by construction, but manual mapping amendments can drift.)
    }
            .putAlias(AliasMetadata.builder("bank_all").build());
                    .build()
        IndexMetadata.Builder left = indexBuilder(
        assertTrue(
        return "{\"properties\":{\"" + name + "\":{\"type\":\"long\"}}}";
    }
        IllegalArgumentException ex = expectThrows(
 * mapping compatibility across all backing indices.
        IndexMetadata.Builder closed = indexBuilder("bank_a", longField("age")).state(IndexMetadata.State.CLOSE)
        IndexResolution result = IndexResolution.resolve("test*", state, RESOLVER);
            .build();
        ).putAlias(AliasMetadata.builder("both").build());
        ClusterState state = clusterStateOf(a, b);
        Metadata.Builder mb = Metadata.builder();
            indexBuilder("test2", longField("age"))
    /**
                .settings(
            indexBuilder("bank", longField("balance")),
        ).putAlias(AliasMetadata.builder("both").build());
        ClusterState state = clusterStateOf(indexBuilder("bank", longField("age")));
    public void testDataStreamRejectsConflictingBackingMappings() {
        IndexMetadata.Builder a = indexBuilder("bank_a", longField("age")).putAlias(AliasMetadata.builder("bank_all").build());
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("bank_a", "bank_b"));
            .build();
     * but a manual amendment could drift, so we still validate.
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("bank_all", state));
                        .put("index.number_of_shards", 1)
        );
        ClusterState state = clusterStateOf(closed);
    }
    // path always throws, which diverges. Decide the analytics-engine contract (always-strict vs.
    }
        // though the raw OpenSearch type strings differ. The schema builder collapses them too.
     */
        assertEquals("bank_all", result.requestedName());
    }
import org.opensearch.cluster.ClusterName;
            "left",
/**
            indexBuilder("test1", longField("age")),
    }
        assertTrue("error must mention closed: " + ex.getMessage(), ex.getMessage().toLowerCase(Locale.ROOT).contains("closed"));
 * (concrete index or alias) to a list of {@link IndexMetadata} and validates
    // / `allow_no_indices=true` callers see an empty result for wildcards matching nothing. This
            indexBuilder("test1", longField("age")),
        } catch (java.io.IOException e) {
 * SPDX-License-Identifier: Apache-2.0
    }
    }
    }
            () -> IndexResolution.resolve("does_not_exist", state, RESOLVER)
import org.opensearch.cluster.metadata.Metadata;
        // and validateSchemaCompatibility only compares the object/object pair at top level.
        assertEquals("bank", result.concreteIndices().get(0).getIndex().getName());
        assertTrue("error must say closed: " + ex.getMessage(), ex.getMessage().toLowerCase(Locale.ROOT).contains("closed"));
        return "{\"properties\":{\"" + name + "\":{\"type\":\"keyword\"}}}";
            .metadata(Metadata.builder().put(closedIndexBuilder("frozen", longField("age"))).build())
                        new DataStream(
    private static IndexMetadata.Builder indexBuilder(String name, String mappingJson) {
    public void testNestedFieldTypeMismatchIsNotCaughtAtResolution() {
            () -> IndexResolution.resolve("nomatch*", state, RESOLVER)
    }
        IndexResolution result = IndexResolution.resolve("test*,-test2", state, RESOLVER);
        ClusterState state = clusterStateOf(
            "{\"properties\":{\"a\":{\"type\":\"object\",\"properties\":{\"b\":{\"type\":\"keyword\"}}}}}"
 *
        assertFalse("test2 must be excluded", result.concreteIndexNames().contains("test2"));
            )
        IndexResolution result = IndexResolution.resolve("bank,test", state, RESOLVER);
        assertTrue("error must mention the missing name: " + ex.getMessage(), ex.getMessage().contains("does_not_exist"));
     * Data streams fan out to their backing indices, just like aliases. The same closed-filter
        ClusterState state = clusterStateOf(open, closed);
                    .put(b2, false)
        IndexMetadata.Builder a = indexBuilder("bank_a", longField("age")).putAlias(AliasMetadata.builder("bank_all").build());
                            "logs",
        ClusterState state = clusterStateOf(indexBuilder("test", longField("age")), indexBuilder("test1", keywordField("age")));
    }
        );
            IllegalArgumentException.class,
        IndexResolution result = IndexResolution.resolve("bank", state);
     */
    /**
    public void testAliasAcceptsFieldsThatMapToSameCalciteType() {
    }
    }
            () -> IndexResolution.resolve("frozen", state, RESOLVER)
}
 * The OpenSearch Contributors require contributions made to
        IndexResolution result = IndexResolution.resolve("bank_all", state);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("does_not_exist", state));
        ClusterState state = ClusterState.builder(new ClusterName("test"))
                    .put(b2, false)
    private static String longField(String name) {
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("test*", state, RESOLVER));
                        .build()
        );
    public void testWildcardRejectsIncompatibleSchemasAcrossMatches() {
        }
        IndexMetadata.Builder a = indexBuilder("bank_a", longField("age")).putAlias(filterAlias);
    }
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("bank_all", state));
                .putMapping(mappingJson);
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("bank_a", "bank_b"));
    // ── helpers ──────────────────────────────────────────────────────────
    }
import org.opensearch.cluster.metadata.AliasMetadata;
            IllegalArgumentException.class,
        // text and keyword both map to VARCHAR, so a union over them is schema-compatible even
     * top-level "properties" walk does NOT recurse into nested object types, so two indices that
     * declare {@code a} as a different leaf type under an object disagree at the data-node bind
import org.opensearch.common.settings.Settings;
/*
        assertEquals("logs", result.requestedName());
     * error path. Today the conflict is silently accepted at resolution.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
