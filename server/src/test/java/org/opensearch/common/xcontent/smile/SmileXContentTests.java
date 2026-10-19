 *  
        doTestBigInteger(generator, os);
 * software distributed under the License is distributed on an
        return XContentType.SMILE;
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        JsonGenerator generator = new SmileFactory().createGenerator(os);  
 * not use this file except in compliance with the License.
 *
 * ownership. Elasticsearch licenses this file to you under  
/*
package org.opensearch.common.xcontent.smile;
 */
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
/*  
    public XContentType xcontentType() {  
 *
    public void testBigInteger() throws Exception {
 * compatible open source license.
/*  
import org.opensearch.common.xcontent.XContentType;
 * You may obtain a copy of the License at  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.xcontent.BaseXContentTestCase;
    @Override
import java.io.ByteArrayOutputStream;
 * GitHub history for details.
import tools.jackson.core.JsonGenerator;  
        ByteArrayOutputStream os = new ByteArrayOutputStream();
import tools.jackson.dataformat.smile.SmileFactory;
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
public class SmileXContentTests extends BaseXContentTestCase {  
    }
 */  
 * this work for additional information regarding copyright
