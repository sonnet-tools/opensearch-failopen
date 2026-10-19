 * KIND, either express or implied.  See the License for the
    }
public class RestartPersistentTaskRequestTests extends AbstractWireSerializingTestCase<Request> {
        return Request::new;
/*
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.AbstractWireSerializingTestCase;
 * specific language governing permissions and limitations
    protected Writeable.Reader<Request> instanceReader() {  
/*  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 * this work for additional information regarding copyright
 */
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new Request(randomAlphaOfLength(10), randomLong(), null);
 * Modifications Copyright OpenSearch Contributors. See  
    protected Request createTestInstance() {
 *
 */
}  
import org.opensearch.core.common.io.stream.Writeable;  
/*
 */  
 * compatible open source license.
package org.opensearch.persistent;
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    @Override  
 *
 * GitHub history for details.
import org.opensearch.persistent.CompletionPersistentTaskAction.Request;
