 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 */
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        return input.toLowerCase(Locale.ROOT);
 *
import java.util.Locale;
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
}
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.ingest.common;
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
    protected AbstractStringProcessor<String> newProcessor(String field, boolean ignoreMissing, String targetField) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Modifications Copyright OpenSearch Contributors. See
        return new LowercaseProcessor(randomAlphaOfLength(10), null, field, ignoreMissing, targetField);  
/*
    protected String expectedResult(String input) {
 *
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
/*  
public class LowercaseProcessorTests extends AbstractStringProcessorTestCase<String> {  
    @Override  
 * license agreements. See the NOTICE file distributed with
 */  
 *  
 * this work for additional information regarding copyright
