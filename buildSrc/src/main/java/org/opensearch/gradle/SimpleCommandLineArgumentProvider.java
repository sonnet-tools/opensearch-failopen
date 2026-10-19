    public Iterable<String> asArguments() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.arguments = Arrays.asList(arguments);
/**  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * arguments as inputs, so this is useful for passing arguments that should not be used for the purposes of input snapshotting.
 * under the License.  
import java.util.Arrays;  
 * The OpenSearch Contributors require contributions made to  
    }
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * A {@link CommandLineArgumentProvider} implementation that simply returns the given list. This implementation does not track any
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
}  
import java.util.List;
 */  
 *  
package org.opensearch.gradle;
 *
 */  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
/*
    private final List<String> arguments;
import org.gradle.process.CommandLineArgumentProvider;
    }  
/*  
/*  
 * this work for additional information regarding copyright
        return arguments;
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    public SimpleCommandLineArgumentProvider(String... arguments) {
public class SimpleCommandLineArgumentProvider implements CommandLineArgumentProvider {
 */
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 */  
