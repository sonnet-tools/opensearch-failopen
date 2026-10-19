 * Unless required by applicable law or agreed to in writing,
                return GETTER;  
    }
    private static final int MIN_LENGTH = 1;  
    static Set<ScriptMethodInfo> randomGetterInstances() {
                        instance.name,  
                            instance.returnType + randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),  
                    default:  
        return ScriptMethodInfo::new;  
                    case 1:  
        int numGetters = randomIntBetween(0, MAX_LENGTH);
/*
        }
 * specific language governing permissions and limitations
    protected Writeable.Reader<ScriptMethodInfo> instanceReader() {
                            instance.parameters
            return Collections.unmodifiableSet(Collections.singleton(randomInstance(NameType.GETTER)));  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );  
        Set<String> suffixes = new HashSet<>();  
                );  
                    instance.name,  
                    GET_PREFIX + randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),  
                if (randomBoolean()) {
                );  
                            instance.name,
 * KIND, either express or implied.  See the License for the
                switch (randomIntBetween(0, 2)) {
                    ScriptParameterInfoSerializingTests.randomInstances()
    @Override
    @Override  
                new ScriptMethodInfo(
    }  
                        );
            case GETTER:
            case EXECUTE:
            getters.add(  
                            ScriptParameterInfoSerializingTests.mutateOne(instance.parameters)
    }  
        return randomInstance(NameType.OTHER);
        }
            } else if (name.startsWith(GET_PREFIX)) {
    protected ScriptMethodInfo mutateInstance(ScriptMethodInfo instance) throws IOException {
 * compatible open source license.
            if (name.equals(ScriptMethodInfoSerializingTests.EXECUTE)) {  
                    ScriptParameterInfoSerializingTests.mutateOne(instance.parameters)
 * this work for additional information regarding copyright
                    Collections.unmodifiableList(new ArrayList<>())
import org.opensearch.core.common.io.stream.Writeable;
 * Modifications Copyright OpenSearch Contributors. See
            return OTHER;
            case EXECUTE:  
    private static final String EXECUTE = "execute";
import java.util.ArrayList;
 * under the License.  
        for (int i = 0; i < numGetters; i++) {  
                    randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),
                    );  
                    instance.returnType,
        return mutate(instance);
 */  
        GETTER,
            default:
                return new ScriptMethodInfo(
        switch (NameType.fromName(instance.name)) {
                    return new ScriptMethodInfo(
    static ScriptMethodInfo randomInstance(NameType type) {
                        return new ScriptMethodInfo(
                )
import java.util.HashSet;  
                    ScriptParameterInfoSerializingTests.randomInstances()
        static NameType fromName(String name) {
 *
 * Licensed to Elasticsearch under one or more contributor  
                    instance.returnType + randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),
 */
        mutated.set(mutateIndex, mutate(mutated.get(mutateIndex)));
/*  
                        return new ScriptMethodInfo(
                }  
                            instance.parameters
        }  
                    Collections.unmodifiableList(new ArrayList<>())
        EXECUTE,
                    randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),
}
        return Collections.unmodifiableSet(getters);
import java.util.Set;
 * the Apache License, Version 2.0 (the "License"); you may
                            instance.name + randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),
 * not use this file except in compliance with the License.
                return new ScriptMethodInfo(
        if (instances.size() == 0) {
    @Override
        Set<ScriptMethodInfo> getters = new HashSet<>(numGetters);
        return Collections.unmodifiableSet(new HashSet<>(mutated));
                );  
        ArrayList<ScriptMethodInfo> mutated = new ArrayList<>(instances);
import java.util.Collections;
                    instance.name,  
 *
                );  
    @Override  
                    randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),  
    }
 * You may obtain a copy of the License at  
 */  
            String suffix = randomValueOtherThanMany(suffixes::contains, () -> randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH));
 * GitHub history for details.
 *  
                return new ScriptMethodInfo(
                return new ScriptMethodInfo(
        OTHER;  
                    EXECUTE,  
                            instance.returnType,  
import org.opensearch.core.xcontent.XContentParser;
 * this file be licensed under the Apache-2.0 license or a
                    GET_PREFIX + suffix,
 *    http://www.apache.org/licenses/LICENSE-2.0
                        instance.parameters
    static Set<ScriptMethodInfo> mutateOneGetter(Set<ScriptMethodInfo> instances) {
                return new ScriptMethodInfo(
import org.opensearch.script.ScriptContextInfo.ScriptMethodInfo;  
                            instance.returnType,  
 * SPDX-License-Identifier: Apache-2.0
                        return new ScriptMethodInfo(
                return EXECUTE;
            );  
            case GETTER:
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.AbstractSerializingTestCase;
package org.opensearch.action.admin.cluster.storedscripts;
            default:
 * ownership. Elasticsearch licenses this file to you under  
                            instance.name,
    }
    static ScriptMethodInfo mutate(ScriptMethodInfo instance) {
        int mutateIndex = randomIntBetween(0, instances.size() - 1);  
 * software distributed under the License is distributed on an
            }
                    instance.parameters
    private static final int MAX_LENGTH = 16;
    enum NameType {  
    protected ScriptMethodInfo createTestInstance() {  
                    randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),
                    randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),  
                        );
    protected ScriptMethodInfo doParseInstance(XContentParser parser) throws IOException {
    }
                        instance.returnType + randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),
    private static final String GET_PREFIX = "get";
                    case 0:  
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;  
/*  
    }  
public class ScriptMethodInfoSerializingTests extends AbstractSerializingTestCase<ScriptMethodInfo> {  
        return ScriptMethodInfo.fromXContent(parser);
                        );
    }  
                }
            suffixes.add(suffix);
    }
        }
        switch (type) {  
