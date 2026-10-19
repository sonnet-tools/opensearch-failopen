    private TestEnvironment() {}
package org.opensearch.env;
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * Unless required by applicable law or agreed to in writing,
/*
/*  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * Provides a convenience method for tests to construct an Environment when the config path does not matter.
 */
 */  
 * software distributed under the License is distributed on an
public class TestEnvironment {
 * compatible open source license.
 *
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
        return new Environment(settings, null);
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * this work for additional information regarding copyright
}  
 * about what the config path needs to be set to.  
 *  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * This is in the test framework to force people who construct an Environment in production code to think
 *
    public static Environment newEnvironment(Settings settings) {  
