                } catch (NumberFormatException e) {
 * The OpenSearch Contributors require contributions made to  
                return Long.parseLong(actualValue.toString());  
                    + actualValue
        return field;
        if (expectedValue instanceof Map) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                }
    /**
    public final Object getExpectedValue() {
    }
        }
                try {  
 * this file be licensed under the Apache-2.0 license or a
 *
    }
            if (expectedValue instanceof Float) {
    protected final Object resolveExpectedValue(ClientYamlTestExecutionContext executionContext) throws IOException {  
public abstract class Assertion implements ExecutableSection {
            } else if (expectedValue instanceof Integer) {
    }
    public final void execute(ClientYamlTestExecutionContext executionContext) throws IOException {
 */
     * a utility to get the class of an object, protecting for null (i.e., returning null if the input is null)  
    }
     */
                    + expectedValue.getClass()
 * license agreements. See the NOTICE file distributed with
                return Double.parseDouble(actualValue.toString());
 * software distributed under the License is distributed on an
 * Base class for executable sections that hold assertions  
 */  
        this.expectedValue = expectedValue;
import java.io.IOException;  
/*
        }
        }
    }
    }  
     * Executes the assertion comparing the actual value (parsed from the response) with the expected one
 *  
        }  
    protected final Object getActualValue(ClientYamlTestExecutionContext executionContext) throws IOException {
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
/*  
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;
package org.opensearch.test.rest.yaml.section;
        this.field = field;  
                return Float.parseFloat(actualValue.toString());
            }
                    + expectedValue  
    private final XContentLocation location;  
        // Force a class cast exception here, so developers can flesh out the above logic as needed.  
    private final Object expectedValue;
    }  
                    + actualValue.getClass()
 * Modifications Copyright OpenSearch Contributors. See  
    static Object convertActualValue(Object actualValue, Object expectedValue) {
import org.opensearch.core.xcontent.XContentLocation;  
    /**  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
        return expectedValue;  
                    + ". "  
            return executionContext.stash().replaceStashedValues(map);
 */
        return executionContext.response(field);
    private final String field;
            Map<String, Object> map = (Map<String, Object>) expectedValue;  
 */
    protected abstract void doAssert(Object actualValue, Object expectedValue);  
            } else if (expectedValue instanceof Double) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
        }
            return executionContext.stash().getValue(field);  
    }  
        return o == null ? null : o.getClass();  
 * this work for additional information regarding copyright
                    + ") has type "  
}
    public XContentLocation getLocation() {  
            expectedValue.getClass().cast(actualValue);
                    + "Actual value ("
        return actualValue;
                    return Integer.parseInt(actualValue.toString());  
 * compatible open source license.
                    + "."
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        if (executionContext.stash().containsStashedValue(expectedValue)) {
                "Type mismatch: Expected value ("
        try {
        if (executionContext.stash().containsStashedValue(field)) {
/**
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        this.location = location;
            @SuppressWarnings("unchecked")
        return expectedValue;
     */
    @Override
        if (actualValue instanceof Number && expectedValue instanceof Number) {  
        return location;
    public final String getField() {
 * under the License.  
        doAssert(getActualValue(executionContext), resolveExpectedValue(executionContext));  
import static org.junit.Assert.fail;  
            return actualValue;
    protected Assertion(XContentLocation location, String field, Object expectedValue) {
        if (actualValue == null || expectedValue.getClass().isAssignableFrom(actualValue.getClass())) {  
/*
                    return Long.parseLong(actualValue.toString());
            } else if (expectedValue instanceof Long) {
 *
            fail(
            );  
 * GitHub history for details.
    @Override
                    + ") has type "
    }
        } catch (ClassCastException e) {  
            return executionContext.stash().getValue(expectedValue.toString());
    protected Class<?> safeClass(Object o) {
