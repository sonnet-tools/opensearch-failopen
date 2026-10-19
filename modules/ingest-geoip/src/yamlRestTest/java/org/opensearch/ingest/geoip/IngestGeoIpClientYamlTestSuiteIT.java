import com.carrotsearch.randomizedtesting.annotations.Name;
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 *
/*  
 * GitHub history for details.
 *  
    public IngestGeoIpClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
 * the Apache License, Version 2.0 (the "License"); you may
    @ParametersFactory
 */
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
public class IngestGeoIpClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
        super(testCandidate);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 */  
 * KIND, either express or implied.  See the License for the
}
 */  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * You may obtain a copy of the License at  
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
    public static Iterable<Object[]> parameters() throws Exception {
 *
 * this work for additional information regarding copyright
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
/*
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
    }
 * ownership. Elasticsearch licenses this file to you under  
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
package org.opensearch.ingest.geoip;
