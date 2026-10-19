import java.util.LinkedHashMap;  
    @Input  
            .stream()
 * under the License.  
}
import java.util.function.Supplier;
 *  
import org.gradle.process.CommandLineArgumentProvider;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    }
 * The OpenSearch Contributors require contributions made to  
    }
    public Iterable<String> asArguments() {
    public void systemProperty(String key, Object value) {  
        return systemProperties.keySet();
 * KIND, either express or implied.  See the License for the
package org.opensearch.gradle;
    public void systemProperty(String key, Supplier<String> value) {
    private final Map<String, Object> systemProperties = new LinkedHashMap<>();  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
    }  
 * Unless required by applicable law or agreed to in writing,
/*
                    + (entry.getValue() instanceof Supplier ? ((Supplier) entry.getValue()).get() : entry.getValue())  
 * Modifications Copyright OpenSearch Contributors. See  
        systemProperties.put(key, value);  
                entry -> "-D"  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 */  
        return systemProperties.entrySet()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.stream.Collectors;  
            )
import java.util.Map;
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 *
    // Track system property keys as an input so our build cache key will change if we add properties but values are still ignored
 * compatible open source license.
import org.gradle.api.tasks.Input;  
 */
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
    }  
                    + entry.getKey()
                    + "="
            .collect(Collectors.toList());
    public Iterable<String> getPropertyNames() {
        systemProperties.put(key, value);
 */
/*
            .map(
 *
public class SystemPropertyCommandLineArgumentProvider implements CommandLineArgumentProvider {
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * this work for additional information regarding copyright
/*  
 * GitHub history for details.
