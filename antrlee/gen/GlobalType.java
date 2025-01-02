import java.util.HashMap;
import java.util.Map;

// 枚举类型，表示符号的类别
enum Category {
    PRIMITIVE, ARRAY, STRUCTURE, FUNCTION,ERROR
}

// 表示全局类型信息
class GlobalType {
    public Category category;
    public String primitiveType; // int, char, float 等
    public ArrayType arrayType;  // 如果是数组类型
    public FunctionType functionType; // 如果是函数类型
    public Map<String, GlobalType> structFields;

    // 基础类型构造函数
    public GlobalType(Category category, String primitiveType) {
        this.category = category;
        this.primitiveType = primitiveType;
    }

    // 数组类型构造函数
    public GlobalType(Category category, ArrayType arrayType) {
        this.category = category;
        this.arrayType = arrayType;
    }

    // 函数类型构造函数
    public GlobalType(Category category, FunctionType functionType) {
        this.category = category;
        this.functionType = functionType;
    }
    public GlobalType(Category category, Map<String, GlobalType> structFields) {
        this.category = category;
        this.structFields = structFields;
    }
}

// 数组类型
class ArrayType {
    public GlobalType baseType; // 基础类型
    public int size; // 数组大小
    public int dimension;

    public ArrayType(GlobalType baseType, int size,int dimension) {
        this.baseType = baseType;
        this.size = size;
        this.dimension=dimension;
    }
}

// 函数类型
class FunctionType {
    public GlobalType returnType; // 返回值类型
    public Map<String, GlobalType> parameters; // 参数列表（参数名 -> 类型）

    public FunctionType(GlobalType returnType, Map<String, GlobalType> parameters) {
        this.returnType = returnType;
        this.parameters = parameters;
    }
}

// 符号类
class Symbol {
    public String name; // 符号名称
    public GlobalType type; // 符号类型
    public int line; // 定义所在行号

    public Symbol(String name, GlobalType type, int line) {
        this.name = name;
        this.type = type;
        this.line = line;
    }

    public GlobalType getType() {
        return type;
    }
}

// 符号表类，仅支持全局作用域
class SymbolTable {
    private Map<String, Symbol> globalScope; // 全局作用域

    public SymbolTable() {
        globalScope = new HashMap<>();
    }

    // 在全局作用域定义符号
    public boolean define(String name, GlobalType type, int line) {
        if (globalScope.containsKey(name)) {
            System.err.println("Error type 3 at Line " + line + ": \"" + name + "\" is redefined");
            return false;
        }
        globalScope.put(name, new Symbol(name, type, line));
        return true;
    }

    // 在全局作用域查找符号
    public Symbol lookup(String name) {
        return globalScope.get(name);
    }

    public void remove(String variable) {
        if (globalScope.containsKey(variable)) {
            globalScope.remove(variable);
        } else {
            System.err.println("Warning: Attempt to remove undefined variable \"" + variable + "\".");
        }
    }
}
