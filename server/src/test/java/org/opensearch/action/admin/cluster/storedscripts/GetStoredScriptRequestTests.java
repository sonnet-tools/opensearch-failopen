 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.admin.cluster.storedscripts;
 * ownership. Elasticsearch licenses this file to you under  
        GetStoredScriptRequest request = new GetStoredScriptRequest("id");  
 * Modifications Copyright OpenSearch Contributors. See
 */
        BytesStreamOutput out = new BytesStreamOutput();
import static org.opensearch.test.VersionUtils.randomVersion;
/*
 *
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.io.stream.BytesStreamOutput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        GetStoredScriptRequest request2 = new GetStoredScriptRequest(in);
/*  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 *
 * compatible open source license.
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
        in.setVersion(out.getVersion());
        StreamInput in = out.bytes().streamInput();  
    public void testGetIndexedScriptRequestSerialization() throws IOException {
import static org.hamcrest.CoreMatchers.equalTo;
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
 * under the License.  
    }
        assertThat(request2.id(), equalTo(request.id()));
        out.setVersion(randomVersion(random()));  
}  
import org.opensearch.test.OpenSearchTestCase;  
public class GetStoredScriptRequestTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
/*  
        request.writeTo(out);
 */  
 *  
 * Unless required by applicable law or agreed to in writing,
 */  
