import org.opensearch.core.xcontent.XContentParser;
     * @return A new TemplateQueryBuilder instance.
            int startVar = template.indexOf("\"${", start);
        return Objects.equals(this.content, other.content);
 * The OpenSearch Contributors require contributions made to
    }
        Map<String, Object> contextVariables = convertedQueryCoordinateContext.getContextVariables();
     */
     * @throws IOException If there's an error during rewriting.
import java.util.stream.Collectors;
            variablesMap = contextVariables.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> {
            }
     * Constructs a TemplateQueryBuilder from a stream input.
/*
 *
     */
public class TemplateQueryBuilder extends AbstractQueryBuilder<TemplateQueryBuilder> {
    @Override
            builder.map(this.content);
    }
            if (endVar == -1) {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    /**
        } catch (Exception e) {
        out.writeMap(content);
                } catch (IOException e) {
            return newQueryBuilder;
            QueryBuilder newQueryBuilder = parseInnerQueryBuilder(parser);
        builder.field(NAME, content);
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
            if (startVar == -1) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
import org.opensearch.core.xcontent.XContentBuilder;
    public Map<String, Object> getContent() {
            if (replacement == null) {
}
        if (template.isEmpty() || template.equals("{}")) {
        return new TemplateQueryBuilder(parser.map());
     * Constructs a new TemplateQueryBuilder with the given content.
            start = endVar + 2;
    /**
     */
 * compatible open source license.
    protected QueryBuilder doRewrite(QueryRewriteContext queryCoordinatorContext) throws IOException {
    private String replaceVariables(String template, Map<String, String> variables) {
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.common.xcontent.XContentType;
                throw new IllegalArgumentException("Variable not found: " + varName);
    }
    public static TemplateQueryBuilder fromXContent(XContentParser parser) throws IOException {
        return result.toString();
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    @Override
    }
                throw new IllegalArgumentException("Unclosed variable in template: " + template.substring(startVar));
                    throw new RuntimeException("Error converting contextVariables to JSON string", e);
     * Creates a TemplateQueryBuilder from XContent.
 * this file be licensed under the Apache-2.0 license or a
/**
 * A query builder that constructs a query based on a template and context variables.
                }
    }
    }
            throw new IllegalStateException(
        if (variables == null || variables.isEmpty()) {
            "Template queries cannot be converted directly to a query. Template Query must be rewritten first during doRewrite."
        super(in);
        throw new IllegalStateException(
        }
            int endVar = template.indexOf("}\"", startVar);
        // the queryRewrite is expected at QueryCoordinator level
        }
import java.util.Map;
import org.opensearch.core.common.io.stream.StreamInput;
            String varName = template.substring(startVar + 3, endVar);
    }
    @Override
            }
     * @param in The StreamInput to read from.
    public TemplateQueryBuilder(Map<String, Object> content) {
            throw new IllegalArgumentException("Template string cannot be null. A valid template must be provided.");
                    return JsonXContent.contentBuilder().value(entry.getValue()).toString();
     * @param parser The XContentParser to read from.
     *
import org.apache.lucene.search.Query;
     * @param queryCoordinatorContext The context for query rewriting.
import java.util.Objects;
    protected int doHashCode() {
                result.append(template.substring(start));
    }
    @Override
        if (!(queryCoordinatorContext instanceof QueryCoordinatorContext)) {
     *
    /**
        }
    }
    public static final String queryName = "template";
    /**
    @Override
            String replacement = variables.get(varName);
    /**
        }
     */
    @Override
        );
        String queryString;
        }
                "Template Query must be rewritten at the coordinator node. Rewriting at shard level is not supported."
        QueryCoordinatorContext convertedQueryCoordinateContext = (QueryCoordinatorContext) queryCoordinatorContext;
                try {
 * SPDX-License-Identifier: Apache-2.0
    public String getWriteableName() {
            return template;
 */
     */
import java.io.IOException;
    public static final String NAME = "template";
        if (template == null || template.equals("null")) {
            throw new IllegalArgumentException("Template string cannot be empty. A valid template must be provided.");
import org.opensearch.common.xcontent.XContentFactory;
        this.content = content;
    protected void doWriteTo(StreamOutput out) throws IOException {
            );
        }
    }
        try {
                break;
     * @throws IOException If there's an error parsing the content.
     * @throws IOException If there's an error reading from the stream.
     * @param content The template content as a map.
        StringBuilder result = new StringBuilder();
        return Objects.hash(content);
            result.append(replacement);
        if (contextVariables != null) {
     * @return The template content as a map.
    protected boolean doEquals(TemplateQueryBuilder other) {
 * This query is designed to be rewritten with variables from search processors.
package org.opensearch.index.query;
        // Convert Map<String, Object> to Map<String, String> with proper JSON escaping
        this.content = in.readMap();
    protected Query doToQuery(QueryShardContext context) throws IOException {
 */
    public TemplateQueryBuilder(StreamInput in) throws IOException {
        int start = 0;
    }
            }));
import org.opensearch.core.common.io.stream.StreamOutput;
                .createParser(queryCoordinatorContext.getXContentRegistry(), LoggingDeprecationHandler.INSTANCE, newQueryContent);
        return content;
     *
     * @return A rewritten QueryBuilder.
    @Override
            throw new IllegalArgumentException("Failed to rewrite template query: " + newQueryContent, e);
            queryString = builder.toString();
        while (true) {
        return NAME;
     *
            XContentParser parser = XContentType.JSON.xContent()
        }
            result.append(template, start, startVar);
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        String newQueryContent = replaceVariables(queryString, variablesMap);
     *
        Map<String, String> variablesMap = null;
            }
        }
    }
     * Rewrites the template query by substituting variables from the context.
    private final Map<String, Object> content;
     * Gets the content of this template query.
