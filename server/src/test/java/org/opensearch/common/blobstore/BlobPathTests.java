        assertThat(path.buildAsString(), is("a/"));  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    }
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
/*
 * this work for additional information regarding copyright
        path = path.add("a");
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(path.buildAsString(), is(""));  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 */  
        assertThat(path.buildAsString(), is("a/b/c/d/"));  
package org.opensearch.common.blobstore;
 * license agreements. See the NOTICE file distributed with
 *
 * compatible open source license.
public class BlobPathTests extends OpenSearchTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.is;  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(path.buildAsString(), is("a/b/c/"));  
 * specific language governing permissions and limitations
    public void testBuildAsString() {
 * Modifications Copyright OpenSearch Contributors. See
 *
 */
}
 */  
        BlobPath path = new BlobPath();
import org.opensearch.test.OpenSearchTestCase;
        path = path.add("d/");
 * software distributed under the License is distributed on an
        path = path.add("b").add("c");
 *  
 * this file be licensed under the Apache-2.0 license or a
