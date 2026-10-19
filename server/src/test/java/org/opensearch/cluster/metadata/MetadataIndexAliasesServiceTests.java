            afterAddWriteAlias,  
            before,  
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")  
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
            exception.getMessage(),
                Collections.singletonList(new AliasAction.Add("test1", "alias", null, null, null, null, true))
                Collections.singletonList(new AliasAction.Add("test1", "alias", null, null, null, null, true))
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
        assertAliasesVersionIncreased("test", before, after);
        }
        Exception exception = expectThrows(
        assertNotNull(alias);
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        final int length = randomIntBetween(2, 8);
        final ClusterState afterChangeNonWriteAliasToWriteAlias = service.applyAliasActions(
/*  
        final int length = randomIntBetween(2, 8);
/*  
        {
            .settings(settings(Version.CURRENT))
            applyHiddenAliasMix(before, true, true);
        IllegalArgumentException exception = expectThrows(
        );  
            singletonList(new AliasAction.Add(index, "test", null, null, null, null, null))
    public void testAddAndRemove() {
        {
    public void testAddingAliasMoreThanOnceShouldOnlyIncreaseAliasesVersionByOne() {  
        originalState = createIndex(originalState, "test2");  
            before,  
        final ClusterState afterRemoveAndAddAlias = service.applyAliasActions(afterAddingAlias, removeAndAddActions);
        );  
    }
        return service.applyAliasActions(
        assertFalse(after.metadata().index("test").getAliases().get("alias").writeIndex());  
            .numberOfReplicas(1)
        after = service.applyAliasActions(before, singletonList(new AliasAction.Remove(index, "test_2", randomBoolean())));  
            .putAlias(AliasMetadata.builder("alias").build())
            final long actual = after.metadata().index(index).getAliasesVersion();
            .putAlias(AliasMetadata.builder("alias").build())
        );  
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
        // Now just remove on its own
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);  
        {
            singletonList(new AliasAction.Add(index, "test", null, null, null, null, null))
    private void assertAliasesVersionIncreased(final String index, final ClusterState before, final ClusterState after) {
                assertTrue("index now found", state.metadata().hasConcreteIndex(index.getName()));
        );
import org.opensearch.test.VersionUtils;
        assertNull(after.metadata().getIndicesLookup().get("test_2"));
                Collections.singletonList(new AliasAction.Add("test1", "alias", null, null, null, null, randomFrom(false, null)))
            assertThat(exception.getMessage(), startsWith("alias [alias] has is_hidden set to true on indices ["));
        );
        final ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);
    public void testAddWriteOnlyWithIndexRemoved() {  
        {  
        final Set<String> randomIndices = new HashSet<>(length);
        );
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < length; i++) {
    public void testAliasesVersionUnchangedWhenActionsAreIdempotent() {  
            removeAndAddActions.add(new AliasAction.Add(index, aliasName, null, null, null, null, null));  
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")  
import java.util.Collections;
            );
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
            .settings(settings(Version.CURRENT))
    }
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test3")));  
    }  
        ClusterState after = service.applyAliasActions(before, Collections.singletonList(new AliasAction.RemoveIndex("test")));
            .numberOfReplicas(1);
        IndexAbstraction alias = after.metadata().getIndicesLookup().get("test");
        // Now just remove on its own
 */
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        final int length = randomIntBetween(1, 8);
import org.opensearch.cluster.ClusterState;  
        // Try to remove an index twice. This should just remove the index once....  
        assertThat(iae.getMessage(), containsString("aliases [test_2] missing"));  
 * KIND, either express or implied.  See the License for the
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")  
            Arrays.asList(  
        assertThat(after.metadata().index("test").getAliases().get("alias").writeIndex(), equalTo(unsetValue));  
        {
 * You may obtain a copy of the License at  
                Collections.singletonList(new AliasAction.Add("test2", "alias", null, null, null, null, true))
        );
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));  
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test2")));
                Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, null, null), new AliasAction.RemoveIndex("test"))
import java.util.HashSet;
import static org.mockito.Mockito.anySet;
        );
            singletonList(new AliasAction.Add(index, "test", null, null, null, true, null))
    private void assertAliasesVersionIncreased(final String[] indices, final ClusterState before, final ClusterState after) {
            addActions.add(new AliasAction.Add(index, "alias-" + index, null, null, null, null, null));
                testState,
            Arrays.asList(new AliasAction.Remove(index, "test", true), new AliasAction.Add(index, "test_2", null, null, null, null, null))
            // Add a hidden alias to one index
            Metadata.Builder meta = Metadata.builder(state.metadata());
                before,
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), "test");
            .numberOfReplicas(1);
        assertNull(after.metadata().getIndicesLookup().get("test"));  
    public void testHiddenPropertyValidation() {  
            assertThat("index metadata aliases version mismatch", actual, equalTo(expected));  
                Arrays.asList(  
        assertAliasesVersionUnchanged("test", before, after);
            .build();
        assertAliasesVersionIncreased(index, before, after);
    );  
import static org.hamcrest.Matchers.contains;
            before = createIndex(before, index);
        // Remove the alias from it with mustExist == true while adding another one
        final AliasesNotFoundException iae = expectThrows(
        before = after;
            .numberOfShards(1)  
            .build();  
        }
import java.util.ArrayList;
    }
            }  
 * software distributed under the License is distributed on an
        for (int i = 0; i < length; i++) {
                    .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), singletonList(indexMetadata.getIndex())))
        assertNull(after.metadata().getIndicesLookup().get("test"));
            assertThat(exception.getMessage(), startsWith("alias [alias] has is_hidden set to true on indices ["));  
        final List<AliasAction> removeAndAddActions = new ArrayList<>(2 * length);  
 *
            Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, null, null))
        when(deleteIndexService.deleteIndices(any(ClusterState.class), anySet())).then(i -> {
                Collections.singletonList(new AliasAction.Add("test1", "alias", null, null, null, null, randomFrom(false, null)))  
    }
        assertNull(after.metadata().getIndicesLookup().get("test"));
import static java.util.Collections.singletonList;  
        after = service.applyAliasActions(before, Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, null, null)));
    }
            // Adding the same alias as hidden should be OK
        final ClusterState afterAddingRandomAliases = service.applyAliasActions(afterAddingAliasesToAll, randomAddActions);
        originalState = createIndex(originalState, "test1");
            .build();  
    }
        }
            singletonList(new AliasAction.Add(index, "test", null, null, null, false, null))
        assertThat(  
import java.util.Collection;  
            // Adding the same alias as hidden to another index should throw  
                originalState,
            applyHiddenAliasMix(before, null, false);  
            Exception exception = expectThrows(
            );
            .build();  
        // Add an alias to it
                Collections.singletonList(new AliasAction.Add("test2", "alias", null, null, null, null, randomFrom(false, null)))
        }
            .settings(settings(Version.CURRENT))
        final List<AliasAction> addActions = new ArrayList<>(length);  
        assertNull(after.metadata().getIndicesLookup().get("test"));
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test2")));
    private final MetadataIndexAliasesService service = new MetadataIndexAliasesService(  
            afterAddingRandomAliases  
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
import static org.hamcrest.Matchers.startsWith;  
            .settings(settings(Version.CURRENT))  
            final String aliasName = randomValueOtherThanMany(v -> aliasNames.add(v) == false, () -> randomAlphaOfLength(8));  
            () -> service.applyAliasActions(  
 * the Apache License, Version 2.0 (the "License"); you may
        final ClusterState afterAddingAliases = service.applyAliasActions(before, addActions);
            before,  
            .settings(settings(Version.CURRENT))  
            // Add a hidden alias to one index
                new AliasAction.Add("test2", "alias", null, null, null, null, isHidden2)
            )
    public MetadataIndexAliasesServiceTests() {
            );  
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));  
        ClusterState originalState = ClusterState.EMPTY_STATE;
        after = service.applyAliasActions(before, Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, true, null)));  
    public void testSimultaneousHiddenPropertyValidation() {  
            .numberOfReplicas(1);
        // Show that removing non-existing alias with mustExist == true fails  
            before,
        assertAliasesVersionIncreased(new String[] { index }, before, after);
                () -> applyHiddenAliasMix(before, randomFrom(false, null), true)
            final long expected = before.metadata().index(index).getAliasesVersion();
        );
                Collections.singletonList(new AliasAction.Add("test2", "alias", null, null, null, null, randomFrom(false, null)))
            singletonList(new AliasAction.Add(index, "test", null, null, null, true, null))
            .settings(settings(Version.CURRENT))
        Exception exception = expectThrows(
 */  
            .settings(settings(Version.CURRENT))
        List<AliasAction> swapActions = Arrays.asList(  
            // Adding the same alias as non-hidden should be OK
        }  
        assertEquals("test", e.getIndex().getName());
            .numberOfShards(1)  
        );  
            .numberOfReplicas(1);
        assertAliasesVersionIncreased("test", before, after);
    private void assertAliasesVersionUnchanged(final String[] indices, final ClusterState before, final ClusterState after) {
            () -> service.applyAliasActions(
                )  
        final String index = randomAlphaOfLength(8);
        assertThat(alias.getIndices(), contains(after.metadata().index(index)));  
        IndexAbstraction alias = after.metadata().getIndicesLookup().get("test");  
            .numberOfShards(1)  
            .numberOfShards(1)
            .build();
    }  
            ));  
        assertAliasesVersionIncreased("test", before, after);  
 * license agreements. See the NOTICE file distributed with
            service.applyAliasActions(
            .numberOfReplicas(1);  
            IllegalStateException.class,  
    public void testAddAliasToRemovedIndex() {
        final String index = randomAlphaOfLength(8);
        assertThat(exception.getMessage(), startsWith("alias [alias] has more than one write index ["));  
            final long expected = 1 + before.metadata().index(index).getAliasesVersion();
        final ClusterState afterChangeWriteAliasToNonWriteAlias = service.applyAliasActions(
        for (int i = 0; i < length; i++) {
            applyHiddenAliasMix(before, false, null);
            .metadata(
            assertThat(ex.getMessage(), containsString("alias [alias] has is_hidden set to true on indices"));  
 * specific language governing permissions and limitations
        assertAliasesVersionIncreased(index, before, afterAddWriteAlias);  
            ClusterState testState = service.applyAliasActions(
        }
                before,
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);  
        mock(ClusterService.class),
 *  
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);
}
import static org.mockito.Mockito.mock;  
        ClusterState after = service.applyAliasActions(
        assertNull(before.metadata().getIndicesLookup().get("alias").getWriteIndex());
        Boolean unsetValue = randomBoolean() ? null : false;
            .settings(settings(Version.CURRENT))
            ClusterState state = (ClusterState) i.getArguments()[0];
    }  
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
                testState,  
        assertAliasesVersionUnchanged("test2", before, after);
        aliasValidator,  
            .settings(settings(Version.CURRENT))
        }  
            () -> service.applyAliasActions(before, Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, true, null)))
        );
        final List<AliasAction> addActions = new ArrayList<>(length);
            assertThat(ex.getMessage(), containsString("alias [alias] has is_hidden set to true on indices"));
            () -> service.applyAliasActions(
    public void testRemoveIndexTwice() {
        {  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        before = createIndex(before, "test_2");  
            // Add a non-hidden alias to one index
        );
            before,
    public void testSwapIndexWithAlias() {  
        null,
        for (final String index : indices) {  
        );
                singletonList(new AliasAction.Add(backingIndexName, "test", null, null, null, null, null))  
    }  
        }
        assertAliasesVersionUnchanged("test2", before, after);  
            afterAddingAliasesToAll,
            .numberOfShards(1)
        assertNull(before.metadata().getIndicesLookup().get("alias").getWriteIndex());
                    + "[foo-stream]. Data streams and their backing indices don't support alias operations."
        assertAliasesVersionIncreased(index, before, afterAddingAliases);  
        assertNotNull(alias);
        );
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
            .putAlias(AliasMetadata.builder("alias").writeIndex(randomBoolean() ? null : false).build())  
                    new AliasAction.Add("test", "alias", null, null, null, true, null),
                randomAddActions.add(new AliasAction.Add(index, "random-alias-" + index, null, null, null, null, null));  
            before,
 * ownership. Elasticsearch licenses this file to you under  
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
        for (final String index : indices) {  
        // now add some aliases randomly
 * this work for additional information regarding copyright
            .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
public class MetadataIndexAliasesServiceTests extends OpenSearchTestCase {  
            .numberOfShards(1)
            service.applyAliasActions(  
        // Mock any deletes so we don't need to worry about how MetadataDeleteIndexService does its job  
            Exception ex = expectThrows(IllegalStateException.class, () -> // Add a non-hidden alias to one index
        assertAliasesVersionIncreased(index, before, after);  
        // Create a state with a single index
        );
                "The provided index [ .ds-foo-stream-000001] is a backing index belonging to data stream "  
        before = after;
        final Set<String> indices = new HashSet<>(length);
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), "test");
    public void testChangingWriteAliasStateIncreasesAliasesVersion() {
        }  
    private final MetadataDeleteIndexService deleteIndexService = mock(MetadataDeleteIndexService.class);
            .settings(settings(Version.CURRENT))  
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test")));
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT).build();  
            service.applyAliasActions(
    }
            Arrays.asList(new AliasAction.RemoveIndex("test"), new AliasAction.RemoveIndex("test"))  
                new AliasAction.Add("test", "alias", null, null, null, null, isHidden1),
    private final AliasValidator aliasValidator = new AliasValidator();
        final ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);
        IndexMetadata.Builder indexMetadata3 = IndexMetadata.builder("test3")  
        );
                originalState,
        assertAliasesVersionIncreased("test3", before, after);  
        assertNull(before.metadata().index("test").getAliases().get("alias").writeIndex());  
        ClusterState after = service.applyAliasActions(
            )
                IllegalStateException.class,  
        assertAliasesVersionIncreased(index, afterAddWriteAlias, afterChangeWriteAliasToNonWriteAlias);  
        before = after;
import static org.hamcrest.Matchers.equalTo;
        Collections.shuffle(swapActions, random());
        assertNull(before.metadata().index("test2").getAliases().get("alias").writeIndex());
    public void testAliasesForDataStreamBackingIndicesNotSupported() {
        );
            .numberOfShards(1)
            for (Index index : indices) {  
    private ClusterState applyHiddenAliasMix(ClusterState before, Boolean isHidden1, Boolean isHidden2) {  
        final ClusterState afterAddingAliasesToAll = service.applyAliasActions(before, addActions);
import java.util.Set;
        final ClusterState afterAddWriteAlias = service.applyAliasActions(
            ClusterState testState = service.applyAliasActions(
            IllegalArgumentException.class,  
import static org.mockito.Mockito.any;
        });
            .numberOfShards(1)  
        after = service.applyAliasActions(
 * compatible open source license.
        assertNull(after.metadata().index("test2").getAliases().get("alias").writeIndex());
        }
            new AliasAction.Add("test", "alias", null, null, null, unsetValue, null),
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
            .build();
        assertAliasesVersionIncreased(indices.toArray(new String[0]), before, afterAddingAliasesToAll);
        String dataStreamName = "foo-stream";
        assertNotNull(alias);
        assertAliasesVersionIncreased(index, afterChangeWriteAliasToNonWriteAlias, afterChangeNonWriteAliasToWriteAlias);  
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))  
            addActions.add(new AliasAction.Add(index, "test", null, null, null, null, null));
        // Remove the alias from it while adding another one  
            .settings(settings(Version.CURRENT))
                randomIndices.add(index);
        for (String index : indices) {
        ClusterState after = service.applyAliasActions(
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test2")));  
        assertTrue(after.metadata().index("test2").getAliases().get("alias").writeIndex());
import org.opensearch.cluster.service.ClusterService;
        final List<AliasAction> randomAddActions = new ArrayList<>(length);  
        );  
        // add some aliases to the index
            .settings(settings(Version.CURRENT))  
    }
            .settings(settings(Version.CURRENT))
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test")));  
            removeAndAddActions.add(new AliasAction.Remove(index, aliasName, null));
            applyHiddenAliasMix(before, null, null);  
        assertNull(after.metadata().getIndicesLookup().get("test_2"));  
        }
    }
            if (randomBoolean()) {
            .build();  
        assertThat(alias.getIndices(), contains(after.metadata().index(index)));
            .numberOfReplicas(1);
            before,
    }
        final ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);  
    public void testAddWriteOnlyWithExistingWriteIndex() {  
            ClusterState testState = service.applyAliasActions(  
        final Set<String> aliasNames = new HashSet<>();  
            // Add a non-hidden alias to one index  
        for (final String aliasName : aliasNames) {
            );
import org.opensearch.index.IndexNotFoundException;
        alias = after.metadata().getIndicesLookup().get("test_2");
import static org.mockito.Mockito.when;
        assertNull(after.metadata().getIndicesLookup().get("test"));
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
            .numberOfShards(1)
        IndexAbstraction alias = after.metadata().getIndicesLookup().get("test");
            () -> service.applyAliasActions(finalCS, singletonList(new AliasAction.Remove(index, "test_2", true)))
            );
            Arrays.asList(new AliasAction.Add("test3", "alias", null, null, null, true, null))  
import org.opensearch.cluster.ClusterName;
        assertAliasesVersionIncreased("test", before, after);
                    new AliasAction.Add("test2", "alias", null, null, null, true, null)
        // Create "test" and "test_2"
            )
        assertAliasesVersionIncreased(index, before, after);  
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
import java.util.List;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IllegalStateException.class,  
        assertAliasesVersionIncreased(index, before, after);
        assertNull(after.metadata().index("test").getAliases().get("alias").writeIndex());  
        // Create a state with a single index  
    }
        );
            AliasesNotFoundException.class,  
    public void testSwapWriteOnlyIndex() {  
                Collections.singletonList(new AliasAction.Add("test2", "alias", null, null, null, null, true))
        deleteIndexService,
            .numberOfShards(1)
        assertAliasesVersionUnchanged(new String[] { index }, before, after);
 * this file be licensed under the Apache-2.0 license or a
        final ClusterState finalCS = after;
        final List<AliasAction> addActions = new ArrayList<>(length);
            .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())  
    }
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));  
        // Attempt to add an alias to "test" at the same time as we remove it  
                originalState,  
    private ClusterState createIndex(ClusterState state, String index) {
                Metadata.builder()
                IllegalStateException.class,
            .build();  
        assertNotNull(alias);
        ClusterState after = service.applyAliasActions(
        }  
            addActions.add(new AliasAction.Add(index, aliasName, null, null, null, null, null));
    private void assertAliasesVersionUnchanged(final String index, final ClusterState before, final ClusterState after) {
            @SuppressWarnings("unchecked")  
                testState,  
            .numberOfReplicas(1);
    }
        String index = randomAlphaOfLength(5);
            Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, false, null))
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), "test");
        after = service.applyAliasActions(before, singletonList(new AliasAction.Remove(index, "test_2", randomBoolean())));
        }
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
                state,
            Arrays.asList(new AliasAction.Add("test_2", "test", null, null, null, null, null), new AliasAction.RemoveIndex("test"))
    }
                testState,
            );
            .numberOfShards(1)
        );
        assertNotNull(alias);  
            .numberOfReplicas(1);
        String index = randomAlphaOfLength(5);
            before,  
        xContentRegistry()
import org.opensearch.common.settings.Settings;
        final String index = randomAlphaOfLength(8);
        assertThat(alias.getIndices(), contains(after.metadata().index("test_2")));
        return ClusterState.builder(state).metadata(Metadata.builder(state.metadata()).put(indexMetadata, false)).build();
        assertAliasesVersionIncreased(index, before, after);
        // Create "test"  
 * GitHub history for details.
        }  
    }
        // Now remove "test" and add an alias to "test" to "test_2" in one go
            Exception exception = expectThrows(  
        ClusterState after = service.applyAliasActions(
            .numberOfShards(1)
        assertAliasesVersionIncreased(index, before, after);
            applyHiddenAliasMix(before, false, false);
    public void testAddWriteOnlyValidatesAgainstMetadataBuilder() {
import org.opensearch.core.index.Index;
        assertThat(alias.getIndices(), contains(after.metadata().index(index)));
            .numberOfReplicas(1);  
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), "test");  
            )  
            );  
 *
        ClusterState after = service.applyAliasActions(before, swapActions);
            return ClusterState.builder(state).metadata(meta).build();
        after = service.applyAliasActions(  
            ));
        alias = after.metadata().getIndicesLookup().get("test_2");
    }
    }  
                    .put(indexMetadata, true)  
            }
            Arrays.asList(new AliasAction.Remove(index, "test", null), new AliasAction.Add(index, "test_2", null, null, null, null, null))
    public void testMustExist() {  
    }
        {
 * under the License.  
            .numberOfReplicas(1);  
            .numberOfShards(1)
        IndexMetadata indexMetadata = IndexMetadata.builder(backingIndexName)
            .numberOfReplicas(1)
            IndexNotFoundException.class,
            .settings(settings(Version.CURRENT))  
        assertAliasesVersionIncreased("test2", before, after);
        assertAliasesVersionIncreased("test_2", before, after);
    public void testMultipleIndices() {  
        ClusterState after = service.applyAliasActions(  
            is(
        final ClusterState afterAddingAlias = service.applyAliasActions(before, addActions);  
        assertAliasesVersionIncreased("test", before, after);  
import org.opensearch.common.util.set.Sets;  
            .settings(Settings.builder().put("index.version.created", VersionUtils.randomVersion(random())))  
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;  
        // Add an alias to it
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        // add an alias to the index multiple times
        assertAliasesVersionIncreased(randomIndices.toArray(new String[0]), afterAddingAliasesToAll, afterAddingRandomAliases);
            );  
        assertAliasesVersionUnchanged("test2", before, after);
        ClusterState after = service.applyAliasActions(  
            afterChangeWriteAliasToNonWriteAlias,  
        // now perform a remove and add for each alias which is idempotent, the resulting aliases are unchanged
        );
            )
            Exception ex = expectThrows(IllegalStateException.class, () -> // Add a non-hidden alias to one index
    }
            before,
package org.opensearch.cluster.metadata;
        assertTrue(after.metadata().index("test3").getAliases().get("alias").writeIndex());
            .putAlias(AliasMetadata.builder("alias").writeIndex(randomBoolean() ? null : false).build())
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)  
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
            .numberOfReplicas(1);
 */  
            Sets.difference(indices, randomIndices).toArray(new String[0]),
            // These should all be fine
            before,  
        assertTrue(after.metadata().index("test").getAliases().get("alias").writeIndex());
            assertThat("index metadata aliases version mismatch", actual, equalTo(expected));  
            ClusterState testState = service.applyAliasActions(
            .numberOfShards(1)
                meta.remove(index.getName()); // We only think about metadata for this test. Not routing or any other fun stuff.
        // Create "test"  
            // Adding the same alias as non-hidden to another index should throw
import static org.hamcrest.Matchers.containsString;  
            .build();  
import org.opensearch.Version;
import org.opensearch.test.OpenSearchTestCase;
import java.util.Arrays;
    }  
                originalState,  
            .numberOfReplicas(1);  
        assertThat(alias.getIndices(), contains(after.metadata().index(index)));
        assertNull(after.metadata().index("test").getAliases().get("alias").writeIndex());
        IndexNotFoundException e = expectThrows(
            Collection<Index> indices = (Collection<Index>) i.getArguments()[1];
            .numberOfReplicas(1);  
                () -> applyHiddenAliasMix(before, true, randomFrom(false, null))
            before,
    public void testAddWriteOnlyWithNoExistingAliases() {
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
            final long actual = after.metadata().index(index).getAliasesVersion();
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
        before = after;  
            service.applyAliasActions(  
            )  
        assertNull(after.metadata().getIndicesLookup().get("alias").getWriteIndex());
            .numberOfShards(1)
        assertAliasesVersionUnchanged(  
        assertThat(exception.getMessage(), startsWith("alias [alias] has more than one write index ["));  
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
            new AliasAction.Add("test2", "alias", null, null, null, true, null)
        assertAliasesVersionUnchanged(index, afterAddingAlias, afterRemoveAndAddAlias);  
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.is;
/*
    public void testAddWriteOnlyWithExistingNonWriteIndices() {
            final String index = randomValueOtherThanMany(v -> indices.add(v) == false, () -> randomAlphaOfLength(8));  
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2).put(indexMetadata3))
