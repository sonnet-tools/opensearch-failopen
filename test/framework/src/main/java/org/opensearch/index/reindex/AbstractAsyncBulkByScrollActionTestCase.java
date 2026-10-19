 * KIND, either express or implied.  See the License for the
    }  
import org.opensearch.threadpool.TestThreadPool;
    @Before
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected PlainActionFuture<Response> listener() {
        threadPool.shutdown();
 *
        task.setWorker(Float.POSITIVE_INFINITY, null);  
 * software distributed under the License is distributed on an
        return new PlainActionFuture<>();
import org.opensearch.threadpool.ThreadPool;
        task = new BulkByScrollTask(1, "test", "test", "test", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
/*  
}
 */  
public abstract class AbstractAsyncBulkByScrollActionTestCase<
    }  
    protected ThreadPool threadPool;
 *  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.OpenSearchTestCase;  
        super.tearDown();
    Request extends AbstractBulkByScrollRequest<Request>,  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
import org.junit.After;  
import org.opensearch.action.support.PlainActionFuture;
 */
 * this file be licensed under the Apache-2.0 license or a
        threadPool = new TestThreadPool(getTestName());
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
    public void setupForTest() {  
import java.util.Collections;  
import org.opensearch.core.tasks.TaskId;
 * The OpenSearch Contributors require contributions made to  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
    @Override
    protected BulkByScrollTask task;  
/*
    protected abstract Request request();
package org.opensearch.index.reindex;
    @After
 *
    public void tearDown() throws Exception {  
import org.junit.Before;
/*  
 */  
    Response extends BulkByScrollResponse> extends OpenSearchTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
