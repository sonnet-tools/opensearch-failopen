 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 *
import java.lang.reflect.Constructor;
        return new StackTraceElement(declaringClass.getName(), memberName, fileName, lineNumber);
/*  
    public static Object forMember(Member member) {
/**
        int lineNumber = -1;  
package org.opensearch.common.inject.internal;
 *
 */  
 * See the License for the specific language governing permissions and
        }
 * http://www.apache.org/licenses/LICENSE-2.0  
import java.lang.reflect.Member;
        String fileName = null;
 * Licensed under the Apache License, Version 2.0 (the "License");
        return new StackTraceElement(implementation.getName(), "class", fileName, lineNumber);
 * Unless required by applicable law or agreed to in writing, software
 */  
 */
    }  
        String fileName = null;
        Class declaringClass = member.getDeclaringClass();  
}
 * this file be licensed under the Apache-2.0 license or a
        if (member == null) {
 * You may obtain a copy of the License at
        int lineNumber = -1;  
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * @opensearch.internal  
 *
 */
            return SourceProvider.UNKNOWN_SOURCE;  
        String memberName = memberType == Constructor.class ? "<init>" : member.getName();  
 * GitHub history for details.
public class StackTraceElements {
/*
        Class<? extends Member> memberType = MoreTypes.memberType(member);
 * you may not use this file except in compliance with the License.  
 * Copyright (C) 2006 Google Inc.  
 *
 * compatible open source license.
 *  
 * The OpenSearch Contributors require contributions made to  
 * @author crazybob@google.com (Bob Lee)
    }
 * limitations under the License.  
    public static Object forType(Class<?> implementation) {
 * Creates stack trace elements for members.
/*  
