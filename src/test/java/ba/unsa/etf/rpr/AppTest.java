package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * class that tests our program for evaluating expressions
 * @author Admir Mehmedagić
 * @version 1.0
 */
public class AppTest {

    @Test
    public void AdditionTest () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( 2 + ( 3 + 5 ) )"), 10.0);
    }

    @Test
    public void SubstractionTest () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( 2 - ( 9 - 3 ) )"), -4);
    }

    @Test
    public void MultiplicationTest () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( ( 8 * 7 ) * 2 )"), 112);
    }

    @Test
    public void DivisionTest () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( ( 50 / 5 ) / 5 )"), 2);
    }

    @Test
    public void SqrtTest () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( sqrt 1296 )"), 36);
    }

    @Test
    public void ComboTest1 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( 3 + ( 2 * ( 4 - 1 ) ) + ( sqrt ( 9 ) ) )"), 12);
    }


    @Test
    public void ComboTest2 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertEquals(ex.evaluate("( 1 + ( 2 + ( 3 * ( 2 + ( 1 - ( 5 - 8 ) ) ) ) ) )"), 21);
    }

    @Test
    public void ExceptionTest1 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> ex.evaluate (" ( 1 + 9 - 2 )"));
    }

    @Test
    public void ExceptionTest2 () {
        ExpressionEvaluator ex = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> ex.evaluate ("( 1 - 2 ! )"));
    }

}
