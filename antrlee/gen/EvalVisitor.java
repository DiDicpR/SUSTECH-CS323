//import gen.splBaseVisitor;
//import org.antlr.v4.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.tree.TerminalNode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//
//public class EvalVisitor extends splBaseVisitor<Void> {
//    SymbolTable symbolTable =new SymbolTable();
//    private static ArrayList<String> var=new ArrayList<>();
//    @Override
//    public Void visitProgram(splParser.ProgramContext ctx) {
//        return super.visitProgram(ctx);
//    }
//
//    @Override public Void visitExtDefList(splParser.ExtDefListContext ctx) {
//        return super.visitExtDefList(ctx);
//    }
//
//
//    @Override
//    public Void visitExtDef(splParser.ExtDefContext ctx) {
//        var.clear();
//        GlobalType specType = parseSpecifier(ctx.specifier());
//        if (ctx.extDecList() != null) { // Specifier ExtDecList SEMI
//            parseExtDecList(ctx.extDecList(), specType);
//        } else if (ctx.funDec() != null) { // Specifier FunDec CompSt
//
//            GlobalType funType = parseFunDec(ctx.funDec(), specType);
//            if (funType != null) {
//                String funcName = ctx.funDec().ID().getText();
//                if (symbolTable.lookup(funcName) != null) {
//                    System.err.printf("Error type 4 at Line %d: \"%s\" is redefined%n",
//                            ctx.getStart().getLine(), funcName);
//                    parseCompSt(ctx.compSt(),specType);
//
//                } else {
//                    symbolTable.define(funcName, funType, ctx.getStart().getLine());
//                    parseCompSt(ctx.compSt(),specType);
//                }
//            }
//
//        }
//        for (String variable : var) {
//            if (symbolTable.lookup(variable) != null) {
//                symbolTable.remove(variable);
//            }
//        }
//        return null;
//    }
//
//
//    private GlobalType parseFunDec(splParser.FunDecContext funDecContext, GlobalType specType) {
//
//        // 创建函数类型参数列表
//        Map<String, GlobalType> parameters = new HashMap<>();
//
//        // 检查是否有参数列表
//        if (funDecContext.varList() != null) {
//            parseVarList(funDecContext.varList(), parameters);
//        }
//
//        // 创建函数类型
//        FunctionType functionType = new FunctionType(specType, parameters);
//
//        // 返回函数类型的 GlobalType
//        return new GlobalType(Category.FUNCTION, functionType);
//    }
//    private void parseVarList(splParser.VarListContext varListContext, Map<String, GlobalType> parameters) {
//        // VarList:
//        //     ParamDec COMMA VarList
//        //   | ParamDec
//
//        // 获取当前参数声明
//        parseParamDec(varListContext.paramDec(), parameters);
//
//        // 如果还有更多参数（有 COMMA）
//        if (varListContext.COMMA() != null && varListContext.varList() != null) {
//            parseVarList(varListContext.varList(), parameters);
//        }
//    }
//    private void parseParamDec(splParser.ParamDecContext paramDecContext, Map<String, GlobalType> parameters) {
//        // ParamDec:
//        //     Specifier VarDec
//
//        // 解析 Specifier
//        GlobalType specifierType = parseSpecifier(paramDecContext.specifier());
//
//        // 如果 Specifier 有效，则解析 VarDec
//        if (specifierType != null) {
//            String paramName = parseVarDec(paramDecContext.varDec(), specifierType);
//            if (paramName != null) {
//                // 将参数名称和类型加入参数列表
//                parameters.put(paramName, specifierType);
//            }
//        }
//    }
//
//    private String parseVarDec(splParser.VarDecContext varDecContext, GlobalType globalType) {
//        // VarDec:
//        //     ID
//        //   | VarDec LB INT RB
//
//        GlobalType lastType = globalType;
//        int dimension=1;
//        // 循环处理数组声明
//        while (varDecContext.varDec() != null && varDecContext.LB() != null && varDecContext.RB() != null) {
//            // 获取数组大小
//            int arraySize = Integer.parseInt(varDecContext.INT().getText());
//
//            // 创建新数组类型
//            ArrayType arrayType = new ArrayType(lastType, arraySize,dimension);
//            lastType = new GlobalType(Category.ARRAY, arrayType);
//
//            // 进入下一层 VarDec
//            varDecContext = varDecContext.varDec();
//            dimension++;
//        }
//
//        // 最终应该是一个 ID
//        if (varDecContext.ID() != null) {
//            String id = varDecContext.ID().getText();
//            int lineNum = varDecContext.ID().getSymbol().getLine();  // 获取行号
//            // 检查符号表中是否已经存在
//            if (symbolTable.lookup(id) != null) {
//                System.err.println("Error type 3 at Line " + lineNum + ": \"" + id + "\" is redefined");
//            } else {
//                // 添加到符号表
//                symbolTable.define(id, lastType, varDecContext.ID().getSymbol().getLine());
//                var.add(id);
//            }
//
//            // 返回变量名
//            return id;
//        }
//
//        return null;
//    }
//
//
//
//    private void parseExtDecList(splParser.ExtDecListContext extDecListContext, GlobalType specType) {
//        splParser.VarDecContext varDecContext = extDecListContext.varDec();
//        parseVarDec(varDecContext, specType);
//
//        // 检查是否还有后续的 ExtDecList
//        if (extDecListContext.COMMA() != null && extDecListContext.extDecList() != null) {
//            // 递归处理后续的 ExtDecList
//            parseExtDecList(extDecListContext.extDecList(), specType);
//        }
//    }
//
//
//
//    private GlobalType parseSpecifier(splParser.SpecifierContext specifier) {
//        // Specifier:
//        // TYPE | StructSpecifier
//
//        GlobalType globalType = null;
//
//        if (specifier.TYPE() != null) {
//            // 如果是基本类型（int, float, char）
//            String typeName = specifier.TYPE().getText();
//            switch (typeName) {
//                case "int":
//                    globalType = new GlobalType(Category.PRIMITIVE, "INT");
//                    break;
//                case "float":
//                    globalType =  new GlobalType(Category.PRIMITIVE, "FLOAT");
//                    break;
//                case "char":
//                    globalType = new GlobalType(Category.PRIMITIVE, "CHAR");
//                    break;
//                default:
//                    throw new IllegalArgumentException("Unsupported type: " + typeName);
//            }
//        } else if (specifier.structSpecifier() != null) {
//            // 如果是结构体类型
//            splParser.StructSpecifierContext structSpecifier = specifier.structSpecifier();
//            globalType = parseStructSpecifier(structSpecifier);
//
//        }
//
//        return globalType;
//    }
//    // 解析 StructSpecifier
//    private GlobalType parseStructSpecifier(splParser.StructSpecifierContext structSpecifier) {
//        // StructSpecifier:
//        // STRUCT ID | STRUCT ID LC DefList RC
//        String structName = structSpecifier.ID().getText();
//        if (structSpecifier.ID() != null && structSpecifier.defList() == null) {
//
//
//            // 如果是结构体的直接引用
//            Symbol structSymbol = symbolTable.lookup(structName);
//            if (structSymbol == null) {
//                System.err.println("Error: Undefined structure \"" + structName + "\"");
//                return  new GlobalType(Category.ERROR, (String) null);
//            }
//            if (structSymbol.type.category != Category.STRUCTURE) {
//                System.err.println("Error: \"" + structName + "\" is not a structure");
//                return null;
//            }
//            return structSymbol.type;
//        } else if (structSpecifier.LC() != null && structSpecifier.defList() != null && structSpecifier.RC() != null) {
//
//            // 定义新的结构体
//            Map<String, GlobalType> structFields = parseDefList(structSpecifier.defList());
//            GlobalType temp=new GlobalType(Category.STRUCTURE, structFields);
//            if (symbolTable.lookup(structName)!=null){
//                System.err.println("Error type 15 at Line " + structSpecifier.start.getLine() + ": " +  "redefine the same structure type");
//            }else {
//            symbolTable.define(structName, temp,structSpecifier.start.getLine());}
//            return temp;
//        }
//
//        return null;
//    }
//    // 解析 DefList
//    private Map<String, GlobalType> parseDefList(splParser.DefListContext defList) {
//        // DefList:
//        //     Def DefList | 空
//        Map<String, GlobalType> fields = new HashMap<>();
//        while (defList != null && defList.def() != null) {
//            parseDef(defList.def(), fields);
//            defList = defList.defList(); // 递归处理下一条定义
//        }
//        return fields;
//    }
//    // 解析单个 Def
//    private void parseDef(splParser.DefContext def, Map<String, GlobalType> fields) {
//        // Def:
//        //     Specifier DecList SEMI
//        GlobalType specifierType = parseSpecifier(def.specifier());
//        splParser.DecListContext decList = def.decList();
//        parseDecList(decList, specifierType, fields);
//    }
//    private void parseDecList(splParser.DecListContext decList, GlobalType specifierType, Map<String, GlobalType> fields) {
//        // DecList:
//        //     Dec | Dec COMMA DecList
//        while (decList != null && decList.dec() != null) {
//            parseDec(decList.dec(), specifierType, fields);
//            decList = decList.decList(); // 递归处理下一条声明
//        }
//    }
//
//    // 解析 Dec
//    private void parseDec(splParser.DecContext dec, GlobalType specifierType, Map<String, GlobalType> fields) {
//        // Dec:
//        //     VarDec | VarDec ASSIGN Exp
//        splParser.VarDecContext varDec = dec.varDec();
//
//        // 解析变量名
//        String varName = parseVarDec(varDec, specifierType);
//        fields.put(varName,specifierType);
//
//        // 检查初始化表达式
//        if (dec.ASSIGN() != null && dec.exp() != null) {
//            GlobalType expType = parseExp(dec.exp());
//            if (!sameType(specifierType, expType)&&(specifierType!=null&&expType!=null&&!(specifierType.primitiveType.equals("FLOAT")&&expType.primitiveType.equals("INT")))) {
//                System.err.println("Error: Type mismatch in assignment to \"" + varName + "\"");
//            }
//        }
//    }
//
//    private GlobalType parseExp(splParser.ExpContext exp) {
//        GlobalType globalType = null;
//
//        // Handle cases based on the number of child nodes in the expression
//        if (exp.getChildCount() == 1) { // ID | CHAR | FLOAT | INT
//            ParseTree node1 = exp.getChild(0);
//
//            if (node1 instanceof TerminalNode) {
//                TerminalNode terminalNode = (TerminalNode) node1;
//
//                // Check if it's an identifier
//                if (terminalNode.getSymbol().getType() == splParser.ID) {
//                    String varName = terminalNode.getText();
//                    Symbol symbol = symbolTable.lookup(varName);
//                    if (symbol == null) {
//                        System.err.println("Error type 1 at Line " + terminalNode.getSymbol().getLine() + ": \"" + varName + "\" is used without a definition.");
//                        globalType = new GlobalType(Category.ERROR, (String) null);
//                    }
//                    else {
//                        globalType = symbol.getType();
//                    }
//                } else { // CHAR | FLOAT | INT
//                    int tokenType = terminalNode.getSymbol().getType();
//                    switch (tokenType) {
//                        case splParser.CHAR:
//                            globalType = new GlobalType(Category.PRIMITIVE, "CHAR");
//                            break;
//                        case splParser.FLOAT:
//                            globalType = new GlobalType(Category.PRIMITIVE, "FLOAT");
//                            break;
//                        case splParser.INT:
//                            globalType = new GlobalType(Category.PRIMITIVE, "INT");
//                            break;
//                        default:
//                            System.err.println("Error: Unsupported primitive type at Line " + terminalNode.getSymbol().getLine());
//                            globalType = null; // Set to null for unsupported types
//                            break;
//                    }
//                }
//            }
//        } else if (exp.getChildCount() == 2) { // NOT Exp | MINUS Exp
//            ParseTree node1 = exp.getChild(0);
//            ParseTree node2 = exp.getChild(1);
//            GlobalType expType = parseExp((splParser.ExpContext) node2);
//
//            if (node1.getText().equals("!")) {
//                if (!(expType.category == Category.PRIMITIVE && expType.primitiveType .equals("INT"))) {
//                    System.err.println("Error type 7 at Line " + ((splParser.ExpContext) node2).start.getLine() + ": Invalid operand for NOT.");
//                } else {
//                    globalType = expType;
//                }
//            } else if (node1.getText().equals("-")) {
//                if (expType.category != Category.PRIMITIVE || expType.primitiveType .equals("CHAR")) {
//                    System.err.println("Error type 7 at Line " + ((splParser.ExpContext) node2).start.getLine() + ": Invalid operand for MINUS.");
//                } else {
//                    globalType = expType;
//                }
//            }
//        } else if (exp.getChildCount() == 3) {
//            ParseTree node1 = exp.getChild(0);
//            ParseTree node2 = exp.getChild(1);
//            ParseTree node3 = exp.getChild(2);
//
//            if (node2.getText().equals("=")) { // Exp ASSIGN Exp
//                globalType = checkAssign(node1, node2, node3);
//            } else if (node2.getText().equals("&&") || node2.getText().equals("||")) { // Exp AND Exp | Exp OR Exp
//                GlobalType exp1Type = parseExp((splParser.ExpContext) node1);
//                GlobalType exp2Type = parseExp((splParser.ExpContext) node3);
//
//                if (!sameType(exp1Type, exp2Type) || !(exp1Type.category == Category.PRIMITIVE && "INT".equals(exp1Type.primitiveType))) {
//                    System.err.println("Error type 7 at Line " + ((splParser.ExpContext) node3).start.getLine() + ": Type mismatch in logical operation.");
//                } else {
//                    globalType = exp1Type;
//                }
//            } else if (node2.getText().equals("<") || node2.getText().equals("<=") || node2.getText().equals(">") ||
//                    node2.getText().equals(">=") || node2.getText().equals("!=") || node2.getText().equals("==") ||
//                    node2.getText().equals("+") || node2.getText().equals("-") || node2.getText().equals("*") ||
//                    node2.getText().equals("/")) { // Comparison and arithmetic operations
//                GlobalType exp1Type = parseExp((splParser.ExpContext) node1);
//                GlobalType exp2Type = parseExp((splParser.ExpContext) node3);
//
//
//                if (!sameType(exp1Type, exp2Type) || exp1Type.category != Category.PRIMITIVE) {
//                    System.err.println("Error type 7 at Line " + ((splParser.ExpContext) node1).start.getLine()
//                            + ": unmatching operands.");
//                } else {
//                    globalType = exp1Type;
//                }
//            } else if (node2.getText().equals(".")) { // Exp DOT ID
//                GlobalType exp1Type = parseExp((splParser.ExpContext) node1);
//                if (exp1Type.category==Category.ERROR){
//                    return null;
//                }
//                if (exp1Type.category != Category.STRUCTURE) {
//                    System.err.println("Error type 13 at Line " + ((splParser.ExpContext) node1).start.getLine() + ": accessing with non-struct variable.");
//                } else {
//                    String memberId = node3.getText();
//
//                    // 检查 structFields 中是否有指定的字段
//                    if (exp1Type.structFields == null || !exp1Type.structFields.containsKey(memberId)) {
//                        System.err.println("Error type 14 at Line " + ((splParser.ExpContext) node1).start.getLine() + ":unmatching types appear at both sides of the assignment operator");
//                    } else {
//                        // 获取成员的类型
//                        globalType = exp1Type.structFields.get(memberId);
//                    }
//                }
//            } else if (node1.getText().equals("(")) { // LP Exp RP
//                globalType = parseExp((splParser.ExpContext) node2);
//            } else if (node1 instanceof TerminalNode && ((TerminalNode) node1).getSymbol().getType() == splParser.ID) { // Function call
//                String funcName = node1.getText();
//                Symbol symbol = symbolTable.lookup(funcName);
//                if (symbol== null) {
//                    System.err.println("Error type 2 at Line " + exp.start.getLine() + ": \"" + funcName + "\" is invoked without a definition.");
//
//                } else if (symbol.type.category != Category.FUNCTION) {
//                    System.err.println("Error type 11 at Line " + exp.start.getLine() + ": invoking non-function variable.");
//                } else {
//
//                    FunctionType functionType = symbol.type.functionType;
//                    Map<String, GlobalType> paramTypes = functionType.parameters;
//                    int expectedArgsCount = paramTypes.size();
//                    if (expectedArgsCount != 0) {
//                        System.err.println("Error type 9 at Line " + exp.start.getLine() + ": invalid argument number, expected " + expectedArgsCount + ", got " + 0 + ".");
//                    }
//                    globalType = symbol.type;
//                }
//            }
//        } else if (exp.getChildCount() == 4) { // ID LP Args RP | Exp LB Exp RB
//            ParseTree node1 = exp.getChild(0);
//            ParseTree node2 = exp.getChild(1);
//            ParseTree node3 = exp.getChild(2);
//            ParseTree node4 = exp.getChild(3);
//
//            if (node1 instanceof TerminalNode && ((TerminalNode) node1).getSymbol().getType() == splParser.ID) { // Function call
//                String funcName = node1.getText();
//                Symbol symbol = symbolTable.lookup(funcName);
//                if (symbol == null) {
//                    System.err.println("Error type 2 at Line " + exp.start.getLine() + ": \"" + funcName + "\" is invoked without a definition.");
//                    globalType = new GlobalType(Category.ERROR, (String) null);
//                } else if (symbol.type.category != Category.FUNCTION) {
//                    System.err.println("Error type 11 at Line " + exp.start.getLine() + ": \"" + funcName + "\" is not a function.");
//                } else {
//                    globalType = checkArgs((splParser.ArgsContext) node3, symbol.type, node1);
//                }
//            } else if (node2.getText().equals("[")) { // Exp LB Exp RB
//                GlobalType exp1Type = parseExp((splParser.ExpContext) node1);
//                GlobalType exp2Type = parseExp((splParser.ExpContext) node3);
//
//                if (exp1Type.category != Category.ARRAY) {
//                    System.err.println("Error type 10 at Line " + ((splParser.ExpContext) node1).start.getLine() + ": Indexing non-array type.");
//                    globalType=new GlobalType(Category.ERROR, (String) null);
//                } else if (!(exp2Type.category == Category.PRIMITIVE && "INT".equals(exp2Type.primitiveType))) {
//                    System.err.println("Error type 12 at Line " + ((splParser.ExpContext) node3).start.getLine() + ": indexing by non-integer.");
//                    globalType=new GlobalType(Category.ERROR, (String) null);
//                } else {
//                    globalType = exp1Type.arrayType.baseType;
//                }
//            }
//        }
//
//        return globalType;
//    }
//
//    private GlobalType checkArgs(splParser.ArgsContext node3, GlobalType funcType, ParseTree idNode) {
//        // 确保 idNode 是 splParser.ExpContext 类型或至少能安全获取行号
//        int lineNumber = idNode instanceof splParser.ExpContext
//                ? ((splParser.ExpContext) idNode).start.getLine()
//                : (idNode instanceof TerminalNode ? ((TerminalNode) idNode).getSymbol().getLine() : -1);
//
//        // 检查类型是否为函数类型
//        if (funcType.category != Category.FUNCTION) {
//            System.err.println("Error type 11 at Line " + lineNumber + ": \"" + idNode.getText() + "\" is not a function.");
//            return new GlobalType(Category.ERROR, (String) null);
//        }
//
//        // 获取函数类型中的参数和返回值类型
//        FunctionType functionType = funcType.functionType;
//        Map<String, GlobalType> paramTypes = functionType.parameters;
//        GlobalType returnType = functionType.returnType;
//        int expectedArgsCount = paramTypes.size(); // 函数定义中的参数数量
//        int actualArgsCount = 0; // 调用时实际提供的参数数量
//
//        // 遍历参数，统计实际参数数量
//        splParser.ArgsContext currentArg = node3;
//        while (currentArg != null) {
//            actualArgsCount++;
//            currentArg = currentArg.args();
//        }
//
//        // 如果参数数量不匹配，直接输出错误消息
//        if (expectedArgsCount != actualArgsCount) {
//            System.err.println("Error type 9 at Line " + lineNumber + ": invalid argument number, expected " + expectedArgsCount + ", got " + actualArgsCount + ".");
//            return new GlobalType(Category.ERROR, (String) null);
//        }
//
//        // 遍历并检查每个参数类型
//        currentArg = node3;
//        int paramIndex = 0;
//        for (String paramName : paramTypes.keySet()) {
//            splParser.ExpContext exp = currentArg.exp();
//            GlobalType expType = parseExp(exp);
//
//            // 检查类型匹配
//            if (!sameType(expType, paramTypes.get(paramName))) {
//                System.err.println("Error type 9 at Line " + exp.start.getLine() + ": Type mismatch for parameter \"" + paramName + "\" in function \"" + idNode.getText() + "\".");
//                return new GlobalType(Category.ERROR, (String) null);
//            }
//
//            currentArg = currentArg.args();
//            paramIndex++;
//        }
//
//        // 参数匹配成功，返回函数的返回值类型
//        return returnType;
//    }
//
//
//    private GlobalType checkAssign(ParseTree node1, ParseTree node2, ParseTree node3) {
//        // Parse the left-hand side (LHS) and right-hand side (RHS) expressions
//        GlobalType exp1Type = parseExp((splParser.ExpContext) node1);
//        GlobalType exp2Type = parseExp((splParser.ExpContext) node3);
//
//        // A flag to check if the left-hand side is a valid lvalue
//        boolean isValidLValue = false;
//
//
//        // Get the line number of the assignment statement
//        int lineNumber = ((splParser.ExpContext) node1).start.getLine();
//
//        // Check the structure of the LHS expression to determine if it's a valid lvalue
//        switch (node1.getChildCount()) {
//            case 1: {
//                // Case: Variable (simple identifier)
//                ParseTree child = node1.getChild(0);
//                if (child instanceof TerminalNode) {
//                    TerminalNode terminalNode = (TerminalNode) child;
//                    // Check if the terminal node is an identifier
//                    if (terminalNode.getSymbol().getType() == splParser.ID) {
//                        isValidLValue = true;  // It's a valid lvalue (simple variable)
//                    }
//                }
//                break;
//            }
//            case 3: {
//                // Case: Exp DOT ID (structure member access)
//                if (node1.getChild(0) instanceof splParser.ExpContext &&
//                        node1.getChild(1).getText().equals(".") &&
//                        node1.getChild(2) instanceof TerminalNode) {
//                    TerminalNode idNode = (TerminalNode) node1.getChild(2);
//                    // Check if the last child is an identifier (struct member)
//                    if (idNode.getSymbol().getType() == splParser.ID) {
//                        isValidLValue = true;  // It's a valid lvalue (member of structure)
//                    }
//                }
//                break;
//            }
//            case 4: {
//                // Case: Exp LB Exp RB (array element access)
//                if (node1.getChild(0) instanceof splParser.ExpContext &&
//                        node1.getChild(1).getText().equals("[") &&
//                        node1.getChild(2) instanceof splParser.ExpContext &&
//                        node1.getChild(3).getText().equals("]")) {
//                    isValidLValue = true;  // It's a valid lvalue (array element)
//                }
//                break;
//            }
//            default:
//                // Invalid lvalue (not a variable, struct member, or array element)
//                break;
//        }
//
//        // If the left-hand side is not a valid lvalue, throw an error
//        if (!isValidLValue) {
//            System.err.println("Error type 6 at Line " + lineNumber + ": rvalue appears on the left-side of assignment.");
//            return new GlobalType(Category.ERROR, (String) null);
//        }
//
//        // Check if the types of the left-hand side and right-hand side match
//        if (!sameType(exp1Type, exp2Type)&&(exp1Type!=null&&exp2Type!=null&&!(exp1Type.primitiveType.equals("FLOAT")&&exp2Type.primitiveType.equals("INT")))) {
//            System.err.println("Error type 5 at Line " + lineNumber + ": unmatching type on both sides of assignment.");
//            return new GlobalType(Category.ERROR, (String) null);
//        }
//
//        // If everything is correct, return the type of the left-hand side expression (exp1Type)
//        return exp1Type;
//    }
//
//
//    public static boolean sameType(GlobalType type1, GlobalType type2) {
//        if (type1 == null || type2 == null) {
//            return false;
//        }
//        if (type1.category == Category.ERROR || type2.category == Category.ERROR) {
//            return true;
//        }
//        // 比较类别
//        if (type1.category == type2.category) {
//            // 如果是基本类型
//            if (type1.category == Category.PRIMITIVE && type1.primitiveType.equals(type2.primitiveType)) {
//                return true;
//            }
//            // 如果是数组类型
//            else if (type1.category == Category.ARRAY) {
//                if (type1.arrayType != null && type2.arrayType != null) {
//                    return sameType(type1.arrayType.baseType, type2.arrayType.baseType) &&
//                            type1.arrayType.size == type2.arrayType.size;
//                }
//                return false;
//            }
//            // 如果是结构体类型
//            else if (type1.category == Category.STRUCTURE) {
//                if (type1.structFields != null && type2.structFields != null) {
//                    if (type1.structFields.size() != type2.structFields.size()) {
//                        return false;
//                    }
//                    for (String field : type1.structFields.keySet()) {
//                        if (!type2.structFields.containsKey(field) ||
//                                !sameType(type1.structFields.get(field), type2.structFields.get(field))) {
//                            return false;
//                        }
//                    }
//                    return true;
//                }
//                return false;
//            }
//            // 如果是函数类型
//            else if (type1.category == Category.FUNCTION) {
//                if (type1.functionType != null && type2.functionType != null) {
//                    // 检查返回类型
//                    if (!sameType(type1.functionType.returnType, type2.functionType.returnType)) {
//                        return false;
//                    }
//                    // 检查参数列表
//                    Map<String, GlobalType> params1 = type1.functionType.parameters;
//                    Map<String, GlobalType> params2 = type2.functionType.parameters;
//                    if (params1.size() != params2.size()) {
//                        return false;
//                    }
//                    for (String paramName : params1.keySet()) {
//                        if (!params2.containsKey(paramName) ||
//                                !sameType(params1.get(paramName), params2.get(paramName))) {
//                            return false;
//                        }
//                    }
//                    return true;
//                }
//                return false;
//            }
//        }
//
//        // 类别不同
//        return false;
//    }
//
//    private void parseCompSt(splParser.CompStContext compStContext, GlobalType specType) {
//        //compSt      : LC defList stmtList RC
//
//        parseDefList(compStContext.defList());
//        parseStmtList(compStContext.stmtList(),specType);
//
//
//    }
//
//    private void parseStmtList(splParser.StmtListContext stmtListContext, GlobalType specType) {
//        //stmtList    : stmt stmtList
//        //            | /* empty */
//        //            ;
//        if (stmtListContext == null || stmtListContext.getChildCount() == 0) {
//            // Base case: the stmtList is empty
//            return;
//        }
//        parseStmt(stmtListContext.stmt(),specType);
//        parseStmtList(stmtListContext.stmtList(),specType);
//    }
//
//    private void parseStmt(splParser.StmtContext stmt, GlobalType specType) {
//        // Stmt:
//        // DEBUG_INFO;
//
//        // Retrieve the first child (which determines the type of statement)
//        if (stmt == null || stmt.getChildCount() == 0) {
//            return; // If stmt is empty, return
//        }
//
//        // Extract the first child to determine the statement type
//        ParseTree node1 = stmt.getChild(0);
//
//        if (node1 instanceof splParser.ExpContext) { // Exp SEMI
//            // Handle Exp statement
//            splParser.ExpContext exp = (splParser.ExpContext) node1;
//            parseExp(exp);  // Parse the expression
//        } else if (node1 instanceof splParser.CompStContext) { // CompSt
//
//            parseCompSt((splParser.CompStContext) node1, specType);  // Parse the compound statement
//        } else if (node1.getText().equals("return")) { // RETURN Exp SEMI
//
//            splParser.ExpContext exp = (splParser.ExpContext) stmt.getChild(1);
//            GlobalType expType = parseExp(exp);
//            if (expType.category==Category.FUNCTION){
//                if (!expType.functionType.returnType.primitiveType.equals(specType.primitiveType)){
//                    System.err.println("Error type 8 at Line " + stmt.start.getLine() + ": Incompatible return type.");
//                }
//            }else if (expType != null && !sameType(specType, expType)) {
//                System.err.println("Error type 8 at Line " + stmt.start.getLine() + ": Incompatible return type.");
//
//            }
//        } else if (node1.getText().equals("if")) { // IF LP Exp RP Stmt
//            // Handle if statement
//            splParser.ExpContext exp = (splParser.ExpContext) stmt.getChild(2);
//            GlobalType expType = parseExp(exp);
//            if (expType != null && expType.category == Category.PRIMITIVE && Objects.equals(expType.primitiveType, "INT")) {
//                splParser.StmtContext stmt1 = (splParser.StmtContext) stmt.getChild(4);
//                parseStmt(stmt1, specType); // Parse the "then" part of the if statement
//
//                if (stmt.ELSE()!=null) { // IF LP Exp RP Stmt ELSE Stmt
//                    splParser.StmtContext stmt2 = (splParser.StmtContext) stmt.getChild(6);
//                    parseStmt(stmt2, specType); // Parse the "else" part of the if statement
//                }
//            } else {
//                System.err.println("MY_ERROR_TYPE.UNMATCH_OPERAND");
//            }
//        } else if (node1.getText().equals("while")) { // WHILE LP Exp RP Stmt
//            // Handle while loop statement
//            splParser.ExpContext exp = (splParser.ExpContext) stmt.getChild(2);
//            GlobalType expType = parseExp(exp);
//            if (expType != null && expType.category == Category.PRIMITIVE && Objects.equals(expType.primitiveType, "INT")) {
//                splParser.StmtContext stmt1 = (splParser.StmtContext) stmt.getChild(4);
//                parseStmt(stmt1, specType); // Parse the statement inside the while loop
//            } else {
//                System.err.println("MY_ERROR_TYPE.UNMATCH_OPERAND");
//
//            }
//        }
//
//    }
//
//
//
//}
