        return new RegexMatcher(regex);
 * ownership. Elasticsearch licenses this file to you under  
        return new RegexMatcher(regex, flag);  
 * You may obtain a copy of the License at  
 *
import java.util.regex.Pattern;
public class RegexMatcher extends TypeSafeMatcher<String> {  
 * under the License.  
    protected boolean matchesSafely(String item) {
        this.pattern = Pattern.compile(regex, flag);  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        this.regex = regex;
 *  
    @Override
        this.pattern = Pattern.compile(regex);
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public static RegexMatcher matches(String regex) {
package org.opensearch.test.hamcrest;
    public void describeTo(Description description) {  
 * KIND, either express or implied.  See the License for the
    public static RegexMatcher matches(String regex, int flag) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Matcher that supports regular expression and allows to provide optional flags
 * compatible open source license.
    public RegexMatcher(String regex, int flag) {
    }
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
}
 * GitHub history for details.
 *
 * software distributed under the License is distributed on an
 */
    public RegexMatcher(String regex) {
    }
        description.appendText(regex);
/*  
 */  
    }  
        return pattern.matcher(item).find();
import org.hamcrest.TypeSafeMatcher;
    private final String regex;
 */
    }  
        this.regex = regex;  
    }
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
 * specific language governing permissions and limitations
import org.hamcrest.Description;
    }
    private final Pattern pattern;  
 * not use this file except in compliance with the License.
/**  
/*
 * license agreements. See the NOTICE file distributed with
