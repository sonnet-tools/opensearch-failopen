        assertThat(alias.getIndices(), contains(after.metadata().index(index)));
        }
            .numberOfShards(1)
        // Create a state with a single index
        );
        assertAliasesVersionIncreased(index, before, afterAddWriteAlias);
        assertFalse(after.metadata().index("test").getAliases().get("alias").writeIndex());
        final int length = randomIntBetween(2, 8);
            ClusterState testState = service.applyAliasActions(
            )
            applyHiddenAliasMix(before, false, null);
            before,
import static org.hamcrest.Matchers.startsWith;
        assertNull(after.metadata().getIndicesLookup().get("test"));
    public void testAddWriteOnlyValidatesAgainstMetadataBuilder() {
        Boolean unsetValue = randomBoolean() ? null : false;
        IndexMetadata indexMetadata = IndexMetadata.builder(index)
            final String aliasName = randomValueOtherThanMany(v -> aliasNames.add(v) == false, () -> randomAlphaOfLength(8));
        );
        final ClusterState afterAddingAliasesToAll = service.applyAliasActions(before, addActions);
            ClusterState testState = service.applyAliasActions(
import static org.mockito.Mockito.anySet;
            singletonList(new AliasAction.Add(index, "test", null, null, null, false, null))
        assertEquals("test", e.getIndex().getName());
        );
            .build();
        }
        alias = after.metadata().getIndicesLookup().get("test_2");
            );
            )
                randomIndices.add(index);
        IndexAbstraction alias = after.metadata().getIndicesLookup().get("test");
            .putAlias(AliasMetadata.builder("alias").build())
        deleteIndexService,
        after = service.applyAliasActions(before, Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, null, null)));
            final String index = randomValueOtherThanMany(v -> indices.add(v) == false, () -> randomAlphaOfLength(8));
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test3")));
            .settings(settings(Version.CURRENT))
        // Now remove "test" and add an alias to "test" to "test_2" in one go
            final long expected = 1 + before.metadata().index(index).getAliasesVersion();
            .settings(settings(Version.CURRENT))
        );
            .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
import org.opensearch.core.index.Index;
 */
    }
        assertAliasesVersionIncreased(index, before, after);
        );
            afterAddWriteAlias,
            .build();
    public void testMultipleIndices() {
    }
            .build();
            singletonList(new AliasAction.Add(index, "test", null, null, null, true, null))
        ClusterState after = service.applyAliasActions(
        assertAliasesVersionIncreased("test", before, after);
        );
import java.util.Set;
    private final MetadataDeleteIndexService deleteIndexService = mock(MetadataDeleteIndexService.class);
            .numberOfShards(1)
 * Unless required by applicable law or agreed to in writing,
            .settings(settings(Version.CURRENT))
        );
    }
            addActions.add(new AliasAction.Add(index, "alias-" + index, null, null, null, null, null));
        assertAliasesVersionUnchanged("test", before, after);
        assertAliasesVersionIncreased(index, afterAddWriteAlias, afterChangeWriteAliasToNonWriteAlias);
            before,
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), "test");
        Collections.shuffle(swapActions, random());
            .settings(settings(Version.CURRENT))
            Arrays.asList(new AliasAction.Remove(index, "test", null), new AliasAction.Add(index, "test_2", null, null, null, null, null))
            .numberOfReplicas(1);
    public void testAddAndRemove() {
        null,
        before = after;
            @SuppressWarnings("unchecked")
            .settings(settings(Version.CURRENT))
            .numberOfReplicas(1);
            .build();
    }
            }
            .putAlias(AliasMetadata.builder("alias").build())
        Exception exception = expectThrows(
                () -> applyHiddenAliasMix(before, randomFrom(false, null), true)
            ClusterState testState = service.applyAliasActions(
        assertThat(alias.getIndices(), contains(after.metadata().index(index)));
 * the Apache License, Version 2.0 (the "License"); you may
        assertAliasesVersionIncreased(index, before, after);
            .numberOfShards(1)
        final ClusterState afterAddingRandomAliases = service.applyAliasActions(afterAddingAliasesToAll, randomAddActions);
        for (final String aliasName : aliasNames) {
                IllegalStateException.class,
    }
            // Add a non-hidden alias to one index
            final long expected = before.metadata().index(index).getAliasesVersion();
        return ClusterState.builder(state).metadata(Metadata.builder(state.metadata()).put(indexMetadata, false)).build();
            IllegalArgumentException.class,
            singletonList(new AliasAction.Add(index, "test", null, null, null, null, null))
    public void testRemoveIndexTwice() {
        ClusterState after = service.applyAliasActions(
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test")));
            Metadata.Builder meta = Metadata.builder(state.metadata());
                () -> applyHiddenAliasMix(before, true, randomFrom(false, null))
        // Add an alias to it
    }
                originalState,
            before,
            Sets.difference(indices, randomIndices).toArray(new String[0]),
                Collections.singletonList(new AliasAction.Add("test2", "alias", null, null, null, null, randomFrom(false, null)))
            // Add a hidden alias to one index
            Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, null, null))
        });
        final ClusterState afterChangeNonWriteAliasToWriteAlias = service.applyAliasActions(
        for (final String index : indices) {
                    new AliasAction.Add("test", "alias", null, null, null, true, null),
            ));
import static org.hamcrest.Matchers.containsString;
import java.util.HashSet;
                Collections.singletonList(new AliasAction.Add("test1", "alias", null, null, null, null, randomFrom(false, null)))
            is(
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
            addActions.add(new AliasAction.Add(index, aliasName, null, null, null, null, null));
            .build();
                Collections.singletonList(new AliasAction.Add("test1", "alias", null, null, null, null, randomFrom(false, null)))
        // Remove the alias from it while adding another one
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        after = service.applyAliasActions(before, singletonList(new AliasAction.Remove(index, "test_2", randomBoolean())));
        // Attempt to add an alias to "test" at the same time as we remove it
            .build();
 */
    public void testAddAliasToRemovedIndex() {
        assertThat(alias.getIndices(), contains(after.metadata().index("test_2")));
        for (int i = 0; i < length; i++) {
    public void testAddWriteOnlyWithExistingNonWriteIndices() {
            );
        assertNull(after.metadata().index("test2").getAliases().get("alias").writeIndex());
        String index = randomAlphaOfLength(5);
    private void assertAliasesVersionUnchanged(final String[] indices, final ClusterState before, final ClusterState after) {
    public void testMustExist() {
            );
        assertAliasesVersionIncreased("test", before, after);
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
            )
            .numberOfShards(1)
            .numberOfShards(1)
        after = service.applyAliasActions(
            removeAndAddActions.add(new AliasAction.Add(index, aliasName, null, null, null, null, null));
            IllegalStateException.class,
            .numberOfShards(1)
            .numberOfShards(1)
            .settings(settings(Version.CURRENT))
            Collection<Index> indices = (Collection<Index>) i.getArguments()[1];
        ClusterState after = service.applyAliasActions(
import static org.mockito.Mockito.mock;
        }
        assertAliasesVersionIncreased("test", before, after);
        after = service.applyAliasActions(before, Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, true, null)));
        assertTrue(after.metadata().index("test2").getAliases().get("alias").writeIndex());
import java.util.Collections;
        );
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
 */
        final ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);
        assertAliasesVersionUnchanged("test2", before, after);
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
    }
                Collections.singletonList(new AliasAction.Add("test1", "alias", null, null, null, null, true))
    public void testAliasesForDataStreamBackingIndicesNotSupported() {
        xContentRegistry()
            .settings(Settings.builder().put("index.version.created", VersionUtils.randomVersion(random())))
        ClusterState after = service.applyAliasActions(
        assertAliasesVersionIncreased(index, before, after);
            Arrays.asList(new AliasAction.Add("test3", "alias", null, null, null, true, null))
        before = createIndex(before, "test_2");
        assertAliasesVersionUnchanged(
        // Remove the alias from it with mustExist == true while adding another one
 * ownership. Elasticsearch licenses this file to you under
            .settings(settings(Version.CURRENT))
        assertNull(after.metadata().getIndicesLookup().get("test"));
    }
        );
        assertNotNull(alias);
        assertAliasesVersionIncreased(indices.toArray(new String[0]), before, afterAddingAliasesToAll);
            applyHiddenAliasMix(before, false, false);
        {
            service.applyAliasActions(
        for (int i = 0; i < length; i++) {
            new AliasAction.Add("test2", "alias", null, null, null, true, null)
        }
        assertNull(after.metadata().index("test").getAliases().get("alias").writeIndex());
package org.opensearch.cluster.metadata;
        aliasValidator,
        }
            () -> service.applyAliasActions(
        // Show that removing non-existing alias with mustExist == true fails
import org.opensearch.cluster.ClusterName;
        assertThat(after.metadata().index("test").getAliases().get("alias").writeIndex(), equalTo(unsetValue));
        );
        assertNull(after.metadata().index("test").getAliases().get("alias").writeIndex());
        IllegalArgumentException exception = expectThrows(
                Collections.singletonList(new AliasAction.Add("test1", "alias", null, null, null, null, true))
            .numberOfReplicas(1);
        final ClusterState afterRemoveAndAddAlias = service.applyAliasActions(afterAddingAlias, removeAndAddActions);
        assertNull(before.metadata().getIndicesLookup().get("alias").getWriteIndex());
            .numberOfReplicas(1);
 * specific language governing permissions and limitations
    public void testAddingAliasMoreThanOnceShouldOnlyIncreaseAliasesVersionByOne() {
        final ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);
            .settings(settings(Version.CURRENT))
            before,
    private void assertAliasesVersionUnchanged(final String index, final ClusterState before, final ClusterState after) {
            .numberOfReplicas(1);
        assertNull(before.metadata().index("test").getAliases().get("alias").writeIndex());
 * this work for additional information regarding copyright
            .numberOfShards(1)
            new AliasAction.Add("test", "alias", null, null, null, unsetValue, null),
        assertAliasesVersionIncreased(index, before, after);
        );
    }
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
                Collections.singletonList(new AliasAction.Add("test2", "alias", null, null, null, null, true))
        assertAliasesVersionIncreased("test_2", before, after);
            .settings(settings(Version.CURRENT))
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
 * Modifications Copyright OpenSearch Contributors. See
    }
        final int length = randomIntBetween(1, 8);
        {
        assertNull(after.metadata().getIndicesLookup().get("test"));
        assertThat(iae.getMessage(), containsString("aliases [test_2] missing"));
    public MetadataIndexAliasesServiceTests() {
        assertThat(exception.getMessage(), startsWith("alias [alias] has more than one write index ["));
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2).put(indexMetadata3))
        originalState = createIndex(originalState, "test2");
            () -> service.applyAliasActions(finalCS, singletonList(new AliasAction.Remove(index, "test_2", true)))
            .settings(settings(Version.CURRENT))
        assertNotNull(alias);
            // These should all be fine
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
        assertNull(after.metadata().getIndicesLookup().get("alias").getWriteIndex());
import org.opensearch.common.util.set.Sets;
                originalState,
        assertAliasesVersionIncreased(new String[] { index }, before, after);
    public void testSimultaneousHiddenPropertyValidation() {
        // Now just remove on its own
        // Try to remove an index twice. This should just remove the index once....
    public void testAddWriteOnlyWithExistingWriteIndex() {
        );
        assertThat(alias.getIndices(), contains(after.metadata().index(index)));
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;
    public void testAddWriteOnlyWithNoExistingAliases() {
            IllegalStateException.class,
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
            .settings(settings(Version.CURRENT))
            .numberOfReplicas(1);
        assertAliasesVersionUnchanged("test2", before, after);
    }
        IndexMetadata indexMetadata = IndexMetadata.builder(backingIndexName)
    }
            .settings(settings(Version.CURRENT))
        final List<AliasAction> addActions = new ArrayList<>(length);
                new AliasAction.Add("test", "alias", null, null, null, null, isHidden1),
            )
                singletonList(new AliasAction.Add(backingIndexName, "test", null, null, null, null, null))
        String dataStreamName = "foo-stream";
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
        // Create "test"
            );
 *     http://www.apache.org/licenses/LICENSE-2.0
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
import java.util.Collection;
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
            before,
                new AliasAction.Add("test2", "alias", null, null, null, null, isHidden2)
    }
        }
                state,
            // Adding the same alias as hidden should be OK
            .numberOfShards(1)
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), "test");
/*
    public void testHiddenPropertyValidation() {
                Collections.singletonList(new AliasAction.Add("test2", "alias", null, null, null, null, randomFrom(false, null)))
                Arrays.asList(
 * Licensed to Elasticsearch under one or more contributor
            final long actual = after.metadata().index(index).getAliasesVersion();
 * GitHub history for details.
            .numberOfShards(1)
            .settings(settings(Version.CURRENT))
            .numberOfShards(1)
import org.opensearch.cluster.ClusterState;
        ClusterState after = service.applyAliasActions(
            .putAlias(AliasMetadata.builder("alias").writeIndex(randomBoolean() ? null : false).build())
            assertThat(ex.getMessage(), containsString("alias [alias] has is_hidden set to true on indices"));
        final String index = randomAlphaOfLength(8);
                    .put(indexMetadata, true)
            applyHiddenAliasMix(before, null, false);
 * You may obtain a copy of the License at
    public void testChangingWriteAliasStateIncreasesAliasesVersion() {
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
        // Mock any deletes so we don't need to worry about how MetadataDeleteIndexService does its job
        ClusterState after = service.applyAliasActions(before, Collections.singletonList(new AliasAction.RemoveIndex("test")));
            assertThat(exception.getMessage(), startsWith("alias [alias] has is_hidden set to true on indices ["));
import static org.hamcrest.Matchers.is;
 *
    private ClusterState createIndex(ClusterState state, String index) {
    }
            addActions.add(new AliasAction.Add(index, "test", null, null, null, null, null));
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);
}
        alias = after.metadata().getIndicesLookup().get("test_2");
            before,
        before = after;
import org.opensearch.common.settings.Settings;
            Arrays.asList(new AliasAction.Add("test_2", "test", null, null, null, null, null), new AliasAction.RemoveIndex("test"))
        final Set<String> randomIndices = new HashSet<>(length);
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
            .numberOfReplicas(1);
            service.applyAliasActions(
        assertAliasesVersionIncreased("test", before, after);
                IllegalStateException.class,
            .putAlias(AliasMetadata.builder("alias").writeIndex(true).build())
            .numberOfShards(1)
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, false, null))
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test2")));
        final AliasesNotFoundException iae = expectThrows(
            () -> service.applyAliasActions(
        when(deleteIndexService.deleteIndices(any(ClusterState.class), anySet())).then(i -> {
    public void testSwapWriteOnlyIndex() {
        assertAliasesVersionIncreased("test3", before, after);
            exception.getMessage(),
        final ClusterState finalCS = after;
            if (randomBoolean()) {
        List<AliasAction> swapActions = Arrays.asList(
            .numberOfReplicas(1);
    }
        );
 *
import org.opensearch.test.OpenSearchTestCase;
        for (String index : indices) {
    private ClusterState applyHiddenAliasMix(ClusterState before, Boolean isHidden1, Boolean isHidden2) {
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test")));
            .numberOfReplicas(1);
            service.applyAliasActions(
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test2")));
        assertTrue(after.metadata().index("test3").getAliases().get("alias").writeIndex());
import static org.hamcrest.Matchers.equalTo;
    );
            assertThat("index metadata aliases version mismatch", actual, equalTo(expected));
        // Add an alias to it
        assertNull(after.metadata().getIndicesLookup().get("test_2"));
            .metadata(
import org.opensearch.cluster.service.ClusterService;
            return ClusterState.builder(state).metadata(meta).build();
    }
            before,
                testState,
        {
public class MetadataIndexAliasesServiceTests extends OpenSearchTestCase {
        ClusterState originalState = ClusterState.EMPTY_STATE;
                    + "[foo-stream]. Data streams and their backing indices don't support alias operations."
        assertAliasesVersionIncreased(index, afterChangeWriteAliasToNonWriteAlias, afterChangeNonWriteAliasToWriteAlias);
                "The provided index [ .ds-foo-stream-000001] is a backing index belonging to data stream "
        }
                before,
        );
        {
        final List<AliasAction> addActions = new ArrayList<>(length);
 * KIND, either express or implied.  See the License for the
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);
        {
        final ClusterState afterAddWriteAlias = service.applyAliasActions(
    }
                originalState,
        final ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), index);
    public void testAddWriteOnlyWithIndexRemoved() {
            // Adding the same alias as hidden to another index should throw
        assertAliasesVersionIncreased(index, before, after);
    public void testAliasesVersionUnchangedWhenActionsAreIdempotent() {
        String index = randomAlphaOfLength(5);
import org.opensearch.index.IndexNotFoundException;
    }
        );
            .build();
            );
            afterAddingRandomAliases
            )
            assertThat("index metadata aliases version mismatch", actual, equalTo(expected));
        );
        }
import org.opensearch.Version;
 * compatible open source license.
        }
        }
        assertNull(after.metadata().getIndicesLookup().get("test_2"));
            // Adding the same alias as non-hidden to another index should throw
        assertNull(before.metadata().index("test2").getAliases().get("alias").writeIndex());
        {
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
import static org.mockito.Mockito.when;
    }
    }
        assertNotNull(alias);
        IndexAbstraction alias = after.metadata().getIndicesLookup().get("test");
                randomAddActions.add(new AliasAction.Add(index, "random-alias-" + index, null, null, null, null, null));
            afterChangeWriteAliasToNonWriteAlias,
/*
import java.util.List;
    private void assertAliasesVersionIncreased(final String index, final ClusterState before, final ClusterState after) {
        final Set<String> aliasNames = new HashSet<>();
            for (Index index : indices) {
        );
 * not use this file except in compliance with the License.
                Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, null, null), new AliasAction.RemoveIndex("test"))
        // now add some aliases randomly
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
            // Add a hidden alias to one index
    private final MetadataIndexAliasesService service = new MetadataIndexAliasesService(
            before,
            .numberOfShards(1)
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
        assertTrue(after.metadata().index("test").getAliases().get("alias").writeIndex());
        for (final String index : indices) {
            .numberOfReplicas(1);
        Exception exception = expectThrows(
            .numberOfReplicas(1);
                meta.remove(index.getName()); // We only think about metadata for this test. Not routing or any other fun stuff.
            Arrays.asList(new AliasAction.RemoveIndex("test"), new AliasAction.RemoveIndex("test"))
        ClusterState after = service.applyAliasActions(
                    new AliasAction.Add("test2", "alias", null, null, null, true, null)
            .numberOfShards(1)
            applyHiddenAliasMix(before, null, null);
                testState,
        for (int i = 0; i < length; i++) {
            Arrays.asList(
        final ClusterState afterAddingAliases = service.applyAliasActions(before, addActions);
        }
        ClusterState after = service.applyAliasActions(
            AliasesNotFoundException.class,
            );
        after = service.applyAliasActions(before, singletonList(new AliasAction.Remove(index, "test_2", randomBoolean())));
                    .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), singletonList(indexMetadata.getIndex())))
        // add an alias to the index multiple times
            // Adding the same alias as non-hidden should be OK
                testState,
        final ClusterState afterAddingAlias = service.applyAliasActions(before, addActions);
            .numberOfReplicas(1);
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
                Collections.singletonList(new AliasAction.Add("test2", "alias", null, null, null, null, true))
            final long actual = after.metadata().index(index).getAliasesVersion();
        // Now just remove on its own
            )
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
 * SPDX-License-Identifier: Apache-2.0
        final ClusterState afterChangeWriteAliasToNonWriteAlias = service.applyAliasActions(
        assertAliasesVersionUnchanged("test2", before, after);
        // Create "test"
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), "test");
        IndexNotFoundException e = expectThrows(
 * software distributed under the License is distributed on an
            before = createIndex(before, index);
        assertThat(
            .build();
            ClusterState state = (ClusterState) i.getArguments()[0];
                testState,
        );
    }
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT).build();
            ));
import java.util.Arrays;
        originalState = createIndex(originalState, "test1");
            .settings(settings(Version.CURRENT))
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
        mock(ClusterService.class),
        }
        final String index = randomAlphaOfLength(8);
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
        assertThat(alias.getIndices(), contains(after.metadata().index(index)));
        // Create "test" and "test_2"
            IndexNotFoundException.class,
        assertAliasesVersionUnchanged(new String[] { index }, before, after);
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
        // add some aliases to the index
            before,
import static org.mockito.Mockito.any;
        final int length = randomIntBetween(2, 8);
    }
        assertNull(before.metadata().getIndicesLookup().get("alias").getWriteIndex());
        assertNotNull(alias);
            before,
                )
        );
            Exception ex = expectThrows(IllegalStateException.class, () -> // Add a non-hidden alias to one index
            () -> service.applyAliasActions(
            .metadata(Metadata.builder().put(indexMetadata).put(indexMetadata2))
        final List<AliasAction> randomAddActions = new ArrayList<>(length);
        assertAliasesVersionIncreased(index, before, afterAddingAliases);
        assertThat(alias.getType(), equalTo(IndexAbstraction.Type.ALIAS));
            .numberOfReplicas(1);
            .putAlias(AliasMetadata.builder("alias").writeIndex(randomBoolean() ? null : false).build())
        {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.VersionUtils;
            before,
        before = after;
 *
        assertNull(after.metadata().getIndicesLookup().get("test"));
        assertAliasesVersionUnchanged(index, afterAddingAlias, afterRemoveAndAddAlias);
        assertThat(after.metadata().getIndicesLookup().get("alias").getWriteIndex(), equalTo(after.metadata().index("test2")));
            Exception ex = expectThrows(IllegalStateException.class, () -> // Add a non-hidden alias to one index
        final String index = randomAlphaOfLength(8);
        final Set<String> indices = new HashSet<>(length);
 * The OpenSearch Contributors require contributions made to
            .numberOfReplicas(1)
    }
 * under the License.
        IndexMetadata.Builder indexMetadata3 = IndexMetadata.builder("test3")
    private void assertAliasesVersionIncreased(final String[] indices, final ClusterState before, final ClusterState after) {
        );
            }
        after = service.applyAliasActions(
            Exception exception = expectThrows(
            removeAndAddActions.add(new AliasAction.Remove(index, aliasName, null));
 * this file be licensed under the Apache-2.0 license or a
    }
            );
import java.util.ArrayList;
            ClusterState testState = service.applyAliasActions(
        // now perform a remove and add for each alias which is idempotent, the resulting aliases are unchanged
        assertAliasesVersionIncreased("test", before, after);
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
    }
            Exception exception = expectThrows(
        IndexMetadata.Builder indexMetadata2 = IndexMetadata.builder("test2")
/*
        );
            afterAddingAliasesToAll,
                originalState,
        assertThat(exception.getMessage(), startsWith("alias [alias] has more than one write index ["));
            // Add a non-hidden alias to one index
        before = after;
            .numberOfReplicas(1)
        assertAliasesVersionIncreased(index, before, after);
            applyHiddenAliasMix(before, true, true);
        // Create a state with a single index
                Metadata.builder()
            );
            .build();
        assertAliasesVersionIncreased(randomIndices.toArray(new String[0]), afterAddingAliasesToAll, afterAddingRandomAliases);
            singletonList(new AliasAction.Add(index, "test", null, null, null, true, null))
            singletonList(new AliasAction.Add(index, "test", null, null, null, null, null))
            .numberOfShards(1)
            assertThat(ex.getMessage(), containsString("alias [alias] has is_hidden set to true on indices"));
        ClusterState after = service.applyAliasActions(before, swapActions);
        return service.applyAliasActions(
                assertTrue("index now found", state.metadata().hasConcreteIndex(index.getName()));
            () -> service.applyAliasActions(before, Arrays.asList(new AliasAction.Add("test", "alias", null, null, null, true, null)))
        final List<AliasAction> addActions = new ArrayList<>(length);
        assertAliasesVersionIncreased("test2", before, after);
        }
        IndexAbstraction alias = after.metadata().getIndicesLookup().get("test");
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT)
        String backingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, 1);
        ClusterState before = createIndex(ClusterState.builder(ClusterName.DEFAULT).build(), "test");
        ClusterState before = ClusterState.builder(ClusterName.DEFAULT)
        final List<AliasAction> removeAndAddActions = new ArrayList<>(2 * length);
    private final AliasValidator aliasValidator = new AliasValidator();
            service.applyAliasActions(
import static org.hamcrest.Matchers.contains;
            assertThat(exception.getMessage(), startsWith("alias [alias] has is_hidden set to true on indices ["));
            Arrays.asList(new AliasAction.Remove(index, "test", true), new AliasAction.Add(index, "test_2", null, null, null, null, null))
        assertNotNull(alias);
    public void testSwapIndexWithAlias() {
        assertNull(after.metadata().getIndicesLookup().get("test"));
import static java.util.Collections.singletonList;
                before,
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
