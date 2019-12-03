package lab2;
import java.io.Serializable;
import java.util.Arrays;
/** ������ ��������� � ��������� ����������.
 * @author boieva-maryna
 * @version 1.0
 */
public class Item implements Serializable {
	/** ��������� ����������� �������. */
	// transient
	private double [] x;

	/** ���������� ���������� �������. */
	private double [] y; 

	/**������� �������������� �����������*/
	private int average;
	
	/**���������� ������ � �������� ������������� ����� �����
	 * �������� ��������������� �������� �������*/
	private int ones;
	
	/** ������������� ��������������� ��������� */
	private static final long serialVersionUID = 1L;
	/** �������������� ���� {@linkplain Item#x}, {@linkplain Item#y} */
	public Item() {
		x = new double[] {.0,.0,.0,.0};
		y = new double[] {.0,.0,.0,.0};
		average=0;
		ones=0;
	}
	/** ������������� �������� �����: ���������
	* � ���������� ���������� �������.
	* @param x - �������� ��� ������������� ���� {@linkplain Item#x}
	* @param y - �������� ��� ������������� ���� {@linkplain Item#y}
	*/
	public Item(double []x, double [] y,int average,int ones) {
		this.x = x;
		this.y = y;
		this.average=average;
		this.ones=ones;
	}
	/** ��������� �������� ���� {@linkplain Item#x}
	* @param x - �������� ��� {@linkplain Item#x}
	* @return �������� {@linkplain Item#x}
	*/
	public double [] setX(double [] x) {
		return this.x = x;
	}
	/** ��������� �������� ���� {@linkplain Item#x}
	* @return �������� {@linkplain Item#x}
	*/
	public double [] getX() {
		return x;
	}
	/** ��������� �������� ���� {@linkplain Item#y}
	* @param y - �������� ��� {@linkplain Item#y}
	* @return �������� {@linkplain Item#y}
	*/
	public double [] setY(double [] y) {
		return this.y = y;
	}
	/** ��������� �������� ���� {@linkplain Item#y}
	* @return �������� {@linkplain Item#y}
	*/
	public double [] getY() {
		return y;
	}
	/** ��������� �������� ���� {@linkplain Item#average}
	* @param average - �������� ��� {@linkplain Item#average}
	* @return �������� {@linkplain Item#average}
	*/
	public int setAverage(int average) {
		return this.average=average;
	}
	/** ��������� �������� ���� {@linkplain Item#average}
	* @return �������� {@linkplain Item#average}
	*/
	public int getAverage() {
		return this.average;
	}
	/** ��������� �������� ���� {@linkplain Item#ones}
	* @param ones - �������� ��� {@linkplain Item#ones}
	* @return �������� {@linkplain Item#ones}
	*/
	public int setOnes(int ones) {
		return this.ones=ones;
	}
	/** ��������� �������� ���� {@linkplain Item#ones}
	* @return �������� {@linkplain Item#ones}
	*/
	public int getOnes() {
		return this.ones;
	}
	/** ��������� �������� {@linkplain Item#x} � {@linkplain Item#y}
	* @param x - �������� ��� {@linkplain Item#x}
	* @param y - �������� ��� {@linkplain Item#y}
	* @return this
	*/
	public Item setXY(double [] x, double [] y) {
		this.x = x;
		this.y = y;
		return this;
	}
	/** ������������ ��������� ���������� � ���� ������.<br>{@inheritDoc} */
	@Override
	public String toString() {
		return "x = " + Arrays.toString(x) + ", y = " + Arrays.toString(y)+", average = "+average+", ones = "+ones;
	}
	/** ������������� ��������������� �����.<br>{@inheritDoc} */
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