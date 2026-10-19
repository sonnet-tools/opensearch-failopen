 */  
    public ExampleSystemIngestProcessorClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {  
        return OpenSearchClientYamlSuiteTestCase.createParameters();  
    public static Iterable<Object[]> parameters() throws Exception {
 * compatible open source license.
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
    }
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 *
}
import com.carrotsearch.randomizedtesting.annotations.Name;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
public class ExampleSystemIngestProcessorClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 * SPDX-License-Identifier: Apache-2.0
    @ParametersFactory
/*  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.example.systemingestprocessor;
    }
 * this file be licensed under the Apache-2.0 license or a
        super(testCandidate);
