        return new NamedWriteableRegistry(
import org.opensearch.persistent.TestPersistentTasksPlugin.TestParams;
 * You may obtain a copy of the License at  
            testParams.setExecutorNodeAttr(randomAlphaOfLengthBetween(1, 20));
    protected Writeable.Reader<Request> instanceReader() {
 * SPDX-License-Identifier: Apache-2.0
 */
 *
import org.opensearch.test.AbstractWireSerializingTestCase;
 * under the License.  
import org.opensearch.persistent.StartPersistentTaskAction.Request;
 */  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            Collections.singletonList(new Entry(PersistentTaskParams.class, TestPersistentTasksExecutor.NAME, TestParams::new))  
 * ownership. Elasticsearch licenses this file to you under  
/*  
public class StartPersistentActionRequestTests extends AbstractWireSerializingTestCase<Request> {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
}  
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
        if (randomBoolean()) {
        return new Request(UUIDs.base64UUID(), randomAlphaOfLengthBetween(1, 20), testParams);
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 */
    }
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        }  
 *
        if (randomBoolean()) {
        return Request::new;  
 * not use this file except in compliance with the License.
 *  
 * software distributed under the License is distributed on an
    protected Request createTestInstance() {
            testParams.setTestParam(randomAlphaOfLengthBetween(1, 20));
import org.opensearch.persistent.TestPersistentTasksPlugin.TestPersistentTasksExecutor;  
 * GitHub history for details.
import java.util.Collections;  
    }
import org.opensearch.core.common.io.stream.Writeable;  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
        }  
package org.opensearch.persistent;
 * The OpenSearch Contributors require contributions made to  
        TestParams testParams = new TestParams();  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
import org.opensearch.common.UUIDs;  
/*
        );
 * this work for additional information regarding copyright
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
/*
