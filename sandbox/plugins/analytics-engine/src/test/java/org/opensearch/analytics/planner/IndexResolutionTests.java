    public void testAliasResolvesToAllBackingIndicesWhenSchemasMatch() {  
        return indexBuilder(name, mappingJson).state(IndexMetadata.State.CLOSE);
                            List.of(b1.getIndex(), b2.getIndex())
        IndexResolution result = IndexResolution.resolve("bank_all", state);
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("bank", "test"));  
     */  
                        )  
    /**
 * compatible open source license.
        assertEquals("bank", result.requestedName());  
        ClusterState state = clusterStateOf(
    }
    /**  
        IndexMetadata b1 = indexBuilder(DataStream.getDefaultBackingIndexName("logs", 1), longField("age")).build();
                        .put("index.number_of_shards", 1)
    /**
        IllegalArgumentException ex = expectThrows(
    }
    }
     * step instead of at resolution time.
    }
        );
        assertTrue("error must mention the alias name: " + ex.getMessage(), ex.getMessage().contains("active_only"));
        assertTrue("error must say closed: " + ex.getMessage(), ex.getMessage().toLowerCase(Locale.ROOT).contains("closed"));  
            )  
                            DataStreamTestHelper.createTimestampField("@timestamp"),
            ex.getMessage().contains("bank_a") && ex.getMessage().contains("bank_b")  
        assertTrue("error must mention the unmatched expression: " + ex.getMessage(), ex.getMessage().contains("nomatch*"));  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("logs", state, RESOLVER));  
    public void testConcreteClosedIndexIsRejected() {
        assertTrue("error must mention the conflicting field: " + ex.getMessage(), ex.getMessage().contains("age"));
        );
        assertEquals("bank", result.concreteIndices().get(0).getIndex().getName());
    public void testAliasRejectsFilterAlias() {
        assertTrue("error must mention closed: " + ex.getMessage(), ex.getMessage().toLowerCase(Locale.ROOT).contains("closed"));
import org.opensearch.cluster.metadata.Metadata;
        assertTrue(
        );
     * (DS backings *should* be identical by construction, but manual mapping amendments can drift.)  
 * mapping compatibility across all backing indices.
    }
        for (IndexMetadata.Builder b : indices) {
        IndexResolution result = IndexResolution.resolve("bank", state);  
                        )
        assertTrue("error must mention the missing name: " + ex.getMessage(), ex.getMessage().contains("does_not_exist"));
        // text and keyword both map to VARCHAR, so a union over them is schema-compatible even
import org.opensearch.cluster.ClusterState;
    // path always throws, which diverges. Decide the analytics-engine contract (always-strict vs.  
        ClusterState state = clusterStateOf(closed);
                        .put("index.version.created", org.opensearch.Version.CURRENT.id)
        IndexResolution result = IndexResolution.resolve("bank_all", state);
    private static ClusterState clusterStateOf(IndexMetadata.Builder... indices) {  
 * The OpenSearch Contributors require contributions made to  
                            List.of(b1.getIndex(), b2.getIndex())  
    private static IndexMetadata.Builder indexBuilder(String name, String mappingJson) {
    }  
     * closed indices, so all three resolution paths (literal-name, alias, wildcard) converge on
        ClusterState state = ClusterState.builder(new ClusterName("test"))  
 */  
import java.util.Locale;
import org.opensearch.cluster.metadata.DataStream;
                    .build()  
     *
        IndexMetadata b2 = indexBuilder(DataStream.getDefaultBackingIndexName("logs", 2), longField("age")).build();
        AliasMetadata filterAlias = AliasMetadata.builder("active_only").filter("{\"term\":{\"status\":\"active\"}}").build();
     * Data stream backings with conflicting mappings fail the same schema-compat check as aliases.
    public void testAliasSkipsClosedBackingIndices() {
        ).putAlias(AliasMetadata.builder("both").build());
        assertEquals("bank_a", result.concreteIndices().get(0).getIndex().getName());
        // and validateSchemaCompatibility only compares the object/object pair at top level.  
            indexBuilder("test", longField("age")),
        IndexResolution result = IndexResolution.resolve("test*", state, RESOLVER);  
        IndexMetadata.Builder right = indexBuilder(
    // / `allow_no_indices=true` callers see an empty result for wildcards matching nothing. This
/**
        ClusterState state = clusterStateOf(indexBuilder("test", longField("age")), indexBuilder("test1", keywordField("age")));
        ClusterState state = ClusterState.builder(new ClusterName("test"))  
        IndexMetadata.Builder b = indexBuilder("bank_b", keywordField("name")).putAlias(AliasMetadata.builder("bank_all").build());
        IndexResolution result = IndexResolution.resolve("logs", state, RESOLVER);
        assertEquals("test*", result.requestedName());
        assertEquals("logs", result.requestedName());  
                )
                            "logs",
import org.opensearch.cluster.DataStreamTestHelper;  
                Metadata.builder()
        Metadata.Builder mb = Metadata.builder();
     * Pins the documented gap in {@link IndexResolution} schema-compatibility validation: the
        IndexMetadata b1 = indexBuilder(DataStream.getDefaultBackingIndexName("logs", 1), longField("age")).build();  
 * SPDX-License-Identifier: Apache-2.0
    // ── helpers ──────────────────────────────────────────────────────────
        assertTrue("error must mention the conflicting field: " + ex.getMessage(), ex.getMessage().contains("age"));
            .metadata(  
    // pass-through), then either flip this test or add a permissive overload.
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("bank_a", "bank_b"));
        return "{\"properties\":{\"" + name + "\":{\"type\":\"long\"}}}";
     * Closed indices named directly are rejected with the same error style as alias-only-backed
    private static String keywordField(String name) {
                    )
        ClusterState state = clusterStateOf(open, closed);
        ClusterState state = clusterStateOf(
        assertTrue("error must mention 'filter': " + ex.getMessage(), ex.getMessage().toLowerCase(Locale.ROOT).contains("filter"));
    private static String textField(String name) {
    }
        }  
        ClusterState state = clusterStateOf(  
        IndexResolution result = IndexResolution.resolve("bank,test", state, RESOLVER);
        try {  
            indexBuilder("test1", longField("age")),
        assertTrue("error must name the closed index: " + ex.getMessage(), ex.getMessage().contains("frozen"));
     * but a manual amendment could drift, so we still validate.
            IllegalArgumentException.class,
 * Unit tests for {@link IndexResolution} — the helper that expands a table name
            indexBuilder("test", longField("age")),  
import java.util.List;
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("left", "right"));
        ClusterState state = ClusterState.builder(new ClusterName("test"))
        IndexMetadata.Builder left = indexBuilder(
     */
            indexBuilder("bank", longField("balance")),
    }
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("test", "test1"));
    public void testAliasResolvingOnlyToClosedIndicesThrows() {
     * "closed indices are not searchable through analytics-engine."  
            .build();
            .putAlias(AliasMetadata.builder("bank_all").build());
        IndexMetadata.Builder b = indexBuilder("bank_b", longField("age")).putAlias(AliasMetadata.builder("bank_all").build());
        IndexMetadata.Builder open = indexBuilder("bank_a", longField("age")).putAlias(AliasMetadata.builder("bank_all").build());
import org.opensearch.cluster.metadata.AliasMetadata;
import org.opensearch.cluster.metadata.IndexMetadata;  
        IndexResolution result = IndexResolution.resolve("bank_all", state);
package org.opensearch.analytics.planner;
        );
            .metadata(
    public void testAliasAcceptsFieldsThatMapToSameCalciteType() {
    }  
            "{\"properties\":{\"a\":{\"type\":\"object\",\"properties\":{\"b\":{\"type\":\"keyword\"}}}}}"
                            DataStreamTestHelper.createTimestampField("@timestamp"),
     * top-level "properties" walk does NOT recurse into nested object types, so two indices that
    }
                    Settings.builder()  
    }
        assertEquals("bank_all", result.requestedName());
    private static String longField(String name) {  
        IndexMetadata.Builder b = indexBuilder("bank_b", keywordField("age")).putAlias(AliasMetadata.builder("bank_all").build());
        ).putAlias(AliasMetadata.builder("both").build());
    }
                Metadata.builder()
        ClusterState state = clusterStateOf(left, right);  
        ClusterState state = clusterStateOf(a, b);  
            )
    }  
        IllegalArgumentException ex = expectThrows(
                    .build()
        ClusterState state = clusterStateOf(indexBuilder("bank", longField("age")));
                    )
            IllegalArgumentException.class,  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ClusterState state = clusterStateOf(a, b);  
        ClusterState state = clusterStateOf(indexBuilder("bank", longField("age")));  
    }
        IndexResolution result = IndexResolution.resolve("both", state);
                        new DataStream(  
import org.opensearch.common.settings.Settings;  
     * Data streams fan out to their backing indices, just like aliases. The same closed-filter
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("test*", state, RESOLVER));  
    }  
     * error path. Today the conflict is silently accepted at resolution.
    }
        ClusterState state = clusterStateOf(indexBuilder("bank", longField("age")));
            throw new AssertionError(e);
        IndexMetadata.Builder a = indexBuilder("bank_a", longField("age")).putAlias(AliasMetadata.builder("bank_all").build());
        IndexResolution result = IndexResolution.resolve("test*,-test2", state, RESOLVER);
    }
     * trees, OR document this as deferred-to-bind-time and add a regression test for the bind-time
        ClusterState state = clusterStateOf(a, b);  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("bank_all", state));
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("bank_a", "bank_b"));  
    public void testDataStreamResolvesToBackingIndices() {  
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder(b1.getIndex().getName(), b2.getIndex().getName()));
    }
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("bank_all", state));  
        assertEquals("closed backing index must be excluded", 1, result.concreteIndices().size());  
                    .put(b1, false)
        IndexMetadata.Builder closed = indexBuilder("bank_a", longField("age")).state(IndexMetadata.State.CLOSE)
    public void testCommaSeparatedExpressionResolvesToUnion() {  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("active_only", state));  
                .putMapping(mappingJson);  
            "right",  
    // TODO honor IndicesOptions.allowNoIndices() — vanilla OpenSearch lets `ignore_unavailable=true`
    public void testNestedFieldTypeMismatchIsNotCaughtAtResolution() {
        );
    private static final IndexNameExpressionResolver RESOLVER = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
            "error must mention both indices: " + ex.getMessage(),
            "{\"properties\":{\"a\":{\"type\":\"object\",\"properties\":{\"b\":{\"type\":\"long\"}}}}}"  
 * this file be licensed under the Apache-2.0 license or a
            () -> IndexResolution.resolve("does_not_exist", state, RESOLVER)
        IndexMetadata b2 = indexBuilder(DataStream.getDefaultBackingIndexName("logs", 2), keywordField("age")).build();
    /**  
        ClusterState state = clusterStateOf(a);
        assertFalse("test2 must be excluded", result.concreteIndexNames().contains("test2"));
     * and schema-compat checks apply — DS backings should have identical mappings by construction,  
            () -> IndexResolution.resolve("nomatch*", state, RESOLVER)
            .build();
    public void testWildcardMatchingNothingThrows() {
     */
        ClusterState state = clusterStateOf(indexBuilder("bank", longField("age")));  
 */
            indexBuilder("test1", longField("age")),
                        .build()
        }
        assertThat(result.concreteIndexNames(), org.hamcrest.Matchers.containsInAnyOrder("test", "test1"));  
            mb.put(b);  
                    .put(b2, false)
        assertTrue("error must mention the conflicting field: " + ex.getMessage(), ex.getMessage().contains("age"));  
        assertEquals(1, result.concreteIndices().size());
        return "{\"properties\":{\"" + name + "\":{\"type\":\"text\"}}}";  
 *
            indexBuilder("other", longField("age"))  
                    .put(b2, false)  
        IndexMetadata.Builder a = indexBuilder("bank_a", longField("age")).putAlias(AliasMetadata.builder("bank_all").build());
    public void testMissingNameThrows() {
        IndexMetadata.Builder a = indexBuilder("bank_a", longField("age")).putAlias(filterAlias);  
            indexBuilder("test2", longField("age"))
    }
import org.opensearch.cluster.ClusterName;
            "left",
public class IndexResolutionTests extends OpenSearchTestCase {  
            IllegalArgumentException.class,  
    }
    }
        return ClusterState.builder(new ClusterName("test")).metadata(mb.build()).build();
    public void testWildcardRejectsIncompatibleSchemasAcrossMatches() {  
                            "logs",  
            .build();
            return IndexMetadata.builder(name)
                        new DataStream(
                    .put(
    public void testMissingConcreteNameWithResolverStillThrows() {  
    public void testAliasRejectsWhenFieldTypesDiffer() {  
        assertTrue("error must mention the missing name: " + ex.getMessage(), ex.getMessage().contains("does_not_exist"));  
     */
        IndexMetadata.Builder closed = indexBuilder("bank_b", longField("age")).state(IndexMetadata.State.CLOSE)  
            .metadata(Metadata.builder().put(closedIndexBuilder("frozen", longField("age"))).build())
     * <p>TODO: extend {@code validateSchemaCompatibility} to descend into object {@code properties}  
        IllegalArgumentException ex = expectThrows(
        );  
            indexBuilder("test", longField("age")),  
}
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> IndexResolution.resolve("does_not_exist", state));
    public void testDataStreamRejectsConflictingBackingMappings() {
            indexBuilder("other", longField("age"))
    }  
            .putAlias(AliasMetadata.builder("bank_all").build());  
        } catch (java.io.IOException e) {
    public void testConcreteIndexResolvesToSingleton() {
    }
                    .put(
import org.opensearch.common.util.concurrent.ThreadContext;
                .settings(
        // a.b is long in index "left", keyword in index "right" — but a itself is "object" in both,
     * declare {@code a} as a different leaf type under an object disagree at the data-node bind  
    }  
    private static IndexMetadata.Builder closedIndexBuilder(String name, String mappingJson) {
                    .put(b1, false)  
    public void testWildcardResolvesToMatchingConcreteIndices() {
/*  
                        .put("index.number_of_replicas", 0)  
    public void testExclusionPatternResolvesCorrectly() {
 * (concrete index or alias) to a list of {@link IndexMetadata} and validates  
        IndexMetadata.Builder a = indexBuilder("bank_a", textField("name")).putAlias(AliasMetadata.builder("bank_all").build());
        // though the raw OpenSearch type strings differ. The schema builder collapses them too.  
        assertEquals(2, result.concreteIndices().size());
        return "{\"properties\":{\"" + name + "\":{\"type\":\"keyword\"}}}";
            () -> IndexResolution.resolve("frozen", state, RESOLVER)  
        );
