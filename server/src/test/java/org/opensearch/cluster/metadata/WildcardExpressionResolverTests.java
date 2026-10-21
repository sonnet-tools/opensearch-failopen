            IllegalArgumentException iae = (IllegalArgumentException) skipAliasesStrictContext.getFirstResolutionError();
            );
                indicesAndAliasesContext,
        // ignoreAliases option is set, WildcardExpressionResolver resolves the provided expressions
                "foo*"
        assertThat(
        assertThat(
                indices,
        }
        }
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
        );
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("testX*"))), equalTo(newHashSet("testXXX", "testXYY")));
 * SPDX-License-Identifier: Apache-2.0
            List<String> indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("foo_*"));
            List<String> indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("foo_alias"));
                state.getMetadata(),
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("kuku*Y*"))), equalTo(newHashSet("kukuYYY")));
            assertThat(indices, containsInAnyOrder("foo_foo", "foo_index", "bar_index"));
            .put(indexBuilder("bar_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")))
            );
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "testYYY"))), equalTo(newHashSet("testXXX", "testYYY")));
                false,
            false
            assertEquals("foo_a*", ((IndexNotFoundException) skipAliasesStrictContext.getFirstResolutionError()).getIndex().getName());
            IndicesOptions.lenientExpandOpen(),
        assertThat(
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            IndicesOptions.lenientExpandOpen(),
    }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
    }
 * KIND, either express or implied.  See the License for the
        }
                indicesAndAliasesOptions,
            List<String> indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("foo_a*"));
            IndicesOptions.fromOptions(true, true, true, true),
            IndexNameExpressionResolver.Context indicesAliasesDataStreamsAndHiddenIndices = new IndexNameExpressionResolver.Context(
            .put(indexBuilder("foo_foo").state(State.OPEN))
import static org.hamcrest.Matchers.containsInAnyOrder;
            .put(indexBuilder("testXYY"))
            List<String> indices = resolver.resolve(skipAliasesStrictContext, Collections.singletonList("foo*"));
            List<String> indices = resolver.resolve(indicesAliasesAndDataStreamsContext, Collections.singletonList("foo_*"));
        );
import org.opensearch.cluster.ClusterName;
        Metadata.Builder mdBuilder = Metadata.builder()
            );
            List<String> indices = resolver.resolve(skipAliasesLenientContext, Collections.singletonList("foo_a*"));
            );
        );
 * You may obtain a copy of the License at
        }
 */
        Metadata.Builder mdBuilder = Metadata.builder()
                false
public class WildcardExpressionResolverTests extends OpenSearchTestCase {
            newHashSet(resolver.resolve(context, Arrays.asList("testX*", "testYYY"))),
                true,
                false
            .put(indexBuilder("testXXX"))
        );
    public void testMultipleWildcards() {
        {
            IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(
            state,
                randomBoolean(),
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
                true,
 * specific language governing permissions and limitations
            resolver.resolve(skipAliasesStrictContext, Collections.singletonList("foo_a*"));
        );
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("testXXX"))), equalTo(newHashSet("testXXX")));
                onlyIndicesContext,
 *
                containsInAnyOrder("foo_index", "bar_index", "foo_foo", "bar_bar", ".ds-foo_logs-000001", ".ds-foo_logs-000002")
        assertThat(
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "-testX*"))), equalTo(newHashSet("testXXX")));
        );
            );
        // when ignoreAliases option is not set, WildcardExpressionResolver resolves the provided
            .put(indexBuilder("testXYY").state(IndexMetadata.State.CLOSE))
            );
            );
 * Modifications Copyright OpenSearch Contributors. See
            .put(indexBuilder("bar_bar").state(State.OPEN))
            equalTo(newHashSet("testXXX", "testXYY", "testYYY", "kuku"))
            .put(indexBuilder("testYYX").state(IndexMetadata.State.CLOSE))
                iae.getMessage()
        assertThat(
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            ).keySet();
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
                errorOnAliasIndicesOptions,
            .put(indexBuilder("bar_bar").state(State.OPEN))
            .put(indexBuilder("bar_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")));
                state.getMetadata(),
            .put(firstBackingIndexMetadata, true)
            newHashSet(resolver.resolve(context, Arrays.asList("*", "-kuku"))),
            assertThat(indices, containsInAnyOrder("foo_alias"));
            IndicesOptions indicesAliasesAndExpandHiddenOptions = IndicesOptions.fromOptions(
    public void testResolveAliases() {
                true,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                    List.of(firstBackingIndexMetadata.getIndex(), secondBackingIndexMetadata.getIndex())
                false
import java.util.Arrays;
                indicesAndAliasesContext,
    public void testConvertWildcardsJustIndicesTests() {
        }
        {
    }
            List<String> indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("foo*"));
            List<String> indices = resolver.resolve(indicesAliasesDataStreamsAndHiddenIndices, Collections.singletonList("foo_*"));
                state.getMetadata(),
        assertThat(
        IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, false, false);
            state,
            .put(indexBuilder("kuku"));
        }
 * Unless required by applicable law or agreed to in writing,
                "*"
                false,
        }
                false,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            newHashSet(resolver.resolve(context, Arrays.asList("testYY*", "alias*"))),
            .put(indexBuilder("testXXY").state(IndexMetadata.State.OPEN))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(indices, containsInAnyOrder("foo_index", "foo_foo", "bar_index"));
        );
        IndexNameExpressionResolver.Context indicesAndAliasesContext = new IndexNameExpressionResolver.Context(
import org.opensearch.cluster.ClusterState;
            state,
        {
 * ownership. Elasticsearch licenses this file to you under
import java.util.Set;
                errorOnAliasIndicesOptions,
        );
            IndicesOptions.lenientExpandOpen(),
            state,
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
 * this work for additional information regarding copyright
            .put(indexBuilder("testXYY").putAlias(AliasMetadata.builder("alias2")))
            assertEquals(newHashSet(), matches);
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
                state,
    }
            assertThat(indices, containsInAnyOrder("foo_alias"));
            .put(indexBuilder("foo_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")))
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
            IndicesOptions.lenientExpandOpen(),
        );
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
            .put(
    public void testConvertWildcardsOpenClosedIndicesTests() {
            equalTo(newHashSet("testXXX", "testXYY", "kuku"))
    public void testAll() {
    public void testConvertWildcardsTests() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
    // issue #13334
                false,
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "-testXXX"))), equalTo(newHashSet("testXXX", "-testXXX")));
                true,
            );
            false
            indicesAndAliasesOptions,
        // only against the defined indices
            );
            assertThat(indices, containsInAnyOrder("foo_index", "bar_index", "foo_foo", ".ds-foo_logs-000001", ".ds-foo_logs-000002"));
            List<String> indices = resolver.resolve(skipAliasesLenientContext, Collections.singletonList("foo*"));
                false
            newHashSet(resolver.resolve(context, Collections.singletonList("test*"))),
        }
        Metadata.Builder mdBuilder = Metadata.builder()
 *
            );
        }
        );
            assertEquals(
import org.opensearch.Version;
        {
 * this file be licensed under the Apache-2.0 license or a
                "foo*"
            indicesAndAliasesOptions,
        }
            .put(indexBuilder("testYYY"))
                false
            assertThat(indices, containsInAnyOrder("foo_index", "bar_index"));
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
            skipAliasesIndicesOptions,
import org.opensearch.cluster.metadata.IndexMetadata.State;
                randomBoolean(),
            newHashSet(resolver.resolve(context, Collections.singletonList("*Y*"))),
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
                errorOnAliasIndicesOptions,
import static org.hamcrest.Matchers.equalTo;
            .put(indexBuilder("testXYY"))
            IndexNameExpressionResolver.Context indicesAliasesAndDataStreamsContext = new IndexNameExpressionResolver.Context(
        {
                false,
            // data stream's corresponding backing indices are resolved
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            indices = resolver.resolve(indicesAliasesDataStreamsAndHiddenIndices, Collections.singletonList("*"));
        assertThat(
            assertEquals(newHashSet("foo_foo", "foo_index", "foo_alias"), matches);
                state,
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
    public void testResolveDataStreams() {
            newHashSet(resolver.resolve(context, Collections.singletonList("test*X*"))),
            );
            IndexNameExpressionResolver.Context skipAliasesStrictContext = new IndexNameExpressionResolver.Context(
        IndexMetadata firstBackingIndexMetadata = createBackingIndex(dataStreamName, 1).build();
                "foo_alias"
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
            false
            indices = resolver.resolve(indicesAliasesAndDataStreamsContext, Collections.singletonList("*"));
            false,
        IndexNameExpressionResolver.Context onlyIndicesContext = new IndexNameExpressionResolver.Context(state, onlyIndicesOptions, false);
            // data streams are not included and expression doesn't match the data steram
                onlyIndicesContext,
 *
            .put(indexBuilder("testYYY"));
            );
        IndexNameExpressionResolver.Context skipAliasesLenientContext = new IndexNameExpressionResolver.Context(
                false
            );
                true,
        {
            IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(
            false
        assertThat(
import static org.opensearch.common.util.set.Sets.newHashSet;
        // ignoreAliases option is set, WildcardExpressionResolver resolves the provided expressions only against the defined indices
            ).keySet();
            assertThat(
    public void testMatchesConcreteIndicesWildcardAndAliases() {
            state,
            false
 * under the License.
import java.util.List;
            .put(indexBuilder("bar_bar").state(State.OPEN))
}
                false,
    }
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
            // include all wildcard adds the data stream's backing indices
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "ku*"))), equalTo(newHashSet("testXXX", "kuku")));
            ).keySet();
            IndexNameExpressionResolver.Context skipAliasesStrictContext = new IndexNameExpressionResolver.Context(
                state.getMetadata(),
/*
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            state,
 * The OpenSearch Contributors require contributions made to
            IndexNameExpressionResolver.Context indicesAndAliasesContext = new IndexNameExpressionResolver.Context(
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("*Y*X"))).size(), equalTo(0));
            .put(indexBuilder("testXXX"))
        );
        {
        // when ignoreAliases option is not set, WildcardExpressionResolver resolves the provided
        {
        Metadata.Builder mdBuilder = Metadata.builder()
            state,
    }
                state.getMetadata(),
            .settings(
        return IndexMetadata.builder(index)
                false
            // data streams are not included but expression matches the data stream
            assertEquals(newHashSet("bar_bar", "foo_foo", "foo_index", "bar_index"), matches);
                true,
            false,
 * compatible open source license.
            assertThat(
            .put(indexBuilder("foo_foo").state(State.OPEN))
        {
            assertEquals(newHashSet("foo_alias"), matches);
        );
            .put(indexBuilder("testYYY").putAlias(AliasMetadata.builder("alias3")))
        }
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("test*Y*X"))).size(), equalTo(0));
                false,
            equalTo(newHashSet("testXXY", "testXYY", "testYYY", "kukuYYY"))
            .put(indexBuilder("kuku").state(IndexMetadata.State.OPEN));
        {
                false
            true,
        }
            .put(indexBuilder("testXXX").putAlias(AliasMetadata.builder("alias1")).putAlias(AliasMetadata.builder("alias2")))
        {
            resolver.resolve(skipAliasesStrictContext, Collections.singletonList("foo_alias"));
        }
    }
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            .put(indexBuilder("testYYY"))
        {
            .put(indexBuilder("foo_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")))
        {
            .put(indexBuilder("testXXX"))
            randomBoolean(),
                false
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
                indices,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        IndicesOptions skipAliasesIndicesOptions = IndicesOptions.fromOptions(true, true, true, false, true, false, true, false);
                state,
        );
    private static IndexMetadata.Builder indexBuilder(String index) {
        );
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, false, true), false);
            .put(indexBuilder("foo_foo").state(State.OPEN))
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
        Metadata.Builder mdBuilder = Metadata.builder()
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("testX*"))), equalTo(newHashSet("testXXX", "testXXY")));
                state,
            equalTo(newHashSet("testXXX", "testXXY", "testXYY"))
                "*"
            assertEquals(0, indices.size());
        String dataStreamName = "foo_logs";
        IndicesOptions onlyIndicesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, true, false);
        );
                false,
                indicesAndAliasesContext,
                randomBoolean(),
                "foo_alias"
            );
            .put(indexBuilder("kuku"))
        // ignoreAliases option is set, WildcardExpressionResolver throws error when
        Metadata.Builder mdBuilder = Metadata.builder()
                "The provided expression [foo_alias] matches an alias, " + "specify the corresponding concrete indices instead.",
                true,
            false,
            assertThat(indices, containsInAnyOrder("foo_index", "bar_index", "foo_foo", ".ds-foo_logs-000001", ".ds-foo_logs-000002"));
            newHashSet(resolver.resolve(context, Collections.singletonList("*"))),
                )
        assertThat(
        assertThat(
                state,
            newHashSet(resolver.resolve(context, Collections.singletonList("testX*"))),
        IndexNameExpressionResolver.Context indicesAndAliasesContext = new IndexNameExpressionResolver.Context(
                false,
 * GitHub history for details.
import org.opensearch.index.IndexNotFoundException;
                onlyIndicesContext,
        }
                indicesAndAliasesOptions,
        );
        assertThat(
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
/*
                containsInAnyOrder("foo_index", "bar_index", "foo_foo", "bar_bar", ".ds-foo_logs-000001", ".ds-foo_logs-000002")
                false,
            List<String> indices = resolver.resolve(skipAliasesLenientContext, Collections.singletonList("foo_alias"));
            IndexNameExpressionResolver.Context skipAliasesStrictContext = new IndexNameExpressionResolver.Context(
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("test*", "-testYYY"))), equalTo(newHashSet("testXXX", "testXYY")));
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
        }
                randomBoolean(),
/*
        );
            ).keySet();
            ).keySet();
 * not use this file except in compliance with the License.
            indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("bar_*"));
        );
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
                    dataStreamName,
            assertEquals(newHashSet("bar_bar", "foo_foo", "foo_index", "bar_index", "foo_alias"), matches);
            // include all wildcard adds the data stream's backing indices
            assertThat(indices, containsInAnyOrder("foo_foo", "foo_index"));
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("test*X*Y"))), equalTo(newHashSet("testXXY", "testXYY")));
        {
        }
            // data stream's corresponding backing indices are resolved
        }
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, true, false), false);
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
        {
                new DataStream(
    }
        );
            assertEquals(newHashSet("foo_foo", "foo_index"), matches);
            .put(indexBuilder("kukuYYY"));
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        IndexMetadata secondBackingIndexMetadata = createBackingIndex(dataStreamName, 2).build();
                state.getMetadata(),
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
 */
        Metadata.Builder mdBuilder = Metadata.builder()
        );
            true,
            newHashSet(resolver.resolve(context, Arrays.asList("testYYY", "testX*"))),
                true,
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("-kuku"))), equalTo(newHashSet("-kuku")));
                false,
                false,
            equalTo(newHashSet("testXXX", "testXXY", "testXYY"))
            false
    }
            newHashSet(resolver.resolve(context, Collections.singletonList("_all"))),
        Metadata.Builder mdBuilder = Metadata.builder()
            assertThat(indices, containsInAnyOrder("bar_bar", "bar_index"));
import java.util.Collections;
        // expressions against the defined indices and aliases
        // expressions against the defined indices and aliases
            .put(indexBuilder("bar_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")));
        IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(
                state,
            randomBoolean(),
            ).keySet();
                true,
            .put(indexBuilder("testXXX").state(IndexMetadata.State.OPEN))
                indicesAliasesAndExpandHiddenOptions,
                randomBoolean(),
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                false,
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;
            false
            .put(indexBuilder("kuku"));
            assertThat(indices, containsInAnyOrder("foo_foo", "foo_index"));
            .put(secondBackingIndexMetadata, true)
        {
            state,
            false
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("testX*"))), equalTo(newHashSet("testXYY")));
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "testY*"))), equalTo(newHashSet("testXXX", "testYYY")));
            false
                    createTimestampField("@timestamp"),
        IndicesOptions errorOnAliasIndicesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, true, false);
        }
                randomBoolean(),
        {
import org.opensearch.action.support.IndicesOptions;
            .put(indexBuilder("testXYY"))
            .put(indexBuilder("testXXY"))
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "testYYY"))), equalTo(newHashSet("testXXX", "testYYY")));
        {
            .put(indexBuilder("testYYY").state(IndexMetadata.State.OPEN))
            .put(indexBuilder("foo_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")))
 * Licensed to Elasticsearch under one or more contributor
            newHashSet(resolver.resolve(context, Arrays.asList("testX*", "kuku"))),
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
package org.opensearch.cluster.metadata;
