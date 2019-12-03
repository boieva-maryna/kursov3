package lab4;

import lab3.View;
/** ���������� � ����������� �����������<br>
 * �������� ���������� ������������ ������ main()
 * @author boieva-maryna
 * @version 3.0
 * @see Main#main
 */
public class Main extends lab3.Main {
	/** �������������� ���� {@linkplain lab3.Main#view view} */
	public Main(View view) {
		super(view);
	}
	/** ����������� ��� ������� ���������;
	 * �������� ����� {@linkplain lab3.Main#menu menu()}
	 * @param args - ��������� ������� ���������
	 */
	public static void main(String[] args) {
		Main main = new Main(new ViewableTable().getView());
		main.menu();
	}
}