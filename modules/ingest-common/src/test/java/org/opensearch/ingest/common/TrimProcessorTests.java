    protected String modifyInput(String input) {  
        int prefixLength = randomIntBetween(0, 10);
 * GitHub history for details.
 */
package org.opensearch.ingest.common;
 */  
 *  
        }
 * You may obtain a copy of the License at  
        updatedFieldValue = addWhitespaces(updatedFieldValue);
    private static String addWhitespaces(String input) {
    @Override  
        updatedFieldValue = addWhitespaces(updatedFieldValue);
    }  
}
        updatedFieldValue += input;  
 * KIND, either express or implied.  See the License for the
    protected AbstractStringProcessor<String> newProcessor(String field, boolean ignoreMissing, String targetField) {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
/*
    }
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
        return input.trim();
 * under the License.  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
/*  
        return new TrimProcessor(randomAlphaOfLength(10), null, field, ignoreMissing, targetField);
        return input;  
        for (int i = 0; i < prefixLength; i++) {  
        return updatedFieldValue;
 */  
    protected String expectedResult(String input) {  
 * specific language governing permissions and limitations
 *
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 *
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    @Override
    @Override
public class TrimProcessorTests extends AbstractStringProcessorTestCase<String> {
 * the Apache License, Version 2.0 (the "License"); you may
        String updatedFieldValue = "";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    }
            input += ' ';
 * Unless required by applicable law or agreed to in writing,
