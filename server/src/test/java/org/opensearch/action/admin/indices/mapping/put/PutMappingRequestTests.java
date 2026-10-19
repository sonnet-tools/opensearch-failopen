        Index[] indices = TransportPutMappingAction.resolveIndices(
        }
        Metadata.Builder builder = Metadata.builder(cs.metadata());
            tuple(dataStreamNames[2], randomIntBetween(1, 3))
import org.opensearch.core.index.Index;
        List<Tuple<String, Integer>> dsMetadata = List.of(
            )
        List<Tuple<String, Integer>> dsMetadata = List.of(
        request.source(mapping);
        r.source("", MediaTypeRegistry.JSON);
    /**
    }
        BytesReference originalBytes = toShuffledXContent(putMappingRequest, xContentType, EMPTY_PARAMS, humanReadable);
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
    public void testToXContentWithEmptySource() throws IOException {
        List<String> indexNames = Arrays.stream(indices).map(Index::getName).collect(Collectors.toList());
            cs,
                AliasMetadata newAliasMd = AliasMetadata.newAliasMetadataBuilder(alias.v1()).writeIndex(index.v2()).build();
        ex = r.validate();
        );
        PutMappingRequest request = new PutMappingRequest().indices("foo", "index3").writeIndexOnly(true);
import org.opensearch.core.common.bytes.BytesReference;
     * to the alias's indices. The alias's indices are a tuple of index name and a flag indicating whether the alias
        );
        String[] dataStreamNames = { "foo", "bar", "baz" };
        IndexAbstraction expectedDs = cs.metadata().getIndicesLookup().get("foo");
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", true)))
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PutMappingRequest.simpleMapping("only_field"));
        PutMappingRequest request = new PutMappingRequest().indices("foo", "alias1", "alias2");
 * compatible open source license.
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", true))),
            XContentParser actualJson = createParser(MediaTypeRegistry.JSON.xContent(), actual)
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));
        String expectedRequestBody = "{\"properties\":{\"email\":{\"type\":\"text\"}}}";
 * specific language governing permissions and limitations
    private static ClusterState addAliases(ClusterState cs, List<Tuple<String, List<Tuple<String, Boolean>>>> aliases) {
            cs,
        PutMappingRequest request = new PutMappingRequest().indices("foo", "alias1", "alias2").writeIndexOnly(true);
    }
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", false)))
    public void testValidation() {
        );
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
            assertEquals(expectedJson.mapOrdered(), actualJson.mapOrdered());
    public void testResolveIndicesWithoutWriteIndexOnlyAndDataStreamsAndWriteAliases() {
        assertThat(e.getMessage(), containsString("no write index is defined for alias [alias2]"));
        String[] dataStreamNames = { "foo", "bar", "baz" };
import org.opensearch.common.collect.Tuple;
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
        ex = r.validate();
        expectedIndices.addAll(List.of("index1", "index2", "index3"));
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
import org.opensearch.cluster.metadata.IndexMetadata;
        assertNotNull("source validation should fail", ex);
            ex.getMessage(),
public class PutMappingRequestTests extends OpenSearchTestCase {
/*
        ).concreteIndicesAsArray();
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));
            List.of(
import org.opensearch.cluster.metadata.AliasMetadata;
import java.util.stream.Collectors;
            )
import org.opensearch.cluster.ClusterState;
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", true)))
        ActionRequestValidationException ex = r.validate();
            () -> TransportPutMappingAction.resolveIndices(cs2, request, new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)))
        String[] dataStreamNames = { "foo", "bar", "baz" };
        ).concreteIndicesAsArray();
        cs = addAliases(
        // should resolve the data stream and each alias to their respective write indices
            tuple(dataStreamNames[2], randomIntBetween(1, 3))
 * software distributed under the License is distributed on an
        assertThat(indexNames, containsInAnyOrder(expectedDs.getWriteIndex().getIndex().getName(), "index2", "index3"));
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", true))),
        return request;
        mapping.endObject();
package org.opensearch.action.admin.indices.mapping.put;
        String actualRequestBody = Strings.toString(MediaTypeRegistry.JSON, request);
        cs = addAliases(
        return ClusterState.builder(cs).metadata(builder.build()).build();
        final PutMappingRequest putMappingRequest = createTestItem();
 * under the License.
        assertTrue(ex.getMessage().contains("source is missing"));
}
 * license agreements. See the NOTICE file distributed with
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", true)))
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
        for (Tuple<String, List<Tuple<String, Boolean>>> alias : aliases) {
        final ClusterState cs2 = addAliases(
                + " concrete index: [[foo/bar]] and indices: [myindex];"
        assertEquals(
    public void testResolveIndicesWithWriteIndexOnlyAndAliasWithoutWriteIndex() {
 * not use this file except in compliance with the License.
        mapping.startObject("email");
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
        String[] dataStreamNames = { "foo", "bar", "baz" };
        IllegalArgumentException e = expectThrows(
        List<String> indexNames = Arrays.stream(indices).map(Index::getName).collect(Collectors.toList());
    }
            tuple(dataStreamNames[2], randomIntBetween(1, 3))
        try (
        );
            request,
        r.setConcreteIndex(new Index("foo", "bar"));
     * Returns a random {@link PutMappingRequest}.
     */
            for (Tuple<String, Boolean> index : alias.v2()) {
            )
/*
 * KIND, either express or implied.  See the License for the
        request.source(RandomCreateIndexGenerator.randomMapping());
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        PutMappingRequest request = new PutMappingRequest().indices("*").writeIndexOnly(true);
            )
            XContentParser expectedJson = createParser(MediaTypeRegistry.JSON.xContent(), expected);
     */
        assertThat(indexNames, containsInAnyOrder(expectedIndices.toArray()));
        IndexAbstraction expectedDs = cs.metadata().getIndicesLookup().get("foo");
 * ownership. Elasticsearch licenses this file to you under
            cs,
        final XContentType xContentType = randomFrom(XContentType.values());
        String[] dataStreamNames = { "foo", "bar", "baz" };
 */
        List<Tuple<String, Integer>> dsMetadata = List.of(
        mapping.endObject();
            request,
        expectedIndices.addAll(List.of("index1", "index2", "index3"));
            IllegalArgumentException.class,
import java.io.IOException;
    public void testResolveIndicesWithWriteIndexOnlyAndNoSingleWriteIndex() {
import org.opensearch.test.OpenSearchTestCase;
        assertMappingsEqual(putMappingRequest.source(), parsedPutMappingRequest.source());
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(expectedRequestBody, actualRequestBody);
    public void testToAndFromXContent() throws IOException {
                IndexMetadata im = builder.get(index.v1());
        mapping.field("type", "text");
    /**
        assertTrue(ex.getMessage().contains("source is empty"));
import org.opensearch.cluster.metadata.IndexAbstraction;
        }
        String expectedRequestBody = "{}";
        assertNull("validation should succeed", ex);
        PutMappingRequest request = new PutMappingRequest("foo");
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", true)))
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
 *    http://www.apache.org/licenses/LICENSE-2.0
        ex = r.validate();
        mapping.startObject("properties");
        PutMappingRequest request = new PutMappingRequest("foo");
    private void assertMappingsEqual(String expected, String actual) throws IOException {
    }
    }
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));
        List<Tuple<String, Integer>> dsMetadata = List.of(
        assertThat(indexNames, containsInAnyOrder(expectedDs.getWriteIndex().getIndex().getName(), "index3"));
            cs,
     * rejects inputs where the {@code Object...} varargs of field name and properties are not
 * this work for additional information regarding copyright
            IllegalArgumentException.class,
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.Strings;
        PutMappingRequest parsedPutMappingRequest = new PutMappingRequest();
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamRequestTests;
     * paired correctly
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.opensearch.common.collect.Tuple.tuple;
     * Adds aliases to the supplied ClusterState instance. The aliases parameter takes of list of tuples of aliasName
    public void testResolveIndicesWithWriteIndexOnlyAndDataStreamsAndWriteAliases() {
            List.of(
    public void testBuildFromSimplifiedDef() {
            () -> TransportPutMappingAction.resolveIndices(cs2, request, new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)))
        PutMappingRequest r = new PutMappingRequest("myindex");
        assertNotNull("source validation should fail", ex);
        List<String> expectedIndices = expectedDs.getIndices().stream().map(im -> im.getIndex().getName()).collect(Collectors.toList());
        );
    }
 *
        ) {
import org.opensearch.common.settings.Settings;
        Index[] indices = TransportPutMappingAction.resolveIndices(
            cs,
     */
import org.opensearch.common.xcontent.XContentType;
        List<String> indexNames = Arrays.stream(indices).map(Index::getName).collect(Collectors.toList());
import org.opensearch.cluster.metadata.Metadata;
        String index = randomAlphaOfLength(5);
            List.of(
    }
    public void testToXContent() throws IOException {
        // should resolve the data stream and each alias to _all_ their respective indices
        assertEquals("mapping source must be pairs of fieldnames and properties definition.", e.getMessage());
        assertThat(e.getMessage(), containsString("The index expression [*] and options provided did not point to a single write-index"));
        );
import org.opensearch.common.xcontent.json.JsonXContent;
        assertEquals(expectedRequestBody, actualRequestBody);
    }
import java.util.Arrays;
        List<Tuple<String, Integer>> dsMetadata = List.of(
/*
            "Validation Failed: 1: either concrete index or unresolved indices can be set,"
        );
import org.opensearch.core.xcontent.XContentParser;
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
 * You may obtain a copy of the License at
        );
import org.opensearch.action.ActionRequestValidationException;
        XContentBuilder mapping = JsonXContent.contentBuilder().startObject();
            cs,
    }
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", true))),
import java.util.List;
    }
            tuple(dataStreamNames[2], randomIntBetween(1, 3))
            cs,
        );
        assertNotNull("source validation should fail", ex);
 *
    }
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
            List.of(
            request,
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", true))),
        final ClusterState cs2 = addAliases(
        PutMappingRequest request = new PutMappingRequest().indices("alias2").writeIndexOnly(true);
        PutMappingRequest request = new PutMappingRequest(index);
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
import org.opensearch.common.util.concurrent.ThreadContext;
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
            }
            )
        List<String> expectedIndices = expectedDs.getIndices().stream().map(im -> im.getIndex().getName()).collect(Collectors.toList());
            tuple(dataStreamNames[2], randomIntBetween(1, 3))
 */
    public void testResolveIndicesWithWriteIndexOnlyAndDataStreamAndIndex() {
        parsedPutMappingRequest.source(originalBytes, xContentType);
import static org.hamcrest.Matchers.containsString;
 * Licensed to Elasticsearch under one or more contributor
        );
        );
            List.of(
 *
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", false))),
    private static PutMappingRequest createTestItem() throws IOException {
    }
        String actualRequestBody = Strings.toString(MediaTypeRegistry.JSON, request);
     * Test that {@link PutMappingRequest#simpleMapping(String...)}
        ).concreteIndicesAsArray();
        );
        );
import org.opensearch.core.xcontent.XContentBuilder;
 * The OpenSearch Contributors require contributions made to
        boolean humanReadable = randomBoolean();
        cs = addAliases(
 * GitHub history for details.
        Index[] indices = TransportPutMappingAction.resolveIndices(
        IllegalArgumentException e = expectThrows(
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * is a write alias for that index. See usage examples above.
        mapping.endObject();
                builder.put(IndexMetadata.builder(im).putAlias(newAliasMd));
        r.source("somevalidmapping", MediaTypeRegistry.JSON);
import org.opensearch.index.RandomCreateIndexGenerator;
 * this file be licensed under the Apache-2.0 license or a
    /**
 * SPDX-License-Identifier: Apache-2.0
            cs,
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
        IndexAbstraction expectedDs = cs.metadata().getIndicesLookup().get("foo");
        // should resolve the data stream and each alias to _all_ their respective indices
 * Modifications Copyright OpenSearch Contributors. See
