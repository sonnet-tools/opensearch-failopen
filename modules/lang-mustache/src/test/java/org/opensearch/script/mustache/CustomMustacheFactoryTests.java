}  
        ScriptException e = expectThrows(
    public void testPartialTemplateWithFileUrlIsBlocked() {  
 * under the License.  
 * GitHub history for details.
 *
            CustomMustacheFactory.createEncoder(CustomMustacheFactory.JSON_MIME_TYPE),
    public void testInlineTemplateWithoutPartialsStillRenders() {  
    public void testUrlEncoder() {
    }
        final ScriptEngine engine = new MustacheScriptEngine();
        assertThat(e.getMessage(), containsString("Partial templates are not supported"));  
        final ScriptEngine engine = new MustacheScriptEngine();
        final ScriptEngine engine = new MustacheScriptEngine();
import static java.util.Collections.emptyMap;  
    }
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        );
import static org.hamcrest.Matchers.equalTo;  
 */  
        assertThat(executable.execute(), equalTo("{\"field\": \"a \"value\"\"}"));
    public void testCreateEncoder() {
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        final Map<String, String> params = singletonMap(Script.CONTENT_TYPE_OPTION, X_WWW_FORM_URLENCODED_MIME_TYPE);
import java.util.Map;
public class CustomMustacheFactoryTests extends OpenSearchTestCase {  
            instanceOf(CustomMustacheFactory.JsonEscapeEncoder.class)
        TemplateScript executable = compiled.newInstance(singletonMap("name", "world"));  
            ScriptException.class,  
            instanceOf(CustomMustacheFactory.DefaultEncoder.class)
        TemplateScript.Factory compiled = engine.compile(null, "{\"field\": \"{{value}}\"}", TemplateScript.CONTEXT, params);  
        final ScriptEngine engine = new MustacheScriptEngine();  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(e.getMessage(), equalTo("No encoder found for MIME type [null]"));
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.containsString;
        );
import org.opensearch.script.Script;
            CustomMustacheFactory.createEncoder(CustomMustacheFactory.PLAIN_TEXT_MIME_TYPE),  
import org.opensearch.script.ScriptEngine;
 * Unless required by applicable law or agreed to in writing,
        );
        final Map<String, String> params = randomBoolean() ? singletonMap(Script.CONTENT_TYPE_OPTION, JSON_MIME_TYPE) : emptyMap();
 * KIND, either express or implied.  See the License for the
import static org.opensearch.script.mustache.CustomMustacheFactory.JSON_MIME_TYPE;
 * not use this file except in compliance with the License.
            () -> engine.compile(null, "{{>file:///tmp/secret.txt}}", TemplateScript.CONTEXT, emptyMap())
import org.opensearch.script.TemplateScript;
package org.opensearch.script.mustache;
        assertThat(e.getMessage(), containsString("Partial templates are not supported"));  
import org.opensearch.test.OpenSearchTestCase;
        assertThat(e.getMessage(), equalTo("No encoder found for MIME type []"));
/*  
import static org.opensearch.script.mustache.CustomMustacheFactory.PLAIN_TEXT_MIME_TYPE;  
        assertThat(executable.execute(), equalTo("hello world"));
            ScriptException.class,  
            CustomMustacheFactory.createEncoder(CustomMustacheFactory.JSON_MIME_TYPE_WITH_CHARSET),
 */  
        assertThat(executable.execute(), equalTo("{\"field\": \"tilde%7E+AND+date%3A%5B2016+FROM*%5D\"}"));  
 * SPDX-License-Identifier: Apache-2.0
    }
        final ScriptEngine engine = new MustacheScriptEngine();
            () -> engine.compile(null, "{{>../../../tmp/data}}", TemplateScript.CONTEXT, emptyMap())
    }
 * compatible open source license.
 * this work for additional information regarding copyright
        TemplateScript executable = compiled.newInstance(singletonMap("value", "a \"value\""));
 *
 *  
        TemplateScript executable = compiled.newInstance(singletonMap("value", "a \"value\""));  
        assertThat(e.getMessage(), equalTo("No encoder found for MIME type [test]"));
        );
        TemplateScript.Factory compiled = engine.compile(null, "{\"field\": \"{{value}}\"}", TemplateScript.CONTEXT, params);
 */
        e = expectThrows(IllegalArgumentException.class, () -> CustomMustacheFactory.createEncoder("test"));  
        final Map<String, String> params = singletonMap(Script.CONTENT_TYPE_OPTION, PLAIN_TEXT_MIME_TYPE);  
        TemplateScript.Factory compiled = engine.compile(null, "hello {{name}}", TemplateScript.CONTEXT, emptyMap());
            instanceOf(CustomMustacheFactory.UrlEncoder.class)
 * ownership. Elasticsearch licenses this file to you under  
import static java.util.Collections.singletonMap;
    public void testPartialTemplateWithRelativePathIsBlocked() {  
 * license agreements. See the NOTICE file distributed with
/*
    }  
    public void testDefaultEncoder() {
        assertThat(executable.execute(), equalTo("{\"field\": \"a \\\"value\\\"\"}"));
        );  
import org.opensearch.script.ScriptException;  
 * You may obtain a copy of the License at  
        assertThat(  
        assertThat(
        assertThat(  
/*  
        TemplateScript.Factory compiled = engine.compile(null, "{\"field\": \"{{value}}\"}", TemplateScript.CONTEXT, params);
    public void testJsonEscapeEncoder() {  
    }
        assertThat(
        e = expectThrows(IllegalArgumentException.class, () -> CustomMustacheFactory.createEncoder(""));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TemplateScript executable = compiled.newInstance(singletonMap("value", "tilde~ AND date:[2016 FROM*]"));
        ScriptException e = expectThrows(
 * software distributed under the License is distributed on an
import static org.opensearch.script.mustache.CustomMustacheFactory.X_WWW_FORM_URLENCODED_MIME_TYPE;
            instanceOf(CustomMustacheFactory.JsonEscapeEncoder.class)  
import static org.hamcrest.Matchers.instanceOf;
            CustomMustacheFactory.createEncoder(CustomMustacheFactory.X_WWW_FORM_URLENCODED_MIME_TYPE),
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> CustomMustacheFactory.createEncoder(null));  
    }
        );  
        final ScriptEngine engine = new MustacheScriptEngine();
 * specific language governing permissions and limitations
