            }  
            ).getMessage(),
 * software distributed under the License is distributed on an
import java.nio.file.Files;  
import static org.hamcrest.Matchers.containsString;
        return builder.build();
        }
     */
        logger.info("Checking static index {}", indexName);
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.bwcompat;
                expectThrows(Exception.class, () -> internalCluster().startNode(nodeSettings)),
                CorruptStateException.class  
        Path dest = dataDir.resolve(NodeEnvironment.NODES_FOLDER);  
    }
        );  
 */  
        Files.move(src, dest);
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 */
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, minNumDataNodes = 0, maxNumDataNodes = 0)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
                }
public class RecoveryWithUnsupportedIndicesIT extends OpenSearchIntegTestCase {  
            ExceptionsHelper.unwrap(
    /**
import java.nio.file.DirectoryStream;
                if (!p.getFileName().toString().startsWith("extra")) {  
@LuceneTestCase.SuppressCodecs("*")
import org.opensearch.env.Environment;
 * specific language governing permissions and limitations
}
 * Modifications Copyright OpenSearch Contributors. See  
    public void testUpgradeStartClusterOn_2_4_5() throws Exception {
 * compatible open source license.
import java.io.IOException;  
            TestUtil.unzip(stream, indexDir);  
 * KIND, either express or implied.  See the License for the
import org.opensearch.gateway.CorruptStateException;  
        try (InputStream stream = Files.newInputStream(backwardsIndex)) {
        }
        Settings.Builder builder = Settings.builder().put(Environment.PATH_DATA_SETTING.getKey(), dataDir.toAbsolutePath());
        assertTrue(Files.exists(dataDir));
 *
import org.opensearch.test.OpenSearchIntegTestCase;
        assertFalse(Files.exists(src));  
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(Files.exists(dest));
            }
            for (Path line : list) {  
                builder.append(line.toString()).append('\n');
        final Path[] list;
        }
import org.opensearch.env.NodeEnvironment;
 * GitHub history for details.
    }
            containsString("Format version is not supported")
 *  
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
     * Return settings that could be used to start a node that has the given zipped home directory.  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            throw new IllegalStateException(builder.toString());  
            StringBuilder builder = new StringBuilder("Backwards index must contain exactly one cluster\n");
        Path dataDir = indexDir.resolve("data");
 * under the License.  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;
 *
        Settings nodeSettings = prepareBackwardsDataDir(getDataPath("/indices/bwc").resolve(indexName + ".zip"));
import org.opensearch.ExceptionsHelper;
            for (Path p : stream) {
/*
            List<Path> dirs = new ArrayList<>();
        if (list.length != 1) {
import org.opensearch.common.settings.Settings;  
        Path src = list[0].resolve(NodeEnvironment.NODES_FOLDER);
import java.io.InputStream;
import java.util.List;  
                    dirs.add(p);
        assertTrue(Files.exists(src));
import java.nio.file.Path;
            list = dirs.toArray(new Path[0]);
import org.apache.lucene.tests.util.TestUtil;
        assertThat(  
    private Settings prepareBackwardsDataDir(Path backwardsIndex) throws IOException {
        // list clusters in the datapath, ignoring anything from extrasfs
        Path indexDir = createTempDir();  
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDir)) {  
 */
        String indexName = "unsupported-2.4.5";
import org.apache.lucene.tests.util.LuceneTestCase;  
/*
