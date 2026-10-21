                        randomAlphaOfLength(randomIntBetween(4, 10)),
                for (int parameter = 0; parameter < parameterSize; ++parameter) {
            int readOnly = randomIntBetween(1, parameterSize - 1);
import org.opensearch.core.common.io.stream.Writeable;
                parameters.add(randomAlphaOfLengthBetween(1, 20));
 * license agreements. See the NOTICE file distributed with
                    methods,
        List<PainlessContextMethodInfo> importedMethods = new ArrayList<>(importedMethodsSize);
                    randomBoolean(),
            List<PainlessContextFieldInfo> fields = new ArrayList<>();
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
                new PainlessContextClassInfo(
 * SPDX-License-Identifier: Apache-2.0
                    randomAlphaOfLength(randomIntBetween(4, 10)),
                    readOnly,
                        parameters
            for (int parameter = 0; parameter < parameterSize; ++parameter) {
            for (int field = 0; field < fieldsSize; ++field) {
        for (int importedMethod = 0; importedMethod < importedMethodsSize; ++importedMethod) {
            int parameterSize = randomIntBetween(2, 5);
            instanceBindings.add(
    }
            classes.add(
                List<String> parameters = new ArrayList<>(parameterSize);
    @Override
                    randomAlphaOfLength(randomIntBetween(4, 10)),
        return PainlessContextInfo::new;
                    randomAlphaOfLength(randomIntBetween(4, 10)),
                        randomAlphaOfLength(randomIntBetween(4, 10)),
        }
                parameters.add(randomAlphaOfLengthBetween(1, 20));
                List<String> parameters = new ArrayList<>(parameterSize);
/*
        for (int classBinding = 0; classBinding < classBindingsSize; ++classBinding) {
/*
                    )
        int classBindingsSize = randomInt(3);
            List<PainlessContextConstructorInfo> constructors = new ArrayList<>(constructorsSize);
        int classesSize = randomIntBetween(20, 100);
            }
 *
            int staticMethodsSize = randomInt(4);
            for (int staticField = 0; staticField < staticFieldsSize; ++staticField) {
                );
 * specific language governing permissions and limitations
            }
                    parameters
                    )
            for (int parameter = 0; parameter < parameterSize; ++parameter) {
            );
            List<String> parameters = new ArrayList<>(parameterSize);
 */
            }
            }
                    randomAlphaOfLength(randomIntBetween(4, 10)),
            int parameterSize = randomInt(12);
            }
            );
            }
            int methodsSize = randomInt(10);
                    new PainlessContextFieldInfo(
 * Modifications Copyright OpenSearch Contributors. See
                    )
                    randomAlphaOfLength(randomIntBetween(4, 10)),
        return PainlessContextInfo.fromXContent(parser);
    @Override
                        randomAlphaOfLength(randomIntBetween(4, 10)),
import org.opensearch.test.AbstractSerializingTestCase;
                        randomAlphaOfLength(randomIntBetween(4, 10)),
                        randomAlphaOfLength(randomIntBetween(4, 10)),
        for (int instanceBinding = 0; instanceBinding < instanceBindingsSize; ++instanceBinding) {
        int importedMethodsSize = randomInt(4);
 * You may obtain a copy of the License at
                staticFields.add(
 * compatible open source license.
/*
            List<PainlessContextFieldInfo> staticFields = new ArrayList<>();
import java.util.ArrayList;
public class ContextInfoTests extends AbstractSerializingTestCase<PainlessContextInfo> {
 * Licensed to Elasticsearch under one or more contributor
            List<String> parameters = new ArrayList<>(parameterSize);
                }
            for (int staticMethod = 0; staticMethod < staticMethodsSize; ++staticMethod) {
                int parameterSize = randomInt(12);
    protected PainlessContextInfo createTestInstance() {
                for (int parameter = 0; parameter < parameterSize; ++parameter) {
 * under the License.
    @Override
                    staticFields
                    new PainlessContextMethodInfo(
            classBindings.add(
                        parameters
        List<PainlessContextClassInfo> classes = new ArrayList<>();
 *
                );
                )
                    parameters
                    parameters
                parameters.add(randomAlphaOfLengthBetween(1, 20));
                );
            int staticFieldsSize = randomInt(10);
                }
    protected Writeable.Reader<PainlessContextInfo> instanceReader() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    new PainlessContextMethodInfo(
                staticMethods.add(
                );
    }
                for (int parameter = 0; parameter < parameterSize; ++parameter) {
                        randomAlphaOfLength(randomIntBetween(4, 10)),
import java.util.List;
            List<PainlessContextMethodInfo> staticMethods = new ArrayList<>(staticMethodsSize);
                new PainlessContextInstanceBindingInfo(
 * the Apache License, Version 2.0 (the "License"); you may
            for (int method = 0; method < methodsSize; ++method) {
 * KIND, either express or implied.  See the License for the
                new PainlessContextMethodInfo(
            List<String> parameters = new ArrayList<>(parameterSize);
                    randomAlphaOfLength(randomIntBetween(4, 10)),
}
    protected PainlessContextInfo doParseInstance(XContentParser parser) {
                List<String> parameters = new ArrayList<>(parameterSize);
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    new PainlessContextFieldInfo(
            int fieldsSize = randomInt(4);
                    constructors,
import org.opensearch.core.xcontent.XContentParser;
                        randomAlphaOfLength(randomIntBetween(4, 10)),
                        randomAlphaOfLength(randomIntBetween(4, 10))
            List<PainlessContextMethodInfo> methods = new ArrayList<>(methodsSize);
            }
                    staticMethods,
                fields.add(
                        randomAlphaOfLength(randomIntBetween(4, 10)),
                    randomAlphaOfLength(randomIntBetween(3, 200)),
        }
        int instanceBindingsSize = randomInt(3);
            ;
 * ownership. Elasticsearch licenses this file to you under
            for (int parameter = 0; parameter < parameterSize; ++parameter) {
            int constructorsSize = randomInt(4);
 * this file be licensed under the Apache-2.0 license or a
                    randomAlphaOfLength(randomIntBetween(4, 10)),
package org.opensearch.painless.action;
 * software distributed under the License is distributed on an
        }
 */
        for (int clazz = 0; clazz < classesSize; ++clazz) {
                int parameterSize = randomInt(12);
        return new PainlessContextInfo(randomAlphaOfLength(20), classes, importedMethods, classBindings, instanceBindings);
            int parameterSize = randomInt(12);
                        randomAlphaOfLength(randomIntBetween(4, 10)),
    }
            for (int constructor = 0; constructor < constructorsSize; ++constructor) {
                )
 * The OpenSearch Contributors require contributions made to
 * this work for additional information regarding copyright
                )
                        randomAlphaOfLength(randomIntBetween(4, 10)),
                    fields,
                int parameterSize = randomInt(12);
                    randomAlphaOfLength(randomIntBetween(4, 10)),
 *
                    parameters.add(randomAlphaOfLengthBetween(1, 20));
            );
                    parameters.add(randomAlphaOfLengthBetween(1, 20));
                )
 */
                constructors.add(new PainlessContextConstructorInfo(randomAlphaOfLength(randomIntBetween(4, 10)), parameters));
        }
            importedMethods.add(
            );
                    )
 * not use this file except in compliance with the License.
        List<PainlessContextClassBindingInfo> classBindings = new ArrayList<>(classBindingsSize);
                }
                    parameters.add(randomAlphaOfLengthBetween(1, 20));
                new PainlessContextClassBindingInfo(
                    randomAlphaOfLength(randomIntBetween(4, 10)),
                methods.add(
                        randomAlphaOfLength(randomIntBetween(4, 10))
        List<PainlessContextInstanceBindingInfo> instanceBindings = new ArrayList<>(classBindingsSize);
