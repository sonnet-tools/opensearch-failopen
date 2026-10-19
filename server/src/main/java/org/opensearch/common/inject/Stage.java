 * The OpenSearch Contributors require contributions made to  
public enum Stage {
 *
     * We want to catch errors as early as possible and take performance hits up front.
 *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    /**  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * Unless required by applicable law or agreed to in writing, software
 * you may not use this file except in compliance with the License.  
 * Licensed under the Apache License, Version 2.0 (the "License");
 */  
 * GitHub history for details.
 * http://www.apache.org/licenses/LICENSE-2.0  
 * The stage we're running in.
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 *
 * See the License for the specific language governing permissions and
    PRODUCTION  
 * compatible open source license.
     * We're running in a tool (an IDE plugin for example). We need binding meta data but not a
     */
 */
 * @opensearch.api
 *
    /**
 * this file be licensed under the Apache-2.0 license or a
 *
     * checking.
     * We want fast startup times at the expense of runtime performance and some up front error
    TOOL,
 *
 */  
/*  
/*  
 */  
 * You may obtain a copy of the License at
     * functioning Injector. Do not inject members of instances. Do not load eager singletons. Do as  
     * little as possible so our tools run nice and snappy. Injectors created in this stage cannot
    DEVELOPMENT,
package org.opensearch.common.inject;
/*
@PublicApi(since = "1.0.0")
     */  
}
import org.opensearch.common.annotation.PublicApi;
    /**  
     * be used to satisfy injections.
     */  
/**  
 * limitations under the License.  
 * @author crazybob@google.com (Bob Lee)  
 * Copyright (C) 2006 Google Inc.  
