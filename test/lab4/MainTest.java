package lab4;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import lab2.Item;
/** Выполняет тестирование
 * разработанных классов.
 * @author boieva-maryna
 * @version 3.0
 */
public class MainTest {
	/** Проверка основной функциональности класса {@linkplain ViewTable} */
	@Test
	public void testCalc() {
		ViewTable tbl = new ViewTable(10, 5);
		assertEquals(10, tbl.getWidth());
		assertEquals(5, tbl.getItems().size());
		tbl.init(40, 90.0);
		Item item = new Item();
		double [] x= {90.0,180.0,270.0,360.0};
		double [] y= {1000.0,0.0,-1000.0,0.0};
		int ctr = 0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
				tbl.getItems().get(ctr).equals(item)); 
		ctr++;
		x[0]=450.0;
		x[1]=540.0;
		x[2]=630.0;
		x[3]=720.0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
				tbl.getItems().get(ctr).equals(item));
		ctr++;
		x[0]=810.0;
		x[1]=900.0;
		x[2]=990.0;
		x[3]=1080.0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
				tbl.getItems().get(ctr).equals(item));
		ctr++;
		x[0]=1170.0;
		x[1]=1260.0;
		x[2]=1350.0;
		x[3]=1440.0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
				tbl.getItems().get(ctr).equals(item));
		ctr++;
		x[0]=1530.0;
		x[1]=1620.0;
		x[2]=1710.0;
		x[3]=1800.0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
				tbl.getItems().get(ctr).equals(item));
	}
	/** Проверка сериализации. Корректность восстановления данных. */
	@Test
	public void testRestore() {
		ViewTable tbl1 = new ViewTable(10, 1000);
		ViewTable tbl2 = new ViewTable();
		// Вычислим значение функции со случайным шагом приращения аргумента
		tbl1.init(30, Math.random()*100.0);
		// Сохраним коллекцию tbl1.items
		try {
			tbl1.viewSave();
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		// Загрузим коллекцию tbl2.items
		try {
			tbl2.viewRestore();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		// Должны загрузить столько же элементов, сколько сохранили
		assertEquals(tbl1.getItems().size(), tbl2.getItems().size());
		// Причем эти элементы должны быть равны.
		// Для этого нужно определить метод equals
		assertTrue("containsAll()", tbl1.getItems().containsAll(tbl2.getItems()));
	}
}