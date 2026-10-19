 * Licensed to Elasticsearch under one or more contributor  
 *
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * Provides a static final field that can be used to check if assertions are enabled. Since this field might be used elsewhere to check if
 * license agreements. See the NOTICE file distributed with
    public static final boolean ENABLED;
    }  
         * are disabled enabled will have the value false.
 *     http://www.apache.org/licenses/LICENSE-2.0
        ENABLED = enabled;
 *
        boolean enabled = false;
 */
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
        // noinspection ConstantConditions,AssertWithSideEffects
/*
 */
 * The OpenSearch Contributors require contributions made to  
 *  
}
 * software distributed under the License is distributed on an
package org.opensearch.core;
/**
 *
    private Assertions() {
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
public final class Assertions {
 * GitHub history for details.
 * class too (e.g., {@code -ea org.opensearch.core.Assertions -ea org.opensearch.cluster.service.ClusterManagerService}).
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static {
 * ownership. Elasticsearch licenses this file to you under  
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
         */  
        assert enabled = true;
 * KIND, either express or implied.  See the License for the
         * If assertions are enabled, the following line will be evaluated and enabled will have the value true, otherwise when assertions
        // noinspection ConstantConditions  
 */  
 * assertions are enabled, if you are running with assertions enabled for specific packages or classes, you should enable assertions on this  
 */  
 * compatible open source license.
        /*  
 * @opensearch.internal  
