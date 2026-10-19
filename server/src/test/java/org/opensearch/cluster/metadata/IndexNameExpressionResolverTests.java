            );
        }
                        .putAlias(AliasMetadata.builder(hiddenAlias).isHidden(true))
    public void testConcreteIndicesWildcardWithNegation() {
            // Both hidden indices and hidden aliases should not be included in wildcard resolution
import org.opensearch.cluster.ClusterState;
        threadContext = createThreadContext();
                    assertThat(concreteIndices.length, equalTo(expectedNumberOfIndices));
                    break;
    public void testConcreteIndicesAllPatternRandom() {
        {
import org.opensearch.index.IndexSettings;
        {
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, IndicesOptions.lenientExpandOpen(), "*", "-*");
                state,
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        IndexNotFoundException infe = expectThrows(
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
            assertEquals("test-index", indices[0].getName());
        final String visibleAlias = "visible_alias";
            .put(index1, false)
    public void testAliasResolutionNotAllowingMultipleIndices() {
        IndicesOptions ignoreAliasesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, true, false);
        }
            IndexNotFoundException infe = expectThrows(
                IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, indicesOptions, false);
                        expectedNumberOfIndices += 1;
            IllegalArgumentException iae = expectThrows(
            .put(indexBuilder("testYYX").state(State.OPEN));
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 1)));
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo", "-foobar");
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(testZeroWriteIndex ? true : null))
            ;
        IllegalArgumentException iae = expectThrows(
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertThat(results, arrayContainingInAnyOrder(".hidden"));
        options = IndicesOptions.fromOptions(false, true, true, false, false);
                ),
                );
                // unavailable indices are ignored but no indices are disallowed
        );
            )
        Metadata.Builder mdBuilder = Metadata.builder()
                    IndexNotFoundException.class,
import org.opensearch.common.settings.Settings;
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*");
    public void testFullWildcardSystemIndexResolutionAllowed() {
            assertThat(result[2].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 1)));
        assertThat(results, arrayContainingInAnyOrder(".hidden", ".hidden-closed"));
        options = IndicesOptions.fromOptions(false, true, true, true, true);
        }
                IndexNotFoundException infe = expectThrows(
        IndicesOptions ignoreAliasesOptions = IndicesOptions.fromOptions(false, true, true, false, true, false, true, false);
                "my-data-stream"
            Index[] indices = indexNameExpressionResolver.concreteIndices(
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
        assertThat(
            assertEquals("test-a*", infe.getIndex().getName());
        ClusterState state = systemIndexTestClusterState();
        );
        assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 1)));
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(randomFrom(test0WriteIndex, null)))
import java.util.Collections;
     * test resolving wildcard pattern that matches no index of alias for random IndicesOptions
            "index_b*",
            new HashSet<>(Arrays.asList("test-0", "test-1", "test-alias"))
        for (IndicesOptions options : indicesOptions) {
        // implicit hidden for dot indices based on wildcard starting with .
                    IndexNotFoundException.class,
        }
        assertEquals(3, results.length);
            );
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*_alias");
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
    public void testHiddenAliasAndHiddenIndexResolution() {
            );
                    "-testXXY"
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Arrays.asList("*")), equalTo(false));
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.remove().index("test-index");
    public void testConcreteResolvedIndicesIgnoreIndicesOneMissingIndex() {
            assertEquals("test-index", indices[0]);
            );
        {
            assertEquals(new HashSet<>(Arrays.asList("foo", "foobar")), new HashSet<>(Arrays.asList(results)));
                    IndexNotFoundException.class,
            results = indexNameExpressionResolver.concreteIndexNames(context, "baz*");
                "test-*"
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
    }
        ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(
                IndexNotFoundException.class,
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, deleteIndexRequest);
            }
                    .put(indexBuilder("bbb").state(State.OPEN).putAlias(AliasMetadata.builder("bbb_alias1")))
        // implicit hidden for dot indices based on wildcard starting with .
                state,
        assertEquals(new HashSet<>(Arrays.asList("alias-0", "alias-1")), indexNameExpressionResolver.resolveExpressions(state, "alias-*"));
            }
        );
            () -> indexNameExpressionResolver.concreteIndexNames(context3, Strings.EMPTY_ARRAY)
            .put(backingIndex, false)
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo1-closed");
    public void testConcreteWriteIndexWithNoWriteIndexWithMultipleIndices() {
                state,
            IndicesOptions.lenientExpandOpen(),
        assertThat(
            IndicesOptions.fromOptions(
        }
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "baz*")
            0
            assertThat(e.getMessage(), equalTo("no such index [my-data-stream]"));
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("my-data-*").alias("my-data");
            }
        // implicit hidden for dot indices based on wildcard starting with .
        results = indexNameExpressionResolver.concreteIndexNames(context2, "foo*");
        }
            );
        );
            exception.getMessage(),
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "test*", "-testXXX")),
     */
        String[] indicesOrAliases = new String[] { "-index1", "index1" };
        );
            .put(
            assertEquals("foo", results[0]);
    }
            {
            }
        );
        assertEquals("no such index []", indexNotFoundException.getMessage());
            assertEquals(2, results.length);
        assertThat(
            containsInAnyOrder(
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED,
    }
                IllegalArgumentException.class,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
            .put(indexBuilder("hidden-closed", Settings.builder().put("index.hidden", true).build()).state(IndexMetadata.State.CLOSE));
    public void testDataStreamsWithClosedBackingIndicesAndWildcardExpressions() {
            )
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "bar", "baz")
            state,
            equalTo(newHashSet("testXXX", "testXYY", "testXXY"))
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
                randomBoolean(),
        {
    public void testIsPatternMatchingAllIndicesOnlyWildcard() throws Exception {
            expectThrows(
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), dataStream1);
        final String dottedHiddenAlias = ".hidden_alias";
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        }
                        .putAlias(AliasMetadata.builder(visibleAlias))
    private ClusterState systemIndexTestClusterState() {
        String[] strings = indexNameExpressionResolver.indexAliases(
        ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(context, "testZZZ");
        {
            assertEquals(1, results.length);
        );
        );
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias")));
                IndexNotFoundException.class,
    public void testDataStreamsWithRegularIndexAndAlias() {
        }
        results = indexNameExpressionResolver.concreteIndexNames(context, "h*");
                state,
        assertThat(
        IndexNotFoundException infe = expectThrows(
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
            assertEquals("index", indices[0].getName());
                "test-alias"
            assertEquals(1, indices.length);
        Settings settings = Settings.builder().build();
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "bar")
        boolean test0WriteIndex = randomBoolean();
    public void testConcreteIndicesIgnoreIndicesOneMissingIndexOtherFound() {
        );
        {
            assertEquals("test-index", indices[0]);
            Exception e = expectThrows(
        assertThat(results, emptyArray());
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        results = indexNameExpressionResolver.concreteIndexNames(context, "foobar2-closed");
 * The OpenSearch Contributors require contributions made to
        );
        assertThat(results, arrayContainingInAnyOrder("hidden", "hidden-closed"));
            options = IndicesOptions.fromOptions(false, true, false, true, false, true, false, false);
                assertThat(results, arrayContainingInAnyOrder("foo", "foobar"));
public class IndexNameExpressionResolverTests extends OpenSearchTestCase {
        assertEquals(2, results.length);
        return mdBuilder.build();
        assertEquals(2, results.length);
                    .put(index2, false)
                    }
        assertEquals("bar", results[0]);
        {
                    DataStream.getDefaultBackingIndexName(dataStreamName, 1),
                state,
        }
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*");
        assertEquals("foo", results[0]);
                return false;
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "my-*", "-my-visible*");
        assertEquals(2, indexNames.size());
            );
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
    }
                IndexNotFoundException.class,
            false
            IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
                "no write index is defined for alias [test-alias]."
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testXXX", "testZZZ")),
            deleteIndexRequest.indicesOptions(IndicesOptions.fromOptions(randomBoolean(), false, true, true, false, false, true, false));
                indexBuilder("test-0").state(State.OPEN)
        );
    public void testIndexOptionsFailClosedIndicesAndAliases() {
        for (IndicesOptions options : indicesOptions) {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
    public void testFilteringAliases() {
    /**
import org.opensearch.indices.IndexClosedException;
                );
import org.opensearch.cluster.metadata.IndexMetadata.State;
            .put(indexBuilder("testXXX").state(State.OPEN))
        {
                "test-alias"
            .put(indexBuilder("test-1").state(State.OPEN).putAlias(AliasMetadata.builder("alias-1")));
        return new IndexNameExpressionResolver(threadContext);
                .put(indexBuilder(visibleIndex).state(State.OPEN).putAlias(AliasMetadata.builder(hiddenAlias).isHidden(true)))
            new HashSet<>(Arrays.asList("test-0", "test-alias"))
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
import static org.hamcrest.Matchers.is;
        }
    }
            .put(indexBuilder("test-1").state(IndexMetadata.State.CLOSE).putAlias(AliasMetadata.builder("alias-1")));
            state,
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
    }
        assertEquals("foo_foo", indexNamesIndexWildcard[0]);
    }
            assertThat(e.getMessage(), equalTo("no such index [null]"));
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                        new DataStream(dataStream1, createTimestampField("@timestamp"), Arrays.asList(index1.getIndex(), index2.getIndex()))
        }
            true,
            .put(indexBuilder("index_closed").state(IndexMetadata.State.CLOSE))
                assertThat(results, emptyArray());
            assertEquals("test-index", indices[0]);
        assertEquals("hidden", results[0]);
                IllegalArgumentException.class,
            IllegalArgumentException.class,
        assertEquals(
            "index_closed",
            .put(
            );
            state,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertEquals(2, results.length);
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo");
            .put(indexBuilder("hidden", Settings.builder().put("index.hidden", true).build()))
            assertEquals(2, results.length);
            // Unless hidden is specified in the options
            );
            .build();
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
            equalTo(
        IndexNameExpressionResolver.Context context2 = new IndexNameExpressionResolver.Context(state, options, false);
            false
            x -> true,
            assertThat(result[3].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 2)));
                IndexNotFoundException.class,
        IndexNotFoundException infe = expectThrows(IndexNotFoundException.class, () -> concreteResolvedIndices.concreteIndices());
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
            false
        String[] indicesOrAliases = new String[] { "index*" };
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        String[] indexNames;
        }
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo", "foobar");
        String[] indexNames = indexNameExpressionResolver.concreteIndexNames(state, IndicesOptions.lenientExpandOpen(), "-doesnotexist");
                    .putAlias(AliasMetadata.builder("test-alias2"))
    public void testIndexOptionsLenient() {
                        new DataStream(dataStream2, createTimestampField("@timestamp"), Arrays.asList(index3.getIndex(), index4.getIndex()))
        assertThat(concreteResolvedIndices.namesOfConcreteIndices(), containsInAnyOrder("index_b1", "index_b2"));
            concreteResolvedIndices.resolutionErrors().stream().map(Throwable::getMessage).toList(),
    }
                    EnumSet.of(IndicesOptions.WildcardStates.OPEN, IndicesOptions.WildcardStates.CLOSED)
        final String hiddenIndex = "my-hidden-index";
        );
        try {
        assertThat(results, emptyArray());
            .put(additionalSettings);
        {
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar", "hidden", ".hidden"));
                true,
            {
        assertEquals("hidden-closed", results[0]);
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, hiddenAlias);
        );
        assertThat(Arrays.asList(indexNames), empty());
        ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(
        assertThat(
            false
        {
        };
        );
        assertEquals(2, results.length);
            IndicesOptions.strictExpandOpen(),
            false
        assertThat(concreteResolvedIndices.names(), containsInAnyOrder("alias_a", "index_b1", "index_b2", "index_d"));
        context = new IndexNameExpressionResolver.Context(state, options, false);
        {
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
            }
        {
        assertWarnings(
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
            .put(indexBuilder("foo").state(IndexMetadata.State.CLOSE))
        assertThat(Arrays.asList(indexNames), empty());
}
            // A total wildcards does not resolve the hidden index in this case
    }
        Metadata.Builder mdBuilder = Metadata.builder()
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
            .put(
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*_alias");
            Exception e = expectThrows(
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
        {
        Metadata.Builder mdBuilder = Metadata.builder()
                // unavailable indices are not ignored, hence the error on the first unavailable indices encountered
                IndexClosedException.class,
                contextICE.getOptions().expandWildcardsOpen(),
            // Ignore data streams
            .put(indexBuilder("foo3").putAlias(AliasMetadata.builder("foobar2-closed")));
        assertThat(IndexNameExpressionResolver.isAllIndices(null), equalTo(true));
        {
            assertEquals("no such index [" + dataStreamName + "]", iae.getMessage());
        SearchRequest request = new SearchRequest(randomFrom("*", "_all"));
            assertThat(results, arrayContainingInAnyOrder("foo", "foobar"));
            .put(indexBuilder(".hidden", Settings.builder().put("index.hidden", true).build()))
            state,
        assertThat(
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
                EnumSet.of(IndicesOptions.WildcardStates.OPEN)
        assertEquals(1, indexNamesIndexWildcard.length);
        InvalidIndexNameException iine = expectThrows(
        {
                indexNameExpressionResolver.concreteIndexNames(
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
        context = new IndexNameExpressionResolver.Context(state, options, false);
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        assertEquals(2, indexNames.size());
            assertEquals(1, indices.length);
            @Override
            }
            public IndicesOptions indicesOptions() {
                case 1:
        Index writeIndex = indexNameExpressionResolver.concreteWriteIndex(state, request);
            IndexNotFoundException.class,
            IndexNotFoundException.class,
            assertEquals(2, results.length);
        } catch (IllegalArgumentException iae) {
            IndicesOptions.strictExpandOpenAndForbidClosed() };
        results = indexNameExpressionResolver.concreteIndexNames(context2, Strings.EMPTY_ARRAY);
                false
            state,
import static org.hamcrest.Matchers.empty;
            @Override
        assertEquals(1, indexNamesIndexWildcard.length);
            .put(indexBuilder("test-index").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias")))
            }
        }
            .put(indexBuilder("testXYY").state(State.OPEN))
            context,
                state,
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo", "foobar");
                    .put(index1, false)
            () -> indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "foo")
        results = indexNameExpressionResolver.concreteIndexNames(context, "foobar2-closed");
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*");
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(true));
            assertThat(e.getMessage(), containsString("alias [foofoobar] has more than one index associated with it"));
            results = indexNameExpressionResolver.concreteIndexNames(context, "barbaz", "bar");
                IllegalArgumentException.class,
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
                    EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES, IndicesOptions.Option.IGNORE_THROTTLED),
    }
                    throw new UnsupportedOperationException();
            new OriginalIndices(new String[] { "index_b*", "index_d" }, IndicesOptions.lenientExpandOpen()),
                "test-index"
        assertEquals(0, indexNames.length);
            assertEquals(1, indices.length);
            assertEquals("no such index [does_not_exist]", infe.getMessage());
                indicesOptions,
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, noExpandDisallowEmpty, false);
            () -> indexNameExpressionResolver.concreteWriteIndex(state, request.indicesOptions(), request.indices()[0], false, false)
        context = new IndexNameExpressionResolver.Context(state, options, false);
        // - Of course, the concrete indices will contain all existing indices that are matched.
        );
        indexNamesIndexWildcard = indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "f*o");
            newHashSet(indexNameExpressionResolver.concreteIndexNames(state, IndicesOptions.lenientExpandOpen(), "-*")),
            state,
            resolvedExpressions
                    + " indices without one being designated as a write index"
            state,
                false
        String[] strings = indexNameExpressionResolver.concreteIndexNames(context, "alias-*");
                }
        }
            new UpdateRequest("test-alias", "_id"),
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("foofoobar")))
import java.util.function.Function;
            .put(indexBuilder("index_c1"));
                randomBoolean(),
        String[] strings = indexNameExpressionResolver.indexAliases(
        );
        assertThat(
        );
            state,
            equalTo(
                IndexNotFoundException.class,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            assertEquals("test-index", indices[0]);
        assertEquals(1, results.length);
        );
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
        IndexMetadata justAnIndex = IndexMetadata.builder("logs-foobarbaz-0")
                    }
            );
import org.opensearch.action.search.SearchRequest;
            );
        );
            assertEquals(2, results.length);
        boolean testZeroWriteIndex = randomBoolean();
            assertThat(e.getMessage(), equalTo("no such index [my-data-stream]"));
        );
        Metadata metadata = metadataBuilder(concreteIndices);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            IndicesOptions.strictExpandOpen(),
        assertEquals("bar", results[0]);
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")),
        for (IndicesOptions options : indicesOptions) {
            equalTo(newHashSet("testXXX"))
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(threadContext, customResolvers);
 * under the License.
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
        threadContext.putHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY, Boolean.FALSE.toString());
        );
        assertEquals(1, results.length);
                    expectThrows(IndexNotFoundException.class, () -> indexNameExpressionResolver.concreteIndexNames(context, allIndices));
        String[] strings = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, true, resolvedExpressions);
                .put(indexBuilder("bbb").state(State.OPEN).putAlias(AliasMetadata.builder("bbb_alias1")))
        assertNull(strings);
        assertEquals("Invalid index name [_foo], must not start with '_'.", iine.getMessage());
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "my-hidden*");
            assertEquals(
                case 2:
        final String hiddenIndex = "hidden_index";
        assertEquals(1, results.length);
        );
        );
            assertEquals("foo", results[0]);
        );
        IndicesOptions[] indicesOptions = new IndicesOptions[] { IndicesOptions.strictExpandOpen(), IndicesOptions.strictExpand() };
        Metadata metadata = metadataBuilder(allConcreteIndices);
            }
            .put(indexBuilder(".hidden-closed", Settings.builder().put("index.hidden", true).build()).state(IndexMetadata.State.CLOSE))
            assertThat(
    }
 * SPDX-License-Identifier: Apache-2.0
        results = indexNameExpressionResolver.concreteIndexNames(context, ".hidd*");
            equalTo(newHashSet("testXXX", "testXXY", "testXYY"))
        assertThat(results, arrayContainingInAnyOrder(".hidden", ".hidden-closed"));
        assertEquals(2, results.length);
        assertThat(results, arrayContainingInAnyOrder(".hidden-closed"));
        IndexNotFoundException indexNotFoundException = expectThrows(
                IndexNotFoundException.class,
                );
    /**
            assertEquals("index", indices[0].getName());
                    )
        assertThat(results, emptyArray());
        assertThat(
        IndexMetadata index1 = createBackingIndex(dataStream1, 1).build();
            () -> indexNameExpressionResolver.concreteIndexNames(context2, "-*")
        try {
        return ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        IndicesOptions[] indicesOptions = new IndicesOptions[] {
        assertThat(indexNames, containsInAnyOrder(".ml-meta", ".ml-stuff"));
            .put(indexBuilder("foobar"))
            .put(index4, false)
        IndexMetadata index2 = createBackingIndex(dataStream1, 2).build();
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "bar")
        }
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "other*");
            IndexNotFoundException infe = expectThrows(
        assertArrayEquals(new String[] { "test-alias" }, strings);
        }
    }
            "this request accesses system indices: [.ml-stuff], but in a future major version, direct access "
            assertEquals("index", indices[0].getName());
            Exception e = expectThrows(
            );
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, "logs-*");
            {
    public void testInvalidIndex() {
import org.opensearch.index.IndexNotFoundException;
                "The provided expression [test-alias] matches an alias, " + "specify the corresponding concrete indices instead.",
        assertEquals(1, results.length);
                // with no indices, asking for all indices should return empty list or exception, depending on indices options
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("test-*"));
        List<String> names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "log*");
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
    public void testIndexOptionsNoExpandWildcards() {
        assertEquals(1, results.length);
 * KIND, either express or implied.  See the License for the
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "notmatched");
            .put(indexBuilder("bar"))
        assertEquals(5, results.length);
            );
    private ThreadContext createThreadContext() {
    }
    public void testSingleSystemIndexResolutionAllowed() {
        Metadata.Builder mdBuilder = Metadata.builder()
        );
        };
            assertEquals(1, results.length);
        ClusterState state = systemIndexTestClusterState();
        assertThat(results, emptyArray());
        assertThat(infe.getMessage(), is("no such index [testZZZ]"));
        results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo*");
    public void testDeleteIndexIgnoresAliases() {
            .put(indexBuilder("testXYY").state(State.CLOSE))
        }
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar", "foo"));
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
                "test-index"
        final String dataStreamName = "my-data-stream";
    public void testConcreteResolvedIndicesWithErrors() {
            "test-0",
        results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo*");
        results = indexNameExpressionResolver.concreteIndexNames(context, (String[]) null);
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("test-alias");
        }
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, expandOpen, false);
            .put(indexBuilder("foo").putAlias(AliasMetadata.builder("foofoobar")))
            .put(index3, false)
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            Metadata.Builder mdBuilder = Metadata.builder()
        assertThat(exception.getMessage(), equalTo("indices request must specify a single index expression"));
            IndexNotFoundException infe = expectThrows(
        assertEquals(7, results.length);
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, false, true), false);
                () -> indexNameExpressionResolver.concreteWriteIndex(state, indicesOptions, "my-data-stream", true, false)
        assertThat(results, arrayContainingInAnyOrder("foo", "foofoo"));
            .settings(OpenSearchTestCase.settings(Version.CURRENT))
            assertThat(result[2].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 1)));
            state,
            equalTo(newHashSet("testXXX", "testXXY", "testXYY"))
        DocWriteRequest request = randomFrom(
            IndexNotFoundException.class,
        {
            assertEquals(new HashSet<>(Arrays.asList("foo", "foobar")), new HashSet<>(Arrays.asList(results)));
                    .put(index4, false)
            assertEquals("no such index [" + dataStreamName + "]", iae.getMessage());
        // - resolved index patterns
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("index1").putAlias(AliasMetadata.builder("alias1")));
    }
                indexBuilder("test-1").state(State.OPEN)
            assertEquals(1, indices.length);
                indexBuilder("test-1").state(State.OPEN)
            assertEquals(infe.getIndex().getName(), "test-a*");
            assertEquals(1, indices.length);
        // only hidden
        assertEquals(3, results.length);
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden-closed");
            assertThat(result.length, equalTo(4));
            {
    }
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.remove().index("test-alias");
            .put(indexBuilder("index").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias2")));
                    .putAlias(AliasMetadata.builder("test-alias"))
                );
        @Override
            assertEquals(ince.getIndex().getName(), "foofoo-closed");
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index(dataStreamName);
                IllegalArgumentException.class,
        assertEquals(1, results.length);
        Metadata.Builder mdBuilder = Metadata.builder()
                    assertThat(concreteIndices.length, equalTo(0));
        }
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "baz*");
        assertEquals(1, results.length);
            {
        assertThat(results, emptyArray());
     * Same as testConcreteIndicesIgnoreIndicesOneMissingIndex() but using the concreteResolvedIndices() method.
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, ".hidden_a*");
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        Metadata.Builder mdBuilder = Metadata.builder()
            );
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        // when ignoreAliases is set, and an alias is specified in the index expression without using a wildcard,
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foofoobar")
     * This should keep the name of the missing index and defer the throwing of the exception to the point
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(true));
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(Metadata.builder().build()).build();
        IllegalArgumentException exception = expectThrows(
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(hiddenIndex));
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "*", "-*");
            .settings(OpenSearchTestCase.settings(Version.CURRENT))
    public void testInvalidEmptyIndex() {
    }
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
                assertThat(infe.getIndex().getName(), equalTo("bar"));
                    allIndices = null;
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
        context = new IndexNameExpressionResolver.Context(state, options, false);
        assertEquals(
            assertEquals(0, indices.length);
    }
        IndicesOptions indicesOptions = IndicesOptions.strictExpandOpenAndForbidClosedIgnoreThrottled();
        assertThat(
            );
            assertThat(results, emptyArray());
            .put(
        }
                IndexNotFoundException infe = expectThrows(
        assertEquals(3, results.length);
                .put(indexBuilder(visibleIndex).state(State.OPEN).putAlias(AliasMetadata.builder(visibleAlias)))
        final String dataStream1 = "logs-mysql";
        Metadata metadata = metadataBuilder(concreteIndices);
            () -> indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "my_alias*", "-my_alias")
            IndexNotFoundException infe2 = expectThrows(
                assertThat(infe.getIndex().getName(), equalTo("baz*"));
import static org.opensearch.cluster.metadata.IndexNameExpressionResolver.SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY;
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
        List<String> indexNames = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(state, indicesAndAliasesOptions, "foo*"));
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias").writeIndex(randomFrom(false, null))))
        assertThat(concreteResolvedIndices.names(), containsInAnyOrder("index_closed", "index_c1", "baz*", "alias_b", "alias_a"));
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpand(), false);
        {
 * Modifications Copyright OpenSearch Contributors. See
            }
        assertThat(result[2].getName(), equalTo("logs-foobarbaz-0"));
            assertEquals(1, results.length);
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))
        assertThat(results, arrayContainingInAnyOrder("bar", "hidden", "hidden-closed", ".hidden", ".hidden-closed"));
    }
            .put(index3, false)
    public void testIsAllIndicesExplicitAllPlusOther() throws Exception {
        }
        assertEquals(3, results.length);
            .build();
        {
        // error on unavailable but allow no indices
        String[] strings = indexNameExpressionResolver.indexAliases(
            }
        {
/*
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
            equalTo(newHashSet("testYYX", "testXXX", "testXYY", "testYYY", "testXXY"))
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, indicesOptions, false);
            assertEquals(1, indices.length);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            public String[] indices() {
            IndicesOptions.lenientExpandOpen(),
        Metadata.Builder mdBuilder = Metadata.builder()
 * this work for additional information regarding copyright
        assertEquals(3, results.length);
            assertEquals("test-index", indices[0]);
            equalTo(newHashSet("testYYX", "testXYY", "testYYY", "testXXY"))
import java.util.Arrays;
        IndexMetadata index2 = createBackingIndex(dataStreamName, 2).build();
                    "testXYY",
            );
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")),
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(true));
            {
            false
        }
                () -> indexNameExpressionResolver.concreteWriteIndex(state, indicesOptions, "my-data-stream", false, false)
        // - names of existing indices
        );
        {
    }
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
            assertThat(result.length, equalTo(0));
                state,
        assertEquals("bar", results[0]);
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpandOpenAndForbidClosed(), false);
        assertEquals(1, results.length);
            "this request accesses system indices: [.ml-meta], but in a future major version, direct access "
        assertThat(results, arrayContainingInAnyOrder("foo", "foobar", "foofoo", "foofoo-closed"));
            .put(new DataStream(dataStream1, createTimestampField("@timestamp"), List.of(index1.getIndex(), index2.getIndex())))
        {
                () -> indexNameExpressionResolver.concreteIndices(state, indicesOptions, false, "my-data-stream")
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_HIDDEN_SETTING;
            state,
        Arrays.sort(strings);
        assertThat(results, emptyArray());
        assertThat(results, emptyArray());
import org.opensearch.action.delete.DeleteRequest;
    public void testIsPatternMatchingAllIndicesNonMatchingSingleExclusion() throws Exception {
            state,
                Arrays.stream(result).map(Index::getName).collect(Collectors.toList()),
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "logs-*");
                .index(dataStreamName)
        );
    public void testIsExplicitAllIndicesNormalIndexes() throws Exception {
            false
    }
        threadContext.putHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY, Boolean.FALSE.toString());
            );
            );
        }
        state = ClusterState.builder(state)
        Metadata.Builder mdBuilder = Metadata.builder()
            }
        {
            results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
    public void testIsExplicitAllIndicesExplicitAllPlusOther() throws Exception {
                .put(indexBuilder("ccc").state(State.CLOSE).putAlias(AliasMetadata.builder("ccc_alias1")));
                    if (indicesOptions.expandWildcardsOpen()) {
                IndexNotFoundException infe = expectThrows(
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, ".hidden_a*");
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
        }
    public void testIsPatternMatchingAllIndicesMatchingSingleExclusion() throws Exception {
            state,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpand(), false);
            .numberOfReplicas(1)
            );
                IndexNotFoundException.class,
            "alias_a",
            Index[] indices = indexNameExpressionResolver.concreteIndices(
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
            {
    public void testIsExplicitAllIndicesEmpty() throws Exception {
            assertEquals(
                    .put(
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        );
                true,
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*");
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, hiddenAlias);
            "index_c1"
 */
                EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES),
                if (indicesOptions.expandWildcardsOpen() || indicesOptions.expandWildcardsClosed() || indicesOptions.allowNoIndices()) {
        {
    }
        assertArrayEquals(new String[] { "test-alias" }, strings);
        assertEquals(
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*");
        assertThat(
            );
        Metadata.Builder mdBuilder = Metadata.builder()
            IndicesOptions.strictExpandOpen(),
            .put(indexBuilder("-testYYY").state(State.OPEN))
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
                randomBoolean()
            IndicesOptions.fromOptions(false, false, true, true),
            );
        assertEquals(3, results.length);
    }
        }
    }
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                state,
            false
        options = IndicesOptions.fromOptions(false, true, true, true, false);
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
            mdBuilder.put(indexBuilder(concreteIndex));
                return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
            assertEquals(2, results.length);
        );
            IndicesOptions indicesOptions = new IndicesOptions(
        IndexMetadata index2 = createBackingIndex(dataStream1, 2).build();
    static class FakeExpressionResolver implements IndexNameExpressionResolver.ExpressionResolver {
        assertNull(aliases);
            new DeleteRequest("test-alias")
                () -> indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*_alias")
                false
            // Ignore data streams and allow no indices
        assertEquals("foo", results[0]);
                () -> indexNameExpressionResolver.concreteIndexNames(state, deleteIndexRequest)
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(index1.getIndex(), index2.getIndex()), 2));
    }
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(dottedHiddenIndex, hiddenIndex));
        String[] aliases = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, false, resolvedExpressions);
            ),
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
            assertThat(result.length, equalTo(2));
        );
            .put(index2, false)
        IndicesOptions indicesAndAliasesOptions = IndicesOptions.fromOptions(false, false, true, false, true, false, false, false);
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
            state,
                    break;
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        String[] indicesOrAliases = new String[] { "index*" };
        assertArrayEquals(new String[] { "test-alias" }, aliases);
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "barbaz");
            "index_c*",
    }
        );
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("foofoobar")))
        context = new IndexNameExpressionResolver.Context(state, expand, false);
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED,
            assertEquals(1, indices.length);
            );
                indexBuilder("foo1-closed").state(IndexMetadata.State.CLOSE)
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
        IndicesOptions excludeHiddenOptions = IndicesOptions.fromOptions(false, false, true, false, false, true, false, false, false);
     * when ResolvedIndices.Local.Concrete.concreteIndices() is called.
                    "testXXY",
            assertThat(infe.getIndex().getName(), equalTo("foo"));
                .put(
            assertThat(result[3].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 2)));
        return new ThreadContext(Settings.EMPTY);
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
        ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(
            {
                false
        context = new IndexNameExpressionResolver.Context(state, options, false);
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
                assertThat(infe.getIndex().getName(), equalTo("bar"));
        final String dataStream1 = "logs-foobar";
            .put(
                .put(
            );
        );
            "baz*",
            () -> indexNameExpressionResolver.concreteIndexNames(context, "")
    }
        }
        assertArrayEquals(null, strings);
            );
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
        assertEquals(1, results.length);
import org.opensearch.core.index.Index;
        results = indexNameExpressionResolver.concreteIndexNames(context, "h*");
            );
        // Open and closed
            IllegalArgumentException.class,
                    .putAlias(AliasMetadata.builder("test-alias-non-filtering"))
                    IndexNotFoundException.class,
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.action.index.IndexRequest;
                assertThat(concreteIndices.length, equalTo(0));
    protected IndexNameExpressionResolver createIndexNameExpressionResolver(ThreadContext threadContext) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                IndexNotFoundException.class,
        assertThat(names, empty());
        aliases = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, true, resolvedExpressions);
    }
        {
        assertArrayEquals(new String[] { "test-alias" }, strings);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            )
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
        );
            {
        final String dataStream1 = "logs-foobar";
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
                    "testXXX",
    }
                containsInAnyOrder(
        // ignore unavailable but don't allow no indices
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
        assertEquals(2, indexNames.size());
    public void testIsExplicitAllIndicesExplicitAll() throws Exception {
                false
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*")
            () -> indexNameExpressionResolver.concreteIndexNames(context, "testZZZ")
            IndicesOptions.fromOptions(
            );
        assertEquals(1, results.length);
            assertEquals("does_not_exist", infe.getIndex().getName());
            );
        // testing an alias pointing to three indices:
            assertThat(results, arrayContainingInAnyOrder("foo", "foobar"));
        IndicesOptions includeHiddenOptions = IndicesOptions.fromOptions(false, true, true, false, true, true, false, false, false);
    }
import java.util.stream.Collectors;
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
    public void testConcreteIndicesWildcardAndAliases() {
        );
        final String dataStream2 = "logs-redis";
        assertEquals("foo", results[0]);
                    EnumSet.of(IndicesOptions.WildcardStates.OPEN)
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Collections.<String>emptyList()), equalTo(false));
            IndicesOptions.fromOptions(true, true, true, true),
                        .putAlias(AliasMetadata.builder(dottedHiddenAlias).isHidden(true))
                    .put(indexBuilder("aaa").state(State.OPEN).putAlias(AliasMetadata.builder("aaa_alias1")))
    public void testConcreteIndicesWildcardExpansion() {
            .put(index1, false)
        results = indexNameExpressionResolver.concreteIndexNames(context, ".*");
            iae.getMessage()
        }
        ClusterState state = systemIndexTestClusterState();
            assertEquals(1, results.length);
    }
            false
            );
        );
     */
        String[] strings = indexNameExpressionResolver.indexAliases(
        }
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "baz*")
        );
            equalTo(newHashSet("-testXYZ", "-testXZZ", "-testYYY"))
        assertTrue(indexNames.contains("bar_bar"));
        assertEquals(1, results.length);
            public IndicesOptions indicesOptions() {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver.ExpressionResolver;
        }
            false
        );
        assertEquals(1, indexNamesIndexWildcard.length);
            IllegalArgumentException iae = expectThrows(
            // expected
                );
                EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES, IndicesOptions.Option.IGNORE_UNAVAILABLE),
        assertThat(
        assertThat(results, arrayContainingInAnyOrder("foo", "foobar", "foofoo"));
                context.getOptions()
            }
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            ),
                + "to system indices will be prevented by default"
        assertThat(Arrays.asList(indexNames), empty());
        assertTrue(indexNames.contains("bar_bar"));
        // concrete index supersedes filtering alias
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
    public void testDataStreamsNames() {
                        )
                IndexNotFoundException infe = expectThrows(
    }
            );
        {
                return false;
    public void testIndexAliases() {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("test-a*");
        );
            .put(indexBuilder("my_index").state(State.OPEN).putAlias(AliasMetadata.builder("my_alias")));
            assertEquals(
        indexNames = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(state, indicesAndAliasesOptions, "*o"));
    public void testDataStreamsWithWildcardExpression() {
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testYYY", "testYYX", "testX*", "-testXXX")),
    public void testIndexAliasesSkipIdentity() {
        results = indexNameExpressionResolver.concreteIndexNames(context, "foobar1-closed");
        assertThat(results, arrayContainingInAnyOrder("hidden-closed"));
        results = indexNameExpressionResolver.concreteIndexNames(context, "h*");
            // Ignore data streams
                EnumSet.noneOf(IndicesOptions.Option.class),
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
                    int expectedNumberOfIndices = 0;
        Metadata.Builder mdBuilder = Metadata.builder()
            Metadata.Builder mdBuilder = Metadata.builder()
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo")
        {
        results = indexNameExpressionResolver.concreteIndexNames(context, ".hidd*");
        final String dottedHiddenIndex = ".hidden_index";
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(false));
            .put(indexBuilder("testXXY").state(State.OPEN))
            x -> true,
            () -> indexNameExpressionResolver.concreteWriteIndex(state, requestGen.apply(null))
            .put(indexBuilder("testXXY").state(State.OPEN))
        Metadata metadata = metadataBuilder(concreteIndices);
                indexBuilder("test-0").state(State.OPEN)
            Metadata.Builder mdBuilder = Metadata.builder()
                "The provided expression [test-alias] matches an alias, " + "specify the corresponding concrete indices instead.",
        }
                return IndicesOptions.strictExpandOpenAndForbidClosed();
        // an exception is expected.
            assertEquals(0, results.length);
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 2)));
        indexNames = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(state, indicesAndAliasesOptions, "foo"));
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testXXY", "-testX*")),
        }
        IndexMetadata index3 = createBackingIndex(dataStream2, 1).build();
        Arrays.sort(result, Comparator.comparing(Index::getName));
        );
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        assertEquals(Collections.singletonList(dataStream1), names);
        assertThat(results, arrayWithSize(1));
        final String dataStream2 = "logs-redis";
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, noExpandLenient, false);
    private static IndexMetadata.Builder indexBuilder(String index, Settings additionalSettings) {
    }
    }
                .put(
                IndexNotFoundException infe = expectThrows(
                    IndexNotFoundException.class,
        resolvedExpressions = new HashSet<>(Arrays.asList("test-0", "test-1", "alias-0", "alias-1"));
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, false, "my-data-stream");
 * compatible open source license.
            assertEquals("foo", results[0]);
        }
        IndicesOptions excludeHiddenOptions = IndicesOptions.fromOptions(false, true, true, false, false, true, false, false, false);
        public List<String> resolve(IndexNameExpressionResolver.Context context, List<String> expressions) {
            .put(indexBuilder("some-other-index").state(State.OPEN));
        }
            Arrays.sort(result, Comparator.comparing(Index::getName));
            assertEquals(
        assertThat(IndexNameExpressionResolver.isAllIndices(Arrays.asList("_all")), equalTo(true));
            assertThat(results, arrayContainingInAnyOrder("foo"));
            .put(indexBuilder("bar_bar").state(State.OPEN).putAlias(AliasMetadata.builder("foo")));
    }
        );
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        assertTrue(indexNames.contains("bar_bar"));
            () -> indexNameExpressionResolver.concreteWriteIndex(state, requestGen.apply(new String[] { "too", "many" }))
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
            assertEquals(2, results.length);
            // A query that doesn't include the dot should fail if the options don't include hidden
        {
        Metadata.Builder mdBuilder = Metadata.builder()
    public void testIndexOptionsWildcardExpansion() {
        assertThat(results, emptyArray());
                new IndicesOptions(
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("test-a*"));
            public boolean includeDataStreams() {
    public void testIndexOptionsAllowUnavailableDisallowEmpty() {
            Arrays.sort(result, Comparator.comparing(Index::getName));
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, visibleAlias);
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("test-index");
        }
        );
                assertThat(infe.getIndex().getName(), equalTo("bar"));
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*");
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("foofoobar")))
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
        final IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
        assertThat(newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")), equalTo(newHashSet("testXYY")));
            .build();
    public void testIndexOptionsSingleIndexNoExpandWildcards() {
                    .put(index3, false)
            assertThat(concreteResolvedIndices.resolutionErrors().getFirst().getMessage(), equalTo("no such index [my-data-stream]"));
        }
        );
            }
                    .put(index2, false)
    public void testConcreteWriteIndexWithWildcardExpansion() {
            );
            assertEquals(1, indices.length);
                IllegalArgumentException.class,
            // unless it's specified in the options
        // no wildcards, so wildcard expansion don't apply
            .metadata(
                indexBuilder("test-0").state(State.OPEN)
        strings = indexNameExpressionResolver.filteringAliases(state, "test-0", resolvedExpressions);
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        strings = indexNameExpressionResolver.indexAliases(
                IndexNotFoundException.class,
                indicesOptions,
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
                "test-index"
        results = indexNameExpressionResolver.concreteIndexNames(context, ".*");
    private static IndexMetadata.Builder indexBuilder(String index) {
        IndexMetadata index1 = createBackingIndex(dataStream1, 1).build();
                );
            assertThat(results, emptyArray());
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
        IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
            IndicesOptions noExpandDisallowEmpty = IndicesOptions.fromOptions(true, false, false, false, randomBoolean());
        assertArrayEquals(new String[] { "test-0" }, strings);
            }
            state,
            () -> indexNameExpressionResolver.concreteWriteIndex(state, request)
import static org.hamcrest.Matchers.notNullValue;
            .numberOfShards(1)
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
            }
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("test-*");
        Metadata.Builder mdBuilder = Metadata.builder();
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo");
        options = IndicesOptions.fromOptions(false, true, false, true, false, false, false, false);
                contextICE.getOptions()
    public void testIsExplicitAllIndicesWildcard() throws Exception {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
            public IndicesOptions indicesOptions() {
        SearchRequest request = new SearchRequest(".ml-meta");
                // with existing indices, asking for all indices should return all open/closed indices depending on options
        IndicesOptions expandOpen = IndicesOptions.fromOptions(true, false, true, false);
    /**
            indexNameExpressionResolver.resolveExpressions(state, "test-0", "alias-*")
            ;
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "-testXXX", "test*")),
                    + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
        assertThat(results, arrayWithSize(3));
        }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertThat(results, arrayWithSize(1));
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
        );
                randomFrom(new String[] { "*" }, new String[] { "_all" }, new String[0])
        assertThat(writeIndex.getName(), equalTo("test-0"));
            () -> indexNameExpressionResolver.concreteIndices(context, new String[] {})
        IndexMetadata index4 = createBackingIndex(dataStream2, 2).build();
    public void testIsAllIndicesNull() throws Exception {
        IndicesRequest request = new IndicesRequest() {
                        new DataStream(dataStream1, createTimestampField("@timestamp"), Arrays.asList(index1.getIndex(), index2.getIndex()))
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
                Metadata.builder(state.metadata())
            // A visible alias that points to one hidden and one visible index
            String[] indexNames;
            IndexNotFoundException.class,
            assertEquals(0, indices.length);
            .put(index4, false)
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "logs-m*");
            .put(indexBuilder("index_a1").putAlias(AliasMetadata.builder("alias_a")))
            );
        {
            assertThat(results, arrayContainingInAnyOrder("foofoo", "foobar"));
            .put(indexBuilder("test-1").state(State.OPEN).putAlias(AliasMetadata.builder("alias-1")));
            );
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        } catch (IndexClosedException e) {
    public void testConcreteWriteIndexSuccessful() {
        assertArrayEquals(new String[] { "test-alias" }, strings);
            .put(indexBuilder("foo").putAlias(AliasMetadata.builder("foofoobar")))
        final String hiddenAlias = "my-hidden-alias";
import java.util.EnumSet;
            .build();
        );
            );
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(null), equalTo(false));
            "The provided expression [foo] matches an alias, specify the corresponding concrete indices instead.",
        return Arrays.stream(indexNameExpressionResolver.concreteIndices(state, request))
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, concreteIndices, concreteIndices), equalTo(false));
            x -> true,
        Metadata.Builder mdBuilder = Metadata.builder()
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(dottedHiddenIndex, hiddenIndex));
        }
        }
        assertEquals("bar", results[0]);
            false
            assertEquals(1, results.length);
                return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
        assertNull(strings);
                () -> indexNameExpressionResolver.concreteIndices(state, indicesOptions, false, "my-data-stream")
        assertEquals(4, results.length);
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*_alias");
            );
 *
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN; // without include data streams
        assertThat(indexNames, containsInAnyOrder(".ml-meta"));
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        );
    }
                    assertThat(concreteIndices, notNullValue());
                    String[] concreteIndices = indexNameExpressionResolver.concreteIndexNames(context, allIndices);
        assertEquals("foo_foo", indexNamesIndexWildcard[0]);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
            .put(new DataStream(dataStream2, createTimestampField("@timestamp"), List.of(index3.getIndex(), index4.getIndex())));
                state,
 *
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*");
    public void testIsPatternMatchingAllIndicesNonMatchingTrailingWildcard() throws Exception {
            .build();
            IndicesOptions.strictExpand(),
            state,
            .put(
        assertWarnings(
        String[] strings = indexNameExpressionResolver.indexAliases(
        assertThat(writeIndex.getName(), equalTo(testZeroWriteIndex ? "test-0" : "test-1"));
    }
        // - For the names() property we include:
            state,
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
            assertEquals("foo", results[0]);
        assertThat(indexNames, containsInAnyOrder("some-other-index", ".ml-stuff", ".ml-meta"));
        }
        assertEquals(0, indexNames.length);
            .put(
            newHashSet(
        assertEquals(4, results.length);
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar"));
        assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
        ClusterState state = systemIndexTestClusterState();
            IndexNotFoundException.class,
            state,
            // If we specify a hidden alias by name, the options shouldn't matter.
        }
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        assertThat(
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                    allIndices = new String[] { Metadata.ALL };
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
                .put(indexBuilder("aaa").state(State.OPEN).putAlias(AliasMetadata.builder("aaa_alias1")))
                .alias("my-data");
        }
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        );
        indexNames = Arrays.asList(indexNameExpressionResolver.concreteIndexNames(state, indicesAndAliasesOptions, "f*o"));
                () -> indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("does_not_exist"))
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
        assertEquals(concreteResolvedIndices.names(), Set.of("testZZZ"));
            public String[] indices() {
            assertEquals("index-closed", indices[1].getName());
            @Override
    }
            // Ignore data streams, allow no indices and ignore unavailable
        {
            {
            // unless, again, it's specified in the options
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.remove().index("test-*");
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "*foobar");
        final String visibleAlias = "my-visible-alias";
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        IndexMetadata index1 = createBackingIndex(dataStreamName, 1).build();
            state,
                default:
        IllegalArgumentException exception = expectThrows(
                EnumSet.of(IndicesOptions.WildcardStates.OPEN)
                        indexBuilder("test-1").putAlias(
        // Only closed
            true,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                IndexNotFoundException.class,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
    public void testFilterClosedIndicesOnAliases() {
        // closed and hidden
            .collect(Collectors.toList());
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testXXX", "testXXY", "testYYY", "-testYYY")),
                case 0:
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo*");
        IndexMetadata index1 = createBackingIndex(dataStream1, 1).state(State.CLOSE).build();
        results = indexNameExpressionResolver.concreteIndexNames(context, "foobar1-closed");
            false
        assertEquals(Collections.singletonList(dataStream1), names);
                "ind*",
            assertThat(infe.getIndex().getName(), equalTo("baz*"));
        {
                    .putAlias(AliasMetadata.builder("test-alias-0").filter("{ \"term\": \"foo\"}"))
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.remove().index("test-a*");
            Arrays.sort(result, Comparator.comparing(Index::getName));
        assertEquals(3, results.length);
 * not use this file except in compliance with the License.
        threadContext.putHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY, Boolean.FALSE.toString());
            // asking for non existing wildcard pattern should return empty list or exception
            assertEquals("no such index [my-data-*]", iae.getMessage());
    public void testIsAllIndicesEmpty() throws Exception {
            .put(indexBuilder("foo").putAlias(AliasMetadata.builder("foofoobar")))
                assertEquals(2, results.length);
        );
        );
        assertArrayEquals(new String[] { "other-alias" }, aliases);
            .numberOfShards(1)
        assertThat(
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "foofoobar")
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
            assertThat(results, emptyArray());
            results = indexNameExpressionResolver.concreteIndexNames(context, (String[]) null);
    public void testConcreteIndicesIgnoreIndicesOneMissingIndex() {
            assertEquals("index", indices[0].getName());
        assertThat(IndexNameExpressionResolver.isAllIndices(Arrays.asList("_all", "other")), equalTo(false));
            IndicesOptions.fromOptions(false, false, false, false),
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden");
            {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            "this request accesses system indices: [.ml-meta], but in a future major version, direct access "
            );
                IndexNotFoundException.class,
            }
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("test-index"));
            assertEquals("foo", results[0]);
            results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
                "*"
            // Ignore data streams, allow no indices and ignore unavailable
    }
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
    }
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 1)));
    }
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo*", "bar")
            IllegalArgumentException iae = expectThrows(
    }
            // Ignore data streams; use different overload
        assertArrayEquals(new String[] { "test-alias-0", "test-alias-1", "test-alias-non-filtering" }, strings);
            results = indexNameExpressionResolver.concreteIndexNames(context, "barbaz", "foobar");
            Index[] indices = indexNameExpressionResolver.concreteIndices(
            assertEquals(0, indices.length);
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("foofoobar")))
                        .putAlias(AliasMetadata.builder(hiddenAlias).isHidden(true))
            state,
        );
                Metadata.Builder mdBuilder = Metadata.builder()
            Index[] indices = indexNameExpressionResolver.concreteIndices(
        }
            );
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED,
            @Override
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        }
                .put(
            .put(indexBuilder("foo"))
                    .put(justAnIndex, false)
        FakeExpressionResolver customResolver = new FakeExpressionResolver();
            assertThat(result.length, equalTo(2));
            IndicesOptions.strictExpandOpenAndForbidClosed(),
                    IndexNotFoundException.class,
            IndicesOptions.lenientExpandOpen(),
        assertEquals(1, results.length);
            if (indicesOptions.allowNoIndices()) {
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("index_b1")).put(indexBuilder("index_b2"));
    }
        );
            throw new UnsupportedOperationException("resolve operation not supported on FakeExpressionResolver");
            .put(
                    .putAlias(AliasMetadata.builder(hiddenAlias).isHidden(true))
import static org.hamcrest.Matchers.arrayWithSize;
        // only against the defined indices
            indexNameExpressionResolver.concreteIndexNames(context, "foobar2-closed");
                true,
            Arrays.sort(result, Comparator.comparing(Index::getName));
import org.opensearch.action.support.IndicesOptions;
        context = new IndexNameExpressionResolver.Context(state, options, false);
            assertEquals("test-a*", infe.getIndex().getName());
            );
                IndexNotFoundException.class,
            Index result = indexNameExpressionResolver.concreteWriteIndex(state, indicesOptions, "my-data-stream", false, true);
        final String hiddenAlias = "hidden_alias";
        IndicesOptions[] indicesOptions = new IndicesOptions[] { IndicesOptions.lenientExpandOpen(), IndicesOptions.lenientExpand() };
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("alias-0").filter("{ \"term\": \"foo\"}")))
        assertEquals(1, results.length);
        IndexMetadata index2 = createBackingIndex(dataStream1, 2).build();
            true,
                () -> indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*_alias")
                EnumSet.of(IndicesOptions.WildcardStates.OPEN)
    }
        {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
    }
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo1-closed");
        {
    public void testConcreteResolvedIndicesWithWildcards() {
    }
        assertArrayEquals(new String[] { "alias-0" }, strings);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            equalTo("The index expression [test-*] and options provided did not point to a single write-index")
        IndexNotFoundException infe = expectThrows(
                    IndexNotFoundException.class,
    }
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            );
        SearchRequest request = new SearchRequest(".ml-meta");
        assertEquals(4, results.length);
                indexBuilder("index-closed", Settings.builder().put("index.frozen", true).build()).state(State.CLOSE)
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED,
        assertThat(results, arrayContaining("foo1-closed"));
    }
            "test-0",
            state,
        results = indexNameExpressionResolver.concreteIndexNames(context, ".hidd*");
    public void testDedupConcreteIndices() {
                IndexNotFoundException.class,
                );
        {
        }
        assertThat(names, containsInAnyOrder(dataStream2));
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*")
            assertEquals(1, results.length);
        assertThat(results, arrayContainingInAnyOrder("foo", "foobar", "foofoo"));
            assertEquals(1, indices.length);
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
                    indexBuilder(dottedHiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "-testX*")),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden*");
                    .put(indexBuilder("ccc").state(State.CLOSE).putAlias(AliasMetadata.builder("ccc_alias1")));
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(testZeroWriteIndex ? true : null))
    public void testIsPatternMatchingAllIndicesMatchingTrailingWildcardAndExclusion() throws Exception {
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "*");
        results = indexNameExpressionResolver.concreteIndexNames(context2, "foo*", "bar");
    }
            IllegalArgumentException.class,
            // If the alias is resolved to concrete indices, it should resolve to all the indices it points to, hidden or not.
                }
        Metadata.Builder mdBuilder = Metadata.builder()
        Set<String> resolvedExpressions = indexNameExpressionResolver.resolveExpressions(state, "test-*");
    }
            () -> indexNameExpressionResolver.concreteIndexNames(context, "_foo")
                IndexNotFoundException.class,
        Metadata metadata = metadataBuilder(concreteIndices);
            equalTo(newHashSet("testYYX", "testYYY", "-testYYY"))
     * test resolving _all pattern (null, empty array or "_all") for random IndicesOptions
        // when ignoreAliases option is not set, concreteIndexNames resolves the provided
    public void testConcreteIndicesWildcardNoMatch() {
                IndexNotFoundException infe = expectThrows(
        assertThat(concreteResolvedIndices.names(), containsInAnyOrder("index_b1", "index_b2", "index_d"));
            .put(indexBuilder("-testXYZ").state(State.OPEN))
        assertEquals(new HashSet<>(Arrays.asList("test-1", "alias-1")), indexNameExpressionResolver.resolveExpressions(state, "*-1"));
            );
        assertEquals(1, results.length);
            } else {
    public void testIndicesAliasesRequestIgnoresAliases() {
import static org.hamcrest.Matchers.endsWith;
    public void testResolveExpressions() {
        }
            @Override
    private static Settings.Builder settings(Settings additionalSettings) {
    public void testIndicesAliasesRequestTargetDataStreams() {
            .map(i -> i.getName())
                IndexNotFoundException infe = expectThrows(
            }
                assertThat(infe.getIndex().getName(), equalTo("bar"));
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        assertThat(
        assertEquals(1, results.length);
            assertEquals("foo", results[0]);
                    .putAlias(AliasMetadata.builder("test-alias-closed"))
            "this request accesses system indices: [.ml-stuff], but in a future major version, "
            equalTo(newHashSet("-testXYZ", "-testXZZ"))
        Metadata.Builder mdBuilder = Metadata.builder()
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
        aliases = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, false, resolvedExpressions);
    public void testWildcardSystemIndexResolutionSingleMatchAllowed() {
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, noExpandErrorUnavailable, false);
            }
        ClusterState state = ClusterState.builder(new ClusterName("_name"))
            assertEquals(1, results.length);
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
            state,
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpandOpen(), false);
    }
                "ind*",
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*")
                            AliasMetadata.builder("test-alias").writeIndex(testZeroWriteIndex ? randomFrom(false, null) : true)
            assertEquals("test-index", indices[0]);
                    DataStream.getDefaultBackingIndexName(dataStreamName, 2)
        assertEquals(1, results.length);
                    IndexNotFoundException.class,
    public void testFullWildcardSystemIndexResolutionDeprecated() {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        assertEquals(Collections.singletonList(dataStream2), names);
            IndicesOptions indicesOptions = new IndicesOptions(
                    )
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
                contextICE.getOptions().allowNoIndices(),
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.removeIndex().index("test-index");
    }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
    public void testIsAllIndicesWildcard() throws Exception {
            }
            assertEquals(3, indices.length);
            IndicesOptions.strictExpandOpen(),
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
            .put(new DataStream(dataStream1, createTimestampField("@timestamp"), List.of(index1.getIndex(), index2.getIndex())))
        }
                .put(indexBuilder(visibleIndex).state(State.OPEN).putAlias(AliasMetadata.builder(visibleAlias)))
        expectThrows(IndexClosedException.class, () -> indexNameExpressionResolver.concreteIndexNames(contextICE, "foobar1-closed"));
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("test-a*");
    public void testIsAllIndicesNormalIndexes() throws Exception {
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, true, false), false);
        results = indexNameExpressionResolver.concreteIndexNames(context, "-*");
            .put(
    }
        assertEquals(2, results.length);
            )
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            IndicesOptions indicesOptions = new IndicesOptions(
            equalTo(newHashSet("testXXY", "-testXYZ", "-testXZZ"))
                    )
        assertThat(indexNames, containsInAnyOrder(".ml-meta"));
        assertTrue(indexNames.contains("foo_foo"));
                String[] concreteIndices = indexNameExpressionResolver.concreteIndexNames(context, "Foo*");
    public void testWildcardSystemIndexResolutionMultipleMatchesDeprecated() {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        Metadata metadata = metadataBuilder(allConcreteIndices);
        String[] concreteIndices = new String[] { "index2", "index3" };
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Arrays.asList("index1", "index2", "index3")), equalTo(false));
                    expectThrows(IndexNotFoundException.class, () -> indexNameExpressionResolver.concreteIndexNames(context, allIndices));
    }
        assertEquals("bar", results[0]);
                return new String[] { "test-alias" };
            .put(indexBuilder("foobar").putAlias(AliasMetadata.builder("barbaz")))
            }
            }
        IndicesOptions options = IndicesOptions.strictExpandOpen();
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), index3.getIndex().getName());
            IndicesOptions noExpandLenient = IndicesOptions.fromOptions(true, true, false, false, randomBoolean());
                state,
            IndexNotFoundException infe = expectThrows(
                assertThat(infe.getIndex().getName(), equalTo("baz*"));
        final String dataStreamName = "my-data-stream";
            assertEquals(0, results.length);
        SearchRequest request = new SearchRequest(".ml-*");
            Metadata.Builder mdBuilder = Metadata.builder()
        final String dataStream2 = "other-foobar";
                "no write index is defined for alias [test-alias]."
            )
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.removeIndex().index("test-*");
    public void testConcreteIndicesIgnoreIndicesEmptyRequest() {
 * Licensed to Elasticsearch under one or more contributor
                state,
                IndexNotFoundException.class,
        ClusterState state = systemIndexTestClusterState();
            assertThat(infe.getIndex().getName(), equalTo("baz*"));
        for (int i = 0; i < 10; i++) {
            InvalidIndexNameException.class,
    public void testConcreteIndicesNoIndicesErrorMessage() {
        {
        options = IndicesOptions.fromOptions(false, true, true, false, true);
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream2, 2)));
    public void testIsPatternMatchingAllIndicesNonMatchingTrailingWildcardAndExclusion() throws Exception {
        assertEquals(3, results.length);
        return settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        options = IndicesOptions.fromOptions(false, true, false, false, true);
            false
        }
                    EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES),
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(1, results.length);
            assertThat(e.getMessage(), equalTo("no such index [my-data-stream]"));
        assertEquals(2, results.length);
                context.getOptions().allowNoIndices(),
                );
                if (indicesOptions.allowNoIndices()) {
            .numberOfReplicas(1)
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*");
        );
        }
 * ownership. Elasticsearch licenses this file to you under
            IllegalArgumentException.class,
        assertEquals("foo_foo", indexNamesIndexWildcard[0]);
            new DeleteRequest("test-alias")
            "test-0",
        }
        assertArrayEquals(new String[] { "other-alias" }, aliases);
    public void testConcreteIndicesNoIndicesErrorMessageNoExpand() {
                () -> indexNameExpressionResolver.concreteIndexNames(context, "baz*")
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        assertEquals("foobar", results[0]);
        Metadata.Builder mdBuilder = Metadata.builder()
        }
        );
        Metadata.Builder mdBuilder = Metadata.builder()
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(false));
        Metadata.Builder mdBuilder = Metadata.builder()
    public void testConcreteWriteIndexWithInvalidIndicesRequest() {
        }
            IndicesOptions noExpandErrorUnavailable = IndicesOptions.fromOptions(false, true, false, false, randomBoolean());
                () -> indexNameExpressionResolver.concreteIndexNames(state, new DeleteIndexRequest("test-alias"))
import static org.hamcrest.Matchers.containsInAnyOrder;
        }
        }
                state,
                    allIndices = new String[0];
    public void testIgnoreAliasesOnNonWildcardValue() {
        ClusterState state = systemIndexTestClusterState();
            );
            public boolean includeDataStreams() {
            () -> indexNameExpressionResolver.concreteWriteIndex(state, request.indicesOptions(), request.indices()[0], false, false)
        assertThat(results, arrayContainingInAnyOrder("bar", ".hidden", ".hidden-closed"));
 * license agreements. See the NOTICE file distributed with
            IndexNotFoundException iae = expectThrows(
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo*");
        {
        assertThat(concreteResolvedIndices.namesOfConcreteIndices(), containsInAnyOrder("index_a1", "index_a2", "index_b1", "index_b2"));
        String[] indicesOrAliases = new String[] { "*" };
 *
            ),
                    + " indices without one being designated as a write index"
            .put(indexBuilder("test-index").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias")))
    }
            IndicesOptions.fromOptions(true, true, false, false),
                () -> indexNameExpressionResolver.concreteIndexNames(context, "foofoo-closed", "foofoobar")
            assertThat(e.getMessage(), equalTo("no such index [my-data-stream]"));
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
            new HashSet<>(Arrays.asList("test-0", "test-1", "test-alias"))
        assertTrue(indexNames.contains("bar_bar"));
        {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            assertEquals(1, indices.length);
        {
            false
            assertThat(result.length, equalTo(0));
            .put(index2, false)
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
                "test-alias"
        );
            indexNameExpressionResolver.resolveExpressions(state, "test-*", "alias-*")
        final String visibleIndex = "visible_index";
            deleteIndexRequest.indicesOptions(IndicesOptions.fromOptions(true, true, true, true, false, false, true, false));
        final IndexNameExpressionResolver.Context context2 = new IndexNameExpressionResolver.Context(
        String[] indicesOrAliases = new String[] { "index*", "-index1" };
            );
            true,
            .metadata(
            true,
        assertEquals(1, results.length);
        );
            assertThat(result.length, equalTo(4));
        );
        }
        }
        String[] indicesOrAliases = new String[] { "index*", "-index1", "index1" };
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("alias-0").filter("{ \"term\": \"foo\"}")))
            );
        {
        {
        Metadata.Builder mdBuilder = Metadata.builder();
    public void testSingleSystemIndexResolutionDeprecated() {
        // error on both unavailable and no indices + every alias needs to expand to a single index
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                    )
        Set<String> resolvedExpressions = new HashSet<>(Arrays.asList("test-0", "test-alias"));
        List<ExpressionResolver> customResolvers = Collections.singletonList(customResolver);
            IndicesOptions.lenientExpandOpen(),
        assertEquals(4, results.length);
            }
            state,
        assertThat(results, arrayContainingInAnyOrder(".hidden"));
        {
        }
            new HashSet<>(Arrays.asList("test-0", "test-alias"))
import org.opensearch.core.common.Strings;
        ClusterState state = ClusterState.builder(new ClusterName("_name"))
    }
            Arrays.sort(indices, Comparator.comparing(Index::getName));
    public void testIsExplicitAllIndicesNull() throws Exception {
                "ind*",
        assertEquals(
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
        IndexMetadata justAnIndex = IndexMetadata.builder("logs-foobarbaz-0")
            new HashSet<>(Arrays.asList("test-0", "alias-0", "alias-1")),
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
                () -> indexNameExpressionResolver.concreteIndexNames(state, aliasActions)
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("test"));
        assertEquals(3, results.length);
            assertThat(results, arrayContainingInAnyOrder("foofoo"));
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(testZeroWriteIndex ? randomFrom(false, null) : true))
            assertEquals("test-a*", infe.getIndex().getName());
import static org.opensearch.common.util.set.Sets.newHashSet;
        assertEquals(1, results.length);
        assertTrue(indexNames.contains("foo_foo"));
            .put(indexBuilder("foofoo").putAlias(AliasMetadata.builder("barbaz")));
            .put(
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        for (int i = 0; i < 10; i++) {
                iae.getMessage()
            state,
                IndicesOptions.STRICT_EXPAND_OPEN_FORBID_CLOSED_IGNORE_THROTTLED,
        IndexMetadata index3 = createBackingIndex(dataStream2, 1).build();
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.removeIndex().index("test-alias");
        assertThat(infe.getResourceId().toString(), equalTo("[-*]"));
                + "direct access to system indices will be prevented by default",
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo", "-foobar", "-hidden*");
                "alias [alias_a] has more than one index associated with it [index_a1, index_a2], can't execute a single index op",
        }
        assertEquals(1, results.length);
                IndexNotFoundException infe = expectThrows(
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*");
            // Only visible aliases should be included in wildcard resolution
            );
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            public boolean includeDataStreams() {
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")),
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
        assertThat(results, emptyArray());
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "bar")
        // even though it does identify all indices, it's not a pattern but just an explicit list of them
        IndicesOptions options = IndicesOptions.fromOptions(false, true, false, true, false);
    public void testConcreteIndicesIgnoreIndicesAllMissing() {
        Metadata.Builder mdBuilder = Metadata.builder()
        Metadata.Builder mdBuilder = Metadata.builder()
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Arrays.asList("_all", "other")), equalTo(false));
        assertThat(indexNames, containsInAnyOrder(".ml-meta", ".ml-stuff"));
        IndexMetadata backingIndex = createBackingIndex(dataStreamName, 1).build();
        // Only open
            results = indexNameExpressionResolver.concreteIndexNames(context, "baz*");
            exception.getMessage(),
    public void testIsAllIndicesExplicitAll() throws Exception {
        String[] allConcreteIndices = new String[] { "index1", "index2", "index3" };
            new HashSet<>(Arrays.asList("test-0", "test-1", "alias-0", "alias-1")),
        assertThat(results, arrayContaining("foo3"));
            IndexNotFoundException iae = expectThrows(
            assertThat(results, equalTo(new String[] { "index1" }));
            .put(indexBuilder("testYYX").state(State.OPEN));
            results = indexNameExpressionResolver.concreteIndexNames(context, "barbaz", "foobar");
        results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo*");
                IndexNotFoundException.class,
        String[] indicesOrAliases = new String[] { "-index1" };
            IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
    }
                state,
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden");
                )
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "bar")
            );
            assertEquals(1, indices.length);
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("alias-0")))
                    .put(
                    .put(
            IllegalArgumentException iae = expectThrows(
package org.opensearch.cluster.metadata;
    }
        IndexMetadata index2 = createBackingIndex(dataStream1, 2).build();
            state,
    }
        results = indexNameExpressionResolver.concreteIndexNames(context, ".*");
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "my-hidden*", "-my-hidden-a*");
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            IndexNotFoundException iae = expectThrows(
            {
        return indexBuilder(index, Settings.EMPTY);
                    assertThat(concreteIndices, notNullValue());
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;
            IndexNotFoundException infe = expectThrows(
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "barbaz", "bar")
                IndexNotFoundException.class,
            // A query that only matches the hidden alias should throw
            .put(
        assertThat(names, containsInAnyOrder(dataStream1, dataStream2));
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpand(), false);
            assertThat(e.getMessage(), containsString("alias [foofoobar] has more than one index associated with it"));
            true,
        SearchRequest request = new SearchRequest(randomFrom("*", "_all"));
            )
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
        names = indexNameExpressionResolver.dataStreamNames(state, IndicesOptions.lenientExpand(), "*", "-logs-foobar");
        );
                expectThrows(IndexNotFoundException.class, () -> indexNameExpressionResolver.concreteIndexNames(context, "bar", "baz"));
        Metadata.Builder mdBuilder = Metadata.builder()
            );
            results = indexNameExpressionResolver.concreteIndexNames(context, "foo", "bar");
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*_alias");
            IndexClosedException ince = expectThrows(
        );
        indexNameExpressionResolver = createIndexNameExpressionResolver(threadContext);
import java.util.HashSet;
                assertThat(infe.getIndex().getName(), equalTo("baz*"));
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, hiddenAlias);
        }
            state,
    public void testIndexOptionsEmptyCluster() {
        assertThat(
    public void testHiddenIndexWithVisibleAliasOverlappingNameResolution() {
                return new String[] { "test-*" };
            equalTo(newHashSet("testXXX", "testXXY"))
        assertThat(infe.getMessage(), is("no such index [null] and no indices exist"));
            x -> true,
        // open and hidden
        Metadata.Builder mdBuilder = Metadata.builder()
        IndexNotFoundException infe = expectThrows(
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
        assertEquals(0, results.length);
            IndexNotFoundException infe = expectThrows(
                    state,
        assertEquals(2, indexNames.size());
        assertEquals(3, results.length);
                    .put(
                + "to system indices will be prevented by default",
        assertThat(results, arrayContainingInAnyOrder("foobar", "foo"));
            equalTo(newHashSet("testXXX", "testXXY", "testXYY", "testYYX", "testYYY", "-testYYY"))
        IndicesOptions expand = IndicesOptions.fromOptions(true, false, true, true);
        results = indexNameExpressionResolver.concreteIndexNames(context, "-*");
            );
        IndexNotFoundException infe = expectThrows(
        Function<String[], IndicesRequest> requestGen = (indices) -> new IndicesRequest() {
        String[] allConcreteIndices = new String[] { "index1", "index2", "index3" };
        Arrays.sort(strings);
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpandOpen(), false);
        context = new IndexNameExpressionResolver.Context(state, options, false);
import org.opensearch.indices.InvalidIndexNameException;
            false
                    .putAlias(AliasMetadata.builder("test-alias"))
            fail("foo2-closed should be closed, but it is open");
        // error on both unavailable and no indices
        assertThat(infe.getMessage(), is("no such index [testMo]"));
        assertThat(infe.getMessage(), is("no such index [_all] and no indices exist"));
        Metadata metadata = metadataBuilder(concreteIndices);
        {
import static org.hamcrest.Matchers.emptyArray;
    public void testIndexOptionsStrict() {
            Index[] indices = indexNameExpressionResolver.concreteIndices(
                )
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
            String[] indexNames;
 * specific language governing permissions and limitations
        writeIndex = indexNameExpressionResolver.concreteWriteIndex(state, request);
        IllegalArgumentException exception = expectThrows(
            assertThat(infe2.getIndex().getName(), equalTo("baz*"));
        Metadata.Builder mdBuilder = Metadata.builder()
            x -> x.alias().equals("test-alias-1"),
                );
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                () -> indexNameExpressionResolver.concreteIndexNames(context, "baz*")
            ResolvedIndices.Local.Concrete concreteResolvedIndices = indexNameExpressionResolver.concreteResolvedIndices(
            String[] indexNames;
    public void testIsPatternMatchingAllIndicesMatchingTrailingWildcard() throws Exception {
            Exception e = expectThrows(
        assertEquals("foo", results[0]);
        assertTrue(indexNames.contains("foo_foo"));
        boolean testZeroWriteIndex = randomBoolean();
        assertEquals(0, results.length);
        IndexNameExpressionResolver.Context contextICE = new IndexNameExpressionResolver.Context(
            "alias_a",
        assertThat(IndexNameExpressionResolver.isAllIndices(Collections.<String>emptyList()), equalTo(true));
                IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
        IndexMetadata index1 = createBackingIndex(dataStream1, 1).build();
            )
        assertEquals("bar", results[0]);
            false
            assertThat(infe.getIndex().getName(), equalTo("baz*"));
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("test"));
            // A dot-prefixed pattern that includes only the hidden alias should resolve to both, regardless of the options
        assertEquals(1, results.length);
            equalTo(newHashSet("kuku", "testXXX"))
        IllegalArgumentException exception = expectThrows(
        results = indexNameExpressionResolver.concreteIndexNames(context, "bar");
        {
                );
        Metadata.Builder mdBuilder = Metadata.builder()
            () -> indexNameExpressionResolver.concreteIndices(context, new String[] {})
                IndexNotFoundException.class,
            ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        resolvedExpressions = new HashSet<>(Arrays.asList("test-0", "alias-0", "alias-1"));
        {
            context = new IndexNameExpressionResolver.Context(state, options, false);
            assertEquals(expectedMessage, iae.getMessage());
        IndexMetadata index4 = createBackingIndex(dataStream2, 2).build();
                return false;
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, new String[] {})),
/*
    }
                        .putAlias(AliasMetadata.builder(dottedHiddenAlias).isHidden(true))
        {
                    indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
            .put(index2, false)
                new IndicesOptions(
                iae.getMessage()
        }
                indexBuilder("test-0").state(State.OPEN)
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
        // when ignoreAliases option is set, concreteIndexNames resolves the provided expressions
        assertThat(
    }
        assertThat(results, arrayContainingInAnyOrder("bar", "hidden", "hidden-closed", ".hidden", ".hidden-closed"));
                assertThat(infe.getIndex().getName(), equalTo("bar"));
        final IndexNameExpressionResolver.Context context3 = new IndexNameExpressionResolver.Context(
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(hiddenIndex));
        Arrays.sort(strings);
            @Override
                iae.getMessage()
        final String dataStream1 = "logs-mysql";
        );
        {
        {
        assertThat(
            IndexNotFoundException infe = expectThrows(
        assertThat(names, empty());
    public void setUp() throws Exception {
            IllegalArgumentException.class,
        assertEquals("bar", results[0]);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        Metadata.Builder mdBuilder = Metadata.builder()
        }
            {
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
 */
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
        Arrays.sort(strings);
        Arrays.sort(strings);
            assertEquals("test-index", indices[0]);
        SearchRequest request = new SearchRequest(".ml-*");
            .put(indexBuilder("index_b1"))
        }
        {
        assertArrayEquals(new String[] { "test-alias" }, strings);
    }
                    IndexNotFoundException.class,
                contextICE.getOptions().expandWildcardsClosed(),
        assertEquals(Arrays.toString(results), 4, results.length);
            assertThat(results, arrayContainingInAnyOrder("foofoo", "foobar"));
                ),
                assertThat(infe.getIndex().getName(), equalTo("bar"));
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(true));
            IndicesOptions.lenientExpandOpen(),
            new IndexRequest("test-alias"),
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        assertTrue(indexNames.contains("foo_foo"));
            IllegalArgumentException.class,
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add()
            assertEquals("foo", results[0]);
            () -> indexNameExpressionResolver.concreteIndexNames(
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "logs-*");
            IndicesOptions noExpandStrict = IndicesOptions.fromOptions(false, false, false, false, randomBoolean());
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.removeIndex().index("test-a*");
import java.util.List;
        options = IndicesOptions.fromOptions(false, false, true, true, true);
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        assertThat(IndexNameExpressionResolver.isExplicitAllPattern(Arrays.asList("_all")), equalTo(true));
                    break;
        super.setUp();
        strings = indexNameExpressionResolver.filteringAliases(state, "test-0", resolvedExpressions);
        exception = expectThrows(
            IllegalArgumentException.class,
                    .put(justAnIndex, false)
import org.opensearch.action.DocWriteRequest;
            )
        results = indexNameExpressionResolver.concreteIndexNames(context2, "foo");
        assertArrayEquals(new String[] { "test-0" }, strings);
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar", "foo"));
        );
                expectThrows(IndexNotFoundException.class, () -> indexNameExpressionResolver.concreteIndexNames(context, "Foo*"));
            );
            IndicesOptions.fromOptions(true, false, true, false),
        {
            // But if we include hidden it should be resolved to both indices
            assertEquals("index", indices[0].getName());
        {
        {
            switch (randomIntBetween(0, 2)) {
            }
                Metadata.builder()
            // If we specify the alias by name it should resolve to both indices, regardless of if the options specify hidden
            .put(
            assertThat(result.getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStreamName, 2)));
        expectThrows(IndexClosedException.class, () -> indexNameExpressionResolver.concreteIndexNames(contextICE, "foo1-closed"));
                IllegalArgumentException.class,
            IndexNotFoundException.class,
        Metadata metadata = metadataBuilder(allConcreteIndices);
            .put(indexBuilder("-testXZZ").state(State.OPEN))
                return indices;
     */
            assertEquals(2, results.length);
        );
                    .putAlias(AliasMetadata.builder("test-alias-1").filter("{ \"term\": \"foo\"}"))
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "*_alias");
            expectThrows(
            Index[] indices = indexNameExpressionResolver.concreteIndices(
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.strictExpandOpen(), false);
            Arrays.sort(indices, Comparator.comparing(Index::getName));
        {
            assertThat(results, arrayContainingInAnyOrder("foo", "foobar"));
            exception.getMessage(),
        options = IndicesOptions.fromOptions(false, true, false, true, true);
        Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "logs-*");
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
                    .putAlias(AliasMetadata.builder("test-alias").writeIndex(randomFrom(!test0WriteIndex, null)))
                    .putAlias(AliasMetadata.builder("foobar2-closed"))
            );
        Metadata.Builder mdBuilder = Metadata.builder()
                IndexNotFoundException infe = expectThrows(
                    String[] concreteIndices = indexNameExpressionResolver.concreteIndexNames(context, allIndices);
            state,
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
        {
        for (IndicesOptions options : indicesOptions) {
            "test-0",
            .put(indexBuilder("testYYY").state(State.OPEN))
        assertThat(indexNameExpressionResolver.isPatternMatchingAllIndices(metadata, indicesOrAliases, concreteIndices), equalTo(false));
            assertEquals(2, results.length);
                } else {
            .put(
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
import static org.hamcrest.Matchers.arrayContaining;
        Metadata.Builder mdBuilder = Metadata.builder()
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo", "-foobar");
        assertEquals(5, results.length);
            assertThat(results, arrayContainingInAnyOrder("foofoo", "foobar"));
            false
    }
        IllegalArgumentException exception = expectThrows(
        assertEquals(4, results.length);
            assertThat(result[1].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 2)));
            assertThat(ince.getMessage(), equalTo("closed"));
    public void testDataStreams() {
            .put(indexBuilder("test-0").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias").writeIndex(false)));
                iae.getMessage()
        }
        assertThat(infe.getResourceId().toString(), equalTo("[_all]"));
            )
        assertThat(
        }
        assertThat(Arrays.asList(indexNames), containsInAnyOrder(hiddenIndex));
            public String[] indices() {
            // A hidden alias with a dot-prefixed name that points to one hidden index with a dot prefix, and one hidden index without
        results = indexNameExpressionResolver.concreteIndexNames(context, (String[]) null);
    }
                indexBuilder("test-index", Settings.builder().put("index.frozen", true).build()).state(State.OPEN)
                    .put(index1, false)
                state,
            new HashSet<>(Arrays.asList("test-0", "test-1", "test-alias"))
            false
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, options, false);
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
    }
            assertEquals("test-index", indices[0]);
            IndicesOptions indicesOptions = new IndicesOptions(
        Metadata.Builder mdBuilder = Metadata.builder()
                state,
        );
            .put(indexBuilder(".ml-stuff", settings).state(State.OPEN).system(true))
    }
        for (String concreteIndex : indices) {
    }
                "The provided expression [test-alias] matches an alias, " + "specify the corresponding concrete indices instead.",
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex, hiddenIndex));
            .put(indexBuilder("index_b2"));
    private IndexNameExpressionResolver indexNameExpressionResolver;
        );
        {
                context.getOptions().expandWildcardsClosed(),
            .put(indexBuilder("index").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias2")));
            IllegalArgumentException.class,
import java.util.Set;
        results = indexNameExpressionResolver.concreteIndexNames(context, "*", "-foo", "*");
        }
        assertThat(results, arrayContainingInAnyOrder("foo", "hidden-closed", ".hidden-closed"));
        );
        IndexMetadata index4 = createBackingIndex(dataStream2, 2).build();
            }
            Arrays.sort(result, Comparator.comparing(Index::getName));
        assertThat(result.length, equalTo(3));
        context = new IndexNameExpressionResolver.Context(
import org.opensearch.action.OriginalIndices;
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "hidden*", "visible*");
            .putAlias(new AliasMetadata.Builder("logs-foobarbaz"))
                EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES, IndicesOptions.Option.IGNORE_UNAVAILABLE),
                        expectedNumberOfIndices += 2;
    public void testConcreteWriteIndexWithNoWriteIndexWithSingleIndex() {
            );
                () -> indexNameExpressionResolver.concreteWriteIndex(state, indicesOptions, "my-data-stream", false, false)
            );
    }
import java.util.Comparator;
 */
        assertThat(names, empty());
        };
            .put(indexBuilder("index_b1").putAlias(AliasMetadata.builder("alias_b")))
            {
        assertThat(results, arrayContainingInAnyOrder(".hidden-closed"));
 * GitHub history for details.
    }
    }
import static org.hamcrest.Matchers.containsString;
                .put(
                    .putAlias(AliasMetadata.builder("other-alias"))
    private List<String> resolveConcreteIndexNameList(ClusterState state, SearchRequest request) {
        assertEquals(indexNameExpressionResolver.getExpressionResolvers().get(0), customResolver);
            IndicesOptions.lenientExpandOpen(),
        }
            assertEquals(1, results.length);
        {
        );
                "no such index [baz*]",
            IllegalArgumentException e = expectThrows(
            @Override
            .put(indexBuilder("index_a2").putAlias(AliasMetadata.builder("alias_a")))
        assertThat(results, arrayContainingInAnyOrder("foo", "foobar", "foofoo", "foofoo-closed"));
        assertThat(exception.getMessage(), endsWith(", can't execute a single index op"));
            Arrays.sort(indices, Comparator.comparing(Index::getName));
            .putAlias(new AliasMetadata.Builder("logs-foobarbaz"))
                )
                    () -> indexNameExpressionResolver.concreteIndexNames(context, "foo", "baz*")
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(visibleIndex));
                    .putAlias(AliasMetadata.builder(visibleAlias).build())
            );
        );
        List<String> indexNames = resolveConcreteIndexNameList(state, request);
            Exception e = expectThrows(
        assertEquals("foobar", results[0]);
                indexBuilder("test-1").state(State.OPEN).putAlias(AliasMetadata.builder("test-alias").writeIndex(randomFrom(false, null)))
        IndicesOptions includeHiddenOptions = IndicesOptions.fromOptions(false, false, true, false, true, true, false, false, false);
        DocWriteRequest request = randomFrom(
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            .put(indexBuilder("foofoo-closed").state(IndexMetadata.State.CLOSE))
            // A total wildcard should only be resolved to visible indices
    public void testIsPatternMatchingAllIndicesExplicitList() throws Exception {
        Arrays.sort(strings);
        );
            Index[] result = indexNameExpressionResolver.concreteIndices(state, indicesOptions, true, "my-data-stream");
        assertThat(IndexNameExpressionResolver.isAllIndices(Arrays.asList("index1", "index2", "index3")), equalTo(false));
            );
            assertEquals(1, results.length);
            }
        {
        assertThat(
        assertThat(results, arrayContainingInAnyOrder("hidden"));
        String[] results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
            final IndicesOptions indicesOptions = IndicesOptions.fromOptions(
            );
        String[] indexNamesIndexWildcard = indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "foo*");
            context,
        assertEquals(4, results.length);
import org.opensearch.action.IndicesRequest;
    }
        );
    }
        assertThat(results, arrayWithSize(1));
            IndexNotFoundException infe = expectThrows(
            Index[] result = indexNameExpressionResolver.concreteIndices(
            () -> indexNameExpressionResolver.concreteIndexNames(context, "testMo", "testMahdy")
            .put(new DataStream(dataStream2, createTimestampField("@timestamp"), List.of(index3.getIndex(), index4.getIndex())));
            "index_d"
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foo");
            false
        // open closed and hidden
            state,
            assertEquals("foo", results[0]);
            Metadata.Builder mdBuilder = Metadata.builder()
    @Override
        results = indexNameExpressionResolver.concreteIndexNames(context, "hidden-closed");
        {
            IndicesOptions.lenientExpandOpen(),
        );
        assertThat(results, arrayContaining("foo1-closed"));
                Metadata.builder()
        aliases = indexNameExpressionResolver.indexAliases(state, "test-0", x -> true, true, resolvedExpressions);
    }
import org.opensearch.common.util.concurrent.ThreadContext;
        );
        assertThat(concreteResolvedIndices.withoutResolutionErrors().namesOfConcreteIndices(), containsInAnyOrder("index_b1", "index_c1"));
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
            .put(indexBuilder("foo2-closed").state(IndexMetadata.State.CLOSE).putAlias(AliasMetadata.builder("foobar2-closed")))
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpandOpen(), false);
            String expectedMessage = "To expand [CLOSE] wildcard, please set forbid_closed_indices to `false`";
            String[] indices = indexNameExpressionResolver.concreteIndexNames(state, aliasActions);
        strings = indexNameExpressionResolver.concreteIndexNames(context, "alias-*");
        );
        }
        // expressions against the defined indices and aliases
        assertThat(results, arrayContainingInAnyOrder("foo1-closed", "foo2-closed", "foo3"));
                indexBuilder("index", Settings.builder().put(IndexSettings.INDEX_SEARCH_THROTTLED.getKey(), true).build()).state(State.OPEN)
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
            // A visible index with a visible alias and a hidden index with a hidden alias
    }
            .put(indexBuilder("foo").putAlias(AliasMetadata.builder("foofoobar")))
                "closed"
                    IndexNotFoundException.class,
        String[] concreteIndices = new String[] { "index2", "index3" };
    }
                "The provided expression [test-alias] matches an alias, " + "specify the corresponding concrete indices instead.",
        {
                } else {
                String[] results = indexNameExpressionResolver.concreteIndexNames(context, "baz*");
        assertThat(IndexNameExpressionResolver.isAllIndices(Arrays.asList("*")), equalTo(false));
        IndicesRequest request = new IndicesRequest() {
import org.opensearch.action.update.UpdateRequest;
                IndexNotFoundException.class,
            IndicesAliasesRequest.AliasActions aliasActions = IndicesAliasesRequest.AliasActions.add().index("test-alias");
            )
        Metadata.Builder mdBuilder = Metadata.builder()
    }
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "*", "--testX*")),
            "test-0",
            assertThat(results, emptyArray());
            equalTo(newHashSet("testYYY", "testYYX", "testXXY", "testXYY"))
        resolvedExpressions = Collections.singleton("other-alias");
            new UpdateRequest("test-alias", "_id"),
        indexNamesIndexWildcard = indexNameExpressionResolver.concreteIndexNames(state, ignoreAliasesOptions, "*o");
    }
            false
            );
            );
        Metadata.Builder mdBuilder = Metadata.builder()
                assertThat(concreteIndices, notNullValue());
 * You may obtain a copy of the License at
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
                randomBoolean(),
                    IndicesOptions.lenientExpandOpen(),
            new IndexRequest("test-alias"),
            Index[] indices = indexNameExpressionResolver.concreteIndices(
            state,
        return IndexMetadata.builder(index).settings(settings(additionalSettings));
                );
            "test-0",
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
    private ThreadContext threadContext;
            assertThat(results, arrayContainingInAnyOrder("foofoo", "foobar"));
    }
        Metadata.Builder mdBuilder = Metadata.builder().put(indexBuilder("testXXX")).put(indexBuilder("kuku"));
        assertWarnings(
                IndexNotFoundException.class,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            "this request accesses system indices: [.ml-meta], but in a future major version, "
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, visibleAlias);
            assertThat(Arrays.asList(indexNames), containsInAnyOrder(dottedHiddenIndex, hiddenIndex));
        assertThat(indexNames, containsInAnyOrder("some-other-index", ".ml-stuff", ".ml-meta"));
        String[] allConcreteIndices = new String[] { "index1", "index2", "index3", "a", "b" };
        assertThat(
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            IndexNotFoundException.class,
/*
            .put(indexBuilder(".ml-meta", settings).state(State.OPEN).system(true))
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            false
                + "to system indices will be prevented by default"
                    .putAlias(AliasMetadata.builder("foobar1-closed"))
                );
                String[] results = indexNameExpressionResolver.concreteIndexNames(context, "foofoobar");
        // We test the following semantics:
    }
        String[] concreteIndices = new String[] { "index1", "index2", "index3" };
    }
            assertEquals(1, indices.length);
        IndexNotFoundException infe = expectThrows(
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        }
            assertThat(result.length, equalTo(2));
            )
            );
import org.opensearch.Version;
            // But should include both indices if the options do include hidden
            );
        assertThat(infe.getMessage(), is("no such index [testZZZ]"));
                IndexNotFoundException infe = expectThrows(
        Metadata.Builder mdBuilder = Metadata.builder()
            IndicesOptions.strictSingleIndexNoExpandForbidClosed(),
            IndexNotFoundException infe = expectThrows(
                    indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
    private static Metadata metadataBuilder(String... indices) {
            .put(indexBuilder("testYYY").state(State.OPEN))
            IllegalArgumentException e = expectThrows(
            );
        results = indexNameExpressionResolver.concreteIndexNames(context, "foofoo*");
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "*_alias");
            false
                    indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
            assertEquals("test-index", indices[2].getName());
        );
            );
            "alias_b",
        results = indexNameExpressionResolver.concreteIndexNames(context, "foo*");
            "The provided expression [my_alias] matches an alias, specify the corresponding concrete indices instead.",
    public void testConcreteResolvedIndicesWithIndicesRequestParam() {
    }
            x -> true,
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpandOpen(), false);
            final String[] allIndices;
            .put(indexBuilder("foo_foo").state(State.OPEN).putAlias(AliasMetadata.builder("foo")))
        // - names of non-existing indices
    public void testIgnoreThrottled() {
            equalTo(newHashSet("testYYY", "testYYX"))
            equalTo(newHashSet("testXXX", "testXXY", "testYYY", "-testYYY"))
                EnumSet.of(IndicesOptions.WildcardStates.OPEN)
                IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, indicesOptions, false);
        Metadata.Builder mdBuilder = Metadata.builder()
            state,
        IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(
            @Override
        );
            IndicesOptions.strictExpandOpen(),
        assertThat(exception.getMessage(), equalTo("indices request must specify a single index expression"));
            }
    }
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, "my-*");
            results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.lenientExpand(), false);
        assertThat(results, arrayContainingInAnyOrder("foobar", "foo"));
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, includeHiddenOptions, "hidden*", "visible*");
            assertThat(infe.getIndex().getName(), equalTo("bar"));
            assertThat(result.length, equalTo(2));
                assertThat(infe.getIndex().getName(), equalTo("baz*"));
                ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
            IndicesOptions.lenientExpandOpen(),
        );
            .metadata(
            String[] results = indexNameExpressionResolver.concreteIndexNames(context, "index1", "index1", "alias1");
                ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(Metadata.builder().build()).build();
            // Ignore data streams and allow no indices
            {
            // A hidden alias that points to one hidden and one visible index
            IndicesOptions.lenientExpandOpen(),
        Metadata.Builder mdBuilder = Metadata.builder()
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(backingIndex.getIndex()), 1));
    }
    public void testAddCustomResolver() {
            );
import org.opensearch.cluster.ClusterName;
        // ignore unavailable and allow no indices
        {
    }
            IndexNotFoundException infe = expectThrows(
        IndexMetadata index3 = createBackingIndex(dataStream2, 1).state(State.CLOSE).build();
                + "direct access to system indices will be prevented by default"
            assertEquals(1, indices.length);
            );
                indexBuilder("test-0").state(State.OPEN)
        }
            indexNames = indexNameExpressionResolver.concreteIndexNames(state, excludeHiddenOptions, hiddenAlias);
        {
        IllegalArgumentException illegalArgumentException = expectThrows(
        assertThat(results, arrayContainingInAnyOrder("hidden-closed"));
        assertThat(newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "testX*")), equalTo(new HashSet<String>()));
            illegalArgumentException.getMessage()
        results = indexNameExpressionResolver.concreteIndexNames(context, Strings.EMPTY_ARRAY);
        assertEquals("bar", results[0]);
            )
            @Override
        assertEquals(1, results.length);
            IndexNameExpressionResolver.Context context = new IndexNameExpressionResolver.Context(state, noExpandStrict, false);
            assertThat(result[0].getName(), equalTo(DataStream.getDefaultBackingIndexName(dataStream1, 1)));
                IndexNotFoundException.class,
            assertEquals(1, results.length);
        Metadata.Builder mdBuilder = Metadata.builder();
                );
        assertThat(results, emptyArray());
        }
                context.getOptions().expandWildcardsOpen(),
    }
            .put(indexBuilder("testXXX").state(State.OPEN))
 * Unless required by applicable law or agreed to in writing,
        );
                    indexBuilder(hiddenIndex, Settings.builder().put(INDEX_HIDDEN_SETTING.getKey(), true).build()).state(State.OPEN)
        String[] strings = indexNameExpressionResolver.filteringAliases(state, "test-0", resolvedExpressions);
 * software distributed under the License is distributed on an
            IndicesOptions indicesOptions = IndicesOptions.STRICT_EXPAND_OPEN;
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "test*", "-testX*")),
        Metadata.Builder mdBuilder = Metadata.builder()
        assertThat(results, arrayContainingInAnyOrder("hidden"));
            newHashSet(indexNameExpressionResolver.concreteIndexNames(context, "-testXXX", "*testY*", "-testYYY")),
    }
        assertThat(results, arrayContainingInAnyOrder("bar", "foobar", "foo", "hidden", "hidden-closed", ".hidden", ".hidden-closed"));
        ClusterState state = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        expectThrows(InvalidIndexNameException.class, () -> indexNameExpressionResolver.resolveExpressions(state, "_invalid_index_name"));
        IndicesOptions[] indicesOptions = new IndicesOptions[] { expandOpen, expand };
        Set<String> resolvedExpressions = new HashSet<>(Arrays.asList("alias-0", "alias-1"));
                    if (indicesOptions.expandWildcardsClosed()) {
                );
import static org.hamcrest.Matchers.equalTo;
 * this file be licensed under the Apache-2.0 license or a
        );
        );
            String[] indexNames;
        context = new IndexNameExpressionResolver.Context(state, IndicesOptions.fromOptions(true, true, true, true), false);
            .put(index1, false)
