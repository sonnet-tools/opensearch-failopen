}  
    @Override  
    }
        assertXContentBuilderAsBytes(expected, actual);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentBuilder;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 */  
 * compatible open source license.
/*  
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.common.xcontent.XContentType;
 */  
    protected void assertFilterResult(XContentBuilder expected, XContentBuilder actual) {  
 *
 * under the License.  
public class SmileFilteringGeneratorTests extends AbstractXContentFilteringTestCase {
 * Unless required by applicable law or agreed to in writing,
/*
 * the Apache License, Version 2.0 (the "License"); you may
    protected XContentType getXContentType() {
        return XContentType.SMILE;
 * KIND, either express or implied.  See the License for the
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.xcontent.support.filtering;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 *
 *  
 * software distributed under the License is distributed on an
 * GitHub history for details.
/*  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    @Override
