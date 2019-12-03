package lab2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import junit.framework.Assert;
import java.util.Arrays;
import lab2.Calc;

import java.io.IOException;
/** Выполняет тестирование разработанных классов.
 * @author boieva-maryna
 * @version 1.0
 */
public class MainTest {
	/** Проверка основной функциональности класса {@linkplain Calc} */
	@Test
	public void testCalc() {
		Calc calc = new Calc();
		double [] alpha=new double[4];
		Arrays.fill(alpha,0.0);
		calc.init(alpha);
		assertEquals(0, calc.getResult().getAverage());//среднее арифметическое легче проверить
		Arrays.fill(alpha,90.0);
		calc.init(alpha);
		assertEquals(1000, calc.getResult().getAverage());
		Arrays.fill(alpha,180.0);
		calc.init(alpha);
		assertEquals(0, calc.getResult().getAverage());
		Arrays.fill(alpha,270.0);
		calc.init(alpha);
		assertEquals(-1000, calc.getResult().getAverage());
		Arrays.fill(alpha,360.0);
		calc.init(alpha);
		assertEquals(0, calc.getResult().getAverage());
	}
	/** Проверка сериализации. Корректность восстановления данных. */
	@Test
	public void testRestore() {
		Calc calc = new Calc();
		double []alpha =new double[4];
		double []x =new double[4];
		int ones;
		for(int ctr = 0; ctr < 1000; ctr++) {
			for(int i=0;i<4;i++) {x[i] = Math.random() * 360.0;}
			ones = calc.init(x);
			try {
				calc.save();
			} catch (IOException e) {
				Assert.fail(e.getMessage());
			}
			for(int i=0;i<4;i++) {alpha[i] = Math.random() * 360.0;}
			calc.init(alpha);
			try {
				calc.restore();
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
			assertEquals(ones, calc.getResult().getOnes()); 
			assertArrayEquals(x, calc.getResult().getX(), .1e-10);
		}
	}
}