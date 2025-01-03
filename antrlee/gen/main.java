
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
        InputStream is = new FileInputStream("C:\\Users\\aoxiangxueyuan\\PycharmProjects\\git\\SUSTECH-CS323\\antrlee\\gen\\phase3\\test_3_r05.spl"); // or System.in;
        ANTLRInputStream input = new ANTLRInputStream(is);
        splLexer lexer = new splLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        splParser parser = new splParser(tokens);
        ParseTree tree = parser.program(); // calc is the starting rule.


        CreateTAC tac = new CreateTAC();
        tac.visit(tree);


    }
}
