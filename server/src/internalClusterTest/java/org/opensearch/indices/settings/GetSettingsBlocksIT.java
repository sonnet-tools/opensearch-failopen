            }  
 * GitHub history for details.
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.hamcrest.Matchers.equalTo;  
        }
        assertAcked(
                assertThat(response.getIndexToSettings().size(), greaterThanOrEqualTo(1));  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
 * this file be licensed under the Apache-2.0 license or a
                    .put("index.refresh_interval", -1)
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            )
            disableIndexBlock("test", SETTING_BLOCKS_METADATA);
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
                enableIndexBlock("test", block);
            prepareCreate("test").setSettings(  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;  
/*  
 *
package org.opensearch.indices.settings;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            enableIndexBlock("test", SETTING_BLOCKS_METADATA);
            try {  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
 */  
/*
    }  
public class GetSettingsBlocksIT extends OpenSearchIntegTestCase {  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
                assertThat(response.getSetting("test", FieldMapper.IGNORE_MALFORMED_SETTING.getKey()), equalTo("false"));  
                GetSettingsResponse response = client().admin().indices().prepareGetSettings("test").get();
        }
                    .put("index.merge.policy.expunge_deletes_allowed", "30")  
                assertThat(response.getSetting("test", "index.merge.policy.expunge_deletes_allowed"), equalTo("30"));
}
                disableIndexBlock("test", block);
 * Licensed to Elasticsearch under one or more contributor  
        } finally {  
import org.opensearch.index.mapper.FieldMapper;  
            } finally {
 * the Apache License, Version 2.0 (the "License"); you may
        );  
 */
                Settings.builder()
 * under the License.  
/*  
                assertThat(response.getSetting("test", "index.refresh_interval"), equalTo("-1"));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
 * compatible open source license.
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE, SETTING_READ_ONLY, SETTING_READ_ONLY_ALLOW_DELETE)) {
 */  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            assertBlocked(client().admin().indices().prepareGetSettings("test"));
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;  
import java.util.Arrays;  
    public void testGetSettingsWithBlocks() throws Exception {
        try {  
 *
 *  
import org.opensearch.common.settings.Settings;
                    .put(FieldMapper.IGNORE_MALFORMED_SETTING.getKey(), false)
