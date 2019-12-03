package lab2;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/** Содержит реализацию методов для вычисления и отображения результатов.
 * @author boieva-maryna
 * @version 1.0
 */
public class Calc {

	/** Имя файла, используемое при сериализации. */
	private static final String FNAME = "Item.bin";

	/** Сохраняет результат вычислений. Объект класса {@linkplain Item} */
	private Item result;
	/** Инициализирует {@linkplain Calc#result} */
	public Calc() {
		result = new Item();
	}
	/** Установить значение {@linkplain Calc#result}
	* @param result - новое значение ссылки на объект {@linkplain Item}
	*/
	public void setResult(Item result) { 
		this.result = result;
	}
	/** Получить значение {@linkplain Calc#result}
	* @return текущее значение ссылки на объект {@linkplain Item}
	*/
	public Item getResult() {
		return result;
	}
	/** Вычисляет значения функции y=1000sin(x) для 4 аргументов.
	 * @param x - аргументы вычисляемой функции.
	 * @return результаты вычисления функции.
	 */
	private double[] calcSin(double []x) {
		double [] y= new double [x.length];
		for(int i=0;i<x.length;i++) {
			y[i]=1000*Math.sin(x[i]*Math.PI/180);
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
	public int init(double [] alpha) {
		result.setX(alpha);
		result.setY(calcSin(alpha));
		result.setAverage(calcAverage(result.getY()));
		return result.setOnes(calcOnes(result.getAverage()));
	}

	/** Выводит результат вычислений. */
	public void show() {
		System.out.println(result);
	}

	/** Сохраняет {@linkplain Calc#result} в файле {@linkplain Calc#FNAME}
	* @throws IOException
	*/
	public void save() throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(new
				FileOutputStream(FNAME));
		os.writeObject(result);
		os.flush();
		os.close();
	}

	/** Восстанавливает {@linkplain Calc#result} из файла {@linkplain Calc#FNAME}
	* @throws Exception
	*/
	public void restore() throws Exception {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
		result = (Item)is.readObject();
		is.close();
	}
} 
