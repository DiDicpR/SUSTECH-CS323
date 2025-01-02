
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class main {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\SUSTech\\Fall 2024\\Compilers\\SUSTECH-CS323\\antrlee\\gen\\phase3\\test_3_r01.spl"); // or System.in;
        ANTLRInputStream input = new ANTLRInputStream(is);
        splLexer lexer = new splLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        splParser parser = new splParser(tokens);
        ParseTree tree = parser.program(); // calc is the starting rule

        // Redirect output to a file
        PrintStream fileOut = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(fileOut);

//        System.out.println("语义检查");
//        EvalVisitor eval = new EvalVisitor();
        // 开始遍历语法分析树
//        eval.visit(tree);
        CreateTAC tac = new CreateTAC();
        tac.visit(tree);

        // Close the file output stream
        fileOut.close();
    }
}
