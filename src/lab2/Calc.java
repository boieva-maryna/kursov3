package lab2;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/** �������� ���������� ������� ��� ���������� � ����������� �����������.
 * @author boieva-maryna
 * @version 1.0
 */
public class Calc {

	/** ��� �����, ������������ ��� ������������. */
	private static final String FNAME = "Item.bin";

	/** ��������� ��������� ����������. ������ ������ {@linkplain Item} */
	private Item result;
	/** �������������� {@linkplain Calc#result} */
	public Calc() {
		result = new Item();
	}
	/** ���������� �������� {@linkplain Calc#result}
	* @param result - ����� �������� ������ �� ������ {@linkplain Item}
	*/
	public void setResult(Item result) { 
		this.result = result;
	}
	/** �������� �������� {@linkplain Calc#result}
	* @return ������� �������� ������ �� ������ {@linkplain Item}
	*/
	public Item getResult() {
		return result;
	}
	/** ��������� �������� ������� y=1000sin(x) ��� 4 ����������.
	 * @param x - ��������� ����������� �������.
	 * @return ���������� ���������� �������.
	 */
	private double[] calcSin(double []x) {
		double [] y= new double [x.length];
		for(int i=0;i<x.length;i++) {
			y[i]=1000*Math.sin(x[i]*Math.PI/180);
		}
		return y;
	}
	/** ��������� ������� �������������� 4 �������� �������.
	 * @param y - �������� �������.
	 * @return ��������� ����������.
	 */
	private int calcAverage(double []y) {
		double sum=0.0;
		for(int i=0;i<y.length;i++) {
			sum+=y[i];
		}
		return (int)sum/y.length;
	}
	/** ������� ���������� ������ � �������� ������������� �����.
	 * @param number - ����� �����.
	 * @return ���������.
	 */
	private int calcOnes(long number) {
		return (int)Long.toBinaryString(number).chars().filter(item->item == '1').count();
	}
	/** ��������� �������� ������� � ���������
	* ��������� � ������� {@linkplain Calc#result}
	* @param alpha -��������� ����������� ������� � ��������.
	*/
	public int init(double [] alpha) {
		result.setX(alpha);
		result.setY(calcSin(alpha));
		result.setAverage(calcAverage(result.getY()));
		return result.setOnes(calcOnes(result.getAverage()));
	}

	/** ������� ��������� ����������. */
	public void show() {
		System.out.println(result);
	}

	/** ��������� {@linkplain Calc#result} � ����� {@linkplain Calc#FNAME}
	* @throws IOException
	*/
	public void save() throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(new
				FileOutputStream(FNAME));
		os.writeObject(result);
		os.flush();
		os.close();
	}

	/** ��������������� {@linkplain Calc#result} �� ����� {@linkplain Calc#FNAME}
	* @throws Exception
	*/
	public void restore() throws Exception {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		result = (Item)is.readObject();
		is.close();
	}
} 
