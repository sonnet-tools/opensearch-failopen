 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    protected String expectedResult(String input) {
public class HtmlStripProcessorTests extends AbstractStringProcessorTestCase<String> {
 * Licensed to Elasticsearch under one or more contributor  
 *
    @Override
 */
    }
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 */  
 * compatible open source license.
 * this work for additional information regarding copyright
    @Override  
/*  
 *
 * license agreements. See the NOTICE file distributed with
        return new HtmlStripProcessor(randomAlphaOfLength(10), null, field, ignoreMissing, targetField);
        return "\ntest" + input + "\ntest";  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    protected AbstractStringProcessor<String> newProcessor(String field, boolean ignoreMissing, String targetField) {
 * Unless required by applicable law or agreed to in writing,
        return "<p><b>test</b>" + input + "<p><b>test</b>";
    protected String modifyInput(String input) {  
/*
}
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
/*  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.ingest.common;
 * this file be licensed under the Apache-2.0 license or a
    }  
 * GitHub history for details.
 *  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
