        List<String> indexNames = Arrays.stream(indices).map(Index::getName).collect(Collectors.toList());
            cs,
        r.setConcreteIndex(new Index("foo", "bar"));  
     */
package org.opensearch.action.admin.indices.mapping.put;
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", true))),
        PutMappingRequest request = new PutMappingRequest(index);  
            cs,
            cs,  
                builder.put(IndexMetadata.builder(im).putAlias(newAliasMd));  
        PutMappingRequest r = new PutMappingRequest("myindex");  
    }
            cs,
        List<Tuple<String, Integer>> dsMetadata = List.of(  
    }
    public void testResolveIndicesWithWriteIndexOnlyAndNoSingleWriteIndex() {
        );
        assertNotNull("source validation should fail", ex);
import org.opensearch.cluster.metadata.Metadata;
            cs,
 * this file be licensed under the Apache-2.0 license or a
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),  
     * paired correctly
    /**
        assertThat(e.getMessage(), containsString("The index expression [*] and options provided did not point to a single write-index"));
        IllegalArgumentException e = expectThrows(  
        List<String> expectedIndices = expectedDs.getIndices().stream().map(im -> im.getIndex().getName()).collect(Collectors.toList());
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));
        assertMappingsEqual(putMappingRequest.source(), parsedPutMappingRequest.source());
        ) {
            for (Tuple<String, Boolean> index : alias.v2()) {  
            request,
     * Returns a random {@link PutMappingRequest}.
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamRequestTests;
            )
    private void assertMappingsEqual(String expected, String actual) throws IOException {
        IndexAbstraction expectedDs = cs.metadata().getIndicesLookup().get("foo");  
import org.opensearch.core.index.Index;
        Index[] indices = TransportPutMappingAction.resolveIndices(
        assertThat(e.getMessage(), containsString("no write index is defined for alias [alias2]"));
 *
import org.opensearch.core.common.bytes.BytesReference;  
        Metadata.Builder builder = Metadata.builder(cs.metadata());
     * Test that {@link PutMappingRequest#simpleMapping(String...)}
        List<Tuple<String, Integer>> dsMetadata = List.of(  
        );
            tuple(dataStreamNames[2], randomIntBetween(1, 3))  
        );
    }  
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", true))),
        String[] dataStreamNames = { "foo", "bar", "baz" };
/*  
        // should resolve the data stream and each alias to _all_ their respective indices  
}  
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", true)))
        request.source(RandomCreateIndexGenerator.randomMapping());
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
import static org.hamcrest.Matchers.containsString;
 * You may obtain a copy of the License at  
            request,
        final ClusterState cs2 = addAliases(
        PutMappingRequest request = new PutMappingRequest().indices("foo", "alias1", "alias2");
            IllegalArgumentException.class,
        PutMappingRequest parsedPutMappingRequest = new PutMappingRequest();
        );
            List.of(  
        mapping.startObject("email");
        mapping.endObject();
    public void testToXContent() throws IOException {
import org.opensearch.test.OpenSearchTestCase;  
        String expectedRequestBody = "{\"properties\":{\"email\":{\"type\":\"text\"}}}";  
     */
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));  
        ex = r.validate();
        assertEquals(expectedRequestBody, actualRequestBody);  
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
 */  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        expectedIndices.addAll(List.of("index1", "index2", "index3"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        String[] dataStreamNames = { "foo", "bar", "baz" };
        mapping.endObject();  
        final PutMappingRequest putMappingRequest = createTestItem();
        final XContentType xContentType = randomFrom(XContentType.values());
    public void testResolveIndicesWithWriteIndexOnlyAndAliasWithoutWriteIndex() {
        boolean humanReadable = randomBoolean();
        mapping.field("type", "text");
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
            cs,
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))  
            List.of(  
        IllegalArgumentException e = expectThrows(  
        );
import org.opensearch.core.common.Strings;
        Index[] indices = TransportPutMappingAction.resolveIndices(  
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", true)))
        );
    private static PutMappingRequest createTestItem() throws IOException {  
            cs,
    }
        request.source(mapping);  
            tuple(dataStreamNames[2], randomIntBetween(1, 3))  
     */
        ).concreteIndicesAsArray();
 *
        assertNotNull("source validation should fail", ex);
 * SPDX-License-Identifier: Apache-2.0
    public void testResolveIndicesWithWriteIndexOnlyAndDataStreamsAndWriteAliases() {  
        IndexAbstraction expectedDs = cs.metadata().getIndicesLookup().get("foo");
    }
    }
        assertNull("validation should succeed", ex);
    }
        PutMappingRequest request = new PutMappingRequest("foo");  
            )  
            "Validation Failed: 1: either concrete index or unresolved indices can be set,"
        List<Tuple<String, Integer>> dsMetadata = List.of(  
import org.opensearch.common.util.concurrent.ThreadContext;
 * this work for additional information regarding copyright
    }
    private static ClusterState addAliases(ClusterState cs, List<Tuple<String, List<Tuple<String, Boolean>>>> aliases) {  
 *  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            () -> TransportPutMappingAction.resolveIndices(cs2, request, new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)))
        ).concreteIndicesAsArray();
     * Adds aliases to the supplied ClusterState instance. The aliases parameter takes of list of tuples of aliasName
import java.util.stream.Collectors;
        PutMappingRequest request = new PutMappingRequest("foo");
            }
 * Modifications Copyright OpenSearch Contributors. See
        ).concreteIndicesAsArray();  
        PutMappingRequest request = new PutMappingRequest().indices("alias2").writeIndexOnly(true);
    }
    public void testBuildFromSimplifiedDef() {  
        for (Tuple<String, List<Tuple<String, Boolean>>> alias : aliases) {
        List<Tuple<String, Integer>> dsMetadata = List.of(
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
 */  
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", false))),
            assertEquals(expectedJson.mapOrdered(), actualJson.mapOrdered());
        assertEquals(expectedRequestBody, actualRequestBody);
    /**  
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
    public void testToAndFromXContent() throws IOException {  
        );  
                IndexMetadata im = builder.get(index.v1());
        r.source("somevalidmapping", MediaTypeRegistry.JSON);
        String[] dataStreamNames = { "foo", "bar", "baz" };
    }
 * not use this file except in compliance with the License.
        // should resolve the data stream and each alias to _all_ their respective indices  
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
 */
        String index = randomAlphaOfLength(5);
            List.of(  
 * Unless required by applicable law or agreed to in writing,
     * to the alias's indices. The alias's indices are a tuple of index name and a flag indicating whether the alias  
        assertNotNull("source validation should fail", ex);  
        );  
            List.of(
 * compatible open source license.
     * rejects inputs where the {@code Object...} varargs of field name and properties are not  
        return request;  
        assertThat(indexNames, containsInAnyOrder(expectedDs.getWriteIndex().getIndex().getName(), "index3"));
        PutMappingRequest request = new PutMappingRequest().indices("*").writeIndexOnly(true);
public class PutMappingRequestTests extends OpenSearchTestCase {  
    }
            request,
    /**
        List<String> expectedIndices = expectedDs.getIndices().stream().map(im -> im.getIndex().getName()).collect(Collectors.toList());
    public void testResolveIndicesWithoutWriteIndexOnlyAndDataStreamsAndWriteAliases() {
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", true))),
        );  
        Index[] indices = TransportPutMappingAction.resolveIndices(  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * is a write alias for that index. See usage examples above.
    public void testResolveIndicesWithWriteIndexOnlyAndDataStreamAndIndex() {
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", true)))
import org.opensearch.cluster.ClusterState;  
    public void testToXContentWithEmptySource() throws IOException {
/*
    public void testValidation() {
 * software distributed under the License is distributed on an
        assertTrue(ex.getMessage().contains("source is empty"));  
import static org.opensearch.common.collect.Tuple.tuple;
        cs = addAliases(  
        assertTrue(ex.getMessage().contains("source is missing"));
        // should resolve the data stream and each alias to their respective write indices  
import java.util.List;
        assertEquals("mapping source must be pairs of fieldnames and properties definition.", e.getMessage());
                AliasMetadata newAliasMd = AliasMetadata.newAliasMetadataBuilder(alias.v1()).writeIndex(index.v2()).build();
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
        String[] dataStreamNames = { "foo", "bar", "baz" };
        return ClusterState.builder(cs).metadata(builder.build()).build();  
        List<Tuple<String, Integer>> dsMetadata = List.of(  
    }
            )  
        );  
import org.opensearch.cluster.metadata.AliasMetadata;
        );
            ex.getMessage(),
        String actualRequestBody = Strings.toString(MediaTypeRegistry.JSON, request);
                + " concrete index: [[foo/bar]] and indices: [myindex];"  
        String expectedRequestBody = "{}";
        ex = r.validate();  
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));  
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
            )  
        }  
        mapping.endObject();
            XContentParser actualJson = createParser(MediaTypeRegistry.JSON.xContent(), actual)  
            XContentParser expectedJson = createParser(MediaTypeRegistry.JSON.xContent(), expected);
import org.opensearch.cluster.metadata.IndexAbstraction;
import org.opensearch.index.RandomCreateIndexGenerator;
        assertThat(indexNames, containsInAnyOrder(expectedIndices.toArray()));
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.xcontent.XContentType;  
            )  
import static org.hamcrest.Matchers.containsInAnyOrder;  
            List.of(  
        try (
import org.opensearch.core.xcontent.XContentBuilder;  
        assertThat(indexNames, containsInAnyOrder(expectedDs.getWriteIndex().getIndex().getName(), "index2", "index3"));
        List<String> indexNames = Arrays.stream(indices).map(Index::getName).collect(Collectors.toList());
            IllegalArgumentException.class,
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
        }
        cs = addAliases(
            tuple(dataStreamNames[2], randomIntBetween(1, 3))  
        r.source("", MediaTypeRegistry.JSON);  
import java.util.Arrays;  
        XContentBuilder mapping = JsonXContent.contentBuilder().startObject();
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
            tuple(dataStreamNames[1], randomIntBetween(1, 3)),
/*  
        mapping.startObject("properties");  
import org.opensearch.common.xcontent.json.JsonXContent;
        );
            tuple(dataStreamNames[2], randomIntBetween(1, 3))
import org.opensearch.common.settings.Settings;
        PutMappingRequest request = new PutMappingRequest().indices("foo", "index3").writeIndexOnly(true);
            tuple(dataStreamNames[2], randomIntBetween(1, 3))  
        PutMappingRequest request = new PutMappingRequest().indices("foo", "alias1", "alias2").writeIndexOnly(true);
            () -> TransportPutMappingAction.resolveIndices(cs2, request, new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)))
            tuple(dataStreamNames[0], randomIntBetween(1, 3)),
        List<String> indexNames = Arrays.stream(indices).map(Index::getName).collect(Collectors.toList());
 * under the License.  
        parsedPutMappingRequest.source(originalBytes, xContentType);  
import org.opensearch.cluster.metadata.IndexMetadata;  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        expectedIndices.addAll(List.of("index1", "index2", "index3"));
    }  
        );
        ex = r.validate();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PutMappingRequest.simpleMapping("only_field"));
import org.opensearch.common.collect.Tuple;  
        ClusterState cs = DeleteDataStreamRequestTests.getClusterStateWithDataStreams(dsMetadata, List.of("index1", "index2", "index3"));  
        ActionRequestValidationException ex = r.validate();
        IndexAbstraction expectedDs = cs.metadata().getIndicesLookup().get("foo");  
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", true)))
        String[] dataStreamNames = { "foo", "bar", "baz" };
                tuple("alias1", List.of(tuple("index1", false), tuple("index2", true))),  
import org.opensearch.action.ActionRequestValidationException;
        final ClusterState cs2 = addAliases(
        cs = addAliases(
        assertEquals(  
        BytesReference originalBytes = toShuffledXContent(putMappingRequest, xContentType, EMPTY_PARAMS, humanReadable);  
        String actualRequestBody = Strings.toString(MediaTypeRegistry.JSON, request);
                tuple("alias2", List.of(tuple("index2", false), tuple("index3", false)))
            cs,
import java.io.IOException;
