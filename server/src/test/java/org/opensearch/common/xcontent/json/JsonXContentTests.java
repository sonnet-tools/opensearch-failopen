 *
        doTestBigInteger(generator, os);
 */
 */  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
    @Override
/*
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    public XContentType xcontentType() {  
import org.opensearch.common.xcontent.XContentType;
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
}  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        JsonGenerator generator = new JsonFactory().createGenerator(os);  
 *  
import java.io.ByteArrayOutputStream;
    public void testBigInteger() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * compatible open source license.
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.xcontent.json;
 * license agreements. See the NOTICE file distributed with
import tools.jackson.core.JsonGenerator;  
        return XContentType.JSON;
/*  
    }
 * ownership. Elasticsearch licenses this file to you under  
public class JsonXContentTests extends BaseXContentTestCase {  
 * specific language governing permissions and limitations
import tools.jackson.core.json.JsonFactory;
 */  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
import org.opensearch.common.xcontent.BaseXContentTestCase;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
