 */  
        final Version opensearchVersion = Version.fromString(opensearchVersionString.replace("-SNAPSHOT", ""));
 * ownership. Elasticsearch licenses this file to you under  
/*  
         * *write* compatible versions but this runs with *index* compatible  
    public boolean preserveClusterUponCompletion() {
 */
 *
        return true;  
 */  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
        final ObjectPath objectPath = ObjectPath.createFromResponse(response);
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
         * to clean up. Also, our cleanup code is really only compatible with
 * specific language governing permissions and limitations
 *  
import org.opensearch.client.Request;
        final Response response = client().performRequest(new Request("GET", "/"));  
 * the Apache License, Version 2.0 (the "License"); you may
 *
import java.text.ParseException;
         */
    @Override
        final org.apache.lucene.util.Version luceneVersion = org.apache.lucene.util.Version.parse(luceneVersionString);  
        final String opensearchVersionString = objectPath.evaluate("version.number").toString();  
import org.opensearch.client.Response;  
}
        assertThat(opensearchVersion.luceneVersion, equalTo(luceneVersion));
 * software distributed under the License is distributed on an
import static org.hamcrest.CoreMatchers.equalTo;
        final String luceneVersionString = objectPath.evaluate("version.lucene_version").toString();
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    public void testLuceneVersionConstant() throws IOException, ParseException {
public class VerifyVersionConstantsIT extends OpenSearchRestTestCase {  
package org.opensearch.qa.verify_version_constants;
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.test.rest.yaml.ObjectPath;
    }
import org.opensearch.Version;
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
         * We don't perform any writes to the cluster so there won't be anything
         * versions.
 * The OpenSearch Contributors require contributions made to  
        /*  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
/*  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.rest.OpenSearchRestTestCase;
/*
 * GitHub history for details.
