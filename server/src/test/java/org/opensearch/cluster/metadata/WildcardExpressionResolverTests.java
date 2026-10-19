                false,
                false,
            .put(indexBuilder("testXXX").putAlias(AliasMetadata.builder("alias1")).putAlias(AliasMetadata.builder("alias2")))  
    }
            );  
            IndexNameExpressionResolver.Context indicesAndAliasesContext = new IndexNameExpressionResolver.Context(
            .put(indexBuilder("bar_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")));
            IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(
            assertThat(indices, containsInAnyOrder("foo_index", "bar_index", "foo_foo", ".ds-foo_logs-000001", ".ds-foo_logs-000002"));
            IndexNameExpressionResolver.Context skipAliasesStrictContext = new IndexNameExpressionResolver.Context(  
            randomBoolean(),
                state.getMetadata(),
            .put(secondBackingIndexMetadata, true)
        }
            .put(indexBuilder("testXXX").state(IndexMetadata.State.OPEN))  
 * this file be licensed under the Apache-2.0 license or a
                false
                false,
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "testYYY"))), equalTo(newHashSet("testXXX", "testYYY")));  
            assertThat(indices, containsInAnyOrder("foo_foo", "foo_index", "bar_index"));  
                false,  
            false  
        );
 * KIND, either express or implied.  See the License for the
        IndexNameExpressionResolver.Context skipAliasesLenientContext = new IndexNameExpressionResolver.Context(  
                randomBoolean(),
        );
            .put(
            equalTo(newHashSet("testXXX", "testXYY", "kuku"))  
        }
    }
import static org.opensearch.common.util.set.Sets.newHashSet;
        // expressions against the defined indices and aliases  
        Metadata.Builder mdBuilder = Metadata.builder()
            state,
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "-testX*"))), equalTo(newHashSet("testXXX")));
                state.getMetadata(),  
        );  
            List<String> indices = resolver.resolve(skipAliasesLenientContext, Collections.singletonList("foo_alias"));
        );
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, true, false), false);
            equalTo(newHashSet("testXXX", "testXXY", "testXYY"))
            assertThat(  
            .put(indexBuilder("testYYY").putAlias(AliasMetadata.builder("alias3")))
            equalTo(newHashSet("testXXX", "testXYY", "testYYY", "kuku"))
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
        }
            newHashSet(resolver.resolve(context, Arrays.asList("testX*", "testYYY"))),
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "testYYY"))), equalTo(newHashSet("testXXX", "testYYY")));
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
            assertEquals(newHashSet(), matches);  
        }
            false
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
                    List.of(firstBackingIndexMetadata.getIndex(), secondBackingIndexMetadata.getIndex())  
                false,  
            .put(indexBuilder("foo_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")))
                errorOnAliasIndicesOptions,
            ).keySet();
                indicesAndAliasesContext,  
import java.util.Set;  
import org.opensearch.index.IndexNotFoundException;  
            false,
                state.getMetadata(),
                randomBoolean(),
            // include all wildcard adds the data stream's backing indices
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        assertThat(  
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))  
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                errorOnAliasIndicesOptions,  
            assertThat(indices, containsInAnyOrder("foo_index", "bar_index"));
                "foo_alias"
                state,  
 * Unless required by applicable law or agreed to in writing,
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        assertThat(
                state,
            newHashSet(resolver.resolve(context, Collections.singletonList("*Y*"))),
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("test*", "-testYYY"))), equalTo(newHashSet("testXXX", "testXYY")));
import org.opensearch.cluster.ClusterState;
    }  
        );  
            .put(indexBuilder("testYYY"));  
    public void testConvertWildcardsJustIndicesTests() {  
    }
            .put(indexBuilder("kuku"));  
        assertThat(  
            .put(indexBuilder("bar_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")))
                indices,
            false
        );
    }
        }
/*  
        }
        {  
            // data streams are not included and expression doesn't match the data steram
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
        );  
                true,
 * under the License.  
    public void testResolveDataStreams() {
                false
            );  
            false  
                indicesAndAliasesContext,
                false
 * Licensed to Elasticsearch under one or more contributor  
        }
                true,
        );
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
        );
            indices = resolver.resolve(indicesAliasesAndDataStreamsContext, Collections.singletonList("*"));
        );
        // expressions against the defined indices and aliases
/*  
            .put(indexBuilder("testXXX"))
        {
    public void testConvertWildcardsOpenClosedIndicesTests() {
            .put(indexBuilder("kuku").state(IndexMetadata.State.OPEN));
        }  
        }
            // data stream's corresponding backing indices are resolved  
 */  
            assertEquals("foo_a*", ((IndexNotFoundException) skipAliasesStrictContext.getFirstResolutionError()).getIndex().getName());
            IndexNameExpressionResolver.Context skipAliasesStrictContext = new IndexNameExpressionResolver.Context(
            .put(indexBuilder("testYYY"))  
            randomBoolean(),  
            assertEquals(newHashSet("foo_foo", "foo_index", "foo_alias"), matches);  
            .settings(  
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
 * compatible open source license.
                false
    public void testResolveAliases() {  
            IndicesOptions indicesAliasesAndExpandHiddenOptions = IndicesOptions.fromOptions(
                true,
            assertThat(indices, containsInAnyOrder("foo_foo", "foo_index"));
            resolver.resolve(skipAliasesStrictContext, Collections.singletonList("foo_a*"));
 * SPDX-License-Identifier: Apache-2.0
                indicesAndAliasesOptions,
        }  
        }  
            .put(indexBuilder("foo_foo").state(State.OPEN))
        {  
import static org.hamcrest.Matchers.containsInAnyOrder;
    }  
    }
                false
                "The provided expression [foo_alias] matches an alias, " + "specify the corresponding concrete indices instead.",
                onlyIndicesContext,
                indicesAliasesAndExpandHiddenOptions,
                "foo*"
 * software distributed under the License is distributed on an
                errorOnAliasIndicesOptions,
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;
            false
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;  
            .put(indexBuilder("testXYY"))  
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "-testXXX"))), equalTo(newHashSet("testXXX", "-testXXX")));
            newHashSet(resolver.resolve(context, Collections.singletonList("test*"))),  
        assertThat(  
                containsInAnyOrder("foo_index", "bar_index", "foo_foo", "bar_bar", ".ds-foo_logs-000001", ".ds-foo_logs-000002")
                "*"  
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        {
        // only against the defined indices
            );
            .put(indexBuilder("bar_bar").state(State.OPEN))  
        );
            indicesAndAliasesOptions,
        IndexNameExpressionResolver.Context onlyIndicesContext = new IndexNameExpressionResolver.Context(state, onlyIndicesOptions, false);  
        Metadata.Builder mdBuilder = Metadata.builder()
            .put(indexBuilder("foo_foo").state(State.OPEN))  
            assertEquals(newHashSet("foo_alias"), matches);
            indicesAndAliasesOptions,
        }
            state,
        String dataStreamName = "foo_logs";  
                randomBoolean(),
        IndicesOptions skipAliasesIndicesOptions = IndicesOptions.fromOptions(true, true, true, false, true, false, true, false);
            .put(indexBuilder("testXXX"))  
            IndexNameExpressionResolver.Context indicesAliasesDataStreamsAndHiddenIndices = new IndexNameExpressionResolver.Context(  
    private static IndexMetadata.Builder indexBuilder(String index) {
            List<String> indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("foo_a*"));  
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(  
package org.opensearch.cluster.metadata;
            indices = resolver.resolve(indicesAliasesDataStreamsAndHiddenIndices, Collections.singletonList("*"));
    }  
            .put(indexBuilder("foo_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")))
 * specific language governing permissions and limitations
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("testX*"))), equalTo(newHashSet("testXXX", "testXYY")));  
 * the Apache License, Version 2.0 (the "License"); you may
            );
            IndicesOptions.lenientExpandOpen(),  
            );
            );
        {
                indices,
        {
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("testX*"))), equalTo(newHashSet("testXXX", "testXXY")));  
                indicesAndAliasesContext,
 */  
                true,
        {
                false,
            state,  
                false  
            .put(indexBuilder("foo_foo").state(State.OPEN))
        {
        assertThat(  
            false  
        Metadata.Builder mdBuilder = Metadata.builder()  
        {
            assertEquals(newHashSet("bar_bar", "foo_foo", "foo_index", "bar_index"), matches);
            IllegalArgumentException iae = (IllegalArgumentException) skipAliasesStrictContext.getFirstResolutionError();  
            List<String> indices = resolver.resolve(skipAliasesLenientContext, Collections.singletonList("foo*"));  
    public void testMatchesConcreteIndicesWildcardAndAliases() {
                true,  
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            assertThat(indices, containsInAnyOrder("foo_index", "bar_index", "foo_foo", ".ds-foo_logs-000001", ".ds-foo_logs-000002"));
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        {
                new DataStream(  
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
        IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(
import org.opensearch.Version;
            newHashSet(resolver.resolve(context, Collections.singletonList("test*X*"))),
        return IndexMetadata.builder(index)
                true,  
            assertThat(indices, containsInAnyOrder("foo_alias"));  
            List<String> indices = resolver.resolve(indicesAliasesAndDataStreamsContext, Collections.singletonList("foo_*"));
            false,
public class WildcardExpressionResolverTests extends OpenSearchTestCase {
            state,
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
            .put(indexBuilder("testYYX").state(IndexMetadata.State.CLOSE))
                false,  
        // ignoreAliases option is set, WildcardExpressionResolver resolves the provided expressions  
            false  
                state.getMetadata(),  
            .put(indexBuilder("testXYY"))
        );  
import org.opensearch.action.support.IndicesOptions;
            assertThat(indices, containsInAnyOrder("foo_foo", "foo_index"));
                false,
        );  
        }  
                false
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("kuku*Y*"))), equalTo(newHashSet("kukuYYY")));
            IndexNameExpressionResolver.Context skipAliasesStrictContext = new IndexNameExpressionResolver.Context(
            // data stream's corresponding backing indices are resolved  
import static org.hamcrest.Matchers.equalTo;  
            List<String> indices = resolver.resolve(indicesAliasesDataStreamsAndHiddenIndices, Collections.singletonList("foo_*"));
import java.util.List;
        );
                true,
            true,
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("testX*"))), equalTo(newHashSet("testXYY")));
                true,
                containsInAnyOrder("foo_index", "bar_index", "foo_foo", "bar_bar", ".ds-foo_logs-000001", ".ds-foo_logs-000002")
            // include all wildcard adds the data stream's backing indices
            IndexNameExpressionResolver.Context indicesAliasesAndDataStreamsContext = new IndexNameExpressionResolver.Context(  
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "ku*"))), equalTo(newHashSet("testXXX", "kuku")));
import org.opensearch.cluster.ClusterName;  
            assertThat(indices, containsInAnyOrder("foo_alias"));
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
            false,
 * license agreements. See the NOTICE file distributed with
            state,
        IndexMetadata secondBackingIndexMetadata = createBackingIndex(dataStreamName, 2).build();
        );
                "foo*"  
import java.util.Arrays;  
                randomBoolean(),  
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
            newHashSet(resolver.resolve(context, Collections.singletonList("_all"))),
            ).keySet();
                    dataStreamName,
        Metadata.Builder mdBuilder = Metadata.builder()
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();  
import java.util.Collections;
            true,  
        }
 *  
        assertThat(
 *     http://www.apache.org/licenses/LICENSE-2.0
            ).keySet();  
            IndicesOptions.lenientExpandOpen(),  
                iae.getMessage()  
            indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("bar_*"));  
 * Modifications Copyright OpenSearch Contributors. See
            IndicesOptions.fromOptions(true, true, true, true),
            newHashSet(resolver.resolve(context, Collections.singletonList("*"))),  
            skipAliasesIndicesOptions,
/*
 * not use this file except in compliance with the License.
        {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(newHashSet("foo_foo", "foo_index"), matches);
            assertEquals(0, indices.size());
            assertEquals(newHashSet("bar_bar", "foo_foo", "foo_index", "bar_index", "foo_alias"), matches);
        );
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(  
 *
        {
        IndexNameExpressionResolver.Context indicesAndAliasesContext = new IndexNameExpressionResolver.Context(  
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("-kuku"))), equalTo(newHashSet("-kuku")));
                state,
            );  
            .put(indexBuilder("testXYY").putAlias(AliasMetadata.builder("alias2")))
 *
        IndicesOptions onlyIndicesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, true, false);
            IndicesOptions.lenientExpandOpen(),  
                onlyIndicesContext,
            assertThat(indices, containsInAnyOrder("bar_bar", "bar_index"));
            List<String> indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("foo*"));
            equalTo(newHashSet("testXXY", "testXYY", "testYYY", "kukuYYY"))
        }
        IndicesOptions errorOnAliasIndicesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, true, false);  
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
                false,
        Metadata.Builder mdBuilder = Metadata.builder()
                onlyIndicesContext,  
            newHashSet(resolver.resolve(context, Arrays.asList("testYY*", "alias*"))),
        {  
        }  
            );
        );
            equalTo(newHashSet("testXXX", "testXYY", "testYYY"))
                indicesAndAliasesOptions,  
                randomBoolean(),
    public void testConvertWildcardsTests() {
}
    public void testMultipleWildcards() {
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
        assertThat(
            newHashSet(resolver.resolve(context, Arrays.asList("testX*", "kuku"))),
 * this work for additional information regarding copyright
            assertThat(  
        }
            state,
            );
            );
            .put(indexBuilder("bar_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")));  
                false,
        );
            IndicesOptions.lenientExpandOpen(),
            .put(indexBuilder("testXXX"))
                state,
            equalTo(newHashSet("testXXX", "testXXY", "testXYY"))
    // issue #13334  
        IndexNameExpressionResolver.Context indicesAndAliasesContext = new IndexNameExpressionResolver.Context(
                state.getMetadata(),
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            resolver.resolve(skipAliasesStrictContext, Collections.singletonList("foo_alias"));
            .put(indexBuilder("foo_index").state(State.OPEN).putAlias(AliasMetadata.builder("foo_alias")))
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("*Y*X"))).size(), equalTo(0));
        // when ignoreAliases option is not set, WildcardExpressionResolver resolves the provided  
        IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, false, false);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        Metadata.Builder mdBuilder = Metadata.builder()
            false  
                randomBoolean(),  
        );  
    }
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("test*Y*X"))).size(), equalTo(0));
                true,
        {
 * GitHub history for details.
            .put(indexBuilder("testXYY"))
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            );
            .put(indexBuilder("kuku"));
        // ignoreAliases option is set, WildcardExpressionResolver resolves the provided expressions only against the defined indices
                )
        assertThat(newHashSet(resolver.resolve(context, Arrays.asList("testXXX", "testY*"))), equalTo(newHashSet("testXXX", "testYYY")));  
                false,  
        assertThat(
 * You may obtain a copy of the License at  
            .put(firstBackingIndexMetadata, true)  
        IndexMetadata firstBackingIndexMetadata = createBackingIndex(dataStreamName, 1).build();
        {  
    public void testAll() {
                "foo_alias"
        {  
            ).keySet();  
        IndexNameExpressionResolver.WildcardExpressionResolver resolver = new IndexNameExpressionResolver.WildcardExpressionResolver();
        {
        // ignoreAliases option is set, WildcardExpressionResolver throws error when
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, false, true), false);  
            List<String> indices = resolver.resolve(skipAliasesStrictContext, Collections.singletonList("foo*"));  
        assertThat(
            List<String> indices = resolver.resolve(skipAliasesLenientContext, Collections.singletonList("foo_a*"));
                false  
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(
                false,  
            assertEquals(
            .put(indexBuilder("testXXY"))
            newHashSet(resolver.resolve(context, Arrays.asList("*", "-kuku"))),
            );
                state,
            Set<String> matches = IndexNameExpressionResolver.WildcardExpressionResolver.matches(  
            .put(indexBuilder("kukuYYY"));
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("test*X*Y"))), equalTo(newHashSet("testXXY", "testXYY")));
        assertThat(  
            .put(indexBuilder("testYYY").state(IndexMetadata.State.OPEN))  
            newHashSet(resolver.resolve(context, Collections.singletonList("testX*"))),  
            false
                "*"
                state.getMetadata(),
 */
                false,  
import org.opensearch.cluster.metadata.IndexMetadata.State;
        // when ignoreAliases option is not set, WildcardExpressionResolver resolves the provided
        assertThat(  
        Metadata.Builder mdBuilder = Metadata.builder()
            );  
            .put(indexBuilder("bar_bar").state(State.OPEN))
            IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(  
            ).keySet();
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
            ).keySet();
            assertThat(indices, containsInAnyOrder("foo_index", "foo_foo", "bar_index"));  
            newHashSet(resolver.resolve(context, Arrays.asList("testYYY", "testX*"))),
                state,
            .put(indexBuilder("kuku"))
        );  
                    createTimestampField("@timestamp"),
            .put(indexBuilder("testXXY").state(IndexMetadata.State.OPEN))
            List<String> indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("foo_*"));
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(  
            List<String> indices = resolver.resolve(indicesAndAliasesContext, Collections.singletonList("foo_alias"));
        }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertThat(newHashSet(resolver.resolve(context, Collections.singletonList("testXXX"))), equalTo(newHashSet("testXXX")));
        Metadata.Builder mdBuilder = Metadata.builder()
            // data streams are not included but expression matches the data stream
        {  
            state,
            .put(indexBuilder("bar_bar").state(State.OPEN))  
            state,
            .put(indexBuilder("testYYY"))
                false  
            .put(indexBuilder("testXYY").state(IndexMetadata.State.CLOSE))
