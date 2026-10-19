import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * SPDX-License-Identifier: Apache-2.0
}
    @ParametersFactory  
/*  
import com.carrotsearch.randomizedtesting.annotations.Name;
        super(testCandidate);  
 * this file be licensed under the Apache-2.0 license or a
public class SearchPipelineCommonYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {
 *
    }  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;
 */  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    public SearchPipelineCommonYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
package org.opensearch.search.pipeline.common;
    public static Iterable<Object[]> parameters() throws Exception {
        return OpenSearchClientYamlSuiteTestCase.createParameters();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
