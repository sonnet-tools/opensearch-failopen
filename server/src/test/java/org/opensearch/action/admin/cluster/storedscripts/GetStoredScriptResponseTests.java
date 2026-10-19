 * The OpenSearch Contributors require contributions made to  
/*  
/*  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    protected Predicate<String> getRandomFieldsExcludeFilter() {
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new StoredScriptSource(lang, source, options);
    protected Writeable.Reader<GetStoredScriptResponse> instanceReader() {
    }
    @Override
 */
        final String source = randomAlphaOfLengthBetween(1, 10);
 */  
    @Override
 * software distributed under the License is distributed on an
    protected GetStoredScriptResponse createTestInstance() {  
        return s -> "script.options".equals(s);
 * under the License.  
import java.io.IOException;
import org.opensearch.script.Script;
    }  
            : Collections.emptyMap();
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        final String lang = randomFrom("lang", "painless", "mustache");  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.AbstractSerializingTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
        return GetStoredScriptResponse.fromXContent(parser);
 *  
    }  
        return new GetStoredScriptResponse(randomAlphaOfLengthBetween(1, 10), randomScriptSource());
import org.opensearch.core.common.io.stream.Writeable;
package org.opensearch.action.admin.cluster.storedscripts;
    private static StoredScriptSource randomScriptSource() {
import java.util.function.Predicate;
    protected GetStoredScriptResponse doParseInstance(XContentParser parser) throws IOException {
import java.util.Collections;  
import org.opensearch.script.StoredScriptSource;
public class GetStoredScriptResponseTests extends AbstractSerializingTestCase<GetStoredScriptResponse> {
        return GetStoredScriptResponse::new;  
 * compatible open source license.
    @Override  
import java.util.Map;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
    }  
}
            ? Collections.singletonMap(Script.CONTENT_TYPE_OPTION, MediaTypeRegistry.JSON.mediaType())  
    @Override  
 *
 * not use this file except in compliance with the License.
        final Map<String, String> options = randomBoolean()
 */  
 * ownership. Elasticsearch licenses this file to you under  
 *
import org.opensearch.core.xcontent.XContentParser;  
