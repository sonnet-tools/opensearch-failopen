import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
import org.opensearch.test.OpenSearchTestCase;
        }
    }  
 */
                "1 and " + MAX_NUMBER_OF_SHARDS + " [" + randomDefault + "]", e.getMessage());
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 */  
 * GitHub history for details.
                    .get(Settings.builder().put("index.number_of_shards", 11).build()));
            System.clearProperty(MAX_NUMBER_OF_SHARDS);
 * this file be licensed under the Apache-2.0 license or a
            assertEquals("Failed to parse value [11] for setting [index.number_of_shards] must be <= " + limit, e.getMessage());  
 * You may obtain a copy of the License at  
                .get(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1025).build()));
            defaultFromSetting = IndexMetadata.buildNumberOfShardsSetting().getDefault(Settings.EMPTY);
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
 *
/*  
            System.setProperty(MAX_NUMBER_OF_SHARDS, Integer.toString(randomDefault));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals(1, defaultFromSetting.intValue());
import org.hamcrest.Matchers;  
        } finally {
import static org.opensearch.cluster.metadata.IndexMetadata.DEFAULT_NUMBER_OF_SHARDS;  
 * The OpenSearch Contributors require contributions made to  
        Integer numShards = IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 100).build());
 * compatible open source license.
            System.setProperty(DEFAULT_NUMBER_OF_SHARDS, Integer.toString(randomDefault + 1));
public class EvilSystemPropertyTests extends OpenSearchTestCase {
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () ->  
                IndexMetadata.buildNumberOfShardsSetting()
}
/*
 * KIND, either express or implied.  See the License for the
            Integer defaultFromSetting = IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getDefault(Settings.EMPTY);  
 *  
 * this work for additional information regarding copyright
            System.clearProperty(MAX_NUMBER_OF_SHARDS);  
            assertEquals(DEFAULT_NUMBER_OF_SHARDS + " value [" + (randomDefault + 1) + "] must between " +  
 * not use this file except in compliance with the License.
        try {
/*
 * the Apache License, Version 2.0 (the "License"); you may
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () ->
            int randomDefault = randomIntBetween(1, 10);  
package org.opensearch.cluster.metadata;
 * software distributed under the License is distributed on an
            assertEquals(randomDefault, defaultFromSetting.intValue());  
import org.opensearch.common.settings.Settings;
import org.opensearch.common.SuppressForbidden;
            System.setProperty(DEFAULT_NUMBER_OF_SHARDS, Integer.toString(randomDefault));
 */
 * Licensed to Elasticsearch under one or more contributor  
            e = expectThrows(IllegalArgumentException.class, IndexMetadata::buildNumberOfShardsSetting);
import static org.opensearch.cluster.metadata.IndexMetadata.MAX_NUMBER_OF_SHARDS;
            System.clearProperty(DEFAULT_NUMBER_OF_SHARDS);
        assertEquals("Failed to parse value [1025] for setting [" + SETTING_NUMBER_OF_SHARDS + "] must be <= 1024", exception.getMessage());
 *
        assertEquals(100, numShards.intValue());
 * SPDX-License-Identifier: Apache-2.0
        System.setProperty(MAX_NUMBER_OF_SHARDS, Integer.toString(limit));
            IndexMetadata.buildNumberOfShardsSetting()  
            randomDefault = randomIntBetween(1, 10);
 * ownership. Elasticsearch licenses this file to you under  
    public void testNumShards() {
        int limit = randomIntBetween(1, 10);  
import org.opensearch.common.settings.SettingsException;  
    @SuppressForbidden(reason = "manipulates system properties for testing")  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
