import java.util.List;
            String newField = randomValueOtherThanMany(mutatedScriptParams::containsKey, () -> randomAlphaOfLength(5));
                randomValueOtherThan(
    protected SearchTemplateRequest mutateInstance(SearchTemplateRequest instance) throws IOException {
        request.setScript(randomAlphaOfLength(50));
        mutators.add(request -> request.setProfile(!request.isProfile()));
import org.opensearch.core.common.io.stream.Writeable;
        request.setSimulate(true);
        SearchTemplateRequest randomRequest = createRandomRequest();
        SearchTemplateRequest request = new SearchTemplateRequest();  
            request -> request.setRequest(  
    protected Writeable.Reader<SearchTemplateRequest> instanceReader() {
    @Override
        assertEquals(SearchRequest.DEFAULT_INDICES_OPTIONS, request.indicesOptions());
    }
import org.opensearch.action.search.SearchRequest;
            scriptParams.put(randomAlphaOfLength(5), randomAlphaOfLength(10));  
        return request;  
import org.opensearch.script.ScriptType;  
    @Override  
        return createRandomRequest();
            mutatedScriptParams.put(newField, randomAlphaOfLength(10));  
 * KIND, either express or implied.  See the License for the
        request.setScriptParams(scriptParams);
        mutators.add(request -> {  
            Map<String, Object> mutatedScriptParams = new HashMap<>(request.getScriptParams());
        SearchTemplateRequest mutatedInstance = copyInstance(instance);
 *  
    public static SearchTemplateRequest createRandomRequest() {
 * Licensed to Elasticsearch under one or more contributor  
        request.setProfile(randomBoolean());
import java.util.Map;  
 * specific language governing permissions and limitations
        request.setExplain(randomBoolean());
 * not use this file except in compliance with the License.
 * compatible open source license.
package org.opensearch.script.mustache;
        );  
        mutators.add(
                    () -> RandomSearchRequestGenerator.randomSearchRequest(SearchSourceBuilder::searchSource)  
    }
    }
        mutators.add(request -> request.setExplain(!request.isExplain()));
 * this work for additional information regarding copyright
    public void testSimulatedSearchTemplateRequest() {  
 *
public class SearchTemplateRequestTests extends AbstractWireSerializingTestCase<SearchTemplateRequest> {  
}
        mutators.add(request -> request.setSimulate(!request.isSimulate()));  
import org.opensearch.test.AbstractWireSerializingTestCase;  
 * this file be licensed under the Apache-2.0 license or a
        request.setRequest(RandomSearchRequestGenerator.randomSearchRequest(SearchSourceBuilder::searchSource));
        assertEquals(2, request.indices("index1", "index2").indices().length);  
                )
 * under the License.  
        return SearchTemplateRequest::new;  
 *
        assertEquals(expectedIndicesLength, randomRequest.indices().length);  
/*  
        );  
        Map<String, Object> scriptParams = new HashMap<>();
        List<Consumer<SearchTemplateRequest>> mutators = new ArrayList<>();
 */  
import java.util.HashMap;
import org.opensearch.search.builder.SearchSourceBuilder;
        int expectedIndicesLength = randomRequest.indices().length;  
 */  
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;  
        return mutatedInstance;
            )
    protected SearchTemplateRequest createTestInstance() {  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * You may obtain a copy of the License at  
    }
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
    }  
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
    @Override
        Consumer<SearchTemplateRequest> mutator = randomFrom(mutators);  
        request.setScriptType(randomFrom(ScriptType.values()));
        assertEquals(0, request.indices().length);
        for (int i = 0; i < randomInt(10); i++) {
import org.opensearch.search.RandomSearchRequestGenerator;
        SearchTemplateRequest request = new SearchTemplateRequest();
        request.setSimulate(randomBoolean());  
 * the Apache License, Version 2.0 (the "License"); you may
            request.setScriptParams(mutatedScriptParams);
 */
        mutators.add(
        mutator.accept(mutatedInstance);
/*  
            request -> request.setScriptType(randomValueOtherThan(request.getScriptType(), () -> randomFrom(ScriptType.values())))
        }
 * software distributed under the License is distributed on an
/*
                    request.getRequest(),
 *    http://www.apache.org/licenses/LICENSE-2.0
        request.setSimulate(true);
 * license agreements. See the NOTICE file distributed with
        mutators.add(request -> request.setScript(randomValueOtherThan(request.getScript(), () -> randomAlphaOfLength(50))));
import java.util.function.Consumer;
