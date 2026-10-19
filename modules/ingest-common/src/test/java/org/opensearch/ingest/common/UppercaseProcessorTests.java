 * GitHub history for details.
        return new UppercaseProcessor(randomAlphaOfLength(10), null, field, ignoreMissing, targetField);
 * specific language governing permissions and limitations
public class UppercaseProcessorTests extends AbstractStringProcessorTestCase<String> {  
 *
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
/*
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
}
    }
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 */  
    }
    protected AbstractStringProcessor<String> newProcessor(String field, boolean ignoreMissing, String targetField) {  
 * software distributed under the License is distributed on an
import java.util.Locale;
 * You may obtain a copy of the License at  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 */  
 * ownership. Elasticsearch licenses this file to you under  
    protected String expectedResult(String input) {
 * the Apache License, Version 2.0 (the "License"); you may
 *
/*  
package org.opensearch.ingest.common;
 * compatible open source license.
        return input.toUpperCase(Locale.ROOT);  
