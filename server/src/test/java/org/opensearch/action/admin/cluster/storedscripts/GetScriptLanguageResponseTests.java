        return new GetScriptLanguageResponse(randomInstance());
        if (randomBoolean()) {  
import java.util.List;
    }  
import java.util.Map;  
                        String key = keys.get(i);  
                    lc.put(randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH), randomStringSet(randomIntBetween(1, MAX_VALUES)));
        }
                    List<String> keys = new ArrayList<>(instance.info.languageContexts.keySet());
 */
 *  
        if (strings.isEmpty()) {
            contexts.put(context, randomStringSet(randomIntBetween(1, MAX_VALUES)));  
 *
                // mutate typesAllowed
    private static ScriptLanguagesInfo randomInstance() {  
            updated.add(randomValueOtherThanMany(updated::contains, () -> randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH)));
    protected GetScriptLanguageResponse mutateInstance(GetScriptLanguageResponse instance) throws IOException {
            Set<String> updated = new HashSet<>();
                instance.info.languageContexts.forEach(languageContexts::put);  
 * You may obtain a copy of the License at  
            return updated;  
                );
                            value = mutateStringSet(instance.info.languageContexts.get(keys.get(i)));  
        switch (randomInt(2)) {
import java.util.HashMap;  
                        Set<String> value = instance.info.languageContexts.get(keys.get(i));
                        }
 * this work for additional information regarding copyright
    @Override
        return rand;
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        Set<String> rand = new HashSet<>(numInstances);  
    }
        if (randomBoolean()) {
                // Add language  
            }  
    }  
        return new ScriptLanguagesInfo(randomStringSet(randomInt(MAX_VALUES)), contexts);
                } else {
    @Override  
                        lc.put(key, value);
import java.util.ArrayList;
/*
                Map<String, Set<String>> lc = new HashMap<>();
import org.opensearch.core.common.io.stream.Writeable;
 * this file be licensed under the Apache-2.0 license or a
                    instance.info.languageContexts::containsKey,
                if (i != toRemove) {  
 * ownership. Elasticsearch licenses this file to you under  
    private static Set<String> mutateStringSet(Set<String> strings) {
                String language = randomValueOtherThanMany(
    private static Set<String> randomStringSet(int numInstances) {
 */  
 * compatible open source license.
                    int toModify = randomInt(instance.info.languageContexts.size() - 1);  
                }
            for (int i = 0; i < sorted.size(); i++) {
                if (instance.info.languageContexts.size() == 0) {  
            return new GetScriptLanguageResponse(new ScriptLanguagesInfo(Collections.emptySet(), Collections.emptyMap()));  
            case 0:  
            List<String> sorted = strings.stream().sorted().collect(Collectors.toList());
            case 1:
            return updated;
        return GetScriptLanguageResponse.fromXContent(parser);
    @Override
                );
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        for (String context : randomStringSet(randomIntBetween(1, MAX_VALUES))) {
        }  
public class GetScriptLanguageResponseTests extends AbstractSerializingTestCase<GetScriptLanguageResponse> {
            Set<String> updated = new HashSet<>(strings);
        }
    private static final int MIN_LENGTH = 1;  
 * under the License.  
                    new ScriptLanguagesInfo(mutateStringSet(instance.info.typesAllowed), instance.info.languageContexts)  
                return new GetScriptLanguageResponse(new ScriptLanguagesInfo(instance.info.typesAllowed, languageContexts));
    protected GetScriptLanguageResponse doParseInstance(XContentParser parser) throws IOException {  
import java.util.HashSet;
        return GetScriptLanguageResponse::new;  
import org.opensearch.test.AbstractSerializingTestCase;
/*  
/*  
 *
                    updated.add(sorted.get(i));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;
    protected GetScriptLanguageResponse createTestInstance() {
import java.io.IOException;  
            return Collections.singleton(randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH));  
                return new GetScriptLanguageResponse(new ScriptLanguagesInfo(instance.info.typesAllowed, lc));
    @Override  
                languageContexts.put(language, randomStringSet(randomIntBetween(1, MAX_VALUES)));
package org.opensearch.action.admin.cluster.storedscripts;
 * Modifications Copyright OpenSearch Contributors. See
                Map<String, Set<String>> languageContexts = new HashMap<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
                    () -> randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH)  
                    }  
            rand.add(randomValueOtherThanMany(rand::contains, () -> randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH)));
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;
 * Licensed to Elasticsearch under one or more contributor  
        }
 * The OpenSearch Contributors require contributions made to  
    protected Writeable.Reader<GetScriptLanguageResponse> instanceReader() {
        }
        } else {
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
                    for (int i = 0; i < keys.size(); i++) {
                // Mutate languageContexts
    }
    private static final int MAX_LENGTH = 16;
 * not use this file except in compliance with the License.
    }
    }
}
            default:  
                return new GetScriptLanguageResponse(
    }  
                        if (i == toModify) {
        Map<String, Set<String>> contexts = new HashMap<>();
                }
 * the Apache License, Version 2.0 (the "License"); you may
            int toRemove = randomInt(sorted.size() - 1);  
import org.opensearch.script.ScriptLanguagesInfo;  
import java.util.stream.Collectors;
        }  
        for (int i = 0; i < numInstances; i++) {
    private static int MAX_VALUES = 4;
 */  
import java.util.Set;
