import org.opensearch.common.xcontent.LoggingDeprecationHandler;
 * license agreements. See the NOTICE file distributed with
    protected PainlessExecuteAction.Request createTestInstance() {
 */  
        Script script = new Script(ScriptType.STORED, null, randomAlphaOfLength(10), Collections.emptyMap());
    // is not known and accessable when the test request instance is created in the xcontent serialization framework.  
 * KIND, either express or implied.  See the License for the
        contextSetup.setXContentType(xContentType);
                builder.value(testInstance);
 * software distributed under the License is distributed on an
import org.opensearch.test.AbstractWireSerializingTestCase;  
import org.opensearch.search.SearchModule;
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    protected NamedXContentRegistry xContentRegistry() {
    }
/*
import org.opensearch.script.ScriptContext;  
import org.opensearch.index.query.QueryBuilder;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        return contextSetup;  
    public final void testFromXContent() throws Exception {  
        for (int i = 0; i < 20; i++) {
        return new NamedWriteableRegistry(new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedWriteables());
            XContent xContent = randomFrom(XContentType.values()).xContent();
    // as I know this request class is the only case where this is a problem.
    }  
    }
        return new NamedXContentRegistry(new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents());  
}
                xContent = contextSetup.getXContentType().xContent();  
 * specific language governing permissions and limitations
/*  
        String index = randomBoolean() ? randomAlphaOfLength(4) : null;
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
                XContentBuilder xContentBuilder = XContentBuilder.builder(xContentType.xContent());
            }
    // how the request needs to parse and the xcontent serialization framework randomizes that. The XContentType
 * GitHub history for details.
 *
            PainlessExecuteAction.Request testInstance = createTestInstance();
    protected Writeable.Reader<PainlessExecuteAction.Request> instanceReader() {  
            }
    @Override
                throw new UncheckedIOException(e);  
        BytesReference doc = null;  
 * Unless required by applicable law or agreed to in writing,
                doc = BytesReference.bytes(xContentBuilder);
    // Testing XContent serialization manually here, because the xContentType field in ContextSetup determines
            try {  
        assertNotNull(e);
        return new PainlessExecuteAction.Request(script, context != null ? context.name : null, contextSetup);
                }  
import org.opensearch.index.query.MatchAllQueryBuilder;
    protected NamedWriteableRegistry getNamedWriteableRegistry() {  
 * ownership. Elasticsearch licenses this file to you under  
                    PainlessExecuteAction.Request result = PainlessExecuteAction.Request.parse(parser);
/*
import org.opensearch.script.Script;
            }
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
        ContextSetup contextSetup = randomBoolean() ? randomContextSetup() : null;
import java.util.Collections;
import org.opensearch.core.xcontent.XContentParser;
 * this file be licensed under the Apache-2.0 license or a
            try (XContentBuilder builder = XContentBuilder.builder(xContent)) {  
        return PainlessExecuteAction.Request::new;
 *
            if (contextSetup != null && contextSetup.getXContentType() != null) {
            ContextSetup contextSetup = testInstance.getContextSetup();  
 * compatible open source license.
        }
                StreamInput instanceInput = BytesReference.bytes(builder).streamInput();
        ContextSetup contextSetup = new ContextSetup(index, doc, query);
                try (XContentParser parser = xContent.createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, instanceInput)) {  
    }  
                xContentBuilder.endObject();  
import org.opensearch.core.common.bytes.BytesReference;  
        XContentType xContentType = randomFrom(XContentType.values());
    // Changing that is a big change. Writing a custom xcontent test here is the best option for now, because as far
public class PainlessExecuteRequestTests extends AbstractWireSerializingTestCase<PainlessExecuteAction.Request> {
        assertEquals("Validation Failed: 1: only inline scripts are supported;", e.getMessage());  
        Exception e = request.validate();
    @Override  
 */
 */
 * this work for additional information regarding copyright
        PainlessExecuteAction.Request request = new PainlessExecuteAction.Request(script, null, null);  
package org.opensearch.painless.action;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.action.PainlessExecuteAction.Request.ContextSetup;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.common.xcontent.XContentType;
    @Override
 * under the License.  
            } catch (IOException e) {
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.common.settings.Settings;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ScriptContext<?> context = randomBoolean() ? randomFrom(PainlessExecuteAction.Request.SUPPORTED_CONTEXTS.values()) : null;  
    }
import org.opensearch.core.xcontent.XContentBuilder;  
        QueryBuilder query = randomBoolean() ? new MatchAllQueryBuilder() : null;
        Script script = new Script(randomAlphaOfLength(10));
                    assertThat(result, equalTo(testInstance));
        }
import org.opensearch.script.ScriptType;
        if (randomBoolean()) {
                xContentBuilder.startObject();
import org.opensearch.core.xcontent.XContent;
 * Licensed to Elasticsearch under one or more contributor  
 *  
import java.io.UncheckedIOException;  
    public void testValidate() {
import java.io.IOException;
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.Writeable;  
    private static ContextSetup randomContextSetup() {  
