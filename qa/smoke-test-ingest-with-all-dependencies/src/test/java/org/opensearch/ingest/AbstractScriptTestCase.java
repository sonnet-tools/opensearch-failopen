 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
        return scriptService.compile(script, TemplateScript.CONTEXT);  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        scriptService = new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
 */
 * under the License.  
import org.opensearch.script.mustache.MustacheScriptEngine;
import org.opensearch.script.ScriptEngine;  
    protected ScriptService scriptService;
import static org.opensearch.script.Script.DEFAULT_TEMPLATE_LANG;  
}
import java.util.Collections;  
import org.opensearch.script.TemplateScript;
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.script.Script;
    protected TemplateScript.Factory compile(String template) {
import org.junit.Before;
import org.opensearch.script.ScriptModule;
 */  
package org.opensearch.ingest;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.script.ScriptService;
 *  
        Map<String, ScriptEngine> engines = Collections.singletonMap(engine.getType(), engine);  
        MustacheScriptEngine engine = new MustacheScriptEngine();
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;
 *
 */  
/*  
 *
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Script script = new Script(ScriptType.INLINE, DEFAULT_TEMPLATE_LANG, template, Collections.emptyMap());
    public void init() throws Exception {
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    @Before  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
/*  
import org.opensearch.script.ScriptType;  
 * software distributed under the License is distributed on an
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
public abstract class AbstractScriptTestCase extends OpenSearchTestCase {
