 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * You may obtain a copy of the License at  
import org.opensearch.common.xcontent.BaseXContentTestCase;
/*  
 * compatible open source license.
 */  
 *  
        JsonGenerator generator = new YAMLFactory().createGenerator(os);  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
        return XContentType.YAML;
 * Licensed to Elasticsearch under one or more contributor  
 *
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.ByteArrayOutputStream;
 */
 * license agreements. See the NOTICE file distributed with
    }
 *
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
import tools.jackson.dataformat.yaml.YAMLFactory;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.common.xcontent.yaml;
import tools.jackson.core.JsonGenerator;  
        doTestBigInteger(generator, os);
}  
public class YamlXContentTests extends BaseXContentTestCase {  
    }
 * not use this file except in compliance with the License.
        ByteArrayOutputStream os = new ByteArrayOutputStream();
 */  
    @Override
/*
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    public XContentType xcontentType() {  
 * specific language governing permissions and limitations
import org.opensearch.common.xcontent.XContentType;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    public void testBigInteger() throws Exception {
