 * compatible open source license.
/*
/*  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    @Override  
 * not use this file except in compliance with the License.
}  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 *  
    }  
    protected void assertFilterResult(XContentBuilder expected, XContentBuilder actual) {  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentBuilder;
 * this file be licensed under the Apache-2.0 license or a
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
public class CborXContentFilteringTests extends AbstractXContentFilteringTestCase {
 * Licensed to Elasticsearch under one or more contributor  
 */  
        assertXContentBuilderAsBytes(expected, actual);
    }
    protected XContentType getXContentType() {
 * ownership. Elasticsearch licenses this file to you under  
 */  
 */
 * You may obtain a copy of the License at  
package org.opensearch.common.xcontent.support.filtering;
        return XContentType.CBOR;
 * this work for additional information regarding copyright
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
import org.opensearch.common.xcontent.XContentType;
 * license agreements. See the NOTICE file distributed with
