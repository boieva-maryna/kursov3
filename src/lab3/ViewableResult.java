package lab3;

/** ConcreteCreator
 * (������ ��������������
 * Factory Method)<br>
 * ��������� �����,
 * "�����������" �������
 * @author boieva-maryna
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable {
	/** ������ ������������ ������ {@linkplain ViewResult} */
	@Override
	public View getView() {
		return new ViewResult();
	}
} 