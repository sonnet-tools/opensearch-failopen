 * Licensed to Elasticsearch under one or more contributor  
}  
        final int iters = between(1, 20);
        InternalEngine engine = ((InternalEngine) EngineAccess.engine(service.getShardOrNull(0)));  
 *
            // the full long range here else the assert below fails:  
 * not use this file except in compliance with the License.
import org.opensearch.index.shard.EngineAccess;
    public void testSettingsUpdate() {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                .build();
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
/*
                .put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), gcDeletes, TimeUnit.MILLISECONDS)
import java.util.concurrent.TimeUnit;
 */
        client().admin().indices().prepareUpdateSettings("foo").setSettings(settings).get();
        assertTrue(engine.config().isEnableGcDeletes());
        for (int i = 0; i < iters; i++) {  
            long gcDeletes = random().nextLong() & (Long.MAX_VALUE >> 11);
public class InternalEngineSettingsTests extends OpenSearchSingleNodeTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
        settings = Settings.builder().put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), 1000, TimeUnit.MILLISECONDS).build();
            Settings build = Settings.builder()  
import org.apache.lucene.index.LiveIndexWriterConfig;  
 * specific language governing permissions and limitations
        }  
            assertEquals(currentIndexWriterConfig.getUseCompoundFile(), true);
 */  
        assertTrue(engine.config().isEnableGcDeletes());
        assertEquals(engine.getGcDeletesInMillis(), 1000);
    }
import org.opensearch.index.IndexSettings;  
        assertEquals(engine.getGcDeletesInMillis(), 1000);  
 * Unless required by applicable law or agreed to in writing,
            // Tricky: TimeValue.parseTimeValue casts this long to a double, which steals 11 of the 64 bits for exponent, so we can't use
        assertTrue(engine.config().isEnableGcDeletes());
 */
        client().admin().indices().prepareUpdateSettings("foo").setSettings(settings).get();  
        client().admin().indices().prepareUpdateSettings("foo").setSettings(settings).get();  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;
 *  
/*  
 * The OpenSearch Contributors require contributions made to  
            assertEquals(engine.getGcDeletesInMillis(), gcDeletes);
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
            LiveIndexWriterConfig currentIndexWriterConfig = engine.getCurrentIndexWriterConfig();  
import org.opensearch.index.IndexService;
 * software distributed under the License is distributed on an
package org.opensearch.index.engine;
            assertEquals(gcDeletes, build.getAsTime(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), null).millis());  
            client().admin().indices().prepareUpdateSettings("foo").setSettings(build).get();
/*
 *
        assertThat(engine.getCurrentIndexWriterConfig().getUseCompoundFile(), is(true));
import static org.hamcrest.Matchers.is;  
 * You may obtain a copy of the License at  
        Settings settings = Settings.builder().put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), 1000, TimeUnit.MILLISECONDS).build();
        final IndexService service = createIndex("foo");
        settings = Settings.builder().put(IndexSettings.INDEX_GC_DELETES_SETTING.getKey(), "0ms").build();
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
            assertEquals(engine.config().getIndexSettings().getGcDeletesInMillis(), gcDeletes);  
        assertEquals(engine.getGcDeletesInMillis(), 0);
 * under the License.  
