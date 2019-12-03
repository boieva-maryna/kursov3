package lab3;

/** Creator
 * (шаблон проектировани€
 * Factory Method)<br>
 * ќбъ€вл€ет метод,
 * "фабрикующий" объекты
 * @author boieva-maryna
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable {
	/** —оздаЄт объект, реализующий {@linkplain View} */
	public View getView();
} 
