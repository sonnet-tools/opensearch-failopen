        }
import org.opensearch.cluster.routing.AllocationId;  
        final String customDataPath;  
/*
 * The OpenSearch Contributors require contributions made to  
                }
 * this file be licensed under the Apache-2.0 license or a
        try (NodeEnvironment env = newNodeEnvironment(Settings.builder().build())) {
            assertTrue(shardPath.getDataPath().startsWith(fileCachePath));  
        Index index = new Index("foo", "foo");
                        found = true;  
            ShardId shardId = new ShardId("foo", indexUUID, 0);
            assertEquals("foo", shardPath.getShardId().getIndexName());
        try (NodeEnvironment env = newNodeEnvironment(Settings.builder().build())) {
}
        }
                assertNull(customPath);  
        final Path customPath;
            ShardId shardId = new ShardId("foo", "0xDEADBEEF", 0);  
            writeShardStateMetadata("0xDEADBEEF", path);  
        Index index = new Index("foo", "foo");
                if (p.equals(shardPath.getRootStatePath())) {
            assertEquals(path, shardPath.getDataPath());
 * specific language governing permissions and limitations
                    if (p.equals(shardPath.getRootDataPath())) {
 * SPDX-License-Identifier: Apache-2.0
                    break;  
package org.opensearch.index.shard;
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            customDataPath = "custom";  
        final String indexUUID = "0xDEADBEEF";
 * under the License.  
    public void testFailLoadShardPathOnMultiState() throws IOException {
            final Path path = createTempDir();
 * Modifications Copyright OpenSearch Contributors. See  
            writeShardStateMetadata("0xDEADBEEF", fileCachePath);  
        ShardStateMetadata.FORMAT.writeAndCleanup(  
    }
 */
        final Path path = createTempDir().resolve(index.getUUID()).resolve("0");
            assertTrue("root state paths must be a node path but wasn't: " + shardPath.getRootStatePath(), found);  
 * GitHub history for details.
        try (NodeEnvironment env = newNodeEnvironment(searchNodeSettings)) {  
import java.io.IOException;
        final Settings nodeSettings;  
                }  
            customPath = null;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.env.NodeEnvironment;
            ShardPath shardPath = ShardPath.loadFileCachePath(env, shardId);
            Path[] paths = env.availableShardPaths(shardId);
        assertEquals(shardPath.getShardStatePath(), path);
            boolean found = false;
            assertEquals(path.resolve("index"), shardPath.resolveIndex());  
import java.nio.file.Path;  
        if (useCustomDataPath) {
 *
import static org.opensearch.env.Environment.PATH_SHARED_DATA_SETTING;
            if (useCustomDataPath) {
/*  
            paths
                assertTrue("root state paths must be a node path but wasn't: " + shardPath.getRootDataPath(), found);
 * license agreements. See the NOTICE file distributed with
            Path path = randomFrom(paths);
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testLoadShardPath() throws IOException {
                        break;
 * the Apache License, Version 2.0 (the "License"); you may
            writeShardStateMetadata("0xDEADBEEF", path);  
            assertEquals("0xDEADBEEF", shardPath.getShardId().getIndex().getUUID());  
 */  
            ShardPath shardPath = ShardPath.loadShardPath(logger, env, shardId, "");
    public void testIllegalCustomDataPath() {  
            Path[] paths = env.availableShardPaths(shardId);
        }
            writeShardStateMetadata(indexUUID, path);  
            nodeSettings = Settings.EMPTY;  
import static org.hamcrest.Matchers.containsString;  
            assertThat(e.getMessage(), containsString("more than one shard state found"));  
    }
        boolean useCustomDataPath = randomBoolean();
            assertEquals("foo", shardPath.getShardId().getIndexName());
            new ShardStateMetadata(true, indexUUID, AllocationId.newInitializing(), ShardStateMetadata.IndexDataLocation.LOCAL),
 * not use this file except in compliance with the License.
        }  
 * software distributed under the License is distributed on an
    public void testGetRootPaths() throws IOException {
        } else {  
    public void testValidCtor() {
            nodeSettings = Settings.builder().put(PATH_SHARED_DATA_SETTING.getKey(), path.toAbsolutePath().toAbsolutePath()).build();
        Exception e = expectThrows(IllegalArgumentException.class, () -> new ShardPath(true, path, path, new ShardId(index, 0)));  
    }
            Path fileCachePath = env.fileCacheNodePath().fileCachePath;
            Path path = randomFrom(paths);
                assertNotEquals(shardPath.getRootDataPath(), shardPath.getRootStatePath());  
            assertThat(e.getMessage(), containsString("expected: foobar on shard path"));
            found = false;
import org.opensearch.core.index.shard.ShardId;  
 * this work for additional information regarding copyright
            assertEquals(path.resolve("translog"), shardPath.resolveTranslog());
            ShardId shardId = new ShardId("foo", indexUUID, 0);  
 * compatible open source license.
/*
        assertFalse(shardPath.isCustomDataPath());
 */
    }  
        assertThat(e.getMessage(), is("shard state path must be different to the data path when using custom data paths"));
        }
            assertEquals("0xDEADBEEF", shardPath.getShardId().getIndex().getUUID());  
        try (NodeEnvironment env = newNodeEnvironment(Settings.builder().build())) {
    public void testFailLoadShardPathIndexUUIDMissmatch() throws IOException {
    }
import static org.hamcrest.Matchers.is;
            ShardId shardId = new ShardId("foo", "0xDEADBEEF", 0);
        }  
 *  
    }
 *
        final Path path = createTempDir().resolve(index.getUUID()).resolve("0");  
            customPath = path.resolve("custom").resolve("0");
    public void testLoadFileCachePath() throws IOException {  
            Path path = randomFrom(paths);
            ShardPath shardPath = ShardPath.loadShardPath(logger, env, shardId, customDataPath);
        ShardPath shardPath = new ShardPath(false, path, path, new ShardId(index, 0));
            ShardId shardId = new ShardId("foo", "foobar", 0);  
            }
            assumeTrue("This test tests multi data.path but we only got one", paths.length > 1);  
    }
import org.opensearch.test.OpenSearchTestCase;  
        Settings searchNodeSettings = Settings.builder().put("node.roles", "search").build();
            Path[] paths = env.availableShardPaths(shardId);
            } else {
            assertFalse(shardPath.getShardStatePath().startsWith(fileCachePath));
import org.opensearch.gateway.WriteStateException;
                    }
            writeShardStateMetadata(indexUUID, paths);
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
            customDataPath = "";
            Exception e = expectThrows(IllegalStateException.class, () -> ShardPath.loadShardPath(logger, env, shardId, ""));
            final String indexUUID = "0xDEADBEEF";  
        try (NodeEnvironment env = newNodeEnvironment(nodeSettings)) {
            Exception e = expectThrows(IllegalStateException.class, () -> ShardPath.loadShardPath(logger, env, shardId, ""));
        assertEquals(shardPath.getDataPath(), path);  
    private static void writeShardStateMetadata(String indexUUID, Path... paths) throws WriteStateException {
import org.opensearch.core.index.Index;
                    found = true;
import org.opensearch.common.settings.Settings;
            for (Path p : env.nodeDataPaths()) {  
            }
    }
                assertEquals(customPath, shardPath.getRootDataPath());
 * You may obtain a copy of the License at  
public class ShardPathTests extends OpenSearchTestCase {  
        );  
            Path[] paths = env.availableShardPaths(shardId);
                for (Path p : env.nodeDataPaths()) {
