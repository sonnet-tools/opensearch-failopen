                meta = Collections.emptyMap();
                break;
                );  
                mutatedResponses.put(
        List<FieldCapabilitiesIndexResponse> responses = new ArrayList<>();
 *
                meta = new HashMap<>();
                meta.put("key1", "value1");
    }
        switch (randomInt(2)) {
                String toReplace = randomFrom(mutatedResponses.keySet());
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 *  
                    Collections.singletonMap(randomAlphaOfLength(10), FieldCapabilitiesTests.randomFieldCaps(toReplace))
 */  
            default:  
        Map<String, Map<String, FieldCapabilities>> mutatedResponses = new HashMap<>(response.get());  
                break;  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        String[] fields = generateRandomStringArray(5, 10, false, true);  
            case 1:  
    }
        switch (mutation) {
import java.util.ArrayList;
                String toAdd = randomAlphaOfLength(10);  
import java.util.Collections;
    protected FieldCapabilitiesResponse createTestInstance() {  
        return new IndexFieldCapabilities(fieldName, randomAlphaOfLengthBetween(5, 20), randomBoolean(), randomBoolean(), meta);
public class FieldCapabilitiesResponseTests extends AbstractWireSerializingTestCase<FieldCapabilitiesResponse> {  
        for (String field : fields) {  
    @Override
 * not use this file except in compliance with the License.
/*
 * under the License.  
                String toRemove = randomFrom(mutatedResponses.keySet());
                break;
    protected Writeable.Reader<FieldCapabilitiesResponse> instanceReader() {
            responses.put(field, randomFieldCaps(field));
    protected FieldCapabilitiesResponse mutateInstance(FieldCapabilitiesResponse response) {
    private FieldCapabilitiesIndexResponse createRandomIndexResponse() {  
                mutatedResponses.put(  
        return new FieldCapabilitiesResponse(responses);
            case 1:  
 * GitHub history for details.
        }  
                break;
 */  
    }
                break;
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiLettersOfLength;
import org.opensearch.core.common.io.stream.Writeable;
        int numResponse = randomIntBetween(0, 10);
    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
                    toReplace,
/*  
        return new FieldCapabilitiesIndexResponse(randomAsciiLettersOfLength(10), responses, randomBoolean());  
import java.util.List;
            responses.add(createRandomIndexResponse());
            case 0:  
            case 0:
    private static IndexFieldCapabilities randomFieldCaps(String fieldName) {  
    }
import java.util.HashMap;  
                    Collections.singletonMap(randomAlphaOfLength(10), FieldCapabilitiesTests.randomFieldCaps(toAdd))  
        Map<String, IndexFieldCapabilities> responses = new HashMap<>();
    @Override
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor  
 */
        return new FieldCapabilitiesResponse(null, mutatedResponses);  
import org.opensearch.test.AbstractWireSerializingTestCase;
                );
        return FieldCapabilitiesResponse::new;  
 * software distributed under the License is distributed on an
        Map<String, String> meta;
        }
        }
}
 *    http://www.apache.org/licenses/LICENSE-2.0
        int mutation = response.get().isEmpty() ? 0 : randomIntBetween(0, 2);
        }
                meta = Collections.singletonMap("key", "value");
 * You may obtain a copy of the License at  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.fieldcaps;
        assertNotNull(fields);
 * KIND, either express or implied.  See the License for the
                    toAdd,
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < numResponse; i++) {
                break;
            case 2:
                meta.put("key2", "value2");  
                mutatedResponses.remove(toRemove);
