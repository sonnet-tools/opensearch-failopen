 */  
 * specific language governing permissions and limitations
/*
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
public class JsonXContentFilteringTests extends AbstractXContentFilteringTestCase {
            AbstractXContentFilteringTestCase.assertXContentBuilderAsBytes(expected, actual);
 */  
import org.opensearch.test.OpenSearchTestCase;  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.xcontent.XContentType;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.XContentBuilder;
    }
 *  
    @Override
/*  
 */
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    @Override  
        }  
 * compatible open source license.
            AbstractXContentFilteringTestCase.assertXContentBuilderAsString(expected, actual);  
 *
        } else {
 * You may obtain a copy of the License at  
        if (OpenSearchTestCase.randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    protected void assertFilterResult(XContentBuilder expected, XContentBuilder actual) {
    protected XContentType getXContentType() {
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
package org.opensearch.common.xcontent.support.filtering;
 * KIND, either express or implied.  See the License for the
 * under the License.  
}
/*  
 *
        return XContentType.JSON;  
    }
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
