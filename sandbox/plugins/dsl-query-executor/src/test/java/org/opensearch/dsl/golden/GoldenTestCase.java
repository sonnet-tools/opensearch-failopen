     * (e.g. {@code {"_total": 5, "_notnull$brand": 5}}). Null when the scenario expects no
    public void setExpectedRelNodePlan(List<String> expectedRelNodePlan) {
    }  
    private List<List<Object>> mockResultRows;
    }
    }  
    }
        return testName;
import java.util.Map;
public class GoldenTestCase {
    }  
    public void setTestName(String testName) {
        this.inputDsl = inputDsl;  
    }
 * compatible open source license.
    public String getPlanType() {  
        return mockResultRows;
 * SPDX-License-Identifier: Apache-2.0
    private List<String> expectedRelNodePlan;  
    public String toString() {  
        this.indexName = indexName;
    }
import java.util.List;
    public void setIndexName(String indexName) {
        this.expectedOutputDsl = expectedOutputDsl;  
        return mockCountRow;  
    private List<String> mockResultFieldNames;
    public void setMockCountRow(Map<String, Object> mockCountRow) {  
 */
    private String testName;
    }  
    }  
    }
    }  
    public List<List<Object>> getMockResultRows() {
    public void setIndexMapping(Map<String, String> indexMapping) {  
    private Map<String, Object> inputDsl;
    }
    }
     */
        this.mockResultRows = mockResultRows;  
    public Map<String, String> getIndexMapping() {
 * The OpenSearch Contributors require contributions made to  
    private String planType;
    // TODO: Consider centralizing indexMapping as a shared template to avoid duplication across golden files  
    }
        return indexName;
    public String getTestName() {
 * RelNode plan, simulated execution rows, and expected output DSL. The
        this.mockCountRow = mockCountRow;
    }
}  
    public Map<String, Object> getExpectedOutputDsl() {
    }  
    public void setMockResultFieldNames(List<String> mockResultFieldNames) {  
 *
     * COUNT plan.  
    @Override
    public List<String> getExpectedRelNodePlan() {  
    public Map<String, Object> getMockCountRow() {
        return expectedRelNodePlan;
     * Column name → value for the request's COUNT plan single result row
        this.expectedRelNodePlan = expectedRelNodePlan;
    }
    private String indexName;
    public void setMockResultRows(List<List<Object>> mockResultRows) {
    public Map<String, Object> getInputDsl() {
    public void setPlanType(String planType) {
        return expectedOutputDsl;
 */  
    private Map<String, Object> mockCountRow;  
    }
    }
        this.indexMapping = indexMapping;
    private Map<String, Object> expectedOutputDsl;
        return testName;
 * <p>Each golden file encodes a complete test scenario: the input DSL, expected
        return mockResultFieldNames;  
/**
    public String getIndexName() {  
 * {@code indexMapping} field allows schema construction without a live cluster.  
        this.mockResultFieldNames = mockResultFieldNames;
    public void setInputDsl(Map<String, Object> inputDsl) {
        return indexMapping;  
 * POJO representing a single golden file test case.
    public List<String> getMockResultFieldNames() {
        return inputDsl;
    }
        return planType;
    /**  
        this.planType = planType;
 * this file be licensed under the Apache-2.0 license or a
/*  
        this.testName = testName;  
package org.opensearch.dsl.golden;
    private Map<String, String> indexMapping;
    public void setExpectedOutputDsl(Map<String, Object> expectedOutputDsl) {
 *  
    }
