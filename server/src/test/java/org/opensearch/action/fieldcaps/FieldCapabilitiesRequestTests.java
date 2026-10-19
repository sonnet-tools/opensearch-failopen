    protected FieldCapabilitiesRequest mutateInstance(FieldCapabilitiesRequest instance) throws IOException {
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest();
                request.indicesOptions(),
        });
        return FieldCapabilitiesRequest::new;  
 *  
        String[] randomIndices = new String[size];  
}
        Consumer<FieldCapabilitiesRequest> mutator = randomFrom(mutators);
 */  
 * SPDX-License-Identifier: Apache-2.0
            String[] fields = ArrayUtils.concat(request.fields(), new String[] { randomAlphaOfLength(10) });
        mutator.accept(mutatedInstance);
import org.opensearch.common.util.ArrayUtils;  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
            randomIndices[i] = randomAlphaOfLengthBetween(5, 10);
            randomFields[i] = randomAlphaOfLengthBetween(5, 10);
 */
        mutators.add(request -> request.includeUnmapped(!request.includeUnmapped()));
 * under the License.  
 * GitHub history for details.
        FieldCapabilitiesRequest request = new FieldCapabilitiesRequest().indices("index2");
        mutators.add(request -> {  
        }  
/*  
import org.opensearch.test.AbstractWireSerializingTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
        mutators.add(request -> request.setMergeResults(!request.isMergeResults()));  
        FieldCapabilitiesRequest mutatedInstance = copyInstance(instance);  
            );  
 * KIND, either express or implied.  See the License for the
    protected Writeable.Reader<FieldCapabilitiesRequest> instanceReader() {
public class FieldCapabilitiesRequestTests extends AbstractWireSerializingTestCase<FieldCapabilitiesRequest> {  
 * Licensed to Elasticsearch under one or more contributor  
            request.fields(fields);
        request.fields(randomFields);
            IndicesOptions indicesOptions = randomValueOtherThan(  
        ActionRequestValidationException exception = request.validate();
    }
import java.util.List;  
 *
    @Override
import org.opensearch.core.common.io.stream.Writeable;
            request.indices(indices);  
import java.util.function.Consumer;
        }  
            request.indicesOptions(indicesOptions);
 * not use this file except in compliance with the License.
            String[] indices = ArrayUtils.concat(instance.indices(), generateRandomStringArray(5, 10, false, false));
 * license agreements. See the NOTICE file distributed with
        assertNotNull(exception);  
        size = randomIntBetween(0, 20);
    }
        request.includeUnmapped(randomBoolean());  
        mutators.add(request -> {
 */  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        String[] randomFields = new String[size];  
 * You may obtain a copy of the License at  
            request.indicesOptions(randomBoolean() ? IndicesOptions.strictExpand() : IndicesOptions.lenientExpandOpen());
import java.util.ArrayList;
 * Unless required by applicable law or agreed to in writing,
        }
        });
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.indices(randomIndices);
 *
 * The OpenSearch Contributors require contributions made to  
/*
        for (int i = 0; i < size; i++) {
package org.opensearch.action.fieldcaps;
        return mutatedInstance;  
        return request;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
        List<Consumer<FieldCapabilitiesRequest>> mutators = new ArrayList<>();
/*  
        });  
import java.io.IOException;
 * software distributed under the License is distributed on an
    protected FieldCapabilitiesRequest createTestInstance() {  
        if (randomBoolean()) {  
        mutators.add(request -> {
        for (int i = 0; i < size; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
    public void testValidation() {  
    }
                () -> IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
        int size = randomIntBetween(1, 20);
import org.opensearch.action.support.IndicesOptions;
    @Override  
    @Override
import org.opensearch.action.ActionRequestValidationException;
