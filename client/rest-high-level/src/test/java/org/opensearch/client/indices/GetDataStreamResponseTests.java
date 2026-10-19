import org.opensearch.cluster.health.ClusterHealthStatus;
 * compatible open source license.
import static org.opensearch.cluster.metadata.DataStream.getDefaultBackingIndexName;
        for (int i = 0; i < numIndices; i++) {
 *  
 * Unless required by applicable law or agreed to in writing,
            dataStreams.add(randomInstance());
 * ownership. Elasticsearch licenses this file to you under  
/*
        for (int i = 0; i < count; i++) {  
 * Licensed to Elasticsearch under one or more contributor  
            assertEquals(server.getGeneration(), client.getGeneration());
/*  
            assertEquals(server.getName(), client.getName());
        int count = randomInt(10);
import org.opensearch.common.UUIDs;  
import org.opensearch.core.index.Index;
        }
    }  
import java.util.List;
 */  
 * The OpenSearch Contributors require contributions made to  
            assertEquals(server.getTimeStampField().getName(), client.getTimeStampField());
 * software distributed under the License is distributed on an
    }
import org.opensearch.cluster.metadata.DataStream;
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, generation), UUIDs.randomBase64UUID(random())));  
        return GetDataStreamResponse.fromXContent(parser);
    }
        }  
            org.opensearch.client.indices.DataStream client = clientIt.next();  
 *
import java.util.Iterator;
        long generation = indices.size() + randomLongBetween(1, 128);
/*  
import java.io.IOException;
 *
 * not use this file except in compliance with the License.
    protected GetDataStreamResponse doParseToClientInstance(XContentParser parser) throws IOException {
            assertEquals(server.getIndices().stream().map(Index::getName).collect(Collectors.toList()), client.getIndices());  
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
        List<Index> indices = new ArrayList<>(numIndices);
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
import java.util.ArrayList;  
import org.opensearch.core.xcontent.XContentParser;  
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
        return new GetDataStreamAction.Response(dataStreams);  
import org.opensearch.common.xcontent.XContentType;
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction.Response.DataStreamInfo;
    @Override
import java.util.stream.Collectors;
 * SPDX-License-Identifier: Apache-2.0
        return new DataStreamInfo(dataStream, ClusterHealthStatus.YELLOW, randomAlphaOfLengthBetween(2, 10));
package org.opensearch.client.indices;
public class GetDataStreamResponseTests extends AbstractResponseTestCase<GetDataStreamAction.Response, GetDataStreamResponse> {  
    @Override
 */
        int numIndices = randomIntBetween(0, 128);  
    private static DataStreamInfo randomInstance() {
 * under the License.  
        Iterator<DataStreamInfo> serverIt = serverTestInstance.getDataStreams().iterator();
    protected void assertInstances(GetDataStreamAction.Response serverTestInstance, GetDataStreamResponse clientInstance) {  
import java.util.Locale;  
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        return indices;
        }
 */  
}
        assertEquals(serverTestInstance.getDataStreams().size(), clientInstance.getDataStreams().size());
        while (serverIt.hasNext()) {
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
        ArrayList<DataStreamInfo> dataStreams = new ArrayList<>();
    private static List<Index> randomIndexInstances() {
    }  
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            indices.add(new Index(randomAlphaOfLength(10).toLowerCase(Locale.ROOT), UUIDs.randomBase64UUID(random())));  
        List<Index> indices = randomIndexInstances();  
 * specific language governing permissions and limitations
    protected GetDataStreamAction.Response createServerTestInstance(XContentType xContentType) {  
    }  
        DataStream dataStream = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, generation);
import org.opensearch.client.AbstractResponseTestCase;  
            DataStream server = serverIt.next().getDataStream();
        Iterator<org.opensearch.client.indices.DataStream> clientIt = clientInstance.getDataStreams().iterator();
