 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.Writeable;  
    protected Status createTestInstance() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
package org.opensearch.persistent;
 * KIND, either express or implied.  See the License for the
 */
/*  
    @Override
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        return new Status(randomFrom(AllocatedPersistentTask.State.values()));
 * license agreements. See the NOTICE file distributed with
public class PersistentTasksNodeServiceStatusTests extends AbstractWireSerializingTestCase<Status> {  
/*
 *  
import org.opensearch.persistent.PersistentTasksNodeService.Status;
 * ownership. Elasticsearch licenses this file to you under  
 *
import static org.hamcrest.Matchers.containsString;
    protected Writeable.Reader<Status> instanceReader() {
 * Unless required by applicable law or agreed to in writing,
        return Status::new;  
import org.opensearch.test.AbstractWireSerializingTestCase;
}  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * not use this file except in compliance with the License.
        assertThat(createTestInstance().toString(), containsString("state"));
 * under the License.  
    public void testToString() {  
/*
 * this work for additional information regarding copyright
    }
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
    }
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
 * compatible open source license.
    }
