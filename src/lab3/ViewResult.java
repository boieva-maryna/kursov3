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
 * (Шаблон проектирования
 * Factory Method)<br>
 * Вычисление функции,
 * сохранение и отображение
 * результатов
 * @author boieva-maryna
 * @version 1.0
 * @see View
 */
public class ViewResult implements View {
	/** Имя файла, используемое при сериализации */
	private static final String FNAME = "items.bin";
	/** Определяет количество значений для вычисления по умолчанию */
	private static final int DEFAULT_NUM = 10;
	/** Коллекция аргументов и результатов вычислений */
	private ArrayList<Item> items = new ArrayList<Item>();

	/** Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
	 * с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
	 */
	public ViewResult() {
		this(DEFAULT_NUM);
	}
	/** Инициализирует коллекцию {@linkplain ViewResult#items}
	 * @param n начальное количество элементов
	 */
	public ViewResult(int n) {
		for(int ctr = 0; ctr < n; ctr++) {
			items.add(new Item());
		}
	}

	/** Получить значение {@linkplain ViewResult#items}
	 * @return текущее значение ссылки на объект {@linkplain ArrayList}
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	/** Вычисляет значение функции
	 * @param x аргумент вычисляемой функции
	 * @return результат вычисления функции
	 */
	private double[] calcSin(double []x) {
		double [] y= new double [x.length];
		for(int i=0;i<x.length;i++) {
			y[i]=1000*Math.sin(x[i]*Math.PI/180);
			y[i]=(double)Math.round(y[i] * 1000000) / 1000000;
		}
		return y;
	}
	/** Вычисляет среднее арифметическое 4 значений функции.
	 * @param y - значения функции.
	 * @return результат вычисления.
	 */
	private int calcAverage(double []y) {
		double sum=0.0;
		for(int i=0;i<y.length;i++) {
			sum+=y[i];
		}
		return (int)sum/y.length;
	}
	/** Считает количество единиц в двоичном представлении числа.
	 * @param number - целое число.
	 * @return результат.
	 */
	private int calcOnes(long number) {
		return (int)Long.toBinaryString(number).chars().filter(item->item == '1').count();
	}
	/** Вычисляет значение функции и сохраняет
	* результат в объекте {@linkplain Calc#result}
	* @param alpha -аргументы вычисляемой функции в радианах.
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
	/** Вызывает <b>init(double stepX)</b> со случайным значением аргумента<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewInit() {
		init(Math.random() * 360.0);
	}

	/** Реализация метода {@linkplain View#viewSave()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewSave() throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
		os.writeObject(items);
		os.flush();
		os.close();
	}
	/** Реализация метода {@linkplain View#viewRestore()}<br>
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void viewRestore() throws Exception {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		items = (ArrayList<Item>) is.readObject();
		is.close();
	}
	/** Реализация метода {@linkplain View#viewHeader()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewHeader() {
		System.out.println("Results:");
	}
	/** Реализация метода {@linkplain View#viewBody()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewBody() {
		for(Item item : items) {
			System.out.println("x: "+Arrays.toString(item.getX()) +",y: "+Arrays.toString(item.getY())+",avarage: "+item.getAverage()+",ones: "+item.getOnes());
		}
		System.out.println();
	}
	/** Реализация метода {@linkplain View#viewFooter()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewFooter() {
		System.out.println("End.");
	}
	/** Реализация метода {@linkplain View#viewShow()}<br>
	 * {@inheritDoc}
	 */
	@Override
	public void viewShow() {
		viewHeader();
		viewBody(); 
		viewFooter();
	}
} 