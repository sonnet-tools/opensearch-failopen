 * compatible open source license.
public class ClientAssertions {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
}  
 *  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.MatcherAssert.assertThat;
 * You may obtain a copy of the License at  
package org.opensearch.test;
 * GitHub history for details.
 */
 */  
 * under the License.  
import static org.hamcrest.CoreMatchers.equalTo;  
 *
    }
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        assertThat(response.getClass().getSimpleName() + " failed - not acked", response.isAcknowledged(), equalTo(true));  
/*
import org.opensearch.client.core.AcknowledgedResponse;
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
/*  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * KIND, either express or implied.  See the License for the
    public static void assertAcked(AcknowledgedResponse response) {
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
