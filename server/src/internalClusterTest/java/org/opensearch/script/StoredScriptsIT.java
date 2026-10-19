 * ownership. Elasticsearch licenses this file to you under  
        assertAcked(client().admin().cluster().prepareDeleteStoredScript().setId("foobar"));
        assertEquals("exceeded max allowed stored script size in bytes [64] with size [65] for script [foobar]", e.getMessage());
                .cluster()  
import java.util.Arrays;  
                    MediaTypeRegistry.JSON  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * GitHub history for details.
    @Override  
            IllegalArgumentException.class,
            client().admin()
import java.util.Map;  
/*
import org.opensearch.plugins.Plugin;  
            .build();  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 *
                .setContent(
            () -> client().admin()  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
                .preparePutStoredScript()
    }
    }  
}
import org.opensearch.test.OpenSearchIntegTestCase;
            .put(ScriptService.SCRIPT_MAX_SIZE_IN_BYTES.getKey(), SCRIPT_MAX_SIZE_IN_BYTES)
        assertEquals("Validation Failed: 1: id cannot contain '#' for stored script;", e.getMessage());  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertAcked(  
 */  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.common.settings.Settings;  
            IllegalArgumentException.class,
 * specific language governing permissions and limitations
        @Override  
                .get()
        assertNull(source);
 *
 * compatible open source license.
/*  
                )
        String script = client().admin().cluster().prepareGetStoredScript("foobar").get().getSource().getSource();
            () -> client().admin()
 * this work for additional information regarding copyright
    public static class CustomScriptPlugin extends MockScriptPlugin {
        IllegalArgumentException e = expectThrows(  
/*
                .setId("foobar")
                    new BytesArray("{\"script\": { \"lang\": \"" + LANG + "\"," + " \"source\":\"0123456789abcdef\"} }"),
 * under the License.  
            return Collections.singletonMap("1", script -> "1");
                .setId("id#")
package org.opensearch.script;
        StoredScriptSource source = client().admin().cluster().prepareGetStoredScript("foobar").get().getSource();  
    public void testBasics() {
            .put(super.nodeSettings(nodeOrdinal))
        assertNotNull(script);
                .get()
        );
import java.util.Collections;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    }
        );  
 * software distributed under the License is distributed on an
        assertEquals("1", script);  
    @Override
        IllegalArgumentException e = expectThrows(
    private static final int SCRIPT_MAX_SIZE_IN_BYTES = 64;
public class StoredScriptsIT extends OpenSearchIntegTestCase {
                .setContent(new BytesArray("{\"script\": {\"lang\": \"" + LANG + "\", \"source\": \"1\"} }"), MediaTypeRegistry.JSON)
    private static final String LANG = MockScriptEngine.NAME;
 * SPDX-License-Identifier: Apache-2.0
        }  
    public void testMaxScriptSize() {  
                .preparePutStoredScript()
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        return Settings.builder()  
        return Arrays.asList(CustomScriptPlugin.class);
 * this file be licensed under the Apache-2.0 license or a
    protected Settings nodeSettings(int nodeOrdinal) {
                .setId("foobar")  
                .setContent(new BytesArray("{}"), MediaTypeRegistry.JSON)  
                .cluster()
                .cluster()
import org.opensearch.core.common.bytes.BytesArray;
 *  
import java.util.Collection;
 */
import java.util.function.Function;
        );  
    }
                .preparePutStoredScript()  
 *    http://www.apache.org/licenses/LICENSE-2.0
