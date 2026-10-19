import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
}
    }
    public SmokeTestArrowPluginsClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
    public static Iterable<Object[]> parameters() throws Exception {
 */  
 * SPDX-License-Identifier: Apache-2.0
    @ParametersFactory
    }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
package org.opensearch.smoketest;
public class SmokeTestArrowPluginsClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
        super(testCandidate);
 *
import com.carrotsearch.randomizedtesting.annotations.Name;
