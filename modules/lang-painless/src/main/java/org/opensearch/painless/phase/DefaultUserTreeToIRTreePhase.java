        // add a cast node if necessary for the value node for the assignment
            irFunctionNode.setMaxLoopCounter(0);
        scriptScope.putDecoration(userFunctionRefNode, new IRNodeDecoration(irReferenceNode));
    }
        irFieldNode.setFieldType(FunctionTable.class);
     * @param accessDepth The number of arguments to dup for an additional read.
                binaryImplNode.setLeftNode(irPrefixNode);
                    LoadListShortcutNode irLoadListShortcutNode = new LoadListShortcutNode(location);
                    irDupNode.setDepth(accessDepth);
                    irStoreListShortcutNode.setSetter(
            irConditionNode = irForEachSubArrayNode;
        );
                callLocalNode,
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;
                irStoreNode.setChildNode(irCompoundNode);
            Class<?> staticType = scriptScope.getDecoration(userSymbolNode, StaticType.class).getStaticType();
        irFieldNode.setModifiers(modifiers);
        if (targetType == null) {
            // this load/store is a dot or brace load/store
        irFieldNode.setName("$DEFINITION");
import org.opensearch.painless.symbol.Decorations.CapturesDecoration;
        }
    }
                iterableValueType == def.class
/*
        if (irPrefixNode != null) {
    /**
                irCastNode.setCast(downcast);
        irForEachLoopNode.setConditionNode(irConditionNode);
                StoreVariableNode irStoreVariableNode = new StoreVariableNode(location);
    protected void injectBootstrapMethod(ScriptScope scriptScope) {
                )
    }
        irFunctionNode.getParameterNames().addAll(scriptScope.getDecoration(userLambdaNode, ParameterNames.class).getParameterNames());
            irExpressionNode = buildLoadStore(
import org.opensearch.painless.symbol.Decorations.StandardPainlessClassBinding;
        irElvisNode.setLeftNode(injectCast(userElvisNode.getLeftNode(), scriptScope));
        irBooleanNode.setExpressionType(scriptScope.getDecoration(userBooleanCompNode, ValueType.class).getValueType());
        irIfElseNode.setElseBlockNode((BlockNode) visit(userIfElseNode.getElseBlockNode(), scriptScope));
        irDoWhileLoopNode.setBlockNode((BlockNode) visit(userDoNode.getBlockNode(), scriptScope));
    public void visitBooleanConstant(EBooleanConstant userBooleanConstantNode, ScriptScope scriptScope) {
        scriptScope.putDecoration(userBreakNode, new IRNodeDecoration(irBreakNode));
                throw userFunctionNode.createError(new IllegalStateException("illegal tree structure"));
                        "bootstrap",
            );
                (int) scriptScope.getDecoration(callLocalNode, StandardConstant.class).getStandardConstant()
import org.opensearch.painless.lookup.PainlessLookupUtility;
import org.opensearch.painless.symbol.ScriptScope;
import org.opensearch.painless.symbol.Decorations.ComparisonType;
            ? scriptScope.getDecoration(userAssignmentNode, CompoundType.class).getCompoundType()
                PainlessField painlessField = scriptScope.getDecoration(userDotNode, StandardPainlessField.class)
            boolean read = scriptScope.getCondition(userSymbolNode, Read.class);
                irStoreBraceNode.setStoreType(valueType);
import org.opensearch.painless.ir.TryNode;
            ConstantNode irConstantNode = new ConstantNode(userRegexNode.getLocation());
                irCompoundNode.setExpressionType(irStoreNode.getStoreType());
        irElvisNode.setRightNode(injectCast(userElvisNode.getRightNode(), scriptScope));
    public void visitElvis(EElvis userElvisNode, ScriptScope scriptScope) {
                    binaryImplNode.setRightNode(irIndexNode);
                    null,
import org.opensearch.painless.ir.StoreFieldMemberNode;
        scriptScope.putDecoration(userRegexNode, new IRNodeDecoration(irLoadFieldMemberNode));
        irWhileLoopNode.setBlockNode((BlockNode) visit(userWhileNode.getBlockNode(), scriptScope));
        irFunctionNode.setSynthetic(userFunctionNode.isSynthetic());
        LoadVariableNode irLoadVariableNode = new LoadVariableNode(userNewArrayFunctionRefNode.getLocation());
        if (capturesDecoration != null) {
            for (int i = 0; i < injections.length; i++) {
                    irStoreMapShortcutNode.setStoreType(valueType);
        } else if (scriptScope.getCondition(userBraceNode, ListShortcut.class)) {
            BinaryImplNode irBinaryImplNode = new BinaryImplNode(internalLocation);
    }
            // no need to downcast so the binary math node is the value for the store node
    @Override
        boolean methodEscape = scriptScope.getCondition(userFunctionNode, MethodEscape.class);
            invokeCallNode.addArgumentNode(irLoadVariableNode);
import org.opensearch.painless.ir.LoadMapShortcutNode;
        } else {
    @Override
            TypedInterfaceReferenceNode typedInterfaceReferenceNode = new TypedInterfaceReferenceNode(userFunctionRefNode.getLocation());
            irFieldNode.setModifiers(Modifier.PUBLIC | Modifier.STATIC);
    }
            blockNode.addStatementNode(irStatementExpressionNode);
                        }
            }
            : null;
            irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
            FlipCollectionIndexNode irFlipCollectionIndexNode = new FlipCollectionIndexNode(userBraceNode.getIndexNode().getLocation());
        Location internalLocation = new Location("$internal$injectStaticFields", 0);
 * under the License.
                    Pattern.class,
        irConstantNode.setConstant(scriptScope.getDecoration(userStringNode, StandardConstant.class).getStandardConstant());
        irIfElseNode.setConditionNode(injectCast(userIfElseNode.getConditionNode(), scriptScope));
                StoreMapShortcutNode irStoreMapShortcutNode = new StoreMapShortcutNode(location);
import org.opensearch.painless.ir.ForEachSubIterableNode;
        scriptScope.putDecoration(userBooleanCompNode, new IRNodeDecoration(irBooleanNode));
                    irLoadDotNode.setField(painlessField);
                    irLoadMapShortcutNode.setExpressionType(valueType);
            }
        } else {
     */
                scriptScope.getDecoration(userFunctionRefNode, EncodingDecoration.class).getEncoding()
                irDupNode.setSize(MethodWriter.getType(irValueNode.getExpressionType()).getSize());
                userNewArrayFunctionRefNode.getLocation()
        irComparisonNode.setOperation(userCompNode.getOperation());
        BooleanNode irBooleanNode = new BooleanNode(userBooleanCompNode.getLocation());
    /**
import org.opensearch.painless.symbol.Decorations.InstanceType;
        irCatchNode.setSymbol(variable.getName());
                        scriptScope.getDecoration(userDotNode, SetterPainlessMethod.class).getSetterPainlessMethod()
                    irLoadNode = irLoadDotNode;
import org.opensearch.painless.node.EBinary;
    public void visitDot(EDot userDotNode, ScriptScope scriptScope) {
                irStoreListShortcutNode.setExpressionType(read ? valueType : void.class);
            invokeCallNode.setExpressionType(Pattern.class);
        irInstanceofNode.setInstanceType(scriptScope.getDecoration(userInstanceofNode, InstanceType.class).getInstanceType());
            );
                BinaryImplNode binaryImplNode = new BinaryImplNode(location);
            }
            irLoadVariableNode.setExpressionType(int.class);
import org.opensearch.painless.node.SExpression;
                irConstantNode.setExpressionType(int.class);
        }
        Class<?> compoundType = scriptScope.hasDecoration(userAssignmentNode, CompoundType.class)
            boolean concatenate = userAssignmentNode.getOperation() == Operation.ADD && compoundType == String.class;
                irCastNode.setChildNode(irCompoundNode);
    public void visitBinary(EBinary userBinaryNode, ScriptScope scriptScope) {
                irLoadNode = irLoadMapShortcutNode;
            }
        for (AExpression userArgumentNode : callLocalNode.getArgumentNodes()) {
            String bindingName = scriptScope.getNextSyntheticName("class_binding");
            throw userSymbolNode.createError(new IllegalStateException("illegal tree structure"));
        } else if (painlessCast.unboxTargetType != null) {
            ExpressionNode irLoadNode = null;
            Class<?> staticType = scriptScope.getDecoration(userDotNode, StaticType.class).getStaticType();
            irBinaryImplNode.setLeftNode(staticNode);
import org.opensearch.painless.ir.ThrowNode;
            irLoadFieldMemberNode.setStatic(true);
        internalLocation = new Location("$internal$injectDefBootstrapMethod", 0);
                    Pattern.class.getMethod("compile", String.class, int.class),
    }
            return null;
    @Override
        InstanceofNode irInstanceofNode = new InstanceofNode(userInstanceofNode.getLocation());
                irLoadNode = irCastNode;
                        PainlessLookup.class,
        ExpressionNode irIndexNode,
    }
            ExpressionNode irExpressionNode;
                LoadDotArrayLengthNode irLoadDotArrayLengthNode = new LoadDotArrayLengthNode(location);
    protected IRNode visit(ANode userNode, ScriptScope scriptScope) {
import org.opensearch.painless.node.ESymbol;
    public void visitWhile(SWhile userWhileNode, ScriptScope scriptScope) {
import org.opensearch.painless.node.EConditional;
        if (scriptScope.hasDecoration(userNewArrayFunctionRefNode, TargetType.class)) {
        irBlockNode.setAllEscape(true);
        irNullNode.setExpressionType(scriptScope.getDecoration(userNullNode, ValueType.class).getValueType());
import org.opensearch.painless.node.SWhile;
            Class<?>[] parameterTypes = method.javaMethod.getParameterTypes();
                    null,
            InvokeCallNode invokeCallNode = new InvokeCallNode(internalLocation);
        irClassNode.addFieldNode(irFieldNode);
        scriptScope.putDecoration(userMapInitNode, new IRNodeDecoration(irMapInitializationNode));
import org.opensearch.painless.symbol.Decorations.DowncastPainlessCast;
        scriptScope.putDecoration(userCatchNode, new IRNodeDecoration(irCatchNode));
import org.opensearch.painless.ir.BinaryImplNode;
                }
    @Override
        WhileLoopNode irWhileLoopNode = new WhileLoopNode(userWhileNode.getLocation());
            irForEachSubIterableNode.setIteratorType(Iterator.class);
        scriptScope.putDecoration(userCallNode, new IRNodeDecoration(irBinaryImplNode));
                binaryImplNode.setRightNode(irExpressionNode);
        }
            BinaryImplNode binaryImplNode = new BinaryImplNode(location);
            irForEachSubArrayNode.setCast(painlessCast);
            typedInterfaceReferenceNode.setReference(
        } catch (Exception exception) {
        scriptScope.putDecoration(userContinueNode, new IRNodeDecoration(irContinueNode));
                // build the structure for a standard load/store
        for (SCatch userCatchNode : userTryNode.getCatchNodes()) {
 * not use this file except in compliance with the License.
import org.opensearch.painless.ir.LoadBraceDefNode;
            irUnaryMathNode.setChildNode(injectCast(userUnaryNode.getChildNode(), scriptScope));
import org.opensearch.painless.node.ERegex;
import org.opensearch.painless.ir.DupNode;
                DupNode dupNode = new DupNode(location);
    @Override
            irListInitializationNode.addArgumentNode(injectCast(userValueNode, scriptScope));
import org.opensearch.painless.node.SContinue;
            invokeCallNode.addArgumentNode(irLoadFieldMemberNode);
            if (returnType == void.class) {
        }
        irComparisonNode.setExpressionType(scriptScope.getDecoration(userCompNode, ValueType.class).getValueType());
            ExpressionNode irPrefixNode = (ExpressionNode) visit(userDotNode.getPrefixNode(), scriptScope);
                    irLoadDotDefNode.setExpressionType(valueType);
                : null;
                irNullSafeSubNode.setExpressionType(irExpressionNode.getExpressionType());
                CastNode irCastNode = new CastNode(irLoadNode.getLocation());
                irLoadBraceDefNode.setIndexType(indexType);
                    binaryImplNode.setExpressionType(void.class);
                irConstantNode.setConstant(scriptScope.getDecoration(userDotNode, StandardConstant.class).getStandardConstant());
    }
    public void visitSymbol(ESymbol userSymbolNode, ScriptScope scriptScope) {
            BinaryImplNode irBinaryImplNode = new BinaryImplNode(userRegexNode.getLocation());
     * This helper generates a set of ir nodes that are required for an assignment
    }
            // handles a standard assignment
            blockNode.addStatementNode(returnNode);
                }
        irFunctionNode.addParameterName("size");
                accessDepth = 2;
                accessDepth,
                    scriptScope.getDecoration(userBraceNode, GetterPainlessMethod.class).getGetterPainlessMethod()
        return irExpressionNode;
        TryNode irTryNode = new TryNode(userTryNode.getLocation());
import org.opensearch.painless.ir.StoreVariableNode;
import org.opensearch.painless.symbol.Decorations.AllEscape;
import org.opensearch.painless.ir.StoreDotDefNode;
            irNullSafeSubNode.setExpressionType(irExpressionNode.getExpressionType());
            // the value is also read from this assignment
                        Map.class,
            irTryNode.addCatchNode((CatchNode) visit(userCatchNode, scriptScope));
            if (write == false || compound) {
            irBinaryMathNode.setLeftNode(injectCast(userBinaryNode.getLeftNode(), scriptScope));
            }
import org.opensearch.painless.node.SIf;
            irLoadVariableNode = new LoadVariableNode(internalLocation);
            );
            DefInterfaceReferenceNode defInterfaceReferenceNode = new DefInterfaceReferenceNode(userFunctionRefNode.getLocation());
            if (read) {
            // build the structure to combine the prefix and the load/store
import org.opensearch.painless.node.SCatch;
        if (scriptScope.hasDecoration(userSymbolNode, StaticType.class)) {
                irIndexNode,
 *
        irConstantNode.setConstant(scriptScope.getDecoration(userNumericNode, StandardConstant.class).getStandardConstant());
        irReturnNode.setExpressionNode(irNewArrayNode);
        scriptScope.putDecoration(userBinaryNode, new IRNodeDecoration(irExpressionNode));
            if (irAssignmentNode instanceof BinaryImplNode) {
                    StoreMapShortcutNode irStoreMapShortcutNode = new StoreMapShortcutNode(location);
        irFunctionNode.setBlockNode(irBlockNode);
            irConstantNode.setConstant(userRegexNode.getPattern());
        PainlessCast painlessCast = expressionPainlessCast.getExpressionPainlessCast();
                int accessDepth = scriptScope.getDecoration(userAssignmentNode.getLeftNode(), AccessDepth.class).getAccessDepth();
    protected ExpressionNode injectCast(AExpression userExpressionNode, ScriptScope scriptScope) {
            irExpressionNode = irCallSubDefNode;
                    irDupNode.setExpressionType(irStoreNode.getStoreType());
                    if (returnType == boolean.class) {
            boolean read = scriptScope.getCondition(userDotNode, Read.class);
                    );
                accessDepth = 1;
                    ConstantNode irConstantNode = new ConstantNode(userFunctionNode.getLocation());
    @Override
        irFunctionNode.setBlockNode(irBlockNode);
            irFlipCollectionIndexNode.setChildNode(irIndexNode);
                        int.class,
            invokeCallNode.addArgumentNode(irLoadVariableNode);
    public void visitNull(ENull userNullNode, ScriptScope scriptScope) {
            }
    public void visitTry(STry userTryNode, ScriptScope scriptScope) {
            invokeCallNode.addArgumentNode(irLoadVariableNode);
            scriptScope.getDecoration(userListInitNode, StandardPainlessConstructor.class).getStandardPainlessConstructor()
        ReturnNode irReturnNode = new ReturnNode(userNewArrayFunctionRefNode.getLocation());
        irForLoopNode.setAfterthoughtNode((ExpressionNode) visit(userForNode.getAfterthoughtNode(), scriptScope));
                    ((DupNode) ((BinaryImplNode) irLoadNode).getLeftNode()).setDepth(1);
import org.opensearch.painless.ir.LoadDotArrayLengthNode;
import org.opensearch.painless.symbol.Decorations.SemanticVariable;
        irForLoopNode.setInitialzerNode(visit(userForNode.getInitializerNode(), scriptScope));
import org.opensearch.painless.ir.StringConcatenationNode;
            StoreNode irStoreNode = null;
package org.opensearch.painless.phase;
            InvokeCallDefNode irCallSubDefNode = new InvokeCallDefNode(userCallNode.getLocation());
import org.opensearch.painless.lookup.PainlessMethod;
        }
            StoreNode irStoreNode = null;
                irStoreNode = irStoreBraceNode;
            // this is a compound assignment and the store is the root
            scriptScope.putDecoration(userDotNode, new AccessDepth(accessDepth));
            irForEachSubIterableNode.setContinuous(false);
                            throw userFunctionNode.createError(new IllegalStateException("illegal tree structure"));
        BlockNode irBlockNode = new BlockNode(userBlockNode.getLocation());
        // adds static fields required for def bootstrapping
        if (prefixValueType.isArray()) {
        irNewArrayNode.setInitialize(false);
        }
import org.opensearch.painless.symbol.Decorations.GetterPainlessMethod;
        scriptScope.putDecoration(userBooleanConstantNode, new IRNodeDecoration(irConstantNode));
        irNewObjectNode.setConstructor(
import org.opensearch.painless.Operation;
            irStatementNode = irStatementExpressionNode;
            irUnaryMathNode.setUnaryType(unaryType);
        irClassNode.addFunctionNode(irFunctionNode);
        irIfNode.setBlockNode((BlockNode) visit(userIfNode.getIfBlockNode(), scriptScope));
            } else {
    @Override
                irCallSubDefNode.addArgumentNode((ExpressionNode) visit(userArgumentNode, scriptScope));
        try {
import org.opensearch.painless.ir.TypedCaptureReferenceNode;
import org.opensearch.painless.ir.InvokeCallNode;
            irIndexNode = irFlipDefIndexNode;
                        scriptScope.getDecoration(userDotNode, GetterPainlessMethod.class).getGetterPainlessMethod()
                    } else if (returnType == byte.class
import org.opensearch.painless.lookup.PainlessInstanceBinding;
                            irConstantNode.setConstant(0d);
        }
        scriptScope.putDecoration(userForNode, new IRNodeDecoration(irForLoopNode));
            }
                    irDupNode.setDepth(accessDepth);
                dupNode.setSize(accessDepth);
        if (expressionPainlessCast == null) {
        } else {
            );
                irStoreListShortcutNode.setStoreType(valueType);
                        scriptScope.getDecoration(userDotNode, SetterPainlessMethod.class).getSetterPainlessMethod()
                    irStoreListShortcutNode.setStoreType(valueType);
                        int.class,
        int accessDepth,
                    irDupNode.setSize(MethodWriter.getType(irLoadNode.getExpressionType()).getSize());
            if (write || compound) {
        }
            irNewArrayNode.addArgumentNode(injectCast(userArgumentNode, scriptScope));
 */
import org.opensearch.painless.ir.NewArrayNode;
            irLoadVariableNode = new LoadVariableNode(internalLocation);
        ExpressionNode irExpressionNode = (ExpressionNode) visit(userExpressionNode, scriptScope);
            irConstantNode.setConstant(scriptScope.getDecoration(userRegexNode, StandardConstant.class).getStandardConstant());
                    LoadDotDefNode irLoadDotDefNode = new LoadDotDefNode(location);
        Class<?> prefixValueType = scriptScope.getDecoration(userBraceNode.getPrefixNode(), ValueType.class).getValueType();
                }
            new IRNodeDecoration(buildLoadStore(2, location, false, irPrefixNode, irIndexNode, irLoadNode, irStoreNode))
        if (scriptScope.getCondition(userUnaryNode.getChildNode(), Negate.class)) {
            ReturnNode irReturnNode = new ReturnNode(userFunctionNode.getLocation());
                }
import org.opensearch.painless.symbol.Decorations.Shortcut;
        ForLoopNode irForLoopNode = new ForLoopNode(userForNode.getLocation());
    }
                // this load/store requires an index
import org.opensearch.painless.node.SThrow;
            );
                irStoreNode = irStoreMapShortcutNode;
                irLoadNode = irLoadBraceNode;
        ExpressionNode irPrefixNode = (ExpressionNode) visit(userBraceNode.getPrefixNode(), scriptScope);
                irStoreVariableNode.setStoreType(valueType);
                    ? null
import org.opensearch.painless.node.ENewObj;
                DupNode irDupNode = new DupNode(irValueNode.getLocation());
        // adds the bootstrap method required for dynamic binding for def type resolution
                irBinaryMathNode.setLeftNode(irLoadNode);
        irComparisonNode.setRightNode(injectCast(userCompNode.getRightNode(), scriptScope));
            } else if (userFunctionNode.isAutoReturnEnabled()) {
                scriptScope.getDecoration(callLocalNode, StandardLocalFunction.class).getLocalFunction()
                irIndexNode = irConstantNode;
import org.opensearch.painless.symbol.Decorations.Write;
            irLoadVariableNode = new LoadVariableNode(internalLocation);
import org.opensearch.painless.ir.TypedInterfaceReferenceNode;
            irForEachSubArrayNode.setIndexName("#index" + userEachNode.getLocation().getOffset());
                injectCast(userMapInitNode.getValueNodes().get(i), scriptScope)
                    irStoreNode = irStoreDotShortcutNode;
                DupNode irDupNode;
            if (prefixValueType != null && prefixValueType.getValueType().isArray()) {
        irFieldNode.setFieldType(PainlessLookup.class);
        Class<?> returnType = localFunction.getReturnType();
    public void visitCatch(SCatch userCatchNode, ScriptScope scriptScope) {
                if (write == false || compound) {
        irNewArrayNode.setExpressionType(returnType);
            binaryImplNode.setExpressionType(irExpressionNode.getExpressionType());
            );
                // this is a compound assignment and requires and additional dup to re-access the prefix
        }
                    LoadMapShortcutNode irLoadMapShortcutNode = new LoadMapShortcutNode(location);
     * the compound assignment.
            irFieldNode.setModifiers(Modifier.PRIVATE);
            targetType = PainlessLookupUtility.typeToBoxedType(painlessCast.boxTargetType);
        scriptScope.putDecoration(userElvisNode, new IRNodeDecoration(irElvisNode));
            }
                irLoadNode = irLoadBraceDefNode;
        irCatchNode.setExceptionType(variable.getType());
            StringConcatenationNode stringConcatenationNode = new StringConcatenationNode(userBinaryNode.getLocation());
        irFunctionNode.setStatic(true);
        irFieldNode.setModifiers(modifiers);
        }
     * This handles both load and store for dot accesses as necessary. This uses buildLoadStore to
            DefInterfaceReferenceNode defInterfaceReferenceNode = new DefInterfaceReferenceNode(userLambdaNode.getLocation());
            scriptScope.putDecoration(userSymbolNode, new AccessDepth(0));
import java.lang.reflect.Modifier;
                irValueNode = irDupNode;
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                irBinaryMathNode.setExpressionType(compoundType);
            irForEachSubArrayNode.setConditionNode(irIterableNode);
            irExpressionNode = irStoreNode;
                irBinaryMathNode.setRegexLimit(scriptScope.getCompilerSettings().getRegexLimitFactor());
                    irStoreDotShortcutNode.setSetter(
                }
            } else {
                    irExpressionNode = irConstantNode;
            boolean write = scriptScope.getCondition(userDotNode, Write.class);
import org.opensearch.painless.symbol.Decorations.StandardPainlessConstructor;
        scriptScope.putDecoration(userNumericNode, new IRNodeDecoration(irConstantNode));
        if (prefixValueType != null && prefixValueType.getValueType() == def.class) {
    public void visitDo(SDo userDoNode, ScriptScope scriptScope) {
            }
                    irStoreMapShortcutNode.setSetter(
            irFunctionNode.setReturnType(CallSite.class);
                irConstantNode.setConstant(index);
        );
                    // the value is read from after the assignment (pre-increment/compound)
    }
                    CallSite.class,
import org.opensearch.painless.node.EBooleanComp;
                accessDepth = 2;
                ? scriptScope.getDecoration(userAssignmentNode, UpcastPainlessCast.class).getUpcastPainlessCast()
 * The OpenSearch Contributors require contributions made to
 * Unless required by applicable law or agreed to in writing,
    public void visitNewObj(ENewObj userNewObjectNode, ScriptScope scriptScope) {
                    ),
            BlockNode blockNode = irClassNode.getClinitBlockNode();
     */
        irFieldNode.setModifiers(modifiers);
import org.opensearch.painless.lookup.PainlessField;
                    irConstantNode.setExpressionType(returnType);
     * @param irPrefixNode The prefix node for this store/load. The 'a.b' of 'a.b.c', etc.
 * license agreements. See the NOTICE file distributed with
        Location location = userBraceNode.getLocation();
        ExpressionNode irIndexNode = injectCast(userBraceNode.getIndexNode(), scriptScope);
        if (irLoadNode != null && irStoreNode != null) {
                location,
        irBooleanNode.setRightNode(injectCast(userBooleanCompNode.getRightNode(), scriptScope));
/*
import org.opensearch.painless.ir.StatementNode;
            invokeCallNode.addArgumentNode(irLoadVariableNode);
            BinaryMathNode irBinaryMathNode = new BinaryMathNode(userBinaryNode.getLocation());
        irFunctionNode.setVarArgs(false);
    @Override
        if (userCallNode.isNullSafe()) {
                } else {
import org.opensearch.painless.symbol.Decorations.UnaryType;
            PainlessCast upcast = scriptScope.hasDecoration(userAssignmentNode, UpcastPainlessCast.class)
    public void visitInstanceof(EInstanceof userInstanceofNode, ScriptScope scriptScope) {
                    null
import org.opensearch.painless.node.EMapInit;
        irFunctionNode.setReturnType(returnType);
            }
        irDeclarationNode.setExpressionNode(injectCast(userDeclarationNode.getValueNode(), scriptScope));
        irFunctionNode.setName(userFunctionNode.getFunctionName());
            irConstantNode.setExpressionType(int.class);
        }
    @Override
                    irLoadMapShortcutNode.setGetter(
    /**
                BinaryMathNode irBinaryMathNode = (BinaryMathNode) irCompoundNode;
            irBinaryImplNode.setRightNode(invokeCallNode);
        int modifiers = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC;
            irForEachSubIterableNode.setVariableName(variable.getName());
            }
            } else if (scriptScope.getCondition(userDotNode, ListShortcut.class)) {
    }
            FlipArrayIndexNode irFlipArrayIndexNode = new FlipArrayIndexNode(userBraceNode.getIndexNode().getLocation());
import org.opensearch.painless.node.EDecimal;
        String memberFieldName = scriptScope.getNextSyntheticName("regex");
    public void visitBlock(SBlock userBlockNode, ScriptScope scriptScope) {
                    irLoadNode = irLoadDotShortcutNode;
            if (write || compound) {
 */
            }
        for (AExpression userArgumentNode : userNewObjectNode.getArgumentNodes()) {
                irStoreNode = irStoreVariableNode;
        List<Variable> captures = scriptScope.getDecoration(userLambdaNode, CapturesDecoration.class).getCaptures();
            ;
            NullSafeSubNode irNullSafeSubNode = new NullSafeSubNode(irExpressionNode.getLocation());
        NewArrayNode irNewArrayNode = new NewArrayNode(userNewArrayFunctionRefNode.getLocation());
                stringConcatenationNode.setExpressionType(String.class);
        ExpressionNode irValueNode = injectCast(userAssignmentNode.getRightNode(), scriptScope);
        ExpressionNode irExpressionNode;
import org.opensearch.painless.ir.StoreListShortcutNode;
import org.opensearch.painless.ir.IRNode;
        ExpressionNode irExpressionNode;
            targetType = painlessCast.unboxTargetType;
            ExpressionNode irLoadNode = null;
            if (write || compound) {
                new PainlessMethod(
                binaryImplNode.setLeftNode(irPrefixNode);
import org.opensearch.painless.ir.LoadListShortcutNode;
import java.lang.invoke.CallSite;
import org.opensearch.painless.symbol.Decorations.StandardLocalFunction;
        MapInitializationNode irMapInitializationNode = new MapInitializationNode(userMapInitNode.getLocation());
    }
                        scriptScope.getDecoration(userDotNode, GetterPainlessMethod.class).getGetterPainlessMethod()
                irPrefixNode = dupNode;
                    irPrefixNode = binaryImplNode;
        irFunctionNode.setSynthetic(true);
        irLoadFieldMemberNode.setStatic(true);
        ExpressionNode irAssignmentNode;
                if (write || compound) {
            irBinaryMathNode.setShiftType(shiftType);
                StringConcatenationNode irStringConcatenationNode = (StringConcatenationNode) irCompoundNode;
                irLoadVariableNode.setExpressionType(valueType);
            Class<?> valueType = scriptScope.getDecoration(userSymbolNode, ValueType.class).getValueType();
            irBlockNode.addStatementNode((StatementNode) visit(userStatementNode, scriptScope));
                        String.class,
import org.opensearch.painless.symbol.Decorations.MapShortcut;
import org.opensearch.painless.ir.NullNode;
        LocalFunction localFunction = scriptScope.getFunctionTable().getFunction(functionName, functionArity);
    public void visitNumeric(ENumeric userNumericNode, ScriptScope scriptScope) {
                Class<?> parameterType = parameterTypes[i + augmentedOffset];
            scriptScope.getDecoration(userListInitNode, StandardPainlessMethod.class).getStandardPainlessMethod()
            }
    public void visitClass(SClass userClassNode, ScriptScope scriptScope) {
            );
        irThrowNode.setExpressionNode(injectCast(userThrowNode.getExpressionNode(), scriptScope));
            Location location = userSymbolNode.getLocation();
        scriptScope.putDecoration(userDotNode, new IRNodeDecoration(irExpressionNode));
        StatementNode irStatementNode;
    /**
            invokeCallNode.setMethod(
                    irDupNode.setChildNode(irStoreNode.getChildNode());
    ) {
        irFunctionNode.setVarArgs(false);
import org.objectweb.asm.Opcodes;
            if (write == false || compound) {
            StaticNode staticNode = new StaticNode(userSymbolNode.getLocation());
import org.opensearch.painless.symbol.Decorations.Compound;
            FieldNode irFieldNode = new FieldNode(callLocalNode.getLocation());
import org.opensearch.painless.ir.CatchNode;
import org.opensearch.painless.node.SClass;
            }
import org.opensearch.painless.symbol.Decorations.ListShortcut;
        } else {
        } else if (prefixValueType == def.class) {
                irLoadMapShortcutNode.setExpressionType(scriptScope.getDecoration(userBraceNode, ValueType.class).getValueType());
                        } else if (returnType == long.class) {
        irDeclarationNode.setDeclarationType(variable.getType());
    }
    }
            irLoadVariableNode.setName("methodHandlesLookup");
            irFlipArrayIndexNode.setExpressionType(int.class);
        scriptScope.putDecoration(userBraceNode, new AccessDepth(2));
                irStringConcatenationNode.addArgumentNode(irLoadNode);
import org.opensearch.painless.symbol.Decorations.BinaryType;
 * GitHub history for details.
    }
import org.opensearch.painless.ir.ComparisonNode;
                    irLoadNode = irLoadListShortcutNode;
import org.opensearch.painless.ir.WhileLoopNode;
            scriptScope.addStaticConstant(bindingName, painlessInstanceBinding.targetInstance);
            boolean compound = scriptScope.getCondition(userSymbolNode, Compound.class);
            invokeCallNode.setBox(Pattern.class);
                binaryImplNode.setRightNode(irNullSafeSubNode);
        );
        }
        scriptScope.putDecoration(userCompNode, new IRNodeDecoration(irComparisonNode));
            if (downcast == null) {
                    );
    public void visitAssignment(EAssignment userAssignmentNode, ScriptScope scriptScope) {
                    );
        } else if (capturesDecoration != null && capturesDecoration.getCaptures().get(0).getType() == def.class) {
 * this work for additional information regarding copyright
        irDoWhileLoopNode.setContinuous(scriptScope.getCondition(userDoNode, ContinuousLoop.class));
                    irExpressionNode.setExpressionType(returnType);
import org.opensearch.painless.symbol.Decorations.IterablePainlessMethod;
        irNewArrayNode.setExpressionType(scriptScope.getDecoration(userNewArrayNode, ValueType.class).getValueType());
                    DefBootstrap.class.getMethod(
            irClassNode.addFunctionNode((FunctionNode) visit(userFunctionNode, scriptScope));
            } else {
                        } else if (returnType == float.class) {
import java.lang.invoke.MethodType;
            typedInterfaceReferenceNode.setReference(
    @Override
    @Override
        } else {
                if (write || compound) {
            irLoadVariableNode.setName("flavor");
        irExpressionNode.setExpressionType(valueType);
        NewObjectNode irNewObjectNode = new NewObjectNode(userNewObjectNode.getLocation());
            staticNode.setExpressionType(staticType);
     * @return The root node for this assignment.
        irReferenceNode.setExpressionType(scriptScope.getDecoration(userLambdaNode, ValueType.class).getValueType());
            irBlockNode.addStatementNode(irReturnNode);
                }
        for (Variable capture : captures) {
            irForEachSubIterableNode.setVariableType(variable.getType());
import org.opensearch.painless.node.EInstanceof;
        boolean read = scriptScope.getCondition(userAssignmentNode, Read.class);
            String symbol = userSymbolNode.getSymbol();
    @Override
    public void visitUnary(EUnary userUnaryNode, ScriptScope scriptScope) {
                irBinaryMathNode.setRightNode(irValueNode);
        ExpressionNode irExpressionNode = injectCast(userExpressionNode.getStatementNode(), scriptScope);
        ElvisNode irElvisNode = new ElvisNode(userElvisNode.getLocation());
    public void visitEach(SEach userEachNode, ScriptScope scriptScope) {
    @Override
                if (write || compound) {
        irCatchNode.setBlockNode((BlockNode) visit(userCatchNode.getBlockNode(), scriptScope));
    }
            Object[] injections = PainlessLookupUtility.buildInjections(method, scriptScope.getCompilerSettings().asMap());
                ? scriptScope.getDecoration(userBinaryNode, ShiftType.class).getShiftType()
                LoadVariableNode irLoadVariableNode = new LoadVariableNode(location);
            return null;
    /**
    }
            irFieldNode.setFieldType(painlessInstanceBinding.targetInstance.getClass());
            }
 * the Apache License, Version 2.0 (the "License"); you may
            }
            // upcast the stored value if necessary
            irLoadFieldMemberNode.setExpressionType(Map.class);
    @Override
import org.opensearch.painless.symbol.Decorations.ParameterNames;
        Class<?> iterableValueType = scriptScope.getDecoration(userEachNode.getIterableNode(), ValueType.class).getValueType();
            irInvokeCallMemberNode.setClassBindingOffset(
                irStoreMapShortcutNode.setSetter(
import org.opensearch.painless.ir.FlipCollectionIndexNode;
            irStoreFieldMemberNode.setName(memberFieldName);
            for (AExpression userArgumentNode : userCallNode.getArgumentNodes()) {
            irFunctionNode.setVarArgs(true);
                LoadMapShortcutNode irLoadMapShortcutNode = new LoadMapShortcutNode(location);
                    irDupNode = new DupNode(irStoreNode.getLocation());
    @Override
                if (write == false || compound) {
            ReturnNode returnNode = new ReturnNode(internalLocation);
     * stub out the appropriate load and store ir nodes.
            irFunctionNode.setSynthetic(true);
        ReferenceNode irReferenceNode;
        irFunctionNode.setReturnType(returnType);
                irStoreVariableNode.setName(symbol);
        irBinaryImplNode.setExpressionType(irExpressionNode.getExpressionType());
 * SPDX-License-Identifier: Apache-2.0
                        MethodType.class,
import org.opensearch.painless.node.SReturn;
        irFunctionNode.getTypeParameters().addAll(localFunction.getTypeParameters());
        if (scriptScope.hasDecoration(userDotNode, StaticType.class)) {
        PainlessCast painlessCast = scriptScope.hasDecoration(userEachNode, ExpressionPainlessCast.class)
                    DefBootstrap.class,
            irForEachSubIterableNode.setMethod(
                irCastNode.setExpressionType(downcast.targetType);
import org.opensearch.painless.ir.ForEachLoopNode;
        irCastNode.setCast(painlessCast);
import org.opensearch.painless.ir.DeclarationBlockNode;
            invokeCallNode.addArgumentNode(irConstantNode);
        scriptScope.putDecoration(userNullNode, new IRNodeDecoration(irNullNode));
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < userMapInitNode.getKeyNodes().size(); ++i) {
        }
                    Pattern.class,
        if (methodEscape == false) {
            int accessDepth;
                        Object[].class
import org.opensearch.painless.node.EUnary;
            irCallSubDefNode.setExpressionType(scriptScope.getDecoration(userCallNode, ValueType.class).getValueType());
        irNewObjectNode.setExpressionType(scriptScope.getDecoration(userNewObjectNode, ValueType.class).getValueType());
                // handles when the operation is mathematical
            return irExpressionNode;
    public void visitMapInit(EMapInit userMapInitNode, ScriptScope scriptScope) {
    }
            int augmentedOffset = method.javaMethod.getDeclaringClass() == method.targetClass ? 0 : 1;
                constantNode.setConstant(injection);
            );
import org.opensearch.painless.ir.InvokeCallDefNode;
                        FunctionTable.class,
        irDeclarationNode.setName(variable.getName());
                    irLoadDotNode.setExpressionType(valueType);
            irFieldNode.setFieldType(painlessClassBinding.javaConstructor.getDeclaringClass());
import org.opensearch.painless.ir.ListInitializationNode;
                irStoreNode.setChildNode(irCastNode);
            invokeCallNode.setBox(DefBootstrap.class);
import org.opensearch.painless.symbol.Decorations.StaticType;
            defInterfaceReferenceNode.setDefReferenceEncoding(
            irForEachSubArrayNode.setArrayName("#array" + userEachNode.getLocation().getOffset());
import org.opensearch.painless.node.ENewArray;
import org.opensearch.painless.node.EExplicit;
            irLoadVariableNode.setName("args");
                    irStoreNode = irStoreMapShortcutNode;
            typedInterfaceReferenceNode.setReference(scriptScope.getDecoration(userLambdaNode, ReferenceDecoration.class).getReference());
            irForEachSubIterableNode.setConditionNode(irIterableNode);
            irForEachSubArrayNode.setArrayType(iterableValueType);
    public void visitThrow(SThrow userThrowNode, ScriptScope scriptScope) {
            irReferenceNode = typedInterfaceReferenceNode;
        try {
        irFieldNode.setFieldType(Pattern.class);
                }
                irLoadBraceDefNode.setExpressionType(valueType);
import org.opensearch.painless.ir.DeclarationNode;
            throw userEachNode.createError(new IllegalStateException("illegal tree structure"));
}
        Operation operation = userBinaryNode.getOperation();
import org.opensearch.painless.ir.ExpressionNode;
        ValueType prefixValueType = scriptScope.getDecoration(userCallNode.getPrefixNode(), ValueType.class);
 *
import org.opensearch.painless.symbol.Decorations.ValueType;
        ConditionalNode irConditionalNode = new ConditionalNode(userConditionalNode.getLocation());
            irBinaryImplNode.setExpressionType(CallSite.class);
        BlockNode irBlockNode = new BlockNode(userNewArrayFunctionRefNode.getLocation());
            ? scriptScope.getDecoration(userEachNode, ExpressionPainlessCast.class).getExpressionPainlessCast()
            ReturnNode irReturnNode = new ReturnNode(userExpressionNode.getLocation());
public class DefaultUserTreeToIRTreePhase implements UserTreeVisitor<ScriptScope> {
                // add a cast node to do a downcast as the value for the store node
                            irConstantNode.setConstant(0f);
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
                        irConstantNode.setConstant(false);
    }
        String functionName = userFunctionNode.getFunctionName();
    @Override
            irInvokeCallMemberNode.setImportedMethod(
            if (operation == Operation.MATCH || operation == Operation.FIND) {
        injectBootstrapMethod(scriptScope);
            );
                    irExpressionNode = binaryImplNode;
        scriptScope.putDecoration(userDeclBlockNode, new IRNodeDecoration(irDeclarationBlockNode));
            irLoadVariableNode.setName("type");
            } else if (scriptScope.getCondition(userDotNode, MapShortcut.class)) {
        } else if (iterableValueType == def.class || Iterable.class.isAssignableFrom(iterableValueType)) {
        irClassNode.setScriptScope(scriptScope);
import org.opensearch.painless.ir.InstanceofNode;
import org.opensearch.painless.ir.FlipDefIndexNode;
import org.opensearch.painless.ir.StoreNode;
            irFunctionNode.setBlockNode(blockNode);
        boolean isNullSafe,
                    binaryImplNode.setLeftNode(irIndexNode);
                new PainlessMethod(
            irClassNode.addFieldNode(irFieldNode);
    public void visitIf(SIf userIfNode, ScriptScope scriptScope) {
            StaticNode irStaticNode = new StaticNode(userRegexNode.getLocation());
        irFieldNode = new FieldNode(internalLocation);
            irBinaryImplNode.setExpressionType(Pattern.class);
            staticNode.setExpressionType(DefBootstrap.class);
            : null;
                irLoadNode = irLoadListShortcutNode;
import org.opensearch.painless.ir.IfNode;
import org.opensearch.painless.ir.LoadBraceNode;
            PainlessInstanceBinding painlessInstanceBinding = scriptScope.getDecoration(
        Class<?> valueType = scriptScope.getDecoration(userBraceNode, ValueType.class).getValueType();
                irDupNode.setChildNode(irValueNode);
            }
        ReferenceNode irReferenceNode;
        irTryNode.setBlockNode((BlockNode) visit(userTryNode.getBlockNode(), scriptScope));
        ConstantNode irConstantNode = new ConstantNode(userBooleanConstantNode.getLocation());
        irInstanceofNode.setChildNode((ExpressionNode) visit(userInstanceofNode.getExpressionNode(), scriptScope));
            irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
    }
        irBlockNode.addStatementNode(irReturnNode);
        irFunctionNode.setName(scriptScope.getDecoration(userNewArrayFunctionRefNode, MethodNameDecoration.class).getMethodName());
                        scriptScope.getDecoration(userDotNode, GetterPainlessMethod.class).getGetterPainlessMethod()
            irStoreNode.setChildNode(irExpressionNode);
                irCompoundNode = stringConcatenationNode;
            userBraceNode,
            irStoreFieldMemberNode.setExpressionType(void.class);
            ExpressionNode irLoadNode = irStoreNode.getChildNode();
        ForEachLoopNode irForEachLoopNode = new ForEachLoopNode(userEachNode.getLocation());
        irLoadVariableNode.setName("size");
                }
    public void visitExplicit(EExplicit userExplicitNode, ScriptScope scriptScope) {
        ConstantNode irConstantNode = new ConstantNode(userDecimalNode.getLocation());
    }
                : null;
            irExpressionNode = irInvokeCallNode;
        scriptScope.putDecoration(userAssignmentNode, new IRNodeDecoration(irAssignmentNode));
            if (irLoadNode != null && irStoreNode != null) {
    public void visitIfElse(SIfElse userIfElseNode, ScriptScope scriptScope) {
            return scriptScope.getDecoration(userNode, IRNodeDecoration.class).getIRNode();
        irFieldNode.setName("$FUNCTIONS");
import org.opensearch.painless.symbol.Decorations.AccessDepth;
        }
            if (read) {
                        scriptScope.getDecoration(userDotNode, SetterPainlessMethod.class).getSetterPainlessMethod()
     * @param irStoreNode The store node if this is a write.
    }
        NewArrayNode irNewArrayNode = new NewArrayNode(userNewArrayNode.getLocation());
        if (userNode == null) {
            invokeCallNode.setMethod(
    }
            irInvokeCallNode.setMethod(scriptScope.getDecoration(userCallNode, StandardPainlessMethod.class).getStandardPainlessMethod());
            irFlipDefIndexNode.setChildNode(irIndexNode);
            } else {
                dupNode.setDepth(0);
                irBinaryMathNode.setOperation(userAssignmentNode.getOperation());
                    );
            scriptScope.getDecoration(userNewObjectNode, StandardPainlessConstructor.class).getStandardPainlessConstructor()
import org.opensearch.painless.symbol.Decorations.Read;
        scriptScope.putDecoration(userDecimalNode, new IRNodeDecoration(irConstantNode));
            }
                dupNode.setExpressionType(void.class);
                    irStoreDotNode.setStoreType(valueType);
            irExpressionNode = staticNode;
        IfNode irIfNode = new IfNode(userIfNode.getLocation());
    @Override
     * This handles both load and store for brace accesses as necessary. This uses buildLoadStore to
                        || returnType == char.class
                    scriptScope.getDecoration(userBraceNode, SetterPainlessMethod.class).getSetterPainlessMethod()
        irInvokeCallMemberNode.setExpressionType(scriptScope.getDecoration(callLocalNode, ValueType.class).getValueType());
                throw userDotNode.createError(new IllegalStateException("illegal tree structure"));
                irStoreMapShortcutNode.setExpressionType(read ? valueType : void.class);
            returnNode.setExpressionNode(irBinaryImplNode);
                );
                // the value is read from prior to assignment (post-increment)
    @Override
        }
            if (write || compound) {
        }
            irClassNode.addFieldNode(irFieldNode);
    @Override
        Variable variable = scriptScope.getDecoration(userDeclarationNode, SemanticVariable.class).getSemanticVariable();
        irReferenceNode.setExpressionType(scriptScope.getDecoration(userNewArrayFunctionRefNode, ValueType.class).getValueType());
            irMapInitializationNode.addArgumentNode(
            }
        }
            ExpressionNode irIndexNode = null;
                irLoadBraceNode.setExpressionType(valueType);
            irExpressionNode = buildLoadStore(0, location, false, null, null, irLoadNode, irStoreNode);
import java.util.regex.Pattern;
    public void visitCallLocal(ECallLocal callLocalNode, ScriptScope scriptScope) {
import org.opensearch.painless.ir.ConditionNode;
        irConstantNode.setConstant(scriptScope.getDecoration(userDecimalNode, StandardConstant.class).getStandardConstant());
        scriptScope.putDecoration(userBlockNode, new IRNodeDecoration(irBlockNode));
                    // both the index and expression are not written to the stack if the prefix is null
import org.opensearch.painless.node.SDeclaration;
                }
                if (write || compound) {
    @Override
import org.opensearch.painless.symbol.Decorations.SetterPainlessMethod;
        scriptScope.putDecoration(userDoNode, new IRNodeDecoration(irDoWhileLoopNode));
        boolean compound = scriptScope.getCondition(userBraceNode, Compound.class);
import org.opensearch.painless.ir.BooleanNode;
    @Override
import org.opensearch.painless.ir.MapInitializationNode;
                    null,
        irForLoopNode.setContinuous(scriptScope.getCondition(userForNode, ContinuousLoop.class));
import org.opensearch.painless.ir.ClassNode;
 * this file be licensed under the Apache-2.0 license or a
            irLoadFieldMemberNode.setName("$FUNCTIONS");
            irReferenceNode.addCapture(capturesDecoration.getCaptures().get(0).getName());
            invokeCallNode.addArgumentNode(irConstantNode);
            );
                }
        scriptScope.putDecoration(userTryNode, new IRNodeDecoration(irTryNode));
            irReturnNode.setExpressionNode(irExpressionNode);
            irIndexNode = irFlipArrayIndexNode;
                dupNode.setChildNode(irPrefixNode);
            irForEachSubArrayNode.setContinuous(false);
            irExpressionNode = irNullSafeSubNode;
import org.opensearch.painless.symbol.Decorations.ShiftType;
        scriptScope.putDecoration(userIfNode, new IRNodeDecoration(irIfNode));
            FlipDefIndexNode irFlipDefIndexNode = new FlipDefIndexNode(userBraceNode.getIndexNode().getLocation());
            }
 * compatible open source license.
    public void visitDeclaration(SDeclaration userDeclarationNode, ScriptScope scriptScope) {
        scriptScope.putDecoration(userFunctionNode, new IRNodeDecoration(irFunctionNode));
            invokeCallNode.addArgumentNode(irLoadFieldMemberNode);
        Class<?> valueType = scriptScope.getDecoration(userBinaryNode, ValueType.class).getValueType();
    @Override
        irClassNode.addFieldNode(irFieldNode);
                irLoadNode,
        irForLoopNode.setConditionNode(injectCast(userForNode.getConditionNode(), scriptScope));
 */
import org.opensearch.painless.ir.IfElseNode;
import org.opensearch.painless.ir.StoreDotNode;
    }
        irLoadVariableNode.setExpressionType(int.class);
        } else {
                    irStoreListShortcutNode.setExpressionType(read ? valueType : void.class);
        irFunctionNode.setReturnType(scriptScope.getDecoration(userLambdaNode, ReturnType.class).getReturnType());
import org.opensearch.painless.ir.StoreBraceNode;
import org.opensearch.painless.symbol.Decorations.ReturnType;
            Class<?> valueType = scriptScope.getDecoration(userDotNode, ValueType.class).getValueType();
                irStoreBraceNode.setIndexType(indexType);
            FunctionNode irFunctionNode = new FunctionNode(internalLocation);
            irStaticNode.setExpressionType(Pattern.class);
        CapturesDecoration capturesDecoration = scriptScope.getDecoration(userFunctionRefNode, CapturesDecoration.class);
import org.opensearch.painless.ir.BinaryMathNode;
        irFunctionNode.setStatic(true);
        ExpressionNode irLoadNode,
            irInvokeCallMemberNode.setBindingName(bindingName);
        irConstantNode.setExpressionType(scriptScope.getDecoration(userBooleanConstantNode, ValueType.class).getValueType());
                    irLoadNode = irLoadDotDefNode;
     */
                )
                    irDupNode.setExpressionType(irLoadNode.getExpressionType());
    }
                        FunctionTable.class,
        }
     * handling both regular assignment and compound assignment. It only stubs out
            Class<?> boxType;
        if (compoundType != null) {
        StoreNode irStoreNode
import java.util.Map;
    @Override
                irLoadNode = irLoadDotArrayLengthNode;
        irComparisonNode.setComparisonType(scriptScope.getDecoration(userCompNode, ComparisonType.class).getComparisonType());
            scriptScope.getDecoration(userMapInitNode, StandardPainlessConstructor.class).getStandardPainlessConstructor()
        } else {
            } else if (scriptScope.getCondition(userDotNode, Shortcut.class)) {
        scriptScope.putDecoration(userSymbolNode, new IRNodeDecoration(irExpressionNode));
    }
     * @param isNullSafe Whether or not the null safe operator is used.
        irFunctionNode.setSynthetic(true);
import org.opensearch.painless.ir.StoreMapShortcutNode;
    @Override
            irFunctionNode.setStatic(true);
        FunctionNode irFunctionNode = new FunctionNode(userNewArrayFunctionRefNode.getLocation());
                }
                scriptScope.getDecoration(callLocalNode, StandardPainlessMethod.class).getStandardPainlessMethod()
            StoreFieldMemberNode irStoreFieldMemberNode = new StoreFieldMemberNode(userRegexNode.getLocation());
import org.opensearch.painless.node.EDot;
            irLoadFieldMemberNode.setExpressionType(PainlessLookup.class);
    }
            } else {
        irFunctionNode.setVarArgs(false);
        irConditionalNode.setRightNode(injectCast(userConditionalNode.getFalseNode(), scriptScope));
        irBooleanNode.setLeftNode(injectCast(userBooleanCompNode.getLeftNode(), scriptScope));
import org.opensearch.painless.DefBootstrap;
        scriptScope.putDecoration(userWhileNode, new IRNodeDecoration(irWhileLoopNode));
            if (prefixValueType != null) {
        BinaryImplNode irBinaryImplNode = new BinaryImplNode(irExpressionNode.getLocation());
import org.opensearch.painless.node.AExpression;
            irLoadVariableNode.setExpressionType(Lookup.class);
            ForEachSubArrayNode irForEachSubArrayNode = new ForEachSubArrayNode(userEachNode.getLocation());
            irStoreFieldMemberNode.setStatic(true);
    public void visitNewArrayFunctionRef(ENewArrayFunctionRef userNewArrayFunctionRefNode, ScriptScope scriptScope) {
        irBinaryImplNode.setLeftNode((ExpressionNode) visit(userCallNode.getPrefixNode(), scriptScope));
        boolean read = scriptScope.getCondition(userBraceNode, Read.class);
        ListInitializationNode irListInitializationNode = new ListInitializationNode(userListInitNode.getLocation());
        } else {
            StatementExpressionNode irStatementExpressionNode = new StatementExpressionNode(userExpressionNode.getLocation());
import org.opensearch.painless.node.EElvis;
import org.opensearch.painless.node.SDo;
        }
import org.opensearch.painless.symbol.Decorations.ExpressionPainlessCast;
                    LoadDotNode irLoadDotNode = new LoadDotNode(location);
import java.util.Iterator;
        scriptScope.putDecoration(userThrowNode, new IRNodeDecoration(irThrowNode));
            // the value is read from after the assignment
        irConstantNode.setExpressionType(scriptScope.getDecoration(userStringNode, ValueType.class).getValueType());
                irLoadNode = irLoadVariableNode;
import org.opensearch.painless.WriterConstants;
        irFieldNode = new FieldNode(internalLocation);
            irStatementNode = irReturnNode;
                CastNode irCastNode = new CastNode(irCompoundNode.getLocation());
                scriptScope.getDecoration(userNewArrayFunctionRefNode, EncodingDecoration.class).getEncoding()
                if (isNullSafe) {
import org.opensearch.painless.symbol.Decorations.StandardPainlessField;
                StoreListShortcutNode irStoreListShortcutNode = new StoreListShortcutNode(location);
    }
    public void visitBrace(EBrace userBraceNode, ScriptScope scriptScope) {
import org.opensearch.painless.node.EBrace;
                LoadBraceNode irLoadBraceNode = new LoadBraceNode(location);
import org.opensearch.painless.symbol.Decorations.TypeParameters;
    public void visitString(EString userStringNode, ScriptScope scriptScope) {
        StoreNode irStoreNode = null;
        irFieldNode.setName(memberFieldName);
                    binaryImplNode.setExpressionType(irExpressionNode.getExpressionType());
        irBlockNode.setAllEscape(scriptScope.getCondition(userBlockNode, AllEscape.class));
    @Override
            if (write == false || compound) {
        irMapInitializationNode.setConstructor(
            irNullSafeSubNode.setChildNode(irExpressionNode);
        if (painlessCast.boxTargetType != null) {
        irConstantNode.setExpressionType(scriptScope.getDecoration(userNumericNode, ValueType.class).getValueType());
        irCastNode.setChildNode(irExpressionNode);
    }
                        int.class,
            Class<?> indexType = scriptScope.getDecoration(userBraceNode.getIndexNode(), ValueType.class).getValueType();
                irBinaryMathNode.setLeftNode(irLoadNode);
            UnaryMathNode irUnaryMathNode = new UnaryMathNode(userUnaryNode.getLocation());
                    binaryImplNode.setRightNode(irExpressionNode);
        for (SDeclaration userDeclarationNode : userDeclBlockNode.getDeclarationNodes()) {
        // handles a compound assignment using the stub generated from buildLoadStore
            );
            StaticNode staticNode = new StaticNode(userDotNode.getLocation());
                irStoreNode = irStoreListShortcutNode;
                } else {
import org.opensearch.painless.ir.StoreBraceDefNode;
    }
            irForEachSubIterableNode.setBlockNode(irBlockNode);
        );
            irDeclarationBlockNode.addDeclarationNode((DeclarationNode) visit(userDeclarationNode, scriptScope));
                Object injection = injections[i];
            irReferenceNode = typedCaptureReferenceNode;
                    irLoadNode = irDupNode;
    @Override
            irBinaryMathNode.setBinaryType(scriptScope.getDecoration(userBinaryNode, BinaryType.class).getBinaryType());
        irBinaryImplNode.setRightNode(irExpressionNode);
            irLoadVariableNode.setName("name");
        // build out the load structure for load/compound assignment or the store structure for just store
                StringConcatenationNode stringConcatenationNode = new StringConcatenationNode(irStoreNode.getLocation());
        );
            irLoadVariableNode = new LoadVariableNode(internalLocation);
                ? scriptScope.getDecoration(userAssignmentNode, DowncastPainlessCast.class).getDowncastPainlessCast()
        scriptScope.putDecoration(userListInitNode, new IRNodeDecoration(irListInitializationNode));
    }
    @Override
import org.opensearch.painless.ir.ReturnNode;
                irCompoundNode = irBinaryMathNode;
    @Override
import org.opensearch.painless.symbol.Decorations.CompoundType;
            irLoadVariableNode = new LoadVariableNode(internalLocation);
                irStoreBraceNode.setExpressionType(read ? valueType : void.class);
            }
        int functionArity = userFunctionNode.getCanonicalTypeNameParameters().size();
            irInvokeCallMemberNode.setLocalFunction(
import org.opensearch.painless.lookup.def;
                    irStoreDotNode.setField(painlessField);
        irConditionalNode.setLeftNode(injectCast(userConditionalNode.getTrueNode(), scriptScope));
        } else if (scriptScope.getCondition(userBraceNode, MapShortcut.class)) {
            irLoadFieldMemberNode.setStatic(true);
                injectCast(userMapInitNode.getKeyNodes().get(i), scriptScope),
            defInterfaceReferenceNode.setDefReferenceEncoding(
            if (concatenate) {
                boxType = scriptScope.getDecoration(userCallNode.getPrefixNode(), StaticType.class).getStaticType();
                irStoreNode = irStoreBraceNode;
                if (write == false || compound) {
import org.opensearch.painless.symbol.Decorations.IRNodeDecoration;
 *
import org.opensearch.painless.symbol.Decorations.MethodNameDecoration;
            irFieldNode.setName(bindingName);
            DefInterfaceReferenceNode defInterfaceReferenceNode = new DefInterfaceReferenceNode(userNewArrayFunctionRefNode.getLocation());
                scriptScope.getDecoration(userFunctionRefNode, ReferenceDecoration.class).getReference()
        irInstanceofNode.setExpressionType(scriptScope.getDecoration(userInstanceofNode, ValueType.class).getValueType());
        }
            irUnaryMathNode.setExpressionType(scriptScope.getDecoration(userUnaryNode, ValueType.class).getValueType());
                irLoadVariableNode.setName(symbol);
            );
        scriptScope.putDecoration(userReturnNode, new IRNodeDecoration(irReturnNode));
            if (concatenate) {
                irIndexNode = irConstantNode;
            irBinaryImplNode.setLeftNode(irStaticNode);
                    LoadDotShortcutNode irLoadDotShortcutNode = new LoadDotShortcutNode(location);
            userNode.visit(this, scriptScope);
            irForEachSubArrayNode.setVariableType(variable.getType());
                    Arrays.asList(String.class, int.class),
import org.opensearch.painless.ir.LoadFieldMemberNode;
            irAssignmentNode = irStoreNode;
import org.opensearch.painless.node.EAssignment;
                if (write == false || compound) {
                    irDupNode.setChildNode(irLoadNode);
                .getPainlessClassBinding();
    @Override
            String index = userDotNode.getIndex();
        } else {
            invokeCallNode.setExpressionType(CallSite.class);
        irClassNode.addFunctionNode(irFunctionNode);
                irBinaryMathNode.setBinaryType(compoundType);
        irMapInitializationNode.setExpressionType(scriptScope.getDecoration(userMapInitNode, ValueType.class).getValueType());
                int accessDepth = scriptScope.getDecoration(userAssignmentNode.getLeftNode(), AccessDepth.class).getAccessDepth();
                irPrefixNode,
    protected ClassNode irClassNode;
                irBinaryMathNode.setFlags(DefBootstrap.OPERATOR_EXPLICIT_CAST);
     * @param irIndexNode The index node if this is a brace access.
        irBooleanNode.setOperation(userBooleanCompNode.getOperation());
        irDoWhileLoopNode.setConditionNode(injectCast(userDoNode.getConditionNode(), scriptScope));
import org.opensearch.painless.symbol.Decorations.MethodEscape;
            : null;
    }
    @Override
import org.opensearch.painless.node.SEach;
            if (write == false || compound) {
import org.opensearch.painless.node.AStatement;
                irStoreListShortcutNode.setSetter(
        irFieldNode.setName("$COMPILERSETTINGS");
import org.opensearch.painless.ir.StaticNode;
        } else {
    @Override
                    irStoreNode.setChildNode(irDupNode);
            irLoadVariableNode.setExpressionType(int.class);
            TypedCaptureReferenceNode typedCaptureReferenceNode = new TypedCaptureReferenceNode(userFunctionRefNode.getLocation());
            if (write == false || compound) {
        }
            irLoadFieldMemberNode.setName("$COMPILERSETTINGS");
            irInvokeCallMemberNode.setClassBinding(painlessClassBinding);
                ((StoreNode) irAssignmentNode).setChildNode(irValueNode);
    @Override
        irFunctionNode.setMaxLoopCounter(scriptScope.getCompilerSettings().getMaxLoopCounter());
        ContinueNode irContinueNode = new ContinueNode(userContinueNode.getLocation());
        irListInitializationNode.setExpressionType(scriptScope.getDecoration(userListInitNode, ValueType.class).getValueType());
import org.opensearch.painless.symbol.Decorations.UpcastPainlessCast;
        TargetType targetType = scriptScope.getDecoration(userFunctionRefNode, TargetType.class);
import org.opensearch.painless.node.ANode;
                    irStoreNode = irStoreDotDefNode;
        if (operation == Operation.ADD && valueType == String.class) {
            irReferenceNode.addCapture(capture.getName());
            PainlessMethod method = scriptScope.getDecoration(userCallNode, StandardPainlessMethod.class).getStandardPainlessMethod();
    @Override
import org.opensearch.painless.symbol.Decorations.StandardPainlessInstanceBinding;
        scriptScope.putDecoration(userConditionalNode, new IRNodeDecoration(irConditionalNode));
                irStoreMapShortcutNode.setStoreType(valueType);
     * stub out the appropriate load and store ir nodes.
        irCastNode.setExpressionType(targetType);
                irCastNode.setExpressionType(upcast.targetType);
        irListInitializationNode.setMethod(
        }
            irReferenceNode = typedInterfaceReferenceNode;
    public void visitListInit(EListInit userListInitNode, ScriptScope scriptScope) {
        ConstantNode irConstantNode = new ConstantNode(userNumericNode.getLocation());
        irConstantNode.setConstant(scriptScope.getDecoration(userBooleanConstantNode, StandardConstant.class).getStandardConstant());
                irLoadListShortcutNode.setExpressionType(scriptScope.getDecoration(userBraceNode, ValueType.class).getValueType());
import org.opensearch.painless.lookup.PainlessLookup;
import org.opensearch.painless.ir.BreakNode;
        }
            irUnaryMathNode.setOperation(userUnaryNode.getOperation());
        );
            irForEachSubArrayNode.setIndexType(int.class);
            irLoadVariableNode.setName("initialDepth");
        Class<?> returnType = scriptScope.getDecoration(userNewArrayFunctionRefNode, ReturnType.class).getReturnType();
import java.util.List;
        scriptScope.putDecoration(userEachNode, new IRNodeDecoration(irForEachLoopNode));
            irStoreFieldMemberNode.setChildNode(irBinaryImplNode);
        ExpressionNode irExpressionNode;
                        PainlessLookup.class,
            );
        irFunctionNode.getParameterNames().addAll(userFunctionNode.getParameterNames());
        if (irExpressionNode == null) {
                    irExpressionNode = new NullNode(userFunctionNode.getLocation());
        }
                    scriptScope.getDecoration(userBraceNode, SetterPainlessMethod.class).getSetterPainlessMethod()
        ExpressionNode irPrefixNode,
        }
    public void visitComp(EComp userCompNode, ScriptScope scriptScope) {
            irStoreFieldMemberNode.setStoreType(Pattern.class);
        }
import org.opensearch.painless.node.SFor;
import org.opensearch.painless.symbol.Decorations.StandardPainlessMethod;
        Class<?> unaryType = scriptScope.hasDecoration(userUnaryNode, UnaryType.class)
    }
        scriptScope.putDecoration(userIfElseNode, new IRNodeDecoration(irIfElseNode));
                irCastNode.setCast(upcast);
import org.opensearch.painless.ir.DoWhileLoopNode;
        scriptScope.putDecoration(userUnaryNode, new IRNodeDecoration(irNode));
        for (AExpression userValueNode : userListInitNode.getValueNodes()) {
        for (SFunction userFunctionNode : userClassNode.getFunctionNodes()) {
            throw new IllegalStateException(exception);
        irFieldNode.setFieldType(Map.class);
                irStoreBraceNode.setExpressionType(read ? valueType : void.class);
            irConstantNode.setExpressionType(String.class);
        irReturnNode.setExpressionNode(injectCast(userReturnNode.getValueNode(), scriptScope));
            String bindingName = scriptScope.getNextSyntheticName("instance_binding");
            irFunctionNode.getTypeParameters()
    @Override
                irStoreVariableNode.setExpressionType(read ? valueType : void.class);
        ConditionNode irConditionNode;
import org.opensearch.painless.ir.StoreDotShortcutNode;
            PainlessCast downcast = scriptScope.hasDecoration(userAssignmentNode, DowncastPainlessCast.class)
        } else {
    @Override
        irFunctionNode.setMaxLoopCounter(0);
    public void visitConditional(EConditional userConditionalNode, ScriptScope scriptScope) {
                ConstantNode irConstantNode = new ConstantNode(location);
        irConditionalNode.setExpressionType(scriptScope.getDecoration(userConditionalNode, ValueType.class).getValueType());
                    irLoadNode = irLoadMapShortcutNode;
            Location location = userDotNode.getLocation();
                        Lookup.class,
        FieldNode irFieldNode = new FieldNode(userRegexNode.getLocation());
    @Override
        irMapInitializationNode.setMethod(
        irFunctionNode.setBlockNode((BlockNode) visit(userLambdaNode.getBlockNode(), scriptScope));
    public void visitBreak(SBreak userBreakNode, ScriptScope scriptScope) {
     * This handles both load and store for symbol accesses as necessary. This uses buildLoadStore to
                    irStoreDotDefNode.setValue(index);
import org.opensearch.painless.symbol.Decorations.ReferenceDecoration;
     * This includes injection of ir nodes to add a function to call
                    null
                        } else {
import org.opensearch.painless.lookup.PainlessClassBinding;
    public void visitDecimal(EDecimal userDecimalNode, ScriptScope scriptScope) {
                BinaryMathNode irBinaryMathNode = new BinaryMathNode(irStoreNode.getLocation());
                // must handle the StringBuilder case for java version <= 8
        Variable variable = scriptScope.getDecoration(userEachNode, SemanticVariable.class).getSemanticVariable();
    }
        } else {
            irLoadVariableNode.setExpressionType(MethodType.class);
            irBinaryMathNode.setOperation(operation);
import org.opensearch.painless.ir.FieldNode;
        }
            stringConcatenationNode.addArgumentNode((ExpressionNode) visit(userBinaryNode.getLeftNode(), scriptScope));
            );
            BlockNode blockNode = new BlockNode(internalLocation);
        irFunctionNode.getTypeParameters().addAll(scriptScope.getDecoration(userLambdaNode, TypeParameters.class).getTypeParameters());
            PainlessClassBinding painlessClassBinding = scriptScope.getDecoration(callLocalNode, StandardPainlessClassBinding.class)
                }
import org.opensearch.painless.ir.BlockNode;
        irWhileLoopNode.setConditionNode(injectCast(userWhileNode.getConditionNode(), scriptScope));
/*
 * You may obtain a copy of the License at
import org.opensearch.painless.symbol.Decorations.Explicit;
                irLoadListShortcutNode.setGetter(
        Class<?> targetType = painlessCast.targetType;
import org.opensearch.painless.ir.ForLoopNode;
        ThrowNode irThrowNode = new ThrowNode(userThrowNode.getLocation());
            }
        for (AExpression userArgumentNode : userNewArrayNode.getValueNodes()) {
            irConstantNode = new ConstantNode(userRegexNode.getLocation());
            LoadVariableNode irLoadVariableNode = new LoadVariableNode(internalLocation);
            Class<?> shiftType = scriptScope.hasDecoration(userBinaryNode, ShiftType.class)
                if (irLoadNode instanceof BinaryImplNode && WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE == null) {
                accessDepth = 1;
        NullNode irNullNode = new NullNode(userNullNode.getLocation());
                accessDepth = 1;
        FunctionNode irFunctionNode = new FunctionNode(userFunctionNode.getLocation());
            ForEachSubIterableNode irForEachSubIterableNode = new ForEachSubIterableNode(userEachNode.getLocation());
        BlockNode irBlockNode = (BlockNode) visit(userEachNode.getBlockNode(), scriptScope);
import org.opensearch.painless.symbol.SemanticScope.Variable;
        irNewArrayNode.setInitialize(userNewArrayNode.isInitializer());
        } else {
            irInvokeCallNode.setExpressionType(scriptScope.getDecoration(userCallNode, ValueType.class).getValueType());
        ReferenceNode irReferenceNode;
import org.opensearch.painless.node.ECallLocal;
                        MethodType.class,
        irForLoopNode.setBlockNode((BlockNode) visit(userForNode.getBlockNode(), scriptScope));
            irCallSubDefNode.setName(userCallNode.getMethodName());
        CatchNode irCatchNode = new CatchNode(userCatchNode.getLocation());
                }
        ExpressionNode irExpressionNode;
        CastNode irCastNode = new CastNode(irExpressionNode.getLocation());
            }
        }
                        || returnType == short.class
        ExpressionNode irExpressionNode = irLoadNode != null ? irLoadNode : irStoreNode;
import org.opensearch.painless.node.EListInit;
        irConstantNode.setExpressionType(scriptScope.getDecoration(userDecimalNode, ValueType.class).getValueType());
                    irStoreDotShortcutNode.setStoreType(valueType);
                    // the null-safe structure is slightly different from the standard structure since
            irFlipArrayIndexNode.setChildNode(irIndexNode);
            } else {
                    StoreDotNode irStoreDotNode = new StoreDotNode(location);
            scriptScope.setCondition(userAssignmentNode.getLeftNode(), Compound.class);
            invokeCallNode.addArgumentNode(irLoadFieldMemberNode);
            irExpressionNode = irBinaryMathNode;
            irExpressionNode = staticNode;
                    irStoreNode = irStoreDotNode;
            irInvokeCallMemberNode.setInstanceBinding(painlessInstanceBinding);
            irReferenceNode = typedInterfaceReferenceNode;
                irLoadDotArrayLengthNode.setExpressionType(int.class);
    @Override
                    ),
                userDotNode.isNullSafe(),
            FieldNode irFieldNode = new FieldNode(callLocalNode.getLocation());
    protected ExpressionNode buildLoadStore(
        }
 * ownership. Elasticsearch licenses this file to you under
        scriptScope.putDecoration(userDeclarationNode, new IRNodeDecoration(irDeclarationNode));
                if (parameterType != PainlessLookupUtility.typeToUnboxedType(injection.getClass())) {
                    StoreDotDefNode irStoreDotDefNode = new StoreDotDefNode(location);
            irReturnNode.setExpressionNode(irExpressionNode);
            TypedInterfaceReferenceNode typedInterfaceReferenceNode = new TypedInterfaceReferenceNode(userLambdaNode.getLocation());
                LoadBraceDefNode irLoadBraceDefNode = new LoadBraceDefNode(location);
            throw callLocalNode.createError(new IllegalStateException("illegal tree structure"));
import org.opensearch.painless.ir.NewObjectNode;
    }
import org.opensearch.painless.node.ENumeric;
 * specific language governing permissions and limitations
                .addAll(Arrays.asList(Lookup.class, String.class, MethodType.class, int.class, int.class, Object[].class));
                    irStoreDotShortcutNode.setExpressionType(read ? valueType : void.class);
        irFunctionNode.setName(scriptScope.getDecoration(userLambdaNode, MethodNameDecoration.class).getMethodName());
                ConstantNode constantNode = new ConstantNode(userCallNode.getLocation());
                    Arrays.asList(
                if (returnType.isPrimitive()) {
                irBinaryMathNode.setFlags(DefBootstrap.OPERATOR_COMPOUND_ASSIGNMENT);
                scriptScope.getDecoration(userLambdaNode, EncodingDecoration.class).getEncoding()
        DeclarationNode irDeclarationNode = new DeclarationNode(userDeclarationNode.getLocation());
            } else {
                StoreBraceDefNode irStoreBraceNode = new StoreBraceDefNode(location);
import org.opensearch.painless.ir.UnaryMathNode;
     * @param location The location for errors.
                );
        }
import org.opensearch.painless.node.ENewArrayFunctionRef;
        irClassNode.addFieldNode(irFieldNode);
            irAssignmentNode = (ExpressionNode) visit(userAssignmentNode.getLeftNode(), scriptScope);
                irCastNode.setChildNode(irLoadNode);
     */
import org.opensearch.painless.node.SIfElse;
    }
    }
        FieldNode irFieldNode = new FieldNode(internalLocation);
                constantNode.setExpressionType(parameterType);
    public void visitLambda(ELambda userLambdaNode, ScriptScope scriptScope) {
        scriptScope.putDecoration(userNewArrayNode, new IRNodeDecoration(irNewArrayNode));
                boxType = prefixValueType.getValueType();
                    irStoreDotDefNode.setStoreType(valueType);
            irClassNode.addFunctionNode(irFunctionNode);
import org.opensearch.painless.symbol.FunctionTable;
        } else if (scriptScope.hasDecoration(callLocalNode, StandardPainlessMethod.class)) {
        }
import org.opensearch.painless.ir.LoadDotShortcutNode;
                    binaryImplNode.setLeftNode(irPrefixNode);
        } else if (scriptScope.hasDecoration(callLocalNode, StandardPainlessInstanceBinding.class)) {
        irComparisonNode.setLeftNode(injectCast(userCompNode.getLeftNode(), scriptScope));
            InvokeCallNode invokeCallNode = new InvokeCallNode(userRegexNode.getLocation());
import org.opensearch.painless.ir.ContinueNode;
                irInvokeCallNode.addArgumentNode(constantNode);
        irElvisNode.setExpressionType(scriptScope.getDecoration(userElvisNode, ValueType.class).getValueType());
            irConditionNode = irForEachSubIterableNode;
            defInterfaceReferenceNode.setDefReferenceEncoding(
        irNewObjectNode.setRead(scriptScope.getCondition(userNewObjectNode, Read.class));
                    irLoadDotDefNode.setValue(index);
import org.opensearch.painless.ir.LoadDotNode;
        irLoadFieldMemberNode.setExpressionType(Pattern.class);
        ReturnNode irReturnNode = new ReturnNode(userReturnNode.getLocation());
     * This injects additional ir nodes required for resolving the def type at runtime.
                        || returnType == int.class) {
                    irStoreDotDefNode.setExpressionType(read ? valueType : void.class);
    }
            irForEachSubIterableNode.setCast(painlessCast);
            }
            invokeCallNode.addArgumentNode(irLoadVariableNode);
import java.util.Arrays;
                    irLoadDotShortcutNode.setGetter(
        }
                } else {
        scriptScope.putDecoration(userNewObjectNode, new IRNodeDecoration(irNewObjectNode));
            irForEachSubArrayNode.setIndexedType(iterableValueType.getComponentType());
import org.opensearch.painless.ir.FunctionNode;
                }
    }
                );
        for (AStatement userStatementNode : userBlockNode.getStatementNodes()) {
                        } else if (returnType == double.class) {
import org.opensearch.painless.Location;
        scriptScope.putDecoration(callLocalNode, new IRNodeDecoration(irInvokeCallMemberNode));
            irFunctionNode.setName("$bootstrapDef");
                irConstantNode.setExpressionType(String.class);
            irNewObjectNode.addArgumentNode(injectCast(userArgumentNode, scriptScope));
                NullSafeSubNode irNullSafeSubNode = new NullSafeSubNode(location);
        LoadFieldMemberNode irLoadFieldMemberNode = new LoadFieldMemberNode(userRegexNode.getLocation());
        BlockNode irBlockNode = (BlockNode) visit(userFunctionNode.getBlockNode(), scriptScope);
                        Map.class,
                .addAll(Arrays.asList("methodHandlesLookup", "name", "type", "initialDepth", "flavor", "args"));
    public void visitRegex(ERegex userRegexNode, ScriptScope scriptScope) {
                irLoadMapShortcutNode.setGetter(
            throw userBraceNode.createError(new IllegalStateException("illegal tree structure"));
    }
                    null,
                    StoreDotShortcutNode irStoreDotShortcutNode = new StoreDotShortcutNode(location);
                ConstantNode irConstantNode = new ConstantNode(location);
import org.opensearch.painless.symbol.Decorations.TargetType;
                irStoreNode
            irFunctionNode.getParameterNames()
            for (AExpression userCallArgumentNode : userCallNode.getArgumentNodes()) {
            irInvokeCallMemberNode.setBindingName(bindingName);
            }
        irWhileLoopNode.setContinuous(scriptScope.getCondition(userWhileNode, ContinuousLoop.class));
        InvokeCallMemberNode irInvokeCallMemberNode = new InvokeCallMemberNode(callLocalNode.getLocation());
        } catch (Exception exception) {
import java.lang.invoke.MethodHandles.Lookup;
    @Override
            irLoadFieldMemberNode.setStatic(true);
            irFlipCollectionIndexNode.setExpressionType(int.class);
        if (scriptScope.getCondition(userExpressionNode, MethodEscape.class)) {
            irUnaryMathNode.setOriginallyExplicit(scriptScope.getCondition(userUnaryNode, Explicit.class));
            invokeCallNode.addArgumentNode(irLoadVariableNode);
import org.opensearch.painless.symbol.Decorations.StandardConstant;
import org.opensearch.painless.node.SBlock;
        irLoadFieldMemberNode.setName(memberFieldName);
                );
        ExpressionNode irLoadNode = null;
    public void visitReturn(SReturn userReturnNode, ScriptScope scriptScope) {
        scriptScope.putDecoration(userExplicitNode, new IRNodeDecoration(injectCast(userExplicitNode.getChildNode(), scriptScope)));
                        int.class,
        irFunctionNode.setStatic(userFunctionNode.isStatic());
                scriptScope.getDecoration(userNewArrayFunctionRefNode, ReferenceDecoration.class).getReference()
            irFieldNode.setName(bindingName);
                : null;
            boolean write = scriptScope.getCondition(userSymbolNode, Write.class);
                if (write || compound) {
    public void visitCall(ECall userCallNode, ScriptScope scriptScope) {
    public void visitDeclBlock(SDeclBlock userDeclBlockNode, ScriptScope scriptScope) {
        scriptScope.putDecoration(userNewArrayFunctionRefNode, new IRNodeDecoration(irReferenceNode));
    @Override
        Location location,
            irForEachSubIterableNode.setIteratorName("#itr" + userEachNode.getLocation().getOffset());
import org.opensearch.painless.symbol.Decorations.EncodingDecoration;
    @Override
    public void visitFunctionRef(EFunctionRef userFunctionRefNode, ScriptScope scriptScope) {
     * to do the runtime resolution, and several supporting static fields.
        BreakNode irBreakNode = new BreakNode(userBreakNode.getLocation());
import org.opensearch.painless.node.EComp;
            boolean compound = scriptScope.getCondition(userDotNode, Compound.class);
            irReferenceNode = defInterfaceReferenceNode;
            StaticNode staticNode = new StaticNode(internalLocation);
    @Override
    }
        boolean write = scriptScope.getCondition(userBraceNode, Write.class);
                irStringConcatenationNode.addArgumentNode(irValueNode);
                    : scriptScope.getDecoration(userEachNode, IterablePainlessMethod.class).getIterablePainlessMethod()
                StandardPainlessInstanceBinding.class
                    irStoreDotNode.setExpressionType(read ? valueType : void.class);
            irInvokeCallMemberNode.addArgumentNode(injectCast(userArgumentNode, scriptScope));
        scriptScope.putDecoration(userStringNode, new IRNodeDecoration(irConstantNode));
    public void visitExpression(SExpression userExpressionNode, ScriptScope scriptScope) {
import org.opensearch.painless.node.SDeclBlock;
                    irStoreMapShortcutNode.setExpressionType(read ? valueType : void.class);
            typedCaptureReferenceNode.setMethodName(userFunctionRefNode.getMethodName());
    }
                irStoreBraceNode.setStoreType(valueType);
            irLoadFieldMemberNode.setName("$DEFINITION");
    }
        } else if (scriptScope.hasDecoration(callLocalNode, StandardPainlessClassBinding.class)) {
            }
        ConstantNode irConstantNode = new ConstantNode(userStringNode.getLocation());
                    irLoadListShortcutNode.setGetter(
                accessDepth = 1;
                irExpressionNode = null;
                            irConstantNode.setConstant(0L);
            } else {
                        String.class,
                irDupNode.setDepth(accessDepth);
            if (upcast != null) {
                    .getStandardPainlessField();
import org.opensearch.painless.node.ECall;
import org.opensearch.painless.node.EFunctionRef;
import org.opensearch.painless.symbol.Decorations.ContinuousLoop;
     * @param irLoadNode The load node if this a read.
import org.opensearch.painless.ir.ConditionalNode;
            blockNode.setAllEscape(true);
                    irLoadListShortcutNode.setExpressionType(valueType);
                    irLoadDotShortcutNode.setExpressionType(valueType);
        ComparisonNode irComparisonNode = new ComparisonNode(userCompNode.getLocation());
        if (iterableValueType.isArray()) {
            irIndexNode = irFlipCollectionIndexNode;
import org.opensearch.painless.node.SFunction;
import org.opensearch.painless.ir.InvokeCallMemberNode;
            StatementExpressionNode irStatementExpressionNode = new StatementExpressionNode(userRegexNode.getLocation());
            StoreNode irStoreNode = (StoreNode) visit(userAssignmentNode.getLeftNode(), scriptScope);
            if (scriptScope.getCondition(userBinaryNode, Explicit.class)) {
                            irConstantNode.setConstant(0);
import org.opensearch.painless.ir.NullSafeSubNode;
            ? scriptScope.getDecoration(userUnaryNode, UnaryType.class).getUnaryType()
        if (scriptScope.hasDecoration(callLocalNode, StandardLocalFunction.class)) {
        irIfElseNode.setBlockNode((BlockNode) visit(userIfElseNode.getIfBlockNode(), scriptScope));
    @Override
import org.opensearch.painless.ir.StatementExpressionNode;
            irStatementExpressionNode.setExpressionNode(irStoreFieldMemberNode);
            irBinaryMathNode.setRightNode(injectCast(userBinaryNode.getRightNode(), scriptScope));
            irReferenceNode = defInterfaceReferenceNode;
            if (isNullSafe) {
            irInvokeCallNode.setBox(boxType);
import org.opensearch.painless.node.EBooleanConstant;
     * stub out the appropriate load and store ir nodes.
            if (write || compound) {
import org.opensearch.painless.lookup.PainlessCast;
            irStatementExpressionNode.setExpressionNode(irExpressionNode);
        irFunctionNode.addTypeParameter(int.class);
                    irDupNode = new DupNode(irLoadNode.getLocation());
    @Override
        scriptScope.putDecoration(userLambdaNode, new IRNodeDecoration(irReferenceNode));
import org.opensearch.painless.ir.LoadDotDefNode;
        } else if (scriptScope.hasDecoration(userSymbolNode, ValueType.class)) {
            ExpressionNode irCompoundNode;
import org.opensearch.painless.ir.LoadVariableNode;
        irClassNode.addFieldNode(irFieldNode);
        irConditionalNode.setConditionNode(injectCast(userConditionalNode.getConditionNode(), scriptScope));
        FunctionNode irFunctionNode = new FunctionNode(userLambdaNode.getLocation());
        irIfNode.setConditionNode(injectCast(userIfNode.getConditionNode(), scriptScope));
            irReferenceNode = defInterfaceReferenceNode;
                irNullSafeSubNode.setChildNode(irExpressionNode);
import org.opensearch.painless.ir.ReferenceNode;
import org.opensearch.painless.ir.ForEachSubArrayNode;
import org.opensearch.painless.ir.ElvisNode;
        irListInitializationNode.setConstructor(
 * software distributed under the License is distributed on an
import org.opensearch.painless.ir.ConstantNode;
            throw userRegexNode.createError(new IllegalStateException("illegal tree structure"));
                if (write == false || compound) {
                        Object[].class
import org.opensearch.painless.node.ENull;
                }
        scriptScope.putDecoration(userExpressionNode, new IRNodeDecoration(irStatementNode));
        ExpressionPainlessCast expressionPainlessCast = scriptScope.getDecoration(userExpressionNode, ExpressionPainlessCast.class);
                // build the structure for a null safe load
        IRNode irNode;
                    StoreListShortcutNode irStoreListShortcutNode = new StoreListShortcutNode(location);
    @Override
        }
            irFlipDefIndexNode.setExpressionType(indexType);
    }
            irLoadFieldMemberNode.setExpressionType(FunctionTable.class);
            irExpressionNode = binaryImplNode;
            LoadFieldMemberNode irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
            }
            irForEachSubArrayNode.setBlockNode(irBlockNode);
        irFunctionNode.setMaxLoopCounter(scriptScope.getCompilerSettings().getMaxLoopCounter());
import org.opensearch.painless.ir.DefInterfaceReferenceNode;
            InvokeCallNode irInvokeCallNode = new InvokeCallNode(userCallNode.getLocation());
        if (scriptScope.hasDecoration(userLambdaNode, TargetType.class)) {
        ExpressionNode irIterableNode = (ExpressionNode) visit(userEachNode.getIterableNode(), scriptScope);
import org.opensearch.painless.MethodWriter;
                if (userAssignmentNode.postIfRead()) {
                LoadListShortcutNode irLoadListShortcutNode = new LoadListShortcutNode(location);
            irLoadVariableNode.setExpressionType(Object[].class);
            irForEachSubArrayNode.setVariableName(variable.getName());
            } else if (prefixValueType != null && prefixValueType.getValueType() == def.class) {
        IfElseNode irIfElseNode = new IfElseNode(userIfElseNode.getLocation());
import org.opensearch.painless.node.SBreak;
    }
            irLoadVariableNode.setExpressionType(String.class);
                    irStoreNode = irStoreListShortcutNode;
            stringConcatenationNode.addArgumentNode((ExpressionNode) visit(userBinaryNode.getRightNode(), scriptScope));
        }
                irDupNode.setExpressionType(irValueNode.getExpressionType());
            scriptScope.getDecoration(userMapInitNode, StandardPainlessMethod.class).getStandardPainlessMethod()
    }
                    throw new IllegalStateException("illegal tree structure");
                        Lookup.class,
                    scriptScope.getDecoration(userBraceNode, GetterPainlessMethod.class).getGetterPainlessMethod()
    }
            staticNode.setExpressionType(staticType);
    public void visitBooleanComp(EBooleanComp userBooleanCompNode, ScriptScope scriptScope) {
        irClassNode = new ClassNode(userClassNode.getLocation());
        DeclarationBlockNode irDeclarationBlockNode = new DeclarationBlockNode(userDeclBlockNode.getLocation());
        scriptScope.putDecoration(
     * {@link DefBootstrap#bootstrap(PainlessLookup, FunctionTable, Map, Lookup, String, MethodType, int, int, Object...)}
    public void visitContinue(SContinue userContinueNode, ScriptScope scriptScope) {
import org.opensearch.painless.symbol.Decorations.Negate;
        irNewArrayNode.addArgumentNode(irLoadVariableNode);
        return irCastNode;
            // handles when the operation is a string concatenation
                ((StoreNode) ((BinaryImplNode) irAssignmentNode).getRightNode()).setChildNode(irValueNode);
            irBinaryImplNode.setRightNode(invokeCallNode);
                // add a compound assignment flag to the binary math node
 * Licensed to Elasticsearch under one or more contributor
            irExpressionNode = stringConcatenationNode;
import org.opensearch.painless.node.STry;
            ValueType prefixValueType = scriptScope.getDecoration(userDotNode.getPrefixNode(), ValueType.class);
    }
        scriptScope.putDecoration(userInstanceofNode, new IRNodeDecoration(irInstanceofNode));
import org.opensearch.painless.ir.FlipArrayIndexNode;
        Variable variable = scriptScope.getDecoration(userCatchNode, SemanticVariable.class).getSemanticVariable();
    @Override
import org.opensearch.painless.node.EString;
 * KIND, either express or implied.  See the License for the
import org.opensearch.painless.node.ELambda;
                    );
        DoWhileLoopNode irDoWhileLoopNode = new DoWhileLoopNode(userDoNode.getLocation());
        irFieldNode.setModifiers(Modifier.FINAL | Modifier.STATIC | Modifier.PRIVATE);
                    );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    irDupNode.setSize(MethodWriter.getType(irStoreNode.getExpressionType()).getSize());
            ).getPainlessInstanceBinding();
    public void visitNewArray(ENewArray userNewArrayNode, ScriptScope scriptScope) {
            irNode = visit(userUnaryNode.getChildNode(), scriptScope);
    public void visitFor(SFor userForNode, ScriptScope scriptScope) {
            TypedInterfaceReferenceNode typedInterfaceReferenceNode = new TypedInterfaceReferenceNode(
     */
                StoreBraceNode irStoreBraceNode = new StoreBraceNode(location);
        } else {
            if (irIndexNode != null) {
            } else if (scriptScope.hasDecoration(userDotNode, StandardPainlessField.class)) {
            irNode = irUnaryMathNode;
        irReferenceNode.setExpressionType(scriptScope.getDecoration(userFunctionRefNode, ValueType.class).getValueType());
                irInvokeCallNode.addArgumentNode(injectCast(userCallArgumentNode, scriptScope));
        scriptScope.putDecoration(userClassNode, new IRNodeDecoration(irClassNode));
import org.opensearch.painless.ir.CastNode;
