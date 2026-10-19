            }
import org.opensearch.core.common.io.stream.StreamOutput;
        this.content = in.readMap();
    }
    private final Map<String, Object> content;
            throw new IllegalStateException(  
    protected Query doToQuery(QueryShardContext context) throws IOException {
    }
            start = endVar + 2;  
     * Creates a TemplateQueryBuilder from XContent.
    private String replaceVariables(String template, Map<String, String> variables) {  
    public TemplateQueryBuilder(StreamInput in) throws IOException {  
    @Override  
        try (XContentBuilder builder = XContentFactory.jsonBuilder()) {  
            return template;
    /**
 */  
            result.append(template, start, startVar);
        }  
    }
 *
        builder.field(NAME, content);  
            throw new IllegalArgumentException("Template string cannot be null. A valid template must be provided.");
        return Objects.hash(content);
import org.apache.lucene.search.Query;
     *  
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
        }  
        if (variables == null || variables.isEmpty()) {
    }
     * @param queryCoordinatorContext The context for query rewriting.
     * @return A rewritten QueryBuilder.
    /**
        if (template.isEmpty() || template.equals("{}")) {
    public Map<String, Object> getContent() {  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
                }
    public static final String NAME = "template";  
            }  
    protected int doHashCode() {
                result.append(template.substring(start));
package org.opensearch.index.query;
import org.opensearch.common.xcontent.json.JsonXContent;
 */  
     * @throws IOException If there's an error reading from the stream.
import java.util.Objects;
                } catch (IOException e) {
/**  
    /**
        return NAME;
                "Template Query must be rewritten at the coordinator node. Rewriting at shard level is not supported."
        Map<String, Object> contextVariables = convertedQueryCoordinateContext.getContextVariables();  
import org.opensearch.core.xcontent.XContentParser;  
    }
    }
        int start = 0;  
     * Constructs a TemplateQueryBuilder from a stream input.
    public static final String queryName = "template";
     *  
        QueryCoordinatorContext convertedQueryCoordinateContext = (QueryCoordinatorContext) queryCoordinatorContext;
        if (template == null || template.equals("null")) {
 * This query is designed to be rewritten with variables from search processors.
        }  
        }
    public static TemplateQueryBuilder fromXContent(XContentParser parser) throws IOException {
import java.util.stream.Collectors;
     *
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     * Gets the content of this template query.
        String queryString;
        super(in);
                throw new IllegalArgumentException("Variable not found: " + varName);  
        Map<String, String> variablesMap = null;  
     */
        out.writeMap(content);
     * @throws IOException If there's an error during rewriting.  
    @Override
    protected boolean doEquals(TemplateQueryBuilder other) {
        }  
        throw new IllegalStateException(
        String newQueryContent = replaceVariables(queryString, variablesMap);
 * The OpenSearch Contributors require contributions made to  
                break;
    @Override  
    public String getWriteableName() {  
            String varName = template.substring(startVar + 3, endVar);  
import java.io.IOException;
    /**
public class TemplateQueryBuilder extends AbstractQueryBuilder<TemplateQueryBuilder> {
    @Override
        // Convert Map<String, Object> to Map<String, String> with proper JSON escaping
                try {  
        return content;
            throw new IllegalArgumentException("Failed to rewrite template query: " + newQueryContent, e);
        }  
            QueryBuilder newQueryBuilder = parseInnerQueryBuilder(parser);  
    public TemplateQueryBuilder(Map<String, Object> content) {  
        try {  
     *  
     * @return The template content as a map.
    }  
     * Constructs a new TemplateQueryBuilder with the given content.
        // the queryRewrite is expected at QueryCoordinator level
            if (endVar == -1) {  
            throw new IllegalArgumentException("Template string cannot be empty. A valid template must be provided.");
            variablesMap = contextVariables.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> {
    @Override
        while (true) {
        } catch (Exception e) {
     */
import java.util.Map;  
     *  
    }  
                throw new IllegalArgumentException("Unclosed variable in template: " + template.substring(startVar));
/*  
     */
            queryString = builder.toString();
     * @param in The StreamInput to read from.  
            if (startVar == -1) {  
import org.opensearch.core.xcontent.XContentBuilder;
        );
            }));
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
     */
}
     */
    }
                    throw new RuntimeException("Error converting contextVariables to JSON string", e);  
    protected QueryBuilder doRewrite(QueryRewriteContext queryCoordinatorContext) throws IOException {  
            );
            int startVar = template.indexOf("\"${", start);
            result.append(replacement);
            if (replacement == null) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            "Template queries cannot be converted directly to a query. Template Query must be rewritten first during doRewrite."  
    protected void doWriteTo(StreamOutput out) throws IOException {  
    @Override
import org.opensearch.common.xcontent.XContentFactory;  
            XContentParser parser = XContentType.JSON.xContent()
            builder.map(this.content);
     * @return A new TemplateQueryBuilder instance.
            return newQueryBuilder;
     * @param parser The XContentParser to read from.
    }  
            String replacement = variables.get(varName);
    }
 * SPDX-License-Identifier: Apache-2.0
        this.content = content;
import org.opensearch.common.xcontent.XContentType;
 * this file be licensed under the Apache-2.0 license or a
        if (contextVariables != null) {
        return Objects.equals(this.content, other.content);  
 * compatible open source license.
        return result.toString();
     * @throws IOException If there's an error parsing the content.  
        StringBuilder result = new StringBuilder();
 * A query builder that constructs a query based on a template and context variables.
        return new TemplateQueryBuilder(parser.map());  
            }
                .createParser(queryCoordinatorContext.getXContentRegistry(), LoggingDeprecationHandler.INSTANCE, newQueryContent);
            int endVar = template.indexOf("}\"", startVar);
    }
        }  
     * @param content The template content as a map.
        }  
        if (!(queryCoordinatorContext instanceof QueryCoordinatorContext)) {
                    return JsonXContent.contentBuilder().value(entry.getValue()).toString();
    /**  
     * Rewrites the template query by substituting variables from the context.
