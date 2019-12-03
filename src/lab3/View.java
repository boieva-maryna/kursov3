package lab3;

import java.io.IOException;
/** Product
 * (������ ��������������
 * Factory Method)<br>
 * ��������� "�����������"
 * ��������<br>
 * ��������� ������
 * ����������� ��������
 * @author boieva-maryna
 * @version 1.0
 */
public interface View {
	/** ���������� ��������� */
	public void viewHeader();
	/** ���������� �������� ����� */
	public void viewBody();

	/** ���������� ��������� */
	public void viewFooter();

	/** ���������� ������ ������� */
	public void viewShow();

	/** ��������� ������������� */
	public void viewInit();
	/** ��������� ������ ��� ������������ �������������� */
	public void viewSave() throws IOException;
	/** ��������������� ����� ���������� ������ */
	public void viewRestore() throws Exception;
} 
