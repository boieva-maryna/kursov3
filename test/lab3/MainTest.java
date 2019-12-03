package lab3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import java.util.Arrays;

import lab2.Item;
/** ��������� ������������
 * ������������� �������.
 * @author boieva-maryna
 * @version 2.0
 */
public class MainTest {
	/** �������� �������� ���������������� ������ {@linkplain ViewResult} */
	@Test
	public void testCalc() {
		ViewResult view = new ViewResult(5);
		double [] x= {90.0,180.0,270.0,360.0};
		double [] y= {1000.0,0.0,-1000.0,0.0};
		view.init(90.0);
		Item item = new Item();
		int ctr = 0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
				view.getItems().get(ctr).equals(item));
		ctr++;
		x[0]=450.0;
		x[1]=540.0;
		x[2]=630.0;
		x[3]=720.0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
				view.getItems().get(ctr).equals(item));
		ctr++;
		x[0]=810.0;
		x[1]=900.0;
		x[2]=990.0;
		x[3]=1080.0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
				view.getItems().get(ctr).equals(item));
		ctr++;
		x[0]=1170.0;
		x[1]=1260.0;
		x[2]=1350.0;
		x[3]=1440.0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
				view.getItems().get(ctr).equals(item));
		ctr++;
		x[0]=1530.0;
		x[1]=1620.0;
		x[2]=1710.0;
		x[3]=1800.0;
		item.setXY(x, y);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
				view.getItems().get(ctr).equals(item));
	}
	/** �������� ������������. ������������ �������������� ������. */
	@Test
	public void testRestore() {
		ViewResult view1 = new ViewResult(1000);
		ViewResult view2 = new ViewResult();
		// �������� �������� ������� �� ��������� ����� ���������� ���������
		view1.init(Math.random()*100.0);
		// �������� ��������� view1.items
		try {
			view1.viewSave();
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		// �������� ��������� view2.items
		try {
			view2.viewRestore();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		// ������ ��������� ������� �� ���������, ������� ���������
		assertEquals(view1.getItems().size(), view2.getItems().size());
		// ������ ��� �������� ������ ���� �����.
		// ��� ����� ����� ���������� ����� equals
		assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
	}
} 