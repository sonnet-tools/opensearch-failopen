 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
    public Function<String, Predicate<String>> getFieldFilter() {
import java.util.function.Function;
import java.util.function.Predicate;
 * KIND, either express or implied.  See the License for the
import org.opensearch.plugins.Plugin;
 * Unless required by applicable law or agreed to in writing,
public class MockFieldFilterPlugin extends Plugin implements MapperPlugin {
 * ownership. Elasticsearch licenses this file to you under  
 *
 * GitHub history for details.
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 */
 * this work for additional information regarding copyright
 *
 * not use this file except in compliance with the License.
    @Override  
/*
 * license agreements. See the NOTICE file distributed with
/*  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 */  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    }
        return index -> field -> true;  
 * You may obtain a copy of the License at  
/*  
 * under the License.  
}
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.mapper;
        // this filter doesn't filter any field out, but it's used to exercise the code path executed when the filter is not no-op
import org.opensearch.plugins.MapperPlugin;
