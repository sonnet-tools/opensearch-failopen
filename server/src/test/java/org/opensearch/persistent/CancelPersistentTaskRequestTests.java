 * the Apache License, Version 2.0 (the "License"); you may
    }
/*  
 * GitHub history for details.
 * under the License.  
 * KIND, either express or implied.  See the License for the
package org.opensearch.persistent;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.persistent.RemovePersistentTaskAction.Request;
        return Request::new;  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
 *
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiOfLength;
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 */
    protected Request createTestInstance() {  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
}
 *
import org.opensearch.core.common.io.stream.Writeable;  
 */  
 * specific language governing permissions and limitations
public class CancelPersistentTaskRequestTests extends AbstractWireSerializingTestCase<Request> {  
 *  
    @Override
 * not use this file except in compliance with the License.
    protected Writeable.Reader<Request> instanceReader() {
 * compatible open source license.
import org.opensearch.test.AbstractWireSerializingTestCase;
        return new Request(randomAsciiOfLength(10));
/*
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 */
    @Override
