            );
        semanticScope.putDecoration(userUnaryNode, new ValueType(valueType));
                                        "Illegal get shortcut on field [" + index + "] for type [" + prefixCanonicalTypeName + "]."
            semanticScope.replicateCondition(userUnaryNode, userChildNode, Internal.class);
                        + functionName
                    )
        for (SCatch userCatchNode : userTryNode.getCatchNodes()) {
            );
            throw userElvisNode.createError(new IllegalArgumentException("Extraneous elvis operator. LHS is a primitive."));
    public void visitThrow(SThrow userThrowNode, SemanticScope semanticScope) {
    @Override
                new IllegalArgumentException(
        } else {
     * Visits an if/else statement with error checking for an extraneous if/else.
import org.opensearch.painless.CompilerSettings;
    /**
                            + "["
                    );
            semanticScope.replicateCondition(userBlockNode, userCatchNode, AllEscape.class);
    /**
                constant = Double.parseDouble(toParse);
        }
                    throw userCallNode.createError(
 *
                    valueType = short.class;
        if (localFunction != null) {
        checkedVisit(userExpressionNode, semanticScope);
                    userIndexNode,
                    if (typeParameter == null) {
            if (importedMethod == null) {
        if (rtn) {
    /**
                new IllegalArgumentException(
            throw userCallNode.createError(
        if (userBlockNode == null) {
        if (method == null) {
import org.opensearch.painless.symbol.Decorations.GetterPainlessMethod;
 */
                            }
                userValueNode,
                                new IllegalArgumentException(
                compoundType = AnalyzerCaster.promoteNumeric(leftValueType, false);
                new IllegalArgumentException("invalid catch declaration: type [" + symbol + "] cannot be a name")
            semanticScope.replicateCondition(userCatchNode, userBlockNode, InLoop.class);
        Class<?> prefixValueType = semanticScope.getDecoration(userPrefixNode, ValueType.class).getValueType();
        if (semanticScope.getCondition(userLambdaNode, Write.class)) {
                            + "["
            && userLeftNode instanceof ENull
            throw userExplicitNode.createError(
                } else {
        decorateWithCast(userConditionNode, semanticScope);
                } else {
            decorateWithCast(userValueNode, semanticScope);
                iterableValueType.getComponentType(),
        }
        semanticScope.setCondition(userReturnNode, AllEscape.class);
import org.opensearch.painless.node.SContinue;
                        );
                }
                        .getPainlessLookup()
                semanticScope.setCondition(userIndexNode, Read.class);
            importedMethod = scriptScope.getPainlessLookup().lookupImportedPainlessMethod(methodName, userArgumentsSize);
            }
            // TODO: remove ZonedDateTime exception when JodaCompatibleDateTime is removed
        if (operation != null) {
                    semanticScope.putDecoration(userRightNode, new TargetType(shiftType));
                }
    public void visitSymbol(ESymbol userSymbolNode, SemanticScope semanticScope) {
                )
            Class<?> typeParameter = localFunction.getTypeParameters().get(index);
                if (type == null) {
            throw userCallNode.createError(
                                + "/"
            throw userFunctionNode.createError(
        SBlock userBlockNode = userForNode.getBlockNode();
                                + "["
    @Override
        }
        if (type == null) {
                valueType = setter != null ? setter.typeParameters.get(1) : getter.returnType;
    @Override
                throw userDotNode.createError(
            // TODO: remove ZonedDateTime exception when JodaCompatibleDateTime is removed
                throw userBinaryNode.createError(new IllegalStateException("unexpected binary operation [" + operation.name + "]"));
    @Override
        semanticScope.setCondition(userConditionNode, Read.class);
                )
                semanticScope.putDecoration(userFunctionRefNode, new ReferenceDecoration(ref));
                    )
                if (beginLoop || lastLoop) {
        boolean anyContinue = false;
    public void decorateWithCast(AExpression userExpressionNode, SemanticScope semanticScope) {
        semanticScope.putDecoration(userExpressionNode, new TargetType(Exception.class));
        boolean continuous = false;
        int constant = 0;
     */
     * Checks: type validation
                        || semanticScope.getCondition(userDotNode, Explicit.class) ? def.class : targetType.getTargetType();
                    )
        semanticScope.replicateCondition(userConditionalNode, userFalseNode, Internal.class);
                } else {
        if (semanticScope.getCondition(userNumericNode, Write.class)) {
                userNewArrayFunctionRefNode.getLocation(),
                semanticScope.setCondition(userForNode, MethodEscape.class);
            semanticScope.setCondition(userExpressionNode, AllEscape.class);
            }
            throw userLambdaNode.createError(new IllegalArgumentException("not all paths return a value for lambda"));
            }
        }
     */
                throw userDecimalNode.createError(new IllegalArgumentException("Invalid double constant [" + decimal + "]."));
            }
                } else {
        Class<?> type = scriptScope.getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
                    throw userDotNode.createError(
                semanticScope.setCondition(userIndexNode, Read.class);
            semanticScope.setCondition(userTryNode, LoopEscape.class);
        semanticScope.setCondition(userReturnNode, MethodEscape.class);
        semanticScope = semanticScope.newLocalScope();
                semanticScope.setCondition(userForNode, AllEscape.class);
        if (anyContinue) {
    /**
            FunctionRef ref = FunctionRef.create(
        String symbol = userCatchNode.getSymbol();
                );
            Class<?> compoundType;
    public void visitBooleanComp(EBooleanComp userBooleanCompNode, SemanticScope semanticScope) {
        semanticScope.putDecoration(userCompNode, new ValueType(boolean.class));
        if (semanticScope.getCondition(userCompNode, Read.class) == false) {
            throw userMapInitNode.createError(new IllegalArgumentException("not a statement: result not used from map initializer"));
                                    )
     * Visits a throw statement.
        }
        if (scriptScope.getPainlessLookup().isValidCanonicalClassName(symbol)) {
            }
            valueType = promote;
        }
    @Override
    /**
                            }
                        + "found no statements for function "
                if (captured.getType() == def.class) {
        decorateWithCast(userChildNode, semanticScope);
                    "cannot have both "
        }
                new IllegalArgumentException(
            throw userStringNode.createError(new IllegalArgumentException("not a statement: string constant [" + string + "] not used"));
        if (semanticScope.getCondition(userInstanceofNode, Write.class)) {
                                }
            PainlessMethod getter = semanticScope.getScriptScope()
                    || !getter.returnType.equals(setter.typeParameters.get(1)))) {
            String toParse = decimal;
import org.opensearch.painless.node.ESymbol;
            semanticScope.setCondition(userKeyNode, Read.class);
    @Override
                    new ClassCastException(
    @Override
 * not use this file except in compliance with the License.
        visit(userBlockNode, functionScope.newLocalScope());
                )
                semanticScope.putDecoration(
        }
        }
                );
        List<AExpression> userArgumentNodes = userCallLocalNode.getArgumentNodes();
                                if (getter != null
    public void visitNumeric(ENumeric userNumericNode, SemanticScope semanticScope) {
                        )
                scriptScope.getFunctionTable(),
        boolean methodEscape = semanticScope.getCondition(userBlockNode, MethodEscape.class);
import org.opensearch.painless.symbol.Decorations.StandardConstant;
        boolean anyContinue = semanticScope.getCondition(userBlockNode, AnyContinue.class);
            parameterNamesWithCaptures.add(capturedVariable.getName());
                semanticScope.setCondition(userArgumentNode, Read.class);
            } else {
        }
     */
        boolean methodEscape = functionScope.getCondition(userBlockNode, MethodEscape.class);
        boolean loopEscape = semanticScope.getCondition(userBlockNode, LoopEscape.class);
        semanticScope.putDecoration(userLambdaNode, new MethodNameDecoration(name));
            checkedVisit(userIndexNode, semanticScope);
            methodEscape &= semanticScope.getCondition(userCatchNode, MethodEscape.class);
            boolean isConcatenation = false;
        semanticScope.replicateCondition(userConditionalNode, userTrueNode, Internal.class);
        }
                        "value required: instead found unexpected type " + "[" + prefixStaticType.getStaticType() + "]"
                }
            allEscape &= semanticScope.getCondition(userCatchNode, AllEscape.class);
            }
                if (write) {
    }
            semanticScope.putDecoration(userConditionNode, new TargetType(boolean.class));
        if (semanticScope.getCondition(userBinaryNode, Write.class)) {
                            }
            }
            || userLeftNode instanceof EString) {
        }
            String parameterName = userFunctionNode.getParameterNames().get(index);
                                new IllegalArgumentException(
            semanticScope.setCondition(userValueNode, Read.class);
            visit(userStatementNode, semanticScope);
import org.opensearch.painless.symbol.Decorations.Write;
        Class<?> valueType;
        semanticScope.putDecoration(userNewArrayFunctionRefNode, new MethodNameDecoration(name));
        }
            throw userNullNode.createError(new IllegalArgumentException("not a statement: null constant not used"));
        Operation operation = userBinaryNode.getOperation();
                        semanticScope.setCondition(userRightNode, Explicit.class);
                )
        }
                                );
        String canonicalTypeName = userEachNode.getCanonicalTypeName();
    /**
        semanticScope.putDecoration(userListInitNode, new StandardPainlessMethod(method));
import org.opensearch.painless.lookup.PainlessClassBinding;
                true
        semanticScope.replicateCondition(userElvisNode, userRightNode, Explicit.class);
            }
                .getPainlessLookup()
import java.util.HashMap;
            }
        }
import org.opensearch.painless.symbol.Decorations.StandardPainlessField;
     * Visits a null constant expression.
                new IllegalArgumentException(
                        + "not all paths provide a return value for function "
                if (unaryType == def.class && targetType != null) {
        ScriptScope scriptScope = semanticScope.getScriptScope();
                new IllegalArgumentException(
                    // dynamic implementation
import org.opensearch.painless.node.SThrow;
                        + canonicalTypeName
        }
        }
            );
                case 's':
            visit(userBlockNode, semanticScope);
            } else if (operation == Operation.LSH || operation == Operation.RSH || operation == Operation.USH) {
     * Checks: type validation
        semanticScope.putDecoration(userDecimalNode, new ValueType(valueType));
            scriptScope.putDecoration(userNewArrayFunctionRefNode, new EncodingDecoration(defReferenceEncoding));
    /**
        if (leftValueType.isPrimitive()) {
        semanticScope.putDecoration(userListInitNode, new ValueType(valueType));
            && userRightNode instanceof ENull) {
        Class<?> valueType = ArrayList.class;
                            );
                    if (field == null) {
 * You may obtain a copy of the License at
                    throw userForNode.createError(new IllegalArgumentException("extraneous for loop"));
     * Checks: control flow, type validation
        Class<?> leftValueType = semanticScope.getDecoration(userTrueNode, ValueType.class).getValueType();
        semanticScope.replicateCondition(userIfNode, userIfBlockNode, LastSource.class);
        if (anyBreak) {
    @Override
     */
import org.opensearch.painless.symbol.Decorations.MapShortcut;
                                + "]"
                                );
import org.opensearch.painless.symbol.Decorations.StandardPainlessClassBinding;
                            + "]"
            throw userElvisNode.createError(new IllegalArgumentException("Elvis operator cannot return primitives"));
        if (semanticScope.getCondition(userCallLocalNode, Write.class)) {
        List<Class<?>> typeParameters;
                                    throw userDotNode.createError(
        AExpression userRightNode = userCompNode.getRightNode();
                                    valueType = setter != null ? setter.typeParameters.get(1) : getter.returnType;
        }
                )
     * Checks: control flow
                        + constructor.typeParameters.size()
        semanticScope.setCondition(userThrowNode, MethodEscape.class);
                valueType = boolean.class;
import org.opensearch.painless.node.EMapInit;
/*
        if (constructor == null) {
                            + "cannot write a value to a static type ["
            semanticScope.setCondition(userIfElseNode, LoopEscape.class);
    public void visitBlock(SBlock userBlockNode, SemanticScope semanticScope) {
                            + "]"
                                        || getter.typeParameters.size() != 1
                    .getPainlessLookup()
        SBlock userBlockNode = userCatchNode.getBlockNode();
            semanticScope.setCondition(userBlockNode, InLoop.class);
                                if ((read == false || getter != null) && (write == false || setter != null)) {
                        prefixType = prefixStaticType.getStaticType();
            && semanticScope.getCondition(userElseBlockNode, MethodEscape.class)) {
                new IllegalArgumentException(
            semanticScope.setCondition(userIfElseNode, AnyBreak.class);
                if (lastSource) {
                            }
                                + prefixValueType.getValueCanonicalTypeName()
                throw userSymbolNode.createError(new IllegalArgumentException("not a statement: variable [" + symbol + "] not used"));
        } else if (numeric.endsWith("f") || numeric.endsWith("F")) {
        }
     * Visits a boolean comp expression which covers boolean comparision operators.
     */
        if (semanticScope.getCondition(userBlockNode, LoopEscape.class)
                                    );
        semanticScope.putDecoration(userBinaryNode, new BinaryType(binaryType));
        List<String> parameterNamesWithCaptures = new ArrayList<>(capturedVariables.size() + parameterNames.size());
        if (prefixValueType != null && prefixStaticType != null) {
            throw userEachNode.createError(
        AExpression userLeftNode = userBooleanCompNode.getLeftNode();
    public void visitInstanceof(EInstanceof userInstanceofNode, SemanticScope semanticScope) {
                            + PainlessLookupUtility.typeToCanonicalTypeName(leftValueType)
                    "invalid assignment cannot assign a value to new object with constructor "
        boolean write = semanticScope.getCondition(userDotNode, Write.class);
                new IllegalArgumentException("invalid assignment: cannot assign a value to numeric constant [" + numeric + "]")
        Class<?> expressionValueType = semanticScope.getDecoration(userStatementNode, ValueType.class).getValueType();
                name,
                    + "]"
            throw userListInitNode.createError(
        PainlessMethod interfaceMethod;
        }
     * Visits a list init expression which either defines a standard array or initializes
                        + "] parameters"
        List<String> canonicalTypeNameParameters = userLambdaNode.getCanonicalTypeNameParameters();
            decorateWithCast(userLeftNode, semanticScope);
            checkedVisit(userValueNode, semanticScope);
            );
     * Visits a binary expression which covers all the mathematical operators.
                                    "invalid assignment: cannot assign a value to read-only field [" + field.javaField.getName() + "]"
                semanticScope.setCondition(userStatementNode, InLoop.class);
            throw userInstanceofNode.createError(
                compoundType = AnalyzerCaster.promoteAdd(leftValueType, rightValueType);
                )
                .lookupPainlessMethod(prefixValueType, false, "get", 1);
                        + "]"
            if (read == false) {
            );
     * Checks: type validation
            }
    public void visitCall(ECall userCallNode, SemanticScope semanticScope) {
        for (int i = 0; i < flags.length(); ++i) {
                semanticScope.putDecoration(userFunctionRefNode, new EncodingDecoration(defReferenceEncoding));
            } else if (operation == Operation.BWAND) {
        ScriptScope scriptScope = semanticScope.getScriptScope();
     * Visits an expression that is also considered a statement.
        }
import java.time.ZonedDateTime;
                )
import org.opensearch.painless.symbol.Decorations.ContinuousLoop;
            String defReferenceEncoding = "Sthis." + name + "," + capturedVariables.size();
import org.opensearch.painless.node.SReturn;
                    );
import org.opensearch.painless.lookup.PainlessConstructor;
    /**
                                valueType = setter != null ? setter.typeParameters.get(0) : getter.returnType;
                semanticScope.putDecoration(userIndexNode, new TargetType(int.class));
        Variable variable = semanticScope.defineVariable(location, type, symbol, false);
import org.opensearch.painless.node.SDeclaration;
    @Override
        if (semanticScope.getCondition(userIfBlockNode, AnyContinue.class)
                                }
        } else {
        semanticScope.setCondition(userReturnNode, LoopEscape.class);
                if (argumentValueType == void.class) {
            }
        semanticScope.setCondition(userTrueNode, Read.class);
        }
            visitFunction(userFunctionNode, scriptScope);
        } else {
                        + operation.symbol
        if (semanticScope.getCondition(userRegexNode, Write.class)) {
            );
        String functionName = userFunctionNode.getFunctionName();
        }
                    "When calling constructor on type ["
        semanticScope.putDecoration(userMapInitNode, new ValueType(valueType));
    }
                            + semanticScope.getDecoration(userExpressionNode, PartialCanonicalTypeName.class).getPartialCanonicalTypeName()
        Class<?> instanceType = semanticScope.getScriptScope().getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
            checkedVisit(userValueNode, semanticScope);
                        isStatic = true;
            anyBreak |= semanticScope.getCondition(userStatementNode, AnyBreak.class);
        semanticScope.putDecoration(userFunctionRefNode, new ValueType(valueType));
            }
                    "not a statement: result not used from " + operation.name + " operation " + "[" + operation.symbol + "]"
                }
            if (targetType.getTargetType().isPrimitive()) {
            Variable variable = semanticScope.getVariable(location, symbol);
        // setup method reference to synthetic method
     * Visits a brace expression which is an array index with a qualifier (prefix) and
        boolean bool = userBooleanConstantNode.getBool();
        } else {
    @Override
            PainlessCast upcast = AnalyzerCaster.getLegalCast(location, leftValueType, compoundType, false, false);
            }
import org.opensearch.painless.symbol.Decorations.ParameterNames;
                    "invalid assignment: cannot assign a value to regex constant [" + pattern + "] with flags [" + flags + "]"
            AExpression userArgumentNode = userArgumentNodes.get(argument);
            if (operation == Operation.NOT) {
                        scriptScope.getFunctionTable(),
        visit(userIfBlockNode, semanticScope.newLocalScope());
                                + "["
                throw userBraceNode.createError(
            throw userLambdaNode.createError(new IllegalArgumentException("cannot generate empty lambda"));
        semanticScope.putDecoration(userLambdaNode, new ParameterNames(parameterNamesWithCaptures));
                                    throw userDotNode.createError(
                                + userArgumentsSize
            promotedType = AnalyzerCaster.promoteEquality(leftValueType, rightValueType);
import org.opensearch.painless.symbol.Decorations.StandardPainlessMethod;
        }
import org.opensearch.painless.symbol.FunctionTable;
        List<AExpression> userArgumentNodes = userCallNode.getArgumentNodes();
            checkedVisit(userIndexNode, semanticScope);
                throw userForNode.createError(new IllegalArgumentException("extraneous for loop"));
        semanticScope.setCondition(userExpressionNode, Read.class);
                        )
            throw userBooleanConstantNode.createError(
            } else {
                                            "Illegal list set shortcut for type [" + prefixCanonicalTypeName + "]."
            throw userExplicitNode.createError(new IllegalArgumentException("cannot resolve type [" + canonicalTypeName + "]"));
            } else if (operation == Operation.ADD) {
                            + semanticScope.getReturnCanonicalTypeName()
    public void visitTry(STry userTryNode, SemanticScope semanticScope) {
        } else if (classBinding != null) {
    @Override
                                    );
            semanticScope.setCondition(userArgumentNode, Internal.class);
        if (semanticScope.getCondition(userDecimalNode, Negate.class)) {
                valueType = float.class;
            );
        if (userBlockNode != null) {
                        prefixCanonicalTypeName = prefixStaticType.getStaticCanonicalTypeName();
                                );
            if (inLoop) {
import org.opensearch.painless.lookup.def;
                    } else if (prefixStaticType != null) {
        ScriptScope scriptScope = semanticScope.getScriptScope();
    }
        semanticScope.copyDecoration(userConditionalNode, userTrueNode, TargetType.class);
 *
        semanticScope.putDecoration(userBinaryNode, new ValueType(valueType));
            if (continuous == false) {
                    .lookupPainlessMethod(prefixStaticType.getStaticType(), true, methodName, userArgumentsSize);
            );
            PainlessCast painlessCast = AnalyzerCaster.getLegalCast(location, def.class, type, true, true);
            continuous = ((EBooleanConstant) userConditionNode).getBool();
     * Shortcut to visit a user tree node with a null check.
        Location location = userLambdaNode.getLocation();
                if (paramType == null) {
                if (setter != null) {
                        + "and type ["
                        + "["
        }
            throw userCompNode.createError(
                                "get" + Character.toUpperCase(index.charAt(0)) + index.substring(1),
                .getPainlessLookup()
                        )
     */
import org.opensearch.painless.node.SBlock;
        }
    @Override
                                    );
            checkedVisit(userChildNode, semanticScope);
                targetType.getTargetType(),
     */
                    String prefixCanonicalTypeName;
     * Visits a unary expression which special-cases a negative operator when the child
        AExpression userStatementNode = userExpressionNode.getStatementNode();
                            }
        if (userStatementNodes.isEmpty()) {
     * Checks: type validation, method resolution
import org.opensearch.painless.node.ERegex;
            }
import org.opensearch.painless.node.ENull;
        semanticScope.setCondition(userFalseNode, Read.class);
                                + operation.symbol
            TargetType targetType = userCallNode.isNullSafe() ? null : semanticScope.getDecoration(userCallNode, TargetType.class);
import org.opensearch.painless.node.ENewArray;
            semanticScope.putDecoration(userNewArrayFunctionRefNode, new ReferenceDecoration(ref));
                    new IllegalArgumentException(
            semanticScope.putDecoration(userUnaryNode, new UnaryType(unaryType));
                case 'l':
    public void visitDo(SDo userDoNode, SemanticScope semanticScope) {
                    // typed implementation
                    "invalid function definition: "
            Location location = userAssignmentNode.getLocation();
        PainlessConstructor constructor = semanticScope.getScriptScope().getPainlessLookup().lookupPainlessConstructor(valueType, 0);
        Operation operation = userCompNode.getOperation();
        String symbol = userSymbolNode.getSymbol();
            throw userUnaryNode.createError(
        if (semanticScope.getCondition(userNumericNode, Read.class) == false) {
        boolean inLoop = semanticScope.getCondition(userBlockNode, InLoop.class);
                    scriptScope.getFunctionTable(),
                                throw userDotNode.createError(
     */
                    )
            }
            semanticScope.putDecoration(userLambdaNode, new ReferenceDecoration(ref));
import org.opensearch.painless.node.SWhile;
                    targetType.getTargetType(),
    /**
                    valueType = int.class;
                    )
            char flag = flags.charAt(i);
            Class<?> staticType = scriptScope.getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
                throw userAssignmentNode.createError(new IllegalStateException("illegal tree structure"));
                }
     * Checks: control flow
            semanticScope.setCondition(userBlockNode, BeginLoop.class);
        semanticScope.replicateCondition(userElvisNode, userRightNode, Internal.class);
                    break;
        semanticScope.replicateCondition(userIfElseNode, userIfBlockNode, InLoop.class);
            semanticScope.putDecoration(userValueNode, new TargetType(type));
        if (semanticScope.getCondition(userNewArrayNode, Write.class)) {
        }
                );
                    constant = (char) integer;
                valueType = String.class;
            semanticScope.setCondition(userValueNode, Internal.class);
        semanticScope.putDecoration(
     */
                if (write) {
                            + "]"
                    throw userBlockNode.createError(new IllegalArgumentException("invalid block: unreachable statement"));
                    semanticScope.putDecoration(userBraceNode, new SetterPainlessMethod(setter));
                TargetType targetType = semanticScope.getDecoration(userUnaryNode, TargetType.class);
        int userArgumentsSize = userArgumentNodes.size();
                    "invalid assignment: cannot assign a value to " + operation.name + " operation " + "[" + operation.symbol + "]"
    public void visitCatch(SCatch userCatchNode, SemanticScope semanticScope) {
     * Visits a try statement.
            if (semanticScope.getCondition(userBlockNode, AnyBreak.class) == false) {
            semanticScope.setCondition(userTryNode, AnyBreak.class);
            }
        Class<?> valueType;
                                getter = scriptScope.getPainlessLookup().lookupPainlessMethod(prefixType, false, "get", 1);
            semanticScope.replicateCondition(userCatchNode, userBlockNode, LastSource.class);
            );
                        + "] to the types "
                            + "["
            if (painlessCast != null) {
                    new IllegalArgumentException("Illegal map get shortcut for type [" + canonicalClassName + "].")
                throw userBraceNode.createError(
    /**
import org.opensearch.painless.node.EConditional;
                        + "] with ["
                // check to see if this class binding requires an implicit this reference
                String paramType = canonicalTypeNameParameters.get(i);
                        if (valueType == null) {
        }
        // if the class binding is using an implicit this reference then the arguments counted must
    @Override
                compoundType = AnalyzerCaster.promoteXor(leftValueType, rightValueType);
                                    semanticScope.putDecoration(userDotNode, new SetterPainlessMethod(setter));
            throw userIfElseNode.createError(new IllegalArgumentException("extraneous else block."));
            if (targetType == null) {
                }
                new IllegalArgumentException("invalid assignment: cannot assign a value to boolean constant [" + bool + "]")
 * ownership. Elasticsearch licenses this file to you under
                    "cannot assign a value to new array function reference with target type [ + " + canonicalTypeName + "]"
            }
        }
    /**
                        semanticScope.putDecoration(userDotNode, new StandardPainlessField(field));
                            }
        boolean allEscape;
                    pse
            } catch (NumberFormatException exception) {
    /**
                    "invalid assignment: cannot assign a value to function call [" + methodName + "/" + userArgumentsSize + "]"
            throw userNumericNode.createError(
            typeParameters = new ArrayList<>(importedMethod.typeParameters);
        StaticType prefixStaticType = semanticScope.getDecoration(userPrefixNode, StaticType.class);
                        getter = scriptScope.getPainlessLookup()
            );
    /**
     * Shortcut to visit a user expression node with additional checks common to most expression nodes. These
                isConcatenation = compoundType == String.class;
                checkedVisit(userArgumentNode, semanticScope);
            );
                decorateWithCast(userArgumentNode, semanticScope);
    public void visitReturn(SReturn userReturnNode, SemanticScope semanticScope) {
     * Visits a break statement.
     * Checks: type validation
            checkedVisit(userValueNode, semanticScope);
                            + "["
                                    isStatic,
            throw userInstanceofNode.createError(new IllegalArgumentException("Not a type [" + canonicalTypeName + "]."));
                }
            if (operation == Operation.MUL) {
            }
                    "not a statement: new array function reference with target type [" + canonicalTypeName + "] not used"
                        + "["
            if (semanticScope.getReturnType() != void.class) {
            if (compoundType == null || (isShift && shiftType == null)) {
                constant = Double.parseDouble(numeric.substring(0, numeric.length() - 1));
                name,
        }
import org.opensearch.painless.symbol.Decorations.ExpressionPainlessCast;
            PainlessCast painlessCast = AnalyzerCaster.getLegalCast(
                new IllegalArgumentException(
            }
                if (setter != null) {
                        }
        }
            && semanticScope.getCondition(userBlockNode, AnyContinue.class) == false) {
    @Override
            }
                compoundType = AnalyzerCaster.promoteNumeric(leftValueType, rightValueType, true);
            semanticScope.replicateCondition(userTryNode, userCatchNode, LastSource.class);
            }
    }
                    new IllegalArgumentException("Illegal map set shortcut for type [" + canonicalClassName + "].")
        }
        } else {
            semanticScope.setCondition(userValueNode, Read.class);
                    "invalid assignment: cannot assign a value to " + operation.name + " operation " + "[" + operation.symbol + "]"
        String canonicalTypeName = userInstanceofNode.getCanonicalTypeName();
                        prefixType = prefixValueType.getValueType();
    /**
     */
                                if ((read == false || getter != null) && (write == false || setter != null)) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.node.AExpression;
                decorateWithCast(userRightNode, semanticScope);
public class DefaultSemanticAnalysisPhase extends UserTreeBaseVisitor<SemanticScope> {
            SemanticScope.Variable captured = semanticScope.getVariable(location, symbol);
                throw userForNode.createError(new IllegalStateException("illegal tree structure"));
                        )
        decorateWithCast(userExpressionNode, semanticScope);
                decorateWithCast(userChildNode, semanticScope);
            semanticScope.setCondition(userBlockNode, AnyBreak.class);
            }
                        "Cannot pass lambda to " + "[" + targetType.getTargetCanonicalTypeName() + "], not a functional interface"
                new IllegalArgumentException(
            semanticScope.setCondition(userValueNode, Internal.class);
                            .lookupPainlessMethod(
        Location location = userFunctionRefNode.getLocation();
            }
                capturedVariables.size(),
        } else {
                    new IllegalArgumentException(
                                try {
        Operation operation = userUnaryNode.getOperation();
            if (setter != null && setter.typeParameters.size() != 2) {
        if (operation == Operation.FIND || operation == Operation.MATCH) {
        semanticScope.putDecoration(userElvisNode, new ValueType(valueType));
                        + semanticScope.getDecoration(userPrefixNode, PartialCanonicalTypeName.class).getPartialCanonicalTypeName()
                    .lookupPainlessMethod(iterableValueType, false, "iterator", 0);
            } else if (operation == Operation.BWOR || operation == Operation.BWAND) {
        semanticScope.setCondition(userLeftNode, Read.class);
            scriptScope.markNonDeterministic(importedMethod.annotations.containsKey(NonDeterministicAnnotation.class));
     */
        int userArgumentsSize = userArgumentNodes.size();
                if (userBlockNode == null) {
    public void visitCallLocal(ECallLocal userCallLocalNode, SemanticScope semanticScope) {
                        + "] "
                throw userCallNode.createError(new IllegalStateException("value required: instead found no value"));
            Class<?> promote = AnalyzerCaster.promoteConditional(leftValueType, rightValueType);
                            semanticScope.setCondition(userDotNode, Shortcut.class);
            if (semanticScope.getCondition(userFunctionRefNode, Write.class)) {
import org.opensearch.painless.node.SClass;
import org.opensearch.painless.symbol.Decorations.LastLoop;
                            + "]"
            // check arity before we manipulate parameters
                                    );
        Object constant;
            if (prefixStaticType != null) {
        String canonicalTypeName = userNewObjNode.getCanonicalTypeName();
        semanticScope.putDecoration(userConditionNode, new TargetType(boolean.class));
                new IllegalArgumentException(
            );
                        isStatic = false;
    /**
        Class<?> binaryType;
            semanticScope.putDecoration(userIndexNode, new TargetType(int.class));
     * Checks: type validation
    @Override
            if (semanticScope.getCondition(userFunctionRefNode, Write.class)) {
import org.opensearch.painless.symbol.Decorations.Internal;
import org.opensearch.painless.symbol.Decorations.SetterPainlessMethod;
import org.opensearch.painless.symbol.SemanticScope.Variable;
        semanticScope.setCondition(userBreakNode, AllEscape.class);
            );
                )
                    );
        semanticScope.putDecoration(userEachNode, new SemanticVariable(variable));
                )
        if (semanticScope.getCondition(userBooleanConstantNode, Write.class)) {
            try {
     * Checks: type validation
        } else {
        Operation operation = userAssignmentNode.getOperation();
                        throw userLambdaNode.createError(new IllegalArgumentException("cannot resolve type [" + type + "]"));
     * Visits a boolean constant expression.
        }
                if (sort == byte.class && integer >= Byte.MIN_VALUE && integer <= Byte.MAX_VALUE) {
        if (semanticScope.getCondition(userUnaryNode, Write.class)) {
            );
                shiftType = AnalyzerCaster.promoteNumeric(rightValueType, false);
        }
        Class<?> unaryType = null;
        }
        Class<?> promotedType;
            }
            valueType = targetType == null
            PainlessMethod setter = semanticScope.getScriptScope()
        semanticScope.setCondition(userConditionNode, Read.class);
                            throw userDotNode.createError(
                new IllegalArgumentException("not a statement: boolean constant [" + bool + "] not used")
    @Override
     * Checks: type validation, method resolution
import org.opensearch.painless.lookup.PainlessInstanceBinding;
            if (prefixValueType != null) {
            if (semanticScope.hasDecoration(userExpressionNode, StaticType.class)) {
            semanticScope.putDecoration(userValueNode, new TargetType(def.class));
                }
            if (getter != null
        semanticScope.setCondition(userIterableNode, Read.class);
                binaryType = AnalyzerCaster.promoteNumeric(leftValueType, rightValueType, true);
            throw userInstanceofNode.createError(
            );
                new IllegalArgumentException(
        if (localFunction == null) {
        semanticScope.putDecoration(userExplicitNode, new ValueType(valueType));
                                } else {
            );
            throw userLambdaNode.createError(new IllegalArgumentException("not a statement: lambda not used"));
            checkedVisit(userConditionNode, semanticScope);
                if (allEscape) {
            semanticScope.putDecoration(userCallLocalNode, new StandardPainlessInstanceBinding(instanceBinding));
    public void visitConditional(EConditional userConditionalNode, SemanticScope semanticScope) {
            decimal = "-" + decimal;
                        + PainlessLookupUtility.typeToCanonicalTypeName(rightValueType)
    }
import org.opensearch.painless.FunctionRef;
                                + ", "
     */
                visit(userInitializerNode, semanticScope);
            }
                binaryType = AnalyzerCaster.promoteXor(leftValueType, rightValueType);
        semanticScope.putDecoration(userMapInitNode, new StandardPainlessMethod(method));
        TargetType targetType = semanticScope.getDecoration(userElvisNode, TargetType.class);
                        if (write) {
                    constant |= Pattern.UNICODE_CHARACTER_CLASS;
            );
    @Override
                        "invalid compound assignment: "
            if (isConcatenation) {
        semanticScope.putDecoration(userConditionNode, new TargetType(boolean.class));
            checkedVisit(userKeyNode, semanticScope);
     */
            semanticScope.putDecoration(userExpressionNode, new ExpressionPainlessCast(painlessCast));
        } else {
        }
                                if (setter != null && (setter.typeParameters.size() != 2 || setter.typeParameters.get(0) != int.class)) {
                            + semanticScope.getDecoration(userExpressionNode, StaticType.class).getStaticCanonicalTypeName()
            if (setter != null && (setter.typeParameters.size() != 2 || setter.typeParameters.get(0) != int.class)) {
                        "cannot apply the conditional operator [?:] to the types "
                case 'm':
            throw userCompNode.createError(
                }
                            throw userCallLocalNode.createError(
                + "."
import org.opensearch.painless.symbol.Decorations.DefOptimized;
                                + PainlessLookupUtility.typeToCanonicalTypeName(childValueType)
            if (promote == null) {
                throw userNumericNode.createError(new IllegalArgumentException("Invalid double constant [" + numeric + "]."));
                                if (getter != null && (getter.returnType == void.class || getter.typeParameters.size() != 1)) {
                        if (instanceBinding == null) {
                || semanticScope.getCondition(userBraceNode, Explicit.class) ? def.class : targetType.getTargetType();
 * GitHub history for details.
                new IllegalArgumentException("method [" + typeToCanonicalTypeName(valueType) + ", add/1] not found")
                    break;
                                    semanticScope.putDecoration(userDotNode, new GetterPainlessMethod(getter));
                isShift = true;
                checkedVisit(userChildNode, semanticScope);
            decorateWithCast(userArgumentNode, semanticScope);
    @Override
                    } else {
import org.opensearch.painless.symbol.Decorations.AnyBreak;
            }
                        1,
        } else {
            }
import org.opensearch.painless.node.SDo;
            }
    /**
import org.opensearch.painless.symbol.Decorations.ComparisonType;
        if (userConditionNode instanceof EBooleanConstant || userIfBlockNode == null) {
            throw userNewArrayFunctionRefNode.createError(new IllegalArgumentException("Not a type [" + canonicalTypeName + "]."));
        if (semanticScope.getCondition(userStringNode, Write.class)) {
        }
import org.opensearch.painless.node.EBooleanConstant;
            throw userElvisNode.createError(new IllegalArgumentException("not a statement: result not used from elvis operation [?:]"));
                constant = Float.parseFloat(decimal.substring(0, decimal.length() - 1));
        } else if (semanticScope.getCondition(userLeftNode, DefOptimized.class)) {
     * is a constant expression to handle the maximum negative values appropriately.
                .lookupPainlessMethod(prefixValueType, false, "get", 1);
        checkedVisit(userRightNode, semanticScope);
        }
                        if (write && Modifier.isFinal(field.javaField.getModifiers())) {
                );
                decorateWithCast(userLeftNode, semanticScope);
            );
        semanticScope.setCondition(userThrowNode, AllEscape.class);
            if ((read == false || getter != null) && (write == false || setter != null)) {
        }
            }
            throw userNewArrayNode.createError(new IllegalArgumentException("not a statement: result not used from new array"));
        if (constructor == null) {
        PainlessConstructor constructor = semanticScope.getScriptScope().getPainlessLookup().lookupPainlessConstructor(valueType, 0);
import org.opensearch.painless.node.EDecimal;
                staticType = scriptScope.getPainlessLookup().canonicalTypeNameToType(staticCanonicalTypeName);
            semanticScope.setCondition(userStatementNode, Read.class);
            } else if (operation == Operation.BWNOT || operation == Operation.ADD || operation == Operation.SUB) {
                    "not a statement: result not used from " + operation.name + " operation " + "[" + operation.symbol + "]"
                        prefixCanonicalTypeName = prefixValueType.getValueCanonicalTypeName();
            interfaceMethod = scriptScope.getPainlessLookup().lookupFunctionalInterfacePainlessMethod(targetType.getTargetType());
                        + "]"
                String defReferenceEncoding;
        }
    }
        if (method == null) {
        semanticScope.setCondition(userBlockNode, BeginLoop.class);
                                }
                        new IllegalArgumentException(
     * may resolve to an array index, or a getter/setter for a Map or List.
                } else if (sort == char.class && integer >= Character.MIN_VALUE && integer <= Character.MAX_VALUE) {
        semanticScope.putDecoration(userNewObjNode, new ValueType(valueType));
            semanticScope.setCondition(userChildNode, Read.class);
        if (methodEscape) {
                            + "["
                                }
     * Visits a comp expression which covers mathematical comparision operators.
        Class<?> iterableValueType = semanticScope.getDecoration(userIterableNode, ValueType.class).getValueType();
        semanticScope.setCondition(userPrefixNode, Read.class);
        } else if (iterableValueType == def.class || Iterable.class.isAssignableFrom(iterableValueType)) {
    public void checkedVisit(AExpression userExpressionNode, SemanticScope semanticScope) {
                        + "value ["
                    valueType = targetType.getTargetType();
import org.opensearch.painless.symbol.Decorations.ListShortcut;
                    // Check if we can parse as a long. If so then hint that the user might prefer that.
package org.opensearch.painless.phase;
import org.opensearch.painless.node.EExplicit;
            );
        if (semanticScope.getCondition(userBlockNode, MethodEscape.class) == false) {
            semanticScope.setCondition(userArgumentNode, Internal.class);
        semanticScope.replicateCondition(userIfElseNode, userElseBlockNode, LastSource.class);
import org.opensearch.painless.symbol.SemanticScope;
        checkedVisit(userStatementNode, semanticScope);
                toParse = toParse.substring(0, decimal.length() - 1);
        if (targetType == null) {
            for (int i = 0; i < canonicalTypeNameParameters.size(); i++) {
                        new IllegalArgumentException(
     * Checks: type validation
    }
    @Override
        }
    }
            semanticScope.putDecoration(userArgumentNode, new TargetType(types[i]));
            }
            throw userEachNode.createError(new IllegalArgumentException("extraneous foreach loop"));
                            new IllegalArgumentException("invalid assignment: cannot assign a value to a null safe operation [?.]")
                                        || getter.returnType.equals(setter.typeParameters.get(1)) == false)) {
        scriptScope.getFunctionTable().addFunction(name, returnType, typeParametersWithCaptures, true, true);
                                isStatic,
        semanticScope.putDecoration(userLambdaNode, new TypeParameters(typeParametersWithCaptures));
                                    )
                                    throw userDotNode.createError(
                                if (setter != null) {
                case 'i':
import org.opensearch.painless.node.EFunctionRef;
                isShift = true;
                    )
import org.opensearch.painless.node.SBreak;
                default:
                Class<?> sort = targetType == null ? int.class : targetType.getTargetType();
        }
    }
                    }
                                }
        Class<?> type = scriptScope.getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
                returnType = interfaceMethod.returnType;
        AExpression userChildNode = userUnaryNode.getChildNode();
        semanticScope = semanticScope.newLocalScope();
            throw userTryNode.createError(new IllegalArgumentException("extraneous try statement"));
        LocalFunction localFunction = scriptScope.getFunctionTable()
        // desugar lambda body into a synthetic method
        );
                    // reference. This is a temporary solution to allow the class binding access to data from the
        if (semanticScope.getCondition(userMapInitNode, Write.class)) {
                );
     */
                throw userDotNode.createError(
     * Visits a string constant expression.
                .getPainlessLookup()
        }
        for (int index = 0; index < typeParameters.size(); ++index) {
        semanticScope.replicateCondition(userTryNode, userBlockNode, LastSource.class);
                throw userBraceNode.createError(new IllegalArgumentException("Shortcut argument types must match."));
            && semanticScope.getCondition(userElseBlockNode, AllEscape.class)) {
            semanticScope.setCondition(userArgumentNode, Read.class);
     */
    }
                                }
    @Override
            throw userEachNode.createError(
        String canonicalTypeName = userDeclarationNode.getCanonicalTypeName();
        }
            throw userConditionalNode.createError(
     * Visits a while statement with error checking for an extraneous loop.
                PainlessMethod method = semanticScope.getScriptScope()
                binaryType = AnalyzerCaster.promoteNumeric(leftValueType, rightValueType, false);
     * Checks: control flow
                    constant |= Pattern.UNICODE_CASE;
                                prefixType,
            checkedVisit(userValueNode, semanticScope);
                    && classBinding.typeParameters.isEmpty() == false
                            .lookupPainlessMethod(
                shiftType = AnalyzerCaster.promoteNumeric(rightValueType, false);
    }
            semanticScope.replicateCondition(userBlockNode, userCatchNode, MethodEscape.class);
            lambdaScope.defineVariable(location, type, parameterName, true);
            }
                }
        semanticScope = semanticScope.newLocalScope();
        PainlessCast painlessCast = AnalyzerCaster.getLegalCast(location, valueType, targetType, isExplicitCast, isInternalCast);
        }
            } catch (NumberFormatException exception) {
        boolean lastSource = semanticScope.getCondition(userExpressionNode, LastSource.class);
            PainlessMethod getter = semanticScope.getScriptScope()
                                "Field [" + index + "] does not exist for type [" + prefixValueType.getValueCanonicalTypeName() + "]."
        AExpression userPrefixNode = userBraceNode.getPrefixNode();
        AExpression userLeftNode = userAssignmentNode.getLeftNode();
            );
                } else {
                            + operation.name
                "this",
import java.lang.reflect.Modifier;
        semanticScope.putDecoration(userStringNode, new ValueType(String.class));
                        + PainlessLookupUtility.typeToCanonicalTypeName(baseException)
        ScriptScope scriptScope = semanticScope.getScriptScope();
            for (String type : canonicalTypeNameParameters) {
                    )
        semanticScope.putDecoration(userStringNode, new StandardConstant(string));
                                + "not found"
            throw userStringNode.createError(
        Class<?> leftValueType = semanticScope.getDecoration(userLeftNode, ValueType.class).getValueType();
                                isStatic,
        if (semanticScope.getCondition(userElvisNode, Read.class) == false) {
        }
        }
                                        new IllegalArgumentException("Illegal map set shortcut for type [" + prefixCanonicalTypeName + "].")
                    } else {
        if (methodEscape == false && isAutoReturnEnabled == false && returnType != void.class) {
        Class<?> type = scriptScope.getPainlessLookup().canonicalTypeNameToType(symbol);
        }
        AExpression userFalseNode = userConditionalNode.getFalseNode();
                        new IllegalArgumentException(
        semanticScope.copyDecoration(userElvisNode, userRightNode, TargetType.class);
        semanticScope.putDecoration(userNumericNode, new ValueType(valueType));
        Class<?> valueType;
    }
    public void visitFor(SFor userForNode, SemanticScope semanticScope) {
    /**
                }
        if (lastSource && isVoid == false) {
        }
import org.opensearch.painless.symbol.Decorations.LastSource;
                valueType = targetType.getTargetType();
import org.opensearch.painless.symbol.Decorations.PartialCanonicalTypeName;
        Class<?> rightValueType = semanticScope.getDecoration(userRightNode, ValueType.class).getValueType();
        }
        Variable variable = semanticScope.defineVariable(location, type, symbol, false);
import org.opensearch.painless.symbol.SemanticScope.FunctionScope;
     * Checks: control flow
            new ValueType(semanticScope.getCondition(userAssignmentNode, Read.class) ? leftValueType : void.class)
                            } else {
            } else {
import org.opensearch.painless.symbol.Decorations.LoopEscape;
                new IllegalArgumentException(
            Class<?> valueType = variable.getType();
        List<AExpression> userArgumentNodes = userNewObjNode.getArgumentNodes();
                throw userNullNode.createError(
            } else if (prefixStaticType != null) {
                        new ClassCastException(
            decorateWithCast(userValueNode, semanticScope);
                                        new IllegalArgumentException(
        semanticScope.setCondition(userConditionNode, Read.class);
        semanticScope.replicateCondition(userConditionalNode, userFalseNode, Explicit.class);
            semanticScope.setCondition(userExpressionNode, MethodEscape.class);
        AExpression userLeftNode = userBinaryNode.getLeftNode();
                semanticScope.putDecoration(userAssignmentNode, new DowncastPainlessCast(downcast));
            && semanticScope.getCondition(userBlockNode, AnyContinue.class) == false) {
            if (iterableValueType != def.class) {
     * Visits a numeric constant expression which includes int and long.
                    new IllegalArgumentException(
 * license agreements. See the NOTICE file distributed with
        checkedVisit(userTrueNode, semanticScope);
                            "member method "
                    new ClassCastException(
            // if the lhs node is a def optimized node we update the actual type to remove the need for a cast
        if (prefixValueType.isArray()) {
            throw new Location(location.getSourceName(), location.getOffset() + 1 + pse.getIndex()).createError(
                compoundType = AnalyzerCaster.promoteNumeric(leftValueType, rightValueType, true);
                            );
                    + targetType.getTargetCanonicalTypeName()
        List<Class<?>> typeParameters = localFunction.getTypeParameters();
     */
                                + "] to the type "
                    "not a statement: result not used from " + operation.name + " operation " + "[" + operation.symbol + "]"
                    break;
            throw userNewObjNode.createError(new IllegalArgumentException("Not a type [" + canonicalTypeName + "]."));
                }
                                + "] "
            throw userElvisNode.createError(new IllegalArgumentException("Extraneous elvis operator. LHS is a constant."));
        checkedVisit(userConditionNode, semanticScope);
                }
     * Checks: control flow
    /**
        scriptScope.putDecoration(userNewObjNode, new StandardPainlessConstructor(constructor));
                    } else {
            if (painlessCast != null) {
    }
                new IllegalArgumentException(
                    new IllegalArgumentException("Cannot cast null to a primitive type [" + targetType.getTargetCanonicalTypeName() + "].")
            semanticScope.setCondition(userValueNode, Read.class);
                            + "=] to types ["
     * Visits a continue statement.
                                    new IllegalArgumentException(
                }
        AExpression userRightNode = userBinaryNode.getRightNode();
                                }
        semanticScope.setCondition(userContinueNode, AnyContinue.class);
import org.opensearch.painless.node.EComp;
        PainlessMethod importedMethod = null;
                )
                    if (prefixValueType != null) {
                semanticScope.putDecoration(userEachNode, new ExpressionPainlessCast(painlessCast));
            decorateWithCast(userStatementNode, semanticScope);
        if (anyBreak) {
        if (instanceType == null) {
            semanticScope.putDecoration(userLeftNode, new ValueType(rightValueType));
                semanticScope.setCondition(userBraceNode, DefOptimized.class);
            if (upcast != null) {
import java.util.regex.PatternSyntaxException;
        decorateWithCast(userRightNode, semanticScope);
                new IllegalArgumentException("invalid foreach loop: type [" + canonicalTypeName + "] not found")
                    classBinding = scriptScope.getPainlessLookup().lookupPainlessClassBinding(methodName, userArgumentsSize + 1);
     * Checks: type validation
            semanticScope.setCondition(userExpressionNode, LoopEscape.class);
     * Visits a decimal constant expression which includes float and double.
                    throw userEachNode.createError(
        checkedVisit(userLeftNode, semanticScope);
            );
    public void visitDecimal(EDecimal userDecimalNode, SemanticScope semanticScope) {
                    valueType = targetType == null
                    )
                );
        }
                        + "]."
                    // Ignored
        List<AExpression> userValueNodes = userMapInitNode.getValueNodes();
    /**
                    boolean isStatic;
        }
                    new IllegalArgumentException(
        AExpression userLeftNode = userElvisNode.getLeftNode();
            semanticScope.putDecoration(userLambdaNode, new EncodingDecoration(defReferenceEncoding));
        if (semanticScope.getCondition(userNumericNode, Negate.class)) {
            if (semanticScope.hasDecoration(userExpressionNode, ValueType.class) == false) {
        visit(userBlockNode, semanticScope);
                )
        for (Variable capturedVariable : capturedVariables) {
                && (!getter.typeParameters.get(0).equals(setter.typeParameters.get(0))
                semanticScope.putDecoration(userEachNode, new IterablePainlessMethod(method));
                    "invalid assignment: cannot assign a value to instanceof with target type [" + canonicalTypeName + "]"
        if (userBlockNode.getStatementNodes().isEmpty()) {
            typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
                semanticScope.putDecoration(userDotNode, new StaticType(staticType));
            // Otherwise, we must adapt the rhs type to the lhs type with a cast.
                    if (typeParameter == null) {
    /**
        // be incremented by 1 as the this reference will not be part of the arguments passed into
                                    )
        PainlessMethod method = semanticScope.getScriptScope().getPainlessLookup().lookupPainlessMethod(valueType, false, "add", 1);
    @Override
                                getter = scriptScope.getPainlessLookup().lookupPainlessMethod(prefixType, false, "get", 1);
import org.opensearch.painless.symbol.Decorations.Explicit;
        boolean lastLoop = semanticScope.getCondition(userBlockNode, LastLoop.class);
        }
        if (iterableValueType.isArray()) {
                                } else {
            PainlessMethod setter = semanticScope.getScriptScope()
        }
        }
                    .getPainlessLookup()
    }
                        semanticScope.setCondition(userDotNode, DefOptimized.class);
        AExpression userValueNode = userDeclarationNode.getValueNode();
                try {
        Class<?> staticType = semanticScope.getScriptScope().getPainlessLookup().canonicalTypeNameToType(symbol);
        if (anyContinue) {
    /**
     * Checks: control flow, type validation
                        new IllegalArgumentException(
        if (semanticScope.getCondition(userConditionalNode, Write.class)) {
        }
 * Licensed to Elasticsearch under one or more contributor
                                throw userDotNode.createError(new IllegalArgumentException("Shortcut argument types must match."));
        } else {
                scriptScope.getPainlessLookup(),
                    semanticScope.setCondition(userStatementNode, LastLoop.class);
            if (semanticScope.getCondition(userBlockNode, LoopEscape.class)
                    0,
        for (AStatement userStatementNode : userStatementNodes) {
import org.opensearch.painless.node.EBooleanComp;
            decorateWithCast(userArgumentNode, semanticScope);
            }
                        + prefixValueType.getValueCanonicalTypeName()
            try {
                new IllegalArgumentException(
     */
import org.opensearch.painless.node.ANode;
        }
        TargetType targetType = semanticScope.getDecoration(userConditionalNode, TargetType.class);
        if (type == null) {
            if (read == false) {
                        }
            || userLeftNode instanceof ENumeric
            );
            throw userCatchNode.createError(
                        + "["
            } else if (operation != Operation.ADD || binaryType != String.class) {
                    throw userCallNode.createError(
        if (shiftType != null) {
        boolean lastSource = semanticScope.getCondition(userBlockNode, LastSource.class);
import static org.opensearch.painless.lookup.PainlessLookupUtility.typeToCanonicalTypeName;
            valueType = targetType.getTargetType();
            throw userLambdaNode.createError(new IllegalArgumentException("invalid assignment: cannot assign a value to a lambda"));
                );
            }
            visit(userCatchNode, semanticScope.newLocalScope());
            if (interfaceMethod == null) {
        checkedVisit(userIterableNode, semanticScope);
     */
            throw userBooleanConstantNode.createError(
                                        new IllegalArgumentException(
            if (semanticScope.getCondition(userBlockNode, LoopEscape.class)
        functionScope.setCondition(userBlockNode, LastSource.class);
        AExpression userRightNode = userAssignmentNode.getRightNode();
            semanticScope.replicateCondition(userBlockNode, userCatchNode, AnyContinue.class);
        semanticScope.replicateCondition(userElvisNode, userLeftNode, Internal.class);
import org.opensearch.painless.node.EElvis;
        // the class binding call
                            if (setter != null) {
                scriptScope.getFunctionTable(),
import java.util.Collections;
            // replace any null types with the actual type
        if (userAfterthoughtNode != null) {
        SBlock userElseBlockNode = userIfElseNode.getElseBlockNode();
            Class<?> type = typeParameters.get(index);
        TargetType targetType = semanticScope.getDecoration(userNullNode, TargetType.class);
                if (allEscape) {
        if (semanticScope.getCondition(userNullNode, Read.class) == false) {
                    semanticScope.putDecoration(userRightNode, new TargetType(int.class));
                        }
                );
                                    scriptScope.putDecoration(userDotNode, new StandardConstant(Integer.parseInt(index)));
                method = semanticScope.getScriptScope()
        // user cannot call internal functions, reset to null if an internal function is found
    public void visitBinary(EBinary userBinaryNode, SemanticScope semanticScope) {
                        + "["
        }
            AExpression userKeyNode = userKeyNodes.get(i);
                )
    /**
            semanticScope.setCondition(userTryNode, AnyContinue.class);
        semanticScope = semanticScope.newLocalScope();
            throw userConditionalNode.createError(
            semanticScope.setCondition(userBraceNode, MapShortcut.class);
        if (userExpressionNode != null) {
                throw userBraceNode.createError(
            String defReferenceEncoding = "Sthis." + name + ",0";
        semanticScope.putDecoration(userRegexNode, new ValueType(Pattern.class));
            boolean isShift = false;
            throw userNewArrayNode.createError(new IllegalArgumentException("invalid assignment: cannot assign a value to new array"));
import org.opensearch.painless.symbol.Decorations.TargetType;
        if (userValueNode == null) {
            );
                                semanticScope.setCondition(userDotNode, MapShortcut.class);
        if (userBlockNode == null) {
            userExpressionNode.visit(this, semanticScope);
            } catch (NumberFormatException exception) {
                new IllegalArgumentException("invalid assignment: cannot assign a value to list initializer")
        }
            throw userBraceNode.createError(
        if (userLeftNode instanceof ENull) {
    public void visitUnary(EUnary userUnaryNode, SemanticScope semanticScope) {
                Class<?> childValueType = semanticScope.getDecoration(userChildNode, ValueType.class).getValueType();
            semanticScope.replicateCondition(userUnaryNode, userChildNode, Explicit.class);
                );
                    "invalid function definition: "
 * KIND, either express or implied.  See the License for the
        Class<?> baseException = userCatchNode.getBaseException();
            throw userListInitNode.createError(
        semanticScope.putDecoration(userNewArrayFunctionRefNode, new ReturnType(clazz));
import org.opensearch.painless.node.EBrace;
        for (int i = 0; i < userArgumentsSize; ++i) {
import org.opensearch.painless.symbol.Decorations.ReturnType;
        scriptScope.markNonDeterministic(constructor.annotations.containsKey(NonDeterministicAnnotation.class));
                case 'x':
                    semanticScope.putDecoration(userFunctionRefNode, new ReferenceDecoration(ref));
            }
                                semanticScope.putDecoration(userDotNode, new GetterPainlessMethod(getter));
            checkedVisit(userArgumentNode, semanticScope);
        decorateWithCast(userConditionNode, semanticScope);
            semanticScope.putDecoration(userRightNode, new TargetType(promotedType));
            }
        for (int index = 0; index < localFunction.getTypeParameters().size(); ++index) {
            semanticScope.putDecoration(userRightNode, new TargetType(Pattern.class));
            if (staticType == null) {
                )
                continuous = ((EBooleanConstant) userConditionNode).getBool();
        }
                new IllegalArgumentException(
     */
import org.opensearch.painless.node.EDot;
                        throw userDotNode.createError(new IllegalStateException("value required: instead found no value"));
        }
        }
        if (semanticScope.getCondition(userDecimalNode, Write.class)) {
            functionScope.setCondition(userFunctionNode, MethodEscape.class);
            valueType = method.returnType;
            } else if (operation == Operation.RSH) {
        }
        if (semanticScope.getCondition(userContinueNode, LastLoop.class)) {
        SBlock userBlockNode = userTryNode.getBlockNode();
                    // are a substantial change if even possible to do.
    /**
                                + "/"
                }
            throw userElvisNode.createError(new IllegalArgumentException("Extraneous elvis operator. RHS is null."));
        if (semanticScope.getCondition(userBinaryNode, Read.class) == false) {
                                throw userDotNode.createError(
        if (targetType == null) {
                    if (valueType.isPrimitive()) {
            Class<?> shiftType = null;
        semanticScope.putDecoration(userConditionNode, new TargetType(boolean.class));
                } catch (NumberFormatException longNoGood) {
        }
            }
        if (semanticScope.getCondition(userLambdaNode, Read.class) == false) {
                        + typeParameters.size()
                decorateWithCast(userIndexNode, semanticScope);
            Class<?> rightValueType = semanticScope.getDecoration(userRightNode, ValueType.class).getValueType();
        AExpression userIterableNode = userEachNode.getIterableNode();
                if (getter != null) {
                                    throw userDotNode.createError(new IllegalArgumentException("Shortcut argument types must match."));
                                }
        semanticScope.replicateCondition(userIfBlockNode, userIfNode, AnyBreak.class);
        String canonicalTypeName = userCatchNode.getCanonicalTypeName();
        if (read == false && write == false) {
                        || targetType.getTargetType() == ZonedDateTime.class
            semanticScope.putDecoration(userFunctionRefNode, new CapturesDecoration(Collections.singletonList(captured)));
        if (semanticScope.getCondition(userBooleanCompNode, Read.class) == false) {
    }
        } else {
        if (semanticScope.getCondition(userStringNode, Read.class) == false) {
        semanticScope.setCondition(userContinueNode, AllEscape.class);
            if (userStatementNode == lastUserStatement) {
                unaryType = AnalyzerCaster.promoteNumeric(childValueType, operation != Operation.BWNOT);
                        setter = scriptScope.getPainlessLookup()
                        + "["
        Class<?> clazz = scriptScope.getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
                )
                );
    }
        // prepend capture list to lambda's arguments
    @Override
        ValueType prefixValueType = semanticScope.getDecoration(userPrefixNode, ValueType.class);
            semanticScope.putDecoration(userArgumentNode, new TargetType(typeParameters.get(argument + classBindingOffset)));
            if (userConditionNode instanceof EBooleanConstant) {
    @Override
                valueType = double.class;
        boolean read = semanticScope.getCondition(userSymbolNode, Read.class);
        ScriptScope scriptScope = semanticScope.getScriptScope();
                        + "]."
                                    new IllegalArgumentException(
import org.opensearch.painless.symbol.Decorations.UpcastPainlessCast;
    public void visitRegex(ERegex userRegexNode, SemanticScope semanticScope) {
import org.opensearch.painless.node.SDeclBlock;
    public void visitAssignment(EAssignment userAssignmentNode, SemanticScope semanticScope) {
                throw userLambdaNode.createError(
     */
        parameterNamesWithCaptures.addAll(parameterNames);
                if (classBinding != null
            valueType = targetType.getTargetType();
                }
        semanticScope.setCondition(userRightNode, Read.class);
                            "static method "
                throw userExpressionNode.createError(new IllegalStateException("value required: instead found no value"));
            semanticScope.setCondition(userBlockNode, AnyContinue.class);
            && semanticScope.getCondition(userElseBlockNode, LoopEscape.class)) {
        semanticScope.putDecoration(userBraceNode, new ValueType(valueType));
        }
            if (targetType == null) {
     * Checks: type validation
                semanticScope.putDecoration(userDotNode, new PartialCanonicalTypeName(canonicalTypeName));
        }
     * and variables.
    }
        semanticScope.setCondition(userLeftNode, Read.class);
                        + userArgumentsSize
        if (userNode != null) {
import org.opensearch.painless.symbol.Decorations.Negate;
     * Checks: type validation
    /**
            FunctionRef ref = FunctionRef.create(
        } else if (operation == Operation.GT || operation == Operation.GTE || operation == Operation.LT || operation == Operation.LTE) {
    @Override
            if (write) {
    public void visitExplicit(EExplicit userExplicitNode, SemanticScope semanticScope) {
                    if (write) {
                    valueType = char.class;
        SBlock userIfBlockNode = userIfElseNode.getIfBlockNode();
            anyContinue |= semanticScope.getCondition(userCatchNode, AnyContinue.class);
                new TargetType(userNewArrayNode.isInitializer() ? valueType.getComponentType() : int.class)
        boolean anyBreak = semanticScope.getCondition(userBlockNode, AnyBreak.class);
        if (semanticScope.getCondition(userListInitNode, Read.class) == false) {
            decorateWithCast(userValueNode, semanticScope);
                valueType = targetType.getTargetType();
        semanticScope.putDecoration(userConditionNode, new TargetType(boolean.class));
        decorateWithCast(userConditionNode, semanticScope);
     * Checks: type validation
        if (constructor == null) {
                );
                throw userNumericNode.createError(new IllegalStateException("Illegal tree structure."));
                        + "] arguments, but found ["
        List<AStatement> userStatementNodes = userBlockNode.getStatementNodes();
        int userArgumentsSize = userArgumentNodes.size();
        }
                throw userFunctionRefNode.createError(
                    typeParameters.add(interfaceMethod.typeParameters.get(i));
                    // shifts are promoted independently, but for the def type, we need object.
    }
                    break;
        visit(userElseBlockNode, semanticScope.newLocalScope());
                semanticScope.putDecoration(userLeftNode, new TargetType(binaryType));
    public void visitDot(EDot userDotNode, SemanticScope semanticScope) {
            throw userDeclarationNode.createError(
            } else {
            valueType = localFunction.getReturnType();
    }
                        )
                throw userSymbolNode.createError(
                new IllegalArgumentException("invalid assignment: cannot assign a value to elvis operation [?:]")
        String decimal = userDecimalNode.getDecimal();
    }
                new IllegalStateException(
                new IllegalArgumentException("invalid assignment: cannot assign a value to string constant [" + string + "]")
     * may resolve to a static type, a partial canonical type, a field, a shortcut to a
     */
            valueType = String.class;
        } else if (Map.class.isAssignableFrom(prefixValueType)) {
        decorateWithCast(userConditionNode, semanticScope);
                )
import org.opensearch.painless.AnalyzerCaster;
                        + "]"
        FunctionTable.LocalFunction localFunction = null;
        visit(userBlockNode, semanticScope);
            semanticScope.putDecoration(userCallLocalNode, new StandardConstant(classBindingOffset));
                        throw userDotNode.createError(
            String parameterName = parameterNames.get(index);
                )
        if (userBlockNode != null) {
        SBlock userBlockNode = userLambdaNode.getBlockNode();
                compoundType = AnalyzerCaster.promoteXor(leftValueType, rightValueType);
        }
            );
        } else {
        semanticScope.replicateCondition(userTryNode, userBlockNode, InLoop.class);
            }
                    classBinding = null;
                    )
                throw userWhileNode.createError(new IllegalArgumentException("no paths escape from while loop"));
     * Checks: type checking, type resolution, variable resolution
    /**
            );
        }
                semanticScope.putDecoration(userChildNode, new TargetType(unaryType));
    /**
        Class<?> type = semanticScope.getScriptScope().getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
                            + "] and "
                }
                    + "] in ["
                case 'u':
                semanticScope.putDecoration(userDotNode, new StaticType(staticType));
 */
    @Override
                    new TargetType(setter != null ? setter.typeParameters.get(0) : getter.typeParameters.get(0))
        Class<?> valueType;
                    )
                location,
            checkedVisit(userRightNode, semanticScope);
            } else if (userInitializerNode instanceof AExpression) {
                    if (classBinding == null) {
            semanticScope.putDecoration(
                    new IllegalArgumentException(
                                + operation.name
                            + "cannot apply ["
            } else {
                    constant |= Pattern.COMMENTS;
        String symbol = userDeclarationNode.getSymbol();
    public void visitString(EString userStringNode, SemanticScope semanticScope) {
        if (userLeftNode instanceof EBooleanConstant
            );
import org.opensearch.painless.symbol.Decorations.InstanceType;
        AExpression userValueNode = userReturnNode.getValueNode();
     * Visits a symbol expression which covers static types, partial canonical types,
            throw userNewObjNode.createError(
                            "invalid assignment: "
                throw userSymbolNode.createError(new IllegalArgumentException("Variable [" + variable.getName() + "] is read-only."));
                        + " operator "
                            classBindingOffset = 1;
                checkedVisit(userChildNode, semanticScope);
            throw userContinueNode.createError(new IllegalArgumentException("invalid continue statement: not inside loop"));
     * Checks: control flow
        boolean write = semanticScope.getCondition(userBraceNode, Write.class);
            );
                targetType.getTargetType(),
            } else if (operation == Operation.DIV) {
import org.opensearch.painless.symbol.Decorations.StandardPainlessConstructor;
                    typeParameters.add(def.class);
                        valueType = field.typeParameter;
            } else {
                        PainlessMethod setter;
                && (!getter.typeParameters.get(0).equals(setter.typeParameters.get(0))
    public void visitBreak(SBreak userBreakNode, SemanticScope semanticScope) {
            );
                                0
                        scriptScope.getPainlessLookup(),
        AExpression userConditionNode = userIfNode.getConditionNode();
                                    throw userDotNode.createError(new IllegalArgumentException("Shortcut argument types must match."));
        List<String> parameterNames = userLambdaNode.getParameterNames();
        if (targetType == null) {
            .getFunction(functionName, userFunctionNode.getCanonicalTypeNameParameters().size());
                    throw userDotNode.createError(
        if (unaryType != null) {
        if (operation == Operation.EQR || operation == Operation.NER || promotedType != def.class) {
            valueType = boolean.class;
            }
                semanticScope.putDecoration(userDotNode, new ValueType(valueType));
                }
                    "cannot have both "
        }
                if (userDotNode.isNullSafe()) {
                    "invalid assignment: cannot assign a value to " + operation.name + " operation " + "[" + operation.symbol + "]"
        } catch (PatternSyntaxException pse) {
                                    semanticScope.putDecoration(userDotNode, new GetterPainlessMethod(getter));
            numeric = "-" + numeric;
            throw userNewArrayNode.createError(new IllegalArgumentException("Not a type [" + canonicalTypeName + "]."));
                            );
        semanticScope.setCondition(userRightNode, Read.class);
            throw userDecimalNode.createError(
            );
        decorateWithCast(userLeftNode, semanticScope);
                    }
            TargetType targetType = semanticScope.getDecoration(userBraceNode, TargetType.class);
            } else if (operation == Operation.XOR) {
        }
        semanticScope.replicateCondition(userIfBlockNode, userIfNode, AnyContinue.class);
                new IllegalArgumentException(
            semanticScope.replicateCondition(userBlockNode, userCatchNode, AnyBreak.class);
     * getter/setter method on a type, or a getter/setter for a Map or List.
            semanticScope.copyDecoration(userUnaryNode, userChildNode, TargetType.class);
        visit(userIfBlockNode, semanticScope.newLocalScope());
            throw userElvisNode.createError(new IllegalArgumentException("Extraneous elvis operator. LHS is null."));
            }
    /**
                    }
                    typeParameters.add(typeParameter);
     * Visits a list init expression which is a shortcut for initializing a list with pre-defined values.
     * Visits a return statement and casts the value to the return type if possible.
                        + "in opensearch.yaml to allow them. Be careful though, regexes break out of Painless's protection against deep "
    }
                                        )
                );
            if (downcast != null) {
        }
            if (getter != null
            throw userFunctionNode.createError(
                throw userFunctionRefNode.createError(
                )
            throw userBinaryNode.createError(
                    defReferenceEncoding = "S" + captured.getCanonicalTypeName() + "." + methodName + ",1";
    /**
        } else if (instanceBinding != null) {
                );
                if (operation == Operation.LSH || operation == Operation.RSH || operation == Operation.USH) {
        AExpression userAfterthoughtNode = userForNode.getAfterthoughtNode();
            decorateWithCast(userRightNode, semanticScope);
            throw userIfElseNode.createError(new IllegalArgumentException("extraneous if block"));
        String methodName = userCallLocalNode.getMethodName();
    public void visitNewArrayFunctionRef(ENewArrayFunctionRef userNewArrayFunctionRefNode, SemanticScope semanticScope) {
            throw userNewArrayFunctionRefNode.createError(
                );
                    semanticScope.putDecoration(userRightNode, new TargetType(binaryType));
                        "invalid assignment: cannot assign a value to function reference [" + symbol + ":" + methodName + "]"
import java.util.ArrayList;
            if (toParse.endsWith("d") || decimal.endsWith("D")) {
                throw userExpressionNode.createError(
                TargetType targetType = semanticScope.getDecoration(userNumericNode, TargetType.class);
        AExpression userPrefixNode = userDotNode.getPrefixNode();
            }
            throw userBooleanCompNode.createError(
                        new IllegalArgumentException(
            scriptScope.markNonDeterministic(classBinding.annotations.containsKey(NonDeterministicAnnotation.class));
            );
                if (compoundType == def.class) {
        for (AExpression userValueNode : userListInitNode.getValueNodes()) {
import org.opensearch.painless.symbol.Decorations.SemanticVariable;
        if (symbol.equals("this") || type != null) {
        } else if (prefixValueType == def.class) {
        semanticScope.putDecoration(userRegexNode, new StandardConstant(constant));
                new IllegalStateException(
import org.opensearch.painless.symbol.Decorations.EncodingDecoration;
                            );
                    semanticScope.putDecoration(userRightNode, new TargetType(def.class));
        AExpression userConditionNode = userForNode.getConditionNode();
                        } else {
    @Override
                new IllegalArgumentException("not a statement: regex constant [" + pattern + "] with flags [" + flags + "] not used")
                            + PainlessLookupUtility.typeToCanonicalTypeName(rightValueType)
        Class<?> valueType;
        SBlock userBlockNode = userFunctionNode.getBlockNode();
                        valueType = int.class;
        if (valueType == null) {
        boolean isInternalCast = semanticScope.getCondition(userExpressionNode, Internal.class);
                new IllegalStateException(
                                );
            valueType = targetType == null
 */
     */
            loopEscape &= semanticScope.getCondition(userCatchNode, LoopEscape.class);
        String name = scriptScope.getNextSyntheticName("newarray");
        Class<?>[] types = new Class<?>[constructor.typeParameters.size()];
                                "set" + Character.toUpperCase(index.charAt(0)) + index.substring(1),
                                        "Illegal set shortcut on field [" + index + "] for type [" + prefixCanonicalTypeName + "]."
        if (prefixValueType != null && prefixValueType.getValueType() == def.class) {
            try {
        if (semanticScope.getCondition(userIfBlockNode, MethodEscape.class)
    /**
            );
        }
                semanticScope.setCondition(userWhileNode, AllEscape.class);
    public void visitDeclaration(SDeclaration userDeclarationNode, SemanticScope semanticScope) {
        }
import org.opensearch.painless.symbol.Decorations.UnaryType;
    /**
     */
                throw userSymbolNode.createError(
            if (semanticScope.hasDecoration(userExpressionNode, PartialCanonicalTypeName.class)) {
            throw userMapInitNode.createError(new IllegalArgumentException("invalid assignment: cannot assign a value to map initializer"));
                compoundType = AnalyzerCaster.promoteNumeric(leftValueType, rightValueType, true);
            );
                                    && (!getter.typeParameters.get(0).equals(setter.typeParameters.get(0))
                                setter = scriptScope.getPainlessLookup().lookupPainlessMethod(prefixType, false, "put", 2);
                    "not a statement: result not used from explicit cast with target type [" + canonicalTypeName + "]"
                    // base script class without need for a user to add additional arguments. A long term solution
                        semanticScope.putDecoration(userRightNode, new TargetType(shiftType));
                                    );
     * Visits a conditional expression.
                throw userNumericNode.createError(new IllegalArgumentException("Invalid int constant [" + numeric + "]."));
            throw userBreakNode.createError(new IllegalArgumentException("invalid break statement: not inside loop"));
                        throw new IllegalArgumentException("Result of null safe operator must be nullable");
import org.opensearch.painless.node.ENewObj;
                    }
        try {
                        + "/"
     */
                }
            userAssignmentNode,
            );
                Class<?> valueType = null;
                            + "]"
    /**
                    Long.parseLong(numeric, radix);
        AExpression userIndexNode = userBraceNode.getIndexNode();
import org.opensearch.painless.lookup.PainlessField;
                throw userConditionalNode.createError(
            anyContinue |= semanticScope.getCondition(userStatementNode, AnyContinue.class);
            throw userDoNode.createError(new IllegalArgumentException("extraneous do-while loop"));
        if (targetType == null) {
                    break;
                            + "]"
                    "invalid assignment: cannot assign a value to " + operation.name + " operation " + "[" + operation.symbol + "]"
                                    throw userDotNode.createError(
            decorateWithCast(userRightNode, semanticScope);
        }
                    "invalid foreach loop: "
        AExpression userTrueNode = userConditionalNode.getTrueNode();
                case 'c':
            semanticScope.setCondition(userIfElseNode, AnyContinue.class);
        AExpression userConditionNode = userDoNode.getConditionNode();
            }
            functionScope.defineVariable(userFunctionNode.getLocation(), typeParameter, parameterName, false);
            semanticScope.setCondition(userBlockNode, InLoop.class);
        PainlessInstanceBinding instanceBinding = null;
            if (interfaceMethod.returnType == void.class) {
                    semanticScope.putDecoration(userBraceNode, new GetterPainlessMethod(getter));
                            "invalid assignment: "
    @Override
            }
     */
                        + "]"
            throw userNumericNode.createError(new IllegalArgumentException("not a statement: numeric constant [" + numeric + "] not used"));
        }
        Class<?> valueType = scriptScope.getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
                throw userNumericNode.createError(new IllegalArgumentException("Invalid long constant [" + numeric + "]."));
                )
                                + "]"
     * Checks: type validation
            );
                && (getter.returnType == void.class || getter.typeParameters.size() != 1 || getter.typeParameters.get(0) != int.class)) {
            if (read == false && write == false) {
    }
            }
        } else {
    /**
        }
        semanticScope.putDecoration(userListInitNode, new StandardPainlessConstructor(constructor));
        }
        Class<?> valueType;
        if (userConditionNode != null) {
import org.opensearch.painless.symbol.Decorations.StandardPainlessInstanceBinding;
                    );
            typeParametersWithCaptures.add(capturedVariable.getType());
            semanticScope.setCondition(userTryNode, MethodEscape.class);
                    }
    @Override
        visit(userBlockNode, semanticScope.newLocalScope());
     * Checks: type validation
            }
            );
        AStatement lastUserStatement = userStatementNodes.get(userStatementNodes.size() - 1);
                }
        List<AExpression> userKeyNodes = userMapInitNode.getKeyNodes();
                        + "to ["
     * Visits a catch statement and defines a variable for the caught exception.
import org.opensearch.painless.symbol.Decorations.BeginLoop;
        }
                throw userDoNode.createError(new IllegalArgumentException("extraneous do-while loop"));
                            + operation.symbol
                if (captured.getType() != def.class) {
        checkedVisit(userPrefixNode, semanticScope);
        Class<?> shiftType = null;
            Pattern.compile(pattern, constant);
                            }
                    binaryType = null;
        semanticScope.putDecoration(userConditionalNode, new ValueType(valueType));
        semanticScope.replicateCondition(userIfNode, userIfBlockNode, InLoop.class);
        Class<?> valueType;
        semanticScope.setCondition(userRightNode, Read.class);
                    FunctionRef ref = FunctionRef.create(
                        new IllegalArgumentException("Argument(s) cannot be of [void] type when calling method [" + methodName + "].")
                    )
            );
        TargetType targetType = semanticScope.getDecoration(userLambdaNode, TargetType.class);
        Location location = userDeclarationNode.getLocation();
    }
            if (binaryType == def.class || shiftType == def.class) {
                    typeParameters.add(typeParameter);
                            + "["
            }
        if (userInitializerNode != null) {
                if (prefixValueType != null && prefixValueType.getValueType().isArray()) {
import org.opensearch.painless.symbol.Decorations.AllEscape;
        }
     * Checks: control flow
     * Visits a block and which contains one-to-many statements.
        FunctionScope functionScope = newFunctionScope(scriptScope, localFunction.getReturnType());
        if (targetType != null && targetType.getTargetType().isPrimitive()) {
            } else {
        }
            semanticScope.setCondition(userChildNode, Negate.class);
        }
import org.opensearch.painless.node.ENumeric;
        semanticScope.putDecoration(userDeclarationNode, new SemanticVariable(variable));
import org.opensearch.painless.symbol.Decorations.StaticType;
        semanticScope.putDecoration(userCatchNode, new SemanticVariable(variable));
        if (semanticScope.getCondition(userIfBlockNode, LoopEscape.class)
                                } catch (NumberFormatException nfe) {
                semanticScope.setCondition(userDoNode, ContinuousLoop.class);
                } else {
        semanticScope.setCondition(userBreakNode, LoopEscape.class);
                                    && setter != null
        AExpression userChildNode = userExplicitNode.getChildNode();
            if (semanticScope.hasDecoration(userUnaryNode, TargetType.class)) {
        Class<?> returnType = localFunction.getReturnType();
            typeParameters = new ArrayList<>(canonicalTypeNameParameters.size());
            if (continuous && semanticScope.getCondition(userBlockNode, AnyBreak.class) == false) {
        semanticScope.setCondition(userLeftNode, Read.class);
            }
        StaticType prefixStaticType = semanticScope.getDecoration(userPrefixNode, StaticType.class);
                    if (write) {
                        + "]"
                    "cannot cast from ["
            }
        } else {
    public void visitNewObj(ENewObj userNewObjNode, SemanticScope semanticScope) {
        String numeric = userNumericNode.getNumeric();
            semanticScope.setCondition(userIfElseNode, MethodEscape.class);
                    constant = integer;
        for (AExpression userValueNode : userNewArrayNode.getValueNodes()) {
        semanticScope.setCondition(userThrowNode, LoopEscape.class);
    public void visitIfElse(SIfElse userIfElseNode, SemanticScope semanticScope) {
        AExpression userExpressionNode = userInstanceofNode.getExpressionNode();
                )
                shiftType = AnalyzerCaster.promoteNumeric(rightValueType, false);
    }
                            if ((read == false || getter != null) && (write == false || setter != null)) {
                throw userBraceNode.createError(new IllegalArgumentException("Shortcut argument types must match."));
                new IllegalArgumentException(
                    }
        semanticScope.putDecoration(userNewArrayNode, new ValueType(valueType));
        Class<?> returnType;
                        + "["
     * Checks: type validation, method resolution, field resolution
        checkedVisit(userLeftNode, semanticScope);
        if (semanticScope.getCondition(userListInitNode, Write.class)) {
            if (read == false) {
import org.opensearch.painless.symbol.Decorations.AnyContinue;
     * Visits a for-each statement which and adds an internal variable for a generated iterator.
                throw userBraceNode.createError(
    public void visitBooleanConstant(EBooleanConstant userBooleanConstantNode, SemanticScope semanticScope) {
     * Visits an assignment expression which handles both assignment and compound assignment.
        Class<?> rightValueType = semanticScope.getDecoration(userFalseNode, ValueType.class).getValueType();
        semanticScope.setCondition(userLeftNode, Read.class);
                                    throw userDotNode.createError(new IllegalArgumentException("invalid list index [" + index + "]", nfe));
                throw userDecimalNode.createError(new IllegalArgumentException("Invalid float constant [" + decimal + "]."));
        semanticScope.setCondition(userExpressionNode, Read.class);
                semanticScope.putDecoration(userAssignmentNode, new UpcastPainlessCast(upcast));
        for (SFunction userFunctionNode : userClassNode.getFunctionNodes()) {
    public void visitWhile(SWhile userWhileNode, SemanticScope semanticScope) {
                    // as part of its API. However, the situation at run-time is difficult and will modifications that
                } else if (prefixValueType != null && prefixValueType.getValueType() == def.class) {
        semanticScope.putDecoration(userNumericNode, new StandardConstant(constant));
            decorateWithCast(userRightNode, semanticScope);
import org.opensearch.painless.node.SEach;
                                throw userDotNode.createError(
            }
        Class<?> leftValueType = semanticScope.getDecoration(userLeftNode, ValueType.class).getValueType();
        semanticScope.putDecoration(userNewArrayFunctionRefNode, new ValueType(valueType));
     * unexpected value type.
                                + PainlessLookupUtility.typeToCanonicalTypeName(staticType)
                valueType = double.class;
            } else {
     * Visits a dot expression which is a field index with a qualifier (prefix) and
            }
    public void visitBrace(EBrace userBraceNode, SemanticScope semanticScope) {
            decorateWithCast(userConditionNode, semanticScope);
                        + functionName
                    Class<?> typeParameter = scriptScope.getPainlessLookup().canonicalTypeNameToType(paramType);
        semanticScope.putDecoration(userCompNode, new ComparisonType(promotedType));
            throw userDotNode.createError(
import org.opensearch.painless.lookup.PainlessMethod;
        }
                            } else {
                || targetType.getTargetType() == ZonedDateTime.class
                throw userBraceNode.createError(
        if (prefixValueType != null && prefixStaticType != null) {
        if (userRightNode instanceof ENull) {
                + index;
                throw userWhileNode.createError(new IllegalArgumentException("extraneous while loop"));
                } else {
            throw userBooleanCompNode.createError(
            if (getter != null
        Location location = userCatchNode.getLocation();
        }
        boolean isAutoReturnEnabled = userFunctionNode.isAutoReturnEnabled();
 *
        SBlock userIfBlockNode = userIfNode.getIfBlockNode();
    /**
                decorateWithCast(userIndexNode, semanticScope);
        }
                                        new IllegalArgumentException("Illegal map get shortcut for type [" + prefixCanonicalTypeName + "].")
            }
                int integer = Integer.parseInt(numeric, radix);
                valueType = String.class;
                                + "["
        TargetType targetType = semanticScope.getDecoration(userFunctionRefNode, TargetType.class);
                    "Regexes are disabled. Set [script.painless.regex.enabled] to [true] "
                )
        if (targetType != null) {
        checkedVisit(userLeftNode, semanticScope);
                checkedVisit(userIndexNode, semanticScope);
            }
            );
    @Override
        AExpression userPrefixNode = userCallNode.getPrefixNode();
            semanticScope.putDecoration(userValueNode, new TargetType(semanticScope.getReturnType()));
                }
            PainlessCast downcast = AnalyzerCaster.getLegalCast(location, compoundType, leftValueType, true, false);
    /**
        if (semanticScope.getCondition(userNewArrayNode, Read.class) == false) {
        if (semanticScope.getCondition(userBreakNode, InLoop.class) == false) {
                scriptScope.getCompilerSettings().asMap()
                            && classBinding.typeParameters.get(0) == scriptScope.getScriptClassInfo().getBaseClass()) {
        PainlessClassBinding classBinding = null;
import org.opensearch.painless.symbol.Decorations.ReferenceDecoration;
     * Visits a function and defines variables for each parameter.
     */
            semanticScope.setCondition(userArgumentNode, Read.class);
                        "invalid assignment: cannot assign type [" + PainlessLookupUtility.typeToCanonicalTypeName(void.class) + "]"
            throw userElvisNode.createError(
 * this file be licensed under the Apache-2.0 license or a
        if (semanticScope.getCondition(userContinueNode, InLoop.class) == false) {
                    new IllegalArgumentException("not a statement: function reference [" + symbol + ":" + methodName + "] not used")
            semanticScope.putDecoration(userCallNode, new StandardPainlessMethod(method));
                                    "is" + Character.toUpperCase(index.charAt(0)) + index.substring(1),
            if (staticType != null) {
            throw userCatchNode.createError(
                    semanticScope.putDecoration(userBraceNode, new SetterPainlessMethod(setter));
     */
                checkedVisit((AExpression) userInitializerNode, semanticScope);
            );
                        + typeParameters.size()
            } else {
                    new IllegalArgumentException(
     * Checks: type validation
import org.opensearch.painless.symbol.Decorations.CapturesDecoration;
            leftValueType = rightValueType;
            }
                            if (List.class.isAssignableFrom(prefixType)) {
        }
        checkedVisit(userConditionNode, semanticScope);
            semanticScope.putDecoration(userLeftNode, new TargetType(promotedType));
                        scriptScope.getCompilerSettings().asMap()
        }
        if (semanticScope.getCondition(userIfBlockNode, AllEscape.class)
    @Override
        Class<?> valueType;
                    scriptScope.getCompilerSettings().asMap()
        boolean isVoid = rtnType == void.class;
                semanticScope.replicateCondition(userStatementNode, userBlockNode, LoopEscape.class);
                }
    }
        PainlessMethod method = semanticScope.getScriptScope().getPainlessLookup().lookupPainlessMethod(valueType, false, "put", 2);
            // we know the method statically, infer return type and any unknown/def types
                                    valueType = setter != null ? setter.typeParameters.get(1) : getter.returnType;
        List<Variable> capturedVariables = new ArrayList<>(lambdaScope.getCaptures());
     * Visits an if statement with error checking for an extraneous if.
        semanticScope.replicateCondition(userElvisNode, userLeftNode, Explicit.class);
            }
        if (userValueNode != null) {
        String symbol = userEachNode.getSymbol();
        }
        if (semanticScope.getCondition(userMapInitNode, Read.class) == false) {
                throw userReturnNode.createError(
            if (rightValueType == void.class) {
                || semanticScope.getCondition(userCallNode, Explicit.class) ? def.class : targetType.getTargetType();
                            if (getter != null && setter != null && setter.typeParameters.get(0) != getter.returnType) {
        }
     */
        visit(userPrefixNode, semanticScope);
        Class<?> valueType;
import org.opensearch.painless.node.SExpression;
            throw userMapInitNode.createError(new IllegalStateException("Illegal tree structure."));
                                + "["
                );
                AExpression userArgumentNode = userArgumentNodes.get(argument);
        for (int i = 0; i < userKeyNodes.size(); ++i) {
import org.opensearch.painless.spi.annotation.NonDeterministicAnnotation;
            semanticScope.putDecoration(userCallLocalNode, new StandardPainlessMethod(importedMethod));
        // inspect the target first, set interface method if we know it.
            throw userCallNode.createError(
        if (clazz == null) {
            } else if (operation == Operation.LSH) {
    /**
        checkedVisit(userConditionNode, semanticScope);
                    constant |= Pattern.CASE_INSENSITIVE;
                    );
            returnType = def.class;
        semanticScope.setCondition(userRightNode, Read.class);
            semanticScope.putDecoration(userRightNode, new TargetType(leftValueType));
            );
        checkedVisit(userRightNode, semanticScope);
     */
            );
    @Override
                            throw userDotNode.createError(
            semanticScope.setCondition(userValueNode, Read.class);
    public void visitEach(SEach userEachNode, SemanticScope semanticScope) {
            }
    @Override
        String flags = userRegexNode.getFlags();
                    constant = (short) integer;
        if (userElseBlockNode == null) {
     */
 * SPDX-License-Identifier: Apache-2.0
        Class<?> valueType = HashMap.class;
                    new IllegalArgumentException("Illegal list set shortcut for type [" + canonicalClassName + "].")
                    );
        localFunction = scriptScope.getFunctionTable().getFunction(methodName, userArgumentsSize);
            throw userEachNode.createError(new IllegalArgumentException("extraneous foreach loop"));
                returnType = def.class;
            semanticScope.putDecoration(userFalseNode, new TargetType(promote));
    /**
                decorateWithCast(userChildNode, semanticScope);
                        + "["
                    );
                if (continuous == false) {
import org.opensearch.painless.node.ENewArrayFunctionRef;
            if (binaryType == null) {
     */
            semanticScope.putDecoration(userSymbolNode, new ValueType(valueType));
                    );
                                + "cannot write a value to a static type ["
            } else if (operation == Operation.REM) {
        checkedVisit(userConditionNode, semanticScope);
                        if (classBinding.typeParameters.isEmpty() == false
                    break;
        }
                    "Illegal array access on type " + "[" + PainlessLookupUtility.typeToCanonicalTypeName(prefixValueType) + "]."
            semanticScope.replicateCondition(userTryNode, userCatchNode, LastLoop.class);
                                + "] "
        }
            decorateWithCast(userValueNode, semanticScope);
                if (method == null) {
        if (semanticScope.getCondition(userNewObjNode, Write.class)) {
            throw userBinaryNode.createError(
                    }
        if (read == false && write == false) {
                        captured.getCanonicalTypeName(),
    public void visitElvis(EElvis userElvisNode, SemanticScope semanticScope) {
                    "cannot apply the "
            semanticScope.putDecoration(userCallLocalNode, new StandardLocalFunction(localFunction));
import org.opensearch.painless.node.ECall;
                        }
                        PainlessMethod getter;
import org.opensearch.painless.symbol.Decorations.ShiftType;
            );
    /**
                        "cannot cast from "
     * Visits a class.
    public void visitExpression(SExpression userExpressionNode, SemanticScope semanticScope) {
    }
                case 'U':
        }
        }
        checkedVisit(userConditionNode, semanticScope);
    /**
        } else {
        }
            throw userNewObjNode.createError(
                        + operation.name
                            + "] and "
                );
                                    new IllegalArgumentException(
                                + ", "
                String defReferenceEncoding = "S" + symbol + "." + methodName + ",0";
                        if (getter != null || setter != null) {
        decorateWithCast(userLeftNode, semanticScope);
                                    prefixType,
 * valid control flow, valid types, valid variable resolution, valid method resolution,
        } else {
        }
    }
            );
import org.opensearch.painless.symbol.Decorations.TypeParameters;
        Class<?> valueType = semanticScope.getDecoration(userExpressionNode, ValueType.class).getValueType();
/*
                            + operation.symbol
            checkedVisit(userValueNode, semanticScope);
        } else if (List.class.isAssignableFrom(prefixValueType)) {
     * a single-dimensional with pre-defined values.
import org.opensearch.painless.symbol.Decorations.IterablePainlessMethod;
        }
import org.opensearch.painless.node.EBinary;
            Class<?> rightValueType = semanticScope.getDecoration(userRightNode, ValueType.class).getValueType();
        if (semanticScope.getCondition(userRegexNode, Read.class) == false) {
                "this",
            decorateWithCast(userValueNode, semanticScope);
                                if (getter != null
                                        new IllegalArgumentException("Illegal list shortcut for type [" + prefixCanonicalTypeName + "].")
                        + "] with ["
                        + "and type ["
        }
    public void visitListInit(EListInit userListInitNode, SemanticScope semanticScope) {
                    constant = (byte) integer;
                        "not a statement: capturing function reference [" + symbol + ":" + methodName + "] not used"
            PainlessMethod method;
        Operation operation = userBooleanCompNode.getOperation();
                    constant |= Pattern.LITERAL;
        boolean allEscape = semanticScope.getCondition(userBlockNode, AllEscape.class);
        if (userConditionNode instanceof EBooleanConstant || userIfBlockNode == null) {
        Class<?> valueType = semanticScope.getScriptScope().getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
        Class<?> leftValueType = semanticScope.getDecoration(userLeftNode, Decorations.ValueType.class).getValueType();
    @Override
                .getPartialCanonicalTypeName()
import org.opensearch.painless.symbol.Decorations.MethodNameDecoration;
        }
                } else if (sort == short.class && integer >= Short.MIN_VALUE && integer <= Short.MAX_VALUE) {
            AExpression userArgumentNode = userArgumentNodes.get(i);
            valueType = importedMethod.returnType;
            );
            throw userRegexNode.createError(
     */
            // we don't know anything: treat as def
                valueType = float.class;
import org.opensearch.painless.symbol.Decorations;
                    if ("length".equals(index)) {
            String canonicalClassName = PainlessLookupUtility.typeToCanonicalTypeName(prefixValueType);
                        } else if (isStatic == false) {
                                new IllegalArgumentException(
            Location location = userSymbolNode.getLocation();
            semanticScope.setCondition(userBraceNode, ListShortcut.class);
            // don't infer any types, replace any null types with def
                                    "invalid assignment: cannot assign a value write to read-only field [length] for an array."
                if (unaryType == null) {
                semanticScope.putDecoration(userRightNode, new TargetType(rightValueType));
                                        || getter.typeParameters.get(0) != int.class)) {
                            + PainlessLookupUtility.typeToCanonicalTypeName(void.class)
                                    )
        }
            visit(userDeclarationNode, semanticScope);
            valueType = prefixValueType.getComponentType();
        String symbol = userFunctionRefNode.getSymbol();
                && setter != null
                    new IllegalArgumentException("Illegal map shortcut for type [" + canonicalClassName + "].")
        semanticScope.replicateCondition(userIfElseNode, userIfBlockNode, LastSource.class);
        semanticScope.replicateCondition(userAssignmentNode, userLeftNode, Read.class);
    /**
        boolean isExplicitCast = semanticScope.getCondition(userExpressionNode, Explicit.class);
    }
                                .lookupPainlessMethod(
     */
        boolean beginLoop = semanticScope.getCondition(userBlockNode, BeginLoop.class);
import org.opensearch.painless.symbol.Decorations.StandardLocalFunction;
                throw userAssignmentNode.createError(
                    throw userNumericNode.createError(
            } else if (operation == Operation.USH) {
                                        )
        Variable variable = semanticScope.defineVariable(location, type, symbol, true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    new IllegalArgumentException(
                        + prefixStaticType.getStaticCanonicalTypeName()
                }
        Location location = userRegexNode.getLocation();
        ScriptScope scriptScope = semanticScope.getScriptScope();
                    if (shiftType == long.class) {
            if (userStatementNode == lastUserStatement) {
                        "cannot resolve symbol ["
            valueType = binaryType;
        }
        AExpression userConditionNode = userWhileNode.getConditionNode();
        AExpression userConditionNode = userIfElseNode.getConditionNode();
            }
     * Checks: control flow, type validation
        visit(userPrefixNode, semanticScope);
                        )
            );
            semanticScope.getScriptScope().markNonDeterministic(method.annotations.containsKey(NonDeterministicAnnotation.class));
                            if (getter != null) {
                                + "]"
        }
    }
                semanticScope.setCondition(userArgumentNode, Internal.class);
        }
        }
        }
            valueType = promote;
import org.opensearch.painless.Operation;
        }
                                + "cannot write a value to a static type ["
                    semanticScope.setCondition(userBlockNode, AllEscape.class);
     * Checks: type validation
                TargetType targetType = semanticScope.getDecoration(userBinaryNode, TargetType.class);
        if (semanticScope.getCondition(userDecimalNode, Read.class) == false) {
                );
        int classBindingOffset = 0;
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;
                shiftType = AnalyzerCaster.promoteNumeric(rightValueType, false);
        if (numeric.endsWith("d") || numeric.endsWith("D")) {
        semanticScope.replicateCondition(userIfElseNode, userElseBlockNode, LastLoop.class);
                        instanceBinding = scriptScope.getPainlessLookup().lookupPainlessInstanceBinding(methodName, userArgumentsSize);
                        }
        typeParametersWithCaptures.addAll(typeParameters);
                if (targetType != null) {
            throw userCompNode.createError(new IllegalStateException("unexpected binary operation [" + operation.name + "]"));
        semanticScope.setCondition(userChildNode, Explicit.class);
        String canonicalTypeName = userNewArrayFunctionRefNode.getCanonicalTypeName();
                scriptScope.getPainlessLookup(),
                }
                new IllegalArgumentException(
                // static case
        decorateWithCast(userFalseNode, semanticScope);
     * Visits a call expression which is a method call with a qualifier (prefix).
                        if (getter == null) {
        }
            semanticScope.putDecoration(userLeftNode, new TargetType(String.class));
import org.opensearch.painless.node.EString;
                    break;
        checkedVisit(userFalseNode, semanticScope);
            Class<?> promote = AnalyzerCaster.promoteConditional(leftValueType, rightValueType);
        if (userBlockNode.getStatementNodes().isEmpty()) {
    }
                semanticScope.putDecoration(userFunctionRefNode, new EncodingDecoration(defReferenceEncoding));
        }
     * Visits a lambda expression which adds a new internal method to the class as defined by the lambda.
                                )
                binaryType = AnalyzerCaster.promoteNumeric(leftValueType, false);
                                }
        if (semanticScope.getCondition(userCompNode, Write.class)) {
                                    && setter != null
        boolean read = semanticScope.getCondition(userDotNode, Read.class);
        }
                    valueType = unaryType;
 */
            }
            decorateWithCast(userLeftNode, semanticScope);
                throw userAssignmentNode.createError(
                        + PainlessLookupUtility.typeToCanonicalTypeName(leftValueType)
            throw userCallLocalNode.createError(
                    + interfaceMethod.javaMethod.getName()
        ScriptScope scriptScope = semanticScope.getScriptScope();
            throw userDecimalNode.createError(new IllegalArgumentException("not a statement: decimal constant [" + decimal + "] not used"));
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
                throw userFunctionRefNode.createError(
            try {
import org.opensearch.painless.symbol.Decorations.Shortcut;
        String canonicalTypeName = userNewArrayNode.getCanonicalTypeName();
            }
            );
                location,
            try {
                );
        }
            } else {
        Class<?> targetType = semanticScope.getDecoration(userExpressionNode, TargetType.class).getTargetType();
        semanticScope.putDecoration(userInstanceofNode, new InstanceType(instanceType));
                                semanticScope.setCondition(userDotNode, ListShortcut.class);
            switch (flag) {
            typeParameters = new ArrayList<>(classBinding.typeParameters);
                if (classBinding == null) {
                }
                    new IllegalArgumentException(
                                )
        Class<?> valueType;
        }
            if (operation == Operation.MUL || operation == Operation.DIV || operation == Operation.REM) {
                                }
                new IllegalArgumentException("constructor [" + typeToCanonicalTypeName(valueType) + ", <init>/0] not found")
            decorateWithCast(userKeyNode, semanticScope);
    public void visitMapInit(EMapInit userMapInitNode, SemanticScope semanticScope) {
                );
import org.opensearch.painless.symbol.Decorations.CompoundType;
        semanticScope.putDecoration(userInstanceofNode, new ValueType(boolean.class));
            } else if (isShift) {
                new IllegalArgumentException(
        String methodName = userCallNode.getMethodName();
            } else {
            String canonicalTypeName = semanticScope.getDecoration(userPrefixNode, PartialCanonicalTypeName.class)
        if (semanticScope.getScriptScope().getCompilerSettings().areRegexesEnabled() == CompilerSettings.RegexEnabled.FALSE) {
     */
     * Checks: type validation
import org.opensearch.painless.node.STry;
                            if (getter != null && (getter.returnType == void.class || !getter.typeParameters.isEmpty())) {
            try {
                )
        if (operation == Operation.SUB && (userChildNode instanceof ENumeric || userChildNode instanceof EDecimal)) {
 * the Apache License, Version 2.0 (the "License"); you may
                            + "] and ["
            continuous = true;
                valueType = setter != null ? setter.typeParameters.get(1) : getter.returnType;
        if (scriptScope.getPainlessLookup().isValidCanonicalClassName(symbol)) {
            for (int argument = 0; argument < userArgumentsSize; ++argument) {
                throw userWhileNode.createError(new IllegalArgumentException("extraneous while loop"));
                if (shiftType == null) {
import java.util.regex.Pattern;
                );
                semanticScope.setCondition(userArgumentNode, Internal.class);
            );
        }
        ANode userInitializerNode = userForNode.getInitializerNode();
                compoundType = AnalyzerCaster.promoteNumeric(leftValueType, rightValueType, true);
        } else {
     */
                        + PainlessLookupUtility.typeToCanonicalTypeName(iterableValueType)
        semanticScope.replicateCondition(userIfNode, userIfBlockNode, LastLoop.class);
                String staticCanonicalTypeName = prefixStaticType.getStaticCanonicalTypeName() + "." + userDotNode.getIndex();
                new IllegalArgumentException(
    }
                                throw userDotNode.createError(
import org.opensearch.painless.symbol.Decorations.Read;
        semanticScope.putDecoration(userBooleanCompNode, new ValueType(boolean.class));
            }
                semanticScope.putDecoration(userEachNode, new ExpressionPainlessCast(painlessCast));
            semanticScope.replicateCondition(userCatchNode, userBlockNode, LastLoop.class);
                    "constructor [" + typeToCanonicalTypeName(valueType) + ", <init>/" + userArgumentsSize + "] not found"
                )
                        + "] "
        if (operation == Operation.EQ || operation == Operation.EQR || operation == Operation.NE || operation == Operation.NER) {
                if (method == null) {
            semanticScope.putDecoration(userSymbolNode, new PartialCanonicalTypeName(symbol));
        SBlock userBlockNode = userEachNode.getBlockNode();
        boolean read = semanticScope.getCondition(userFunctionRefNode, Read.class);
        if (semanticScope.getCondition(userUnaryNode, Read.class) == false) {
                semanticScope.setCondition(userDoNode, MethodEscape.class);
            decorateWithCast(userIndexNode, semanticScope);
                "Incorrect number of parameters for ["
        if (valueType == null) {
                    throw userCallNode.createError(
                                    throw userDotNode.createError(
                                );
        }
        }
                throw userBraceNode.createError(
                                if (setter != null && setter.typeParameters.size() != 2) {
        if (semanticScope.hasDecoration(userPrefixNode, PartialCanonicalTypeName.class)) {
                        "not a statement: " + "static type [" + PainlessLookupUtility.typeToCanonicalTypeName(staticType) + "] not used"
                && semanticScope.getCondition(userBlockNode, AnyContinue.class) == false) {
        semanticScope.setCondition(userBlockNode, InLoop.class);
                    }
            || userLeftNode instanceof EDecimal
            // for method invocation, its allowed to ignore the return value
        semanticScope.putDecoration(userNullNode, new ValueType(valueType));
        semanticScope.putDecoration(userCallLocalNode, new ValueType(valueType));
                new IllegalArgumentException("invalid assignment: cannot assign a value to conditional operation [?:]")
                    break;
                semanticScope.putDecoration(userChildNode, new TargetType(boolean.class));
    /**
            allEscape = semanticScope.getCondition(userStatementNode, AllEscape.class);
     * Checks: type validation, method resolution, field resolution
            semanticScope.putDecoration(userRightNode, new TargetType(promote));
        AExpression userRightNode = userBooleanCompNode.getRightNode();
        }
        Class<?> rightValueType = semanticScope.getDecoration(userRightNode, ValueType.class).getValueType();
                                        "Illegal shortcut on field [" + index + "] for type [" + prefixCanonicalTypeName + "]."
                                if (getter != null) {
        if (promotedType == null) {
            throw userRegexNode.createError(
                                    && (!getter.typeParameters.get(0).equals(setter.typeParameters.get(0))
        }
            if (interfaceMethod.typeParameters.size() != canonicalTypeNameParameters.size()) throw new IllegalArgumentException(
                                    semanticScope.putDecoration(userDotNode, new SetterPainlessMethod(setter));
                                + methodName
        Object constant;
        }
                new IllegalArgumentException("invalid catch declaration: cannot resolve type [" + canonicalTypeName + "]")
            throw userMapInitNode.createError(
                        semanticScope.putDecoration(userRightNode, new TargetType(int.class));
                binaryType = AnalyzerCaster.promoteAdd(leftValueType, rightValueType);
                        "invalid assignment: cannot assign a value to capturing function reference [" + symbol + ":" + methodName + "]"
        }
                        + "value ["
 * under the License.
                        }
            if (write) {
        }
 * software distributed under the License is distributed on an
import org.opensearch.painless.lookup.PainlessCast;
                new IllegalArgumentException("method [" + typeToCanonicalTypeName(valueType) + ", put/2] not found")
        }
}
                        }
    }
        checkedVisit(userRightNode, semanticScope);
        }
        }
import org.opensearch.painless.symbol.Decorations.ValueType;
    public void visitLambda(ELambda userLambdaNode, SemanticScope semanticScope) {
                .lookupPainlessMethod(prefixValueType, false, "put", 2);
                }
        Location location = userExpressionNode.getLocation();
        semanticScope.setCondition(userBlockNode, BeginLoop.class);
                                + PainlessLookupUtility.typeToCanonicalTypeName(staticType)
    }
                semanticScope.setCondition(userChildNode, Read.class);
            }
        }
        Class<?> rightValueType = semanticScope.getDecoration(userRightNode, ValueType.class).getValueType();
                            }
     * Visits a regex constant expression which does additional work to initialize a regex using pre-defined flags.
                )
        if (userKeyNodes.size() != userValueNodes.size()) {
import static org.opensearch.painless.symbol.SemanticScope.newFunctionScope;
            if (prefixStaticType != null) {
                throw userFunctionRefNode.createError(
     * Visits a call local expression which is a method call with no qualifier (prefix).
                                    new IllegalArgumentException(
                                    new IllegalArgumentException(
                semanticScope.setCondition(userWhileNode, MethodEscape.class);
import org.opensearch.painless.node.AStatement;
                    constant |= Pattern.MULTILINE;
            throw userDotNode.createError(new IllegalArgumentException("not a statement: result of dot operator [.] not used"));
    /**
            }
                )
                    )
import org.opensearch.painless.symbol.Decorations.BinaryType;
                    new IllegalArgumentException("Illegal list get shortcut for type [" + canonicalClassName + "].")
import org.opensearch.painless.symbol.Decorations.MethodEscape;
import org.opensearch.painless.Location;
                            + PainlessLookupUtility.typeToCanonicalTypeName(staticType)
        semanticScope.putDecoration(userLambdaNode, new ValueType(valueType));
     */
            if (write && variable.isFinal()) {
                                )
                    valueType = byte.class;
        }
            throw userIfNode.createError(new IllegalArgumentException("extraneous if block"));
        scriptScope.getFunctionTable().addFunction(name, clazz, Collections.singletonList(int.class), true, true);
        if (methodEscape) {
                    && classBinding.typeParameters.get(0) == scriptScope.getScriptClassInfo().getBaseClass()) {
                                }
        semanticScope.putDecoration(userConditionNode, new TargetType(boolean.class));
            } else {
            throw userUnaryNode.createError(
                semanticScope.setCondition(userChildNode, Read.class);
        visit(userBlockNode, lambdaScope);
                            + " operator "
     * Visits a function ref expression which covers class function references,
                compoundType = AnalyzerCaster.promoteNumeric(leftValueType, false);
                    )
        if (painlessCast != null) {
import org.opensearch.painless.lookup.PainlessLookupUtility;
        if (loopEscape) {
        AExpression userExpressionNode = userThrowNode.getExpressionNode();
                    new IllegalArgumentException("Illegal list shortcut for type [" + canonicalClassName + "].")
                    .lookupPainlessMethod(prefixValueType.getValueType(), false, methodName, userArgumentsSize);
                            + "]"
            valueType = targetType.getTargetType();
    public void visitContinue(SContinue userContinueNode, SemanticScope semanticScope) {
     */
            throw userCatchNode.createError(
    public void visit(ANode userNode, SemanticScope semanticScope) {
            }
        if (semanticScope.getCondition(userNewArrayFunctionRefNode, Read.class) == false) {
     * Visits a do-while statement with error checking for an extraneous loop.
                            getter = scriptScope.getPainlessLookup()
            decorateWithCast(userRightNode, semanticScope);
        semanticScope.replicateCondition(userTryNode, userBlockNode, LastLoop.class);
import org.opensearch.painless.symbol.Decorations.DowncastPainlessCast;
                );
        if (semanticScope.getCondition(userBooleanCompNode, Write.class)) {
        if (semanticScope.getCondition(userInstanceofNode, Read.class) == false) {
        if (semanticScope.getCondition(userIfBlockNode, AnyBreak.class) || semanticScope.getCondition(userElseBlockNode, AnyBreak.class)) {
                                semanticScope.putDecoration(userDotNode, new SetterPainlessMethod(setter));
                    "invalid assignment: cannot assign a value to method call [" + methodName + "/" + userArgumentsSize + "]"
        String pattern = userRegexNode.getPattern();
        if (semanticScope.getCondition(userBlockNode, LoopEscape.class)
            if (continuous && semanticScope.getCondition(userBlockNode, AnyBreak.class) == false) {
        semanticScope.putDecoration(userLeftNode, new TargetType(boolean.class));
        List<Class<?>> typeParametersWithCaptures = new ArrayList<>(capturedVariables.size() + typeParameters.size());
                new IllegalArgumentException("constructor [" + typeToCanonicalTypeName(valueType) + ", <init>/0] not found")
            if (getter != null && (getter.returnType == void.class || getter.typeParameters.size() != 1)) {
        }
                )
                new IllegalArgumentException(
    @Override
                                    )
        if (userBlockNode != null) {
     * Checks: type validation
                .getPainlessLookup()
        int radix = userNumericNode.getRadix();
                    .getPainlessLookup()
            } else if (operation == Operation.ADD) {
            semanticScope.replicateCondition(userTryNode, userCatchNode, InLoop.class);
                    }
        }
        if (semanticScope.getCondition(userNullNode, Write.class)) {
                    valueType = targetType.getTargetType();
                new IllegalArgumentException(
        List<Class<?>> typeParameters;
    @Override
     * Checks: control flow
    public void visitClass(SClass userClassNode, ScriptScope scriptScope) {
                } else if (shiftType == long.class) {
            );
                )
            }
                            )
                        new IllegalArgumentException(
     * Decorates a user expression node with a PainlessCast.
            typeParameters = new ArrayList<>(instanceBinding.typeParameters);
            throw userCompNode.createError(
            }
        if (semanticScope.hasDecoration(userPrefixNode, PartialCanonicalTypeName.class)) {
                                0
                            }
        if (staticType != null) {
            checkedVisit(userArgumentNode, semanticScope);
                    scriptScope.getPainlessLookup(),
        }
    }
     */
                throw userNumericNode.createError(new IllegalArgumentException("Invalid float constant [" + numeric + "]."));
     * Checks: type validation
    @Override
        String index = userDotNode.getIndex();
                        )
 * The OpenSearch Contributors require contributions made to
        if (semanticScope.getCondition(userConditionalNode, Read.class) == false) {
        }
                new IllegalArgumentException("invalid assignment: cannot assign a value to decimal constant [" + decimal + "]")
                constant = Long.parseLong(numeric.substring(0, numeric.length() - 1), radix);
                    // will likely involve adding a class instance binding where any instance can have a class binding
                method = semanticScope.getScriptScope()
                } else {
            valueType = String.class;
     * constructor function references, and local function references.
        }
                        + "]"
                            + leftValueType
        semanticScope.putDecoration(userLambdaNode, new ReturnType(returnType));
                }
     * Visits an instanceof expression which handles both primitive and non-primitive types.
            throw userBraceNode.createError(new IllegalArgumentException("not a statement: result of brace operator not used"));
        for (SDeclaration userDeclarationNode : userDeclBlockNode.getDeclarationNodes()) {
        semanticScope.replicateCondition(userIfElseNode, userIfBlockNode, LastLoop.class);
                    location,
                                        "field [" + prefixValueType.getValueCanonicalTypeName() + ", " + index + "] not found"
        boolean write = semanticScope.getCondition(userSymbolNode, Write.class);
                    new ClassCastException(
            anyBreak |= semanticScope.getCondition(userCatchNode, AnyBreak.class);
                    throw userForNode.createError(new IllegalArgumentException("no paths escape from for loop"));
            } else if (operation == Operation.BWOR) {
    }
     * Checks: type validation
                isShift = true;
 * this work for additional information regarding copyright
        }
    @Override
                new IllegalArgumentException("not a statement: result not used from conditional operation [?:]")
            );
 *     http://www.apache.org/licenses/LICENSE-2.0
                                prefixType,
                        + "expected ["
        AExpression userLeftNode = userCompNode.getLeftNode();
     */
                        );
        if (semanticScope.getCondition(userExplicitNode, Read.class) == false) {
                && setter != null
            valueType = Object.class;
        if (userCatchNode.getBaseException().isAssignableFrom(type) == false) {
    @Override
                            + "] to the types "
        }
        SBlock userBlockNode = userWhileNode.getBlockNode();
    }
                                        "field [" + prefixStaticType.getStaticCanonicalTypeName() + ", " + index + "] not found"
                        throw userLambdaNode.createError(new IllegalArgumentException("cannot resolve type [" + paramType + "]"));
 * valid field resolution, and other specialized validation.
     * Visits a map init expression which is a shortcut for initializing a map with pre-defined keys and values.
            throw userBlockNode.createError(new IllegalArgumentException("invalid block: found no statements"));
        if (userCallNode.isNullSafe() && valueType.isPrimitive()) {
            semanticScope.putDecoration(userValueNode, new TargetType(def.class));
        semanticScope.putDecoration(userBooleanConstantNode, new StandardConstant(bool));
        }
                    semanticScope.setCondition(userStatementNode, LastSource.class);
     * Checks: type validation
            binaryType = boolean.class;
import org.opensearch.painless.node.EListInit;
        }
                                    );
        Class<?> valueType;
                compoundType = AnalyzerCaster.promoteNumeric(leftValueType, false);
                            + "] to "
            } else if (operation == Operation.SUB) {
import org.opensearch.painless.node.ECallLocal;
        checkedVisit(userLeftNode, semanticScope);
                        + prefixValueType.getValueCanonicalTypeName()
    /**
            } catch (NumberFormatException exception) {
import java.util.Map;
                        + "] "
            } else {
                variable.getType(),
    }
        }
            valueType = instanceBinding.returnType;
                    TargetType targetType = userDotNode.isNullSafe() ? null : semanticScope.getDecoration(userDotNode, TargetType.class);
import org.opensearch.painless.node.SFor;
            semanticScope.setCondition(userValueNode, Internal.class);
        semanticScope.setCondition(userPrefixNode, Read.class);
 * Semantically validates a user tree visiting all user tree nodes to check for
            semanticScope.setCondition(userTryNode, AllEscape.class);
     */
        if (userBlockNode == null) {
    }
                );
                        + PainlessLookupUtility.typeToCanonicalTypeName(type)
            }
        semanticScope.putDecoration(userLambdaNode, new CapturesDecoration(capturedVariables));
                            new IllegalArgumentException(
                    "not a statement: result not used from instanceof with target type [" + canonicalTypeName + "]"
    }
    }
            semanticScope.setCondition(userIfElseNode, AllEscape.class);
                }
                            + PainlessLookupUtility.typeToCanonicalTypeName(rightValueType)
                );
            valueType = classBinding.returnType;
                                        new IllegalArgumentException("Illegal map shortcut for type [" + prefixCanonicalTypeName + "].")
                classBinding = scriptScope.getPainlessLookup().lookupPainlessClassBinding(methodName, userArgumentsSize);
                constant = Float.parseFloat(numeric.substring(0, numeric.length() - 1));
     */
        semanticScope.putDecoration(userDecimalNode, new StandardConstant(constant));
                if (method == null) {
        } else if (importedMethod != null) {
     * additional checks include looking for an escaped partial canonical type, an unexpected static type, and an
            }
            semanticScope.putDecoration(userSymbolNode, new StaticType(staticType));
                .lookupPainlessMethod(prefixValueType, false, "set", 2);
            } catch (NumberFormatException exception) {
import org.opensearch.painless.node.SCatch;
                semanticScope.setCondition(userDoNode, AllEscape.class);
            if (prefixValueType != null) {
    /**
        boolean rtn = lastSource && isVoid == false && expressionValueType != void.class;
                        throw userDotNode.createError(
 * compatible open source license.
                    );
                                + methodName
                checkedVisit(userArgumentNode, semanticScope);
            semanticScope.setCondition(userValueNode, Internal.class);
                new IllegalArgumentException("invalid declaration: type [" + symbol + "] cannot be a name")
 * Modifications Copyright OpenSearch Contributors. See
                        methodName,
                new ClassCastException(
                        + "] and "
                                + " operator "
            }
        }
        semanticScope.putDecoration(userBooleanConstantNode, new ValueType(boolean.class));
        }
                    throw userUnaryNode.createError(
     * Visits an explicit expression which handles an explicit cast.
            AExpression userValueNode = userValueNodes.get(i);
                || targetType.getTargetType() == ZonedDateTime.class
                binaryType = AnalyzerCaster.promoteNumeric(leftValueType, rightValueType, true);
    public void visitIf(SIf userIfNode, SemanticScope semanticScope) {
                semanticScope.putDecoration(userArgumentNode, new TargetType(method.typeParameters.get(argument)));
                                if (getter != null
                )
                throw userUnaryNode.createError(new IllegalStateException("unexpected unary operation [" + operation.name + "]"));
            );
    /**
                    symbol,
     * Visits a new array function ref expression which covers only a new array function reference
        TargetType targetType = semanticScope.getDecoration(userNewArrayFunctionRefNode, TargetType.class);
        semanticScope.replicateCondition(userIfElseNode, userElseBlockNode, InLoop.class);
                true,
                                );
            }
            semanticScope.setCondition(userStatementNode, Internal.class);
            semanticScope.setCondition(userConditionNode, Read.class);
     */
    }
            if (radix != 10) {
            typeParameters = new ArrayList<>(localFunction.getTypeParameters());
            }
        }
            );
            throw userMapInitNode.createError(
    /**
            checkedVisit(userRightNode, semanticScope);
        PainlessConstructor constructor = scriptScope.getPainlessLookup().lookupPainlessConstructor(valueType, userArgumentsSize);
                    semanticScope.setCondition(userRightNode, Explicit.class);
                        + "] parameters"
 * specific language governing permissions and limitations
                                }
            semanticScope.putDecoration(userTrueNode, new TargetType(promote));
     * Checks: type validation
import org.opensearch.painless.symbol.Decorations.InLoop;
    @Override
    @Override
            }
    public void visitComp(EComp userCompNode, SemanticScope semanticScope) {
                    "not a statement: result not used from " + operation.name + " operation " + "[" + operation.symbol + "]"
        }
        String name = scriptScope.getNextSyntheticName("lambda");
import org.opensearch.painless.node.EInstanceof;
                new IllegalArgumentException("invalid declaration: cannot resolve type [" + canonicalTypeName + "]")
                }
                                if (setter != null) {
        if (allEscape) {
        if (localFunction != null && localFunction.isInternal()) {
                );
                new ClassCastException(
                            + "["
            checkedVisit(userRightNode, semanticScope);
    }
                semanticScope.putDecoration(userRightNode, new TargetType(compoundType));
        } else {
                    }
     */
        }
        }
        boolean read = semanticScope.getCondition(userBraceNode, Read.class);
            } else {
                    "cannot resolve symbol "
                }
import org.opensearch.painless.node.SIfElse;
        checkedVisit(userRightNode, semanticScope);
            if ((read == false || getter != null) && (write == false || setter != null)) {
                            if (prefixValueType != null) {
        }
        if (decimal.endsWith("f") || decimal.endsWith("F")) {
            );
            semanticScope.setCondition(userValueNode, Read.class);
     * Visits a new obj expression which creates a new object and calls its constructor.
    @Override
            throw userDoNode.createError(new IllegalArgumentException("extraneous do-while loop"));
        if (semanticScope.getCondition(userNewArrayFunctionRefNode, Write.class)) {
                        + "recursion and long loops."
            Class<?> staticType = null;
        if (type == null) {
                                }
            } else {
        semanticScope.putDecoration(userCallNode, new ValueType(valueType));
                            if (Map.class.isAssignableFrom(prefixValueType.getValueType())) {
                    throw new IllegalArgumentException("invalid regular expression: unknown flag [" + flag + "]");
    public void visitNewArray(ENewArray userNewArrayNode, SemanticScope semanticScope) {
        if (semanticScope.getCondition(userElvisNode, Write.class)) {
                valueType = long.class;
    public void visitNull(ENull userNullNode, SemanticScope semanticScope) {
            if (userInitializerNode instanceof SDeclBlock) {
                    // This extra check looks for a possible match where the class binding requires an implicit this
        }
                if (getter != null) {
                                + "not found"
                                        || !getter.returnType.equals(setter.typeParameters.get(1)))) {
        Class<?> valueType = semanticScope.getScriptScope().getPainlessLookup().canonicalTypeNameToType(canonicalTypeName);
        }
        if (constructor.typeParameters.size() != userArgumentsSize) {
import org.opensearch.painless.symbol.ScriptScope;
            valueType = targetType.getTargetType();
        } else {
            userNode.visit(this, semanticScope);
                new IllegalArgumentException(
        }
     */
                    PainlessField field = semanticScope.getScriptScope()
            }
    }
        String canonicalTypeName = userExplicitNode.getCanonicalTypeName();
                    )
                new IllegalArgumentException(
        constructor.typeParameters.toArray(types);
        boolean continuous = false;
     * Checks: type validation
            throw userListInitNode.createError(new IllegalArgumentException("not a statement: result not used from list initializer"));
            } else if (operation == Operation.SUB) {
        Class<?> leftValueType = semanticScope.getDecoration(userLeftNode, ValueType.class).getValueType();
     * Checks: control flow
            checkedVisit(userAfterthoughtNode, semanticScope);
                    new IllegalArgumentException(
                throw userNumericNode.createError(new IllegalStateException("Illegal tree structure."));
     * Checks: control flow
        Class<?> rtnType = semanticScope.getReturnType();
     * Visits a declaration block which contains one-to-many declarations.
    }
        semanticScope.setCondition(userPrefixNode, Read.class);
            semanticScope.putDecoration(userCallLocalNode, new StandardPainlessClassBinding(classBinding));
                    // TODO: remove ZonedDateTime exception when JodaCompatibleDateTime is removed
        }
            throw userNewObjNode.createError(
                && semanticScope.getCondition(userBlockNode, AnyContinue.class) == false) {
                }
     */
        }
        String string = userStringNode.getString();
        if (targetType == null) {
     */
            semanticScope.putDecoration(userBinaryNode, new ShiftType(shiftType));
            );
    /**
        }
     * Checks: type validation
                    constant |= Pattern.DOTALL;
                    || getter.returnType.equals(setter.typeParameters.get(1)) == false)) {
        LambdaScope lambdaScope = semanticScope.newLambdaScope(returnType);
        }
            throw userNewArrayFunctionRefNode.createError(
        if (semanticScope.getCondition(userBooleanConstantNode, Read.class) == false) {
        semanticScope.setCondition(userConditionNode, Read.class);
        } else {
    @Override
                        + "] "
        } else if (numeric.endsWith("l") || numeric.endsWith("L")) {
        checkedVisit(userExpressionNode, semanticScope);
                );
        }
                                throw userDotNode.createError(
                                    "Unknown call [" + methodName + "] with [" + userArgumentNodes + "] arguments."
    }
        checkedVisit(userChildNode, semanticScope);
                        + "cannot iterate over type ["
                FunctionRef ref = FunctionRef.create(
                        "invalid assignment: "
     * Visits a for statement with error checking for an extraneous loop.
                semanticScope.setCondition(userArgumentNode, Read.class);
                                    && (getter.returnType == void.class
            if (radix != 10) {
        if ((operation == Operation.EQ || operation == Operation.EQR || operation == Operation.NE || operation == Operation.NER)
                            "invalid foreach loop: " + "method [" + typeToCanonicalTypeName(iterableValueType) + ", iterator/0] not found"
     * Checks: type validation
        if (userConditionNode instanceof EBooleanConstant) {
import java.util.List;
import org.opensearch.painless.node.ELambda;
            throw userListInitNode.createError(
        semanticScope.replicateCondition(userConditionalNode, userTrueNode, Explicit.class);
                    if (classBinding != null) {
        decorateWithCast(userTrueNode, semanticScope);
                            + "["
            throw new IllegalStateException("Illegal tree structure.");
import org.opensearch.painless.node.EUnary;
        if (semanticScope.getCondition(userCallNode, Write.class)) {
                    Class<?> typeParameter = scriptScope.getPainlessLookup().canonicalTypeNameToType(type);
                semanticScope.setCondition(userWhileNode, ContinuousLoop.class);
                }
                    constant |= Pattern.CANON_EQ;
        }
            }
        } else {
import org.opensearch.painless.node.SFunction;
     */
     * Checks: control flow, type validation
        AExpression userConditionNode = userConditionalNode.getConditionNode();
            throw userNullNode.createError(new IllegalArgumentException("invalid assignment: cannot assign a value to null constant"));
        decorateWithCast(userConditionNode, semanticScope);
        boolean anyBreak = false;
            semanticScope.putDecoration(userKeyNode, new TargetType(def.class));
        Class<?> valueType;
                Class<?> argumentValueType = semanticScope.getDecoration(userArgumentNode, ValueType.class).getValueType();
            }
                        "value required: instead found unexpected type " + "[" + prefixValueType.getValueCanonicalTypeName() + "]"
            throw userDeclarationNode.createError(
        if (userConditionNode instanceof EBooleanConstant) {
                    new ClassCastException(
    }
                                            "Illegal list get shortcut for type [" + prefixCanonicalTypeName + "]."
                )
        SBlock userBlockNode = userDoNode.getBlockNode();
                    defReferenceEncoding = "D" + symbol + "." + methodName + ",1";
        boolean continuous;
                semanticScope.replicateCondition(userStatementNode, userBlockNode, MethodEscape.class);
                                if (getter != null) {
            semanticScope.putDecoration(userAssignmentNode, new CompoundType(compoundType));
        }
            } catch (NumberFormatException exception) {
                throw userBinaryNode.createError(
                new IllegalArgumentException(
            semanticScope.setCondition(userIndexNode, Read.class);
                    )
                    Class<?> prefixType;
/*
            );
        }
        semanticScope.setCondition(userLeftNode, Write.class);
            for (AExpression userArgumentNode : userArgumentNodes) {
                    new IllegalArgumentException(
            valueType = targetType.getTargetType();
                decorateWithCast(userChildNode, semanticScope);
            throw userContinueNode.createError(new IllegalArgumentException("extraneous continue statement"));
            if (userBlockNode == null) {
            || semanticScope.getCondition(userElseBlockNode, AnyContinue.class)) {
     * Visits a elvis expression which is a shortcut for a null check on a conditional expression.
        semanticScope.copyDecoration(userElvisNode, userLeftNode, TargetType.class);
        checkedVisit(userLeftNode, semanticScope);
                        + PainlessLookupUtility.typeToCanonicalTypeName(valueType)
            }
    public void visitDeclBlock(SDeclBlock userDeclBlockNode, SemanticScope semanticScope) {
        for (int argument = 0; argument < userArgumentsSize; ++argument) {
                            if (setter != null && (setter.returnType != void.class || setter.typeParameters.size() != 1)) {
        Location location = userEachNode.getLocation();
        semanticScope.setCondition(userBlockNode, LastSource.class);
        semanticScope.setCondition(userRightNode, Read.class);
                )
            );
                        "value required: instead found unexpected type "
                compoundType = AnalyzerCaster.promoteXor(leftValueType, rightValueType);
            semanticScope.setCondition(userKeyNode, Internal.class);
            valueType = semanticScope.getDecoration(userChildNode, ValueType.class).getValueType();
            throw new IllegalArgumentException("Result of null safe operator must be nullable");
        semanticScope.copyDecoration(userConditionalNode, userFalseNode, TargetType.class);
                        location,
                        + userArgumentsSize
            visit(userBlockNode, semanticScope);
        }
     * Visits a declaration and defines a variable with a type and optionally a value.
                    } else {
        semanticScope.setCondition(userConditionNode, Read.class);
        if (semanticScope.getCondition(userExplicitNode, Write.class)) {
                                + prefixStaticType.getStaticCanonicalTypeName()
            );
                0,
        Class<?> valueType;
            if (continuous == false) {
        AExpression userRightNode = userElvisNode.getRightNode();
import org.opensearch.painless.node.SIf;
                    "invalid regular expression: " + "could not compile regex constant [" + pattern + "] with flags [" + flags + "]",
                new IllegalArgumentException(
    public void visitFunctionRef(EFunctionRef userFunctionRefNode, SemanticScope semanticScope) {
        }
            semanticScope.putDecoration(userStatementNode, new TargetType(rtnType));
                            + PainlessLookupUtility.typeToCanonicalTypeName(leftValueType)
        semanticScope.putDecoration(userChildNode, new TargetType(valueType));
                            "Invalid int constant [" + numeric + "]. If you want a long constant then change it to [" + numeric + "L]."
            semanticScope.replicateCondition(userBlockNode, userCatchNode, LoopEscape.class);
                new IllegalArgumentException(
    /**
        }
import org.opensearch.painless.node.EAssignment;
        decorateWithCast(userRightNode, semanticScope);
        semanticScope.putDecoration(userRightNode, new TargetType(boolean.class));
            semanticScope.setCondition(userIndexNode, Read.class);
            continuous = ((EBooleanConstant) userConditionNode).getBool();
        }
        } else if (semanticScope.isVariableDefined(symbol)) {
                        + prefixStaticType.getStaticCanonicalTypeName()
            promotedType = AnalyzerCaster.promoteNumeric(leftValueType, rightValueType, true);
                throw userExpressionNode.createError(
            semanticScope.putDecoration(userLeftNode, new TargetType(promote));
     */
                    "invalid assignment: cannot assign a value to an explicit cast with target type [" + canonicalTypeName + "]"
        semanticScope.putDecoration(userMapInitNode, new StandardPainlessConstructor(constructor));
            visit(userBlockNode, semanticScope);
        semanticScope.setCondition(userBreakNode, AnyBreak.class);
                    }
                checkedVisit(userIndexNode, semanticScope);
                            "cannot apply the "
                        .lookupPainlessField(prefixType, isStatic, index);
                scriptScope.getCompilerSettings().asMap()
                                    0
        }
                                    throw userDotNode.createError(
                    semanticScope.putDecoration(userBraceNode, new GetterPainlessMethod(getter));
            throw userExplicitNode.createError(
        semanticScope.setCondition(userBlockNode, InLoop.class);
            throw userCompNode.createError(new IllegalArgumentException("extraneous comparison of [null] constants"));
                                setter = scriptScope.getPainlessLookup().lookupPainlessMethod(prefixType, false, "set", 2);
        if (valueType == null) {
import org.opensearch.painless.symbol.SemanticScope.LambdaScope;
        ValueType prefixValueType = semanticScope.getDecoration(userPrefixNode, ValueType.class);
                )
                )
        }
        String methodName = userFunctionRefNode.getMethodName();
                        "cannot apply the "
            }
            } else if (operation == Operation.XOR) {
            throw userRegexNode.createError(
                        targetType.getTargetType(),
            }
                    new IllegalArgumentException(
                            );
    @Override
    }
    }
        semanticScope.setCondition(userChildNode, Read.class);
                            classBinding = null;
        ScriptScope scriptScope = semanticScope.getScriptScope();
            } else {
            localFunction = null;
                    methodName,
                            + rightValueType
    /**
/**
                                + userArgumentsSize
            semanticScope.setCondition(userBlockNode, BeginLoop.class);
            String canonicalClassName = PainlessLookupUtility.typeToCanonicalTypeName(prefixValueType);
     * and generates an internal method to define the new array.
