 *  
 * compatible open source license.
    }  
/*  
import org.opensearch.common.xcontent.XContentType;
 * Unless required by applicable law or agreed to in writing,
 */  
package org.opensearch.common.xcontent.support.filtering;
 * ownership. Elasticsearch licenses this file to you under  
    protected void assertFilterResult(XContentBuilder expected, XContentBuilder actual) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected XContentType getXContentType() {
 */
 * GitHub history for details.
 * not use this file except in compliance with the License.
        }
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
/*
}
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 *
            assertXContentBuilderAsString(expected, actual);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        } else {  
    }  
 * this file be licensed under the Apache-2.0 license or a
public class YamlFilteringGeneratorTests extends AbstractXContentFilteringTestCase {
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {
    @Override  
 * under the License.  
/*  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        return XContentType.YAML;
            assertXContentBuilderAsBytes(expected, actual);
 * software distributed under the License is distributed on an
 */  
 * license agreements. See the NOTICE file distributed with
