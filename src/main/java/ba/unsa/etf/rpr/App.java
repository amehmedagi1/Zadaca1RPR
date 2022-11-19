package ba.unsa.etf.rpr;

/**
 * Main class that we run from console
 */
public class App {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        String s = new String();

        try {
            for (String string : args) {
                if (args.length % 2 == 0) throw new RuntimeException();
                if(string.equals(")")) s=s+string;
                else
                s = s + string + " ";
                ExpressionEvaluator ee = new ExpressionEvaluator();
                System.out.println(ee.evaluate(s));
            }
        }
        catch (RuntimeException exception) {
            System.out.println("Neispravan unos");
        }
    }
}
