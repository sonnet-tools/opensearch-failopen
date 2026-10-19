            case "long":  
                return "0L";
 * the Apache License, Version 2.0 (the "License"); you may
                return "0.0f";
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
/*  
    @Override
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
            List<Object> list = new ArrayList<>();  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
                return null;
    }
import static org.hamcrest.Matchers.equalTo;
            case "int":
        String[] fill = new String[size];  
import org.hamcrest.Matcher;
            return equalTo(Integer.toString(index));  
            case "double":
    @Override  
 *
    private String fillValue(String valueType) {
    }  
        } else {
}  
 * under the License.  
            case "short":
 */  
                return "(byte) 0";
            for (int i = 0; i < size; i++) {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            }
/*
        switch (valueType) {  
        }  
                return equalTo("Index: " + index + ", Size: " + size);
            case "float":  
 * GitHub history for details.
package org.opensearch.painless;
            // This exception is locale dependent so we attempt to reproduce it
/*  
public class ListTests extends ArrayLikeObjectTestCase {
/** Tests for working with lists. */  
        Arrays.fill(fill, fillValue(valueType));
import java.util.ArrayList;  
    protected Matcher<String> outOfBoundsExceptionMessageMatcher(int index, int size) {
    @Override
import java.util.Arrays;
                return "(short) 0";  
    }
        if ("1.8".equals(Runtime.class.getPackage().getSpecificationVersion())) {
    protected String declType(String valueType) {  
            case "byte":
        return "List";
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
            Exception e = expectThrows(IndexOutOfBoundsException.class, () -> list.get(index));
            }  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 *  
 * specific language governing permissions and limitations
            return equalTo(e.getMessage());
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 *
                list.add(new Object());
                return "0";
        }  
    }
        return "[" + String.join(",", fill) + "]";
            if (index > size) {  
 * You may obtain a copy of the License at  
    protected String valueCtorCall(String valueType, int size) {
            default:
import java.util.List;
                return "0.0"; // Double is implicit for decimal constants  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
