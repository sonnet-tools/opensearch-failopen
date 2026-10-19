 * specific language governing permissions and limitations
         * Constructs a new put index template request with the provided name.
        public String[] indices() {
            this.cause = cause;
 * GitHub history for details.
        }
import org.opensearch.core.common.Strings;  
        /**
        public IndicesOptions indicesOptions() {  
                && Objects.equals(this.cause, other.cause)
 */
    /**  
        @Override
 * The OpenSearch Contributors require contributions made to  
            return indexTemplate.indexPatterns().toArray(Strings.EMPTY_ARRAY);
                    && indexTemplate.template() != null
    public static final String NAME = "indices:admin/index_template/put";  
            this.indexTemplate = template;
         * The index template that will be inserted into the cluster state
            }
        public String cause() {  
            sb.append(", create=").append(create);  
            sb.append(", index_template=").append(indexTemplate);
import org.opensearch.common.regex.Regex;
            return this.cause;
                        validationException  
            validationException = validateIndexTemplate(validationException);
    @PublicApi(since = "1.0.0")
            Request other = (Request) obj;
        }
            sb.append(", cause=").append(cause);
                && this.create == other.create;  
public class PutComposableIndexTemplateAction extends ActionType<AcknowledgedResponse> {  
            } else {
            }
        public void writeTo(StreamOutput out) throws IOException {
         * The cause for this index template creation.
        }  
 * KIND, either express or implied.  See the License for the
        @Override
                    validationException = addValidationError(
                if (indexTemplate.indexPatterns().stream().anyMatch(Regex::isMatchAllPattern)  
    }
            super.writeTo(out);  
     *
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
 * compatible open source license.
            this.name = name;
                return false;  
        @Override  
         */  
            sb.append("]");
            StringBuilder sb = new StringBuilder("PutTemplateV2Request[");  
        private final String name;
}
@PublicApi(since = "1.0.0")
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * ownership. Elasticsearch licenses this file to you under  
                    );
    public static final PutComposableIndexTemplateAction INSTANCE = new PutComposableIndexTemplateAction();
        @Nullable
        }
import org.opensearch.action.support.IndicesOptions;
        public Request(StreamInput in) throws IOException {
            if (indexTemplate == null) {  
 *
import static org.opensearch.action.ValidateActions.addValidationError;
            return create;  
        }
            return Objects.hash(name, cause, create, indexTemplate);  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
     * A request for putting a single index template into the cluster state
        /**  
        }  
            return this.indexTemplate;
            this.indexTemplate = new ComposableIndexTemplate(in);  
        /**
 * software distributed under the License is distributed on an
        @Override  
            this.name = in.readString();  
        public Request(String name) {  
        private String cause;  
        }
            super(in);
            return this;
 * not use this file except in compliance with the License.
 */  
import org.opensearch.action.ActionRequestValidationException;
            this.create = in.readBoolean();
        public Request create(boolean create) {  
        private boolean create;
            }  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
            return this;  
                && Objects.equals(this.indexTemplate, other.indexTemplate)
        }  
            if (getClass() != obj.getClass()) {
                if (indexTemplate.priority() != null && indexTemplate.priority() < 0) {  
            sb.append("name=").append(name);
 * Modifications Copyright OpenSearch Contributors. See
        }  
 * @opensearch.api  
    private PutComposableIndexTemplateAction() {
        public ComposableIndexTemplate indexTemplate() {  
 * license agreements. See the NOTICE file distributed with
            out.writeOptionalString(cause);
        public String name() {
import org.opensearch.common.Nullable;  
         * Set to {@code true} to force only creation, not an update of an index template. If it already  
         */
        public boolean equals(Object obj) {
         * exists, it will fail with an {@link IllegalArgumentException}.
 *
            return validationException;
 */  
 *
        }
        /**  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.ActionType;
            return sb.toString();  
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
            return Objects.equals(this.name, other.name)  
import org.opensearch.core.common.io.stream.StreamOutput;
                    validationException = addValidationError("index template priority must be >= 0", validationException);
         */
        @Override
 * SPDX-License-Identifier: Apache-2.0
            this.indexTemplate.writeTo(out);
     */
        @Override
        public Request cause(@Nullable String cause) {  
            return IndicesOptions.strictExpand();
                validationException = addValidationError("name is missing", validationException);
    public static class Request extends ClusterManagerNodeRequest<Request> implements IndicesRequest {  
                return false;  
        }
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        @Override
        @Nullable
            ActionRequestValidationException validationException = null;  
        }
         */  
        public boolean create() {
/*  
 * under the License.  
    }
package org.opensearch.action.admin.indices.template.put;
            }  
        }  
                }
         * The name of the index template.
            return this;
            this.cause = in.readOptionalString();
        public Request indexTemplate(ComposableIndexTemplate template) {
            if (obj == null) {
            return this.name;
     * @opensearch.api  
                }
        public int hashCode() {
            if (name == null || Strings.hasText(name) == false) {
        super(NAME, AcknowledgedResponse::new);  
import org.opensearch.core.common.io.stream.StreamInput;
                validationException = addValidationError("an index template is required", validationException);
            this.create = create;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * An action for putting a composable template into the cluster state
            out.writeBoolean(create);  
        public String toString() {
 */
/*  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.action.IndicesRequest;  
        }
            out.writeString(name);
                    && IndexMetadata.INDEX_HIDDEN_SETTING.exists(indexTemplate.template().settings())) {  
        private ComposableIndexTemplate indexTemplate;
        public ActionRequestValidationException validate() {
import java.io.IOException;
                    && indexTemplate.template().settings() != null
            return validationException;
 * You may obtain a copy of the License at  
        public ActionRequestValidationException validateIndexTemplate(@Nullable ActionRequestValidationException validationException) {
        }
import java.util.Objects;
/*
        }
                        "global composable templates may not specify the setting " + IndexMetadata.INDEX_HIDDEN_SETTING.getKey(),
        }
        /**
         */
 * this file be licensed under the Apache-2.0 license or a
