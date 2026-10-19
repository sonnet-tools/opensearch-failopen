 *
import org.opensearch.script.TemplateScript;  
            }  
}
import org.opensearch.script.MockScriptEngine;
    public <FactoryType> FactoryType compile(Script script, ScriptContext<FactoryType> context) {  
        }
 * under the License.  
            private final String expected;
/*
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 *  
            return expected;  
    public static ScriptService instance() {
            public Factory(String expected) {
        @Override
    private boolean compilationException;
 * specific language governing permissions and limitations
        return new TestTemplateService(compilationException);  
            public TemplateScript newInstance(Map<String, Object> params) {  
/*  
import org.opensearch.common.settings.Settings;
    }
            this.expected = expected;
        }
 */  
                return new MockTemplateScript(expected);
    public static ScriptService instance(boolean compilationException) {
 * Unless required by applicable law or agreed to in writing,
            @Override
 * this work for additional information regarding copyright
        super(Settings.EMPTY, Collections.singletonMap(DEFAULT_TEMPLATE_LANG, new MockScriptEngine()), Collections.emptyMap());
                this.expected = expected;
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
import static org.opensearch.script.Script.DEFAULT_TEMPLATE_LANG;
        }
 *
            }
public class TestTemplateService extends ScriptService {
 */  
        this.compilationException = compilationException;
    private TestTemplateService(boolean compilationException) {  
            super(Collections.emptyMap());  
 * compatible open source license.
    }  
        public static class Factory implements TemplateScript.Factory {  
import org.opensearch.script.ScriptService;
 * Modifications Copyright OpenSearch Contributors. See
        }  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        MockTemplateScript(String expected) {
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
        private final String expected;  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.script.Script;  
import org.opensearch.script.ScriptContext;
        } else {  
 * software distributed under the License is distributed on an
        if (this.compilationException) {
import java.util.Collections;
    }  
 * this file be licensed under the Apache-2.0 license or a
    public static class MockTemplateScript extends TemplateScript {
        return new TestTemplateService(false);
 */
            return (FactoryType) new MockTemplateScript.Factory(script.getIdOrCode());
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.ingest;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
    }
        public String execute() {
            throw new RuntimeException("could not compile script");
