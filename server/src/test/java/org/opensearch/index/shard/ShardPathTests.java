        Exception e = expectThrows(IllegalArgumentException.class, () -> new ShardPath(true, path, path, new ShardId(index, 0)));
                    }
                    break;
            writeShardStateMetadata("0xDEADBEEF", path);
            assertThat(e.getMessage(), containsString("expected: foobar on shard path"));
            nodeSettings = Settings.EMPTY;
                }
            Exception e = expectThrows(IllegalStateException.class, () -> ShardPath.loadShardPath(logger, env, shardId, ""));
        }
/*
        final Settings nodeSettings;
 * You may obtain a copy of the License at
        boolean useCustomDataPath = randomBoolean();
import org.opensearch.gateway.WriteStateException;
public class ShardPathTests extends OpenSearchTestCase {
            ShardPath shardPath = ShardPath.loadFileCachePath(env, shardId);
    public void testLoadShardPath() throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        Settings searchNodeSettings = Settings.builder().put("node.roles", "search").build();
 *
            Path path = randomFrom(paths);
            customDataPath = "custom";
        final String indexUUID = "0xDEADBEEF";
 *
    public void testIllegalCustomDataPath() {
        final Path customPath;
        } else {
            Path[] paths = env.availableShardPaths(shardId);
                        break;
                assertNotEquals(shardPath.getRootDataPath(), shardPath.getRootStatePath());
    public void testGetRootPaths() throws IOException {
    private static void writeShardStateMetadata(String indexUUID, Path... paths) throws WriteStateException {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.index.Index;
            Path[] paths = env.availableShardPaths(shardId);
}
        try (NodeEnvironment env = newNodeEnvironment(Settings.builder().build())) {
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
            } else {
        Index index = new Index("foo", "foo");
            for (Path p : env.nodeDataPaths()) {
        assertEquals(shardPath.getDataPath(), path);
            }
import org.opensearch.test.OpenSearchTestCase;
            customPath = null;
        ShardStateMetadata.FORMAT.writeAndCleanup(
            if (useCustomDataPath) {
            writeShardStateMetadata("0xDEADBEEF", fileCachePath);
        );
            assertTrue(shardPath.getDataPath().startsWith(fileCachePath));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Modifications Copyright OpenSearch Contributors. See
    }
                assertEquals(customPath, shardPath.getRootDataPath());
            assertEquals(path, shardPath.getDataPath());
                if (p.equals(shardPath.getRootStatePath())) {
import java.nio.file.Path;
            Path path = randomFrom(paths);
                    if (p.equals(shardPath.getRootDataPath())) {
 * this file be licensed under the Apache-2.0 license or a
            final String indexUUID = "0xDEADBEEF";
import static org.opensearch.env.Environment.PATH_SHARED_DATA_SETTING;
 * under the License.
            ShardId shardId = new ShardId("foo", indexUUID, 0);
 * SPDX-License-Identifier: Apache-2.0
        if (useCustomDataPath) {
            Path fileCachePath = env.fileCacheNodePath().fileCachePath;
        assertFalse(shardPath.isCustomDataPath());
 * this work for additional information regarding copyright
 */
            Path[] paths = env.availableShardPaths(shardId);
            Path[] paths = env.availableShardPaths(shardId);
                assertNull(customPath);
 * license agreements. See the NOTICE file distributed with
    }
                        found = true;
    }
            writeShardStateMetadata(indexUUID, path);
import org.opensearch.common.settings.Settings;
                assertTrue("root state paths must be a node path but wasn't: " + shardPath.getRootDataPath(), found);
        try (NodeEnvironment env = newNodeEnvironment(searchNodeSettings)) {
            assertEquals("0xDEADBEEF", shardPath.getShardId().getIndex().getUUID());
            assertEquals("0xDEADBEEF", shardPath.getShardId().getIndex().getUUID());
 * specific language governing permissions and limitations
        assertEquals(shardPath.getShardStatePath(), path);
    }
            ShardId shardId = new ShardId("foo", "foobar", 0);
    public void testFailLoadShardPathIndexUUIDMissmatch() throws IOException {
            }
    public void testFailLoadShardPathOnMultiState() throws IOException {
            paths
import static org.hamcrest.Matchers.containsString;
                for (Path p : env.nodeDataPaths()) {
        final String customDataPath;
            assertEquals(path.resolve("index"), shardPath.resolveIndex());
 */
        Index index = new Index("foo", "foo");
    }
            ShardId shardId = new ShardId("foo", indexUUID, 0);
            ShardId shardId = new ShardId("foo", "0xDEADBEEF", 0);
            assertEquals(path.resolve("translog"), shardPath.resolveTranslog());
            Exception e = expectThrows(IllegalStateException.class, () -> ShardPath.loadShardPath(logger, env, shardId, ""));
import org.opensearch.cluster.routing.AllocationId;
                    found = true;
package org.opensearch.index.shard;
        final Path path = createTempDir().resolve(index.getUUID()).resolve("0");
            new ShardStateMetadata(true, indexUUID, AllocationId.newInitializing(), ShardStateMetadata.IndexDataLocation.LOCAL),
            customDataPath = "";
        try (NodeEnvironment env = newNodeEnvironment(Settings.builder().build())) {
            ShardId shardId = new ShardId("foo", "0xDEADBEEF", 0);
            assertEquals("foo", shardPath.getShardId().getIndexName());
/*
import org.opensearch.env.NodeEnvironment;
            ShardPath shardPath = ShardPath.loadShardPath(logger, env, shardId, "");
        }
            writeShardStateMetadata("0xDEADBEEF", path);
    }
            nodeSettings = Settings.builder().put(PATH_SHARED_DATA_SETTING.getKey(), path.toAbsolutePath().toAbsolutePath()).build();
 * the Apache License, Version 2.0 (the "License"); you may
            found = false;
 *
        final Path path = createTempDir().resolve(index.getUUID()).resolve("0");
 * GitHub history for details.
    public void testLoadFileCachePath() throws IOException {
        }
 * not use this file except in compliance with the License.
        try (NodeEnvironment env = newNodeEnvironment(Settings.builder().build())) {
            assertFalse(shardPath.getShardStatePath().startsWith(fileCachePath));
    public void testValidCtor() {
            boolean found = false;
 * KIND, either express or implied.  See the License for the
            Path path = randomFrom(paths);
import java.io.IOException;
/*
            assertTrue("root state paths must be a node path but wasn't: " + shardPath.getRootStatePath(), found);
            assertThat(e.getMessage(), containsString("more than one shard state found"));
            ShardPath shardPath = ShardPath.loadShardPath(logger, env, shardId, customDataPath);
        }
        ShardPath shardPath = new ShardPath(false, path, path, new ShardId(index, 0));
        }
        assertThat(e.getMessage(), is("shard state path must be different to the data path when using custom data paths"));
import org.opensearch.core.index.shard.ShardId;
        }
                }
            final Path path = createTempDir();
            customPath = path.resolve("custom").resolve("0");
 */
            assertEquals("foo", shardPath.getShardId().getIndexName());
            writeShardStateMetadata(indexUUID, paths);
        try (NodeEnvironment env = newNodeEnvironment(nodeSettings)) {
import static org.hamcrest.Matchers.is;
 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
            assumeTrue("This test tests multi data.path but we only got one", paths.length > 1);
    }
