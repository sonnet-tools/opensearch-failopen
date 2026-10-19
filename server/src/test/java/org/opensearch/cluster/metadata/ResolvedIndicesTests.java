            .withRemoteIndices(Map.of("remote", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)))
import static org.hamcrest.Matchers.equalTo;
        assertNotEquals(resolvedIndices1.hashCode(), resolvedIndices3.hashCode());
    }
        Set<String> names = Set.of("index_a", "index_b", "index_c");
import java.util.List;
        ResolvedIndices.Local local = ResolvedIndices.Local.of(List.of("o", "p", "q"));
        assertArrayEquals(
        Metadata.Builder metadata = Metadata.builder()
            DeleteIndexAction.INSTANCE,
package org.opensearch.cluster.metadata;
        assertNotEquals(resolvedIndices1.hashCode(), ResolvedIndices.unknown().hashCode());
 * compatible open source license.
    public void testEqualsHashCode() {
        concrete = concrete.withoutResolutionErrors();
    public void testWithLocalSubActions() {
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
        assertTrue(resolvedIndices1 + " equals " + resolvedIndices2, resolvedIndices1.equals(resolvedIndices2));
            resolvedIndices.remote().asClusterToOriginalIndicesMap().get("remote_cluster").indices()
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b", "c"));
        ResolvedIndices resolvedIndices = ResolvedIndices.of("a", "b", "c")
    public void testNamesOfIndices() {
        ResolvedIndices resolvedIndices = ResolvedIndices.of(new String[0]);
        assertFalse(resolvedIndices.local().isEmpty());
        assertThat(resolvedIndices.local().names(ClusterState.EMPTY_STATE), containsInAnyOrder("a", "b", "c"));
        assertTrue(resolvedIndices.remote().asClusterToOriginalIndicesMap().containsKey("remote_cluster"));
import org.opensearch.core.index.Index;
        IndexNotFoundException exception = expectThrows(IndexNotFoundException.class, concrete::concreteIndices);
        );
        assertThat(concrete.names(), containsInAnyOrder("index_a", "index_b", "index_c"));
            containsInAnyOrder("index_not_existing", "index_a1", "index_a2", "index_b1")
        ResolvedIndices.Local.Concrete concrete = ResolvedIndices.Local.Concrete.of(indices, names).withResolutionErrors();
        ResolvedIndices resolvedIndices = ResolvedIndices.of("index_not_existing", "alias_a", "index_b1");
        assertTrue(resolvedIndices.remote().asClusterToOriginalIndicesMap().isEmpty());
        assertNotEquals(resolvedIndices1.hashCode(), resolvedIndices3.hashCode());
import org.opensearch.action.OriginalIndices;
    }
        ResolvedIndices resolvedIndices3 = resolvedIndices2.withLocalSubActions(
    public void testNamesWithClusterState() {
        ResolvedIndices resolvedIndices2 = ResolvedIndices.of("index")
        assertFalse(resolvedIndices instanceof ResolvedIndices);
        assertThat(concrete.names(), containsInAnyOrder("index_a", "index_b", "index_c"));
        OriginalIndices originalIndices = new OriginalIndices(new String[] { "x", "y" }, IndicesOptions.LENIENT_EXPAND_OPEN);
        );
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("other"));
        assertThat(resolvedIndices.remote().asRawExpressions(), containsInAnyOrder("remote_cluster:remote_index"));
    }
        Set<Index> indices = Set.of(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b"));
            new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)
        assertFalse(resolvedIndices.isEmpty());
    }
        ResolvedIndices resolvedIndices3 = resolvedIndices2.withRemoteIndices(
    }
import java.util.Arrays;
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("other"));
    public void testHashCodeForConcreteIndices() {
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b", "c"));
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("other"));
    public void testOfNamesCollection() {
    }
        ResolvedIndices resolvedIndices = ResolvedIndices.of("a", "b", "c").withLocalOriginalIndices(originalIndices);
    }
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))
    public void testWithRemoteIndices() {
    }
        ResolvedIndices resolvedIndices2 = ResolvedIndices.of(ResolvedIndices.Local.Concrete.of(new Index("index", "index_uuid")))
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        );
        Metadata.Builder metadata = Metadata.builder()
/*
            new String[] { "remote_index" },
import java.util.Map;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
    }
        assertTrue(resolvedIndices.remote().isEmpty());
        ResolvedIndices resolvedIndices1 = ResolvedIndices.of(ResolvedIndices.Local.Concrete.of(new Index("index", "index_uuid")))
        assertArrayEquals(resolvedIndices.local().originalIndices().indices(), new String[] { "x", "y" });
        assertTrue(resolvedIndices.local().contains("a"));
        assertTrue(resolvedIndices.local().containsAny(i -> i.equals("a")));
    public void testOfEmpty() {
        ResolvedIndices.Local.Concrete concrete = (ResolvedIndices.Local.Concrete) resolvedIndices.local();
    public void testLocalConcreteOf() {
public class ResolvedIndicesTests extends OpenSearchTestCase {
        assertFalse(resolvedIndices3.equals(resolvedIndices1));
            .withRemoteIndices(Map.of("remote", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)))
        assertThat(resolvedIndices.local().names(clusterState), containsInAnyOrder("index_not_existing", "alias_a", "index_b1"));
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
            ResolvedIndices.Local.of("other2")
import java.util.Set;
        assertThat(concrete.concreteIndices(), containsInAnyOrder(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b")));
        ResolvedIndices resolvedIndices = ResolvedIndices.of(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b"));
        );
}
        assertFalse(resolvedIndices1.equals(resolvedIndices3));
        ResolvedIndices.Local.Concrete concrete = ResolvedIndices.Local.Concrete.of(indices, names)
        ResolvedIndices resolvedIndices = ResolvedIndices.of("a", "b", "c");
            .put(indexBuilder("index_b1"));
    }
    }
import org.opensearch.index.IndexNotFoundException;
            resolvedIndices.local().namesOfIndices(clusterState),
    public void testWithoutRemoteIndices() {
 */
        assertTrue(resolvedIndices2 + " equals " + resolvedIndices1, resolvedIndices2.equals(resolvedIndices1));
        assertThat(concrete.namesOfConcreteIndices(), containsInAnyOrder("index_a", "index_b"));
        ResolvedIndices resolvedIndices = ResolvedIndices.ofNonNull("a", "b", "c", null);
    }
    }
        assertThat(concrete.concreteIndices(), containsInAnyOrder(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b")));
    }
        ResolvedIndices resolvedIndices = ResolvedIndices.of(List.of("a", "b"));
import org.opensearch.Version;
    }
        return IndexMetadata.builder(index)
        assertTrue(resolvedIndices.local().containsAny(List.of("a", "x")));
        ResolvedIndices resolvedIndices = ResolvedIndices.of(new String[0]).withRemoteIndices(remoteIndices);
import org.opensearch.cluster.ClusterName;
    public void testOfConcreteIndices() {
            );
        assertThat(resolvedIndices.local().subActions().get(DeleteIndexAction.NAME).names(), containsInAnyOrder("x", "y", "z"));
        assertThat(exception.getIndex().getName(), equalTo("index_x"));
            .withResolutionErrors(new IndexNotFoundException("index_x"));
    }
            .settings(
        assertFalse(resolvedIndices1.equals(ResolvedIndices.unknown()));
        assertEquals(resolvedIndices1.hashCode(), resolvedIndices2.hashCode());
    public void testWithLocalOriginalIndices() {
        assertThat(
    public void testLocalConcreteWithResolutionErrors() {
        assertTrue(resolvedIndices.local().containsAny(List.of("whatever")));
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        assertTrue(resolvedIndices.local().contains("whatever"));
            ResolvedIndices.unknown().local().names(clusterState),
        resolvedIndices = OptionallyResolvedIndices.unknown();
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("index_a", "index_b"));
        Map<String, OriginalIndices> remoteIndices = Map.of(
 * this file be licensed under the Apache-2.0 license or a
        assertThat(Arrays.asList(resolvedIndices.local().namesAsArray()), containsInAnyOrder("a", "b", "c"));
    public void testOfNames() {
    public void testOfNonNull() {
        assertFalse(resolvedIndices.local().isEmpty());
        assertThat(
import static org.hamcrest.Matchers.containsInAnyOrder;
            .put(indexBuilder("index_b1"));
        assertEquals(resolvedIndices1.hashCode(), resolvedIndices2.hashCode());
        assertTrue(resolvedIndices1 + " equals " + resolvedIndices2, resolvedIndices1.equals(resolvedIndices2));
        ResolvedIndices resolvedIndices1 = ResolvedIndices.of("index")
        assertFalse(resolvedIndices1.equals(resolvedIndices3));
    }
        ResolvedIndices resolvedIndices = ResolvedIndices.of(new String[0]);
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b", "c"));
        assertThat(concrete.concreteIndices(), containsInAnyOrder(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b")));
    }
    public void testContains() {
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("x", "y", "z"));
    public void testLocalOf() {
        assertTrue(resolvedIndices2 + " equals " + resolvedIndices1, resolvedIndices2.equals(resolvedIndices1));
        assertFalse(resolvedIndices.local().containsAny(List.of("x", "y")));
            containsInAnyOrder("index_a1", "index_a2", "index_b1", "alias_a")
            .withRemoteIndices(Map.of("remote", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)))
        assertFalse(resolvedIndices.local().containsAny(i -> i.equals("z")));
        assertEquals(resolvedIndices.remote().asRawExpressions(), Arrays.asList(resolvedIndices.remote().asRawExpressionsArray()));
    public void testUnknown() {
        assertFalse(resolvedIndices.local().contains("x"));
            Map.of("remote2", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN))
        assertTrue(resolvedIndices.remote().isEmpty());
    }
            "remote_cluster",
            .withRemoteIndices(Map.of("remote", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)))
        assertThat(Arrays.asList(concrete.namesOfConcreteIndicesAsArray()), containsInAnyOrder("index_a", "index_b"));
        assertFalse(resolvedIndices3.equals(resolvedIndices1));
        OptionallyResolvedIndices resolvedIndices = ResolvedIndices.unknown();
        assertTrue(resolvedIndices.remote().asRawExpressions().isEmpty());
        );
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("other"));
        assertThat(local.names(), containsInAnyOrder("o", "p", "q"));
        assertEquals("ResolvedIndices{unknown=true}", resolvedIndices.toString());
        Set<Index> indices = Set.of(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b"));
        assertFalse(resolvedIndices instanceof ResolvedIndices);
        ResolvedIndices resolvedIndices = ResolvedIndices.of("index_not_existing", "alias_a", "index_b1");
        ResolvedIndices resolvedIndices = ResolvedIndices.of("a", "b", "c");
        assertTrue(resolvedIndices.isEmpty());
    private static IndexMetadata.Builder indexBuilder(String index) {
import org.opensearch.test.OpenSearchTestCase;
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b", "c"));
 *
        assertTrue(resolvedIndices.local().isEmpty());
import static org.hamcrest.Matchers.isA;
import org.opensearch.action.support.IndicesOptions;
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b"));
        assertThat(resolvedIndices.local(), isA(ResolvedIndices.Local.Concrete.class));
        assertTrue(resolvedIndices.local().containsAny(i -> false));
        Set<String> names = Set.of("index_a", "index_b", "index_c");
        );
import org.opensearch.cluster.ClusterState;
