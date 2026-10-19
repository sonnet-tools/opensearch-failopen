            + "        \""
            + "        \"enabled\": true,\n"
    public static DataStream.TimestampField createTimestampField(String fieldName) {  
            indices.add(new Index(randomAlphaOfLength(10).toLowerCase(Locale.ROOT), UUIDs.randomBase64UUID(LuceneTestCase.random())));
            .numberOfReplicas(NUMBER_OF_REPLICAS);
     * @param indexNames  The names of indices to create that do not back any data streams
                createTimestampField("@timestamp"),
            .numberOfReplicas(NUMBER_OF_REPLICAS);  
    public static IndexMetadata.Builder createFirstBackingIndex(String dataStreamName) {  
    public static IndexMetadata.Builder createBackingIndex(String dataStreamName, int generation) {
        int numIndices = OpenSearchTestCase.randomIntBetween(0, 128);
            DataStream ds = new DataStream(
 *  
    public static IndexMetadata.Builder getIndexMetadataBuilderForIndex(Index index) {
    public static String generateMapping(String timestampFieldName, String type) {
    }
    private static final Settings.Builder SETTINGS = OpenSearchTestCase.settings(Version.CURRENT).put("index.hidden", true);
            + "      \"_data_stream_timestamp\": {\n"
        }  
    private static IndexMetadata createIndexMetadata(String name, boolean hidden) {
            + "\": {\n"
            );
    public static List<Index> randomIndexInstances() {
            .numberOfShards(NUMBER_OF_SHARDS)
        List<Index> indices = new ArrayList<>(numIndices);  
        return createBackingIndex(dataStreamName, 1);
 */
        }
 *
}
 * this work for additional information regarding copyright
        return indices;
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLength;
        return IndexMetadata.builder(DataStream.getDefaultBackingIndexName(dataStreamName, generation))
        return new DataStream.TimestampField(fieldName);
    }
     * @param dataStreams The names of the data streams to create with their respective number of backing indices  
            + "      \"properties\": {\n"
            allIndices.add(createIndexMetadata(indexName, false));  
     * Constructs {@code ClusterState} with the specified data streams and indices.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.metadata.IndexMetadata;
 */  
                dsTuple.v2()  
            builder.put(index, false);
                dsTuple.v1(),  
 * under the License.  
            + timestampFieldName  
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        return IndexMetadata.builder(name).settings(b).numberOfShards(1).numberOfReplicas(1).build();
/*  
            .settings(Settings.builder().put(SETTINGS.build()).put(SETTING_INDEX_UUID, index.getUUID()))
import java.util.ArrayList;  
            List<IndexMetadata> backingIndices = new ArrayList<>();
        Settings.Builder b = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put("index.hidden", hidden);
            + type  
import org.opensearch.core.index.Index;  
import org.opensearch.cluster.metadata.DataStream;  
            + "        \"timestamp_field\": { \"name\": \""  
            + "\" }"
    }  
        }
        return new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, generation);  
        for (int i = 0; i < numIndices; i++) {
        Metadata.Builder builder = Metadata.builder();
            + "      },"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "          \"type\": \""
                backingIndices.add(createIndexMetadata(getDefaultBackingIndexName(dsTuple.v1(), backingIndexNumber), true));
 */  
import org.opensearch.common.UUIDs;  
            for (int backingIndexNumber = 1; backingIndexNumber <= dsTuple.v2(); backingIndexNumber++) {  
import org.opensearch.cluster.metadata.Metadata;
        for (IndexMetadata index : allIndices) {  
            .numberOfShards(NUMBER_OF_SHARDS)
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
/*
        for (String indexName : indexNames) {
            allIndices.addAll(backingIndices);  
    public static DataStream randomInstance() {
 * KIND, either express or implied.  See the License for the
        return ClusterState.builder(new ClusterName("_name")).metadata(builder).build();
    }
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, generation), UUIDs.randomBase64UUID(LuceneTestCase.random())));
import static org.opensearch.cluster.metadata.DataStream.getDefaultBackingIndexName;
    private static final int NUMBER_OF_SHARDS = 1;  
     */
import org.opensearch.common.collect.Tuple;
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;  
        List<IndexMetadata> allIndices = new ArrayList<>();  
 * ownership. Elasticsearch licenses this file to you under  
            .settings(SETTINGS)  
            }
import org.opensearch.Version;
            + "        }\n"
 * software distributed under the License is distributed on an
     *
import org.opensearch.test.OpenSearchTestCase;
import java.util.stream.Collectors;  
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "      }\n"  
        }  
 * Modifications Copyright OpenSearch Contributors. See
    private static final int NUMBER_OF_REPLICAS = 1;
        List<Index> indices = randomIndexInstances();
            + "    }";
 * the Apache License, Version 2.0 (the "License"); you may
        return IndexMetadata.builder(index.getName())  
 * GitHub history for details.
        long generation = indices.size() + OpenSearchTestCase.randomLongBetween(1, 128);  
import org.apache.lucene.tests.util.LuceneTestCase;
        return "{\n"  
package org.opensearch.cluster;
 * SPDX-License-Identifier: Apache-2.0
    }
            builder.put(ds);
 * not use this file except in compliance with the License.
 * compatible open source license.
import java.util.Locale;
    }  
    public static String generateMapping(String timestampFieldName) {
 * specific language governing permissions and limitations
/*  
            + timestampFieldName
    public static ClusterState getClusterStateWithDataStreams(List<Tuple<String, Integer>> dataStreams, List<String> indexNames) {  
 *
public final class DataStreamTestHelper {  
 * this file be licensed under the Apache-2.0 license or a
    }
    }
        for (Tuple<String, Integer> dsTuple : dataStreams) {
import java.util.List;
        return generateMapping(timestampFieldName, "date");
 * You may obtain a copy of the License at  
    }
 * The OpenSearch Contributors require contributions made to  
            + "\"\n"
    /**  
                backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList()),
import org.opensearch.common.settings.Settings;
