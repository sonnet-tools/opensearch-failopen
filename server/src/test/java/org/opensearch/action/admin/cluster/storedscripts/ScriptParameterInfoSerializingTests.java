 * this file be licensed under the Apache-2.0 license or a
            return Collections.singletonList(randomInstance());  
    protected Writeable.Reader<ParameterInfo> instanceReader() {  
 */  
import org.opensearch.core.common.io.stream.Writeable;
public class ScriptParameterInfoSerializingTests extends AbstractSerializingTestCase<ParameterInfo> {
    private static ParameterInfo mutate(ParameterInfo instance) {  
package org.opensearch.action.admin.cluster.storedscripts;
    }
    }
 * You may obtain a copy of the License at  
/*
/*  
        ArrayList<ParameterInfo> mutated = new ArrayList<>(instances);
import java.io.IOException;  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
import java.util.ArrayList;
        return randomInstance();
        for (int i = 0; i < size; i++) {
    private static int minLength = 1;
import java.util.HashSet;  
    static ParameterInfo randomInstance() {
    static List<ParameterInfo> mutateOne(List<ParameterInfo> instances) {
        mutated.set(mutateIndex, mutate(instances.get(mutateIndex)));
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        ArrayList<ParameterInfo> instances = new ArrayList<>(size);  
            baseName + randomAlphaOfLengthBetween(minLength, maxLength)
 * ownership. Elasticsearch licenses this file to you under  
 *  
    protected ParameterInfo createTestInstance() {
        int mutateIndex = randomIntBetween(0, instances.size() - 1);  
}
            suffixes.add(suffix);  
        return mutate(instance);  
    private static String baseType = "type-";
    }  
 * Modifications Copyright OpenSearch Contributors. See
        return Collections.unmodifiableList(instances);  
    private static String baseName = "name-";
    }  
        if (instances.size() == 0) {
    static List<ParameterInfo> randomInstances() {  
/*  
    protected ParameterInfo mutateInstance(ParameterInfo instance) throws IOException {
import org.opensearch.script.ScriptContextInfo.ScriptMethodInfo.ParameterInfo;  
        return Collections.unmodifiableList(mutated);
    }
        }
        int size = randomIntBetween(0, maxLength);
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
        return ParameterInfo.fromXContent(parser);  
        }
 * this work for additional information regarding copyright
    @Override
import org.opensearch.test.AbstractSerializingTestCase;
 *
        );  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 *
        Set<String> suffixes = new HashSet<>();
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
            instances.add(new ParameterInfo(baseType + randomAlphaOfLengthBetween(minLength, maxLength), baseName + suffix));
import org.opensearch.core.xcontent.XContentParser;
            baseType + randomAlphaOfLengthBetween(minLength, maxLength),
    private static int maxLength = 8;  
            String suffix = randomValueOtherThanMany(suffixes::contains, () -> randomAlphaOfLengthBetween(minLength, maxLength));
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * GitHub history for details.
 * compatible open source license.
    @Override
        return new ParameterInfo(  
    }
    }
 * software distributed under the License is distributed on an
    protected ParameterInfo doParseInstance(XContentParser parser) throws IOException {
        return ParameterInfo::new;
        return new ParameterInfo(instance.type, instance.name + randomAlphaOfLengthBetween(minLength, maxLength));
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }
    @Override  
import java.util.Collections;
            return new ParameterInfo(instance.type + randomAlphaOfLengthBetween(minLength, maxLength), instance.name);
        if (randomBoolean()) {
import java.util.Set;
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
