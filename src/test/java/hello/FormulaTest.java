package hello;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FormulaTest {

    @Test
    public void shouldTestFormula() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula.calculate(100);     // 100.0
        formula.sqrt(16);           // 4.0

        assertThat(formula.sqrt(16)).isEqualTo(4.0);
    }

    @Test
    public void shouldTestLamdaExpression() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

    @Test
    public void shouldPassMethodAsParam() {
        Something s = new Something();
        Converter<String, String> converter = s::startsWith;

        assertThat(converter.convert("Java")).isEqualTo("J");
    }

    class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }
}
