package lab4;

import lab3.View;
/** Вычисление и отображение результатов<br>
 * Содержит реализацию статического метода main()
 * @author boieva-maryna
 * @version 3.0
 * @see Main#main
 */
public class Main extends lab3.Main {
	/** Инициализирует поле {@linkplain lab3.Main#view view} */
	public Main(View view) {
		super(view);
	}
	/** Выполняется при запуске программы;
	 * вызывает метод {@linkplain lab3.Main#menu menu()}
	 * @param args - параметры запуска программы
	 */
	public static void main(String[] args) {
		Main main = new Main(new ViewableTable().getView());
		main.menu();
	}
}