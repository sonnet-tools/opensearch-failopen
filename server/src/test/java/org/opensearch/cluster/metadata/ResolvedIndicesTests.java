    }  
        assertTrue(resolvedIndices.remote().isEmpty());
 * compatible open source license.
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertThat(resolvedIndices.local().names(clusterState), containsInAnyOrder("index_not_existing", "alias_a", "index_b1"));  
            resolvedIndices.local().namesOfIndices(clusterState),  
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("x", "y", "z"));
            );
    public void testOfNonNull() {  
        assertFalse(resolvedIndices.local().containsAny(i -> i.equals("z")));  
import java.util.List;  
            .withRemoteIndices(Map.of("remote", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)))
            ResolvedIndices.Local.of("other2")
        assertTrue(resolvedIndices.isEmpty());
        Set<Index> indices = Set.of(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b"));  
        assertFalse(resolvedIndices.local().containsAny(List.of("x", "y")));
        assertTrue(resolvedIndices.remote().asClusterToOriginalIndicesMap().containsKey("remote_cluster"));
    }
    public void testNamesOfIndices() {
    }  
        assertFalse(resolvedIndices.isEmpty());
package org.opensearch.cluster.metadata;
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("index_a", "index_b"));  
        );
        assertArrayEquals(resolvedIndices.local().originalIndices().indices(), new String[] { "x", "y" });  
    }
        Set<String> names = Set.of("index_a", "index_b", "index_c");  
    public void testLocalConcreteWithResolutionErrors() {
        assertThat(exception.getIndex().getName(), equalTo("index_x"));  
        assertTrue(resolvedIndices.remote().asRawExpressions().isEmpty());
        IndexNotFoundException exception = expectThrows(IndexNotFoundException.class, concrete::concreteIndices);
        ResolvedIndices resolvedIndices = ResolvedIndices.of("index_not_existing", "alias_a", "index_b1");
    }
        assertThat(Arrays.asList(concrete.namesOfConcreteIndicesAsArray()), containsInAnyOrder("index_a", "index_b"));
        assertFalse(resolvedIndices3.equals(resolvedIndices1));  
        assertEquals(resolvedIndices1.hashCode(), resolvedIndices2.hashCode());  
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("other"));  
    public void testContains() {
        assertTrue(resolvedIndices1 + " equals " + resolvedIndices2, resolvedIndices1.equals(resolvedIndices2));
        Set<Index> indices = Set.of(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b"));
            containsInAnyOrder("index_a1", "index_a2", "index_b1", "alias_a")  
        assertEquals(resolvedIndices.remote().asRawExpressions(), Arrays.asList(resolvedIndices.remote().asRawExpressionsArray()));
        assertThat(concrete.concreteIndices(), containsInAnyOrder(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b")));  
        );  
            "remote_cluster",  
        ResolvedIndices resolvedIndices = ResolvedIndices.of(new String[0]);
        ResolvedIndices resolvedIndices3 = resolvedIndices2.withRemoteIndices(
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))  
        assertArrayEquals(
    }
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b", "c"));
        ResolvedIndices resolvedIndices = ResolvedIndices.ofNonNull("a", "b", "c", null);
}  
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
        ResolvedIndices resolvedIndices = ResolvedIndices.of(List.of("a", "b"));  
            DeleteIndexAction.INSTANCE,
    public void testOfNamesCollection() {
        );
            .put(indexBuilder("index_b1"));
        assertThat(resolvedIndices.remote().asRawExpressions(), containsInAnyOrder("remote_cluster:remote_index"));  
import org.opensearch.test.OpenSearchTestCase;  
        ResolvedIndices resolvedIndices = ResolvedIndices.of(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b"));
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();  
        ResolvedIndices resolvedIndices = ResolvedIndices.of(new String[0]);
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
    }
        assertTrue(resolvedIndices.local().containsAny(i -> i.equals("a")));
        Metadata.Builder metadata = Metadata.builder()  
        ResolvedIndices resolvedIndices2 = ResolvedIndices.of(ResolvedIndices.Local.Concrete.of(new Index("index", "index_uuid")))  
    public void testOfNames() {
        assertNotEquals(resolvedIndices1.hashCode(), resolvedIndices3.hashCode());
        Set<String> names = Set.of("index_a", "index_b", "index_c");
    public void testOfConcreteIndices() {
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
            .withRemoteIndices(Map.of("remote", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)))
        concrete = concrete.withoutResolutionErrors();
    public void testLocalConcreteOf() {
    public void testWithLocalSubActions() {
    }
    }
        assertTrue(resolvedIndices.local().contains("a"));
            Map.of("remote2", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN))
    private static IndexMetadata.Builder indexBuilder(String index) {  
        ResolvedIndices resolvedIndices1 = ResolvedIndices.of("index")
import org.opensearch.cluster.ClusterName;
    }  
        ResolvedIndices.Local.Concrete concrete = (ResolvedIndices.Local.Concrete) resolvedIndices.local();
    }
        ResolvedIndices.Local.Concrete concrete = ResolvedIndices.Local.Concrete.of(indices, names)
        assertThat(
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("other"));
        assertFalse(resolvedIndices.local().contains("x"));
import org.opensearch.cluster.ClusterState;  
    public void testWithRemoteIndices() {
        assertNotEquals(resolvedIndices1.hashCode(), resolvedIndices3.hashCode());
    }  
        assertThat(concrete.names(), containsInAnyOrder("index_a", "index_b", "index_c"));
        );
        OriginalIndices originalIndices = new OriginalIndices(new String[] { "x", "y" }, IndicesOptions.LENIENT_EXPAND_OPEN);  
            .withResolutionErrors(new IndexNotFoundException("index_x"));  
    public void testUnknown() {
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;  
        ResolvedIndices resolvedIndices = ResolvedIndices.of("a", "b", "c");  
        ResolvedIndices resolvedIndices2 = ResolvedIndices.of("index")
        assertTrue(resolvedIndices.local().isEmpty());
        assertThat(concrete.namesOfConcreteIndices(), containsInAnyOrder("index_a", "index_b"));  
 */  
        ResolvedIndices resolvedIndices = ResolvedIndices.of("index_not_existing", "alias_a", "index_b1");
        assertThat(concrete.concreteIndices(), containsInAnyOrder(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b")));
        ResolvedIndices resolvedIndices1 = ResolvedIndices.of(ResolvedIndices.Local.Concrete.of(new Index("index", "index_uuid")))  
    public void testNamesWithClusterState() {
    public void testEqualsHashCode() {  
        ResolvedIndices.Local local = ResolvedIndices.Local.of(List.of("o", "p", "q"));
        assertFalse(resolvedIndices1.equals(resolvedIndices3));
        assertFalse(resolvedIndices3.equals(resolvedIndices1));  
        assertTrue(resolvedIndices.local().containsAny(List.of("a", "x")));  
            new String[] { "remote_index" },  
    public void testHashCodeForConcreteIndices() {
        assertThat(resolvedIndices.local().subActions().get(DeleteIndexAction.NAME).names(), containsInAnyOrder("x", "y", "z"));  
        OptionallyResolvedIndices resolvedIndices = ResolvedIndices.unknown();
        );
        resolvedIndices = OptionallyResolvedIndices.unknown();
        assertTrue(resolvedIndices2 + " equals " + resolvedIndices1, resolvedIndices2.equals(resolvedIndices1));
    }  
        assertThat(concrete.concreteIndices(), containsInAnyOrder(new Index("index_a", "uuid_a"), new Index("index_b", "uuid_b")));
        assertFalse(resolvedIndices instanceof ResolvedIndices);  
    }
        assertTrue(resolvedIndices.remote().isEmpty());  
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b"));
        assertTrue(resolvedIndices.local().containsAny(i -> false));  
    }  
        assertNotEquals(resolvedIndices1.hashCode(), ResolvedIndices.unknown().hashCode());
/*  
            containsInAnyOrder("index_not_existing", "index_a1", "index_a2", "index_b1")
        ResolvedIndices resolvedIndices = ResolvedIndices.of("a", "b", "c").withLocalOriginalIndices(originalIndices);
        Metadata.Builder metadata = Metadata.builder()
        );  
        return IndexMetadata.builder(index)
        ResolvedIndices resolvedIndices = ResolvedIndices.of(new String[0]).withRemoteIndices(remoteIndices);  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(resolvedIndices1.hashCode(), resolvedIndices2.hashCode());
            new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("other"));  
            .settings(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.Index;
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b", "c"));
import org.opensearch.index.IndexNotFoundException;
import static org.hamcrest.Matchers.equalTo;
            resolvedIndices.remote().asClusterToOriginalIndicesMap().get("remote_cluster").indices()
    }
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b", "c"));  
    public void testWithoutRemoteIndices() {
import java.util.Set;
        assertFalse(resolvedIndices1.equals(resolvedIndices3));
import java.util.Map;
        assertTrue(resolvedIndices.local().containsAny(List.of("whatever")));
        assertThat(resolvedIndices.local(), isA(ResolvedIndices.Local.Concrete.class));
            .withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of("other"));
    }  
        assertThat(resolvedIndices.local().names(ClusterState.EMPTY_STATE), containsInAnyOrder("a", "b", "c"));
import java.util.Arrays;
        assertTrue(resolvedIndices.local().contains("whatever"));
        assertFalse(resolvedIndices1.equals(ResolvedIndices.unknown()));
import static org.hamcrest.Matchers.isA;  
public class ResolvedIndicesTests extends OpenSearchTestCase {
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))
 * SPDX-License-Identifier: Apache-2.0
    public void testLocalOf() {  
        ResolvedIndices resolvedIndices = ResolvedIndices.of("a", "b", "c");
        ResolvedIndices resolvedIndices3 = resolvedIndices2.withLocalSubActions(  
import org.opensearch.action.support.IndicesOptions;
            .withRemoteIndices(Map.of("remote", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)))
        assertTrue(resolvedIndices2 + " equals " + resolvedIndices1, resolvedIndices2.equals(resolvedIndices1));  
        assertThat(concrete.names(), containsInAnyOrder("index_a", "index_b", "index_c"));
        assertFalse(resolvedIndices.local().isEmpty());  
    }
        ResolvedIndices resolvedIndices = ResolvedIndices.of("a", "b", "c")  
        assertThat(
 *
        assertEquals("ResolvedIndices{unknown=true}", resolvedIndices.toString());
import org.opensearch.Version;
        assertThat(resolvedIndices.local().names(), containsInAnyOrder("a", "b", "c"));
        ResolvedIndices.Local.Concrete concrete = ResolvedIndices.Local.Concrete.of(indices, names).withResolutionErrors();
        assertThat(Arrays.asList(resolvedIndices.local().namesAsArray()), containsInAnyOrder("a", "b", "c"));
    }
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    public void testWithLocalOriginalIndices() {
            ResolvedIndices.unknown().local().names(clusterState),
        assertThat(local.names(), containsInAnyOrder("o", "p", "q"));
            .withRemoteIndices(Map.of("remote", new OriginalIndices(new String[] { "remote_index" }, IndicesOptions.LENIENT_EXPAND_OPEN)))
        assertTrue(resolvedIndices.remote().asClusterToOriginalIndicesMap().isEmpty());  
        assertTrue(resolvedIndices1 + " equals " + resolvedIndices2, resolvedIndices1.equals(resolvedIndices2));
        assertFalse(resolvedIndices.local().isEmpty());  
            .put(indexBuilder("index_b1"));  
    public void testOfEmpty() {  
import org.opensearch.action.OriginalIndices;
        assertFalse(resolvedIndices instanceof ResolvedIndices);
        Map<String, OriginalIndices> remoteIndices = Map.of(
