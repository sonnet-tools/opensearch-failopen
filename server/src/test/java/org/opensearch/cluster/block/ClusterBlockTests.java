 * this work for additional information regarding copyright
        assertThat(clusterBlocks.hasIndexBlockWithId("index-1", 2), is(true));
        assertThat(clusterBlocks.indices().get("index-2").size(), equalTo(1));  
        assertThat(clusterBlocks.hasIndexBlockWithId("index-1", 2), is(true));
        assertThat(actual.description(), equalTo(expected.description()));
        builder.addIndexBlock("index-1", new ClusterBlock(1, "uuid", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL)));  
            ClusterBlock clusterBlock = randomClusterBlock();
    }
            copyOf(randomSubsetOf(randomIntBetween(1, levels.size()), levels))
        assertThat(builder.build().indices().get("index").size(), equalTo(clusterBlocks.length));
            randomInt(),
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(clusterBlocks.hasIndexBlockWithId("index-1", 1), is(true));  
        }
            "index-1",
        clusterBlocks = builder.build();  
        assertThat(clusterBlocks.hasIndexBlockWithId("index-2", 3), is(true));  
 * the Apache License, Version 2.0 (the "License"); you may
            clusterBlock.writeTo(out);
 * KIND, either express or implied.  See the License for the
        clusterBlocks = builder.build();  
    public void testRemoveIndexBlockWithId() {
        assertThat(actual.uuid(), equalTo(expected.uuid()));  
        for (int i = 0; i < iterations; i++) {
/*  
            Version version = randomVersion(random());  
import java.util.Arrays;
        assertThat(clusterBlocks.hasIndexBlockWithId("index-2", 3), is(false));  
 */
import static java.util.EnumSet.copyOf;
            randomFrom(RestStatus.values()),
            out.setVersion(version);
        assertThat(clusterBlocks.indices().get("index-2").size(), equalTo(1));
        assertThat(clusterBlock.toString(), not(endsWith(",")));
        builder.addIndexBlock(  
}
    }  
        assertThat(clusterBlocks.indices().get("index-2"), nullValue());
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.io.stream.BytesStreamOutput;  
            in.setVersion(version);
        assertThat(actual.retryable(), equalTo(expected.retryable()));  
        assertThat(actual.id(), equalTo(expected.id()));
        assertThat(builder.build().getIndexBlockWithId("index", blockId), is(oneOf(clusterBlocks)));
        assertEquals(expected, actual);
    private void assertClusterBlockEquals(final ClusterBlock expected, final ClusterBlock actual) {  
import org.opensearch.test.OpenSearchTestCase;  
    public void testGlobalBlocksCheckedIfNoIndicesSpecified() {
        assertNotNull(exception);  
        ClusterBlocks clusterBlocks = builder.build();
            "cluster block #" + randomInt(),  
 * Modifications Copyright OpenSearch Contributors. See
    }
 */  
        return new ClusterBlock(  
import static org.hamcrest.Matchers.oneOf;
            clusterBlocks[i] = new ClusterBlock(blockId, "uuid" + i, "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL));  
        final String uuid = randomBoolean() ? UUIDs.randomBase64UUID() : null;
import static org.hamcrest.Matchers.nullValue;
import java.util.Map;
            StreamInput in = out.bytes().streamInput();
 * GitHub history for details.
            randomBoolean(),
/*
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.VersionUtils.randomVersion;
            randomBoolean(),  
 */  
    public void testSerialization() throws Exception {  
    public void testToStringDanglingComma() {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.UUIDs;
    public static ClusterBlock randomClusterBlock() {  
        assertThat(clusterBlocks.indices().get("index-1").size(), equalTo(2));
        for (int i = 0; i < clusterBlocks.length; i++) {
        }  
            ClusterBlock result = new ClusterBlock(in);  
/*  
            builder.addIndexBlock("index", clusterBlocks[i]);
 *
        assertThat(clusterBlocks.indices().get("index-1").size(), equalTo(2));
    }
        );  
import org.opensearch.Version;
        assertThat(clusterBlocks.hasIndexBlockWithId("index-1", 1), is(true));  
 *
import static org.hamcrest.CoreMatchers.not;
    public void testGetIndexBlockWithId() {  
import static org.hamcrest.CoreMatchers.equalTo;
            new ClusterBlock(3, "other uuid", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL))
 *  
import java.util.List;
            assertClusterBlockEquals(clusterBlock, result);
import org.opensearch.core.rest.RestStatus;
        assertThat(actual.disableStatePersistence(), equalTo(expected.disableStatePersistence()));
        final int blockId = randomInt();
import static org.hamcrest.CoreMatchers.endsWith;  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(clusterBlocks.indices().get("index-1").size(), equalTo(4));
 *     http://www.apache.org/licenses/LICENSE-2.0
        final ClusterBlocks.Builder builder = ClusterBlocks.builder();
        assertEquals(exception.blocks(), Collections.singleton(globalBlock));
            BytesStreamOutput out = new BytesStreamOutput();  
package org.opensearch.cluster.block;
 * not use this file except in compliance with the License.
        final ClusterBlock clusterBlock = randomClusterBlock();
        builder.removeIndexBlockWithId("index-1", 3);
        int iterations = randomIntBetween(5, 20);
        ClusterBlock globalBlock = randomClusterBlock();  
        ClusterBlocks clusterBlocks = new ClusterBlocks(Collections.singleton(globalBlock), Map.of());
            randomBoolean(),
        builder.addIndexBlock("index-1", new ClusterBlock(2, "uuid", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL)));
        final ClusterBlocks.Builder builder = ClusterBlocks.builder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        builder.addIndexBlock("index-1", new ClusterBlock(3, "uuid", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL)));
 * specific language governing permissions and limitations
 * under the License.  
    }
 * compatible open source license.
    }
 * You may obtain a copy of the License at  
        builder.addIndexBlock("index-2", new ClusterBlock(3, "uuid3", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL)));
        );  
    }  
 * software distributed under the License is distributed on an
import java.util.Collections;  
import static org.hamcrest.Matchers.is;  
 * Unless required by applicable law or agreed to in writing,
public class ClusterBlockTests extends OpenSearchTestCase {
        assertArrayEquals(actual.levels().toArray(), expected.levels().toArray());
        final List<ClusterBlockLevel> levels = Arrays.asList(ClusterBlockLevel.values());
            uuid,
        assertThat(builder.build().getIndexBlockWithId("index", randomValueOtherThan(blockId, OpenSearchTestCase::randomInt)), nullValue());  
        ClusterBlockException exception = clusterBlocks.indicesBlockedException(randomFrom(globalBlock.levels()), new String[0]);
        builder.removeIndexBlockWithId("index-2", 3);
 * The OpenSearch Contributors require contributions made to  
        assertThat(actual.status(), equalTo(expected.status()));
        final ClusterBlock[] clusterBlocks = new ClusterBlock[randomIntBetween(1, 5)];
