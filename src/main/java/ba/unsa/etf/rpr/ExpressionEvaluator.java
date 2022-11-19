package ba.unsa.etf.rpr;
import java.util.Stack;



public class ExpressionEvaluator {
    private final Stack<Double> vals = new Stack<>();
    private final Stack<String> ops = new Stack<>();

    /**
     * Method that checks whether a string is made up of digits
     * @param str (String)
     * @return boolean
     */
    private boolean isDigit (String str) {
        if (str == null) return false;
        try {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException exc) {
            return false;
        }
    }

    /**
     * method that uses two stack Dijkstra's algorithm to evaluate the value
     * @param str (String)
     * @return Double
     */
    public Double evaluate(String str) {
        String[] strings = str.split(" ");
        for (String string : strings) {
            if (!isDigit(string) && !string.equals("(") && !string.equals("+") && !string.equals("*") && !string.equals("-") && !string.equals("/") && !string.equals("sqrt") && !string.equals(")")) {
                throw new RuntimeException();
            }
            if (string.equals("("));
            else if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/") || string.equals("sqrt")) {
                ops.push(string);
            } else if (string.equals(")")) {
                String operator = ops.pop();
                Double value = vals.pop();
                if (operator.equals("+")) value += vals.pop();
                else if (operator.equals("-")) value = vals.pop() - value;
                else if (operator.equals("*")) value *= vals.pop();
                else if (operator.equals("/")) value = vals.pop() / value;
                else if (operator.equals("sqrt")) value = Math.sqrt(value);
                vals.push(value);
            } else {
                vals.push(Double.parseDouble(string));
            }
        }
        if(!ops.isEmpty()) throw new RuntimeException();
        return vals.pop();
    }
}