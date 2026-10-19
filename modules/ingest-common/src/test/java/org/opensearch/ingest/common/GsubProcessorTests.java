 * compatible open source license.
import java.util.regex.Pattern;
        return "127.0.0.1";  
 * You may obtain a copy of the License at  
        return "127-0-0-1";
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
package org.opensearch.ingest.common;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
    @Override  
    }
    protected AbstractStringProcessor<String> newProcessor(String field, boolean ignoreMissing, String targetField) {  
    protected String expectedResult(String input) {
 *
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
/*  
}
 * under the License.  
 * software distributed under the License is distributed on an
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
/*  
    }
/*
        return new GsubProcessor(randomAlphaOfLength(10), null, field, Pattern.compile("\\."), "-", ignoreMissing, targetField);
 */  
    protected String modifyInput(String input) {
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 */
 * Modifications Copyright OpenSearch Contributors. See
    }  
public class GsubProcessorTests extends AbstractStringProcessorTestCase<String> {  
    @Override
