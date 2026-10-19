                assertThat(infe.getIndex().getName(), equalTo("baz*"));  
            new DeleteRequest("test-alias")  
                () -> indexNameExpressionResolver.concreteIndexNames(context, "baz*")  
        results = indexNameExpressionResolver.concreteIndexNames(context, "h*");
        assertThat(infe.getMessage(), is("no such index [testZZZ]"));
                // unavailable indices are not ignored, hence the error on the first unavailable indices encountered  
        {  
        IndexMetadata index2 = createBackingIndex(dataStream1, 2).build();
        Metadata.Builder mdBuilder = Metadata.builder()  
                        new DataStream(dataStream1, createTimestampField("@timestamp"), Arrays.asList(index1.getIndex(), index2.getIndex()))
            );
    private List<String> resolveConcreteIndexNameList(ClusterState state, SearchRequest request) {
            }  
            );  
            () -> indexNameExpressionResolver.concreteIndexNames(context, "testZZZ")
                EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES, IndicesOptions.Option.IGNORE_UNAVAILABLE),
            false
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "-testX*")),
        context = new IndexNameExpressionResolver.Context(state, options, false);
import org.opensearch.action.DocWriteRequest;
        SearchRequest request = new SearchRequest(".ml-meta");
        assertEquals("bar", results[0]);
                    IndexNotFoundException.class,
                .put(  
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias").writeIndex(randomFrom(false, null))))
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), index3.getIndex().getName());
            assertEquals("index", indices[0].getName());
        {
            Arrays.sort(result, Comparator.comparing(Index::getName));  
                () -> indexNameExpressionResolver.concreteIndices(state, indicesOptions, false, "my-data-stream")
        assertEquals(2, results.length);
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
 * Licensed to Elasticsearch under one or more contributor  
            true,  
    }
            .metadata(  
import org.opensearch.common.util.concurrent.ThreadContext;
                .put(indexBuilder("ccc").state(State.CLOSE).putAlias(AliasMetadata.builder("ccc_alias1")));
        }
                    .putAlias(AliasMetadata.builder("test-alias"))
            newHashSet(indexNameExpressionResolver.concreteIndexNames(state, IndicesOptions.lenientExpandOpen(), "-*")),
        );
            assertEquals(1, indices.length);  
        results = indexNameExpressionResolver.concreteIndexNames(context, (String[]) null);  
        assertThat(concreteResolvedIndices.names(), containsInAnyOrder("index_b1", "index_b2", "index_d"));
        return new IndexNameExpressionResolver(threadContext);
            "The provided expression [foo] matches an alias, specify the corresponding concrete indices instead.",  
        IndexMetadata index1 = createBackingIndex(dataStreamName, 1).build();  
public class IndexNameExpressionResolverTests extends OpenSearchTestCase {
        Metadata metadata = metadataBuilder(allConcreteIndices);  
        }
                        indexBuilder("test-1").putAlias(  
        indexNames = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(state, indicesAndAliasesOptions, "f*o"));  
                Metadata.builder(state.metadata())
        assertThat(exception.getMessage(), equalTo("indices request must specify a single index expression"));
        );  
        assertEquals(3, results.length);
            Exception e = expectThrows(  
            .metadata(  
                    EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES),
        IndicesRequest request = new IndicesRequest() {  
            .metadata(  
        IndexMetadata index2 = createBackingIndex(dataStream1, 2).build();  
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
        assertTrue(indexNames.contains("foo_foo"));
        IndicesOptions expandOpen = IndicesOptions.fromOptions(true, false, true, false);
                    .putAlias(AliasMetadata.builder("test-alias-1").filter("{ \"term\": \"foo\"}"))
            );  
package org.opensearch.cluster.metadata;
                    )
import org.opensearch.common.settings.Settings;
        Set<String> resolvedExpressions = new HashSet<>(Arrays.asList("alias-0", "alias-1"));  
            }
                IndexNotFoundException.class,
                    assertThat(concreteIndices.length, equalTo(expectedNumberOfIndices));  
 * compatible open source license.
            IndicesOptions.lenientExpandOpen(),  
        );  
        String[] concreteIndices = new String[] { "index2", "index3" };
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
    public void testDedupConcreteIndices() {
    public void testDataStreams() {
        final IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);  
            IllegalArgumentException e = expectThrows(
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Collections.<String>emptyList()), equalTo(false));
            Exception e = expectThrows(  
        }
            false
        assertEquals(2, results.length);
            Exception e = expectThrows(
        final String dataStream1 = "logs-foobar";
    }  
            results = indexNameExpressionResolver.concreteIndexNames(context, "barbaz", "foobar");  
                state,
        boolean test0WriteIndex = randomBoolean();
        assertArrayEquals(new String[] { "other-alias" }, aliases);
        indexNameExpressionResolver = createIndexNameExpressionResolver(threadContext);  
                state,
            equalTo(newHashSet("testXXX"))  
            assertEquals(
            Index[] indices = indexNameExpressionResolver.concreteIndices(
            "test-0",  
        Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "logs-*");  
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");  
            .put(index3, false)
        assertEquals(1, results.length);
                "no write index is defined for alias [test-alias]."
                ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
    }
            {  
        String[] strings = indexNameExpressionResolver.indexAliases(
            .put(  
            assertEquals("test-index", indices[0]);
            "index_closed",
        String[] indicesOrAliases = new String[] { "index*", "-index1", "index1" };
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
        }  
        );
            "this request accesses system indices: [.ml-meta], but in a future major version, "
        assertEquals(2, results.length);  
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, noExpandStrict, false);
            assertThat(results, arrayContainingInAnyOrder("foofoo", "foobar"));
            "alias_b",  
                    IndexNotFoundException.class,
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpandOpenAndForbidClosed(), false);
        Metadata.Builder mdBuilder = Metadata.builder()
    public void testIndexOptionsWildcardExpansion() {
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.remove().index("test-alias");
    public void testFilterClosedIndicesOnAliases() {  
                () -> indexNameExpressionResolver.concreteWriteIndex(state, indicesOptions, "my-data-stream", false, false)
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
        assertEquals(2, results.length);
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
    }
                IndexNotFoundException infe = expectThrows(
        final String hiddenAlias = "my-hidden-alias";  
            );  
                IndexNotFoundException.class,
        Arrays.sort(strings);
            );  
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "bar");
    public void testIsPatternMatchingAllIndicesNonMatchingSingleExclusion() throws Exception {
        Metadata metadata = metadataBuilder(concreteIndices);  
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
                    .put(indexBuilder("bbb").state(State.OPEN).putAlias(AliasMetadata.builder("bbb_alias1")))
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        IndexNotFoundException infe = expectThrows(
        IndexNotFoundException infe = expectThrows(  
            .put(indexBuilder("foo"))
            x -> true,  
            .put(indexBuilder("foo").putAlias(AliasMetadata.builder("foofoobar")))
        );
        );
            assertEquals(1, indices.length);
            assertThat(ince.getMessage(), equalTo("closed"));  
        );
            "baz*",  
                        new DataStream(dataStream1, createTimestampField("@timestamp"), Arrays.asList(index1.getIndex(), index2.getIndex()))  
            .put(new DataStream(dataStream1, createTimestampField("@timestamp"), List.of(index1.getIndex(), index2.getIndex())))
        assertEquals(1, results.length);
        );
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpandOpen(), false);
        // open closed and hidden  
            true,
    public void testConcreteWriteIndexWithInvalidIndicesRequest() {
        List<String> indexNames = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(state, indicesAndAliasesOptions, "foo*"));
            }
                "test-index"  
        Metadata.Builder mdBuilder = Metadata.builder();
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
        assertEquals(4, results.length);
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "baz*")
            {
            IndicesOptions.strictExpandOpen(),
    }
                    DataStream.getDefaultBackingIndexName(dataStreamName, 2)
        assertThat(results, arrayContainingInAnyOrder("foo", "foobar", "foofoo", "foofoo-closed"));  
            new DeleteRequest("test-alias")
                return new String[] { "test-*" };  
        }
        assertEquals(1, results.length);  
        for (String concreteIndex : indices) {  
            IndicesOptions.lenientExpandOpen(),
        results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo*");
        );
    }
        assertThat(Arrays.asList(indexNames), containsInAnyOrder(hiddenIndex));
        assertEquals(4, results.length);
                case 1:  
        );
    static class FakeExpressionResolver implements IndexNameExpressionResolver.ExpressionResolver {
            true,
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
        );  
        resolvedExpressions = new HashSet<>(Arrays.asList("test-0", "test-1", "alias-0", "alias-1"));  
    public void testFullWildcardSystemIndexResolutionAllowed() {  
            exception.getMessage(),
                contextICE.getOptions().allowNoIndices(),  
    private IndexNameExpressionResolver indexNameExpressionResolver;  
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden-closed");
            IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
        );
            );  
    }
        IndicesOptions expand = IndicesOptions.fromOptions(true, false, true, true);  
            Index[] indices = indexNameExpressionResolver.concreteIndices(
        {
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))  
        );
            IndexNotFoundException infe = expectThrows(  
        assertEquals("foo_foo", indexNamesIndexWildcard[0]);
    }
        assertThat(results, emptyArray());
        );  
                    allIndices = new String[0];
            IllegalArgumentException iae = expectThrows(  
    public void testIsPatternMatchingAllIndicesNonMatchingTrailingWildcard() throws Exception {
        }
        @Override  
    public void testIsPatternMatchingAllIndicesExplicitList() throws Exception {
                    )  
            IllegalArgumentException.class,  
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, ".hidden_a*");
            // unless it's specified in the options  
        assertThat(names, empty());
        expectThrows(InvalidIndexNameException.class, () -> indexNameExpressionResolver.resolveExpressions(state, "_invalid_index_name"));  
        strings = indexNameExpressionResolver.concreteIndexNames(context, "alias-*");  
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpandOpen(), false);
                    .putAlias(AliasMetadata.builder("test-alias-non-filtering"))
            assertThat(results, arrayContainingInAnyOrder("foo", "foobar"));
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
                    String[] concreteIndices = indexNameExpressionResolver.concreteIndexNames(context, allIndices);  
                "test-*"
        );
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
            context,
        );
            );
                indexBuilder("test-0").state(State.OPEN)
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
        final String hiddenIndex = "hidden_index";
        return new ThreadContext(Settings.EMPTY);
        assertEquals("bar", results[0]);  
        assertEquals(1, indexNamesIndexWildcard.length);
                "test-alias"  
        Arrays.sort(result, Comparator.comparing(Index::getName));
            0
        );
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, results.length);
        Metadata.Builder mdBuilder = Metadata.builder()
        return Arrays.stream(indexNameExpressionResolver.concreteIndices(state, request))
        }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                    .put(justAnIndex, false)
        }
            Arrays.sort(indices, Comparator.comparing(Index::getName));
                indexBuilder("test-0").state(State.OPEN)
                    break;
        {  
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(backingIndex.getIndex()), 1));
            state,
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, false, true), false);  
        {
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 2)));
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
            IndicesOptions.lenientExpandOpen(),
import org.opensearch.index.IndexSettings;  
                IndexNotFoundException infe = expectThrows(
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
        List<ExpressionResolver> customResolvers = Collections.singletonList(customResolver);
            IllegalArgumentException.class,
            context = new IndexNameExpressionResolver.Context(state, options, false);
            .put(indexBuilder("index").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias2")));  
            "test-0",
            state,
                indexBuilder("test-0").state(State.OPEN)
        results = indexNameExpressionResolver.concreteIndexNames(context, "-*");  
            }
 * ownership. Elasticsearch licenses this file to you under  
    }  
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 1)));
            assertThat(result.length, equalTo(0));
            // If we specify the alias by name it should resolve to both indices, regardless of if the options specify hidden  
                        expectedNumberOfIndices += 2;
        assertEquals("bar", results[0]);
            false
                case 2:  
    }
        assertEquals(1, results.length);  
                new IndicesOptions(  
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
            {  
            results = indexNameExpressionResolver.concreteIndexNames(context, "baz*");
        }
    private static IndexMetadata.Builder indexBuilder(String index, Settings additionalSettings) {
/*  
    public void testIndicesAliasesRequestIgnoresAliases() {  
        } catch (IndexClosedException e) {  
            assertEquals(0, indices.length);
    }
        // concrete index supersedes filtering alias
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "bar")
        IllegalArgumentException exception = expectThrows(
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "*", "--testX*")),
            {  
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "*");
    public void testIndexOptionsLenient() {  
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED,
        expectThrows(IndexClosedException.class, () -> indexNameExpressionResolver.concreteIndexNames(contextICE, "foo1-closed"));
        assertEquals(4, results.length);
            )
            IllegalArgumentException iae = expectThrows(
        // only against the defined indices
            );
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            }
            IndicesOptions.fromOptions(false, false, true, true),  
        indexNames = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(state, indicesAndAliasesOptions, "foo"));
        );  
            .put(indexBuilder("index_b1").putAlias(AliasMetadata.builder("alias_b")))  
        }
            );  
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),  
            .putAlias(new AliasMetadata.Builder("logs-foobarbaz"))
        context = new IndexNameExpressionResolver.Context(state, options, false);
                "The provided expression [test-alias] matches an alias, " + "specify the corresponding concrete indices instead.",  
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(hiddenIndex));
            assertThat(e.getMessage(), equalTo("no such index [my-data-stream]"));
            new HashSet<>(Arrays.asList("test-0", "test-1", "test-alias"))  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        );  
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "my-*", "-my-visible*");
            .put(
            );
            } else {
            assertEquals(1, indices.length);
            state,  
            assertEquals(3, indices.length);
            }
                    indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
                EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES),
        // error on unavailable but allow no indices
            IndexNotFoundException.class,
            x -> true,  
    public void testConcreteIndicesWildcardWithNegation() {  
            "this request accesses system indices: [.ml-meta], but in a future major version, direct access "  
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
                );
                randomBoolean(),
        Metadata.Builder mdBuilder = Metadata.builder()  
            false
            assertThat(infe.getIndex().getName(), equalTo("baz*"));
        Metadata.Builder mdBuilder = Metadata.builder()
            .put(
    }
    public void testHiddenAliasAndHiddenIndexResolution() {
        ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(context, "testZZZ");  
        IndicesOptions indicesOptions = IndicesOptions.strictExpandOpenAndForbidClosedIgnoreThrottled();
                () -> indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("test-alias"))
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));  
                state,  
        ClusterState state = systemIndexTestClusterState();
        assertEquals(concreteResolvedIndices.names(), Set.of("testZZZ"));
            .put(
            .put(indexBuilder("my_index").state(State.OPEN).putAlias(AliasMetadata.builder("my_alias")));
            containsInAnyOrder(
        }  
                EnumSet.of(IndicesOptions.WildcardStates.OPEN)
        // - resolved index patterns  
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");  
        // error on both unavailable and no indices
            IndexNotFoundException.class,
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
    public void testDeleteIndexIgnoresAliases() {  
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo1-closed");
            .numberOfReplicas(1)
            .put(indexBuilder("testYYY").state(State.OPEN))
        assertEquals(Collections.singletonList(dataStream1), names);
            // But if we include hidden it should be resolved to both indices
            IllegalArgumentException.class,  
            assertEquals(expectedMessage, iae.getMessage());  
            .putAlias(new AliasMetadata.Builder("logs-foobarbaz"))
            .put(index1, false)
            @Override  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                randomBoolean(),
            state,
            public boolean includeDataStreams() {
        context = new IndexNameExpressionResolver.Context(state, options, false);
            false
/*  
                );
        // when ignoreAliases option is not set, concreteIndexNames resolves the provided
        indexNamesIndexWildcard = indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "f*o");
            assertEquals("no such index [does_not_exist]", infe.getMessage());
            .put(
                    throw new UnsupportedOperationException();
    }  
        );
            );  
                iae.getMessage()
        {  
        context = new IndexNameExpressionResolver.Context(
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "*foobar");
        IndexNotFoundException infe = expectThrows(  
    }  
        IndexMetadata index1 = createBackingIndex(dataStream1, 1).build();
            equalTo(newHashSet("testXXX", "testXXY"))
import java.util.Collections;  
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias")));  
        assertNull(aliases);
        String[] strings = indexNameExpressionResolver.indexAliases(  
     * when ResolvedIndices.Local.Concrete.concreteIndices() is called.
        assertEquals(1, results.length);
    }
            // Ignore data streams
            .put(indexBuilder("foo").putAlias(AliasMetadata.builder("foofoobar")))
            IndexNotFoundException iae = expectThrows(  
        {  
            .put(indexBuilder("foobar"))  
            }
        assertEquals(Collections.singletonList(dataStream1), names);
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);  
            () -> indexNameExpressionResolver.concreteWriteIndex(state, request)
        assertArrayEquals(new String[] { "test-alias" }, strings);  
            );  
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo")
    }
        }  
        Metadata.Builder mdBuilder = Metadata.builder()
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
    }
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*");  
        results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo*");
    public void testIsAllIndicesNormalIndexes() throws Exception {  
                "closed"
            );
        } catch (IllegalArgumentException iae) {
            false
    public void testInvalidIndex() {
        assertEquals(Collections.singletonList(dataStream2), names);
        IndicesOptions[] indicesOptions = new IndicesOptions[] { IndicesOptions.lenientExpandOpen(), IndicesOptions.lenientExpand() };
            );  
            assertEquals(0, results.length);
        IndicesOptions excludeHiddenOptions = IndicesOptions.fromOptions(false, false, true, false, false, true, false, false, false);
        assertThat(writeIndex.getName(), equalTo(testZeroWriteIndex ? "test-0" : "test-1"));
        );
        IndexMetadata index4 = createBackingIndex(dataStream2, 2).build();  
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(null), equalTo(false));  
 *
            @Override  
            equalTo(newHashSet("testXXX", "testXXY", "testXYY", "testYYX", "testYYY", "-testYYY"))  
        assertEquals(1, results.length);
        assertEquals(1, results.length);
        assertEquals(1, results.length);  
            results = indexNameExpressionResolver.concreteIndexNames(context, (String[]) null);
        FakeExpressionResolver customResolver = new FakeExpressionResolver();
            public IndicesOptions indicesOptions() {
        assertThat(infe.getResourceId().toString(), equalTo("[_all]"));
            new HashSet<>(Arrays.asList("test-0", "test-1", "test-alias"))
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("alias-0").filter("{ \"term\": \"foo\"}")))
            new UpdateRequest("test-alias", "_id"),  
            String[] indexNames;
        );
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "other*");
            assertEquals(1, results.length);  
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))
        threadContext.putHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY, Boolean.FALSE.toString());
        assertThat(indexNames, containsInAnyOrder("some-other-index", ".ml-stuff", ".ml-meta"));  
        assertThat(  
                () -> indexNameExpressionResolver.concreteWriteIndex(state, indicesOptions, "my-data-stream", false, false)
                return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
            Index[] indices = indexNameExpressionResolver.concreteIndices(  
            ),  
            () -> indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "foo")  
                assertThat(infe.getIndex().getName(), equalTo("bar"));
            expectThrows(  
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
                    "testXXY",  
            ;  
            );
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index(dataStreamName);
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
                () -> indexNameExpressionResolver.concreteIndexNames(context, "baz*")
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
    public void testIndexOptionsNoExpandWildcards() {
        assertThat(  
                        )
                return false;
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(Metadata.builder().build()).build();  
/*
            false  
        Metadata.Builder mdBuilder = Metadata.builder()
        assertWarnings(
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            assertEquals("no such index [" + dataStreamName + "]", iae.getMessage());  
            .put(indexBuilder(".ml-meta", settings).state(State.OPEN).system(true))
            assertEquals(0, indices.length);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            Exception e = expectThrows(  
        return indexBuilder(index, Settings.EMPTY);
            .put(indexBuilder("foo").state(IndexMetadata.State.CLOSE))
        options = IndicesOptions.fromOptions(false, false, true, true, true);
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("index_b1")).put(indexBuilder("index_b2"));
                    }
            IndicesOptions indicesOptions = new IndicesOptions(
                IndexNotFoundException.class,  
            {
                iae.getMessage()
    }  
            IndicesOptions.fromOptions(  
            assertEquals("index", indices[0].getName());
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        Metadata.Builder mdBuilder = Metadata.builder();
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("foofoobar")))  
                .put(indexBuilder(visibleIndex).state(State.OPEN).putAlias(AliasMetadata.builder(visibleAlias)))
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, IndicesOptions.lenientExpandOpen(), "*", "-*");
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
        );
        );
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
        assertThat(infe.getMessage(), is("no such index [null] and no indices exist"));
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "hidden*", "visible*");  
        ClusterState state = ClusterState.builder(new ClusterName("_name"))
            IndicesOptions noExpandErrorUnavailable = IndicesOptions.fromOptions(false, true, false, false, randomBoolean());
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        }
        Metadata.Builder mdBuilder = Metadata.builder()  
    public void testIgnoreThrottled() {
        }
            }
            .build();  
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("index1").putAlias(AliasMetadata.builder("alias1")));
            );
        assertEquals("bar", results[0]);
            )
        {
        options = IndicesOptions.fromOptions(false, true, true, true, true);
        ClusterState state = systemIndexTestClusterState();  
            // Unless hidden is specified in the options
        // an exception is expected.  
            public String[] indices() {  
            .put(indexBuilder("-testXYZ").state(State.OPEN))
            // unless, again, it's specified in the options
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
        assertEquals(0, results.length);
                state,
            // If the alias is resolved to concrete indices, it should resolve to all the indices it points to, hidden or not.  
            // Ignore data streams, allow no indices and ignore unavailable
        assertEquals("hidden", results[0]);
        IndexMetadata index2 = createBackingIndex(dataStreamName, 2).build();
        results = indexNameExpressionResolver.concreteIndexNames(context, "foobar1-closed");  
        {
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
            state,
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(  
                EnumSet.of(IndicesOptions.WildcardStates.OPEN)
        assertEquals("foo", results[0]);
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Arrays.asList("_all")), equalTo(true));
        // Only closed
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.removeIndex().index("test-a*");
        IndexMetadata index3 = createBackingIndex(dataStream2, 1).build();
            )
                state,  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        Arrays.sort(strings);
        );  
            IndexNotFoundException infe = expectThrows(
                    EnumSet.of(IndicesOptions.WildcardStates.OPEN)  
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*");
                );
            assertEquals(2, results.length);
    @Override
        assertEquals(0, results.length);
    }
                true,
            .put(
                iae.getMessage()
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
                IllegalArgumentException.class,
            () -> indexNameExpressionResolver.concreteIndexNames(context, "_foo")  
        assertEquals(3, results.length);  
        IndicesOptions includeHiddenOptions = IndicesOptions.fromOptions(false, false, true, false, true, true, false, false, false);
        assertEquals(4, results.length);
            .put(index4, false)
 */  
            String[] indexNames;
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 2)));
            .put(indexBuilder("bar"))
        results = indexNameExpressionResolver.concreteIndexNames(context, "h*");  
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, hiddenAlias);
    }
                EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES, IndicesOptions.Option.IGNORE_UNAVAILABLE),  
 * specific language governing permissions and limitations
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo");  
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("foofoobar")))  
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
        assertThat(
            );  
            }  
    }
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
        String[] indicesOrAliases = new String[] { "index*", "-index1" };  
        context = new IndexNameExpressionResolver.Context(state, options, false);
            .put(  
            false
        assertThat(results, arrayContainingInAnyOrder(".hidden"));
                false
            .settings(OpenSearchTestCase.settings(Version.CURRENT))
    public void testAliasResolutionNotAllowingMultipleIndices() {
            );
        assertThat(IndexNameExpressionResolver.isAllIndices(Arrays.asList("_all")), equalTo(true));
            assertEquals(1, indices.length);
            x -> true,
    public void testConcreteIndicesIgnoreIndicesAllMissing() {
                "alias [alias_a] has more than one index associated with it [index_a1, index_a2], can't execute a single index op",  
        }  
            assertEquals(2, results.length);
            assertThat(infe.getIndex().getName(), equalTo("bar"));
            assertEquals("test-index", indices[0].getName());  
        final String dataStream2 = "logs-redis";
            equalTo(newHashSet("testYYY", "testYYX", "testXXY", "testXYY"))
            IndexNotFoundException iae = expectThrows(
        assertThat(indexNames, containsInAnyOrder(".ml-meta"));  
            assertEquals("test-index", indices[0]);  
                indexBuilder("test-0").state(State.OPEN)  
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.remove().index("test-*");
        Arrays.sort(strings);  
        assertThat(results, arrayContainingInAnyOrder("foo1-closed", "foo2-closed", "foo3"));
        Metadata.Builder mdBuilder = Metadata.builder()
        assertThat(names, containsInAnyOrder(dataStream1, dataStream2));
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden");
            )  
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");  
        }
            .put(indexBuilder("-testYYY").state(State.OPEN))
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        results = indexNameExpressionResolver.concreteIndexNames(context, ".hidd*");
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.removeIndex().index("test-*");  
            Arrays.sort(result, Comparator.comparing(Index::getName));  
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(true));
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo", "-foobar");
    }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertEquals(4, results.length);
import static org.opensearch.common.util.set.Sets.newHashSet;
        Metadata.Builder mdBuilder = Metadata.builder()
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foofoobar")
    }
        InvalidIndexNameException iine = expectThrows(
            assertEquals(2, results.length);
            .put(new DataStream(dataStream2, createTimestampField("@timestamp"), List.of(index3.getIndex(), index4.getIndex())));
        threadContext.putHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY, Boolean.FALSE.toString());
            }  
            equalTo(newHashSet("testYYX", "testXYY", "testYYY", "testXXY"))
    }
        Metadata.Builder mdBuilder = Metadata.builder()
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "barbaz", "bar")  
        assertThat(IndexNameExpressionResolver.isAllIndices(Arrays.asList("_all", "other")), equalTo(false));  
                .put(indexBuilder("bbb").state(State.OPEN).putAlias(AliasMetadata.builder("bbb_alias1")))
                    assertThat(concreteIndices, notNullValue());
        assertThat(results, arrayContainingInAnyOrder("foo", "foobar", "foofoo"));
            "test-0",  
            throw new UnsupportedOperationException("resolve operation not supported on FakeExpressionResolver");
            .put(indexBuilder("testYYY").state(State.OPEN))  
        assertTrue(indexNames.contains("bar_bar"));  
            () -> indexNameExpressionResolver.concreteWriteIndex(state, request.indicesOptions(), request.indices()[0], false, false)
                state,
            assertThat(infe.getIndex().getName(), equalTo("foo"));  
        assertThat(indexNames, containsInAnyOrder(".ml-meta", ".ml-stuff"));  
        }  
            public String[] indices() {
    public void testConcreteResolvedIndicesWithErrors() {
import org.opensearch.cluster.metadata.IndexMetadata.State;
            "this request accesses system indices: [.ml-stuff], but in a future major version, "
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
        assertThat(
        );  
        results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo*");
import static org.hamcrest.Matchers.emptyArray;
        String[] indexNamesIndexWildcard = indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "foo*");
            assertEquals(1, indices.length);
        IllegalArgumentException exception = expectThrows(
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testYYY", "testYYX", "testX*", "-testXXX")),
            equalTo(newHashSet("-testXYZ", "-testXZZ", "-testYYY"))  
            assertEquals("foo", results[0]);
    public void testWildcardSystemIndexResolutionSingleMatchAllowed() {
            assertThat(result.length, equalTo(4));
        // - Of course, the concrete indices will contain all existing indices that are matched.
        Metadata.Builder mdBuilder = Metadata.builder();
        assertThat(infe.getMessage(), is("no such index [testMo]"));
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        );
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, true, true), false);
                () -> indexNameExpressionResolver.concreteIndexNames(state, deleteIndexRequest)
        IndexMetadata backingIndex = createBackingIndex(dataStreamName, 1).build();  
            );
    public void testConcreteIndicesIgnoreIndicesOneMissingIndexOtherFound() {
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        // when ignoreAliases option is set, concreteIndexNames resolves the provided expressions  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        }
                    IndexNotFoundException.class,
        }
        // implicit hidden for dot indices based on wildcard starting with .  
            @Override
            indexNameExpressionResolver.resolveExpressions(state, "test-0", "alias-*")
        SearchRequest request = new SearchRequest(randomFrom("*", "_all"));  
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
 * SPDX-License-Identifier: Apache-2.0
        for (IndicesOptions options : indicesOptions) {
            assertThat(results, arrayContainingInAnyOrder("foo", "foobar"));  
            "this request accesses system indices: [.ml-meta], but in a future major version, direct access "
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
            .put(index1, false)
import java.util.EnumSet;
            equalTo(newHashSet("testXXX", "testXXY", "testXYY"))
            assertEquals(  
            Index[] indices = indexNameExpressionResolver.concreteIndices(  
        assertEquals("foo", results[0]);  
        ClusterState state = ClusterState.builder(new ClusterName("_name"))
                return indices;  
        );
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*_alias");
                    .putAlias(AliasMetadata.builder("test-alias"))  
            }  
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("test-index");
        // implicit hidden for dot indices based on wildcard starting with .  
            state,  
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
import org.opensearch.action.delete.DeleteRequest;
        // - names of non-existing indices
        String[] strings = indexNameExpressionResolver.indexAliases(  
        context = new IndexNameExpressionResolver.Context(state, options, false);
    public void testConcreteWriteIndexWithWildcardExpansion() {
    public void testConcreteResolvedIndicesIgnoreIndicesOneMissingIndex() {  
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
            @Override
                    IndicesOptions.lenientExpandOpen(),
                    .put(indexBuilder("aaa").state(State.OPEN).putAlias(AliasMetadata.builder("aaa_alias1")))  
        }  
            {
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("alias-0")))
        assertThat(newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")), equalTo(new HashSet<String>()));  
                );
            ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(  
        );
        results = indexNameExpressionResolver.concreteIndexNames(context2, Strings.EMPTY_ARRAY);
            .numberOfShards(1)  
        {
            .put(indexBuilder("testXYY").state(State.OPEN))
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(hiddenIndex));
            .put(indexBuilder("test-1").state(State.OPEN).putAlias(AliasMetadata.builder("alias-1")));  
            assertEquals("index-closed", indices[1].getName());
        assertThat(results, arrayContainingInAnyOrder("foo", "hidden-closed", ".hidden-closed"));  
        Metadata.Builder mdBuilder = Metadata.builder()
    public void testIsPatternMatchingAllIndicesOnlyWildcard() throws Exception {  
        assertThat(results, arrayContainingInAnyOrder("foo", "foobar", "foofoo", "foofoo-closed"));  
        );
    public void testConcreteIndicesIgnoreIndicesEmptyRequest() {
            );  
            IndexNotFoundException infe = expectThrows(
            false
            false
        String[] indicesOrAliases = new String[] { "*" };
            assertEquals(1, results.length);  
        assertThat(Arrays.asList(indexNames), empty());
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, visibleAlias);
    public void testDataStreamsNames() {
        assertThat(  
        threadContext.putHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY, Boolean.FALSE.toString());
            false  
            assertThat(infe2.getIndex().getName(), equalTo("baz*"));
        {  
        assertThat(results, arrayWithSize(1));
import org.opensearch.action.search.SearchRequest;  
            "index_c1"
        final String visibleIndex = "visible_index";  
            .put(indexBuilder("testXYY").state(State.CLOSE))
            state,
    public void testConcreteResolvedIndicesWithWildcards() {
        assertEquals(3, results.length);
            ),
                assertThat(infe.getIndex().getName(), equalTo("bar"));
            public IndicesOptions indicesOptions() {
        assertEquals("bar", results[0]);
            assertThat(results, emptyArray());  
            IndexNotFoundException infe = expectThrows(
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*");
        }  
            String expectedMessage = "To expand [CLOSE] wildcard, please set forbid_closed_indices to `false`";
            );
        assertThat(IndexNameExpressionResolver.isAllIndices(Arrays.asList("index1", "index2", "index3")), equalTo(false));
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(0, indices.length);  
            assertThat(result[3].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 2)));  
        {
        Metadata metadata = metadataBuilder(allConcreteIndices);  
            equalTo("The index expression [test-*] and options provided did not point to a single write-index")
        assertNull(strings);
            IllegalArgumentException iae = expectThrows(
        indexNames = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(state, indicesAndAliasesOptions, "*o"));
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar", "foo", "hidden", "hidden-closed", ".hidden", ".hidden-closed"));
        IndexNotFoundException infe = expectThrows(  
        assertThat(IndexNameExpressionResolver.isAllIndices(Arrays.asList("*")), equalTo(false));
        assertEquals(1, results.length);
            );  
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo*");  
                );
            true,
                    indexBuilder(dottedHiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
        }  
        );
        {
            state,
    }
        String[] strings = indexNameExpressionResolver.filteringAliases(state, "test-0", resolvedExpressions);
        ClusterState state = systemIndexTestClusterState();  
        );
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testXXX", "testXXY", "testYYY", "-testYYY")),
    }
        options = IndicesOptions.fromOptions(false, true, false, true, false, false, false, false);
                IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, indicesOptions, false);  
                context.getOptions().allowNoIndices(),
        aliases = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, true, resolvedExpressions);  
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertThat(Arrays.asList(indexNames), empty());
        String[] strings = indexNameExpressionResolver.indexAliases(
        // - names of existing indices
    }
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);  
            Metadata.Builder mdBuilder = Metadata.builder()  
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))  
            new HashSet<>(Arrays.asList("test-0", "test-alias"))
            "test-0",
            IllegalArgumentException.class,
        ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
        assertThat(results, emptyArray());  
                    EnumSet.of(IndicesOptions.WildcardStates.OPEN, IndicesOptions.WildcardStates.CLOSED)
            assertEquals("foo", results[0]);
        {
            );
        assertEquals(1, results.length);  
        assertEquals(new HashSet<>(Arrays.asList("test-1", "alias-1")), indexNameExpressionResolver.resolveExpressions(state, "*-1"));
                String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
        writeIndex = indexNameExpressionResolver.concreteWriteIndex(state, request);  
    public void testDataStreamsWithClosedBackingIndicesAndWildcardExpressions() {  
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
        {  
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("alias-0").filter("{ \"term\": \"foo\"}")))
    public void testWildcardSystemIndexResolutionMultipleMatchesDeprecated() {  
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.removeIndex().index("test-index");  
        // ignore unavailable but don't allow no indices
        }  
    }
        {
            );  
                return false;
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "my-hidden*", "-my-hidden-a*");
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo");
        assertEquals("foobar", results[0]);  
            .put(  
        return IndexMetadata.builder(index).settings(settings(additionalSettings));  
                    if (indicesOptions.expandWildcardsClosed()) {  
            );
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "my-data-stream");
    public void testIndexOptionsAllowUnavailableDisallowEmpty() {  
            IndicesOptions.strictExpand(),  
            .put(indexBuilder("hidden-closed", Settings.builder().put("index.hidden", true).build()).state(IndexMetadata.State.CLOSE));
                .put(
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
            IllegalArgumentException.class,
            ),
        assertEquals(0, indexNames.length);  
            );  
        assertThat(
import org.opensearch.action.IndicesRequest;  
        IndexMetadata index1 = createBackingIndex(dataStream1, 1).state(State.CLOSE).build();  
        // Open and closed  
        results = indexNameExpressionResolver.concreteIndexNames(context, (String[]) null);
        assertThat(
    }  
                indexBuilder("test-index", Settings.builder().put("index.frozen", true).build()).state(State.OPEN)
            .build();  
    public void testConcreteIndicesWildcardAndAliases() {  
        Metadata.Builder mdBuilder = Metadata.builder()
            .put(indexBuilder("hidden", Settings.builder().put("index.hidden", true).build()))
            assertEquals(
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;  
    }  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
            @Override
import org.opensearch.action.update.UpdateRequest;
            new HashSet<>(Arrays.asList("test-0", "test-1", "alias-0", "alias-1")),
                    .put(justAnIndex, false)  
            IndicesOptions.strictSingleIndexNoExpandForbidClosed(),  
            IndicesOptions.strictExpandOpenAndForbidClosed(),
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
            final String[] allIndices;
        results = indexNameExpressionResolver.concreteIndexNames(context, "foobar2-closed");  
                    IndexNotFoundException.class,  
    }  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.removeIndex().index("test-alias");
            assertEquals(1, indices.length);
        assertThat(concreteResolvedIndices.namesOfConcreteIndices(), containsInAnyOrder("index_a1", "index_a2", "index_b1", "index_b2"));
        assertWarnings(
    }
            IndicesOptions indicesOptions = new IndicesOptions(
        {
        }
        assertEquals(2, results.length);
        {  
                    DataStream.getDefaultBackingIndexName(dataStreamName, 1),
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(  
                IndexNotFoundException.class,
        assertArrayEquals(new String[] { "test-alias" }, strings);  
                Metadata.Builder mdBuilder = Metadata.builder()
                    break;
}  
        Metadata.Builder mdBuilder = Metadata.builder()
import java.util.Arrays;
                () -> indexNameExpressionResolver.concreteIndices(state, indicesOptions, false, "my-data-stream")  
                );
        );  
    public void testIsPatternMatchingAllIndicesMatchingSingleExclusion() throws Exception {
            IndicesOptions noExpandStrict = IndicesOptions.fromOptions(false, false, false, false, randomBoolean());
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "notmatched");
        try {  
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };  
                if (indicesOptions.allowNoIndices()) {  
        {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        assertThat(results, arrayContainingInAnyOrder("hidden"));  
    }  
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("test-alias");  
            assertEquals("foo", results[0]);
import static org.hamcrest.Matchers.containsString;  
            }
        );
    }  
                        .putAlias(AliasMetadata.builder(visibleAlias))
            );
        {
                return IndicesOptions.strictSingleIndexNoExpandForbidClosed();  
            )
        assertEquals(2, indexNames.size());  
                    state,  
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
        Metadata.Builder mdBuilder = Metadata.builder()
        {
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo*");  
                String[] results = indexNameExpressionResolver.concreteIndexNames(context, "baz*");
        }
        }  
    }
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "bar", "baz")  
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
        };  
            .numberOfShards(1)  
            "test-0",
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                state,
                )
            IndicesOptions.fromOptions(false, false, false, false),  
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
            .put(indexBuilder("foo_foo").state(State.OPEN).putAlias(AliasMetadata.builder("foo")))
                expectThrows(IndexNotFoundException.class, () -> indexNameExpressionResolver.concreteIndexNames(context, "bar", "baz"));
            results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        }
            false  
            IndicesOptions.lenientExpandOpen(),  
    public void testDataStreamsWithRegularIndexAndAlias() {  
        assertEquals(1, indexNamesIndexWildcard.length);  
            .put(index2, false)
                () -> indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*_alias")
            state,  
            exception.getMessage(),
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            false
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo", "*");
                containsInAnyOrder(  
            assertEquals(infe.getIndex().getName(), "test-a*");  
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
import java.util.function.Function;  
            expectThrows(
        IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, false, false);  
            state,
    /**
            if (indicesOptions.allowNoIndices()) {
    }  
                assertEquals(2, results.length);  
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo", "-foobar");
            results = indexNameExpressionResolver.concreteIndexNames(context, "baz*");
        }  
                // with no indices, asking for all indices should return empty list or exception, depending on indices options
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED,
                indexBuilder("test-0").state(State.OPEN)
            }
    public void testResolveExpressions() {
                );  
                // with existing indices, asking for all indices should return all open/closed indices depending on options
            public boolean includeDataStreams() {  
        {  
            .numberOfReplicas(1)
                    assertThat(concreteIndices, notNullValue());
                expectThrows(IndexNotFoundException.class, () -> indexNameExpressionResolver.concreteIndexNames(context, "Foo*"));  
            assertEquals(1, results.length);
        context = new IndexNameExpressionResolver.Context(state, options, false);  
 * under the License.  
        assertEquals(1, results.length);  
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpand(), false);  
            IllegalArgumentException.class,
                () -> indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*_alias")  
    /**
        String[] indexNames = indexNameExpressionResolver.concreteIndexNames(state, IndicesOptions.lenientExpandOpen(), "-doesnotexist");
        assertThat(
    public void testConcreteIndicesNoIndicesErrorMessage() {
            fail("foo2-closed should be closed, but it is open");
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, noExpandDisallowEmpty, false);
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "hidden*", "visible*");
            equalTo(
        );
            // Both hidden indices and hidden aliases should not be included in wildcard resolution
    public void testSingleSystemIndexResolutionDeprecated() {
        assertThat(results, emptyArray());
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*");  
        }
            );  
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "my-hidden*");  
    public void testIndexAliasesSkipIdentity() {  
                IndexNotFoundException.class,  
        final String dataStream2 = "logs-redis";
            IndexNotFoundException.class,
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")),  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, visibleAlias);  
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };  
                    IndexNotFoundException.class,  
            assertEquals(1, indices.length);  
        IndexMetadata index4 = createBackingIndex(dataStream2, 2).build();
        {  
        strings = indexNameExpressionResolver.indexAliases(
                state,
                state,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        {  
    public void testAddCustomResolver() {  
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertEquals(1, results.length);  
    private ThreadContext threadContext;
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        assertEquals(1, results.length);  
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "-testXXX", "test*")),
            // A visible index with a visible alias and a hidden index with a hidden alias
        assertEquals(2, results.length);
                    .putAlias(AliasMetadata.builder("other-alias"))
                iae.getMessage()  
            () -> indexNameExpressionResolver.concreteWriteIndex(state, request.indicesOptions(), request.indices()[0], false, false)
        {
            .put(indexBuilder("index_c1"));
            equalTo(newHashSet("testXXX", "testXYY", "testXXY"))
        String[] aliases = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, false, resolvedExpressions);
            assertEquals("index", indices[0].getName());  
            // asking for non existing wildcard pattern should return empty list or exception  
                false  
        }
            assertEquals("test-index", indices[0]);  
        }
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
                IndexNotFoundException.class,  
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
        options = IndicesOptions.fromOptions(false, true, true, false, false);
            IndexNotFoundException infe2 = expectThrows(  
        IllegalArgumentException iae = expectThrows(
        assertThat(concreteResolvedIndices.names(), containsInAnyOrder("alias_a", "index_b1", "index_b2", "index_d"));  
        List<String> indexNames = resolveConcreteIndexNameList(state, request);  
            // A hidden alias with a dot-prefixed name that points to one hidden index with a dot prefix, and one hidden index without
        assertEquals(new HashSet<>(Arrays.asList("alias-0", "alias-1")), indexNameExpressionResolver.resolveExpressions(state, "alias-*"));
        assertThat(results, arrayWithSize(1));  
        {  
        results = indexNameExpressionResolver.concreteIndexNames(context, "foobar1-closed");
        assertEquals(
            assertThat(results, arrayContainingInAnyOrder("foofoo", "foobar"));
import org.opensearch.cluster.ClusterState;
            state,
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Arrays.asList("*")), equalTo(false));
        );
                        .putAlias(AliasMetadata.builder(hiddenAlias).isHidden(true))
            IndexNotFoundException infe = expectThrows(  
                    .put(index3, false)
            );
                EnumSet.of(IndicesOptions.WildcardStates.OPEN)
        IndexNotFoundException infe = expectThrows(IndexNotFoundException.class, () -> concreteResolvedIndices.concreteIndices());  
        assertEquals(Arrays.toString(results), 4, results.length);
            assertThat(results, arrayContainingInAnyOrder("foofoo"));  
        IndexNotFoundException indexNotFoundException = expectThrows(
            )
            Index[] result = indexNameExpressionResolver.concreteIndices(
                "ind*",
                indexNameExpressionResolver.concreteIndexNames(
 * license agreements. See the NOTICE file distributed with
            assertThat(result.getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStreamName, 2)));
            IndexNotFoundException infe = expectThrows(  
            IndexNotFoundException iae = expectThrows(  
        assertEquals(  
        assertThat(  
        assertThat(exception.getMessage(), endsWith(", can't execute a single index op"));  
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("test-a*");
        );  
                ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(Metadata.builder().build()).build();
            );
            // Ignore data streams and allow no indices
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(true));
        {
    protected IndexNameExpressionResolver createIndexNameExpressionResolver(ThreadContext threadContext) {
            Arrays.sort(indices, Comparator.comparing(Index::getName));  
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);  
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*_alias");  
                )  
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(threadContext, customResolvers);  
        assertWarnings(
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        Metadata metadata = metadataBuilder(concreteIndices);
    private ClusterState systemIndexTestClusterState() {
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(  
                IndexNotFoundException infe = expectThrows(
    }  
        assertThat(results, arrayContainingInAnyOrder(".hidden-closed"));  
            assertThat(e.getMessage(), equalTo("no such index [my-data-stream]"));
 * software distributed under the License is distributed on an
            assertThat(
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 1)));
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add()
        assertThat(indexNames, containsInAnyOrder(".ml-meta"));
            assertEquals("test-index", indices[0]);
                assertThat(infe.getIndex().getName(), equalTo("baz*"));  
    public void testIsExplicitAllIndicesEmpty() throws Exception {  
            resolvedExpressions
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar", "hidden", ".hidden"));
            assertThat(result.length, equalTo(2));  
            @Override
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };  
        assertEquals(3, results.length);
        {
        assertThat(results, arrayContainingInAnyOrder("hidden-closed"));  
        final String visibleAlias = "my-visible-alias";
            new OriginalIndices(new String[] { "index_b*", "index_d" }, IndicesOptions.lenientExpandOpen()),  
        }  
        return ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        IndicesOptions options = IndicesOptions.strictExpandOpen();
            IndexNotFoundException infe = expectThrows(
        assertArrayEquals(new String[] { "test-alias" }, strings);
            "index_c*",
            String[] indexNames;  
                    .put(
        ClusterState state = systemIndexTestClusterState();
        ClusterState state = systemIndexTestClusterState();
        assertThat(indexNames, containsInAnyOrder(".ml-meta", ".ml-stuff"));
            x -> x.alias().equals("test-alias-1"),
                assertThat(results, emptyArray());
        final String dataStream1 = "logs-mysql";  
                );
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
            results = indexNameExpressionResolver.concreteIndexNames(context, "bar");  
                IndexNotFoundException.class,
                IndexNotFoundException.class,
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden*");  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            state,
        {
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "test*", "-testX*")),
        IndexMetadata index2 = createBackingIndex(dataStream1, 2).build();  
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo", "foobar");  
                IndexNotFoundException.class,  
                contextICE.getOptions()  
                }  
                + "direct access to system indices will be prevented by default",  
                true,
            IndicesOptions.strictSingleIndexNoExpandForbidClosed(),  
     */
        final String dataStreamName = "my-data-stream";
        }
            IndexNotFoundException infe = expectThrows(
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpandOpen(), false);
                IndexNotFoundException.class,
            illegalArgumentException.getMessage()
        );
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpand(), false);  
        assertTrue(indexNames.contains("bar_bar"));
        {
     */
                );
        }  
            );
            Exception e = expectThrows(  
                false
            assertThat(result.length, equalTo(0));
            assertThat(result[2].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 1)));
            new HashSet<>(Arrays.asList("test-0", "test-1", "test-alias"))
            );  
                    .put(index4, false)
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpand(), false);  
        boolean testZeroWriteIndex = randomBoolean();  
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;  
        assertThat(  
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
            IndexClosedException ince = expectThrows(
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);  
            IndicesOptions.lenientExpandOpen(),  
        assertArrayEquals(new String[] { "test-0" }, strings);  
    }
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("test-*"));  
            Index[] indices = indexNameExpressionResolver.concreteIndices(  
                ),  
        assertEquals("foo", results[0]);
    }
            IndicesOptions indicesOptions = new IndicesOptions(  
        final String dataStream1 = "logs-mysql";
            // A hidden alias that points to one hidden and one visible index
            assertThat(result[2].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 1)));
        String[] allConcreteIndices = new String[] { "index1", "index2", "index3" };
            );
    }
        IndexMetadata index3 = createBackingIndex(dataStream2, 1).build();
            () -> indexNameExpressionResolver.concreteWriteIndex(state, requestGen.apply(null))  
        String[] indicesOrAliases = new String[] { "index*" };  
        Metadata.Builder mdBuilder = Metadata.builder()
            assertEquals("test-index", indices[2].getName());
    }
 *  
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar", "foo"));
        }
        {
            IndicesOptions noExpandLenient = IndicesOptions.fromOptions(true, true, false, false, randomBoolean());  
                    expectThrows(IndexNotFoundException.class, () -> indexNameExpressionResolver.concreteIndexNames(context, allIndices));
        IndexMetadata index2 = createBackingIndex(dataStream1, 2).build();  
 * Unless required by applicable law or agreed to in writing,
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(testZeroWriteIndex ? true : null))
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                state,
        results = indexNameExpressionResolver.concreteIndexNames(context, "-*");  
            () -> indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "my_alias*", "-my_alias")
        String[] indicesOrAliases = new String[] { "-index1", "index1" };
        }
        assertThat(infe.getResourceId().toString(), equalTo("[-*]"));
        );
import static org.hamcrest.Matchers.notNullValue;  
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpandOpen(), false);
        aliases = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, false, resolvedExpressions);
        );  
        for (IndicesOptions options : indicesOptions) {  
            assertEquals("no such index [my-data-*]", iae.getMessage());
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
            deleteIndexRequest.indicesOptions(IndicesOptions.fromOptions(randomBoolean(), false, true, true, false, false, true, false));
            {
            );  
            IndexNotFoundException infe = expectThrows(
            equalTo(newHashSet("testXXX", "testXXY", "testYYY", "-testYYY"))  
            .settings(OpenSearchTestCase.settings(Version.CURRENT))
            IndexNotFoundException.class,  
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
        };
                        .putAlias(AliasMetadata.builder(hiddenAlias).isHidden(true))
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")),
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));  
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "baz*")
        );
            "alias_a",
    public void testIsAllIndicesWildcard() throws Exception {
        );
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
            state,  
            assertEquals(1, results.length);
        assertEquals("no such index []", indexNotFoundException.getMessage());  
            );
import org.opensearch.action.support.IndicesOptions;
        {
    public void testConcreteIndicesAllPatternRandom() {
    }  
            false
        // error on both unavailable and no indices + every alias needs to expand to a single index
        assertEquals(1, results.length);
            );
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Arrays.asList("index1", "index2", "index3")), equalTo(false));
        assertEquals(1, results.length);
        );
        {
        final String hiddenIndex = "my-hidden-index";
import org.opensearch.cluster.ClusterName;  
        assertEquals(3, results.length);  
        Metadata.Builder mdBuilder = Metadata.builder()  
        assertEquals(1, results.length);
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "-testXXX", "*testY*", "-testYYY")),  
        );
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
        assertThat(results, arrayContainingInAnyOrder("bar", ".hidden", ".hidden-closed"));
        Metadata.Builder mdBuilder = Metadata.builder()
    }
        assertThat(results, arrayWithSize(1));
                    )  
                    String[] concreteIndices = indexNameExpressionResolver.concreteIndexNames(context, allIndices);
    public void testIndexOptionsSingleIndexNoExpandWildcards() {  
                IndexNotFoundException.class,
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        // ignore unavailable and allow no indices
        {
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias").writeIndex(false)));
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
            state,
            .put(
        DocWriteRequest request = randomFrom(  
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(  
        for (IndicesOptions options : indicesOptions) {  
        }  
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            .put(indexBuilder(".ml-stuff", settings).state(State.OPEN).system(true))
            );  
        Metadata.Builder mdBuilder = Metadata.builder()  
            state,  
            );
        {
    public void testIsExplicitAllIndicesExplicitAllPlusOther() throws Exception {
    }  
                );
                );
        assertEquals(1, results.length);
                randomBoolean()
                "The provided expression [test-alias] matches an alias, " + "specify the corresponding concrete indices instead.",
    }
        );
            false
            IndicesOptions.fromOptions(
    }  
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("test"));  
        );
        {  
                    if (indicesOptions.expandWildcardsOpen()) {  
        }  
        SearchRequest request = new SearchRequest(".ml-*");
        final IndexNameExpressionResolver.Context context3 = new IndexNameExpressionResolver.Context(
        context = new IndexNameExpressionResolver.Context(state, options, false);  
            assertEquals(1, indices.length);
import static org.hamcrest.Matchers.equalTo;
            assertThat(e.getMessage(), equalTo("no such index [my-data-stream]"));
                return new String[] { "test-alias" };
            state,
                context.getOptions().expandWildcardsClosed(),
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(false));
        );
        );
            .put(indexBuilder("testXXX").state(State.OPEN))  
            .put(indexBuilder("testXXY").state(State.OPEN))  
        {
        // implicit hidden for dot indices based on wildcard starting with .
            x -> true,
                    IndexNotFoundException.class,  
            );
            IndicesOptions.strictExpandOpen(),
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*")
        assertEquals(2, indexNames.size());
                    IndexNotFoundException.class,
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testXXX", "testZZZ")),
        IndicesRequest request = new IndicesRequest() {
            }  
    }
        threadContext = createThreadContext();
        }
        for (int i = 0; i < 10; i++) {  
        // closed and hidden
            false
            assertThat(results, arrayContainingInAnyOrder("foo"));
            // Ignore data streams and allow no indices
        results = indexNameExpressionResolver.concreteIndexNames(context, ".*");  
        context = new IndexNameExpressionResolver.Context(state, expand, false);  
        assertThat(results, arrayContainingInAnyOrder("hidden", "hidden-closed"));
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, indicesOptions, false);
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "bar")
        assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
    /**
            assertEquals(1, results.length);  
    }  
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN; // without include data streams  
        Index writeIndex = indexNameExpressionResolver.concreteWriteIndex(state, request);
    }
    }
        {
        }
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(true));
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));  
     */
        {  
            );
            IndicesOptions.lenientExpandOpen(),
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(  
            .put(
        IllegalArgumentException exception = expectThrows(
        {
    public void testHiddenIndexWithVisibleAliasOverlappingNameResolution() {
        final String dataStream2 = "other-foobar";
                IndexNotFoundException.class,
    }
        assertThat(names, containsInAnyOrder(dataStream2));
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        assertEquals("hidden-closed", results[0]);  
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo", "-foobar", "-hidden*");
        ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(
            IndicesOptions indicesOptions = new IndicesOptions(  
    public void testDataStreamsWithWildcardExpression() {
            new HashSet<>(Arrays.asList("test-0", "alias-0", "alias-1")),
                )  
                .index(dataStreamName)  
                "*"  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                    indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)  
        SearchRequest request = new SearchRequest(".ml-meta");  
                true,
        assertThat(writeIndex.getName(), equalTo("test-0"));  
            true,  
        // only hidden
            }
                IndexNotFoundException.class,  
        assertArrayEquals(new String[] { "alias-0" }, strings);
        ClusterState state = systemIndexTestClusterState();
                IndexNotFoundException.class,
                // unavailable indices are ignored but no indices are disallowed  
        // no wildcards, so wildcard expansion don't apply  
        assertEquals("foo_foo", indexNamesIndexWildcard[0]);
            }  
            assertEquals(2, results.length);
        assertThat(concreteResolvedIndices.withoutResolutionErrors().namesOfConcreteIndices(), containsInAnyOrder("index_b1", "index_c1"));
                    .putAlias(AliasMetadata.builder("test-alias2"))
                "The provided expression [test-alias] matches an alias, " + "specify the corresponding concrete indices instead.",
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("foofoobar")))  
        Metadata metadata = metadataBuilder(concreteIndices);
                IllegalArgumentException.class,  
            // Ignore data streams
                assertThat(infe.getIndex().getName(), equalTo("baz*"));
            );
    }
        }
    }  
            () -> indexNameExpressionResolver.concreteIndices(context, new String[] {})
            // A visible alias that points to one hidden and one visible index  
                case 0:  
        assertThat(  
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
            .collect(Collectors.toList());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(indexBuilder("foo2-closed").state(IndexMetadata.State.CLOSE).putAlias(AliasMetadata.builder("foobar2-closed")))
        Metadata.Builder mdBuilder = Metadata.builder()  
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(index1.getIndex(), index2.getIndex()), 2));  
        options = IndicesOptions.fromOptions(false, true, true, true, false);
        );
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, deleteIndexRequest);
        List<String> names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "log*");
    }
            assertEquals(1, results.length);  
                + "to system indices will be prevented by default"
        assertArrayEquals(new String[] { "test-alias" }, aliases);
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.remove().index("test-index");
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*_alias");
                "test-alias"  
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED,
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        IndicesOptions ignoreAliasesOptions = IndicesOptions.fromOptions(false, true, true, false, true, false, true, false);
            );
                }  
            assertEquals("test-index", indices[0]);
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "*", "-*");
    public void testConcreteWriteIndexWithNoWriteIndexWithSingleIndex() {  
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foofoo-closed", "foofoobar")
        IndexNameExpressionResolver.Context context2 = new IndexNameExpressionResolver.Context(state, options, false);  
                    .putAlias(AliasMetadata.builder(hiddenAlias).isHidden(true))  
    }  
import org.opensearch.Version;
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
    public void testIndexOptionsFailClosedIndicesAndAliases() {
                false  
        );  
        assertThat(Arrays.asList(indexNames), empty());  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            .put(indexBuilder("foo3").putAlias(AliasMetadata.builder("foobar2-closed")));  
            {  
        // testing an alias pointing to three indices:
                "ind*",
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
        IndexMetadata index1 = createBackingIndex(dataStream1, 1).build();
        assertThat(infe.getMessage(), is("no such index [testZZZ]"));
        assertThat(results, arrayContainingInAnyOrder("bar", "hidden", "hidden-closed", ".hidden", ".hidden-closed"));
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
        try {  
        }
                    EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES, IndicesOptions.Option.IGNORE_THROTTLED),
        );
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, false, "my-data-stream");
                    int expectedNumberOfIndices = 0;
        {
        super.setUp();
            .put(indexBuilder("bar_bar").state(State.OPEN).putAlias(AliasMetadata.builder("foo")));  
        }
            );
            );
            // Only visible aliases should be included in wildcard resolution
            )
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));  
        {
            .put(indexBuilder("index_b2"));
        resolvedExpressions = Collections.singleton("other-alias");  
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, noExpandErrorUnavailable, false);
        IllegalArgumentException exception = expectThrows(
            assertEquals("does_not_exist", infe.getIndex().getName());
            state,
        assertThat(result[2].getName(), equalTo("logs-foobarbaz-0"));
        assertThat(results, emptyArray());
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
    public void testConcreteIndicesWildcardNoMatch() {
            @Override
                IllegalArgumentException.class,
        return mdBuilder.build();  
            // Ignore data streams, allow no indices and ignore unavailable
                assertThat(infe.getIndex().getName(), equalTo("baz*"));  
                    .put(
            .put(indexBuilder("some-other-index").state(State.OPEN));  
        assertThat(results, emptyArray());  
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");  
        assertThat(results, arrayContainingInAnyOrder("bar", "hidden", "hidden-closed", ".hidden", ".hidden-closed"));  
        }
        // Only open  
import static org.hamcrest.Matchers.endsWith;  
    public void testIndexOptionsStrict() {  
            public IndicesOptions indicesOptions() {
            .put(indexBuilder("index_closed").state(IndexMetadata.State.CLOSE))
        final String dottedHiddenAlias = ".hidden_alias";
        {  
            .put(
        Metadata metadata = metadataBuilder(concreteIndices);
            state,
            );
        options = IndicesOptions.fromOptions(false, true, false, true, true);
            false
    public void testIsAllIndicesExplicitAll() throws Exception {
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, hiddenAlias);
            .put(indexBuilder(".hidden-closed", Settings.builder().put("index.hidden", true).build()).state(IndexMetadata.State.CLOSE))  
            .put(indexBuilder("foo").putAlias(AliasMetadata.builder("foofoobar")))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // A dot-prefixed pattern that includes only the hidden alias should resolve to both, regardless of the options  
            {
                return false;
            Index result = indexNameExpressionResolver.concreteWriteIndex(state, indicesOptions, "my-data-stream", false, true);  
            assertEquals("foo", results[0]);  
            );
            "The provided expression [my_alias] matches an alias, specify the corresponding concrete indices instead.",  
        }  
            () -> indexNameExpressionResolver.concreteWriteIndex(state, requestGen.apply(new String[] { "too", "many" }))
                    .put(indexBuilder("ccc").state(State.CLOSE).putAlias(AliasMetadata.builder("ccc_alias1")));
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*");
            InvalidIndexNameException.class,
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED,
        assertThat(exception.getMessage(), equalTo("indices request must specify a single index expression"));
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar", "foo"));
            assertThat(e.getMessage(), equalTo("no such index [null]"));
                indicesOptions,  
    }
                "ind*",
            );  
                    .put(
            false
                IndexNotFoundException.class,
        );
            assertThat(infe.getIndex().getName(), equalTo("baz*"));
            @Override
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "logs-*");
        assertEquals(1, results.length);  
                    .putAlias(AliasMetadata.builder("test-alias-0").filter("{ \"term\": \"foo\"}"))  
 *     http://www.apache.org/licenses/LICENSE-2.0
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, ".hidden_a*");  
        assertArrayEquals(new String[] { "test-0" }, strings);
        aliases = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, true, resolvedExpressions);  
            .put(
    }
        assertEquals(1, indexNamesIndexWildcard.length);
            assertThat(infe.getIndex().getName(), equalTo("baz*"));  
    public void testConcreteIndicesIgnoreIndicesOneMissingIndex() {  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
                randomFrom(new String[] { "*" }, new String[] { "_all" }, new String[0])
            Metadata.Builder mdBuilder = Metadata.builder()  
            Metadata.Builder mdBuilder = Metadata.builder()
                    + " indices without one being designated as a write index"
        Metadata.Builder mdBuilder = Metadata.builder()  
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
     * test resolving _all pattern (null, empty array or "_all") for random IndicesOptions  
        assertEquals("Invalid index name [_foo], must not start with '_'.", iine.getMessage());
            assertEquals(0, results.length);
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*");
    public void testIndexOptionsEmptyCluster() {
                IllegalArgumentException.class,  
        String[] allConcreteIndices = new String[] { "index1", "index2", "index3" };
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        Metadata.Builder mdBuilder = Metadata.builder()  
                indicesOptions,
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, concreteIndices, concreteIndices), equalTo(false));  
                "test-alias"  
            assertEquals("test-index", indices[0]);
            assertEquals("test-index", indices[0]);
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));  
import static org.hamcrest.Matchers.arrayWithSize;
            options = IndicesOptions.fromOptions(false, true, false, true, false, true, false, false);
        assertThat(results, arrayContaining("foo1-closed"));
    }
                String[] concreteIndices = indexNameExpressionResolver.concreteIndexNames(context, "Foo*");
        );
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), dataStream1);
import java.util.Set;
            switch (randomIntBetween(0, 2)) {
            .put(additionalSettings);  
            new HashSet<>(Arrays.asList("test-0", "test-alias"))  
            .put(indexBuilder("testYYX").state(State.OPEN));  
                    .put(index1, false)
            .put(index2, false)  
                indexBuilder("test-1").state(State.OPEN)  
    }  
        {  
            new IndexRequest("test-alias"),
        assertTrue(indexNames.contains("foo_foo"));  
        assertThat(
                contextICE.getOptions().expandWildcardsClosed(),
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*_alias");
            assertThat(e.getMessage(), containsString("alias [foofoobar] has more than one index associated with it"));
        IndexNotFoundException infe = expectThrows(  
        IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
        assertThat(
            )
                IndexNotFoundException infe = expectThrows(
            {
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "my-*");  
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        assertEquals(3, results.length);
        Metadata.Builder mdBuilder = Metadata.builder()  
            .put(index4, false)
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "bar")  
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(randomFrom(!test0WriteIndex, null)))
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;  
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            // A query that only matches the hidden alias should throw
            IllegalArgumentException e = expectThrows(  
        String[] indicesOrAliases = new String[] { "-index1" };  
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(dottedHiddenIndex, hiddenIndex));
        results = indexNameExpressionResolver.concreteIndexNames(context2, "foo*");
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, expandOpen, false);
        IndexMetadata index4 = createBackingIndex(dataStream2, 2).build();  
     * test resolving wildcard pattern that matches no index of alias for random IndicesOptions  
        Metadata.Builder mdBuilder = Metadata.builder()
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(  
        assertThat(concreteResolvedIndices.namesOfConcreteIndices(), containsInAnyOrder("index_b1", "index_b2"));
    private static IndexMetadata.Builder indexBuilder(String index) {
        Settings settings = Settings.builder().build();
            IndexNotFoundException.class,
            state,
            "test-0",
            }
                IllegalArgumentException.class,
        assertArrayEquals(null, strings);  
        // We test the following semantics:  
        }
        );  
        assertThat(results, arrayContainingInAnyOrder("foo", "foofoo"));
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
        SearchRequest request = new SearchRequest(randomFrom("*", "_all"));
            .put(indexBuilder("-testXZZ").state(State.OPEN))  
                    .put(index1, false)
                );  
        {
import org.opensearch.indices.InvalidIndexNameException;
            }
        for (int i = 0; i < 10; i++) {  
    }  
            new IndexRequest("test-alias"),
        );
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpandOpen(), false);
            Arrays.sort(result, Comparator.comparing(Index::getName));
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("test-index"));
        assertThat(result.length, equalTo(3));
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
            () -> indexNameExpressionResolver.concreteIndexNames(context, "testMo", "testMahdy")  
    }
    }
            assertThat(result.length, equalTo(2));
        assertThat(
                assertThat(concreteIndices.length, equalTo(0));
            // A total wildcards does not resolve the hidden index in this case
        results = indexNameExpressionResolver.concreteIndexNames(context, ".hidd*");
        }
        List<String> indexNames = resolveConcreteIndexNameList(state, request);  
                () -> indexNameExpressionResolver.concreteWriteIndex(state, indicesOptions, "my-data-stream", true, false)
        assertArrayEquals(new String[] { "other-alias" }, aliases);
            assertEquals(1, indices.length);
                IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, indicesOptions, false);
            indexNameExpressionResolver.concreteIndexNames(context, "foobar2-closed");
        assertThat(IndexNameExpressionResolver.isAllIndices(Collections.<String>emptyList()), equalTo(true));
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
        {
            );
            assertThat(result.length, equalTo(4));
            }  
        state = ClusterState.builder(state)
            assertEquals(1, indices.length);
    }
                IndexNotFoundException infe = expectThrows(
import static org.hamcrest.Matchers.arrayContaining;
    }
            );
                );
        // - For the names() property we include:
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            false
    }
        assertThat(results, emptyArray());
                () -> indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("does_not_exist"))
        // open and hidden  
        Arrays.sort(strings);
        assertThat(results, arrayContainingInAnyOrder("foobar", "foo"));  
        IllegalArgumentException illegalArgumentException = expectThrows(  
                "my-data-stream"  
            final IndicesOptions indicesOptions = IndicesOptions.fromOptions(  
    public void testConcreteWriteIndexWithNoWriteIndexWithMultipleIndices() {
        results = indexNameExpressionResolver.concreteIndexNames(context, "foobar2-closed");
 * GitHub history for details.
            assertEquals(2, results.length);
                if (indicesOptions.expandWildcardsOpen() || indicesOptions.expandWildcardsClosed() || indicesOptions.allowNoIndices()) {
        assertEquals("bar", results[0]);
        {  
            {
                    "testXYY",
        assertEquals("bar", results[0]);
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "baz*");
                state,  
            () -> indexNameExpressionResolver.concreteIndexNames(context2, "-*")  
            assertThat(results, emptyArray());
            state,
        }
    }
        {
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")),  
            );  
        assertThat(concreteResolvedIndices.names(), containsInAnyOrder("index_closed", "index_c1", "baz*", "alias_b", "alias_a"));  
    }  
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden-closed");
        exception = expectThrows(  
            state,
            IndexNotFoundException.class,
                            AliasMetadata.builder("test-alias").writeIndex(testZeroWriteIndex ? randomFrom(false, null) : true)
            state,
            assertEquals(1, results.length);
    public void testIsPatternMatchingAllIndicesMatchingTrailingWildcard() throws Exception {
            assertEquals("foo", results[0]);
            {  
                    expectThrows(IndexNotFoundException.class, () -> indexNameExpressionResolver.concreteIndexNames(context, allIndices));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(
 *
                Metadata.builder()
        );
            results = indexNameExpressionResolver.concreteIndexNames(context, "barbaz", "bar");
    private ThreadContext createThreadContext() {  
            () -> indexNameExpressionResolver.concreteIndices(context, new String[] {})
            assertEquals(new HashSet<>(Arrays.asList("foo", "foobar")), new HashSet<>(Arrays.asList(results)));  
        }
        );  
                state,
        Set<String> resolvedExpressions = new HashSet<>(Arrays.asList("test-0", "test-alias"));  
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("test-a*");  
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*")
                IndexNotFoundException.class,
                IndexNotFoundException.class,
        results = indexNameExpressionResolver.concreteIndexNames(context2, "foo*", "bar");
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpand(), false);  
                indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("foofoobar")))
        IndexNameExpressionResolver.Context contextICE = new IndexNameExpressionResolver.Context(  
            }
        String[] strings = indexNameExpressionResolver.concreteIndexNames(context, "alias-*");
            // Ignore data streams; use different overload
            assertEquals(1, results.length);
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                IndexClosedException.class,  
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(false));
        }
        {  
                state,
            assertThat(e.getMessage(), containsString("alias [foofoobar] has more than one index associated with it"));
        results = indexNameExpressionResolver.concreteIndexNames(context, ".*");
            .put(indexBuilder("test-index").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias")))
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo1-closed");
        options = IndicesOptions.fromOptions(false, true, true, false, true);
import org.opensearch.index.IndexNotFoundException;
            .put(index3, false)  
                    indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)  
        {
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(dottedHiddenIndex, hiddenIndex));
        }
                assertThat(results, arrayContainingInAnyOrder("foo", "foobar"));
                return IndicesOptions.strictExpandOpenAndForbidClosed();
        {  
            }
        assertEquals(
            assertEquals(1, indices.length);
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);  
        final IndexNameExpressionResolver.Context context2 = new IndexNameExpressionResolver.Context(
    private static Settings.Builder settings(Settings additionalSettings) {  
        assertThat(results, arrayContainingInAnyOrder(".hidden", ".hidden-closed"));  
            assertEquals(2, results.length);  
            indexNameExpressionResolver.resolveExpressions(state, "test-*", "alias-*")  
        IndicesOptions includeHiddenOptions = IndicesOptions.fromOptions(false, true, true, false, true, true, false, false, false);
        Metadata metadata = metadataBuilder(concreteIndices);
                assertThat(concreteIndices, notNullValue());  
                false
import org.opensearch.core.index.Index;
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(true));
                indexBuilder("foo1-closed").state(IndexMetadata.State.CLOSE)
            Index[] indices = indexNameExpressionResolver.concreteIndices(
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, "logs-*");
            }  
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "logs-*");  
import static org.hamcrest.Matchers.empty;
            );
            IllegalArgumentException.class,
                assertThat(infe.getIndex().getName(), equalTo("bar"));
        );
        assertThat(results, arrayContainingInAnyOrder(".hidden", ".hidden-closed"));
        assertEquals(4, results.length);
            .put(indexBuilder("testXXX").state(State.OPEN))
        assertThat(results, arrayContainingInAnyOrder("hidden"));  
            .put(indexBuilder("index").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias2")));  
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
            // A total wildcard should only be resolved to visible indices
            results = indexNameExpressionResolver.concreteIndexNames(context, "barbaz", "foobar");
            public String[] indices() {
            }
    }
                    "testXXX",
        return settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
    public void testIndexAliases() {
        DocWriteRequest request = randomFrom(
        assertThat(results, arrayContaining("foo1-closed"));
            deleteIndexRequest.indicesOptions(IndicesOptions.fromOptions(true, true, true, true, false, false, true, false));
            );
            exception.getMessage(),
        assertEquals("foo", results[0]);
            assertThat(results, arrayContainingInAnyOrder("foofoo", "foobar"));
            equalTo(newHashSet("testYYX", "testXXX", "testXYY", "testYYY", "testXXY"))
        Metadata.Builder mdBuilder = Metadata.builder()
        }
    }  
        assertEquals(0, indexNames.length);
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testXXY", "-testX*")),  
            assertEquals(1, results.length);  
    public void testSingleSystemIndexResolutionAllowed() {
            String[] indexNames;
        );  
        boolean testZeroWriteIndex = randomBoolean();
        assertEquals(2, indexNames.size());  
    }
                IllegalArgumentException.class,
            assertThat(results, arrayContainingInAnyOrder("foofoo", "foobar"));
 * not use this file except in compliance with the License.
            IndicesOptions.fromOptions(true, true, false, false),  
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        final String visibleAlias = "visible_alias";
        IndicesOptions[] indicesOptions = new IndicesOptions[] {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
            }
            assertThat(result.length, equalTo(2));
import org.opensearch.action.OriginalIndices;
        );
            // A query that doesn't include the dot should fail if the options don't include hidden  
            assertEquals(2, results.length);
                IndexNotFoundException infe = expectThrows(
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*_alias");  
            state,  
            Arrays.sort(indices, Comparator.comparing(Index::getName));  
        IndexMetadata justAnIndex = IndexMetadata.builder("logs-foobarbaz-0")
                .put(
        assertEquals("bar", results[0]);  
                    + " indices without one being designated as a write index"  
import java.util.Comparator;
            .put(
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("test"));
import org.opensearch.indices.IndexClosedException;
        assertThat(
            Arrays.sort(result, Comparator.comparing(Index::getName));
        assertTrue(indexNames.contains("bar_bar"));
        assertEquals(
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
                assertThat(infe.getIndex().getName(), equalTo("bar"));  
            );
                } else {
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
            assertEquals(new HashSet<>(Arrays.asList("foo", "foobar")), new HashSet<>(Arrays.asList(results)));
            IndicesOptions.strictExpandOpen(),
            new UpdateRequest("test-alias", "_id"),
            state,
    public void testInvalidEmptyIndex() {
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)  
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(dottedHiddenIndex, hiddenIndex));
        IndicesOptions excludeHiddenOptions = IndicesOptions.fromOptions(false, true, true, false, false, true, false, false, false);  
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "bar")  
        Arrays.sort(strings);
            IndicesOptions.strictExpandOpenAndForbidClosed() };
                EnumSet.noneOf(IndicesOptions.Option.class),  
        expectThrows(IndexClosedException.class, () -> indexNameExpressionResolver.concreteIndexNames(contextICE, "foobar1-closed"));  
            IndicesOptions.strictExpandOpen(),  
        {
        assertThat(results, arrayContainingInAnyOrder(".hidden"));  
        final String hiddenAlias = "hidden_alias";  
                state,  
        assertThat(indexNames, containsInAnyOrder("some-other-index", ".ml-stuff", ".ml-meta"));
        assertArrayEquals(new String[] { "test-alias-0", "test-alias-1", "test-alias-non-filtering" }, strings);  
            .build();
        final String dottedHiddenIndex = ".hidden_index";
    }  
        IndexMetadata index1 = createBackingIndex(dataStream1, 1).build();
    }
        Metadata.Builder mdBuilder = Metadata.builder()
        String[] indexNames;
        IndicesOptions options = IndicesOptions.fromOptions(false, true, false, true, false);
            }
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
            assertThat(results, equalTo(new String[] { "index1" }));  
        );
    }  
            equalTo(newHashSet("kuku", "testXXX"))  
        assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 1)));  
    public void setUp() throws Exception {  
        results = indexNameExpressionResolver.concreteIndexNames(context2, "foo");  
        {
        }  
        }  
import java.util.List;
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "logs-m*");
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo");
            );  
    public void testIgnoreAliasesOnNonWildcardValue() {  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertTrue(indexNames.contains("foo_foo"));
                    IndexNotFoundException.class,  
    }
            IndexNotFoundException.class,
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
     * This should keep the name of the missing index and defer the throwing of the exception to the point  
        );  
        assertEquals(5, results.length);
            false  
            equalTo(newHashSet("-testXYZ", "-testXZZ"))
        assertEquals(3, results.length);  
            equalTo(newHashSet("testXXY", "-testXYZ", "-testXZZ"))
    public void testIsAllIndicesExplicitAllPlusOther() throws Exception {
            state,
    }
        );
            state,
    }
    public void testIsExplicitAllIndicesNormalIndexes() throws Exception {  
            IllegalArgumentException.class,
                "no such index [baz*]",
            assertEquals("index", indices[0].getName());  
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*");  
                context.getOptions()
            assertEquals("test-a*", infe.getIndex().getName());  
        Metadata.Builder mdBuilder = Metadata.builder()
        strings = indexNameExpressionResolver.filteringAliases(state, "test-0", resolvedExpressions);  
            .put(backingIndex, false)  
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, new String[] {})),
                randomBoolean(),  
                    .putAlias(AliasMetadata.builder("foobar2-closed"))  
        assertThat(names, empty());
            assertEquals("test-a*", infe.getIndex().getName());
    public void testIsExplicitAllIndicesNull() throws Exception {
        // expressions against the defined indices and aliases
        // when ignoreAliases is set, and an alias is specified in the index expression without using a wildcard,
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(randomFrom(test0WriteIndex, null)))  
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
            IndicesOptions noExpandDisallowEmpty = IndicesOptions.fromOptions(true, false, false, false, randomBoolean());
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertThat(results, arrayContainingInAnyOrder("hidden-closed"));
                    .put(
            assertEquals("test-a*", infe.getIndex().getName());
            assertThat(result[3].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 2)));
        IndexNotFoundException infe = expectThrows(
                IndexNotFoundException.class,
        results = indexNameExpressionResolver.concreteIndexNames(context, ".hidd*");
            .put(indexBuilder("test-1").state(IndexMetadata.State.CLOSE).putAlias(AliasMetadata.builder("alias-1")));  
            .build();
            .put(indexBuilder("test-index").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias")))
        assertEquals(1, results.length);
            assertEquals("foo", results[0]);
            assertThat(results, emptyArray());  
        }  
    public void testIsPatternMatchingAllIndicesNonMatchingTrailingWildcardAndExclusion() throws Exception {
            x -> true,
            .build();  
            )
        assertEquals("foo_foo", indexNamesIndexWildcard[0]);  
            assertEquals(1, indices.length);
        );  
        }
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
                IndexNotFoundException.class,
        );
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*");
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
            false  
        Metadata metadata = metadataBuilder(allConcreteIndices);  
        {  
import java.util.stream.Collectors;
            mdBuilder.put(indexBuilder(concreteIndex));
                        expectedNumberOfIndices += 1;
        Metadata.Builder mdBuilder = Metadata.builder()  
                .put(
        assertThat(results, arrayContainingInAnyOrder("foo", "foobar", "foofoo"));
            .put(index2, false)
                    .putAlias(AliasMetadata.builder("foobar1-closed"))
        }
    public void testFullWildcardSystemIndexResolutionDeprecated() {  
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, hiddenAlias);  
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));  
            assertEquals(ince.getIndex().getName(), "foofoo-closed");
        assertThat(
            assertThat(results, arrayContainingInAnyOrder("foo", "foobar"));
        IllegalArgumentException exception = expectThrows(  
        {
        assertThat(results, arrayContainingInAnyOrder("foobar", "foo"));  
            .map(i -> i.getName())  
            IndexNotFoundException infe = expectThrows(
    public void testConcreteResolvedIndicesWithIndicesRequestParam() {  
            assertEquals(2, results.length);
            }
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 1)));  
        ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(
                    .put(index2, false)  
                ),
                );
            () -> indexNameExpressionResolver.concreteIndexNames(context, "")
                    assertThat(concreteIndices.length, equalTo(0));  
            newHashSet(
        assertEquals(1, results.length);  
            equalTo(newHashSet("testYYX", "testYYY", "-testYYY"))
        results = indexNameExpressionResolver.concreteIndexNames(context, ".*");
        results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo*");
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
            )
                "no write index is defined for alias [test-alias]."  
        results = indexNameExpressionResolver.concreteIndexNames(context, "h*");
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*_alias");
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(testZeroWriteIndex ? true : null))  
        }  
        assertThat(
                IndexNotFoundException infe = expectThrows(
 */  
                } else {
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "*", "-logs-foobar");
        assertEquals(3, results.length);  
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
        }
                    .put(index2, false)  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
            IndicesOptions.lenientExpandOpen(),
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
        }
                        .putAlias(AliasMetadata.builder(dottedHiddenAlias).isHidden(true))
                assertThat(infe.getIndex().getName(), equalTo("bar"));  
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "test*", "-testXXX")),  
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, true, false), false);
            public boolean includeDataStreams() {  
        assertEquals(indexNameExpressionResolver.getExpressionResolvers().get(0), customResolver);
                IndexNotFoundException infe = expectThrows(
import static org.hamcrest.Matchers.is;
import org.opensearch.action.index.IndexRequest;
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar"));
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(false));
        String[] indicesOrAliases = new String[] { "index*" };
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        {
            assertEquals("foo", results[0]);
    public void testIsExplicitAllIndicesExplicitAll() throws Exception {
                    IndexNotFoundException.class,  
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        Metadata.Builder mdBuilder = Metadata.builder()
    public void testConcreteWriteIndexSuccessful() {
        );  
    }
        assertThat(results, emptyArray());
                IndexNotFoundException infe = expectThrows(
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo", "foobar");  
            equalTo(newHashSet("testYYY", "testYYX"))  
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            false
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
            IndicesOptions.lenientExpandOpen(),
        assertEquals(2, indexNames.size());
        {  
    }  
        strings = indexNameExpressionResolver.filteringAliases(state, "test-0", resolvedExpressions);
            .put(new DataStream(dataStream1, createTimestampField("@timestamp"), List.of(index1.getIndex(), index2.getIndex())))  
                EnumSet.of(IndicesOptions.WildcardStates.OPEN)
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Arrays.asList("_all", "other")), equalTo(false));  
                new IndicesOptions(
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(testZeroWriteIndex ? randomFrom(false, null) : true))
        );  
        assertEquals(7, results.length);
        assertThat(IndexNameExpressionResolver.isAllIndices(null), equalTo(true));  
    }
 */
            equalTo(  
        assertThat(infe.getMessage(), is("no such index [_all] and no indices exist"));
        assertThat(results, emptyArray());
        assertThat(results, emptyArray());
        for (IndicesOptions options : indicesOptions) {  
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*")
            );  
        );
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)  
                        .putAlias(AliasMetadata.builder(dottedHiddenAlias).isHidden(true))  
                assertThat(infe.getIndex().getName(), equalTo("bar"));
import org.opensearch.core.common.Strings;  
    public void testIsExplicitAllIndicesWildcard() throws Exception {
        options = IndicesOptions.fromOptions(false, true, false, false, true);  
        }
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
            iae.getMessage()
        Arrays.sort(strings);
                "The provided expression [test-alias] matches an alias, " + "specify the corresponding concrete indices instead.",
                .put(indexBuilder(visibleIndex).state(State.OPEN).putAlias(AliasMetadata.builder(visibleAlias)))
        assertThat(results, emptyArray());  
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("test-*");
        {
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("test-alias");  
            {
            {
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("test-a*"));  
    }  
        );  
            () -> indexNameExpressionResolver.concreteIndexNames(  
        final String dataStream1 = "logs-foobar";  
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
            Arrays.sort(result, Comparator.comparing(Index::getName));
                    indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)  
        );  
            IndicesOptions.lenientExpandOpen(),  
 * The OpenSearch Contributors require contributions made to  
                .alias("my-data");
        }
                    allIndices = new String[] { Metadata.ALL };
            assertThat(result.length, equalTo(2));  
                indexBuilder("test-1").state(State.OPEN)  
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("my-data-*").alias("my-data");
        {
    public void testIsPatternMatchingAllIndicesMatchingTrailingWildcardAndExclusion() throws Exception {
            state,
    public void testIndicesAliasesRequestTargetDataStreams() {
            )
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);  
        assertThat(newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")), equalTo(newHashSet("testXYY")));
            // expected
                state,  
            assertEquals(1, indices.length);
        IndicesOptions[] indicesOptions = new IndicesOptions[] { expandOpen, expand };
            ;
                + "to system indices will be prevented by default"
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, hiddenAlias);
            state,
    }
        }  
        );
            .put(new DataStream(dataStream2, createTimestampField("@timestamp"), List.of(index3.getIndex(), index4.getIndex())));  
        String[] strings = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, true, resolvedExpressions);
    public void testIsAllIndicesNull() throws Exception {
        }  
        assertEquals(1, results.length);
                IndexNotFoundException.class,
                    "-testXXY"
import static org.opensearch.cluster.metadata.IndexNameExpressionResolver.SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY;  
     * Same as testConcreteIndicesIgnoreIndicesOneMissingIndex() but using the concreteResolvedIndices() method.
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "index1", "index1", "alias1");
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            IllegalArgumentException iae = expectThrows(
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_HIDDEN_SETTING;
                IndexNotFoundException.class,
            .put(indexBuilder("test-1").state(State.OPEN).putAlias(AliasMetadata.builder("alias-1")));
            IndicesOptions.fromOptions(true, false, true, false),  
        String[] concreteIndices = new String[] { "index2", "index3" };
            assertEquals(  
        Metadata.Builder mdBuilder = Metadata.builder()  
    }
        IndicesOptions[] indicesOptions = new IndicesOptions[] { IndicesOptions.strictExpandOpen(), IndicesOptions.strictExpand() };  
        assertArrayEquals(new String[] { "test-alias" }, strings);
            "index_d"  
        Metadata.Builder mdBuilder = Metadata.builder()
        assertEquals(3, results.length);
            @Override  
        String[] strings = indexNameExpressionResolver.indexAliases(
                    IndexNotFoundException.class,
        assertEquals("foobar", results[0]);  
        resolvedExpressions = new HashSet<>(Arrays.asList("test-0", "alias-0", "alias-1"));
                    .putAlias(AliasMetadata.builder("test-alias-closed"))
        );  
            assertThat(results, emptyArray());  
        SearchRequest request = new SearchRequest(".ml-*");  
        }
        IndexMetadata justAnIndex = IndexMetadata.builder("logs-foobarbaz-0")
                    break;
                context.getOptions().expandWildcardsOpen(),  
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.remove().index("test-a*");  
        assertEquals(3, results.length);
    public void testFilteringAliases() {  
        assertThat(  
                        new DataStream(dataStream2, createTimestampField("@timestamp"), Arrays.asList(index3.getIndex(), index4.getIndex()))
            // But should include both indices if the options do include hidden  
            assertEquals(1, results.length);  
            {
    private static Metadata metadataBuilder(String... indices) {
            true,
        Function<String[], IndicesRequest> requestGen = (indices) -> new IndicesRequest() {
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden");
        IndexMetadata index3 = createBackingIndex(dataStream2, 1).state(State.CLOSE).build();
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);  
                indexBuilder("index-closed", Settings.builder().put("index.frozen", true).build()).state(State.CLOSE)
            state,
        );
            IndicesOptions.strictExpandOpen(),  
            Index[] indices = indexNameExpressionResolver.concreteIndices(
            // If we specify a hidden alias by name, the options shouldn't matter.  
        assertNull(strings);
            )
        }  
                "test-index"
                .put(indexBuilder("aaa").state(State.OPEN).putAlias(AliasMetadata.builder("aaa_alias1")))  
import static org.hamcrest.Matchers.containsInAnyOrder;
                    }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        }  
            );  
        indexNamesIndexWildcard = indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "*o");  
            .put(indexBuilder("foo").putAlias(AliasMetadata.builder("foofoobar")))
        assertTrue(indexNames.contains("foo_foo"));
                Arrays.stream(result).map(Index::getName).collect(Collectors.toList()),
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
        );
            context,
                    allIndices = null;
        assertTrue(indexNames.contains("bar_bar"));
        );  
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);  
    }
        );
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "barbaz");  
            );  
        assertThat(results, arrayWithSize(3));  
            assertEquals("index", indices[0].getName());
    }  
    }
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*");
        Metadata.Builder mdBuilder = Metadata.builder()  
                    )  
            );  
        };  
        assertEquals(2, results.length);
        assertThat(results, arrayContainingInAnyOrder(".hidden-closed"));
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            .put(indexBuilder(".hidden", Settings.builder().put("index.hidden", true).build()))
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);  
    }  
        assertArrayEquals(new String[] { "test-alias" }, strings);
            IndicesOptions.fromOptions(true, true, true, true),
        public List<String> resolve(IndexNameExpressionResolver.Context context, List<String> expressions) {
                Metadata.builder()
        Metadata.Builder mdBuilder = Metadata.builder()  
            assertThat(e.getMessage(), equalTo("no such index [my-data-stream]"));
    public void testIsAllIndicesEmpty() throws Exception {  
                default:  
        IndicesOptions ignoreAliasesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, true, false);
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        }
                + "to system indices will be prevented by default",  
            .put(indexBuilder("testYYX").state(State.OPEN));
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*")
            Metadata.Builder mdBuilder = Metadata.builder()  
            );
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();  
        assertThat(names, empty());
        assertThat(
            "this request accesses system indices: [.ml-stuff], but in a future major version, direct access "
        final String dataStreamName = "my-data-stream";
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "foofoobar")  
        String[] allConcreteIndices = new String[] { "index1", "index2", "index3", "a", "b" };
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo*", "bar")  
                .put(
            equalTo(newHashSet("testXXX", "testXXY", "testXYY"))
                .put(indexBuilder(visibleIndex).state(State.OPEN).putAlias(AliasMetadata.builder(hiddenAlias).isHidden(true)))
                indexBuilder("index", Settings.builder().put(IndexSettings.INDEX_SEARCH_THROTTLED.getKey(), true).build()).state(State.OPEN)  
        // even though it does identify all indices, it's not a pattern but just an explicit list of them  
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);  
            () -> indexNameExpressionResolver.concreteIndexNames(context3, Strings.EMPTY_ARRAY)
 * You may obtain a copy of the License at  
            .put(index1, false)
import java.util.HashSet;  
            "index_b*",
        assertThat(results, arrayContaining("foo3"));
                IndexNotFoundException infe = expectThrows(  
            .put(indexBuilder("testXXY").state(State.OPEN))
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        assertEquals(5, results.length);
                "test-index"  
                contextICE.getOptions().expandWildcardsOpen(),
            concreteResolvedIndices.resolutionErrors().stream().map(Throwable::getMessage).toList(),  
            );  
            .put(indexBuilder("index_b1"))  
            Metadata.Builder mdBuilder = Metadata.builder()
            assertEquals("no such index [" + dataStreamName + "]", iae.getMessage());
    public void testConcreteIndicesWildcardExpansion() {
                    .putAlias(AliasMetadata.builder(visibleAlias).build())
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, noExpandLenient, false);
            assertEquals("foo", results[0]);
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));  
        Set<String> resolvedExpressions = indexNameExpressionResolver.resolveExpressions(state, "test-*");
                + "direct access to system indices will be prevented by default"
            assertThat(concreteResolvedIndices.resolutionErrors().getFirst().getMessage(), equalTo("no such index [my-data-stream]"));
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("barbaz")))  
import org.opensearch.test.OpenSearchTestCase;  
    public void testConcreteIndicesNoIndicesErrorMessageNoExpand() {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver.ExpressionResolver;  
            "alias_a",  
                indexBuilder("test-1").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias").writeIndex(randomFrom(false, null)))  
            assertEquals("test-index", indices[0]);  
