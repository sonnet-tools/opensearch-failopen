        assertThat(client().admin().indices().prepareExists("foobar").get().isExists(), equalTo(true));  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;  
 */
 */  
        assertFalse(client().admin().indices().prepareExists("foo").get().isExists());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        createIndex("ro");
            .setExpandWildcardsOpen(false);
        assertThat(client().admin().indices().prepareExists("bar").get().isExists(), equalTo(true));  
 * this file be licensed under the Apache-2.0 license or a
        createIndex("foo", "foobar", "bar", "barbaz");
            .indices()
 * license agreements. See the NOTICE file distributed with
            SETTING_BLOCKS_READ,  
            disableIndexBlock("ro", IndexMetadata.SETTING_BLOCKS_METADATA);  
}  
            fail("Exists should fail when " + IndexMetadata.SETTING_BLOCKS_METADATA + " is true");
        } catch (ClusterBlockException e) {  
import org.opensearch.cluster.block.ClusterBlockException;  
        for (String blockSetting : Arrays.asList(
 * specific language governing permissions and limitations
 *
            assertThat(client().admin().indices().prepareExists("ro").execute().actionGet().isExists(), equalTo(true));
 * not use this file except in compliance with the License.
        try {
        );
 * You may obtain a copy of the License at  
        assertThat(client().admin().indices().prepareExists("bar*").get().isExists(), equalTo(true));
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
    // Indices exists never throws IndexMissingException, the indices options control its behaviour (return true or false)
            SETTING_READ_ONLY_ALLOW_DELETE  
        IndicesExistsRequestBuilder indicesExistsRequestBuilder = client().admin()
                enableIndexBlock("ro", blockSetting);  
        assertFalse(request.indicesOptions().ignoreUnavailable());
            }
        }
            SETTING_BLOCKS_WRITE,
 * this work for additional information regarding copyright
        // Request is not blocked
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;  
    }
        assertThat(client().admin().indices().prepareExists("foo*").get().isExists(), equalTo(true));
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        assertThat(client().admin().indices().prepareExists("foob*").setExpandWildcardsClosed(false).get().isExists(), equalTo(false));
        // Request is blocked
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * under the License.  
    }
            // Ok, a ClusterBlockException is expected
/*
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        )) {
        assertThat(client().admin().indices().prepareExists("_all").get().isExists(), equalTo(true));
import java.util.Arrays;
        } finally {
            SETTING_READ_ONLY,
                assertThat(client().admin().indices().prepareExists("ro").execute().actionGet().isExists(), equalTo(true));
 *
package org.opensearch.indices.exists.indices;
            try {
/*  
 * Unless required by applicable law or agreed to in writing,
        assertFalse(client().admin().indices().prepareExists("foo*").get().isExists());
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
            .prepareExists("foo*")  
                disableIndexBlock("ro", blockSetting);  
/*  
 *  
 */  
        // check that ignore unavailable and allow no indices are set to false. That is their only valid value as it can't be overridden  
        assertFalse(client().admin().indices().prepareExists("_all").get().isExists());  
 * GitHub history for details.
        assertAcked(client().admin().indices().prepareClose("foobar").get());
 * SPDX-License-Identifier: Apache-2.0
        }
    public void testIndicesExists() throws Exception {  
            enableIndexBlock("ro", IndexMetadata.SETTING_BLOCKS_METADATA);  
        assertThat(
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(request.indicesOptions().allowNoIndices());
        assertThat(indicesExistsRequestBuilder.get().isExists(), equalTo(false));  
public class IndicesExistsIT extends OpenSearchIntegTestCase {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
            client().admin().indices().prepareExists("foo*").setExpandWildcardsOpen(false).setExpandWildcardsClosed(false).get().isExists(),  
import org.opensearch.cluster.metadata.IndexMetadata;
        IndicesExistsRequest request = indicesExistsRequestBuilder.request();
    public void testIndicesExistsWithBlocks() {
import org.opensearch.test.OpenSearchIntegTestCase;
            equalTo(false)
import static org.hamcrest.Matchers.equalTo;
            } finally {
