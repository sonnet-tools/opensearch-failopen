        }
            Version.CURRENT
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.is;  
 */
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
import org.opensearch.Version;  
 * ownership. Elasticsearch licenses this file to you under  
    public void testSerialization() throws Exception {
        }  
        @Override  
import java.util.Collections;
            super.writeTo(out);
        assertThat(result.isShardsAcknowledged(), is(true));
 * compatible open source license.
        ShardsAcknowledgedResponse testInstance = new TestImpl(true, true);
import org.opensearch.core.common.io.stream.StreamOutput;  
            in -> new TestImpl(in, true),
        }
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * this work for additional information regarding copyright
            super(acknowledged, shardsAcknowledged);  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
            new NamedWriteableRegistry(Collections.emptyList()),  
 * Licensed to Elasticsearch under one or more contributor  
            super(in, readShardsAcknowledged);
        public void writeTo(StreamOutput out) throws IOException {
            writeShardsAcknowledged(out);  
 * software distributed under the License is distributed on an
/*
 */  
}
 *
            testInstance,
        ShardsAcknowledgedResponse result = copyWriteable(
import org.opensearch.core.common.io.stream.StreamInput;
 *  
 * The OpenSearch Contributors require contributions made to  
        assertThat(result.isAcknowledged(), is(true));
 *
    }  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        private TestImpl(boolean acknowledged, boolean shardsAcknowledged) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
        private TestImpl(StreamInput in, boolean readShardsAcknowledged) throws IOException {
import java.io.IOException;  
/*
 * not use this file except in compliance with the License.
    }
 */
package org.opensearch.action.support.clustermanager;
public class ShardsAcknowledgedResponseTests extends OpenSearchTestCase {
        );  
    private static class TestImpl extends ShardsAcknowledgedResponse {
 * Unless required by applicable law or agreed to in writing,
