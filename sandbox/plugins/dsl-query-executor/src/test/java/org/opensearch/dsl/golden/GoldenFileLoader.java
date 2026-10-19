    }
        } catch (IllegalArgumentException e) {
    /**
     * Throws {@link IllegalArgumentException} identifying the file and the
package org.opensearch.dsl.golden;
 * <p>Each golden file is a self-contained JSON document parsed into a
import java.io.IOException;
 * Loads and validates golden file test cases.
 *  
        } catch (IOException e) {  
public class GoldenFileLoader {
     * @param goldenFileName file name (e.g. {@code "term_query_hits.json"})
 * SPDX-License-Identifier: Apache-2.0
        requireNonNull(testCase.getPlanType(), "planType", filePath);
import org.opensearch.dsl.executor.QueryPlans;  
            validate(testCase, Path.of(resourcePath));
        requireNonNull(testCase.getExpectedOutputDsl(), "expectedOutputDsl", filePath);  
        requireNonNull(testCase.getIndexMapping(), "indexMapping", filePath);
            validate(testCase, goldenFilePath);
    private GoldenFileLoader() {}
        requireNonNull(testCase.getMockResultRows(), "mockResultRows", filePath);
 * aggregation test cases must additionally include {@code aggregationMetadata}.  
     * Loads a golden file by name from the classpath resource directory
        requireNonNull(testCase.getIndexName(), "indexName", filePath);  
     * {@code src/test/resources/golden/}.
            return testCase;
            if (is == null) {  
 * {@link GoldenTestCase}. Required fields are validated after parsing;
     *         required fields
     * @throws IllegalArgumentException if the file is malformed or has missing
        String resourcePath = RESOURCE_DIR + goldenFileName;
import com.fasterxml.jackson.databind.ObjectMapper;
    private static void requireNonNull(Object value, String fieldName, Path filePath) {  
        }
 */  
 * this file be licensed under the Apache-2.0 license or a
     * @param goldenFilePath path to the JSON golden file
     * @return parsed and validated test case  
            throw new IllegalArgumentException("Golden file " + filePath + " has invalid planType: " + testCase.getPlanType());
 *
        requireNonNull(testCase.getInputDsl(), "inputDsl", filePath);
 * compatible open source license.
     */
     *         has missing required fields
            throw new IllegalArgumentException("Failed to parse golden file: " + resourcePath, e);
    /**  
        }  
    }  
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public static GoldenTestCase load(String goldenFileName) {  
/*  
            throw new IllegalArgumentException("Golden file " + filePath + " missing required field: " + fieldName);
import java.nio.file.Path;
    }  
     */  
            GoldenTestCase testCase = MAPPER.readValue(is, GoldenTestCase.class);  
    public static GoldenTestCase load(Path goldenFilePath) {
     *  
     * Validates that all required fields are present in the parsed test case.  
     * missing field.
    /**
            GoldenTestCase testCase = MAPPER.readValue(is, GoldenTestCase.class);  
        }
        try (InputStream is = Files.newInputStream(goldenFilePath)) {
        } catch (IOException e) {  
        requireNonNull(testCase.getExpectedRelNodePlan(), "expectedRelNodePlan", filePath);  
            throw new IllegalArgumentException("Failed to parse golden file: " + goldenFilePath, e);
import java.nio.file.Files;
     * @throws IllegalArgumentException if the file is missing, malformed, or  
    private static void validate(GoldenTestCase testCase, Path filePath) {
}
        if (value == null) {
        }  
import java.io.InputStream;  
        try {
            return testCase;
     *
        requireNonNull(testCase.getMockResultFieldNames(), "mockResultFieldNames", filePath);
     * Loads a golden file from an absolute or relative file-system path.  
     * @return parsed and validated test case
                throw new IllegalArgumentException("Golden file not found on classpath: " + resourcePath);
    }
 * The OpenSearch Contributors require contributions made to  
            QueryPlans.Type.valueOf(testCase.getPlanType());  
     */  
        requireNonNull(testCase.getTestName(), "testName", filePath);
    private static final String RESOURCE_DIR = "golden/";
        try (InputStream is = GoldenFileLoader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            }
 */
/**
