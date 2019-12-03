package lab4;

import lab3.ViewableResult;
import lab3.View;
/** ConcreteCreator
 * (шаблон проектировани€
 * Factory Method)<br>
 * ќбъ€вл€ет метод,
 * "фабрикующий" объекты
 * @author boieva-maryna
 * @version 1.0
 * @see ViewableResult
 * @see ViewableTable#getView()
*/
public class ViewableTable extends ViewableResult {
	/** —оздаЄт отображаемый объект {@linkplain ViewTable} */
	@Override
	public View getView() {
		return new ViewTable();
	}
}
