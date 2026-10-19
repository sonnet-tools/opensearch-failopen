    }
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
import tools.jackson.core.JsonGenerator;  
    public void testBigInteger() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import tools.jackson.dataformat.cbor.CBORFactory;
        JsonGenerator generator = new CBORFactory().createGenerator(os);  
 * specific language governing permissions and limitations
 */
import org.opensearch.common.xcontent.XContentType;
 * GitHub history for details.
        doTestBigInteger(generator, os);
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
/*
package org.opensearch.common.xcontent.cbor;
        return XContentType.CBOR;
import org.opensearch.common.xcontent.BaseXContentTestCase;
 * Licensed to Elasticsearch under one or more contributor  
        ByteArrayOutputStream os = new ByteArrayOutputStream();
 *
/*  
 * Modifications Copyright OpenSearch Contributors. See
public class CborXContentTests extends BaseXContentTestCase {  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 *
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public XContentType xcontentType() {  
 *  
import java.io.ByteArrayOutputStream;
/*  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    @Override
 */  
}  
    }
 */  
