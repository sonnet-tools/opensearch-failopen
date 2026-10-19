        Metadata loadedMetadata;  
 *  
        if (randomBoolean()) {  
import org.opensearch.cluster.metadata.DataStream;
                .collect(Collectors.toList())
    @Override  
        int numDelIndices = randomIntBetween(0, 5);
            Stream.of(ClusterModule.getNamedXWriteables().stream(), IndicesModule.getNamedXContents().stream())  
        builder.startObject();
            assertNotNull(loadedMetadata.custom(IndexGraveyard.TYPE));
        builder.endObject();
import org.opensearch.common.UUIDs;  
        );  
import org.opensearch.cluster.metadata.IndexGraveyard;  
import java.util.stream.Stream;  
 */  
                // check that we reserialize unknown metadata correctly again
 * under the License.  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.test.OpenSearchTestCase;
            loadedMetadata = Metadata.fromXContent(parser);
        // make sure the index tombstones are the same too
        mdBuilder.generateClusterUuidIfNeeded();  
 * compatible open source license.
 *
import java.util.List;  
            XContentParser parser = createParser(
        return mdBuilder.build();  
import org.opensearch.core.xcontent.XContentBuilder;
        final IndexGraveyard.Builder graveyard = IndexGraveyard.builder();
 */  
        assertThat(loadedMetadata.clusterUUID(), not(equalTo("_na_")));
                Metadata.FORMAT.write(loadedMetadata, tempdir);
import java.util.stream.Collectors;
 * license agreements. See the NOTICE file distributed with
        ) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Metadata.FORMAT.toXContent(builder, latestMetadata);  
 * Licensed to Elasticsearch under one or more contributor  
                mdBuilder.put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(backingIndex.getIndex())));
                String dataStreamName = "name" + 1;  
        assertThat(loadedMetadata.clusterUUID(), equalTo(latestMetadata.clusterUUID()));
import static org.hamcrest.Matchers.instanceOf;
                BytesReference.bytes(builder)
    private Metadata randomMeta() {
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.IndexMetadata;
    }
                .flatMap(Function.identity())
package org.opensearch.cluster.coordination;
import java.util.function.Function;
    private void runLoadStateTest(boolean hasMissingCustoms, boolean preserveUnknownCustoms) throws IOException {
import java.nio.file.Path;
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(loadedMetadata.custom(IndexGraveyard.TYPE), instanceOf(OpenSearchNodeCommand.UnknownMetadataCustom.class));
        mdBuilder.indexGraveyard(graveyard.build());
        for (int i = 0; i < numDelIndices; i++) {  
        runLoadStateTest(true, false);
            for (int i = 0; i < numDataStreams; i++) {
        return new NamedXContentRegistry(
            graveyard.addTombstone(new Index(randomAlphaOfLength(10) + "del-idx-" + i, UUIDs.randomBase64UUID()));
                JsonXContent.jsonXContent,
import org.opensearch.cluster.metadata.Metadata;
 * not use this file except in compliance with the License.
            }  
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;  
 * this work for additional information regarding copyright
        runLoadStateTest(false, false);
            }
    protected NamedXContentRegistry xContentRegistry() {
import org.opensearch.indices.IndicesModule;
 * Unless required by applicable law or agreed to in writing,
        }  
import org.opensearch.cluster.ClusterModule;
                final Path tempdir = createTempDir();  
 * The OpenSearch Contributors require contributions made to  
            if (preserveUnknownCustoms) {
public class OpenSearchNodeCommandTests extends OpenSearchTestCase {
 * You may obtain a copy of the License at  
import org.opensearch.core.common.bytes.BytesReference;
import java.io.IOException;
    }  
        assertThat(loadedMetadata.dataStreams(), equalTo(latestMetadata.dataStreams()));  
    }
 * GitHub history for details.
        final XContentBuilder builder = JsonXContent.contentBuilder();
 * software distributed under the License is distributed on an
        }
    public void testLoadStateWithoutMissingCustoms() throws IOException {
                assertThat(reloadedMetadata.indexGraveyard(), equalTo(latestMetadata.indexGraveyard()));  
/*
        }
        final Metadata latestMetadata = randomMeta();  
                final Metadata reloadedMetadata = Metadata.FORMAT.loadLatestState(logger, xContentRegistry(), tempdir);
import static org.hamcrest.Matchers.not;  
import static org.hamcrest.Matchers.equalTo;
        }
        } else {
    public void testLoadStateWithoutMissingCustomsButPreserved() throws IOException {
            )  
/*  
        if (hasMissingCustoms) {  
        runLoadStateTest(false, true);  
    }  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 *
}
                IndexMetadata backingIndex = createFirstBackingIndex(dataStreamName).build();
        Metadata.Builder mdBuilder = Metadata.builder();
/*  
import org.opensearch.core.index.Index;  
            assertThat(loadedMetadata.indexGraveyard(), equalTo(latestMetadata.indexGraveyard()));  
    public void testLoadStateWithMissingCustomsButPreserved() throws IOException {  
 * specific language governing permissions and limitations
    public void testLoadStateWithMissingCustomsAndNotPreserved() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    }
 * SPDX-License-Identifier: Apache-2.0
            int numDataStreams = randomIntBetween(0, 5);
        runLoadStateTest(true, true);
                hasMissingCustoms ? OpenSearchNodeCommand.namedXContentRegistry : xContentRegistry(),  
import static org.opensearch.cluster.DataStreamTestHelper.createFirstBackingIndex;
import org.opensearch.common.xcontent.json.JsonXContent;
 * ownership. Elasticsearch licenses this file to you under  
        try (
