            "index-1",
            assertClusterBlockEquals(clusterBlock, result);
        assertEquals(exception.blocks(), Collections.singleton(globalBlock));
        assertThat(builder.build().indices().get("index").size(), equalTo(clusterBlocks.length));
/*
        final String uuid = randomBoolean() ? UUIDs.randomBase64UUID() : null;
/*
        assertThat(clusterBlocks.hasIndexBlockWithId("index-1", 1), is(true));
        final ClusterBlock clusterBlock = randomClusterBlock();
 * this file be licensed under the Apache-2.0 license or a
        final int blockId = randomInt();
 * license agreements. See the NOTICE file distributed with
    }
        assertThat(clusterBlocks.hasIndexBlockWithId("index-1", 1), is(true));
            ClusterBlock result = new ClusterBlock(in);
        assertThat(builder.build().getIndexBlockWithId("index", randomValueOtherThan(blockId, OpenSearchTestCase::randomInt)), nullValue());
            out.setVersion(version);
    }
        ClusterBlocks clusterBlocks = new ClusterBlocks(Collections.singleton(globalBlock), Map.of());
            uuid,
        );
        assertThat(clusterBlocks.hasIndexBlockWithId("index-2", 3), is(false));
            StreamInput in = out.bytes().streamInput();
        }
            builder.addIndexBlock("index", clusterBlocks[i]);
        assertArrayEquals(actual.levels().toArray(), expected.levels().toArray());
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
        assertThat(actual.description(), equalTo(expected.description()));
 * compatible open source license.
import static org.hamcrest.CoreMatchers.equalTo;
            ClusterBlock clusterBlock = randomClusterBlock();
        ClusterBlock globalBlock = randomClusterBlock();
import static org.hamcrest.CoreMatchers.not;
package org.opensearch.cluster.block;
        ClusterBlockException exception = clusterBlocks.indicesBlockedException(randomFrom(globalBlock.levels()), new String[0]);
    }
            new ClusterBlock(3, "other uuid", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL))
            BytesStreamOutput out = new BytesStreamOutput();
    }
        assertThat(builder.build().getIndexBlockWithId("index", blockId), is(oneOf(clusterBlocks)));
import static org.hamcrest.CoreMatchers.endsWith;
        assertThat(clusterBlocks.indices().get("index-2").size(), equalTo(1));
    }
import static org.opensearch.test.VersionUtils.randomVersion;
import org.opensearch.common.io.stream.BytesStreamOutput;
        for (int i = 0; i < clusterBlocks.length; i++) {
        clusterBlocks = builder.build();
 * Unless required by applicable law or agreed to in writing,
            randomBoolean(),
import org.opensearch.common.UUIDs;
import static org.hamcrest.Matchers.nullValue;
        assertThat(clusterBlocks.indices().get("index-2").size(), equalTo(1));
        final ClusterBlocks.Builder builder = ClusterBlocks.builder();
 *
        builder.addIndexBlock(
 *
 * ownership. Elasticsearch licenses this file to you under
        int iterations = randomIntBetween(5, 20);
import static java.util.EnumSet.copyOf;
    }
 */
 */
        assertThat(clusterBlocks.indices().get("index-1").size(), equalTo(2));
        assertThat(clusterBlocks.hasIndexBlockWithId("index-1", 2), is(true));
import static org.hamcrest.Matchers.oneOf;
    public void testRemoveIndexBlockWithId() {
        builder.addIndexBlock("index-2", new ClusterBlock(3, "uuid3", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL)));
        builder.removeIndexBlockWithId("index-2", 3);
 *
            randomFrom(RestStatus.values()),
    private void assertClusterBlockEquals(final ClusterBlock expected, final ClusterBlock actual) {
        }
    public static ClusterBlock randomClusterBlock() {
    }
 * Licensed to Elasticsearch under one or more contributor
        assertThat(actual.status(), equalTo(expected.status()));
        builder.addIndexBlock("index-1", new ClusterBlock(2, "uuid", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL)));
        for (int i = 0; i < iterations; i++) {
        assertThat(actual.uuid(), equalTo(expected.uuid()));
        assertThat(clusterBlocks.indices().get("index-1").size(), equalTo(2));
 * software distributed under the License is distributed on an
import java.util.Collections;
        final ClusterBlocks.Builder builder = ClusterBlocks.builder();
        builder.addIndexBlock("index-1", new ClusterBlock(1, "uuid", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL)));
        assertNotNull(exception);
import java.util.List;
            "cluster block #" + randomInt(),
import java.util.Arrays;
/*
        builder.addIndexBlock("index-1", new ClusterBlock(3, "uuid", "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL)));
}
import static org.hamcrest.Matchers.is;
        assertThat(clusterBlocks.hasIndexBlockWithId("index-1", 2), is(true));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
            Version version = randomVersion(random());
 * KIND, either express or implied.  See the License for the
        assertEquals(expected, actual);
    public void testSerialization() throws Exception {
import org.opensearch.core.rest.RestStatus;
        final ClusterBlock[] clusterBlocks = new ClusterBlock[randomIntBetween(1, 5)];
            randomBoolean(),
 * under the License.
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(actual.retryable(), equalTo(expected.retryable()));
 * not use this file except in compliance with the License.
    public void testGlobalBlocksCheckedIfNoIndicesSpecified() {
import org.opensearch.Version;
        final List<ClusterBlockLevel> levels = Arrays.asList(ClusterBlockLevel.values());
        ClusterBlocks clusterBlocks = builder.build();
            in.setVersion(version);
import java.util.Map;
        builder.removeIndexBlockWithId("index-1", 3);
 * this work for additional information regarding copyright
 */
        clusterBlocks = builder.build();
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(actual.id(), equalTo(expected.id()));
 * specific language governing permissions and limitations
            clusterBlock.writeTo(out);
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(clusterBlocks.hasIndexBlockWithId("index-2", 3), is(true));
        assertThat(clusterBlocks.indices().get("index-1").size(), equalTo(4));
        assertThat(clusterBlock.toString(), not(endsWith(",")));
public class ClusterBlockTests extends OpenSearchTestCase {
    public void testToStringDanglingComma() {
            randomBoolean(),
import org.opensearch.core.common.io.stream.StreamInput;
            randomInt(),
            clusterBlocks[i] = new ClusterBlock(blockId, "uuid" + i, "", true, true, true, RestStatus.OK, copyOf(ClusterBlockLevel.ALL));
            copyOf(randomSubsetOf(randomIntBetween(1, levels.size()), levels))
        return new ClusterBlock(
        assertThat(clusterBlocks.indices().get("index-2"), nullValue());
        );
        assertThat(actual.disableStatePersistence(), equalTo(expected.disableStatePersistence()));
    public void testGetIndexBlockWithId() {
