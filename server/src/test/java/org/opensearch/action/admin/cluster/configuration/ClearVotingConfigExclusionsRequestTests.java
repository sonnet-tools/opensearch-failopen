    public void testSerialization() throws IOException {
 * under the License.  
 */
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        final ClearVotingConfigExclusionsRequest originalRequest = new ClearVotingConfigExclusionsRequest();  
 */  
 * ownership. Elasticsearch licenses this file to you under  
        );
        }  
        assertThat(deserialized.getWaitForRemoval(), equalTo(originalRequest.getWaitForRemoval()));  
        if (randomBoolean()) {
public class ClearVotingConfigExclusionsRequestTests extends OpenSearchTestCase {
        }  
 *  
 * compatible open source license.
/*  
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
            originalRequest.setTimeout(TimeValue.timeValueMillis(randomLongBetween(0, 30000)));
import org.opensearch.common.unit.TimeValue;  
            ClearVotingConfigExclusionsRequest::new
 * specific language governing permissions and limitations
 *
 *
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 */
import java.io.IOException;  
        final ClearVotingConfigExclusionsRequest deserialized = copyWriteable(
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
package org.opensearch.action.admin.cluster.configuration;
import static org.hamcrest.Matchers.equalTo;
        assertThat(deserialized.getTimeout(), equalTo(originalRequest.getTimeout()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            originalRequest,
            originalRequest.setWaitForRemoval(randomBoolean());
 * software distributed under the License is distributed on an
}  
            writableRegistry(),  
 * You may obtain a copy of the License at  
