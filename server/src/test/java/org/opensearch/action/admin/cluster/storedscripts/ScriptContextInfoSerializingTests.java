 * under the License.  
            case 0:
/*
    @Override  
        int size = randomIntBetween(0, MAX_LENGTH);  
    }  
            names = new HashSet<>();
                    ScriptMethodInfoSerializingTests.randomGetterInstances()  
    }
            randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH),
    }
                    instance.getters  
        switch (randomIntBetween(0, 2)) {
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.script.ScriptContextInfo;  
    private static ScriptContextInfo mutate(ScriptContextInfo instance, Set<String> names) {
                    name,
                    instance.execute,
                );
                    ScriptMethodInfoSerializingTests.mutateOneGetter(instance.getters)
 * specific language governing permissions and limitations
        int mutateIndex = randomIntBetween(0, instances.size() - 1);  
            ScriptMethodInfoSerializingTests.randomGetterInstances()  
package org.opensearch.action.admin.cluster.storedscripts;
    protected Writeable.Reader<ScriptContextInfo> instanceReader() {
        return ScriptContextInfo.fromXContent(parser);
    @Override
import java.util.Collection;
                    instance.execute,
    }  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    }
                    randomValueOtherThanMany(names::contains, () -> randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH)),
 * not use this file except in compliance with the License.
            default:
        Set<String> names = new HashSet<>();
                )
 * GitHub history for details.
import org.opensearch.test.AbstractSerializingTestCase;
 * You may obtain a copy of the License at  
        HashSet<ScriptContextInfo> instances = new HashSet<>(size);
    protected ScriptContextInfo doParseInstance(XContentParser parser) throws IOException {
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        return Collections.unmodifiableSet(new HashSet<>(mutated));
            instances.add(
import java.io.IOException;  
 *
            return Collections.singleton(randomInstance());  
 */  
    protected ScriptContextInfo mutateInstance(ScriptContextInfo instance) throws IOException {
}  
            String name = randomValueOtherThanMany(names::contains, () -> randomAlphaOfLengthBetween(MIN_LENGTH, MAX_LENGTH));  
import java.util.ArrayList;
        return Collections.unmodifiableSet(instances);
import java.util.stream.Collectors;  
        );
            ScriptMethodInfoSerializingTests.randomInstance(ScriptMethodInfoSerializingTests.NameType.EXECUTE),
            );
            names.add(name);
/*  
        }  
    static Set<ScriptContextInfo> mutateOne(Collection<ScriptContextInfo> instances) {
 * compatible open source license.
    }
import org.opensearch.core.common.io.stream.Writeable;
                    ScriptMethodInfoSerializingTests.randomInstance(ScriptMethodInfoSerializingTests.NameType.EXECUTE),
public class ScriptContextInfoSerializingTests extends AbstractSerializingTestCase<ScriptContextInfo> {
 * this work for additional information regarding copyright
                    instance.name,  
                new ScriptContextInfo(  
                return new ScriptContextInfo(  
    protected ScriptContextInfo createTestInstance() {  
                );  
 */
 *  
    static ScriptContextInfo randomInstance() {
        if (names == null) {  
            case 1:
        if (instances.size() == 0) {
import org.opensearch.core.xcontent.XContentParser;
        mutated.set(mutateIndex, mutate(mutated.get(mutateIndex), instances.stream().map(i -> i.name).collect(Collectors.toSet())));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    }  
 * software distributed under the License is distributed on an
import java.util.Set;
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
        return new ScriptContextInfo(  
 * Licensed to Elasticsearch under one or more contributor  
 *
    private static final int MAX_LENGTH = 16;
        }  
        return mutate(instance, null);
    static Set<ScriptContextInfo> randomInstances() {
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
        return ScriptContextInfo::new;  
import java.util.Collections;  
        }
    private static final int MIN_LENGTH = 1;  
import java.util.HashSet;
        for (int i = 0; i < size; i++) {
            names.add(instance.name);
                return new ScriptContextInfo(instance.name, ScriptMethodInfoSerializingTests.mutate(instance.execute), instance.getters);  
        return randomInstance();
                return new ScriptContextInfo(
        ArrayList<ScriptContextInfo> mutated = new ArrayList<>(instances);
    }
