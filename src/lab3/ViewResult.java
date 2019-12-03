package lab3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import lab2.Item;
/** ConcreteProduct
 * (������ ��������������
 * Factory Method)<br>
 * ���������� �������,
 * ���������� � �����������
 * �����������
 * @author boieva-maryna
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {
	/** ��� �����, ������������ ��� ������������ */
	private static final String FNAME = "items.bin";
	/** ���������� ���������� �������� ��� ���������� �� ��������� */
	private static final int DEFAULT_NUM = 10;
	/** ��������� ���������� � ����������� ���������� */
	private ArrayList<Item> items = new ArrayList<Item>();

	/** �������� {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
	 * � ���������� {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
	 */
	public ViewResult() {
		this(DEFAULT_NUM);
	}
	/** �������������� ��������� {@linkplain ViewResult#items}
	 * @param n ��������� ���������� ���������
	 */
	public ViewResult(int n) {
		for(int ctr = 0; ctr < n; ctr++) {
			items.add(new Item());
		}
	}

	/** �������� �������� {@linkplain ViewResult#items}
	 * @return ������� �������� ������ �� ������ {@linkplain ArrayList}
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	/** ��������� �������� �������
	 * @param x �������� ����������� �������
	 * @return ��������� ���������� �������
	 */
	private double[] calcSin(double []x) {
		double [] y= new double [x.length];
		for(int i=0;i<x.length;i++) {
			y[i]=1000*Math.sin(x[i]*Math.PI/180);
			y[i]=(double)Math.round(y[i] * 1000000) / 1000000;
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
	public void init(double stepX) {
		int index=1;
		for(Item item:items) {
			double [] alpha=new double [4];
			for(int i=0;i<4;i++) {
				alpha[i]=stepX*(i+index);
			}
			item.setX(alpha);
			item.setY(calcSin(alpha));
			item.setAverage(calcAverage(item.getY()));
			item.setOnes(calcOnes(item.getAverage()));
			index+=4;
		}
	}
	/** �������� <b>init(double stepX)</b> �� ��������� ��������� ���������<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewInit() {
		init(Math.random() * 360.0);
	}

	/** ���������� ������ {@linkplain View#viewSave()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewSave() throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
		os.writeObject(items);
		os.flush();
		os.close();
	}
	/** ���������� ������ {@linkplain View#viewRestore()}<br>
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void viewRestore() throws Exception {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		items = (ArrayList<Item>) is.readObject();
		is.close();
	}
	/** ���������� ������ {@linkplain View#viewHeader()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewHeader() {
		System.out.println("Results:");
	}
	/** ���������� ������ {@linkplain View#viewBody()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewBody() {
		for(Item item : items) {
			System.out.println("x: "+Arrays.toString(item.getX()) +",y: "+Arrays.toString(item.getY())+",avarage: "+item.getAverage()+",ones: "+item.getOnes());
		}
		System.out.println();
	}
	/** ���������� ������ {@linkplain View#viewFooter()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewFooter() {
		System.out.println("End.");
	}
	/** ���������� ������ {@linkplain View#viewShow()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewShow() {
		viewHeader();
		viewBody(); 
		viewFooter();
	}
} 