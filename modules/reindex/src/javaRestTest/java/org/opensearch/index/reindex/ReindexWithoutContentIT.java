            () -> client().performRequest(new Request("POST", "/_reindex"))
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 *
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */
    }  
 * You may obtain a copy of the License at  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.client.Request;
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
}
 *  
 * software distributed under the License is distributed on an
        assertThat(responseException.getMessage(), containsString("request body is required"));
public class ReindexWithoutContentIT extends OpenSearchRestTestCase {  
            ResponseException.class,
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * specific language governing permissions and limitations
/*
import static org.hamcrest.CoreMatchers.containsString;
/*  
        assertEquals(400, responseException.getResponse().getStatusLine().getStatusCode());
 */  
 * this work for additional information regarding copyright
package org.opensearch.index.reindex;
/*  
    public void testReindexMissingBody() throws IOException {
import org.opensearch.client.ResponseException;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        ResponseException responseException = expectThrows(  
        );  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
