package lab4;

import lab3.ViewableResult;
import lab3.View;
/** ConcreteCreator
 * (������ ��������������
 * Factory Method)<br>
 * ��������� �����,
 * "�����������" �������
 * @author boieva-maryna
 * @version 1.0
 * @see ViewableResult
 * @see ViewableTable#getView()
*/
public class ViewableTable extends ViewableResult {
	/** ������ ������������ ������ {@linkplain ViewTable} */
	@Override
	public View getView() {
		return new ViewTable();
	}
}
