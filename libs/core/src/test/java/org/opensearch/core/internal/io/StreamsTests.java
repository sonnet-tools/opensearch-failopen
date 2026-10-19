 */  
        ByteArrayInputStream in = new ByteArrayInputStream(content);  
 * Unless required by applicable law or agreed to in writing,
import java.nio.charset.StandardCharsets;
 * this work for additional information regarding copyright
import java.io.ByteArrayOutputStream;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.io.Streams;
 * ownership. Elasticsearch licenses this file to you under  
 *  
/*  
        byte[] content = "content".getBytes(StandardCharsets.UTF_8);
        long count = Streams.copy(in, out);
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
    public void testCopyFromInputStream() throws IOException {
 *
import org.opensearch.test.OpenSearchTestCase;
        ByteArrayOutputStream out = new ByteArrayOutputStream(content.length);
}
/*
 * KIND, either express or implied.  See the License for the
package org.opensearch.core.internal.io;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
import java.io.ByteArrayInputStream;
/*  
import static org.hamcrest.Matchers.equalTo;
 * software distributed under the License is distributed on an
public class StreamsTests extends OpenSearchTestCase {  
 */
 * GitHub history for details.
import java.util.Arrays;
 * compatible open source license.
import java.io.IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 *
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(count, equalTo((long) content.length));
    }  
 */  
        assertThat(Arrays.equals(content, out.toByteArray()), equalTo(true));
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
