package lab3;

/** ConcreteCreator
 * (шаблон проектировани€
 * Factory Method)<br>
 * ќбъ€вл€ет метод,
 * "фабрикующий" объекты
 * @author boieva-maryna
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable {
	/** —оздаЄт отображаемый объект {@linkplain ViewResult} */
	@Override
	public View getView() {
		return new ViewResult();
	}
} 