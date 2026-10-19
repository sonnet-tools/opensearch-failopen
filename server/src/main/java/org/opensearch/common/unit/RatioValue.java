 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * under the License.  
        return this.percent + "%";
            } catch (NumberFormatException e) {  
 * Licensed to Elasticsearch under one or more contributor  
    }  
    public String toString() {  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        return this.percent / 100.0;
    public RatioValue(double percent) {
import org.opensearch.OpenSearchParseException;
                return new RatioValue(Math.abs(percent));
 * @opensearch.internal  
 * specific language governing permissions and limitations
    /**
package org.opensearch.common.unit;
        }
        if (sValue.endsWith("%")) {
 * Unless required by applicable law or agreed to in writing,
        this.percent = percent;  
    public double getAsRatio() {  
 *
                if (ratio < 0 || ratio > 1.0) {  
     * Parses the provided string as a {@link RatioValue}, the string can
 * The OpenSearch Contributors require contributions made to  
}
     * either be in percentage format (eg. 73.5%), or a floating-point ratio  
 * You may obtain a copy of the License at  
     */
     * format (eg. 0.735)
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
                throw new OpenSearchParseException("Invalid ratio or percentage [{}]", sValue);
 * ownership. Elasticsearch licenses this file to you under  
                double ratio = Double.parseDouble(sValue);
 * software distributed under the License is distributed on an
                }
 * Utility class to represent ratio and percentage values between 0 and 100
            try {
                return new RatioValue(100.0 * Math.abs(ratio));  
 */  
            } catch (NumberFormatException e) {
 *  
    }  
/*  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this.percent;
                throw new OpenSearchParseException("Failed to parse [{}] as a double", e, percentAsString);
 */
            }
            try {  
/**  
public class RatioValue {
        } else {  
    private final double percent;  
 * GitHub history for details.
            }  
    }
    }
    }
                }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    public double getAsPercent() {
                final double percent = Double.parseDouble(percentAsString);
    public static RatioValue parseRatioValue(String sValue) {  
            final String percentAsString = sValue.substring(0, sValue.length() - 1);
    @Override
/*
                if (percent < 0 || percent > 100) {
 * license agreements. See the NOTICE file distributed with
 *
 * KIND, either express or implied.  See the License for the
                    throw new OpenSearchParseException("Percentage should be in [0-100], got [{}]", percentAsString);  
 *
                    throw new OpenSearchParseException("Ratio should be in [0-1.0], got [{}]", ratio);
