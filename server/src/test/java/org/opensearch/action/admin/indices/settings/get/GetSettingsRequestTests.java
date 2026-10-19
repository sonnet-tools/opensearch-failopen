 * license agreements. See the NOTICE file distributed with
public class GetSettingsRequestTests extends OpenSearchTestCase {
        GetSettingsRequest deserialized = new GetSettingsRequest(si);
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * KIND, either express or implied.  See the License for the
        byte[] responseBytes = BytesReference.toBytes(bso.bytes());  
import java.io.IOException;  
 * software distributed under the License is distributed on an
/*  
 * this file be licensed under the Apache-2.0 license or a
 *
        TEST_700_REQUEST.writeTo(bso);
 */  
/*  
 * under the License.  
 * not use this file except in compliance with the License.
    public void testSerdeRoundTrip() throws IOException {
        StreamInput si = StreamInput.wrap(responseBytes);
        .humanReadable(true)
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        .names("test_setting_key");  
}
    }
        BytesStreamOutput bso = new BytesStreamOutput();  
 */  
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesReference;
 * GitHub history for details.
 * this work for additional information regarding copyright
 *
        assertEquals(TEST_700_REQUEST, deserialized);  
 * specific language governing permissions and limitations
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;  
 */
    private static final GetSettingsRequest TEST_700_REQUEST = new GetSettingsRequest().includeDefaults(true)  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        .indices("test_index")
 *  
package org.opensearch.action.admin.indices.settings.get;
