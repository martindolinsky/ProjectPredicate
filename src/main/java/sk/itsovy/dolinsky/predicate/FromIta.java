package sk.itsovy.dolinsky.predicate;

import java.util.function.Predicate;

/**
 * @author Martin Dolinsky
 */
public class FromIta<T> implements Predicate<City> {

	@Override
	public boolean test(City city) {
		return city.getCode().equals("ITA");
	}
}
