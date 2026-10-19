 */
package org.opensearch.persistent;
                new NamedWriteableRegistry.Entry(PersistentTaskState.class, TestPersistentTasksExecutor.NAME, State::new)
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
public class UpdatePersistentTaskRequestTests extends AbstractWireSerializingTestCase<Request> {
 * Modifications Copyright OpenSearch Contributors. See  
 */
 * The OpenSearch Contributors require contributions made to  
 */  
 *
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
/*
/*
 *  
 * GitHub history for details.
    }  
    protected Request createTestInstance() {
    @Override
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;
 * compatible open source license.
            Collections.singletonList(
import org.opensearch.persistent.UpdatePersistentTaskStatusAction.Request;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
            )  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;
import org.opensearch.common.UUIDs;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
/*  
import org.opensearch.persistent.TestPersistentTasksPlugin.State;  
 * this work for additional information regarding copyright
}  
        return new Request(UUIDs.base64UUID(), randomLong(), new State(randomAlphaOfLength(10)));
        return new NamedWriteableRegistry(  
import org.opensearch.core.common.io.stream.Writeable;
 * software distributed under the License is distributed on an
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    protected Writeable.Reader<Request> instanceReader() {  
import org.opensearch.test.AbstractWireSerializingTestCase;  
    }
        return Request::new;
 * not use this file except in compliance with the License.
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *
 * specific language governing permissions and limitations
 * under the License.  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
