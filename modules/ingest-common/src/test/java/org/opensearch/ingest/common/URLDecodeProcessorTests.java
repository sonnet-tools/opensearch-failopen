 * the Apache License, Version 2.0 (the "License"); you may
    protected String expectedResult(String input) {
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
}  
    private static String urlEncode(String s) {  
/*  
 * GitHub history for details.
 * under the License.  
    protected String modifyInput(String input) {
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    }
 * The OpenSearch Contributors require contributions made to  
    protected AbstractStringProcessor<String> newProcessor(String field, boolean ignoreMissing, String targetField) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return URLEncoder.encode(s, StandardCharsets.UTF_8);
import java.net.URLEncoder;
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 */  
 *  
 * You may obtain a copy of the License at  
public class URLDecodeProcessorTests extends AbstractStringProcessorTestCase<String> {
import java.net.URLDecoder;
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
import java.nio.charset.StandardCharsets;  
package org.opensearch.ingest.common;
 * this work for additional information regarding copyright
/*  
    }  
        return "Hello Günter" + URLDecoder.decode(urlEncode(input), StandardCharsets.UTF_8);  
    }
        return new URLDecodeProcessor(randomAlphaOfLength(10), null, field, ignoreMissing, targetField);
    @Override
    }
        return "Hello%20G%C3%BCnter" + urlEncode(input);
    @Override  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
/*
 *
 *
 * this file be licensed under the Apache-2.0 license or a
