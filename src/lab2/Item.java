package lab2;
import java.io.Serializable;
import java.util.Arrays;
/** Хранит аргументы и результат вычислений.
 * @author boieva-maryna
 * @version 1.0
 */
public class Item implements Serializable {
	/** Аргументы вычисляемой функции. */
	// transient
	private double [] x;

	/** Результаты вычисления функции. */
	private double [] y; 

	/**Среднее арифметическое результатов*/
	private int average;
	
	/**Количество единиц в двоичном представлении целой части
	 * среднего арифметического значения функции*/
	private int ones;
	
	/** Автоматически сгенерированная константа */
	private static final long serialVersionUID = 1L;
	/** Инициализирует поля {@linkplain Item#x}, {@linkplain Item#y} */
	public Item() {
		x = new double[] {.0,.0,.0,.0};
		y = new double[] {.0,.0,.0,.0};
		average=0;
		ones=0;
	}
	/** Устанавливает значения полей: аргумента
	* и результата вычисления функции.
	* @param x - значение для инициализации поля {@linkplain Item#x}
	* @param y - значение для инициализации поля {@linkplain Item#y}
	*/
	public Item(double []x, double [] y,int average,int ones) {
		this.x = x;
		this.y = y;
		this.average=average;
		this.ones=ones;
	}
	/** Установка значения поля {@linkplain Item#x}
	* @param x - значение для {@linkplain Item#x}
	* @return Значение {@linkplain Item#x}
	*/
	public double [] setX(double [] x) {
		return this.x = x;
	}
	/** Получение значения поля {@linkplain Item#x}
	* @return Значение {@linkplain Item#x}
	*/
	public double [] getX() {
		return x;
	}
	/** Установка значения поля {@linkplain Item#y}
	* @param y - значение для {@linkplain Item#y}
	* @return Значение {@linkplain Item#y}
	*/
	public double [] setY(double [] y) {
		return this.y = y;
	}
	/** Получение значения поля {@linkplain Item#y}
	* @return значение {@linkplain Item#y}
	*/
	public double [] getY() {
		return y;
	}
	/** Установка значения поля {@linkplain Item#average}
	* @param average - значение для {@linkplain Item#average}
	* @return Значение {@linkplain Item#average}
	*/
	public int setAverage(int average) {
		return this.average=average;
	}
	/** Получение значения поля {@linkplain Item#average}
	* @return значение {@linkplain Item#average}
	*/
	public int getAverage() {
		return this.average;
	}
	/** Установка значения поля {@linkplain Item#ones}
	* @param ones - значение для {@linkplain Item#ones}
	* @return Значение {@linkplain Item#ones}
	*/
	public int setOnes(int ones) {
		return this.ones=ones;
	}
	/** Получение значения поля {@linkplain Item#ones}
	* @return значение {@linkplain Item#ones}
	*/
	public int getOnes() {
		return this.ones;
	}
	/** Установка значений {@linkplain Item#x} и {@linkplain Item#y}
	* @param x - значение для {@linkplain Item#x}
	* @param y - значение для {@linkplain Item#y}
	* @return this
	*/
	public Item setXY(double [] x, double [] y) {
		this.x = x;
		this.y = y;
		return this;
	}
	/** Представляет результат вычислений в виде строки.<br>{@inheritDoc} */
	@Override
	public String toString() {
		return "x = " + Arrays.toString(x) + ", y = " + Arrays.toString(y)+", average = "+average+", ones = "+ones;
	}
	/** Автоматически сгенерированный метод.<br>{@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
	 if (this == obj)
	 return true;
	 if (obj == null)
	 return false;
	 if (getClass() != obj.getClass())
	 return false; 
	 Item other = (Item) obj;
	 if (!Arrays.equals(x, other.x))
	 return false;
	 return true;
	}
} 